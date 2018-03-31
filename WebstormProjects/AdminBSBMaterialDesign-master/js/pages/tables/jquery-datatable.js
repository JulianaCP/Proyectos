$(function () {
    $('.js-basic-example').DataTable({
        responsive: true,
        searching: false,
        sort : false,
        lengthChange: false,
        pageLength: 10,
        info:false
    });

    //Exportable table
    $('.js-exportable').DataTable({
        dom: 'Bfrtip',
        responsive: true,
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    });
});