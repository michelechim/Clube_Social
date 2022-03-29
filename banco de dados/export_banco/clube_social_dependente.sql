create table dependente
(
    cartao_dep   int auto_increment
        primary key,
    cartao_socio int          not null,
    nome_dep     varchar(255) not null,
    parentesco   varchar(255) not null,
    email_dep    varchar(255) not null,
    constraint dependente_ibfk_1
        foreign key (cartao_socio) references socio (cartao_socio)
);

create index cartao_socio
    on dependente (cartao_socio);

INSERT INTO clube_social.dependente (cartao_dep, cartao_socio, nome_dep, parentesco, email_dep) VALUES (10, 20, 'Jose', 'esposo', 'jose@gmail.com');
INSERT INTO clube_social.dependente (cartao_dep, cartao_socio, nome_dep, parentesco, email_dep) VALUES (20, 20, 'Vitoria', 'filha', 'vitoria@gmail.com');
INSERT INTO clube_social.dependente (cartao_dep, cartao_socio, nome_dep, parentesco, email_dep) VALUES (21, 22, 'Cilene Barros', 'Irmã', 'cilene_barros@gmail.com');
