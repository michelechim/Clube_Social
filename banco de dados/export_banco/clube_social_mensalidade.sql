create table mensalidade
(
    nro_mens       int auto_increment
        primary key,
    cartao_socio   int            not null,
    data_mens      date           not null,
    valor_mens     decimal(10, 2) not null,
    data_pgto_mens date           not null,
    juros_mens     decimal(10, 2) not null,
    valor_pago     decimal(10, 2) not null,
    quit_mens      tinyint(1)     not null,
    constraint mensalidade_ibfk_1
        foreign key (cartao_socio) references socio (cartao_socio),
    constraint mensalidade_ibfk_2
        foreign key (cartao_socio) references socio (cartao_socio)
);

create index cartao_socio
    on mensalidade (cartao_socio);

INSERT INTO clube_social.mensalidade (nro_mens, cartao_socio, data_mens, valor_mens, data_pgto_mens, juros_mens, valor_pago, quit_mens) VALUES (100, 10, '2022-03-15', 12.34, '2022-03-17', 0.50, 12.84, 1);
INSERT INTO clube_social.mensalidade (nro_mens, cartao_socio, data_mens, valor_mens, data_pgto_mens, juros_mens, valor_pago, quit_mens) VALUES (200, 20, '2022-03-17', 45.67, '2022-03-21', 1.25, 46.96, 2);
