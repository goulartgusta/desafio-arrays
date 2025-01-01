
## **Visão Geral do Projeto**
Este projeto consiste na implementação de diversas estruturas e funcionalidades relacionadas a arrays e coleções em Java. O objetivo é explorar o uso de arrays e suas limitações, criar classes específicas para manipulação de dados, implementar funcionalidades comuns de coleções (como listas, mapas e conjuntos) e garantir que todo o código esteja devidamente testado e coberto por ferramentas de análise.

---

### **Etapa 1: Testes com Arrays Comuns**
Criar e testar arrays explorando todas as possibilidades e limitações da estrutura. O foco está em:
- Demonstrar como criar arrays em diferentes cenários.
- Testar operações permitidas, como acesso, modificação e iteração.
- Identificar limitações, como tamanho fixo e falta de métodos utilitários.

### **Etapa 2: Classes Model e Arrays Específicos**
1. Criar as classes:
   - **Pessoa**, **Bicicleta** e **Carro**, todas estendendo a classe base `Model`.
   - Cada uma dessas classes deve conter 3 atributos.
2. Criar as classes específicas para manipulação:
   - **ArrayPessoa**, **ArrayBicicleta** e **ArrayCarro**, todas estendendo a classe base `Array`.
   - A classe `Array` terá métodos genéricos.

### **Etapa 3: Métodos da Classe Array**
A classe `Array` deve implementar os seguintes métodos:
- **`inserir(Model model)`**: Inserir um objeto no array.
- **`remover(Model model)`**: Remover um objeto do array.
- **`pesquisar(Model model)`**: Pesquisar um objeto no array.
- **`ordenarPorIdCrescente(int id)`**: Ordenar os objetos pelo ID em ordem crescente.
- **`ordenarPorIdDecrescente(int id)`**: Ordenar os objetos pelo ID em ordem decrescente.
- **`atualizar(Model model)`**: Atualizar um objeto existente no array.

### **Etapa 4: Interfaces e Classes de Coleções**
1. Criar as implementações:
   - **MyList**: Implementação personalizada de uma lista.
   - **MyMap**: Implementação personalizada de um mapa.
   - **MySet**: Implementação personalizada de um conjunto.
2. Garantir que as classes sejam amplamente testadas, cobrindo:
   - Adição, remoção, busca, iteração e outras operações.

---

## Requisitos e Observações

- **Testes Unitários:**
  - Utilizar **JUnit** para garantir 100% de cobertura nos testes.
  - Testar todos os cenários possíveis, incluindo casos de erro (exceções).

- **Ferramentas de Qualidade:**
  - Utilizar o **EclEmma** para verificar a cobertura de testes.
  - Usar o **SonarLint** para garantir a qualidade do código e evitar problemas de manutenção.

- **Levantamento de Exceções:**
  - Implementar exceções específicas para cenários como remoção de elementos inexistentes ou acesso a índices inválidos.

---

## Organização dos Arquivos

### Estrutura de Pacotes
```
br.com.almaviva.desafio.array.etapa1  // Testes com arrays comuns
br.com.almaviva.desafio.array.etapa2  // Classes Model e Arrays específicos
br.com.almaviva.desafio.array.etapa3  // Implementação da classe Array e seus métodos
br.com.almaviva.desafio.array.etapa4  // Implementação de MyList, MyMap e MySet
```

### Classes Principais
- **Etapa 1:** Arquivos de teste explorando arrays comuns.
- **Etapa 2:**
  - `Model`
  - `Pessoa`, `Bicicleta`, `Carro`
  - `ArrayPessoa`, `ArrayBicicleta`, `ArrayCarro`
- **Etapa 3:**
  - `Array` com métodos genéricos.
- **Etapa 4:**
  - `List`, `Map`, `Set` (interfaces)
  - `MyList`, `MyMap`, `MySet` (implementações personalizadas)

### Testes
Todos os testes estarão no pacote correspondente, seguindo a convenção:
```
br.com.almaviva.desafio.array.etapaX.tests
```

