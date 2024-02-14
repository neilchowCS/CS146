def fibonacci(n):
    if n <= 1:
        return n

    output = 0
    x = 1
    for i in range(0, n):
        temp = output
        output = output + x
        x = temp
    return output

string = ""
for i in range(0, 10):
    string = string + str(fibonacci(i)) + " "

print(string)