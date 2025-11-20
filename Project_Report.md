# 📂 Project Files Report

Hey there! 👋 Here is a quick rundown of the Java files in your `src/main/java` folder. It looks like you're working on some cool geometry stuff with 2D rectangles and 3D cuboids.

Here's what each file does and how you can use it.

---

## 1. `Point3D.java` 📍
**What it is:**
This is your basic building block for the 3D world. It represents a point in 3D space with `x`, `y`, and `z` coordinates.

**Functionality:**
- Stores 3D coordinates.
- Calculates the distance to another point.
- Prints itself nicely with `toString()`.



---

## 2. `Cuboid.java` 📦
**What it is:**
This class defines a 3D box (a cuboid). It uses two `Point3D` objects to represent opposite corners.

**Functionality:**
- Creates a cuboid from two points or raw coordinates.
- Calculates dimensions: `getWidth()`, `getLength()`, `getDepth()`.
- Finds the center point of the cuboid.



---

## 3. `Lab6Ex1.java` 🧪
**What it is:**
This is a runnable program (it has a `main` method) that tests out your `Cuboid` logic.

**Functionality:**
- Creates two specific `Cuboid` instances.
- Checks if they intersect (overlap).
- If they do, it calculates the volume of the overlapping part.

**How to run it:**
Just run the `main` method. It will print out whether the hardcoded cuboids intersect and what their common volume is.

---

## 4. `MyRectangle.java` 🟦
**What it is:**
This represents a 2D rectangle. It seems to be a base class or a starter template. It uses Java's built-in `Point2D.Double` for coordinates.

**Functionality:**
- Stores the bottom-left and top-right corners.
- Basic getters and setters.



---

## 5. `Lab6Ex2.java` 📐
**What it is:**
This is the advanced version of `MyRectangle`. It extends that class to add more features and includes a `main` method for testing.

**Functionality:**
- Adds methods to get the center, length, and width of the rectangle.
- The `main` method runs several test cases to see if two rectangles overlap, touch, or are separate.

**How to run it:**
Run the `main` method. You can uncomment different "Cases" in the code to test different scenarios (like overlapping, touching at vertex, etc.).

---

Hope this helps you navigate your project! Happy coding! 🚀
