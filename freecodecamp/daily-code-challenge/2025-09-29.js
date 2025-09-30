/*

Longest Word

Given a sentence, return the longest word in the sentence.
- Ignore periods (.) when determining word length.
- If multiple words are ties for the longest, return the first one that occurs.


Tests : 
1. getLongestWord("coding is fun") should return "coding".
2. getLongestWord("Coding challenges are fun and educational.") should return "educational".
3. getLongestWord("This sentence has multiple long words.") should return "sentence".

*/

function getLongestWord(sentence) {
  if (!sentence || typeof sentence !== 'string') {
    return '';
  }
  
  const words = sentence
    .replace(/\./g, '')
    .split(" ")
    .filter(word => word.length > 0);
  
  if (words.length === 0) {
    return '';
  }
  
  return words.reduce((longest, current) => 
    current.length > longest.length ? current : longest
  );
}

// Brute Force

function getLongestWord(sentence) {
  const newSentence = sentence.replace(".", "");
  let words = newSentence.split(" ");

  let longestWordLength = 0;
  let longestWord = '';

  for(let i=0; i < words.length; i++) {
    let len = words[i].length;
    if(longestWordLength < words[i].length) {
      longestWordLength = len;
      longestWord = words[i];
    }
  }

  return longestWord;
}
