# Pairing Drivers and Passengers with Algorithms

## How to run the code:
  In order to run the code, you must compile it with a java compiler, ensuring that all of the .class files are in the same folder, and then you run
  the program using the java command.

## How to reproduce the experiments:

**How the raw data was generated**: The raw data was generated using Java's Random class. For each experiment the range for each coordinate was created with
Random.nextInt(-50, 50), first generating x then y, and generating all the uber drivers before the passengers. The seed was determined when the object was created,
using seeds 4292026-4322026 for each run of each subexperiment.

**Where the seeds and input were defined**: The seeds were defined as constant values within the code, as the experiment was done through hardcoding. The random seeds used
are listed here: 4292026, 4302026, 4312026, 4322026.

**How were the averages computed**: The averages for each subexperiment were computed by finding the mean of the 4 runs. This means it was the average of seeds
4292026, 4302026, 4312026, and 4322026, calculated for each subexperiment.

**How were the charts produced**: The charts were produced through canva, created as bar graphs using the average of each subexperiment. A separate pair of bars was
added for each subexperiment, with one bar for the baseline algorithm's average and one for the improved algorithm's average.

## The function of each file:

  **Main.java**: This is the main file for the program, containing the algorithms for solving the problem, the inputs, and the output. The two algorithms within
  the Main.java file are a brute force scanning algorithm, and a Divide and Conquer KD-Tree algorithm that is designed to be more efficient.

  **CoordinatePoint**: This is the file for the CoordinatePoint class, which is an abstract class that contains fields for an x and y coordinate, the methods
  to modify those coordinates, and a method to find the distance between two CoordinatePoint objects.
  
  **UberDriver.java**: This is the file for the UberDriver class, which is a child class of the
  CoordinatePoint class and contains a location and list of passengers, alongside a static function to find the distance between two UberDriver objects.

  **Passenger.java**: This is the file for the Passenger class, which is a child class of the CoordinatePoint class and contains an UberDriver variable to store
  a reference to the closest UberDriver to the given passenger.

  **KDTree.java**: KDTree implementation of 2D kd tree that takes UberDriver objects for the purpose of efficiently finding the nearest neighbor (nearest uber driver), given a point of passenger location

  **AxisComparator**: Sorts Uberdriver objects between its x or y coordinate. If those values are equal, then it uses the other coordinate to break the tie to make sure they are ordered.
