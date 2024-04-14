// GameAreaModel.java

public abstract class GameAreaModel {
    // Common properties and methods for all game models can go here

    // Abstract method to check if a tile is a door
    public abstract String isDoor(int x, int y);

    // Abstract method to check if a tile is a boss tile
    public abstract boolean isBoss(int x, int y);

    // Abstract method to check if a tile is a spawn point
    public abstract boolean isSpawn(int x, int y);

    // Abstract method to generate a random number of runes for treasure
    public abstract int treasureRunes();

    // Abstract method to generate a random number
    public abstract int generateRandomNumber();

    // Abstract method to get the dimensions of the floor
    public abstract int[] getFloorDimension();

    // Abstract method to set the current floor
    public abstract void setCurrentFloor(int num);

    // Abstract method to get the current floor
    public abstract int getCurrentFloor();

    // Abstract method to get the starting position
    public abstract int[] getStartPos();

    // Abstract method to get the length of spawn points
    public abstract int getSpawnLen();
}
