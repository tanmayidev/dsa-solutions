function shiftMatrix(matrix, shift) {
    if (!matrix.length || !matrix[0].length) {
        return matrix;
    }

    const rows = matrix.length;
    const cols = matrix[0].length;
    const total = rows * cols;

    // Normalize shift
    shift = ((shift % total) + total) % total;

    // Flatten matrix
    const flat = matrix.flat();

    // Shift using slicing
    const shifted = flat.slice(-shift).concat(flat.slice(0, total - shift));

    // Rebuild matrix
    const result = [];
    for (let r = 0; r < rows; r++) {
        result.push(shifted.slice(r * cols, (r + 1) * cols));
    }

    return result;
}
