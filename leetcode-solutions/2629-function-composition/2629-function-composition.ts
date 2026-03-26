type Func = (arg: any) => any;

function compose(functions: Func[]): Func {
  if (functions.length === 0) {
    return (x: any) => x;
  }

  return functions.reduceRight((prevFn, nextFn) => {
    return (x: any) => {
      return nextFn(prevFn(x));
    };
  });
}