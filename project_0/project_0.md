# Project 0 AWS playground

## Launch Instances and benchmarking

### Test CPU

1. Command
```
sysbench --test=cpu --cpu-max-prime=20000 --num-threads=8 run
```

2. Result

	1. t2.small

	```
		Running the test with following options:
		Number of threads: 8

		Doing CPU performance benchmark

		Threads started!
		Done.

		Maximum prime number checked in CPU test: 20000


		Test execution summary:
		    total time:                          29.9139s
		    total number of events:              10000
		    total time taken by event execution: 239.1646
		    per-request statistics:
		         min:                                  2.96ms
		         avg:                                 23.92ms
		         max:                                 56.25ms
		         approx.  95 percentile:              31.07ms

		Threads fairness:
		    events (avg/stddev):           1250.0000/0.50
		    execution time (avg/stddev):   29.8956/0.01
	```

	```
			Number of threads: 1
		Doing CPU performance benchmark

		Threads started!
		Done.

		Maximum prime number checked in CPU test: 40000


		Test execution summary:
		    total time:                          77.6130s
		    total number of events:              10000
		    total time taken by event execution: 77.6063
		    per-request statistics:
		         min:                                  7.69ms
		         avg:                                  7.76ms
		         max:                                 21.98ms
		         approx.  95 percentile:               7.89ms

		Threads fairness:
		    events (avg/stddev):           10000.0000/0.00
		    execution time (avg/stddev):   77.6063/0.00
	```

	2. t2.medium

	```
		Running the test with following options:
		Number of threads: 8

		Doing CPU performance benchmark

		Threads started!
		Done.

		Maximum prime number checked in CPU test: 20000


		Test execution summary:
		    total time:                          14.8918s
		    total number of events:              10000
		    total time taken by event execution: 119.0229
		    per-request statistics:
		         min:                                  2.96ms
		         avg:                                 11.90ms
		         max:                                 51.09ms
		         approx.  95 percentile:              15.00ms

		Threads fairness:
		    events (avg/stddev):           1250.0000/11.90
		    execution time (avg/stddev):   14.8779/0.01
	```

	```
			Number of threads: 1

		Doing CPU performance benchmark

		Threads started!
		Done.

		Maximum prime number checked in CPU test: 40000


		Test execution summary:
		    total time:                          77.4006s
		    total number of events:              10000
		    total time taken by event execution: 77.3940
		    per-request statistics:
		         min:                                  7.67ms
		         avg:                                  7.74ms
		         max:                                  9.96ms
		         approx.  95 percentile:               7.85ms

		Threads fairness:
		    events (avg/stddev):           10000.0000/0.00
		    execution time (avg/stddev):   77.3940/0.00
	```

	3. t2.large

	```
		Running the test with following options:
		Number of threads: 8

		Doing CPU performance benchmark

		Threads started!
		Done.

		Maximum prime number checked in CPU test: 20000


		Test execution summary:
		    total time:                          13.9730s
		    total number of events:              10000
		    total time taken by event execution: 111.6941
		    per-request statistics:
		         min:                                  2.78ms
		         avg:                                 11.17ms
		         max:                                 51.10ms
		         approx.  95 percentile:              14.82ms

		Threads fairness:
		    events (avg/stddev):           1250.0000/4.69
		    execution time (avg/stddev):   13.9618/0.01
	```

	```
			Running the test with following options:
		Number of threads: 1

		Doing CPU performance benchmark

		Threads started!
		Done.

		Maximum prime number checked in CPU test: 40000


		Test execution summary:
		    total time:                          72.5437s
		    total number of events:              10000
		    total time taken by event execution: 72.5365
		    per-request statistics:
		         min:                                  7.23ms
		         avg:                                  7.25ms
		         max:                                  7.50ms
		         approx.  95 percentile:               7.27ms

		Threads fairness:
		    events (avg/stddev):           10000.0000/0.00
		    execution time (avg/stddev):   72.5365/0.00
	```

### Test FIle IO

1. Command
```
sysbench --test=fileio --file-total-size=20G prepare
```

