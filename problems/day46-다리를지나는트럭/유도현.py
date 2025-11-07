from collections import deque

def solution(bridge_length, weight, truck_weights):
    totalTime, idx = 0, 0
    bus, weights, time, diff = deque(), deque(), deque(), deque()
    
    while idx < len(truck_weights):
        totalTime += 1
        
        # 다리 위 트럭 한 칸 이동
        for i in range(len(bus)):
            time[i] += 1
            diff[i] += 1
        
        # 다리에서 내려야 하는 트럭 제거
        while bus and diff[0] > bridge_length:
            bus.popleft()
            weights.popleft()
            time.popleft()
            diff.popleft()
        
        # 새 트럭 진입 시도
        if not bus:
            bus.append(idx)
            weights.append(truck_weights[idx])
            time.append(1)
            diff.append(1)
            idx += 1
        else:
            if sum(weights) + truck_weights[idx] <= weight:
                bus.append(idx)
                weights.append(truck_weights[idx])
                time.append(1)
                diff.append(1)
                idx += 1
    
    if bus:
        totalTime += bridge_length - diff[-1] + 1
    
    return totalTime
