# Java Terminal Chat

A simple multi-client terminal chat app written in Java.

## Requirements

- Java JDK 8+

## Files

```
├── Server.java
├── Client.java
└── Main.java
```

## Usage

**1. Compile**
```bash
javac *.java
```

**2. Start the server** (Terminal 1)
```bash
java Main server
```

**3. Join as a client** (Terminal 2, 3, ...)
```bash
java Main client Alice
java Main client Bob
```

## Example

```
Terminal 1 (server):
  Server started on port 9999...

Terminal 2 (Alice):
  Alice: hey everyone!

Terminal 3 (Bob):
  Alice: hey everyone!
  Bob: hi Alice!
```