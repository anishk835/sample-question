# Java Coding Practice

A comprehensive collection of Java coding problems, algorithms, data structures, and design patterns for interview preparation and skill development. This repository contains solutions to problems from CodeChef, Codility, and common technical interview questions.

## 📋 Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Categories](#categories)
- [Getting Started](#getting-started)
- [Running Tests](#running-tests)
- [Topics Covered](#topics-covered)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This repository serves as a practical learning resource for Java developers preparing for technical interviews or looking to strengthen their problem-solving skills. Each solution is implemented with clarity and includes test cases where applicable.

**Technology Stack:**
- Java (JDK 8+)
- Maven 3.x
- JUnit 4.13.1

## 📁 Project Structure

```
java-coding-practice/
├── src/
│   ├── main/java/
│   │   ├── codechef/              # CodeChef competition problems
│   │   └── com/java/recruitme/
│   │       ├── algo/               # Core algorithms & data structures
│   │       ├── threads/            # Concurrency & multithreading
│   │       ├── comparator/         # Comparator implementations
│   │       ├── exceptions/         # Exception handling patterns
│   │       ├── characterCount/     # String manipulation problems
│   │       ├── expressionValidator/ # Expression parsing & validation
│   │       ├── immutableCollection/ # Immutable design patterns
│   │       ├── equalityProblem/    # equals() & hashCode() implementations
│   │       ├── innerclass/         # Inner class patterns
│   │       ├── jmx/                # Java Management Extensions
│   │       ├── kafka/              # Kafka client examples
│   │       └── primes/             # Prime number algorithms
│   └── test/java/                  # Unit tests and practice problems
└── pom.xml                         # Maven configuration
```

## 📚 Categories

### 🔢 Algorithms & Data Structures (`algo/`)

| Problem | Description | Difficulty |
|---------|-------------|------------|
| **BinaryTree.java** | Binary tree traversals (In/Pre/Post/Level order), max path sum | Medium |
| **DijkstraAlgo.java** | Shortest path algorithm for weighted graphs | Medium |
| **ManachersAlgo.java** | Longest palindromic substring in linear time | Hard |
| **StringKMPSearch.java** | Knuth-Morris-Pratt pattern matching | Medium |
| **ImplementQueueUsingStack.java** | Queue implementation using two stacks | Easy |
| **StackObjectUsingSingleArray.java** | Multiple stacks in a single array | Medium |
| **ReverseSubArray.java** | Array manipulation techniques | Easy |
| **SubMatrixSum.java** | 2D matrix range sum queries | Medium |

### 🧵 Concurrency & Multithreading (`threads/`)

| Problem | Description | Key Concepts |
|---------|-------------|--------------|
| **ProducerConsumerDemo.java** | Classic producer-consumer pattern | wait/notify, synchronization |
| **PrintEvenOdd.java** | Print even/odd numbers in sequence | Thread coordination |
| **Printevenoddsequentialusinglock.java** | Even/odd printing with ReentrantLock | Explicit locks |
| **Printoddevenusinglockonobect.java** | Even/odd with object-level locking | Monitor locks |
| **InterThreadCommunication.java** | Thread communication patterns | wait/notify mechanisms |
| **ExecutorServiceSample.java** | Thread pool management | ExecutorService, Callable, Future |
| **ArraySumCalculator.java** | Parallel array processing | Fork/Join framework |

**Test Examples:** Thread safety, data corruption prevention, semaphores, file reading concurrency

### 🔤 String & Character Problems

- **CharacterCount.java** - Character frequency analysis
- **Convertstringtointeger.java** - String to integer conversion (atoi implementation)
- **ConvertIntegerToRoman.java** - Integer to Roman numeral conversion
- **ExpressionValidator.java** - Balanced parentheses/bracket validation

### 🎯 Object-Oriented Design

- **Comparator.java** / **ComparatorImpl.java** - Custom comparator implementations
- **Player.java** - equals() and hashCode() contract demonstration
- **CopyConstructor.java** - Copy constructor pattern
- **InnerClass.java** - Inner class usage patterns
- **ReflectionUsingString.java** - Java Reflection API examples

### 🐛 Exception Handling & Error Management

- **ErraticService.java** / **ErraticServiceImpl.java** - Exception handling patterns
- **StackTraceImpl.java** - Stack trace analysis and manipulation
- **Custom Exceptions:** RandomException, RandomError, MethodNotImplementedException

### 🧪 Java Core Concepts

- **ImmutableCollection.java** - Creating immutable collections
- **FailSafe.java** - Fail-safe iterator patterns
- **Prime.java** - Prime number generation and checking algorithms

### 🏆 Competitive Programming

**CodeChef:**
- `Codechef_ZCO15004.java` - ZCO 2015 problem
- `CodilityAdjacentString.java` - Codility string manipulation challenge

## 🤖 Automated Program Execution on GitHub

**All programs run automatically on every push!** 🎉

### View Program Outputs Online

1. **Go to the [Actions tab](../../actions)** in this repository
2. Click on the latest workflow run (green ✅ = success, red ❌ = failures)
3. Click on the **"build-and-test"** job
4. Expand the workflow steps to see outputs:
   - **"Build with Maven"** - Compilation results
   - **"Run all tests"** - JUnit test execution
   - **"Run sample programs"** - Individual program outputs

**Programs that run automatically:**
- Binary Tree traversals and algorithms
- Dijkstra's shortest path algorithm
- Producer-Consumer multithreading demo
- Character count analysis
- Prime number generation

### Manual Trigger

You can also trigger the workflow manually:
1. Go to [Actions tab](../../actions)
2. Click "Java CI - Run All Programs" on the left
3. Click "Run workflow" button
4. Select branch and click "Run workflow"

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.x
- Git (for cloning the repository)

### Installation

```bash
# Clone the repository
git clone git@github.com:anishk835/sample-question.git
cd sample-question

# Build the project
mvn clean install

# Run all tests
mvn test
```

### Running Individual Examples

Most classes have a `main()` method for demonstration:

```bash
# Compile and run a specific class
mvn compile
mvn exec:java -Dexec.mainClass="com.java.recruitme.algo.BinaryTree"
mvn exec:java -Dexec.mainClass="com.java.recruitme.algo.DijkstraAlgo"
mvn exec:java -Dexec.mainClass="com.java.recruitme.threads.ProducerConsumerDemo"
```

## 🧪 Running Tests

The project uses JUnit 4.13.1 for testing.

```bash
# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=CharacterCountTest
mvn test -Dtest=ErraticServiceTest
mvn test -Dtest=ExpressionValidatorTest

# Run tests with verbose output
mvn test -X
```

### Test Coverage

Tests are organized under `src/test/java/`:
- **Unit Tests** - Test individual components and algorithms
- **Thread Tests** - Concurrent programming scenarios and edge cases
- **Integration Tests** - Service and component interaction tests

## 📖 Topics Covered

### Data Structures
- Binary Trees (traversal, max path sum)
- Stacks and Queues
- Arrays and Matrices
- Graphs (Dijkstra's algorithm)

### Algorithms
- **Searching:** KMP string search, binary search
- **String Processing:** Manacher's algorithm (longest palindrome)
- **Graph Algorithms:** Dijkstra's shortest path
- **Dynamic Programming:** Max path sum, subarray problems

### Java Concurrency
- Thread synchronization (synchronized, wait/notify)
- ReentrantLock and explicit locking
- Producer-Consumer pattern
- Thread pools and ExecutorService
- Semaphores
- Thread-safe collections
- Race condition prevention

### Design Patterns
- Factory pattern
- Builder pattern (immutable objects)
- Iterator pattern (fail-safe)
- Observer pattern

### Java Core
- Generics
- Collections Framework
- Exception handling
- Reflection API
- JMX (Java Management Extensions)
- Comparators and Comparable

### Integration Technologies
- Apache Kafka basics

## 💡 Learning Path

**Beginners:**
1. Start with basic data structures (BinaryTree, ImplementQueueUsingStack)
2. Practice string manipulation (CharacterCount, Convertstringtointeger)
3. Understand OOP concepts (Player, CopyConstructor, Comparator)

**Intermediate:**
1. Explore algorithms (DijkstraAlgo, StringKMPSearch)
2. Master exception handling (ErraticService, StackTrace)
3. Learn concurrent programming basics (ProducerConsumerDemo, PrintEvenOdd)

**Advanced:**
1. Study complex algorithms (ManachersAlgo, SubMatrixSum)
2. Deep dive into concurrency (ExecutorService, thread safety patterns)
3. Explore advanced Java (Reflection, JMX, Kafka integration)

## 🤝 Contributing

Contributions are welcome! If you'd like to add new problems or improve existing solutions:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-algorithm`)
3. Add your solution with tests
4. Commit your changes (`git commit -m 'Add new algorithm: XYZ'`)
5. Push to the branch (`git push origin feature/new-algorithm`)
6. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

**Author:** Anish Kumar
**GitHub:** [@anishk835](https://github.com/anishk835)

## 🎓 Acknowledgments

- CodeChef and Codility for problem inspirations
- Java community for best practices and patterns
- Contributors and reviewers

---

**⭐ Star this repository if you find it helpful!**

*Last updated: March 2026*
