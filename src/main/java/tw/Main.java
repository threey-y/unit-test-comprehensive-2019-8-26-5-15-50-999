package tw;

import tw.commands.GuessInputCommand;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {

    private static final int RUN_TIMES = 6;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < RUN_TIMES; i++) {
            String input = new GuessInputCommand().input();
            String inputArr[] =  Trans2Arr(input);
            int arrLength = GetArrLength(inputArr);
            boolean checkLength =  CheckInputLength(arrLength);
            boolean checkNumber = CheckInputNumber(inputArr);
            boolean checkValue = checkLength & checkNumber;
            System.out.println(checkValue);
        }
    }

    public static String[] Trans2Arr(String input){
        String inputArr[] = input.split(" ");
        return inputArr;
    }

    public static int GetArrLength(String[] inputArr){
        int arrLength = inputArr.length;
        return arrLength;
    }


    public static boolean CheckInputLength(int arrLength){
        if(arrLength == 4){
            return true;
        }
        return false;
    }

    public static boolean CheckInputNumber(String[] inputArr){
        Set<String> set = new HashSet<String>();
        for(String str : inputArr) {
            set.add(str);
        }
        if(set.size() != inputArr.length)
        {
            return false;
        }else {
            return true;//不重复
        }
    }


}


//    Scanner sc = new Scanner(System.in);
//    String inputString = sc.nextLine();
//    String stringArray[] = inputString.split(" ");