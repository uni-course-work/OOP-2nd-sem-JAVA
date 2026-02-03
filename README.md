# Object-Oriented Programming Problem Sets
This Repository is for Learning OOP with Java.
I'm aiming to Solve these problem sets during OOP course.
## CSOO-127 - Rigorous Learning Track

> **Philosophy**: These problem sets are designed to challenge you, not comfort you. Each problem requires genuine thinking, design decisions, and often multiple attempts. If a problem feels easy, you're probably missing something deeper.

---

## Unit 1: From Procedures to Objects — The OOP Mindset

### Problem Set 1.1: Paradigm Translation (Conceptual)

**Problem 1: The Invoice Calculator** You have this procedural code pattern:

```
function calculateTotal(items[], taxRate):
    subtotal = 0
    for each item in items:
        subtotal += item.price * item.quantity
    tax = subtotal * taxRate
    return subtotal + tax
```

**Task**: Don't just convert this to Java. Redesign it using OOP thinking. What objects exist? What are their responsibilities? What should NOT be an object? Write a 200-word analysis BEFORE writing any code explaining your design decisions.

**Problem 2: The Library System Decomposition** Given: A library tracks books (title, author, ISBN), members (name, ID, borrowed books), and loans (book, member, due date).

**Task**:

- First, solve this procedurally (using only functions and data structures). Implement: addBook, borrowBook, returnBook, findOverdue.
- Then, solve it using OOP.
- Write a comparative analysis: What changed? What became easier? What became harder? What new problems appeared?

**Problem 3: When OOP Fails You** Design a program that:

- Calculates factorial of a number
- Finds prime numbers in a range
- Sorts an array

**Task**: Try to force this into an OOP design with classes and objects. Now explain why it feels wrong. When should you NOT use OOP? This is a critical thinking exercise.

---

## Unit 2: Java Foundations — The Language as a Tool

### Problem Set 2.1: Java Mechanics and Compilation

**Problem 1: The Compilation Detective** Given this buggy code:

```java
public class Mystery {
    public static void main(String[] args) {
        int x = 5;
        double y = 10;
        System.out.println(x / y);
        String message = "Value: " + x + y;
        System.out.println(message);
    }
}
```

**Task**:

- Predict the output WITHOUT running it
- Explain EXACTLY what happens during compilation and execution
- Explain the JVM's role at each step
- What bytecode is generated for the division operation?

**Problem 2: Type System Exploration** Create a Java program that demonstrates:

- Implicit type conversion (widening)
- Explicit type conversion (narrowing)
- Type conversion that causes data loss
- Type conversion that throws an error

For each case, explain WHY Java behaves that way.

**Problem 3: Lexical Analysis Challenge** Write a Java program that:

```java
int _123 = 100;
int $money = 200;
// Is this valid? Why?
// int 123abc = 300;
// int class = 400;
```

**Task**: Document ALL the lexical rules for Java identifiers, keywords, and literals. Create a table of 20 test cases (valid/invalid) and explain each.

---

## Unit 3: Methods — Behavior Before Structure

### Problem Set 3.1: Method Design Patterns

**Problem 1: The Parameter Problem** Implement a method that calculates distance between two points. Design it in FOUR different ways:

1. Using 4 separate parameters (x1, y1, x2, y2)
2. Using 2 arrays
3. Using a Point class (you can create it)
4. Using variable arguments (varargs)

**Task**: Analyze trade-offs of each approach. Which is best? Why? When would you use each?

**Problem 2: Method Overloading vs. Bad Design** You need to create a "print" functionality that handles:

- Integers
- Doubles
- Strings
- Arrays of integers
- Objects (toString)

**Task**:

- Implement using method overloading
- Explain: When does overloading make sense vs. when should you use different method names?
- Create an example where overloading is BAD design

**Problem 3: Return Value Design** Design a method that validates a password. It must check:

- Length (8-20 characters)
- Contains uppercase
- Contains lowercase
- Contains digit
- Contains special character

**Challenge**: Design THREE different return strategies:

1. boolean return (just valid/invalid)
2. int return (error code)
3. String return (detailed message)
4. BONUS: Custom return type

Which is best? Why? Implement all and compare.

---

## Unit 4: Classes and Objects — Modeling Reality

### Problem Set 4.1: From Reality to Code

