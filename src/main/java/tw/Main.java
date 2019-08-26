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
            String[] rootArr = new String[]{"1","2","3","4"};
            String totalNum = TotalNum(inputArr,rootArr);
            System.out.println(totalNum);
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
        for(int i = 0;i<inputArr.length;i++){
            if(Integer.parseInt(inputArr[i])>=10){
                return false;
            }
        }
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

    public static String TotalNum(String[] inputArr, String[] rootArr){
        int countA = 0;
        int countB = 0;
        Set<String> set = new HashSet<String>();
        for(String str : rootArr) {
            set.add(str);
        }
        for(int i = 0;i<inputArr.length;i++){
            if(set.contains(inputArr[i]) == true){
                countB++;
                if(Integer.parseInt(inputArr[i]) == Integer.parseInt(rootArr[i])){
                    countA++;
                }
            }

        }
        return countA+"A"+(countB-countA)+"B";
    }


}


//    Scanner sc = new Scanner(System.in);
//    String inputString = sc.nextLine();
//    String stringArray[] = inputString.split(" ");