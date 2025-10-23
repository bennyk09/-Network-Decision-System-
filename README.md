# Network Decision System (Three-Case Algorithm)

**Based on Matrix Summation**  
**Presented by:** Joseph Kothapalli  
**Department of Computer Science and Engineering**  
**Date:** 11 October 2025  

---

## Overview

The **Network Decision System** is a lightweight analytical framework designed to evaluate real-time network stability using a **Three-Case Algorithm based on Matrix Summation**. It converts signal readings into a structured 3×3 matrix, computes directional summations (rows, columns, diagonals), and produces a global decision metric `f(A)`.

Unlike conventional AI or machine learning models, this deterministic approach is **transparent, interpretable, and efficient**, suitable for real-time applications.

---

## Features

- Evaluates Wi-Fi signal strength, IoT device reliability, industrial process monitoring, and more.  
- Uses directional summation to compute overall network stability.  
- Provides three decision levels:  
  - **Strong (Good)** – stable connection  
  - **Moderate** – average connection  
  - **Weak** – poor connection  
- Fully implemented in **Java** with ANSI color-coded output for terminal readability.  
- Can be adapted for embedded systems and other sensor-based applications.

---

## How It Works

1. **Collect Input Signals:** Reads consecutive network signal strengths.  
2. **Matrix Mapping:** Maps signal readings into a 3×3 matrix.  
3. **Directional Summation:** Computes sums across rows, columns, and diagonals.  
4. **Global Stability Function:** Calculates `f(A)` = average of all directional sums.  
5. **Decision Mapping:** Compares `f(A)` with thresholds to classify network state.

Example Decision Ranges:

| f(A) Value | Network State       |
|------------|-------------------|
| ≥ 1.5      | Good connection    |
| -1.5 < f(A) < 1.5 | Moderate connection |
| ≤ -1.5     | Weak connection    |

---

## Installation 

1. Clone this repository:  
```bash
git clone https://github.com/<your-username>/NetworkDecisionSystem.git

