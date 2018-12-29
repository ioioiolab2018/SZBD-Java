insert into persons(pesel, name, name2, surname, birth_date, birthplace, father_name, mother_name, sex)
values('97000000001','Pawel','','Bubak', sysdate, 'Pz','D***', 'A***', 'MALE');
commit;

insert into app_users(person_id, username, password) values ('97000000001', 'pawelbubak', 'qwerty123');
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