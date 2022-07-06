def binary_search(list, item):
    low = 0
    high = len(list)-1

    while low<= high:
        # 파이썬 3.x 버전에서는 //를 사용
        mid = (low + high) // 2
        guess = list[mid]

        if guess == item:
            return mid
        if guess > item:
            high = mid - 1
        else:
            low = mid + 1

my_list = [1, 3, 5, 7, 9]

print(binary_search(my_list, 3))
