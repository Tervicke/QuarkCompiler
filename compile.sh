#!/bin/bash

mkdir -p build

# Create colon-separated classpath from all jars
CLASSPATH=$(echo jars/*.jar | tr ' ' ':')

# Compile all Java files in src/ into build/
javac -cp "$CLASSPATH" -d build $(find src -name "*.java")

