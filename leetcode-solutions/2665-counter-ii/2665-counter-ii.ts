/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
interface Counter {
  increment(): number;
  decrement(): number;
  reset(): number;
}

const createCounter = (init: number = 0): Counter => {
  let count: number = init || 0;

  const increment = (): number => {
    count++;
    return count;
  };

  const decrement = (): number => {
    count--;
    return count;
  };

  const reset = (): number => {
    count = init;
    return count;
  };

  return { increment, decrement, reset };
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
