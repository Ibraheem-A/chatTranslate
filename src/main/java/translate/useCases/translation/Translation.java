package translate.useCases.translation;

import translate.useCases.messaging.Messages;

import java.util.LinkedHashMap;
import java.util.Map;

public class Translation {

    private static Map<String, String> translateToEnglish = new LinkedHashMap<>();
    private static Map<String, String> translateToGerman = new LinkedHashMap<>();
    private static Map<String, String> translateSpanishToEnglish = new LinkedHashMap<>();

    static {

        // TRANSLATE TO GERMAN

        // English to German
        translateToGerman.put("Hello", "Hallo");
        translateToGerman.put("How are you", "Wie geht's");
        translateToGerman.put("I'm fine", "Ich bin gut");
        translateToGerman.put("I'm fine. Thanks", "Ich bin gut. Danke");
        translateToGerman.put("Thank you REDI", "Danke REDI");
        translateToGerman.put("Have a nice evening", "Schonen Abend");
        translateToGerman.put("Bye", "Tchuss");
        translateToGerman.put("See you again", "Auf wiedersehen");
        // English to Spanish





        // TRANSLATE TO ENGLISH

        // German to English
        translateToEnglish.put("Hallo", "Hello");
        translateToEnglish.put("Wie geht's", "How are you");
        translateToEnglish.put("Ich bin gut", "I'm fine");
        translateToEnglish.put("Ich bin gut. Danke", "I'm fine. Thanks");
        translateToEnglish.put("Danke REDI", "Thank you REDI");
        translateToEnglish.put("Schonen Abend", "Have a nice evening");
        translateToEnglish.put("Tchuss", "Bye");
//        translateToEnglish.put("")
    }


    public static Messages trn(Messages messages, String language) {
        switch (language) {
            case "English":
                return new Messages(translateToEnglish.getOrDefault(messages.getMessage(), messages.getMessage()), messages.getSender());
            case "German":
                return new Messages(translateToGerman.getOrDefault(messages.getMessage(), messages.getMessage()), messages.getSender());
            default:
                return new Messages(messages.getMessage(), messages.getSender());
        }

    }

}
