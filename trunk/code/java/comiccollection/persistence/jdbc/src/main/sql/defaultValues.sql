insert into JDBC_ALBUM (ID, ALBUMINDEX, NAME) values (1,1,'Het hart van Telenko');
insert into JDBC_ALBUM (ID, ALBUMINDEX, NAME) values (2,2,'Martha\'s benen');
insert into JDBC_ALBUM (ID, ALBUMINDEX, NAME) values (3,3,'Het geheugen van Dillon');

insert into JDBC_COMIC (ID, NAME) values (1,'Hard tegen hard');

insert into JDBC_COMIC_CONTENTS (COMIC_ID, ALBUM_ID) values(1,1);
insert into JDBC_COMIC_CONTENTS (COMIC_ID, ALBUM_ID) values(1,2);
insert into JDBC_COMIC_CONTENTS (COMIC_ID, ALBUM_ID) values(1,3);

insert into JDBC_OMNIBUS (ID) values (1);

insert into JDBC_OMNIBUS_CONTENTS (OMNIBUS_ID, COMIC_ID) values(1,1);

insert into JDBC_PROPERTY (NAME, TYPE, VALUE) values ('nextId', 'Long', '2');