'use strict';

var anonima = function () {
    let texto = document.getElementById('input-text').value;
    return window.alert(texto);
};

document.getElementById('testeAnonima').onclick = anonima;
