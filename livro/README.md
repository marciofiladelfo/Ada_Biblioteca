<img src="./logo.png" alt="logo" style="width:200px;"/>

## Cadastrar, listar, alterar, deletar e gerenciar o estoque dos livros 
> Livros

Resumo Geral do projeto.
Esta API Rest é responsável por gerir toda a entidade livros.

### Getting Started

* Java 11
* Maven
* SpringBoot

### Initial Configuration

Alguns projetos requerem configuração inicial. Esta é a seção onde você documentaria esses requisitos.

## Developing

Aqui está uma breve introdução sobre o que um desenvolvedor deve fazer para começar a desenvolver
o projeto:

```
git clone 
cd livros
```

### Building

Etapas adicionais para o desenvolvedor construir o projeto após algumas alterações de código e configurações de IDE:

Projeto padronizado de acordo com arquivo ``./resources/swagger.yml``

## Premise


## Configuration



## Deploy and Test

1 – Cadastrar livros

- API: /livros
- End Point URL Path:  /livros
- Method: POST
- Objetivo: Cadastrar todas as informações necessárias para identificação de um livro.
- Descrição: Este método é responsável por cadastrar livros

1.1 - JSON Request de exemplo:

{
    "nome": "Orgulho e preconceito",
    "autor": "Jane Austen",
    "editora": "Camelot Editora",
    "descricao": "É um dos mais aclamados romances da escritora inglesa Jane Austen",
    "genero": "Romance",
    "quantidade": "10"
}

2 – Listar livros

- API: /livros
- End Point URL Path:  /livros
- Method: GET
- Objetivo: reotornar lista com todas as informações de todos livro.
- Descrição: Este método é responsável por litar todos os livros

2.1 - JSON Response de exemplo:

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


3 – Alterar livro por id

- API: /livros
- End Point URL Path:  livros/{id}
- Method: PUT
- Objetivo: Alterar informações especificas de um determinado livro.
- Descrição: Este método é responsável alterar informações de um determinado id.

3.1 - Parametros Request de exemplo:

PathParams: livro_Id (CDPROD): path param (livro_Id) value=1</br>

3.2 - JSON Request de exemplo:

{
    "nome": "Orgulho e preconceito",
    "autor": "Jane Austen",
    "editora": "Camelot Editora",
    "descricao": "É um dos mais aclamados romances da escritora inglesa Jane Austen",
    "genero": "Romance",
    "quantidade": "15"
}

4 – Deletar livro por id

- API: /livros
- End Point URL Path:  livros/{id}
- Method: Delete
- Objetivo: deletar informações especificas de um determinado livro.
- Descrição: Este método é responsável deletar informações de um determinado id.

3.1 - Parametros Request de exemplo:

PathParams: livro_Id (CDPROD): path param (livro_Id) value=1</br>

5 – Gerenciar estoque livro por id

- API: /livros
- End Point URL Path:  livros/{id}/estoque
- Method: POST
- Objetivo: Alterar informações de quantidade de um determinado livro buscando pelo id.
- Descrição: Este método é responsável gerenciar estoque de um determinado id, assim que houver emprestimo ou devolutiva do mesmo.

3.1 - Parametros Request de exemplo:

PathParams: livro_Id (CDPROD): path param (livro_Id) value=1</br>
Headers:
- quantidade:		value=1

## Licensing

Para reportar bugs, sugerir novas funcionalidades e melhorias entre em contato com alguns dos membros responsáveis
por este projeto, ou submeta um Pull Request seguindo as práticas e convenções de desenvolvimento desse projeto.
