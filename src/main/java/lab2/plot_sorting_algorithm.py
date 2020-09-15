size = [512,1024,2048,4096]
bubble_sort = [4610232,2201932,8586324,23295844]
merge_sort = [1406003,323573,650766,1081541]
quick_sort = [2359736,196757,209940,406650]
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
