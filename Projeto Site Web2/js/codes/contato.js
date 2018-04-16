'use strict';

var porNome = function (name) {
    return document.getElementsByName(name);
};



window.onload = function () {

    porNome('nome')[0].addEventListener('keypress', function (e) {
        let letra = e.charCode;
        if (!(letra >= 97 && letra <= 122 || letra >= 65 && letra <= 90)) {
            e.preventDefault();
        }
    });

    porNome('sobrenome')[0].addEventListener('keypress', function (e) {
        let letra = e.charCode;
        if (!(letra >= 97 && letra <= 122 || letra >= 65 && letra <= 90)) {
            e.preventDefault();
        }
    });

    $('#email').on('blur', function () {

        if (this.validity.patternMismatch) {
            this.setCustomValidity('Digite um email valido!');
        } else {
            this.setCustomValidity('');
        }
    });
};


let vetorPessoas = [];

var enviarFormulario = function enviarFormulario() {

    let nome = porNome('nome')[0].value;
    let sobrenome = porNome('sobrenome')[0].value;
    let email = porNome('email')[0].value;
    let msg = porNome('mensagem')[0].value;

    let pessoa = {};
    pessoa.nome = nome;
    pessoa.sobrenome = sobrenome;
    pessoa.email = email;
    pessoa.msg = msg;

    let a = localStorage.getItem('pessoa');
    if(a != undefined){
        vetorPessoas = JSON.parse(a);
    }
    
    vetorPessoas.push(pessoa);

    localStorage.setItem('pessoa', JSON.stringify(vetorPessoas));

};
