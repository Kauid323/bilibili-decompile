package tv.danmaku.bili.splash.ad.utils;

import com.bilibili.base.BiliContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.BezierAnimationElement;
import tv.danmaku.bili.splash.ad.model.ExtSplashGuideButtonKt;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.PeakTaskDefine;
import tv.danmaku.bili.splash.ad.model.SplashEgg;
import tv.danmaku.bili.splash.ad.model.SplashElementAnimation;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashPeakInfo;
import tv.danmaku.bili.splash.ad.model.SplashPeakTask;
import tv.danmaku.bili.splash.ad.model.SplashPeakTaskKt;
import tv.danmaku.bili.splash.ad.model.SplashSecondPageInfo;

/* compiled from: ExtSplashOrderResources.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\u001a\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u0004\u0018\u00010\u0004H\u0002\u001a\u001a\u0010\t\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f*\u0004\u0018\u00010\u0004H\u0000\u001a\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\f*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"TAG", "", "isSplashDownloadEnable", "", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)Z", "getActivatePeakTaskList", "", "Ltv/danmaku/bili/splash/ad/model/SplashPeakTask;", "getPairHash", "hash", "getActivatePeakIdSet", "", "getUnReadyPeakTaskList", "allResHashSet", "getAllResHashSet", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)Ljava/util/Set;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ExtSplashOrderResourcesKt {
    private static final String TAG = "[Splash]SplashCreativeHelper";

    public static final boolean isSplashDownloadEnable(SplashOrder $this$isSplashDownloadEnable) {
        Intrinsics.checkNotNullParameter($this$isSplashDownloadEnable, "<this>");
        if (NetworkUtilsKt.isWifiConnected()) {
            return true;
        }
        if (!$this$isSplashDownloadEnable.getPreLoadEnable()) {
            BLog.e(TAG, $this$isSplashDownloadEnable.getId() + " download abort, cause enable_pre_download: false");
            return false;
        } else if (!NetworkUtilsKt.isMobileConnected()) {
            BLog.e(TAG, $this$isSplashDownloadEnable.getId() + " download abort, cause enable_pre_download: true, but network not 4G/5G");
            return false;
        } else {
            boolean isForeground = BiliContext.isVisible();
            if (!NetworkUtilsKt.isMobileConnected() || isForeground || $this$isSplashDownloadEnable.getBackDownloadEnable()) {
                return true;
            }
            BLog.e(TAG, $this$isSplashDownloadEnable.getId() + " download abort, cause enable_background_download: false, isForeground: false, network: 4G/5G");
            return false;
        }
    }

    private static final List<SplashPeakTask> getActivatePeakTaskList(final SplashOrder $this$getActivatePeakTaskList) {
        Sequence asSequence;
        Sequence filterNotNull;
        Sequence onEach;
        List<SplashPeakTask> list;
        if ($this$getActivatePeakTaskList == null) {
            return CollectionsKt.emptyList();
        }
        SplashPeakInfo peakInfo = $this$getActivatePeakTaskList.getPeakInfo();
        boolean z = false;
        if (peakInfo != null && peakInfo.getEnable()) {
            z = true;
        }
        if (!z || $this$getActivatePeakTaskList.getAdCb() == null) {
            return CollectionsKt.emptyList();
        }
        List<SplashPeakTask> taskList = $this$getActivatePeakTaskList.getPeakInfo().getTaskList();
        if (taskList != null && (asSequence = CollectionsKt.asSequence(taskList)) != null && (filterNotNull = SequencesKt.filterNotNull(asSequence)) != null && (onEach = SequencesKt.onEach(filterNotNull, new Function1() { // from class: tv.danmaku.bili.splash.ad.utils.ExtSplashOrderResourcesKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit activatePeakTaskList$lambda$0;
                activatePeakTaskList$lambda$0 = ExtSplashOrderResourcesKt.getActivatePeakTaskList$lambda$0(SplashOrder.this, (SplashPeakTask) obj);
                return activatePeakTaskList$lambda$0;
            }
        })) != null && (list = SequencesKt.toList(onEach)) != null) {
            return list;
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getActivatePeakTaskList$lambda$0(SplashOrder $this_getActivatePeakTaskList, SplashPeakTask it) {
        String pairHash;
        Intrinsics.checkNotNullParameter(it, "it");
        String taskId = it.getTaskId();
        if (taskId == null || StringsKt.isBlank(taskId)) {
            it.setTaskId($this_getActivatePeakTaskList.getId() + "_" + it.getHash() + "_" + it.getEffectTime());
            if (it.getExtra() == null) {
                it.setExtra(new LinkedHashMap());
            }
            Map extra = it.getExtra();
            if (extra != null) {
                extra.put(PeakTaskDefine.BIZ_SRC, PeakTaskDefine.BizSrc.BUSINESS_SPLASH);
                String adCb = $this_getActivatePeakTaskList.getAdCb();
                if (adCb == null) {
                    adCb = "";
                }
                extra.put(PeakTaskDefine.AD_CB, adCb);
                extra.put(PeakTaskDefine.SPLASH_ID, String.valueOf($this_getActivatePeakTaskList.getId()));
                if (ExtSplashOrderKt.isImageVideoMixCardType($this_getActivatePeakTaskList) && (pairHash = getPairHash($this_getActivatePeakTaskList, it.getHash())) != null) {
                    extra.put(PeakTaskDefine.PAIR_HASH, pairHash);
                }
            }
        }
        return Unit.INSTANCE;
    }

    private static final String getPairHash(SplashOrder $this$getPairHash, String hash) {
        if ($this$getPairHash == null) {
            return null;
        }
        String str = hash;
        if ((str == null || StringsKt.isBlank(str)) || !ExtSplashOrderKt.isImageVideoMixCardType($this$getPairHash)) {
            return null;
        }
        return Intrinsics.areEqual(hash, $this$getPairHash.getImageHash()) ? $this$getPairHash.getVideoHash() : $this$getPairHash.getImageHash();
    }

    public static final Set<String> getActivatePeakIdSet(SplashOrder $this$getActivatePeakIdSet) {
        Iterable $this$mapNotNull$iv = getActivatePeakTaskList($this$getActivatePeakIdSet);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            SplashPeakTask it = (SplashPeakTask) element$iv$iv$iv;
            String taskId = it.getTaskId();
            if (taskId != null) {
                destination$iv$iv.add(taskId);
            }
        }
        return CollectionsKt.toHashSet((List) destination$iv$iv);
    }

    public static final List<SplashPeakTask> getUnReadyPeakTaskList(SplashOrder $this$getUnReadyPeakTaskList) {
        Iterable $this$filter$iv = getActivatePeakTaskList($this$getUnReadyPeakTaskList);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            SplashPeakTask it = (SplashPeakTask) element$iv$iv;
            if (!SplashPeakTaskKt.isResourceExists(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final Set<String> getAllResHashSet(SplashOrder $this$allResHashSet) {
        Iterable animationList;
        String it;
        Iterable secondPageButtons;
        Intrinsics.checkNotNullParameter($this$allResHashSet, "<this>");
        Set sets = new LinkedHashSet();
        String it2 = $this$allResHashSet.getImageHash();
        String str = it2;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            it2 = null;
        }
        if (it2 != null) {
            sets.add(it2);
        }
        String it3 = $this$allResHashSet.getVideoHash();
        String str2 = it3;
        if (str2 == null || StringsKt.isBlank(str2)) {
            it3 = null;
        }
        if (it3 != null) {
            sets.add(it3);
        }
        String it4 = $this$allResHashSet.getLogoHash();
        String str3 = it4;
        if (str3 == null || StringsKt.isBlank(str3)) {
            it4 = null;
        }
        if (it4 != null) {
            sets.add(it4);
        }
        Iterable splashGuideButton = $this$allResHashSet.getSplashGuideButton();
        if (splashGuideButton != null) {
            Iterable $this$forEach$iv = splashGuideButton;
            for (Object element$iv : $this$forEach$iv) {
                sets.addAll(ExtSplashGuideButtonKt.getAllResHashSet((SplashGuideButton) element$iv));
            }
        }
        SplashSecondPageInfo secondPage = $this$allResHashSet.getSecondPage();
        if (secondPage != null && (secondPageButtons = secondPage.getSecondPageButtons()) != null) {
            Iterable $this$forEach$iv2 = secondPageButtons;
            for (Object element$iv2 : $this$forEach$iv2) {
                sets.addAll(ExtSplashGuideButtonKt.getAllResHashSet((SplashGuideButton) element$iv2));
            }
        }
        SplashSecondPageInfo secondPage2 = $this$allResHashSet.getSecondPage();
        if (secondPage2 != null && (it = secondPage2.getSecondVideoHash()) != null) {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it != null) {
                sets.add(it);
            }
        }
        SplashElementAnimation elementAnimation = $this$allResHashSet.getElementAnimation();
        if (elementAnimation != null && (animationList = elementAnimation.getAnimationList()) != null) {
            Iterable $this$forEach$iv3 = animationList;
            for (Object element$iv3 : $this$forEach$iv3) {
                BezierAnimationElement ele = (BezierAnimationElement) element$iv3;
                String it5 = ele.getImageMd5();
                String str4 = it5;
                if (str4 == null || StringsKt.isBlank(str4)) {
                    it5 = null;
                }
                if (it5 != null) {
                    sets.add(it5);
                }
                String it6 = ele.getGuideImageMd5();
                String str5 = it6;
                if (str5 == null || StringsKt.isBlank(str5)) {
                    it6 = null;
                }
                if (it6 != null) {
                    sets.add(it6);
                }
                String it7 = ele.getTopImageMd5();
                String str6 = it7;
                if (str6 == null || StringsKt.isBlank(str6)) {
                    it7 = null;
                }
                if (it7 != null) {
                    sets.add(it7);
                }
            }
        }
        SplashEgg splashEgg = $this$allResHashSet.getSplashEgg();
        String it8 = splashEgg != null ? splashEgg.getVideoHash() : null;
        String str7 = it8;
        String it9 = (str7 == null || StringsKt.isBlank(str7)) ? true : true ? null : it8;
        if (it9 != null) {
            sets.add(it9);
        }
        return sets;
    }
}