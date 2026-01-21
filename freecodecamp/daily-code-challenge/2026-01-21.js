// regex
function parseInlineCode(markdown) {

  return markdown.replace(/`([^`]+)`/g, '<code>$1</code>');
}
