DROP TABLE PERSONS CASCADE CONSTRAINTS;
CREATE TABLE PERSONS(
    PESEL VARCHAR2(11 CHAR) CONSTRAINT pk_persons_id PRIMARY KEY,
	BIRTH_DATE DATE DEFAULT SYSDATE,
	BIRTHPLACE VARCHAR2(50 CHAR) NOT NULL,
	FATHER_NAME VARCHAR2(20 CHAR),
	MOTHER_NAME VARCHAR2(20 CHAR),
	NAME VARCHAR2(20 CHAR) NOT NULL,
	NAME2 VARCHAR2(20 CHAR),
	ROLE VARCHAR2(10 CHAR) DEFAULT 'STUDENT' CONSTRAINT chk_role CHECK(ROLE IN ('STUDENT','LECTURER')),
	SEX VARCHAR2(10 CHAR) CONSTRAINT chk_sex CHECK(SEX IN ('MALE','FEMALE')),
	SURNAME VARCHAR2(255 CHAR) NOT NULL);

DROP TABLE APP_USERS CASCADE CONSTRAINTS;
CREATE TABLE APP_USERS(
	USERNAME VARCHAR2(50 CHAR) CONSTRAINT uk_username PRIMARY KEY,
    PERSON_ID VARCHAR2(11 CHAR) CONSTRAINT fk_persons REFERENCES persons(pesel),
	LAST_LOGIN_DATE DATE,
	PASSWORD VARCHAR2(100 CHAR) NOT NULL);

DROP TABLE LECTURERS CASCADE CONSTRAINTS;
CREATE TABLE LECTURERS(
	LECTURER_INDEX NUMBER(6,0) CONSTRAINT pk_lecturers_id PRIMARY KEY,
    PERSON_ID VARCHAR2(11 CHAR) CONSTRAINT fk_lecturers_persons REFERENCES persons(pesel),
    ACADEMIC_DEGREE VARCHAR2(5 CHAR) CONSTRAINT chk_academic_degree CHECK(ACADEMIC_DEGREE IN ('INZ','MGR','DR','PROF')),
	OFFICE VARCHAR2(50 CHAR),
	START_DATE DATE DEFAULT SYSDATE,
	END_DATE DATE);

DROP SEQUENCE LECTURERS_SEQ;
CREATE SEQUENCE LECTURERS_SEQ START WITH 1000;

CREATE OR REPLACE TRIGGER LECTURERS_BIR
BEFORE INSERT ON LECTURERS
FOR EACH ROW
BEGIN
  SELECT LECTURERS_SEQ.NEXTVAL
  INTO   :new.LECTURER_INDEX
  FROM   dual;
END;
/

DROP TABLE STUDENTS CASCADE CONSTRAINTS;
CREATE TABLE STUDENTS(
    STUDENT_INDEX NUMBER(6,0) CONSTRAINT pk_students_id PRIMARY KEY,
	PERSON_ID VARCHAR2(11 CHAR) CONSTRAINT fk_students_persons REFERENCES persons(pesel),
	ECTS_POINTS NUMBER(3,0) DEFAULT 0 NOT NULL,
	START_DATE DATE DEFAULT SYSDATE,
	END_DATE DATE DEFAULT SYSDATE + INTERVAL '3' YEAR,
	LAST_AVERAGE FLOAT(126),
	SEMESTER NUMBER(2,0),
	STATUS VARCHAR2(255 CHAR) CONSTRAINT chk_status CHECK(STATUS IN ('STUDY','NOT_STUDY')),
	STUDY_YEAR NUMBER(2,0));

DROP SEQUENCE STUDENTS_SEQ;
CREATE SEQUENCE STUDENTS_SEQ START WITH 1000;

CREATE OR REPLACE TRIGGER STUDENTS_BIR
BEFORE INSERT ON STUDENTS
FOR EACH ROW
BEGIN
  SELECT STUDENTS_SEQ.NEXTVAL
  INTO   :new.STUDENT_INDEX
  FROM   dual;
END;
/

DROP TABLE STUDENT_GROUPS CASCADE CONSTRAINTS;
CREATE TABLE STUDENT_GROUPS(
    ID NUMBER(6,0) CONSTRAINT pk_student_groups_id PRIMARY KEY,
	START_DATE DATE DEFAULT SYSDATE,
	END_DATE DATE DEFAULT SYSDATE + INTERVAL '3' YEAR,
	FACULTY VARCHAR2(100 CHAR),
	STUDY_FIELD VARCHAR2(100 CHAR),
	STUDY_MODE VARCHAR2(20 CHAR) CONSTRAINT chk_study_mode CHECK(STUDY_MODE IN ('FULL_TIME','PART_TIME')),
	TYPE VARCHAR2(20 CHAR) CONSTRAINT chk_type CHECK(TYPE IN ('FIRST_DEGREE','SECOND_DEGREE','PHD','POSTGRADUATE')),
	SEMESTER NUMBER(2,0));

