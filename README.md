# ADS_assingments
### Name: Askar Kairatbek

### Group: IT-2501

#### Assignment 3

# Sorting and Searching Algorithm Analysis System
## 1. Project Overview
This project compares the performance of sorting and searching algorithms in Java.

I selected these algorithms:
- Insertion Sort as the basic sorting algorithm
- Heap Sort as the advanced sorting algorithm
- Binary Search as the searching algorithm
The purpose of this experiment is to measure execution time using `System.nanoTime()` and 
compare how the algorithms perform on different array sizes and input types.

The program tests:
- Small arrays with 10 elements
- Medium arrays with 100 elements
- Large arrays with 1000 elements
- Random arrays
- Sorted arrays

## 2. Algorithm Descriptions

### Insertion Sort

Insertion Sort is a simple sorting algorithm. 
It builds the sorted part of the array one element at a time. 
Each new element is compared with the previous elements and placed in the correct position.

Time complexity:
- Best case: O(n), when the array is already sorted
- Average case: O(n²)
- Worst case: O(n²)

### Heap Sort

Heap Sort is an advanced sorting algorithm. It first builds a max heap from the array. 
Then it repeatedly moves the largest element to the end of the array and fixes the heap structure.

Time complexity:
- Best case: O(n log n)
- Average case: O(n log n)
- Worst case: O(n log n)

### Binary Search

Binary Search is a searching algorithm that works only on sorted arrays. 
It checks the middle element of the array. If the target is smaller, it searches the left half. 
If the target is larger, it searches the right half.

Time complexity:
- Best case: O(1)
- Average case: O(log n)
- Worst case: O(log n)

## 4. Analysis Questions
### Which sorting algorithm performed faster? Why?
Heap Sort performed faster than Insertion Sort for larger arrays.
This is because Heap Sort has O(n log n) time complexity,
while Insertion Sort has O(n²) time complexity in the average and worst cases.

### How does performance change with input size?
As the input size increased, both algorithms took more time.
However, Insertion Sort became much slower when the array size increased because it uses nested comparisons and shifting.
Heap Sort increased more slowly because it has better time complexity.

### How does sorted vs unsorted data affect performance?

Insertion Sort performs much better on sorted arrays because it does not need to move many elements.
Its best case is O(n).
Heap Sort is less affected by whether the array is sorted or random
because it always builds a heap and extracts elements.

### Do the results match the expected Big-O complexity?

Yes, the results mostly match the expected Big-O complexity.
Insertion Sort became slower for larger random arrays, which matches O(n²). 
Heap Sort performed better for large arrays, which matches O(n log n).

### Which searching algorithm is more efficient? Why?

Binary Search is very efficient because it divides the search area in half each time. 
Its time complexity is O(log n), which is faster than Linear Search’s O(n).

### Why does Binary Search require a sorted array?

Binary Search requires a sorted array because it uses the middle value to decide whether to search the left half or the right half. 
If the array is not sorted, the algorithm cannot know which side contains the target.

### Screenshots

### Program Output
![Program Output](docs/images/output1.png)

### Second Test Run
![Second Test Run](docs/images/output2.png)

## 6. Reflection

In this assignment, I learned how different algorithms can have different performance depending on the input size and input type. 
I saw that Insertion Sort can work well for small or already sorted arrays, but it becomes slower for large random arrays. 
Heap Sort was more efficient for large arrays because its time complexity is O(n log n).

I also learned that theoretical Big-O complexity and real execution time are related, 
but the exact time can change depending on the computer, Java runtime, and random data. 
One challenge I faced was making sure Binary Search was used only on a sorted array, 
because it cannot work correctly on unsorted data.
