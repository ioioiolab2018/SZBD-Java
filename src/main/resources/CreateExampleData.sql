insert into persons(pesel, name, name2, surname, birth_date, birthplace, father_name, mother_name, sex)
values('97000000001','Pawel','','Bubak', sysdate, 'Pz','D***', 'A***', 'MALE');
insert into persons(pesel, name, name2, surname, birth_date, birthplace, father_name, mother_name, sex, role)
values('97000000000','Szymon','','Wąsik', sysdate, 'xyz','Bartosz', 'Danuta', 'MALE', 'LECTURER');
commit;

insert into app_users(person_id, username, password) values ('97000000001', 'pawelbubak', 'qwerty123');
insert into app_users(person_id, username, password) values ('97000000000', 'szymonwasik', 'qwerty123');
commit;

insert into proposals(PERSON_ID, TOPIC, CONTENT, SUBMISSION_DATE, SHORT_ANSWER, ANSWER, ANSWER_DATE) 
values('97000000001', 'DAJ PAN TRZY', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ullamcorper tellus vitae blandit consequat. Suspendisse viverra libero quis elit scelerisque mattis. Nam in egestas nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam rutrum auctor iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc laoreet vel est sit amet finibus.',
to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd'), 'T', 'Morbi iaculis fermentum velit nec ultrices. Integer pulvinar, odio ut pellentesque viverra, nunc neque pretium nibh, quis elementum velit tortor vitae augue. Phasellus euismod augue commodo maximus tincidunt. Pellentesque dapibus augue consequat ipsum aliquam interdum. Ut tincidunt metus id viverra semper. Sed odio urna, ullamcorper in cursus ac, rutrum in mi. Phasellus feugiat, est vel aliquet volutpat, risus dolor egestas eros, maximus eleifend ligula metus at dui. Nunc elit dolor, tempus ut eros in, cursus vehicula odio.',
to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') + interval '1' day);

insert into proposals(PERSON_ID, TOPIC, CONTENT, SUBMISSION_DATE) 
values('97000000001', 'Może jakaś kaska?', 'Morbi iaculis fermentum velit nec ultrices. Integer pulvinar, odio ut pellentesque viverra, nunc neque pretium nibh, quis elementum velit tortor vitae augue. Phasellus euismod augue commodo maximus tincidunt. Pellentesque dapibus augue consequat ipsum aliquam interdum. Ut tincidunt metus id viverra semper. Sed odio urna, ullamcorper in cursus ac, rutrum in mi. Phasellus feugiat, est vel aliquet volutpat, risus dolor egestas eros, maximus eleifend ligula metus at dui. Nunc elit dolor, tempus ut eros in, cursus vehicula odio.',
to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') - interval '2' DAY);
commit;

insert into questionnaires(start_date, end_date, name, content, options, single)
values(to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') - interval '7' DAY, to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') + interval '7' DAY, 'Chcesz piniażki?', 'Rozdajemy piniażki za darmo, jeśli chcesz wziaść udzial pulub nasz funPage! No i oczywiście zaznaczacz tak xD',
'Nie;Jednak nie;Może nie;Może', 'F');

insert into questionnaires(start_date, end_date, name, content, options, single)
values(to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') - interval '7' DAY, to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') + interval '7' DAY, 'Lubisz lorem?', 'Morbi iaculis fermentum velit nec ultrices. Integer pulvinar, odio ut pellentesque viverra, nunc neque pretium nibh, quis elementum velit tortor vitae augue. Phasellus euismod augue commodo maximus tincidunt. Pellentesque dapibus augue consequat ipsum aliquam interdum. Ut tincidunt metus id viverra semper. Sed odio urna, ullamcorper in cursus ac, rutrum in mi. Phasellus feugiat, est vel aliquet volutpat, risus dolor egestas eros, maximus eleifend ligula metus at dui. Nunc elit dolor, tempus ut eros in, cursus vehicula odio.',
'Tak;Nie', 'T');

