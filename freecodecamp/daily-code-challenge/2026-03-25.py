from datetime import datetime

def can_retake(finish_time, current_time):
    fmt = "%Y-%m-%dT%H:%M:%S"
    
    t1 = datetime.strptime(finish_time, fmt)
    t2 = datetime.strptime(current_time, fmt)
    
    diff = (t2 - t1).total_seconds()
    
    return diff >= 48 * 3600