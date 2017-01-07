# Canvas Project

Canvas project is a sample drawing program using command line.

Project is aiming to provide simple commands to:
- create canvas
- draw lines
- draw rectangles
- fill area (bucket fill tool)

## Commands

| Command       | Description                                                                                                                                                                     |
|---------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| C w h         | Should create a new canvas of width w and height h.                                                                                                                             |
| L x1 y1 x2 y2 | Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal orvertical lines are supported. Horizontal and vertical lines will be drawn using the 'x'character. |
| R x1 y1 x2 y2 | Should create a new rectangle, whose upper left corner is (x1,y1) and lower rightcorner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.        |
| B x y c       | Should fill the entire area connected to (x,y) with colour 'c'. The behaviour of this isthe same as that of the "bucket fill" tool in paint programs.                           |
| Q             | Should quit the program.                                                                                                                                                        | 


