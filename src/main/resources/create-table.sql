CREATE TABLE public.cars
(
  id serial PRIMARY KEY ,
  name character varying(50) NOT NULL,
  marka character varying(50) NOT NULL,
  year integer NOT NULL
);

insert into cars(name , marka, year) values ('tazz', 'lada', 2300);