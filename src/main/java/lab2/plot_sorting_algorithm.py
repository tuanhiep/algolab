size = [512,1024,2048,4096]
bubble_sort = [2807219,1737710,6172898,16287862]
merge_sort = [1162649,270742,464319,719351]
quick_sort = [812118,179200,184305,381783]
import matplotlib.pyplot as plt

plt.clf()
plt.plot(size, bubble_sort)
plt.plot(size, merge_sort)
plt.plot(size, quick_sort)

plt.xlabel('Input Size')
plt.ylabel('Average time (nanoseconds)')
plt.title('Execution time for sorting algorithms')
plt.legend(['bubble_sort', 'merge_sort', 'quick_sort'], loc = 'upper left')
plt.show()
