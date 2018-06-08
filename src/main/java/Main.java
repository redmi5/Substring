import java.io.IOException;

public class Main {

    private static String  getSubString(String input ){
        String result="";
        int max = 0;
        int count = 0;
        String countTemp = "";
        int resultcount=0;
        for (int i = 1; i < input.length(); i++) {
            count = 0;
            String tempStr = input.substring(0, i);
            for (int j = 0; j < input.length(); j += i) {
                if (j + i < input.length()) {
                    countTemp = input.substring(j, j + i);
                    if (tempStr.equals(countTemp)) {
                        count++;
                        if (count > 1 && count>max) {
                            max = count;
                            resultcount=((j+i)-j);
                        }
                    }
                    else{break;}
                }
            }
        }
        System.out.println("countmax=" + max +", result="+resultcount);
        result=""+resultcount;

        return result;
    }
    public static void main(String[] args) {

        try {
            String input = FileDao.readOneLineFromFile();
            String result = getSubString(input);
            FileDao.writeStringToFile(result);
        } catch (IOException | NullPointerException e) {
            System.err.println(e.toString());
        }

    }
}
