const getData = () => {
    console.log('Fetching data');
}

const debounceFunction = (func, time) => {
    const context;
    let timer;
    return function() {
        clearTimeout(timer);
        timer = setTimeout(() => {
            func.apply(context);
        }, time);
    }
}

const onKeyUp = debounceFunction(getData, 1000);