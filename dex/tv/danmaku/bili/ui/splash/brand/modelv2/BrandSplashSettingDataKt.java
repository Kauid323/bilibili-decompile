package tv.danmaku.bili.ui.splash.brand.modelv2;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingData.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isValid", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingData;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingDataKt {
    public static final boolean isValid(BrandSplashSettingData $this$isValid) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$isValid, "<this>");
        if ($this$isValid.getTabs().isEmpty()) {
            return false;
        }
        Iterable $this$forEach$iv = $this$isValid.getTabs();
        Iterator<T> it = $this$forEach$iv.iterator();
        do {
            z = true;
            if (!it.hasNext()) {
                return $this$isValid.getSetOption() != null;
            }
            Object element$iv = it.next();
            BrandSplashSettingTab it2 = (BrandSplashSettingTab) element$iv;
            if (it2.getSource() == null) {
                break;
            }
            List<BrandSplashSection> sections = it2.getSections();
            if (sections != null && !sections.isEmpty()) {
                z = false;
                continue;
            }
        } while (!z);
        return false;
    }
}