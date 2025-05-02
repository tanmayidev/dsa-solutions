def find(a, x):
  if x in a:
    return a.index(x)
  return -1

def flip(a, k):
  for i in range(k//2):
    a[i], a[k-i-1] = a[k-i-1], a[i]

def pancakeSorting(a):
  n = len(a)
  ans = []

  while (n > 0):
    i = find(a, n)
    if (i != n - 1):
      flip(a, i + 1)
      flip(a, n)
      ans.append(i + 1)
      ans.append(n)
    n -= 1
  return ans