# Producer-Consumer Problem using Thread Communication in Java

## 🧵 Problem Statement

The **Producer-Consumer Problem** is a classic example of a multi-threading synchronization problem. In this implementation, we demonstrate how to solve it using Java's intrinsic lock mechanism (`synchronized`), `wait()`, `notify()`, and `notifyAll()` methods for **inter-thread communication**.

## ✅ Key Concepts

- **Producer**: Generates data and adds it to a shared buffer.
- **Consumer**: Retrieves and processes data from the buffer.
- **Buffer**: A bounded shared resource (e.g., a queue) with limited capacity.
- **Thread Communication**: Achieved using `wait()`, `notify()`, and `notifyAll()` for safe cooperation between threads.

## ⚙️ Technologies Used

- Java
- Multithreading
- `synchronized`, `wait()`, `notify()`, `notifyAll()`

## 🔁 How it Works

1. The **Producer** thread keeps producing items and adds them to a shared buffer.
2. If the buffer is **full**, the Producer calls `wait()` and waits until the Consumer removes an item.
3. The **Consumer** thread keeps consuming items from the buffer.
4. If the buffer is **empty**, the Consumer calls `wait()` and waits until the Producer adds an item.
5. After producing/consuming, the threads call `notifyAll()` to wake up any waiting threads.

## 🔐 Synchronization and Communication

- The shared buffer is protected using `synchronized` blocks/methods.
- Threads **release the lock** when calling `wait()`, allowing other threads to proceed.
- `notify()` or `notifyAll()` is used to **wake up waiting threads** when the state changes.


