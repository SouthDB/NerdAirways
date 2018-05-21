---create all Tables from NerdAirways---

---article---
CREATE TABLE aw_article
(
    ID INT NOT NULL PRIMARY KEY,
    headline VARCHAR2(50),
    content VARCHAR2(2500),
    imgpath VARCHAR2(200)
);

---creditcard---
CREATE TABLE aw_creditcard
(
    ID INT NOT NULL PRIMARY KEY,
    cardtype VARCHAR2(50) NOT NULL,
    cardnr VARCHAR2(50) NOT NULL,
    holder VARCHAR2(50) NOT NULL,

    CONSTRAINT al_creditcard_cardtype CHECK(cardtype in('Visa','Mastercard','American Express'))
);

---country---
CREATE TABLE aw_country
(
    ID INT NOT NULL PRIMARY KEY,
    country VARCHAR2(50) NOT NULL
);

---customer---
CREATE TABLE aw_customer
(
    ID INT NOT NULL PRIMARY KEY,
    email VARCHAR2(50) NOT NULL UNIQUE,
    username VARCHAR2(50) NOT NULL UNIQUE,
    pw VARCHAR2(50) NOT NULL,
    --gender m is man w is woman --
    gender VARCHAR2(1) NOT NULL,
    sname VARCHAR2(50) NOT NULL,
    fname VARCHAR2(50) NOT NULL,
    birthdate date,
    adress VARCHAR2(50) NOT NULL,
    plz VARCHAR2(10) NOT NULL,
    place VARCHAR2(50) NOT NULL,
    COUNID int NOT NULL,
    CREDID int NOT NULL,

    CONSTRAINT fk_customer_COUNID FOREIGN KEY(COUNID) REFERENCES aw_country(ID),
    CONSTRAINT fk_customer_CREDID FOREIGN KEY(CREDID) REFERENCES aw_creditcard(ID),
    CONSTRAINT al_customer_gender CHECK(gender in('m','w'))
);

---terminal place---
CREATE TABLE aw_terminal
(
    ID INT NOT NULL PRIMARY KEY,
    place VARCHAR2(50)
);

---flight status---
CREATE TABLE aw_flightstatus
(
    ID INT NOT NULL PRIMARY KEY,
    statustext VARCHAR2(50)
);

---flight---
CREATE TABLE aw_flight
(
    ID INT NOT NULL PRIMARY KEY,
    flightNR INT NOT NULL UNIQUE,
    FROMID INT NOT NULL,
    TOID INT NOT NULL,
    STATID INT NOT NULL,
    takeoff DATE,
    arrival DATE,
    price DECIMAL(20,2) NOT NULL,

    CONSTRAINT fk_flight_FROMID FOREIGN KEY(FROMID) REFERENCES aw_terminal(ID),
    CONSTRAINT fk_flight_TOID FOREIGN KEY(TOID) REFERENCES aw_terminal(ID),
    CONSTRAINT fk_flight_STATID FOREIGN KEY(FROMID) REFERENCES aw_flightstatus(ID),
    CONSTRAINT al_flight_price CHECK(price >= 0),
    CONSTRAINT al_flight_arrical CHECK(arrival > takeoff)
);

---class---
CREATE TABLE aw_class
(
    ID INT NOT NULL PRIMARY KEY,
    class VARCHAR2(50),
    ---price in decimal % + 1---
    price DECIMAL(5,3) NOT NULL,

    CONSTRAINT al_class_price CHECK(price >= 1)
);

---luggage---
CREATE TABLE aw_luggage
(
    ID INT NOT NULL PRIMARY KEY,
    mass VARCHAR2(50),
    ---price in decimal % + 1---
    price DECIMAL(5,3) NOT NULL,

    CONSTRAINT al_luggage_price CHECK(price >= 1)
);

---booking---
CREATE TABLE aw_booking
(
    ID INT NOT NULL PRIMARY KEY,
    bookingNR INT NOT NULL UNIQUE,
    FLIGID INT NOT NULL,
    CUSTID INT NOT NULL,
    CLASID INT NOT NULL,
    LAGGID INT NOT NULL,
    price DECIMAL(20,2),
    ---check in y is yes n is no---
    checkin VARCHAR2(1) NOT NULL,
    timelog TIMESTAMP NOT NULL,

    CONSTRAINT fk_booking_FLIGID FOREIGN KEY(FLIGID) REFERENCES aw_flight(ID),
    CONSTRAINT fk_booking_CUSTID FOREIGN KEY(CUSTID) REFERENCES aw_customer(ID),
    CONSTRAINT fk_booking_CLASID FOREIGN KEY(CLASID) REFERENCES aw_class(ID),
    CONSTRAINT fk_booking_LAGGID FOREIGN KEY(LAGGID) REFERENCES aw_luggage(ID),
    CONSTRAINT al_booking_price CHECK(price >= 0),
    CONSTRAINT al_booking_checkin CHECK(checkin in('y','n'))
);

---review---
CREATE TABLE aw_review
(
    ID INT NOT NULL PRIMARY KEY,
    BOOKID INT NOT NULL UNIQUE,
    text VARCHAR2(500),
    rating INT NOT NULL,
    timelog TIMESTAMP NOT NULL,

    CONSTRAINT fk_review_BOOKID FOREIGN KEY(BOOKID) REFERENCES aw_booking(ID),
    CONSTRAINT al_review_rating CHECK(rating between -1 and 6)
);