**Problem 1: The Bank Account Challenge** Model a bank account that:

- Has account number, owner name, balance
- Can deposit money
- Can withdraw money (but not more than balance)
- Can transfer to another account
- Tracks transaction history

**Critical Constraints**:

- Account numbers must be unique and auto-generated
- Balance should NEVER be directly accessible
- Invalid operations should be handled gracefully
- Think: What should be an object? What shouldn't?

**Problem 2: The Student Enrollment System** Model:

- Student (ID, name, enrolled courses)
- Course (code, title, credits, enrolled students)
- Enrollment (student, course, grade)

**Critical Questions**:

- Where does the enrollment relationship live?
- Who is responsible for maintaining consistency?
- How do you prevent a student from enrolling twice in the same course?
- How do you handle course capacity limits?

**Problem 3: Anonymous Object Justification** Create scenarios where anonymous objects make sense:

```java
new SomeClass().method();
```

**Task**: Provide 3 legitimate use cases and 3 cases where using anonymous objects is BAD design.

---

## Unit 5: Encapsulation and Class Design

### Problem Set 5.1: Defensive Design

**Problem 1: The Immutable Date** Create a `Date` class that is TRULY immutable:

- Has day, month, year
- Validates dates (no Feb 31st)
- Once created, can NEVER be changed
- Supports operations like addDays() but returns NEW date object

**Challenge**: Make it bulletproof. Try to break your own design. Can you modify internal state? Can you pass invalid data?

**Problem 2: The Password Manager** Design a `Password` class that:

- Stores a password securely
- Never exposes the password directly
- Can verify if a given string matches
- Can check password strength
- Has a final MAX_ATTEMPTS before locking

**Critical Constraint**: Even YOU (the programmer) should not be able to extract the raw password from the object after creation.

**Problem 3: Access Modifier Maze** Given:

```java
public class Outer {
    private int privateVar = 1;
    int defaultVar = 2;
    protected int protectedVar = 3;
    public int publicVar = 4;
}
```

**Task**: Create a comprehensive test showing EXACTLY what can be accessed from:

- Same class
- Same package, different class
- Different package, subclass
- Different package, non-subclass

Document your findings in a matrix.

---

## Unit 6: Constructors and Object Initialization

### Problem Set 6.1: Initialization Patterns

**Problem 1: Constructor Chaining** Create a `Rectangle` class with:

- No-arg constructor (creates 1x1 rectangle)
- Single-arg constructor (creates square)
- Two-arg constructor (creates rectangle)
- Constructor that takes another Rectangle (copy constructor)

**Requirements**:

- Minimize code duplication using constructor chaining
- Add validation (no negative dimensions)
- Demonstrate all four constructors

**Problem 2: The Initialization Order Mystery** Predict the output WITHOUT running:

```java
public class InitOrder {
    static int staticVar = printAndReturn("static var");
    int instanceVar = printAndReturn("instance var");
    
    static {
        System.out.println("Static block");
    }
    
    {
        System.out.println("Instance block");
    }
    
    public InitOrder() {
        System.out.println("Constructor");
    }
    
    static int printAndReturn(String msg) {
        System.out.println(msg);
        return 0;
    }
    
    public static void main(String[] args) {
        new InitOrder();
        new InitOrder();
    }
}
```

**Task**: Explain EXACTLY what happens and why.

**Problem 3: The Invalid Object Problem** Design a `CreditCard` class where:

- Card number must be 16 digits
- CVV must be 3 digits
- Expiry date must be in the future

**Challenge**: How do you prevent invalid CreditCard objects from ever existing? Consider multiple strategies:

1. Exception in constructor
2. Factory method
3. Builder pattern (research this)

Implement all three and compare.

---

## Unit 7: Static Members and Class-Level Behavior

### Problem Set 7.1: Static vs Instance

**Problem 1: The Object Counter** Create a class that:

- Counts how many objects have been created (total, ever)
- Counts how many objects currently exist (considering garbage collection is beyond scope, simulate with destroy())
- Assigns each object a unique ID

**Requirements**:

- Use static appropriately
- Demonstrate with creation and "destruction" of objects
- Explain what happens if you DON'T use static

**Problem 2: Utility Class Design** Create a `MathUtils` class with static methods:

- isPrime(int n)
- gcd(int a, int b)
- fibonacci(int n)
- factorial(int n)

