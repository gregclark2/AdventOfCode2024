package Day1Java;

import java.io.FileReader;

import java.util.*;

import static java.util.Collections.sort;

public class Day1Src {
    public static void main(String[] args) {


        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        HashSet<Integer> leftSet = new HashSet<>();
        //for part 2
        HashMap<Integer, Integer> timesInRight = new HashMap<>();

        int result = 0;
        int result2 = 0;

        try {
            Scanner input = new Scanner(new FileReader("Day1_1input.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] inBufferArray = line.split("\\s+");
                leftList.add(Integer.valueOf(inBufferArray[0]));
                rightList.add(Integer.valueOf(inBufferArray[1]));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sort(leftList);
        sort(rightList);

        if (leftList.size() == rightList.size()) {
            for (int i = 0; i < leftList.size(); i++) {
                result += Math.abs((leftList.get(i) - rightList.get(i)));
            }

        } else {
            System.out.println("Array issue with length");
        }
        System.out.println("result: " + result);

        int counter = 0;
                for (int num : rightList) {
                    if( num == 24791) counter++;
                }
        //part 2
        for (int i = 0; i < rightList.size(); i++) {
            if (timesInRight.containsKey(rightList.get(i)))
            {timesInRight.put(rightList.get(i), (timesInRight.get(rightList.get(i)) + 1));}
            else {
                timesInRight.put(rightList.get(i), 1);
            }
        }

        System.out.println(timesInRight);
            leftSet.addAll(leftList);
            for (Integer num : leftSet) {
                if (timesInRight.containsKey(num)) {
                    System.out.println(num + " " + timesInRight.get(num));
                    result2 += num * timesInRight.get(num);
                }
            }

        System.out.println("Result 2: " + result2);
            System.out.println("Counter should be 6: " + counter);

        }

    }