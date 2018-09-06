import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {
    private ArrayList<String> data = new ArrayList<>();
    private final int dataSize = 1000000;
    private final int removeSize = 100;
    private final int addTime = 100;
    private final int removeTime = 100;
    private final int searchTime = 20000;

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
        final String fileName = "D:\\Multiset\\javaSrc\\AddFile.txt";
        long addDataStartTime = System.currentTimeMillis();
        while(this.getData().size() < dataSize){
            for(int i = 2;i < 6;i++){
                String str = this.getRandom(i);
                this.getData().add(str);
                multiset.add(str);
            }

        }
        long addDataEndTime = System.currentTimeMillis();
        System.out.println("Add Data Time:"+(addDataEndTime-addDataStartTime)+"ms");

        long startTime = System.nanoTime();
        this.textWriter(this.getData(),fileName);
        long endTime = System.nanoTime();
        System.out.println("TextFile Write time:"+(endTime-startTime)+"ms");
    }

    public void removeOneData(Multiset<String> multiset) throws IOException {
        final String fileName = "D:\\Multiset\\javaSrc\\RemoveFile.txt";
        ArrayList<String> removeData = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        for(int i = 0;i<removeSize;i++){
            Random random = new Random();
            int index = random.nextInt(this.getData().size()-1);
            String str = this.getData().get(index);

            multiset.removeOne(str);
            removeData.add(str);
            this.getData().remove(index);

        }
        long endTime = System.currentTimeMillis();

        System.out.println("Remove One Data time:"+(endTime-startTime)+"ms");
        this.textWriter(removeData,fileName);
    }

    public void removeAllData(Multiset<String> multiset) throws IOException {
        final String fileName = "D:\\Multiset\\javaSrc\\RemoveAllFile.txt";
        ArrayList<String> removeAllData = new ArrayList<>();

        long startTime = System.nanoTime();
        for(int i = 0;i<removeSize;i++){
            Random random = new Random();
            int index = random.nextInt(this.getData().size()-1);
            String str = this.getData().get(index);

            multiset.removeAll(str);
            removeAllData.add(str);
            this.getData().remove(index);

        }
        long endTime = System.nanoTime();

        System.out.println("Remove All Data time:"+(endTime-startTime)+"ms");
        this.textWriter(removeAllData,fileName);
    }

    public void searchData(Multiset<String> multiset) throws IOException {
        final String fileName = "D:\\Multiset\\javaSrc\\SearchFile.txt";
        ArrayList<String> searchData = new ArrayList<>();

        long startTime = System.currentTimeMillis();
       // for(int i = 0;i<addTime;i++){
       //     this.addData(multiset);
        // }
       for(int j = 0;j<searchTime;j++){
        Random random = new Random();
        int index = random.nextInt(this.getData().size()-1);
        String str = this.getData().get(index);
        multiset.search(str);
        searchData.add(str);
       }
       //for(int t = 0;t<removeTime;t++){
           this.removeOneData(multiset);
       //}
       long endTime = System.currentTimeMillis();

        System.out.println("Search Data time:"+(endTime-startTime)+"ms");
        this.textWriter(searchData,fileName);

    }

    public void mergeTest(Multiset<String> multiset) throws IOException {
        final String fileName = "D:\\Multiset\\javaSrc\\MergeTextFile.txt";
        String[] command = {"A","R"};
        Random random = new Random();

        ArrayList<String> removeData = new ArrayList<>();

        long startTime = System.nanoTime();
        for(int i = 0;i<dataSize;i++){
            int index = random.nextInt(1);
            if( "A".equals(command[index])){
                for(int j = 2;j < 6;j++){
                    String str = this.getRandom(i);
                    this.getData().add(str);
                    multiset.add(str);
                }
            }else if("R".equals(command[index])) {
                if (this.getData().size() > 1) {
                    Random random1 = new Random();
                    int index1 = random1.nextInt(this.getData().size()-1);
                    String str1 = this.getData().get(index1);
                    multiset.removeOne(str1);
                    removeData.add(str1);
                    this.getData().remove(str1);
                } else {
                    for(int j = 2;j < 6;j++) {
                        String str = this.getRandom(i);
                        this.getData().add(str);
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
