def next_n(n):
  s = 0
  for i in n:
    s+= int(i)**2
  return str(s)

def isHappyRecur(s, n):
  if n == '1':
    return True
  if n in s:
    return False
  s.add(n)
  n = next_n(n)
    
  return isHappyRecur(s, n)

def isHappy(n):
  s = set()
  return isHappyRecur(s, n)

n = input()
result = isHappy(n)
if result:
  print("true")
else:
  print("false")