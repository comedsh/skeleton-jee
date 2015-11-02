package com.fenghua.auto.backend.service.lucene;
import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
 
public class LuenceDemo {
 
    public static void main(String[] args) throws IOException, ParseException, InvalidTokenOffsetsException {
        Analyzer analyzer = new StandardAnalyzer();
 
        // 索引存到内存中的目录
        Directory directory = new RAMDirectory();
        // 配置索引
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        
        // 这里，将5篇文档filedname信息和content信息存入索引
        Document doc[] = new Document[6];
        for (int i = 0; i < 6; i++) {
            doc[i] = new Document();
        }
 
        doc[0].add(new Field("fieldname", "丰华神州", TextField.TYPE_STORED));
        doc[1].add(new Field("fieldname", "丰华神州Auto007", TextField.TYPE_STORED));
        doc[2].add(new Field("fieldname", "丰华神州Auto007设计", TextField.TYPE_STORED));
        doc[3].add(new Field("fieldname", "丰华神州Auto007测试", TextField.TYPE_STORED));
        doc[4].add(new Field("fieldname", "华东", TextField.TYPE_STORED));
        doc[5].add(new Field("fieldname", "中华", TextField.TYPE_STORED));
        
        iwriter.addDocument(doc[0]);
        iwriter.addDocument(doc[1]);
        iwriter.addDocument(doc[2]);
        iwriter.addDocument(doc[3]);
        iwriter.addDocument(doc[4]);
        iwriter.addDocument(doc[5]);
        iwriter.close();
 
        // 索引构建完毕，准备搜索。
        // 设定搜索目录
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // 使用同样的方式对多field进行搜索
        String[] multiFields = { "fieldname", "content" };
        MultiFieldQueryParser parser = new MultiFieldQueryParser(multiFields, analyzer);
        // 设定具体的搜索词
        Query query = parser.parse("丰华");
        TopDocs docs =isearcher.search(query, 10);//查找
        ScoreDoc[] hits = docs.scoreDocs;
         
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<span style='color:green'>", "</span>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
         //高亮htmlFormatter对象  
        //设置高亮附近的字数  
        highlighter.setTextFragmenter(new SimpleFragmenter(100));  
         
        System.out.println("Searched " + hits.length + " documents.");
        // Iteratethrough the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            String[] scoreExplain = null;
            // scoreExplain可以显示文档的得分详情，这里用split截取总分
            scoreExplain = isearcher.explain(query, hits[i].doc).toString().split(" ", 2);
            String scores = scoreExplain[0];
            // assertEquals("Thisis the text to be indexed.",
            // hitDoc.get("fieldname"));
            String value =hitDoc.get("fieldname"); ;
            TokenStream tokenStream = analyzer.tokenStream(value, new StringReader(value));    
            String str1 = highlighter.getBestFragment(tokenStream, value);   
             
            System.out.println("score:"+scores+ " : "+str1);
        }
        ireader.close();
        directory.close();
    }
}