nums = [99,0,10,1]
target = 100

def FindPair(arr, t):
    d = {}
    for i in arr:
        d[i] = t - i

    for i in d.values():
        if d[i] in d.keys():
            return d[i], i
    return -1,-1

x = FindPair(nums, target)
print("no pair" if x == (-1, -1) else x)