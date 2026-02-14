# Complete Java + OOP Problem Sets Specification
This Repository is for Learning OOP with Java.
I'm aiming to create these Projects during my OOP course.

## LIBRARY MANAGEMENT SYSTEM — FINAL SPEC (NO GUESSING)

### University Library Management System (Console-Based)

### Description
A university-level library system that manages books, members, borrowing rules, reservations, and fines. The system models realistic academic policies with clearly defined roles and book categories.

> You are building a mid-sized university library, not a national archive.

---

### USER ROLES (Exactly 3)

1. Student
2. Faculty
3. Guest

That’s it. No admin role as a borrower. Admin is a system operator, not a borrowing entity.

### Borrowing Rules:

#### Student
- Max 5 active borrowings
- Loan duration: 14 days
- Fine: $1 per day overdue
- Can reserve books

#### Faculty
- Max 10 active borrowings
- Loan duration: 30 days
- Fine: $0.50 per day overdue
- Can reserve books
- Can borrow reference books (in-library use only, 6-hour limit)

#### Guest
- Max 2 active borrowings
- Loan duration: 7 days
- Fine: $2 per day overdue
- Cannot reserve books
- Cannot borrow reference books

> These rules are fixed.

---

### BOOK TYPES (Exactly 4)

1. PhysicalBook
2. EBook
3. AudioBook
4. ReferenceBook

#### Definitions:

**PhysicalBook**
- Has limited copies
- Can be borrowed normally
- Can be reserved

**EBook**
- Unlimited copies
- No reservation required
- Borrowed digitally
- No physical return processing

**AudioBook**
- Unlimited copies
- Same rules as EBook
- Borrowed digitally

**ReferenceBook**
- Physical only
- Exactly 1 copy
- Cannot be borrowed normally
- Faculty can check out for 6 hours (in-library use)
- Students and Guests cannot borrow

_**Important design decision:**_

> ReferenceBook is **NOT** also an ebook or audiobook. It is a separate physical-only category. No hybrid types. Keep taxonomy clean.

---

### CORE FEATURES (Mandatory)

- Add/remove books
- Register/remove members
- Borrow book
- Return book
- Reserve physical book (queue-based)
- Automatic fine calculation
- Track due dates
- Track book status (Available, Borrowed, Reserved, InLibraryUse)
- Prevent rule violations (limit exceeded, restricted access, etc.)
- File-based persistence (simple serialization or structured text)

---

### STATE RULES (No ambiguity)

#### PhysicalBook states:
- Available → Borrowed → Available
- Available → Reserved → Borrowed
- Borrowed → Reserved (queue exists)

#### EBook & AudioBook states:
- Always Available
- Borrowed status tracked per user, not per copy

#### ReferenceBook states:
- Available → InLibraryUse → Available

> No other states allowed.

---

### RESERVATION RULES

- Only PhysicalBook can be reserved
- FIFO queue
- When returned, automatically assign to first user in queue
- Guest cannot reserve

---

### FINE RULES

- Fine = (CurrentDate - DueDate) × RoleRate
- No compound logic.
- Fine accumulates until paid.

> Users with unpaid fines above $20 cannot borrow.

---

### SUCCESS CRITERIA

**The system is successful if:**

- Adding a new role would require minimal modification
- Borrowing rules are not hardcoded in a giant conditional block
- Book type behavior differs without if-else chains everywhere
- State transitions are validated and cannot enter invalid states
- Persistence works across restarts
- Edge cases do not break the system

---

### WHAT YOU ARE NOT BUILDING

- GUI
- Database
- Networked system
- Multi-branch library
- Payment gateway
- Search engine ranking

> Stay focused.

---

**If you build exactly this specification, you will encounter:**

- Inheritance decisions
- Polymorphism decisions
- State modeling
- Rule encapsulation
- Separation of concerns
- Basic persistence architecture
---

## 2) Plugin Architecture System

### Modular Command Processing System (Runtime Plugin Loader)

### Description
A console-based core application that dynamically loads external plugins at runtime. Each plugin adds new executable commands to the system without requiring recompilation of the core application.

> The core application acts as a host. Plugins extend functionality.

---

### System Structure

There are exactly **two layers**:

1. Core Application (host)
2. Plugins (external modules in a `/plugins` directory)

Plugins are compiled separately and placed in the plugins folder as `.class` files or `.jar` files.

---

### Core Responsibilities

