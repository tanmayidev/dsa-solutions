from datetime import datetime

def get_day_of_week(timestamp):
    days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
    dt = datetime.utcfromtimestamp(timestamp / 1000)
    return days[dt.weekday() + 1 if dt.weekday() < 6 else 0]