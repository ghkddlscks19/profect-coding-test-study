def solution(line):
    answer = []
    points = set()
    for i in range(len(line)):
        for j in range(i+1, len(line)):
            a,b,e = line[i]
            c,d,f = line[j]
            
            if (a * d - b * c) != 0:
                x = (b * f - e * d) / (a * d - b * c)
                y = (e*c - a*f) / (a*d - b*c)
            
            if int(x) == x and int(y) == y:
                x = int(x)
                y = int(y)
                points.add((x,y))

    min_x = min(point[0] for point in points)
    max_x = max(point[0] for point in points)
    min_y = min(point[1] for point in points)
    max_y = max(point[1] for point in points)
    print(points)
    for y in range(max_y, min_y - 1, -1):
        row = ""
        for x in range(min_x, max_x + 1):
            if (x, y) in points:
                row += "*"
            else:
                row += "."
        answer.append(row)
    return answer