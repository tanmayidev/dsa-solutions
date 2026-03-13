import math

def calculate_parking_fee(park_time, pickup_time):
    ph, pm = map(int, park_time.split(":"))
    uh, um = map(int, pickup_time.split(":"))

    park_minutes = ph * 60 + pm
    pickup_minutes = uh * 60 + um

    overnight_fee = 0
    if pickup_minutes < park_minutes:
        pickup_minutes += 24 * 60
        overnight_fee = 10

    total_minutes = pickup_minutes - park_minutes
    hours = math.ceil(total_minutes / 60)

    cost = hours * 3 + overnight_fee
    cost = max(cost, 5)

    return f"${cost}"
