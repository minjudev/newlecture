window.addEventListener("load", function() {
	const section = document.querySelector("#dnd-section");
	const uploadBox = section.querySelector(".upload-box");
	const progressStatusDiv = document.querySelector(".progress-status");
	const fileInput = document.querySelectorAll(".form input[type='file']")[0];
	
	fileInput.oninput = function(e) { // 파일 등록버튼 선택
		let file = fileInput.files[0]; // 파일에 대한 정보만 가져온 상태
		if(file.type.indexOf("image/") < 0)
			alert("이미지 형식만 사용할 수 있습니다");
		console.log(file);
			
		// 선택된 파일을 메모리에 올릴 수 있음, 로컬에 파일 로드 가능
		// 웹(원격)이라는 브라우저는 로컬의 문서에 접근하지 못함
		var reader = new FileReader(); // 파일 읽어오기 가능, Reader 하나당 파일 하나 읽기 가능
		reader.onload = function(evt) { // 아직 원격에 올라간 거 아닌데도 웹에서 이미지 보기 가능
			let img = document.createElement("img");
			img.src = evt.target.result; 	
			fileInput.insertAdjacentElement("afterend", img);
		}
	
		reader.readAsDataURL(file); // 비동기로 읽어옴, 위 코드가 바로 진행되지 않게 onload 이벤트에 넣어주기	
	}
	
	uploadBox.ondragenter = function(e) {
		console.log("enter");
	};
	
	uploadBox.ondragleave = function(e) {
		console.log("leave");
	};
	
	uploadBox.ondragover = function(e) {
		e.preventDefault();
		let dt = e.dataTransfer;
		
		var valid = dt.types.indexOf("Files") >= 0;
		if(valid) {
			uploadBox.classList.add("valid");			
		} else {
			uploadBox.classList.add("invalid");						
		}
	};
	
	uploadBox.ondrop = function(e) {
		e.preventDefault();
		
		uploadBox.classList.remove("valid");			
		uploadBox.classList.remove("invalid");			

		let dt = e.dataTransfer;
		if(dt.files.length > 1) {
			alert("파일은 1개만 업로드 가능합니다.");
			return;	
		}
		
		if(dt.files[0].size > 500*1024*1024) {
			alert("업로드 가능한 파일 크기를 초과했습니다.");
		}
			
		let formData = new FormData(); // 추가되는 데이터마다 파트가 나눠져서 개별적으로 보내짐
		formData.append("p", "/upload/test");
		formData.append("f", dt.files[0]); // 키값은 name값이라고 생각하기
		
		let request = new XMLHttpRequest();
		request.onload = function() {
			console.log(request.responseText);
			let filePath = request.responseText;
			
			/*let li = `<li>
						<a download href="${filePath}">
							${filePath}
						</a>
					  </li>`;*/
			
			let li = `<li>
						<img style="width: 100px; height: 100px" src="${filePath}">
						<a download href="${filePath}">
							${filePath}
						</a>
					  </li>`;
			
			let ul = progressStatusDiv.lastElementChild;
			ul.insertAdjacentHTML("beforeend", li);	
		};
		
		request.upload.onprogress = function(e) { // request.upload는 진척도 이벤트를 가지고 있음
			console.log(`total: ${e.total}, load: ${e.loaded}`) // e.total: 보내야 할 전체 바이트 수, e.loaded: 올라간 바이트 수
			let status = Math.round(e.loaded*100/e.total) + '%';
			// e.total : 100 = e.loaded : status
			
			let bar = progressStatusDiv.firstElementChild;
			// 진척도 숫자로 나타내기
			bar.firstElementChild.innerText = status;
			// 진척도만큼 너비 증가시키기
			bar.firstElementChild.style.width = status;
		};
		request.open("POST", "/admin/uploader", true);
		request.send(formData);
		
		console.log("drop");
	};
});