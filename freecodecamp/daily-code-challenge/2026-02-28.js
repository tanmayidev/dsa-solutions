function addPunctuation(sentences) {
  let result = sentences.replace(/\s(?=[A-Z])/g, ". ");
  
  // Add period at end if not already present
  if (!result.endsWith(".")) {
    result += ".";
  }
  
  return result;
}
