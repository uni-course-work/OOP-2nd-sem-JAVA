# Complete Java + OOP Problem Sets Specification
This Repository is for Learning OOP with Java.
I'm aiming to Solve these problem sets during OOP course.

# Object-Oriented Programming - Problem Sets & Projects

## Problem Set 2: Java Foundations
**Time: 6-8 hours**

### Problem 1: Bytecode Detective (Warm-up)
Write a Java program that prints its own bytecode instructions. Create a simple class with different types of statements (loops, conditionals, method calls) and use `javap -c` to analyze the bytecode. Document what you discover about how Java translates your code.

**Learning**: Understand compilation, JVM, and the layer between source and execution.

### Problem 2: Type Stress Test
Create a program called `TypeLimits` that:
- Tests and prints the maximum/minimum values of all primitive types
- Demonstrates what happens during overflow/underflow
- Shows precision loss in floating-point arithmetic
- Implements a calculator that warns users about potential type issues

**Challenge**: Handle edge cases like `Integer.MAX_VALUE + 1` gracefully.

### Problem 3: Lexer Challenge ⚡
Build a simple **Java tokenizer** that reads a `.java` file and categorizes every token (keywords, identifiers, literals, operators, comments). Output should look like:
```
KEYWORD: public
KEYWORD: class
IDENTIFIER: MyClass
PUNCTUATION: {
COMMENT: // This is a test
...
```

**Why uncomfortable**: You're reverse-engineering part of what a compiler does. You'll wrestle with parsing logic, string manipulation, and edge cases (multi-line comments, string literals with special chars).

---

## Problem Set 3: Methods & Behavior Design
**Time: 8-10 hours**

### Problem 1: Method Signature Puzzle
Given a set of requirements (e.g., "convert temperature", "validate email", "calculate loan payment"), design method signatures BEFORE implementation. Focus on:
- Choosing right parameter types
- Deciding return types
- Naming conventions
- When to overload vs. create new methods

Implement 5+ utility methods demonstrating overloading meaningfully.

### Problem 2: Calculator with Memory
Build a **scientific calculator** (command-line) that:
- Performs basic operations (+, -, *, /, ^, sqrt, log)
- Maintains memory (M+, M-, MR, MC commands)
- Supports method chaining: `calc.add(5).multiply(3).sqrt()`
- Validates all inputs and handles errors

**Twist**: Everything must be methods. No main() spaghetti code.

### Problem 3: Polynomial Evaluator ⚡
Create a program that:
1. Accepts polynomial coefficients: `3x³ + 2x² - 5x + 7`
2. Evaluates at any point using **Horner's method**
3. Finds derivative symbolically
4. Implements operations: add, subtract, multiply polynomials

**Why uncomfortable**: Heavy method decomposition. You'll need separate methods for parsing, evaluation, calculus operations. Forces you to think: "What behavior belongs where?"

---

## Problem Set 4: Classes & Objects - Modeling Reality
**Time: 10-12 hours**

### Problem 1: Object Lifecycle Tracker
Create a `Person` class that:
- Tracks total people created (use counter)
- Assigns unique ID to each person
- Prints message on object creation
- Override `finalize()` to print destruction message

Create/destroy hundreds of objects and observe lifecycle behavior.

### Problem 2: Bank Account Simulator
Model a banking system with:
- `Account` class (balance, accountNumber, holder)
- Methods: deposit, withdraw, transfer, getStatement
- Interest calculation
- Transaction history (last 10 transactions)

**Key**: Each method should update object state meaningfully. Demonstrate creating multiple accounts and transferring between them.

### Problem 3: Card Deck System ⚡
Build a complete **playing card simulation**:
- `Card` class (suit, rank, comparing cards)
- `Deck` class (52 cards, shuffle, draw, remaining count)
- `Hand` class (for poker/blackjack)
- Implement shuffle algorithm (Fisher-Yates)
- Calculate poker hand rankings

Then simulate 10,000 hands of poker and output statistics on hand frequencies.

**Why uncomfortable**: Multiple classes working together, algorithms, probability verification. You'll struggle with object interactions before formally learning relationships.

---

## Problem Set 5: Encapsulation & Defensive Design
**Time: 8-10 hours**

### Problem 1: Date Class (Safe)
Create an immutable `Date` class:
- Private day, month, year
- Validation in constructor
- Getters only (no setters)
- Methods: `addDays()`, `daysBetween()`, `isLeapYear()`
- Prevent invalid dates (Feb 30, etc.)

Test with edge cases and document why immutability matters.

### Problem 2: Password Manager
Design a `SecurePassword` class that:
- Stores passwords encrypted (simple XOR cipher is fine)
- Never exposes raw password via getters
- Implements `verify(String attempt)` method
- Enforces strength requirements (length, complexity)
- Auto-locks after 3 failed attempts

**Learning**: Data hiding isn't paranoia—it's protection.

### Problem 3: Library Management System ⚡
Build a **library system** with proper encapsulation:

**Classes**:
- `Book` (title, ISBN, author, status, dueDate)
- `Member` (ID, name, borrowedBooks, fines)
- `Library` (books collection, members, transactions)

**Features**:
- Issue/return books (update status, set due dates)
- Calculate late fines (₹10/day after 14 days)
- Search books by title/author
- Member borrowing limit (max 3 books)
- Generate member report

**Why uncomfortable**: Real-world business rules. You must prevent invalid states (issuing borrowed books, returning books not issued, etc.) purely through encapsulation—no public fields allowed.

---

## Problem Set 6: Constructors & Initialization
**Time: 6-8 hours**

