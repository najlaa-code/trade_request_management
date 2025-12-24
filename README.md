# trade_request_management
Trade tariff management system (LinkedList-based) that loads tariff policies from two text files and provides an interactive menu to search for a specific tariff and process trade requests.

# Trade Request Management System

A Java-based linked list application for managing international trade tariffs and evaluating trade requests between countries.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Input File Formats](#input-file-formats)
- [Trade Evaluation Logic](#trade-evaluation-logic)
- [Authors](#authors)

## 🌍 Overview

This system manages tariff policies between countries and evaluates trade requests based on proposed tariff rates. It uses custom linked list data structures to store and search tariff information efficiently.

## ✨ Features

### 1. **Tariff Management**
- Load tariff policies from multiple text files
- Store tariffs in custom linked list structures
- Each tariff includes:
  - Origin country
  - Destination country
  - Product category
  - Tariff percentage

### 2. **Interactive Menu System**
The application provides four main options:

#### 🔍 Search for Tariffs
- Search by destination country, origin country, and category
- Displays matching tariff information
- Shows number of iterations required to find the tariff

#### 📊 Process Trade Requests
- Reads trade requests from file
- Evaluates each request against existing tariff policies
- Provides acceptance/rejection decisions with detailed feedback

#### 🧪 Testing Module
Test various linked list operations:
- Insert at specific index
- Delete from specific index
- Add to start of list
- Delete from start of list
- Replace tariff at index
- Test equality between lists
- Test copy constructor

#### 🚪 Exit Program

### 3. **Smart Trade Evaluation**
The system evaluates trade requests using three-tier logic:

✅ **Accepted**
- Proposed tariff ≥ minimum required tariff
- Trade proceeds without additional charges

⚠️ **Conditionally Accepted**
- Proposed tariff is within 20% of minimum requirement
- Trade proceeds with a surcharge applied
- Surcharge calculation: `Trade Value × ((Min Tariff - Proposed Tariff) / 100)`

❌ **Rejected**
- Proposed tariff is more than 20% below minimum
- Trade cannot proceed

## 📁 Project Structure
```
part2_linkedlists/
├── TradeManagerDriver.java    # Main driver with interactive menu
├── TariffList.java            # Custom linked list implementation
├── Tariffs.java               # Tariff object definition
├── TradeRequest.java          # Trade request object
└── TariffPolicy.java          # Interface for trade evaluation
```

### Class Descriptions

**TradeManagerDriver.java**
- Entry point of the application
- Handles user interaction and menu navigation
- Manages file I/O operations
- Processes and displays trade requests

**TariffList.java**
- Custom linked list implementation for tariff storage
- Inner class `TariffNode` for list nodes
- Methods: insert, delete, search, replace, equality checking
- Implements `TariffPolicy` interface

**Tariffs.java**
- Represents a single tariff policy
- Contains country, category, and percentage information
- Includes clone, equals, and toString methods

**TradeRequest.java**
- Represents a trade request from a country
- Contains request ID, origin, destination, category, trade value, and proposed tariff

**TariffPolicy.java**
- Interface defining trade evaluation contract
- Method: `evaluateTrade(double proposedTariff, double minimumTariff)`

## 🛠️ Requirements

- **Java Version:** Java 8 or higher
- **Input Files:**
  - `TariffsList1.txt` - First tariff policy list
  - `TariffsList2.txt` - Second tariff policy list
  - `TradeRequests.txt` - Trade requests to evaluate

## 💾 Installation

1. **Clone or download the repository**
```bash
git clone <your-repository-url>
cd part2_linkedlists
```

2. **Ensure input files are in the correct location**
Place the three required `.txt` files in the same directory as the Java files.

3. **Compile the program**
```bash
javac part2_linkedlists/*.java
```

## 🚀 Usage

### Running the Program
```bash
java part2_linkedlists.TradeManagerDriver
```

### Example Interaction
```
Reading list 1 ... (origin -> destination)
Added Tariff: USA -> China
Added Tariff: China -> USA
...

----- Main Menu -----
What would you like to do ?
  1. Search for a tariff.
  2. Display trade requests.
  3. Test the program.
  4. Exit the program.
Enter your choice here: 1

Enter the destination country to search for tariffs: China
Enter the origin country to search for tariffs: USA
Enter the category to search for tariffs: Electronics

Iterations: 5
Tariff(s) found: 
 Destination Country: China
 Origin Country: USA
 Category: Electronics
 Tariff percentage: 15
```

## 📄 Input File Formats

### Tariff Files (TariffsList1.txt, TariffsList2.txt)
Format: `destination origin category percentage`

Example:
```
China USA Electronics 15
Germany France Automobile 10
India UK Agriculture 8
```

### Trade Requests File (TradeRequests.txt)
Format: `requestID origin destination category tradeValue proposedTariff`

Example:
```
REQ001 USA China Electronics 50000.0 15.0
REQ002 France Germany Automobile 75000.0 8.0
REQ003 UK India Agriculture 30000.0 5.0
```

## 📊 Trade Evaluation Logic

### Decision Matrix

| Proposed Tariff | Condition | Result | Additional Action |
|----------------|-----------|--------|-------------------|
| ≥ Min Tariff | Meets requirement | ✅ Accepted | None |
| ≥ 80% of Min | Within 20% tolerance | ⚠️ Conditionally Accepted | Surcharge applied |
| < 80% of Min | Below tolerance | ❌ Rejected | Trade blocked |

### Example Scenarios

**Scenario 1: Accepted**
```
Minimum Tariff: 10%
Proposed Tariff: 12%
Result: REQ001 - Accepted.
Proposed tariff 12.0% meets or exceeds minimum requirement 10.0%
```

**Scenario 2: Conditionally Accepted**
```
Minimum Tariff: 10%
Proposed Tariff: 8.5%
Trade Value: $50,000
Surcharge: $50,000 × (10 - 8.5) / 100 = $750
Result: REQ002 - Conditionally Accepted.
Proposed tariff 8.5% is within 20% of required minimum 10.0%.
A surcharge of $750.00 is applied.
```

**Scenario 3: Rejected**
```
Minimum Tariff: 10%
Proposed Tariff: 5%
Result: REQ003 - Rejected.
Proposed tariff 5.0% is more than 20% below required minimum 10.0%.
```
