def solution(board, aloc, bloc):
    lenR, lenC = len(board), len(board[0])
    visited = [[board[r][c] for c in range(lenC)] for r in range(lenR)]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # dfs는 (win, count) 반환
    def dfs(turn, visited, count, aloc, bloc):
        if turn == 0:   # A 차례
            x, y = aloc
            if visited[x][y] == 0:
                return (False, count)   # A는 더 못 움직여서 패배

            win_cnt = float('inf')
            lose_cnt = count
            can_move = False

            visited[x][y] = 0   # 발판 제거 (현재 위치)

            for k in range(4):
                nx, ny = x + dx[k], y + dy[k]
                if 0 <= nx < lenR and 0 <= ny < lenC and visited[nx][ny] == 1:
                    can_move = True
                    opp_win, opp_cnt = dfs(1, visited, count + 1, [nx, ny], bloc)

                    if not opp_win:   # 상대가 지면 A는 승리
                        win_cnt = min(win_cnt, opp_cnt)
                    else:
                        lose_cnt = max(lose_cnt, opp_cnt)

            visited[x][y] = 1   

            if not can_move:
                return (False, count)

            if win_cnt != float('inf'):
                return (True, win_cnt)
            return (False, lose_cnt)

        else:  # B 차례
            x, y = bloc
            if visited[x][y] == 0:
                return (False, count)

            win_cnt = float('inf')
            lose_cnt = count
            can_move = False

            visited[x][y] = 0   # 발판 제거

            for k in range(4):
                nx, ny = x + dx[k], y + dy[k]
                if 0 <= nx < lenR and 0 <= ny < lenC and visited[nx][ny] == 1:
                    can_move = True
                    opp_win, opp_cnt = dfs(0, visited, count + 1, aloc, [nx, ny])

                    if not opp_win:  
                        win_cnt = min(win_cnt, opp_cnt)
                    else:
                        lose_cnt = max(lose_cnt, opp_cnt)

            visited[x][y] = 1  

            if not can_move:
                return (False, count)

            if win_cnt != float('inf'):
                return (True, win_cnt)
            return (False, lose_cnt)

    win, cnt = dfs(0, visited, 0, aloc, bloc)
    return cnt



# def solution(board, aloc, bloc):
#     answer = float("inf")
#     dx = [-1,1,0,0]
#     dy = [0,0,-1,1]

#     def dfs(turn,visited,count,aloc,bloc):
#         nonlocal answer
#         if turn == 0: # a차례
#             ar,ac = aloc[0], aloc[1]
#             visited[ar][ac] = 1 # 아니지 이제 이 곳은 못 오는 곳이 맞지. 그리고 여기에 b가 있고 내가 무빙가능이면 게임 끝인거고
#             for k in range(4):
#                 nr = ar + dx[k]
#                 nc = ac + dy[k]
#                 if 0 <= nr < lenR and 0 <= nc < lenC and not visited[nr][nc]: # 발판은 있어야 가지
#                     if (ar,ac) == (bloc[0], bloc[1]): #같으면 게임 끝
#                         answer = min(answer, count) # 그리고 더 이상 이 부분은 안 봐도 되는 것 아님?
#                         return # return을 바로 해도 되나?
#                     else: # 만약 둘이 같은 발판에 없어. 그러면 a가 움직여야지
#                         dfs((turn + 1) % 2, visited, count + 1, [nr,nc], bloc)
#             #visited[ar][ac] = 0

#         if turn == 1:
#             br, bc = bloc[0], bloc[1]
#             visited[br][bc] = 1
#             for k in range(4):
#                 nr = br + dx[k]
#                 nc = bc + dy[k]
#                 if 0 <= nr < lenR and 0 <= nc < lenC and not visited[nr][nc]:
#                     if [br,bc] == aloc:
#                         answer = min(answer, count)
#                         return
#                     else:
#                         dfs((turn + 1) % 2, visited, count + 1, aloc, [nr,nc])
#             visited[br][bc] = 0 
                    

#     lenR, lenC = len(board), len(board[0])
#     visited = visited = [[1 if board[r][c] == 1 else 0 for c in range(lenC)] for r in range(lenR)]
#     dfs(0,visited,0,aloc,bloc) # turn 0은 a차례, 1은 b차례, visited로 발판 여부, count로 총 몇 번 움직였는지


#     return answer
