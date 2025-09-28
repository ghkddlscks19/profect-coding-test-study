def solution(s, n):
    answer = ''
    
    big = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    small = "abcdefghijklmnopqrstuvwxyz"
    
    arr = []
    
    for i in s:
        if i in big:
            idx = big.index(i)
            arr.append(big[(idx+n)%26])
        elif i in small:
            idx = small.index(i)
            arr.append(small[(idx+n)%26])
        if i == " ":
            arr.append(" ")

    return "".join(arr)