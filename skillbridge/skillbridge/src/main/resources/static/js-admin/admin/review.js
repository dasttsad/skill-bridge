function modificaRecensione(button) {
    // prendo i dati dal bottone    
    document.getElementById("form-modifica").hidden = false;

    document.getElementById("id").value = button.getAttribute("modifica-id");
    document.getElementById("testo").value = button.getAttribute("modifica-testo");
    document.getElementById("voto").value = button.getAttribute("modifica-voto");
    document.getElementById("immagine").value = button.getAttribute("modifica-immagine");

    // Mostra il form di modifica
}