### Problem 1: Constructor Chaining Practice
Create a `Rectangle` class with multiple constructors:
- Default (1x1 square)
- Single parameter (square of size n)
- Two parameters (width, height)
- Copy constructor
- Constructor taking another shape and converting

Demonstrate chaining using `this()`.

### Problem 2: Object Factory
Build an `Employee` class with:
- Private constructor
- Static factory methods: `createFullTime()`, `createPartTime()`, `createIntern()`
- Each type has different validation rules
- Static counter for employee IDs

**Learning**: Constructors aren't the only way to create objects.

### Problem 3: Complex Number Library ⚡
Create a **complex number** class (`a + bi`):
- Multiple constructors (polar form, cartesian, copy)
- Static factory methods: `fromPolar(r, θ)`, `fromString("3+4i")`
- Operations: add, subtract, multiply, divide
- Methods: magnitude, phase, conjugate
- Parse complex numbers from strings with validation

Then build a **complex calculator** REPL that evaluates expressions like:
```
> (3+4i) + (1-2i)
4+2i
> (2+3i) * (1+1i)
-1+5i
```

**Why uncomfortable**: Initialization is tricky (polar vs cartesian), parsing is hard, and you need bulletproof validation. Many edge cases.

---

## Problem Set 7: Static Members & Class-Level Logic
**Time: 6-8 hours**

### Problem 1: Singleton Pattern
Implement a `DatabaseConnection` singleton:
- Private constructor
- Static instance
- `getInstance()` method
- Connection counting
- Prevent multiple instances

Demonstrate thread-safety issues by trying to break it.

### Problem 2: Utility Class Design
Create a `MathUtils` class with static methods:
- `gcd(a, b)`, `lcm(a, b)`
- `isPrime(n)`, `primeFactors(n)`
- `fibonacci(n)` (iterative and recursive)
- `factorial(n)` with memoization

Private constructor to prevent instantiation.

### Problem 3: Student Grade System ⚡
Design a grade management system:

**Classes**:
- `Student` (name, rollNo, grades Map)
- `Subject` (code, name, credits, classAverage - static)
- `GradeBook` (all students, static methods for analytics)

**Features**:
- Add students and grades
- Calculate individual GPA
- Calculate class average per subject (static)
- Find topper, class rank
- Generate transcript

**Key challenge**: Mix instance and static appropriately. Class averages are static (apply to all), but individual grades are instance-level.

**Why uncomfortable**: You'll be tempted to make everything static or everything instance. Finding the right balance is the lesson.

---

## Problem Set 8: Object Relationships & Collaboration
**Time: 12-15 hours**

### Problem 1: University Model
Design classes with proper relationships:
- `University` → `Department` (composition)
- `Department` → `Course` (aggregation)
- `Professor` → `Course` (association)
- `Student` → `Course` (enrollment - many-to-many)

Implement: enroll students, assign professors, generate department reports.

### Problem 2: E-Commerce Order System
Model an ordering system:
- `Customer` has many `Order`s (aggregation)
- `Order` has many `OrderItem`s (composition)
- `OrderItem` references `Product` (association)
- `ShoppingCart` temporarily holds items

Implement: add to cart, place order, calculate total, apply discounts, track order status.

### Problem 3: Hospital Management System ⚡
Build a **hospital system** with complex relationships:

**Classes**:
- `Patient` (id, name, age, medicalHistory, appointments)
- `Doctor` (id, name, specialization, availableSlots, patients)
- `Appointment` (patient, doctor, date, time, status, diagnosis)
- `Department` (name, doctors list)
- `Hospital` (departments, patients, appointments registry)
- `Prescription` (medicines list, dosage, duration)

**Relationships**:
- Hospital HAS departments (composition)
- Department HAS doctors (aggregation)
- Doctor HAS MANY patients (association)
- Appointment TIES patient+doctor (association)
- Patient HAS medical history (composition)

**Features**:
- Book appointment (check doctor availability)
- View patient history
- Assign doctors to departments
- Generate department-wise patient reports
- Cancel/reschedule appointments
- Issue prescriptions

**Why uncomfortable**: Real-world complexity. Multiple interacting objects, bidirectional relationships, state management across objects, and business logic spanning classes.

---

## Problem Set 9: Inheritance - Selective Reuse
**Time: 10-12 hours**

### Problem 1: Shape Hierarchy
Create inheritance chain:
```
Shape (abstract area(), perimeter())
  ├── Circle
  ├── Rectangle
  │     └── Square
  └── Triangle
```

Add: `draw()` method, `resize(factor)`, comparison by area.

### Problem 2: Employee Hierarchy
```
Employee (base class)
  ├── FullTimeEmployee (salary, benefits)
  ├── PartTimeEmployee (hourlyRate, hoursWorked)
  └── Contractor (projectRate, projectsCompleted)
```

Implement: `calculatePay()`, `grantBonus()`, `generatePaySlip()`.

### Problem 3: Vehicle Rental System ⚡
Build a **rental management system**:

**Hierarchy**:
```
Vehicle (abstract)
  ├── Car (sedan/SUV variants)
  ├── Bike (geared/non-geared)
  └── Truck (capacity-based pricing)
```

**Additional Classes**:
- `Customer` (license, rental history)
- `RentalTransaction` (vehicle, customer, dates, cost)
- `RentalAgency` (fleet management)

**Features**:
- Dynamic pricing based on vehicle type and rental duration
- Availability tracking
- Late return penalties
- Mileage-based charges for cars
- Generate rental invoice
- Maintenance tracking (vehicles need service after X km)

**Challenge**: Use inheritance for vehicle types but avoid over-inheritance. Some behavior should be in interfaces (later), some in base class, some specific to subclass.

**Why uncomfortable**: You'll struggle with: "Should this be in base class or subclass?" Forces proper use of `super`, method overriding, and protected access.

---

## Problem Set 10: Polymorphism - One Interface, Many Forms
**Time: 10-12 hours**

### Problem 1: Polymorphic Collections
Create a `Shape[]` array holding different shapes. Iterate and call `area()`, `draw()` polymorphically. Demonstrate:
- Upcasting and downcasting
- `instanceof` checks
- Runtime type identification

### Problem 2: Payment Processing
```
PaymentMethod (interface or abstract)
  ├── CreditCard (validation, processing fee)
  ├── DebitCard (balance check)
  ├── UPI (instant transfer)
  └── Cash (change calculation)
```

Process payments polymorphically. Show compile-time vs runtime binding.

### Problem 3: Media Player System ⚡
Build a **universal media player**:

**Hierarchy**:
```
Media (abstract)
  ├── Audio
  │     ├── MP3
  │     ├── WAV
  │     └── FLAC
  ├── Video
  │     ├── MP4
  │     ├── AVI
  │     └── MKV
  └── Document
        ├── PDF
        └── EPUB
```

**Classes**:
- `MediaPlayer` (polymorphic playback)
- `Playlist` (holds Media objects)
- `MediaLibrary` (search, filter, organize)

**Features**:
- Play any media type (polymorphically calls `play()`)
- Each type has specific behavior (MP3: shows bitrate, MP4: resolution, PDF: page count)
- Playlist management (add, remove, shuffle, repeat)
- Search by type, duration, size
- Format conversion (MP3→WAV, MP4→AVI) - demonstrate casting

**Why uncomfortable**: Deep polymorphism. Arrays/collections of base type holding subclass objects. Dynamic dispatch in action. You'll implement method overriding extensively and see the power (and confusion) of runtime binding.

---

## Problem Set 11: Abstraction - Designing for Change
**Time: 8-10 hours**

### Problem 1: Template Method Pattern
Create abstract `GameTemplate` class:
- `initialize()`, `startPlay()`, `endPlay()` (abstract)
- `play()` method (final, calls above in sequence)

Implement: `Chess`, `Cricket`, `VideoGame` subclasses.

### Problem 2: Data Structure Abstraction
Design abstract `DataStructure` with operations:
- `add()`, `remove()`, `search()`, `size()`

Implement: `Stack`, `Queue`, `PriorityQueue` (use arrays internally).

### Problem 3: File Format Converter ⚡
Build an **extensible file converter framework**:

**Abstract Design**:
```
FileConverter (abstract)
  - read(filename) : abstract
  - write(filename, data) : abstract
  - convert(source, dest) : final template method
  
Implementations:
  ├── CSVConverter (comma-separated)
  ├── JSONConverter (nested objects)
  ├── XMLConverter (tags)
  └── ExcelConverter (cells/sheets)
```

**Features**:
- Convert any format to any other (CSV↔JSON↔XML)
- Template method orchestrates: read→transform→write
- Each subclass implements parsing/serialization
- Handle malformed files gracefully
- Validate data structure during conversion

**Client Program**:
```java
Converter c = ConverterFactory.getConverter("csv", "json");
c.convert("input.csv", "output.json");
```

**Why uncomfortable**: You're building a framework, not just an app. Abstract classes enforce structure, final methods prevent breaking the workflow. You'll understand how libraries enforce contracts while allowing extension.

---

## Problem Set 12: Interfaces - Contracts Over Inheritance
**Time: 10-12 hours**

### Problem 1: Multiple Interface Implementation
Create interfaces: `Flyable`, `Swimmable`, `Walkable`

Implement classes:
- `Duck` (swims, flies, walks)
- `Fish` (swims only)
- `Airplane` (flies only)
- `Amphibian` (swims, walks)

Demonstrate polymorphism with interface references.

### Problem 2: Comparable & Comparator
Make `Product` class implementing `Comparable<Product>` (by price).
Create separate `Comparator` classes to sort by:
- Name
- Rating
- Popularity

Sort and display products using different strategies.

### Problem 3: Plugin-Based Text Editor ⚡
Build an **extensible text editor** using interfaces:

**Core Interfaces**:
```java
interface Plugin {
    String getName();
    void execute(TextBuffer buffer);
}

interface TextTransform extends Plugin {
    String transform(String text);
}

interface SyntaxHighlighter extends Plugin {
    String highlight(String code, String language);
}
```

**Implementations**:
- `UpperCasePlugin`, `LowerCasePlugin`, `ReversePlugin`
- `WordCountPlugin`, `SpellCheckPlugin`
- `JavaHighlighter`, `PythonHighlighter`, `MarkdownHighlighter`

**Editor Class**:
- `TextBuffer` (holds text, supports undo/redo)
- `PluginManager` (loads plugins, lists available)
- `Editor` (menu-driven interface)

**Features**:
- Load text from file
- Apply any plugin dynamically
- Chain multiple plugins
- Add new plugins without modifying editor
- Save transformed text

**Challenge**: The editor never knows about concrete plugin classes—only interfaces. New plugins are registered at runtime.

**Why uncomfortable**: Interface-driven design. You're building for extension without modification. Multiple inheritance of behavior, not structure.

---

## Problem Set 13: Packages & Organization
**Time: 6-8 hours**

### Problem 1: Package Structure Design
Organize a university system into packages:
```
edu.university.core (Person, Student, Faculty)
edu.university.academic (Course, Grade, Transcript)
edu.university.library (Book, LibraryCard)
edu.university.utils (DateUtils, Validator)
```

Demonstrate package-private access, importing, and access control.

### Problem 2: Custom Object Class
Create `MyObject` class demonstrating:
- Override `equals()`
- Override `hashCode()` (consistent with equals)
- Override `toString()`
- Override `clone()`

Test with collections (HashSet, HashMap).

### Problem 3: Reflection-Based Object Inspector ⚡
Build a **Java introspection tool**:

**Features**:
- Accept any object
- List all fields (including private)
- List all methods (including inherited)
- Show superclass hierarchy
- Display implemented interfaces
- Print field values using reflection
- Invoke methods dynamically

**Example Output**:
```
Class: java.util.ArrayList
Superclass: java.util.AbstractList
Interfaces: List, RandomAccess, Cloneable, Serializable

Fields:
  - private int size
  - private Object[] elementData

Methods:
  - public boolean add(Object)
  - public Object get(int)
  ...
```

**Why uncomfortable**: Deep dive into Java's Object model and reflection API. You'll understand what the JVM knows about your objects at runtime.

---

## Problem Set 14: Exception Handling - Failing Gracefully
**Time: 8-10 hours**

### Problem 1: Custom Exception Hierarchy
Create banking exceptions:
```
BankingException
  ├── InsufficientFundsException
  ├── InvalidAccountException
  └── TransactionFailedException
```

Implement transaction system with proper exception handling and rollback.

### Problem 2: Robust File Parser
Build a CSV parser that handles:
- File not found
- Malformed rows
- Type conversion errors
- Empty fields
- Invalid data

Use try-with-resources, multi-catch blocks, and custom exceptions.

### Problem 3: Resilient Network Client ⚡
Build a **fault-tolerant HTTP client** (simplified):

**Features**:
- Connect to URLs and fetch content
- Handle exceptions:
    - `MalformedURLException`
    - `UnknownHostException`
    - `SocketTimeoutException`
    - `IOException`
- Retry mechanism (exponential backoff)
- Circuit breaker pattern (stop after N failures)
- Logging all errors with timestamps
- Graceful degradation (fallback to cached response)

**Custom Exceptions**:
- `ConnectionTimeoutException`
- `RetryExhaustedException`
- `InvalidResponseException`

**Example Usage**:
```java
NetworkClient client = new NetworkClient();
try {
    String content = client.fetch("https://example.com", 3); // 3 retries
    System.out.println(content);
} catch (RetryExhaustedException e) {
    String cached = client.getCachedResponse();
}
```

**Why uncomfortable**: Real-world network programming is full of failures. You'll learn exception handling isn't about avoiding errors—it's about managing them intelligently.

---

## Problem Set 15: Generics & Collections - Type-Safe Reuse
**Time: 10-12 hours**

### Problem 1: Generic Stack & Queue
Implement:
- `GenericStack<T>`
- `GenericQueue<T>`
- `GenericPriorityQueue<T extends Comparable<T>>`

Use bounded type parameters, demonstrate with different types.

### Problem 2: Collection Framework Mastery
Build a student management system using:
- `ArrayList<Student>` for storage
- `HashMap<String, Student>` for ID lookup
- `TreeSet<Student>` for sorted display
- `LinkedList<Transaction>` for history

Implement search, filter, sort operations.

### Problem 3: Custom Collection Framework ⚡
Build your own **mini collection library**:

**Interfaces**:
```java
interface MyCollection<E> {
    boolean add(E element);
    boolean remove(E element);
    boolean contains(E element);
    int size();
    Iterator<E> iterator();
}

interface MyList<E> extends MyCollection<E> {
    E get(int index);
    void add(int index, E element);
}

interface MySet<E> extends MyCollection<E> {
    // No duplicate elements
}
```

**Implementations**:
- `MyArrayList<E>` (dynamic array)
- `MyLinkedList<E>` (doubly linked)
- `MyHashSet<E>` (hashtable-based)
- `MyTreeSet<E extends Comparable<E>>` (binary search tree)

**Features**:
- Auto-resizing for ArrayList
- Efficient insertion/deletion for LinkedList
- O(1) lookup for HashSet (implement hash function)
- O(log n) operations for TreeSet (BST traversal)
- Custom iterator for each collection
- Implement `forEach()` using iterators

**Test Suite**:
- Performance comparison (add 10k elements)
- Correctness tests (add, remove, contains)
- Demonstrate generics with different types

**Why uncomfortable**: You're reimplementing Java's collection framework. Deep understanding of data structures, generics, and performance trade-offs required. This is where OOP meets algorithms.

---

## Problem Set 16: File Handling & Persistence
**Time: 8-10 hours**

### Problem 1: Log File Analyzer
Read server logs, parse entries, generate statistics:
- Most frequent errors
- Response time distribution
- Traffic patterns by hour

Use BufferedReader, streams, exception handling.

### Problem 2: Configuration Manager
Build a `.properties` file handler:
- Read key-value pairs
- Support comments and sections
- Type-safe getters (getInt, getString, getBoolean)
- Write updated config back

### Problem 3: Object Database System ⚡
Build a **persistent object store** using serialization:

**Core Classes**:
- `ObjectDB<T extends Serializable>` (generic database)
- `Index<K, V>` (for fast lookups)
- `Transaction` (ACID properties)

**Features**:
- Store any serializable object to file
- Retrieve by ID or query
- Update and delete operations
- Index on specific fields (e.g., index Student by rollNo)
- Transaction support (commit/rollback)
- Batch operations (import/export)
- Compaction (remove deleted records)

**Example Usage**:
```java
ObjectDB<Student> db = new ObjectDB<>("students.db");
db.createIndex("rollNo");

db.insert(new Student("John", "S001", 3.8));
Student s = db.findByIndex("rollNo", "S001");
db.update("S001", updatedStudent);
db.delete("S001");
```

**Advanced**:
- Implement simple query language: `db.query("gpa > 3.5 AND year = 3")`
- Handle concurrent access (basic file locking)
- Crash recovery (write-ahead log)

**Why uncomfortable**: Real persistence is hard. File I/O, serialization quirks, maintaining indexes, handling corrupted data. You'll appreciate databases afterward.

---

## Problem Set 17: GUI & Event-Driven Programming
**Time: 12-15 hours**

### Problem 1: Calculator GUI
Build graphical calculator using Swing:
- Button grid layout
- Display panel
- Event handlers for operations
- Keyboard support

### Problem 2: Drawing Canvas
Create paint application:
- Freehand drawing
- Shapes (line, rectangle, circle)
- Color picker
- Undo/redo
- Save as image

### Problem 3: Chat Application (GUI) ⚡
Build a **local network chat app**:

**GUI Components** (Swing):
- Login window (username input)
- Main chat window (message area, input field, user list)
- Private chat windows
- Emoji picker
- File sharing dialog

**Features**:
- Connect multiple clients (localhost sockets)
- Send/receive messages in real-time
- Private messaging
- Group chats
- File transfer
- User online/offline status
- Message history (persist to file)
- Notifications (system tray)

**Event Handling**:
- Button clicks (send message)
- Enter key press (send)
- Double-click user (private chat)
- Window close (disconnect gracefully)

**Architecture**:
- `ChatServer` (handles multiple clients)
- `ChatClient` (GUI + network logic)
- `Message` (serializable objects over sockets)
- Event-driven message processing

**Why uncomfortable**: GUI + networking + threading + event handling all together. Asynchronous message arrival, updating GUI from background threads (SwingUtilities), managing connections. This is real-world complexity.

---

# FINAL PROJECT: Cryptocurrency Trading Simulation Platform

## Overview

Build a comprehensive cryptocurrency trading simulator that demonstrates enterprise Java development, real-time data handling, concurrency, and modern software architecture.

## Core Features

### 1. Market Data Engine (Real-Time Price Feeds)

**API Integration:**

- Use free crypto APIs: CoinGecko API, CoinCap API, or Binance Public API
- Fetch real-time prices for major cryptocurrencies: BTC, ETH, LTC, XRP, ADA, DOT, LINK, etc.
- Historical data: fetch OHLCV (Open, High, Low, Close, Volume) data
- WebSocket support for real-time price streaming (if API supports)
- Fallback mechanism if primary API is down

**Data Models:**

```java
public class CryptoAsset {
    private String symbol;         // BTC, ETH, etc.
    private String name;           // Bitcoin, Ethereum
    private BigDecimal currentPrice;
    private BigDecimal high24h;
    private BigDecimal low24h;
    private BigDecimal volume24h;
    private BigDecimal marketCap;
    private BigDecimal priceChange24h;
    private LocalDateTime lastUpdated;
}

public class PriceHistory {
    private String symbol;
    private LocalDateTime timestamp;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
}
```

**Features:**

- Automatic price updates (every 10-60 seconds)
- Price change notifications (alert users of significant movements)
- Market indices (overall market trend)
- Top gainers/losers tracking
- Market volatility indicators

---

### 2. User Management System

**User Types:**

- Regular Trader: can trade, view portfolio
- Premium Trader: advanced analytics, more API calls
- Administrator: manage users, view all trades, system settings

**User Entity:**

```java
public class User {
    private Long id;
    private String username;
    private String email;
    private String passwordHash;    // BCrypt hashed
    private UserRole role;          // TRADER, PREMIUM, ADMIN
    private BigDecimal cashBalance; // USD balance
    private LocalDateTime createdAt;
    private boolean isActive;
    private String twoFactorSecret; // Optional: 2FA
}
```

**Authentication:**

- Registration with email verification (simulate via console)
- Login with username/password
- Password hashing using BCrypt
- Session management (JWT tokens or session IDs)
- Optional: Two-factor authentication (TOTP)

**Authorization:**

- Role-based access control
- Premium features locked for regular users
- Admin-only operations (user management, system config)

---

### 3. Portfolio Management

**Portfolio Entity:**

```java
public class Portfolio {
    private Long userId;
    private Map<String, Holding> holdings; // symbol -> holding
    private BigDecimal cashBalance;
    private BigDecimal totalValue;         // cash + holdings value
    private BigDecimal totalInvested;
    private BigDecimal totalReturn;        // profit/loss
    private double returnPercentage;
}

public class Holding {
    private String symbol;
    private BigDecimal quantity;
    private BigDecimal averageBuyPrice;
    private BigDecimal currentPrice;
    private BigDecimal currentValue;       // quantity * currentPrice
    private BigDecimal unrealizedPL;       // profit/loss
    private double returnPercentage;
}
```

**Features:**

- View current holdings (all cryptocurrencies owned)
- Real-time portfolio value updates (as prices change)
- Portfolio diversification analysis (% allocation per asset)
- Total return calculation (profit/loss since inception)
- Historical portfolio value chart
- Asset allocation pie chart
- Portfolio rebalancing suggestions

---

### 4. Trading System

