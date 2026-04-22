package tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSection;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashListItemBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ListTypeHolder.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/tab/ListTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashListItemBinding;", "<init>", "(Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashListItemBinding;)V", "getBinding", "()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashListItemBinding;", "mAdapter", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/tab/BrandSplashSettingAdapter;", "bind", "", "data", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSection;", "fragment", "Landroidx/fragment/app/Fragment;", "payloads", "", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ListTypeHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final BiliAppListBrandSplashListItemBinding binding;
    private BrandSplashSettingAdapter mAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListTypeHolder(BiliAppListBrandSplashListItemBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        ViewGroup.LayoutParams lp = this.binding.rvItems.getLayoutParams();
        lp.width = -1;
        lp.height = ListExtentionsKt.toPx(214);
        this.binding.rvItems.setLayoutParams(lp);
        ViewGroup.LayoutParams lp2 = this.binding.rvContainer.getLayoutParams();
        lp2.width = -1;
        lp2.height = -2;
        this.binding.rvContainer.setLayoutParams(lp2);
        this.binding.rvItems.setLayoutManager(new LinearLayoutManager(this.binding.getRoot().getContext(), 0, false));
        this.binding.rvItems.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.ListTypeHolder.1
            public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view2, parent, state);
                int pos = parent.getChildAdapterPosition(view2);
                int left = ListExtentionsKt.toPx(pos == 0 ? 18 : 8);
                RecyclerView.Adapter adapter = parent.getAdapter();
                int right = pos == (adapter != null ? adapter.getItemCount() : 0) + (-1) ? ListExtentionsKt.toPx(20) : ListExtentionsKt.toPx(0);
                outRect.left = left;
                outRect.right = right;
                outRect.bottom = 0;
            }
        });
    }

    public final BiliAppListBrandSplashListItemBinding getBinding() {
        return this.binding;
    }

    public final void bind(BrandSplashSection data, Fragment fragment, List<? extends Object> list) {
        EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (this.mAdapter == null) {
            this.mAdapter = new BrandSplashSettingAdapter(fragment);
            this.binding.rvItems.setAdapter(this.mAdapter);
        }
        this.binding.title.setText(data.getTitle());
        ImageView imageView = this.binding.titleIcon;
        Integer type = data.getType();
        imageView.setVisibility((type != null && type.intValue() == 3) ? 0 : 8);
        BrandSplashSettingAdapter brandSplashSettingAdapter = this.mAdapter;
        if (brandSplashSettingAdapter != null) {
            List<BrandSplash> list2 = data.getList();
            if (list2 == null) {
                list2 = CollectionsKt.emptyList();
            }
            brandSplashSettingAdapter.updateData(list2);
        }
    }
}