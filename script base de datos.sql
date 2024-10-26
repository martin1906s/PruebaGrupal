--CREATE DATABASE INVENTARIOS_KRAKEDEV
--    WITH
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    LC_COLLATE = 'Spanish_Mexico.1252'
--    LC_CTYPE = 'Spanish_Mexico.1252'
--    TABLESPACE = pg_default
--    CONNECTION LIMIT = -1
--    IS_TEMPLATE = False;


drop table if exists historial_movimientos;
drop table if exists articulos;
drop table if exists grupos;

create table grupos(
id_grupo char(4) not null,
nombre varchar(50) not null,
constraint id_grupo_pk primary key(id_grupo)
);

create table articulos(
id_articulo char(4) not null,
nombre varchar(50) not null,
precio_venta money not null,
precio_compra money not null,
id_grupo char(4) not null,
estado boolean not null,
constraint id_articulo_pk primary key(id_articulo),
constraint id_grupo_fk foreign key(id_grupo) references grupos(id_grupo)
);
create table historial_movimientos(
id_historial serial not null,
id_articulo char(4) not null,
cantidad int not null,
fecha_movimiento timestamp not null,
constraint id_historial_pk primary key(id_historial),
constraint id_articulo_fk foreign key(id_articulo) references articulos(id_articulo)
);

insert into grupos(id_grupo, nombre)
values
('G001','ropa'),
('G002','electronica'),
('G003','alimentos');

insert into articulos(id_articulo, nombre, precio_venta, precio_compra, id_grupo, estado)
values
('A001','computador hp i7',850,800,'G002', true),
('A002','vestido de gala azul',185.5,150.3,'G001', true),
('A003','canasta de verduras',58,48.5,'G003',false),
('A004','pantalon jean talla 8',25,18.5,'G001',true),
('A005','chompa afelpada',55,49.8,'G001',false),
('A006','iphone 15 pro max',1200,1110.25,'G002',false),
('A007','smart tv 49 p',850,730,'G002',true),
('A008','nescafe gold',7.5,6.95,'G003',false),
('A009','teclado y mouse inalambricos',35,28.5,'G002',true),
('A010','quintal arroz',58,54,'G003',false);

insert into historial_movimientos(id_articulo, cantidad, fecha_movimiento)
values
('A002',10,'2024/10/10 08:40'),
('A005',12,'2024/10/10 9:30'),
('A007',9,'2024/10/10 10:15'),
('A001',8,'2024/10/12 08:00'),
('A007',-5,'2024/10/15 14:40'),
('A009',8,'2024/10/15 18:00'),
('A006',20,'2024/10/20 11:30'),
('A008',50,'2024/10/22 9:00'),
('A010',15,'2024/10/24 10:30'),
('A001',-2,'2024/10/25 16:30');

select * from articulos;
select * from grupos;
select * from historial_movimientos order by fecha_movimiento;
