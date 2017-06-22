package OOP;


public abstract class Elevator {
    int[] legalfloors;
    int capacity;

    public void goTo(int floorNo){

    }
    public boolean isOperational(){
        return true;
    }
    public int getCurrentFloor(){
        return 0;
    }
}

class ElevatorGenerator extends Elevator{
    private int[] legalfloors;
    private int capacity;

    public ElevatorGenerator(int[] legalFloors, int capacity){
        this.legalfloors=legalFloors;
        this.capacity=capacity;
    }

    public void goTo(int floorNo){

    }
    public boolean isOperational(){
        return true;
    }
    public int getCurrentFloor(){
        return 0;
    }
    private void goUp(int floorNo){

    }
    private void goDown(int floorNo){

    }
}
