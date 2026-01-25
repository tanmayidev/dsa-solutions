```
Scaled Image
Given a string representing the width and height of an image, and a number to scale the image, return the scaled width and height.

The input string is in the format "WxH". For example, "800x600".
The scale is a number to multiply the width and height by.
Return the scaled dimensions in the same "WxH" format.

Test Cases : 
1. scaleImage("800x600", 2) should return "1600x1200".
2. scaleImage("100x100", 10) should return "1000x1000".
3. scaleImage("1024x768", 0.5) should return "512x384".
4. scaleImage("300x200", 1.5) should return "450x300".
```

function scaleImage(size, scale) {
  let str = size.split("x");
  let str2 = str.map((s) => { return s*scale})
  return str2.join("x");
}
