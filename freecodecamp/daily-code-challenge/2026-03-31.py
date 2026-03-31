def alarm_check(alarm_time, wake_time):
    def to_minutes(time):
        h, m = map(int, time.split(":"))
        return h * 60 + m

    alarm = to_minutes(alarm_time)
    wake = to_minutes(wake_time)

    if wake < alarm:
        return "early"
    elif wake <= alarm + 10:
        return "on time"
    else:
        return "late"