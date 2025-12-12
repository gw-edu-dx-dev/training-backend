-- 前回自動生成していたテーブルを削除
drop table users;

create table users(
    id bigint auto_increment,
    password varchar(100) not null,
    name varchar(100) not null,
    email varchar(225) not null,
    primary key(id)
);
