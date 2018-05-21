---create all TRIGGER from xProject---

---before insert TRIGGER for IDs with sequence---

CREATE OR REPLACE TRIGGER x_table1_bir
BEFORE INSERT ON x_table1
FOR EACH ROW
BEGIN
    SELECT x_table1_seq.NEXTVAL
    INTO    :new.ID
    FROM dual;
END;
/