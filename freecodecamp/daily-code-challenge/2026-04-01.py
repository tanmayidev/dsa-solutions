from collections import Counter

def fix_prank_number(arr):
    n = len(arr)

    # Step 1: differences
    diffs = [arr[i] - arr[i-1] for i in range(1, n)]

    # Step 2: most common difference
    correct_diff = Counter(diffs).most_common(1)[0][0]

    # Step 3: try different starting points
    for start_idx in range(min(3, n)):
        start_val = arr[start_idx] - start_idx * correct_diff

        candidate = [start_val + i * correct_diff for i in range(n)]

        changes = sum(1 for i in range(n) if candidate[i] != arr[i])

        if changes <= 1:
            return candidate

    return arr