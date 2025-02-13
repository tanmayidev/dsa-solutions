def threeSumClosest(nums, target):
  nums.sort()
  length = len(nums)
  ans = nums[0]+nums[1]+nums[length-1]
  for i in range(length-2):
    start = i+1
    end = length-1
    while start < end:
      sum = nums[i]+nums[start]+nums[end]
      if sum > target:
        end -= 1
      else:
        start += 1
      if abs(sum-target) < abs(ans-target):
        ans = sum
  return ans

n = int(input())
target = int(input())
arr = []
for i in range(n):
  arr.append(int(input()))

res = threeSumClosest(arr,target)
print(res)