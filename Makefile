BUILD_DIR := build
.PHONY: all run clean
all: clean compile

compile:
	@chmod +x compile.sh
	@./compile.sh
	@echo "Compiled and generated $(BUILD_DIR)/" 

clean:
	rm -rf $(BUILD_DIR)

run:
	java -cp "build:jars/*" Main $(input) -o $(output) 

