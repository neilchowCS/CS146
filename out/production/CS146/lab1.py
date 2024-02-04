nums = [99,0,10,1]
target = 100

def findPair(arr, t):
    d = {}
    for i in arr:
        d[i] = t - i

    for i in arr:
        if d[i] in d.keys():
            return i, d[i]
    return None

x = findPair(nums, target)
print("no pair" if x is None else x)