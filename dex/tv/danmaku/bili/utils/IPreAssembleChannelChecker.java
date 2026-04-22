package tv.danmaku.bili.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.droid.SystemProperties;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: IPreAssembleChannelChecker.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001:\u000f\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "", "getPreAssembleChannel", "", "getChannelFromFile", "fileDir", "fileName", "filePath", "Builder", "XIAOMIPreAssembleChannelChecker", "VIVOPreAssembleChannelChecker", "OPPOPreAssembleChannelChecker", "HUAWEIPreAssembleChannelChecker", "SAMSUNGPreAssembleChannelChecker", "BLACKSHARKPreAssembleChannelChecker", "NUBIAPreAssembleChannelChecker", "MEIZUPreAssembleChannelChecker", "CoolpadPreAssembleChannelChecker", "ZTEPreAssembleChannelChecker", "COOSEAPreAssembleChannelChecker", "ZHUOYIPreAssembleChannelChecker", "SONYAPreAssembleChannelChecker", "LenovoPreAssembleChannelChecker", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPreAssembleChannelChecker {
    String getChannelFromFile(String str);

    String getChannelFromFile(String str, String str2);

    String getPreAssembleChannel();

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J)\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001c\"\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\rH\u0002R\u0010\u0010!\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$Builder;", "", "<init>", "()V", "setApkChannel", "channel", "", "setContext", "context", "Landroid/content/Context;", "build", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "isXIAOMI", "", "isLenovo", "isVIVO", "isOPPO", "isHUAWEI", "isSAMSUNG", "isHONOR", "isBLACKSHARK", "isNUBIA", "isSONY", "isMeizu", "isCoolPad", "isZTE", "isPreassemble", "devices", "", "(Ljava/lang/String;[Ljava/lang/String;)Z", "isHuaweiByExtraCheck", "isCOOSEA", "isZHUOYI", "device", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Builder {
        private static final String COOSEA_PROPERTY_A = "ro.odm.cust";
        private static final String COOSEA_PROPERTY_B = "ro.prize_customer";
        private static final String EMUI_PROPERTY = "ro.build.version.emui";
        private static final String HARMONYOS_PROPERTY = "hw_sc.build.platform.version";
        private static final String TAG_BLACKSHARK = "blackshark";
        private static final String TAG_COOLPAD = "coolpad";
        private static final String TAG_COOLPAD_M = "yulong";
        private static final String TAG_COOSEA = "coosea";
        private static final String TAG_HONOR = "honor";
        private static final String TAG_HUAWEI = "huawei";
        private static final String TAG_HUAWEI_TNN = "tianyi";
        private static final String TAG_LENOVO = "lenovo";
        private static final String TAG_MEITU = "meitu";
        private static final String TAG_MEIZU = "meizu";
        private static final String TAG_MEIZU_A = "rda";
        private static final String TAG_MEIZU_B = "sprd";
        private static final String TAG_MOTOROLA = "motorola";
        private static final String TAG_NUBIA = "nubia";
        private static final String TAG_ONEPlUS = "oneplus";
        private static final String TAG_OPPO = "oppo";
        private static final String TAG_REALME = "realme";
        private static final String TAG_REDMI = "redmi";
        private static final String TAG_SAMSUNG = "samsung";
        private static final String TAG_SONY = "sony";
        private static final String TAG_VIVO = "vivo";
        private static final String TAG_XIAOMI = "xiaomi";
        private static final String TAG_ZHUOYI = "zhuoyi";
        private static final String TAG_ZTE = "zte";
        private static final String ZHUOYI_LABEL = "FreemeOS";
        private static final String ZHUOYI_PROPERTY = "ro.build.freeme.label";
        private String channel;
        private Context context;
        private String device;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public Builder() {
            String str = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            this.device = lowerCase;
        }

        /* compiled from: IPreAssembleChannelChecker.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$Builder$Companion;", "", "<init>", "()V", "TAG_XIAOMI", "", "TAG_REDMI", "TAG_MEITU", "TAG_VIVO", "TAG_OPPO", "TAG_ONEPlUS", "TAG_REALME", "TAG_HUAWEI", "TAG_HUAWEI_TNN", "EMUI_PROPERTY", "HARMONYOS_PROPERTY", "TAG_SAMSUNG", "TAG_HONOR", "TAG_BLACKSHARK", "TAG_NUBIA", "TAG_SONY", "TAG_LENOVO", "TAG_MOTOROLA", "TAG_MEIZU_A", "TAG_MEIZU_B", "TAG_MEIZU", "TAG_COOLPAD", "TAG_COOLPAD_M", "TAG_ZTE", "TAG_COOSEA", "COOSEA_PROPERTY_A", "COOSEA_PROPERTY_B", "TAG_ZHUOYI", "ZHUOYI_PROPERTY", "ZHUOYI_LABEL", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final Builder setApkChannel(String channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            return this;
        }

        public final Builder setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            return this;
        }

        public final IPreAssembleChannelChecker build() {
            if (isXIAOMI()) {
                XIAOMIPreAssembleChannelChecker target = new XIAOMIPreAssembleChannelChecker();
                Context context = this.context;
                Intrinsics.checkNotNull(context);
                target.setContext(context);
                return target;
            } else if (isVIVO()) {
                return new VIVOPreAssembleChannelChecker();
            } else {
                if (isOPPO()) {
                    return new OPPOPreAssembleChannelChecker();
                }
                if (isHUAWEI()) {
                    return new HUAWEIPreAssembleChannelChecker();
                }
                if (isSAMSUNG()) {
                    return new SAMSUNGPreAssembleChannelChecker();
                }
                if (isHONOR()) {
                    return new HUAWEIPreAssembleChannelChecker();
                }
                if (isBLACKSHARK()) {
                    return new BLACKSHARKPreAssembleChannelChecker();
                }
                if (isNUBIA()) {
                    return new NUBIAPreAssembleChannelChecker();
                }
                if (isSONY()) {
                    return new SONYAPreAssembleChannelChecker();
                }
                if (isLenovo()) {
                    return new LenovoPreAssembleChannelChecker();
                }
                if (isMeizu()) {
                    return new MEIZUPreAssembleChannelChecker();
                }
                if (isCoolPad()) {
                    return new CoolpadPreAssembleChannelChecker();
                }
                if (isZTE()) {
                    return new ZTEPreAssembleChannelChecker();
                }
                if (isHuaweiByExtraCheck()) {
                    return new HUAWEIPreAssembleChannelChecker();
                }
                if (isCOOSEA()) {
                    return new COOSEAPreAssembleChannelChecker();
                }
                if (isZHUOYI()) {
                    return new ZHUOYIPreAssembleChannelChecker();
                }
                return null;
            }
        }

        private final boolean isXIAOMI() {
            return isPreassemble(TAG_XIAOMI, TAG_XIAOMI, TAG_REDMI, TAG_MEITU);
        }

        private final boolean isLenovo() {
            return isPreassemble(TAG_LENOVO, TAG_LENOVO, TAG_MOTOROLA);
        }

        private final boolean isVIVO() {
            return isPreassemble(TAG_VIVO, TAG_VIVO);
        }

        private final boolean isOPPO() {
            return isPreassemble(TAG_OPPO, TAG_OPPO, TAG_REALME, TAG_ONEPlUS);
        }

        private final boolean isHUAWEI() {
            return isPreassemble(TAG_HUAWEI, TAG_HUAWEI, TAG_HONOR, TAG_HUAWEI_TNN);
        }

        private final boolean isSAMSUNG() {
            return isPreassemble("sanxing", TAG_SAMSUNG);
        }

        private final boolean isHONOR() {
            return isPreassemble("rongyao", TAG_HONOR);
        }

        private final boolean isBLACKSHARK() {
            return isPreassemble("heisha", TAG_BLACKSHARK);
        }

        private final boolean isNUBIA() {
            return isPreassemble("nby", TAG_NUBIA);
        }

        private final boolean isSONY() {
            return isPreassemble(TAG_SONY, TAG_SONY);
        }

        private final boolean isMeizu() {
            return isPreassemble(TAG_MEIZU, TAG_MEIZU_A, TAG_MEIZU_B);
        }

        private final boolean isCoolPad() {
            return isPreassemble(TAG_COOLPAD, TAG_COOLPAD_M) || isPreassemble(TAG_COOLPAD, TAG_COOLPAD) || isPreassemble("master", TAG_COOLPAD);
        }

        private final boolean isZTE() {
            return isPreassemble("zhongxing", TAG_ZTE);
        }

        private final boolean isPreassemble(String channel, String... devices) {
            String str = this.channel;
            Intrinsics.checkNotNull(str);
            boolean z = true;
            boolean condition = StringsKt.contains(str, channel, true);
            boolean isDevice = false;
            for (String it : devices) {
                isDevice = isDevice || StringsKt.equals(it, this.device, true);
            }
            boolean condition2 = (condition && isDevice) ? false : false;
            BLog.e("preassemble isPreassemble=" + condition2 + ", channel=" + channel);
            Log.e("preassemble", "channel " + channel + "devices " + devices + " preassemble isPreassemble=" + condition2);
            return condition2;
        }

        private final boolean isHuaweiByExtraCheck() {
            String str = this.channel;
            Intrinsics.checkNotNull(str);
            boolean condition = true;
            boolean condition2 = StringsKt.contains(str, TAG_HUAWEI, true);
            String emuiVersion = SystemProperties.get(EMUI_PROPERTY);
            Intrinsics.checkNotNullExpressionValue(emuiVersion, "get(...)");
            String harmonyVersion = SystemProperties.get(HARMONYOS_PROPERTY);
            Intrinsics.checkNotNullExpressionValue(harmonyVersion, "get(...)");
            boolean isHuawei = (TextUtils.isEmpty(emuiVersion) && TextUtils.isEmpty(harmonyVersion)) ? false : true;
            BLog.e("preassemble isHuaweiPhone=" + isHuawei + ", condition = " + condition2 + ", emuiVersion = " + emuiVersion + ", harmonyVersion = " + harmonyVersion);
            Log.e("preassemble", "preassemble isHuaweiPhone=" + isHuawei + ", condition = " + condition2 + ", emuiVersion = " + emuiVersion + ", harmonyVersion = " + harmonyVersion);
            if (!condition2 || !isHuawei) {
                condition = false;
            }
            return condition;
        }

        private final boolean isCOOSEA() {
            String str = this.channel;
            Intrinsics.checkNotNull(str);
            boolean condition = true;
            boolean condition2 = StringsKt.contains(str, TAG_COOSEA, true);
            String cooseaA = SystemProperties.get(COOSEA_PROPERTY_A);
            Intrinsics.checkNotNullExpressionValue(cooseaA, "get(...)");
            String cooseaB = SystemProperties.get(COOSEA_PROPERTY_B);
            Intrinsics.checkNotNullExpressionValue(cooseaB, "get(...)");
            boolean isCoosea = TextUtils.equals(cooseaA, TAG_COOSEA) || TextUtils.equals(cooseaB, TAG_COOSEA);
            BLog.e("preassemble isCoosea=" + isCoosea + ", condition = " + condition2 + ", cooseaA = " + cooseaA + ", cooseaB = " + cooseaB);
            Log.e("preassemble", "preassemble isCoosea=" + isCoosea + ", condition = " + condition2 + ", cooseaA = " + cooseaA + ", cooseaB = " + cooseaB);
            if (!condition2 || !isCoosea) {
                condition = false;
            }
            return condition;
        }

        private final boolean isZHUOYI() {
            String str = this.channel;
            Intrinsics.checkNotNull(str);
            boolean condition = true;
            boolean condition2 = StringsKt.contains(str, TAG_ZHUOYI, true);
            String zhuoyi = SystemProperties.get(ZHUOYI_PROPERTY);
            Intrinsics.checkNotNullExpressionValue(zhuoyi, "get(...)");
            boolean isZhuoyi = TextUtils.equals(zhuoyi, ZHUOYI_LABEL);
            BLog.e("preassemble isZhuoyi=" + isZhuoyi + ", condition = " + condition2 + ", zhuoyi = " + zhuoyi);
            Log.e("preassemble", "preassemble isZhuoyi=" + isZhuoyi + ", condition = " + condition2 + ", zhuoyi = " + zhuoyi);
            return (condition2 && isZhuoyi) ? false : false;
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$XIAOMIPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "setContext", "", "context", "Landroid/content/Context;", "getMIUIChannel", "pkg", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class XIAOMIPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        private Context context;

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            String channel = getMIUIChannel(packageName);
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        public final void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        private final String getMIUIChannel(String pkg) {
            try {
                Class miui = Class.forName("miui.os.MiuiInit");
                Method method = miui.getMethod("getMiuiChannelPath", String.class);
                Object invoke = method.invoke(null, pkg);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
                String result = (String) invoke;
                if (TextUtils.isEmpty(result)) {
                    return "";
                }
                String channel = getChannelFromFile(result);
                Log.e("preassemble", "preassemble getMIUIChannel from " + result + " channel is " + channel);
                return channel;
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    /* renamed from: tv.danmaku.bili.utils.IPreAssembleChannelChecker$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static String $default$getChannelFromFile(IPreAssembleChannelChecker _this, String fileDir, String fileName) {
            Intrinsics.checkNotNullParameter(fileDir, "fileDir");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            if (!TextUtils.isEmpty(fileDir)) {
                String filePath = fileDir + File.separator + fileName;
                return _this.getChannelFromFile(filePath);
            }
            return "";
        }

        public static String $default$getChannelFromFile(IPreAssembleChannelChecker _this, String filePath) {
            String obj;
            String replace$default;
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            String channel = FileUtils.string(filePath);
            String channel2 = (channel == null || (obj = StringsKt.trim(channel).toString()) == null || (replace$default = StringsKt.replace$default(obj, VideoFile.TREE_END, "", false, 4, (Object) null)) == null) ? null : StringsKt.replace$default(replace$default, "\r", "", false, 4, (Object) null);
            BLog.d("preassemble channel from " + filePath + " is " + channel2);
            Intrinsics.checkNotNull(channel2);
            return channel2;
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$VIVOPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getVIVOChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class VIVOPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getVIVOChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getVIVOChannel() {
            try {
                String fileDir = SystemProperties.get("ro.preinstall.path");
                Intrinsics.checkNotNullExpressionValue(fileDir, "get(...)");
                return getChannelFromFile(fileDir, "vivo_bili_channel.txt");
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$OPPOPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getOPPOChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class OPPOPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getOPPOChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getOPPOChannel() {
            try {
                return getChannelFromFile("/data/etc/appchannel", "oppo_bili_channel.txt");
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$HUAWEIPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class HUAWEIPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = SystemProperties.get("ro.channel.tv.danmaku.bili");
            Intrinsics.checkNotNullExpressionValue(channel, "get(...)");
            if (TextUtils.isEmpty(channel)) {
                channel = "";
            }
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$SAMSUNGPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getSAMSUNGChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class SAMSUNGPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getSAMSUNGChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getSAMSUNGChannel() {
            try {
                return getChannelFromFile("/system/etc", "samsung_bili_channel.txt");
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$BLACKSHARKPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getBLACKSHARKChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class BLACKSHARKPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getBLACKSHARKChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getBLACKSHARKChannel() {
            try {
                return getChannelFromFile("/system/etc", "blackshark_bili_channel.txt");
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$NUBIAPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getNUBIAChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class NUBIAPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getNUBIAChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getNUBIAChannel() {
            try {
                return getChannelFromFile("/system/etc", "nubia_bili_channel.txt");
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$MEIZUPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class MEIZUPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getChannel() {
            try {
                return getChannelFromFile("/system/etc", "meizu_bili_channel.txt");
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$CoolpadPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class CoolpadPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getChannel() {
            try {
                return getChannelFromFile("/system/etc", "coolpad_bili_channel.txt");
            } catch (Exception ignore) {
                BLog.e("获取失败预装渠道信息失败:" + ignore.getMessage());
                ignore.printStackTrace();
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$ZTEPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class ZTEPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getChannel() {
            try {
                return getChannelFromFile("/system/etc", "zte_bili_channel.txt");
            } catch (Exception ignore) {
                BLog.e("获取失败预装渠道信息失败:" + ignore.getMessage());
                ignore.printStackTrace();
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$COOSEAPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class COOSEAPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getChannel() {
            try {
                return getChannelFromFile("/system/etc", "coosea_bili_channel.txt");
            } catch (Exception ignore) {
                BLog.e("获取失败预装渠道信息失败:" + ignore.getMessage());
                ignore.printStackTrace();
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$ZHUOYIPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "getChannel", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class ZHUOYIPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = getChannel();
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }

        private final String getChannel() {
            try {
                return getChannelFromFile("/system/etc", "zhuoyi_bili_channel.txt");
            } catch (Exception ignore) {
                BLog.e("获取失败预装渠道信息失败:" + ignore.getMessage());
                ignore.printStackTrace();
                return "";
            }
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$SONYAPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class SONYAPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = "";
            try {
                channel = getChannelFromFile("/oem/deletable-app", "sony_bili_channel.txt");
            } catch (Exception e) {
            }
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }
    }

    /* compiled from: IPreAssembleChannelChecker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/utils/IPreAssembleChannelChecker$LenovoPreAssembleChannelChecker;", "Ltv/danmaku/bili/utils/IPreAssembleChannelChecker;", "<init>", "()V", "getPreAssembleChannel", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class LenovoPreAssembleChannelChecker implements IPreAssembleChannelChecker {
        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str) {
            return CC.$default$getChannelFromFile(this, str);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public /* synthetic */ String getChannelFromFile(String str, String str2) {
            return CC.$default$getChannelFromFile(this, str, str2);
        }

        @Override // tv.danmaku.bili.utils.IPreAssembleChannelChecker
        public String getPreAssembleChannel() {
            String channel = "";
            try {
                channel = getChannelFromFile("/product/etc", "lenovo_bili_channel.txt");
            } catch (Exception e) {
            }
            if (TextUtils.isEmpty(channel)) {
                try {
                    channel = getChannelFromFile("/system/etc", "lenovo_bili_channel.txt");
                } catch (Exception e2) {
                }
            }
            BLog.e("preassemble channel=" + channel);
            Log.e("preassemble", "preassemble channel=" + channel);
            return channel;
        }
    }
}