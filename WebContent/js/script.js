(function () {
    $('select').material_select();
    $('.parallax').parallax();

    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;

        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');

            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };

    var status = getUrlParameter('status');

    if (status === '1') {
        Materialize.toast('Cadastrado com Sucesso!', 4000, 'green');
    }
    else if(status === '2'){
        Materialize.toast('Email já cadastrado!', 4000, 'red');
    }
}());