window.addEventListener("load", function() {
    var section = document.querySelector("#ex5");

    var container = section.querySelector(".container");
    var btnAdd = section.querySelectorAll(".btn")[0];
    var btnDel = section.querySelectorAll(".btn")[1];
    var btnClone = section.querySelectorAll(".btn")[2];

    btnAdd.onclick = function() {
        // 메모리에 없는 객체를 메모리에 추가해보자
        // 1. 엘리먼트 객체 생성하기 -> 생성하는 것은 다큐먼트 객체의 기능
        // var img = document.createElement("img"); /*메모리에는 올라가 있지만 화면에는 나오지 않은 상태*/
        // document.createTextNode();
        var box = document.createElement("div");

        // 2. 엘리먼트 객체의 속성 설정하기
        // img.src = "../images/1.jpg"
        box.style.width = "100px";
        box.style.height = "100px";
        box.style.backgroundColor = "rgb(252, 226, 81)";
        box.style.borderRadius = "50px";

        // 3. 엘리먼트 객체를 문서에 추가하기 -> 메모리 상에 존재하는 것이 화면에 출력됨
        // container.appendChild(img); 
        container.appendChild(box);
    };

    btnDel.onclick = function() {
        console.log("Test");
    };

    btnClone.onclick = function() {
        console.log("Test");
    };
});

// ------------------------------------------------------------------------

window.addEventListener("load", function() {
    var section = document.querySelector("#ex4");
    var span = section.querySelector(".container");
    var boxes = section.querySelectorAll(".box");
    var button = section.querySelector("input[value=click]");
    
    // 이전에는 css에서 초기화된 값을 자바스크립트로 얻을 수 없었음
    button.onclick = function() {
        var box = boxes[0];
        let boxStyle = window.getComputedStyle(box);
        var left = parseInt(boxStyle.getPropertyValue("left"));

        // 타이머 작동을 멈출 수 있음
        var tid = window.setInterval(function() {
            left++;
            // console.log(left);
            boxes[0].style.left = left + "px";

            if(left == 400)
                clearInterval(tid);
        }, 17);
    };
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