DROP SEQUENCE STUDENT_GROUPS_SEQ;
CREATE SEQUENCE STUDENT_GROUPS_SEQ START WITH 1;

CREATE OR REPLACE TRIGGER STUDENT_GROUPS_BIR
BEFORE INSERT ON STUDENT_GROUPS
FOR EACH ROW
BEGIN
  SELECT STUDENT_GROUPS_SEQ.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/

DROP TABLE GROUPS_TO_STUDENTS CASCADE CONSTRAINTS;
CREATE TABLE GROUPS_TO_STUDENTS(
    GROUP_ID NUMBER(6,0) CONSTRAINT fk_student_groups REFERENCES student_groups(ID),
    STUDENT_ID NUMBER(6,0) CONSTRAINT fk_students REFERENCES students(STUDENT_INDEX),
    CONSTRAINT pk_student_to_group PRIMARY KEY(GROUP_ID, STUDENT_ID));

DROP TABLE STUDY_SUBJECTS CASCADE CONSTRAINTS;
CREATE TABLE STUDY_SUBJECTS(
    ID NUMBER(6,0) CONSTRAINT pk_study_subjects_id PRIMARY KEY,
	GROUP_ID NUMBER(6,0) CONSTRAINT fk_student_group_study_subject REFERENCES student_groups(ID),
	LECTURER_ID NUMBER(6,0) CONSTRAINT fk_lecturers_study_subjects REFERENCES lecturers(LECTURER_INDEX),
	DESCRIPTION CLOB,
	ECTS_VALUE NUMBER(1,0) NOT NULL,
	NAME VARCHAR2(100 CHAR) NOT NULL);

DROP SEQUENCE STUDY_SUBJECTS_SEQ;
CREATE SEQUENCE STUDY_SUBJECTS_SEQ START WITH 1;

CREATE OR REPLACE TRIGGER STUDY_SUBJECTS_BIR
BEFORE INSERT ON STUDY_SUBJECTS
FOR EACH ROW
BEGIN
  SELECT STUDY_SUBJECTS_SEQ.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/

DROP TABLE GRADES CASCADE CONSTRAINTS;
CREATE TABLE GRADES(
    ID NUMBER(19,0) CONSTRAINT pk_grades_id PRIMARY KEY,
	SUBJECT_ID NUMBER(6,0) CONSTRAINT fk_study_subjects_grades REFERENCES study_subjects(ID),
	STUDENT_ID NUMBER(6,0) CONSTRAINT fk_students_grades REFERENCES students(STUDENT_INDEX),
	GRADE_DATE DATE DEFAULT SYSDATE,
	TYPE VARCHAR2(20 CHAR) DEFAULT 'FIRST' CONSTRAINT chk_grade_type CHECK(TYPE IN ('FIRST','SECOND')),
	VALUE FLOAT(126));

DROP SEQUENCE GRADES_SEQ;
CREATE SEQUENCE GRADES_SEQ START WITH 1;

CREATE OR REPLACE TRIGGER GRADES_BIR
BEFORE INSERT ON GRADES
FOR EACH ROW
BEGIN
  SELECT GRADES_SEQ.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/

DROP TABLE PROPOSALS CASCADE CONSTRAINTS;
CREATE TABLE PROPOSALS(
    ID NUMBER(19,0) CONSTRAINT pk_proposals_id PRIMARY KEY,
	PERSON_ID VARCHAR2(11 CHAR) CONSTRAINT fk_persons_proposals REFERENCES persons(pesel),
	TOPIC VARCHAR2(255 CHAR) NOT NULL,
	CONTENT CLOB NOT NULL,
	SUBMISSION_DATE DATE DEFAULT SYSDATE,
	SHORT_ANSWER VARCHAR2(10 CHAR),
	ANSWER CLOB,
	ANSWER_DATE DATE);

DROP SEQUENCE PROPOSALS_SEQ;
CREATE SEQUENCE PROPOSALS_SEQ START WITH 1;

CREATE OR REPLACE TRIGGER PROPOSALS_BIR
BEFORE INSERT ON PROPOSALS
FOR EACH ROW
BEGIN
  SELECT PROPOSALS_SEQ.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/

