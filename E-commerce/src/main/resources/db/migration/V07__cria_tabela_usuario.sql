CREATE TABLE usuario (
	user_cd_id serial primary key,
	user_tx_nome varchar(60) NOT NULL,
	user_tx_email varchar(60) NOT NULL,
	user_tx_senha varchar(255) NOT NULL
);



