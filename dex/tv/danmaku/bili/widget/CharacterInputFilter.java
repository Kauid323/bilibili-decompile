package tv.danmaku.bili.widget;

import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public class CharacterInputFilter implements InputFilter {
    private char filter;

    public CharacterInputFilter(char c) {
        this.filter = c;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        int i = start;
        while (i < end && this.filter != source.charAt(i)) {
            i++;
        }
        if (i == end) {
            return null;
        }
        if (end - start == 1) {
            return "";
        }
        SpannableStringBuilder filtered = new SpannableStringBuilder(source, start, end);
        int i2 = i - start;
        int end2 = end - start;
        int i3 = end2 - start;
        for (int j = end2 - 1; j >= i2; j--) {
            if (this.filter == source.charAt(j)) {
                filtered.delete(j, j + 1);
            }
        }
        return filtered;
    }
}