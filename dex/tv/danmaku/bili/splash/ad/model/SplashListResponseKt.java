package tv.danmaku.bili.splash.ad.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.bili.BR;

/* compiled from: SplashListResponse.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001a\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"validMaxCount", "", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "getValidMaxCount", "(Ltv/danmaku/bili/splash/ad/model/SplashListResponse;)I", "validIntervalForUpdate", "getValidIntervalForUpdate", "validIntervalForShow", "getValidIntervalForShow", "encryptedData", "", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "getEncryptedData", "(Ltv/danmaku/bili/splash/ad/model/SplashListResponse;)Ljava/util/List;", "trimEncrypt", "", "unExposeKeepIds", "", "getUnExposeKeepIds", "(Ltv/danmaku/bili/splash/ad/model/SplashListResponse;)Ljava/lang/String;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashListResponseKt {
    public static final int getValidMaxCount(SplashListResponse $this$validMaxCount) {
        Intrinsics.checkNotNullParameter($this$validMaxCount, "<this>");
        if ($this$validMaxCount.getMaxCount() > 0) {
            return $this$validMaxCount.getMaxCount();
        }
        return 6;
    }

    public static final int getValidIntervalForUpdate(SplashListResponse $this$validIntervalForUpdate) {
        Intrinsics.checkNotNullParameter($this$validIntervalForUpdate, "<this>");
        if ($this$validIntervalForUpdate.getIntervalForUpdate() > 0) {
            return $this$validIntervalForUpdate.getIntervalForUpdate();
        }
        return 900;
    }

    public static final int getValidIntervalForShow(SplashListResponse $this$validIntervalForShow) {
        Intrinsics.checkNotNullParameter($this$validIntervalForShow, "<this>");
        if ($this$validIntervalForShow.getIntervalForShow() > 0) {
            return $this$validIntervalForShow.getIntervalForShow();
        }
        return 900;
    }

    public static final List<SplashOrder> getEncryptedData(SplashListResponse $this$encryptedData) {
        Intrinsics.checkNotNullParameter($this$encryptedData, "<this>");
        Iterable splashList = $this$encryptedData.getSplashList();
        if (splashList != null) {
            Iterable $this$filter$iv = splashList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                SplashOrder it = (SplashOrder) element$iv$iv;
                if (ExtSplashOrderKt.isEncrypted(it)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        }
        return CollectionsKt.emptyList();
    }

    public static final void trimEncrypt(SplashListResponse $this$trimEncrypt) {
        Iterator iterator;
        Intrinsics.checkNotNullParameter($this$trimEncrypt, "<this>");
        List<SplashOrder> splashList = $this$trimEncrypt.getSplashList();
        if (splashList == null || (iterator = splashList.iterator()) == null) {
            return;
        }
        while (iterator.hasNext()) {
            SplashOrder splash = iterator.next();
            if (ExtSplashOrderKt.isEncrypted(splash)) {
                iterator.remove();
            }
        }
    }

    public static final String getUnExposeKeepIds(SplashListResponse $this$unExposeKeepIds) {
        Iterable ids;
        Iterable splashList;
        if ($this$unExposeKeepIds == null || (ids = $this$unExposeKeepIds.getKeepIds()) == null || (splashList = $this$unExposeKeepIds.getSplashList()) == null) {
            return "";
        }
        Iterable $this$filter$iv = splashList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            SplashOrder it = (SplashOrder) element$iv$iv;
            if (!it.isLocalExposed()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$associateBy$iv = (List) destination$iv$iv;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv2 : $this$associateBy$iv) {
            SplashOrder it2 = (SplashOrder) element$iv$iv2;
            destination$iv$iv2.put(Long.valueOf(it2.getId()), element$iv$iv2);
        }
        Iterable $this$filter$iv2 = ids;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv3 : $this$filter$iv2) {
            long it3 = ((Number) element$iv$iv3).longValue();
            if (destination$iv$iv2.containsKey(Long.valueOf(it3))) {
                destination$iv$iv3.add(element$iv$iv3);
            }
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv3, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}