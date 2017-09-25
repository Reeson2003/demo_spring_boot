/**
 * Created by Николай Новиков on 25.09.2017.
 */

$(document).ready(setDataList());

function setDataList() {
    $.ajax({
        type: "GET",
        cache: false,
        url: '/messages',
        data: "",
        success: function (response) {
            var html = "";
            console.log(response);
            $.each(response, function (i) {
                var message = response[i];
                html = html + "<li>" + message.message + "<li/>";
            });
            $('#messages').html(html);
        }
    });
}

$('#submit').click(function () {
    alert("Clicked");
})