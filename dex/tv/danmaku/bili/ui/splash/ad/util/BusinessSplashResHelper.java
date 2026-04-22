package tv.danmaku.bili.ui.splash.ad.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.gripper.api.ad.biz.GAdBizKt;
import com.bilibili.gripper.api.ad.biz.pegasus.banner.ITopViewResFileHelper;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.report.SimpleAdReportPreset;
import com.bilibili.lib.downloader.periodic.DownloadObserver;
import com.bilibili.lib.downloader.periodic.PeriodicDownloader;
import com.bilibili.lib.downloader.periodic.PeriodicRequest;
import com.bilibili.lib.downloader.periodic.ResInfo;
import com.bilibili.lib.resmanager.DownloadBizType;
import com.bilibili.lib.resmanager.ResCallback;
import com.bilibili.lib.resmanager.ResDownloadRequest;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.resmanager.ResResponse;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.SplashHelper;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.model.BezierAnimationElement;
import tv.danmaku.bili.ui.splash.ad.model.PeakTaskDefine;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashEgg;
import tv.danmaku.bili.ui.splash.ad.model.SplashElementAnimation;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.model.SplashPeakTask;
import tv.danmaku.bili.ui.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.ui.splash.ad.model.SplashShopCard;
import tv.danmaku.bili.ui.splash.event.EventSplashStorageKt;
import tv.danmaku.bili.ui.splash.utils.SplashUtilsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: BusinessSplashResHelper.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J$\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010!\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\rH\u0007J\u0016\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010&\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\rH\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00050)0\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010+\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\rH\u0007J,\u0010,\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010-\u001a\u00020.H\u0002J\u001e\u0010/\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u00102\u001a\u00020\u000bH\u0007J\u0010\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u000205H\u0002J \u00106\u001a\u0002072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/util/BusinessSplashResHelper;", "", "<init>", "()V", "TAG", "", "DOWNLOAD_TAG_VIDE0", "DOWNLOAD_TAG_IMAGE", "DOWNLOAD_TAG_BUTTON", "DOWNLOAD_TAG_ANIMATION", "downloadButtonRes", "", "buttonList", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "adType", "", "downloadMainLogo", "url", "md5", "downloadMainImageSync", "", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "downloadMainVideoSync", "downloadAnimationResourceAsync", "downloadEggResourceAsync", "downloadSecondPageEggVideo", "downloadSecondPageEggVideoSync", "isResourceExistByHash", "hash", "fetchResourceFileByHash", "Ljava/io/File;", "downloadTopViewRes", "saveList", "oldList", "reportResDownloadSucces", PeakTaskDefine.AD_CB, "deleteTopViewSplashRes", "extractTopViewUrls", "extractTopViewUrlsWithId", "Lkotlin/Pair;", "", "deleteUselessResources", "deleteUselessSplashResAndTask", "bizType", "Lcom/bilibili/lib/resmanager/DownloadBizType;", "downloadUsePeak", "list", "Ltv/danmaku/bili/ui/splash/ad/model/SplashPeakTask;", "registerPeakDownloadListener", "handlePeriodicDownloaderCallback", "info", "Lcom/bilibili/lib/downloader/periodic/ResInfo;", "buildGuideBtnResDownloadRequest", "Lcom/bilibili/lib/resmanager/ResDownloadRequest;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BusinessSplashResHelper {
    public static final int $stable = 0;
    private static final String DOWNLOAD_TAG_ANIMATION = "ad_splash_animation";
    private static final String DOWNLOAD_TAG_BUTTON = "ad_splash_button";
    private static final String DOWNLOAD_TAG_IMAGE = "ad_splash_image";
    private static final String DOWNLOAD_TAG_VIDE0 = "ad_splash_video";
    public static final BusinessSplashResHelper INSTANCE = new BusinessSplashResHelper();
    private static final String TAG = "[Splash]BusinessSplashResHelper";

    private BusinessSplashResHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0294 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0187  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void downloadButtonRes(List<SplashGuideButton> list, int adType) {
        boolean isGuideImageValid;
        String jumpImageUrl;
        boolean isJumpImageValid;
        String schemaImageUrl;
        boolean isSchemaImageValid;
        List buttonList;
        String logoUrl;
        boolean isLogoImageValid;
        List $this$fastForEach$iv;
        List $this$fastForEach$iv2;
        int i;
        List buttonList2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        boolean z = true;
        DownloadBizType bizType = adType == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        if (buttonList2 == null) {
            return;
        }
        List $this$forEach$iv = buttonList2;
        for (Object element$iv : $this$forEach$iv) {
            SplashGuideButton it = (SplashGuideButton) element$iv;
            List list2 = new ArrayList();
            String guideImageUrl = it.getGuideImageUrl();
            if (!((guideImageUrl == null || StringsKt.isBlank(guideImageUrl)) ? z : false)) {
                String guideImageMD5 = it.getGuideImageMD5();
                if (!((guideImageMD5 == null || StringsKt.isBlank(guideImageMD5)) ? z : false)) {
                    isGuideImageValid = z;
                    if (isGuideImageValid && !isResourceExistByHash(it.getGuideImageMD5())) {
                        BusinessSplashResHelper businessSplashResHelper = INSTANCE;
                        String guideImageUrl2 = it.getGuideImageUrl();
                        Intrinsics.checkNotNull(guideImageUrl2);
                        String guideImageMD52 = it.getGuideImageMD5();
                        Intrinsics.checkNotNull(guideImageMD52);
                        list2.add(businessSplashResHelper.buildGuideBtnResDownloadRequest(guideImageUrl2, guideImageMD52, bizType));
                        BLog.i(TAG, "download guide image. url = " + it.getGuideImageUrl());
                    }
                    jumpImageUrl = it.getJumpImageUrl();
                    if (!(jumpImageUrl != null || StringsKt.isBlank(jumpImageUrl))) {
                        String jumpImageMD5 = it.getJumpImageMD5();
                        if (!(jumpImageMD5 == null || StringsKt.isBlank(jumpImageMD5))) {
                            isJumpImageValid = true;
                            if (isJumpImageValid && !isResourceExistByHash(it.getJumpImageMD5())) {
                                BusinessSplashResHelper businessSplashResHelper2 = INSTANCE;
                                String jumpImageUrl2 = it.getJumpImageUrl();
                                Intrinsics.checkNotNull(jumpImageUrl2);
                                String jumpImageMD52 = it.getJumpImageMD5();
                                Intrinsics.checkNotNull(jumpImageMD52);
                                list2.add(businessSplashResHelper2.buildGuideBtnResDownloadRequest(jumpImageUrl2, jumpImageMD52, bizType));
                                BLog.i(TAG, "download jump image. url = " + it.getJumpImageUrl());
                            }
                            schemaImageUrl = it.getSchemaImageUrl();
                            if (!(schemaImageUrl != null || StringsKt.isBlank(schemaImageUrl))) {
                                String schemaImageMD5 = it.getSchemaImageMD5();
                                if (!(schemaImageMD5 == null || StringsKt.isBlank(schemaImageMD5))) {
                                    isSchemaImageValid = true;
                                    if (isSchemaImageValid || isResourceExistByHash(it.getSchemaImageMD5())) {
                                        buttonList = buttonList2;
                                    } else {
                                        BusinessSplashResHelper businessSplashResHelper3 = INSTANCE;
                                        String schemaImageUrl2 = it.getSchemaImageUrl();
                                        Intrinsics.checkNotNull(schemaImageUrl2);
                                        buttonList = buttonList2;
                                        String schemaImageMD52 = it.getSchemaImageMD5();
                                        Intrinsics.checkNotNull(schemaImageMD52);
                                        list2.add(businessSplashResHelper3.buildGuideBtnResDownloadRequest(schemaImageUrl2, schemaImageMD52, bizType));
                                        BLog.i(TAG, "download schema image. url = " + it.getSchemaImageUrl());
                                    }
                                    logoUrl = it.getLogoUrl();
                                    if (!(logoUrl != null || StringsKt.isBlank(logoUrl))) {
                                        String logoImageMD5 = it.getLogoImageMD5();
                                        if (!(logoImageMD5 == null || StringsKt.isBlank(logoImageMD5))) {
                                            isLogoImageValid = true;
                                            if (!isLogoImageValid && !isResourceExistByHash(it.getLogoImageMD5())) {
                                                BusinessSplashResHelper businessSplashResHelper4 = INSTANCE;
                                                String logoUrl2 = it.getLogoUrl();
                                                Intrinsics.checkNotNull(logoUrl2);
                                                String logoImageMD52 = it.getLogoImageMD5();
                                                Intrinsics.checkNotNull(logoImageMD52);
                                                list2.add(businessSplashResHelper4.buildGuideBtnResDownloadRequest(logoUrl2, logoImageMD52, bizType));
                                                BLog.i(TAG, "download logo image. url = " + it.getLogoUrl());
                                            }
                                            $this$fastForEach$iv = it.getCards();
                                            if ($this$fastForEach$iv != null) {
                                                int index$iv = 0;
                                                int size = $this$fastForEach$iv.size();
                                                while (index$iv < size) {
                                                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                                                    SplashShopCard card = (SplashShopCard) item$iv;
                                                    String imageHash = card.getImageHash();
                                                    if (!(imageHash == null || StringsKt.isBlank(imageHash))) {
                                                        String image = card.getImage();
                                                        if (!(image == null || StringsKt.isBlank(image))) {
                                                            if (isResourceExistByHash(card.getImageHash())) {
                                                                $this$fastForEach$iv2 = $this$fastForEach$iv;
                                                                i = size;
                                                            } else {
                                                                $this$fastForEach$iv2 = $this$fastForEach$iv;
                                                                BusinessSplashResHelper businessSplashResHelper5 = INSTANCE;
                                                                i = size;
                                                                String image2 = card.getImage();
                                                                Intrinsics.checkNotNull(image2);
                                                                String imageHash2 = card.getImageHash();
                                                                Intrinsics.checkNotNull(imageHash2);
                                                                list2.add(businessSplashResHelper5.buildGuideBtnResDownloadRequest(image2, imageHash2, bizType));
                                                                BLog.i(TAG, "download shop card image. url = " + card.getImage());
                                                            }
                                                            index$iv++;
                                                            $this$fastForEach$iv = $this$fastForEach$iv2;
                                                            size = i;
                                                        }
                                                    }
                                                    $this$fastForEach$iv2 = $this$fastForEach$iv;
                                                    i = size;
                                                    index$iv++;
                                                    $this$fastForEach$iv = $this$fastForEach$iv2;
                                                    size = i;
                                                }
                                            }
                                            if (!list2.isEmpty()) {
                                                ResManager.downloadBatch(list2);
                                            }
                                            buttonList2 = buttonList;
                                            z = true;
                                        }
                                    }
                                    isLogoImageValid = false;
                                    if (!isLogoImageValid) {
                                    }
                                    $this$fastForEach$iv = it.getCards();
                                    if ($this$fastForEach$iv != null) {
                                    }
                                    if (!list2.isEmpty()) {
                                    }
                                    buttonList2 = buttonList;
                                    z = true;
                                }
                            }
                            isSchemaImageValid = false;
                            if (isSchemaImageValid) {
                            }
                            buttonList = buttonList2;
                            logoUrl = it.getLogoUrl();
                            if (!(logoUrl != null || StringsKt.isBlank(logoUrl))) {
                            }
                            isLogoImageValid = false;
                            if (!isLogoImageValid) {
                            }
                            $this$fastForEach$iv = it.getCards();
                            if ($this$fastForEach$iv != null) {
                            }
                            if (!list2.isEmpty()) {
                            }
                            buttonList2 = buttonList;
                            z = true;
                        }
                    }
                    isJumpImageValid = false;
                    if (isJumpImageValid) {
                        BusinessSplashResHelper businessSplashResHelper22 = INSTANCE;
                        String jumpImageUrl22 = it.getJumpImageUrl();
                        Intrinsics.checkNotNull(jumpImageUrl22);
                        String jumpImageMD522 = it.getJumpImageMD5();
                        Intrinsics.checkNotNull(jumpImageMD522);
                        list2.add(businessSplashResHelper22.buildGuideBtnResDownloadRequest(jumpImageUrl22, jumpImageMD522, bizType));
                        BLog.i(TAG, "download jump image. url = " + it.getJumpImageUrl());
                    }
                    schemaImageUrl = it.getSchemaImageUrl();
                    if (!(schemaImageUrl != null || StringsKt.isBlank(schemaImageUrl))) {
                    }
                    isSchemaImageValid = false;
                    if (isSchemaImageValid) {
                    }
                    buttonList = buttonList2;
                    logoUrl = it.getLogoUrl();
                    if (!(logoUrl != null || StringsKt.isBlank(logoUrl))) {
                    }
                    isLogoImageValid = false;
                    if (!isLogoImageValid) {
                    }
                    $this$fastForEach$iv = it.getCards();
                    if ($this$fastForEach$iv != null) {
                    }
                    if (!list2.isEmpty()) {
                    }
                    buttonList2 = buttonList;
                    z = true;
                }
            }
            isGuideImageValid = false;
            if (isGuideImageValid) {
                BusinessSplashResHelper businessSplashResHelper6 = INSTANCE;
                String guideImageUrl22 = it.getGuideImageUrl();
                Intrinsics.checkNotNull(guideImageUrl22);
                String guideImageMD522 = it.getGuideImageMD5();
                Intrinsics.checkNotNull(guideImageMD522);
                list2.add(businessSplashResHelper6.buildGuideBtnResDownloadRequest(guideImageUrl22, guideImageMD522, bizType));
                BLog.i(TAG, "download guide image. url = " + it.getGuideImageUrl());
            }
            jumpImageUrl = it.getJumpImageUrl();
            if (!(jumpImageUrl != null || StringsKt.isBlank(jumpImageUrl))) {
            }
            isJumpImageValid = false;
            if (isJumpImageValid) {
            }
            schemaImageUrl = it.getSchemaImageUrl();
            if (!(schemaImageUrl != null || StringsKt.isBlank(schemaImageUrl))) {
            }
            isSchemaImageValid = false;
            if (isSchemaImageValid) {
            }
            buttonList = buttonList2;
            logoUrl = it.getLogoUrl();
            if (!(logoUrl != null || StringsKt.isBlank(logoUrl))) {
            }
            isLogoImageValid = false;
            if (!isLogoImageValid) {
            }
            $this$fastForEach$iv = it.getCards();
            if ($this$fastForEach$iv != null) {
            }
            if (!list2.isEmpty()) {
            }
            buttonList2 = buttonList;
            z = true;
        }
    }

    @JvmStatic
    public static final void downloadMainLogo(String url, String md5, int adType) {
        String str = url;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        String str2 = md5;
        if (str2 == null || StringsKt.isBlank(str2)) {
            z = true;
        }
        if (z) {
            return;
        }
        DownloadBizType bizType = adType == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        ResManager.download$default(INSTANCE.buildGuideBtnResDownloadRequest(url, md5, bizType), (ResCallback) null, 2, (Object) null);
    }

    @JvmStatic
    public static final boolean downloadMainImageSync(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        boolean isExists = isResourceExistByHash(splash.imageHash);
        long j = splash.id;
        String str = splash.imageUrl;
        BLog.i(TAG, "downloadMainImageSync, already download = " + isExists + ", splashId = " + j + ", imageUrl = " + str + ", imageHash = " + splash.imageHash + ", isEffectiveSplash = " + (splash.splashType == 1));
        if (isExists) {
            return true;
        }
        DownloadBizType bizType = splash.splashType == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        ResDownloadRequest imageRequest = new ResDownloadRequest(splash.imageUrl, splash.imageHash).encrypted(splash.isEncrypted()).md5(splash.imageHash).bizType(bizType).downloadTag(DOWNLOAD_TAG_IMAGE);
        return ResManager.downloadSync(imageRequest);
    }

    @JvmStatic
    public static final boolean downloadMainVideoSync(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        boolean isExists = isResourceExistByHash(splash.videoHash);
        long j = splash.id;
        String str = splash.videoUrl;
        BLog.i(TAG, "downloadMainVideoSync, already download = " + isExists + " , splashId = " + j + ", videoUrl = " + str + ", videoHash = " + splash.videoHash + ", isEffectiveSplash = " + (splash.splashType == 1));
        if (isExists) {
            return true;
        }
        DownloadBizType bizType = splash.splashType == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        ResDownloadRequest videoRequest = new ResDownloadRequest(splash.videoUrl, splash.videoHash).encrypted(splash.isEncrypted()).md5(splash.videoHash).bizType(bizType).downloadTag(DOWNLOAD_TAG_VIDE0);
        return ResManager.downloadSync(videoRequest);
    }

    @JvmStatic
    public static final void downloadAnimationResourceAsync(Splash splash) {
        DownloadBizType bizType;
        Iterable animationList;
        Intrinsics.checkNotNullParameter(splash, "splash");
        if (splash.splashType == 1) {
            bizType = DownloadBizType.EffectSplash;
        } else {
            bizType = DownloadBizType.Splash;
        }
        Map downloadMap = new LinkedHashMap();
        SplashElementAnimation splashElementAnimation = splash.elementAnimation;
        if (splashElementAnimation != null && (animationList = splashElementAnimation.getAnimationList()) != null) {
            Iterable $this$forEach$iv = animationList;
            for (Object element$iv : $this$forEach$iv) {
                BezierAnimationElement ele = (BezierAnimationElement) element$iv;
                String imageUrl = ele.getImageUrl();
                boolean z = false;
                if (!(imageUrl == null || StringsKt.isBlank(imageUrl))) {
                    String imageMd5 = ele.getImageMd5();
                    if (!(imageMd5 == null || StringsKt.isBlank(imageMd5))) {
                        String imageMd52 = ele.getImageMd5();
                        if (imageMd52 == null) {
                            imageMd52 = "";
                        }
                        String imageUrl2 = ele.getImageUrl();
                        if (imageUrl2 == null) {
                            imageUrl2 = "";
                        }
                        downloadMap.put(imageMd52, imageUrl2);
                    }
                }
                String guideImageUrl = ele.getGuideImageUrl();
                if (!(guideImageUrl == null || StringsKt.isBlank(guideImageUrl))) {
                    String guideImageMd5 = ele.getGuideImageMd5();
                    if (!(guideImageMd5 == null || StringsKt.isBlank(guideImageMd5))) {
                        String guideImageMd52 = ele.getGuideImageMd5();
                        if (guideImageMd52 == null) {
                            guideImageMd52 = "";
                        }
                        String guideImageUrl2 = ele.getGuideImageUrl();
                        if (guideImageUrl2 == null) {
                            guideImageUrl2 = "";
                        }
                        downloadMap.put(guideImageMd52, guideImageUrl2);
                    }
                }
                String topImageUrl = ele.getTopImageUrl();
                if (!(topImageUrl == null || StringsKt.isBlank(topImageUrl))) {
                    String topImageMd5 = ele.getTopImageMd5();
                    if (!((topImageMd5 == null || StringsKt.isBlank(topImageMd5)) ? true : true)) {
                        String topImageMd52 = ele.getTopImageMd5();
                        if (topImageMd52 == null) {
                            topImageMd52 = "";
                        }
                        String topImageUrl2 = ele.getTopImageUrl();
                        downloadMap.put(topImageMd52, topImageUrl2 != null ? topImageUrl2 : "");
                    }
                }
            }
        }
        Collection destination$iv$iv = new ArrayList(downloadMap.size());
        for (Map.Entry item$iv$iv : downloadMap.entrySet()) {
            destination$iv$iv.add(new ResDownloadRequest((String) item$iv$iv.getValue(), (String) item$iv$iv.getKey()).md5((String) item$iv$iv.getKey()).bizType(bizType).downloadTag(DOWNLOAD_TAG_ANIMATION));
        }
        List downloadList = (List) destination$iv$iv;
        ResManager.downloadBatch(downloadList);
    }

    @JvmStatic
    public static final void downloadEggResourceAsync(Splash splash) {
        String hash;
        SplashEgg splashEgg;
        String videoUrl;
        Intrinsics.checkNotNullParameter(splash, "splash");
        SplashEgg splashEgg2 = splash.splashEgg;
        if (splashEgg2 == null || (hash = splashEgg2.getVideoHash()) == null || (splashEgg = splash.splashEgg) == null || (videoUrl = splashEgg.getVideoUrl()) == null || isResourceExistByHash(hash)) {
            return;
        }
        DownloadBizType bizType = splash.splashType == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        ResDownloadRequest videoRequest = new ResDownloadRequest(videoUrl, hash).encrypted(splash.isEncrypted()).md5(hash).bizType(bizType).downloadTag(DOWNLOAD_TAG_VIDE0);
        ResManager.downloadSync(videoRequest);
    }

    @JvmStatic
    public static final void downloadSecondPageEggVideo(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        if (splash.secondPage == null) {
            return;
        }
        SplashSecondPageInfo splashSecondPageInfo = splash.secondPage;
        Intrinsics.checkNotNull(splashSecondPageInfo);
        String url = splashSecondPageInfo.getSecondVideoUrl();
        SplashSecondPageInfo splashSecondPageInfo2 = splash.secondPage;
        Intrinsics.checkNotNull(splashSecondPageInfo2);
        String hash = splashSecondPageInfo2.getSecondVideoHash();
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(hash)) {
            return;
        }
        boolean isLocalVideoExists = isResourceExistByHash(hash);
        if (!isLocalVideoExists) {
            boolean isDownloadSuccessViaNet = downloadSecondPageEggVideoSync(splash);
            long j = splash.id;
            BLog.d(SplashHelper.TAG, "handleSecondPageEggVideoDownload, tech report,  videoHash = " + hash + ", splashId = " + j + ", isDownloadSuccessViaNet = " + isDownloadSuccessViaNet + ", cardType = " + splash.type);
        }
    }

    @JvmStatic
    public static final boolean downloadSecondPageEggVideoSync(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        SplashSecondPageInfo splashSecondPageInfo = splash.secondPage;
        boolean isExists = isResourceExistByHash(splashSecondPageInfo != null ? splashSecondPageInfo.getSecondVideoHash() : null);
        long j = splash.id;
        SplashSecondPageInfo splashSecondPageInfo2 = splash.secondPage;
        String secondVideoUrl = splashSecondPageInfo2 != null ? splashSecondPageInfo2.getSecondVideoUrl() : null;
        SplashSecondPageInfo splashSecondPageInfo3 = splash.secondPage;
        BLog.i(TAG, "downloadSecondPageEggVideoSync, already download = " + isExists + " , splashId = " + j + ", videoUrl = " + secondVideoUrl + ", videoHash = " + (splashSecondPageInfo3 != null ? splashSecondPageInfo3.getSecondVideoHash() : null) + ", isEffectiveSplash = " + (splash.splashType == 1));
        if (isExists) {
            return true;
        }
        DownloadBizType bizType = splash.splashType == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        SplashSecondPageInfo splashSecondPageInfo4 = splash.secondPage;
        String secondVideoUrl2 = splashSecondPageInfo4 != null ? splashSecondPageInfo4.getSecondVideoUrl() : null;
        SplashSecondPageInfo splashSecondPageInfo5 = splash.secondPage;
        ResDownloadRequest encrypted = new ResDownloadRequest(secondVideoUrl2, splashSecondPageInfo5 != null ? splashSecondPageInfo5.getSecondVideoHash() : null).encrypted(splash.isEncrypted());
        SplashSecondPageInfo splashSecondPageInfo6 = splash.secondPage;
        ResDownloadRequest videoRequest = encrypted.md5(splashSecondPageInfo6 != null ? splashSecondPageInfo6.getSecondVideoHash() : null).bizType(bizType).downloadTag(DOWNLOAD_TAG_VIDE0);
        return ResManager.downloadSync(videoRequest);
    }

    @JvmStatic
    public static final boolean isResourceExistByHash(String hash) {
        String str = hash;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        return ResManager.isFileExist(new ResRequest((String) null, hash));
    }

    @JvmStatic
    public static final File fetchResourceFileByHash(String hash) {
        ResResponse fetch;
        File it;
        String str = hash;
        if ((str == null || StringsKt.isBlank(str)) || (fetch = ResManager.fetch(new ResRequest((String) null, hash))) == null || (it = fetch.getFile()) == null || !it.exists()) {
            return null;
        }
        return it;
    }

    @JvmStatic
    public static final void downloadTopViewRes(List<? extends Splash> list, List<? extends Splash> list2) {
        List saveList;
        List saveList2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List oldList = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        Intrinsics.checkNotNullParameter(saveList2, "saveList");
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        BLog.i(TAG, "downloadTopViewRes");
        Context context = BiliContext.application();
        List<Splash> allResList = new ArrayList(saveList2);
        allResList.addAll(oldList);
        long currentTime = System.currentTimeMillis() / ((long) IjkMediaCodecInfo.RANK_MAX);
        ITopViewResFileHelper topViewResFileHelper = GAdBizKt.getGAdPegasus().getBanner().getTopViewResFileHelper();
        for (Splash splash : allResList) {
            if (splash.id <= 0 || !splash.hasTopViewResInfo() || currentTime > splash.endTime) {
                saveList2 = saveList2;
            } else if (!SplashCreativeHelper.isSplashDownloadEnable(splash)) {
                SplashCustomReporterKt.reportSplashDownloadDisable(splash);
            } else {
                JSONObject it = splash.extra;
                if (it != null) {
                    String topPicUrl = it.getString("topview_pic_url");
                    String topVideoUrl = it.getString("topview_video_url");
                    String top3dVideoUrl = it.getString("topview_3d_url");
                    if (TextUtils.isEmpty(topPicUrl)) {
                        saveList = saveList2;
                    } else {
                        Intrinsics.checkNotNull(context);
                        long j = splash.id;
                        Intrinsics.checkNotNull(topPicUrl);
                        boolean isTopViewPicSuccess = topViewResFileHelper.downloadPicResource(context, j, topPicUrl);
                        if (!isTopViewPicSuccess) {
                            saveList = saveList2;
                        } else {
                            BusinessSplashResHelper businessSplashResHelper = INSTANCE;
                            saveList = saveList2;
                            String str = splash.adCb;
                            Intrinsics.checkNotNull(str);
                            businessSplashResHelper.reportResDownloadSucces(str, topPicUrl);
                        }
                    }
                    if (!TextUtils.isEmpty(topVideoUrl)) {
                        Intrinsics.checkNotNull(context);
                        long j2 = splash.id;
                        Intrinsics.checkNotNull(topVideoUrl);
                        boolean isTopViewVideoSuccess = topViewResFileHelper.downloadVideoResource(context, j2, topVideoUrl);
                        if (isTopViewVideoSuccess) {
                            BusinessSplashResHelper businessSplashResHelper2 = INSTANCE;
                            String str2 = splash.adCb;
                            Intrinsics.checkNotNull(str2);
                            businessSplashResHelper2.reportResDownloadSucces(str2, topVideoUrl);
                        }
                    }
                    if (!TextUtils.isEmpty(top3dVideoUrl)) {
                        Intrinsics.checkNotNull(context);
                        long j3 = splash.id;
                        Intrinsics.checkNotNull(top3dVideoUrl);
                        boolean isTopView3dVideoSuccess = topViewResFileHelper.downloadVideoResource(context, j3, top3dVideoUrl);
                        if (isTopView3dVideoSuccess) {
                            BusinessSplashResHelper businessSplashResHelper3 = INSTANCE;
                            String str3 = splash.adCb;
                            Intrinsics.checkNotNull(str3);
                            businessSplashResHelper3.reportResDownloadSucces(str3, top3dVideoUrl);
                        }
                    }
                    saveList2 = saveList;
                }
            }
        }
    }

    public final void reportResDownloadSucces(String adCb, String url) {
        Intrinsics.checkNotNullParameter(adCb, PeakTaskDefine.AD_CB);
        Intrinsics.checkNotNullParameter(url, "url");
        GAdCoreKt.getGAdReport().uiEvent("cre_dl_suc", new SimpleAdReportPreset(adCb, url));
    }

    private final void deleteTopViewSplashRes(Splash splash) {
        JSONObject extra = splash.extra;
        if (extra == null) {
            return;
        }
        Context context = BiliContext.application();
        if (!splash.isValid() && splash.hasTopViewResInfo()) {
            ITopViewResFileHelper topViewResFileHelper = GAdBizKt.getGAdPegasus().getBanner().getTopViewResFileHelper();
            Intrinsics.checkNotNull(context);
            topViewResFileHelper.deleteResource(context, splash.id, extra);
        }
    }

    private final void deleteTopViewSplashRes(List<? extends Splash> list, List<? extends Splash> list2) {
        final List saveList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List oldList = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        List $this$flatMap$iv = saveList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            Splash p0 = (Splash) element$iv$iv;
            Iterable list$iv$iv = extractTopViewUrlsWithId(p0);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable referencedUrlsWithId = CollectionsKt.toSet((List) destination$iv$iv);
        Iterable $this$mapTo$iv = referencedUrlsWithId;
        Collection destination$iv = (Set) new LinkedHashSet();
        for (Object item$iv : $this$mapTo$iv) {
            Pair it = (Pair) item$iv;
            destination$iv.add((String) it.getSecond());
        }
        final Set referencedUrlOnlySet = (Set) destination$iv;
        Sequence $this$forEach$iv = SequencesKt.filter(SequencesKt.filterNot(CollectionsKt.asSequence(oldList), new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean deleteTopViewSplashRes$lambda$1;
                deleteTopViewSplashRes$lambda$1 = BusinessSplashResHelper.deleteTopViewSplashRes$lambda$1(saveList, (Splash) obj);
                return Boolean.valueOf(deleteTopViewSplashRes$lambda$1);
            }
        }), new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean deleteTopViewSplashRes$lambda$2;
                deleteTopViewSplashRes$lambda$2 = BusinessSplashResHelper.deleteTopViewSplashRes$lambda$2(referencedUrlOnlySet, (Splash) obj);
                return Boolean.valueOf(deleteTopViewSplashRes$lambda$2);
            }
        });
        for (Object element$iv : $this$forEach$iv) {
            Splash p02 = (Splash) element$iv;
            deleteTopViewSplashRes(p02);
        }
        ITopViewResFileHelper resHelper = GAdBizKt.getGAdPegasus().getBanner().getTopViewResFileHelper();
        long start$iv = System.currentTimeMillis();
        Iterable $this$forEach$iv2 = referencedUrlsWithId;
        for (Object element$iv2 : $this$forEach$iv2) {
            Pair pair = (Pair) element$iv2;
            long id = ((Number) pair.component1()).longValue();
            String url = (String) pair.component2();
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            resHelper.renameToUrlHash(application, id, url);
            saveList = saveList;
            oldList = oldList;
        }
        long renameCostTime = System.currentTimeMillis() - start$iv;
        BLog.i(TAG, "renameTopViewSplashRes, costTime = " + renameCostTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteTopViewSplashRes$lambda$1(List $saveList, Splash it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $saveList.contains(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteTopViewSplashRes$lambda$2(Set $referencedUrlOnlySet, Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        Iterable $this$none$iv = INSTANCE.extractTopViewUrls(splash);
        if (($this$none$iv instanceof Collection) && ((Collection) $this$none$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$none$iv) {
            String it = (String) element$iv;
            if ($referencedUrlOnlySet.contains(it)) {
                return false;
            }
        }
        return true;
    }

    private final List<String> extractTopViewUrls(Splash splash) {
        JSONObject extra = splash.extra;
        return extra == null ? EnhancedUnmodifiabilityKt.unmodifiable(CollectionsKt.emptyList()) : EnhancedUnmodifiabilityKt.unmodifiable(CollectionsKt.listOfNotNull(new String[]{extra.getString("topview_pic_url"), extra.getString("topview_video_url"), extra.getString("topview_3d_url")}));
    }

    private final List<Pair<Long, String>> extractTopViewUrlsWithId(Splash splash) {
        long id = splash.id;
        Iterable $this$map$iv = extractTopViewUrls(splash);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(TuplesKt.to(Long.valueOf(id), it));
        }
        return EnhancedUnmodifiabilityKt.unmodifiable((List) destination$iv$iv);
    }

    @JvmStatic
    public static final void deleteUselessResources(List<? extends Splash> list, List<? extends Splash> list2) {
        List saveList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List oldList = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        Intrinsics.checkNotNullParameter(saveList, "saveList");
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        boolean isShowing = SplashUtilsKt.isSplashShowing();
        BLog.i(TAG, "deleteUselessResources, isSplashShowing = " + isShowing);
        if (!isShowing) {
            BusinessSplashResHelper businessSplashResHelper = INSTANCE;
            List $this$filter$iv = saveList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Splash it = (Splash) element$iv$iv;
                if (it.splashType == 0) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            ArrayList arrayList = (List) destination$iv$iv;
            List $this$filter$iv2 = oldList;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv2) {
                Splash it2 = (Splash) element$iv$iv2;
                if (it2.splashType == 0) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            businessSplashResHelper.deleteUselessSplashResAndTask(arrayList, (List) destination$iv$iv2, DownloadBizType.Splash);
            BusinessSplashResHelper businessSplashResHelper2 = INSTANCE;
            List $this$filter$iv3 = saveList;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv3 : $this$filter$iv3) {
                Splash it3 = (Splash) element$iv$iv3;
                Splash it4 = it3.splashType == 1 ? 1 : null;
                if (it4 != null) {
                    destination$iv$iv3.add(element$iv$iv3);
                }
            }
            ArrayList arrayList2 = (List) destination$iv$iv3;
            List $this$filter$iv4 = oldList;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv4 : $this$filter$iv4) {
                Splash it5 = (Splash) element$iv$iv4;
                Splash it6 = it5.splashType == 1 ? 1 : null;
                if (it6 != null) {
                    destination$iv$iv4.add(element$iv$iv4);
                }
            }
            businessSplashResHelper2.deleteUselessSplashResAndTask(arrayList2, (List) destination$iv$iv4, DownloadBizType.EffectSplash);
            INSTANCE.deleteTopViewSplashRes(saveList, oldList);
        }
    }

    private final void deleteUselessSplashResAndTask(List<? extends Splash> list, List<? extends Splash> list2, DownloadBizType bizType) {
        Iterable saveList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Iterable oldList = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        BLog.i(TAG, "deleteUselessSplashResAndTask");
        Set whiteListResSet = new LinkedHashSet();
        whiteListResSet.add(EventSplashStorageKt.getBackupBirthdayResourceKey());
        List usefulPeakTaskSet = new ArrayList();
        Iterable $this$forEach$iv = saveList;
        for (Object element$iv : $this$forEach$iv) {
            Splash it = (Splash) element$iv;
            whiteListResSet.addAll(SplashCreativeHelperKt.getAllResHashSet(it));
            usefulPeakTaskSet.addAll(SplashCreativeHelperKt.getActivatePeakIdSet(it));
        }
        Set oldPeakTaskSet = new LinkedHashSet();
        Iterable $this$forEach$iv2 = oldList;
        for (Object element$iv2 : $this$forEach$iv2) {
            Splash it2 = (Splash) element$iv2;
            oldPeakTaskSet.addAll(SplashCreativeHelperKt.getActivatePeakIdSet(it2));
        }
        Set $this$filter$iv = oldPeakTaskSet;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it3 = (String) element$iv$iv;
            if (!usefulPeakTaskSet.contains(it3)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv3 = (List) destination$iv$iv;
        for (Object element$iv3 : $this$forEach$iv3) {
            String it4 = (String) element$iv3;
            PeriodicDownloader.cancel(it4);
        }
        Set $this$map$iv = whiteListResSet;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it5 = (String) item$iv$iv;
            destination$iv$iv2.add(new ResRequest((String) null, it5));
        }
        ResManager.deleteWithWhitelist(bizType, (List) destination$iv$iv2);
    }

    @JvmStatic
    public static final void downloadUsePeak(List<SplashPeakTask> list, Splash splash) {
        Map emptyMap;
        Iterable list2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(list2, "list");
        Intrinsics.checkNotNullParameter(splash, "splash");
        DownloadBizType bizType = splash.splashType == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        Iterable $this$forEach$iv = list2;
        for (Object element$iv : $this$forEach$iv) {
            SplashPeakTask it = (SplashPeakTask) element$iv;
            if (it.getTaskId() != null && it.getUrl() != null && it.getHash() != null && it.getExtra() != null) {
                PeriodicRequest.Builder builder = new PeriodicRequest.Builder();
                String url = it.getUrl();
                if (url == null) {
                    url = "";
                }
                PeriodicRequest.Builder url2 = builder.url(url);
                String taskId = it.getTaskId();
                if (taskId == null) {
                    taskId = "invalid_task";
                }
                PeriodicRequest.Builder effectTime = url2.taskId(taskId).effectTime(it.getEffectTime());
                String hash = it.getHash();
                PeriodicRequest.Builder md5 = effectTime.md5(hash != null ? hash : "");
                HashMap<String, String> extra = it.getExtra();
                if (extra == null || (emptyMap = MapsKt.toMap(extra)) == null) {
                    emptyMap = MapsKt.emptyMap();
                }
                PeriodicRequest request = md5.extra(emptyMap).reportTag("splash").tag(PeakTaskDefine.BizSrc.BUSINESS_SPLASH).bizType(bizType).encrypted(splash.isEncrypted()).build();
                BLog.i(TAG, "downloadUsePeak, enqueue task = " + it.getTaskId());
                PeriodicDownloader.enqueue(request);
            }
        }
    }

    @JvmStatic
    public static final void registerPeakDownloadListener() {
        PeriodicDownloader.observe(new DownloadObserver() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper$registerPeakDownloadListener$1
            public void onSuccess(ResInfo info, ResResponse res) {
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(res, "res");
                BLog.i("[Splash]BusinessSplashResHelper", "onSuccess, taskId = " + info.getTaskId());
                BusinessSplashResHelper.INSTANCE.handlePeriodicDownloaderCallback(info);
            }

            public void onExists(ResInfo info, ResResponse res) {
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(res, "res");
                BLog.i("[Splash]BusinessSplashResHelper", "onExists, taskId = " + info.getTaskId());
            }

            public void onFailure(ResInfo info, int errCode, String errMsg) {
                Intrinsics.checkNotNullParameter(info, "info");
                BLog.i("[Splash]BusinessSplashResHelper", "onFailure, taskId = " + info.getTaskId());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePeriodicDownloaderCallback(ResInfo info) {
        Map map = info.getExtra();
        if (map != null && Intrinsics.areEqual(map.get(PeakTaskDefine.BIZ_SRC), PeakTaskDefine.BizSrc.BUSINESS_SPLASH)) {
            String id = (String) map.get(PeakTaskDefine.SPLASH_ID);
            boolean z = true;
            if (id != null) {
                Splash $this$handlePeriodicDownloaderCallback_u24lambda_u240_u240_u240 = new Splash();
                $this$handlePeriodicDownloaderCallback_u24lambda_u240_u240_u240.id = Long.parseLong(id);
                SplashCustomReporterKt.reportSplashResDownload($this$handlePeriodicDownloaderCallback_u24lambda_u240_u240_u240, true);
            }
            String pairHash = (String) map.get(PeakTaskDefine.PAIR_HASH);
            boolean needReport = true;
            if (pairHash != null) {
                if (!isResourceExistByHash(pairHash) && !isResourceExistByHash(pairHash)) {
                    z = false;
                }
                needReport = z;
            }
            if (needReport) {
                BLog.i(TAG, "handlePeriodicDownloaderCallback, taskId = " + info.getTaskId());
                SplashAdHelper.adSplashDownloadSuccess((String) map.get(PeakTaskDefine.AD_CB));
            }
        }
    }

    private final ResDownloadRequest buildGuideBtnResDownloadRequest(String url, String md5, DownloadBizType bizType) {
        return new ResDownloadRequest(url, md5).md5(md5).bizType(bizType).downloadTag(DOWNLOAD_TAG_BUTTON);
    }
}