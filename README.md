# Complete Java + OOP Problem Sets Specification
This Repository is for Learning OOP with Java.
I'm aiming to Solve these problem sets during OOP course.

## Problem Set 1: Object-Oriented Design Patterns

### Problem 1.1: Library Management System

**What to Build:** A complete digital library system that manages books, users, and transactions.

**Core Requirements:**

- Support three types of books: Physical Books, E-Books, and Audio Books
- Support three types of users: Students (borrow 3 books for 14 days), Faculty (5 books for 30 days), Guests (1 book for 7 days)
- Books have: ISBN, title, author, publisher, publication year, genre, number of pages, language, availability status
- Users can: check out books, return books, reserve unavailable books, view borrowing history
- System must: track due dates, calculate late fees ($1/day), send overdue notifications, generate reports
- Search books by: title, author, ISBN, genre, availability
- Must use: Builder pattern for book creation, Factory pattern for creating users and books, Singleton for database management

**Success Criteria:**

- A user can check out multiple books up to their limit
- System prevents checkout if user has overdue books
- Late fees are calculated correctly
- Books can be reserved when unavailable
- Search returns accurate results

---

### Problem 1.2: Event Bus Implementation

**What to Build:** A publish-subscribe event system where components can communicate without direct dependencies.

**Core Requirements:**

- Create a generic event system supporting any event type
- Components register themselves as subscribers using annotations
- Events are published to the bus and delivered to all interested subscribers
- Support synchronous (immediate) and asynchronous (background thread) delivery
- Subscribers can specify priority (high priority subscribers receive events first)
- Handle "dead events" - events that have no subscribers
- Support event inheritance (if you subscribe to ParentEvent, you receive ChildEvent too)
- Thread-safe operation with multiple publishers and subscribers

**Success Criteria:**

- Multiple components can subscribe to same event type
- Events are delivered in priority order
- Async events don't block the publisher
- No memory leaks from unregistered subscribers
- System remains responsive under heavy event load

---

### Problem 1.3: Plugin Architecture

**What to Build:** A plugin system that discovers and loads plugins from JAR files at runtime.

**Core Requirements:**

- Define a Plugin interface that all plugins must implement
- System scans a "plugins" directory for JAR files at startup
- Plugins are loaded dynamically using reflection
- Each plugin has: name, version, description, list of dependencies
- Plugins can depend on other plugins (load order matters)
- System validates plugin compatibility before loading
- Plugins can be enabled/disabled without restarting the application
- Provide a context object that plugins use to interact with the host application

**Create Three Sample Plugins:**

- Logger Plugin: logs all application events to a file
- Data Processor Plugin: transforms data (depends on Logger)
- Notification Plugin: sends notifications (depends on Logger)

**Success Criteria:**

- System loads valid plugins and rejects invalid ones
- Plugins load in correct dependency order
- Disabling a plugin that others depend on is prevented
- Plugins can be reloaded without restarting

---

### Problem 1.4: Command Pattern CLI

**What to Build:** A command-line application where every action is a command object with full undo/redo capability.

**Core Requirements:**

- Every operation is a Command object (create file, delete file, modify file, etc.)
- Each command knows how to execute itself and undo itself
- System maintains a history of executed commands
- Support undo (reverse last N commands) and redo (re-execute undone commands)
- Commands work with files and directories on the actual file system

**Implement These Commands:**

- File operations: create, delete, rename, copy, move
- Text operations: write text to file, append to file, replace text in file
- Directory operations: create directory, delete directory, list contents

**CLI Features:**

- Interactive mode: user types commands and sees results
- Script mode: execute commands from a script file
- Help command: shows all available commands and syntax
- History command: shows past commands
- Save history to file and reload on next run

**Success Criteria:**

- Every command can be undone and redone correctly
- Undo/redo works for multiple operations in sequence
- File system reflects command executions accurately
- Invalid commands are rejected with helpful error messages

---

## Problem Set 2: Collections & Generics

### Problem 2.1: Custom ArrayList Implementation

**What to Build:** Your own implementation of Java's ArrayList from scratch using a generic array.

**Core Requirements:**

- Generic type support (works with any object type)
- Dynamic resizing (starts small, grows as needed)
- Implement all standard operations: add, remove, get, set, size, isEmpty, clear, contains
- Implement indexOf, lastIndexOf
- Support for-each loops (implement Iterable interface)
- Implement custom Iterator with remove() support
- Provide trimToSize() to reduce memory usage
- Proper exception handling (IndexOutOfBoundsException, ConcurrentModificationException)

**Performance Requirements:**

- add() should be O(1) amortized
- get() should be O(1)
- remove() should be O(n)
- No performance degradation with 100,000+ elements

**Success Criteria:**

