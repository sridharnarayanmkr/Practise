
public class Chocolate {
    static int bal=0,visit=0;
    public static void main(String[] args) {

        int cash=16,price=2,wrap=2,choc=1,vis=5;
        int sum;
        sum=cash/price;visit++;
        sum+=calculate(sum,price,wrap,choc,vis);
        System.out.println(sum+" Balance Wrapper: "+bal);
    }
    private static int calculate(int wrapper, int price, int wrap, int choc, int vis) {

        //int ol=0;
        visit++;
        if(visit<=vis){
            if((wrapper)<wrap){
                bal=wrapper;
                return 0;
            }
            else if((wrapper)%wrap!=0){
                //ol=bal;
                bal=(wrapper)%wrap;
                wrapper=((wrapper)/wrap)*choc;
                System.out.println(wrapper+" "+bal);
                return  wrapper+ calculate(wrapper+bal,price,wrap,choc,vis);
            }
            else if((wrapper)%wrap==0){
                //ol=bal;
                bal=0;
                wrapper=((wrapper)/wrap)*choc;
                System.out.println(wrapper+" "+bal);
                return  wrapper+ calculate(wrapper,price,wrap,choc,vis);
            }
        }
        return 0;
    }

}
