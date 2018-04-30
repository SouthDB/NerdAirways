---insert Data from NerdAirways---

insert into aw_article values(1, 'Unwetterwarunung', 'Nach den hohen Temperaturen der vergangenen Tage ist mit einem starken Gewitter zu rechnen. Neben intensivem Regen kann es auch Hagel und Sturmböen geben. Sollte dies Auswirkungen auf unsere Flüge haben werden wir sie natürlich rechtzeitig informieren.', '/img/Unwetter.jpg');
insert into aw_article values(2, 'Reiseziel - London', 'Für eine Städtereise ist London nahezu ideal. Die Anreise ist kurz, die Auswahl an Unterkünften riesig und das kulturelle Angebot ist vielfältig. Entdecken Sie die Sehenswürdigkeiten von London bei Ihrem nächsten Kurztrip und genießen Sie die Metropole an der Themse in vollen Zügen. London hält für jeden Besucher etwas bereit. Liebhaber von Geschichte und Architektur können zwischen den Jahrhunderten der Baugeschichte schwelgen – von römischen Mauern bis hin zu modernen Wolkenkratzern. Diejenigen, die Kunst mögen können Stunden in den Museen von London verbringen und dabei Gemälde aus der Renaissance bis hin zu zeitgenössischen Skulpturen bewundern.','/img/London.jpg');

insert into aw_creditcard values(1, 'Visa', '4556026434970005', 'Paula Bäumler');
insert into aw_creditcard values(2, 'Mastercard', '5270574535610188', 'Joshua Grießhammer');
insert into aw_creditcard values(3, 'American Express', '370225264440905', 'Michelle Krämer');

insert into aw_country values(1, 'Austria');
insert into aw_country values(2, 'Belgium');
insert into aw_country values(3, 'Croatia');
insert into aw_country values(4, 'Cyprus');
insert into aw_country values(5, 'Czech Republic');
insert into aw_country values(6, 'Denmark');
insert into aw_country values(7, 'Estonia');
insert into aw_country values(8, 'Finland');
insert into aw_country values(9, 'France');
insert into aw_country values(10, 'Germany');
insert into aw_country values(11, 'Greece');
insert into aw_country values(12, 'Hungary');
insert into aw_country values(13, 'Ireland');
insert into aw_country values(14, 'Italy');
insert into aw_country values(15, 'Lativa');
insert into aw_country values(17, 'Lithuania');
insert into aw_country values(18, 'Luxembourg');
insert into aw_country values(19, 'Malta');
insert into aw_country values(20, 'Nethlands');
insert into aw_country values(21, 'Poland');
insert into aw_country values(22, 'Portugal');
insert into aw_country values(23, 'Romania');
insert into aw_country values(24, 'Slovakia');
insert into aw_country values(25, 'Slovenia');
insert into aw_country values(26, 'Spain');
insert into aw_country values(27, 'Sweden');
insert into aw_country values(28, 'Unted Kingdom');
insert into aw_country values(29, 'USA');

insert into aw_customer values(1, 'paula@gmail.com', 'paula001', '1234', 'w', 'Bäumler', 'Paula', (TO_DATE('04-03-1994','dd-mm-yyyy')), 'Brandenburgische Strasse 75', '67303', 'Göllheim', 10, 1);
insert into aw_customer values(2, 'joshua@gmail.com', 'joshua001', '1234', 'm', 'Grießhammer', 'Joshua', (TO_DATE('13-06-1996','dd-mm-yyyy')), 'Hoheluftchaussee 29', '16829', 'Rheinsberg', 10, 2);
insert into aw_customer values(3, 'michelle@gmail.com', 'michelle001', '1234', 'w', 'Krämer', 'Michelle', (TO_DATE('21-02-1989','dd-mm-yyyy')), 'Havnegade 5', '4671', 'Strøby', 6, 3);

insert into aw_terminal values(1, 'Brüssel');
insert into aw_terminal values(2, 'Berlin');
insert into aw_terminal values(3, 'Madrid');
insert into aw_terminal values(4, 'London');
insert into aw_terminal values(5, 'Wien');
insert into aw_terminal values(6, 'Rom');

insert into aw_flightstatus values(1, 'keine Änderung');
insert into aw_flightstatus values(2, 'Verspätung');
insert into aw_flightstatus values(3, 'Ausfall');

insert into aw_flight values(1, 'AWFAA0000001', 1, 2, 1, (TO_DATE('04:00', 'HH24:MI')), (TO_DATE('06:00', 'HH24:MI')), 50);
insert into aw_flight values(2, 'AWFAA0000002', 1, 3, 1, (TO_DATE('06:00', 'HH24:MI')), (TO_DATE('08:00', 'HH24:MI')), 80);
insert into aw_flight values(3, 'AWFAA0000003', 1, 4, 1, (TO_DATE('08:00', 'HH24:MI')), (TO_DATE('10:00', 'HH24:MI')), 60);

insert into aw_class values(1, 'Economy', 1);
insert into aw_class values(2, 'Business', 3.10);
insert into aw_class values(3, 'First', 4.15);

insert into aw_luggage values(1, '+0 kg', 1);
insert into aw_luggage values(2, '+15 kg', 1.2);
insert into aw_luggage values(3, '+30 kg', 1.4);
insert into aw_luggage values(4, '+45 kg', 1.6);

insert into aw_booking values(1, 'AWBA0000001DE', 3, 1, 1, 2, 72, 'n', systimestamp);
insert into aw_booking values(2, 'AWBA0000002DE', 2, 2, 1, 1, 80, 'n', systimestamp);
insert into aw_booking values(3, 'AWBA0000003DE', 1, 3, 3, 1, 249, 'y', systimestamp);

insert into aw_review values(1, 1, 'Bester Flug meines Lebens!', 5, systimestamp);
insert into aw_review values(2, 3, 'Sind abgestürzt - naja schade.', 0, systimestamp);