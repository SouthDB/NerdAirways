--------------------------------------------------------------------------
                    HINWEISE ZUR PROJEKT VERWENDUNG
--------------------------------------------------------------------------
>>Datenbank
    - VPN zur Hochschule
    - Datenbank aufgesetzt
        -> SQL Files ausführen
    - Datenbankverbindung in Eclipse eingrichtet
    - USER Libary Hibernate anlegen
    - Persistent xml -> username und passwort ändern

>>Eclipse JEE
    - Buildpath anpassen
        -> User Libary Hibernate
        -> JRE System Libary(am besten gleiche jdk installieren (1.8))
    - Fehler bei POM.xml
        -> Prüfen ob maven-war-plugin version 3.0.0 unterstützt wird... (Kann zB auch 2.6 sein)

>>Server (Tomcat V9.0)
    - JDBC7 in Lib von Tomcat kopieren
    - Fehlermeldung: java.lang.IndexOutOfBoundsException on publish
        -> C:\benutzer\username\.m2 löschen
        -> Eclipse-Projekte: Maven>Update Project...