type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | JSONValue[]

function isEmpty(obj: Record<string, any> | any[]): boolean {
  for (const _ in obj) {
    return false;
  }
  return true;
}