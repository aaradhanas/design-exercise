/*const s = new Date().getSeconds();

setTimeout(function() {
  // prints out "2", meaning that the callback is not called immediately after 500 milliseconds.
  console.log("Ran after " + (new Date().getSeconds() - s) + " seconds");
}, 500)

while (true) {
  if (new Date().getSeconds() - s >= 2) {
    console.log("Good, looped for 2 seconds")
    break;
  }
}*/

(function() {

    console.log('this is the start');
  
    setTimeout(function cb() {
      console.log('Callback 1: this is a msg from call back');
    }); // has a default time value of 0
  
    console.log('this is just a message');
  
    setTimeout(function cb1() {
      console.log('Callback 2: this is a msg from call back');
    }, 0);
  
    console.log('this is the end');
  
  })();