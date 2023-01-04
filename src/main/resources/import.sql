INSERT INTO tb_enderecos(id, logradouro, cep, numero, cidade) VALUES (1, 'casa', '35533079', '368', 'nova serrana');
INSERT INTO tb_enderecos(id, logradouro, cep, numero, cidade) VALUES (2, 'apartamento', '35527074', '212', 'divinopolis');
INSERT INTO tb_enderecos(id, logradouro, cep, numero, cidade) VALUES (3, 'rural', '35522073', '523', 'bom despacho');

INSERT INTO tb_pessoas(codigo, DATA_NASCIMENTO, nome) VALUES (1, '1999-05-16', 'Caio');
INSERT INTO tb_pessoas(codigo, DATA_NASCIMENTO, nome) VALUES (2, '2000-02-11', 'Joao');
INSERT INTO tb_pessoas(codigo, DATA_NASCIMENTO, nome) VALUES (3, '1995-12-20', 'Eduardo');

INSERT INTO  TB_ENDERECO_PESSOA(PESSOA_ID, ENDERECO_ID) VALUES (1,2);
INSERT INTO  TB_ENDERECO_PESSOA(PESSOA_ID, ENDERECO_ID) VALUES (2,3);
INSERT INTO  TB_ENDERECO_PESSOA(PESSOA_ID, ENDERECO_ID) VALUES (3,1);


