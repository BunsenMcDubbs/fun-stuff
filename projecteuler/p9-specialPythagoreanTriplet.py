import math

for i in range(1, 1001):
	for j in range(i, 1000):
		k = math.sqrt(i * i + j * j)
		sum = i + j + k
		if sum == 1000:
			print sum
			print i
			print j
			print k
			print i * j * k
