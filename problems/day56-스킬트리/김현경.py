def solution(skill, skill_trees):
    answer = 0
    for i in skill_trees:
        skill2=""
        for j in i:
            if j in skill:
                skill2+=j
        if skill.startswith(skill2):
            answer+=1
    return answer