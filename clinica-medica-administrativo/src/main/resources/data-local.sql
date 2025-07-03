insert into especialidades (id,nome,descricao) values (1,'admin','administrador do sistema');

insert into especialidades (id,nome,descricao) values (2,'medico geral','atendimento');

insert into especialidades (id,nome,descricao) values (3,'atendente','atendente da recepção');

insert into perfis(id,atualizar_consulta,atualizar_convenio,atualizar_especialidade,atualizar_funcionario,atualizar_paciente,atualizar_prontuario,cadastrar_consulta,cadastrar_convenio,cadastrar_especialidade,
cadastrar_funcionario,cadastrar_paciente,cadastrar_prontuario,deletar_consulta,deletar_convenio,deletar_especialidade,deletar_funcionario,deletar_paciente,deletar_prontuario,ler_consulta,ler_convenio,
ler_especialidade,ler_funcionario,ler_paciente,ler_prontuario,listar_consulta,listar_convenio,listar_especialidade,listar_funcionario,listar_paciente,listar_prontuario,nome,atualizar_perfil,cadastrar_perfil,
deletar_perfil,ler_perfil,listar_perfil) values (1,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,'outros',
true,true,true,true,true);

insert into perfis(id,atualizar_consulta,atualizar_convenio,atualizar_especialidade,atualizar_funcionario,atualizar_paciente,atualizar_prontuario,cadastrar_consulta,cadastrar_convenio,cadastrar_especialidade,
cadastrar_funcionario,cadastrar_paciente,cadastrar_prontuario,deletar_consulta,deletar_convenio,deletar_especialidade,deletar_funcionario,deletar_paciente,deletar_prontuario,ler_consulta,ler_convenio,
ler_especialidade,ler_funcionario,ler_paciente,ler_prontuario,listar_consulta,listar_convenio,listar_especialidade,listar_funcionario,listar_paciente,listar_prontuario,nome,atualizar_perfil,cadastrar_perfil,
deletar_perfil,ler_perfil,listar_perfil) values (2,true,false,false,false,false,true,true,false,false,false,false,true,true,false,false,false,false,true,true,false,false,false,false,true,true,false,false,false,false,true,'medico',
false,false,false,false,false);

insert into perfis(id,atualizar_consulta,atualizar_convenio,atualizar_especialidade,atualizar_funcionario,atualizar_paciente,atualizar_prontuario,cadastrar_consulta,cadastrar_convenio,cadastrar_especialidade,
cadastrar_funcionario,cadastrar_paciente,cadastrar_prontuario,deletar_consulta,deletar_convenio,deletar_especialidade,deletar_funcionario,deletar_paciente,deletar_prontuario,ler_consulta,ler_convenio,
ler_especialidade,ler_funcionario,ler_paciente,ler_prontuario,listar_consulta,listar_convenio,listar_especialidade,listar_funcionario,listar_paciente,listar_prontuario,nome,atualizar_perfil,cadastrar_perfil,
deletar_perfil,ler_perfil,listar_perfil) values (3,true,true,false,false,true,false,true,true,false,false,true,false,true,true,false,false,true,false,true,true,false,false,true,false,true,true,false,false,true,false,'atendente',
false,false,false,false,false);

insert into funcionarios(id,bairro,cidade,complemento,contato,cpf,data_nascimento,email,estado,idade,nome,numero,rua,senha,sexo,tipo_funcionario,usuario,especialidade_id,perfil_id) values (1,'admin_bairro','admin_cidade',
'admin_complemento','admin_contato','admin_cpf','2000-01-01','admin_email','admin_estado',22,'admin_nome','admin_numero','admin_rua','$2a$10$v3XiWemKfdA5L3SCmaofsO4oQqWSyHiO5QDg8hJ9GFAN5mWS.EcGu','m','OUTROS','teste',1,1);

insert into funcionarios(id,bairro,cidade,complemento,contato,cpf,data_nascimento,email,estado,idade,nome,numero,rua,senha,sexo,tipo_funcionario,usuario,especialidade_id,perfil_id) values (2,'medico_bairro','medico_cidade',
'medico_complemento','medico_contato','medico_cpf','2000-01-01','medico_email','medico_estado',22,'medico_nome','medico_numero','medico_rua','$2a$10$8ZEsbWZVvMVqQxGmah9S9.lOroWnnNH7oHoi3g7zURJ8wPwG9SfEC','m','MEDICO','medico',2,2);

insert into funcionarios(id,bairro,cidade,complemento,contato,cpf,data_nascimento,email,estado,idade,nome,numero,rua,senha,sexo,tipo_funcionario,usuario,especialidade_id,perfil_id) values (3,'atendente_bairro','atendente_cidade',
'atendente_complemento','atendente_contato','atendente_cpf','2000-01-01','atendente_email','atendente_estado',20,'atendente_nome','atendente_numero','atendente_rua','$2a$10$Z9J64IIOJojIhEZgSl21/ewYqTdG5JUz8.zDbfgwXX19Gds/9RyEq','m','ATENDENTE','atendente',3,3);

insert into pacientes(id,bairro,cidade,complemento,contato,cpf,data_nascimento,email,estado,idade,nome,numero,rua,sexo) values(1,'paciente_bairro','paciente_cidade','paciente_complemento','paciente_contato','paciente_cpf','1995-05-10','paciente_email','paciente_estado',30,'paciente_nome','paciente_numero','paciente_rua','m');

insert into convenios(id,descricao,nome) values(1,'só tem problema','Ipsemg');