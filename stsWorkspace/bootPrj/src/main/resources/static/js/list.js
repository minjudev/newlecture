// window가 가지고 있는 구성 요소들이 다 로드가 되었을 때 수행하게 하는 이벤트 속성
window.onload = function() {
    var asideTitle = document.getElementById("aside-title");
    var a1 = document.getElementById("a1");

    asideTitle.onclick = function() {
        var x = prompt('x 값을 입력하세요', 0);
        var y = prompt('y 값을 입력하세요', 0);
        
        x = parseInt(x);
        y = parseInt(y);
        asideTitle.innerText = x+y;
        a1.value = x+y;
    };
};
