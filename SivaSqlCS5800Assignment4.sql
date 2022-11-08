
CREATE TABLE notown.address (
                addressID INTEGER NOT NULL,
                street1 VARCHAR NOT NULL,
                street2 VARCHAR NOT NULL,
                number INTEGER NOT NULL,
                city VARCHAR NOT NULL,
                state VARCHAR NOT NULL,
                telephone VARCHAR NOT NULL,
                zipCode VARCHAR NOT NULL,
                CONSTRAINT address_pk PRIMARY KEY (addressID)
);


CREATE TABLE notown.musician (
                ssn INTEGER NOT NULL,
                addressID INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT musician_pk PRIMARY KEY (ssn)
);


CREATE TABLE notown.album (
                albumID INTEGER NOT NULL,
                title VARCHAR NOT NULL,
                release_date DATE NOT NULL,
                format VARCHAR NOT NULL,
                age INTEGER NOT NULL,
                producer_ssn INTEGER NOT NULL,
                CONSTRAINT album_pk PRIMARY KEY (albumID)
);


CREATE TABLE notown.song (
                title VARCHAR NOT NULL,
                length INTEGER NOT NULL,
                albumID INTEGER NOT NULL,
                ssn_author INTEGER NOT NULL,
                CONSTRAINT song_pk PRIMARY KEY (title)
);


CREATE TABLE notown.performs (
                ssn INTEGER NOT NULL,
                title VARCHAR NOT NULL,
                CONSTRAINT performs_pk PRIMARY KEY (ssn, title)
);


CREATE TABLE notown.instrument (
                name VARCHAR NOT NULL,
                pitch INTEGER NOT NULL,
                CONSTRAINT name PRIMARY KEY (name)
);


CREATE TABLE notown.instrument_usedin (
                name VARCHAR NOT NULL,
                title VARCHAR NOT NULL,
                CONSTRAINT instrument_usedin_pk PRIMARY KEY (name, title)
);


CREATE TABLE notown.plays (
                ssn INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT plays_pk PRIMARY KEY (ssn, name)
);


ALTER TABLE notown.instrument ADD CONSTRAINT users_comments_fk
FOREIGN KEY (pitch)
REFERENCES notown.address (addressID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.musician ADD CONSTRAINT address_musician_fk
FOREIGN KEY (addressID)
REFERENCES notown.address (addressID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.plays ADD CONSTRAINT musician_plays_fk
FOREIGN KEY (ssn)
REFERENCES notown.musician (ssn)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.performs ADD CONSTRAINT musician_performs_fk
FOREIGN KEY (ssn)
REFERENCES notown.musician (ssn)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.album ADD CONSTRAINT musician_album_fk
FOREIGN KEY (producer_ssn)
REFERENCES notown.musician (ssn)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.song ADD CONSTRAINT musician_song_fk
FOREIGN KEY (ssn_author)
REFERENCES notown.musician (ssn)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.song ADD CONSTRAINT album_song_fk
FOREIGN KEY (albumID)
REFERENCES notown.album (albumID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.instrument_usedin ADD CONSTRAINT song_instrument_usedin_fk
FOREIGN KEY (title)
REFERENCES notown.song (title)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.performs ADD CONSTRAINT song_performs_fk
FOREIGN KEY (title)
REFERENCES notown.song (title)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.plays ADD CONSTRAINT instrument_plays_fk
FOREIGN KEY (name)
REFERENCES notown.instrument (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE notown.instrument_usedin ADD CONSTRAINT instrument_instrument_usedin_fk
FOREIGN KEY (name)
REFERENCES notown.instrument (name)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;