DROP TABLE CONTACTS CASCADE CONSTRAINTS;
CREATE TABLE CONTACTS(
    ID NUMBER(19,0) CONSTRAINT pk_contacts_id PRIMARY KEY,
	PERSON_ID VARCHAR2(11 CHAR) CONSTRAINT fk_persons_contacts REFERENCES persons(pesel),
	CONTACT_TYPE VARCHAR2(10 CHAR) CONSTRAINT chk_contact_type CHECK(CONTACT_TYPE IN ('EMAIL','PHONE')),
	TYPE VARCHAR2(20 CHAR) CONSTRAINT chk_type_contacts CHECK(TYPE IN ('BUSINESS','PRIVATE')),
	VALUE VARCHAR2(50 CHAR));

DROP SEQUENCE CONTACTS_SEQ;
CREATE SEQUENCE CONTACTS_SEQ START WITH 1;

CREATE OR REPLACE TRIGGER CONTACTS_BIR
BEFORE INSERT ON CONTACTS
FOR EACH ROW
BEGIN
  SELECT CONTACTS_SEQ.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/

DROP TABLE ADDRESSES CASCADE CONSTRAINTS;
CREATE TABLE ADDRESSES(
    ID NUMBER(19,0) CONSTRAINT pk_addresses_id PRIMARY KEY,
	PERSON_ID VARCHAR2(11 CHAR) CONSTRAINT fk_persons_addresses REFERENCES persons(pesel),
	ADDRESS_TYPE VARCHAR2(20 CHAR) CONSTRAINT chk_address_type CHECK(ADDRESS_TYPE IN ('CONTACT','DEFAULT','TEMPORARY')),
	APARTMENT_NUMBER NUMBER(3,0),
	HOUSE_NUMBER NUMBER(3,0) NOT NULL,
	STREET VARCHAR2(50 CHAR) NOT NULL,
	TOWN VARCHAR2(50 CHAR) NOT NULL,
	ZIP_CODE VARCHAR2(10 CHAR) NOT NULL);

DROP SEQUENCE ADDRESSES_SEQ;
CREATE SEQUENCE ADDRESSES_SEQ START WITH 1;

CREATE OR REPLACE TRIGGER ADDRESSES_BIR
BEFORE INSERT ON ADDRESSES
FOR EACH ROW
BEGIN
  SELECT ADDRESSES_SEQ.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/

DROP TABLE QUESTIONNAIRES CASCADE CONSTRAINTS;
CREATE TABLE QUESTIONNAIRES(
    ID NUMBER(6,0) CONSTRAINT pk_questionnaires_id PRIMARY KEY,
	START_DATE DATE DEFAULT SYSDATE,
	END_DATE DATE DEFAULT SYSDATE + INTERVAL '7' DAY,
	NAME VARCHAR2(100 CHAR) NOT NULL,
	CONTENT CLOB NOT NULL,
	OPTIONS VARCHAR2(255 CHAR) NOT NULL,
	SINGLE VARCHAR2(5 CHAR) DEFAULT 'F' CONSTRAINT chk_single CHECK(SINGLE IN ('T','F')));

DROP SEQUENCE QUESTIONNAIRES_SEQ;
CREATE SEQUENCE QUESTIONNAIRES_SEQ START WITH 1;

CREATE OR REPLACE TRIGGER QUESTIONNAIRES_BIR
BEFORE INSERT ON QUESTIONNAIRES
FOR EACH ROW
BEGIN
  SELECT QUESTIONNAIRES_SEQ.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/

DROP TABLE QUESTIONNAIRE_ANSWERS CASCADE CONSTRAINTS;
CREATE TABLE QUESTIONNAIRE_ANSWERS(
    QUESTIONNAIRE_ID NUMBER(6,0) CONSTRAINT fk_questionnaire_answers REFERENCES questionnaires(ID),
    PERSON_ID VARCHAR2(11 CHAR) CONSTRAINT fk_persons_answers REFERENCES persons(pesel),
	ANSWER VARCHAR2(100 CHAR) ,
	DT DATE DEFAULT SYSDATE,
    CONSTRAINT pk_questionnaire_to_student PRIMARY KEY(QUESTIONNAIRE_ID, PERSON_ID));

