

--INSERT INTO usuario (nome, email, senha) VALUES
--	('Turma08', 'aMelhorTurma4ever@gmail.com', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK'), --senha /123456
--	('Green Reaper', 'donamorte@gmail.com', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK'); --123456
--
--INSERT INTO perfil (nome) VALUES
--	('ADMIN'),
--	('USER');
--
--INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES
--	( (SELECT id_usuario FROM usuario WHERE email='aMelhorTurma4ever@gmail.com'),
--	  (SELECT id_perfil FROM perfil WHERE nome='ADMIN') ),
--	( (SELECT id_usuario FROM usuario WHERE email='aMelhorTurma4ever@gmail.com'),
--	  (SELECT id_perfil FROM perfil WHERE nome='USER') ),
--	( (SELECT id_usuario FROM usuario WHERE email='donamorte@gmail.com'),
--	  (SELECT id_perfil FROM perfil WHERE nome='USER') );

insert into Usuario (nome_completo, email,senha) VALUES
	('Grim Reaper','donamorte@gmail.com','$2a$12$ZjvwXBjNeJTKazlrocGlZ.9l8dt9xFXOCoguie9.sfWa8xb.yyxy6'), -- 123456
	('Mandy','mandy@hotmail.com','$2a$12$WUzzKnhoHn.veC2K0EYRfO0dI3FRcBnGxQYvnEZ3VmIYqK9hiTbEK'), -- renan
	('Billy','billy@gmail.com','$2a$12$Pso84rdA797enOwcB0StROGtnnBdeQ9792jn3nZKe5X77Y4JC/zaW'),	-- isabelly
	('Turma08','aMelhorTurma4ever@gmail.com','$2a$12$J7RDWxkA0XjEzTUe11Xjde01KP9kZ6urFmelcI.JNWOP48RH8P9ke'); -- fabiana
	
INSERT INTO Perfil(tipo) VALUES 
	('ADMIN'),
	('USER');
	
INSERT INTO usuario_perfil(id_usuario,id_perfil,data_criacao) VALUES 
	(1,1,'2022-10-24'),
	(2,2,'2022-10-24'),
	(3,2,'2022-10-24'),
	(4,1,'2022-10-24');