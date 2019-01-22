INSERT INTO persons (pesel, name, name2, surname, birth_date, birthplace, father_name, mother_name, sex)
VALUES ('97000000001', 'Pawel', '', 'Bubak', sysdate, 'Pz', 'D***', 'A***', 'MALE');
INSERT INTO persons (pesel, name, name2, surname, birth_date, birthplace, father_name, mother_name, sex, role)
VALUES ('97000000000', 'Szymon', '', 'Wąsik', sysdate, 'xyz', 'Bartosz', 'Danuta', 'MALE', 'LECTURER');
INSERT INTO persons (pesel, name, name2, surname, birth_date, birthplace, father_name, mother_name, sex, role)
VALUES ('97000000002', 'Dariusz', '', 'Wawrzyniak', sysdate, 'xyz', 'Jan', 'Anna', 'MALE', 'LECTURER');
COMMIT;

INSERT INTO app_users (person_id, username, password) VALUES ('97000000001', 'pawelbubak', 'qwerty123');
INSERT INTO app_users (person_id, username, password) VALUES ('97000000000', 'szymonwasik', 'qwerty123');
INSERT INTO app_users (person_id, username, password) VALUES ('97000000002', 'dariuszwawrzyniak', 'qwerty123');
COMMIT;

INSERT INTO proposals (PERSON_ID, TOPIC, CONTENT, SUBMISSION_DATE, SHORT_ANSWER, ANSWER, ANSWER_DATE)
VALUES ('97000000001', 'DAJ PAN TRZY',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ullamcorper tellus vitae blandit consequat. Suspendisse viverra libero quis elit scelerisque mattis. Nam in egestas nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam rutrum auctor iaculis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc laoreet vel est sit amet finibus.',
        to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd'), 'T',
        'Morbi iaculis fermentum velit nec ultrices. Integer pulvinar, odio ut pellentesque viverra, nunc neque pretium nibh, quis elementum velit tortor vitae augue. Phasellus euismod augue commodo maximus tincidunt. Pellentesque dapibus augue consequat ipsum aliquam interdum. Ut tincidunt metus id viverra semper. Sed odio urna, ullamcorper in cursus ac, rutrum in mi. Phasellus feugiat, est vel aliquet volutpat, risus dolor egestas eros, maximus eleifend ligula metus at dui. Nunc elit dolor, tempus ut eros in, cursus vehicula odio.',
        to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') + interval '1' day);

INSERT INTO proposals (PERSON_ID, TOPIC, CONTENT, SUBMISSION_DATE)
VALUES ('97000000001', 'Może jakaś kaska?',
        'Morbi iaculis fermentum velit nec ultrices. Integer pulvinar, odio ut pellentesque viverra, nunc neque pretium nibh, quis elementum velit tortor vitae augue. Phasellus euismod augue commodo maximus tincidunt. Pellentesque dapibus augue consequat ipsum aliquam interdum. Ut tincidunt metus id viverra semper. Sed odio urna, ullamcorper in cursus ac, rutrum in mi. Phasellus feugiat, est vel aliquet volutpat, risus dolor egestas eros, maximus eleifend ligula metus at dui. Nunc elit dolor, tempus ut eros in, cursus vehicula odio.',
        to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - interval '2' DAY);
COMMIT;

INSERT INTO questionnaires (start_date, end_date, name, content, options, single)
VALUES (to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - interval '7' DAY,
        to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') + interval '7' DAY, 'Chcesz piniażki?',
        'Rozdajemy piniażki za darmo, jeśli chcesz wziaść udzial pulub nasz funPage! No i oczywiście zaznaczacz tak xD',
        'Nie;Jednak nie;Może nie;Może', 'F');

INSERT INTO questionnaires (start_date, end_date, name, content, options, single)
VALUES (to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - interval '7' DAY,
        to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') + interval '7' DAY, 'Lubisz lorem?',
        'Morbi iaculis fermentum velit nec ultrices. Integer pulvinar, odio ut pellentesque viverra, nunc neque pretium nibh, quis elementum velit tortor vitae augue. Phasellus euismod augue commodo maximus tincidunt. Pellentesque dapibus augue consequat ipsum aliquam interdum. Ut tincidunt metus id viverra semper. Sed odio urna, ullamcorper in cursus ac, rutrum in mi. Phasellus feugiat, est vel aliquet volutpat, risus dolor egestas eros, maximus eleifend ligula metus at dui. Nunc elit dolor, tempus ut eros in, cursus vehicula odio.',
        'Tak;Nie', 'T');

INSERT INTO questionnaires (start_date, end_date, name, content, options, single)
VALUES (to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - interval '7' DAY,
        to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - interval '1' DAY, 'Przedmioty obieralne',
        'Morbi iaculis fermentum velit nec ultrices. Integer pulvinar, odio ut pellentesque viverra, nunc neque pretium nibh, quis elementum velit tortor vitae augue. Phasellus euismod augue commodo maximus tincidunt. Pellentesque dapibus augue consequat ipsum aliquam interdum. Ut tincidunt metus id viverra semper. Sed odio urna, ullamcorper in cursus ac, rutrum in mi. Phasellus feugiat, est vel aliquet volutpat, risus dolor egestas eros, maximus eleifend ligula metus at dui. Nunc elit dolor, tempus ut eros in, cursus vehicula odio.',
        'Python;Delphi', 'F');
COMMIT;

INSERT INTO QUESTIONNAIRE_ANSWERS (questionnaire_id, person_id, answer, dt)
VALUES (3, '97000000001', 'Tak', to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd'));
COMMIT;

INSERT INTO STUDENTS (person_id, ects_points, start_date, end_date, last_average, semester, status, study_year)
VALUES ('97000000001', 0, to_date('2016-10-03', 'yyyy-mm-dd'), to_date('2020-03-30', 'yyyy-mm-dd'), 4.5, 5, 'STUDY', 3);
COMMIT;

INSERT INTO LECTURERS (person_id, academic_degree, start_date, office)
VALUES ('97000000000', 'DR', to_date('2014-10-03', 'yyyy-mm-dd'), 'CW 13');
INSERT INTO LECTURERS (person_id, academic_degree, start_date, office)
VALUES ('97000000002', 'DR', to_date('2014-10-03', 'yyyy-mm-dd'), 'CW 15');
COMMIT;

INSERT INTO STUDENT_GROUPS (start_date, end_date, faculty, study_field, study_mode, type, semester)
VALUES
  (to_date('2016-10-03', 'yyyy-mm-dd'), to_date('2017-01-29', 'yyyy-mm-dd'), 'Informatyki', 'Informatyka', 'FULL_TIME',
   'FIRST_DEGREE', 1);
INSERT INTO STUDENT_GROUPS (start_date, end_date, faculty, study_field, study_mode, type, semester)
VALUES
  (to_date('2017-02-27', 'yyyy-mm-dd'), to_date('2017-06-25', 'yyyy-mm-dd'), 'Informatyki', 'Informatyka', 'FULL_TIME',
   'FIRST_DEGREE', 2);
INSERT INTO STUDENT_GROUPS (start_date, end_date, faculty, study_field, study_mode, type, semester)
VALUES
  (to_date('2017-10-02', 'yyyy-mm-dd'), to_date('2018-01-28', 'yyyy-mm-dd'), 'Informatyki', 'Informatyka', 'FULL_TIME',
   'FIRST_DEGREE', 3);
INSERT INTO STUDENT_GROUPS (start_date, end_date, faculty, study_field, study_mode, type, semester)
VALUES
  (to_date('2018-02-26', 'yyyy-mm-dd'), to_date('2018-06-24', 'yyyy-mm-dd'), 'Informatyki', 'Informatyka', 'FULL_TIME',
   'FIRST_DEGREE', 4);
INSERT INTO STUDENT_GROUPS (start_date, end_date, faculty, study_field, study_mode, type, semester)
VALUES
  (to_date('2018-10-01', 'yyyy-mm-dd'), to_date('2019-01-27', 'yyyy-mm-dd'), 'Informatyki', 'Informatyka', 'FULL_TIME',
   'FIRST_DEGREE', 5);
COMMIT;

INSERT INTO GROUPS_TO_STUDENTS (group_id, student_id)
VALUES (1, 1000);
INSERT INTO GROUPS_TO_STUDENTS (group_id, student_id)
VALUES (2, 1000);
INSERT INTO GROUPS_TO_STUDENTS (group_id, student_id)
VALUES (3, 1000);
INSERT INTO GROUPS_TO_STUDENTS (group_id, student_id)
VALUES (4, 1000);
INSERT INTO GROUPS_TO_STUDENTS (group_id, student_id)
VALUES (5, 1000);
COMMIT;

INSERT INTO STUDY_SUBJECTS (group_id, lecturer_id, description, ects_value, name)
VALUES
  (1, 1000, 'Fajny przedmiot na którym nie będziesz musiał uczyć się Delphi xD', 4, 'Podstaway programowania - Python');
INSERT INTO STUDY_SUBJECTS (group_id, lecturer_id, description, ects_value, name)
VALUES (2, 1000, 'Bez tego przedmiotu twoje życie nie ma sensu', 5, 'Programowanie deklaratywne- Prolog');
INSERT INTO STUDY_SUBJECTS (group_id, lecturer_id, description, ects_value, name)
VALUES (2, 1001, 'Powodzenia', 3, 'Systemy operacyjne');
INSERT INTO STUDY_SUBJECTS (group_id, lecturer_id, description, ects_value, name)
VALUES (3, 1001, 'łatwe i przyjemne', 6, 'Podstawy Techniki Cyfrowej');

INSERT INTO STUDY_SUBJECTS (group_id, lecturer_id, description, ects_value, name)
VALUES (1, 1000, 'Fajny przedmiot na którym nie będziesz musiał uczyć się Delphi xD', 9, 'test');
INSERT INTO STUDY_SUBJECTS (group_id, lecturer_id, description, ects_value, name)
VALUES (1, 1000, 'Fajny przedmiot na którym nie będziesz musiał uczyć się Delphi xD', 9, 'test1');
INSERT INTO STUDY_SUBJECTS (group_id, lecturer_id, description, ects_value, name)
VALUES (1, 1000, 'Fajny przedmiot na którym nie będziesz musiał uczyć się Delphi xD', 9, 'test2');
INSERT INTO STUDY_SUBJECTS (group_id, lecturer_id, description, ects_value, name)
VALUES (4, 1001, 'Nie do zdania', 3, 'Trudne');
COMMIT;

INSERT INTO GRADES (VALUE, STUDENT_ID, SUBJECT_ID)
VALUES (2, 1000, 2);
INSERT INTO GRADES (VALUE, STUDENT_ID, SUBJECT_ID, TYPE)
VALUES (5, 1000, 2, 'SECOND');
INSERT INTO GRADES (VALUE, STUDENT_ID, SUBJECT_ID, TYPE)
VALUES (3, 1000, 1, 'FIRST');
INSERT INTO GRADES (VALUE, STUDENT_ID, SUBJECT_ID, TYPE)
VALUES (4, 1000, 3, 'FIRST');
INSERT INTO GRADES (VALUE, STUDENT_ID, SUBJECT_ID, TYPE)
VALUES (4, 1000, 4, 'FIRST');
INSERT INTO GRADES (VALUE, STUDENT_ID, SUBJECT_ID, TYPE)
VALUES (4, 1000, 5, 'FIRST');
INSERT INTO GRADES (VALUE, STUDENT_ID, SUBJECT_ID, TYPE)
VALUES (4, 1000, 6, 'FIRST');
INSERT INTO GRADES (VALUE, STUDENT_ID, SUBJECT_ID, TYPE)
VALUES (4, 1000, 7, 'FIRST');

COMMIT;

