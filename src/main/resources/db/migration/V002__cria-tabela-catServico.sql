create table cat_servico (
	id bigint not null auto_increment,
    usuario_id bigint, 
    profissao varchar(145),
    
	primary key (id)
);

alter table cat_servico add constraint fk_cat_servico_usuario
foreign key (usuario_id) references usuario (id);