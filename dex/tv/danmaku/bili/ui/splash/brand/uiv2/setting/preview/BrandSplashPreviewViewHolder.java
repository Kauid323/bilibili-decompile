package tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashPreviewItemViewBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashPreviewAdapter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/preview/BrandSplashPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashPreviewItemViewBinding;", "<init>", "(Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashPreviewItemViewBinding;)V", "getBinding", "()Ltv/danmaku/bili/ui/splash/databinding/BiliAppListBrandSplashPreviewItemViewBinding;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashPreviewViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final BiliAppListBrandSplashPreviewItemViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashPreviewViewHolder(BiliAppListBrandSplashPreviewItemViewBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final BiliAppListBrandSplashPreviewItemViewBinding getBinding() {
        return this.binding;
    }
}