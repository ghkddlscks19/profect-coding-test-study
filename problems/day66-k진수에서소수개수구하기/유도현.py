def change(n,k):
    mods = []
    while n != 0:
        temp = n % k
        mods.append(str(temp))
        n //= k
    mods.reverse()
    return mods

def check(number):
    number = int(number)
    if number == 1:
        return 0
    if number == 2:
        return 1
    for i in range(3, int(number ** 0.5) + 1):
        if number % i == 0:
            return 0
    return 1
        
    
def solution(n, k):
    answer = 0
    mods = change(n,k)
    temp = ""
    for number in mods:
        if temp != "" and number == "0":
            answer += check(temp)
            temp = ""
        elif temp == "" and number != "0":
            temp += number
        elif temp != "" and number != "0":
            temp += number

    if len(temp):
        answer += check(temp)
    return answer

n = 437674
k = 3
print(solution(n,k))
