---INSERT Data from NerdAirways---

INSERT INTO aw_article (headline, content, imgpath) VALUES('Unwetterwarunung', 'Nach den hohen Temperaturen der vergangenen Tage ist mit einem starken Gewitter zu rechnen. Neben intensivem Regen kann es auch Hagel und Sturmböen geben. Sollte dies Auswirkungen auf unsere Flüge haben werden wir sie natürlich rechtzeitig informieren.', '/img/Unwetter.jpg');
INSERT INTO aw_article (headline, content, imgpath) VALUES('Reiseziel - London', 'Für eine Städtereise ist London nahezu ideal. Die Anreise ist kurz, die Auswahl an Unterkünften riesig und das kulturelle Angebot ist vielfältig. Entdecken Sie die Sehenswürdigkeiten von London bei Ihrem nächsten Kurztrip und genießen Sie die Metropole an der Themse in vollen Zügen. London hält für jeden Besucher etwas bereit. Liebhaber von Geschichte und Architektur können zwischen den Jahrhunderten der Baugeschichte schwelgen – von römischen Mauern bis hin zu modernen Wolkenkratzern. Diejenigen, die Kunst mögen können Stunden in den Museen von London verbringen und dabei Gemälde aus der Renaissance bis hin zu zeitgenössischen Skulpturen bewundern.','/img/London.jpg');

INSERT INTO aw_creditcard (cardtype, cardnr, holder) VALUES('Visa', '4556026434970005', 'Paula Bäumler');
INSERT INTO aw_creditcard (cardtype, cardnr, holder) VALUES('Mastercard', '5270574535610188', 'Joshua Grießhammer');
INSERT INTO aw_creditcard (cardtype, cardnr, holder) VALUES('American Express', '370225264440905', 'Michelle Krämer');

INSERT INTO aw_country (country) VALUES('Austria');
INSERT INTO aw_country (country) VALUES('Belgium');
INSERT INTO aw_country (country) VALUES('Croatia');
INSERT INTO aw_country (country) VALUES('Cyprus');
INSERT INTO aw_country (country) VALUES('Czech Republic');
INSERT INTO aw_country (country) VALUES('Denmark');
INSERT INTO aw_country (country) VALUES('Estonia');
INSERT INTO aw_country (country) VALUES('Finland');
INSERT INTO aw_country (country) VALUES('France');
INSERT INTO aw_country (country) VALUES('Germany');
INSERT INTO aw_country (country) VALUES('Greece');
INSERT INTO aw_country (country) VALUES('Hungary');
INSERT INTO aw_country (country) VALUES('Ireland');
INSERT INTO aw_country (country) VALUES('Italy');
INSERT INTO aw_country (country) VALUES('Lativa');
INSERT INTO aw_country (country) VALUES('Lithuania');
INSERT INTO aw_country (country) VALUES('Luxembourg');
INSERT INTO aw_country (country) VALUES('Malta');
INSERT INTO aw_country (country) VALUES('Nethlands');
INSERT INTO aw_country (country) VALUES('Poland');
INSERT INTO aw_country (country) VALUES('Portugal');
INSERT INTO aw_country (country) VALUES('Romania');
INSERT INTO aw_country (country) VALUES('Slovakia');
INSERT INTO aw_country (country) VALUES('Slovenia');
INSERT INTO aw_country (country) VALUES('Spain');
INSERT INTO aw_country (country) VALUES('Sweden');
INSERT INTO aw_country (country) VALUES('Unted Kingdom');
INSERT INTO aw_country (country) VALUES('USA');

INSERT INTO aw_customer (email, username, pw, gender, sname, fname, birthdate, adress, plz, place, COUNID, CREDID) VALUES ('paula@gmail.com', 'paula001', '1234', 'w', 'Bäumler', 'Paula', (TO_DATE('04-03-1994','dd-mm-yyyy')), 'Brandenburgische Strasse 75', '67303', 'Göllheim', 10, 1);
INSERT INTO aw_customer (email, username, pw, gender, sname, fname, birthdate, adress, plz, place, COUNID, CREDID) VALUES('joshua@gmail.com', 'joshua001', '1234', 'm', 'Grießhammer', 'Joshua', (TO_DATE('13-06-1996','dd-mm-yyyy')), 'Hoheluftchaussee 29', '16829', 'Rheinsberg', 10, 2);
INSERT INTO aw_customer (email, username, pw, gender, sname, fname, birthdate, adress, plz, place, COUNID, CREDID) VALUES('michelle@gmail.com', 'michelle001', '1234', 'w', 'Krämer', 'Michelle', (TO_DATE('21-02-1989','dd-mm-yyyy')), 'Havnegade 5', '4671', 'Strøby', 6, 3);

INSERT INTO aw_terminal (place) VALUES('Brüssel');
INSERT INTO aw_terminal (place) VALUES('Berlin');
INSERT INTO aw_terminal (place) VALUES('Madrid');
INSERT INTO aw_terminal (place) VALUES('London');
INSERT INTO aw_terminal (place) VALUES('Wien');
INSERT INTO aw_terminal (place) VALUES('Rom');

INSERT INTO aw_flightstatus (statustext) VALUES('keine Änderung');
INSERT INTO aw_flightstatus (statustext) VALUES('Verspätung');
INSERT INTO aw_flightstatus (statustext) VALUES('Ausfall');

INSERT INTO aw_flight (FROMID, TOID, STATID, takeoff, arrival, price) VALUES(1, 2, 1, (TO_DATE('04:00', 'HH24:MI')), (TO_DATE('06:00', 'HH24:MI')), 50);
INSERT INTO aw_flight (FROMID, TOID, STATID, takeoff, arrival, price) VALUES(1, 3, 1, (TO_DATE('06:00', 'HH24:MI')), (TO_DATE('08:00', 'HH24:MI')), 80);
INSERT INTO aw_flight (FROMID, TOID, STATID, takeoff, arrival, price) VALUES(1, 4, 1, (TO_DATE('08:00', 'HH24:MI')), (TO_DATE('10:00', 'HH24:MI')), 60);

INSERT INTO aw_class (class, price) VALUES('Economy', 1);
INSERT INTO aw_class (class, price) VALUES('Business', 3.10);
INSERT INTO aw_class (class, price) VALUES('First', 4.15);

INSERT INTO aw_luggage (mass, price) VALUES('+0 kg', 1);
INSERT INTO aw_luggage (mass, price) VALUES('+15 kg', 1.2);
INSERT INTO aw_luggage (mass, price) VALUES('+30 kg', 1.4);
INSERT INTO aw_luggage (mass, price) VALUES('+45 kg', 1.6);

INSERT INTO aw_booking (FLIGID, CUSTID, CLASID, LAGGID, price, checkin, timelog) VALUES(3, 1, 1, 2, 72, 'n', systimestamp);
INSERT INTO aw_booking (FLIGID, CUSTID, CLASID, LAGGID, price, checkin, timelog) VALUES(2, 2, 1, 1, 80, 'n', systimestamp);
INSERT INTO aw_booking (FLIGID, CUSTID, CLASID, LAGGID, price, checkin, timelog) VALUES(1, 3, 3, 1, 249, 'y', systimestamp);

INSERT INTO aw_review (BOOKID, text, rating, timelog) VALUES(1, 'Bester Flug meines Lebens!', 5, systimestamp);
INSERT INTO aw_review (BOOKID, text, rating, timelog) VALUES(3, 'Sind abgestürzt - naja schade.', 0, systimestamp);