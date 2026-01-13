"""
Plant the Crop

Given an integer representing the size of your farm field, and "acres" or "hectares" representing the unit for the size of your farm field, and a type of crop, determine how many plants of that type you can fit in your field.

1 acre equals 4046.86 square meters.
1 hectare equals 10,000 square meters.
Here's a list of crops that will be given as input and how much space a single plant takes:

| Crop        |	Space per plant     |
| ----------- | ------------------- |
| "corn"      |	1 square meter      |
| "wheat"     |	0.1 square meters   |
| "soybeans"  |	0.5 square meters   |
| "tomatoes"  |	0.25 square meters  |
| "lettuce"   |	0.2 square meters   |

Return the number of plants that fit in the field, rounded down to the nearest whole plant.

Test Cases : 
1. get_number_of_plants(1, "acres", "corn") should return 4046.
2. get_number_of_plants(2, "hectares", "lettuce") should return 100000.
3. get_number_of_plants(20, "acres", "soybeans") should return 161874.
4. get_number_of_plants(3.75, "hectares", "tomatoes") should return 150000.
5. get_number_of_plants(16.75, "acres", "tomatoes") should return 271139.
"""

import math

ACRE_IN_SQ_MTRS = 4_046.86
HECTARE_IN_SQ_MTRS = 10_000


def unit_to_sq_mtrs(unit):
    if unit == "acres":
        return ACRE_IN_SQ_MTRS
    elif unit == "hectares":
        return HECTARE_IN_SQ_MTRS
    else:
        raise ValueError("Unknown Unit Requested")


def per_crop_sq_mtrs(crop):
    if crop == "corn":
        return 1
    elif crop == "wheat":
        return 0.1
    elif crop == "soybeans":
        return 0.5
    elif crop == "tomatoes":
        return 0.25
    elif crop == "lettuce":
        return 0.2
    else:
        raise ValueError("Unknown Crop Requested")


def get_number_of_plants(field_size, unit, crop):
    total_available_sq_mtrs = field_size * unit_to_sq_mtrs(unit)
    return math.floor(total_available_sq_mtrs / per_crop_sq_mtrs(crop))
