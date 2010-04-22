create table JDBC_ALBUM (ID integer unique not null, ALBUMINDEX integer not null, NAME varchar(250) not null, primary key (ID));
create table JDBC_COMIC (ID integer unique not null, NAME varchar(250) not null, primary key (ID));
create table JDBC_COMIC_CONTENTS (COMIC_ID integer not null, ALBUM_ID integer not null, foreign key (COMIC_ID) references COMIC(ID), foreign key (ALBUM_ID) references ALBUM(ID));
create table JDBC_OMNIBUS (ID integer unique not null, primary key (ID));
create table JDBC_OMNIBUS_CONTENTS (OMNIBUS_ID integer not null, COMIC_ID integer not null, foreign key (OMNIBUS_ID) references OMNIBUS(ID), foreign key (COMIC_ID) references COMIC(ID));
create table JDBC_PROPERTY (NAME varchar(250) unique not null, TYPE varchar(250) not null, VALUE varchar(250) not null);