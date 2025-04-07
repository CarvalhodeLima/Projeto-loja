 Grupo: Felipe Bezerra, Claudio Gabriel


# Loja Virtual - Projeto em Java

Este é um sistema de loja virtual simples desenvolvido em Java, com funcionalidades básicas de administração, compras e gerenciamento de produtos. O projeto simula o funcionamento de uma loja, e permite o cadastro de produtos criação de clientes, e realizar pedidos.

## Estrutura

O sistema é dividido em pacotes organizados:

- `entidades`: Engloba as Classses do sistema (Produto, Cliente, Pedido, etc.).
- `repositorios`: Armazenar e recuperar dados simulando um nível de persistência.
- `servicos`: Regras de negócio e operações principais.
- `menu`: Interfaces de navegação para o cliente e administrador por um terminal.
- `Main.java`: Ponto de entrada do sistema, inicializando repositórios e serviços. Menu Inicial.

---

## Funcionalidades

- **Administrador**
  - Cadastro e gerenciamento de produtos
  - Visualização de pedidos realizados

- **Cliente**
  - Cadastro de conta
  - Visualização e compra de produtos
  - Carrinho de compras
  - Finalização de pedidos

---

##  Como rodar

### Requisitos:
- Java 8 ou superior
- IDE como Eclipse, IntelliJ IDEA, etc.

### Execução:
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/kabum1.git
