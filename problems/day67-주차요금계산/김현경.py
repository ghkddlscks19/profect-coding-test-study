import math

def solution(fees, records):
    total_minutes = {} 
    parking_status = {}  

    def time_to_minutes(time_str):
        H, M = map(int, time_str.split(':'))
        return H * 60 + M

    for record in records:
        time_str, car_num, status = record.split()
        current_time_min = time_to_minutes(time_str)
        if status == "IN":
            parking_status[car_num] = current_time_min
        else:
            in_time = parking_status.pop(car_num)
            duration = current_time_min - in_time
            total_minutes[car_num] = total_minutes.get(car_num, 0) + duration

    final_out_time = time_to_minutes("23:59")
    for car_num, in_time in parking_status.items():
        duration = final_out_time - in_time
        total_minutes[car_num] = total_minutes.get(car_num, 0) + duration

    base_time, base_fee, unit_time, unit_fee = fees
    final_fees = {}

    for car_num, total_time in total_minutes.items():
        if total_time <= base_time:
            fee = base_fee
        else:
            extra_time = total_time - base_time
            required_units = math.ceil(extra_time / unit_time)
            fee = base_fee + required_units * unit_fee
        final_fees[car_num] = fee

    sorted_car_nums = sorted(final_fees.keys())
    answer = [final_fees[car_num] for car_num in sorted_car_nums]
    
    return answer