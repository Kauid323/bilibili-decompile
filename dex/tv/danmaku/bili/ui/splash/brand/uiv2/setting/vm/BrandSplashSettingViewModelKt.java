package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\"\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"updateInSection", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSection;", "sections", "old", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "new", "updateInList", "splashes", "MAX_SELECTED_COUNT", "", "TAG", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingViewModelKt {
    public static final int MAX_SELECTED_COUNT = 12;
    private static final String TAG = "[BrandSplash]BrandSplashSettingViewModel";

    public static final List<BrandSplashSection> updateInSection(List<BrandSplashSection> list, BrandSplash old, BrandSplash brandSplash) {
        Iterable sections = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(brandSplash, "new");
        List newSections = CollectionsKt.toMutableList((Collection) sections);
        Iterable $this$forEachIndexed$iv = sections;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BrandSplashSection section = (BrandSplashSection) item$iv;
            List<BrandSplash> list2 = section.getList();
            if (list2 == null) {
                list2 = CollectionsKt.emptyList();
            }
            newSections.set(index, BrandSplashSection.copy$default(section, null, null, updateInList(list2, old, brandSplash), null, null, 27, null));
            index = index$iv;
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(newSections);
    }

    public static final List<BrandSplash> updateInList(List<BrandSplash> list, BrandSplash old, BrandSplash brandSplash) {
        List splashes = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(splashes, "splashes");
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(brandSplash, "new");
        List $this$updateInList_u24lambda_u240 = CollectionsKt.toMutableList(splashes);
        int index$iv = 0;
        Iterator it = splashes.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                BrandSplash it2 = (BrandSplash) item$iv;
                if (Intrinsics.areEqual(BrandSplashKt.getUniqueId(it2), BrandSplashKt.getUniqueId(old))) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int index = index$iv;
        if (index >= 0) {
            $this$updateInList_u24lambda_u240.remove(index);
            $this$updateInList_u24lambda_u240.add(index, brandSplash);
        }
        return EnhancedUnmodifiabilityKt.unmodifiable($this$updateInList_u24lambda_u240);
    }
}