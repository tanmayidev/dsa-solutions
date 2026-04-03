/**
 * @param functions Array of functions returning a Promise
 * @returns Promise resolving to an array of results
 */
var promiseAll = function (
  functions: Array<() => Promise<any>>
): Promise<any[]> {
  return new Promise((resolve, reject) => {
    const results: any[] = new Array(functions.length);
    let completed: number = 0;

    for (let i = 0; i < functions.length; i++) {
      functions[i]()
        .then((value: any) => {
          results[i] = value;
          completed++;

          if (completed === functions.length) {
            resolve(results);
          }
        })
        .catch(reject); // reject immediately on first failure
    }
  });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */