function getCharWidth(char) {
    if ("ilI.".includes(char)) return 1;
    if ("fjrt ".includes(char)) return 2;
    if ("abcdeghkmnopqrstuvwxyzJL".includes(char)) return 3;
    if ("ABCDEFGHKMNOPQRSTUVWXYZ".includes(char)) return 4;
    return 0; // Fallback for any unmapped characters
}

function truncateText(str) {
    let totalWidth = 0;
    for (let char of str) {
        totalWidth += getCharWidth(char);
    }
    
    // Return original string if it is 50 units or less
    if (totalWidth <= 50) {
        return str;
    }
    
    // Start with 3 to account for the "..." that will be appended
    let currentWidth = 3; 
    let truncatedStr = "";
    
    for (let char of str) {
        let charWidth = getCharWidth(char);
        // Add characters as long as we don't exceed the 50 unit limit
        if (currentWidth + charWidth <= 50) {
            currentWidth += charWidth;
            truncatedStr += char;
        } else {
            break;
        }
    }
    
    return truncatedStr + "...";
}
