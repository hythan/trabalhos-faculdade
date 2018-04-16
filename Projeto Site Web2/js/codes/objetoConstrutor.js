 'use strict';
 let Pessoa = function (nome, sobrenome, email) {
     this.nome = nome;
     this.sobrenome = sobrenome;
     this.email = email;
     this.imprime = 'Nome da pessoa: ' +
         this.nome + '<br>Sobrenome: ' + this.sobrenome + '<br>Email: ' + this.email;
 };

 let pai = {
     nome: 'Pedro',
     sobrenome: 'Pato',
     email: 'pedro_pato@gmail.com',
     imprime: function () {
         return 'Nome da pessoa: ' + this.nome + '<br>Sobrenome: ' +
             this.sobrenome + '<br>Email: ' + this.email;
     }
 };

 let filho = Object.create(pai);
 filho.nome = 'Augusto';
 filho.email = 'augustopato123@gmail.com';

 (function () {
     var pessoa = new Pessoa('João', 'Souza', 'joão_123@gmail.com');
     document.getElementById('resultado-func-contrutora').innerHTML = pessoa.imprime;
     document.querySelector('#resultado-func-literal').innerHTML = filho.imprime();
 })();
