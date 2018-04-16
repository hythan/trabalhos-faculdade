'use strict';
var $$ = function (selector) {
    return document.querySelector(selector);
};

var vetor = [],
    j = 0;

var imprimeVetor = function () {
    vetor.push($$('select').value);
    $$('#pre-resultado-array').innerHTML += vetor[j] + '<br>';

    j++;
};

var limpa = function () {
    $('#pre-resultado-array').html('');
};

$$('#bt-add-vetor').onclick = imprimeVetor;

$$('#bt-limpa-vetor').onclick = limpa;
