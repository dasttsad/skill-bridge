function modificaCommento(commento){

    document.getElementById("form-modificaCommento").style.display = "block";

    var id = document.getElementById("id");
    var titolo = document.getElementById("titolo");
    var descrizione = document.getElementById("descrizione");

    id.value = commento.getAttribute("data-id");
    titolo.value = commento.getAttribute("data-titolo");
    descrizione.value = commento.getAttribute("data-descrizione");
}

function submitForm(event) {
    event.preventDefault(); 

    document.getElementById("form-modificaCommento").submit(); 
}    


function chiudiFormModifica(){
    var form = document.getElementById("form-modificaCommento");

    form.style.display = "block"; 

    document.getElementById("id").value = "";
    document.getElementById("titolo").value = "";
    document.getElementById("descrizione").value = "";
}