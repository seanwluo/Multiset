import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {
    private ArrayList<String> data = new ArrayList<>();

    private String getRandom(int length){
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0;i<length;i++){
            int num = random.nextInt(52);
            sb.append(str.charAt(num));
        }
        return sb.toString();
    }

    public ArrayList<String> getData(){
        return data;
    }

    public void addData(Multiset<String> multiset) throws IOException {
        while(this.getData().size() < 100000){
            for(int i = 2;i < 6;i++){
                String str = this.getRandom(i);
                this.getData().add(str);
                multiset.add(str);
            }

        }
        this.textWriter(this.getData());
    }

    public void romoveOneData(Multiset<String> multiset){
        Random random = new Random(this.getData().size());
        int index = random.nextInt();
        String str = this.getData().get(index);
        multiset.removeOne(str);
    }

    public void removeAllData(Multiset<String> multiset){
        Random random = new Random(this.getData().size());
        int index = random.nextInt();
        String str = this.getData().get(index);
        multiset.removeAll(str);
    }

    public void searchData(Multiset<String> multiset){
        Random random = new Random(this.getData().size());
        int index = random.nextInt();
        String str = this.getData().get(index);
        multiset.search(str);

    }

    private void textWriter(ArrayList<String> data) throws IOException {
        File testFile = new File("D:\\Multiset\\javaSrc\\TestFile.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(testFile));
        try{
            for (String word : data) {
                out.write(word);
                out.write("\n");
                out.flush();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            out.close();

        }
    }

}
