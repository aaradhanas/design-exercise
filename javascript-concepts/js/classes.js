class Shape {
    // public variable
    name;
    // private variable
    #sides;
    constructor(name, sides) {
        this.name = name;
        this.#sides = sides;
    }
}

const shape = new Shape('square', 4);
console.log(shape.name);

class Animal {
    constructor(name) {
        this.name = name;
    }

    speak() {
        console.log(this.name + " makes a noise");
    }
}

class Dog extends Animal {
    constructor(name) {
        super(name);
    }

    speak() {
        super.speak();
        console.log(this.name + " barks");
    }
}

const dog = new Dog("Ludo");
dog.speak();

