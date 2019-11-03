#language: pt

Funcionalidade: Fluxo de compra
  Como um usuário do sistema
  Eu quero adicionar produtos ao carrinho de compras
  Para que eu possa realizar uma compra

  Cenario: Buscar produto
    Dado que estou na página inicial do sistema
    Quando busco por um produto
    Então o retorno da busca mostra o produto

  Cenario: Acessar página de um produto
    Dado que estou na tela com os resultados de uma busca
    Quando clico em um produto
    Então sou enviado para a tela do produto

  Cenario: Adicionar produto ao carrinho
    Dado que estou na página de um produto
    Quando clico em adicionar produto ao carrinho de compras
    Então o produto é adicionado no carrinho de compras