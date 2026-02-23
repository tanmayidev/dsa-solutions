function canDonate(donor, recipient) {
    // Split letter and Rh factor
    const donorRh = donor.at(-1);
    const recipientRh = recipient.at(-1);
    const donorLetter = donor.slice(0, -1);
    const recipientLetter = recipient.slice(0, -1);

    // Rh compatibility
    const rhCompatible = donorRh === "-" || recipientRh === "+";

    // Letter compatibility
    const letterRules = {
        "O":  new Set(["O", "A", "B", "AB"]),
        "A":  new Set(["A", "AB"]),
        "B":  new Set(["B", "AB"]),
        "AB": new Set(["AB"])
    };
    const letterCompatible = letterRules[donorLetter].has(recipientLetter);

    return rhCompatible && letterCompatible;
}
