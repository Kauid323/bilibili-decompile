package tv.danmaku.bili.ui.splash.brand.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"allSplash", "", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplashData;", "getAllSplash", "(Ltv/danmaku/bili/ui/splash/brand/model/BrandSplashData;)Ljava/util/List;", "getCollectionSplashList", "getBrandSplashList", "ORDER_RULE", "", "DEFAULT_PULL_INTERVAL", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashDataKt {
    public static final long DEFAULT_PULL_INTERVAL = 900;
    public static final String ORDER_RULE = "order";

    public static final List<BrandSplash> getAllSplash(BrandSplashData $this$allSplash) {
        Intrinsics.checkNotNullParameter($this$allSplash, "<this>");
        List<BrandSplash> brandList = $this$allSplash.getBrandList();
        if (brandList == null) {
            brandList = CollectionsKt.emptyList();
        }
        return CollectionsKt.toMutableList(CollectionsKt.filterNotNull(CollectionsKt.flatten(CollectionsKt.listOf(brandList))));
    }

    public static final List<BrandSplash> getCollectionSplashList(BrandSplashData $this$getCollectionSplashList) {
        List<BrandSplash> brandList;
        Iterable filterNotNull;
        if ($this$getCollectionSplashList != null && (brandList = $this$getCollectionSplashList.getBrandList()) != null && (filterNotNull = CollectionsKt.filterNotNull(brandList)) != null) {
            Iterable $this$filter$iv = filterNotNull;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                BrandSplash it = (BrandSplash) element$iv$iv;
                if (Intrinsics.areEqual(it.getSource(), BrandSplashSource.VIP.getValue()) || Intrinsics.areEqual(it.getSource(), BrandSplashSource.DLC.getValue())) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List<BrandSplash> mutableList = CollectionsKt.toMutableList((List) destination$iv$iv);
            if (mutableList != null) {
                return mutableList;
            }
        }
        return new ArrayList();
    }

    public static final List<BrandSplash> getBrandSplashList(BrandSplashData $this$getBrandSplashList) {
        List<BrandSplash> brandList;
        Iterable filterNotNull;
        if ($this$getBrandSplashList != null && (brandList = $this$getBrandSplashList.getBrandList()) != null && (filterNotNull = CollectionsKt.filterNotNull(brandList)) != null) {
            Iterable $this$filter$iv = filterNotNull;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                BrandSplash it = (BrandSplash) element$iv$iv;
                if (it.getSource() == null || Intrinsics.areEqual(it.getSource(), BrandSplashSource.BRAND.getValue())) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List<BrandSplash> mutableList = CollectionsKt.toMutableList((List) destination$iv$iv);
            if (mutableList != null) {
                return mutableList;
            }
        }
        return new ArrayList();
    }
}