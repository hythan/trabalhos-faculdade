'use strict';
window.onload = function () {
    $('#div-homer-bart').hide();
    $('pre').hide();
};

$('#btn-esconda-pai').click(function () {
    $('#div-pai').fadeOut(2000);
});

$('#btn-apresente-pai').click(function () {
    $('#div-pai').fadeIn(2000);
    $('#div-homer-bart').hide();
});

$('#btn-esconda-filho').click(function () {
    $('#div-filho').fadeOut(2000);
});

$('#btn-apresente-filho').click(function () {
    $('#div-filho').fadeIn(2000);
    $('#div-homer-bart').hide();
});

$('#btn-pai-filho').click(function () {
    $('#div-filho').hide();
    $('#div-pai').hide();
    $('#div-homer-bart').fadeIn(4000);
});

$('#btn-mostrar-code').click(function () {
    $('pre').fadeIn();
});

let mousesobre = function mousesobre(){
    $('#btn-paz').text('Não tem como!');
}; 

let mousefora = function mousefora(){
    $('#btn-paz').text('Clique aqui para fazerem as pazes');
};