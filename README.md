# Java Stream API Practice & Problem Solutions

A curated repository dedicated to mastering the **Java 8+ Stream API** through hands-on coding exercises, real-world examples, and interview-ready patterns. This repository explores functional data processing pipelines, transformation techniques, reductions, aggregations, and advanced collectors.

---

## 📖 Concept Overview: Java Stream API

Introduced in Java 8, the **Stream API** (`java.util.stream`) provides a functional, declarative approach to processing sequences of elements. Unlike traditional collections, streams do not store data; instead, they convey elements from a source (collections, arrays, I/O channels) through a pipeline of computational operations.

### Key Characteristics

1. **Declarative Style**: Write *what* you want to achieve rather than *how* to iterate (eliminating boilerplate `for`/`while` loops).
2. **Pipelining**: Chain multiple operations together. A stream pipeline consists of:
   - **Source**: Collection, array, or generator function (e.g., `list.stream()`).
   - **Intermediate Operations**: Transform a stream into another stream (e.g., `filter`, `map`, `flatMap`, `sorted`, `distinct`).
   - **Terminal Operations**: Produce a result or side-effect and close the stream (e.g., `collect`, `forEach`, `reduce`, `count`, `sum`, `min`, `max`).
3. **Lazy Evaluation**: Intermediate operations are not executed until a terminal operation is invoked. This allows query optimizations like short-circuiting.
4. **Immutability & Non-Interference**: Streams do not modify the underlying data source.

---

## 📂 Project Structure & Solved Problems

Below is a breakdown of each class in `src/stream_api/` and the specific problems solved within them:

### 1. [Employee.java](file:///p:/WORKSPACE/ZBS/JAVA/JAVA_PRACTICE/src/stream_api/Employee.java)
Demonstrates object-oriented stream processing and complex downstream aggregations using `Collectors`.

- **Domain Model**: `Employee` with `name`, `department`, and `salary` attributes.
- **Problems Solved**:
  - **Distinct Departments**: Extracted all unique department names from an employee list using `map(Employee::getDepartment)` and `distinct()`.
  - **Grouping by Department**: Grouped employee names by department into a `Map<String, List<Employee>>` using `Collectors.groupingBy()`, then formatted and printed them using `Collectors.joining(", ")`.
  - **Highest Paid Employee per Department**: Grouped employees by department and found the top earner in each department using `Collectors.groupingBy()` combined with `Collectors.collectingAndThen()`, `Collectors.maxBy()`, and chained `Comparator.comparingDouble(...).thenComparing(...)`.

---

### 2. [EvenNumbers.java](file:///p:/WORKSPACE/ZBS/JAVA/JAVA_PRACTICE/src/stream_api/EvenNumbers.java)
Focuses on filtering, numerical transformations, custom sorting, and prime number algorithms.

- **Problems Solved**:
  - **Filter, Transform & Sort**: Filtered numbers from a list where `num % 2 == 0 && num > 5`, mapped them to their squares (`num * num`), and sorted them in descending order using custom comparator `(a, b) -> Integer.compare(b, a)`.
  - **Prime Algorithms**: Implemented helper logic (`isPrime` and `sumOfPrimes`) to verify primes and find pairs of prime numbers that sum up to a target integer.

---

### 3. [FlatMapPractice.java](file:///p:/WORKSPACE/ZBS/JAVA/JAVA_PRACTICE/src/stream_api/FlatMapPractice.java)
Explores flattening nested structures and 1-to-N transformations using `flatMap()`.

- **Problems Solved**:
  - **Word Extraction & Deduplication**: Flattened a list of sentences into individual words via `flatMap(sentence -> Arrays.stream(sentence.split(" ")))`, transformed to lowercase, and extracted distinct words.
  - **Flattening Nested Collections**: Flattened a 2D list `List<List<Integer>>` into a 1D `List<Integer>`, then filtered for even numbers.
  - **Cartesian Product**: Computed all pairwise combinations (Cartesian product) of two lists (letters & digits) using nested `flatMap` and `map`.

---

### 4. [NameFilter.java](file:///p:/WORKSPACE/ZBS/JAVA/JAVA_PRACTICE/src/stream_api/NameFilter.java)
Demonstrates fundamental filtering, string manipulation, and method references.

- **Problems Solved**:
  - **Prefix Filtering & Case Transformation**: Filtered strings starting with `"A"` or `"a"` using `filter(name -> name.startsWith("A") || name.startsWith("a"))`, converted matching strings to uppercase using `map(String::toUpperCase)`, and printed them using method reference `forEach(System.out::println)`.

---

### 5. [RemoveDupStrings.java](file:///p:/WORKSPACE/ZBS/JAVA/JAVA_PRACTICE/src/stream_api/RemoveDupStrings.java)
Covers distinct filtering and sorting on string collections.

- **Problems Solved**:
  - **Deduplication & Lexicographical Sorting**: Removed duplicate strings using `distinct()` and sorted them alphabetically in natural order using `sorted()`.

---

### 6. [StringLengthCount.java](file:///p:/WORKSPACE/ZBS/JAVA/JAVA_PRACTICE/src/stream_api/StringLengthCount.java)
Focuses on counting elements matching specific predicate conditions.

