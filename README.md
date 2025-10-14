# 🌐 Network Decision System using the Three-Case Algorithm based on Matrix Summation

## 📘 Overview
The **Network Decision System** is a mathematical and computational model designed to analyze and classify real-time network stability.  
It is powered by the **Three-Case Algorithm based on Matrix Summation**, a universal mathematical decision-making framework developed by **Benny (2025)**.

This system captures Wi-Fi signal strength from a local interface, processes it through a structured matrix-based algorithm, and determines whether the connection is **Strong**, **Moderate**, or **Weak** — providing a lightweight, reliable, and adaptive stability assessment.

---

## 🎯 Purpose
The purpose of this project is to demonstrate how **mathematical computation** can be practically integrated with **programming** to evaluate real-world network stability.  
It transforms raw signal readings into a **quantified stability index** through a matrix summation and averaging process.

---

## 🧠 The Core Algorithm — Three-Case Algorithm based on Matrix Summation
This algorithm was originally designed as a **neutral, standard mathematical model** for decision-making based on directional matrix summations.

### Formula
\[
F(A) = \frac{1}{8}\left(\sum_{i=1}^{3} \alpha_i + \sum_{j=1}^{3} \beta_j + \gamma + \delta \right)
\]

Where:
- \( \alpha_i \): Row summations  
- \( \beta_j \): Column summations  
- \( \gamma \): Main diagonal sum  
- \( \delta \): Opposite diagonal sum  

The final average \( F(A) \) determines the system condition:
- **Strong:** \( F(A) \ge 1.5 \)  
- **Moderate:** \( -1.5 < F(A) < 1.5 \)  
- **Weak:** \( F(A) \le -1.5 \)

---

## ⚙️ How It Works
1. Captures real-time Wi-Fi signal strength using:
   ```bash
   netsh wlan show interfaces
