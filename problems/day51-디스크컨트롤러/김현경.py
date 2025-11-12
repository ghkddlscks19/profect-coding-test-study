import heapq

def solution(jobs):
    n = len(jobs)
    jobs.sort()

    current_time = 0 
    total_response_time = 0 
    job_index = 0 
    heap = []
    
    completed_jobs = 0
    
    while completed_jobs < n:
        while job_index < n and jobs[job_index][0] <= current_time:
            request_time, duration = jobs[job_index]
            heapq.heappush(heap, (duration, request_time))
            job_index += 1
            
        if heap:
            duration, request_time = heapq.heappop(heap)
            current_time += duration
            total_response_time += (current_time - request_time)
            completed_jobs += 1
            
        else:

            if job_index < n:
                current_time = jobs[job_index][0]

    return total_response_time // n