# QuarkCompiler
This is a simple little fun project I am working on to learn more about parsers and the JVM. The idea is to make a tiny but usable language that compiles and emits JVM bytecode (.class file).

# How it works ?
The parser is generated using  [ANTLR](https://www.antlr.org/) . u can find the grammer in the [Quark.g4](/src/Quark.g4) file . The tree walking is done in java classes while using the [ASM](https://asm.ow2.io/) library to generate the jvm bytecode .

# Usage
Open the project in IntelliJ and add all the JARs from the [jars](jars/) folder to the classpath. Then run the code while passing the filepath to the `.quark` file . Here we use test.quark. 
<br>Remember IntelliJ runs the code from the root path so make sure the file path is correct . It will generate a  `filename.class` file in the root folder itself , run it with the JVM. `($ java filename)` 
<br> See the [test.quark](test.quark) file for examples
### <br> using makefile
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
java -cp examples structs 
```
## see more [examples](examples/) 