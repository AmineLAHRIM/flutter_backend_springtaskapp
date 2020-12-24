# Installation

1- Downalod Eclipse
https://www.eclipse.org/downloads/
2- Open it and go to Top Bar > Help > Eclipse marketplace and search for "Spring Tools" then install > Confirm > Finish
3- download this Spring Project then go to Eclipse > Top Bar > Open > chosse the downloaded project, That's it!!

## Configuration

1- Run your localhost via Mamp or Wamp/Xamp ..etc
3- Go to Phpmyadmin via your localhost link and create a database. name it "taskapp" for exemple.
4- go to Spring Project to src > resources > application.properties and change

(for windows)
spring.datasource.url=jdbc:mysql://localhost:8889/YOUR_DATABASE_NAME?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

(for mac/linux)
spring.datasource.url=jdbc:mysql://localhost:8889/YOUR_DATABASE_NAME?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
