# Project 2 - Massive Motion
**Author:** Paul Gedrimas

[Demo](video/massive%20motion.gif)

A 2D celestial body simulator with a star.

---

## How to Run the Project

### To compile:
1. Download from GitHub or clone via terminal.
2. Navigate to the `src` folder.
3. Type:
   ```bash
   javac *.java
   ```

### To run:
Type:
```bash
java MassiveMotion <MassiveMotion.txt>
```
as a command-line argument.

---

## The `.txt` File Configuration

The `.txt` file should contain the following parameters:
```
timer_delay = 75
list = single

window_size_x = 1000
window_size_y = 700

gen_x = 0.06
gen_y = 0.06
body_size = 10
body_velocity = 10

star_position_x = 500
star_position_y = 350
star_size = 30
star_velocity_x = 0
star_velocity_y = 0
```

---

## Key Notes

- **timer_delay** — Canvas update frequency.  
- **list** — All lists used under this configuration must be of the specified type.  
  Valid types are:  
  - `arraylist` = ArrayList  
  - `single` = Singly-linked list with `next` pointers  
  - `double` = Linked list with `next` and `prev` pointers  
  - `dummyhead` = Linked list with an empty `head` node  

- **window_size_x / window_size_y** — Width and height of the canvas.  

- **star_position_x / star_position_y / star_size / star_velocity_x / star_velocity_y** —  
  The first celestial body on the canvas is a “star” with certain characteristics — position, radius, and velocity.  
  Your implementation may ignore the mass of the star in kg.  

- **gen_x / gen_y** — Probability that a new celestial body will be generated at the frontier of the x or y axis.  
  If generated, it has a 50% probability of spawning from either side (top/bottom or left/right).  

- **body_size** — Radius of the new celestial body.  

- **body_velocity** — Range of velocities of the celestial body.  
  If set to 3, the range is random between -3 and +3 (excluding 0), separately determined for both the x-axis and y-axis.

---

## Notes & Reflections

Each list type may not have a standard implementation. I tried my best to implement them without using outside sources and focused on logical design.

The biggest challenge in this project was understanding how painting and movement of celestial objects worked. Since I haven't done GUI and animation before, it was initially difficult to grasp. I thought iterating through each body using loops would make the program slow, but I quickly realized how fast these calculations actually are.

Fun project — I enjoyed working on it!
