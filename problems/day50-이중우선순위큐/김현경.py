def solution(operations):
    q = []  

    for op in operations:
        cmd, val_str = op.split()
        val = int(val_str)
        
        if cmd == 'I':
            q.append(val)
            
        elif cmd == 'D' and len(q) > 0:
            if val == 1:
                max_val = max(q)
                q.remove(max_val)
                
            elif val == -1:
                min_val = min(q)
                q.remove(min_val)

    if not q: 
        return [0, 0]
    else:
        return [max(q), min(q)]