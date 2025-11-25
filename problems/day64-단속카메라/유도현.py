def solution(routes):
    routes.sort()
    c_route = routes[0]
    camera = 1
    for i in range(1, len(routes)):
        if routes[i][1] <= c_route[1]:
            c_route[1] = routes[i][1]
        if routes[i][0] <= c_route[1]:
            c_route[0] = routes[i][0]
        else:
            c_route = routes[i]
            camera += 1
    
    return camera