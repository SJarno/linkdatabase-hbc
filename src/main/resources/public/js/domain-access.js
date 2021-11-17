const url = contextRoot + "links";

async function loadLinks() {
    const response = await fetch(url, {
        headers: {
            "Accept": "application/json"
        }
    });
    const links = await response.json();
    console.log(links);
    addLinkToElement(links);
};

const addLinkToElement = data => {
    data.forEach(link => {
        const ulElement = document.createElement("ul");
        const listElement = document.createElement("li");
        const headerElement = document.createElement("h3");
        headerElement.innerText = "Title: "+link.title;
        /* Elements for info: */
        const idPara = document.createElement("p");
        const descPara = document.createElement("p");
        const keywordPara = document.createElement("p");
        const urlPara = document.createElement("p");
        idPara.innerText = "Id: "+link.id;
        descPara.innerText = "Description: "+link.description;
        keywordPara.innerText = "Keyword: "+link.keyword;
        urlPara.innerText = "Url: "+link.url;

        /*  */
        listElement.appendChild(headerElement);
        listElement.appendChild(idPara);
        listElement.appendChild(descPara);
        listElement.appendChild(keywordPara);
        listElement.appendChild(urlPara);
        /*  */
        ulElement.appendChild(listElement);
        document.getElementById("links").appendChild(ulElement);
    });


};