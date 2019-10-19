package selenium.test.project.utils;

import java.util.Random;

public class DataGenerator {

    public int getRandomNumber (int min, int max){
        return new Random().nextInt(max- min + 1) + min;
    }

    public String getRundomString(int lenght){
        char [] chars = "abcdefghgjiklmnoprstqvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(lenght);
        Random random = new Random();
        for (int i= 0; i< lenght; i++){
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
            return sb.toString();
    }
}
