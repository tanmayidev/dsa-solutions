def is_valid_trick(trick_name):
    valid_first = ["Misty", "Ghost", "Thunder", "Solar", "Sky", "Phantom", "Frozen", "Polar"]
    valid_second = ["Twister", "Icequake", "Avalanche", "Vortex", "Snowstorm", "Frostbite", "Blizzard", "Shadow"]
    
    first, second = trick_name.split(" ")
    return first in valid_first and second in valid_second
