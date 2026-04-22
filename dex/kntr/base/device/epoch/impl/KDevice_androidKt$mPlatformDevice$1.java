package kntr.base.device.epoch.impl;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.bilibili.gripper.api.buvid.GBuvid;
import com.bilibili.gripper.api.buvid.GOaid;
import com.bilibili.lib.biliid.utils.device.PhoneIdHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import java.math.BigInteger;
import java.util.Locale;
import java.util.TimeZone;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.device.DeviceType;
import kntr.base.device.IDevice;
import kntr.base.device.ScreenDimensions;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KDevice.android.kt */
@Metadata(d1 = {"\u0000q\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \u000f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0007\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010)R\u0014\u0010.\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010)R\u0014\u00100\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010)R\u0014\u00102\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010)R\u0014\u00104\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010)R\u0016\u0010:\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010)R\u0016\u0010<\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010)R\u0014\u0010>\u001a\u00020?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010ER\u0014\u0010H\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010)R\u0016\u0010N\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010)R\u0014\u0010P\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010)R\u0014\u0010R\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010)¨\u0006T"}, d2 = {"kntr/base/device/epoch/impl/KDevice_androidKt$mPlatformDevice$1", "Lkntr/base/device/IDevice;", "gBuvid", "Lcom/bilibili/gripper/api/buvid/GBuvid;", "getGBuvid", "()Lcom/bilibili/gripper/api/buvid/GBuvid;", "gBuvid$delegate", "Lkotlin/Lazy;", "gOaid", "Lcom/bilibili/gripper/api/buvid/GOaid;", "getGOaid", "()Lcom/bilibili/gripper/api/buvid/GOaid;", "gOaid$delegate", "contentResolver", "Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "getContentResolver", "()Landroid/content/ContentResolver;", "contentResolver$delegate", "telephonyManager", "Landroid/telephony/TelephonyManager;", "getTelephonyManager", "()Landroid/telephony/TelephonyManager;", "telephonyManager$delegate", "activityManager", "Landroid/app/ActivityManager;", "getActivityManager", "()Landroid/app/ActivityManager;", "activityManager$delegate", "displayMetrics", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "()Landroid/util/DisplayMetrics;", "displayMetrics$delegate", "deviceType", "Lkntr/base/device/DeviceType;", "getDeviceType", "()Lkntr/base/device/DeviceType;", "buvid", "", "getBuvid", "()Ljava/lang/String;", "manufacturer", "getManufacturer", "model", "getModel", "hardwareModel", "getHardwareModel", "systemVersion", "getSystemVersion", "timeZone", "getTimeZone", "timeZoneOffset", "", "getTimeZoneOffset", "()I", "countryCode", "getCountryCode", "carrierName", "getCarrierName", "deviceName", "getDeviceName", "screenDimensions", "Lkntr/base/device/ScreenDimensions;", "getScreenDimensions", "()Lkntr/base/device/ScreenDimensions;", "totalDiskCapacity", "", "getTotalDiskCapacity", "()J", "totalMemory", "getTotalMemory", "language", "getLanguage", "getDirTotalCapacity", "Ljava/math/BigInteger;", "dir", "Landroid/os/StatFs;", "androidId", "getAndroidId", "androidImei", "getAndroidImei", "androidOaId", "getAndroidOaId", "device_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KDevice_androidKt$mPlatformDevice$1 implements IDevice {
    private final Lazy gBuvid$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.device.epoch.impl.KDevice_androidKt$mPlatformDevice$1$$ExternalSyntheticLambda0
        public final Object invoke() {
            GBuvid gBuvid_delegate$lambda$0;
            gBuvid_delegate$lambda$0 = KDevice_androidKt$mPlatformDevice$1.gBuvid_delegate$lambda$0();
            return gBuvid_delegate$lambda$0;
        }
    });
    private final Lazy gOaid$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.device.epoch.impl.KDevice_androidKt$mPlatformDevice$1$$ExternalSyntheticLambda1
        public final Object invoke() {
            GOaid gOaid_delegate$lambda$1;
            gOaid_delegate$lambda$1 = KDevice_androidKt$mPlatformDevice$1.gOaid_delegate$lambda$1();
            return gOaid_delegate$lambda$1;
        }
    });
    private final Lazy contentResolver$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.device.epoch.impl.KDevice_androidKt$mPlatformDevice$1$$ExternalSyntheticLambda2
        public final Object invoke() {
            ContentResolver contentResolver_delegate$lambda$2;
            contentResolver_delegate$lambda$2 = KDevice_androidKt$mPlatformDevice$1.contentResolver_delegate$lambda$2();
            return contentResolver_delegate$lambda$2;
        }
    });
    private final Lazy telephonyManager$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.device.epoch.impl.KDevice_androidKt$mPlatformDevice$1$$ExternalSyntheticLambda3
        public final Object invoke() {
            TelephonyManager telephonyManager_delegate$lambda$3;
            telephonyManager_delegate$lambda$3 = KDevice_androidKt$mPlatformDevice$1.telephonyManager_delegate$lambda$3();
            return telephonyManager_delegate$lambda$3;
        }
    });
    private final Lazy activityManager$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.device.epoch.impl.KDevice_androidKt$mPlatformDevice$1$$ExternalSyntheticLambda4
        public final Object invoke() {
            ActivityManager activityManager_delegate$lambda$4;
            activityManager_delegate$lambda$4 = KDevice_androidKt$mPlatformDevice$1.activityManager_delegate$lambda$4();
            return activityManager_delegate$lambda$4;
        }
    });
    private final Lazy displayMetrics$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.device.epoch.impl.KDevice_androidKt$mPlatformDevice$1$$ExternalSyntheticLambda5
        public final Object invoke() {
            DisplayMetrics displayMetrics_delegate$lambda$5;
            displayMetrics_delegate$lambda$5 = KDevice_androidKt$mPlatformDevice$1.displayMetrics_delegate$lambda$5();
            return displayMetrics_delegate$lambda$5;
        }
    });
    private final DeviceType deviceType = DeviceType.Android;

    @Override // kntr.base.device.IDevice
    public /* bridge */ String getIosIdfa() {
        return IDevice.CC.$default$getIosIdfa(this);
    }

    @Override // kntr.base.device.IDevice
    public /* bridge */ String getIosMachine() {
        return IDevice.CC.$default$getIosMachine(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GBuvid gBuvid_delegate$lambda$0() {
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GBuvid.class, (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        return (GBuvid) suspendProducer.get();
    }

    private final GBuvid getGBuvid() {
        return (GBuvid) this.gBuvid$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GOaid gOaid_delegate$lambda$1() {
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GOaid.class, (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        return (GOaid) suspendProducer.get();
    }

    private final GOaid getGOaid() {
        return (GOaid) this.gOaid$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentResolver contentResolver_delegate$lambda$2() {
        return FoundationAlias.getFapp().getContentResolver();
    }

    private final ContentResolver getContentResolver() {
        return (ContentResolver) this.contentResolver$delegate.getValue();
    }

    private final TelephonyManager getTelephonyManager() {
        return (TelephonyManager) this.telephonyManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TelephonyManager telephonyManager_delegate$lambda$3() {
        Object systemService = FoundationAlias.getFapp().getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return (TelephonyManager) systemService;
    }

    private final ActivityManager getActivityManager() {
        return (ActivityManager) this.activityManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityManager activityManager_delegate$lambda$4() {
        Object systemService = FoundationAlias.getFapp().getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        return (ActivityManager) systemService;
    }

    private final DisplayMetrics getDisplayMetrics() {
        return (DisplayMetrics) this.displayMetrics$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisplayMetrics displayMetrics_delegate$lambda$5() {
        return FoundationAlias.getFapp().getResources().getDisplayMetrics();
    }

    @Override // kntr.base.device.IDevice
    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    @Override // kntr.base.device.IDevice
    public String getBuvid() {
        return getGBuvid().getBuvid();
    }

    @Override // kntr.base.device.IDevice
    public String getManufacturer() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return str;
    }

    @Override // kntr.base.device.IDevice
    public String getModel() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return str;
    }

    @Override // kntr.base.device.IDevice
    public String getHardwareModel() {
        String str = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(str, "HARDWARE");
        return str;
    }

    @Override // kntr.base.device.IDevice
    public String getSystemVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
        return str;
    }

    @Override // kntr.base.device.IDevice
    public String getTimeZone() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
        return id;
    }

    @Override // kntr.base.device.IDevice
    public int getTimeZoneOffset() {
        int offsetMillis = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        return offsetMillis / MediaAttrUtils.TYPE_PAY_SEASON;
    }

    @Override // kntr.base.device.IDevice
    public String getCountryCode() {
        return Locale.getDefault().getCountry();
    }

    @Override // kntr.base.device.IDevice
    public String getCarrierName() {
        try {
            return getTelephonyManager().getNetworkOperatorName();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // kntr.base.device.IDevice
    public String getDeviceName() {
        String bluetoothName;
        try {
            if (Build.VERSION.SDK_INT <= 31 && (bluetoothName = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getString(getContentResolver(), "bluetooth_name")) != null) {
                return bluetoothName;
            }
            if (Build.VERSION.SDK_INT >= 25) {
                String deviceName = Settings.Global.getString(getContentResolver(), "device_name");
                if (deviceName != null) {
                    return deviceName;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // kntr.base.device.IDevice
    public ScreenDimensions getScreenDimensions() {
        return new ScreenDimensions(getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels);
    }

    @Override // kntr.base.device.IDevice
    public long getTotalDiskCapacity() {
        try {
            StatFs rootDir = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs dataDir = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            BigInteger rootDirCapacity = getDirTotalCapacity(rootDir);
            BigInteger dataDirCapacity = getDirTotalCapacity(dataDir);
            return rootDirCapacity.add(dataDirCapacity).longValue();
        } catch (Exception e) {
            return -1L;
        }
    }

    @Override // kntr.base.device.IDevice
    public long getTotalMemory() {
        try {
            ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
            getActivityManager().getMemoryInfo(memInfo);
            return memInfo.totalMem;
        } catch (Exception e) {
            return -1L;
        }
    }

    @Override // kntr.base.device.IDevice
    public String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    private final BigInteger getDirTotalCapacity(StatFs dir) {
        long blockCount = dir.getBlockCountLong();
        long blockSize = dir.getBlockSizeLong();
        BigInteger multiply = BigInteger.valueOf(blockCount).multiply(BigInteger.valueOf(blockSize));
        Intrinsics.checkNotNullExpressionValue(multiply, "multiply(...)");
        return multiply;
    }

    @Override // kntr.base.device.IDevice
    public String getAndroidId() {
        return PhoneIdHelper.getAndroidId(FoundationAlias.getFapp());
    }

    @Override // kntr.base.device.IDevice
    public String getAndroidImei() {
        String imei = PhoneIdHelper.getImei(FoundationAlias.getFapp());
        Intrinsics.checkNotNullExpressionValue(imei, "getImei(...)");
        return imei;
    }

    @Override // kntr.base.device.IDevice
    public String getAndroidOaId() {
        return getGOaid().getOaid();
    }

    @JvmStatic
    private static String __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getString(ContentResolver resolver, String name) {
        if (resolver == null || name == null) {
            return "";
        }
        if (Intrinsics.areEqual(name, "android_id")) {
            Object defaultReturnValue$iv = "";
            PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getAlways();
            try {
                if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("secure_get_string")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [secure_get_string]", (Throwable) null, 4, (Object) null);
                    Object string = Settings.Secure.getString(resolver, name);
                    defaultReturnValue$iv = string instanceof String ? string : null;
                } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("secure_get_string")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [secure_get_string] defaultReturnValue = [" + ((Object) "") + "]", (Throwable) null, 4, (Object) null);
                } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("secure_get_string")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [secure_get_string] defaultReturnValue = [" + ((Object) "") + "]", (Throwable) null, 4, (Object) null);
                } else {
                    Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "secure_get_string");
                    if (it$iv == null) {
                        Object string2 = Settings.Secure.getString(resolver, name);
                        if (!(string2 instanceof String)) {
                            string2 = null;
                        }
                        Object res$iv = string2;
                        if (res$iv != null) {
                            PrivacyHelper.INSTANCE.getPrivacyCache().put("secure_get_string", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "secure_get_string", defaultCacheTime$iv)));
                        }
                        ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: secure_get_string", (Throwable) null, 4, (Object) null);
                        defaultReturnValue$iv = res$iv;
                    } else {
                        defaultReturnValue$iv = it$iv;
                    }
                }
            } catch (Throwable t$iv) {
                if (PrivacyHelper.access$getDebug$p()) {
                    PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: secure_get_string, message = " + t$iv.getMessage(), t$iv);
                } else {
                    PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: secure_get_string, message = " + t$iv.getMessage(), (Throwable) null);
                }
            }
            return (String) defaultReturnValue$iv;
        }
        return Settings.Secure.getString(resolver, name);
    }
}