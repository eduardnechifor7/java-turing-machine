# Turing Machine Simulator

A small Java simulator for a Turing Machine that recognizes the language `a^n b^n`.

The machine reads the input from the console, marks each `a` and its matching `b`, and accepts the word if all symbols are matched. The states and transitions are defined in `turing.txt`.

## Run

From the project directory:

```bash
javac -d out src/*.java
java -cp out Test
```

Examples:

```text
aabb   -> accepted
aaabbb -> accepted
aab    -> rejected
abab   -> rejected
```

## Technologies

- Java 8+
- Console application
- Text-based Turing Machine configuration

## Status

University project maintained for educational and portfolio purposes.
