use uber;

create table CLIENTE(
id_cliente INT primary key,
nombre varchar(200) not null,
Edad INT not null,
Telefono INT not null
);

create table SERVICIO(
id_servicio INT primary key, 
nombre varchar(200) not null,
descripcion_servicio varchar(200) not null,
tipo_servicio varchar(200) not null
);

create table TIPO_VEHICULO(
id_tipo INT primary key,
nombre varchar(200) not null,
descripcion varchar(200) null
);

create table ASOCIADO(
id_asociado INT primary key,
nombre_asociado varchar(200) not null
);
Alter table ASOCIADO ADD COLUMN descripcion varchar(200) null;

create table DETALLE_SOCIOSERVICIO(
id_detallesocio INT primary key,
id_asociado INT,
id_servicio INT
);
Alter table DETALLE_SOCIOSERVICIO ADD CONSTRAINT id_asociado FOREIGN KEY references ASOCIADO(id_asociado);
Alter table DETALLE_SOCIOSERVICIO ADD CONSTRAINT id_servicio FOREIGN KEY references SERVICIO(id_servicio);

use uber;
create table VEHICULO(
id_vehiculo INT primary key,
matricula INT,
modelo varchar(200) not null,
id_tipovehiculo INT,
 foreign key (id_tipovehiculo) references TIPO_VEHICULO(id_tipo)
);

Alter table VEHICULO MODIFY matricula varchar(200);

create table DETALLE_SERVICIO(
id_detalleservicio INT primary key,
id_cliente INT,
localizacion varchar(200) not null,
costo_del_servicio INT not null,
id_detallesocio INT,
foreign key (id_detallesocio) references DETALLE_SOCIOSERVICIO(id_detallesocio),
foreign key (id_cliente) references CLIENTE(id_cliente)
);