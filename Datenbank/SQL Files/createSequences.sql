---create all SEQUENCES from NerdAirways---

---SEQUENCES for auto IDs---

CREATE SEQUENCE aw_arti_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_cred_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_coun_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_cust_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_term_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_fligstat_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_flig_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_clas_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_lugg_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_book_seq
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE aw_revi_seq
    START WITH 1
    INCREMENT BY 1;


---SEQUENCES for auto NR---

CREATE SEQUENCE aw_flightNR_seq
    START WITH 100
    INCREMENT BY 1;

CREATE SEQUENCE aw_bookingNR_seq
    START WITH 5000
    INCREMENT BY 1;