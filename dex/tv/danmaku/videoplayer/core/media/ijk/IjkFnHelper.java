package tv.danmaku.videoplayer.core.media.ijk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.WindowManager;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.RomUtils;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.function.Functions;
import com.bilibili.lib.function.WritableLazy;
import com.bilibili.lib.media.dolby.DolbyVisionConfigManager;
import com.bilibili.moduleservice.player.HDRUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.CpuUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCodecHelper;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* compiled from: IjkFnHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u00104\u001a\u000205R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b!\u0010\"R+\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R+\u0010,\u001a\u00020$2\u0006\u0010#\u001a\u00020$8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010+\u001a\u0004\b-\u0010'\"\u0004\b.\u0010)R\u001b\u00100\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b1\u0010'¨\u00066"}, d2 = {"Ltv/danmaku/videoplayer/core/media/ijk/IjkFnHelper;", "", "<init>", "()V", "TAG", "", "PLAY_URL_FLAG_UNKNOWN", "", "PLAY_URL_FLAG_MP4", "PLAY_URL_FLAG_FLV", "PLAY_URL_FLAG_H265", "PLAY_URL_FLAG_NEW_DASH", "PLAY_URL_FLAG_QUIC", "PLAY_URL_FLAG_HDR", "PLAY_URL_FLAG_4K", "PLAY_URL_FLAG_DOLBY_AUDIO", "PLAY_URL_FLAG_DOLBY_VISION", "PLAY_URL_FLAG_8K", "PLAY_URL_FLAG_AV1", "PLAY_URL_FLAG_HDR_VIVID", "PLAY_URL_FLAG_H266", "PLAY_URL_FLAG_SOFT_UNKNOWN", "", "PLAY_URL_FLAG_SOFT_AV1", "PLAY_URL_FLAG_SOFT_H266", "mFnval", "mSoftFnval", "fnVer", "getFnVer", "()I", "fnVal", "getFnVal", "softFnVal", "getSoftFnVal", "()J", "<set-?>", "", "av1Support", "getAv1Support", "()Z", "setAv1Support", "(Z)V", "av1Support$delegate", "Lcom/bilibili/lib/function/WritableLazy;", "av1SupportSoft", "getAv1SupportSoft", "setAv1SupportSoft", "av1SupportSoft$delegate", "h266SupportSoft", "getH266SupportSoft", "h266SupportSoft$delegate", "Lkotlin/Lazy;", "resetFnVal", "", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkFnHelper {
    private static final int PLAY_URL_FLAG_4K = 128;
    private static final int PLAY_URL_FLAG_8K = 1024;
    private static final int PLAY_URL_FLAG_AV1 = 2048;
    private static final int PLAY_URL_FLAG_DOLBY_AUDIO = 256;
    public static final int PLAY_URL_FLAG_DOLBY_VISION = 512;
    private static final int PLAY_URL_FLAG_FLV = 2;
    private static final int PLAY_URL_FLAG_H265 = 4;
    private static final int PLAY_URL_FLAG_H266 = 65536;
    public static final int PLAY_URL_FLAG_HDR = 64;
    public static final int PLAY_URL_FLAG_HDR_VIVID = 16384;
    private static final int PLAY_URL_FLAG_MP4 = 1;
    private static final int PLAY_URL_FLAG_NEW_DASH = 16;
    private static final int PLAY_URL_FLAG_QUIC = 32;
    private static final long PLAY_URL_FLAG_SOFT_AV1 = 1;
    private static final long PLAY_URL_FLAG_SOFT_H266 = 2;
    private static final long PLAY_URL_FLAG_SOFT_UNKNOWN = 0;
    private static final int PLAY_URL_FLAG_UNKNOWN = 0;
    private static final String TAG = "IjkFnHelper";
    private static int mFnval;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(IjkFnHelper.class, "av1Support", "getAv1Support()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IjkFnHelper.class, "av1SupportSoft", "getAv1SupportSoft()Z", 0))};
    public static final IjkFnHelper INSTANCE = new IjkFnHelper();
    private static long mSoftFnval = -1;
    private static final WritableLazy av1Support$delegate = Functions.writableLazy$default((Object) null, new Function0() { // from class: tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean av1Support_delegate$lambda$0;
            av1Support_delegate$lambda$0 = IjkFnHelper.av1Support_delegate$lambda$0();
            return Boolean.valueOf(av1Support_delegate$lambda$0);
        }
    }, 1, (Object) null);
    private static final WritableLazy av1SupportSoft$delegate = Functions.writableLazy$default((Object) null, new Function0() { // from class: tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean av1SupportSoft_delegate$lambda$0;
            av1SupportSoft_delegate$lambda$0 = IjkFnHelper.av1SupportSoft_delegate$lambda$0();
            return Boolean.valueOf(av1SupportSoft_delegate$lambda$0);
        }
    }, 1, (Object) null);
    private static final Lazy h266SupportSoft$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean h266SupportSoft_delegate$lambda$0;
            h266SupportSoft_delegate$lambda$0 = IjkFnHelper.h266SupportSoft_delegate$lambda$0();
            return Boolean.valueOf(h266SupportSoft_delegate$lambda$0);
        }
    });

    private IjkFnHelper() {
    }

    public final int getFnVer() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getFnVal() {
        boolean supportHdr;
        boolean z;
        boolean supportHdrVivid;
        boolean supportDolbyVision;
        int fnval;
        if (mFnval == 0) {
            Context context = BiliContext.application();
            if (context == null) {
                return 16;
            }
            long startTime = System.currentTimeMillis();
            boolean support4K = IjkOptionsHelper.isSupport4K();
            boolean support8K = IjkOptionsHelper.isSupport8K();
            boolean supportAv1 = getAv1Support() || getAv1SupportSoft();
            String cpuName = IjkCpuInfo.getCpuName();
            boolean supportV2 = true;
            String model = Build.MODEL;
            if (!TextUtils.isEmpty(model) && !TextUtils.isEmpty(cpuName)) {
                Intrinsics.checkNotNull(model);
                String model2 = model.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(model2, "toLowerCase(...)");
                String cpuName2 = model2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(cpuName2, "toLowerCase(...)");
                supportV2 = (StringsKt.contains$default(model2, "huawei p7", false, 2, (Object) null) || StringsKt.contains$default(cpuName2, "mt6795m", false, 2, (Object) null) || StringsKt.contains$default(cpuName2, "mt6595", false, 2, (Object) null)) ? false : true;
            }
            boolean supportV22 = supportV2 && !CpuUtils.isX86(context);
            boolean hdrSwitcher = ConfigManager.Companion.isHitFF("player_hdr_switcher");
            boolean hdrVividEnable = DeviceDecision.INSTANCE.getBoolean("dd_player_hdr_vivid_enable", true);
            if (hdrSwitcher && supportV22) {
                Object systemService = context.getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                if (IjkCodecHelper.isHDRSupport((WindowManager) systemService)) {
                    supportHdr = true;
                    if (!RomUtils.isHuaweiRom()) {
                        HDRUtil hDRUtil = (HDRUtil) BLRouter.get$default(BLRouter.INSTANCE, HDRUtil.class, (String) null, 2, (Object) null);
                        if (hDRUtil != null) {
                            z = true;
                            if (hDRUtil.huaWeiEnableHwHdrWhiteList()) {
                                supportHdrVivid = true;
                            }
                        } else {
                            z = true;
                        }
                        supportHdrVivid = false;
                    } else {
                        z = true;
                        supportHdrVivid = supportHdr;
                    }
                    supportDolbyVision = (!DolbyVisionConfigManager.INSTANCE.supportDolbyVision() || IjkOptionsHelper.isSupportDolbyVisionHw()) ? z : false;
                    fnval = 16;
                    if (supportHdr) {
                        fnval = 16 | 64;
                    }
                    if (supportHdrVivid && hdrVividEnable) {
                        fnval |= PLAY_URL_FLAG_HDR_VIVID;
                    }
                    if (support4K) {
                        fnval |= PLAY_URL_FLAG_4K;
                    }
                    if (support8K) {
                        fnval |= 1024;
                    }
                    if (supportDolbyVision) {
                        fnval |= 512;
                    }
                    if (supportAv1) {
                        fnval |= 2048;
                    }
                    if (!CpuUtils.isX86(context)) {
                        fnval |= 256;
                    }
                    if (getH266SupportSoft()) {
                        fnval |= PLAY_URL_FLAG_H266;
                    }
                    mFnval = fnval;
                    BLog.i(TAG, "fnval init time:" + (System.currentTimeMillis() - startTime) + " " + fnval + ",  av1Support:" + getAv1Support() + ", av1SupportSoft:" + getAv1SupportSoft());
                }
            }
            supportHdr = false;
            if (!RomUtils.isHuaweiRom()) {
            }
            supportDolbyVision = (!DolbyVisionConfigManager.INSTANCE.supportDolbyVision() || IjkOptionsHelper.isSupportDolbyVisionHw()) ? z : false;
            fnval = 16;
            if (supportHdr) {
            }
            if (supportHdrVivid) {
                fnval |= PLAY_URL_FLAG_HDR_VIVID;
            }
            if (support4K) {
            }
            if (support8K) {
            }
            if (supportDolbyVision) {
            }
            if (supportAv1) {
            }
            if (!CpuUtils.isX86(context)) {
            }
            if (getH266SupportSoft()) {
            }
            mFnval = fnval;
            BLog.i(TAG, "fnval init time:" + (System.currentTimeMillis() - startTime) + " " + fnval + ",  av1Support:" + getAv1Support() + ", av1SupportSoft:" + getAv1SupportSoft());
        }
        return mFnval;
    }

    public final long getSoftFnVal() {
        if (mSoftFnval == -1) {
            long startTime = System.currentTimeMillis();
            long softFnval = getAv1SupportSoft() ? 0 | 1 : 0L;
            if (getH266SupportSoft()) {
                softFnval |= 2;
            }
            mSoftFnval = softFnval;
            BLog.i(TAG, "soft fnval init time:" + (System.currentTimeMillis() - startTime) + " " + softFnval);
        }
        long startTime2 = mSoftFnval;
        return startTime2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean av1Support_delegate$lambda$0() {
        return IjkCodecHelper.isAv1Support();
    }

    private final void setAv1Support(boolean z) {
        av1Support$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final boolean getAv1Support() {
        return ((Boolean) av1Support$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean av1SupportSoft_delegate$lambda$0() {
        return IjkCodecHelper.isAv1SupportSoft(BiliContext.application());
    }

    private final void setAv1SupportSoft(boolean z) {
        av1SupportSoft$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    public final boolean getAv1SupportSoft() {
        return ((Boolean) av1SupportSoft$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    private final boolean getH266SupportSoft() {
        return ((Boolean) h266SupportSoft$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h266SupportSoft_delegate$lambda$0() {
        Context context = BiliContext.application();
        return IjkCodecHelper.isH266SupportSoft(context);
    }

    public final void resetFnVal() {
        mFnval = 0;
        mSoftFnval = -1L;
        setAv1Support(IjkCodecHelper.isAv1Support());
        setAv1SupportSoft(IjkCodecHelper.isAv1SupportSoft(BiliContext.application()));
        boolean av1Support = getAv1Support();
        BLog.i(TAG, "resetFnVal， av1Support:" + av1Support + ", av1SupportSoft:" + getAv1SupportSoft());
    }
}