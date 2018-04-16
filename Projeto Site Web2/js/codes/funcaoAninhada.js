 'use strict';
 var funcCachorro = function funcCachorro(nome) {
     nome = document.getElementById('texto_aninhada').value;

     function barulho(nome) {
         return nome + ' late!';
     }
     document.getElementById('resultado_aninhada').innerHTML = (barulho(nome));
 };

 document.getElementById('bt_aninhada').onclick = funcCachorro;