**Critical Questions**:

- Should this class be instantiable?
- How do you prevent instantiation?
- Why use static here?
- Create a COUNTER-EXAMPLE where static would be WRONG for similar functionality

**Problem 3: Static Initialization Order** Given multiple classes with static variables and blocks, predict initialization order:

```java
class A {
    static int x = B.y + 1;
    static { System.out.println("A static"); }
}

class B {
    static int y = 10;
    static { System.out.println("B static"); }
}

class C {
    static A a = new A();
    static B b = new B();
}
```

**Task**: Trace execution when each class is first accessed. What are the dangers?

---

## Unit 8: Relationships Between Classes — Object Collaboration

### Problem Set 8.1: Relationship Design

**Problem 1: University System** Model:

- University HAS departments
- Department HAS courses
- Department HAS professors
- Professor TEACHES courses
- Student ENROLLS IN courses

**Task**:

- Identify ALL relationships (association, aggregation, composition)
- Justify EACH relationship type
- Implement with proper lifecycle management
- What happens when a Department is deleted? What about its Courses? Professors?

**Problem 2: Composition vs Aggregation** Create two scenarios:

1. A `Car` and its `Engine` (composition - engine dies with car)
2. A `Team` and its `Players` (aggregation - players exist independently)

**Requirements**:

- Demonstrate the difference in code
- Show lifecycle differences
- Create a copy constructor for each - how does it differ?
- What happens in serialization? (research if needed)

**Problem 3: Circular Dependency Problem** Design:

- `Author` has written `Books`
- `Book` has an `Author`

**Challenge**: Implement this bidirectional relationship. Issues:

- How do you construct them?
- Who is responsible for maintaining consistency?
- How do you prevent memory leaks in other languages? (Java handles this, but explain why)
- Implement addBook() and setAuthor() that maintain both sides

---

## Unit 9: Inheritance — Reuse with Caution

### Problem Set 9.1: Inheritance Hierarchies

**Problem 1: The Employee Hierarchy** Create:

- `Employee` (base)
- `HourlyEmployee` (paid by hour)
- `SalaryEmployee` (fixed monthly salary)
- `CommissionEmployee` (base + commission on sales)

**Requirements**:

- Each has appropriate data and calculatePay() method
- Use `super` appropriately
- Add toString() override in each
- Demonstrate polymorphism

**Critical**: Justify your design. Why inheritance here?

**Problem 2: When NOT to Inherit** You have:

- `Rectangle` (width, height)
- `Square` (all sides equal)

**Temptation**: Make Square extend Rectangle.

**Task**:

- Implement this "obvious" solution
- Now BREAK it. Show why it violates principles.
- Redesign without inheritance
- Research: This is the famous "Circle-Ellipse Problem" or "Square-Rectangle Problem"

**Problem 3: The Protected Trap**

```java
class Base {
    protected int value = 10;
}

class Derived extends Base {
    public void messWithBase(Base b) {
        // Can you access b.value here?
        // What about this.value?
    }
}
```

**Task**: Explore ALL the nuances of protected access. Create a complete guide with examples.

---

## Unit 10: Polymorphism — One Interface, Many Behaviors

### Problem Set 10.1: Polymorphic Design

**Problem 1: The Shape Hierarchy** Create a true polymorphic system:

- Abstract `Shape` with abstract draw() and area()
- `Circle`, `Rectangle`, `Triangle` implementations
- `ShapeManager` that works with Shape[] and can:
    - Draw all shapes
    - Calculate total area
    - Find largest shape
    - Sort shapes by area

**Challenge**: Add a new shape later WITHOUT modifying ShapeManager.

**Problem 2: Method Overriding Rules** Create examples showing:

1. Return type covariance
2. Access modifier widening
3. Exception specification narrowing
4. Why you CAN'T override private methods
5. Why you CAN'T override static methods
6. Why you CAN'T override final methods

Each should be a working code example with explanation.

**Problem 3: Runtime vs Compile-time**

```java
class Animal {
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    void sound() { System.out.println("Bark"); }
    void fetch() { System.out.println("Fetching"); }
}
```

**Analyze**:

```java
Animal a = new Dog();
a.sound();  // What happens?
a.fetch();  // What happens?
((Dog)a).fetch();  // What happens?
```

Explain EXACTLY what the compiler and JVM do at each step.

