# QuarkCompiler
This is a simple little fun project I am working on to learn more about parsers and the JVM. The idea is to make a tiny but usable language that compiles and emits JVM bytecode (.class file).

# How it works ?
The parser is generated using  [ANTLR](https://www.antlr.org/) . u can find the grammer in the [Quark.g4](/src/Quark.g4) file . The tree walking is done in java classes while using the [ASM](https://asm.ow2.io/) library to generate the jvm bytecode .

# Usage
Open the project in IntelliJ and add all the JARs from the [jars](jars/) folder to the classpath. Then run the code while passing the filepath to the `.quark` file . Here we use test.quark. 
<br>Remember IntelliJ runs the code from the root path so make sure the file path is correct . It will generate a  `filename.class` file in the root folder itself , run it with the JVM. `($ java filename)` 
<br> See the [test.quark](test.quark) file for examples

<br> Some examples

```
// Variable declarations
int a = 10
int b = 3
int c = a + b * 2 - (a % b) / 1

string greeting = "Hello"
string name = "World"

// Boolean logic using relational and equality expressions
bool cond1 = a > b
bool cond2 = a == 10
bool cond3 = a != b

// Print statements
print(a)
print(c)
print(greeting)
print(cond1)

// Control flow using if
if (a > b) {
    print("a is greater than b")
    int result = (a + b) * (a - b) % 2
    print(result)
}

if (cond2 == true) {
    print("Condition is true")
}
```