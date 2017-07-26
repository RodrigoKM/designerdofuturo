(function () {
    $('select').material_select();
    $('.parallax').parallax();
    $('.modal').modal({
        dismissible: true, // Modal can be dismissed by clicking outside of the modal
        opacity: .5, // Opacity of modal background
        inDuration: 300, // Transition in duration
        outDuration: 200, // Transition out duration
        startingTop: '4%', // Starting top style attribute
        endingTop: '10%', // Ending top style attribute
    });

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
        Materialize.toast('Cadastrado com Sucesso! Você receberá o ebook no seu email em até 24 horas.', 5000, 'green');
    }
    else if (status === '2') {
        Materialize.toast('Email já cadastrado!', 5000, 'red');
    }

    $('#modalform').modal('open');
}());

function showModal() {
    $('#modalform').modal('open');
}