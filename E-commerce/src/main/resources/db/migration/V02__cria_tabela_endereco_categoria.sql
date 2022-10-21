--Endereco
INSERT INTO endereco(end_tx_cep, end_tx_rua, end_tx_bairro, end_tx_cidade, end_tx_numero, end_tx_complemento, end_tx_uf) values  
	('22250040', 'Praia Botafogo', 'Botafogo', 'Rio de Janeiro', 777, 'de 285/286 ao fim', 'RJ'),
    ('25629900', 'Rua Paulo Barbosa', 'Centro', 'Petrópolis', 222, '81', 'RJ'),
    ('22210903', 'Praia do Flamengo', 'Flamengo', 'Rio de Janeiro', 555, '66', 'RJ'),
    ('25620000', 'Rua do Imperador', 'Centro', 'Petrópolis', 888, 'até 552 - lado par', 'RJ')
;

--Categoria
INSERT INTO categoria(cat_tx_nome, cat_tx_descricao) VALUES 
 	('Funkos Star Wars', 'Personagens do Star Wars'),
 	('Funkos DC', 'Heróis da DC')
;