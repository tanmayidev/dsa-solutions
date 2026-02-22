def count_medals(winners):
    table = {}

    for gold, silver, bronze in winners:
        if gold not in table:
            table[gold] = [0, 0, 0]
        if silver not in table:
            table[silver] = [0, 0, 0]
        if bronze not in table:
            table[bronze] = [0, 0, 0]

        table[gold][0] += 1
        table[silver][1] += 1
        table[bronze][2] += 1

    countries = list(table.keys())

    countries.sort(key=lambda c: (-table[c][0], c))

    result = "Country,Gold,Silver,Bronze,Total"

    for country in countries:
        g, s, b = table[country]
        total = g + s + b
        result += f"\n{country},{g},{s},{b},{total}"

    return result
