import heapq

def solution(ability, number):
    heap = ability[:]
    heapq.heapify(heap)
    
    for _ in range(number):
        first = heapq.heappop(heap)
        second = heapq.heappop(heap)
        
        new = first + second
        heapq.heappush(heap, new)
        heapq.heappush(heap, new)
    
    return sum(heap)