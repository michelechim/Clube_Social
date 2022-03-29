create table categoria(
   des_cat varchar(255) primary key not null
);

insert into categoria (des_cat) values 
('Estudante'),
('Idoso');

create table socio (
    cartao_socio int(11) primary key not null,
    nome_socio varchar(255) not null,
    end_socio varchar(255) not null,
    tel_socio varchar(255) not null,
    email_socio varchar(255) not null,
	des_cat varchar(255) not null
);
alter table socio
	modify cartao_socio int(11) not null auto_increment, auto_increment=3;

insert into socio(cartao_socio, nome_socio, end_socio, tel_socio, email_socio, des_cat) values
(10, 'Michele', 'br 392', '53 912345678','michele@gmail.com', 'Estudante'),
(20, 'Maria', 'br 392 km 41', '53 987654321','maria@gmail.com', 'Familiar');

create table mensalidade (
	nro_mens int(11) primary key not null,
	cartao_socio int(11) not null,
    data_mens date not null,
    valor_mens decimal(10,2) not null,
    data_pgto_mens date not null,
    juros_mens decimal(10,2) not null,
    valor_pago decimal(10,2) not null,
    quit_mens boolean not null
);

alter table mensalidade
	modify nro_mens int(11) not null auto_increment, auto_increment=3;
	
alter table mensalidade
	add foreign key (cartao_socio) references socio (cartao_socio);

insert into mensalidade(nro_mens, cartao_socio, data_mens, valor_mens, data_pgto_mens, juros_mens,valor_pago, 
quit_mens) values
(100, 10,'2022/03/15','12.34','2022/03/17', '0.50', '12.84', 1),
(200, 20,'2022/03/17','45.67',' ', ' ', ' ', 2);

create table dependente (
    cartao_dep int(11) primary key not null,
	cartao_socio int(11) not null,
    nome_dep varchar(255) not null,
    parentesco varchar(255) not null,
    email_dep varchar(255) not null
);
alter table dependente
	modify cartao_dep int(11) not null auto_increment, auto_increment=3;

alter table dependente
	add foreign key (cartao_socio) references socio (cartao_socio);
	
insert into dependente(cartao_dep, cartao_socio, nome_dep, parentesco, email_dep) values
(010, 20, 'Jose', 'esposo','jose@gmail.com'),
(020, 20, 'Vitoria', 'filha','vitoria@gmail.com');