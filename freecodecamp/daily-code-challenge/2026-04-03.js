function getBrowserHistory(commands) {
  let history = [];
  let current = -1;

  for (let cmd of commands) {
    if (cmd === "Back") {
      if (current > 0) current--;
    } else if (cmd === "Forward") {
      if (current < history.length - 1) current++;
    } else {
      // It's a URL
      history = history.slice(0, current + 1); // remove forward history
      history.push(cmd);
      current++;
    }
  }

  return [history, current];
}