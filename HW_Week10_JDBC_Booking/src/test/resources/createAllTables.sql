CREATE TABLE accommodation
(
    id serial NOT NULL,
    type character varying(32) NOT NULL,
    bed_type character varying(32) NOT NULL,
    max_guests integer NOT NULL,
    description character varying(512),
    PRIMARY KEY (id)
);

CREATE TABLE room_fare
(
    id serial NOT NULL,
    value double precision NOT NULL,
    season character varying(32),
    PRIMARY KEY (id)
);

CREATE TABLE accommodation_fare_relation
(
    id serial NOT NULL,
    id_accommodation integer NOT NULL,
    id_room_fare integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE accommodation_fare_relation
    ADD FOREIGN KEY (id_accommodation)
    REFERENCES accommodation (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    ;


ALTER TABLE accommodation_fare_relation
    ADD FOREIGN KEY (id_room_fare)
    REFERENCES room_fare (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
   ;


