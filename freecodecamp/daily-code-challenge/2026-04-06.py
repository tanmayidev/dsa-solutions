from datetime import datetime

def getDayOfWeek(timestamp):
    days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
    dt = datetime.utcfromtimestamp(timestamp / 1000)
    return days[dt.weekday() + 1 if dt.weekday() < 6 else 0]