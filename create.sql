CREATE DATABASE news_portal;
CREATE TABLE news (id SERIAL PRIMARY KEY, headline VARCHAR, content VARCHAR, department_id INTEGER);
CREATE TABLE departments (id SERIAL PRIMARY KEY, name varchar, description VARCHAR);
CREATE TABLE users (id SERIAL PRIMARY KEY, name VARCHAR, position varchar, role VARCHAR, department_id INTEGER);

CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;