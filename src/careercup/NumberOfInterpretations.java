package careercup;

/**
 *
 *     We have a coding system from alphabets to numbers where a=1, b=2, ...z=26. You are given a string of digits as an input. Write a function that will compute the number of valid interpretations of the input.

         Examples:
         f('11') = 2 // Actual interpretations: ('aa', 'k')
         f('111') = 3 // Actual interpretations: ('aaa', 'ak', 'ka’)

         f('111')
         dp[0] =


         /*
         dp[0-n] = {1,

         dp[index] = dp[index-1]+dp

 *
 *  Created by sunny on 3/19/16.
 */


public class NumberOfInterpretations {

    public int getInterpretations(String inputWord) throws Exception{

        if(inputWord==null){
            return -1; //error code
        }

        int[] numbers = new int[inputWord.length()];
        int[] dp = new int[inputWord.length()]; //capturing the memoized information of the prev numbers

//        for(int index=0;index<numbers.length;index++){
//
//            int num = Integer.parseInt(inputWord.charAt(index) + "");
//            if(num!=0)
//                numbers[index]=num;
//            else
//                throw new IllegalArgumentException("");
//        }

        //inputWord = "01"
        //inputWord2 = "10"
        dp[0] = 1;
        int len = numbers.length;

        if(len >= 2){

            if(numbers[0]*10+numbers[1] < 27){
                dp[1]=2;
            }
            else{
                dp[1]=1;
            }

            for(int i=2;i< len;i++){
                int lastTwoValidDigits = 0;

                if(numbers[i-1]*10 + numbers[i] < 27)
                    lastTwoValidDigits = dp[i-2];
                dp[i] = dp[i-1]+lastTwoValidDigits;
            }
        }

        return dp[len-1];
    }

    public static void main(String[] args) {

        NumberOfInterpretations numberCalculator = new NumberOfInterpretations();

        try {
            System.out.println(numberCalculator.getInterpretations("10"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}




