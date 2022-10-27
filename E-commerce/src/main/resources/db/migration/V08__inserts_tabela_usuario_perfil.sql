

INSERT INTO usuario (nome, email, senha) VALUES
	('Turma08', 'aMelhorTurma4ever@gmail.com', '$2a$12$WHqn.RUY/LdpbNCdvEJVaubQXTJK6XDwTXq5swKcsKvs5MmIDcnHy'), --senha
	('Green Reaper', 'donamorte@gmail.com', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK'); --123456

INSERT INTO perfil (nome) VALUES
	('ADMIN'),
	('USER');

INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES
	( (SELECT id_usuario FROM usuario WHERE email='aMelhorTurma4ever@gmail.com'),
	  (SELECT id_perfil FROM perfil WHERE nome='ADMIN') ),
	( (SELECT id_usuario FROM usuario WHERE email='aMelhorTurma4ever@gmail.com'),
	  (SELECT id_perfil FROM perfil WHERE nome='USER') ),
	( (SELECT id_usuario FROM usuario WHERE email='donamorte@gmail.com'),
	  (SELECT id_perfil FROM perfil WHERE nome='USER') );