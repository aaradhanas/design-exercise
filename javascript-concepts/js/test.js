let a = 100;

if(a === 100) {
    var c = 10;
}

console.log(a);

function func(){
    var a = 10;
    let b = 200;
    if(a == 10) {
        var d = 345;
        let b = 20;
        console.log(b);
    } else {
        const c = 100;
        console.log(c);
    }
    console.log(a);
    console.log(d);
}

func();
console.log(a);


/*function a() {
    var b = 10;
    c();
    function c() {
        d
    }

    function d() {
        console.log(b);
    }
}

a();*/


/*var a = 10;

function sum(num) {
    var sum_val = num+num;
    return sum_val;
}

var result = sum(a);

var func =  () => {
    console.log('Hello');
}

func();

console.log(sum);*/