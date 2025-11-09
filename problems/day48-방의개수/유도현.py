def solution(arrows):
    dx = [0, 1, 1, 1, 0, -1, -1, -1]
    dy = [-1, -1, 0, 1, 1, 1, 0, -1]

    cur_x, cur_y = 0, 0
    visited_points = set()
    visited_points.add((cur_x, cur_y))
    visited_edges = set()
    room_count = 0

    for direction in arrows:
        for _ in range(2):
            next_x, next_y = cur_x + dx[direction], cur_y + dy[direction]
            if (next_x, next_y) in visited_points and (cur_x, cur_y, next_x, next_y) not in visited_edges:
                room_count += 1
            visited_edges.add((cur_x, cur_y, next_x, next_y))
            visited_edges.add((next_x, next_y, cur_x, cur_y))
            visited_points.add((next_x, next_y))
            cur_x, cur_y = next_x, next_y

    return room_count