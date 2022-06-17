create table pedido(
	id bigint not null auto_increment,

    usuario_cliente_id bigint not null,
    forma_pagamento_id bigint not null,
    restaurante_id bigint not null,

    subtotal decimal(10,2) not null,
    taxa_frete decimal(10,2) not null,
    valor_total decimal(10,2) not null,
    data_criacao datetime not null,
    data_confirmacao datetime null,
    data_cancelamento datetime null,
    data_entrega datetime null,

    endereco_cidade_id bigint not null,
    endereco_cep varchar(20) not null,
    endereco_logradouro varchar(60) not null,
    endereco_numero varchar(20) not null,
    endereco_bairro varchar(20) not null,
    endereco_complemento varchar(60) null,

    status varchar(10) not null,
    primary key(id)
)engine=InnoDB default charset=utf8mb4;

alter table pedido add constraint fk_pedido_usuario_cliente
foreign key (usuario_cliente_id) references usuario(id);

alter table pedido add constraint fk_pedido_forma_pagamento
foreign key (forma_pagamento_id) references forma_pagamento(id);

alter table pedido add constraint fk_pedido_cidade
foreign key (endereco_cidade_id) references cidade(id);

alter table pedido add constraint fk_pedido_restaurante
foreign key (restaurante_id) references restaurante(id);