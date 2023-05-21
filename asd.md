| Variable | Detail                                    |
| -------- | ----------------------------------------- |
| - x      | The x-coordinate of the object's position |
| - y      | The y-coordinate of the object's position |
| - size   | The size of the object                    |
| - speed  | The speed of the object                   |
| - color  | The color of the object                   |

| Constructor                                                        | Detail                                                                       |
| ------------------------------------------------------------------ | ---------------------------------------------------------------------------- |
| + BaseObject(double x, double y, int size, int speed, Color color) | Constructs a BaseObject with the specified position, size, speed, and color. |

| Method                               | Detail                                                                             |
| ------------------------------------ | ---------------------------------------------------------------------------------- |
| + move(double vx, double vy)         | Moves the object by the specified amount in the x and y directions.                |
| + move(int vx, int vy)               | Moves the object by the specified amount in the x and y directions.                |
| + move(Player player)                | Moves the object towards the player based on the current game background position. |
| + move(BaseObject others, int speed) | Moves the object towards another object with the specified speed.                  |
| + distance(Player p)                 | Calculates the distance between the object and the player.                         |
| + distance(BaseObject others)        | Calculates the distance between the object and another object.                     |
| + render(GraphicsContext gc)         | Renders the object on the specified GraphicsContext.                               |

| Getter/Setter         | Detail                                         |
| --------------------- | ---------------------------------------------- |
| + getSize()           | Gets the size of the object                    |
| + setSize(int size)   | Sets the size of the object                    |
| + getX()              | Gets the x-coordinate of the object's position |
| + setX(double x)      | Sets the x-coordinate of the object's position |
| + getY()              | Gets the y-coordinate of the object's position |
| + setY(double y)      | Sets the y-coordinate of the object's position |
| + getColor()          | Gets the color of the object                   |
| + setColor(Color c)   | Sets the color of the object                   |
| + getSpeed()          | Gets the speed of the object                   |
| + setSpeed(int speed) | Sets the speed of the object                   |
