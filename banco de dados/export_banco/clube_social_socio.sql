create table socio
(
    cartao_socio int auto_increment
        primary key,
    nome_socio   varchar(255) not null,
    end_socio    varchar(255) not null,
    tel_socio    varchar(255) not null,
    email_socio  varchar(255) not null,
    des_cat      varchar(255) not null
);

INSERT INTO clube_social.socio (cartao_socio, nome_socio, end_socio, tel_socio, email_socio, des_cat) VALUES (10, 'Michele', 'br 392', '53 912345678', 'michele@gmail.com', 'Estudante');
INSERT INTO clube_social.socio (cartao_socio, nome_socio, end_socio, tel_socio, email_socio, des_cat) VALUES (20, 'Maria', 'br 392 km 41', '53 987654321', 'maria@gmail.com', 'Familiar');
INSERT INTO clube_social.socio (cartao_socio, nome_socio, end_socio, tel_socio, email_socio, des_cat) VALUES (21, 'Noeli', 'Av brasil, 114', '123789456', 'noeli@hotmail.com', 'Idoso');
INSERT INTO clube_social.socio (cartao_socio, nome_socio, end_socio, tel_socio, email_socio, des_cat) VALUES (22, 'Cibele	Barros', 'Travessa 9 - Vila Malte', '963258741', 'cibeleb@gmail.com', 'Estudante');
