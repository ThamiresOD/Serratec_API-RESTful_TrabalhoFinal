

CREATE TABLE Usuario(
	id_usuario serial primary key,
	nome_completo varchar(50),
	email varchar(80),
	senha varchar(255)
);

CREATE TABLE Perfil(
	id_perfil serial primary key,
	tipo varchar(5)
);

CREATE TABLE usuario_perfil (
	id_usuario int references usuario (id_usuario),
	id_perfil int references perfil(id_perfil),
	data_criacao date,
constraint pk_usuario_perfil primary key (id_usuario, id_perfil)
);