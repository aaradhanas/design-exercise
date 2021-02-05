let arr = [1,2,3];

let obj = {
    name: "Aara",
    city: "Chennai",

    getIntro: function () {
        console.log(this.name + " from "+ this.city);
    }
}

let obj2 = {
    name: "Badri"
}

// NEVER DO THIS
obj2.__proto__ = obj;


// Every function will have access to this "myfunc" method
Function.prototype.myfunc = function() {
    console.log('myfunc method');
}

function func() {

}

// Call, Apply, bind

let name = {
    firstname: "Aara",
    lastname: "Sri",
}

let printFullName = function (city, state, pincode) {
    // console.log(this.firstname + " "+ this.lastname + " from "+ city + " ," + state + "-", pincode);
    return this.firstname + " "+ this.lastname + " from "+ city + " ," + state + "-", pincode;
}


printFullName.call(name, 'Chennai', 'TN');

let name2 = {
    firstname: "Badri",
    lastname: "Ravi",
}

// Function borrowing
printFullName.call(name2, 'Pune', 'MH');

// The only difference b/n call & apply is the way we pass arguments
printFullName.apply(name2, ['Pune', 'MH']);

// Bind method creates a copy of the function and does not execute it
let printMyName =  printFullName.bind(name2, 'Pune', 'MH');
console.log(printMyName);
// can later be executed by calling like below
printMyName();


// Polyfill for bind method

// Every function will have access to this "mybind" method
Function.prototype.mybind = function(thisArg, ...args) {
    let thisFunc = this;
    // This is a closure
    return function(...args2) {
        return thisFunc.apply(thisArg, [...args, ...args2]);
    };
}

let printName = printFullName.mybind(name2, 'Pune', 'MH');
console.log(printName("411058"));

// Function currying

// Using bind

let multiply = function(x, y) {
    return x*y;
}

let multiplyByTwo = multiply.bind(this, 2);
console.log(multiplyByTwo(3));

let multiplyByThree = multiply.bind(this, 3);
console.log(multiplyByThree(9));


// Using function closures

let mult = function(x) {
    return function(y) {
        console.log(x*y);
    }
}

let multByTwo = mult(2);
multByTwo(3);