Requisitos:

1. Um cliente deve ter um saldo disponível para fazer compras na loja.

2. Um cliente pode fazer várias compras, cada uma contendo vários alimentos.

3. Cada compra deve estar associada a um cliente específico.

4. Cada compra deve ter uma data e hora de criação, início e término.

5. Cada alimento deve ter um nome, preço e tipo específico.

6. Os tipos de alimentos disponíveis incluem Legume, Verdura, Laticínio, Fruta e Carne.

7. Cada funcionário deve ter uma senha para acessar o sistema.

Restriçoes e regras de negócio:

1. O campo id de todas as classes deve ser único e não nulo.

2. O campo preco da classe Alimento deve ser um número decimal positivo.

3. Um cliente só pode fazer uma compra se tiver saldo disponível suficiente.

4. Ao fazer uma compra, o saldo disponível do cliente é atualizado com o valor total da compra.

5. A quantidade de alimentos em uma compra deve ser um número inteiro positivo.

6. O endereço de entrega de uma compra deve conter uma rua, número, bairro, cidade e CEP válidos.

7. A data e hora de início de uma compra devem ser anteriores à data e hora de término.

8. A classe Cliente deve ter um método versaldo() que retorna o saldo disponível do cliente.

9. Será permitido alteração futura.

Diagrama de Classe:

![DiagramaDeClasse-LojaDeAlimento](https://github.com/MarcusVynicius1/LojaDeAlimentos/assets/91838315/a0dd4f4f-0b41-4160-8f9e-55362270fca2)

