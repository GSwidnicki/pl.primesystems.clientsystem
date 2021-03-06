INSERT INTO clientsystem.PS_roles (description, role) VALUES ('Default User', 'ROLE_USER');
INSERT INTO clientsystem.PS_roles (description, role) VALUES ('Administrator', 'ROLE_ADMIN');
INSERT INTO clientsystem.PS_users (email, first_name, last_name, password) VALUES ('user@primesystems.pl', 'User', 'User', 'user');
INSERT INTO clientsystem.PS_users (email, first_name, last_name, password) VALUES ('admin@primesystems.pl', 'Admin', 'Admin', 'admin');
INSERT INTO clientsystem.PS_users_roles (role_id, user_id) VALUES (1, 1);
INSERT INTO clientsystem.PS_users_roles (role_id, user_id) VALUES (2, 2);
INSERT INTO clientsystem.PS_customers (building_number, company_name, email, office_number, street, tax_number, website) VALUES ('9', 'G1-Shop Grzegorz Świdnicki', 'g.swidnicki.biuro@gmail.com', '8', 'Traugutta', 6912488075, 'gswidnicki.com');
INSERT INTO clientsystem.PS_customers (building_number, company_name, email, office_number, street, tax_number, website) VALUES ('17', 'Pryzmat - Oddział Lubin', 'lubin@pryzmat.com', '25', 'Kopernika', 8942994513, 'pryzmat.com');
INSERT INTO clientsystem.PS_phones (customer_id, phone_number, number_desc) VALUES (1, '535252077', 'Księgowość');
INSERT INTO clientsystem.PS_phones (customer_id, phone_number, number_desc) VALUES (1, '535252088', 'Właściciel');
INSERT INTO clientsystem.PS_phones (customer_id, phone_number, number_desc) VALUES (2, '713906120', 'Księgowość Wrocław');
INSERT INTO clientsystem.PS_phones (customer_id, phone_number, number_desc) VALUES (2, '713906127', 'Serwis Wrocław');
INSERT INTO clientsystem.PS_phones (customer_id, phone_number, number_desc) VALUES (2, '885818181', 'Oddział Lubin');