def moveZeros(arr):
  index = 0
  
  for i in range(len(arr)):
    if arr[i] != 0:
      arr[i],arr[index] = arr[index],arr[i]
      index+=1
  
  arr = []
  n = int(input())
  for _ in range(n):
    arr.append(int(input()))
  
  moveZeros(arr)
  
  print(*arr)