// window가 가지고 있는 구성 요소들이 다 로드가 되었을 때 수행하게 하는 이벤트 속성
window.onload = function() {
    var section = document.getElementById("ex2");
    var xInput = section.getElementsByClassName("x-input")[0];
    var yInput = section.getElementsByClassName("y-input")[0];
    var submitButton = section.getElementsByClassName("submit-button")[0];
    var sum = section.getElementsByClassName("sum")[0];

    submitButton.onclick = function() {
        var result = parseInt(xInput.value) + parseInt(yInput.value);
        sum.innerText = result;
    };
};