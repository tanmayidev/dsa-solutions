def get_pi_decimal(n):
    target = n + 1
    
    q, r, t, k, n1, l = 1, 0, 1, 1, 3, 3
    digits = []
    
    while len(digits) < target:
        if 4*q + r - t < n1*t:
            digits.append(n1)
            q, r, t, k, n1, l = (
                10*q,
                10*(r - n1*t),
                t,
                k,
                ((10*(3*q + r)) // t) - 10*n1,
                l
            )
        else:
            q, r, t, k, n1, l = (
                q*k,
                (2*q + r)*l,
                t*l,
                k + 1,
                (q*(7*k) + 2 + r*l) // (t*l),
                l + 2
            )
    
    return digits[n]
