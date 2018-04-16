'use strict';
var $$ = function (selector) {
    return document.querySelector(selector);
};


$$('#input-ra').onkeypress = function (e) {
    let letra = e.charCode;
    if (!(letra >= 48 && letra <= 57)) {
        e.preventDefault();
    }
};

$$('#input-ra').onblur = function () {
    if (!(this.value)) {
        this.style.borderColor = 'red';
        $$('.div-ra').innerHTML = 'Preencha o campo RA.';
    } else {
        this.style.borderColor = 'green';
        $$('.div-ra').innerHTML = '';
    }
};

$$('#input-nome').onkeypress = function (e) {
    let letra = e.charCode;
    if (!(letra >= 97 && letra <= 122 || letra >= 65 && letra <= 90)) {
        e.preventDefault();
    }
};

$$('#input-nome').onblur = function () {
    if (!(this.value)) {
        this.style.borderColor = 'red';
        $$('.div-nome').innerHTML = 'Preencha o campo NOME.';
    } else {
        this.style.borderColor = 'green';
        $$('.div-nome').innerHTML = '';
    }
};





var ALUNOS = [],
    DISCIPLINAS = [],
    i = 0;


function Aluno(ra, nome) {
    this.ra = ra;
    this.nome = nome;
    this.diciplinas = [];
}

var disciplina = {
    nome: ''
};


var limpaVetor = function limpaVetor() {
    for (let i = 0; i < DISCIPLINAS.length; i++) {
        DISCIPLINAS.pop();
        DISCIPLINAS.shift();
    }
};


var imprime = function imprime() {
    let infoAluno = 'Nome: ' + ALUNOS[i].nome + '.   Ra: ' + ALUNOS[i].ra + '. Matérias: ';
    for (var b in ALUNOS[i].diciplinas) {
        infoAluno += ALUNOS[i].diciplinas[b].nome + '  | ';
    }


    let no = document.createElement('li'),
        text = document.createTextNode(infoAluno);

    no.className = 'list-group-item';
    no.appendChild(text);

    i++;
    $$('#ul-resultado-objetoArray').appendChild(no);
};


$$('#bt-adicionar-disciplina').addEventListener('click', function () {
    if (!($$('#input-disciplina').value)) return;

    let materia = Object.create(disciplina);
    materia.nome = document.forms[0].elements[2].value;
    document.forms[0].elements[2].value = '';
    DISCIPLINAS.push(materia);
});

$$('#bt-cadastrar-aluno').onclick = function () {

    let aluno = new Aluno(document.forms[0].elements[0].value, document.forms[0].elements[1].value);

    for (let i = 0; i < DISCIPLINAS.length; i++) {
        aluno.diciplinas.push(DISCIPLINAS[i]);
    }
    ALUNOS.push(aluno);
    console.log(ALUNOS);

    limpaVetor();
    imprime();
};
