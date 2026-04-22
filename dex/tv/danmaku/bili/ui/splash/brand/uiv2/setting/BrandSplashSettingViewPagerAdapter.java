package tv.danmaku.bili.ui.splash.brand.uiv2.setting;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingTab;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashSettingTabFragment;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingViewPagerAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/BrandSplashSettingViewPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "tabs", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingTab;", "getItemCount", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "update", "", "newTabs", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingViewPagerAdapter extends FragmentStateAdapter {
    public static final int $stable = 8;
    private final List<BrandSplashSettingTab> tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingViewPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.tabs = new ArrayList();
    }

    public int getItemCount() {
        return this.tabs.size();
    }

    public Fragment createFragment(int position) {
        BrandSplashSettingTab item = this.tabs.get(position);
        BrandSplashSettingTabFragment.Companion companion = BrandSplashSettingTabFragment.Companion;
        String source = item.getSource();
        Intrinsics.checkNotNull(source);
        return companion.newInstance(source);
    }

    public final void update(List<BrandSplashSettingTab> list) {
        List newTabs = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(newTabs, "newTabs");
        if (newTabs.size() != this.tabs.size()) {
            this.tabs.clear();
            this.tabs.addAll(newTabs);
            notifyDataSetChanged();
            return;
        }
        List $this$forEachIndexed$iv = newTabs;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BrandSplashSettingTab brandSplashSettingTab = (BrandSplashSettingTab) item$iv;
            if (!Intrinsics.areEqual(brandSplashSettingTab.getSource(), this.tabs.get(index).getSource()) || !Intrinsics.areEqual(brandSplashSettingTab.getTitle(), this.tabs.get(index).getTitle())) {
                this.tabs.clear();
                this.tabs.addAll(newTabs);
                notifyDataSetChanged();
                return;
            }
            index = index$iv;
        }
    }
}