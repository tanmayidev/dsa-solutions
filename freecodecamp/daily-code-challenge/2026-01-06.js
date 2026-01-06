```
vOwElcAsE
Given a string, return a new string where all vowels are converted to uppercase and all other alphabetical characters are converted to lowercase.

Vowels are "a", "e", "i", "o", and "u" in any case.
Non-alphabetical characters should remain unchanged.

Test Cases 
1. vowelCase("vowelcase") should return "vOwElcAsE".
2. vowelCase("coding is fun") should return "cOdIng Is fUn".
3. vowelCase("HELLO, world!") should return "hEllO, wOrld!".
4. vowelCase("git cherry-pick") should return "gIt chErry-pIck".
5. vowelCase("HEAD~1") should return "hEAd~1".

```

function vowelCase(str) {
  const vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];

  const strList = str.split("").map(s => {
    if(vowels.indexOf(s) !== -1) {
      return s.toUpperCase();
    } 
    else {
      return s.toLowerCase();
    }
  })


  return strList.join("");
}
