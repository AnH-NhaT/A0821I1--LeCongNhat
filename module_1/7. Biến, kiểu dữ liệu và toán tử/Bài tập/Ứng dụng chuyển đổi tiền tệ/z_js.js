var btn = document.getElementById('btn');
btn.addEventListener('click', function () {
    var from = document.getElementById('from').value
    var to = document.getElementById('to').value
    var ini = document.getElementById('nhap').value
    var resu
    if (from === 'vi' && to === 'us') {
        resu = parseInt(ini) / 23000
        alert('Result = ' + resu + ' USD')
    }
    else if (from === 'us' && to === 'vi') {
        resu = parseInt(ini) * 23000
        alert('Result = ' + resu + ' VND')
    } else {
        alert("let's try select again!")
    }
})