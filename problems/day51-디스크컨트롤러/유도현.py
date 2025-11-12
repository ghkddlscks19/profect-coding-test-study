import heapq

def solution(jobs):
    jobs.sort()
    num = len(jobs)
    waiting = [] 
    count = []
    now = 0
    while len(count) != num : 
        while jobs and now >= jobs[0][0] : 
            top = jobs.pop(0)
            heapq.heappush(waiting, (top[1], top[0]))

        if jobs and waiting == []:
            top = jobs.pop(0)
            now = top[0]
            heapq.heappush(waiting, (top[1], top[0]))
  

        x,y = heapq.heappop(waiting)
        now += x 
        count.append(now-y)

    return sum(count)//num
 

