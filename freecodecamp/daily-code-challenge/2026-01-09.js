```
Circular Prime
Given an integer, determine if it is a circular prime.

A circular prime is an integer where all rotations of its digits are themselves prime.

For example, 197 is a circular prime because all rotations of its digits: 197, 971, and 719, are prime numbers.

Test Cases : 
1. is_circular_prime(197) should return True.
2. is_circular_prime(23) should return False.
3. is_circular_prime(13) should return True.
4. is_circular_prime(89) should return False.
5. is_circular_prime(1193) should return True.
```


// Helper: Check if a number is prime
function isPrime(num) {
    if (num < 2) return false;
    if (num === 2) return true;
    if (num % 2 === 0) return false;
    
    for (let i = 3; i <= Math.sqrt(num); i += 2) {
        if (num % i === 0) return false;
    }
    return true;
}

// Helper: Get all rotations of a number
function getRotations(num) {
    const str = num.toString();
    const rotations = [];
    
    for (let i = 0; i < str.length; i++) {
        const rotated = str.slice(i) + str.slice(0, i);
        rotations.push(parseInt(rotated));
    }
    
    return rotations;
}

function isCircularPrime(n) {    
    // Check if all rotations are prime
    const rotations = getRotations(n);
    return rotations.every(rotation => isPrime(rotation));
}
