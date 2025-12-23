from itertools import combinations
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
chicken = []
city = []
answer = float("inf") 

for i in range(n):
    for j in range(n):
        if arr[i][j] == 1:
            city.append([i,j])
        elif arr[i][j] ==2:
            chicken.append([i,j])

for selected in combinations(chicken, m):
    sum = 0
    for house in city:
        dist =  float("inf") 
        for chick in selected:
            x1, y1 = chick
            x2, y2 = house
            cal =abs(x1-x2)+abs(y1-y2)
            dist= min(dist, cal)
        sum+=dist
    answer = min(sum, answer)

print(answer)



# print(chicken)
# print(city)