package tv.danmaku.bili.update.utils;

import android.app.Activity;
import android.content.Context;
import android.net.NetworkInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.internal.network.connectivity.Connectivity;
import tv.danmaku.bili.update.internal.network.connectivity.ConnectivityManagerHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CommonUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0013\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0086\b\u001a\u0011\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a\t\u0010\u0007\u001a\u00020\bH\u0086\b\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0080\b\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\b\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"invalid", "", "activity", "Landroid/app/Activity;", "isInWifi", "context", "Landroid/content/Context;", "currentTimeMillis", "", "DF", "Ljava/text/SimpleDateFormat;", "printTimestamp", "", "millis", "isThisWeek", "ts", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CommonUtilsKt {
    private static final SimpleDateFormat DF = new SimpleDateFormat("MM-dd-HH:mm:ss", Locale.getDefault());

    public static final /* synthetic */ SimpleDateFormat access$getDF$p() {
        return DF;
    }

    public static final boolean invalid(Activity activity) {
        return activity == null || activity.isFinishing();
    }

    public static final boolean isInWifi(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NetworkInfo info = Connectivity.getActiveNetworkInfo(context);
        return Connectivity.isConnectedWifi(info) && !ConnectivityManagerHelper.isActiveNetworkMetered(context);
    }

    public static final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static final String printTimestamp(long millis) {
        String format = DF.format(Long.valueOf(millis));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final boolean isThisWeek(long ts) {
        Calendar current = Calendar.getInstance();
        int week = current.get(3);
        int year = current.get(1);
        Calendar target = Calendar.getInstance();
        target.setTimeInMillis(ts);
        int targetWeek = target.get(3);
        int targetYear = target.get(1);
        return week == targetWeek && year == targetYear;
    }
}