(function () {
    'use strict';

    angular
        .module('app')
        .controller('ArtigosController', ArtigosController);

    ArtigosController.$inject = ['artigosService', '$stateParams'];

    function ArtigosController(artigosService, $stateParams) {
        var vm = this;

        activate();

        ////////////////

        function activate() {
            var params = $stateParams.categoria;
            if (params) {
                vm.categoria = { categoria: params };
            }
            vm.artigos = artigosService.getArtigos();
        }
    }
})();