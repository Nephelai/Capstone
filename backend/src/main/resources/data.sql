alter table restaurants auto_increment = 1;

insert into restaurants (category) values ('ChineseFood');
insert into chinese_food (name, phone_number, total_table, restaurant_id, current_table) values ('인하각', '01000000001', 20, 1, 0);
insert into restaurants (category) values ('ChineseFood');
insert into chinese_food (name, phone_number, total_table, restaurant_id, current_table) values ('짜장전설', '01000000002', 21, 2, 0);
insert into restaurants (category) values ('ChineseFood');
insert into chinese_food (name, phone_number, total_table, restaurant_id, current_table) values ('취엔', '01000000003', 10, 3, 0);

insert into restaurants (category) values ('JapaneseFood');
insert into japanese_food (name, phone_number, total_table, restaurant_id, current_table) values ('오겡끼데스까', '01000000011', 15, 4, 0);
insert into restaurants (category) values ('JapaneseFood');
insert into japanese_food (name, phone_number, total_table, restaurant_id, current_table) values ('하나마루', '01000000012', 12, 5, 0);
insert into restaurants (category) values ('JapaneseFood');
insert into japanese_food (name, phone_number, total_table, restaurant_id, current_table) values ('라멘', '01000000013', 11, 6, 0);

insert into restaurants (category) values ('KoreanFood');
insert into korean_food (name, phone_number, total_table, restaurant_id, current_table) values ('밥집', '01000000021', 20, 7, 0);
insert into restaurants (category) values ('KoreanFood');
insert into korean_food (name, phone_number, total_table, restaurant_id, current_table) values ('부추삽겹살', '01000000022', 30, 8, 0);

insert into restaurants (category) values ('WesternFood');
insert into western_food (name, phone_number, total_table, restaurant_id, current_table) values ('서가엔쿡', '01000000031', 40, 9, 0);
insert into restaurants (category) values ('WesternFood');
insert into western_food (name, phone_number, total_table, restaurant_id, current_table) values ('챕터스테이크', '01000000032', 20, 10, 0);
insert into restaurants (category) values ('WesternFood');
insert into western_food (name, phone_number, total_table, restaurant_id, current_table) values ('서브웨이', '01000000033', 10, 11, 0);
insert into restaurants (category) values ('WesternFood');
insert into western_food (name, phone_number, total_table, restaurant_id, current_table) values ('맘스터치', '01000000034', 16, 12, 0);