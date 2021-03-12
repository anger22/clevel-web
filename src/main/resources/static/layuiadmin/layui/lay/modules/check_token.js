$(document).ready(function () {
    if (layui.data("layuiAdmin")['token'] == undefined) {
        location.href = '/login';
    }
});

function checkTimeout() {
    layui.data(setter.tableName, {
        key: "token",
        value: undefined
    });
}
window.setInterval(checkTimeout, 43200000);