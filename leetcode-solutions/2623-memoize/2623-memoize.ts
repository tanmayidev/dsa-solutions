type Args = any[];
type MemoizedFn<T> = (...args: Args) => T;

function memoize<T>(fn: MemoizedFn<T>): MemoizedFn<T> {
  const cache: Record<string, T> = {};
  return function (...args: Args) {
    const key = JSON.stringify(args);
    if (key in cache) {
      return cache[key];
    }
    const result = fn(...args);
    cache[key] = result;
    return result;
  }
}

/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */