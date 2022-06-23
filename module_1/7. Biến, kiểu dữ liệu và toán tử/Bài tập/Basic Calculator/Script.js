// var mot = document.getElementById('mot');
// mot.addEventListener('input', function () {

// })

// var hai = document.getElementById('hai');
// hai.addEventListener('input', function() {

// })

var btncong = document.getElementById('cong');
btncong.addEventListener('click', function () {
    var mot = document.getElementById('mot').value;
    var hai = document.getElementById('hai').value;
    document.getElementById('inra').innerHTML = ('Result Addition = ' + (parseInt(mot) + parseInt(hai)))
})
var btntru = document.getElementById('tru');
btntru.addEventListener('click', function () {
    var mot = document.getElementById('mot').value;
    var hai = document.getElementById('hai').value;
    document.getElementById('inra').innerHTML = ('Result Subtraction = ' + (parseInt(mot) - parseInt(hai)))
})
var btnnhan = document.getElementById('nhan');
btnnhan.addEventListener('click', function () {
    var mot = document.getElementById('mot').value;
    var hai = document.getElementById('hai').value;
    document.getElementById('inra').innerHTML = ('Result Multiplication = ' + (parseInt(mot) * parseInt(hai)))
})
var btnchia = document.getElementById('chia');
btnchia.addEventListener('click', function () {
    var mot = document.getElementById('mot').value;
    var hai = document.getElementById('hai').value;
    document.getElementById('inra').innerHTML = ('Result Division = ' + (parseInt(mot) / parseInt(hai)))
})