- **Problems Solved**:
  - **Count Predicate Matches**: Counted how many strings in a list have a length greater than 4 using `filter(name -> name.length() > 4)` followed by the terminal operation `count()`.

---

### 7. [SumMinMaxAvg.java](file:///p:/WORKSPACE/ZBS/JAVA/JAVA_PRACTICE/src/stream_api/SumMinMaxAvg.java)
Comprehensive guide to numeric reductions and statistical operations using primitive streams and `reduce()`.

- **Problems Solved**:
  - **Sum Calculation**:
    - Via primitive specialization: `mapToInt(Integer::intValue).sum()`
    - Via accumulator reduction: `reduce(0, (a, b) -> a + b)`
  - **Minimum Value**:
    - Via built-in terminal: `min(Integer::compare).orElse(-1)`
    - Via binary reduction: `reduce((a, b) -> a < b ? a : b)`
  - **Maximum Value**:
    - Via built-in terminal: `max(Integer::compare).orElse(...)`
    - Via binary reduction: `reduce((num1, num2) -> num1 > num2 ? num1 : num2)`
    - Via method reference reduction: `reduce(Math::max)`
  - **Average Calculation**:
    - Computed total sum via `reduce(0, Integer::sum)` and calculated the arithmetic mean over collection size.

---

## 🎯 Java Stream API: Interview Preparation Guide

This section is tailored specifically for technical interviews (Junior to Senior Java roles).

### 1. High-Frequency Conceptual Questions

#### Q1: What is the difference between Intermediate and Terminal Operations?
- **Intermediate Operations**: Return a new `Stream`. They are **lazy** and do not execute until a terminal operation is called.
  - *Stateless*: Elements are processed independently (e.g., `filter`, `map`, `flatMap`).
  - *Stateful*: Processing an element depends on other elements (e.g., `distinct`, `sorted`, `limit`, `skip`).
- **Terminal Operations**: Traverse the stream pipeline to produce a result or side-effect (e.g., `collect`, `reduce`, `count`, `forEach`). Once executed, the stream is **consumed and cannot be reused**.

#### Q2: What is the difference between `map()` and `flatMap()`?
- **`map()` (1-to-1)**: Transforms each element into another object. `Stream<T>` becomes `Stream<R>`.
  - Example: `["hello", "world"]` $\rightarrow$ `[5, 5]`
- **`flatMap()` (1-to-Many / Flattening)**: Transforms each element into a `Stream`, then flattens all resulting streams into a single continuous stream. `Stream<List<T>>` becomes `Stream<T>`.
  - Example: `[["a", "b"], ["c"]]` $\rightarrow$ `["a", "b", "c"]`

#### Q3: Can a Stream be reused after a terminal operation?
**No.** Streams are single-use objects. Calling any operation on an already-consumed stream throws an `IllegalStateException` ("*stream has already been operated upon or closed*"). To reprocess, you must create a new stream from the source collection.

#### Q4: Why should we use Primitive Streams (`IntStream`, `LongStream`, `DoubleStream`)?
Using `Stream<Integer>` incurs significant overhead due to boxing/unboxing `int` $\leftrightarrow$ `Integer`. Primitive streams avoid boxing penalties and provide convenient numeric aggregation methods like `.sum()`, `.average()`, `.summaryStatistics()`, and `.rangeClosed()`.

```java
// Avoid: Boxed arithmetic
int sum = numbers.stream().reduce(0, Integer::sum);

// Recommended: Primitive stream specialization
int sum = numbers.stream().mapToInt(Integer::intValue).sum();
```

#### Q5: What is the difference between `groupingBy` and `partitioningBy`?
- **`Collectors.groupingBy()`**: Classifies elements based on a classification function; returns `Map<K, List<V>>` with arbitrary key types.
- **`Collectors.partitioningBy()`**: Specialized grouping taking a `Predicate<T>`; always returns `Map<Boolean, List<V>>` with exactly two keys (`true` and `false`).

#### Q6: When should you NOT use Parallel Streams (`parallelStream()`)?
- For small datasets (the overhead of thread splitting and merging outweighs parallel execution).
- When operations involve shared mutable state or blocking I/O calls.
- When stream operations depend on strict ordering (e.g., `findFirst`, `limit`).
- Parallel streams use the shared `ForkJoinPool.commonPool()` by default, which can starve other parts of your application if blocked.

---

### 2. Top 10 Must-Know Coding Snippets

#### 1. Frequency of each character in a String
```java
String input = "streamapiinjava";
Map<Character, Long> charCount = input.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
```

#### 2. Find the first non-repeating character in a String
```java
String input = "swiss";
Character result = input.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
    .entrySet().stream()
    .filter(entry -> entry.getValue() == 1L)
    .map(Map.Entry::getKey)
    .findFirst()
    .orElse(null); // 'w'
```

#### 3. Find the Second Highest Number in a List
```java
List<Integer> numbers = Arrays.asList(10, 25, 87, 45, 98, 98, 32);
Integer secondHighest = numbers.stream()
    .distinct()
    .sorted(Comparator.reverseOrder())
    .skip(1)
    .findFirst()
    .orElseThrow(() -> new NoSuchElementException("Not enough elements"));
```

#### 4. Partition numbers into Even and Odd
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
Map<Boolean, List<Integer>> evenOddMap = numbers.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
// evenOddMap.get(true) -> [2, 4, 6, 8]
// evenOddMap.get(false) -> [1, 3, 5, 7]
```

#### 5. Find Duplicate Elements in a List
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);
Set<Integer> duplicates = numbers.stream()
    .filter(n -> Collections.frequency(numbers, n) > 1)
    .collect(Collectors.toSet());

// Alternative using a Set tracker for O(N) performance:
Set<Integer> seen = new HashSet<>();
Set<Integer> dupes = numbers.stream()
    .filter(n -> !seen.add(n))
    .collect(Collectors.toSet());
```

#### 6. Find Average Salary of Employees in each Department
```java
Map<String, Double> avgSalaryByDept = employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.averagingDouble(Employee::getSalary)
    ));
```

#### 7. Find the Longest String in a List
```java
List<String> words = Arrays.asList("Java", "SpringBoot", "Microservices", "Docker");
String longest = words.stream()
    .max(Comparator.comparingInt(String::length))
    .orElse("");
```

#### 8. Concatenate Two Lists and Remove Duplicates
```java
List<String> list1 = Arrays.asList("A", "B", "C");
List<String> list2 = Arrays.asList("B", "C", "D");

List<String> merged = Stream.concat(list1.stream(), list2.stream())
    .distinct()
    .collect(Collectors.toList());
```

#### 9. Check if Two Strings are Anagrams
```java
String s1 = "listen", s2 = "silent";
boolean isAnagram = s1.length() == s2.length() &&
    Arrays.equals(
        s1.chars().sorted().toArray(),
        s2.chars().sorted().toArray()
    );
```

#### 10. Generate Summary Statistics on Numbers
```java
IntSummaryStatistics stats = numbers.stream()
    .mapToInt(Integer::intValue)
    .summaryStatistics();

System.out.println("Max: " + stats.getMax() + ", Min: " + stats.getMin() + 
                   ", Avg: " + stats.getAverage() + ", Sum: " + stats.getSum());
```

---

### 3. Common Pitfalls & Anti-Patterns to Avoid

| Pitfall | Problem | Best Practice |
| :--- | :--- | :--- |
| **Mutating State in `forEach()`** | Side-effects break thread safety and violate functional purity. | Use `.collect()` or `.reduce()` to accumulate results. |
| **Reusing Streams** | Throws `IllegalStateException`. | Generate a fresh stream pipeline from the collection. |
| **Ignoring Null Values** | Causes unexpected `NullPointerException` during method calls. | Add `.filter(Objects::nonNull)` early in the pipeline. |
| **Using `forEach()` instead of `map()`** | Imperative style defeating the purpose of functional streams. | Use `.map()` for transformations and `.collect()` to store. |
| **Unbounded Infinite Streams** | `Stream.iterate()` or `Stream.generate()` without `.limit()` causes an infinite loop / out of memory. | Always supply a `.limit()` or termination predicate. |

---

## 🛠️ Stream API Quick Reference Cheat Sheet

| Operation | Type | State | Description | Example |
| :--- | :--- | :--- | :--- | :--- |
| `filter(Predicate)` | Intermediate | Stateless | Retains elements matching condition | `.filter(n -> n % 2 == 0)` |
| `map(Function)` | Intermediate | Stateless | Transforms each element (1-to-1) | `.map(String::toUpperCase)` |
| `flatMap(Function)` | Intermediate | Stateless | Flattens 1-to-N stream mappings | `.flatMap(List::stream)` |
| `distinct()` | Intermediate | Stateful | Removes duplicate elements | `.distinct()` |
| `sorted(Comparator)` | Intermediate | Stateful | Sorts elements | `.sorted(Comparator.reverseOrder())` |
| `limit(n)` / `skip(n)` | Intermediate | Stateful | Truncates or skips elements | `.limit(5).skip(2)` |
| `forEach(Consumer)` | Terminal | - | Performs side-effect action for each element | `.forEach(System.out::println)` |
| `collect(Collector)` | Terminal | - | Collects into collections / aggregates | `.collect(Collectors.toList())` |
| `reduce(...)` | Terminal | - | Combines elements into a single value | `.reduce(0, Integer::sum)` |
| `count()` | Terminal | - | Returns number of elements | `.count()` |
| `min()` / `max()` | Terminal | - | Finds minimum / maximum element | `.max(Integer::compare)` |
| `anyMatch()` / `allMatch()` | Terminal | - | Short-circuiting predicate evaluation | `.anyMatch(x -> x > 10)` |

---

## 🚀 Running the Code

You can compile and run any of the practice classes directly using Java:

```bash
# Compile all source files into the out directory
javac -d out src/stream_api/*.java

# Run a specific class
java -cp out stream_api.Employee
java -cp out stream_api.SumMinMaxAvg
java -cp out stream_api.FlatMapPractice
java -cp out stream_api.EvenNumbers
```