DROP VIEW STUDENT_INFORMATION;
CREATE OR REPLACE FORCE VIEW STUDENT_INFORMATION(
        name,
        second_name,
        surname,
        pesel,
        birthplace,
        birth_date,
        father_name,
        mother_name,
        sex,
        email,
        phone,
        address,
        contact_address,
        temporary_address,
        student_index,
        semester,
        faculty,
        study_field,
        study_mode,
        type,
        status,
        ects_points,
        start_date,
        end_date
    ) AS
        SELECT
            p.name,
            p.name2,
            p.surname,
            p.pesel,
            p.birthplace,
            p.birth_date,
            p.father_name,
            p.mother_name,
            p.sex,
            (select value from contacts where contact_type = 'EMAIL' AND person_id = p.pesel),
            (select value from contacts where contact_type = 'PHONE' AND person_id = p.pesel),
            (select street||' '||house_number||', '||zip_code||' '||town from addresses where address_type = 'DEFAULT' AND person_id = p.pesel),
            (select street||' '||house_number||', '||zip_code||' '||town from addresses where address_type = 'CONTACT' AND person_id = p.pesel),
            (select street||' '||house_number||', '||zip_code||' '||town from addresses where address_type = 'TEMPORARY' AND person_id = p.pesel),
            s.student_index,
            s.semester,
            sgr.faculty,
            sgr.study_field,
            sgr.study_mode,
            sgr.type,
            s.status,
            s.ects_points,
            s.start_date,
            sgr.end_date
        FROM
            persons p,
            students s,
            groups_to_students tgr,
            student_groups sgr
        WHERE
            p.role = 'STUDENT'
            AND p.pesel = s.person_id(+)
            AND s.student_index = tgr.student_id(+)
            AND tgr.group_id = sgr.id(+);
COMMENT ON TABLE STUDENT_INFORMATION IS 'COMPL="Widok zwracający dane do panelu informacji o studencie."';

DROP VIEW STUDENT_QUESTIONNAIRES;
CREATE OR REPLACE FORCE VIEW STUDENT_QUESTIONNAIRES(
        id,
        name,
        start_date,
        end_date,
        available
    ) AS
        SELECT
            q.id,
            q.name,
            q.start_date,
            q.end_date,
            q.single
        FROM
            questionnaires q;
COMMENT ON TABLE STUDENT_QUESTIONNAIRES IS 'COMPL="Widok zwracający dane do tabeli ankiet studenta."';

DROP VIEW STUDENT_SUBJECTS;
CREATE OR REPLACE FORCE VIEW STUDENT_SUBJECTS(
        id,
        name,
        lecturer,
        ects_value,
        complete,
        username,
        semester
    ) AS
        SELECT
            sub.id,
            sub.name,
            lec.academic_degree || ' ' || plec.name || ' ' || plec.surname,
            sub.ects_value,
            case
                when exists (select g.value
                        from grades g
                        where g.subject_id = sub.id AND g.student_id(+) = st.student_index AND g.value >= 3)
                    then 'T'
                else 'F'
            end,
            u.username,
            stgr.semester
        FROM
            student_groups stgr,
            groups_to_students grtost,
            students st,
            persons p,
            app_users u,
            study_subjects sub,
            lecturers lec,
            persons plec
        WHERE
            stgr.id(+) = grtost.group_id
            AND grtost.student_id(+) = st.student_index
            AND st.person_id(+) = p.pesel
            AND p.pesel = u.person_id
            AND stgr.id = sub.group_id(+)
            AND sub.lecturer_id = lec.lecturer_index
            AND lec.person_id = plec.pesel;
COMMENT ON TABLE STUDENT_SUBJECTS IS 'COMPL="Widok zwracający listę przedmiotów na które uczęszczał student."';

DROP VIEW SEMESTERS;
CREATE OR REPLACE FORCE VIEW SEMESTERS(
        id,
        semester,
        username
    ) AS
        SELECT
            max(stgr.id),
            stgr.semester,
            u.username
        FROM
            student_groups stgr,
            groups_to_students grtost,
            students st,
            persons p,
            app_users u
        WHERE
            stgr.id = grtost.group_id
            AND grtost.student_id = st.student_index
            AND st.person_id = p.pesel
            AND p.pesel = u.person_id
        GROUP BY
            stgr.semester,
            u.username
        ORDER BY semester;
COMMENT ON TABLE SEMESTERS IS 'COMPL="Widok zwracający semestry na które uczęszczał student."';

CREATE OR REPLACE PACKAGE StudentAverageCalculations IS
    FUNCTION semesterAverage(p_student_index number, p_group_id number) RETURN number;
    FUNCTION isPassSemester(p_group_id number, p_student_index varchar2) RETURN number;
END StudentAverageCalculations;

