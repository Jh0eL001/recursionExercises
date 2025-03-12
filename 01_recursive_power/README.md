# Recursive Power

This Java program computes the power of a number `a` raised to an exponent `b` using recursion. The method works by multiplying the base `a` by itself `b` times (for positive values of `b`). The program includes error handling to ensure the exponent is positive and handles invalid user input.

---

## Program Explanation

### Base Case for Exponent 1:

When \( b = 1 \), the method returns the base \( a \) because any number raised to the power of 1 is the number itself.  
This is the simplest case that stops the recursion.

\[
a^1 = a
\]

### Recursive Case:

For values of \( b > 1 \), the function recursively calls `recursivePow(a, b - 1)` and multiplies the result by `a`.  
This gradually reduces \( b \) by 1 with each recursive call, eventually reaching the base case.

The recursion formula is:

\[
a^b = a \times recursivePow(a, b - 1)
\]

#### Example:

For \( 3^4 \), the function works as:

\[
3 \times recursivePow(3, 3)
\]

Then it recursively evaluates:

\[
3 \times (3 \times recursivePow(3, 2))
\]

And so on, until \( b = 1 \).

---

## Input Handling and Loop

The program prompts the user to enter the base `a` (the number to be raised to a power) and the exponent `b` (the power).  
A `while` loop ensures that the exponent `b` is positive. If the user enters a negative exponent, the program will ask for the input again until a valid (positive) number is provided.  
It also handles cases where the user enters invalid data (non-integer values) using the `hasNextInt()` method from the `Scanner` class.

---

## Example Walkthrough

Let’s walk through an example: `recursivePow(2, 3)`.

### First call: `recursivePow(2, 3)`:
Since \( b \neq 1 \), it calls `recursivePow(2, 2)` and multiplies the result by `2`.

### Second call: `recursivePow(2, 2)`:
Since \( b \neq 1 \), it calls `recursivePow(2, 1)` and multiplies the result by `2`.

### Third call: `recursivePow(2, 1)`:
Since \( b = 1 \), the function returns `2`.

Now the recursion starts unwinding:

\[
recursivePow(2, 2) \rightarrow 2 \times 2 = 4
\]

\[
recursivePow(2, 3) \rightarrow 2 \times 4 = 8
\]

Thus, \( 2^3 = 8 \).

---

