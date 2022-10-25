

--Pedido_Item
INSERT INTO pedido_item(pdt_int_quantidade, pdt_nm_percentual_desconto, pdt_nm_preco_venda, 
	pdt_nm_valor_bruto, pdt_nm_valor_liquido, ped_cd_id, prd_cd_id) VALUES
	(4, 10, 110.00, 440.00, 396.00, 1, 2),
	(2, 5, 10.00, 20.00, 19.00, 2, 4),
	(1, 90, 11000.00, 11000.00, 1100.00, 3, 3),
	(2, 25, 2000.00, 4000.00, 3000.00, 4, 8),
	(30, 5, 1000.00, 30000.00, 28500.00, 5, 1),
	(1, 20, 2250.00, 2250.00, 1800.00, 6, 7),
	(36, 80, 10000.00, 360000.00, 72000.00, 7, 9)
;