size = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
fibo1_times = [1777,258,303,338,552,887,1342,2378,6401,13865,11404,21753,30918,51543,82820,112295]
fibo2_times = [5494,661,585,451,452,377,467,469,479,517,552,546,583,587,668,625]
import matplotlib.pyplot as plt

plt.clf()
plt.plot(size, fibo1_times)
plt.plot(size, fibo2_times)

plt.xlabel('Number')
plt.ylabel('Average time (nanoseconds)')
plt.title('Execution time for Fibo1 and Fibo2')
plt.legend(['fibo1', 'fibo2'], loc = 'upper left')
plt.show()
