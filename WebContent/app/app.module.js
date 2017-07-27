(function () {
    'use strict';

    angular.module('app', [
        'ui.router'
    ])
        .run(function ($transitions) {
            $transitions.onSuccess({}, function () {
                $("html, body").animate({ scrollTop: 0 }, 600);
                //document.body.scrollTop = document.documentElement.scrollTop = 0;
            });
        });
})();