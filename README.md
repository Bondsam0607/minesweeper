# scrabble

## How to run?
1. modify the `board.txt` file in the resourcefolder
2. cd `src` directory, run `make` to generate `.class` files
3. run `java edu.duke.cs201.core.drawBoard`

## Format of `board.txt`
1. use '*' to represent unselected blocks
2. use 'F' to represent Flags
3. use 'X' to represent bombs
4. use numbers to represent selected blocks
	1. use 0 to represent the selected blocks (without number)
	2. use other numbers to represent the selected blocks (with number)

## Example

```
* * * * * * * * * *
* * * * * 1 1 * * *
* * * * 4 0 2 * * *
* * * * 1 2 1 * * *
* * * X * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * F * *
* * * * * * * * * *
* * * * * * * * * *
```

A `board.txt` as above will generate a board as below.

![board](/Users/bondsam/Documents/TA_works/github/minesweeper/example.png)
