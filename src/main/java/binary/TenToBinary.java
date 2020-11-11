package binary;

/**
 * @author lsy
 * @version 1.0
 * @date 2020/11/11 19:45
 * @desc 十进制转二进制
 */
public class TenToBinary {
    public static void Transform_to_Binary(int decimal){
        for(int i = 31;i >= 0; i--)
            System.out.print(decimal >>> i & 1);
    }
    
    static public void Transform_to_Binary1(int decimal) {
        if(decimal==0)
            return;
        else {
            Transform_to_Binary1(decimal/2);
            System.out.print(decimal%2);
        }
    }

    public static void main(String[] args) {
        Transform_to_Binary1(10);
        
    }
}
