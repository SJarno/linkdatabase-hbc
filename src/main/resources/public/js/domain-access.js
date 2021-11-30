const url = contextRoot;

/*Load all images, public path:  */
async function loadLinks(className, modifyTrue) {
    const response = await fetch(url + "links", {
        headers: {
            "Accept": "application/json"
        }
    });

    const links = await response.json();
    addLinkToElement(links, className, modifyTrue);

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
async function addLinkToElement(data, className, modifyTrue) {
    data.forEach(link => {
        createCard(link, className, modifyTrue);
    });


};

const createCard = async (link, className, modifyTrue) => {
    console.log(modifyTrue);
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
    /* Elements for modify button */
    if (modifyTrue) {
        
        const breakElement = document.createElement("br");
        const inputElement = document.createElement("button");
        inputElement.innerHTML = "Modify";
        inputElement.id = "modify-addlink-button";

        const modalDiv = createModal(link, inputElement);
        divCardContainer.appendChild(breakElement);
        divCardContainer.appendChild(inputElement);
        divCardContainer.appendChild(modalDiv);
    }


    divCard.appendChild(divCardContainer);
    /* Add link info to card */
    document.getElementById("links").appendChild(divCard);

};

var modal = document.getElementById("myModal");
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

const createModal = (link, inputElement) => {
    /* Element for modal */
    const modalDiv = document.createElement("div");
    modalDiv.className = "modal";
    modalDiv.id = "myModal";

    const modalContent = document.createElement("form");
    modalContent.className = "modal-content";
    modalContent.method = "post";
    /* modalContent.action = "/update-link/"+link.id; */
    /* modalContent.setAttribute("th:action", `@{/update-link/${link.id}}`); */

    const tableElement = createTable(link, modalDiv);
    

    inputElement.onclick = function () {
        modalDiv.style.display = "block";
    }
    
    const modal = document.getElementById("myModal");
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }


    modalContent.appendChild(tableElement);
    modalDiv.appendChild(modalContent);

    return modalDiv;
};

const createTable = (link, modalDiv) => {
    const table = document.createElement("table");
    /* Elements for heading: */
    const tableHead = document.createElement("thead");
    tableHead.className = "modal-header";
    
    const theadTr = document.createElement("tr");

    const modalTitle = document.createElement("h2");
    modalTitle.innerHTML = "Modifying: " + link.title;


    const spanElement = document.createElement("span");
    spanElement.className = "close";
    spanElement.innerText = "X";
    spanElement.onclick = function () {
        modalDiv.style.display = "none";
    }
    /* Elements for body: */
    const tableBody = document.createElement("tbody");
    tableBody.className = "modal-body";
    /* Modify title: */
    const trForTitle = document.createElement("tr");
    const tdForTitleLabel = document.createElement("td");
    const tdForTitleInput = document.createElement("td");
    const labelForTitle = document.createElement("label");
    labelForTitle.innerText = "Modify title: "+link.title;
    const inputForTitle = document.createElement("input");
    inputForTitle.type = "text";

    tdForTitleLabel.appendChild(labelForTitle);
    tdForTitleInput.appendChild(inputForTitle);
    trForTitle.appendChild(tdForTitleLabel);
    trForTitle.appendChild(tdForTitleInput)
    

    /* Modify description */
    const trForDesc = document.createElement("tr");
    const tdForDescLabel = document.createElement("td");
    const tdForDescInput = document.createElement("td");
    const labelForDesc = document.createElement("label");
    labelForDesc.innerText = "Modify description: "+link.description;
    const inputForDesc = document.createElement("input");
    inputForDesc.type = "text";

    tdForDescLabel.appendChild(labelForDesc);
    tdForDescInput.appendChild(inputForDesc);
    trForDesc.appendChild(tdForDescLabel);
    trForDesc.appendChild(tdForDescInput);

    /* Modify tag */

    /* Modify link */
    
    tableBody.appendChild(trForTitle);
    tableBody.appendChild(trForDesc);
    /* Elements for footer: */
    const tableFooter = document.createElement("tfooter");
    tableFooter.className = "modal-footer";
    const rowForInput = document.createElement("tr");
    const dataForInput = document.createElement("td");
    const submitInput = document.createElement("input");
    submitInput.type = "submit";
    submitInput.value = "Modify";

    dataForInput.appendChild(submitInput);
    rowForInput.appendChild(dataForInput);
    tableFooter.appendChild(rowForInput);

    tableHead.appendChild(spanElement);
    theadTr.appendChild(modalTitle);
    
    tableHead.appendChild(theadTr);
    table.appendChild(tableHead);
    table.appendChild(tableBody);
    table.appendChild(tableFooter);
    return table;

};