CREATE OR REPLACE PACKAGE BODY StudentAverageCalculations IS
    FUNCTION semesterAverage(p_student_index number, p_group_id number)
        RETURN number
    IS
        cursor grade_cursor is
            SELECT
                sub.ects_value,
                gde.value
            FROM
                student_groups stgr,
                groups_to_students grtost,
                students st,
                study_subjects sub,
                grades gde
            WHERE
                stgr.id = grtost.group_id
                AND grtost.student_id = st.student_index
                AND stgr.id = sub.group_id
                AND gde.student_id = st.student_index
                AND gde.subject_id = sub.id
                AND st.student_index = p_student_index
                AND stgr.id = p_group_id;
        v_return number;
        v_sum number;
        v_ects_points_sum number;
    BEGIN
        v_sum := 0;
        v_ects_points_sum := 0;
        FOR v_rec in grade_cursor
        LOOP
            v_sum := v_sum + v_rec.ects_value * v_rec.value;
            v_ects_points_sum := v_ects_points_sum + v_rec.ects_value;
        END LOOP;
        IF v_ects_points_sum > 0 THEN
            v_return := v_sum / v_ects_points_sum;
        END IF;
    RETURN v_return;
    END semesterAverage;
    FUNCTION isPassSemester(p_group_id number, p_student_index varchar2)
        RETURN number
    IS
      cursor semester_cursor is
        SELECT
          sub.ects_value,
          gde.value
        FROM
          student_groups stgr,
          groups_to_students grtost,
          students st,
          study_subjects sub,
          grades gde
        WHERE
          stgr.id = grtost.group_id
          AND grtost.student_id = st.student_index
          AND stgr.id = sub.group_id
          AND gde.student_id = st.student_index
          AND gde.subject_id = sub.id
          AND st.student_index = p_student_index
          AND stgr.id = p_group_id;
        v_return number;
        v_sum number;
    BEGIN
        v_sum := 0;
        FOR v_rec in semester_cursor
        LOOP
          IF v_rec.VALUE > 2 THEN
            v_sum := v_sum + v_rec.ects_value;
          END IF;
        END LOOP;
        IF v_sum >= 30 THEN
          v_return := 1;
        ELSE
          v_return := 0;
        END IF;
    RETURN v_return;
    END isPassSemester;
END StudentAverageCalculations;

DROP VIEW STUDENT_SEMESTERS;
CREATE OR REPLACE FORCE VIEW STUDENT_SEMESTERS(
        id,
        semester,
    semester_pass_date,
    average,
    username
    ) AS
        SELECT
            stgr.id,
            stgr.semester,
            case
            StudentAverageCalculations.isPassSemester(stgr.ID,st.STUDENT_INDEX)
            when 1
            then (select max(grade_date) from grades t_gde, study_subjects sub where t_gde.student_id = st.student_index
                and stgr.id = sub.group_id and t_gde.subject_id = sub.id)
            else null
            end as semester_pass_date,
            StudentAverageCalculations.semesterAverage(st.student_index, stgr.id) as average,
            u.username
        FROM
            student_groups stgr,
            groups_to_students grtost,
            students st,
            persons p,
            app_users u
        WHERE
            stgr.id = grtost.group_id
            AND grtost.student_id = st.student_index
            AND st.person_id = p.pesel
            AND p.pesel = u.person_id;
COMMENT ON TABLE STUDENT_SEMESTERS IS 'COMPL="Widok zwracający informacje o semestrach na które uczęszczał student."';

DROP VIEW STUDENT_GRADES;
CREATE OR REPLACE FORCE VIEW STUDENT_GRADES(
        name,
        lecturer,
        pass_date,
        first_value,
        second_value,
        username,
        group_id
    ) AS
        SELECT
            sub.name,
            l.academic_degree || ' ' || p_l.name || ' ' || p_l.surname as lecturer,
            (select max(g.grade_date) from grades g where g.student_id = s.student_index AND g.subject_id = sub.id) as pass_date,
            (select g.value from grades g where g.student_id = s.student_index AND g.subject_id = sub.id AND g.type = 'FIRST') as first_value,
            (select g.value from grades g where g.student_id = s.student_index AND g.subject_id = sub.id AND g.type = 'SECOND') as second_value,
            u.username,
            stgr.id
        FROM
            student_groups stgr,
            study_subjects sub,
            lecturers l,
            persons p_l,
            groups_to_students gts,
            students s,
            persons p,
            app_users u
        WHERE
            sub.group_id = stgr.id
            AND l.lecturer_index = sub.lecturer_id
            AND p_l.pesel = l.person_id
            AND gts.group_id = stgr.id
            AND s.student_index = gts.student_id
            AND s.person_id = p.pesel
            AND p.pesel = u.person_id;
COMMENT ON TABLE STUDENT_GRADES IS 'COMPL="Widok zwracający oceny studenta."';

CREATE BITMAP INDEX SEX_INDEX ON PERSONS(SEX);

