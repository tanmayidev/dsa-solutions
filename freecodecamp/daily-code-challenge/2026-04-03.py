def get_browser_history(commands):
    history = []
    current = -1

    for cmd in commands:
        if cmd == "Back":
            if current > 0:
                current -= 1
        elif cmd == "Forward":
            if current < len(history) - 1:
                current += 1
        else:
            # URL visit
            history = history[:current + 1]  # remove forward history
            history.append(cmd)
            current += 1

    return [history, current]