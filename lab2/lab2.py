s1 = "string"
s2 = "gnirts"
def anagram(s, t):
    if len(s) != len(t):
        return False
    d = {}
    for i in s:
        if i in d:
            d[i] = d[i] + 1
        else:
            d[i] = 1

    for i in t:
        if i not in d or d[i] < 1:
            return False
        d[i] = d[i] - 1
    return True

print(s1 + ", " + s2 + (": anagrams" if anagram(s1,s2) else ": not anagrams"))