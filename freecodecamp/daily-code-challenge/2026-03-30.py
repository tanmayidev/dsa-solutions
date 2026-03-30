from datetime import datetime
import calendar

def get_due_date(date_str):
    date = datetime.strptime(date_str, "%Y-%m-%d")
    
    # Add 9 months
    new_month = date.month + 9
    new_year = date.year + (new_month - 1) // 12
    new_month = (new_month - 1) % 12 + 1
    
    # Get last day of target month
    last_day = calendar.monthrange(new_year, new_month)[1]
    
    # Adjust day if needed
    new_day = min(date.day, last_day)
    
    return f"{new_year:04d}-{new_month:02d}-{new_day:02d}"