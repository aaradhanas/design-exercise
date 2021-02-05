var idbPromise = idb.open('test-db', 2, function(db) {
    if(!db.objectStoreNames.contains('test-store')) {
        db.createObjectStore('test-store', {keyPath: 'id'});
    }
});

function writeData(store_name, data) {
    idbPromise.then(
        function(db) {
            let txn = db.transaction(store_name, 'readwrite');
            let store = txn.objectStore(store_name);
            store.put(data);
            return txn.complete;
        }
    )
}

writeData('test-store', {id: 3, name:'Kiara'});

function readAllData(store_name) {
    return dbPromise
        .then(function (db) {
            var txn = db.transaction(store_name, 'readonly');
            var store = txn.objectStore(store_name);
            return store.getAll();
        });
}

function clearAllData(store_name) {
    return dbPromise
        .then(function (db) {
            var txn = db.transaction(store_name, 'readwrite');
            var store = txn.objectStore(store_name);
            store.clear();
            return txn.complete;
        })
}

// Will be used later
function deleteItemFromStore(store_name, id){
    dbPromise
        .then(function (db) {
            var txn = db.transaction(store_name, 'readwrite');
            var store = txn.objectStore(store_name);
            store.delete(id);
            return txn.complete;
        })
        .then(function () {
            console.log('Item deleted !!');
        })
}
