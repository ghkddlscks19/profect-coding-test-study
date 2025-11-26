def solution(id_list, report, k):
    answer = [0] * len(id_list)
    toWho = dict() 
    isReported = dict() 
    sequence = dict() 
    for i in range(len(id_list)):
        sequence[id_list[i]] = i

    for info in report:
        info = info.split()

        if info[0] in toWho and info[1] in toWho[info[0]][0]:
            continue 
        if info[0] not in toWho:
            toWho[info[0]] = [{info[1]}]
        else:
            toWho[info[0]][0].add(info[1])

        if info[1] not in isReported:
            isReported[info[1]] = 1
        else: 
            isReported[info[1]] += 1



    stopped = []
    for reported, count in isReported.items():
        if count >= k:
            stopped.append(reported) 

    for reported in stopped: 
        for fp, tps in toWho.items():
            if reported in tps[0]:
                answer[sequence[fp]] += 1

    return answer