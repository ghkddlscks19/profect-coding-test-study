def toBinary(number):
    temp = []
    while number > 0:
        temp.append(number % 2)
        number //= 2
    lenTemp = len(temp)
    totalLen, count = 1,1
    while totalLen < lenTemp:
        totalLen = (2 ** count) - 1
        count += 1
    for i in range(totalLen-lenTemp):
        temp.append(0)
    temp.reverse()
    return temp

def valid_tree(s, l, r):
    if l > r:
        return True
    mid = (l + r) // 2
    root = s[mid]
    if root == 0:
        if 1 in s[l:r+1]:
            return False
        return True
    return valid_tree(s,l,mid-1) and valid_tree(s, mid+1, r)

def solution(numbers):
    answer = []
    
    for number in numbers:
        flag = 0
        binaryList = toBinary(number)        
        if valid_tree(binaryList,0,len(binaryList)-1):
            answer.append(1)
        else:
            answer.append(0)

    return answer

numbers = [63, 111, 95]
print(solution(numbers))
1011 <- 11


# 숫자들이 주어질 때 해당 숫자들을 이진 트리로 만들 수 있냐 없냐인데 깊이와 상관 없이 왼쪽부터 무조건 살펴보는거다.
# 포화 이진트리는 모든 레벨의 노드가 꽉 차 있는 것이다. 더미노드라는 것은 무조건 많이 추가할 수 있긴 하지만 이건 사실 의미가 없지
# 더미 노드의 값은 0이니깐 그냥 이진트리로 기본 형태가 존재하는게 좋지
# 루트만 있을 경우 가능한 값 1,2
# 왼쪽 자식만 있을 경우 6, 오른쪽 자식만 있을 경우 3   어떻게든 4와 5는 무조건 안 된다. 
# 근데 이 이진트리란 게 어떻게든 표현이 가능한데
# 7이란 숫자는 다양하게 만들 수 있지
# 그러면 먼저 숫자가 주어졌을 때 이걸 이진법으로 바꿔봐 63 111111 1이 뒤에섯부터 6개만 있으면 된다.
# 포화 이진트리가 아닌 이상 더미 노드는 꼭 추가해줘야해 6개는 포화이진트리가 아니니 더미 노드가 맨 앞에만 들어가면 돼
# 95는 왜 이진트리로 만들 수 없을까?     1011111 <- 이건데 더미 노드 밑에 원래 노드가 있을 수는 없기떄문에 안 되지
# 0이란 숫자가 그러면 있을 수 없는 위치가 있네 2번째랑 5번째에는 위치할 수 없어
# 010, 011,111, 110, 1, 1,2,3,6,7만 되지
# 그럼만약 다음 15개에 있을때는 하... 근데 한 쪽으로만 깊어진 이진트리라고 했을 때 반대쪽에서는 그냥 더미 노드가 들어갈 수 있음
# 1101111 이진수로 나타내고 이게 이진 트리로 가능한 건지 아닌지만 보면 되는건데
# 1111000 <- 120은 이렇게 만들 수 있지, 그러면 이제 0의 위치가 가능한 위치냐? 왜냐하면 불가능한 위치
# 1, 111<- 가운데가 높은 위치
# 1111111 # 홀수번째 idx가 밑에 노드보다 높은 idx다. 여기서 높은 위치에도 불구하고 1,0만은 안 돼
# 그러니까 홀수번째 idx가 0인데 바론 왼쪽 Idx가 1이면 이제 이거는 만들 수 없는거야