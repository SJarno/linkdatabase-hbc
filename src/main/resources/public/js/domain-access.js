const url = contextRoot;

/*Load all images:  */
async function loadLinks() {
    const response = await fetch(url + "links", {
        headers: {
            "Accept": "application/json"
        }
    });

    const links = await response.json();

    addLinkToElement(links);
    return links;
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
async function addLinkToElement(data) {
    data.forEach(link => {
        createSmallCard(link);
    });


};

const createSmallCard = async (link) => {

    /* create div element with id/class sm-card-container */
    const divCard = document.createElement("div");
    divCard.className = "card";

    const divCardContainer = document.createElement("div");
    divCardContainer.className = "sm-card-container";

    /* Create header element for title: */
    const headerElement = document.createElement("h3");
    headerElement.innerText = "Title: " + link.title;
    divCardContainer.appendChild(headerElement);

    /* Element for description: */
    const paraDescription = document.createElement("p");
    paraDescription.innerHTML = "Description: "+link.description;

    /* Element for key */
    const paraKey = document.createElement("p");
    paraKey.innerHTML = "Tag: "+link.keyword;

    /* Element for hyperlink */
    const hyperlink = document.createElement("a");
    hyperlink.href = link.url;
    hyperlink.innerHTML = "Click to link!";
    hyperlink.target = "_blank";

    
    divCardContainer.appendChild(paraDescription);
    divCardContainer.appendChild(paraKey);
    divCardContainer.appendChild(hyperlink);
    divCard.appendChild(divCardContainer);
    
    /* Add link info to card */

    document.getElementById("links").appendChild(divCard);

};

//window.onload = loadLinks();

