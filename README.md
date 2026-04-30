# Pairing Drivers and Passengers with Algorithms

## How to run the code:
  In order to run the code, you must compile it with a java compiler, ensuring that all of the .class files are in the same folder, and then you run
  the program using the java command.

## How to reproduce the experiments:
  **Inputs**: The seeds used to generate the random numbers were 4292026, 4302026, 4312026, 4322026.
    The input values for each experiment were:
      n = number of drivers, m = number of passengers
      1.1: m = 1000, n = 1000
      1.2: m = 100, n = 100
      2.1: m = 10000, n = 1000
      2.2: m = 1000, n = 100
      3.1: m = 1000, n = 10000
      3.2: m = 100, n = 1000
  **Method**: The experiment was run by creating a Random object in Java with a seed, using each seed 1 time for each experiment, and using that seed to create
    all of the driver and passenger objects through using Random.nextInt() for each coordinate. The time that it took for the experiment was measured in nanoseconds,
    using System.nanoTime(), then dividing the value by 1,000,000 to get the amount in miliseconds. Calculating the total time was run by storing the nanoTime at the start
    of the algorithm in 1 variable, then subtracting it from the nanoTime at the end of the algorithm.

## The function of each file:

  **Main.java**: This is the main file for the program, containing the algorithms for solving the problem, the inputs, and the output. The two algorithms within
  the Main.java file are a brute force scanning algorithm, and a Divide and Conquer KD-Tree algorithm that is designed to be more efficient.

  **CoordinatePoint**: This is the file for the CoordinatePoint class, which is an abstract class that contains fields for an x and y coordinate, the methods
  to modify those coordinates, and a method to find the distance between two CoordinatePoint objects.
  
  **UberDriver.java**: This is the file for the UberDriver class, which is a child class of the
  CoordinatePoint class and contains a location and list of passengers, alongside a static function to find the distance between two UberDriver objects.

  **Passenger.java**: This is the file for the Passenger class, which is a child class of the CoordinatePoint class and contains an UberDriver variable to store
  a reference to the closest UberDriver to the given passenger.

  **KDTree.java**:

  **AxisComparator.java**:
