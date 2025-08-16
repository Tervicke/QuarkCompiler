import subprocess
import json
import os
import sys
import glob

def run_test(test):
    input_file = test["input"]
    name = test["name"]
    print(f"Running test: {name}")

    compile_proc = subprocess.run(
        ["java", "-jar", "../dist/Quark.jar", input_file],
        capture_output=True,
        text=True
    )

    # Check for error test
    if "error_file" in test:
        with open(test['error_file']) as f:
            error_expected = f.read().strip()
        stderr = compile_proc.stderr.strip()
        if error_expected in stderr:
            print("[OK] Error matched")
            return True
        else:
            print(f"[FAIL] Error mismatch\nExpected: {error_expected}\nGot: {stderr}")
            return False

    # Step 2: If no error expected, run the output .class file
    expected_output_file = test["expected_output_file"]
    with open(expected_output_file, "r") as f:
        expected_output = f.read().strip()

    output_class_name = test["input"].split('.')[0]

    run_proc = subprocess.run(
        ["java", output_class_name],
        capture_output=True,
        text=True
    )

    actual_output = run_proc.stdout.strip()

    if expected_output == actual_output:
        print("[OK] Output matched")
        return True
    else:
        print(f"[FAIL] Output mismatch\nExpected:\n{expected_output}\nGot:\n{actual_output}")
        return False

def main():
    with open("tests.json") as f:
        tests = json.load(f)

    passed = 0
    for test in tests:
        if run_test(test):
            passed += 1

    print(f"\nPassed {passed}/{len(tests)} tests")

    # --- Cleanup: remove all .class files ---
    for class_file in glob.glob("*.class"):
        os.remove(class_file)
    print("Cleaned up generated .class files")

if __name__ == "__main__":
    main()