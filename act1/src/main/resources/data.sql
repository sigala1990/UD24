
DROP table IF EXISTS empleado;
create table empleado(
	id int auto_increment primary key,
	nombre varchar(250),
	trabajo varchar(250),
	salario double);
	
insert into empleado (nombre, trabajo,salario)values('Jose','peon',1000);
insert into empleado (nombre, trabajo,salario)values('Juan','jefe', 3000);
insert into empleado (nombre, trabajo,salario)values('Pedro','encargado', 2000);
insert into empleado (nombre, trabajo,salario)values('Jordi','peon',1000);
insert into empleado (nombre, trabajo,salario)values('Jonatan','peon', 1000);