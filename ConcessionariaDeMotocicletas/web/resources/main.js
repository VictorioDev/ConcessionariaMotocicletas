$(document).ready( function() {
    
    $(document).on('click', '.btn-red', function( e ) {
        if( $(this).text().indexOf("Remover") === -1 ) return;
        
        e.preventDefault();
        
        var url = $(this).prop('href');
        
        swal({
            title: 'Atenção!',
            text: 'Deseja realmente remover?',
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "Não, cancelar",
            confirmButtonText: 'Sim, remover!',
            closeOnConfirm: false,
            showLoaderOnConfirm: true
        }, function( confirmed ) {
            if( confirmed ) window.location.href = url;
            
            return;
        });
    });
});