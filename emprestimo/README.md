## Cadastrar, listar, alterar e deletar  clientes
> GerenciarEmprestimo

Resumo Geral do projeto.
Esta API Rest é responsável por gerir toda o emprestimo e devolução de livros

### Getting Started

* Java 17
* Maven
* SpringBoot

### Initial Configuration

Alguns projetos requerem configuração inicial. Esta é a seção onde você documentaria esses requisitos.

## Developing

Aqui está uma breve introdução sobre o que um desenvolvedor deve fazer para começar a desenvolver
o projeto:

```
git clone 
cd GerenciarEmprestimo
```

### Building

Etapas adicionais para o desenvolvedor construir o projeto após algumas alterações de código e configurações de IDE:

Projeto padronizado de acordo com arquivo ``./resources/swagger.yml``

## Premise


## Configuration



## Deploy and Test

1 – Cadastrar emprestimo

- API: /Emprestimo
- End Point URL Path:  /emprestimo/cadastrar
- Method: POST
- Objetivo: Cadastrar todas as informações necessárias para identificação de um cliente e livro, para processo de cadastro emprestimo.
- Descrição: Este método é responsável por cadastrar um emprestimo de livro.

1.1 - JSON Request de exemplo:
```
{
    "idCliente": 1,
    "idLivro": 2
}
```
1.2 - JSON Response de exemplo:
```
    {   
        "protocolo": "01234"
    }
```
2 – Listar livros do cliente

- API: /emprestimo/
- End Point URL Path:  /emprestimo/{idCliente}
- Method: GET
- Objetivo: retornar lista com todas as informações de todos os livros que o cliente possui.
- Descrição: Este método é responsável por listar todos os ivros que o cliente possui.

PathParams: idCliente (idCliente): path param (idCliente) value=1</br>

2.1 - JSON Response de exemplo:
```
{
    "nome": "Mariana Silva",
    "contato": "11-94444-4444",
    "email": "mariana@gmail.com",
    "idade": "18",
    "endereco": "Rua C Bairro V  n° 15, São Paulo - SP",
    "emprestimos": [
        {
            "livros": [
                {
                    "nome": "Orgulho e preconceito",
                    "autor": "Jane Austen",
                    "editora": "Camelot Editora",
                    "descricao": "É um dos mais aclamados romances da escritora inglesa Jane Austen",
                    "genero": "Romance",
                    "quantidade": "10",
                    "dataDevolucao": "10/04/2023"
                },
                {
                    "nome": "Em busca do tempo perdido",
                    "autor": "Marcel Proust",
                    "editora": "Nova fronteira",
                    "descricao": "Em busca do tempo perdido é uma das maiores criações da literatura mundial",
                    "genero": "Romance",
                    "quantidade": "10",
                    "dataDevolucao": "15/04/2023"
                }
            ]
        }
    ]
}
```
3 – Deletar emprestimo do cliente

- API: /Emprestimo
- End Point URL Path:  /emprestimo/devolucao
- Method: DELETE
- Objetivo: deletar todas as informações necessárias de um id_livro que esteja vinculado a um "X" = "id_cliente" no momento da devolucao.
- Descrição: Este método é responsável por deletar um emprestimo de livro.

3.1 - JSON Request de exemplo:
```
{
    "idCliente": 1,
    "idLivro": 2
}
```
4 - Listar todos os livros disponiveis

- API: /emprestimo
- End Point URL Path:  emprestimo/disponivel
- Method: Get
- Objetivo: Consultar na base da API Livros, e retornar apenas os que estiverem o quantidade => que 1. 
- Descrição: Este método é responsável listar todos os livros disponiveis no estoque.
```
{
    "livros": [
        {
            "nome": "Orgulho e preconceito",
            "autor": "Jane Austen",
            "editora": "Camelot Editora",
            "descricao": "É um dos mais aclamados romances da escritora inglesa Jane Austen",
            "genero": "Romance",
            "quantidade": "10"
        },
        {
            "nome": "Em busca do tempo perdido",
            "autor": "Marcel Proust",
            "editora": "Nova fronteira",
            "descricao": "Em busca do tempo perdido é uma das maiores criações da literatura mundial",
            "genero": "Romance",
            "quantidade": "10"
        }
    ]
}

```

5 - Listar todos os livros pendentes de devolução

- API: /emprestimo
- End Point URL Path:  emprestimo/pendente/
- Method: GET
- Objetivo: Listar todos os livros ao qual a data de devolução seja => que hoje.
- Descrição: Este método é responsável listar todos os livros que esteja com a data de devolução vencida.
```
{
    "devolucaoPendente": [
        {
            "nome": "Orgulho e preconceito",
            "autor": "Jane Austen",
            "editora": "Camelot Editora",
            "descricao": "É um dos mais aclamados romances da escritora inglesa Jane Austen",
            "genero": "Romance",
            "quantidade": "10",
            "leitores": [
                {
                    "nome": "Mariana Silva",
                    "contato": "11-94444-4444",
                    "email": "mariana@gmail.com",
                    "dataEmprestimo": "05/04/2023"
                },
            ],
            "dataDevolucao": "10/04/2023"
        },
        {
            "nome": "Em busca do tempo perdido",
            "autor": "Marcel Proust",
            "editora": "Nova fronteira",
            "descricao": "Em busca do tempo perdido é uma das maiores criações da literatura mundial",
            "genero": "Romance",
            "quantidade": "10",
            "leitores": [
                {
                    "nome": "Mariana Silva",
                    "contato": "11-94444-4444",
                    "email": "mariana@gmail.com",
                    "dataEmprestimo": "05/04/2023"
                }
            ],
            "dataDevolucao": "10/04/2023"
        }
    ]
}

```

6 - Listar todos os livros pendentes de devolução de um cliente

- API: /emprestimo
- End Point URL Path:  emprestimo/pendente{id}
- Method: GET
- Objetivo: Listar todos os livros ao qual a data de devolução seja => que hoje de um cleinte especifico.
- Descrição: Este método é responsável listar todos os livros que esteja com a data de devolução vencida de um cliente.

PathParams: cliente_Id (cliente_Id): path param (cliente_Id) value=1
```
{
    "nome": "Mariana Silva",
    "contato": "11-94444-4444",
    "email": "mariana@gmail.com",
    "idade": "18",
    "endereco": "Rua C Bairro V  n° 15, São Paulo - SP",
    "livros": [
        {
            "nome": "Orgulho e preconceito",
            "autor": "Jane Austen",
            "editora": "Camelot Editora",
            "descricao": "É um dos mais aclamados romances da escritora inglesa Jane Austen",
            "genero": "Romance",
            "quantidade": "10",
            "dataDevolucao": "10/04/2023"
        },
        {
            "nome": "Em busca do tempo perdido",
            "autor": "Marcel Proust",
            "editora": "Nova fronteira",
            "descricao": "Em busca do tempo perdido é uma das maiores criações da literatura mundial",
            "genero": "Romance",
            "quantidade": "10",
            "dataDevolucao": "10/04/2023"
        }
    ]
}

```

## Licensing

Para reportar bugs, sugerir novas funcionalidades e melhorias entre em contato com alguns dos membros responsáveis
por este projeto, ou submeta um Pull Request seguindo as práticas e convenções de desenvolvimento desse projeto.
