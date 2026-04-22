package tv.danmaku.android.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

public class InputMethodLeakUtils {
    public static void fixInputMethodManagerLeak(Context destContext) {
        InputMethodManager inputMethodManager;
        if (destContext == null || Build.VERSION.SDK_INT > 23 || (inputMethodManager = (InputMethodManager) destContext.getSystemService("input_method")) == null) {
            return;
        }
        String[] viewArray = {"mCurRootView", "mServedView", "mNextServedView", "Huawei".equals(Build.BRAND) ? "mLastSrvView" : ""};
        for (String view : viewArray) {
            if (!TextUtils.isEmpty(view)) {
                try {
                    Field filed = inputMethodManager.getClass().getDeclaredField(view);
                    if (!filed.isAccessible()) {
                        filed.setAccessible(true);
                    }
                    Object filedObject = filed.get(inputMethodManager);
                    if (filedObject != null && (filedObject instanceof View)) {
                        View fileView = (View) filedObject;
                        if (fileView.getContext() == destContext) {
                            filed.set(inputMethodManager, null);
                        }
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }
    }
}