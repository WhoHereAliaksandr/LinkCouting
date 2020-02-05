function addToParsedLinks(link){
    document.getElementsByName("link")[0].value = link.innerHTML;
}

function waitingBox(link){
    if(document.getElementsByName("link")[0].value != "")
        document.getElementById("waitingBox").style.display = "table";
};