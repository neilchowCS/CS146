from collections import deque


def kahns(li):
    #set indegrees
    indegrees = [0] * len(li)
    for i in li:
        for j in i:
            indegrees[j] += 1

    queue = deque()

    for i in range(len(li)):
        if indegrees[i] == 0:
            queue.append(i)

    output = []

    while len(queue) > 0:
        degree0 = queue.popleft()
        output.append(degree0)
        for adj in li[degree0]:
            indegrees[adj] -= 1
            if indegrees[adj] == 0:
                queue.append(adj)

    if len(output) != len(li):
        return []

    return output

def dfs(li):
    visited = set()
    output = []
    in_progress = set()

    def helper(index):
        if index in in_progress:
            raise ValueError("cycle")
        # visited.add(index)
        #
        # for adj in li[index]:
        #     if adj not in visited:
        #         helper(adj)
        # output.append(index)
        if index not in visited:
            in_progress.add(index)
            for adj in li[index]:
                helper(adj)
            in_progress.remove(index)
            visited.add(index)
            output.append(index)

    for i in range(len(li)):
        if i not in visited:
            helper(i)

    output.reverse()
    return output



adjList = [[2], [3], [4, 5, 6], [4, 5, 6], [7], [7], [7], []]

sorted = kahns(adjList)
sorted2 = dfs(adjList)

for i in sorted:
    print(i)

for i in sorted2:
    print(i)

adjList = [[1],[0]]

sorted = kahns(adjList)

print ("cycle") if sorted == [] else print("no cycle")

try:
    dfs(adjList)
except ValueError as e:
    print("Error:", e)