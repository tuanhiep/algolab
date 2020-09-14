size = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
fibo1_times = [3172,375,551,492,841,1359,18015,3537,7690,10736,14990,37827,36772,58828,97349,155463,65744,31869,50773,152107,112695,187793,307083,466884,348412,569674,857109,1226155,2132080,4871576,7720808]
fibo2_times = [12541,842,654,529,461,433,466,492,605,570,566,676,624,912,824,939,789,744,875,908,843,889,945,841,961,1062,975,1034,1119,967,1275]
import matplotlib.pyplot as plt

plt.clf()
plt.plot(size, fibo1_times)
plt.plot(size, fibo2_times)

plt.xlabel('Number')
plt.ylabel('Average time (nanoseconds)')
plt.title('Execution time for Fibo1 and Fibo2')
plt.legend(['fibo1', 'fibo2'], loc = 'upper left')
plt.show()
