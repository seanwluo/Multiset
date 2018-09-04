import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {
    private ArrayList<String> data = new ArrayList<>();
    private final int dataSize = 10000;

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

    private ArrayList<String> getData(){
        return data;
    }

    public void addData(Multiset<String> multiset) throws IOException {
        final String fileName = "D:\\Multiset\\javaSrc\\TestFile.txt";
        long addDataStartTime = System.nanoTime();
        while(this.getData().size() < dataSize){
            for(int i = 2;i < 6;i++){
                String str = this.getRandom(i);
                this.getData().add(str);
                multiset.add(str);
            }

        }
        long addDataEndTime = System.nanoTime();
        System.out.println("Add Data Time:"+(addDataEndTime-addDataStartTime)+"ns");

        long startTime = System.nanoTime();
        this.textWriter(this.getData(),fileName);
        long endTime = System.nanoTime();
        System.out.println("TextFile Write time:"+(endTime-startTime)+"ns");
    }

    public void removeOneData(Multiset<String> multiset){
        Random random = new Random();
        int index = random.nextInt(this.getData().size()-1);
        String str = this.getData().get(index);

        long startTime = System.nanoTime();
        multiset.removeOne(str);
        long endTime = System.nanoTime();

        System.out.println("Remove One Data time:"+(endTime-startTime)+"ns");
        System.out.println(str);
    }

    public void removeAllData(Multiset<String> multiset){
        Random random = new Random();
        int index = random.nextInt(this.getData().size()-1);
        String str = this.getData().get(index);

        long startTime = System.nanoTime();
        multiset.removeAll(str);
        long endTime = System.nanoTime();

        System.out.println("Remove All Data time:"+(endTime-startTime)+"ns");
        System.out.println(str);
    }

    public void searchData(Multiset<String> multiset){
        Random random = new Random();
        int index = random.nextInt(this.getData().size()-1);
        String str = this.getData().get(index);

        long startTime = System.nanoTime();
        multiset.search(str);
        long endTime = System.nanoTime();

        System.out.println("Search Data time:"+(endTime-startTime)+"ns");
        System.out.println(str);

    }

    public void mergeTest(Multiset<String> multiset) throws IOException {
        final String fileName = "D:\\Multiset\\javaSrc\\MergeTextFile.txt";
        String[] command = {"A","R","RA"};
        Random random = new Random();
        ArrayList<String> mergeData = new ArrayList<>();
        ArrayList<String> removeData = new ArrayList<>();

        long startTime = System.nanoTime();
        for(int i = 0;i<dataSize;i++){
            int index = random.nextInt(2);
            if( "A".equals(command[index])){
                for(int j = 2;j < 6;j++){
                    String str = this.getRandom(i);
                    mergeData.add(str);
                    multiset.add(str);
                }
            }else if("R".equals(command[index])) {
                if (mergeData.size() > 1) {
                    Random random1 = new Random();
                    int index1 = random1.nextInt(mergeData.size()-1);
                    String str1 = mergeData.get(index1);
                    multiset.removeOne(str1);
                    removeData.add(str1);
                } else {
                    for(int j = 2;j < 6;j++) {
                        String str = this.getRandom(i);
                        mergeData.add(str);
                        multiset.add(str);
                    }
                }
            }else if("RA".equals(command[index])){
                if(mergeData.size()>1){
                    Random random2 = new Random();
                    int index2 = random2.nextInt(mergeData.size());
                    String str2 = mergeData.get(index2);
                    multiset.removeAll(str2);
                    removeData.add(str2);
                }else {
                    for(int j = 2;j < 6;j++) {
                        String str = this.getRandom(i);
                        mergeData.add(str);
                        multiset.add(str);
                    }
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Test time:"+(endTime-startTime)+"ns");
        this.textWriter(removeData,fileName);
    }


    private void textWriter(ArrayList<String> data,String path) throws IOException {
        File testFile = new File(path);
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
