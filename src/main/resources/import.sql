insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Portuguesa');
insert into cozinha (nome) values ('Mexicana');
insert into cozinha (nome) values ('Chinesa');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Francesa');
insert into cozinha (nome) values ('Argentina');
insert into cozinha (nome) values ('Brasileira');

insert into estado (id, nome) values (1, 'São Paulo');
insert into estado (id, nome) values (2, 'Rio de Janeiro');
insert into estado (id, nome) values (3, 'Paraná');

insert into cidade (nome, estado_id) values ('Campinas', 1);
insert into cidade (nome, estado_id) values ('Ribeirão Preto', 1);
insert into cidade (nome, estado_id) values ('Guarulhos', 1);

insert into cidade (nome, estado_id) values ('Itaboraí', 2);
insert into cidade (nome, estado_id) values ('Nova Friburgo', 2);
insert into cidade (nome, estado_id) values ('Macaé', 2);

insert into cidade (nome, estado_id) values ('Curitiba', 3);
insert into cidade (nome, estado_id) values ('Cascavel', 3);
insert into cidade (nome, estado_id) values ('Londrina', 3);

insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, data_cadastro, data_atualizacao) values ('Sain\'t Carlos', 20.5, 1, 5, 'Centro', '28613-190', 'Próximo ao Bradesco', 'Rua Lopes Trovão', '715', utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, data_cadastro, data_atualizacao) values ('Só Picanha', 14.25, 2, 1, 'Jardim do Lago Continuação', '13051-062', 'Ao lado do parque', 'Rua Coronel Roberto Mondino', '812', utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Chimarron Churrascaria', 20.99, 3, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Délicieuse de Marcélli', 0, 6, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Hot a Tongle', 0, 3, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Java Steakhouse', 12, 3, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Lanchonete do Tio Sam', 11, 7, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Bar da Maria', 6, 7, utc_timestamp, utc_timestamp);

insert into permissao (descricao, nome) values ('Permite a criação de novos usuários', 'Criar usuários');
insert into permissao (descricao, nome) values ('Permite a criação de novos restaurantes', 'Criar Restaurantes');
insert into permissao (descricao, nome) values ('Permite a modificação de formas de pagamento', 'Modificar Forma Pagamento');

insert into forma_pagamento (descricao) values ('Boleto');
insert into forma_pagamento (descricao) values ('Pix');
insert into forma_pagamento (descricao) values ('Cartão de Crédito');
insert into forma_pagamento (descricao) values ('Cartão de Débito');
insert into forma_pagamento (descricao) values ('Transferência Bancária');
insert into forma_pagamento (descricao) values ('Bitcoin');
insert into forma_pagamento (descricao) values ('Apple Pay');
insert into forma_pagamento (descricao) values ('Dinheiro');

INSERT INTO restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (2, 1), (2, 2), (2, 8), (3, 1), (3, 2), (3, 8), (4, 1), (4, 2), (4, 8), (5, 1), (5, 2), (5, 8), (6, 1), (6, 2), (6, 8), (7, 1), (7, 2), (7, 8);

insert into produto(ativo, descricao, nome, preco, restaurante_id) values (true, 'Descrição produto', 'Kuay Teow Neua', 28.99, 1);
insert into produto(ativo, descricao, nome, preco, restaurante_id) values (true, 'Descrição produto', 'Picanha do Dauro', 38.69, 2);
insert into produto(ativo, descricao, nome, preco, restaurante_id) values (true, 'Descrição produto', 'Filé Mignon', 42.99, 3);
insert into produto(ativo, descricao, nome, preco, restaurante_id) values (true, 'Descrição produto', 'Mouclade Charentaise', 55.99, 4);
insert into produto(ativo, descricao, nome, preco, restaurante_id) values (true, 'Descrição produto', 'Cochinita Pibil', 18.99, 5);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);