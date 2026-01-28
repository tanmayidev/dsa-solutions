function flatten(arr) {

  const result = [];

  function helper(items) {
    for (const item of items) {
      if (Array.isArray(item)) {
        helper(item);
      } else {
        result.push(item);
      }
    }
  }

  helper(arr);
  return result;
}
