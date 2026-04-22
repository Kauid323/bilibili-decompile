package tv.danmaku.bili.utils;

import android.text.TextUtils;

public class FormatUtils {
    public static boolean checkPhoneNumFormat(String phoneNum) {
        return !TextUtils.isEmpty(phoneNum) && phoneNum.length() == 11 && '1' == phoneNum.charAt(0);
    }
}