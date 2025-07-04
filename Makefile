BUILD_DIR := build
.PHONY: all run clean antlr
all: clean compile

compile:
	@chmod +x compile.sh
	@./compile.sh
	@echo "Compiled and generated $(BUILD_DIR)/" 

clean:
	rm -rf $(BUILD_DIR)

run:
	@java -cp "build:jars/*" Main $(input) -o $(output) 

antlr:
	@java -cp "/usr/local/lib/antlr-4.11.1-complete.jar" org.antlr.v4.Tool src/Quark.g4 -visitor 

grun:
	@java -cp "build:jars/antlr-4.11.1-complete.jar" org.antlr.v4.gui.TestRig Quark prog -gui
