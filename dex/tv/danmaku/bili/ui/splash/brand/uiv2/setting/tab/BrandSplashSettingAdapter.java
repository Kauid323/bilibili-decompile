package tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSection;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashCardItemBinding;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashListItemBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingTabAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J*\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00122\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0002J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J&\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/tab/BrandSplashSettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "dataList", "", "", "updateData", "", "data", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemViewType", "position", "getSpanCount", "onBind", "holder", "payloads", "onBindViewHolder", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private List<Object> dataList;
    private final Fragment fragment;

    public BrandSplashSettingAdapter(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.dataList = new ArrayList();
    }

    public final void updateData(List<? extends Object> list) {
        List data = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(data, "data");
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new BrandSplashTabDiffCallBack(this.dataList, data));
        Intrinsics.checkNotNullExpressionValue(diffResult, "calculateDiff(...)");
        this.dataList.clear();
        this.dataList.addAll(data);
        diffResult.dispatchUpdatesTo(this);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1:
                BiliAppListBrandSplashCardItemBinding bind = BiliAppListBrandSplashCardItemBinding.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_brand_splash_card_item, parent, false));
                Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
                return new BrandSplashCardTypeHolder(bind);
            case 2:
                BiliAppListBrandSplashListItemBinding bind2 = BiliAppListBrandSplashListItemBinding.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_brand_splash_list_item, parent, false));
                Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
                return new ListTypeHolder(bind2);
            default:
                throw new IllegalArgumentException("invalid item type = " + viewType);
        }
    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public int getItemViewType(int position) {
        Object item = this.dataList.get(position);
        if (item instanceof BrandSplash) {
            return 1;
        }
        if (item instanceof BrandSplashSection) {
            return 2;
        }
        throw new IllegalArgumentException("unknown type " + item);
    }

    public final int getSpanCount(int position) {
        return this.dataList.get(position) instanceof BrandSplash ? 1 : 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void onBind$default(BrandSplashSettingAdapter brandSplashSettingAdapter, RecyclerView.ViewHolder viewHolder, int i, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list = null;
        }
        brandSplashSettingAdapter.onBind(viewHolder, i, list);
    }

    private final void onBind(RecyclerView.ViewHolder holder, int position, List<? extends Object> list) {
        List payloads = EnhancedUnmodifiabilityKt.unmodifiable(list);
        if (position < 0 || position > this.dataList.size()) {
            return;
        }
        Object item = this.dataList.get(position);
        if (!(item instanceof BrandSplash)) {
            if (!(item instanceof BrandSplashSection)) {
                throw new IllegalArgumentException("unknown type " + item);
            }
            Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.ListTypeHolder");
            ((ListTypeHolder) holder).bind((BrandSplashSection) item, this.fragment, payloads);
            return;
        }
        Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type tv.danmaku.bili.ui.splash.brand.uiv2.setting.tab.BrandSplashCardTypeHolder");
        ((BrandSplashCardTypeHolder) holder).bind((BrandSplash) item, this.fragment, payloads);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        onBind$default(this, holder, position, null, 4, null);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> list) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        onBind(holder, position, list);
    }
}