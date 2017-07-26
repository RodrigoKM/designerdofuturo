
(function () {
    'use strict';

    angular
        .module('app')
        .config(configRoutes);

    configRoutes.$inject = ['$stateProvider', '$urlRouterProvider']

    function configRoutes($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('artigos', {
                url: '/artigos',
                templateUrl: 'app/artigos/artigos.html'
            })
            .state('contatos', {
                url: '/contatos',
                templateUrl: 'app/contatos/contatos.html'
            })
            .state('dicasdeouro', {
                url: '/dicas-de-ouro',
                templateUrl: 'app/artigos/conteudos/dicasdeouro.html'
            })
            .state('saberprogramacao', {
                url: '/designer-precisa-saber-programacao',
                templateUrl: 'app/artigos/conteudos/saberprogramacao.html'
            });

        $urlRouterProvider.otherwise('/artigos');
    }
})();