```
sysbench --test=fileio --file-total-size=20G --file-test-mode=rndrw --init-rng=on --max-time=300 --max-requests=0 run
```

2. Result
	1. t2.small

  ```
		  Operations performed:  293520 Read, 195680 Write, 626118 Other = 1115318 Total
		Read 4.4788Gb  Written 2.9858Gb  Total transferred 7.4646Gb  (25.479Mb/sec)
		 1630.66 Requests/sec executed

		Test execution summary:
		    total time:                          300.0012s
		    total number of events:              489200
		    total time taken by event execution: 178.9853
		    per-request statistics:
		         min:                                  0.00ms
		         avg:                                  0.37ms
		         max:                                 18.76ms
		         approx.  95 percentile:               0.69ms

		Threads fairness:
		    events (avg/stddev):           489200.0000/0.00
		    execution time (avg/stddev):   178.9853/0.00
  ```

	2. t2.medium

  ```
	  Operations performed:  233872 Read, 155914 Write, 498816 Other = 888602 Total
	Read 3.5686Gb  Written 2.3791Gb  Total transferred 5.9477Gb  (20.301Mb/sec)
	 1299.28 Requests/sec executed

	Test execution summary:
	    total time:                          300.0008s
	    total number of events:              389786
	    total time taken by event execution: 186.5389
	    per-request statistics:
	         min:                                  0.00ms
	         avg:                                  0.48ms
	         max:                                132.12ms
	         approx.  95 percentile:               1.88ms

	Threads fairness:
	    events (avg/stddev):           389786.0000/0.00
	    execution time (avg/stddev):   186.5389/0.00
  ```

	3. t2.large
  
  ```
	  Operations performed:  252932 Read, 168621 Write, 539520 Other = 961073 Total
	Read 3.8594Gb  Written 2.573Gb  Total transferred 6.4324Gb  (21.956Mb/sec)
	 1405.18 Requests/sec executed

	Test execution summary:
	    total time:                          300.0002s
	    total number of events:              421553
	    total time taken by event execution: 153.2497
	    per-request statistics:
	         min:                                  0.00ms
	         avg:                                  0.36ms
	         max:                                 34.71ms
	         approx.  95 percentile:               1.40ms

	Threads fairness:
	    events (avg/stddev):           421553.0000/0.00
	    execution time (avg/stddev):   153.2497/0.00
  ```



## Web Server Benchmarking

1. Command

```
sudo apt-get update
sudo apt-get install apache2
sudo apt-get install apache2-utils

ab -n 1000 -c 100 http://localhost/
```

2. Result

	1. t2.small

	```
	Concurrency Level:      100
	Time taken for tests:   1.785 seconds
	Complete requests:      1000
	Failed requests:        0
	Total transferred:      264000 bytes
	HTML transferred:       18000 bytes
	Requests per second:    560.36 [#/sec] (mean)
	Time per request:       178.458 [ms] (mean)
	Time per request:       1.785 [ms] (mean, across all concurrent requests)
	Transfer rate:          144.47 [Kbytes/sec] received
	```

	2. t2.medium
	
	```
	Concurrency Level:      100
	Time taken for tests:   1.930 seconds
	Complete requests:      1000
	Failed requests:        0
	Total transferred:      264000 bytes
	HTML transferred:       18000 bytes
	Requests per second:    518.13 [#/sec] (mean)
	Time per request:       193.002 [ms] (mean)
	Time per request:       1.930 [ms] (mean, across all concurrent requests)
	Transfer rate:          133.58 [Kbytes/sec] received
	```

	3. t2.large
	
	```
	Concurrency Level:      100
	Time taken for tests:   2.073 seconds
	Complete requests:      1000
	Failed requests:        0
	Total transferred:      264000 bytes
	HTML transferred:       18000 bytes
	Requests per second:    482.34 [#/sec] (mean)
	Time per request:       207.323 [ms] (mean)
	Time per request:       2.073 [ms] (mean, across all concurrent requests)
	Transfer rate:          124.35 [Kbytes/sec] received
	```






