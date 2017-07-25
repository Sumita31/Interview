package ByteByByte;

import java.util.*;

/**
 * Created by sumitachauhan on 7/21/17.
 */
public class BuildProcess {
    public List<Integer> build(int[][] processes){
        List<Integer> result = new LinkedList<>();
        Set<Integer> permMarks=new HashSet<>();
        Set<Integer> tempMarks=new HashSet<>();
        for(int i=0; i<processes.length; i++){
            if(!permMarks.contains(i)){
               visit(processes, i, tempMarks, permMarks,result);
            }
        }
        return result;
    }
    private void visit(int[][] processes, int process, Set<Integer> tempMarks, Set<Integer> perMarks, List<Integer> result){
        if(tempMarks.contains(process)) throw new IllegalArgumentException("deadlock");
        if(!perMarks.contains(process)){
            tempMarks.add(process);
            for(int i:processes[process]){
                visit(processes,i,tempMarks,perMarks,result);
            }
            perMarks.add(process);
            tempMarks.remove(process);
            result.add(process);
        }
    }

    public static void main(String[] args) {
        int[][] processes ={
                {},
                {0},
                {1},
                {1,2},
                {3},
                {0}
        };
        BuildProcess obj = new BuildProcess();
        List<Integer> res =obj.build(processes);
        for(int i: res){
            System.out.print(i+", ");
        }
    }


}
