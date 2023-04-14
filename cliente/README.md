## Cadastrar, listar, alterar e deletar  clientes
### Cliente

Resumo Geral do projeto.
Esta API Rest é responsável por gerir toda a entidade cliente.

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
cd clientes
```

### Building

Etapas adicionais para o desenvolvedor construir o projeto após algumas alterações de código e configurações de IDE:

Projeto padronizado de acordo com arquivo ``./resources/swagger.yml``

## Premise


## Configuration



## Deploy and Test

1 – Cadastrar Cliente

- API: Cliente
- End Point URL Path:  /clientes
- Method: POST
- Objetivo: Cadastrar todas as informações necessárias para identificação de um cliente.
- Descrição: Este método é responsável por cadastrar cliente.

1.1 - JSON Request de exemplo:
```
{
    "nome": "Milena Dias",
    "contato": "11-94444-4444",
    "email": "milena@gmail.com",
    "idade": "18",
    "endereco": "Rua A Bairro X  n° 20, São Paulo - SP"
}
```

1.2 - Response de exemplo:
``
201 - CREATED
``

2 – Listar clientes

- API: Cliente
- End Point URL Path:  /clientes
- Method: GET
- Objetivo: retornar lista com todas as informações de todos os clientes.
- Descrição: Este método é responsável por listar todos os clientes.

2.1 - JSON Response de exemplo:
```
{
	"cliente": [
		{
			"nome": "Milena Dias",
			"contato": "11-94444-4444",
			"email": "milena@gmail.com",
			"idade": "18",
			"endereco": "Rua A Bairro X  n° 20, São Paulo - SP"
		},
		{
			"nome": "Joaquim Santos",
			"contato": "11-95555-5555",
			"email": "joaquim@gmail.com",
			"idade": "20",
			"endereco": "Rua C Bairro Z  n° 55, São Paulo - SP"
		}
	]
}
```
3 – Alterar cliente por id
- API: /cliente
- End Point URL Path:  cliente/{id}
- Method: PUT
- Objetivo: Alterar informações especificas de um determinado cliente.
- Descrição: Este método é responsável alterar informações de um determinado id.

3.1 - Parametros Request de exemplo:
```
PathParams: cliente_Id (CDPROD): path param (cliente_Id) value=1
```
3.2 - JSON Request de exemplo:
```
    {
        "nome": "Milena Dias",
        "contato": "11-94444-4444",
        "email": "milena.dias@gmail.com",
        "idade": "18",
        "endereco": "Rua C Bairro V  n° 15, São Paulo - SP"
    }
  ```
  
3.3 - Response de exemplo:
```
201 - CREATED
```
4 – Deletar livro por id
- API: /cliente
- End Point URL Path:  cliente/{id}
- Method: Delete
- Objetivo: deletar informações especificas de um determinado cliente.
- Descrição: Este método é responsável deletar informações de um determinado id.

4.1 - Parametros Request de exemplo:
```
PathParams: cliente_Id (CDPROD): path param (cliente_Id) value=1</br>
```
4.2 - Response de exemplo:
```
{
    "mensagem": "{livro_id} deletado com sucesso!"
}
```
## Licensing

Para reportar bugs, sugerir novas funcionalidades e melhorias entre em contato com alguns dos membros responsáveis
por este projeto, ou submeta um Pull Request seguindo as práticas e convenções de desenvolvimento desse projeto.
