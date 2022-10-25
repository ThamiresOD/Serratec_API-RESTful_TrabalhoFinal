CREATE TABLE perfil (
	per_cd_id serial primary key,
	per_tx_nome varchar(40)
);

CREATE TABLE usuario_perfil (
	user_cd_id int references usuario(user_cd_id),
	per_cd_id int references perfil(per_cd_id),
	usep_dt_data_criacao date,
	constraint pk_usuario_perfil primary key (user_cd_id, per_cd_id)
);

insert into perfil (per_cd_id, per_tx_nome) values
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');

