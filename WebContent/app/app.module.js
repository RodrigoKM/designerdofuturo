(function () {
    'use strict';

    angular.module('app', [
        'ui.router'
    ])
        .run(function ($transitions) {
            $transitions.onSuccess({}, function () {
                document.body.scrollTop = document.documentElement.scrollTop = 0;
            });
        });
})();