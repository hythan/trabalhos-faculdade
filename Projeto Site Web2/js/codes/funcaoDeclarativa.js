var nomeDaFuncao = function nomeDaFuncao(a, b) {
    'use strict';
    a = window.prompt('Abrirei uma jenela para voce digitar algo.');
    b = 12;

    document.getElementById('resultado_funcaoNormal').innerHTML = 'a= ' + a + '<br>b= ' + b;
};

document.getElementById('bt_funcaoNormal').onclick = nomeDaFuncao;
