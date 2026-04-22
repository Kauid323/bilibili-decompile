package tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab;

import androidx.recyclerview.widget.DiffUtil;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingTabAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/tab/BrandSplashTabDiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashTabDiffCallBack extends DiffUtil.Callback {
    public static final int $stable = 8;
    private final List<Object> newList;
    private final List<Object> oldList;

    public BrandSplashTabDiffCallBack(List<? extends Object> list, List<? extends Object> list2) {
        List oldList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List newList = EnhancedUnmodifiabilityKt.unmodifiable(list2);
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.oldList = oldList;
        this.newList = newList;
    }

    public int getOldListSize() {
        return this.oldList.size();
    }

    public int getNewListSize() {
        return this.newList.size();
    }

    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition == newItemPosition;
    }

    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Object oldItem = this.oldList.get(oldItemPosition);
        Object newItem = this.newList.get(newItemPosition);
        return Intrinsics.areEqual(oldItem, newItem);
    }

    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Object oldItem = this.oldList.get(oldItemPosition);
        Object newItem = this.newList.get(newItemPosition);
        if ((oldItem instanceof BrandSplash) && (newItem instanceof BrandSplash)) {
            return 0;
        }
        if ((oldItem instanceof BrandSplashSection) && (newItem instanceof BrandSplashSection)) {
            return 0;
        }
        return null;
    }
}