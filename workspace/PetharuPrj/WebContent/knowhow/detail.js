window.addEventListener("load", function() {
	
	// 상세 데이터 불러오기
	var knowhowHeader = document.querySelector(".knowhow-header");
	var memberInfo = document.querySelector(".member-info");
	var content = document.querySelector(".write-content");
	
	// list에서 전달받은 노하우 게시글의 아이디를 url에 같이 전달하기
	bind("http://localhost:8080/PetharuPrj/api/knowhow/list");

	function bind(url) {
		var request = new XMLHttpRequest();
		
		request.onload = function() {
			
			var list = JSON.parse(request.responseText);
			
			for(var i=0; i<list.length; i++) {
				var div = 
					`<div>
                        <div class="img-area">
                            <a href="detail.html">
                            <img class="img-pet" src="../images/cat-rest1.jpg">
                            </a>
                        </div>
                        <div class="text-area">
                        	<div class="knowhow-info">
                        		<ul>
                        			<li>
                        				<img src="../images/view.png">
                        				<span>${list[i].hit}</span>
                        			</li>
                        			<li>
                        				<img src="../images/heart.png">
                        				<span>${list[i].like}</span>
                        			</li>
                        			<li>
                        				<img src="../images/comment.png">
                        				<span>3</span>
                        			</li>
                        		</ul>
                        	</div>
                            <div class="knowhow-title"><a href="detail.html">${list[i].title}</a></div>
                            <section class="flex">
                                <div class="img-member"></div>
                                <span class="id">${list[i].userId}</span>
                            </section>
                        </div>
                     </div>`;
				
				knowhowList.insertAdjacentHTML("beforeend", div);
			}
			
		}
		
		request.open("GET", url, true);
		request.send(null);   
	}
	
	// 모달창 띄우기
    var background = document.querySelector(".black-bg");
    var modal = document.querySelector(".modal");
    var deleteBtn = document.querySelector(".delete-btn");

    deleteBtn.onclick = function() {
        background.classList.remove("d-none");
        modal.classList.remove("d-none");
    };

    modal.onclick = function(e) {
        e.preventDefault();

        if(!e.target.classList.contains("modal-close") && !e.target.classList.contains("close-btn"))
            return;

        background.classList.add("d-none");
        modal.classList.add("d-none");
    }
});