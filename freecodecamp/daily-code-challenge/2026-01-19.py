JOULES_IN_CALORIE = 4184
JOULES_IN_WATTHOUR = 3600

def compare_energy(calories_burned, watt_hours_used):
    calories_burned_in_joules = calories_burned * JOULES_IN_CALORIE
    watt_hours_used_in_joules = watt_hours_used * JOULES_IN_WATTHOUR

    if (calories_burned_in_joules == watt_hours_used_in_joules):
        return "Equal"
    elif (calories_burned_in_joules > watt_hours_used_in_joules):
        return "Workout"
    else:
        return "Devices"
