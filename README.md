# Wildfire Tracker

This web application allow game warder to be able to race animals both endangered and non-endangered to be rescued in a wild fire situation.

### By Okello Thomas Olal, 05/11/2022


## Table of contents
* [Description](#description)
* [Setup and Installation Requirements](#setup)
* [Behaviour Driven Development](#BDD)
* [Technologies](#technologies)
* [Licence](#licence)
* [Authors information](#contact)

## Description

Often in a wildfire situation many wild animals are being lost to fire due to hard time in being able to identify them, with this application game wardners can have easy time to identify and trace animals in such critical situations.

# Setup and Installation Requirements
To run this program:

```
$ Fork the repository from my git hub.
$ Clone this repository to a location in your file system.
$ Open the Intellij and locate where you have clone the file and open it. 
$ Type gradle run on your intellij command line to open a remote server where you can view the application. 
$ You need to install postgres database managing system to your account, this will be needed for storing your data.
$ alternatively, install the Harouk and using mvn harouk:display to do so in your own harouk free or paid account. 
```

Database Installation:

The following commands will be crucial in aiding you to set up your database and also query them on your commandline 
and is specific to ubuntu unix operating system.  

```
$ You need to install postgres database managing system to your account, this will be needed for storing your data.
$ alternatively, install the Harouk and using mvn harouk:display to do so in your own harouk free or paid account. 
$ sudo apt update - to update your system. 
$ apt install postgresql postgresql-contrib - install the postgres database. 
$ sudo -u postgres psql - navigate to postgres 
$ \password postgres - set your postgres password
$ CREATE DATABASE wildlife_trackers;
  
  \c wildlife_trackers;
  
  CREATE TABLE animals(
      id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
      name VARCHAR
  );
  
  CREATE TABLE endangered(
      id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
      name VARCHAR,
      type VARCHAR,
      health VARCHAR,
      age VARCHAR
  );
  
  CREATE TABLE sightings(
      id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
      location VARCHAR,
      name VARCHAR,
      animId INTEGER,
      endangeredId INTEGER
  );
  
  
  CREATE DATABASE wildlife_trackers_test WITH TEMPLATE wildlife_trackers; 
```


## Behaviour Driven Development (BDD)
This web page is documented and designed around the behavior a user expects to experience when interacting with it.

- When a user sees and animal, they identify it as either endangered or non-endangered animal.
- When they identify and animal as an endangered animal, they provide their name, age, health status.
- On the other hand when a non-endangered animal is identitifed they only enter the name of the animal.
- When an animal is seen in any location, their name and location is also noted.

## Technologies
* HTML - HTML is the standard markup language for Web pages.
* CSS - CSS is the language we use to style an HTML document.
* Java - Java is an OOP language used for both web design and mobile application designs. 
* Sql - allow for data storage in the postgres database management system. 
* Handlebars

# Licence
MIT Licence 
copyright (c) 2022 Okello Thomas Olal. All Rights Reserved.

The wildfire tracker appliction is sole work of Okello Thomas and it delivered free on the github, for any changes or restrictions
like in the case of update, upgrade or omission of part of the software, permission is here granted for any person to alter the code of this 
for software to fit thier purpose. 

Once the software has been altred, the above permission will be obsolute and you will be required to work under the new guidelines or 
copyright policy provided. 

This application permission does not involve any warrant to its users. 


## Authors information
Contributions are always welcome!  
If you have any questions,comments or correctional advice, feel free to contact me
* Email: thomasolal33@gmail.com
* [LinkedIn](https://www.linkedin.com/in/thomas-okello-533313161/)