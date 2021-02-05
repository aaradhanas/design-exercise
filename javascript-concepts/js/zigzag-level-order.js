function zigzag(root) {
    let results = [];
    
    const lot = (root, level) => {
        if(! root)
            return;

        if(results[level] === undefined) {
            results[level] = [];
        }
        results[level].push(root.val);

        lot(root.left, level+1);
        lot(root.right, level+1);
    }

    lot(root, 0);

    // Reverse the elements in odd indices
    results = results.map( (arr, index) => {
        return index%2 ? arr.reverse() : arr;
    });

    return results;
}

zigzag(root);