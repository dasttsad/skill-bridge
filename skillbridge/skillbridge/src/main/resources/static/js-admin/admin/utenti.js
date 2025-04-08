function modificaUtente(button) {
    // prendo i dati dal bottone    
    document.getElementById("modificaForm").hidden = false;

    document.getElementById("id").value = button.getAttribute("data-modifica-id");
    document.getElementById("nome").value = button.getAttribute("data-modifica-nome");
    document.getElementById("cognome").value = button.getAttribute("data-modifica-cognome");
    document.getElementById("username").value = button.getAttribute("data-modifica-username");
    document.getElementById("password").value = button.getAttribute("data-modifica-password");
    document.getElementById("email").value = button.getAttribute("data-modifica-email");
    document.getElementById("data_di_Nascita").value = button.getAttribute("data-modifica-dob");

    // Mostra il form di modifica
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
    var nome = document.getElementById("data-nome");
    nome.value = "";
    var cognome = document.getElementById("data-cognome");
    cognome.value = "";
    var username = document.getElementById("data-username");
    username.value = "";
    var password = document.getElementById("data-password");
    password.value = "";
    var email = document.getElementById("data-email");
    email.value = ""; 
    var data_di_Nascita = document.getElementById("data-dob");
    data_di_Nascita.value = "";     
}
}