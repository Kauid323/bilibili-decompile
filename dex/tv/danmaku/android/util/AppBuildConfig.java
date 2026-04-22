package tv.danmaku.android.util;

import android.app.Activity;
import android.content.Context;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: AppBuildConfig.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/android/util/AppBuildConfig;", "", "<init>", "()V", "Companion", "base_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppBuildConfig {
    private static final String ANDROID = "android";
    private static final String ANDROID_B = "android_b";
    private static final String ANDROID_HD = "android_hd";
    public static final Companion Companion = new Companion(null);
    private static boolean debug;

    /* compiled from: AppBuildConfig.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ltv/danmaku/android/util/AppBuildConfig$Companion;", "", "<init>", "()V", "ANDROID", "", "ANDROID_B", "ANDROID_HD", "isBlueApp", "", "context", "Landroid/content/Context;", "isPinkApp", "isHDApp", "getMobiApp", "getBuglyAppId", "getNeuronAppId", "", "getInfoEyeAppId", "debug", "getDebug$annotations", "getDebug", "()Z", "setDebug", "(Z)V", "base_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDebug$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isBlueApp(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Intrinsics.areEqual(AppBuildConfig.ANDROID_B, getMobiApp(context));
        }

        @JvmStatic
        public final boolean isPinkApp(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Intrinsics.areEqual(AppBuildConfig.ANDROID, getMobiApp(context));
        }

        @JvmStatic
        public final boolean isHDApp(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Intrinsics.areEqual(AppBuildConfig.ANDROID_HD, getMobiApp(context));
        }

        @JvmStatic
        public final boolean isHDApp() {
            Activity it = BiliContext.topActivitiy();
            if (it != null) {
                return Intrinsics.areEqual(AppBuildConfig.ANDROID_HD, AppBuildConfig.Companion.getMobiApp(it));
            }
            return false;
        }

        @JvmStatic
        public final String getMobiApp(Context context) {
            return FoundationAlias.getFapps().getMetaData().getString("MOBI_APP");
        }

        @JvmStatic
        public final String getBuglyAppId(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return FoundationAlias.getFapps().getMetaData().getString("BUGLY_APPID");
        }

        @Deprecated(message = "deprecated with com.bilibili.lib.foundation.fapps.neuronAppId")
        @JvmStatic
        public final int getNeuronAppId(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Integer.parseInt(FoundationAlias.getFapps().getNeuronAppId());
        }

        @JvmStatic
        public final int getInfoEyeAppId(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return FoundationAlias.getFapps().getMetaData().getInt("INFOEYE_APPID");
        }

        public final boolean getDebug() {
            return AppBuildConfig.debug;
        }

        public final void setDebug(boolean z) {
            AppBuildConfig.debug = z;
        }
    }

    @JvmStatic
    public static final boolean isBlueApp(Context context) {
        return Companion.isBlueApp(context);
    }

    @JvmStatic
    public static final boolean isPinkApp(Context context) {
        return Companion.isPinkApp(context);
    }

    @JvmStatic
    public static final boolean isHDApp(Context context) {
        return Companion.isHDApp(context);
    }

    @JvmStatic
    public static final boolean isHDApp() {
        return Companion.isHDApp();
    }

    @JvmStatic
    public static final String getMobiApp(Context context) {
        return Companion.getMobiApp(context);
    }

    @JvmStatic
    public static final String getBuglyAppId(Context context) {
        return Companion.getBuglyAppId(context);
    }

    @Deprecated(message = "deprecated with com.bilibili.lib.foundation.fapps.neuronAppId")
    @JvmStatic
    public static final int getNeuronAppId(Context context) {
        return Companion.getNeuronAppId(context);
    }

    @JvmStatic
    public static final int getInfoEyeAppId(Context context) {
        return Companion.getInfoEyeAppId(context);
    }

    public static final boolean getDebug() {
        return Companion.getDebug();
    }

    public static final void setDebug(boolean z) {
        Companion.setDebug(z);
    }
}