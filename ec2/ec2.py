def listToMatrix(li: dict):
    matrix = []

    for i in range(len(li)):
        matrix.append([0] * len(li))

    for vertex in li.keys():
        for adjacent in li[vertex]:
            matrix[vertex][adjacent] = 1

    return matrix


def matrixToList(matrix):
    li = {}

    for i in range(len(matrix)):
        out = []
        for j in range(len(matrix[i])):
            if matrix[i][j] == 1:
                out.append(j)
        if len(out) > 0:
            li[i] = out

    return li

def reverseGraph(matrix):
    for i in range(len(matrix)):
        for j in range(i - 1):
            temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp