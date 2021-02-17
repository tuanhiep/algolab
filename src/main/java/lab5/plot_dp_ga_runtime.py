size = [1,2,3,4,5,6,7,8,9,10]
dynamic_programming = [182153,103763,119293,93116,63767,110896,91918,77773,65830,64482]
greedy_approach = [99638,72172,95502,72264,77125,65618,84889,64055,51309,89720]
import matplotlib.pyplot as plt

plt.clf()
plt.plot(size, dynamic_programming)
plt.plot(size, greedy_approach)

plt.xlabel('10 Test Cases for n=5')
plt.ylabel('Average time (nanoseconds)')
plt.title('Execution time for knapSack algorithms')
plt.legend(['dynamic_programming', 'greedy_approach'], loc = 'upper left')
plt.show()