- Discover plugins from `/plugins` directory at startup
- Dynamically load plugin classes
- Validate that loaded classes implement the plugin contract
- Register available commands
- Execute commands via user input
- Prevent one plugin failure from crashing the system

---

### Plugin Contract (Fixed)

**Each plugin must:**

- Provide a unique command name
- Provide a description
- Implement a single `execute(String[] args)`-style behavior
- Have lifecycle methods:

* `initialize()`
* `execute(...)`
* `shutdown()`

> No additional lifecycle methods.

---

### Required Features

- Runtime class loading
- Interface-based contract
- Command registry inside core
- Command execution via console input
- Error isolation (try-catch around plugin execution)
- Ability to list all loaded commands

---

### Fixed Behavior Rules

- Plugins are loaded only at startup (no hot reload)
- Duplicate command names are rejected
- If a plugin fails during initialization, it is skipped
- If a plugin throws during execution, system logs error and continues

---

### Good-to-Have Features

- Plugin metadata (name, version, author)
- Enable/disable plugin configuration file
- Basic logging system
- Plugin dependency declaration (optional, non-circular only)

---

### Success Criteria

- Adding a new plugin requires zero modification of core code
- Core has no compile-time dependency on concrete plugin classes
- Removing a plugin does not break system
- One faulty plugin does not terminate application
- Clear separation between plugin API and plugin implementation

---

## 3) Thread-Safe Bounded Buffer

### Concurrent Producer-Consumer Buffer

### Description

A fixed-capacity buffer shared between multiple producer and consumer threads. Producers insert items. Consumers remove items. Synchronization must guarantee correctness under concurrency.

> This is a correctness-first project.

---

### System Structure

**Exactly:**

1. BoundedBuffer class
2. Producer threads
3. Consumer threads
4. Buffer capacity = 5

> No configuration. These numbers are fixed.

---

### Required Behavior

- Producers generate integer items sequentially
- Consumers remove items and print them
- If buffer is full → producers block
- If buffer is empty → consumers block
- No data duplication
- No item loss
- No deadlock

---

### Thread Rules

- All shared state must be protected
- Condition waiting must be correct
- Shutdown mechanism required after producing 50 total items

> Exactly 50 items produced across all producers.

---

### Execution Flow

- Producers stop after total production reaches 50
- Consumers stop after consuming 50 items
 Program exits gracefully

---

### Good-to-Have Features

- Execution log timestamps
- Performance measurement
- Fairness observation
- Stress test mode (repeat multiple runs)

---

### Success Criteria

- No race conditions under repeated runs
- Output count always equals 50 produced and 50 consumed
- No hanging threads
- No busy waiting
- Proper separation of synchronization and data logic

---

## 4) Dependency Injection Container

### Lightweight Annotation-Based Dependency Injection Container

### Description

A minimal inversion-of-control container that manages object creation and dependency resolution automatically using reflection and annotations.

> This container wires components together without manual `new` calls in application code.

---

### Component Model

**Exactly one injection strategy:**

- Constructor-based injection only

> No field injection. No setter injection.

---

### Required Annotations (Exactly 2)

1. `@Component`
2. `@Inject`

No additional annotations.

---

### Required Features

- Scan predefined package for classes
- Register classes annotated with `@Component`
- Resolve constructor dependencies automatically
- Support singleton scope only
- Detect circular dependencies
- Throw meaningful error for missing dependency
- Maintain internal dependency graph

---

### Behavior Rules

- Only one constructor per component allowed
- If constructor has parameters → must resolve all
- If dependency not found → fail fast
- Circular dependency → explicit error message
- All components are singleton by default

---

### Application Example Requirement

>Create a small demo application using:

1. Repository class
2. Service class
3. Controller class

**Dependencies:**

- Controller → Service
- Service → Repository

> No manual object creation allowed in main method. Only container usage.

---

### Good-to-Have Features

- Lazy initialization
- Simple component registry debug output
- Dependency tree visualization (console print)

---

### Success Criteria

- Application runs without manual wiring
- Constructor dependencies resolved automatically
- Circular dependency detection works
- Adding a new component requires no change in container logic
- Container logic is separate from application logic

---

> Now you have four tightly defined, decision-free engineering builds:

1. University Library System
2. Modular Plugin Loader
3. Concurrent Bounded Buffer
4. Lightweight DI Container

Each one teaches a different dimension of OOP and system design.
> **_A NEW BEGINNING_**
