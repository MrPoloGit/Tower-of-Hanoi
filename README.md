# Tower of Hanoi

A recursive Java solution to the Tower of Hanoi puzzle. Given `n` disks and three pegs (numbered 1, 2, 3), it prints the sequence of moves needed to transfer all disks from the start peg to the target peg.

## Requirements

- **Java 11 or later** — download from [Adoptium](https://adoptium.net/) (works on macOS, Windows, Linux)
- **Maven 3.6+** — download from [maven.apache.org](https://maven.apache.org/download.cgi), or use your IDE's built-in Maven

## Building

```bash
mvn compile

# Package into a runnable JAR (output: out/tower-of-hanoi-1.0-SNAPSHOT.jar)
mvn package
```

## Running

```bash
java -jar out/tower-of-hanoi-1.0-SNAPSHOT.jar

# Or via Maven
mvn exec:java -Dexec.mainClass=Main
```

The default call in `main` solves for 3 disks, moving from peg 1 to peg 3:

```
Move disk 1 to 3
Move disk 1 to 2
Move disk 3 to 2
Move disk 1 to 3
Move disk 2 to 1
Move disk 2 to 3
Move disk 1 to 3
```

To change the number of disks or pegs, edit the `Solve(n, start, target)` call in `main`.

## How It Works

```
Solve(n, start, target):
  if n == 1: move disk from start to target  <- base case
  else:
    Solve(n-1, start, helper)   <- move top n-1 disks out of the way
    Solve(1,   start, target)   <- move the largest disk to target
    Solve(n-1, helper, target)  <- move the n-1 disks on top of it
```

The helper peg is found with `6 - start - target` (works because pegs are numbered 1, 2, 3 and 1+2+3=6).

The minimum number of moves for `n` disks is **$2^n$ − 1** (7 moves for 3 disks, 15 for 4, etc.).
