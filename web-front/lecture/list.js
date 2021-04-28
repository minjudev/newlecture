window.addEventListener("load", function() {
    var header = document.querySelector("#header");
    var menuButton = header.querySelector(".icon-menu");

    menuButton.onclick = function(e) {
        e.preventDefault();  // a 태그 클릭 시 페이지가 새로고침되는 기본 행위를 막기

        // 코드 재사용할 수 있도록 함수 만들기
        slideIn("#aside"); 
    };
});