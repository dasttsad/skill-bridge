// AGGIUNTO DA ME OGGI

function modificaPost(button) {
     
    // Mostra il form di modifica
    document.getElementById("modificaForm").style.display = "block";
    // prendo i dati dal bottone   
    document.getElementById("Id").value = button.getAttribute("data-id");
    document.getElementById("titolo").value = button.getAttribute("data-titolo");
    document.getElementById("descrizione").value = button.getAttribute("data-descrizione");
    document.getElementById("immagine").value = button.getAttribute("data-immagine");
    document.getElementById("utente_id").value = button.getAttribute("data-utente");

    
    
}