**Order Types:**

1. **Market Order:** Buy/sell at current market price (immediate execution)
2. **Limit Order:** Buy/sell only at specified price or better (pending until matched)
3. **Stop-Loss Order:** Sell when price drops below specified level (risk management)
4. **Take-Profit Order:** Sell when price rises above specified level (lock in gains)

**Order Entity:**

```java
public class Order {
    private Long id;
    private Long userId;
    private String symbol;
    private OrderType type;           // MARKET, LIMIT, STOP_LOSS, TAKE_PROFIT
    private OrderSide side;           // BUY, SELL
    private BigDecimal quantity;
    private BigDecimal price;         // null for market orders
    private BigDecimal triggerPrice;  // for stop-loss/take-profit
    private OrderStatus status;       // PENDING, FILLED, PARTIALLY_FILLED, CANCELLED
    private LocalDateTime createdAt;
    private LocalDateTime filledAt;
    private BigDecimal filledQuantity;
    private BigDecimal filledPrice;   // average fill price
}
```

**Order Processing:**

- Validate order (sufficient funds, valid quantity, etc.)
- Market orders execute immediately at current price
- Limit orders stored in order book, executed when price matches
- Stop-loss/take-profit orders monitored continuously
- Partial fills supported (order filled in multiple transactions)
- Order cancellation (cancel pending limit orders)

**Order Book (Optional Advanced Feature):**

```java
public class OrderBook {
    private String symbol;
    private TreeMap<BigDecimal, List<Order>> buyOrders;  // price -> orders
    private TreeMap<BigDecimal, List<Order>> sellOrders; // price -> orders
    
    public void addOrder(Order order) { /* add to appropriate side */ }
    public List<Trade> matchOrders() { /* match buy/sell orders */ }
}
```

**Trade Entity:**

```java
public class Trade {
    private Long id;
    private Long buyOrderId;
    private Long sellOrderId;
    private String symbol;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal value;         // quantity * price
    private LocalDateTime timestamp;
}
```

**Transaction Fee:**

- Configurable fee percentage (e.g., 0.1% per trade)
- Deducted from each trade
- Premium users: lower fees

---

### 5. Risk Management & Analysis

**Position Limits:**

- Maximum position size per asset (e.g., max 10% portfolio in single asset)
- Maximum total exposure
- Margin requirements (simulate leveraged trading)

**Risk Metrics:**

```java
public class RiskMetrics {
    private BigDecimal portfolioValue;
    private BigDecimal valueAtRisk;        // VaR: potential loss in worst case
    private double sharpeRatio;            // risk-adjusted return
    private double volatility;             // portfolio volatility
    private double beta;                   // portfolio beta vs market
    private BigDecimal maxDrawdown;        // largest peak-to-trough decline
}
```

**Calculations:**

- **Value at Risk (VaR):** Calculate 95% confidence interval
- **Sharpe Ratio:** (Return - RiskFreeRate) / StandardDeviation
- **Portfolio Beta:** Correlation with market index
- **Drawdown:** Track largest decline from peak

**Alerts:**

- Portfolio value drops X%
- Single asset drops Y%
- Stop-loss triggered
- Margin call warning (if implementing margin)

---

### 6. Analytics & Reporting

**Dashboard:**

- Portfolio summary (total value, return, allocation)
- Recent trades list
- Open orders list
- Price charts for watchlisted assets
- Market overview (top movers, market sentiment)

**Charts (using JavaFX):**

- Candlestick charts (OHLC data)
- Line charts (price history)
- Portfolio value over time
- Asset allocation pie chart
- Return vs benchmark comparison

**Reports:**

- Trade history report (all trades with P/L)
- Portfolio performance report (returns, risk metrics)
- Tax report (capital gains/losses)
- Export to PDF or CSV

---

### 7. Database Schema

**Tables:**

```sql
users (id, username, email, password_hash, role, cash_balance, created_at, is_active)

portfolios (user_id, symbol, quantity, average_buy_price)

orders (id, user_id, symbol, type, side, quantity, price, trigger_price, status, created_at, filled_at)

trades (id, buy_order_id, sell_order_id, symbol, quantity, price, value, fee, timestamp)

price_history (symbol, timestamp, open, high, low, close, volume)

watchlists (user_id, symbol, added_at)

alerts (id, user_id, type, condition, threshold, is_active, triggered_at)
```

**Database:**

- Use PostgreSQL or MySQL for production
- Use H2 in-memory database for testing
- Connection pooling (HikariCP)
- Proper indexing for performance

---

### 8. API Client Layer

**CryptoAPIClient Interface:**

```java
public interface CryptoAPIClient {
    List<CryptoAsset> getAllAssets();
    CryptoAsset getAsset(String symbol);
    List<PriceHistory> getHistoricalData(String symbol, int days);
    Map<String, BigDecimal> getCurrentPrices(List<String> symbols);
}
```

**Implementations:**

- **CoinGeckoClient:** Fetches from CoinGecko API
- **CoinCapClient:** Fetches from CoinCap API
- **MockAPIClient:** Returns simulated data (for testing)

**API Client Features:**

- Rate limiting (respect API limits)
- Caching (cache responses for 10-60 seconds)
- Retry logic (retry failed requests)
- Fallback (switch to backup API if primary fails)
- Async requests (non-blocking API calls)

**CoinGecko API Endpoints (Free Tier):**

```
GET /coins/markets - List all coins with prices
GET /coins/{id} - Detailed info for specific coin
GET /coins/{id}/market_chart - Historical price data
GET /simple/price - Current prices for multiple coins
```

