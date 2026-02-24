from datetime import datetime, timedelta

def count_business_days(start, end):
    start_date = datetime.strptime(start, "%Y-%m-%d").date()
    end_date = datetime.strptime(end, "%Y-%m-%d").date()
    
    count = 0
    current = start_date
    
    while current <= end_date:
        if current.weekday() < 5:  # Monday=0, Sunday=6
            count += 1
        current += timedelta(days=1)
    
    return count
