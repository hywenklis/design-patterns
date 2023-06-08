# Factory Method Design Pattern - Direct Mail

Este é um projeto de exemplo que demonstra a implementação do padrão de projeto Factory Method em Java, usando os módulos `directmail-lib` e `directmail-client` para representar uma biblioteca e um cliente que utiliza essa biblioteca, respectivamente.

## Visão Geral

O Factory Method é um padrão de projeto criacional que fornece uma interface para criar objetos, mas permite que as subclasses decidam qual classe instanciar. Neste projeto, o Factory Method é utilizado para criar objetos de diferentes tipos de contatos (CSV e XML) para enviar e-mails através do módulo DirectMail.

Aqui está a estrutura do projeto:

- `directmail-lib`:
    - `Contact`: Classe que representa um contato, contendo nome e e-mail.
    - `Contacts`: Interface que define o contrato para obter uma lista de contatos.
    - `DirectMail`: Classe abstrata que contém a lógica principal para enviar e-mails e declara o método `createContacts()`, que é implementado pelas subclasses para criar diferentes tipos de contatos.

- `directmail-client`:
    - `ContactsCSV`: Classe que implementa a interface `Contacts` e é responsável por obter uma lista de contatos a partir de um arquivo CSV.
    - `ContactsXML`: Classe que implementa a interface `Contacts` e é responsável por obter uma lista de contatos a partir de um arquivo XML.
    - `DirectMailCSV`: Subclasse de `DirectMail` que implementa o método `createContacts()` e cria uma instância de `ContactsCSV`.
    - `DirectMailXML`: Subclasse de `DirectMail` que implementa o método `createContacts()` e cria uma instância de `ContactsXML`.
    - `ClientRelationshipCSV`: Classe de exemplo que utiliza `DirectMailCSV` para enviar e-mails a partir de um arquivo CSV.
    - `ClientRelationshipXML`: Classe de exemplo que utiliza `DirectMailXML` para enviar e-mails a partir de um arquivo XML.

## Como Utilizar

Para utilizar o padrão Factory Method neste projeto, siga os passos abaixo:

1. Clone este repositório em sua máquina local.
2. Importe os projetos `directmail-lib` e `directmail-client` em sua IDE Java.
3. Certifique-se de ter as dependências corretas configuradas em cada projeto.
4. Execute o arquivo `ClientRelationshipCSV.java` ou `ClientRelationshipXML.java` para enviar e-mails a partir de um arquivo CSV ou XML, respectivamente.

## Exemplo

Aqui está um exemplo de código que demonstra como utilizar o Factory Method neste projeto:

```java
DirectMail directMail = new DirectMailCSV("contacts.csv");

String message = JOptionPane.showInputDialog(null, "Digite a mensagem de e-mail:");
boolean status = directMail.sendEmail(message);

JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);

```
Certifique-se de substituir os nomes dos arquivos e fornecer os arquivos CSV/XML corretos para cada exemplo.

## Diagrama de classe:

<div align="center">
<img src="https://github.com/hywenklis/design-patterns/blob/main/factorymethod/factory-method.drawio.png" /> <div/> 