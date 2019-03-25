--Авторы
insert into author(id,name) values (HIBERNATE_SEQUENCE.nextval,'Ivanov');
insert into author(id,name) values (HIBERNATE_SEQUENCE.nextval,'Petrov');
insert into author(id,name) values (HIBERNATE_SEQUENCE.nextval,'Sidorov');
insert into author(id,name) values (HIBERNATE_SEQUENCE.nextval,'Stepanov');
--Жанры
insert into genre(id,name) values (HIBERNATE_SEQUENCE.nextval,'Детектив');
insert into genre(id,name) values (HIBERNATE_SEQUENCE.nextval,'Анекдоты');
insert into genre(id,name) values (HIBERNATE_SEQUENCE.nextval,'Учебник');
insert into genre(id,name) values (HIBERNATE_SEQUENCE.nextval,'Проза');

--Книги
insert into book(id,name,comment) values (HIBERNATE_SEQUENCE.nextval,'Смертельное убийство','Очень интересная книга');
insert into book(id,name,comment) values (HIBERNATE_SEQUENCE.nextval,'Про Чапая','Не очень интересная книга');
insert into book(id,name,comment) values (HIBERNATE_SEQUENCE.nextval,'Алгебра','Очень НЕ интересная книга');

-- Авторы книг
insert into book_authors(book_id,authors_id) values (9,1);
insert into book_authors(book_id,authors_id) values (10,2);
insert into book_authors(book_id,authors_id) values (11,3);
-- Жанры книг
insert into book_genres(book_id,genres_id) values (9,5);
insert into book_genres(book_id,genres_id) values (9,6);
insert into book_genres(book_id,genres_id) values (10,7);
insert into book_genres(book_id,genres_id) values (11,8);
