--liquibase formatted sql

--changeset ito:1622484109386-2
ALTER TABLE student ADD active BOOLEAN DEFAULT FALSE NOT NULL;

