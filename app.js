/**
 * Created by BALASUBRAMANIAM on 01-12-2015.
 */
//http://localhost:8080/WebSocketProject/
var webSocket =
    new WebSocket('ws://localhost:8080/WebSocketProject/WebSocket');

webSocket.onerror = function(event) {
    onError(event)
};

webSocket.onopen = function(event) {
    onOpen(event)
};

webSocket.onmessage = function(event) {
    onMessage(event)
};

function onMessage(event) {
    document.getElementById('messages').innerHTML
        += '<br />' + event.data;
    webSocket.send('pushing data..........');
}

function onOpen(event) {
    document.getElementById('messages').innerHTML
        = 'Connection established';
}

function onError(event) {
    alert(event.data);
}

function start() {
    webSocket.send('hello');
    return false;
}