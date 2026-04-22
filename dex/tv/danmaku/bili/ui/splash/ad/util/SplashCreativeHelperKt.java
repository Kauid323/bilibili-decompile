package tv.danmaku.bili.ui.splash.ad.util;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.splash.ad.model.BezierAnimationElement;
import tv.danmaku.bili.ui.splash.ad.model.PeakTaskDefine;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashEgg;
import tv.danmaku.bili.ui.splash.ad.model.SplashElementAnimation;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButtonKt;
import tv.danmaku.bili.ui.splash.ad.model.SplashPeakInfo;
import tv.danmaku.bili.ui.splash.ad.model.SplashPeakTask;
import tv.danmaku.bili.ui.splash.ad.model.SplashPeakTaskKt;
import tv.danmaku.bili.ui.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashCreativeHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u0004\u0018\u00010\u0002\u001a\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b*\u0004\u0018\u00010\u0002\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u0004\u0018\u00010\u0002\"\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"isVideo", "", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "isMainResourcesReady", "getActivatePeakTaskList", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashPeakTask;", "getPairHash", "", "hash", "getActivatePeakIdSet", "", "getUnReadyPeakTaskList", "allResHashSet", "getAllResHashSet", "(Ltv/danmaku/bili/ui/splash/ad/model/Splash;)Ljava/util/Set;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashCreativeHelperKt {
    public static final boolean isVideo(Splash $this$isVideo) {
        if ($this$isVideo == null) {
            return false;
        }
        return $this$isVideo.cardType == 16 || $this$isVideo.cardType == 39 || $this$isVideo.cardType == 109 || $this$isVideo.cardType == 152;
    }

    public static final boolean isMainResourcesReady(Splash $this$isMainResourcesReady) {
        if ($this$isMainResourcesReady == null) {
            return false;
        }
        return SplashCreativeHelper.isImageVideoMixCardType($this$isMainResourcesReady) ? (BusinessSplashResHelperKt.md5ToFileUri($this$isMainResourcesReady.videoHash) == null || BusinessSplashResHelperKt.md5ToFileUri($this$isMainResourcesReady.imageHash) == null) ? false : true : SplashCreativeHelper.isOnlyImageCardType($this$isMainResourcesReady) ? BusinessSplashResHelperKt.md5ToFileUri($this$isMainResourcesReady.imageHash) != null : SplashCreativeHelper.isOnlyVideoCardType($this$isMainResourcesReady) && BusinessSplashResHelperKt.md5ToFileUri($this$isMainResourcesReady.videoHash) != null;
    }

    public static final List<SplashPeakTask> getActivatePeakTaskList(final Splash $this$getActivatePeakTaskList) {
        List emptyList;
        List<SplashPeakTask> taskList;
        Sequence asSequence;
        Sequence filterNotNull;
        Sequence onEach;
        SplashPeakInfo splashPeakInfo;
        boolean z = false;
        if ($this$getActivatePeakTaskList != null && (splashPeakInfo = $this$getActivatePeakTaskList.peakInfo) != null && splashPeakInfo.getEnable()) {
            z = true;
        }
        if (!z || $this$getActivatePeakTaskList.adCb == null) {
            return EnhancedUnmodifiabilityKt.unmodifiable(CollectionsKt.emptyList());
        }
        SplashPeakInfo splashPeakInfo2 = $this$getActivatePeakTaskList.peakInfo;
        if (splashPeakInfo2 == null || (taskList = splashPeakInfo2.getTaskList()) == null || (asSequence = CollectionsKt.asSequence(taskList)) == null || (filterNotNull = SequencesKt.filterNotNull(asSequence)) == null || (onEach = SequencesKt.onEach(filterNotNull, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.util.SplashCreativeHelperKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit activatePeakTaskList$lambda$0;
                activatePeakTaskList$lambda$0 = SplashCreativeHelperKt.getActivatePeakTaskList$lambda$0(Splash.this, (SplashPeakTask) obj);
                return activatePeakTaskList$lambda$0;
            }
        })) == null || (emptyList = SequencesKt.toList(onEach)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(emptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getActivatePeakTaskList$lambda$0(Splash $this_getActivatePeakTaskList, SplashPeakTask it) {
        String pairHash;
        Intrinsics.checkNotNullParameter(it, "it");
        String taskId = it.getTaskId();
        if (taskId == null || StringsKt.isBlank(taskId)) {
            it.setTaskId($this_getActivatePeakTaskList.id + "_" + it.getHash() + "_" + it.getEffectTime());
            if (it.getExtra() == null) {
                it.setExtra(new HashMap<>());
            }
            HashMap extra = it.getExtra();
            if (extra != null) {
                extra.put(PeakTaskDefine.BIZ_SRC, PeakTaskDefine.BizSrc.BUSINESS_SPLASH);
                HashMap hashMap = extra;
                String str = $this_getActivatePeakTaskList.adCb;
                if (str == null) {
                    str = "";
                }
                hashMap.put(PeakTaskDefine.AD_CB, str);
                extra.put(PeakTaskDefine.SPLASH_ID, String.valueOf($this_getActivatePeakTaskList.id));
                if (SplashCreativeHelper.isImageVideoMixCardType($this_getActivatePeakTaskList) && (pairHash = getPairHash($this_getActivatePeakTaskList, it.getHash())) != null) {
                    extra.put(PeakTaskDefine.PAIR_HASH, pairHash);
                }
            }
        }
        return Unit.INSTANCE;
    }

    public static final String getPairHash(Splash $this$getPairHash, String hash) {
        if ($this$getPairHash == null) {
            return null;
        }
        String str = hash;
        if ((str == null || StringsKt.isBlank(str)) || !SplashCreativeHelper.isImageVideoMixCardType($this$getPairHash)) {
            return null;
        }
        return Intrinsics.areEqual(hash, $this$getPairHash.imageHash) ? $this$getPairHash.videoHash : $this$getPairHash.imageHash;
    }

    public static final Set<String> getActivatePeakIdSet(Splash $this$getActivatePeakIdSet) {
        Iterable $this$mapNotNull$iv = getActivatePeakTaskList($this$getActivatePeakIdSet);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            SplashPeakTask it = (SplashPeakTask) element$iv$iv$iv;
            String taskId = it.getTaskId();
            if (taskId != null) {
                destination$iv$iv.add(taskId);
            }
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(CollectionsKt.toHashSet((List) destination$iv$iv));
    }

    public static final List<SplashPeakTask> getUnReadyPeakTaskList(Splash $this$getUnReadyPeakTaskList) {
        Iterable $this$filter$iv = getActivatePeakTaskList($this$getUnReadyPeakTaskList);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            SplashPeakTask it = (SplashPeakTask) element$iv$iv;
            if (!SplashPeakTaskKt.isResourceExists(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return EnhancedUnmodifiabilityKt.unmodifiable((List) destination$iv$iv);
    }

    public static final Set<String> getAllResHashSet(Splash $this$allResHashSet) {
        Iterable animationList;
        String it;
        Iterable secondPageButtons;
        Intrinsics.checkNotNullParameter($this$allResHashSet, "<this>");
        Set sets = new LinkedHashSet();
        String it2 = $this$allResHashSet.imageHash;
        String str = it2;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            it2 = null;
        }
        if (it2 != null) {
            sets.add(it2);
        }
        String it3 = $this$allResHashSet.videoHash;
        String str2 = it3;
        if (str2 == null || StringsKt.isBlank(str2)) {
            it3 = null;
        }
        if (it3 != null) {
            sets.add(it3);
        }
        String it4 = $this$allResHashSet.logoHash;
        String str3 = it4;
        if (str3 == null || StringsKt.isBlank(str3)) {
            it4 = null;
        }
        if (it4 != null) {
            sets.add(it4);
        }
        Iterable iterable = $this$allResHashSet.splashGuideButton;
        if (iterable != null) {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                sets.addAll(SplashGuideButtonKt.getAllResHashSet((SplashGuideButton) element$iv));
            }
        }
        SplashSecondPageInfo splashSecondPageInfo = $this$allResHashSet.secondPage;
        if (splashSecondPageInfo != null && (secondPageButtons = splashSecondPageInfo.getSecondPageButtons()) != null) {
            Iterable $this$forEach$iv2 = secondPageButtons;
            for (Object element$iv2 : $this$forEach$iv2) {
                sets.addAll(SplashGuideButtonKt.getAllResHashSet((SplashGuideButton) element$iv2));
            }
        }
        SplashSecondPageInfo splashSecondPageInfo2 = $this$allResHashSet.secondPage;
        if (splashSecondPageInfo2 != null && (it = splashSecondPageInfo2.getSecondVideoHash()) != null) {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it != null) {
                sets.add(it);
            }
        }
        SplashElementAnimation splashElementAnimation = $this$allResHashSet.elementAnimation;
        if (splashElementAnimation != null && (animationList = splashElementAnimation.getAnimationList()) != null) {
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
        SplashEgg splashEgg = $this$allResHashSet.splashEgg;
        String it8 = splashEgg != null ? splashEgg.getVideoHash() : null;
        String str7 = it8;
        String it9 = (str7 == null || StringsKt.isBlank(str7)) ? true : true ? null : it8;
        if (it9 != null) {
            sets.add(it9);
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(sets);
    }
}