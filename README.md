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
