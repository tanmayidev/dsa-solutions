function getRotation(n) {
    let s = String(n);
    const k = s.length;

    for (let i = 0; i < k; i++) {
        let num = Number(s);

        if (num % k === 0) {
            return i;
        }

        // rotate: move first char to end
        s = s.slice(1) + s[0];
    }

    return "none";
}