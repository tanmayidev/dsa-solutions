type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

function chunk(arr: Obj[], size: number): Obj[][] {
    const chunked : Obj[][] = []
    let index : number = 0

    while (index < arr.length) {
        chunked.push(arr.slice(index, size + index))
        index += size
    }
    
    return chunked
};
