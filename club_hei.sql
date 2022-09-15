insert into groups(name) values('G1'),('G2');

insert into club(name,description,creation_date) values('alternant','string','2022-09-15'),('basket','string','2022-09-15'),('cuisine','string','2022-09-15');

insert into event (name, description, start_event, end_event, club_id) values ('assisatance','a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque', '2022-09-16 10:12:56', '2022-09-16 12:17:17', 3),
('reuinion','fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus', '2022-09-16 12:31:39', '2022-09-16 16:13:02', 1),
('assisatance technique','maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum', '2022-09-19 14:50:09', '2022-09-19 15:41:00', 1),
('lecon','ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit', '2022-09-18 12:36:07', '2022-09-18 14:25:56', 3),
('reuinion','aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper', '2022-09-21 08:25:57', '2022-09-21 10:48:53', 2),
('assistance','posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit', '2022-09-15 07:47:00', '2022-09-15 13:31:24', 1),
('reuinion','cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus', '2022-09-20 17:06:53', '2022-09-20 18:18:50', 2),
('entrainement','enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis', '2022-09-18 04:44:13', '2022-09-18 08:28:50', 2);

insert into student (first_name, last_name, email, gender, club_id, groups_id, ref) values ('Hyatt', 'McKernon', 'hei.Hyatt@gmail.com', 'M', 3, 1, 'STD21001'),
('Vera', 'Jirusek', 'hei.Vera@gmail.com', 'F', 2, 2, 'STD21002'),
('Amie', 'Hark', 'hei.Amie@gmail.com', 'F', 3, 2, 'STD21003'),
('Alexandre', 'Willerton', 'hei.Alexandre@gmail.com', 'M', 1, 2, 'STD21004'),
('Hasty', 'Bamfield', 'hei.Hasty@gmail.com', 'M', 3, 2, 'STD21006'),
('Roberto', 'Moir', 'hei.Roberto@gmail.com', 'M', 1, 2, 'STD21007'),
('Danika', 'Alberts', 'hei.Danika@gmail.com', 'F', 1, 1, 'STD21008'),
('Gabby', 'Kirkby', 'hei.Gabby@gmail.com', 'M', 1, 2, 'STD21009'),
('Franklin', 'Baake', 'hei.Franklin@gmail.com', 'M', 3, 1, 'STD21010'),
('Gracie', 'Riccardini', 'hei.Gracie@gmail.com', 'F', 1, 1, 'STD21011'),
('Jaimie', 'Jeckells', 'hei.Jaimie@gmail.com', 'F', 2, 1, 'STD21012'),
('Cayla', 'Turvey', 'hei.Cayla@gmail.com', 'F', 3, 2, 'STD21013'),
('Eugenia', 'Murt', 'hei.Eugenia@gmail.com', 'F', 2, 1, 'STD21014'),
('Teodoor', 'Sallis', 'hei.Teodoor@gmail.com', 'M', 1, 2, 'STD21016'),
('Ondrea', 'Guyton', 'hei.Ondrea@gmail.com', 'F', 1, 2, 'STD21017'),
('Rona', 'Hallgath', 'hei.Rona@gmail.com', 'F', 2, 1, 'STD21018'),
('Shannon', 'Yorke', 'hei.Shannon@gmail.com', 'M', 2, 2, 'STD21019'),
('Kikelia', 'Stit', 'hei.Kikelia@gmail.com', 'F', 2, 2, 'STD21020'),
('Gustave', 'Campagne', 'hei.Gustave@gmail.com', 'M', 1, 2, 'STD21021'),
('Gerrie', 'Pettengell', 'hei.Gerrie@gmail.com', 'M', 2, 1, 'STD21022');

insert into student (first_name, last_name, email, gender, groups_id, ref) values ('Wynnie', 'Bench', 'hei.Wynnie@gmail.com', 'F', 1, 'STD21023'),
('Dru', 'Sperring', 'hei.Dru@gmail.com', 'F', 2, 'STD21024'),
('Lilllie', 'Baelde', 'hei.Lilllie@gmail.com', 'F', 2, 'STD21026'),
('Pebrook', 'Baldry', 'hei.Pebrook@gmail.com', 'M', 1, 'STD21027');


