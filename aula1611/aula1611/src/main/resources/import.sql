insert into tb_contatos(nome, email)values('maria','maria@gmail.com');
insert into tb_contatos(nome, email)values('joao','joao@gmail.com');
insert into tb_contatos(nome, email)values('pedro','pedro@gmail.com');

insert into tb_locais(nome, rua, numero, bairro, cidade, cep)values('Casa1','Carlos Schmidt1','196','Progresso','Blumenau1','89026-620');
insert into tb_locais(nome, rua, numero, bairro, cidade, cep)values('Casa2','Carlos Schmidt2','196','Progresso','Blumenau2','89026-620');
insert into tb_locais(nome, rua, numero, bairro, cidade, cep)values('Casa3','Carlos Schmidt3','196','Progresso','Blumenau3','89026-620');

insert into tb_compromissos(local_id,contato_id ,data ,hora ,status)values(1,1,'2023-12-06','0.5','ATIVO');
insert into tb_compromissos(local_id ,contato_id ,data ,hora ,status)values(2,2,'2023-12-07','8.5','ATIVO');
insert into tb_compromissos(local_id ,contato_id ,data ,hora ,status)values(3,2,'2023-12-08','7.5','ATIVO');