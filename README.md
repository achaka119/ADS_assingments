# ADS_assingments
### Name: Askar Kairatbek

### Group: IT-2501

#### Assignment 1

### Task 1: 
To print digits of a number, I first called the function for `n / 10` and then printed `n % 10`.  
This helped print the digits in the correct order.

![Task 1 Screenshot](images/task+1.png)


### Task 2: 
To find the average, I used recursion to calculate the sum of all array elements.  
After finding the sum, I divided it by the number of elements.

![Task 2 Screenshot](images/task2.png)

### Task 3: 
To check if a number is prime, I tested divisibility starting from `2`.  
If the number was divisible by any smaller number, it was composite.  
If not, it was prime.

![Task 3 Screenshot](images/task3.png)

### Task 4: 
To find factorial, I used the rule:

`n! = n × (n - 1)!`

The recursion stops when `n` becomes `0` or `1`.

![Task 4 Screenshot](images/task4.png)


### Task 5:
To find the Fibonacci number, I used the formula:

`F(n) = F(n-1) + F(n-2)`

The base cases were `F(0) = 0` and `F(1) = 1`.

![Task 5 Screenshot](images/task5.png)

### Task 6:
To calculate power, I used:

`a^n = a × a^(n-1)`

The recursion stops when `n = 0`, because any number to the power of `0` equals `1`

![Task 6 Screenshot](images/task6.png)

### Task 7:
To print numbers in reverse order, I first read one number, then called the function for the remaining numbers, and printed the current number after the recursive call.  
This automatically printed the numbers in reverse.

![Task 7 Screenshot](images/task7.png)

### Task 8:
To check if a string contains only digits, I examined one character at a time.  
If all characters were digits, the function returned `"Yes"`.  
If at least one character was not a digit, it returned `"No"`.

![Task 8 Screenshot](images/task8.png)

### Task 9:
To count characters in a string, I counted one character and then called the function for the rest of the string.  
The recursion stopped when the string became empty.

![Task 9 Screenshot](images/task9.png)

### Task 10
To find the greatest common divisor, I used the Euclidean algorithm:
`gcd(a, b) = gcd(b, a % b)`

The recursion stops when `b = 0`.

![Task 10 Screenshot](images/task10.png)


![output codes 1 Screenshot](images/output_codes_1.png)
![output codes 2 Screenshot](images/output_codes_2.png)

