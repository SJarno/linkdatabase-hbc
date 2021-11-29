const url = contextRoot;

/*Load all images:  */
async function loadLinks(className) {
    const response = await fetch(url + "links", {
        headers: {
            "Accept": "application/json"
        }
    });

    const links = await response.json();
    addLinkToElement(links, className);
    
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

const createCard = async (link, className) => {
    /* create div element with id/class sm-card-container */
    const divCard = document.createElement("div");
    divCard.className = "card "+className;

    const divCardContainer = document.createElement("div");
    divCardContainer.className = "card-container";


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

    /* Element for modify button */
    /* const inputElement = document.createElement("input");
    inputElement.setAttribute("sec:authorize", "isAuthenticated()");
    inputElement.type = "input"; */

    
    divCardContainer.appendChild(paraDescription);
    divCardContainer.appendChild(paraKey);
    divCardContainer.appendChild(hyperlink);
    divCardContainer.appendChild(inputElement);
    /* divCard.appendChild(divCardContainer); */
    
    /* Add link info to card */
    document.getElementById("links").appendChild(divCard);

};

//window.onload = loadLinks();

