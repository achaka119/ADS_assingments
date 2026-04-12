# ADS_assingments
### Name: Askar Kairatbek

### Group: IT-2501

#### Assignment 2

### Task 1: 
![Task 1](images/bankAccount%20java.png)

![Task 1](images/main%20java%20task%201.png)

In Task 1, I created a `BankAccount` class with account number, username, and balance.  
Then I used `LinkedList<BankAccount>` to store bank accounts.
The program can:
- add accounts
- display accounts
- search account by username
This task helped me learn how to use LinkedList in Java.

### Task 2: 
![Task 2](images/task%202.png)
I added two new operations: **deposit** and **withdraw**.
The program first searches for a bank account by username.  
If the account is found, the user can add money to the balance or withdraw money from it.

For deposit:
- the entered amount is added to the current balance
For withdraw:
- the entered amount is subtracted from the balance
- before withdrawing, the program checks if the balance is enough

If there is not enough money, the program shows **"Insufficient balance"**.
This task helped me understand how to update object data inside a LinkedList in Java.

### Task 3: 
![Task 3](images/task%203.png)
In Task 3, I added `Stack<String>` to store transaction history.
The program can:
- save a new transaction using `push()`
- show the last transaction using `peek()`
- remove the last transaction using `pop()`

I used stack because it works with **LIFO (Last In, First Out)**.  
This means the last transaction added is the first one removed.

### Task 4: 
![Task 4](images/task%204.png)
In Task 4, I added `Queue<String>` to manage bill payments.

The program can:
- add a bill to the queue
- process the next bill
- display all bills in the queue

I used queue because it works with **FIFO (First In, First Out)**.  
This means the first bill added to the queue is the first bill processed.

### Task 5:
![Task 5](images/task5.png)
In Task 5, I used `Queue<BankAccount>` to store account opening requests.

When a user wants to create a new bank account, the request is first added to the queue.  
After that, the admin can process the request and move it to the main `LinkedList<BankAccount>`.
I used queue because it follows **First In, First Out**.  
This means the first account request added is the first request processed.

### Task 6:
![Task 6](images/array.png)
In Task 6, I used an array to store predefined bank accounts.
I created `BankAccount[]` with a fixed size and stored 3 bank accounts inside it.

The program can:
- store bank accounts in an array
- display all array accounts

I used an array to show a **physical data structure**.  
Unlike LinkedList, an array has a fixed size and uses indexes to store elements.



