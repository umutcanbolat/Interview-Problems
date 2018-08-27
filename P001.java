package Solutions;

/*
    My quick solution to the problem described here:
    https://www.youtube.com/watch?v=uQdy914JRKQ

 */
public class P001 {

    public static int[] add_one(int[] input){
        
        boolean weNeedBiggerArray = true;
        int[] output;
        
        /*
            if the array is like 9999, than we will need bigger array to store 10000
        */
        for(int i=0 ; i<input.length ; i++){
            if(input[i] < 9){
                weNeedBiggerArray = false;
            }
        }
        
        if(weNeedBiggerArray){
            //create the bigger array, write 1 in the index 0 then fill the remaining with 0
            output = new int[input.length+1];
            System.out.println("we need bigger");
            
            output[0] = 1;
            for(int i=1 ; i<output.length ; i++){
                output[i] = 0;
            }
            return output;
        }else{
            output = new int[input.length];
            System.out.println("we do not need bigger");
            System.arraycopy(input, 0, output, 0, output.length);
            
            
            for(int i=1 ; i<=input.length ; i++){
                if(input[input.length - i] + 1 < 10){
                     output[output.length - i] = input[input.length - i] + 1;
                     return output;
                }else{
                    //we will carry the number if it exceeds 9
                    output[output.length - i] = (input[input.length - i] + 1) % 10;
                }
            }
        }
        return output;
    }
    
    public static void main(String[] args) {
        int[] test = add_one(new int[]{1,2,3,4,8,9,9});
        for(int i=0 ; i<test.length ; i++){
            System.out.print(test[i] + " ");
        }
    }
}
