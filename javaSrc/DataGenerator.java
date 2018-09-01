import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {
    private ArrayList<String> data = new ArrayList<>();

    private String getRandom(int length){
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0;i<length;i++){
            int num = random.nextInt(62);
            sb.append(str.charAt(num));
        }
        return sb.toString();
    }

    public ArrayList<String> getData(){
        return data;
    }

    public void addData(Multiset<String> multiset){
        while(this.getData().size() < 1000){
            for(int i = 2;i < 6;i++){
                String str = this.getRandom(i);
                this.getData().add(str);
                multiset.add(str);
            }
        }
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
}
