create sequence course_seq start with 1 increment by 50;
create sequence student_seq start with 1 increment by 50;

    create table course (
       id bigint not null,
        ects_points integer,
        name varchar(255),
        primary key (id)
    );

    create table student (
       id bigint not null,
        date_of_birth date,
        ects_points integer,
        first_name varchar(255),
        jmbag varchar(255),
        last_name varchar(255),
        primary key (id)
    );

    create table student_course (
       student_id bigint not null,
        course_id bigint not null
    );

    alter table if exists student_course 
       add constraint FKejrkh4gv8iqgmspsanaji90ws 
       foreign key (course_id) 
       references course;

    alter table if exists student_course 
       add constraint FKq7yw2wg9wlt2cnj480hcdn6dq 
       foreign key (student_id) 
       references student;
