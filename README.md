# Complete Java + OOP Problem Sets Specification
This Repository is for Learning OOP with Java.
I'm aiming to Solve these problem sets during OOP course.

# Problem Sets (Units 2–18)

This document groups the problem sets into three sections as requested: Units 2–7, Units 8–13, and Units 14–18. Each problem description is structured for clarity and challenge while avoiding hints or solution paths.

---

## Units 2–7

### Unit 2: Java Foundations — The Language as a Tool

**Problem 2.1 — Binary Badge**
- **Goal:** Build a CLI program that converts a decimal ID into binary, hexadecimal, and a custom 6‑bit badge code.
- **Input/Output:** One numeric ID in, three representations out, with a stable format for automated checking.
- **Constraints:** No arrays, no collections, no built‑in base conversion helpers.
- **Edge Cases:** Zero, negatives, extremely large values, and values beyond 6‑bit range.
- **Success Criteria:** Deterministic output, clean error handling, and consistent formatting across cases.

**Problem 2.2 — You Are the Compiler**
- **Goal:** Analyze a single line of simplified “Java‑like” code and flag invalid identifiers and literals.
- **Input/Output:** One line in, a report of invalid tokens and reasons out.
- **Constraints:** No regex, no external libraries, only manual character processing.
- **Edge Cases:** Identifiers with illegal starts, keywords used as identifiers, malformed numbers, unterminated strings.
- **Success Criteria:** Accurate classification without attempts to auto‑correct inputs.

**Problem 2.3 — Interpreter 0.1**
- **Goal:** Evaluate a single arithmetic expression in the format `a op b`.
- **Input/Output:** One line in, result or error message out.
- **Constraints:** No `switch`, no `Math` utilities.
- **Edge Cases:** Missing operands, invalid operator, division/modulo by zero, non‑numeric values.
- **Success Criteria:** Clear parsing logic and stable error behavior.

### Unit 3: Methods — Behavior Before Structure

**Problem 3.1 — Command Library**
- **Goal:** Implement `parseIntSafe`, `isPrime`, `gcd`, and `clamp` plus a strict test harness.
- **Input/Output:** Tests must show pass/fail outcomes for each method.
- **Constraints:** At least 12 non‑trivial tests per method; no hard‑coded expected outputs.
- **Edge Cases:** Boundary values, negatives, zeros, and large inputs.
- **Success Criteria:** Tests expose subtle bugs and methods remain reusable.

**Problem 3.2 — Autograder Simulator**
- **Goal:** Compute weighted grades and letter grades using reusable methods.
- **Input/Output:** Multiple category scores in, numeric and letter grade out.
- **Constraints:** No duplicated grading logic; grading rules must be changeable via methods.
- **Edge Cases:** Invalid scores, missing categories, boundary grade cutoffs.
- **Success Criteria:** Robust validation and clean separation of calculation and I/O.

**Problem 3.3 — Reverse Polish Calculator**
- **Goal:** Evaluate RPN expressions without arrays, stacks, or collections.
- **Input/Output:** One line of tokens in, result or explicit error out.
- **Constraints:** Only methods and primitive variables for intermediate state.
- **Edge Cases:** Malformed sequences, insufficient operands, extra operands.
- **Success Criteria:** Correct results for valid input and meaningful rejection of invalid input.

### Unit 4: Classes and Objects — Modeling Reality

**Problem 4.1 — Escape Room Object**
- **Goal:** Model `Door`, `Key`, and `Room` objects to simulate an escape sequence.
- **Input/Output:** A text‑based simulation that shows object interactions.
- **Constraints:** No inheritance; behaviors owned by their objects.
- **Edge Cases:** Wrong key, locked door opened, missing key scenarios.
- **Success Criteria:** Object responsibilities are clear and invalid actions are prevented.

**Problem 4.2 — Audio Player**
- **Goal:** Design `Track`, `Playlist`, and a player that supports play/pause/next/previous.
- **Input/Output:** A text‑based simulation of playback operations.
- **Constraints:** State must remain consistent across operations.
- **Edge Cases:** Empty playlist, repeated next/previous at boundaries.
- **Success Criteria:** Clean separation of playlist logic and playback state.

**Problem 4.3 — Blackjack Lite**
- **Goal:** Model a simplified Blackjack round using `Card`, `Deck`, and `Hand`.
- **Input/Output:** A playable round with clear output of hands and results.
- **Constraints:** No collections for shuffling; object responsibilities must be distinct.
- **Edge Cases:** Multiple aces, empty deck, dealer rules.
- **Success Criteria:** Correct rules and clean object collaboration.

### Unit 5: Encapsulation and Class Design

**Problem 5.1 — Bank Ledger**
- **Goal:** Implement a `BankAccount` that never exposes its raw balance.
- **Input/Output:** Deposits/withdrawals in, summaries and logs out.
- **Constraints:** Invalid operations must be rejected and logged.
- **Edge Cases:** Negative deposit, overdraft attempts, repeated failures.
- **Success Criteria:** Strong invariants and no external mutation of balance.

**Problem 5.2 — Temperature Vault**
- **Goal:** Store only valid temperatures and record rejected values.
- **Input/Output:** Temperature readings in, statistics out.
- **Constraints:** No exposure of mutable internal state.
- **Edge Cases:** Values at range boundaries, repeated invalid inputs.
- **Success Criteria:** Only safe data persists and rejection tracking is reliable.

**Problem 5.3 — Cheater Detection**
- **Goal:** Build a `StudentScore` that locks after finalization.
- **Input/Output:** Score updates in, verified read‑only state out.
- **Constraints:** Post‑finalization updates must be rejected and logged.
- **Edge Cases:** Multiple finalize attempts, invalid score changes.
- **Success Criteria:** No bypass of the finalized state via direct access.

### Unit 6: Constructors and Object Initialization

**Problem 6.1 — Fault‑Proof Device**
- **Goal:** Ensure a `Device` cannot be created in an invalid state.
- **Input/Output:** Valid device data in, constructed devices out; invalid data rejected.
- **Constraints:** Use constructors to enforce all invariants.
- **Edge Cases:** Missing required fields, malformed firmware version.
- **Success Criteria:** No invalid instances exist at any point.

**Problem 6.2 — Multiple Worlds**
- **Goal:** Create a `GameWorld` with default, seed‑based, and file‑based constructors.
- **Input/Output:** Constructors in, fully initialized worlds out.
- **Constraints:** No post‑construction “setup” methods allowed.
- **Edge Cases:** Invalid seed, missing or corrupted file.
- **Success Criteria:** Consistent internal state across all construction paths.

**Problem 6.3 — Static vs Instance Init**
- **Goal:** Use static init for shared chessboard metadata and instance init for per‑game pieces.
- **Input/Output:** Multiple independent games created without shared state corruption.
- **Constraints:** Clear explanation in comments for static vs instance usage.
- **Edge Cases:** Multiple instances created in sequence or parallel.
- **Success Criteria:** Each game is isolated, shared data is stable.

### Unit 7: Static Members and Class‑Level Behavior

**Problem 7.1 — Global Counter**
- **Goal:** Track total objects created across multiple classes and per‑class counts.
- **Input/Output:** Object creations in, global and per‑class counts out.
- **Constraints:** Counters must not reset unintentionally.
- **Edge Cases:** Rapid object creation, unused objects.
- **Success Criteria:** Accurate and stable reporting of counts.

**Problem 7.2 — Access Control**
- **Goal:** Enforce a maximum number of active sessions via static control.
- **Input/Output:** Session creation attempts in, approvals/rejections out.
- **Constraints:** No invalid session may exist if the limit is reached.
- **Edge Cases:** Sessions ending out of order, repeated creation attempts.
- **Success Criteria:** Limit is respected and behavior remains consistent.

**Problem 7.3 — Design Smell Challenge**
- **Goal:** Refactor a static‑heavy design to reduce static usage without changing behavior.
- **Input/Output:** Before/after design summary and unchanged external behavior.
- **Constraints:** No replacement with global variables or equivalent anti‑patterns.
- **Edge Cases:** Hidden dependencies and implicit shared state.
- **Success Criteria:** Clear improvement in design with functional parity.

---

## Units 8–13

### Unit 8: Relationships Between Classes — Object Collaboration

