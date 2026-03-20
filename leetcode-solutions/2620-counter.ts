// Postfix Increment
function createCounter(n: number): () => number {
    
    return function() {
        return n++;
    }
}

/**
// Increment and Return
var createCounter = function(n: number) {
  let currentCount = n - 1;
  return function() {
    currentCount += 1;
    return currentCount;      
  };
};

// Prefix Decrement and Increment
var createCounter = function(n: number) {
  --n;
  return function() {
    return ++n;      
  };
};

 */


/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */