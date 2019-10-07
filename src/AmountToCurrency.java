import java.util.HashMap;

public class AmountToCurrency {
    public static void main(String[] args) {
        convertAmount(868);
    }

    private static void convertAmount(int amount) {
        int[] curr = {2000,500,200,100,50,20,10,5,1};
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for (int i=0;i<curr.length;i++){
            while(amount>=curr[i]){
                amount-=curr[i];
                if(hmap.containsKey(curr[i])){
                    hmap.put(curr[i],hmap.get(curr[i])+1);
                }else {
                    hmap.put(curr[i],1);
                }
            }
        }

        for(int i=0;i<curr.length;i++){
            if(hmap.containsKey(curr[i])){
                System.out.println(curr[i]+" - "+hmap.get(curr[i]));
            }
        }

    }
}