**Problem 8.1 — Museum Exhibit**
- **Goal:** Model `Museum`, `Room`, and `Artifact` with strict composition rules.
- **Input/Output:** Artifact placement and movement in, valid room states out.
- **Constraints:** Artifacts cannot exist without a room.
- **Edge Cases:** Moving artifacts between rooms, empty rooms.
- **Success Criteria:** Relationship invariants are always preserved.

**Problem 8.2 — Ride‑Share System**
- **Goal:** Model `Driver`, `Passenger`, and `Ride` with correct association rules.
- **Input/Output:** Ride creation and completion in, consistent ride states out.
- **Constraints:** A ride cannot exist without a driver.
- **Edge Cases:** Passenger cancels, driver unavailable, multiple passengers.
- **Success Criteria:** No invalid ride state can occur.

**Problem 8.3 — Campus System**
- **Goal:** Model `Course`, `Professor`, `Student`, and `Enrollment`.
- **Input/Output:** Enrollment changes in, consistent cross‑references out.
- **Constraints:** Enrollment must be explicit and two‑way consistent.
- **Edge Cases:** Drop/add cycles, professor reassignment.
- **Success Criteria:** Relationship network stays consistent under change.

### Unit 9: Inheritance — Reuse with Caution

**Problem 9.1 — Creature Hierarchy**
- **Goal:** Build a `Creature` hierarchy that balances shared behavior and specialization.
- **Input/Output:** Concrete creature behaviors demonstrated through a simulation.
- **Constraints:** Avoid “god class” design and explain field placement decisions.
- **Edge Cases:** Overlapping behaviors and conflicting abilities.
- **Success Criteria:** Clean inheritance with justified structure.

**Problem 9.2 — Billing System**
- **Goal:** Implement `Plan` subclasses with distinct pricing and limits.
- **Input/Output:** Usage data in, computed charges out.
- **Constraints:** Base class must enable extension without edits.
- **Edge Cases:** Boundary usage, invalid plan data.
- **Success Criteria:** Consistent billing behavior across all plan types.

**Problem 9.3 — Inheritance Trap**
- **Goal:** Refactor an earlier design to remove inappropriate inheritance.
- **Input/Output:** Same external behavior with improved internal structure.
- **Constraints:** Use composition or other relationships instead of inheritance.
- **Edge Cases:** Behaviors that previously relied on inheritance shortcuts.
- **Success Criteria:** Clear rationale and reduced design risk.

### Unit 10: Polymorphism — One Interface, Many Behaviors

**Problem 10.1 — Shape Renderer**
- **Goal:** Use polymorphism to compute area and render ASCII shapes.
- **Input/Output:** Mixed shapes in, correct outputs per shape out.
- **Constraints:** Renderer cannot use type checks or per‑type conditionals.
- **Edge Cases:** New shapes added without renderer changes.
- **Success Criteria:** Dynamic dispatch handles all behaviors correctly.

**Problem 10.2 — Payment Gateway**
- **Goal:** Process multiple payment types through a single interface.
- **Input/Output:** Payment request in, transaction result out.
- **Constraints:** No `instanceof` in the gateway.
- **Edge Cases:** Invalid payment, partial payment data.
- **Success Criteria:** Clean polymorphic flow and clear error handling.

**Problem 10.3 — Polymorphic Inventory**
- **Goal:** Store mixed item types and compute totals via polymorphism.
- **Input/Output:** Items in, receipt and totals out.
- **Constraints:** Inventory logic must not change to add new item types.
- **Edge Cases:** Items with special pricing rules.
- **Success Criteria:** Accurate totals with type‑agnostic processing.

### Unit 11: Abstraction — Designing for Change

**Problem 11.1 — Abstract Engine**
- **Goal:** Define an abstract `Engine` with stable public behavior.
- **Input/Output:** Different engine types in, consistent interface behavior out.
- **Constraints:** Subclasses must provide required implementations.
- **Edge Cases:** Engines with different performance models.
- **Success Criteria:** Interchangeable usage without changing client code.

**Problem 11.2 — Workflow Framework**
- **Goal:** Create a fixed workflow with customizable steps via abstraction.
- **Input/Output:** Two or more report types in, consistent workflow out.
- **Constraints:** Workflow order must not be overridable.
- **Edge Cases:** Missing or partial subclass implementations.
- **Success Criteria:** Stable process with flexible details.

