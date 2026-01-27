from datetime import datetime

def odd_or_even_day(timestamp):
    day = datetime.utcfromtimestamp(timestamp / 1000).day
    return "even" if day % 2 == 0 else "odd"
