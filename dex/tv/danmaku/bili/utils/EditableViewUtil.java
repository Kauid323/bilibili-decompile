package tv.danmaku.bili.utils;

import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;

public class EditableViewUtil {
    public static InputFilter[] getFilterAllowCnEnDig(TextView textView) {
        return getFilter("[^a-zA-Z0-9一-龥]", textView);
    }

    public static InputFilter[] getFilterAllowCnEnDigPun(TextView textView) {
        return getFilter("[^a-zA-Z0-9一-龥\\p{P}&&[^-_]]", textView);
    }

    public static InputFilter[] getFilter(final String reg, TextView textView) {
        InputFilter[] filters = textView.getFilters();
        InputFilter filter = new InputFilter() { // from class: tv.danmaku.bili.utils.EditableViewUtil.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                String s;
                if (source == null) {
                    s = null;
                } else {
                    try {
                        s = source.toString().replaceAll(reg, "");
                    } catch (Exception e) {
                        return source;
                    }
                }
                if (source instanceof Spanned) {
                    SpannableString sp = new SpannableString(s);
                    TextUtils.copySpansFrom((Spanned) source, start, end, null, sp, 0);
                    return sp;
                }
                return s;
            }
        };
        if (filters.length > 0) {
            InputFilter[] newFilters = new InputFilter[filters.length + 1];
            System.arraycopy(filters, 0, newFilters, 0, filters.length);
            newFilters[filters.length] = filter;
            return newFilters;
        }
        return new InputFilter[]{filter};
    }

    public static int getStringByteLength(String editable) {
        if (editable == null) {
            return 0;
        }
        try {
            return editable.getBytes("GBK").length;
        } catch (UnsupportedEncodingException e) {
            return editable.getBytes().length;
        }
    }
}