package main;

import java.util.HashMap;
import java.util.Map;

public class Translator {

    private static final String VOWEL_STR = "уеыаоэяю";
    private static final String CONSONENT_STR = "цкнгшщзхфвпрлджчсмтб";

    private Map<String, String> rusToKoska = new HashMap<>();

    //Strings because because there can be not just single letters
    public Translator() {
        this.rusToKoska.put("ж", "з");
        this.rusToKoska.put("ш", "с");
        this.rusToKoska.put("щ", "с");
        this.rusToKoska.put("ч", "т");
        this.rusToKoska.put("ы", "и");
        this.rusToKoska.put("ц", "т");
        this.rusToKoska.put("р", "л");
        this.rusToKoska.put("Ж", "з");
        this.rusToKoska.put("Ш", "с");
        this.rusToKoska.put("Щ", "с");
        this.rusToKoska.put("Ч", "т");
        this.rusToKoska.put("Ы", "и");
        this.rusToKoska.put("Ц", "ть");
        this.rusToKoska.put("Р", "л");
    }


    public String translate(String input){
        StringBuilder output = new StringBuilder();
        String[] words = input.split(" ");
        for (String word : words){
            output.append(translateWord(word) + ' ');
        }
        return output.toString();
    }

    private String translateWord(String inputWord){
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < inputWord.length(); i++){
            String rusSeq = Character.toString(inputWord.charAt(i));

            if (rusToKoska.containsKey(rusSeq)
      //              && i != 0 && i != inputWord.length() - 1
                    ){ //I'm not sure if we should replace first&last symbol
                output.append(rusToKoska.get(rusSeq));
            }
            else
                output.append(rusSeq);
        }

        insertSoftSignes(output);
        return output.toString();
    }

    private void insertSoftSignes(StringBuilder word){
        int consonent = 0;
        for (int i = 1; i < word.length(); i++) {
            if (CONSONENT_STR.lastIndexOf(word.charAt(i)) != -1) {
                consonent++;
            }
            else {
                if (consonent > 1) {
                    word.insert(i - 1, 'ь');
                }
                consonent = 0;
            }
        }

        if (CONSONENT_STR.lastIndexOf(word.charAt(word.length() - 1)) != -1 && word.length() < 6){
            word.append('ь');
        }
    }
}
