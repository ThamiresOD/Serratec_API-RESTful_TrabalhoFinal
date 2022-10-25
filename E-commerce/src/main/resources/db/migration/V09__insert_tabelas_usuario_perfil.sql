DELETE from perfil;


INSERT INTO usuario (user_tx_nome, user_tx_email, user_tx_senha) VALUES
('Turma08', 'aMelhorTurma4ever@gmail.com', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK'),
('Andre das coves', 'andre@gmail.com', '$2a$12$G7ibc/sJRL0BWCpVCBcRxudHZ2aV8uHbMhHbu/Y6Zpz3Dw1X4.B2S');
INSERT INTO perfil (per_tx_nome) VALUES
('ADMIN'),
('USER');

--INSERT INTO usuario_perfil (user_cd_id, per_cd_id) VALUES
--( (SELECT user_cd_id FROM usuario WHERE user_tx_email='aMelhorTurma4ever@gmail.com'),
-- (SELECT per_cd_id FROM perfil WHERE per_tx_nome='ADMIN') ),
-- 
--( (SELECT user_cd_id FROM usuario WHERE user_tx_email='aMelhorTurma4ever@Gmail.com'),
-- (SELECT per_cd_id FROM perfil WHERE per_tx_nome='USER') ),
-- 
--( (SELECT user_cd_id FROM usuario WHERE user_tx_email='andre@gmail.com'),
-- (SELECT per_cd_id FROM perfil WHERE per_tx_nome='USER') );
 
INSERT INTO usuario_perfil (user_cd_id, per_cd_id, usep_dt_data_criacao) VALUES
	(1, 1, '2022-10-24'),
	(1, 2, '2022-10-24'),	
	(2, 2, '2022-10-24')	
;
