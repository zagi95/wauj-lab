delete from student;
delete from course;
delete from student_course;

insert into student (id, first_name, last_name, date_of_birth, jmbag, ects_points)
            values (1, 'Ive', 'Ivic', NOW(), '1231231231', 120);
insert into student (id, first_name, last_name, date_of_birth, jmbag, ects_points)
            values (2, 'Mate', 'Matic', NOW(), '1231231232', 140);

insert into course(id, name, ects_points)
            values (1, 'web java', 6);
insert into course(id, name, ects_points)
            values (2, 'predmet2', 4);

insert into student_course (id, student_id, course_id)
            values (1, 1, 1);
insert into student_course (id, student_id, course_id)
            values (2, 2, 1);
//insert into student_course (id, student_id, course_id)
//            values (1, 2, 2);

insert into "user" (id, username, password, first_name, last_name)
            values (1, 'admin', '$2a$12$BFNTNVILK3ovqOiWByOVRO2xT3/Wf1gXq/sFP9glPaxMMQcK2Dqii', 'first1', 'last1'); -- password je 'test'
insert into "user" (id, username, password, first_name, last_name)
            values (2, 'user', '$2a$12$Zc0oBshcclIjh450DJ3Q3uwXy/ifX3xev1s8njlh8wfBtM/lgsWbe', 'first2', 'last2'); -- password je 'test'
insert into authority (id, name)
            values (1, 'ROLE_ADMIN');
insert into authority (id, name)
            values (2, 'ROLE_USER');
insert into user_authority (user_id, authority_id)
            values (1, 1);
insert into user_authority (user_id, authority_id)
            values (2, 2);