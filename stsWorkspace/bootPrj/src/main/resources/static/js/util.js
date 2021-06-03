function slideIn(selector) {
    var screen = document.createElement("div");
    var aside = document.querySelector(selector);

    screen.style.position = "fixed"; /*absolute가 아닌 fixed로 변경*/
    screen.style.left = "0px";
    screen.style.top = "0px";

    screen.style.width = "100%";
    screen.style.height = "100%";
    screen.style.backgroundColor = "black";
    screen.style.opacity = 0;
    screen.style.transition = ".5s"; /*0.5초 동안 바뀜*/

    setTimeout(function() { /*setTimeout을 하지 않았을 때는 opacity = 0 다음에 opacity = 0.7이 덮어씌워져서 적용됨*/
                            /*opacity = 0과 opacity = 0.7이 동시에 적용되지 않게 하기*/           
        screen.style.opacity = 0.7;
    }, 0);
    
    document.body.append(screen);


    screen.ontransitionend = function() { // screen의 transition이 끝난 후 아래 이벤트 시작하게 하기

        aside.style.position = "fixed"; // position이 static이 아닌 절대 위치에 있는 요소들끼리는 z축이 존재
        aside.style.left = "100%";
        aside.style.top = "0px";

        aside.style.width = "70%";
        aside.style.height = "100%";
        aside.style.zIndex = 10;
        aside.style.backgroundColor = "gold";
        aside.style.transition = ".5s"; /*0.5초 동안 바뀜*/

        setTimeout(function() {
            aside.style.left = "30%"
        }, 0);
    }

    screen.onclick = function() {
        // 역방향으로 슬라이드 되도록 애니메이션을 설정        
        aside.style = "";
        screen.remove();

        // aside.style.left = "100%";
        
        // aside.ontransitionend = function() {
        //     aside.style.transition = "none";
        //     aside.style.height = "initial";
        //     aside.style.position = "static";
        //     aside.style.backgroundColor = "initial";
        //     screen.style.backgroundColor = "initial";
        // }
    }
}