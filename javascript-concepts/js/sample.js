const api_url = 'http://dummy.restapiexample.com/api/v1/employees';
let api_data;

function setHeaderTitle() {
    $("#header").text('E-Commerce App');
}

function updateTemplate(employee) {
   // Append data to HTML dynamically
   const container = document.getElementById('container');

   let card = document.createElement('div');
   card.className = 'card';
   card.id = 'card-'+employee.id;

   let nameElement = document.createElement('p');
   nameElement.className = 'name';
   nameElement.textContent = employee.employee_name;
   card.append(nameElement);

   let positionElement = document.createElement('p');
   positionElement.textContent = employee.employee_salary;
   card.append(positionElement);

   let salaryElement = document.createElement('p');
   salaryElement.textContent = employee.employee_age;
   card.append(salaryElement);

   let buttonElement = document.createElement('button');
   buttonElement.textContent = 'Remove';
   buttonElement.className = 'remove-btn';
   buttonElement.id = employee.id;
   card.append(buttonElement);

   container.append(card);
}
async function getData() {
    const response  = await fetch(api_url);
    const data = await response.json();
    api_data = data.data;

    // Sort an array of objects
    api_data.sort( (a,b) =>  {
        let p1 = a.employee_name.toLowerCase();
        let p2 = b.employee_name.toLowerCase();

        if(p1 < p2) {
            return -1;
        }

        if(p1 > p2) {
            return 1;
        }

        return 0;
    });

    // Store in local storage
    localStorage.setItem('cached_data', JSON.stringify(api_data));

    const container = document.getElementById('container');
    container.innerHTML = '';
    api_data.forEach(updateTemplate);

    $(".remove-btn").click(function(event) {
        /*let id = event.target.id;
             let card = document.getElementById('card-'+id);
             card.remove();
         */
        let id = event.target.id;
         $(this).parent().remove();
         for(i = 0; i < api_data.length; i++) {
             if(api_data[i].id === id) {
                 api_data.splice(i,1);
             }
         }
         
     });
}

function populateData() {
    // Retrieve from local storage
    const cached_data = localStorage.getItem('cached_data');
    let data;
    if(cached_data === undefined || cached_data === null) {
        getData(); 
    } else {
        data = JSON.parse(cached_data);
        const container = document.getElementById('container');
        container.innerHTML = '';
        data.forEach(updateTemplate);
    }
}

function filter() {
    const search_string = document.getElementById('search-box').value;
    if(search_string !== '') {
        const cards = document.getElementsByClassName('card');

        for(i = 0; i < cards.length; i++) {
            let name = cards[i].getElementsByClassName('name')[0].textContent;
            if(name.toUpperCase().indexOf(search_string.toUpperCase()) > -1) {
                cards[i].classList.remove('hide');
                cards[i].classList.add('show');
            } else {
                cards[i].classList.remove('show');
                cards[i].classList.add('hide');
            }
        }
    } else {

    }
}

function sort() {
    let sortSelect = document.getElementById('sort-option');
    console.log(sortSelect.value);
}

document.addEventListener('DOMContentLoaded', function(event) {
    setHeaderTitle();

    getData();

    document.getElementById('home').onclick = function() {
        // Remove from local storage
        localStorage.removeItem('cached_data');
    }   
});

function drag(event) {
    event.dataTransfer.setData("text", event.target.id);
}

function allowDrop(event) {
    event.preventDefault();
}

function drop(event) {
    event.preventDefault();
    let data = event.dataTransfer.getData("text");
    event.target.appendChild(document.getElementById(data));
}

/*('document').ready(function() {
});*/

// window.onload = setHeaderTitle;

