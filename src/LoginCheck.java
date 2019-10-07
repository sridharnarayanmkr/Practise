import java.io.*;
import java.util.Scanner;

public class LoginCheck {
    public static void main(String[] args) throws IOException {
        int ch;
        System.out.println("1.Sign Up\n2.Login");
        Scanner sc = new Scanner(System.in);
        ch = sc.nextInt();
        do {
            switch (ch){
                case 1: signUp();
                        break;
                case 2: login();
                        break;
                default:break;
            }
            System.out.println("1.Sign Up\n2.Login");
            ch = sc.nextInt();
        }while(ch>0&&ch<=2);
    }

    private static void login() {

    }

    private static void signUp() throws IOException {
        Scanner sc = new Scanner(System.in);
        String name,pwd;
        int id;
        System.out.println("Name: ");
        name=sc.nextLine();
        System.out.println("Password: ");
        pwd=sc.nextLine();
        encrypt(pwd);
        id=getLastId();
        if(addUser(id+","+name+","+pwd)){
            System.out.println("Added");
        }else{
            System.out.println("Failed!");
        }
    }

    private static void encrypt(String pwd) {

        char[] arr = new char[pwd.length()];
        for(int i=0;i<pwd.length();i++){
            arr[i]=getNextChar(pwd.charAt(i),2);
        }
        System.out.println(new String(arr));

    }

    private static char getNextChar(char ch,int v) {

        if(ch>=97 && ch<=122-v){
            ch=(char)(ch+v);
        }
        else{
            ch=(char)(97+(ch+v-121));
        }
        return ch;
    }

    private static boolean addUser(String s) throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{

            fw = new FileWriter("details.txt",true);
            bw = new BufferedWriter(fw);
            bw.write(s+"\n");
            return true;

        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }finally {
            bw.close();
            fw.close();
        }

    }

    private static int getLastId() throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        int id=100;
        String line,last = null;
        try{
            fr = new FileReader("details.txt");
            br = new BufferedReader(fr);
            while((line=br.readLine())!=null){
                last=line;
            }
            id = Integer.parseInt(last.split(",")[0]);
        } catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            br.close();
            fr.close();
        }
        return id+1;
    }
}
