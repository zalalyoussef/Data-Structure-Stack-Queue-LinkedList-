# LW1A: Data Structures - Stack, Queue, and LinkedList Implementations

This repository contains the solution for **LW1A**, focusing on implementing fundamental data structures and solving practical problems using **Stacks**, **Queues**, and **LinkedLists**. The lab covers both compulsory and optional tasks, with an emphasis on understanding and working with these data structures, testing their functionality, and solving algorithmic challenges.

---

## Project Overview

The project is split into two parts: **Compulsory** (7 points) and **Optional** (3 points). In the **Compulsory** part, you will implement essential operations for Stack and Queue data structures using both array and linked list-based implementations. You will also solve algorithmic problems that utilize these structures, such as checking balanced parentheses and implementing a moving average filter. In the **Optional** part, additional challenges like advanced stack-based operations and custom filter implementations are offered to further enhance your understanding of data structures and algorithms.

---

## Compulsory Part (7 Points)

### 1. **Setup the Project**
- Download and set up the corresponding IDE project for IntelliJ or NetBeans.
- Ensure the project runs correctly.  
  _Points: 1_

### 2. **LinkedList Operations**
- Implement unimplemented LinkedList operations (e.g., add, remove, contains, etc.) in the `LW1_Intro` project and test them.  
  _Points: 2_

### 3. **Stack Interface**
- Create a generic `Stack<E>` interface with methods:
  - `E pop()` - Removes and returns the first item in the stack.
  - `void push(E item)` - Inserts a new element at the beginning.
  - `E peak()` - Returns the first element without removing it.
  - `boolean isEmpty()` - Checks if the stack is empty.

### 4. **ArrayStack and LinkedListStack**
- Implement the `Stack<E>` interface in two classes:  
  - `ArrayStack<E>`: A stack based on an array (using `ArrayList<E>`).
  - `LinkedListStack<E>`: A stack based on a linked list (using `LinkedList<E>` or a custom `LinkedList` class).  
  Test the stack operations.  
  _Points: 2_

### 5. **Queue Interface**
- Create a generic `Queue<E>` interface with methods:
  - `void enqueue(E item)` - Adds a new item to the queue.
  - `E dequeue()` - Removes and returns the first item in the queue.
  - `E peak()` - Returns the first item without removing it.
  - `boolean isEmpty()` - Checks if the queue is empty.

### 6. **ArrayQueue and LinkedListQueue**
- Implement the `Queue<E>` interface in two classes:
  - `ArrayQueue<E>`: A queue based on an array (`ArrayList<E>`).
  - `LinkedListQueue<E>`: A queue based on a linked list (`LinkedList<E>` or custom class).  
  Test the queue operations.  
  _Points: 2_

---

## Optional Part (3 Points)

### **Task 1: Parentheses Balancing (1 point)**
- Implement an algorithm to check if a string of parentheses is balanced using a **Stack**. The input string can contain the characters `{`, `}`, `[`, `]`, `(`, and `)`.  
  The algorithm should have O(n) time complexity, and examples are provided for testing.

### **Task 2: Moving Average Filter (1 point)**
- Implement a moving average filter of length `k` (1 < k <= 10) on a sequence of real numbers.  
  The input should be a sequence of length `N`, and the output should be a sequence of the same length, with each element calculated as the average of the last `k` elements.  
  Ensure the algorithm runs with O(kn) complexity.

### **Task 3: Printer Management System (1 point)**
- Simulate a printer management system that processes document print jobs based on the queue.  
  The printer processes one page of a document at a time and returns it to the queue until the document is complete. The result should show the order of printed pages.

---

## Additional Tasks (Optional)
In addition to the basic tasks, you can tackle more advanced problems, such as:
- Find the maximum depth of the bracket pairs in Task 1.
- Replace the moving average filter with median, minimum, or maximum filters in Task 2.
- Modify the printer simulation to include a priority attribute for tasks in Task 3.

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/LW1A-DataStructures.git
   ```
2. Open the project in IntelliJ or NetBeans.
3. Implement the required methods in `ArrayStack`, `LinkedListStack`, `ArrayQueue`, and `LinkedListQueue`.
4. Solve the algorithmic tasks in the optional section.
5. Run the tests and verify the correctness of your solutions.

---

## License

This project is intended for educational purposes and is licensed under the MIT License.

---