insert into questionnaires(start_date, end_date, name, content, options, single)
values(to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') - interval '7' DAY, to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') - interval '1' DAY, 'Przedmioty obieralne', 'Morbi iaculis fermentum velit nec ultrices. Integer pulvinar, odio ut pellentesque viverra, nunc neque pretium nibh, quis elementum velit tortor vitae augue. Phasellus euismod augue commodo maximus tincidunt. Pellentesque dapibus augue consequat ipsum aliquam interdum. Ut tincidunt metus id viverra semper. Sed odio urna, ullamcorper in cursus ac, rutrum in mi. Phasellus feugiat, est vel aliquet volutpat, risus dolor egestas eros, maximus eleifend ligula metus at dui. Nunc elit dolor, tempus ut eros in, cursus vehicula odio.',
'Python;Delphi', 'F');
commit;

insert into QUESTIONNAIRE_ANSWERS(questionnaire_id, person_id, answer, dt)
values(3, '97000000001', 'Tak', to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd'));
commit;

insert into STUDENTS(person_id, ects_points, start_date, end_date, last_average, semester, status, study_year)
values('97000000001', 0, to_date('2016-10-03','yyyy-mm-dd'), to_date('2020-03-30','yyyy-mm-dd'), 4.5, 5, 'STUDY', 3);
commit;

insert into LECTURERS(person_id, academic_degree, start_date, office)
values('97000000000', 'DR', to_date('2014-10-03','yyyy-mm-dd'),'CW 13');
commit;

insert into STUDENT_GROUPS(start_date, end_date, faculty, study_field, study_mode, type, semester)
values(to_date('2016-10-03','yyyy-mm-dd'),to_date('2017-01-29','yyyy-mm-dd'),'Informatyki', 'Informatyka', 'FULL_TIME', 'FIRST_DEGREE', 1);
insert into STUDENT_GROUPS(start_date, end_date, faculty, study_field, study_mode, type, semester)
values(to_date('2017-02-27','yyyy-mm-dd'),to_date('2017-06-25','yyyy-mm-dd'),'Informatyki', 'Informatyka', 'FULL_TIME', 'FIRST_DEGREE', 2);
insert into STUDENT_GROUPS(start_date, end_date, faculty, study_field, study_mode, type, semester)
values(to_date('2017-10-02','yyyy-mm-dd'),to_date('2018-01-28','yyyy-mm-dd'),'Informatyki', 'Informatyka', 'FULL_TIME', 'FIRST_DEGREE', 3);
insert into STUDENT_GROUPS(start_date, end_date, faculty, study_field, study_mode, type, semester)
values(to_date('2018-02-26','yyyy-mm-dd'),to_date('2018-06-24','yyyy-mm-dd'),'Informatyki', 'Informatyka', 'FULL_TIME', 'FIRST_DEGREE', 4);
insert into STUDENT_GROUPS(start_date, end_date, faculty, study_field, study_mode, type, semester)
values(to_date('2018-10-01','yyyy-mm-dd'),to_date('2019-01-27','yyyy-mm-dd'),'Informatyki', 'Informatyka', 'FULL_TIME', 'FIRST_DEGREE', 5);
commit;

insert into GROUPS_TO_STUDENTS(group_id, student_id)
values(1, 1000);
insert into GROUPS_TO_STUDENTS(group_id, student_id)
values(2, 1000);
insert into GROUPS_TO_STUDENTS(group_id, student_id)
values(3, 1000);
insert into GROUPS_TO_STUDENTS(group_id, student_id)
values(4, 1000);
insert into GROUPS_TO_STUDENTS(group_id, student_id)
values(5, 1000);
commit;

insert into STUDY_SUBJECTS(group_id, lecturer_id, description, ects_value, name)
values(1, 1000, 'Fajny przedmiot na którym nie będziesz musiał uczyć się Delphi xD', 4, 'Podstaway programowania - Python');
commit;