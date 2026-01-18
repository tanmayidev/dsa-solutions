```
Free Shipping
Given an array of strings representing items in your shopping cart, and a number for the minimum order amount to qualify for free shipping, determine if the items in your shopping cart qualify for free shipping.

The given array will contain items from the list below:

| Item | 	Price |
| ---- | ----- |
| "shirt" |	34.25 |
| "jeans" |	48.50 |
| "shoes" |	75.00 |
| "hat" |	19.95 |
| "socks"	| 15.00 |
| "jacket" |	109.95 |

Test Cases : 
1. getsFreeShipping(["shoes"], 50) should return true.
2. getsFreeShipping(["hat", "socks"], 50) should return false.
3. getsFreeShipping(["jeans", "shirt", "jacket"], 75) should return true.
4. getsFreeShipping(["socks", "socks", "hat"], 75) should return false.
5. getsFreeShipping(["shirt", "shirt", "jeans", "socks"], 100) should return true.
6. getsFreeShipping(["hat", "socks", "hat", "jeans", "shoes", "hat"], 200) should return false.
```


const priceChart = {
  "shirt": 34.25,
  "jeans": 48.50,
  "shoes": 75.00,
  "hat": 19.95,
  "socks": 15.00,
  "jacket": 109.95,
}

function getsFreeShipping(cart, minimum) {

  return cart.map((item) => priceChart[item]).reduce((acc, price) => acc += price, 0) > minimum;
}
