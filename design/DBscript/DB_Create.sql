/*==============================================================*/
/* Database name:  auto007db                                    */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015-11-17 22:53:47                          */
/*==============================================================*/


drop database if exists auto007db;

/*==============================================================*/
/* Database: auto007db                                          */
/*==============================================================*/
create database auto007db;

use auto007db;

/*==============================================================*/
/* Table: City_Area                                             */
/*==============================================================*/
create table City_Area
(
   ID                   bigint not null,
   Parent_ID            bigint,
   Name                 varchar(100) not null,
   Level                smallint not null,
   Full_Path            varchar(50) not null,
   Full_Name            varchar(200) not null,
   Available            boolean not null,
   primary key (ID)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Index: City_Code_idx                                         */
/*==============================================================*/
create unique index City_Code_idx on City_Area
(
   ID
);

/*==============================================================*/
/* Table: Company                                               */
/*==============================================================*/
create table Company
(
   ID                   bigint not null auto_increment,
   Compnay_Name         varchar(200) not null,
   City_Area_ID         bigint,
   Detail_Address       varchar(200) not null,
   Headcount            int,
   Business_Licence     varchar(200) not null,
   Taxpayer_Licence     varchar(200) not null,
   Taxpayer_Number      varchar(20),
   Contacts_Name        varchar(20) not null,
   Contacts_Phone       varchar(15) not null,
   Contacts_Mobile      varchar(15) not null,
   Contacts_Dept        varchar(50),
   Contacts_Email       varchar(100),
   Created_TS           timestamp,
   Created_by           varchar(30),
   Last_Modified_TS     timestamp,
   Last_Modified_By     varchar(30),
   primary key (ID)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Index: Company_Name_idx                                      */
/*==============================================================*/
create unique index Company_Name_idx on Company
(
   Compnay_Name
);

/*==============================================================*/
/* Index: Taxpayer_Num_idx                                      */
/*==============================================================*/
create unique index Taxpayer_Num_idx on Company
(
   Taxpayer_Number
);

/*==============================================================*/
/* Table: Payment_Type                                          */
/*==============================================================*/
create table Payment_Type
(
   ID                   bigint not null auto_increment,
   TypeName             varchar(20) not null,
   Description          varchar(100),
   NeedApprove          char not null default 'Y',
   Created_TS           timestamp,
   Created_By           varchar(30),
   Last_Modified_TS     timestamp,
   Last_Modified_By     varchar(30),
   primary key (ID)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role
(
   ID                   bigint not null auto_increment,
   Name                 varchar(10) not null,
   Description          varchar(100),
   Created_TS           timestamp,
   Created_By           varchar(30),
   Last_Modified_TS     timestamp,
   Last_Modified_By     varchar(30),
   primary key (ID)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Index: Name_idx                                              */
/*==============================================================*/
create unique index Name_idx on Role
(
   Name
);

/*==============================================================*/
/* Table: Sys_Config                                            */
/*==============================================================*/
create table Sys_Config
(
   Config_Name          varchar(30) not null,
   Config_Value         varchar(200) not null,
   Created_TS           timestamp,
   Created_By           varchar(30),
   Last_Modified_By     timestamp,
   Last_Modified_TS     varchar(30),
   primary key (Config_Name)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   ID                   bigint not null,
   Name                 varchar(30) not null,
   Password             varchar(100),
   Email                varchar(100),
   MobilePhone          varchar(20),
   QQ_Number            varchar(15),
   WeChat               varchar(20),
   Role_ID              bigint,
   User_Level_ID        bigint,
   Company_ID           bigint,
   Failed_Login_Times   smallint not null default 0,
   Available            boolean not null,
   Created_TS           timestamp,
   Created_By           varchar(30),
   Last_Modified_TS     timestamp,
   Last_Modified_By     varchar(30),
   primary key (ID)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Index: QQ_Number_idx                                         */
/*==============================================================*/
create unique index QQ_Number_idx on User
(
   QQ_Number
);

/*==============================================================*/
/* Index: Wechat_idx                                            */
/*==============================================================*/
create unique index Wechat_idx on User
(
   WeChat
);

/*==============================================================*/
/* Index: Name_idx                                              */
/*==============================================================*/
create unique index Name_idx on User
(
   Name
);

/*==============================================================*/
/* Index: Email_idx                                             */
/*==============================================================*/
create unique index Email_idx on User
(
   Email
);

/*==============================================================*/
/* Index: MobilePhone_idx                                       */
/*==============================================================*/
create unique index MobilePhone_idx on User
(
   MobilePhone
);

/*==============================================================*/
/* Table: User_Address                                          */
/*==============================================================*/
create table User_Address
(
   ID                   bigint not null auto_increment,
   User_ID              bigint not null,
   City_Area_ID         bigint,
   Alias                varchar(20) not null,
   Detail_Addr          varchar(200) not null,
   Receiver_Name        varchar(40) not null,
   Receiver_Mobile      varchar(20) not null,
   Default_Addr         boolean not null,
   created_ts           timestamp,
   created_by           varchar(30),
   last_Modified_ts     timestamp,
   last_Modified_by     varchar(30),
   primary key (ID)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Index: UserID_idx                                            */
/*==============================================================*/
create index UserID_idx on User_Address
(
   User_ID
);

/*==============================================================*/
/* Table: User_Level                                            */
/*==============================================================*/
create table User_Level
(
   ID                   bigint not null auto_increment,
   Previous_ID          bigint,
   Name                 varchar(20) not null,
   Description          varchar(100),
   Created_TS           timestamp,
   Created_By           varchar(30),
   Last_Modified_TS     timestamp,
   Last_Modified_By     varchar(30),
   primary key (ID)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: User_Payment_Type                                     */
/*==============================================================*/
create table User_Payment_Type
(
   PaymentType_ID       bigint not null,
   User_ID              bigint not null,
   Status               int not null,
   Duration             int,
   Debt_Limit           decimal(10,2),
   Created_TS           timestamp,
   Created_By           varchar(30),
   Last_Modified_TS     timestamp,
   Last_Modified_By     varchar(30),
   primary key (PaymentType_ID, User_ID)
)
Engine = InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Index: UserID_idx                                            */
/*==============================================================*/
create index UserID_idx on User_Payment_Type
(
   User_ID
);

alter table City_Area add constraint FK_City_Parent_FK foreign key (Parent_ID)
      references City_Area (ID) on delete restrict on update restrict;

alter table Company add constraint FK_Company_City_FK foreign key (City_Area_ID)
      references City_Area (ID) on delete restrict on update restrict;

alter table User add constraint FK_Reference_22 foreign key (Company_ID)
      references Company (ID) on delete restrict on update restrict;

alter table User add constraint FK_User_Role_FK foreign key (Role_ID)
      references Role (ID) on delete restrict on update restrict;

alter table User add constraint FK_User_UserLev_FK foreign key (User_Level_ID)
      references User_Level (ID) on delete restrict on update restrict;

alter table User_Address add constraint FK_User_Addr_City_FK foreign key (City_Area_ID)
      references City_Area (ID) on delete restrict on update restrict;

alter table User_Address add constraint FK_User_Addr_User_FK foreign key (User_ID)
      references User (ID) on delete restrict on update restrict;

alter table User_Level add constraint FK_User_Lev_Prev_FK foreign key (Previous_ID)
      references User_Level (ID) on delete restrict on update restrict;

alter table User_Payment_Type add constraint FK_User_PayType_PayType_FK foreign key (PaymentType_ID)
      references Payment_Type (ID) on delete restrict on update restrict;

alter table User_Payment_Type add constraint FK_User_PayType_User_FK foreign key (User_ID)
      references User (ID) on delete restrict on update restrict;

