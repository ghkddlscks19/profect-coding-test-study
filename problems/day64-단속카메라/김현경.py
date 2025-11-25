def solution(routes):
    routes.sort(key=lambda x: x[1])
    loc = -30001
    answer = 0
    for r in routes:
        first = r[0]
        last = r[1]
        if first > loc:
            answer += 1
            loc = last
    return answer