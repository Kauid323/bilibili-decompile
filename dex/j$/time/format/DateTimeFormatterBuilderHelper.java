package j$.time.format;

/* JADX INFO: Access modifiers changed from: package-private */
public final class DateTimeFormatterBuilderHelper {
    private DateTimeFormatterBuilderHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String transformAndroidJavaTextDateTimePattern(String pattern) {
        if (pattern == null) {
            return null;
        }
        boolean containsCharB = pattern.indexOf(66) != -1;
        boolean containsCharb = pattern.indexOf(98) != -1;
        if (containsCharB || containsCharb) {
            return rewriteIcuDateTimePattern(pattern);
        }
        return pattern;
    }

    private static String rewriteIcuDateTimePattern(String pattern) {
        StringBuilder sb = new StringBuilder(pattern.length());
        char prev = ' ';
        for (int i = 0; i < pattern.length(); i++) {
            char curr = pattern.charAt(i);
            switch (curr) {
                case ' ':
                    if (i == 0 || (prev != 'B' && prev != 'b')) {
                        sb.append(curr);
                        break;
                    }
                    break;
                case 'B':
                case 'b':
                    break;
                default:
                    sb.append(curr);
                    break;
            }
            prev = curr;
        }
        int i2 = sb.length();
        int lastIndex = i2 - 1;
        if (lastIndex >= 0 && sb.charAt(lastIndex) == ' ') {
            sb.deleteCharAt(lastIndex);
        }
        return sb.toString();
    }
}