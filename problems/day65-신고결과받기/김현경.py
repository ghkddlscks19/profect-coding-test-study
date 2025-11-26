def solution(id_list, report, k):
    answer = [0] * len(id_list) # 신고한 사람중 메일받는사람 수
    dict={}
    arr=[[] for _ in range(len(id_list))] #각 신고한 사람이 누군지 저장
    numList = [0] * len(id_list) # 내가 신고당항 횟수
    
    for i in range(len(id_list)):
        dict[id_list[i]] = i
        
    # print(dict)
    real_report = list(set(report))
    #print(real_report)
    for i in real_report:
        a, b = i.split()
        report = dict[a]
        reported = dict[b]
        arr[report].append(reported)
        numList[reported]+=1
        #print(arr)
        # print("%s %d"%(a, report))
        # print("%s %d"%(b,reported))
        #print("%d %d" %(report,reported))
    # print("arr",arr)
    # print("numList", numList)
    for i in range(len(numList)):
        if numList[i]>=k:
            numList[i] = -1
    #print("numList", numList)
            
    for i in range(len(arr)):
        for j in arr[i]:
            if numList[j] == -1:
                answer[i]+=1

    return answer