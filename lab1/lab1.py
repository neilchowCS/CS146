nums = [99,0,10,1]
target = 100

def findPair(arr, t):
    d = {}
    for i in arr:
        d[i] = t - i

    output = [-1,-1]
    for i in range(len(arr)):
        if d[arr[i]] in d.keys():
            output[0] = i
            for j in range(i+1, len(arr)):
                if arr[j] == d[arr[i]]:
                    output[1] = j
                    return output
    return output

print(findPair(nums, target))