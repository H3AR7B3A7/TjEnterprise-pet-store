$(document).ready(
    function () {
        $('#productTable').DataTable({
            "search": true,
            "lengthChange": false,
            "pagingType": "full_numbers"
        });
        $('#cartTable').DataTable({
            // "search": true,
            "lengthChange": false,
            "pagingType": "full_numbers"
        });
    });