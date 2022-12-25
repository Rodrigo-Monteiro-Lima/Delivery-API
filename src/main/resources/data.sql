INSERT INTO restaurant (id, cep, complement, name) VALUES
(1L, '0000001', 'Complemento Endereço Restaurante 1', 'Restaurante 1'),
(2L, '0000002', 'Complemento Endereço Restaurante 2', 'Restaurante 2');

INSERT INTO client (id, cep, complement, name) VALUES
(1L, '0000001', 'Complemento Endereço Cliente 1', 'Cliente 1');

INSERT INTO product (id, avaliable, name, unitary_value, restaurant_id) VALUES
(1L, true, 'Produto 1', 5.0, 1L),
(2L, true, 'Produto 2', 6.0, 1L),
(3L, true, 'Produto 3', 7.0, 2L);

INSERT INTO cart (id, payment_method, closed, total, client_id) VALUES
(1L, 0, false, 0.0, 1L);
