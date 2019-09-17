# Gestão de projetos

É uma API que permite cadastrar usuários, projetos, associar usuários a projetos e importar arquivo CSV com informações de projetos.

# Banco utilizado para testar a API

O banco utilizado será o PostgreSQL.
Nome do banco: gestao
Usuário: gestao
Senha: gestao

# Carga inicial para a tabela de funções

Deve ser executado os scripts abaixo para popular a tabela de funções.

INSERT INTO funcao(ativo, nome) VALUES ('t', 'DESENVOLVEDOR I');
INSERT INTO funcao(ativo, nome) VALUES ('t', 'DESENVOLVEDOR II');
INSERT INTO funcao(ativo, nome) VALUES ('t', 'ANALISTA DE SISTEMAS I');
INSERT INTO funcao(ativo, nome) VALUES ('t', 'ANALISTA DE SISTEMAS II');
INSERT INTO funcao(ativo, nome) VALUES ('t', 'ANALISTA DE SISTEMAS III');
INSERT INTO funcao(ativo, nome) VALUES ('t', 'ANALISTA DE PROCESSOS');
INSERT INTO funcao(ativo, nome) VALUES ('t', 'DAB');

# Carga inicial para a tabela de usuários

Deve ser executado os scripts abaixo para popular a tabela de usuários.

INSERT INTO usuario(ativo, nome, cpf, email) VALUES('t', 'RICARDO MATEUS', '77580540304', 'ricardo@gmail.com');
INSERT INTO usuario(ativo, nome, cpf, email) VALUES('t', 'MARCIO MACIEL', '77580540305', 'marcio@gmail.com');
INSERT INTO usuario(ativo, nome, cpf, email) VALUES('t', 'IRATUAN JUNIOR', '77580540306', 'iratuan@gmail.com');
INSERT INTO usuario(ativo, nome, cpf, email) VALUES('t', 'JOAO PAULO', '77580540307', 'joao@gmail.com');

# O arquivo CSV deve estar dentro da pasta resource do projeto.

# TESTANDO AS APIs

Lembrando que todos os dados abaixo são de testes

# API: usuarios

API que permite as seguintes funções:

Usuários 1.1 Cadastro de usuários, onde é permitido fazer todo o CRUD de usuários.

# MÉTODO GET
url: localhost:8080/usuarios

Quando solicitada sem passar parâmetros, retorna um JSON com todos usuários cadastrados.

Ex.:

[
    {
        "id": 3,
        "nome": "JOÃO PAULO",
        "cpf": "22345678911",
        "email": "joao.paulo@gmail.com",
        "ativo": true
    },
    {
        "id": 1,
        "nome": "RICARDO MATEUS",
        "cpf": "77580540304",
        "email": "ricardo.mateus@gmail.com",
        "ativo": true
    },
    {
        "id": 2,
        "nome": "MARCIO MACIEL",
        "cpf": "12345678910",
        "email": "marcio@gmail.com",
        "ativo": true
    },
    {
        "id": 4,
        "nome": "IRATUAN JUNIOR",
        "cpf": "77580540306",
        "email": "iratuan@gmail.com",
        "ativo": true
    }
]

url: localhost:8080/usuarios/:ID

Quando passada com parâmetro, retorna o usuário referenciado pelo ID.

Ex.:

{
    "id": 1,
    "nome": "RICARDO MATEUS",
    "cpf": "77580540304",
    "email": "ricardo.mateus@gmail.com",
    "ativo": true
}

# MÉTODO POST
url: localhost:8080/usuarios
Deve-se passar um JSON no corpo da requisição para cadastrar um usuário. 

JSON passado como exemplo:

{
	"nome" : "JOÃO PAULO",
	"email": "joao.paulo@gmail.com",
	"cpf": "22345678911"
}

Retorno: 

{
    "id": 9,
    "nome": "JOÃO PAULO",
    "cpf": "22345678911",
    "email": "joao.paulo@gmail.com",
    "ativo": true
}

# MÉTODO PUT
url: localhost:8080/usuarios/:ID

Deve-se passar um JSON no corpo da requisição para com os atributos que serão atualizados. O ID deve ser passado para garantir que apenas o usuário referenciado por ele seja alterado.

JSON SEM ALTERAÇÃO:

{
        "nome": "MARCIO MACIEL",
        "cpf": "12345678910",
        "email": "marcio@gmail.com",
        "ativo": true
	
}

Agora, passando o JSON para alteração, na seguinte requisição:
localhost:8080/usuarios/2
JSON no corpo:
{
        "nome": "MARCIO MACIEL",
        "cpf": "12345678910",
        "email": "marcio.maciel@gmail.com",
        "ativo": true
	
}

JSON de retorno:

{
    "id": 2,
    "nome": "MARCIO MACIEL",
    "cpf": "12345678910",
    "email": "marcio.maciel@gmail.com",
    "ativo": true
}

