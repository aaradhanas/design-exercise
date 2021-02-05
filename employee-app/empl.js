class Employee {
    id;
    name;
    worksheets;
}

class Worksheet {
    id;
    date;
}

let employees = [{
    id: 1,
    name: 'ANC',
    number: 10
}];

// on scroll down / up

let prevCoord;
function onScroll(x, y) {
    let cursor = 100;
    let percentage = 20;

    // cursor = 10, records = 2, 
}