# 🔐 Passcode Traversing Algorithm

A custom algorithm designed to generate the minimum number (using digits 1–9 without repetition) that conforms to a given pattern of `'I'` (Increasing) and `'D'` (Decreasing) characters.

This algorithm was developed **independently** as a novel solution to an Amazon bar-raiser interview question.

---

## 🧠 Problem Statement

Given a string `S` composed of only `'I'` and `'D'`:

- `'I'` indicates the next number is **greater** than the previous  
- `'D'` indicates the next number is **smaller** than the previous  

You must return the **smallest lexicographical number** using digits `1–9` without repetition that fits this pattern.

---

## 🚀 Core Idea

This method introduces the **Passcode Traversing Method** — a **link-style analysis** where the algorithm examines transitions between each character (like `'I-I'`, `'D-I'`, etc.) and reacts accordingly.

It simulates a "passcode graph", breaking down each step into **pairwise links**, like a state machine or LinkedList traversal.

---

## 🔄 Transitions Handled

Each passcode transition (pair of previous and current character) maps to a unique control structure:

| Transition | Behavior |
|------------|----------|
| `0-I`      | Starts with `'I'` → emit `1` and set key |
| `0-D`      | Starts with `'D'` → delay output, count descending steps |
| `I-I`      | Continue increasing → store until reversal |
| `I-D`      | Transition from rise to fall → resolve pending `'I'` values |
| `D-D`      | Continue decreasing → stack more descending |
| `D-I`      | Resolve full descending chain in reverse |
| `I-0` / `D-0` | Final resolution step depending on last char |

---

## ⚙️ Variables Used

- `key`: Current smallest unused digit  
- `ele_kept`: Counter for digits kept during descending  
- `inc`: Number of pending increasing values  
- `element`: Current number to be processed  

---

## 📈 Time and Space Complexity

- **Time Complexity:** `O(n)` — each character is processed once  
- **Space Complexity:** `O(n)` for output string (or `O(1)` with in-place optimizations)

---

## 📌 Example

```java
Input:  "DIDI"
Output: "21435"

Input:  "IIDDD"
Output: "126543"
