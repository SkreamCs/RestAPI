create table Event(
                     id int PRIMARY KEY AUTO_INCREMENT,
                     user_id int,
                     file_id int,
                  CONSTRAINT uniqueEvent UNIQUE(user_id, file_id)
);
