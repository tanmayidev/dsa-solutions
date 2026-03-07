function getElementSize(windowSize, elementVw, elementVh) {

  let [w, h] = windowSize.split(" x ").map(Number);

  // Extract numeric percentage values
  let vwPercent = parseFloat(elementVw);
  let vhPercent = parseFloat(elementVh);

  // Calculate pixel sizes
  let elementWidth = (w * vwPercent) / 100;
  let elementHeight = (h * vhPercent) / 100;

  return `${elementWidth} x ${elementHeight}`;
}
