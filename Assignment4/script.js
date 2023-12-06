document.addEventListener('DOMContentLoaded', () => {
    const apiKey = "tOZt0d3AbZz2vw3tQdFhKyGFAci4HsW4OVoX18Sqa9QzEs74fy68xrCL";
    const input = document.querySelector(".input");
    const searchBtn = document.querySelector(".search-btn");
    const displayImages = document.querySelector(".display-images");

    let pageNum = 1;
    let searchTerm = "";
    let search = false;

    input.addEventListener("input", (event) => {
        event.preventDefault();
        searchTerm = event.target.value;
    });

    searchBtn.addEventListener("click", () => {
        if (input.value === "") {
            alert("Please enter some text");
            return;
        }
        clearGallery();
        search = true;
        searchPhotos(searchTerm, pageNum);
    });

    function clearGallery() {
        displayImages.innerHTML = "";
        pageNum = 1;
    }

    async function fetchPhotos(url) {
        const response = await fetch(url, {
            method: "GET",
            headers: {
                Accept: "application/json",
                Authorization: apiKey,
            },
        });
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    }

    function displayPhotos(photos) {
        photos.forEach((image) => {
            const photo = document.createElement("div");
            photo.innerHTML = `
                <img src=${image.src.large} alt="Photo by ${image.photographer}">
                <figcaption> Photo By: ${image.photographer}📸</figcaption>`;
            displayImages.appendChild(photo);
        });
    }

    async function searchPhotos(query, pageNum) {
        try {
            const url = `https://api.pexels.com/v1/search?query=${query}&page=${pageNum}`;
            const data = await fetchPhotos(url);
            displayPhotos(data.photos);
        } catch (error) {
            console.error("Error searching for images:", error);
        }
    }

    // Infinite Scroll
    window.addEventListener("scroll", () => {
        const { scrollTop, scrollHeight, clientHeight } = document.documentElement;

        if (scrollTop + clientHeight >= scrollHeight - 10) {
            if (!search) {
                pageNum++;
                searchPhotos("curated", pageNum);
            } else {
                if (searchTerm === "") return;
                pageNum++;
                searchPhotos(searchTerm, pageNum);
            }
        }
    });

    // Initial load of curated photos
    searchPhotos("curated", pageNum);
});
