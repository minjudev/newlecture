window.addEventListener("load", function() {
    var section = document.querySelector("#ex4");
    var span = section.querySelector(".container");
    var boxes = section.querySelectorAll(".box");
    var button = section.querySelector("input[value=click]");
    var box1Left = boxes[0].style.left;
    
    button.onclick = function() {
        window.setInterval(function() {
            box1Left++;
            console.log(box1Left);
            boxes[0].style.left = String(box1Left) + "px";
        }, 17);
    }
});

// ------------------------------------------------------------------------

window.addEventListener("load", function() {
    // var section = document.getElementById("ex3");
    var section = document.querySelector("#ex3");
    var span = section.querySelector(".span");
    var button = section.querySelector(".btn");
    
    button.onclick = function() {
        window.setInterval(function() {
            var num = parseInt(span.innerText);
            num--;
            span.innerText = num;
        }, 1000);
    }
});

// ------------------------------------------------------------------------

// window가 가지고 있는 구성 요소들이 다 로드가 되었을 때 수행하게 하는 이벤트 속성
// onload 함수가 여러 개일 때 모두 실행되게 하기 위해 addEventListener 함수 사용
window.addEventListener("load", function() {
    var section = document.getElementById("ex2");
    var xInput = section.getElementsByClassName("x-input")[0];
    var yInput = section.getElementsByClassName("y-input")[0];
    var submitButton = section.getElementsByClassName("submit-button")[0];
    var sum = section.getElementsByClassName("sum")[0];
    
    submitButton.onclick = function() {
        var result = parseInt(xInput.value) + parseInt(yInput.value);
        sum.innerText = result;
    };
});

// ------------------------------------------------------------------------

window.addEventListener("load", function() {
    var section = document.getElementById("ex1");
    var submitButton = section.getElementsByClassName("submit-button")[0];

    submitButton.onclick = function() {
        console.log("test");
    };
});