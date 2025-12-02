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

            visited[x][y] = 1   # 🔁 상태 복원

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

            visited[x][y] = 1   # 🔁 복원

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
#             # 여기서 밢판이 없어서 여기로 왔어. 근데 여기서 풀어버리면 

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
                    

#     lenR, lenC = len(board), len(board[0])
#     visited = visited = [[1 if board[r][c] == 1 else 0 for c in range(lenC)] for r in range(lenR)]
#     dfs(0,visited,0,aloc,bloc) # turn 0은 a차례, 1은 b차례, visited로 발판 여부, count로 총 몇 번 움직였는지


#     return answer

#dfs의 핵심은 돌아갈 때는 다시 돌려놔야 한다는 것이야

# 저렇게 반복을 돌리면 현재 반복에서는 상대방 발판이 있는 곳에 가는게 최선이지만 그걸 모르고 가기 싫다고 안 가면
# 다음 반복들에서는 만약 갈 수 있는 발판이 없다면 난 1턴을 더 버틸 수 있는데 못 버티는 상황이 됨
# 그러니 가는게 맞음, 그래서 경우의 수를 세는거임.






# - 문제 정리
# 양 플레이어가 캐릭터를 몇 번 움직일지
# 상하좌우 중 하나로 옮겨야 하고 옮기는 순간 원래 발판은 사라짐
# 움직일 수 없으면, 같은 발판에 있다가 상대가 먼저 나가면 패배
# 즉 2번 째 조건은 내가 서 있는 발판(남이 서 있는 발판에 내가 들어가면)에 누가 들어오면
# 그 때 이제 다음 차례에 움직일 수 있는 발판이 생기면 내가 이기게 되는거네
# 게임은 항상 플레이어 A가 먼저 시작
# 시작 지점이 같을 수 있다는 것은 A가 움직일 수 있으면 1, 없으면 0 Return

# 풀이 방법 정리
# 모든 경우의 수 중에서 최솟 값을 구하면 돼, 이기려는 사람은 가장 빨리 끝내려고 할 테니깐
# 격자판의 크기까지 작으니깐 이제 이것은 dfs?