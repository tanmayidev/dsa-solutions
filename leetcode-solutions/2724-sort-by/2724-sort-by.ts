type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Fn = (value: JSONValue) => number

function sortBy(arr: any[], fn: Function): any[] {
    function swap(a: any, b: any): number {
        return (fn(a) < fn(b)) ? -1 : 1;
    }

    return arr.sort(swap);
}
