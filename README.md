## **Etapa 1:**

- Criar 1 array simples de letra
- 1 array simples de número
- 1 matriz que recebe o array 1 e 2
- Tentar solucionar o problema de uma matriz com letras e números
- Opções:
    - Criar uma classe com meu próprio tipo de array (tentar essa).
    - Criar nossa própria exceção para os problemas da matriz.
- Testar com JUNIT métodos como o que enviarei (pedir detalhes depois) e exceções também.
- Objetivo: array bidimensional fazendo testes de tudo o que pode e não pode fazer com array, a chave é ser criativo, o intuito é provar que sabemos usar o array e tudo que ele pode ou não pode fazer, lidando com 2 tipos numa matriz comum.

---

## **Etapa 2:**

- Teremos as classes Pessoa, Bicicleta e Carro, as 3 extendem da classe Model, Cada uma deve ter 3 atributos (inclusive a Model).
- Não precisa criar construtor, só com os métodos get set ta tudo certo (podemos conversar melhor sobre isso)
- Depois, teremos as classes ArrayPessoa, ArrayBicicleta e ArrayCarro, cada uma extende da classe Array que devemos criar também.

---

## **Etapa 3:**

Devemos criar os métodos da classe Array que usaremos na etapa 2:

- inserir(Model model)
- remover(Model model)
- pesquisar(Model model)
- ordenarPorIdCrescente(int id)
- ordenarPorIdDecrescente(int id)
- atualizar(Model model)

---

## **Etapa 2 + Etapa 3:**

Terá problemas na modelagem, deveremos implementar os métodos da classe array e extendê-los nas classes usando try catch para validarmos o casting de classes, para isso, (importante) precisaremos da nossa própria exceção, devemos ter o try catch, capturar a exceção do java e lançar a nossa

Após tudo implementado, devemos testar cada classe com 100% de coverage.

---

## **Etapa 4:**

Devemos criar as interfaces List, Map e Set, com os métodos PRINCIPAIS (somente o necessário) que essas classes implementam quando usamos elas normalmente.

Então devemos fazer as classes MyList, MyMap, MySet e testar tudo.

---

**Observações importantes:**

- Precisamos ter 100% do nosso código em testes usando JUnit (sem mock).
- É necessário usarmos o Coverage e termos 100% de cobertura em testes (importantíssmo).
- Devemos levantar as exceptions quando formos testar (Importante).
- Devemos considerar o eclema e SonarLint para realizarmos o projeto.
- A CHAVE nesta etapa será na qualidade dos testes, devemos ter comportamentos com eles, como testes realizados aqui: https://github.com/goulartgusta/teste-collection

Outras observações:

- Não usar i nem j nos laços, usar linha e coluna no lugar ou algo parecido.
- Usar o máximo possível de Wrapper no lugar de tipo primitivo.
- Estamos criando arrays do zero, mas podemos usar coisas somente da classe Array/Arrays
