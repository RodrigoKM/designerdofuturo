(function () {
    'use strict';

    angular
        .module('app')
        .factory('artigosService', artigosService);

    artigosService.$inject = [];
    function artigosService() {
        var service = {
            getArtigos: getArtigos
        }

        return service;

        function getArtigos() {
            return [
                {
                    img: 'img/graffiti.jpg',
                    titulo: 'Baixe Nosso E-Book Grátis',
                    descricao: 'Baixe nosso exclusivo e-book: 50 links para o designer do futuro: da programação ao user experience.',
                    categoria: 'ebook',
                    url: '',
                    botaoDescricao: 'Receber E-Book'
                },
                {
                    img: 'img/bright.jpg',
                    titulo: '5 Dicas de ouro para ser mais criativo',
                    descricao: 'Nossos especialistas do Designer do Futuro elaboraram uma lista com 5 dicas de ouro para que você possa trabalhar sua criatividade.',
                    categoria: 'criatividades',
                    url: 'dicasdeouro',
                    botaoDescricao: 'LEIA MAIS'
                },
                {
                    img: 'img/artigo2.jpg',
                    titulo: 'Designer precisa saber programação?',
                    descricao: 'Nós do Designer do Futuro chegamos a conclusão que seria impossível responder a essa pergunta sem antes termos as respostas de outras perguntas, tão importantes quanto.',
                    categoria: 'design',
                    url: 'saberprogramacao',
                    botaoDescricao: 'LEIA MAIS'
                }
            ]
        }
    }
})();