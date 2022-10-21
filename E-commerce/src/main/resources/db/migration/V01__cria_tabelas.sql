CREATE TABLE endereco (
	end_cd_id serial PRIMARY KEY,
	end_tx_cep varchar(8) NOT NULL,
	end_tx_rua varchar(80) NOT NULL,
	end_tx_bairro varchar(50) NOT NULL,
	end_tx_cidade varchar(80) NOT NULL,
	end_tx_numero varchar(20) NOT NULL,
	end_tx_complemento varchar(80),
	end_tx_uf varchar(2) NOT NULL
);

CREATE TABLE cliente (
	cli_cd_id serial PRIMARY KEY,
	cli_tx_nome_completo varchar(50) NOT NULL,
	cli_tx_email varchar(80) NOT NULL UNIQUE,
	cli_tx_cpf varchar(11) NOT NULL UNIQUE,
	cli_tx_telefone varchar(40) NOT NULL,
	cli_dt_data_nascimento date NULL,
	end_cd_id int REFERENCES endereco(end_cd_id)
);

CREATE TABLE categoria (
	cat_cd_id serial PRIMARY KEY,
	cat_tx_nome varchar(30) NOT NULL UNIQUE,
	cat_tx_descricao varchar(280)
);

CREATE TABLE produto (
	prd_cd_id serial PRIMARY KEY,
	prd_tx_nome varchar(30) NOT NULL UNIQUE,
	prd_tx_descricao varchar(200),
	prd_int_quantidade_estoque int,
	prd_dt_data_cadastro date,
	prd_nm_valor_unitario numeric NOT NULL,
	prd_imagem_produto bytea,
	cat_cd_id int REFERENCES categoria(cat_cd_id)
);

CREATE TABLE pedido (
	ped_cd_id serial PRIMARY KEY,
	ped_dt_data_pedido date NOT NULL,
	ped_dt_data_entrega date,
	ped_dt_data_envio date,
	ped_tx_status varchar(1),
	ped_nm_valor_total numeric NOT NULL,
	cli_cd_id int REFERENCES cliente(cli_cd_id)
);

CREATE TABLE pedido_item (
	pdt_cd_id serial PRIMARY KEY,
	pdt_int_quantidade int NOT NULL,
	pdt_nm_percentual_desconto numeric NOT NULL,
	pdt_nm_preco_venda numeric NOT NULL,
	pdt_nm_valor_bruto numeric NOT NULL,
	pdt_nm_valor_liquido numeric NOT NULL,
	ped_cd_id int REFERENCES pedido(ped_cd_id),
	prd_cd_id int REFERENCES produto(prd_cd_id)
);


