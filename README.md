# Dominoes

## Rules of the game
The game opposes two players on an 8x8 grid. One player is called line and the other column. Each player has a pile of dominoes measuring 2 × 1 unit. In turn, line and column, deposit a domino on the grid:    
   - line can drop a domino horizontally, covering two squares of the grid.     
   - Column can deposit a domino vertically, covering two squares of the grid. 
   
You can not drop a domino on an already occupied space. As the game progresses, the grid fills, the loser is the first player who can not place his domino.

## IA Player
To choose the best move the IA Player generate a tree of all possibilities to a given depth. Then using the AlphaBeta algorithm it choose the best move.  
The IA can be imporved by using multithreading, a better heuristic and exploiting symetries.

## Test
By default the code launch a keyboard player for the user and an IA player to play with. A graphical interface of the game board is displayed and updated in live.
