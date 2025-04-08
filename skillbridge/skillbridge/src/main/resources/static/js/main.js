(function ($) {
    "use strict";

    // Initiate the wowjs
    new WOW().init();


    // Sticky Navbar
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.sticky-top').addClass('shadow-sm').css('top', '0px');
        } else {
            $('.sticky-top').removeClass('shadow-sm').css('top', '-100px');
        }
    });

    // Testimonials carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: false,
        smartSpeed: 1000,
        center: true,
        dots: false,
        loop: true,
        nav: true,
        navText: [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsive: {
            0: {
                items: 1
            },
            768: {
                items: 2
            }
        }
    });


})(jQuery);
//menu profilo




//learning card
let activeGroup = null; // Tiene traccia del gruppo attualmente visibile

function toggleGroup(group) {
    const groupElement = document.getElementById('group-' + group);
    const buttonElement = document.getElementById('btn-' + group);

    // Se il gruppo cliccato è già attivo, nascondilo e resetta il pulsante
    if (activeGroup === group) {
        groupElement.classList.add('hidden');
        buttonElement.classList.remove('btn-light');
        buttonElement.classList.add('btn-primary');
        activeGroup = null; // Reset dello stato
    } else {
        // Nasconde tutti i gruppi
        document.getElementById('group-1').classList.add('hidden');
        document.getElementById('group-2').classList.add('hidden');
        document.getElementById('group-3').classList.add('hidden');

        // Rende tutti i pulsanti primary
        document.getElementById('btn-1').classList.remove('btn-light');
        document.getElementById('btn-2').classList.remove('btn-light');
        document.getElementById('btn-3').classList.remove('btn-light');
        document.getElementById('btn-1').classList.add('btn-primary');
        document.getElementById('btn-2').classList.add('btn-primary');
        document.getElementById('btn-3').classList.add('btn-primary');
        // Mostra solo il gruppo selezionato e cambia lo stile del pulsante
        groupElement.classList.remove('hidden');
        buttonElement.classList.remove('btn-primary');
        buttonElement.classList.add('btn-light');

        activeGroup = group; // Salva lo stato attivo
    }
}

let currentPostId = '';

function openCommentPopup(postId) {
    currentPostId = postId;
    document.getElementById('popupOverlay').style.display = 'block';
    const popup = document.getElementById('commentPopup');
    popup.style.display = 'block';
    setTimeout(() => popup.classList.add('show'), 10);
    loadComments();
}

function openCandidaturaPopup(postId) {
    currentPostId = postId;
    document.getElementById('popupOverlayCandidatura').style.display = 'block';
    const popup = document.getElementById('candidaturaPopup');
    popup.style.display = 'block';
    setTimeout(() => popup.classList.add('show'), 10);
    loadComments();
}

function closeCommentPopup() {
    document.getElementById('popupOverlay').style.display = 'none';
    const popup = document.getElementById('commentPopup');
    popup.classList.remove('show');
    setTimeout(() => popup.style.display = 'none', 200);
    document.getElementById('commentText').value = '';
}

function closeCandidaturaPopup() {
    document.getElementById('popupOverlayCandidatura').style.display = 'none';
    const popup = document.getElementById('candidaturaPopup');
    popup.classList.remove('show');
    setTimeout(() => popup.style.display = 'none', 200);
    //document.getElementById('commentText').value = '';
}

function submitComment() {
    const comment = document.getElementById('commentText').value.trim();
    if (comment !== '') {
        let comments = JSON.parse(localStorage.getItem(currentPostId)) || [];
        comments.push(comment);
        localStorage.setItem(currentPostId, JSON.stringify(comments));
        loadComments();
        document.getElementById('commentText').value = '';
    } else {
        alert('⚠️ Scrivi un commento prima di inviare!');
    }
}

function submitCandidatura() {
    closeCandidaturaPopup();
}


