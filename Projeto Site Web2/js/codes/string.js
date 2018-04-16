'use strict';
var $$ = function (selector) {
    return document.querySelector(selector);
};


let $$$ = function (id) {
    return document.getElementById(id);
};

var stringToUpper = function stringToUpper() {
    let palavra = $$('#input-palavra').value;
    palavra = palavra.toUpperCase();

    sessionStorage.setItem('palavraUpper', palavra);

    $$('#input-palavra').value = '';

};

var stringToLower = function () {
    let palavra = $$$('input-palavra').value;
    palavra = palavra.toLowerCase();

    sessionStorage.setItem('palavraLower', palavra);

    $$('#input-palavra').value = '';
};

var visualizarUpper = function () {

    $$('#resultado-stringUpper').value = sessionStorage.getItem('palavraUpper');
    return $$('#resultado-stringUpper').value;
};

var visualizarLower = function () {
    $$('#resultado-stringLower').value = sessionStorage.getItem('palavraLower');
    return $$('#resultado-stringLower').value;
};
