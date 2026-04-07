function palindromeLocator(str) {
    // Check palindrome
    if (str !== str.split('').reverse().join('')) {
        return "none";
    }

    let len = str.length;
    let mid = Math.floor(len / 2);

    // Odd length
    if (len % 2 !== 0) {
        return str[mid];
    }

    // Even length
    return str[mid - 1] + str[mid];
}