# MÉTODO DELETE
url: localhost:8080/usuarios/:ID

Método utilizado para exclusão de usuários.

exemplo: localhost:8080/usuarios/4

O retorno é o código 200 OK

# API: PROJETOS

API que permite as seguintes funções:

2. Projetos
2.1 Cadastro de Projetos
2.2 Listar projetos (Contendo os usuários envolvidos)
2.3 Arquivar projetos


# MÉTODO POST
url: localhost:8080/projetos
Deve-se passar um JSON no corpo da requisição para cadastrar um projeto. 

Exemplo de JSON VÁLIDO para um cadastro de projetos passado no corpo da requisição:

{
	"nomeProjeto" : "PROCESSAMENTO DE ROTAS",
	"gerente": {
			    "nome": "RICARDO MATEUS",
			    "cpf": "77580540304",
			    "email": "ricardo.mateus@gmail.com"

	},
	"dataInicio": "2019-09-15",
	"dataFim": "2019-12-15",
	"timeSkill": "MICROSERVICES",
	"pmSkill": "Scrum, XP",
	"nomeTime": "Integração"
}

# MÉTODO GET
url: localhost:8080/projetos
Retorna todos os projetos cadastrados, juntamente com os usuários envolvidos:

Exemplo de retorno:

[
    {
        "id": 4,
        "nomeProjeto": "PROCESSAMENTO DE ROTAS",
        "gerente": {
            "id": 1,
            "nome": "RAFAEL DOS ANJOS",
            "cpf": "24582012356",
            "email": "rafael.anjos@gmail.cmom",
            "ativo": true
        },
        "usuariosDoProjeto": [
            {
                "id": 2,
                "usuario": {
                    "id": 2,
                    "nome": "MARCIO MACIEL",
                    "cpf": "12345678910",
                    "email": "marcio.maciel@gmail.com",
                    "ativo": true
                },
                "funcao": {
                    "id": 5,
                    "nome": "ANALISTA DE SISTEMAS II",
                    "ativo": true
                },
                "ativo": true
            },
            {
                "id": 1,
                "usuario": {
                    "id": 1,
                    "nome": "RICARDO MATEUS",
                    "cpf": "77580540304",
                    "email": "ricardo.mateus@gmail.com",
                    "ativo": true
                },
                "funcao": {
                    "id": 8,
                    "nome": "ANALISTA DE SISTEMAS III",
                    "ativo": true
                },
                "ativo": true
            }
        ],
        "dataInicio": "2019-09-14",
        "dataFim": "2019-12-14",
        "timeSkill": "MICROSERVICES",
        "pmSkill": "Scrum, XP",
        "nomeTime": "Integração",
        "ativo": true
    }
]

# MÉTODO PUT
url: localhost:8080/projetos/arquivar/:ID
Através dessa endpoit, é possível arquivar um projeto:

Exemplo:
localhost:8080/projetos/arquivar/4

Retorno: 204 No Content 

# API USUARIOS DO PROJETOS

# MÉTODO POST
url: localhost:8080/usuarios_do_projeto
Através desse endpoit é possível associar um usuário cadastrado, com uma função cadastrada a um projeto passados através de um JSON no corpo da requisição. 

Exemplo de JSON

{
	"projeto": {
        "id": 4,
        "nomeProjeto": "PROCESSAMENTO DE ROTAS",
        "gerente": {
            "id": 1,
            "nome": "RAFAEL DOS ANJOS",
            "cpf": "24582012356",
            "email": "rafael.anjos@gmail.cmom",
            "ativo": true
        },
        "dataInicio": "2019-09-14",
        "dataFim": "2019-12-14",
        "timeSkill": "MICROSERVICES",
        "pmSkill": "Scrum, XP",
        "nomeTime": "Integração",
        "ativo": true
    },
    "usuario": {
    	"id": 2,
        "nome": "MARCIO MACIEL",
        "cpf": "12345678910",
        "email": "MARCIO@gmail.com",
        "ativo": true
	},
	"funcao": {
		"id": 11,
		"nome": "ANALISTA DE SISTEMAS IV",
		"ativo": true
	}
} 

	Retorno:
	
	{
    "id": 5,
    "usuario": {
        "id": 2,
        "nome": "MARCIO MACIEL",
        "cpf": "12345678910",
        "email": "MARCIO@gmail.com",
        "ativo": true
    },
    "funcao": {
        "id": 11,
        "nome": "ANALISTA DE SISTEMAS IV",
        "ativo": true
    },
    "ativo": true
}

# API Importação de projeto via arquivo CSV

4. Importação de projetos
4.1 Importação de projetos através de arquivos CSV

# MÉTODO POST
url: localhost:8080/importarcsv/load

Retorno:
"COMPLETED", 200 OK