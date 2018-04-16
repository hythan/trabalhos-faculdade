var array = [];
array = ['Curitiba', 'São Paulo', 123, 'Paraná', array];
array = array.join('<br>');

(function () {
    'use strict';
    document.getElementById('resultado_array').innerHTML = array;
})();
