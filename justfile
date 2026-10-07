default:
    @just --list

# Build all targets
build:
    bazel build //...

# Run the toy interpreter
run:
    bazel run //src/main/java/com/toyclj:app

# Run all tests
test:
    bazel test //...

# Clean Bazel outputs
clean:
    bazel clean

# Format Java sources (requires google-java-format)
fmt:
    find src -name "*.java" -exec google-java-format -i {} +
