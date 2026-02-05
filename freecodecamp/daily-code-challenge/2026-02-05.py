def count_change(change):
    total_cents = sum(change)
    dollars = total_cents // 100
    cents = total_cents % 100
    return f"${dollars}.{cents:02d}"
