# Simple Terminal Assistant V1.0

A simple Java terminal assistant inspired by J.A.R.V.I.S. from Iron Man.

I made this project to learn Java basics like loops, user input, methods, arrays, file handling, and error handling. It is a beginner project, but it has a lot of small features that make it feel like a real terminal assistant.

## Features

- Starts with a J.A.R.V.I.S. style banner
- Saves your name in `name.txt`
- Welcomes you back by name
- Runs in a command loop
- Shows a help menu
- Tells random jokes
- Shows the current time
- Gives random motivational quotes
- Gives random coding missions
- Has a simple calculator
- Checks for divide by zero in the calculator
- Has a fake scan command for fun
- Keeps command history for the current session
- Saves command history to `history.txt` when you exit
- Can clear the terminal
- Has typing animation
- Lets you turn typing animation on or off
- Lets you change typing animation speed
- Lets you change the saved user name
- Lets you clear saved command history
- Has terminal color themes
- Resets terminal colors when the program exits
- Uses basic `try/catch` error handling

## Commands

| Command | What it does |
| --- | --- |
| `help` | Shows all commands |
| `hello` | Greets the user |
| `time` | Shows the current time |
| `joke` | Tells a random joke |
| `motivate` | Shows a random motivational quote |
| `mission` | Gives a random coding mission |
| `calc` | Opens a basic calculator |
| `scan` | Runs a fake bug scan for fun |
| `history` | Shows commands used in the current session |
| `changeuser` | Changes the saved user name |
| `settings` | Opens the settings menu |
| `clear` | Clears the terminal |
| `exit` | Saves history and exits the program |

## Settings

The settings menu lets you:

- Toggle typing animation
- Change typing animation speed
- Change user name
- Change theme
- Clear command history
- Go back to the main command menu

## Themes

The app includes these terminal themes:

- None/default
- Red
- Green
- Blue
- Cyberpunk

## How to Use the Release Package

The release package is a zip folder with the Java project files inside it.

1. Download the latest release package.
2. Unzip the folder.
3. Open a terminal in the unzipped project folder.
4. Make sure Java is installed.
5. Compile the program:

```bash
javac Main.java
```

6. Run the program:

```bash
java Main
```

When the assistant starts, type a command like:

```text
help
```

That will show the full command list inside the program.

## Files Used

- `Main.java` is the main program
- `name.txt` stores the saved user name
- `history.txt` stores command history after exiting
- `mission.txt` is included for mission-related ideas/data

## What I Learned

- Java loops
- User input with `Scanner`
- Conditions and switch statements
- Methods
- Arrays
- File handling
- Error handling with `try/catch`
- Printing slowly with animation
- Terminal colors and ANSI codes
- Keeping code organized as the project grows
- Debugging small problems

## Future Ideas

- Add more commands
- Add more themes
- Save settings between runs
- Improve the calculator
- Add real file scanning
- Make command history load from the old history file

## AI Usage

I used AI for help understanding some ideas and for the terminal color theme code because that part was more confusing. The rest of the project was built as a learning project while practicing Java.
