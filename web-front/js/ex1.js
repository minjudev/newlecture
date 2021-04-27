window.addEventListener("load", function() {
    var section = document.querySelector("#ex9");
    
    var uploadBox = section.querySelector(".upload-box");
    var selButton = section.querySelector(".btn-sel");
    var fileButton = section.querySelector(".btn-file");

    uploadBox.ondragenter = function(e) { // drag한 상태에서 enter
        console.log("enter");
    }

    uploadBox.ondragover = function(e) { // over는 drop 존 위에 올라와있다는 의미 
                                         // drop 존 위에 올라와있을 때, file 크기가 업로드 가능한 크기를 초과, 유효한 파일이 아니라는 것 등을 알려줄 수 있는 영역
        e.preventDefault(); 
        console.log("over");
    }

    uploadBox.ondragleave = function(e) { // drag한 상태에서 leave
        console.log("leave");
    }

    uploadBox.ondrop = function(e) { // 파일은 event 객체에 포함되어 있음
        e.preventDefault(); // 링크를 열지 않게 하기 위해 기본 행위 막기
        console.log("drop");
        // e.files[0];
    }


    selButton.onclick = function(e) {
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true, // 이벤트 버블링: true
            'cancelable': true
        });

       fileButton.dispatchEvent(event); // 이벤트 위임 - fileButton에게 이벤트가 발생했다고 알려주는 것: 트리거
    }
});

// ------------------------------------------------------------------------

window.addEventListener("load", function() {
    var section = document.querySelector("#ex8");
    
    var product = section.querySelector(".product");
    product.onclick = function(e) {
        var target = e.target;
        if(!target.classList.contains("up") &&
        !target.classList.contains("down") && 
        !target.classList.contains("current"))
            return;

        if(target.classList.contains("up")) {
            var input = target.parentNode.querySelector("input");
            input.value = parseInt(input.value) + 1;
            // item.previousElementSibling.value = count++;
        } else if(target.classList.contains("down")) {
            var input = target.parentNode.querySelector("input");
            input.value = parseInt(input.value) - 1;
            // item.previousElementSibling.previousElementSibling.value = count--;
        } else if(target.classList.contains("current")) {
            target.parentElement.classList.toggle("current");
        }
    }
});

// ------------------------------------------------------------------------

window.addEventListener("load", function() {
    var section = document.querySelector("#ex7");
    
    var accordion = section.querySelector(".accordion");
    accordion.onclick = function(e) {
        // 1. title이 아니면 return
        if(!e.target.classList.contains("title"))
            return;

        // 2. target 동생의 d-none toggle
        selected = e.target;
        selected.nextElementSibling.classList.toggle("d-none");
    }
});

// ------------------------------------------------------------------------

window.addEventListener("load", function() {
    var section = document.querySelector("#ex6");

    var container = section.querySelector(".container");
    var btnDel = section.querySelector(".btn-del");
    var btnClone = section.querySelector(".btn-clone");
    var btnChange = section.querySelector(".btn-change");

    var selected = null;

    // 클릭 이벤트가 발생하면 부가적으로 전달해주는 데이터(이벤트에 대한 정보가 담겨있는 객체 - 이벤트 객체)가 있음
    container.onclick = function(e) {
        if(!e.target.classList.contains("box"))
            return;

        // console.log(e.target); // 이 때 원을 클릭했으면 컨테이너는 클릭되지 않아야 함, 하지만 컨테이너도 클릭됨 -> 버블링
        if(selected != null && selected != e.target)
            selected.classList.remove("selected");
        
        selected = e.target;
        selected.classList.toggle("selected");

        // if(selected.classList.containe("selected"))
        //     selected.classList.remove("selected");
        // else 
        //     selected.classList.add("selected");
    }

    // var boxes = container.querySelectorAll(".box");
    // Closure : 아우터 영역의 자원이 해제될 수 있게 하는 키를 가지는 함수
    // for(let i=0; i<3; i++) { // for문이 반복될 때마다 함수가 3개 만들어짐
    //     boxes[i].onclick = function() {
    //         selected = boxes[i]; // i는 참조라서 그게 가리키는 값이 3이 됨
    //         // i를 값 변수로 사용할 수 있게 하기 -> let 사용
    //         console.log(selected);
    //         selected.style.backgroundColor = "red";
    //     } 
    // } // 3이라는 값이 i에 있는 채로 계속 존재하게 됨

    btnDel.onclick = function() {
        if(selected != null)
            selected.remove();
    };

});

// ------------------------------------------------------------------------

window.addEventListener("load", function() {
    var section = document.querySelector("#ex5");

    var container = section.querySelector(".container");
    var btnAdd = section.querySelectorAll(".btn")[0];
    var btnDel = section.querySelectorAll(".btn")[1];
    var btnClone = section.querySelectorAll(".btn")[2];
    var btnChange = section.querySelectorAll(".btn")[3];

    var idInput = section.querySelector(".id-input");
    var colorInput = section.querySelector(".color-input");

    btnAdd.onclick = function() {
        // 메모리에 없는 객체를 메모리에 추가해보자
        // 1. 엘리먼트 객체 생성하기 -> 생성하는 것은 다큐먼트 객체의 기능
        // var img = document.createElement("img"); /*메모리에는 올라가 있지만 화면에는 나오지 않은 상태*/
        // document.createTextNode();
        // var txt = document.createTextNode("1");
        var div = document.createElement("div");

        // 2. 엘리먼트 객체의 속성 설정하기
        // img.src = "../images/1.jpg"
        div.style.width = "100px";
        div.style.height = "100px";
        div.style.backgroundColor = colorInput.value;
        div.style.borderRadius = "50px";
        div.style.textAlign = "center";
        div.style.color = "#fff";
        div.style.lineHeight = "100px";
        div.style.fontWeight = "bold";
        
        // div.appendChild("1");
        div.append(idInput.value);

        // 3. 엘리먼트 객체를 문서에 추가하기 -> 메모리 상에 존재하는 것이 화면에 출력됨
        // container.appendChild(img); 
        // container.appendChild(div); // appendChild 사용 시에는 원하는 노드 객체를 직접 1번처럼 만들어야 함
        container.append(div); // append 사용 시에는 텍스트는 2번처럼 바로 추가 가능
        // container.append([div1, div2, div3]); // 노드 객체 여러 개를 한번에 추가 가능
                                                 // json에서 배열 객체를 만드는 방법
    };

    btnDel.onclick = function() {
        var div = container.querySelector("div:first-child");
        div.remove();
        // container.removeChild(div);
    };

    btnClone.onclick = function() {
        var div = container.querySelector("div:first-child");
        var clone = div.cloneNode(true); // 자식까지 복제됨
        // var clone = div.cloneNode(false); // 자식은 복제되지 않음 
        container.append(clone);
    };

    btnChange.onclick = function() {
        // var e = container.querySelectorAll("div");
        // var e1 = e[0];
        // var e2 = e[1];
        var e1 = container.querySelector("div:first-child");
        var e2 = container.querySelector("div:nth-child(2)");
        
        // 1. Detach
        // 2. Replace
        var old = container.replaceChild(e1, e2);

        // 3. insertBefore
        // container.insertBefore(old, e1); -> old version
        e1.insertAdjacentElement('beforebegin', old);
    }
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