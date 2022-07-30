package committee.nova.petphrase.util;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    static final ImmutableList<Character> punctuations = ImmutableList.of('!', '?', '.', '(', ')', '！', '？', '。', '（', '）', '~', '”', '“', '‘', '’', '"', '\'');

    public static int getLastPunc(String string) {
        final int length = string.length();
        if (length == 1) return (punctuations.contains(string.charAt(0))) ? -1 : 0;
        return getPunc(string, length - 1);
    }

    public static int getPunc(String string, int index) {
        return (!punctuations.contains(string.charAt(index))) ? index : (index == 0) ? -1 : getPunc(string, index - 1);
    }

    public static String fillPetPhraseIn(String original, String petPhrase) {
        if (original.charAt(0) == '/') return original;
        final int index = getLastPunc(original) + 1;
        if (index == 0) return original;
        return StringUtils.substring(original, 0, index) + petPhrase + StringUtils.substring(original, index);
    }
}