---

## Unit 11: Abstraction — Designing for Change

### Problem Set 11.1: Abstract Design

**Problem 1: Payment Processing System** Design an abstract payment system:

- Abstract `Payment` class with abstract processPayment()
- Concrete: `CreditCardPayment`, `PayPalPayment`, `CryptoPayment`
- Each has different validation and processing logic
- Abstract class should handle common logging/tracking

**Requirements**:

- What goes in abstract class vs subclasses?
- Demonstrate template method pattern (research this)
- Add new payment type without changing existing code

**Problem 2: Abstract vs Interface (Preliminary)** You need to model:

- Different types of vehicles (Car, Motorcycle, Truck)
- All have engine specs (could be common)
- All can start(), stop()
- Some are electric, some gas
- Some can carry cargo

**Task**: Design this with abstract class. Later (Unit 12) you'll redesign with interfaces. Document your decisions.

**Problem 3: Final in Inheritance** Create scenarios showing:

1. final method (can't override)
2. final class (can't extend)
3. final variable in parent class

**Task**: For each, explain WHEN and WHY you'd use it. Create a security example where final prevents malicious overriding.

---

## Unit 12: Interfaces — Multiple Inheritance of Behavior

### Problem Set 12.1: Interface Design

**Problem 1: Revisit the Vehicle Problem** Take your abstract class design from Unit 11, Problem 2.

**Task**:

- Redesign using interfaces: `Drivable`, `Electric`, `CargoCarrier`
- Compare both designs
- What became easier? What became harder?
- When would you use interfaces vs abstract classes?

**Problem 2: Interface Segregation** You have:

```java
interface Worker {
    void work();
    void eat();
    void sleep();
}
```

**Problem**: A `Robot` worker doesn't eat or sleep.

**Task**:

- Show why this interface is poorly designed
- Redesign using interface segregation
- Implement: `HumanWorker` and `RobotWorker`
- Research: This is from SOLID principles

**Problem 3: Default Methods and Diamond Problem**

```java
interface A {
    default void method() { 
        System.out.println("A"); 
    }
}

interface B {
    default void method() { 
        System.out.println("B"); 
    }
}

class C implements A, B {
    // What must you do here?
}
```

**Task**: Solve the diamond problem. Explain Java's resolution rules.

---

## Unit 13: Packages and the Java Object Model

### Problem Set 13.1: Package Organization

**Problem 1: Library System Organization** Design a package structure for:

- Models (Book, Member, Loan)
- Services (BookService, MemberService)
- Utils (DateUtils, ValidationUtils)
- Exceptions (custom exceptions)

**Requirements**:

- Proper package naming
- Correct access modifiers for cross-package access
- Create a package-private utility class
- Document import strategies

**Problem 2: The Object Class** Every class extends Object. Explore:

- Override `equals()` for a `Person` class (correct implementation)
- Override `hashCode()` (must be consistent with equals!)
- Override `toString()` meaningfully
- Understand `getClass()`, `clone()`

**Critical**: Research the equals/hashCode contract. Break it and show the consequences.

**Problem 3: Package Access Protection** Create a scenario with 4 classes across 3 packages demonstrating ALL access level behaviors in a package context.

---

## Unit 14: Exception Handling — Designing for Failure

### Problem Set 14.1: Exception Design

**Problem 1: Custom Exception Hierarchy** Design exceptions for a banking system:

- `BankException` (base)
- `InsufficientFundsException`
- `InvalidAccountException`
- `TransactionLimitExceededException`

**Requirements**:

- Proper exception hierarchy
- Meaningful error messages
- Include relevant data (e.g., available balance, required amount)
- Demonstrate checked vs unchecked decision

**Problem 2: Exception Handling Patterns** Implement file reading with:

1. try-catch
2. try-catch-finally
3. try-with-resources
4. Multiple catch blocks

**Task**: For each, explain when to use it. What happens if exception occurs in finally block?

**Problem 3: To Catch or Not to Catch** You have a method that reads a file and parses data.

**Design Question**: Should you:

1. Catch exceptions inside the method?
2. Declare throws and let caller handle?
3. Wrap in custom exception?

Implement all three versions and argue for each approach.

---

## Unit 15: Generics and Collections — Reusable Abstractions

### Problem Set 15.1: Generic Design

**Problem 1: Generic Pair Class** Create a generic `Pair<T, U>` class:

- Holds two values of potentially different types
- Getter methods
- swap() method
- equals() method (challenging with generics!)

**Challenge**: Create a utility method that finds max of two Pairs (by first element).

**Problem 2: Collections Framework Mastery** Implement a `StudentDatabase` using:

- ArrayList for student list
- HashMap for ID-to-Student lookup
- TreeSet for sorted student names
- LinkedList for student queue

**Requirements**:

- Demonstrate when to use each
- Implement searching, sorting, filtering
- Use Collections utility methods
- Demonstrate the performance trade-offs

**Problem 3: Type Erasure Understanding**

```java
class Box<T> {
    private T value;
}
```

**Explore**:

- What happens at runtime?
- Why can't you do `new T()`?
- Why can't you create `new Box<int>()`?
- What are the workarounds?

---

## Unit 16: File Handling and Object Persistence

### Problem Set 16.1: Persistence Patterns

**Problem 1: CSV Student Database** Create a system that:

- Reads students from CSV
- Allows adding/editing/deleting
- Writes back to CSV
- Handles malformed data gracefully

**Challenge**: Make it handle 10,000 students efficiently.

**Problem 2: Object Serialization** Create a complex object graph:

- `University` contains `Department[]`
- `Department` contains `Course[]` and `Professor[]`
- Serialize entire University
- Deserialize and verify integrity

**Challenges**:

- What should be transient?
- Version control (what if class structure changes?)
- Handle serialVersionUID

**Problem 3: Custom File Format** Design your own binary file format for:

- Student records with fixed-length fields
- Efficient random access by record number
- Update in place without rewriting entire file

**Requirements**: Document your format, implement read/write, demonstrate efficiency.

---

## Unit 17: GUI Programming and Event-Driven Thinking

### Problem Set 17.1: GUI Design

**Problem 1: Calculator Application** Create a functional calculator:

- Swing GUI with buttons for digits, operations
- Display panel
- Event handling for all buttons
- Support: +, -, *, /, clear, equals
- Handle edge cases (division by zero, etc.)

**Challenge**: Implement memory functions (M+, M-, MR, MC).

**Problem 2: Event Delegation Deep Dive** Create three ways to handle button clicks:

1. Separate listener class
2. Anonymous inner class
3. Lambda expression

**Task**: Explain trade-offs. When would you use each?

**Problem 3: Dynamic GUI** Create a contact manager:

- Add contact button (creates new form fields dynamically)
- Remove contact button
- List view of all contacts
- Save to file
- Layout must resize properly

**Challenge**: This combines multiple topics - GUI, events, collections, file I/O, and object design.

---

## Unit 18: Integration Project

### Problem Set 18.1: Course Management System

**Build a complete system integrating ALL concepts**:

**Requirements**:

- Multiple classes with proper inheritance/interfaces
- File persistence
- Exception handling
- Collections framework
- GUI interface (optional but recommended)

**Features**:

1. Student management (add, edit, delete, search)
2. Course management
3. Enrollment system with constraints
4. Grade management
5. Report generation
6. Data persistence

**Evaluation Criteria**:

- Object-oriented design quality
- Encapsulation and access control
- Proper exception handling
- Code organization (packages)
- GUI design (if implemented)
- Documentation

---

## Final Project Prompt

When you're ready to discuss your final project, tell me:

1. **What domain interests you?** (Healthcare, Finance, Gaming, Education, E-commerce, etc.)

2. **What scale are you targeting?**

    - Small (3-5 classes, basic functionality)
    - Medium (8-12 classes, moderate complexity)
    - Large (15+ classes, complex interactions)
3. **What specific OOP concepts do you want to showcase?**

    - Heavy inheritance hierarchy?
    - Interface-based design?
    - Design patterns?
    - Complex object relationships?
4. **Any specific technologies or features?**

    - GUI required?
    - Database integration?
    - Network functionality?
    - File I/O?
5. **Your current comfort level**:

    - Which units felt strong?
    - Which units need more practice?

Based on your answers, I'll suggest 3 tailored project ideas with:

- Detailed requirements
- Class diagram suggestions
- Technology recommendations
- Estimated complexity
- Learning objectives

**Are you ready to start with Unit 1 problem sets, or would you like to jump to a specific unit?**