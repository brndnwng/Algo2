package algo2.programassignment.one.onetwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobScheduler {

	/*
	 * Difference of weight - length, giving more priority to weight if tied
	 * 
	 */
    public static class ProblemOneComparator implements Comparator<Job> {
    	
        @Override
        public int compare(Job arg0, Job arg1) {
        	
            int differenceJobOne = arg0.getWeight() - arg0.getLength();
            int differenceJobTwo = arg1.getWeight() - arg1.getLength();

            if (differenceJobOne > differenceJobTwo) {
                return -1;
            }
            else if (differenceJobOne < differenceJobTwo) {
                return 1;
            }
            else {
                if (arg0.getWeight() >= arg1.getWeight()) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        }
    }
    
    /*
     * Ratio of weight/length
     * 
     */

    public static class ProblemTwoComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            // TODO Auto-generated method stub
            long ratioOne = o1.getWeight() * o2.getLength();
            long ratioTwo = o2.getWeight() * o1.getLength();
            
            if(ratioOne >=ratioTwo){
            	return -1;
            }
            else{
            	return 1;
            }
        }

    }

    public static void calcCompletionTime(List<Job> theList) {
        long sum = 0;
        long currentCompletion = 0;
        for (Job j : theList) {
            currentCompletion += j.getLength();
            sum += currentCompletion * j.getWeight();
        }
        System.out.println("SUM IS: " + sum);
    }
    /*File format: first line contains amount of job, each line contains weight and length of one job
     * 
     * 2
     * 1 2
     * 2 4
     * 
     * 
    */
    public static void getJobsFromFile(String filePath, List<Job> theJobs){
    	try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String line;
			line = br.readLine();
			
			while((line=br.readLine())!= null){
				String[] split = line.split("(\\s)+");
				int weight = Integer.parseInt(split[0]);
				int length = Integer.parseInt(split[1]);
				theJobs.add(new Job(weight,length));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        List<Job> theList = new ArrayList<Job>();
        
        getJobsFromFile("input/jobs.txt",theList);

        System.out.println("Problem 1");
        Collections.sort(theList, new ProblemOneComparator());
        calcCompletionTime(theList);
        
        System.out.println("Problem 2");
        Collections.sort(theList, new ProblemTwoComparator());
        calcCompletionTime(theList);
        


    }
}