---

### 9. Background Services

**Price Update Service:**

- Scheduled task running every 30-60 seconds
- Fetch latest prices from API
- Update all portfolio values
- Check for triggered stop-loss/take-profit orders
- Send price alerts

**Order Monitoring Service:**

- Continuously monitor pending limit orders
- Execute when price matches
- Monitor stop-loss/take-profit orders
- Partial fills for large orders

**Market Data Recorder:**

- Record price history every hour/day
- Store in database for historical analysis
- Clean up old data (keep last 2 years)

**Implementation:**

```java
@Scheduled(fixedDelay = 60000) // Every 60 seconds
public void updatePrices() {
    List<String> symbols = portfolioService.getActiveSymbols();
    Map<String, BigDecimal> prices = apiClient.getCurrentPrices(symbols);
    
    for (Map.Entry<String, BigDecimal> entry : prices.entrySet()) {
        marketDataService.updatePrice(entry.getKey(), entry.getValue());
        orderService.checkTriggeredOrders(entry.getKey(), entry.getValue());
    }
}
```

---

### 10. Web Interface (REST API + Web Frontend)

**REST API Endpoints:**

```
Authentication:
POST   /api/auth/register      - Register new user
POST   /api/auth/login         - Login
POST   /api/auth/logout        - Logout
GET    /api/auth/me            - Get current user info

Market Data:
GET    /api/market/assets      - List all cryptocurrencies
GET    /api/market/assets/{symbol} - Get specific asset
GET    /api/market/prices      - Get current prices
GET    /api/market/history/{symbol}?days=30 - Historical data

Portfolio:
GET    /api/portfolio          - Get user's portfolio
GET    /api/portfolio/value    - Get portfolio value over time
GET   /api/portfolio/metrics - Get risk metrics

Trading: POST /api/orders - Place new order GET /api/orders - Get user's orders GET /api/orders/{id} - Get specific order DELETE /api/orders/{id} - Cancel order GET /api/trades - Get trade history

Watchlist: GET /api/watchlist - Get watchlist POST /api/watchlist - Add to watchlist DELETE /api/watchlist/{symbol} - Remove from watchlist

```

**Frontend Options:**
1. **JavaFX Desktop Application:** Rich UI with charts and real-time updates
2. **Web Application:** Servlet/JSP or Spring Boot with Thymeleaf
3. **Single Page Application:** React/Vue.js consuming REST API

---

### 11. Advanced Features (Optional)

**1. Trading Strategies (Backtesting):**
- Define trading strategies (e.g., buy when RSI < 30, sell when RSI > 70)
- Backtest strategies on historical data
- Calculate strategy performance
- Optimize strategy parameters

**2. Social Features:**
- Leaderboard (top traders by return)
- Follow other traders
- Copy trading (automatically copy trades from successful traders)
- Trading competitions

**3. News Integration:**
- Fetch crypto news from news APIs
- Sentiment analysis on news headlines
- Correlation between news and price movements

**4. Technical Indicators:**
- Moving Averages (SMA, EMA)
- RSI (Relative Strength Index)
- MACD (Moving Average Convergence Divergence)
- Bollinger Bands
- Volume indicators

**5. Simulated Market Manipulation:**
- Admin can inject price volatility
- Simulate flash crashes
- Test system resilience

---

## Technical Architecture

### Layer Structure:
```

┌─────────────────────────────────────────┐ │ Presentation Layer │ │ (JavaFX UI / REST API + Web Frontend) │ └─────────────────────────────────────────┘ ↓ ┌─────────────────────────────────────────┐ │ Service Layer │ │ - UserService │ │ - PortfolioService │ │ - TradingService │ │ - MarketDataService │ │ - OrderService │ │ - AnalyticsService │ └─────────────────────────────────────────┘ ↓ ┌─────────────────────────────────────────┐ │ DAO Layer │ │ - UserDAO │ │ - PortfolioDAO │ │ - OrderDAO │ │ - TradeDAO │ │ - PriceHistoryDAO │ └─────────────────────────────────────────┘ ↓ ┌─────────────────────────────────────────┐ │ Database (PostgreSQL/MySQL) │ └─────────────────────────────────────────┘

```
     External API Layer
