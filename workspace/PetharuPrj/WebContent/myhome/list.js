window.addEventListener("load", function() {
	let diaryList = document.querySelector(".diary-list");
    let background = document.querySelector(".black-bg");
	let detailSection = document.querySelector(".detail-section");
	let closeBtn = document.querySelector(".close-btn");
	
	diaryList.onclick = function(e) {
		if(!e.target.classList.contains("img-pet") && !e.target.classList.contains("diary-content"))
            return;

		background.classList.remove("d-none");
		detailSection.classList.remove("d-none");
	}
	
	closeBtn.onclick = function() {
		background.classList.add("d-none");
		detailSection.classList.add("d-none");
	}

	
    let modal = document.querySelector(".modal");
    let deleteBtn = document.querySelector(".delete-btn");

    deleteBtn.onclick = function() {
        background.classList.remove("d-none");
        modal.classList.remove("d-none");
		detailSection.style.zIndex = 0;
		background.style.opacity = 0.8;
    };

    modal.onclick = function(e) {
        e.preventDefault();

        if(!e.target.classList.contains("modal-close") && !e.target.classList.contains("close-btn"))
            return;

        background.classList.remove("d-none");
        modal.classList.add("d-none");
    }
});