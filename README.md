# Mini Compiler using ANTLR with Custom Instruction Support

This project is a mini compiler implemented in Java using ANTLR (Another Tool for Language Recognition). It showcases all the major phases of compilation, including lexical analysis, syntax analysis, semantic analysis, intermediate code generation, and simulated execution.

The compiler supports a simplified custom language and includes a custom instruction named `buttercup(a, min, max)`, which demonstrates how new high-level constructs can be added to a language and processed across all compilation stages.

## Table of Contents

- Overview
- Motivation for the Custom Instruction
- Instruction Definition: `buttercup`
- Input Format
- Sample Output
- Screenshots
- File Architecture
- Technologies Used
- Installation and Setup
- How to Run
- Frequently Asked Questions
- License

---

## Overview

This compiler has been developed to illustrate the design and implementation of a language from scratch. By integrating ANTLR, the project handles parsing and grammar enforcement in a scalable and efficient manner. The phases of the compiler have been modularized for clarity and future extensibility.

---

## Motivation for the Custom Instruction

Introducing the custom instruction `buttercup` serves the following purposes:

- To demonstrate how a new language construct can be designed and implemented across all compiler phases
- To explore conditional evaluation in a more readable and compact form
- To provide an educational example of compiler extensibility and grammar modification

---

## Instruction: `buttercup(a, min, max)`

### Purpose

The `buttercup` instruction checks whether the value of a variable `a` lies within the inclusive range `[min, max]`.

### Semantics

This instruction is logically equivalent to:

```java
if (a >= min && a <= max) {
    // condition is satisfied
} else {
    // condition is not satisfied
}
```

### What's Special?

Think of `buttercup` as a *friendly bouncer* guarding the boundary of your values — it won’t let a number sneak past the specified range. If a variable tries to go below `min` or above `max`, `buttercup` politely tells it to back off.

It adds a readable, expressive way to enforce range checks, especially in educational code or domain-specific languages.

### Example Usage

```text
int age = 19;
buttercup(age, 18, 60);
```

This checks whether `age` is between 18 and 60.

---

## Input Format

The compiler accepts programs written in a custom simplified language. The input file should contain valid variable declarations and instruction calls.

Example `input.txt`:

```text
int a;
float b;
a = 12;
buttercup(a,1,5)
```

### Supported Syntax

- Variable declarations with optional initialization
- Custom instruction: `buttercup(a, min, max)`

All statements should be terminated properly according to the grammar rules defined in `MyLanguage.g4`.

---

## Console Output after Compilation 

### 1. Lexical Analysis
![Screenshot 2025-04-09 011053](https://github.com/user-attachments/assets/112f5aa2-88bf-442d-becc-674ad33bdd30)

### 2. Syntax Analysis
![Screenshot 2025-04-09 011104](https://github.com/user-attachments/assets/ebd1f033-3031-4765-a6db-e5f7bedbc450)

### 3. Semantic Analysis
![Screenshot 2025-04-09 011116](https://github.com/user-attachments/assets/3d5321ff-b164-4aef-a3c6-35244386b808)

### 4. Intermediate Code Generation
![Screenshot 2025-04-09 011128](https://github.com/user-attachments/assets/5609ca20-dffd-435f-a1ff-8ebefa3fbbbc)

### 5. Assembly Code
![Screenshot 2025-04-09 011140](https://github.com/user-attachments/assets/60577f03-385e-4a44-9647-a3ecb74d1da8)

### 6. Executed Result
![Screenshot 2025-04-09 011147](https://github.com/user-attachments/assets/f871d432-8440-41b1-91de-1b8450688cc1)

---

## File Architecture

| File/Folder                          | Description                                                                 |
|--------------------------------------|-----------------------------------------------------------------------------|
| `assets/`                            | Contains output screenshots used in the documentation                      |
| `AssemblyCodeGenerator.java`         | Handles the generation of assembly-like code from intermediate representation |
| `EvalVisitor.java`                   | Responsible for evaluating and executing the parsed and translated code    |
| `ICGenerator_ICG.java`               | Generates intermediate code during the compilation process                 |
| `Main.java`                          | Entry point of the compiler; coordinates various compiler phases           |
| `ParseTreeGenerator.java`           | Generates and visualizes the parse tree from the source input              |
| `SemanticAnalyser.java`             | Performs semantic analysis and generates relevant symbol table entries     |
| `SymbolTable_SemanticAnalyser.java` | Represents the structure and logic for managing the symbol table           |
| `Tokenization.java`                 | Implements lexical analysis and token generation                           |
| `Expr.g4`                            | ANTLR grammar file defining the syntax rules of the custom language        |
| `ExprBaseVisitor.java`              | ANTLR-generated base visitor class for traversing the parse tree           |
| `ExprBaseListener.java`             | ANTLR-generated listener class for walking the parse tree                  |
| `ExprLexer.java`                    | ANTLR-generated lexer responsible for tokenizing the input                 |
| `ExprParser.java`                   | ANTLR-generated parser for creating the parse tree from tokens             |
| `ExprVisitor.java`                  | ANTLR-generated visitor interface for custom parse tree traversal          |

---

## Technologies Used

- Java (JDK 21)
- ANTLR 4
- Eclipse 
- Command-line tools for ANTLR and Java execution

---

## Installation and Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/mini-compiler.git
   cd mini-compiler
   ```

2. Install ANTLR 4. Refer to official installation instructions:  
   https://github.com/antlr/antlr4/blob/master/doc/getting-started.md

3. Generate lexer and parser from grammar:

   ```bash
   antlr4 grammar/MyLanguage.g4 -o src/parser
   javac src/parser/*.java
   ```

4. Compile the compiler:

   ```bash
   javac -d bin src/**/*.java
   ```

---

## How to Run

1. Write your input program in `input.txt`.

2. Execute the compiler:

   ```bash
   java -cp bin compiler.Main input.txt
   ```

3. The output will be printed to the console or written to `output.txt`.

---

## Frequently Asked Questions

### Why use ANTLR?

ANTLR allows you to define grammars in a declarative way and automatically generates lexers and parsers. This simplifies the compiler construction process and supports modular, reusable code.

### What is the purpose of the `buttercup` instruction?

The `buttercup` instruction demonstrates how high-level custom instructions can be integrated into a compiler. It serves as a pedagogical tool to showcase grammar extension, semantic rule addition, and execution logic in one coherent example.

### Can I add more custom instructions?

Yes. You can extend the ANTLR grammar file and implement the corresponding semantic checks, intermediate representation, and execution behavior in the compiler.

### Does the compiler perform optimizations?

Basic or optional optimizations can be added. This version focuses primarily on demonstrating the compilation pipeline clearly.

---

## License

This project is open for academic and educational use.

```
