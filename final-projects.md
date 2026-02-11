## 🎯 Final Projects (Choose One)
**Time: 25-30 hours**

### Project 1: **Student Information System (Full-Stack OOP)**

**Comprehensive university management platform**

**Modules**:
1. **Student Management**
    - Registration, profiles, photo upload
    - Academic records, transcripts
    - Attendance tracking

2. **Course Management**
    - Course catalog, prerequisites
    - Enrollment system (waitlists, conflicts)
    - Timetable generation (conflict resolution)

3. **Grading System**
    - Assignment submission (file upload)
    - Grade entry by faculty
    - GPA calculation, class ranking
    - Transcript generation (PDF export)

4. **Library Module**
    - Book inventory
    - Issue/return with due dates
    - Fine calculation
    - Search and recommendations

5. **Fee Management**
    - Fee structure by program
    - Payment processing
    - Receipt generation
    - Defaulter tracking

**Technical Requirements**:
- Swing GUI (tabbed interface, forms, tables)
- File persistence (serialization + CSV for exports)
- Exception handling (invalid data, conflicts)
- Collections framework (efficient lookups)
- Generics (reusable components)

**Deliverables**:
- Class diagram (show all relationships)
- Working application with data
- User manual
- Test cases document

---

### Project 2: **Personal Finance Manager**

**Track expenses, budgets, and financial goals**

**Features**:
1. **Transaction Management**
    - Add income/expense entries
    - Categories (food, transport, entertainment)
    - Payment methods tracking
    - Recurring transactions

2. **Budget Planning**
    - Set monthly budgets per category
    - Track spending vs budget
    - Alerts on overspending
    - Budget templates

3. **Visualization**
    - Pie charts (expense breakdown)
    - Line graphs (spending trends)
    - Bar charts (category comparison)
    - Custom date range analysis

4. **Reports**
    - Monthly/yearly summaries
    - Tax-relevant expense filtering
    - Export to CSV/PDF
    - Net worth tracking

5. **Goals & Savings**
    - Savings goals (vacation, gadget)
    - Progress tracking
    - Investment tracking
    - Future predictions

**Technical Highlights**:
- Custom chart drawing (Graphics2D)
- File I/O (transactions persist)
- Date/time handling
- Observer pattern (update charts on data change)
- Strategy pattern (different report formats)

---

### Project 3: **Inventory & Billing System (Retail POS)**

**Point-of-sale system for retail stores**

**Core Features**:
1. **Inventory Management**
    - Product catalog (name, price, stock, supplier)
    - Categories and brands
    - Stock alerts (low stock warnings)
    - Product search and filters
    - Barcode integration (simulate with codes)

2. **Billing**
    - Shopping cart interface
    - Discounts and coupons
    - Multiple payment methods
    - Bill generation (print preview)
    - Daily sales summary

3. **Customer Management**
    - Customer database
    - Purchase history
    - Loyalty points system
    - Targeted promotions

4. **Supplier Management**
    - Supplier database
    - Purchase orders
    - Payment tracking
    - Delivery management

5. **Analytics Dashboard**
    - Sales trends
    - Top-selling products
    - Revenue analysis
    - Profit margins

**Technical Features**:
- Multi-window GUI (inventory, billing, reports)
- Real-time stock updates
- Serialization for data persistence
- Exception handling (insufficient stock)
- Template method (different bill formats)

---

### Project 4: **Quiz & Examination Platform**

**Online quiz system with admin and student interfaces**

**Modules**:
1. **Question Bank**
    - Multiple question types (MCQ, true/false, short answer)
    - Subject and difficulty tagging
    - Import questions (CSV/JSON)
    - Rich text formatting (code snippets)

2. **Exam Creation**
    - Select questions from bank
    - Set time limits
    - Randomize questions/options
    - Negative marking rules
    - Schedule exams

3. **Exam Taking**
    - Countdown timer
    - Progress indicator
    - Mark for review
    - Auto-submit on timeout
    - Offline mode (save locally)

4. **Evaluation**
    - Auto-grading (MCQ)
    - Manual grading (subjective)
    - Partial marking
    - Answer key display
    - Score distribution

