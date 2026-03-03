#!/usr/bin/env bash
set -euo pipefail

# Generate 50 random marks (0-100) and feed them to Marks
inputs=$(
  for _ in $(seq 1 50); do
    echo $((RANDOM % 101))
  done
)

echo "Inputs:" >&2
echo "$inputs" >&2

# Compile if needed
if [ ! -f Marks.class ] || [ Marks.java -nt Marks.class ]; then
  javac Marks.java
fi

# Run program with generated inputs
printf "%s\n" "$inputs" | java Marks
