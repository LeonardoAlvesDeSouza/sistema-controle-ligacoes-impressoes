# Sistema de controle das ligações e impressões da Câmara Cidadã
> Status do projeto: Finalizado

> Versão: 1.0 (beta)

> Data de criação: 11/05/2017
<p>Esse sistema é utilizado na recepção da Câmara Municipal no projeto "Câmara Cidadã", que atende a demanda dos cidadãos do município de Espera Feliz - MG.</p>
<p>A função do sistema é registrar os usuários que utilizam do serviço e controlar o volume de impressões e ligações que são realizadas no âmbito do legislativo, tendo como base os relatórios que podem ser gerados através do próprio sistema.</p>
<p>Inicialmente será cadastrado o usuário administrador, aquele que ficará responsável por adicionar pessoas, editar, excluir e administrar todos os serviços, inclusive adicionar novos usuários.</p>
<p>O sistema fará o controle de todas as impressões e ligações realizadas, podendo gerar os relatórios respectivos de cada mês trabalhado.</p>

## Instalação do ambiente JAVA
```
https://www.java.com/pt-BR/download/manual.jsp
```
## Implementação do banco de dados MySQL
```
https://www.alura.com.br/artigos/mysql-do-download-e-instalacao-ate-sua-primeira-tabela
```
***Observação: Não é necessário a criação das tabelas nesse isntante.***

## Dados de conexão
> DRIVER = "com.mysql.jdbc.Driver";

> URL = "jdbc:mysql://localhost:3306/controliga";

> USER = "root";

> PASS = "cmef37463139";

### Configurando as tabelas
Para a inicialização correta do sistema é necessário a criação e inserção das seguintes base de dados e tabelas com seus respectivos nomes no banco de dados MySql:
+ Base de Dados: controliga
+ Tabelas: impressoes + idImpre
