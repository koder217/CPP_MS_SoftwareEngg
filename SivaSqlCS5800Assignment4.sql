
CREATE TABLE forum.users (
                id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


CREATE TABLE forum.comments (
                id INTEGER NOT NULL,
                id_user INTEGER NOT NULL,
                text VARCHAR NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


ALTER TABLE forum.comments ADD CONSTRAINT users_comments_fk
FOREIGN KEY (id_user)
REFERENCES forum.users (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
