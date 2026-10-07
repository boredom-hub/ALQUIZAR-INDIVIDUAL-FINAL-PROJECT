# Java Activities GUI

A Java Swing desktop app that puts all of my activities this term into one program. You register, log in, and then open any activity from a list of buttons. Each activity runs in its own window.

Second Final Project (Individual) - made with plain Java, object-oriented programming (OOP), and Swing.

## Features

- Register and Login screens with a choice screen between them
- After registering, the app goes back to the Register/Login choice
- Activity Frame that lists every activity from this term as a button
- Each button opens a GUI window that presents that activity
- Logout button that goes back to the start

## How it works

```
MainFrame (choose Register or Login)
   |-- Register --> saves username and password --> back to MainFrame
   |-- Login ------> checks the saved credentials --> ActivityFrame
                                                        |-- opens the activity you pick
```

## Activities included

| Button | Class | What it does |
|---|---|---|
| Aug 17 - Hello, Java! | `codechallenge1` | Prints "Hello, Java!" |
| Aug 17 - Name and Age | `codechallenge2` | Shows a name and an age stored in variables |
| Aug 17 - Data Types | `codechallenge3` | Shows an int, a double and a char |
| Aug 18 - Item Price + Shipping | `ShippingCost` | Adds the item price and the shipping cost |
| Aug 18 - Welcome Message | `WelcomeMessage` | Shows a message stored in a String |
| Aug 20 - Age Check | `AgeCheck` | Tells you if you are allowed (18 and above) |
| Aug 24 - Teyvat Login Portal | `TeyvatLoginPortal` | Create account, login and exit with Paimon messages |
| Aug 29 - Age Finder | `Agefinder` | Finds the lowest age from the ages you enter |
| Aug 29 - Number Lister | `NumberList` | Lists numbers, skips negatives, stops at zero |
| Aug 29 - Highest and Lowest | `HighandLowVAL` | Finds the highest and lowest value |
| Aug 29 - Multiplication Table | `MultiTable` | Fills a 20 x 20 array and shows every product |
| Aug 29 - Vending Draft | `vendingdraft1` | First version of the vending machine |
| Aug 29 - Teyvat Vending Machine | `genshinvendinglol` | Insert Mora, buy items with stock, take your change |
| Sep 8 - Grade Calculator | `AlquizarGradeCalculatorUI` | Base-15 grade calculator (uses `AlquizarGradeCalculator`) |
| Calculator | `Calculator` | Basic calculator with + - x / |

## Other files

| File | Purpose |
|---|---|
| `MainFrame.java` | Starting screen and the `main` method |
| `Register.java` | Register screen, stores the credentials |
| `Login.java` | Login screen, opens the Activity Frame |
| `ActivityFrame.java` | The list of activity buttons |
| `AlquizarGradeCalculator.java` | The class that holds the scores and does the grade computation |

## OOP used

- **Classes and objects** - every screen and activity is its own class, and each button creates an object with `new`
- **Constructors** - each window is built inside its class constructor
- **Encapsulation** - `AlquizarGradeCalculator` has getters and setters for the student's scores
- **Methods** - the logic of each activity is separated into methods like `calculate()`, `buy()` and `login()`
- **Arrays and loops** - used in the age finder, number lister, highest/lowest, multiplication table and vending machine

## Requirements

- Java Development Kit (JDK) 8 or newer

## How to run

1. Download or clone this repository
2. Open a terminal inside the folder that has the `.java` files
3. Compile everything:

   ```
   javac *.java
   ```

4. Start the program:

   ```
   java MainFrame
   ```

The Register/Login window should open. Register first, then log in to see the activities.

## Known limitations

- Only one account is stored at a time, and it is forgotten when the program closes
- The calculator only takes one digit per number

## Author

John Dominique Alquizar
