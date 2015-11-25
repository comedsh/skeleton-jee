/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/11/25 13:54:01                          */
/*==============================================================*/


drop table if exists catalog;

drop table if exists catalog_attribute;

drop table if exists catalog_sku;


drop table if exists price_strategy;

drop table if exists repertory;

drop table if exists sale_area;


drop table if exists sku;

drop table if exists sku_catalog_attr_value;

drop table if exists sku_comment;

drop table if exists sku_extend_attrs;

drop table if exists sku_image_html;

drop table if exists sku_images;

drop table if exists sku_reply;

drop table if exists sku_stock;

drop table if exists stock_lock;

drop table if exists supplier;


drop table if exists vehicle_oe_sku;


/*==============================================================*/
/* Table: catalog                                               */
/*==============================================================*/
create table catalog
(
   id                   bigint not null,
   code                 varchar(20),
   name                 varchar(100),
   parent_id            bigint,
   sort_no              int,
   remark               varchar(100),
   primary key (id),
   unique key AK_code (code)
);

/*==============================================================*/
/* Table: catalog_attribute                                     */
/*==============================================================*/
create table catalog_attribute
(
   id                   bigint not null,
   name                 varchar(100),
   catalog_id           bigint,
   s_no                 int,
   remark               varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: catalog_sku                                           */
/*==============================================================*/
create table catalog_sku
(
   catalog_id           bigint,
   sku_id               bigint
);



/*==============================================================*/
/* Table: price_strategy                                        */
/*==============================================================*/
create table price_strategy
(
   id                   bigint not null auto_increment,
   start_time           datetime,
   end_time             datetime,
   amount               int,
   discount             int,
   primary key (id)
);

/*==============================================================*/
/* Table: repertory                                             */
/*==============================================================*/
create table repertory
(
   id                   bigint not null auto_increment,
   name                 int,
   address              int,
   area                 int,
   seller_id            bigint,
   city_region_id       bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sale_area                                             */
/*==============================================================*/
create table sale_area
(
   id                   bigint not null auto_increment,
   sale_id              bigint not null,
   type                 int comment '1.�� 2 ����',
   primary key (id)
);


/*==============================================================*/
/* Table: sku                                                   */
/*==============================================================*/
create table sku
(
   id                   bigint not null auto_increment,
   code                 varchar(20) not null,
   name                 varchar(200),
   title                varchar(200),
   url                  text comment '��Ʒ����ͼ',
   introduce            text,
   status               bit comment '1,���ϼܣ�2.���ϼ� 3�����¼ܣ�Ĭ�� ���ϼ�',
   type                 bit comment '1.Ʒ�Ƽ� , 2 ԭ����',
   shelf_time           datetime default CURRENT_TIMESTAMP,
   under_time           datetime,
   produce_time         date,
   down_time            date,
   min_quantity         int,
   gross_weight         double(7,2),
   weight               double(7,2),
   unit                 varchar(10) comment '����̨��֧,��',
   brand                varchar(100),
   score                int,
   supplier_id          bigint,
   price                decimal(9,4),
   sale_price           decimal(9,4),
   create_time          datetime default CURRENT_TIMESTAMP,
   update_time          datetime,
   seller_id            char(10),
   primary key (id),
   unique key AK_Key_2 (code)
);

/*==============================================================*/
/* Table: sku_catalog_attr_value                                */
/*==============================================================*/
create table sku_catalog_attr_value
(
   id                   bigint not null,
   catalog_attr_id      bigint,
   sttr_value           varchar(100),
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_comment                                           */
/*==============================================================*/
create table sku_comment
(
   id                   bigint not null,
   sku_id               bigint,
   order_id             bigint,
   order_detail_id      bigint,
   star                 bit comment '1��5���ǣ�>=4,����  ��3< ������3 ����',
   comtent              text,
   user_id              varchar(20),
   create_time          datetime,
   status               int default 1 comment '1 ��ʾ��2����ʾ��Ĭ����ʾ',
   comment_origin       bit comment '0, pc ,1.android 2. iphone  ;',
   primary key (id)
);

/*==============================================================*/
/* Table: sku_extend_attrs                                      */
/*==============================================================*/
create table sku_extend_attrs
(
   id                   bigint not null,
   name                 varchar(100),
   contents             varchar(100),
   sort_no              int,
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_image_html                                        */
/*==============================================================*/
create table sku_image_html
(
   id                   bigint not null,
   contents_html        text,
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_images                                            */
/*==============================================================*/
create table sku_images
(
   id                   bigint not null,
   url                  text,
   title                char(100),
   sort_no              int,
   create_time          datetime default CURRENT_TIMESTAMP,
   update_time          datetime,
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_reply                                             */
/*==============================================================*/
create table sku_reply
(
   id                   bigint not null,
   reply_code           varchar(20),
   comtent              text,
   create_time          datetime default CURRENT_TIMESTAMP,
   user_id              char(20),
   sku_comment_id       bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_stock                                             */
/*==============================================================*/
create table sku_stock
(
   id                   bigint not null,
   stock_count          int,
   stock_availability   int,
   repertory_id         bigint default NULL,
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: stock_lock                                            */
/*==============================================================*/
create table stock_lock
(
   id                   bigint not null auto_increment,
   order_id             bigint,
   sku_id               bigint,
   stock_id             bigint,
   nums                 int,
   create_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: supplier                                              */
/*==============================================================*/
create table supplier
(
   id                   bigint not null auto_increment,
   code                 varchar(20),
   name                 varchar(20),
   address              varchar(200),
   fax                  varchar(15),
   telephone            varchar(15),
   mobile_phone         varchar(15),
   primary key (id),
   unique key supplier_code (code)
);


/*==============================================================*/
/* Table: vehicle_oe_sku                                        */
/*==============================================================*/
create table vehicle_oe_sku
(
   id                   bigint not null,
   oe_code              varchar(50),
   vehicle_id           bigint default NULL,
   vehicle_name         varchar(100),
   brand                varchar(20),
   engine               varchar(20),
   period               varchar(20),
   output_value         varchar(10),
   sku_id               bigint,
   primary key (id)
);


alter table catalog add constraint FK_fk_pid foreign key (parent_id)
      references catalog (id) on delete restrict on update restrict;

alter table catalog_attribute add constraint FK_catalog_attr foreign key (catalog_id)
      references catalog (id) on delete restrict on update restrict;

alter table catalog_sku add constraint FK_Reference_21 foreign key (sku_id)
      references sku (id) on delete restrict on update restrict;

alter table catalog_sku add constraint FK_Reference_23 foreign key (catalog_id)
      references catalog (id) on delete restrict on update restrict;

alter table sku add constraint FK_Reference_25 foreign key (supplier_id)
      references supplier (id) on delete restrict on update restrict;

alter table sku_catalog_attr_value add constraint FK_Reference_22 foreign key (catalog_attr_id)
      references catalog_attribute (id) on delete restrict on update restrict;

alter table sku_catalog_attr_value add constraint FK_Relationship_2 foreign key (sku_id)
      references sku (id) on delete restrict on update restrict;

alter table sku_comment add constraint FK_Relationship_5 foreign key (sku_id)
      references sku (id) on delete restrict on update restrict;

alter table sku_extend_attrs add constraint FK_Reference_18 foreign key (sku_id)
      references sku (id) on delete restrict on update restrict;

alter table sku_image_html add constraint FK_Reference_16 foreign key (sku_id)
      references sku (id) on delete restrict on update restrict;

alter table sku_images add constraint FK_Reference_19 foreign key (sku_id)
      references sku (id) on delete restrict on update restrict;

alter table sku_reply add constraint FK_Relationship_28 foreign key (sku_comment_id)
      references sku_comment (id) on delete restrict on update restrict;

alter table sku_stock add constraint FK_Reference_17 foreign key (repertory_id)
      references repertory (id) on delete restrict on update restrict;

alter table sku_stock add constraint FK_Reference_27 foreign key (sku_id)
      references sku (id) on delete restrict on update restrict;

alter table vehicle_oe_sku add constraint FK_Reference_20 foreign key (sku_id)
      references sku (id) on delete restrict on update restrict;

