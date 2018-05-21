---create all Trigger from NerdAirways---


---before insert TRIGGER for IDs with sequence---

CREATE OR REPLACE TRIGGER aw_arti_bir
BEFORE INSERT ON aw_article
FOR EACH ROW
BEGIN
    SELECT aw_arti_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_cred_bir
BEFORE INSERT ON aw_creditcard
FOR EACH ROW
BEGIN
    SELECT aw_cred_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_coun_bir
BEFORE INSERT ON aw_country
FOR EACH ROW
BEGIN
    SELECT aw_coun_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_cust_bir
BEFORE INSERT ON aw_customer
FOR EACH ROW
BEGIN
    SELECT aw_cust_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_term_bir
BEFORE INSERT ON aw_terminal
FOR EACH ROW
BEGIN
    SELECT aw_term_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_fligstat_bir
BEFORE INSERT ON aw_flightstatus
FOR EACH ROW
BEGIN
    SELECT aw_fligstat_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_flig_bir
BEFORE INSERT ON aw_flight
FOR EACH ROW
BEGIN
    SELECT aw_flig_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
    SELECT aw_flightNR_seq.NEXTVAL
    INTO    :new.flightNR
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_clas_bir
BEFORE INSERT ON aw_class
FOR EACH ROW
BEGIN
    SELECT aw_clas_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_lugg_bir
BEFORE INSERT ON aw_luggage
FOR EACH ROW
BEGIN
    SELECT aw_lugg_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_book_bir
BEFORE INSERT ON aw_booking
FOR EACH ROW
BEGIN
    SELECT aw_book_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
    SELECT aw_bookingNR_seq.NEXTVAL
    INTO    :new.bookingNR
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER aw_revi_bir
BEFORE INSERT ON aw_review
FOR EACH ROW
BEGIN
    SELECT aw_revi_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/