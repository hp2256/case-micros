
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO roles (name) values ('ROLE_RECEPTIONIST');
INSERT INTO roles (name) values ('ROLE_MANAGER');
INSERT INTO roles (name) values ('ROLE_OWNER');

--  encoding  with Bcrypt also change config in SecurityConfiguration
insert INTO users (username,password,email) values ('owner','$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','user1@gmail.com');
insert INTO users (username,password,email) values ('manager1','$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','user2@gmail.com');
insert INTO users (username,password,email) values ('receptionist1','$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','user3@gmail.com');

insert INTO user_roles values(1,3);
insert INTO user_roles values(2,2);
insert INTO user_roles values(3,1);

SET FOREIGN_KEY_CHECKS=1;

-- No encoding only for development!!!!!!
--insert INTO users (username,pass,first_name,last_name) values ('user1','pass1','fname1','lname1');
--insert INTO users (username,pass,first_name,last_name) values ('user2','pass2','fname2','lname2');
--insert INTO users (username,pass,first_name,last_name) values ('user3','pass3','fname3','lname3');
--insert INTO users (username,pass,first_name,last_name) values ('user4','pass4','fname4','lname4');
--insert INTO users (username,pass,first_name,last_name) values ('user5','pass5','fname5','lname5');
--insert INTO users (username,pass,first_name,last_name) values ('user6','pass6','fname6','lname6');
--insert INTO users (username,pass,first_name,last_name) values ('user7','pass7','fname7','lname7');
--insert INTO users (username,pass,first_name,last_name) values ('user8','pass8','fname8','lname8');


