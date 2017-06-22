package DynamicProgramming;

import java.util.*;

public class JobScheduling {
    public int profit(List<Job> jobs){
        Collections.sort(jobs, new JobSorter());
        int[] profit = new int[jobs.size()];
        for(int i=0; i<profit.length; i++){
            profit[i]=jobs.get(i).getProfit();
        }
        for(int j=1; j<profit.length; j++){
            for(int i=0; i<j; i++) {
                if (jobs.get(i).getEndTime() <= jobs.get(j).getStartTime()) {
                    profit[j] = Math.max(profit[i] + jobs.get(j).getProfit(), profit[j]);

                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for(int k=0; k<profit.length; k++){
            if(profit[k]>maxVal){
                System.out.println(profit[k]);
                maxVal=profit[k];
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Job j1=new Job(1,3,5);
        Job j2=new Job(2,5,6);
        Job j3=new Job(4,6,5);
        Job j4=new Job(6,7,4);
        Job j5=new Job(5,8,11);
        Job j6=new Job(7,9,2);

        List<Job> jobs=new ArrayList<>();
        jobs.add(j1);
        jobs.add(j2);
        jobs.add(j3);
        jobs.add(j4);
        jobs.add(j5);
        jobs.add(j6);

        JobScheduling obj = new JobScheduling();
        System.out.println(obj.profit(jobs));
    }
}
class Job {
    private int startTime;
    private int endTime;
    private int profit;

    public Job(int start, int end, int prof){
        if(start<end){
            this.startTime=start;
            this.endTime=end;
            this.profit=prof;
        }
    }
    public int getStartTime(){
        return this.startTime;
    }

    public int getEndTime(){
        return this.endTime;
    }

    public int getProfit(){
        return this.profit;
    }

    public int compare(Job j1, Job j2) {
        return j1.getEndTime()-j2.getEndTime();
    }

//    @Override
//    public int compareTo(Object o) {
//        return this.getEndTime()-((Job) o).getEndTime();
//    }
}

class JobSorter implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        return (j1.getEndTime() <=j2.getEndTime()? -1:1);
    }

}
