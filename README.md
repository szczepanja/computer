Load a file with instructions and executes them one by one on a board of n x m size.

    CREATE [arrow] [x] [y] [id] - places an arrow symbol (^, >, v, <) identified by id on the (x, y) field
    ROTATE [id] 0, 90, 180, 270, -90, -180, -270 - rotates an arrow to a given direction
    MOVE [id] [n] - moves an arrow forward n steps

Display a state of a board every instruction.

Hint: Start with one arrow only. Rotate and move it around.
