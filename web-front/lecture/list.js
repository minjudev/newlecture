window.addEventListener("load", function() {
    var header = document.querySelector("#header");
    var menuButton = header.querySelector(".icon-menu");

    menuButton.onclick = function(e) {
        e.preventDefault();  // a 태그 클릭 시 페이지가 새로고침되는 기본 행위를 막기

        // 1. div 태그를 생성해 전체를 가리는 스크린을 만든다.
        var screen = document.createElement("div");
        screen.style.position = "fixed"; /*absolute가 아닌 fixed로 변경*/
        screen.style.left = "0px";
        screen.style.top = "0px";

        screen.style.width = "100%";
        screen.style.height = "100%";
        screen.style.backgroundColor = "black";
        screen.style.opacity = 0;
        screen.style.transition = "2s"; /*2초 동안 바뀜*/

        setTimeout(function() { /*setTimeout을 하지 않았을 때는 opacity = 0 다음에 opacity = 0.7이 덮어씌워져서 적용됨*/
                                /*opacity = 0과 opacity = 0.7이 동시에 적용되지 않게 하기*/           
            screen.style.opacity = 0.7;
        }, 0);
        
        document.body.append(screen);

        var aside = document.createElement("div");

        aside.style.position = "fixed";
        aside.style.left = "375px";
        aside.style.top = "0px";

        aside.style.width = "150px";
        aside.style.height = "100%";
        aside.style.backgroundColor = "gold";
        aside.style.transition = "1s"; /*1초 동안 바뀜*/

        setTimeout(function() {
            aside.style.left = "225px"
        })

        document.body.append(aside);
    }
});