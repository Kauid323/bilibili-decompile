package tv.danmaku.bili.ui.garb.view;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import java.lang.Character;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\bJ\u001c\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\bJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/garb/view/Utils;", "", "<init>", "()V", "notEmpty", "", "T", "list", "", "isEmpty", "px2dip", "", "context", "Landroid/content/Context;", "pxValue", "", "dip2px", "dipValue", "px2sp", "sp2px", "spValue", "getWindowWidth", "Landroid/app/Activity;", "getWindowHeight", "isChinese", "c", "", "strName", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Utils {
    public static final int $stable = 0;
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public final <T> boolean notEmpty(List<? extends T> list) {
        return !isEmpty(list);
    }

    public final <T> boolean isEmpty(List<? extends T> list) {
        return list == null || list.size() == 0;
    }

    public final int px2dip(Context context, float pxValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((pxValue / scale) + 0.5f);
    }

    public final int dip2px(Context context, float dipValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dipValue * scale) + 0.5f);
    }

    public final int px2sp(Context context, float pxValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) ((pxValue / fontScale) + 0.5f);
    }

    public final int sp2px(Context context, float spValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) ((spValue * fontScale) + 0.5f);
    }

    public final int getWindowWidth(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.widthPixels;
    }

    public final int getWindowHeight(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.heightPixels;
    }

    private final boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION;
    }

    public final boolean isChinese(String strName) {
        Intrinsics.checkNotNullParameter(strName, "strName");
        char[] ch = strName.toCharArray();
        Intrinsics.checkNotNullExpressionValue(ch, "toCharArray(...)");
        for (char c : ch) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }
}