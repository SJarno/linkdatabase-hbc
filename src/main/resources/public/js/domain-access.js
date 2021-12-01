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
        removeLinkElements();
        addLinkToElement(links, "md-card");
    }
    /* console.log(url+"links/search/"+tag); */

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
/* const addLinkToElement = (data) => { */
async function addLinkToElement(data, className) {
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
    const hyperlink = document.createElement("a");
    hyperlink.href = link.url;
    hyperlink.innerHTML = "Click to link!";
    hyperlink.target = "_blank";

    divCardContainer.appendChild(headerElement);
    divCardContainer.appendChild(paraDescription);
    divCardContainer.appendChild(paraKey);
    divCardContainer.appendChild(hyperlink);


    divCard.appendChild(divCardContainer);
    /* Add link info to card */
    document.getElementById("links").appendChild(divCard);

};




