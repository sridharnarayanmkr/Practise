import java.io.*;
import java.util.Vector;

public class TaxiFileHandling {
    public static void main(String[] args) throws IOException {
        Vector<String> empData = new Vector<>();
        addEmp();
        empData=getEmpData();

        for(int i=0;i<empData.size();i++){
            String[] s = empData.get(i).split(",");
            System.out.println(s[0]+" "+s[1]+" "+getTotalFare(s[0]));
        }

    }

    private static void addEmp() throws IOException {
        String line="103,Eliza,21,mbq";
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter("emp.txt",true);
            bw = new BufferedWriter(fw);
            bw.write(line);
            bw.newLine();
        }catch(Exception e){
            System.out.println(e.toString());
        }finally {
            bw.close();
            fw.close();
        }
    }

    private static int getTotalFare(String s) throws IOException {
        int total=0;
        FileReader fr=null;
        BufferedReader br=null;
        String line;
        try{
            fr= new FileReader("ride.txt");
            br = new BufferedReader(fr);
            while((line=br.readLine())!=null){
                String[] arr = line.split(",");
                if(arr[0].equals(s)){
                    total+=Integer.parseInt(arr[2]);
                }
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            br.close();
            fr.close();
        }
       return total;
    }

    private static Vector<String> getEmpData() throws IOException {
        Vector<String> vect = new Vector<>();
        FileReader fr=null;
        BufferedReader br=null;
        String line;
        try{
             fr = new FileReader("emp.txt");
             br = new BufferedReader(fr);
            while((line=br.readLine())!=null){
                vect.add(line);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }finally {
            br.close();
            fr.close();
        }
        return vect;
    }
}
