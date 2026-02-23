def can_donate(donor: str, recipient: str) -> bool:
    # Split letter and Rh factor
    donor_rh = donor[-1]
    recipient_rh = recipient[-1]
    donor_letter = donor[:-1]
    recipient_letter = recipient[:-1]

    # Rh compatibility: "+" can only donate to "+", "-" can donate to both
    rh_compatible = donor_rh == "-" or recipient_rh == "+"

    # Letter compatibility
    letter_rules = {
        "O":  {"O", "A", "B", "AB"},
        "A":  {"A", "AB"},
        "B":  {"B", "AB"},
        "AB": {"AB"}
    }
    letter_compatible = recipient_letter in letter_rules[donor_letter]

    return rh_compatible and letter_compatible
