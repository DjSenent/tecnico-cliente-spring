	INSERT INTO proyectos(nombre,horas_restantes) VALUES('AIRE',140);
	INSERT INTO proyectos(nombre,horas_restantes) VALUES('TIERRA',400);
	INSERT INTO proyectos(nombre,horas_restantes) VALUES('AGUA',20);
	INSERT INTO proyectos(nombre,horas_restantes) VALUES('FUEGO',1260);
	
	INSERT INTO tecnicos (nombre,apellido1,apellido2,experiencia) VALUES ('Jose','Perez','Garcia','JUNIOR');
	INSERT INTO tecnicos (nombre,apellido1,apellido2,experiencia) VALUES ('David','Senent','Alfonso','SENIOR');
	INSERT INTO tecnicos (nombre,apellido1,apellido2,experiencia) VALUES ('Alejandro','Serrano','Romero','EXPERTO');
	INSERT INTO tecnicos (nombre,apellido1,apellido2,experiencia) VALUES ('David','Paredes','Ortiz','JUNIOR');
	INSERT INTO tecnicos (nombre,apellido1,apellido2,experiencia) VALUES ('Beatriz','Redondo','Mocho','SENIOR');
	
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (12,2022,4,2);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (12,2022,1,21);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (12,2022,2,70);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (12,2022,3,31);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (12,2022,4,24);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (11,2022,2,7);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (11,2022,1,0);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (11,2022,2,45);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (11,2022,3,25);
	INSERT INTO calendarios (mes,anyo,id_tecnico,horas_trabajadas) VALUES (11,2022,4,27);
	
	INSERT INTO asignaciones(id_proyecto,id_tecnico,porcentaje) VALUES(1,4,10);
	INSERT INTO asignaciones(id_proyecto,id_tecnico,porcentaje) VALUES(1,1,20);
	INSERT INTO asignaciones(id_proyecto,id_tecnico,porcentaje) VALUES(2,1,30);
	INSERT INTO asignaciones(id_proyecto,id_tecnico,porcentaje) VALUES(1,2,20);
	INSERT INTO asignaciones(id_proyecto,id_tecnico,porcentaje) VALUES(1,3,50);
	INSERT INTO asignaciones(id_proyecto,id_tecnico,porcentaje) VALUES(3,4,10);