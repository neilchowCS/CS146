from collections import deque


def canFinish(numCourses, prerequisites):
    adjList = [[] for i in range(numCourses)]

    for prereq in prerequisites:
        adjList[prereq[0]].append(prereq[1])

    print(adjList)

    return kahns(adjList)

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
        return False

    return True

print(canFinish(2,[[0,1]]))
print(canFinish(2, [[0,1],[1,0]]))