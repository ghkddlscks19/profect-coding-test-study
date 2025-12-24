import sys
input = sys.stdin.readline

def solve(n):
    nLen = len(str(n))
    startNum = "1" * nLen
    while True:
        if int(startNum) % n == 0:
            return len(startNum)
        startNum += "1"

while True:
    try:
        n = int(input())
        print(solve(n))
    except:
        break
