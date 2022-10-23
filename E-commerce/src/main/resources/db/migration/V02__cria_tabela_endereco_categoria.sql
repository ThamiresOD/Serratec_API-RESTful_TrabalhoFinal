

--Endereco
INSERT INTO endereco(end_tx_cep, end_tx_rua, end_tx_bairro, end_tx_cidade, end_tx_numero, 
	end_tx_complemento, end_tx_uf) values  
    ('25629900', 'Rua Paulo Barbosa', 'Centro', 'Petrópolis', 247, 'Segunda porta a esquerda', 'RJ'),
    ('22210903', 'Praia do Flamengo', 'Flamengo', 'Rio de Janeiro', 585, 'Atrás da banca de jornal', 'RJ'),
    ('22250040', 'Praia Botafogo', 'Botafogo', 'Rio de Janeiro', 27, 'de 27/28 ao fim', 'RJ'),
    ('25620000', 'Rua do Imperador', 'Centro', 'Petrópolis', 8, 'até 12 - lado par', 'RJ'),
    ('21031450', 'Rua Andira', 'Olaria', 'Friburgo', 43, 'Ao lado do posto de saude', 'RJ'),
    ('25990290', 'Estrada Antas', 'Antas', 'Teresópolis', 2365, 'Cerca de madeira e arame', 'RJ')
;

--Categoria
INSERT INTO categoria(cat_tx_nome, cat_tx_descricao) VALUES 
 	('Basic', 'Ajustavel'),
 	('Plus', 'Alças revestidas'),	
 	('Confort', 'Estofamento duplo'),	
 	('Premium', 'Resistence++')
;
