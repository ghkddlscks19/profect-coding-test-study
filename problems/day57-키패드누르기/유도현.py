def solution(numbers, hand):
    # 각 키에서 0~9키 까지의거리(키:[각 번호까지의 거리])
    key = {0: [0, 4, 3, 4, 3, 2, 3, 2, 1, 2],  
           1: [4, 0, 1, 2, 1, 2, 3, 2, 3, 4],
           2: [3, 1, 0, 1, 2, 1, 2, 3, 2, 3],
           3: [4, 2, 1, 0, 3, 2, 1, 4, 3, 2],
           4: [3, 1, 2, 3, 0, 1, 2, 1, 2, 3],
           5: [2, 2, 1, 2, 1, 0, 1, 2, 1, 2],
           6: [3, 3, 2, 1, 2, 1, 0, 3, 2, 1],
           7: [2, 2, 3, 4, 1, 2, 3, 0, 1, 2],
           8: [1, 3, 2, 3, 2, 1, 2, 1, 0, 1], 
           9: [2, 4, 3, 2, 3, 2, 1, 2, 1, 0],
           '*': [1, 3, 4, 5, 2, 3, 4, 1, 2, 3],
           '#': [1, 5, 4, 3, 4, 3, 2, 3, 2, 1]
          } 
          
    left, right = '*', '#'
    result = ''
    for i in numbers:
        if i in [1, 4, 7]:
            result += 'L'
            left = i
        elif i in [3, 6, 9]:
            result += 'R'
            right = i
        else:
            # 거리
            ll = key[left][i]
            rr = key[right][i]
            if ll == rr:
                if hand == 'right':
                    right = i
                    result += 'R'
                else:
                    left = i
                    result += 'L'
            elif ll < rr:
                left = i
                result += 'L'
            else:
                right = i
                result +='R'
                
    return result