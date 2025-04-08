function modificaCorso(button) {
     
    // Mostra il form di modifica
    document.getElementById("modificaForm").style.display = "block";
    // prendo i dati dal bottone   
    document.getElementById("Id").value = button.getAttribute("data-id");
    document.getElementById("titolo").value = button.getAttribute("data-titolo");
    document.getElementById("descrizione").value = button.getAttribute("data-descrizione");
    document.getElementById("immagine").value = button.getAttribute("data-immagine");
    document.getElementById("prezzo").value = button.getAttribute("data-prezzo");

    
    
}


// Invia il form 
function submitForm(event) {
    event.preventDefault(); 

    document.getElementById("modificaForm").submit(); 
}    


function chiudiFormModifica(){
    var form = document.getElementById("modificaForm");
    form.hidden = true;
    var id = document.getElementById("data-id");
    id.value = "";
    var titolo = document.getElementById("data-titolo");
    titolo.value = "";
    var descrizione = document.getElementById("data-descrizione");
    descrizione.value = "";
    var immagine = document.getElementById("data-immagine");
    immagine.value = "";
    var prezzo = document.getElementById("data-prezzo");
    prezzo.value = "";    
}



