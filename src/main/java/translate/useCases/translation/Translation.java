package translate.useCases.translation;

import translate.useCases.messaging.Messages;

import java.util.LinkedHashMap;
import java.util.Map;

public class Translation {

    private static Map<String, String> translateToEnglish = new LinkedHashMap<>();
    private static Map<String, String> translateToGerman = new LinkedHashMap<>();
    static {
        translateToGerman.put("hello", "hallo");
        translateToEnglish.put("hallo", "hello");
        translateToGerman.put("how are you", "wie geht's");
        translateToEnglish.put("wie geht's", "how are you");
        translateToGerman.put("I'm fine. Thanks", "Ich bin gut. Danke");
        translateToEnglish.put("Ich bin gut. Danke", "I'm fine. Thanks");

    }


    public static Messages trn(Messages messages, String language) {
        if (language == "English") {
            new Messages(translateToEnglish.getOrDefault(messages.getMessage(), messages.getMessage()));
        }
        else if (language == "German"){
            new Messages(translateToGerman.getOrDefault(messages.getMessage(), messages.getMessage()));
        }
        return;
    }

}
