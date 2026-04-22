package tv.danmaku.bili.ui.splash.ad.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.WindowManagerHelper;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashLocalInfoHelper.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/util/SplashLocalInfoHelper;", "", "<init>", "()V", "TAG", "", "SCREEN_SIZE_SPLIT", "PREF_KEY_DEVICE_SIZE", "DATE_TIME_2", "getDeviceSize", "Landroid/graphics/Point;", "readDeviceSize", "context", "Landroid/content/Context;", "saveDeviceSize", "", "point", "isInMultiWindow", "", "activity", "Landroid/app/Activity;", "isBirthday", "dateString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashLocalInfoHelper {
    public static final int $stable = 0;
    private static final String DATE_TIME_2 = "yyyy-MM-dd";
    public static final SplashLocalInfoHelper INSTANCE = new SplashLocalInfoHelper();
    private static final String PREF_KEY_DEVICE_SIZE = "splash_image_req_screen_size";
    private static final String SCREEN_SIZE_SPLIT = "-";
    private static final String TAG = "[Splash]BusinessSplashUiHelper";

    private SplashLocalInfoHelper() {
    }

    @JvmStatic
    public static final Point getDeviceSize() {
        Point curWindowSize;
        Application context = BiliContext.application();
        Intrinsics.checkNotNull(context);
        Point recordSize = INSTANCE.readDeviceSize(context);
        try {
            Point displayRealSize = WindowManagerHelper.getDisplayRealSize(context);
            Intrinsics.checkNotNullExpressionValue(displayRealSize, "getDisplayRealSize(...)");
            curWindowSize = displayRealSize;
        } catch (Exception e) {
            curWindowSize = new Point();
            BLog.e(TAG, "getDeviceSize error = " + e.getMessage());
        }
        if (recordSize != null && recordSize.x >= curWindowSize.x && recordSize.y >= curWindowSize.y) {
            return recordSize;
        }
        Activity topActivity = BiliContext.topActivitiy();
        if (topActivity != null && !INSTANCE.isInMultiWindow(topActivity)) {
            INSTANCE.saveDeviceSize(context, curWindowSize);
        }
        int width = Math.min(curWindowSize.x, curWindowSize.y);
        int height = Math.max(curWindowSize.x, curWindowSize.y);
        BLog.i(TAG, "device width: " + width + ", height: " + height);
        return curWindowSize;
    }

    private final Point readDeviceSize(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        try {
            String sizeStr = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2).getString(PREF_KEY_DEVICE_SIZE, "");
            if (TextUtils.isEmpty(sizeStr)) {
                return null;
            }
            Intrinsics.checkNotNull(sizeStr);
            Collection $this$toTypedArray$iv = new Regex(SCREEN_SIZE_SPLIT).split(sizeStr, 0);
            String[] sizes = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            return new Point(Integer.parseInt(sizes[0]), Integer.parseInt(sizes[1]));
        } catch (Exception e) {
            return null;
        }
    }

    private final void saveDeviceSize(Context context, Point point) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        String size = point.x + SCREEN_SIZE_SPLIT + point.y;
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2).edit().putString(PREF_KEY_DEVICE_SIZE, size).apply();
    }

    private final boolean isInMultiWindow(Activity activity) {
        return Build.VERSION.SDK_INT >= 24 && activity != null && activity.isInMultiWindowMode();
    }

    @JvmStatic
    public static final boolean isBirthday(String dateString) {
        String str = dateString;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_2, Locale.US);
            Calendar time = Calendar.getInstance();
            Date birthDate = sdf.parse(dateString);
            if (birthDate == null) {
                return false;
            }
            time.setTime(birthDate);
            int thenMonth = time.get(2);
            int thenMonthDay = time.get(5);
            time.setTimeInMillis(System.currentTimeMillis());
            if (thenMonth == time.get(2)) {
                if (thenMonthDay == time.get(5)) {
                    return true;
                }
            }
            return false;
        } catch (ParseException e) {
            return false;
        }
    }
}