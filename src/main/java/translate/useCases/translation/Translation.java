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
        translateToGerman.put("Good Morning", "Guten Morgen");
        translateToGerman.put("Good Evening", "Guten Abend");
        translateToGerman.put("How are you", "Wie geht's");
        translateToGerman.put("I'm fine", "Mir geht es gut");
        translateToGerman.put("I'm fine. Thanks", "Ich bin gut. Danke");
        translateToGerman.put("Thank you REDI", "Danke REDI");
        translateToGerman.put("Have a nice evening", "Schonen Abend");
        translateToGerman.put("Bye", "Tchuss");
        translateToGerman.put("See you again", "Auf wiedersehen");
        translateToGerman.put("REDI is awesome", "REDI ist toll");
        translateToGerman.put("Yes, REDI is awesome", "Ja, REDI ist toll");



        // TRANSLATE TO ENGLISH

        // German to English
        translateToEnglish.put("Hallo", "Hello");
        translateToEnglish.put("Guten Morgen", "Good Morning");
        translateToEnglish.put("Guten Abend", "Good Evening");
        translateToEnglish.put("Wie geht's", "How are you");
        translateToEnglish.put("Mir geht es gut", "I'm fine");
        translateToEnglish.put("Ich bin gut. Danke", "I'm fine. Thanks");
        translateToEnglish.put("Danke REDI", "Thank you REDI");
        translateToEnglish.put("Schonen Abend", "Have a nice evening");
        translateToEnglish.put("Tchuss", "Bye");
        translateToEnglish.put("Auf Weidersehen", "See you again");
        translateToEnglish.put("REDI ist toll", "REDI is awesome");
        translateToEnglish.put("Ja, REDI ist toll", "Yes, REDI is awesome");

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
