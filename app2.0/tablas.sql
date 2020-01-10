
create table public.clientes(
    id_cliente serial not null,
    nombre varchar(100) not null,
    password varchar(100),
    primary key (id_cliente)
);

create table public.consultas(
    id_consulta serial not null,
    id_cliente int,
    asunto varchar(100) not null,
    texto varchar(100) not null,
    primary key (id_consulta)
);
