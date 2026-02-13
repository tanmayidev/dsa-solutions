def get_fastest_speed(times):
    distances = [320, 280, 350, 300, 250]
    
    max_speed = 0
    segment_number = 0
    
    for i in range(5):
        speed = distances[i] / times[i]
        if speed > max_speed:
            max_speed = speed
            segment_number = i + 1
    
    return f"The luger's fastest speed was {max_speed:.2f} m/s on segment {segment_number}."
