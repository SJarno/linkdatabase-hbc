const url = contextRoot;

/*Load all images, public path:  */
async function loadLinks(className) {
    const response = await fetch(url + "links", {
        headers: {
            "Accept": "application/json"
        }
    });

    const links = await response.json();
    addLinkToElement(links, className);

};

/* Load links by keyword/tag */
async function searchByTag() {
    let tag = document.getElementById("search-input").value;
    if (tag.length === 0) {
        loadLinks("md-card");
    } else {
        const response = await fetch(url + "links/search/" + tag, {
            headers: {
                "Accept": "application/json"
            }
        });
        const links = await response.json();
        addLinkToElement(links, "md-card");
    }


};

/* Load link by id */
async function loadLinkById(id) {
    const response = await fetch(url + "links/" + id, {
        headers: {
            "Accept": "application/json"
        }
    });
    return response.json();
};
/* Place fetched images to page */
async function addLinkToElement(data, className) {
    removeLinkElements();
    data.forEach(link => {
        createCard(link, className);
    });


};

const removeLinkElements = () => {
    const parent = document.getElementById("links");
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
};

const createCard = async (link, className) => {
    /* create div element with id/class sm-card-container */
    const divCard = document.createElement("div");
    divCard.className = "card " + className;
    divCard.addEventListener("click", function (event) {
        console.log("tulostus juu");
        window.open(link.url);
    });
    //divCard.onclick = openLink(link.url);
    /* divCard.onclick = window.open(link.url); */
    /* divCard.onclick = window.location = link.url; */
    

    const divCardContainer = document.createElement("div");
    divCardContainer.className = "card-container";


    /* Create header element for title: */
    const headerElement = document.createElement("h3");
    headerElement.innerText = "Title: " + link.title;


    /* Element for description: */
    const paraDescription = document.createElement("p");
    paraDescription.innerHTML = "Description: " + link.description;

    /* Element for key */
    const paraKey = document.createElement("p");
    paraKey.innerHTML = "Tag: " + link.keyword;

    /* Element for hyperlink */
    /* const hyperlink = document.createElement("a");
    hyperlink.href = link.url;
    hyperlink.innerHTML = "Click to link!";
    hyperlink.target = "_blank"; */
    const paraClick = document.createElement("p");
    paraClick.innerHTML = "Click to go to page!"

    divCardContainer.appendChild(headerElement);
    divCardContainer.appendChild(paraDescription);
    divCardContainer.appendChild(paraKey);
    divCardContainer.appendChild(paraClick);


    divCard.appendChild(divCardContainer);
    /* Add link info to card */
    document.getElementById("links").appendChild(divCard);

};






