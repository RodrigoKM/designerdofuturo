(function() {
    'use strict';

    angular
        .module('app')
        .controller('ArtigosController', ArtigosController);

    ArtigosController.$inject = [];
    function ArtigosController() {
        var vm = this;
        vm.img = '';
        vm.titulo ='';
        vm.descricao = '';
        vm.categoria = '';
        vm.url = '';

        activate();

        ////////////////

        function activate() { }
    }
})();