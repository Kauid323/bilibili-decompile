package kntr.app.ad.domain.platformspec;

import kntr.app.ad.common.utils.StringExt_androidKt;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.report.SubmitActionFrom;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.appinfo.KAppInfo;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kntr.base.device.ScreenDimensions;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdPlatformSpec.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001gB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R/\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\fR\u0016\u0010!\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\fR\u0016\u0010#\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\fR\u0016\u0010%\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\fR\u0016\u0010'\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\fR\u0016\u0010)\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\fR\u0016\u0010+\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\fR\u0014\u0010-\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\fR\u0014\u0010/\u001a\u000200X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u00103\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\fR\u0016\u00105\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\fR\u0016\u00107\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\fR\u0016\u00109\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\fR\u0016\u0010;\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\fR\u0016\u0010=\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\fR\u0016\u0010?\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\fR\u0016\u0010A\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\fR\u0016\u0010C\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\fR\u0016\u0010E\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\fR\u0016\u0010G\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\fR\u0016\u0010I\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\fR\u0016\u0010K\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\fR\u0016\u0010M\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\fR\u0016\u0010O\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\fR\u0016\u0010Q\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\fR\u0016\u0010S\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\fR\u0016\u0010U\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\fR\u0016\u0010W\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\fR\u0016\u0010Y\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\fR\u0016\u0010[\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\fR\u0016\u0010]\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\fR\u0011\u0010_\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b`\u0010\fR\u0011\u0010a\u001a\u00020b8F¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0011\u0010e\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\bf\u00102¨\u0006h"}, d2 = {"Lkntr/app/ad/domain/platformspec/AdPlatformSpec;", "Lkntr/app/ad/domain/platformspec/IAdPlatformSpec;", "<init>", "()V", "cache", "Lkntr/app/ad/domain/platformspec/AdPlatformSpec$Cache;", "provider", "Lkntr/app/ad/domain/platformspec/IAdPlatformSpecProvider;", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "webUa", "getWebUa", "()Ljava/lang/String;", "setWebUa", "(Ljava/lang/String;)V", "webUa$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "init", RoomRecommendViewModel.EMPTY_CURSOR, "uaWeb", "getUaWeb", "uaSys", "getUaSys", "bootMark", "getBootMark", "updateMark", "getUpdateMark", "networkV2", "getNetworkV2", ReportBuildInParam.NETWORK, "getNetwork", "userApps", "getUserApps", "storyShownIds", "getStoryShownIds", "dnsClientIp", "getDnsClientIp", "wxSdkVer", "getWxSdkVer", ReportBuildInParam.LNG, "getLng", ReportBuildInParam.LAT, "getLat", "lbsTs", "getLbsTs", "mobiApp", "getMobiApp", ReportBuildInParam.BUILD, RoomRecommendViewModel.EMPTY_CURSOR, "getBuild", "()I", ReportBuildInParam.MODEL, "getModel", "carrierName", "getCarrierName", "manufacturer", "getManufacturer", "osV", "getOsV", "screenSize", "getScreenSize", "androidId", "getAndroidId", ReportBuildInParam.IMEI, "getImei", ReportBuildInParam.OAID, "getOaid", "gameId", "getGameId", "wifiMacAddress", "getWifiMacAddress", ReportBuildInParam.BOOT_TIME_IN_SEC, "getBootTimeInSec", ReportBuildInParam.SYS_FILE_TIME, "getSysFileTime", "initialTime", "getInitialTime", "hardwareModel", "getHardwareModel", ReportBuildInParam.COUNTRY_CODE, "getCountryCode", ReportBuildInParam.DEVICE_NAME, "getDeviceName", ReportBuildInParam.LANGUAGE, "getLanguage", ReportBuildInParam.IDFA, "getIdfa", ReportBuildInParam.MACHINE, "getMachine", "totalDiskCapacity", "getTotalDiskCapacity", "totalMemory", "getTotalMemory", "timeZoneOffset", "getTimeZoneOffset", ReportBuildInParam.BUVID, "getBuvid", ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "getMid", "()J", ReportBuildInParam.OS, "getOs", "Cache", "platformspec_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdPlatformSpec implements IAdPlatformSpec {
    private static final int build;
    private static final String mobiApp;
    private static final int os;
    private static IAdPlatformSpecProvider provider;
    private static final SerializableSharedPreferencesProperty webUa$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(AdPlatformSpec.class, "webUa", "getWebUa()Ljava/lang/String;", 0))};
    public static final AdPlatformSpec INSTANCE = new AdPlatformSpec();
    private static final Cache cache = new Cache();

    /* compiled from: AdPlatformSpec.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.Android.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DeviceType.iOS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DeviceType.HarmonyOS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AdPlatformSpec() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdPlatformSpec.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\bP\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001c\u0010(\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001c\u0010+\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001c\u00101\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\u001c\u00104\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001c\u00107\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001c\u0010:\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR\u001c\u0010=\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR\u001c\u0010@\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0007\"\u0004\bB\u0010\tR\u001c\u0010C\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR\u001c\u0010F\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR\u001c\u0010I\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\tR\u001c\u0010L\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0007\"\u0004\bN\u0010\tR\u001c\u0010O\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR\u001c\u0010R\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0007\"\u0004\bT\u0010\t¨\u0006U"}, d2 = {"Lkntr/app/ad/domain/platformspec/AdPlatformSpec$Cache;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "uaWeb", RoomRecommendViewModel.EMPTY_CURSOR, "getUaWeb", "()Ljava/lang/String;", "setUaWeb", "(Ljava/lang/String;)V", "uaSys", "getUaSys", "setUaSys", "bootMark", "getBootMark", "setBootMark", "updateMark", "getUpdateMark", "setUpdateMark", "wxSdkVer", "getWxSdkVer", "setWxSdkVer", "androidId", "getAndroidId", "setAndroidId", ReportBuildInParam.IMEI, "getImei", "setImei", "gameId", "getGameId", "setGameId", "wifiMacAddress", "getWifiMacAddress", "setWifiMacAddress", "totalDiskCapacity", "getTotalDiskCapacity", "setTotalDiskCapacity", "totalMemory", "getTotalMemory", "setTotalMemory", "screenSize", "getScreenSize", "setScreenSize", ReportBuildInParam.MODEL, "getModel", "setModel", "carrierName", "getCarrierName", "setCarrierName", "manufacturer", "getManufacturer", "setManufacturer", "systemVersion", "getSystemVersion", "setSystemVersion", "hardwareModel", "getHardwareModel", "setHardwareModel", "timeZoneOffset", "getTimeZoneOffset", "setTimeZoneOffset", ReportBuildInParam.COUNTRY_CODE, "getCountryCode", "setCountryCode", ReportBuildInParam.DEVICE_NAME, "getDeviceName", "setDeviceName", ReportBuildInParam.LANGUAGE, "getLanguage", "setLanguage", "iosIdfa", "getIosIdfa", "setIosIdfa", "iosMachine", "getIosMachine", "setIosMachine", ReportBuildInParam.BOOT_TIME_IN_SEC, "getBootTimeInSec", "setBootTimeInSec", ReportBuildInParam.SYS_FILE_TIME, "getSysFileTime", "setSysFileTime", "initialTime", "getInitialTime", "setInitialTime", "platformspec_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Cache {
        private String androidId;
        private String bootMark;
        private String bootTimeInSec;
        private String carrierName;
        private String countryCode;
        private String deviceName;
        private String gameId;
        private String hardwareModel;
        private String imei;
        private String initialTime;
        private String iosIdfa;
        private String iosMachine;
        private String language;
        private String manufacturer;
        private String model;
        private String screenSize;
        private String sysFileTime;
        private String systemVersion;
        private String timeZoneOffset;
        private String totalDiskCapacity;
        private String totalMemory;
        private String uaSys;
        private String uaWeb;
        private String updateMark;
        private String wifiMacAddress;
        private String wxSdkVer;

        public final String getUaWeb() {
            return this.uaWeb;
        }

        public final void setUaWeb(String str) {
            this.uaWeb = str;
        }

        public final String getUaSys() {
            return this.uaSys;
        }

        public final void setUaSys(String str) {
            this.uaSys = str;
        }

        public final String getBootMark() {
            return this.bootMark;
        }

        public final void setBootMark(String str) {
            this.bootMark = str;
        }

        public final String getUpdateMark() {
            return this.updateMark;
        }

        public final void setUpdateMark(String str) {
            this.updateMark = str;
        }

        public final String getWxSdkVer() {
            return this.wxSdkVer;
        }

        public final void setWxSdkVer(String str) {
            this.wxSdkVer = str;
        }

        public final String getAndroidId() {
            return this.androidId;
        }

        public final void setAndroidId(String str) {
            this.androidId = str;
        }

        public final String getImei() {
            return this.imei;
        }

        public final void setImei(String str) {
            this.imei = str;
        }

        public final String getGameId() {
            return this.gameId;
        }

        public final void setGameId(String str) {
            this.gameId = str;
        }

        public final String getWifiMacAddress() {
            return this.wifiMacAddress;
        }

        public final void setWifiMacAddress(String str) {
            this.wifiMacAddress = str;
        }

        public final String getTotalDiskCapacity() {
            return this.totalDiskCapacity;
        }

        public final void setTotalDiskCapacity(String str) {
            this.totalDiskCapacity = str;
        }

        public final String getTotalMemory() {
            return this.totalMemory;
        }

        public final void setTotalMemory(String str) {
            this.totalMemory = str;
        }

        public final String getScreenSize() {
            return this.screenSize;
        }

        public final void setScreenSize(String str) {
            this.screenSize = str;
        }

        public final String getModel() {
            return this.model;
        }

        public final void setModel(String str) {
            this.model = str;
        }

        public final String getCarrierName() {
            return this.carrierName;
        }

        public final void setCarrierName(String str) {
            this.carrierName = str;
        }

        public final String getManufacturer() {
            return this.manufacturer;
        }

        public final void setManufacturer(String str) {
            this.manufacturer = str;
        }

        public final String getSystemVersion() {
            return this.systemVersion;
        }

        public final void setSystemVersion(String str) {
            this.systemVersion = str;
        }

        public final String getHardwareModel() {
            return this.hardwareModel;
        }

        public final void setHardwareModel(String str) {
            this.hardwareModel = str;
        }

        public final String getTimeZoneOffset() {
            return this.timeZoneOffset;
        }

        public final void setTimeZoneOffset(String str) {
            this.timeZoneOffset = str;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final void setCountryCode(String str) {
            this.countryCode = str;
        }

        public final String getDeviceName() {
            return this.deviceName;
        }

        public final void setDeviceName(String str) {
            this.deviceName = str;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final String getIosIdfa() {
            return this.iosIdfa;
        }

        public final void setIosIdfa(String str) {
            this.iosIdfa = str;
        }

        public final String getIosMachine() {
            return this.iosMachine;
        }

        public final void setIosMachine(String str) {
            this.iosMachine = str;
        }

        public final String getBootTimeInSec() {
            return this.bootTimeInSec;
        }

        public final void setBootTimeInSec(String str) {
            this.bootTimeInSec = str;
        }

        public final String getSysFileTime() {
            return this.sysFileTime;
        }

        public final void setSysFileTime(String str) {
            this.sysFileTime = str;
        }

        public final String getInitialTime() {
            return this.initialTime;
        }

        public final void setInitialTime(String str) {
            this.initialTime = str;
        }
    }

    private final String getWebUa() {
        return (String) webUa$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void setWebUa(String str) {
        webUa$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String webUa_delegate$lambda$0() {
        return null;
    }

    public final void init(IAdPlatformSpecProvider provider2) {
        String str;
        Intrinsics.checkNotNullParameter(provider2, "provider");
        provider = provider2;
        cache.setModel(KDevice.INSTANCE.getModel());
        Cache cache2 = cache;
        String it = KDevice.INSTANCE.getCarrierName();
        String str2 = it;
        boolean z = false;
        if ((str2 == null || str2.length() == 0) || Intrinsics.areEqual(it, "--")) {
            str = SubmitActionFrom.MMA_KEY_UNKNOWN;
        } else {
            str = it;
        }
        cache2.setCarrierName(str);
        cache.setManufacturer(KDevice.INSTANCE.getManufacturer());
        cache.setSystemVersion(KDevice.INSTANCE.getSystemVersion());
        Function0 screenAction = new Function0() { // from class: kntr.app.ad.domain.platformspec.AdPlatformSpec$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit init$lambda$1;
                init$lambda$1 = AdPlatformSpec.init$lambda$1();
                return init$lambda$1;
            }
        };
        switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
            case 1:
                screenAction.invoke();
                cache.setAndroidId(KDevice.INSTANCE.getAndroidId());
                cache.setImei(KDevice.INSTANCE.getAndroidImei());
                cache.setGameId(provider2.gameId());
                Cache cache3 = cache;
                String it2 = provider2.wifiMacAddress();
                String str3 = it2;
                if (str3 == null || StringsKt.isBlank(str3)) {
                    it2 = null;
                }
                if (it2 == null) {
                    it2 = "02:00:00:00:00:00";
                }
                cache3.setWifiMacAddress(it2);
                break;
            case 2:
                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new AdPlatformSpec$init$3(screenAction, null), 3, (Object) null);
                cache.setHardwareModel(KDevice.INSTANCE.getHardwareModel());
                cache.setTimeZoneOffset(String.valueOf(KDevice.INSTANCE.getTimeZoneOffset()));
                cache.setCountryCode(KDevice.INSTANCE.getCountryCode());
                cache.setDeviceName(KDevice.INSTANCE.getDeviceName());
                cache.setLanguage(KDevice.INSTANCE.getLanguage());
                cache.setIosIdfa(KDevice.INSTANCE.getIosIdfa());
                cache.setIosMachine(KDevice.INSTANCE.getIosMachine());
                cache.setBootTimeInSec(provider2.bootTimeInSec());
                cache.setSysFileTime(provider2.sysFileTime());
                cache.setInitialTime(provider2.initialTime());
                cache.setTotalDiskCapacity(String.valueOf(KDevice.INSTANCE.getTotalDiskCapacity()));
                cache.setTotalMemory(String.valueOf(KDevice.INSTANCE.getTotalMemory()));
                break;
            case 3:
                screenAction.invoke();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Cache cache4 = cache;
        String it3 = provider2.uaSys();
        String str4 = it3;
        if (str4 == null || str4.length() == 0) {
            it3 = null;
        }
        cache4.setUaSys(it3 != null ? StringExt_androidKt.urlEncode(it3) : null);
        cache.setBootMark(provider2.bootMark());
        cache.setUpdateMark(provider2.updateMark());
        cache.setWxSdkVer(provider2.wxSdkVer());
        provider2.dnsClientIp();
        cache.setUaWeb(getWebUa());
        String it4 = provider2.uaWeb();
        String str5 = it4;
        if (str5 == null || str5.length() == 0) {
            z = true;
        }
        String it5 = z ? null : it4;
        if (it5 != null) {
            Cache cache5 = cache;
            String encodeUA = StringExt_androidKt.urlEncode(it5);
            INSTANCE.setWebUa(encodeUA);
            cache5.setUaWeb(encodeUA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$1() {
        Cache cache2 = cache;
        ScreenDimensions it = KDevice.INSTANCE.getScreenDimensions();
        int height = it.getHeight();
        cache2.setScreenSize(height + "*" + it.getWidth());
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getUaWeb() {
        return cache.getUaWeb();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getUaSys() {
        return cache.getUaSys();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getBootMark() {
        return cache.getBootMark();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getUpdateMark() {
        return cache.getUpdateMark();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getNetworkV2() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        return iAdPlatformSpecProvider.networkV2();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getNetwork() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        return iAdPlatformSpecProvider.network();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getUserApps() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        return iAdPlatformSpecProvider.userApps();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getStoryShownIds() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        return iAdPlatformSpecProvider.storyShownIds();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getDnsClientIp() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        return iAdPlatformSpecProvider.dnsClientIp();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getWxSdkVer() {
        return cache.getWxSdkVer();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getLng() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        AdLocation location = iAdPlatformSpecProvider.location();
        if (location != null) {
            return location.getLng();
        }
        return null;
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getLat() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        AdLocation location = iAdPlatformSpecProvider.location();
        if (location != null) {
            return location.getLat();
        }
        return null;
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getLbsTs() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        AdLocation location = iAdPlatformSpecProvider.location();
        if (location != null) {
            return location.getTs();
        }
        return null;
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getMobiApp() {
        return mobiApp;
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public int getBuild() {
        return build;
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getModel() {
        return cache.getModel();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getCarrierName() {
        return cache.getCarrierName();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getManufacturer() {
        return cache.getManufacturer();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getOsV() {
        return cache.getSystemVersion();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getScreenSize() {
        return cache.getScreenSize();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getAndroidId() {
        return cache.getAndroidId();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getImei() {
        return cache.getImei();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getOaid() {
        IAdPlatformSpecProvider iAdPlatformSpecProvider = provider;
        if (iAdPlatformSpecProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            iAdPlatformSpecProvider = null;
        }
        return iAdPlatformSpecProvider.oaid();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getGameId() {
        return cache.getGameId();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getWifiMacAddress() {
        return cache.getWifiMacAddress();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getBootTimeInSec() {
        return cache.getBootTimeInSec();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getSysFileTime() {
        return cache.getSysFileTime();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getInitialTime() {
        return cache.getInitialTime();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getHardwareModel() {
        return cache.getHardwareModel();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getCountryCode() {
        return cache.getCountryCode();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getDeviceName() {
        return cache.getDeviceName();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getLanguage() {
        return cache.getLanguage();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getIdfa() {
        return cache.getIosIdfa();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getMachine() {
        return cache.getIosMachine();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getTotalDiskCapacity() {
        return cache.getTotalDiskCapacity();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getTotalMemory() {
        return cache.getTotalMemory();
    }

    @Override // kntr.app.ad.domain.platformspec.IAdPlatformSpec
    public String getTimeZoneOffset() {
        return cache.getTimeZoneOffset();
    }

    public final String getBuvid() {
        return KDevice.INSTANCE.getBuvid();
    }

    public final long getMid() {
        AccountState.Logged logged = (AccountState) KAccountStoreKt.getAccountHolder().getState().getValue();
        if (logged instanceof AccountState.Logged) {
            return logged.getUserInfo().getMid();
        }
        return 0L;
    }

    public final int getOs() {
        return os;
    }

    static {
        int i = 1;
        Function0 initializer$iv = new Function0() { // from class: kntr.app.ad.domain.platformspec.AdPlatformSpec$$ExternalSyntheticLambda0
            public final Object invoke() {
                String webUa_delegate$lambda$0;
                webUa_delegate$lambda$0 = AdPlatformSpec.webUa_delegate$lambda$0();
                return webUa_delegate$lambda$0;
            }
        };
        webUa$delegate = new SerializableSharedPreferencesProperty("kntr.ad.preferences", false, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), "web_ua", initializer$iv, (Function2) null);
        mobiApp = KAppInfo.INSTANCE.getMobiApp();
        build = KAppInfo.INSTANCE.getVersionCode();
        switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
            case 1:
                i = 0;
                break;
            case 2:
                break;
            case 3:
                i = 2;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        os = i;
    }
}