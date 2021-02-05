// Cannot redeclare 'a' here is any other JS file has declared 'a' as const / let
// var a = 100;

// sum(1)(2) = 3
// ES5
function sum(a) {
    return function(b) {
        if(b)
            return sum(a+b);
        return a;
    }
}

console.log(sum(1)(2)(3)(4)(5)(6)());

// ES6

let sumFunc = (a) => {
    return (b) => {
       return b ? sumFunc(a+b) : a;
    }
};

console.log(sumFunc(1)(2)(3)());

// IIFE
(function()
{console.log('Hello world');
})
();