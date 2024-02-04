ALTER TABLE Event
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (user_id)
            REFERENCES User(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT fk_file_id
        FOREIGN KEY (file_id)
            REFERENCES File(id)
            ON DELETE CASCADE
               ON UPDATE CASCADE
;