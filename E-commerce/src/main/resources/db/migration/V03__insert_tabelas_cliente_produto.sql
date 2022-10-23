

--Clientes
INSERT INTO cliente(cli_tx_nome_completo, cli_tx_email, cli_tx_cpf, cli_tx_telefone, 
	cli_dt_data_nascimento, end_cd_id) VALUES 
	('Flamengo', 'mengao@gmail.com', '70618114041', '96875321845', '2000-05-12', 1),
	('Palmeiras', 'greenzada@gmail.com', '18405048030', '85875321871', '2000-06-20', 2),
	('Déby', 'debssss@gmail.com', '92429069059', '32875321873', '2000-07-03', 3),
	('Bula', 'bulinhaStar@gmail.com', '21207149080', '73875321878', '2000-08-24', 4),
	('Roberto', 'euAmoOsAnimais@gmail.com', '10681919027', '64875321879', '2000-09-15', 5),
	('Turma 8', 'aMelhorTurma4ever@gmail.com', '80167501097', '68845321872', '2000-09-15', 6)
;

--Produto

INSERT INTO produto(prd_tx_nome, prd_tx_descricao, prd_int_quantidade_estoque, prd_dt_data_cadastro, prd_nm_valor_unitario, prd_tx_url_produto, cat_cd_id) VALUES 
	('Boba feet', 'Boneco Boba feet', 10, '2022-06-04', 110, NULL, 1),
  ('Leia Organa', 'Boneco Leia Organa', 10, '2022-06-04', 110, NULL, 1),
 	('Yoda', 'Boneco Yoda', 10, '2022-06-04', 110, NULL, 1),
	('Batman', 'Boneco Batman', 10, '2022-06-04', 110, NULL, 2),
	('API', 'Caixão da Felicidade', 36, '2022-10-30', 1000.0, NULL, 2), 
  ('Vasco', 'Caixão da serie a', 8560, '2008-01-05', 110.00, NULL, 1), 
  ('Copinha', 'Caixão do mundial', 5230, '1950-04-15', 11000.00, NULL, 2), 
	('Leonardo', 'Caixão do Windows, linha Linux', 2, '2022-10-20', 10.0, NULL, 1),
	('Rivania', 'Caixão da paz', 11, '2022-08-06', 2250.00, NULL, 3), 
	('Fabio', 'Caixão do amor', 1, '2022-10-12', 2250.00, NULL, 4), 
	('Cleiver', 'Caixão do backend', 200, '2022-10-29', 2250.00, NULL, 3),  
	('Goku', 'Caixão do cabelo', 2, '2022-10-16', 2000.00, NULL, 1),  
	('Serratec', 'Caixão da vida social', 148, '2022-08-06', 10000.00, NULL, 4)  
;

