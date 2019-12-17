$(document).ready(
    function () {
        $('#productTable').DataTable({
            "searching": true,
            "lengthChange": false,
            "pagingType": "full_numbers"
        });
        $('#cartTable').DataTable({
            "searching": false,
            "lengthChange": false,
            "pagingType": "full_numbers"
        });
    });