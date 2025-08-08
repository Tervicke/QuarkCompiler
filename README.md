# QuarkCompiler
This is a simple little fun project I am working on to learn more about parsers and the JVM. The idea is to make a tiny but usable language that compiles and emits JVM bytecode (.class file).

# How it works ?
The parser is generated using  [ANTLR](https://www.antlr.org/) . u can find the grammer in the [Quark.g4](/src/Quark.g4) file . The tree walking is done in java classes while using the [ASM](https://asm.ow2.io/) library to generate the jvm bytecode .

# Usage
Open the project in IntelliJ and add all the JARs from the [jars](jars/) folder to the classpath. Then run the code while passing the filepath to the `.quark` file . Here we use test.quark. 
<br>Remember IntelliJ runs the code from the root path so make sure the file path is correct . It will generate a  `filename.class` file in the root folder itself , run it with the JVM. `($ java filename)` 
<br> See the [test.quark](test.quark) file for examples
### <br> using makefile
add the std library as class path in your .bashrc or .zashrc 

For eg
```
export CLASSPATH=".:/home/tervicke/IdeaProjects/Quark/std:$CLASSPATH"
```

compile and create the build directory 
```
make all
```

run the file
```
make run input=examples/structs.quark
```
run the binary
```
cd examples
java structs 
```
## see more [examples](examples/) 
## Tests
The tests are stored in the [json file](tests/tests.json) , u can run the tests by running the [python file](tests/run_tests.py) file.  
```
python3 run_tests.py
```
## features 
---

## 🔹 1. Literals & Basic Types

- [x] Integer literals (`INT`)
- [x] Double literals (`DOUBLE`)
- [x] Boolean literals (`true`, `false`)
- [x] String literals (`"..."`)
- [x] Parenthesized expressions `(expr)`

---

## 🔹 2. Types & Variable Declarations

- [x] Basic types: `int`, `string`, `bool`, `double`
- [x] Variable declaration with type (e.g., `int x = 5`)
- [x] Variable declaration without type (type inference)
- [x] Variable reassignment (`x = expr`)
- [x] Typed function parameters
- [x] Optional return type for functions (`-> TYPE`)
- [x] Const or immutable variables (e.g., `const x = 10`)

---

## 🔹 3. Expressions

- [x] Arithmetic operators: `+`, `-`, `*`, `/`, `%`
- [x] Comparison operators: `<`, `>`, `<=`, `>=`
- [x] Equality operators: `==`, `!=`
- [x] Field access: `obj.field`
- [ ] Logical operators: `&&`, `||`, `!`
- [ ] Unary minus / plus (`-a`, `+a`)
- [ ] Ternary expressions (`cond ? a : b`)

---

## 🔹 4. Control Flow

- [x] If statements (`if (cond) { ... }`)
- [x] If-else blocks
- [x] While loops (`while (cond) { ... }`)
- [x] Nested blocks `{ ... }`
- [ ] For loops
- [ ] Break & continue statements
- [ ] Switch / match expression

---

## 🔹 5. Functions

- [x] Function definition (`fn name(args) { ... }`)
- [x] Function call (`foo(1, 2)`)
- [x] Return statement (`return expr`)
- [x] Optional return type (`-> int`)
- [x] Function call from module (`mod.func()`)
- [x] Recursive functions
- [ ] Lambdas or anonymous functions

---

## 🔹 6. Structs

- [x] Struct definition (`struct Name { ... }`)
- [x] Struct fields with types
- [x] Struct instantiation (`Point(1, 2)`)
- [x] Field access (`p.x`)
- [ ] Nested structs
- [ ] Struct methods

---

## 🔹 7. I/O and Built-ins

- [x] Print statement (`print(...)`)
- [ ] Input from user
- [ ] String formatting
- [ ] Basic standard library (e.g., `len(string)`, math functions)

---

## 🔹 8. Modules and Imports

- [x] Import statement (`import module`)
- [ ] Importing specific functions or structs
- [ ] Export keywords for public APIs

---