```

┌─────────────────────────────────────────┐ │ - CoinGecko API Client │ │ - CoinCap API Client │ │ - News API Client (optional) │ └─────────────────────────────────────────┘

````

### Design Patterns Used:
- **Singleton:** API client, database connection pool
- **Factory:** Creating different order types, DAO implementations
- **Observer:** Price updates notify portfolio observers
- **Strategy:** Different trading strategies, order execution strategies
- **DAO:** Data access abstraction
- **Service Layer:** Business logic separation
- **MVC:** Web interface architecture
- **Builder:** Complex object creation (orders, reports)

---

## Concurrency Requirements

**Thread Pools:**
- API request thread pool (multiple concurrent API calls)
- Order processing thread pool (handle orders concurrently)
- Background service thread pool (scheduled tasks)

**Thread Safety:**
- Portfolio updates (multiple orders updating same portfolio)
- Price cache (multiple threads reading/writing prices)
- Order book (concurrent order matching)

**Synchronization:**
- Use `ConcurrentHashMap` for price cache
- Use `ReentrantLock` for order book operations
- Use atomic operations for portfolio value calculations
- Database transactions for order execution

---

## Testing Requirements

**Unit Tests (JUnit 5):**
- Service layer methods
- Calculation logic (returns, risk metrics)
- Order validation
- Price update logic
- Target: 80%+ code coverage

**Integration Tests:**
- Database operations (CRUD)
- API client (with mocked responses)
- Order processing flow (end-to-end)
- Portfolio updates on trades

**Load Tests:**
- Simulate 100 concurrent users placing orders
- API client handling rate limits
- Database performance under load
- Order matching performance

**Test Data:**
- Mock API responses (don't hit real API in tests)
- In-memory database (H2) for fast tests
- Test fixtures (pre-populated test data)

---

## Performance Requirements

- **API Response Time:** < 2 seconds for market data
- **Order Execution:** < 100ms for market orders
- **Portfolio Calculation:** < 50ms for 100 assets
- **Price Updates:** Process 100 symbols in < 5 seconds
- **Database Queries:** < 100ms for typical queries
- **Concurrent Users:** Support 100+ simultaneous users

---

## Security Requirements

**Authentication & Authorization:**
- Strong password requirements (min 8 chars, mixed case, numbers, symbols)
- Password hashing with BCrypt (cost factor 12+)
- Session timeout (30 minutes inactivity)
- Account lockout after failed login attempts
- Role-based access control

**Data Security:**
- Prepared statements (prevent SQL injection)
- Input validation (reject invalid data)
- Output encoding (prevent XSS if web interface)
- HTTPS for all API communication
- Secure API key storage (environment variables)

**Audit Trail:**
- Log all trades
- Log all order placements/cancellations
- Log login attempts
- Log admin actions

---

## Error Handling

**Expected Errors:**
- API unavailable (use cached data, show warning)
- Insufficient funds (reject order with clear message)
- Invalid order (validation errors with details)
- Network timeout (retry with exponential backoff)
- Database connection lost (reconnect automatically)

**Unexpected Errors:**
- Log error with stack trace
- Show user-friendly error message
- Graceful degradation (partial functionality)
- Admin notification for critical errors

---

## Configuration Management

**Configuration File (application.properties):**
```properties
# Database
db.url=jdbc:postgresql://localhost:5432/cryptotrade
db.username=admin
db.password=${DB_PASSWORD}
db.pool.size=10

# API
api.provider=coingecko
api.key=${API_KEY}
api.rate.limit=50
api.cache.duration=60

# Trading
trading.fee.percentage=0.1
trading.min.order.size=10
trading.max.position.size=10000

# Services
price.update.interval=60000
order.check.interval=5000

# Security
session.timeout=1800
bcrypt.strength=12
````

---

## Deliverables

### 1. Source Code

- Well-organized package structure
- Clean, readable code with comments
- Consistent naming conventions
- Proper exception handling
- Comprehensive logging

### 2. Documentation

- **README.md:** Project overview, setup instructions, API documentation
- **JavaDoc:** All public classes and methods documented
- **UML Diagrams:** Class diagram, sequence diagrams for key flows
- **Database Schema:** ER diagram with relationships
- **API Documentation:** All endpoints with request/response examples
- **User Manual:** How to use the application

### 3. Tests

- Unit tests for all services
- Integration tests for critical flows
- Test coverage report (Jacoco)
- Performance test results

### 4. Build Configuration

- Maven or Gradle build file
- Dependencies clearly listed
- Build instructions
- Database migration scripts

### 5. Demo

- Working application (either JavaFX or web)
- Sample data pre-loaded
- Demo scenario prepared
- Video demo (optional)

---

## Evaluation Criteria

**Architecture & Design (25%):**

- Clean separation of concerns
- Proper use of design patterns
- Scalable architecture
- Good database schema design

**Implementation Quality (30%):**

- Code quality (readability, maintainability)
- Proper error handling
- Efficient algorithms
- Correct concurrency handling

**Functionality (25%):**

- All core features working
- Accurate calculations
- Reliable order execution
- Real-time updates working

**Testing & Documentation (15%):**

- Comprehensive tests
- Good test coverage
- Clear documentation
- Easy setup instructions

**Advanced Features (5%):**

- Additional features beyond requirements
- Creative enhancements
- Performance optimizations

---

## Getting Started Guide

### Step 1: Setup Development Environment

1. Install Java JDK 11+
2. Install IDE (IntelliJ IDEA or Eclipse)
3. Install PostgreSQL or MySQL
4. Install Maven or Gradle
5. Get free API key from CoinGecko

### Step 2: Create Project Structure

```
crypto-trading-platform/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cryptotrade/
│   │   │       ├── model/
│   │   │       ├── dao/
│   │   │       ├── service/
│   │   │       ├── api/
│   │   │       ├── util/
│   │   │       └── ui/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test/
├── pom.xml (or build.gradle)
└── README.md
```

### Step 3: Development Order

1. **Week 1:** Database schema, DAO layer, User management
2. **Week 2:** API client, Market data service, Price updates
3. **Week 3:** Trading system (orders, execution, portfolio)
4. **Week 4:** Analytics, reporting, risk management
5. **Week 5:** UI (JavaFX or web), testing, polish
6. **Week 6:** Documentation, deployment, final testing

### Step 4: Milestones

- **Milestone 1:** User can register, login, view market data
- **Milestone 2:** User can place market orders, view portfolio
- **Milestone 3:** Limit orders, stop-loss, historical data
- **Milestone 4:** Analytics, charts, risk metrics
- **Milestone 5:** Full system working, tested, documented

---

This comprehensive specification provides a clear roadmap for building a professional-grade cryptocurrency trading platform. The project demonstrates skills in: backend development, database design, API integration, concurrency, real-time systems, financial calculations, security, testing, and documentation.

Good luck building your platform! 🚀
