SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals(
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR
);

CREATE TABLE IF NOT EXISTS endangered(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR,
    type VARCHAR,
    health VARCHAR,
    age VARCHAR
);

CREATE TABLE IF NOT EXISTS sightings(
   id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    location VARCHAR,
    name VARCHAR,
    animId INTEGER,
    endangeredId INTEGER
);


