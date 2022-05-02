The task is to recreate the game of battleships.

The battleship game:

A player will place 5 of their ships on a 10x10 grid.

The computer will deploy five ships on a different 10x10 grid.

Once the game starts the player and computer take turns.

Trying to sink each other's ships by guessing the coordinates to "attack".

The game ends when either the player or computer has no ships left.

The game needs to be recreated using Java. When the game starts it should prompt the user to enter the coordinates of the ship placement. There's a total of 5 ships the user can place.

Coordinates should follow the follow the format, letter followed by number.
For example on a 2x3 grid,
First Row: A1, A2, A3
Second Row: B1, B2, B3

Once the input is captured from the user, the computer should place its ships in its grid at random 5 coordinates.

And the game begins by player and computer taking turns to guess the cordinates. Total 10 guesses, 5 for player and 5 for computer.

On each guess it shoukd be displayed whether it was a hit or miss. Hit being correct guess and Miss being incorrect guess.

The game is over after 5 guesses from each. And it should display who has won and total number of hits/misses for both participants.

Additional notes:
1. Validity of guesses and coordinate entries: Invalid entries need to be caught and must reprompt the user to make valid entries.
2. The computer should use a proper random method to place the ships and make guesses against the player. The values shouldn't be hardcoded.


Let me know if you have any questions.