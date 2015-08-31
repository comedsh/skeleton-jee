<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div style="color:blue">deprecated, see layout/views.xml#education_spittle_home template</div> 

<tiles:insertDefinition name="education.default_template">
	<tiles:putAttribute name="body">
	this is home <span style="color:red">body</span>
	</tiles:putAttribute>
</tiles:insertDefinition>