**Problem 11.3 — Future‑Proof Refactor**
- **Goal:** Refactor a prior system to be open for extension, closed for modification.
- **Input/Output:** A new subtype added without edits to existing classes.
- **Constraints:** No “switch by type” or similar workarounds.
- **Edge Cases:** Adding a subtype with different behavior.
- **Success Criteria:** Demonstrated extensibility with no core changes.

### Unit 12: Interfaces — Multiple Inheritance of Behavior

**Problem 12.1 — Capability System**
- **Goal:** Model orthogonal capabilities using interfaces and real behaviors.
- **Input/Output:** Objects used via different interfaces in different contexts.
- **Constraints:** Capabilities must be meaningful, not empty method stubs.
- **Edge Cases:** Objects with multiple capabilities used independently.
- **Success Criteria:** Clean separation of cross‑cutting behaviors.

**Problem 12.2 — Event Plugin Framework**
- **Goal:** Build a plugin system where the host is unaware of plugin types.
- **Input/Output:** Plugins in, host executes common contract out.
- **Constraints:** No modifications to host required for new plugins.
- **Edge Cases:** Plugin failure or misconfiguration.
- **Success Criteria:** True contract‑based extension.

**Problem 12.3 — Multiple Contracts**
- **Goal:** Design a class that satisfies three interfaces with real responsibilities.
- **Input/Output:** Use the class through each interface independently.
- **Constraints:** Avoid “god object” sprawl.
- **Edge Cases:** Conflicting interface expectations.
- **Success Criteria:** Cohesive design with distinct behaviors.

### Unit 13: Packages and the Java Object Model

**Problem 13.1 — Package Split**
- **Goal:** Refactor a project into `model`, `service`, and `ui` packages.
- **Input/Output:** Clean package boundaries with minimal public surface.
- **Constraints:** Use package‑private access for internal helpers.
- **Edge Cases:** External code trying to access hidden internals.
- **Success Criteria:** Enforced encapsulation via package design.

**Problem 13.2 — Equality Rules**
- **Goal:** Implement `equals`, `hashCode`, and `toString` correctly for three classes.
- **Input/Output:** Objects in, correct equality and hash behavior out.
- **Constraints:** Follow Java equality contracts.
- **Edge Cases:** Nulls, self‑comparison, differing field values.
- **Success Criteria:** Consistent behavior in hashed collections.

**Problem 13.3 — Hierarchy Test**
- **Goal:** Demonstrate the Java object model across a multi‑level hierarchy.
- **Input/Output:** Tests that show `Object` methods and overrides in action.
- **Constraints:** No frameworks; demonstrate behavior explicitly.
- **Edge Cases:** Default vs overridden method behavior.
- **Success Criteria:** Clear understanding of `Object` in the type system.

---

## Units 14–18

### Unit 14: Exception Handling — Designing for Failure

**Problem 14.1 — Input Validator**
- **Goal:** Continuously prompt until valid input is received without crashing.
- **Input/Output:** User input in, validated output or error messages out.
- **Constraints:** Distinct messages for different error categories.
- **Edge Cases:** Empty input, wrong type, boundary values.
- **Success Criteria:** Resilient loop and clear error feedback.

**Problem 14.2 — Custom Exceptions**
- **Goal:** Define and use custom exceptions in a `BankAccount` system.
- **Input/Output:** Invalid operations in, explicit exception types out.
- **Constraints:** Exceptions should be intentional and documented.
- **Edge Cases:** Multiple failures in sequence, recovery handling.
- **Success Criteria:** Meaningful exception flow and clean handling.

**Problem 14.3 — File Robustness**
- **Goal:** Differentiate missing file, bad data, and unexpected failures.
- **Input/Output:** File path in, classified error or parsed result out.
- **Constraints:** No silent failures; clear user‑facing messages.
- **Edge Cases:** Partial data, corrupted content.
- **Success Criteria:** Correct classification and graceful exit.

### Unit 15: Generics and Collections — Reusable Abstractions

**Problem 15.1 — Generic Box**
- **Goal:** Implement a reusable generic container with safe operations.
- **Input/Output:** Values in, type‑safe retrieval out.
- **Constraints:** No unsafe casts or suppressed warnings.
- **Edge Cases:** Box swapping with different types.
- **Success Criteria:** Clean generic design and safe usage.