function loadComments() {
    let commentListDiv = document.getElementById('commentList');
    commentListDiv.innerHTML = '';

    let comments = JSON.parse(localStorage.getItem(currentPostId)) || [];

    if (comments.length === 0) {
        commentListDiv.innerHTML = '<p>🚀 Nessun commento ancora.</p>';
    } else {
        comments.forEach(comment => {
            let p = document.createElement('p');
            p.textContent = comment;
            commentListDiv.appendChild(p);
        });
    }
}

//creazione post
document.addEventListener('DOMContentLoaded', function () {
    // DOM elements
    const openPopupBtn = document.getElementById('openPopup');
    const closePopupBtn = document.getElementById('closePopup');
    const popupOverlay = document.getElementById('popupOverlay-creazionepost');
    const postForm = document.getElementById('postForm');

    // Open popup
    if (openPopupBtn) {
        openPopupBtn.addEventListener('click', function () {
            popupOverlay.style.display = 'flex';
        });
    }

    // Close popup
    if (closePopupBtn) {
        closePopupBtn.addEventListener('click', function () {
            popupOverlay.style.display = 'none';
        });
    }

    // Close when clicking outside the form
    if (popupOverlay) {
        popupOverlay.addEventListener('click', function (e) {
            if (e.target === popupOverlay) {
                popupOverlay.style.display = 'none';
            }
        });
    }

    // Form submission - single handler
    if (postForm) {
        postForm.addEventListener('submit', function (e) {
            e.preventDefault();

            // Get form values
            const title = document.getElementById('postTitle').value;
            const description = document.getElementById('postDescription').value;
            const imageFile = document.getElementById('postImage').files[0];

            // Create new post element
            const newPost = document.createElement('div');
            newPost.className = 'post_card1';

            // Create the HTML structure for the new post
            let postHTML = `
                <div class="post_image-container">
                    <h2 style="color: rgb(255, 255, 255); margin: 0;"></h2>
            `;
            // Create new post element
            if (imageFile) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    newPost.querySelector('.post_image-container img').src = e.target.result;
                };
                reader.readAsDataURL(imageFile);
                postHTML += `<img src="" alt="Post Image" class="uploaded-image">`;
            } else {
                postHTML += `<img src="img/post/post1.jpg" alt="post Screenshot">`;
            }

            postHTML += `
                </div>
                <h6 class="title">${title}</h6>
                <p class="post_description">${description}</p>
                <div class="post_author">
                    <img src="img/post/profilo1.jpg" alt="Author">
                    <div class="post_author-info">
                        <span>You</span><br>
                        <small>${new Date().toLocaleDateString('it-IT', {
                year: 'numeric',
                month: 'long',
                day: 'numeric'
            })}</small>
                    </div>
                </div>
                <button class="comment-btn" onclick="openCommentPopup('new-post')" style="margin-left: 300px;">Commenta</button>
            `;

            newPost.innerHTML = postHTML;

            // Insert the new post at the top of the posts container
            const postsContainer = document.querySelector('.posts-container');
            if (postsContainer) {
                postsContainer.insertBefore(newPost, postsContainer.firstChild);
            } else {
                console.error('Posts container not found');
            }

            // Close the popup and reset the form
            if (popupOverlay) {
                popupOverlay.style.display = 'none';
            }
            this.reset();

            // Optional: Show success message
            alert('Post created successfully!');
        });
    }
});
//end creazione

