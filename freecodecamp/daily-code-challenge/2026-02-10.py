def get_relative_results(results):
    # helper: convert H:MM:SS to seconds
    def to_seconds(time):
        h, m, s = map(int, time.split(":"))
        return h * 3600 + m * 60 + s

    winner_time = to_seconds(results[0])
    output = []

    for i, time in enumerate(results):
        if i == 0:
            output.append("0")
        else:
            diff = to_seconds(time) - winner_time
            minutes = diff // 60
            seconds = diff % 60
            output.append(f"+{minutes}:{seconds:02d}")

    return output
