package tv.danmaku.bili.splash.ad.utils;

import android.app.Application;
import android.content.Context;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.BezierAnimationElement;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.PeakTaskDefine;
import tv.danmaku.bili.splash.ad.model.SplashEgg;
import tv.danmaku.bili.splash.ad.model.SplashElementAnimation;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashPeakTask;
import tv.danmaku.bili.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.splash.ad.model.SplashShopCard;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: BusinessSplashResHelper.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010J\"\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\"\u0010\u001f\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\rJ\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010$\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\rH\u0002J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00050'0\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010)\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\rJ,\u0010*\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010+\u001a\u00020,H\u0002J\u001c\u0010-\u001a\u00020\u000b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\r2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u00100\u001a\u00020\u000bH\u0007J\u0010\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u000203H\u0002J \u00104\u001a\u0002052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,H\u0002J\u0015\u00106\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b7J\u0015\u00108\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b9J\u000e\u0010:\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Ltv/danmaku/bili/splash/ad/utils/BusinessSplashResHelper;", "", "<init>", "()V", "TAG", "", "DOWNLOAD_TAG_VIDE0", "DOWNLOAD_TAG_IMAGE", "DOWNLOAD_TAG_BUTTON", "DOWNLOAD_TAG_ANIMATION", "downloadButtonRes", "", "buttonList", "", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "adType", "", "downloadMainLogo", "url", "md5", "downloadMainImageSync", "", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "downloadMainVideoSync", "downloadAnimationResourceAsync", "downloadEggResourceAsync", "isResourceExistByHash", "hash", "fetchResourceFileByHash", "Ljava/io/File;", "downloadTopViewRes", "saveList", "oldList", "reportResDownloadSucces", PeakTaskDefine.AD_CB, "deleteTopViewSplashRes", "extractTopViewUrls", "extractTopViewUrlsWithId", "Lkotlin/Pair;", "", "deleteUselessResources", "deleteUselessSplashResAndTask", "bizType", "Lcom/bilibili/lib/resmanager/DownloadBizType;", "downloadUsePeak", "list", "Ltv/danmaku/bili/splash/ad/model/SplashPeakTask;", "registerPeakDownloadListener", "handlePeriodicDownloaderCallback", "info", "Lcom/bilibili/lib/downloader/periodic/ResInfo;", "buildGuideBtnResDownloadRequest", "Lcom/bilibili/lib/resmanager/ResDownloadRequest;", "handleMainImageDownload", "handleMainImageDownload$adsplash_debug", "handleMainVideoDownload", "handleMainVideoDownload$adsplash_debug", "downloadSecondPageEggVideo", "downloadSecondPageEggVideoSync", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
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
    /* JADX WARN: Removed duplicated region for block: B:103:0x01de A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x028a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void downloadButtonRes(List<SplashGuideButton> list, int adType) {
        boolean isGuideImageValid;
        String jumpImageUrl;
        boolean isJumpImageValid;
        String schemaImageUrl;
        boolean isSchemaImageValid;
        String logoUrl;
        boolean isLogoImageValid;
        List $this$fastForEach$iv;
        Iterable $this$forEach$iv;
        List $this$fastForEach$iv2;
        int i;
        Iterable $this$forEach$iv2;
        boolean z = true;
        DownloadBizType bizType = adType == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        if (list == null) {
            return;
        }
        List<SplashGuideButton> $this$forEach$iv3 = list;
        for (Object element$iv : $this$forEach$iv3) {
            SplashGuideButton it = (SplashGuideButton) element$iv;
            List list2 = new ArrayList();
            String guideImageUrl = it.getGuideImageUrl();
            if (!((guideImageUrl == null || StringsKt.isBlank(guideImageUrl)) ? z : false)) {
                String guideImageMD5 = it.getGuideImageMD5();
                if (!((guideImageMD5 == null || StringsKt.isBlank(guideImageMD5)) ? z : false)) {
                    isGuideImageValid = z;
                    if (isGuideImageValid && !INSTANCE.isResourceExistByHash(it.getGuideImageMD5())) {
                        BusinessSplashResHelper businessSplashResHelper = INSTANCE;
                        String guideImageUrl2 = it.getGuideImageUrl();
                        Intrinsics.checkNotNull(guideImageUrl2);
                        String guideImageMD52 = it.getGuideImageMD5();
                        Intrinsics.checkNotNull(guideImageMD52);
                        list2.add(businessSplashResHelper.buildGuideBtnResDownloadRequest(guideImageUrl2, guideImageMD52, bizType));
                        BLog.i(TAG, "download guide image. url = " + it.getGuideImageUrl());
                    }
                    jumpImageUrl = it.getJumpImageUrl();
                    if (!((jumpImageUrl != null || StringsKt.isBlank(jumpImageUrl)) ? z : false)) {
                        String jumpImageMD5 = it.getJumpImageMD5();
                        if (!((jumpImageMD5 == null || StringsKt.isBlank(jumpImageMD5)) ? z : false)) {
                            isJumpImageValid = z;
                            if (isJumpImageValid && !INSTANCE.isResourceExistByHash(it.getJumpImageMD5())) {
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
                                    if (isSchemaImageValid && !INSTANCE.isResourceExistByHash(it.getSchemaImageMD5())) {
                                        BusinessSplashResHelper businessSplashResHelper3 = INSTANCE;
                                        String schemaImageUrl2 = it.getSchemaImageUrl();
                                        Intrinsics.checkNotNull(schemaImageUrl2);
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
                                            if (!isLogoImageValid && !INSTANCE.isResourceExistByHash(it.getLogoImageMD5())) {
                                                BusinessSplashResHelper businessSplashResHelper4 = INSTANCE;
                                                String logoUrl2 = it.getLogoUrl();
                                                Intrinsics.checkNotNull(logoUrl2);
                                                String logoImageMD52 = it.getLogoImageMD5();
                                                Intrinsics.checkNotNull(logoImageMD52);
                                                list2.add(businessSplashResHelper4.buildGuideBtnResDownloadRequest(logoUrl2, logoImageMD52, bizType));
                                                BLog.i(TAG, "download logo image. url = " + it.getLogoUrl());
                                            }
                                            $this$fastForEach$iv = it.getShopCards();
                                            if ($this$fastForEach$iv == null) {
                                                $this$forEach$iv = $this$forEach$iv3;
                                            } else {
                                                int index$iv = 0;
                                                int $i$f$fastForEach = $this$fastForEach$iv.size();
                                                while (index$iv < $i$f$fastForEach) {
                                                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                                                    SplashShopCard card = (SplashShopCard) item$iv;
                                                    String imageHash = card.getImageHash();
                                                    if (!(imageHash == null || StringsKt.isBlank(imageHash))) {
                                                        String image = card.getImage();
                                                        if (!(image == null || StringsKt.isBlank(image)) && !BusinessSplashResHelperKt.isFileExistByMd5(card.getImageHash())) {
                                                            $this$fastForEach$iv2 = $this$fastForEach$iv;
                                                            i = $i$f$fastForEach;
                                                            $this$forEach$iv2 = $this$forEach$iv3;
                                                            list2.add(INSTANCE.buildGuideBtnResDownloadRequest(card.getImage(), card.getImageHash(), bizType));
                                                            BLog.i(TAG, "download logo image. url = " + card.getImage());
                                                            index$iv++;
                                                            $this$fastForEach$iv = $this$fastForEach$iv2;
                                                            $i$f$fastForEach = i;
                                                            $this$forEach$iv3 = $this$forEach$iv2;
                                                        }
                                                    }
                                                    $this$fastForEach$iv2 = $this$fastForEach$iv;
                                                    i = $i$f$fastForEach;
                                                    $this$forEach$iv2 = $this$forEach$iv3;
                                                    index$iv++;
                                                    $this$fastForEach$iv = $this$fastForEach$iv2;
                                                    $i$f$fastForEach = i;
                                                    $this$forEach$iv3 = $this$forEach$iv2;
                                                }
                                                $this$forEach$iv = $this$forEach$iv3;
                                            }
                                            if (!list2.isEmpty()) {
                                                ResManager.downloadBatch(list2);
                                            }
                                            $this$forEach$iv3 = $this$forEach$iv;
                                            z = true;
                                        }
                                    }
                                    isLogoImageValid = false;
                                    if (!isLogoImageValid) {
                                        BusinessSplashResHelper businessSplashResHelper42 = INSTANCE;
                                        String logoUrl22 = it.getLogoUrl();
                                        Intrinsics.checkNotNull(logoUrl22);
                                        String logoImageMD522 = it.getLogoImageMD5();
                                        Intrinsics.checkNotNull(logoImageMD522);
                                        list2.add(businessSplashResHelper42.buildGuideBtnResDownloadRequest(logoUrl22, logoImageMD522, bizType));
                                        BLog.i(TAG, "download logo image. url = " + it.getLogoUrl());
                                    }
                                    $this$fastForEach$iv = it.getShopCards();
                                    if ($this$fastForEach$iv == null) {
                                    }
                                    if (!list2.isEmpty()) {
                                    }
                                    $this$forEach$iv3 = $this$forEach$iv;
                                    z = true;
                                }
                            }
                            isSchemaImageValid = false;
                            if (isSchemaImageValid) {
                                BusinessSplashResHelper businessSplashResHelper32 = INSTANCE;
                                String schemaImageUrl22 = it.getSchemaImageUrl();
                                Intrinsics.checkNotNull(schemaImageUrl22);
                                String schemaImageMD522 = it.getSchemaImageMD5();
                                Intrinsics.checkNotNull(schemaImageMD522);
                                list2.add(businessSplashResHelper32.buildGuideBtnResDownloadRequest(schemaImageUrl22, schemaImageMD522, bizType));
                                BLog.i(TAG, "download schema image. url = " + it.getSchemaImageUrl());
                            }
                            logoUrl = it.getLogoUrl();
                            if (!(logoUrl != null || StringsKt.isBlank(logoUrl))) {
                            }
                            isLogoImageValid = false;
                            if (!isLogoImageValid) {
                            }
                            $this$fastForEach$iv = it.getShopCards();
                            if ($this$fastForEach$iv == null) {
                            }
                            if (!list2.isEmpty()) {
                            }
                            $this$forEach$iv3 = $this$forEach$iv;
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
                    logoUrl = it.getLogoUrl();
                    if (!(logoUrl != null || StringsKt.isBlank(logoUrl))) {
                    }
                    isLogoImageValid = false;
                    if (!isLogoImageValid) {
                    }
                    $this$fastForEach$iv = it.getShopCards();
                    if ($this$fastForEach$iv == null) {
                    }
                    if (!list2.isEmpty()) {
                    }
                    $this$forEach$iv3 = $this$forEach$iv;
                    z = true;
                }
            }
            isGuideImageValid = false;
            if (isGuideImageValid) {
                BusinessSplashResHelper businessSplashResHelper5 = INSTANCE;
                String guideImageUrl22 = it.getGuideImageUrl();
                Intrinsics.checkNotNull(guideImageUrl22);
                String guideImageMD522 = it.getGuideImageMD5();
                Intrinsics.checkNotNull(guideImageMD522);
                list2.add(businessSplashResHelper5.buildGuideBtnResDownloadRequest(guideImageUrl22, guideImageMD522, bizType));
                BLog.i(TAG, "download guide image. url = " + it.getGuideImageUrl());
            }
            jumpImageUrl = it.getJumpImageUrl();
            if (!((jumpImageUrl != null || StringsKt.isBlank(jumpImageUrl)) ? z : false)) {
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
            logoUrl = it.getLogoUrl();
            if (!(logoUrl != null || StringsKt.isBlank(logoUrl))) {
            }
            isLogoImageValid = false;
            if (!isLogoImageValid) {
            }
            $this$fastForEach$iv = it.getShopCards();
            if ($this$fastForEach$iv == null) {
            }
            if (!list2.isEmpty()) {
            }
            $this$forEach$iv3 = $this$forEach$iv;
            z = true;
        }
    }

    public final void downloadMainLogo(String url, String md5, int adType) {
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
        ResManager.download$default(buildGuideBtnResDownloadRequest(url, md5, bizType), (ResCallback) null, 2, (Object) null);
    }

    private final boolean downloadMainImageSync(SplashOrder splash) {
        boolean isExists = isResourceExistByHash(splash.getImageHash());
        long id = splash.getId();
        String imageUrl = splash.getImageUrl();
        BLog.i(TAG, "downloadMainImageSync, already download = " + isExists + ", splashId = " + id + ", imageUrl = " + imageUrl + ", imageHash = " + splash.getImageHash() + ", isEffectiveSplash = " + (splash.getSplashType() == 1));
        if (isExists) {
            return true;
        }
        DownloadBizType bizType = splash.getSplashType() == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        ResDownloadRequest imageRequest = new ResDownloadRequest(splash.getImageUrl(), splash.getImageHash()).encrypted(ExtSplashOrderKt.isEncrypted(splash)).md5(splash.getImageHash()).bizType(bizType).downloadTag(DOWNLOAD_TAG_IMAGE);
        return ResManager.downloadSync(imageRequest);
    }

    private final boolean downloadMainVideoSync(SplashOrder splash) {
        boolean isExists = isResourceExistByHash(splash.getVideoHash());
        long id = splash.getId();
        String videoUrl = splash.getVideoUrl();
        BLog.i(TAG, "downloadMainVideoSync, already download = " + isExists + " , splashId = " + id + ", videoUrl = " + videoUrl + ", videoHash = " + splash.getVideoHash() + ", isEffectiveSplash = " + (splash.getSplashType() == 1));
        if (isExists) {
            return true;
        }
        DownloadBizType bizType = splash.getSplashType() == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        ResDownloadRequest videoRequest = new ResDownloadRequest(splash.getVideoUrl(), splash.getVideoHash()).encrypted(ExtSplashOrderKt.isEncrypted(splash)).md5(splash.getVideoHash()).bizType(bizType).downloadTag(DOWNLOAD_TAG_VIDE0);
        return ResManager.downloadSync(videoRequest);
    }

    public final void downloadAnimationResourceAsync(SplashOrder splash) {
        DownloadBizType bizType;
        Iterable animationList;
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        if (splash.getSplashType() == 1) {
            bizType = DownloadBizType.EffectSplash;
        } else {
            bizType = DownloadBizType.Splash;
        }
        Map downloadMap = new LinkedHashMap();
        SplashElementAnimation elementAnimation = splash.getElementAnimation();
        if (elementAnimation != null && (animationList = elementAnimation.getAnimationList()) != null) {
            Iterable $this$forEach$iv = animationList;
            for (Object element$iv : $this$forEach$iv) {
                BezierAnimationElement ele = (BezierAnimationElement) element$iv;
                String imageUrl = ele.getImageUrl();
                boolean z = false;
                if (!(imageUrl == null || StringsKt.isBlank(imageUrl))) {
                    String imageMd5 = ele.getImageMd5();
                    if (!(imageMd5 == null || StringsKt.isBlank(imageMd5))) {
                        downloadMap.put(ele.getImageMd5(), ele.getImageUrl());
                    }
                }
                String guideImageUrl = ele.getGuideImageUrl();
                if (!(guideImageUrl == null || StringsKt.isBlank(guideImageUrl))) {
                    String guideImageMd5 = ele.getGuideImageMd5();
                    if (!(guideImageMd5 == null || StringsKt.isBlank(guideImageMd5))) {
                        downloadMap.put(ele.getGuideImageMd5(), ele.getGuideImageUrl());
                    }
                }
                String topImageUrl = ele.getTopImageUrl();
                if (!(topImageUrl == null || StringsKt.isBlank(topImageUrl))) {
                    String topImageMd5 = ele.getTopImageMd5();
                    if (!((topImageMd5 == null || StringsKt.isBlank(topImageMd5)) ? true : true)) {
                        downloadMap.put(ele.getTopImageMd5(), ele.getTopImageUrl());
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

    public final void downloadEggResourceAsync(SplashOrder splash) {
        String hash;
        String videoUrl;
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        SplashEgg splashEgg = splash.getSplashEgg();
        if (splashEgg == null || (hash = splashEgg.getVideoHash()) == null || (videoUrl = splash.getSplashEgg().getVideoUrl()) == null || isResourceExistByHash(hash)) {
            return;
        }
        DownloadBizType bizType = splash.getSplashType() == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        ResDownloadRequest videoRequest = new ResDownloadRequest(videoUrl, hash).encrypted(ExtSplashOrderKt.isEncrypted(splash)).md5(hash).bizType(bizType).downloadTag(DOWNLOAD_TAG_VIDE0);
        ResManager.downloadSync(videoRequest);
    }

    public final boolean isResourceExistByHash(String hash) {
        String str = hash;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        return ResManager.isFileExist(new ResRequest((String) null, hash));
    }

    public final File fetchResourceFileByHash(String hash) {
        ResResponse fetch;
        File it;
        String str = hash;
        if ((str == null || StringsKt.isBlank(str)) || (fetch = ResManager.fetch(new ResRequest((String) null, hash))) == null || (it = fetch.getFile()) == null || !it.exists()) {
            return null;
        }
        return it;
    }

    public final void downloadTopViewRes(List<SplashOrder> list, List<SplashOrder> list2) {
        Intrinsics.checkNotNullParameter(list, "saveList");
        Intrinsics.checkNotNullParameter(list2, "oldList");
        BLog.i(TAG, "downloadTopViewRes");
        Context context = BiliContext.application();
        List<SplashOrder> allResList = new ArrayList(list);
        allResList.addAll(list2);
        long currentTime = System.currentTimeMillis() / 1000;
        ITopViewResFileHelper topViewResFileHelper = GAdBizKt.getGAdPegasus().getBanner().getTopViewResFileHelper();
        for (SplashOrder splash : allResList) {
            if (splash.getId() > 0 && ExtSplashOrderKt.getHasTopViewResInfo(splash) && currentTime <= splash.getEndTime()) {
                if (!ExtSplashOrderResourcesKt.isSplashDownloadEnable(splash)) {
                    SplashCustomReporterKt.reportSplashDownloadDisable(splash);
                } else {
                    JsonObject it = splash.getExtra();
                    if (it != null) {
                        JsonElement jsonElement = it.get("topview_pic_url");
                        String topPicUrl = jsonElement != null ? jsonElement.getAsString() : null;
                        JsonElement jsonElement2 = it.get("topview_video_url");
                        String topVideoUrl = jsonElement2 != null ? jsonElement2.getAsString() : null;
                        JsonElement jsonElement3 = it.get("topview_3d_url");
                        String top3dVideoUrl = jsonElement3 != null ? jsonElement3.getAsString() : null;
                        String str = topPicUrl;
                        boolean z = false;
                        if (!(str == null || StringsKt.isBlank(str))) {
                            Intrinsics.checkNotNull(context);
                            boolean isTopViewPicSuccess = topViewResFileHelper.downloadPicResource(context, splash.getId(), topPicUrl);
                            if (isTopViewPicSuccess) {
                                BusinessSplashResHelper businessSplashResHelper = INSTANCE;
                                String adCb = splash.getAdCb();
                                Intrinsics.checkNotNull(adCb);
                                businessSplashResHelper.reportResDownloadSucces(adCb, topPicUrl);
                            }
                        }
                        String str2 = topVideoUrl;
                        if (!(str2 == null || StringsKt.isBlank(str2))) {
                            Intrinsics.checkNotNull(context);
                            boolean isTopViewVideoSuccess = topViewResFileHelper.downloadVideoResource(context, splash.getId(), topVideoUrl);
                            if (isTopViewVideoSuccess) {
                                BusinessSplashResHelper businessSplashResHelper2 = INSTANCE;
                                String adCb2 = splash.getAdCb();
                                Intrinsics.checkNotNull(adCb2);
                                businessSplashResHelper2.reportResDownloadSucces(adCb2, topVideoUrl);
                            }
                        }
                        String str3 = top3dVideoUrl;
                        if (!((str3 == null || StringsKt.isBlank(str3)) ? true : true)) {
                            Intrinsics.checkNotNull(context);
                            boolean isTopView3dVideoSuccess = topViewResFileHelper.downloadVideoResource(context, splash.getId(), top3dVideoUrl);
                            if (isTopView3dVideoSuccess) {
                                BusinessSplashResHelper businessSplashResHelper3 = INSTANCE;
                                String adCb3 = splash.getAdCb();
                                Intrinsics.checkNotNull(adCb3);
                                businessSplashResHelper3.reportResDownloadSucces(adCb3, top3dVideoUrl);
                            }
                        }
                    }
                }
            }
        }
    }

    private final void reportResDownloadSucces(String adCb, String url) {
        GAdCoreKt.getGAdReport().uiEvent("cre_dl_suc", new SimpleAdReportPreset(adCb, url));
    }

    private final void deleteTopViewSplashRes(SplashOrder splash) {
        JsonObject extra = splash.getExtra();
        if (extra == null) {
            return;
        }
        Context context = BiliContext.application();
        if (!ExtSplashOrderKt.isTimeValid(splash) && ExtSplashOrderKt.getHasTopViewResInfo(splash)) {
            ITopViewResFileHelper topViewResFileHelper = GAdBizKt.getGAdPegasus().getBanner().getTopViewResFileHelper();
            Intrinsics.checkNotNull(context);
            topViewResFileHelper.deleteResource(context, splash.getId(), extra);
        }
    }

    private final void deleteTopViewSplashRes(final List<SplashOrder> list, List<SplashOrder> list2) {
        List<SplashOrder> $this$flatMap$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            SplashOrder p0 = (SplashOrder) element$iv$iv;
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
        Sequence $this$forEach$iv = SequencesKt.filter(SequencesKt.filterNot(CollectionsKt.asSequence(list2), new Function1() { // from class: tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean deleteTopViewSplashRes$lambda$1;
                deleteTopViewSplashRes$lambda$1 = BusinessSplashResHelper.deleteTopViewSplashRes$lambda$1(list, (SplashOrder) obj);
                return Boolean.valueOf(deleteTopViewSplashRes$lambda$1);
            }
        }), new Function1() { // from class: tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean deleteTopViewSplashRes$lambda$2;
                deleteTopViewSplashRes$lambda$2 = BusinessSplashResHelper.deleteTopViewSplashRes$lambda$2(referencedUrlOnlySet, (SplashOrder) obj);
                return Boolean.valueOf(deleteTopViewSplashRes$lambda$2);
            }
        });
        for (Object element$iv : $this$forEach$iv) {
            SplashOrder p02 = (SplashOrder) element$iv;
            deleteTopViewSplashRes(p02);
        }
        ITopViewResFileHelper resHelper = GAdBizKt.getGAdPegasus().getBanner().getTopViewResFileHelper();
        Iterable $this$forEach$iv2 = referencedUrlsWithId;
        for (Object element$iv2 : $this$forEach$iv2) {
            Pair pair = (Pair) element$iv2;
            long id = ((Number) pair.component1()).longValue();
            String url = (String) pair.component2();
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            resHelper.renameToUrlHash(application, id, url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteTopViewSplashRes$lambda$1(List $saveList, SplashOrder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $saveList.contains(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteTopViewSplashRes$lambda$2(Set $referencedUrlOnlySet, SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
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

    private final List<String> extractTopViewUrls(SplashOrder splash) {
        JsonObject extra = splash.getExtra();
        if (extra == null) {
            return CollectionsKt.emptyList();
        }
        JsonElement jsonElement = extra.get("topview_pic_url");
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        JsonElement jsonElement2 = extra.get("topview_video_url");
        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
        JsonElement jsonElement3 = extra.get("topview_3d_url");
        return CollectionsKt.listOfNotNull(new String[]{asString, asString2, jsonElement3 != null ? jsonElement3.getAsString() : null});
    }

    private final List<Pair<Long, String>> extractTopViewUrlsWithId(SplashOrder splash) {
        long id = splash.getId();
        Iterable $this$map$iv = extractTopViewUrls(splash);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(TuplesKt.to(Long.valueOf(id), it));
        }
        return (List) destination$iv$iv;
    }

    public final void deleteUselessResources(List<SplashOrder> list, List<SplashOrder> list2) {
        Intrinsics.checkNotNullParameter(list, "saveList");
        Intrinsics.checkNotNullParameter(list2, "oldList");
        boolean isShowing = SplashUtilsKt.isSplashShowing();
        BLog.i(TAG, "deleteUselessResources, isSplashShowing = " + isShowing);
        if (!isShowing) {
            List<SplashOrder> $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                SplashOrder it = (SplashOrder) element$iv$iv;
                if (it.getSplashType() == 0) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            ArrayList arrayList = (List) destination$iv$iv;
            List<SplashOrder> $this$filter$iv2 = list2;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv2) {
                SplashOrder it2 = (SplashOrder) element$iv$iv2;
                SplashOrder it3 = it2.getSplashType() == 0 ? 1 : null;
                if (it3 != null) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            deleteUselessSplashResAndTask(arrayList, (List) destination$iv$iv2, DownloadBizType.Splash);
            List<SplashOrder> $this$filter$iv3 = list;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv3 : $this$filter$iv3) {
                SplashOrder it4 = (SplashOrder) element$iv$iv3;
                SplashOrder it5 = it4.getSplashType() == 1 ? 1 : null;
                if (it5 != null) {
                    destination$iv$iv3.add(element$iv$iv3);
                }
            }
            ArrayList arrayList2 = (List) destination$iv$iv3;
            List<SplashOrder> $this$filter$iv4 = list2;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv4 : $this$filter$iv4) {
                SplashOrder it6 = (SplashOrder) element$iv$iv4;
                if (it6.getSplashType() == 1) {
                    destination$iv$iv4.add(element$iv$iv4);
                }
            }
            deleteUselessSplashResAndTask(arrayList2, (List) destination$iv$iv4, DownloadBizType.EffectSplash);
            deleteTopViewSplashRes(list, list2);
        }
    }

    private final void deleteUselessSplashResAndTask(List<SplashOrder> list, List<SplashOrder> list2, DownloadBizType bizType) {
        BLog.i(TAG, "deleteUselessSplashResAndTask");
        Set whiteListResSet = new LinkedHashSet();
        whiteListResSet.add(BusinessSplashResHelperKt.access$getBackupBirthdayResourceKey());
        List usefulPeakTaskSet = new ArrayList();
        List<SplashOrder> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            SplashOrder it = (SplashOrder) element$iv;
            whiteListResSet.addAll(ExtSplashOrderResourcesKt.getAllResHashSet(it));
            usefulPeakTaskSet.addAll(ExtSplashOrderResourcesKt.getActivatePeakIdSet(it));
        }
        Set oldPeakTaskSet = new LinkedHashSet();
        List<SplashOrder> $this$forEach$iv2 = list2;
        for (Object element$iv2 : $this$forEach$iv2) {
            SplashOrder it2 = (SplashOrder) element$iv2;
            oldPeakTaskSet.addAll(ExtSplashOrderResourcesKt.getActivatePeakIdSet(it2));
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

    public final void downloadUsePeak(List<SplashPeakTask> list, SplashOrder splash) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        DownloadBizType bizType = splash.getSplashType() == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        List<SplashPeakTask> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            SplashPeakTask it = (SplashPeakTask) element$iv;
            if (it.getTaskId() != null && it.getUrl() != null && it.getHash() != null && it.getExtra() != null) {
                PeriodicRequest.Builder url = new PeriodicRequest.Builder().url(it.getUrl());
                String taskId = it.getTaskId();
                if (taskId == null) {
                    taskId = "invalid_task";
                }
                PeriodicRequest.Builder md5 = url.taskId(taskId).effectTime(it.getEffectTime()).md5(it.getHash());
                Map<String, String> extra = it.getExtra();
                if (extra == null || (emptyMap = MapsKt.toMap(extra)) == null) {
                    emptyMap = MapsKt.emptyMap();
                }
                PeriodicRequest request = md5.extra(emptyMap).reportTag(UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH).tag(PeakTaskDefine.BizSrc.BUSINESS_SPLASH).bizType(bizType).encrypted(ExtSplashOrderKt.isEncrypted(splash)).build();
                BLog.i(TAG, "downloadUsePeak, enqueue task = " + it.getTaskId());
                PeriodicDownloader.enqueue(request);
            }
        }
    }

    @JvmStatic
    public static final void registerPeakDownloadListener() {
        PeriodicDownloader.observe(new DownloadObserver() { // from class: tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper$registerPeakDownloadListener$1
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
                SplashCustomReporterKt.reportSplashResDownload(new SplashOrder(Long.parseLong(id), 0L, 0, 0, 0, 0, 0, 0L, 0L, 0L, null, null, null, null, null, null, 0, 0, null, null, null, null, 0, null, null, 0, 0, null, 0L, null, null, false, false, null, false, null, 0, 0, 0.0f, 0L, 0L, 0L, null, null, 0, false, false, 0, null, 0, 0, null, null, null, null, null, 0, null, null, false, null, 0L, null, null, 0, false, 0L, false, -2, -1, 15, null), true);
            }
            String pairHash = (String) map.get(PeakTaskDefine.PAIR_HASH);
            boolean needReport = true;
            if (pairHash != null) {
                if (!INSTANCE.isResourceExistByHash(pairHash) && !INSTANCE.isResourceExistByHash(pairHash)) {
                    z = false;
                }
                needReport = z;
            }
            if (needReport) {
                BLog.i(TAG, "handlePeriodicDownloaderCallback, taskId = " + info.getTaskId());
                SplashAdHelper.INSTANCE.adSplashDownloadSuccess$adsplash_debug((String) map.get(PeakTaskDefine.AD_CB));
            }
        }
    }

    private final ResDownloadRequest buildGuideBtnResDownloadRequest(String url, String md5, DownloadBizType bizType) {
        return new ResDownloadRequest(url, md5).md5(md5).bizType(bizType).downloadTag(DOWNLOAD_TAG_BUTTON);
    }

    public final void handleMainImageDownload$adsplash_debug(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        String imageUrl = splash.getImageUrl();
        boolean z = false;
        if (imageUrl == null || StringsKt.isBlank(imageUrl)) {
            return;
        }
        String imageHash = splash.getImageHash();
        if (imageHash == null || StringsKt.isBlank(imageHash)) {
            z = true;
        }
        if (z) {
            return;
        }
        boolean isLocalVideoExists = isResourceExistByHash(splash.getVideoHash());
        boolean isLocalImageExists = isResourceExistByHash(splash.getImageHash());
        boolean isDownloadSuccessViaNet = false;
        if (!isLocalImageExists) {
            isDownloadSuccessViaNet = downloadMainImageSync(splash);
            BLog.i(TAG, "handleMainImageDownload, tech report, imageHash = " + splash.getImageHash() + ", splashId = " + splash.getId() + ", isDownloadSuccessViaNet = " + isDownloadSuccessViaNet + ", cardType = " + splash.getCardType());
            SplashCustomReporterKt.reportSplashResDownload(splash, isDownloadSuccessViaNet);
        }
        if (ExtSplashOrderKt.isImageVideoMixCardType(splash)) {
            if (isLocalVideoExists && isDownloadSuccessViaNet) {
                SplashAdHelper.INSTANCE.adSplashDownloadSuccess$adsplash_debug(splash.getAdCb());
            }
        } else if (ExtSplashOrderKt.isOnlyImageSplash(splash) && isDownloadSuccessViaNet) {
            SplashAdHelper.INSTANCE.adSplashDownloadSuccess$adsplash_debug(splash.getAdCb());
        }
    }

    public final void handleMainVideoDownload$adsplash_debug(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        String videoUrl = splash.getVideoUrl();
        boolean z = false;
        if (videoUrl == null || StringsKt.isBlank(videoUrl)) {
            return;
        }
        String videoHash = splash.getVideoHash();
        if (videoHash == null || StringsKt.isBlank(videoHash)) {
            z = true;
        }
        if (z) {
            return;
        }
        boolean isLocalVideoExists = isResourceExistByHash(splash.getVideoHash());
        boolean isLocalImageExists = isResourceExistByHash(splash.getImageHash());
        boolean isDownloadSuccessViaNet = false;
        if (!isLocalVideoExists) {
            isDownloadSuccessViaNet = downloadMainVideoSync(splash);
            BLog.d(TAG, "handleMainVideoDownload, tech report,  videoHash = " + splash.getVideoHash() + ", splashId = " + splash.getId() + ", isDownloadSuccessViaNet = " + isDownloadSuccessViaNet + ", cardType = " + splash.getType());
            SplashCustomReporterKt.reportSplashResDownload(splash, isDownloadSuccessViaNet);
        }
        if (ExtSplashOrderKt.isImageVideoMixCardType(splash)) {
            if (isLocalImageExists && isDownloadSuccessViaNet) {
                SplashAdHelper.INSTANCE.adSplashDownloadSuccess$adsplash_debug(splash.getAdCb());
            }
        } else if (ExtSplashOrderKt.isOnlyVideoSplash(splash) && isDownloadSuccessViaNet) {
            SplashAdHelper.INSTANCE.adSplashDownloadSuccess$adsplash_debug(splash.getAdCb());
        }
    }

    public final void downloadSecondPageEggVideo(SplashOrder splash) {
        SplashSecondPageInfo secondPage;
        String hash;
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        if (ExtSplashOrderKt.getHasSecondPageEggVideo(splash) && (secondPage = splash.getSecondPage()) != null && (hash = secondPage.getSecondVideoHash()) != null) {
            if (StringsKt.isBlank(hash)) {
                hash = null;
            }
            if (hash == null) {
                return;
            }
            boolean isLocalVideoExists = isResourceExistByHash(hash);
            if (!isLocalVideoExists) {
                boolean isDownloadSuccessViaNet = downloadSecondPageEggVideoSync(splash);
                BLog.d(TAG, "handleSecondPageEggVideoDownload, tech report,  videoHash = " + hash + ", splashId = " + splash.getId() + " type = " + splash.getType() + " ,netSuccess = " + isDownloadSuccessViaNet + " ");
            }
        }
    }

    private final boolean downloadSecondPageEggVideoSync(SplashOrder splash) {
        SplashSecondPageInfo secondPage = splash.getSecondPage();
        boolean isExists = isResourceExistByHash(secondPage != null ? secondPage.getSecondVideoHash() : null);
        long id = splash.getId();
        SplashSecondPageInfo secondPage2 = splash.getSecondPage();
        String secondVideoUrl = secondPage2 != null ? secondPage2.getSecondVideoUrl() : null;
        SplashSecondPageInfo secondPage3 = splash.getSecondPage();
        BLog.i(TAG, "downloadSecondPageEggVideoSync, already download = " + isExists + " , splashId = " + id + ", videoUrl = " + secondVideoUrl + ", videoHash = " + (secondPage3 != null ? secondPage3.getSecondVideoHash() : null) + ", isEffectiveSplash = " + (splash.getSplashType() == 1));
        if (isExists) {
            return true;
        }
        DownloadBizType bizType = splash.getSplashType() == 1 ? DownloadBizType.EffectSplash : DownloadBizType.Splash;
        SplashSecondPageInfo secondPage4 = splash.getSecondPage();
        String secondVideoUrl2 = secondPage4 != null ? secondPage4.getSecondVideoUrl() : null;
        SplashSecondPageInfo secondPage5 = splash.getSecondPage();
        ResDownloadRequest encrypted = new ResDownloadRequest(secondVideoUrl2, secondPage5 != null ? secondPage5.getSecondVideoHash() : null).encrypted(ExtSplashOrderKt.isEncrypted(splash));
        SplashSecondPageInfo secondPage6 = splash.getSecondPage();
        ResDownloadRequest videoRequest = encrypted.md5(secondPage6 != null ? secondPage6.getSecondVideoHash() : null).bizType(bizType).downloadTag(DOWNLOAD_TAG_VIDE0);
        return ResManager.downloadSync(videoRequest);
    }
}