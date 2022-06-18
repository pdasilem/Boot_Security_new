insert into users (login, password, name, surname, age, email) values
    ('admin', '$2a$12$uyAfz3v1JrEcHMfjFjn1WOmAlsAPAZDyjymQFXsODY3eU64MzkMHy', 'Admin', 'Adminov', 35, 'admin@admin.com');

insert into roles (role) values
    ('ROLE_ADMIN'),
    ('ROLE_USER');

insert into users_roles (user_id, role_id) values
    ('1', '1'),
    ('1', '2');