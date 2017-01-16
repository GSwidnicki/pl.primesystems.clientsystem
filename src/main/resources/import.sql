INSERT INTO clientsystem.PS_roles (description, role) VALUES ('Default User', 'ROLE_USER');
INSERT INTO clientsystem.PS_users (email, first_name, last_name, password) VALUES ('office@primesystems.pl', 'Grzegorz', 'Świdnicki', 'root');
INSERT INTO clientsystem.PS_users_roles (role_id, user_id) VALUES (1, 1);