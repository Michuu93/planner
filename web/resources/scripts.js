// DateTimePicker
var date = new Date();
var today = new Date(date.getFullYear(), date.getMonth(), date.getDate());

$(function () {
    $('#datepicker').datetimepicker({
        locale: 'pl',
        format: 'YYYY-MM-DD',
        minDate: date,
        defaultDate: date,
        showTodayButton: true
    });
});
$(function () {
    $('#timepicker').datetimepicker({
        format: 'HH:mm',
        defaultDate: date,
        showTodayButton: true
    });
});


// Alerts
    $(".alert-dismissible").fadeTo(3000, 500).slideUp(500, function () {
        $(".alert-dismissible").alert('close');
    });