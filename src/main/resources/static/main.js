/**
 *@author Pavel Gavrilov
 * 25.09.2017.
 */

$(document).ready(getDataList());

function getDataList() {
    $.ajax({
        type: "GET",
        cache: false,
        url: '/messages',
        data: "",
        success: setDataList
    });

    console.log($('#submit').prop('click'));
}

function setDataList(response) {
    var html = "";
    console.log(response);
    $.each(response, function (i) {
        var message = response[i];
        //language=HTML
        html = html + "<a class='listItem' href='#' onclick='deleteItem(" + message.id + ")'>" + "<li>" + message.message + "</li>" + "</a>";
    });
    //language=JQuery-CSS
    $('#messages').html(html);
}

function deleteItem(data) {
    $.ajax({
        type: "DELETE",
        cache: false,
        url: '/message' + '?' + $.param({"id": data}),
        headers: {'id': data},
        success: getDataList
    });
    console.log("ID:" + data)
}

$(function () {
    //language=JQuery-CSS
    $('#submit').click(addEntry);
    //language=JQuery-CSS
    $('#data').keypress(function (e) {
        if (e.keyCode === 13) {
    console.log(e.key);
    addEntry();
}
    })
});

function addEntry() {
    var inputField = $('#data');
    $.post('/message', {data: inputField.val()}, getDataList);
    inputField.val("");
}