5. **Analytics**
    - Question-wise analysis
    - Difficulty assessment
    - Student performance trends
    - Comparative reports

**Technical Challenges**:
- Timer implementation (threads)
- State management (answered/unanswered)
- Polymorphism (different question types)
- Generics (generic question bank)
- File handling (save progress)

---

### Project 5: **Task & Project Management Tool**

**Team collaboration platform (like simplified Trello/Asana)**

**Features**:
1. **Project Management**
    - Create projects with descriptions
    - Project members and roles
    - Milestones and deadlines
    - Project templates

2. **Task Board**
    - Kanban-style columns (To Do, In Progress, Done)
    - Drag-and-drop tasks (simulate with buttons)
    - Task priority and labels
    - Subtasks hierarchy

3. **Task Details**
    - Title, description, assignee
    - Due dates and reminders
    - Attachments (file references)
    - Comments/discussion
    - Activity log

4. **Calendar View**
    - Monthly/weekly view
    - Task deadlines highlighted
    - Milestone markers
    - Drag to reschedule

5. **Collaboration**
    - User assignments
    - Notifications system
    - Activity feed
    - Export project reports

**Technical Implementation**:
- Complex GUI (multiple panels, custom components)
- Observer pattern (task updates notify GUI)
- Composite pattern (task hierarchies)
- Serialization (save projects)
- Collections (efficient task filtering)

---

### Project 6: **Hotel Reservation System**

**Complete hotel booking and management platform**

**Modules**:
1. **Room Management**
    - Room types (single, double, suite)
    - Amenities and pricing
    - Availability calendar
    - Room status (occupied, maintenance)

2. **Reservation System**
    - Search available rooms (dates, type)
    - Booking workflow
    - Pricing calculation (seasons, discounts)
    - Booking modifications and cancellations

3. **Guest Management**
    - Guest profiles
    - ID verification
    - Stay history
    - Loyalty programs

4. **Check-in/Check-out**
    - Room assignment
    - Key card generation (simulate)
    - Minibar/services charges
    - Bill generation

5. **Reporting**
    - Occupancy rates
    - Revenue analysis
    - Popular room types
    - Seasonal trends

**Advanced Features**:
- Waitlist management (overbooking)
- Dynamic pricing
- Group bookings
- Online payment integration (simulate)

---

### Project 7: **Recipe Manager & Meal Planner**

**Culinary assistant with nutrition tracking**

**Features**:
1. **Recipe Database**
    - Add recipes (ingredients, steps, images)
    - Categories and cuisines
    - Difficulty and time estimates
    - User ratings and reviews

2. **Ingredient Management**
    - Pantry inventory
    - Shopping list generation
    - Expiry tracking
    - Substitution suggestions

3. **Meal Planning**
    - Weekly meal planner (drag-drop recipes)
    - Dietary preferences (vegan, gluten-free)
    - Auto-balance nutrition
    - Family size scaling

4. **Nutrition Calculator**
    - Calorie counting
    - Macros breakdown (protein, carbs, fats)
    - Vitamin/mineral tracking
    - Health goals

5. **Social Features**
    - Share recipes
    - Import from URLs (parse recipe sites)
    - Recipe collections
    - Print-friendly format

**Technical Aspects**:
- GUI with image display
- File I/O (recipe import/export JSON)
- Collections (efficient recipe search)
- Composition (Recipe has Ingredients)
- Observer (update nutrition when scaling)

---

## Evaluation Rubric (For Final Project)

### Code Quality (30%)
- Class design and relationships
- Encapsulation and access control
- Method decomposition
- Naming conventions
- Comments and documentation

### OOP Principles (25%)
- Inheritance usage (appropriate, not over-used)
- Polymorphism demonstration
- Interface implementation
- Abstraction and generics
- Exception handling

### Functionality (25%)
- Feature completeness
- Bug-free operation
- Edge case handling
- User experience
- Performance

### GUI & UX (10%)
- Layout design
- User-friendly interface
- Input validation
- Error messages
- Visual appeal

### Documentation (10%)
- Class diagrams
- User manual
- README file
- Test cases
- Code comments

---
