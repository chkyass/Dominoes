# Dominoes

## Rules of the game
The game opposes two players on an 8x8 grid. One player is called line and the other column. Each player has a stack of dominoes measuring 2 × 1 unit. In turn, line and column, deposit a domino on the grid:    
   - line can drop a domino horizontally, covering two squares of the grid.     
   - Column can drop a domino vertically, covering two squares of the grid. 
   
You can not drop a domino on an already occupied space. As the game progresses, the grid fills, the loser is the first player who can not place his domino.

## AI Player
To choose the best move the AI Player generate a tree of all possibilities of moves to a given depth. Then using the AlphaBeta algorithm it choose the best move.  
The AI can be imporved by using multithreading, a better heuristic and exploiting symmetries.

## Test
By default the code launch a keyboard player for the user and an AI player to play with. A graphical interface of the game board is displayed and updated in live.  
To play run Game.java
