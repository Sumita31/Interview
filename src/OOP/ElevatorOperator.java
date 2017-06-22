package OOP;

import java.util.List;

/**
 * Created by sumitachauhan on 6/19/17.
 */
public interface ElevatorOperator {
    public void goUpRequest(int currentFloor, int targetFloor);
    public void goDownRequest(int currentFloor, int targetFloor);
}

class ElevatorOperatorImplement implements ElevatorOperator{
    private List<Elevator> elevators;

    public ElevatorOperatorImplement(List<Elevator> el){
        this.elevators=el;
    }
    public void goUpRequest(int currentFloor, int targetFloor){
        int min = Integer.MAX_VALUE;
        Elevator elevator=null;
        for(Elevator el: elevators){
            if(el.getCurrentFloor()-currentFloor < min){
                min = el.getCurrentFloor();
                elevator=el;
            }
        }
        elevator.goTo(currentFloor);
        elevator.goTo(targetFloor);
    }
    public void goDownRequest(int currentFloor, int targetFloor){

    }
}