//search
//search
document.addEventListener("DOMContentLoaded", function() {
    const searchIcon = document.getElementById("search-icon");
    const searchBar = document.getElementById("searchInput");
    const userRole = document.querySelector(".search-container").getAttribute("data-role") || "";// Assumi che il ruolo sia memorizzato in un attributo del body

    searchIcon.addEventListener("click", function() {
        searchBar.style.display = "block";
        searchBar.focus();
    });

    document.addEventListener("click", function(event) {
        if (!searchBar.contains(event.target) && !searchIcon.contains(event.target) && searchBar.value === "") {
            searchBar.style.display = "none";
        }
    });

    searchBar.addEventListener("keypress", function(event) {
        if (event.key === "Enter") {
            search();
        }
    });

    searchIcon.addEventListener("click", search);

    function search() {
        const query = searchBar.value.trim().toLowerCase();
        if (query !== "") {
            const commonPages = {
                "home": "/public/home",
                "skill bridge": "/public/chisiamo",
                "assistenza": "/public/assistenza",
                "contatti": "/public/assistenza",
                "domande": "/public/assistenza",
                "corsi": "/public/learning"
            };

            const clientPages = {
                ...commonPages,
                "post": "/post"
            };

            const freelancerPages = {
                ...commonPages,
                "offerta": "/offerta",
                "offerte": "/offerta"
            };

            let pages = commonPages;

            if (userRole === "ROLE_CLIENTE") {
                pages = clientPages;
            } else if (userRole === "ROLE_FREELANCER") {
                pages = freelancerPages;
            }
    
            if (pages[query]) {
                window.location.href = pages[query];
            } else {
                alert("Pagina non trovata");
            }
        }
    }
});

//cambia tema
document.addEventListener("DOMContentLoaded", function () {
    const themeToggle = document.getElementById("theme-toggle");
    const body = document.body;
    const icon = themeToggle.querySelector("i");

    const savedTheme = localStorage.getItem("theme");

    if (savedTheme) {
        body.classList.add(savedTheme);
        icon.classList.add(savedTheme === "dark-theme" ? "fa-moon" : "fa-sun");
    } else {
        icon.classList.add("fa-sun");
    }

    themeToggle.addEventListener("click", function () {
        if (body.classList.contains("dark-theme")) {
            body.classList.remove("dark-theme");
            body.classList.add("light-theme");
            localStorage.setItem("theme", "light-theme");
            icon.classList.replace("fa-moon", "fa-sun");
        } else {
            body.classList.remove("light-theme");
            body.classList.add("dark-theme");
            localStorage.setItem("theme", "dark-theme");
            icon.classList.replace("fa-sun", "fa-moon");
        }
    });
});

// function validateForm() {
//     // Ottieni i valori dai campi di input
//     var email = document.getElementById('email').value;
//     var password = document.getElementById('password').value;

//     // Aggiungi qui i dati di login che vuoi confrontare
//     var validEmail = "esempio@dominio.com";
//     var validPassword = "password123";

//     // Controllo se l'email e la password corrispondono ai valori validi
//     if (email === validEmail && password === validPassword) {
//         // Salva lo stato di login nell'archivio locale del browser
//         localStorage.setItem('isLoggedIn', 'true');

//         // Reindirizza alla homepage
//         window.location.href = "index.html"; // Sostituisci con l'URL della tua homepage
//         return false; // Impedisce l'invio del form
//     } else {
//         // Se le credenziali non sono corrette, mostra un messaggio di errore
//         alert("Email o password errati.");
//         return false; // Impedisce l'invio del form
//     }
// }

// window.onload = function() {
//     // Verifica se l'utente è loggato tramite localStorage
//     if (localStorage.getItem('isLoggedIn') === 'true') {
//         // Se l'utente è loggato, nascondi il tasto "Login" e mostra l'immagine del profilo
//         document.getElementById('loginBtn').style.display = 'none';
//         document.getElementById('profileImg').style.display = 'block';
//     } else {
//         // Se non è loggato, mostra il tasto "Login"
//         document.getElementById('loginBtn').style.display = 'block';
//         document.getElementById('profileImg').style.display = 'none';
//     }
// }

// Funzione di logout
// function logout() {
//     // Rimuove lo stato di login dal localStorage
//     localStorage.removeItem('isLoggedIn');

//     // Aggiorna l'interfaccia utente: nasconde il menu e mostra il pulsante login
//     document.getElementById('loginBtn').style.display = 'block';
//     document.getElementById('profileImg').style.display = 'none'; // Assicurati che esista un id="profileImg"
//     document.getElementById('subMenu').style.display = 'none';

//     // Reindirizza alla pagina di login
//     window.location.href = "login2.html";
// }

//profilo menu
let subMenu = document.getElementById("subMenu");

function toggleMenu() {
    subMenu.classList.toggle("open-menu");
}