- Passes same test cases as Java's ArrayList
- Memory grows efficiently (doesn't waste space)
- Iterator detects concurrent modifications
- Works with any object type (Strings, Integers, custom objects)

---

### Problem 2.2: Bloom Filter

**What to Build:** A space-efficient probabilistic data structure for testing set membership.

**Core Requirements:**

- Initialize with: expected number of elements, desired false positive rate
- Support operations: add(element), mightContain(element)
- Use multiple hash functions (configurable, minimum 3)
- Implement using bit array
- Provide statistics: current false positive probability, number of elements added, memory usage
- Support serialization (save/load from file)

**Mathematical Requirements:**

- Calculate optimal bit array size based on inputs
- Calculate optimal number of hash functions
- Implement independent hash functions

**Use Cases to Test:**

- Spell checker: load 100,000 words, test membership
- URL filter: track visited URLs, check if URL was visited
- Email filter: detect if email address has been seen

**Success Criteria:**

- False positive rate matches configured rate (within 10%)
- Never produces false negatives
- Uses significantly less memory than HashSet
- Fast membership testing (microseconds)

---

### Problem 2.3: Priority Queue Scheduler

**What to Build:** A task scheduling system using a custom-built priority queue based on a binary heap.

**Core Requirements:** **Priority Queue Implementation:**

- Generic min-heap or max-heap (configurable)
- Operations: insert, extractMin/Max, peek, size, isEmpty
- Support custom comparators
- Proper heap property maintenance

**Task Scheduler Built on Priority Queue:**

- Tasks have: name, priority level (1-10), deadline, duration
- Schedule tasks by priority and deadline
- Execute highest priority task first
- If priorities are equal, execute task with earliest deadline
- Track: completed tasks, pending tasks, overdue tasks
- Generate execution schedule report

**Scheduler Features:**

- Add tasks dynamically while scheduler is running
- Cancel pending tasks
- Reschedule tasks (change priority or deadline)
- Pause/resume scheduler

**Success Criteria:**

- Tasks execute in correct priority order
- Heap operations maintain heap property
- Scheduler handles 10,000+ tasks efficiently
- No task starvation (low priority tasks eventually execute)

---

### Problem 2.4: Persistent Data Structures

**What to Build:** Immutable data structures that share memory between versions for efficiency.

**Core Requirements:** **Persistent Linked List:**

- Each operation (add, remove, update) creates a new version
- Old versions remain accessible and unchanged
- Versions share nodes where possible (structural sharing)
- Support: head, tail, cons (add to front), get(index)

**Persistent Binary Search Tree:**

- Each insertion/deletion creates new tree version
- Old trees remain valid and queryable
- Nodes are shared between tree versions
- Support: insert, delete, search, traverse

**Version Management:**

- Keep track of all versions
- Allow querying any historical version
- Provide version comparison (what changed between versions)
- Calculate memory savings from structural sharing

**Demonstration:**

- Create a list, show 10 versions with different elements
- Prove that modifying version 5 doesn't affect versions 1-4 or 6-10
- Show memory usage compared to copying entire structure

**Success Criteria:**

- Modifications don't affect previous versions
- Memory usage is less than full copying
- All versions remain queryable
- Performance is reasonable (not worse than 2x standard structures)

---

## Problem Set 3: Concurrency & Threading

### Problem 3.1: Thread-Safe Bounded Buffer

**What to Build:** A fixed-size buffer that safely handles multiple producer and consumer threads.

**Core Requirements:**

- Fixed capacity buffer (configurable size)
- Producers add items to buffer (block if buffer is full)
- Consumers remove items from buffer (block if buffer is empty)
- Thread-safe operations (no race conditions)
- Implement using: wait/notify OR Semaphores OR ReentrantLock with Conditions (choose one)

**Features:**

- Support multiple producer threads adding concurrently
- Support multiple consumer threads removing concurrently
- Producers wait when buffer is full
- Consumers wait when buffer is empty
- Proper wake-up of waiting threads
- No lost notifications or spurious wake-ups

**Testing Requirements:**

- Run with 5 producers and 3 consumers producing/consuming 10,000 items
- Verify all items produced are eventually consumed
- Verify no items are lost or duplicated
- Measure throughput (items/second)

**Success Criteria:**

- No thread crashes or deadlocks
- All items are processed exactly once
- System handles rapid production and consumption
- Fair scheduling (threads don't starve)

---

### Problem 3.2: Concurrent Web Scraper

**What to Build:** A multi-threaded web crawler that downloads pages while respecting concurrency limits.

**Core Requirements:**

- Start from a seed URL, discover and follow links
- Use thread pool (configurable number of threads)
- Respect robots.txt rules
- Limit concurrent requests per domain (max 2 simultaneous connections to same domain)
- Track visited URLs (use ConcurrentHashMap)
- Extract: page title, all links, word count
- Store results in thread-safe data structure

**Politeness Requirements:**

- Delay between requests to same domain (configurable, default 1 second)
- Maximum depth limit (don't crawl infinitely)
- Maximum pages limit (stop after N pages)
- Timeout for slow pages (10 seconds)

**Output:**

- List of all URLs visited
- Site map (which pages link to which)
- Statistics: total pages, total links, average page size, crawl duration

**Success Criteria:**

- Crawls 100+ pages without crashing
- Respects rate limits (no hammering of servers)
- No duplicate page downloads
- Handles network errors gracefully
- Can pause and resume crawling

---

### Problem 3.3: Read-Write Lock Implementation

**What to Build:** Your own implementation of a read-write lock from scratch (don't use ReentrantReadWriteLock).

**Core Requirements:**

- Allow multiple readers simultaneously
- Allow only one writer at a time
- Writers must wait for all readers to finish
- Readers must wait if a writer is active
- Prevent writer starvation (waiting writer gets priority over new readers)
- Support lock upgrade (reader → writer) and downgrade (writer → reader)

**Implementation Constraints:**

- Use synchronized blocks, wait(), notify(), notifyAll()
- Track: number of active readers, number of waiting readers, number of waiting writers, active writer flag

**API:**

```
readLock()
readUnlock()
writeLock()
writeUnlock()
```

**Testing Scenario:**

- Shared data structure (e.g., HashMap with 1000 entries)
- 10 reader threads: read random entries continuously
- 3 writer threads: update random entries continuously
- Run for 60 seconds, verify data integrity

**Success Criteria:**

- Multiple reads happen simultaneously (verify using timestamps)
- Writers have exclusive access
- No data corruption
- No deadlocks
- Fair access (no starvation)

---

### Problem 3.4: Parallel Merge Sort

**What to Build:** A merge sort implementation using Java's Fork/Join framework with performance comparison.

**Core Requirements:**

- Implement classic single-threaded merge sort
- Implement parallel merge sort using RecursiveAction/RecursiveTask
- Configurable threshold (switch to sequential sort below this size)
- Support sorting any Comparable type

**Performance Testing:**

- Test with arrays of sizes: 1K, 10K, 100K, 1M, 10M elements
- Test with: random integers, sorted arrays, reverse-sorted arrays, arrays with duplicates
- Measure: execution time, speedup factor, CPU utilization
- Generate performance graphs comparing single vs parallel

**Optimization:**

- Find optimal threshold for switching to sequential sort
- Compare performance with different thread pool sizes
- Handle edge cases (empty array, single element, all duplicates)

**Success Criteria:**

- Parallel version is faster for large arrays (100K+)
- Both versions produce identical sorted results
- Speedup improves with array size
- No stack overflow on large datasets

---

## Problem Set 4: I/O & Serialization

### Problem 4.1: Custom CSV Parser

**What to Build:** A robust CSV file parser that handles complex CSV formats and large files efficiently.

**Core Requirements:**

- Parse CSV files with customizable delimiter (comma, tab, semicolon, etc.)
- Handle quoted fields (fields containing delimiter or newlines)
- Handle escaped quotes within quoted fields
- Support headers (first row as column names)
- Handle different line endings (Windows \r\n, Unix \n, Mac \r)

**Features:**

- Stream processing (don't load entire file into memory)
- Parse file row-by-row with iterator interface
- Type conversion (string to int, double, date, boolean)
- Handle missing values (empty fields)
- Validation (check correct number of columns per row)
- Error reporting (line number and description of issue)

**Advanced Features:**

- Write CSV files (convert data to CSV format)
- Support custom quote character and escape character
- Handle BOM (Byte Order Mark) in UTF-8 files
- Trim whitespace option

**Test Files:**

- Simple CSV (no quotes, clean data)
- Complex CSV (quoted fields with commas and newlines)
- Large CSV (1GB+ file with millions of rows)
- Malformed CSV (test error handling)

**Success Criteria:**

- Correctly parses all valid CSV formats
- Handles files larger than available RAM
- Parsing speed: 100K+ rows per second
- Clear error messages for invalid files

---

### Problem 4.2: Custom Serialization Protocol

**What to Build:** A binary serialization system for Java objects (alternative to Java's built-in serialization).

**Core Requirements:**

- Serialize objects to binary format
- Deserialize binary data back to objects
- Support: primitives, strings, arrays, collections, custom objects
- Handle object graphs (objects referencing other objects)
- Detect and handle circular references
- Preserve object identity (same object referenced multiple times deserializes to same instance)

**Binary Format Design:**

- Compact representation (smaller than Java serialization)
- Include version information for backward compatibility
- Support schema evolution (handle added/removed fields)

**API Design:**

```
serialize(Object obj, OutputStream out)
Object deserialize(InputStream in)
```

**Test Cases:**

- Simple objects (Person with name, age)
- Nested objects (Company containing list of Employees)
- Circular references (Parent → Child → Parent)
- Collections (ArrayList, HashMap)
- Null values
- Large objects (10MB+)

**Success Criteria:**

- Deserialized object equals original object
- Handles complex object graphs correctly
- More compact than Java serialization (30%+ smaller)
- Faster than Java serialization (2x+ faster)

---

### Problem 4.3: Log File Tail

**What to Build:** A program that watches log files for changes and streams new lines in real-time (like Unix `tail -f`).

**Core Requirements:**

- Monitor one or more log files for changes
- Display new lines as they are written to the file
- Handle: file rotation (file renamed/deleted and new file created), file truncation, multiple concurrent watchers
- Support filters: show only lines containing specific text, regex pattern matching, exclude lines matching pattern

**Features:**

- Follow multiple files simultaneously
- Color coding (error lines in red, warning in yellow)
- Timestamps (show when each line was detected)
- Output to console or save to another file
- Pause/resume monitoring
- Seek to end or start of file

**Performance Requirements:**

- Detect new lines within 100ms
- Handle files growing rapidly (1000+ lines/second)
- Low CPU usage when files are idle
- Handle very large files (10GB+)

**Success Criteria:**

- Never misses a line
- Handles file rotation correctly
- Works with rapidly growing files
- Minimal resource usage
- Clean shutdown (no data loss)

---

### Problem 4.4: File Compression Utility

**What to Build:** A file archiver that creates ZIP-format archives with compression.

**Core Requirements:**

- Create ZIP archives from files and directories
- Add files to existing archives
- Extract files from archives
- List contents of archives
- Remove files from archives
- Support compression (DEFLATE algorithm)

**Features:**

- Recursive directory archiving (preserve directory structure)
- Exclude patterns (don't archive certain file types)
- Progress reporting (show percentage complete)
- Verify archive integrity (checksum validation)
- Password protection (encrypt archives)
- Split archives (create multi-part archives)

**Command-Line Interface:**

```
compress -c archive.zip file1.txt file2.txt
compress -x archive.zip -d output/
compress -l archive.zip
compress -a archive.zip newfile.txt
compress -r archive.zip oldfile.txt
```

**Success Criteria:**

- Archives are compatible with standard ZIP tools (WinZip, 7-Zip)
- Compression achieves good ratios (60%+ for text)
- Handles large files (4GB+) correctly
- Fast operation (compress 1GB in under 1 minute)

---

## Problem Set 5: Networking & Sockets

### Problem 5.1: Multi-Client Echo Server (NIO)

**What to Build:** A TCP server that handles multiple clients with a single thread using non-blocking I/O.

**Core Requirements:**

- Use Java NIO (SocketChannel, Selector)
- Single thread handles all clients
- Echo back whatever clients send
- Support 1000+ simultaneous clients
- Graceful handling of client disconnections

**Protocol:**

- Server listens on configurable port (default 8080)
- Clients connect and send text messages
- Server echoes each message back with timestamp
- Special commands: "TIME" returns server time, "CLIENTS" returns client count, "QUIT" disconnects

**Features:**

- Broadcast message to all connected clients
- Private messaging between clients
- Client nicknames
- Connection statistics (bytes sent/received per client)

**Testing:**

- Create a simple client to connect and send messages
- Load test: simulate 500 concurrent clients sending messages
- Measure: latency, throughput, CPU usage

**Success Criteria:**

- Handles 1000 clients with single thread
- Low latency (< 10ms for echo)
- No message loss or corruption
- Stable under load (no crashes)

---

### Problem 5.2: HTTP Client Library

**What to Build:** A HTTP client library built from scratch using sockets (don't use HttpURLConnection or third-party libraries).

**Core Requirements:**

- Support HTTP methods: GET, POST, PUT, DELETE
- Parse HTTP responses (status code, headers, body)
- Follow redirects (301, 302, 307, 308)
- Support HTTPS (use SSLSocket)
- Handle cookies (store and send automatically)

**Features:**

- Custom headers (User-Agent, Authorization, etc.)
- Request body support (for POST/PUT)
- Response compression (gzip, deflate)
- Timeout configuration
- Connection pooling (reuse connections)
- Keep-alive support

**API Design:**

```java
HttpClient client = new HttpClient();
HttpRequest request = new HttpRequest("GET", "https://api.example.com/data");
request.addHeader("Authorization", "Bearer token");
HttpResponse response = client.send(request);
System.out.println(response.getStatusCode());
System.out.println(response.getBody());
```

**Test Against:**

- Public APIs (JSONPlaceholder, httpbin.org)
- Various response types (JSON, HTML, images)
- Error scenarios (404, 500, timeout)

**Success Criteria:**

- Successfully communicates with real websites
- Correctly parses all response components
- Handles redirects automatically
- Connection pooling improves performance

---

### Problem 5.3: RPC Framework

**What to Build:** A Remote Procedure Call system where clients can invoke methods on server objects as if they were local.

**Core Requirements:**

- Define interfaces that can be exposed remotely
- Server registers objects that implement these interfaces
- Client gets proxy object implementing same interface
- Method calls on proxy are sent to server and executed
- Return values are sent back to client

**Protocol Design:**

- Serialize method calls (method name, parameters)
- Transmit over TCP socket
- Deserialize on server, invoke method, serialize result
- Transmit result back to client

**Features:**

- Support multiple data types (primitives, strings, objects)
- Handle exceptions (propagate from server to client)
- Asynchronous calls (non-blocking)
- Timeout for slow methods
- Server can expose multiple objects

**Example Usage:**

```java
// Shared interface
public interface Calculator {
    int add(int a, int b);
    double divide(double a, double b);
}

// Server
Calculator impl = new CalculatorImpl();
RpcServer server = new RpcServer(8080);
server.register("calculator", impl);
server.start();

// Client
RpcClient client = new RpcClient("localhost", 8080);
Calculator calc = client.getProxy(Calculator.class, "calculator");
int result = calc.add(5, 3); // Executed on server!
```

**Success Criteria:**

- Client code is identical to local method calls
- Handles complex parameters (objects, lists)
- Exceptions propagate correctly
- Performance is acceptable (< 5ms latency on localhost)

---

### Problem 5.4: Multiplayer Game Server

**What to Build:** A turn-based game server supporting simultaneous games between multiple pairs of players.

**Core Requirements:** **Choose One Game to Implement:**

- Chess, Checkers, or Tic-Tac-Toe

**Server Features:**

- Multiple games running simultaneously
- Matchmaking (pair players waiting for games)
- Game state synchronization (both players see same board)
- Move validation (reject illegal moves)
- Turn enforcement (players can only move on their turn)
- Win/lose/draw detection
- Spectator mode (watch ongoing games)

**Protocol:**

- JSON-based messages over TCP
- Message types: LOGIN, FIND_GAME, MAKE_MOVE, GAME_STATE, CHAT, DISCONNECT
- Server broadcasts game state changes to both players

**Client Features:**

- Text-based or GUI client (your choice)
- Display current game state
- Input moves
- Chat with opponent
- View game history

**Testing:**

- Two clients play complete game
- Test disconnection handling (forfeit or reconnect)
- Multiple simultaneous games
- Spectator joins existing game

**Success Criteria:**

- Two players can play complete game from start to finish
- Game rules are enforced correctly
- State stays synchronized between clients
- Server handles player disconnections gracefully
- Supports at least 10 simultaneous games

---

## Problem Set 6: Database & JDBC

### Problem 6.1: Connection Pool Manager

**What to Build:** A database connection pool from scratch (don't use HikariCP or other libraries).

**Core Requirements:**

- Maintain pool of pre-opened database connections
- Client requests connection from pool (if available, return immediately; if not, wait or create new)
- Client returns connection to pool when done
- Configurable: minimum connections, maximum connections, connection timeout
- Idle connection timeout (close connections unused for X minutes)

**Features:**

- Connection validation (test connection before returning)
- Maximum wait time (throw exception if no connection available)
- Connection leak detection (warn if connection not returned)
- Statistics: active connections, idle connections, wait time, request rate
- Graceful shutdown (close all connections)

**Health Checks:**

- Periodically test idle connections (ping database)
- Automatically remove dead connections
- Recreate connections if database restarts

**Configuration:**

```java
PoolConfig config = new PoolConfig();
config.setMinConnections(5);
config.setMaxConnections(20);
config.setConnectionTimeout(30000); // 30 seconds
config.setIdleTimeout(600000); // 10 minutes

ConnectionPool pool = new ConnectionPool(config, jdbcUrl, username, password);
Connection conn = pool.getConnection();
// use connection
pool.returnConnection(conn);
```

**Load Testing:**

- Simulate 100 threads requesting connections simultaneously
- Measure: average wait time, maximum wait time, connection reuse rate
- Verify pool doesn't exceed maximum connections

**Success Criteria:**

- Connection reuse improves performance vs creating new connections
- Pool handles concurrent requests correctly
- Dead connections are detected and removed
- No connection leaks under stress

---

### Problem 6.2: SQL Query Builder

**What to Build:** A fluent API for building SQL queries programmatically without string concatenation.

**Core Requirements:**

- Build SELECT, INSERT, UPDATE, DELETE queries
- Support: WHERE clauses, JOINs, ORDER BY, GROUP BY, LIMIT
- Prevent SQL injection (use parameterized queries)
- Generate both SQL string and parameter list
- Type-safe (compile-time checking where possible)

**API Design:**

```java
// Example usage:
Query query = new QueryBuilder()
    .select("users.name", "orders.total")
    .from("users")
    .join("orders", "users.id = orders.user_id")
    .where("users.age", ">", 18)
    .where("orders.total", ">", 100)
    .orderBy("orders.total", "DESC")
    .limit(10)
    .build();

String sql = query.toSQL();
// SELECT users.name, orders.total FROM users 
// JOIN orders ON users.id = orders.user_id 
// WHERE users.age > ? AND orders.total > ? 
// ORDER BY orders.total DESC LIMIT 10

List<Object> params = query.getParameters();
// [18, 100]
```

**Supported Features:**

- Multiple WHERE conditions (AND/OR)
- INNER JOIN, LEFT JOIN, RIGHT JOIN
- Aggregate functions (COUNT, SUM, AVG, MAX, MIN)
- Subqueries
- DISTINCT
- HAVING clause

**Success Criteria:**

- Generated SQL is syntactically correct
- Parameters are in correct order
- No SQL injection vulnerabilities
- Supports complex queries (multiple joins, subqueries)
- Readable, maintainable API

---

### Problem 6.3: Transaction Manager

**What to Build:** A system for managing database transactions with rollback capability across multiple operations.

**Core Requirements:**

- Begin transaction
- Execute multiple database operations within transaction
- Commit if all succeed
- Rollback if any fail
- Support nested transactions (savepoints)

**Features:**

- Declarative transactions (annotations)
- Transaction isolation levels (READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE)
- Automatic rollback on exceptions
- Transaction timeout
- Transaction logging (audit trail)

**API Design:**

```java
TransactionManager tm = new TransactionManager(dataSource);

tm.executeInTransaction(conn -> {
    // All operations in same transaction
    insertUser(conn, user);
    updateAccount(conn, account);
    logActivity(conn, activity);
    // Automatically commits if no exceptions
    // Automatically rolls back if exception thrown
});
```

**Annotation-Based Transactions:**

```java
@Transactional(isolation = IsolationLevel.READ_COMMITTED, timeout = 5000)
public void transferMoney(Account from, Account to, double amount) {
    debit(from, amount);
    credit(to, amount);
    // Transaction managed automatically
}
```

**Test Scenarios:**

- Successful transaction (all operations commit)
- Failed transaction (rollback on exception)
- Nested transactions with savepoints
- Concurrent transactions (test isolation)

**Success Criteria:**

- ACID properties maintained
- Partial failures don't leave database in inconsistent state
- Nested transactions work correctly
- Minimal performance overhead

---

### Problem 6.4: Database Migration Tool

**What to Build:** A version control system for database schemas (like Flyway/Liquibase).

**Core Requirements:**

- Migrations are SQL scripts with version numbers (V1__initial_schema.sql, V2__add_users_table.sql)
- Tool tracks which migrations have been applied (in special table)
- Apply pending migrations in order
- Rollback migrations (undo changes)
- Validate migration checksums (detect manual changes)

**Migration Tracking:**

- Create `schema_version` table storing: version, description, execution timestamp, checksum, success/failure
- On startup, compare migrations in directory with applied migrations
- Apply only new migrations

**Migration Format:**

```sql
-- V1__initial_schema.sql
CREATE TABLE users (
    id INT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- V2__add_users_table.sql
ALTER TABLE users ADD COLUMN created_at TIMESTAMP;
CREATE INDEX idx_users_email ON users(email);
```

**Rollback Support:**

- Reverse migrations: R1__initial_schema.sql, R2__add_users_table.sql
- Each forward migration has corresponding reverse migration

**Features:**

- Dry-run mode (show what would be executed)
- Migration validation (check syntax before applying)
- Baseline (mark existing database as starting point)
- Repair (fix failed migrations)
- Support multiple databases (MySQL, PostgreSQL, H2)

**CLI Commands:**

```
migrate info      // Show migration status
migrate apply     // Apply pending migrations
migrate rollback  // Rollback last migration
migrate validate  // Check migration integrity
```

**Success Criteria:**

- Migrations apply in correct order
- Can rollback and reapply migrations
- Detects manual schema changes
- Handles failed migrations gracefully
- Works across database restarts

---

## Problem Set 7: XML, JSON & Data Processing

### Problem 7.1: JSON Parser

**What to Build:** A complete JSON parser and serializer from scratch (no libraries like Jackson or Gson).

**Core Requirements:**

- Parse JSON strings into Java objects
- Serialize Java objects to JSON strings
- Support all JSON types: object, array, string, number, boolean, null
- Handle nested structures (objects within objects, arrays within arrays)
- Proper error reporting (line number and position of syntax errors)

**JSON to Java Mapping:**

- JSON object → Map<String, Object>
- JSON array → List<Object>
- JSON number → Integer, Long, or Double (auto-detect)
- JSON string → String
- JSON boolean → Boolean
- JSON null → null

**Features:**

- Pretty printing (formatted output with indentation)
- Compact output (no whitespace)
- Custom object serialization (serialize custom classes)
- Escape handling (quotes, newlines, unicode)
- Number precision (don't lose precision with large numbers)

**Test Cases:**

```json
// Simple object
{"name": "John", "age": 30}

// Nested structure
{"person": {"name": "Jane", "address": {"city": "NYC"}}}

// Arrays
{"scores": [95, 87, 92], "tags": ["java", "json"]}

// Edge cases
{"unicode": "Hello\u0020World", "number": 1.7976931348623157E308}
```

**Error Handling:**

- Missing closing brace
- Invalid escape sequences
- Trailing commas
- Duplicate keys

**Success Criteria:**

- Correctly parses all valid JSON
- Rejects invalid JSON with clear error messages
- Serialization round-trips (parse → serialize → parse produces same result)
- Handles large JSON files (10MB+)

---

### Problem 7.2: XML Schema Validator

**What to Build:** An XML validator that checks XML documents against XSD schemas.

**Core Requirements:**

- Parse XSD schema files
- Validate XML documents against schema
- Report all validation errors (not just first one)
- Error messages include element path and line number

**Validation Checks:**

- Element presence (required elements exist)
- Element order (elements in correct sequence)
- Data types (string, integer, date, boolean)
- Value restrictions (minLength, maxLength, pattern, enumeration)
- Cardinality (minOccurs, maxOccurs)
- Attributes (required, optional, type validation)

**Example Schema:**

```xml
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="person">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="name" type="xs:string"/>
        <xs:element name="age" type="xs:integer" minInclusive="0" maxInclusive="150"/>
        <xs:element name="email" type="xs:string" pattern="[^@]+@[^@]+\.[^@]+"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>
```

**Features:**

- Support common XSD types (string, integer, decimal, date, boolean)
- Support restrictions (length, pattern, enumeration, range)
- Support complex types (sequences, choices)
- Namespace handling
- Schema imports and includes

**Output:**

```
Validation Errors:
Line 5: Element 'age': Value '200' exceeds maximum value of 150
Line 7: Element 'email': Value 'invalid-email' does not match pattern
Line 10: Required element 'name' is missing
```

**Success Criteria:**

- Correctly validates compliant XML
- Catches all common validation errors
- Error messages are clear and actionable
- Handles complex schemas with nested types

---

### Problem 7.3: Template Engine

**What to Build:** A text template engine that replaces variables and evaluates expressions (like Mustache or Handlebars).

**Core Requirements:**

- Replace variables: `{{variableName}}`
- Conditional blocks: `{{#if condition}}...{{/if}}`
- Loops: `{{#each items}}...{{/each}}`
- Comments: `{{! This is a comment }}`

**Features:**

- Nested structures (access object properties: `{{user.name}}`)
- Helper functions (built-in: uppercase, lowercase, date formatting)
- Custom helpers (user-defined functions)
- Partials (reusable template fragments)
- Escaping (HTML escape by default, raw output with `{{{raw}}}`)

**Example Template:**

```
Hello {{name}}!

{{#if isVIP}}
  Welcome back, valued customer!
{{/if}}

Your orders:
{{#each orders}}
  - Order #{{id}}: {{product}} (${{price}})
{{/each}}

Total: ${{total}}
```

**Data:**

```java
Map<String, Object> data = new HashMap<>();
data.put("name", "Alice");
data.put("isVIP", true);
data.put("orders", Arrays.asList(
    Map.of("id", 1, "product", "Laptop", "price", 999),
    Map.of("id", 2, "product", "Mouse", "price", 25)
));
data.put("total", 1024);
```

**Advanced Features:**

- Else clauses: `{{#if}}...{{else}}...{{/if}}`
- Unless: `{{#unless}}...{{/unless}}`
- Array indexing: `{{items.0}}`
- Custom delimiters (change from `{{}}` to something else)

**Success Criteria:**

- Renders templates correctly with provided data
- Handles nested loops and conditionals
- Helper functions work correctly
- Proper error messages for undefined variables
- Good performance (render 1000 templates/second)

---

### Problem 7.4: Data Pipeline (ETL)

**What to Build:** An Extract-Transform-Load pipeline that processes data from multiple sources.

**Core Requirements:** **Extract:**

- Read data from: CSV files, JSON files, XML files, databases (JDBC)
- Handle different encodings and formats
- Support file filtering (by name pattern, date, size)

**Transform:**

- Filter rows (keep only rows matching criteria)
- Map columns (rename, derive new columns from existing)
- Aggregate (group by, sum, count, average)
- Join data from multiple sources
- Clean data (trim whitespace, handle nulls, fix data types)
- Validate data (reject invalid rows, log errors)

**Load:**

- Write to: CSV files, JSON files, database tables
- Support: insert, update, upsert (insert or update)
- Batch processing (commit in batches for performance)
- Error handling (continue on error or fail fast)

**Pipeline Configuration:**

```java
Pipeline pipeline = new Pipeline();

pipeline.addSource(new CsvSource("customers.csv"))
        .addSource(new DatabaseSource("SELECT * FROM orders"))
        .transform(new FilterTransform(row -> row.get("status").equals("active")))
        .transform(new MapTransform(row -> {
            row.put("total", (int)row.get("quantity") * (double)row.get("price"));
            return row;
        }))
        .transform(new JoinTransform("customer_id", customersData))
        .addDestination(new CsvDestination("report.csv"))
        .addDestination(new DatabaseDestination("INSERT INTO results"));

PipelineResult result = pipeline.execute();
System.out.println("Processed: " + result.getProcessedRows());
System.out.println("Errors: " + result.getErrorCount());
```

**Features:**

- Parallel processing (process multiple rows concurrently)
- Progress monitoring (show percentage complete)
- Dry-run mode (show what would happen without executing)
- Incremental processing (process only new/changed data)
- Scheduling (run pipeline on schedule)

**Success Criteria:**

- Correctly processes data from multiple sources
- Transformations produce correct results
- Handles errors gracefully
- Performance: process 100K rows in under 10 seconds
- Can resume failed pipelines

---

## Problem Set 8: Reflection & Annotations

### Problem 8.1: Dependency Injection Container

**What to Build:** A lightweight dependency injection framework that automatically wires object dependencies.

**Core Requirements:**

- Scan packages for classes with `@Component` annotation
- Automatically create instances of components
- Inject dependencies using `@Inject` annotation
- Support constructor injection and field injection
- Detect circular dependencies and report error

**Annotations:**

```java
@Component // Marks class for automatic instantiation
@Inject    // Marks fields or constructors for dependency injection
@Singleton // Component is instantiated once and reused
@Named     // Specify name for ambiguous dependencies
```

**Example Usage:**

```java
@Component
public class UserService {
    @Inject
    private UserRepository repository;
    
    public void saveUser(User user) {
        repository.save(user);
    }
}

@Component
@Singleton
public class DatabaseConnection {
    // Created once, injected everywhere needed
}

// Application startup:
DependencyContainer container = new DependencyContainer();
container.scan("com.myapp.services");
UserService service = container.get(UserService.class);
```

**Features:**

- Constructor injection (preferred over field injection)
- Interface injection (inject implementation of interface)
- Qualifier annotations (choose specific implementation)
- Lazy initialization (create instance only when requested)
- Lifecycle callbacks (@PostConstruct, @PreDestroy)

**Advanced:**

- Handle generic types
- Support factory methods
- Configuration classes (provide beans programmatically)

**Success Criteria:**

- Automatically resolves and injects all dependencies
- Detects circular dependencies before creation
- Singletons are truly instantiated once
- Clear error messages for unresolvable dependencies
- Performance: instantiate 1000 components in under 100ms

---

### Problem 8.2: ORM Mapper (Object-Relational Mapper)

**What to Build:** A simple ORM that maps Java classes to database tables using annotations.

**Core Requirements:**

- Annotate classes with `@Entity`, `@Table`
- Annotate fields with `@Id`, `@Column`
- Generate CREATE TABLE statements from classes
- CRUD operations: save, find, update, delete
- Support basic relationships: @OneToMany, @ManyToOne

**Annotations:**

```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    
    @Column(name = "email")
    private String email;
    
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
```

**Operations:**

```java
EntityManager em = new EntityManager(dataSource);

// Save
User user = new User("john", "john@example.com");
em.save(user); // INSERT INTO users...

// Find
User found = em.find(User.class, 1L); // SELECT * FROM users WHERE id=1

// Update
found.setEmail("newemail@example.com");
em.update(found); // UPDATE users SET email=? WHERE id=?

// Delete
em.delete(found); // DELETE FROM users WHERE id=?
```

**Features:**

- Automatically map Java types to SQL types
- Handle null values
- Support for auto-generated IDs
- Lazy loading for relationships
- Query by example (find all users with name="John")
- Caching (first-level cache per EntityManager)

**Relationship Handling:**

- Fetch related entities automatically
- Cascade operations (delete user deletes their orders)
- Bidirectional relationships

**Success Criteria:**

- Correctly generates DDL from annotations
- CRUD operations work correctly
- Relationships are loaded properly
- No N+1 query problem for relationships
- Handles edge cases (nulls, empty collections)

---

### Problem 8.3: Validation Framework

**What to Build:** A bean validation system using annotations to validate object properties.

**Core Requirements:**

- Built-in validation annotations: @NotNull, @NotEmpty, @Size, @Min, @Max, @Email, @Pattern
- Custom validation annotations
- Validate object graphs (nested objects)
- Return list of validation errors with field names and messages

**Built-in Validators:**

```java
public class User {
    @NotNull(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    
    @Email(message = "Invalid email format")
    private String email;
    
    @Min(value = 18, message = "Must be at least 18 years old")
    private int age;
    
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Phone must be XXX-XXX-XXXX")
    private String phone;
}
```

**Usage:**

```java
Validator validator = new Validator();
User user = new User();
user.setName("J");
user.setEmail("invalid");
user.setAge(15);

ValidationResult result = validator.validate(user);
if (!result.isValid()) {
    for (ValidationError error : result.getErrors()) {
        System.out.println(error.getField() + ": " + error.getMessage());
    }
}
// Output:
// name: Name must be between 2 and 50 characters
// email: Invalid email format
// age: Must be at least 18 years old
```

**Custom Validators:**

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidCreditCard {
    String message() default "Invalid credit card number";
}

// Implement CreditCardValidator that checks Luhn algorithm
```

**Features:**

- Group validation (validate only certain fields)
- Conditional validation (validate field only if another field has specific value)
- Cross-field validation (password and confirmPassword must match)
- Validate collections (all items in list must be valid)
- Integration with other frameworks (auto-validate before saving to database)

**Success Criteria:**

- All built-in validators work correctly
- Custom validators can be created easily
- Nested object validation works
- Performance: validate 10,000 objects per second
- Clear, customizable error messages

---

### Problem 8.4: Test Framework

**What to Build:** A unit testing framework similar to JUnit (but simpler).

**Core Requirements:**

- Discover test classes with `@Test` annotation
- Execute test methods
- Assertions: assertEquals, assertTrue, assertFalse, assertNull, assertThrows
- Report results: number of tests run, passed, failed
- Show which tests failed and why

**Annotations:**

```java
@Test           // Mark method as test
@BeforeEach     // Run before each test
@AfterEach      // Run after each test
@BeforeAll      // Run once before all tests
@AfterAll       // Run once after all tests
@Disabled       // Skip this test
```

**Example Test Class:**

```java
public class CalculatorTest {
    private Calculator calc;
    
    @BeforeEach
    public void setup() {
        calc = new Calculator();
    }
    
    @Test
    public void testAddition() {
        assertEquals(5, calc.add(2, 3));
    }
    
    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
    
    @AfterEach
    public void cleanup() {
        calc = null;
    }
}
```

**Test Runner:**

```java
TestRunner runner = new TestRunner();
runner.addTestClass(CalculatorTest.class);
TestResult result = runner.run();

System.out.println("Tests run: " + result.getRunCount());
System.out.println("Passed: " + result.getPassCount());
System.out.println("Failed: " + result.getFailCount());

for (TestFailure failure : result.getFailures()) {
    System.out.println(failure.getTestName() + ": " + failure.getMessage());
}
```

**Features:**

- Test discovery (automatically find all test classes in package)
- Parameterized tests (run same test with different inputs)
- Test timeouts (fail test if takes too long)
- Test categories/tags (run only specific groups of tests)
- Assertions with custom messages
- Exception message matching

**Output Formatting:**

```
Running: CalculatorTest
  ✓ testAddition (2ms)
  ✓ testSubtraction (1ms)
  ✗ testDivision (5ms)
    Expected: 5.0
    Actual: 4.0
    at line 23

Summary: 3 tests, 2 passed, 1 failed
```

**Success Criteria:**

- Discovers and runs all test methods
- Lifecycle methods execute in correct order
- Failed tests provide clear information
- Can run thousands of tests efficiently
- Test isolation (tests don't affect each other)

---

## Problem Set 9: Algorithms & Data Structures

### Problem 9.1: Graph Library

**What to Build:** A comprehensive graph library with common algorithms and representations.

**Core Requirements:** **Graph Representations:**

- Adjacency List (efficient for sparse graphs)
- Adjacency Matrix (efficient for dense graphs)
- Support directed and undirected graphs
- Support weighted and unweighted edges

**Graph Operations:**

- Add/remove vertices
- Add/remove edges
- Check if edge exists
- Get neighbors of vertex
- Get degree of vertex (in-degree, out-degree for directed)

**Algorithms to Implement:**

- **Traversal:** BFS (Breadth-First Search), DFS (Depth-First Search)
- **Shortest Path:** Dijkstra's algorithm, Bellman-Ford (handles negative weights)
- **Minimum Spanning Tree:** Kruskal's algorithm, Prim's algorithm
- **Topological Sort:** For directed acyclic graphs
- **Connected Components:** Find all connected components
- **Cycle Detection:** Detect if graph has cycles

**Graph Types:**

- Simple graph (no self-loops, no multiple edges)
- Multi-graph (multiple edges between vertices)
- Weighted graph (edges have weights/costs)

**API Design:**

```java
Graph<String> graph = new AdjacencyListGraph<>();
graph.addVertex("A");
graph.addVertex("B");
graph.addEdge("A", "B", 5); // weight = 5

List<String> path = graph.shortestPath("A", "D"); // Dijkstra's
int distance = graph.shortestDistance("A", "D");

Graph<String> mst = graph.minimumSpanningTree(); // Kruskal's

boolean hasCycle = graph.hasCycle();
List<List<String>> components = graph.connectedComponents();
```

**Visualization:**

- Generate DOT format output (for Graphviz)
- Print adjacency matrix/list in readable format

**Test Cases:**

- Small graphs (5-10 vertices) verified by hand
- Large random graphs (1000+ vertices) for performance
- Special cases: disconnected graph, graph with cycles, complete graph
- Real-world graphs: social network, road network

**Success Criteria:**

- All algorithms produce correct results
- Efficient performance (Dijkstra on 10K vertices in under 1 second)
- Clear API that's easy to use
- Handles edge cases (empty graph, single vertex, no path exists)

---

### Problem 9.2: String Matching Algorithms

**What to Build:** Implement and compare three string searching algorithms.

**Algorithms to Implement:**

1. **KMP (Knuth-Morris-Pratt):**
    - Build failure function
    - Linear time search O(n+m)
2. **Boyer-Moore:**
    - Build bad character table
    - Build good suffix table
    - Sublinear time in best case
3. **Rabin-Karp:**
    - Rolling hash function
    - Handle hash collisions
    - Good for multiple pattern search

**Requirements:**

- Find first occurrence of pattern in text
- Find all occurrences of pattern in text
- Handle case-sensitive and case-insensitive search
- Support Unicode text

**Performance Comparison:**

- Test on various text sizes: 1KB, 10KB, 100KB, 1MB
- Test patterns: common words, rare words, non-existent patterns
- Measure: execution time, number of character comparisons
- Generate comparison charts

**Use Cases:**

- Search text files
- Find words in large documents
- Multiple pattern search (find several patterns in one pass)

**Visualization:**

- Show how each algorithm progresses through text
- Display failure function for KMP
- Display hash values for Rabin-Karp

**API Design:**

```java
StringMatcher matcher = new KMPMatcher("pattern");
int firstIndex = matcher.findFirst("this is the text to search");
List<Integer> allIndices = matcher.findAll("text with pattern pattern pattern");

// Performance comparison
PerformanceComparator comparator = new PerformanceComparator();
comparator.addAlgorithm(new KMPMatcher(pattern));
comparator.addAlgorithm(new BoyerMooreMatcher(pattern));
comparator.addAlgorithm(new RabinKarpMatcher(pattern));
ComparisionResult result = comparator.compare(largeText);
result.printResults();
```

**Success Criteria:**

- All algorithms find same occurrences
- KMP and Boyer-Moore perform better than naive search
- Rabin-Karp efficiently finds multiple patterns
- Correct handling of edge cases (empty pattern, pattern longer than text)

---

### Problem 9.3: B-Tree Implementation

**What to Build:** A self-balancing B-Tree suitable for database indexes.

**Core Requirements:**

- Configurable order (minimum degree t, 2t-1 keys per node)
- Operations: insert, delete, search
- Maintain B-Tree properties after every operation
- Support range queries (find all keys between a and b)
- Efficient disk-based storage (minimize disk reads)

**B-Tree Properties to Maintain:**

- All leaves at same level
- Node has between t-1 and 2t-1 keys (except root)
- Keys in node are sorted
- For internal node with k keys, has k+1 children

**Operations:**

- **Insert:** Add key while maintaining balance
- **Delete:** Remove key, merge/redistribute nodes if needed
- **Search:** Find key in tree
- **Range Query:** Return all keys in [min, max]
- **Traverse:** In-order traversal of all keys

**Features:**

- Generic type support (works with any comparable type)
- Bulk loading (efficient insertion of many sorted keys)
- Persistence (save tree to disk, load from disk)
- Statistics (height, number of nodes, number of keys, fill factor)

**Visualization:**

- Print tree structure showing nodes and keys
- Highlight node during operations (for debugging)

**API Design:**

```java
BTree<Integer> tree = new BTree<>(3); // order = 3

tree.insert(10);
tree.insert(20);
tree.insert(5);

boolean found = tree.search(20);
tree.delete(10);

List<Integer> range = tree.rangeQuery(5, 25);

tree.printTree(); // Visual representation
```

**Test Cases:**

- Sequential insertion (1, 2, 3, ..., n)
- Random insertion
- Deletions causing merges and redistributions
- Large tree (100K keys) performance testing

**Success Criteria:**

- Tree maintains balance after all operations
- Operations are efficient (log n)
- Range queries work correctly
- Tree can be persisted and reloaded
- Visualization clearly shows tree structure

---

### Problem 9.4: Huffman Compression

**What to Build:** Text compression using Huffman coding algorithm.

**Core Requirements:**

- Build Huffman tree from character frequencies
- Generate optimal prefix codes for each character
- Compress text using generated codes
- Decompress compressed data back to original text
- Handle any text (including special characters)

**Compression Process:**

1. Count character frequencies in input text
2. Build Huffman tree (greedy algorithm using priority queue)
3. Generate codes from tree (left=0, right=1)
4. Encode text using codes
5. Write tree structure and encoded data to file

**Decompression Process:**

1. Read tree structure from file
2. Read encoded data
3. Decode using tree (traverse from root based on bits)
4. Reconstruct original text

**File Format:**

```
[Tree Structure][Encoded Data]
```

**Features:**

- Compression ratio reporting (original size vs compressed size)
- Support large files (stream processing)
- Handle files with few unique characters efficiently
- Handle files with many unique characters
- Validate decompression (matches original)

**API Design:**

```java
HuffmanCompressor compressor = new HuffmanCompressor();

// Compress
compressor.compress("input.txt", "output.huff");
System.out.println("Compression ratio: " + compressor.getCompressionRatio());

// Decompress
compressor.decompress("output.huff", "restored.txt");

// Verify
boolean matches = filesMatch("input.txt", "restored.txt");
```

**Analysis:**

- Show Huffman tree structure
- Display code table (character → binary code)
- Calculate theoretical optimal compression
- Compare with actual compression achieved

**Test Cases:**

- Text with uniform distribution (all characters equally common)
- Text with skewed distribution (some characters very common)
- Small text (few bytes)
- Large text (megabytes)
- Binary files vs text files

**Success Criteria:**

- Decompression produces exact original text
- Achieves good compression on natural text (30-50%)
- Handles large files without memory issues
- Huffman codes are optimal (no shorter prefix-free code exists)
- Tree structure is correctly encoded/decoded

---

## Problem Set 10: JavaFX GUI Applications

### Problem 10.1: Text Editor

**What to Build:** A fully-featured text editor with modern IDE-like capabilities.

**Core Features:**

- Open, save, save as text files
- New file, close file
- Multiple tabs (edit multiple files)
- Undo/redo (unlimited levels)
- Cut, copy, paste
- Find and replace (with regex support)
- Line numbers
- Syntax highlighting for: Java, Python, HTML, JSON, XML

**Advanced Features:**

- Auto-save (periodic background saving)
- File watching (detect external changes)
- Recent files list
- Keyboard shortcuts (Ctrl+S, Ctrl+F, Ctrl+Z, etc.)
- Status bar (line number, column, file size, encoding)
- Word wrap toggle
- Font size adjustment
- Dark/light theme

**Find and Replace:**

- Case-sensitive option
- Whole word option
- Regular expression support
- Find next, find previous
- Replace one, replace all
- Highlight all matches

**Syntax Highlighting:**

- Keywords (blue)
- Strings (green)
- Comments (gray)
- Numbers (orange)
- Operators (default color)

**Success Criteria:**

- Can edit files up to 10MB without lag
- Undo/redo works correctly for all operations
- Syntax highlighting updates in real-time
- All keyboard shortcuts work
- No data loss on crashes (auto-save)

---

### Problem 10.2: Chart Visualizer

**What to Build:** A data visualization tool that creates interactive charts from CSV data.

**Core Features:**

- Import CSV files
- Display data in table view (editable)
- Create charts: Line Chart, Bar Chart, Pie Chart, Scatter Plot, Area Chart
- Multiple series support (plot multiple data sets)
- Export charts as images (PNG, JPG)
- Save/load projects (data + chart configuration)

**Chart Customization:**

- Title, axis labels
- Colors for each series
- Legend position (top, bottom, left, right)
- Grid lines (show/hide)
- Data point markers
- Tooltips (show values on hover)

**Interactive Features:**

- Zoom in/out
- Pan (move view)
- Click data points to see details
- Animate chart rendering
- Toggle series visibility (show/hide individual lines/bars)

**Data Operations:**

- Filter data (show only rows matching criteria)
- Sort by column
- Calculate statistics (min, max, average, sum)
- Add calculated columns (formula-based)

**UI Layout:**

```
[Menu Bar]
[Toolbar: Import, Export, Chart Type, Settings]
[Split View]
  [Left: Data Table]
  [Right: Chart Display]
[Bottom: Status Bar]
```

**Success Criteria:**

- Handles datasets with 10,000+ rows smoothly
- Charts update in real-time as data changes
- Exported images are high quality
- All chart types render correctly
- Intuitive user interface

---

### Problem 10.3: Image Editor

**What to Build:** A basic image editing application with common image manipulation features.

**Core Features:**

- Open images (PNG, JPG, GIF, BMP)
- Save images (with format conversion)
- Crop tool (select rectangle, crop to selection)
- Rotate (90°, 180°, 270°, custom angle)
- Flip (horizontal, vertical)
- Resize (scale by percentage or fixed dimensions)

**Filters:**

- Brightness adjustment (-100 to +100)
- Contrast adjustment
- Saturation (grayscale to oversaturated)
- Blur (Gaussian blur, adjustable radius)
- Sharpen
- Sepia tone
- Invert colors
- Edge detection

**Drawing Tools:**

- Brush (adjustable size and color)
- Eraser
- Line tool
- Rectangle (filled/outline)
- Circle (filled/outline)
- Text tool (add text with font selection)

**Features:**

- Undo/redo (10 levels minimum)
- Zoom (fit to window, actual size, custom zoom)
- Live preview for filters (see effect before applying)
- Batch processing (apply same operations to multiple images)
- Histogram display

**UI Layout:**

```
[Menu Bar]
[Toolbar: Tools, Filters]
[Left Panel: Tool Options]
[Center: Image Canvas with Scrollbars]
[Right Panel: Layers, History]
[Bottom: Zoom Controls, Image Info]
```

**Success Criteria:**

- Handles large images (4K resolution) smoothly
- Filters process in real-time or show progress bar
- Drawing tools are responsive
- No quality loss with undo/redo
- All common image formats supported

---

### Problem 10.4: Kanban Board

**What to Build:** A task management application using the Kanban methodology.

**Core Features:**

- Multiple boards (e.g., Personal, Work, Project X)
- Columns: Backlog, To Do, In Progress, Done (customizable)
- Cards representing tasks
- Drag-and-drop cards between columns
- Add, edit, delete cards
- Card details: title, description, due date, priority, assignee, tags

**Card Management:**

- Color coding by priority (high=red, medium=yellow, low=green)
- Due date warnings (overdue cards highlighted)
- Checklist items within cards
- Comments/notes on cards
- Attachments (file links)
- Card history (track moves between columns)

**Features:**

- Search/filter cards (by title, tag, assignee)
- Archive completed cards (remove from view but keep data)
- Statistics dashboard (cards per column, completion rate, cycle time)
- Export board to PDF/CSV
- Save boards automatically (persistence)
- Multiple views: Board view, List view, Calendar view

**Customization:**

- Add/remove/rename columns
- Column limits (WIP limit: max cards per column)
- Custom tags (create tags, assign colors)
- Custom fields (add extra info to cards)

**UI Layout:**

```
[Menu Bar]
[Toolbar: Boards dropdown, Add Card, Search, View Options]
[Horizontal Columns]
  [Backlog]  [To Do]  [In Progress]  [Done]
    [Card]     [Card]    [Card]        [Card]
    [Card]     [Card]                  [Card]
[Bottom: Statistics Summary]
```

**Success Criteria:**

- Drag-and-drop is smooth and intuitive
- Handles boards with 500+ cards
- Data persists across restarts
- All CRUD operations work correctly
- Responsive UI (no lag on interactions)

---

## Problem Set 11: Streams & Functional Programming

### Problem 11.1: Custom Stream API

**What to Build:** Your own implementation of Java's Stream API from scratch.

**Core Operations to Implement:** **Intermediate Operations (lazy):**

- `filter(Predicate)` - keep elements matching condition
- `map(Function)` - transform each element
- `flatMap(Function)` - flatten nested structures
- `distinct()` - remove duplicates
- `sorted()` - sort elements
- `sorted(Comparator)` - sort with custom comparator
- `limit(n)` - take first n elements
- `skip(n)` - skip first n elements
- `peek(Consumer)` - perform action without modifying stream

**Terminal Operations (eager):**

- `forEach(Consumer)` - perform action on each element
- `collect(Collector)` - collect into collection
- `reduce(BinaryOperator)` - reduce to single value
- `count()` - count elements
- `anyMatch(Predicate)` - check if any match
- `allMatch(Predicate)` - check if all match
- `noneMatch(Predicate)` - check if none match
- `findFirst()` - get first element
- `findAny()` - get any element
- `min(Comparator)` - find minimum
- `max(Comparator)` - find maximum

**Key Requirements:**

- Lazy evaluation (intermediate operations don't execute until terminal operation)
- Method chaining (fluent API)
- Generic types (works with any type)
- Stateless operations where possible
- Short-circuiting for `limit`, `anyMatch`, `findFirst`

**Example Usage:**

```java
MyStream<Integer> stream = MyStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

List<Integer> result = stream
    .filter(n -> n % 2 == 0)      // 2, 4, 6, 8, 10
    .map(n -> n * n)               // 4, 16, 36, 64, 100
    .sorted()                      // already sorted
    .limit(3)                      // 4, 16, 36
    .collect(Collectors.toList());

System.out.println(result); // [4, 16, 36]
```

**Advanced Features:**

- Parallel streams (process elements in parallel)
- Custom collectors
- Stream concatenation
- Infinite streams (with limit)

**Success Criteria:**

- Lazy evaluation works correctly (intermediate ops don't execute early)
- Produces same results as Java's Stream API
- Efficient (no unnecessary iterations)
- Handles large datasets (1M+ elements)

---

### Problem 11.2: Functional Collections

**What to Build:** Immutable collection classes with functional operations.

**Collections to Implement:**

1. **ImmutableList<T>**
2. **ImmutableSet<T>**
3. **ImmutableMap<K, V>**

**Core Properties:**

- Immutable (all operations return new collection, original unchanged)
- Thread-safe (safe for concurrent access)
- Functional methods (map, filter, reduce, etc.)
- Efficient (structural sharing where possible)

**Operations for ImmutableList:**

```java
ImmutableList<T> add(T element)
ImmutableList<T> addAll(Collection<T> elements)
ImmutableList<T> remove(T element)
ImmutableList<T> removeAt(int index)
ImmutableList<T> set(int index, T element)
T get(int index)
int size()
boolean contains(T element)

// Functional operations
ImmutableList<R> map(Function<T, R> mapper)
ImmutableList<T> filter(Predicate<T> predicate)
T reduce(T identity, BinaryOperator<T> accumulator)
ImmutableList<T> take(int n)
ImmutableList<T> drop(int n)
ImmutableList<T> reverse()
ImmutableList<T> sort(Comparator<T> comparator)
```

**Method Chaining Example:**

```java
ImmutableList<Integer> numbers = ImmutableList.of(1, 2, 3, 4, 5);

ImmutableList<String> result = numbers
    .filter(n -> n % 2 == 0)           // [2, 4]
    .map(n -> n * n)                   // [4, 16]
    .map(n -> "Number: " + n)          // ["Number: 4", "Number: 16"]
    .add("Extra")                      // ["Number: 4", "Number: 16", "Extra"]
    .reverse();                        // ["Extra", "Number: 16", "Number: 4"]

// Original unchanged
System.out.println(numbers); // [1, 2, 3, 4, 5]
```

**Implementation Requirements:**

- Use structural sharing (don't copy entire structure on each change)
- Efficient operations (don't iterate entire collection unnecessarily)
- Builder pattern for efficient construction

**Success Criteria:**

- All operations preserve immutability
- Thread-safe without synchronization
- Functional operations work correctly
- Performance is reasonable (not worse than 3x mutable collections)
- Original collection never changes

---

### Problem 11.3: Parallel Data Processor

**What to Build:** A system for processing large datasets in parallel using streams and custom collectors.

**Core Requirements:**

- Process CSV/JSON data files in parallel
- Custom collectors for aggregations
- Support filtering, mapping, grouping, aggregating
- Performance comparison: sequential vs parallel
- Handle errors gracefully (continue processing on errors)

**Custom Collectors to Implement:**

- `toImmutableList()` - collect to immutable list
- `groupingBy(classifier, downstream)` - group elements
- `partitioningBy(predicate)` - split into two groups
- `summarizing()` - compute statistics (count, sum, min, max, average)
- `toMap(keyMapper, valueMapper)` - collect to map

**Use Cases:** **1. Log File Analysis:**

- Parse log file with millions of entries
- Extract timestamp, log level, message
- Group by log level (ERROR, WARN, INFO)
- Count occurrences of each level
- Find top 10 most common error messages

**2. Sales Data Processing:**

- Process sales records (date, product, quantity, price)
- Calculate total revenue per product
- Find best-selling products
- Group sales by month
- Calculate average order value

**3. Sensor Data Aggregation:**

- Process sensor readings (timestamp, sensor_id, value)
- Calculate average, min, max per sensor
- Detect anomalies (values outside normal range)
- Group by time windows (hourly aggregates)

**API Design:**

```java
DataProcessor processor = new DataProcessor();

// Sequential processing
Result result1 = processor.processSequential("data.csv", pipeline);

// Parallel processing
Result result2 = processor.processParallel("data.csv", pipeline, numThreads);

// Compare performance
System.out.println("Sequential time: " + result1.getExecutionTime());
System.out.println("Parallel time: " + result2.getExecutionTime());
System.out.println("Speedup: " + result1.getExecutionTime() / result2.getExecutionTime());
```

**Performance Requirements:**

- Process 1M records in under 10 seconds (parallel)
- Parallel processing shows speedup (2x+ on 4-core CPU)
- Memory efficient (don't load entire dataset into memory)

**Success Criteria:**

- Parallel processing produces same results as sequential
- Speedup increases with more cores
- Custom collectors work correctly
- Handles large datasets (100M+ records)
- Error handling doesn't corrupt results

---

### Problem 11.4: Reactive Programming (Simple Implementation)

**What to Build:** A basic reactive streams implementation with backpressure support.

**Core Concepts:**

- **Publisher:** source of data
- **Subscriber:** consumes data
- **Subscription:** controls data flow
- **Backpressure:** subscriber controls rate of data

**Interfaces to Implement:**

```java
public interface Publisher<T> {
    void subscribe(Subscriber<T> subscriber);
}

public interface Subscriber<T> {
    void onSubscribe(Subscription subscription);
    void onNext(T item);
    void onError(Throwable throwable);
    void onComplete();
}

public interface Subscription {
    void request(long n);  // Request n items
    void cancel();         // Cancel subscription
}
```

**Publishers to Create:**

- `RangePublisher` - emits numbers in range
- `IterablePublisher` - emits items from collection
- `IntervalPublisher` - emits incrementing number periodically
- `CustomPublisher` - user-defined data source

**Operators to Implement:**

- `map(Function)` - transform each item
- `filter(Predicate)` - keep only matching items
- `take(n)` - take first n items
- `skip(n)` - skip first n items
- `buffer(n)` - collect n items into batch
- `flatMap(Function)` - flatten publishers

**Example Usage:**

```java
// Create publisher
Publisher<Integer> numbers = new RangePublisher(1, 100);

// Apply operators
Publisher<String> strings = numbers
    .map(n -> n * 2)           // Double each number
    .filter(n -> n % 3 == 0)   // Keep multiples of 3
    .map(n -> "Number: " + n); // Convert to string

// Subscribe with backpressure
strings.subscribe(new Subscriber<String>() {
    private Subscription subscription;
    
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(10); // Request 10 items
    }
    
    @Override
    public void onNext(String item) {
        System.out.println(item);
        subscription.request(1); // Request next item
    }
    
    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error: " + throwable);
    }
    
    @Override
    public void onComplete() {
        System.out.println("Complete!");
    }
});
```

**Backpressure Strategies:**

- **Buffering:** store items when subscriber is slow
- **Dropping:** drop items when subscriber can't keep up
- **Throttling:** slow down publisher
- **Error:** throw error when buffer full

**Success Criteria:**

- Backpressure prevents overwhelming slow subscribers
- All operators work correctly
- Multiple subscribers can subscribe to same publisher
- No memory leaks (resources cleaned up on cancel)
- Thread-safe (can be used from multiple threads)

---

## Problem Set 12: Enterprise Patterns

### Problem 12.1: DAO Pattern Implementation

**What to Build:** A complete Data Access Object layer with multiple implementations.

**Core Requirements:**

- Define DAO interfaces for entities (UserDAO, ProductDAO, OrderDAO)
- Implement multiple DAO versions: JDBC-based, In-memory (for testing)
- Support CRUD operations: create, read, update, delete
- Support querying: find by ID, find all, find with criteria
- Transaction support

**Entities:**

```java
User: id, username, email, createdAt
Product: id, name, description, price, stock
Order: id, userId, orderDate, status, items (List<OrderItem>)
OrderItem: productId, quantity, price
```

**DAO Interface Example:**

```java
public interface UserDAO {
    User create(User user);
    User findById(Long id);
    List<User> findAll();
    List<User> findByEmail(String email);
    void update(User user);
    void delete(Long id);
}
```

**Implementations:**

1. **JdbcUserDAO** - uses JDBC to persist to database
2. **InMemoryUserDAO** - stores in HashMap (for testing)

**Features:**

- Connection management (use connection pool)
- Prepared statements (prevent SQL injection)
- Exception handling (convert SQLException to custom exceptions)
- Logging (log all database operations)
- Batch operations (insert/update multiple records efficiently)

**DAO Factory:**

```java
public class DAOFactory {
    public static DAOFactory getInstance(String type) {
        if (type.equals("jdbc")) return new JdbcDAOFactory();
        if (type.equals("memory")) return new InMemoryDAOFactory();
        throw new IllegalArgumentException("Unknown type");
    }
    
    public abstract UserDAO getUserDAO();
    public abstract ProductDAO getProductDAO();
    public abstract OrderDAO getOrderDAO();
}
```

**Success Criteria:**

- DAO interfaces are clean and consistent
- Easy to swap implementations (JDBC ↔ in-memory)
- All CRUD operations work correctly
- Transactions maintain data consistency
- Code is testable (can test with in-memory DAO)

---

### Problem 12.2: Service Layer Architecture

**What to Build:** A three-tier application with clear separation of concerns.

**Architecture Layers:**

```
Presentation Layer (UI)
        ↓
Service Layer (Business Logic)
        ↓
DAO Layer (Data Access)
        ↓
Database
```

**Responsibilities:** **Presentation Layer:**

- Handle user input
- Display data
- No business logic
- No direct database access

**Service Layer:**

- Business logic
- Validation
- Coordinate multiple DAOs
- Transaction management
- No UI concerns
- No SQL

**DAO Layer:**

- Database operations only
- No business logic
- Return domain objects

**Example Application: E-commerce System**

**Service Classes:**

```java
public class UserService {
    private UserDAO userDAO;
    
    public User register(String username, String email, String password) {
        // Business logic
        if (username.length() < 3) throw new ValidationException("Username too short");
        if (!isValidEmail(email)) throw new ValidationException("Invalid email");
        if (userDAO.findByEmail(email) != null) throw new DuplicateException("Email exists");
        
        // Hash password
        String hashedPassword = hashPassword(password);
        
        // Create user
        User user = new User(username, email, hashedPassword);
        return userDAO.create(user);
    }
    
    public User authenticate(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user == null) throw new AuthException("User not found");
        if (!checkPassword(password, user.getPasswordHash())) {
            throw new AuthException("Invalid password");
        }
        return user;
    }
}

public class OrderService {
    private OrderDAO orderDAO;
    private ProductDAO productDAO;
    private UserDAO userDAO;
    
    public Order placeOrder(Long userId, List<OrderItem> items) {
        // Validate user exists
        User user = userDAO.findById(userId);
        if (user == null) throw new NotFoundException("User not found");
        
        // Validate products and stock
        for (OrderItem item : items) {
            Product product = productDAO.findById(item.getProductId());
            if (product == null) throw new NotFoundException("Product not found");
            if (product.getStock() < item.getQuantity()) {
                throw new OutOfStockException("Insufficient stock");
            }
        }
        
        // Create order (in transaction)
        Order order = new Order(userId, LocalDateTime.now(), "PENDING", items);
        orderDAO.create(order);
        
        // Update stock
        for (OrderItem item : items) {
            Product product = productDAO.findById(item.getProductId());
            product.setStock(product.getStock() - item.getQuantity());
            productDAO.update(product);
        }
        
        return order;
    }
}
```

**Presentation Layer (CLI):**

```java
public class ECommerceApp {
    private UserService userService;
    private OrderService orderService;
    private ProductService productService;
    
    public void run() {
        // CLI menu
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Browse Products");
            System.out.println("4. Place Order");
            // ...
        }
    }
}
```

**Transaction Management:**

```java
@Transactional
public Order placeOrder(...) {
    // All database operations in this method
    // are part of same transaction
}
```

**Success Criteria:**

- Clear separation between layers
- Business logic is in service layer (not DAO or UI)
- Services are testable (can mock DAOs)
- Transactions work correctly (all or nothing)
- Code is maintainable and extensible

---

### Problem 12.3: Caching System

**What to Build:** A multi-level caching system with various eviction policies.

**Core Requirements:**

- In-memory cache (primary cache)
- Distributed cache simulation (secondary cache)
- Multiple eviction policies: LRU, LFU, FIFO, TTL
- Configurable cache size
- Thread-safe operations

**Cache Interface:**

```java
public interface Cache<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    void clear();
    int size();
    CacheStats getStats();
}
```

**Eviction Policies:** **1. LRU (Least Recently Used):**

- Evict least recently accessed item
- Use doubly-linked list + hash map

**2. LFU (Least Frequently Used):**

- Evict least frequently accessed item
- Track access count per item

**3. FIFO (First In First Out):**

- Evict oldest item
- Use queue

**4. TTL (Time To Live):**

- Items expire after specified time
- Background thread removes expired items

**Multi-Level Cache:**

```
┌──────────────┐
│  L1 Cache    │ (In-memory, fast, small)
│  (LRU)       │
└──────────────┘
       ↓ miss
┌──────────────┐
│  L2 Cache    │ (Distributed, slower, larger)
│  (LFU)       │
└──────────────┘
       ↓ miss
┌──────────────┐
│  Database    │
└──────────────┘
```

**Cache-Aside Pattern:**

```java
public User getUserById(Long id) {
    // Check cache
    User user = cache.get(id);
    if (user != null) return user;
    
    // Cache miss: load from database
    user = userDAO.findById(id);
    
    // Store in cache
    if (user != null) cache.put(id, user);
    
    return user;
}
```

**Cache Statistics:**

```java
public class CacheStats {
    private AtomicLong hits;
    private AtomicLong misses;
    private AtomicLong evictions;
    
    public double getHitRate() {
        long total = hits.get() + misses.get();
        return total == 0 ? 0 : (double) hits.get() / total;
    }
}
```

**Features:**

- Write-through cache (update cache and database together)
- Write-behind cache (update cache immediately, database later)
- Cache warming (preload frequently accessed items)
- Cache invalidation (remove stale data)
- Distributed cache synchronization

**Success Criteria:**

- High hit rate (80%+ for common access patterns)
- Thread-safe under concurrent access
- Eviction policies work correctly
- No memory leaks (bounded size)
- Performance improvement over database-only access (10x+ faster)

---

### Problem 12.4: Message Queue

**What to Build:** An in-memory message broker supporting publish-subscribe and point-to-point messaging.

**Core Requirements:**

- Producers send messages to queues/topics
- Consumers receive messages from queues/topics
- Support two messaging models: Queue (point-to-point), Topic (publish-subscribe)
- Message persistence (optional: save to disk)
- Delivery guarantees: at-least-once, at-most-once, exactly-once

**Messaging Models:** **1. Queue (Point-to-Point):**

- Each message consumed by exactly one consumer
- Multiple consumers compete for messages
- Load balancing across consumers

**2. Topic (Publish-Subscribe):**

- Each message delivered to all subscribers
- Late subscribers don't receive old messages
- Optional: durable subscriptions (receive messages sent while offline)

**Message Structure:**

```java
public class Message {
    private String id;
    private String body;
    private Map<String, String> headers;
    private long timestamp;
    private int priority;
}
```

**API Design:**

```java
// Queue model
MessageQueue queue = broker.getQueue("orders");
Producer producer = queue.createProducer();
producer.send(new Message("Order #123"));

Consumer consumer = queue.createConsumer();
consumer.setMessageListener(msg -> {
    System.out.println("Received: " + msg.getBody());
});

// Topic model
Topic topic = broker.getTopic("notifications");
Publisher publisher = topic.createPublisher();
publisher.publish(new Message("System update available"));

Subscriber subscriber = topic.createSubscriber();
subscriber.subscribe(msg -> {
    System.out.println("Notification: " + msg.getBody());
});
```

**Features:**

- Message filtering (consumers can filter by headers)
- Priority queues (high priority messages delivered first)
- Dead letter queue (failed messages go here)
- Message expiration (TTL for messages)
- Transaction support (send multiple messages atomically)
- Acknowledgements (consumer confirms message receipt)

**Delivery Guarantees:** **At-most-once:** Message sent without confirmation (may be lost) **At-least-once:** Message resent until acknowledged (may duplicate) **Exactly-once:** Message delivered exactly once (complex, uses transactions)

**Persistence:**

- Store messages to disk (survive broker restart)
- Write-ahead log (fast persistence)
- Configurable persistence level per queue/topic

**Success Criteria:**

- Supports 10,000+ messages/second throughput
- Multiple producers and consumers work concurrently
- Message ordering preserved in queues
- No message loss with persistence enabled
- Delivery guarantees work as specified

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