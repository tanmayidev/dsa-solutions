def get_movie_night_cost(day, showtime, number_of_tickets):
    # Tuesday special
    if day == "Tuesday":
        return f"${5 * number_of_tickets:.2f}"

    # Base price
    if day in ["Friday", "Saturday", "Sunday"]:
        price = 12
    else:
        price = 10

    # Parse time
    time = showtime[:-2]
    period = showtime[-2:]

    hour, minute = map(int, time.split(":"))

    if period == "pm" and hour != 12:
        hour += 12
    if period == "am" and hour == 12:
        hour = 0

    # Matinee check
    if hour < 17:
        price -= 2

    total = price * number_of_tickets
    return f"${total:.2f}"