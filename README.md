# Coin Game (Heads or Tails)

A small Java project built to practice core object-oriented programming concepts: packages, classes, objects, inheritance, abstract classes, interfaces, and encapsulation. The project includes both a **console version** and a **JavaFX graphical version** of the same game.

## Overview

Coin Game is a simple heads-or-tails game where a human player competes against an AI bot over several rounds. Each round, both players pick a side, a coin is flipped, and points are awarded to whoever guessed correctly. After all rounds are played, a final winner is announced.

## Project Structure

```
src/
├── model/
│   └── Coin.java              # The coin object (flips randomly between HEADS/TAILS)
├── player/
│   ├── Participant.java        # Abstract base class (name, score, addPoint)
│   ├── HumanPlayer.java        # Concrete subclass, controlled by user input
│   ├── AIPlayer.java           # Concrete subclass, chooses randomly
│   └── Notifiable.java         # Interface implemented by AIPlayer
├── game/
│   └── CoinGame.java           # Game rules: plays rounds, tracks rounds, final score
├── principal/
│   └── Main.java               # Console entry point
└── view/
    └── CoinGameView.java       # JavaFX entry point (graphical version)
```

## Concepts Demonstrated

- **Packages** — code organized by responsibility (`model`, `player`, `game`, `view`)
- **Classes & objects** — clear separation between blueprints (classes) and instances (objects)
- **Abstract classes** — `Participant` cannot be instantiated directly; only its subclasses can
- **Inheritance** (`extends`) — `HumanPlayer` and `AIPlayer` inherit shared behavior from `Participant`
- **Interfaces** (`implements`) — `Notifiable` defines a contract (`announceResult()`) implemented only by `AIPlayer`
- **Encapsulation** — private fields with public getters, controlled mutators (`addPoint()`)
- **`equals()` / `hashCode()`** — two `Participant` objects are considered equal if they share the same name and score
- **Randomness** (`Math.random()`) — used both for the coin flip and the AI's choice
- **JavaFX basics** — `Stage`, `Scene`, `VBox`/`HBox` layouts, event handling with lambdas

## How to Run — Console Version

1. Open the project in IntelliJ IDEA (or any Java IDE)
2. Run `principal/Main.java`
3. Follow the prompts in the console to play

## How to Run — JavaFX Version

JavaFX is not bundled with the JDK (since Java 11), so it must be added manually:

1. Download the JavaFX SDK from [openjfx.io](https://openjfx.io) and unzip it somewhere on your machine
2. In IntelliJ: **File → Project Structure → Libraries** → add the `lib` folder from the JavaFX SDK
3. Create a run configuration for `view/CoinGameView.java`
4. In that configuration, set the **VM options** to:
   ```
   --module-path "<path-to-javafx-sdk>/lib" --add-modules javafx.controls
   ```
5. Run the configuration — a window will open where you can click **HEADS** or **TAILS** to play

## Possible Improvements

- Extract shared game logic between the console and JavaFX versions to avoid duplication
- Add a `MonitoringZone`-style history of past games (serialization)
- Add unit tests for `Coin`, `Participant`, and `CoinGame`

## Author

Built by Sounyâ as a hands-on exercise to understand Java fundamentals (packages, classes, objects, and OOP principles) through a practical mini-project.