**Problem 15.2 — Library Index**
- **Goal:** Index books by multiple fields using collections.
- **Input/Output:** Books and updates in, search results out.
- **Constraints:** Indexes must remain consistent across updates.
- **Edge Cases:** Duplicate fields, removals, reindexing.
- **Success Criteria:** Reliable search and maintenance of indices.

**Problem 15.3 — Mini Search Engine**
- **Goal:** Index documents and return top‑K results for queries.
- **Input/Output:** Documents in, ranked results out.
- **Constraints:** Deterministic tie handling; no external libraries.
- **Edge Cases:** Empty query, unseen words, duplicate documents.
- **Success Criteria:** Stable ranking and reusable index.

### Unit 16: File Handling and Object Persistence

**Problem 16.1 — Note Vault**
- **Goal:** Persist notes with timestamps and restore them safely.
- **Input/Output:** Notes in, file saved and reloaded out.
- **Constraints:** Must tolerate missing or corrupted files.
- **Edge Cases:** Empty file, partial write, malformed timestamps.
- **Success Criteria:** No crashes and no data loss.

**Problem 16.2 — Object Save System**
- **Goal:** Serialize and restore nested object structures correctly.
- **Input/Output:** Object graph in, identical object graph out.
- **Constraints:** No manual re‑initialization after load.
- **Edge Cases:** Version changes documented, missing data.
- **Success Criteria:** Full fidelity restore with clear assumptions.

**Problem 16.3 — Rollback Mechanism**
- **Goal:** Implement safe saves with automatic rollback on failure.
- **Input/Output:** Save attempts in, verified stable state out.
- **Constraints:** Must restore last known good state.
- **Edge Cases:** Interrupted save, corrupted new data.
- **Success Criteria:** Reliable persistence under failure.

### Unit 17: GUI Programming and Event‑Driven Thinking

**Problem 17.1 — Form with Validation**
- **Goal:** Build a GUI form with real‑time validation and clear feedback.
- **Input/Output:** User actions in, validation state out.
- **Constraints:** No submission allowed until all fields are valid.
- **Edge Cases:** Rapid changes, invalid to valid transitions.
- **Success Criteria:** Responsive UI with correct validation logic.

**Problem 17.2 — Event‑Driven Timer**
- **Goal:** Implement a GUI timer with start/stop/reset and stable updates.
- **Input/Output:** User actions in, display updates out.
- **Constraints:** No duplicate timers or UI freezes.
- **Edge Cases:** Rapid start/stop, repeated resets.
- **Success Criteria:** Correct timekeeping and event handling.

**Problem 17.3 — Paint Lite**
- **Goal:** Create a drawing app with shapes, color selection, and persistence on repaint.
- **Input/Output:** Mouse actions in, consistent drawings out.
- **Constraints:** Render must survive window refresh.
- **Edge Cases:** Fast dragging, multiple shapes, overlapping drawings.
- **Success Criteria:** Smooth interaction and stable rendering.

### Unit 18: Integration, Projects, and Professional Practice

**Problem 18.1 — System Merge**
- **Goal:** Integrate at least three earlier components into one coherent app.
- **Input/Output:** Unified system in, stable UI + persistence out.
- **Constraints:** Resolve design conflicts without breaking features.
- **Edge Cases:** Data mismatch between components.
- **Success Criteria:** Clean integration with documented tradeoffs.

**Problem 18.2 — Design Critique**
- **Goal:** Identify five design flaws and fix two with justification.
- **Input/Output:** Issues list and refactored code out.
- **Constraints:** Fixes must not introduce regressions.
- **Edge Cases:** Hidden coupling, unexpected dependencies.
- **Success Criteria:** Improved design with preserved behavior.

**Problem 18.3 — Presentation Simulation**
- **Goal:** Deliver a written two‑minute technical presentation and demo script.
- **Input/Output:** Presentation text and demo flow out.
- **Constraints:** Include a tradeoff and a design decision.
- **Edge Cases:** Avoid vague claims; be concrete and testable.
- **Success Criteria:** Clear, professional communication of the system.

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
