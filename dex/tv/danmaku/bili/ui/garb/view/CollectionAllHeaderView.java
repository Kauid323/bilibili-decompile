package tv.danmaku.bili.ui.garb.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppViewCollectionAllHeaderBinding;

/* compiled from: CollectionAllHeaderView.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/view/CollectionAllHeaderView;", "", "root", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "getRoot", "()Landroid/view/ViewGroup;", "binding", "Ltv/danmaku/bili/databinding/BiliAppViewCollectionAllHeaderBinding;", "getView", "Landroid/view/View;", "updateUI", "", "url", "", "total", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionAllHeaderView {
    public static final int $stable = 8;
    private BiliAppViewCollectionAllHeaderBinding binding;
    private final ViewGroup root;

    public CollectionAllHeaderView(ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        BiliAppViewCollectionAllHeaderBinding inflate = BiliAppViewCollectionAllHeaderBinding.inflate(LayoutInflater.from(this.root.getContext()), this.root, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    public final ViewGroup getRoot() {
        return this.root;
    }

    public final View getView() {
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void updateUI(String url, int total) {
        Intrinsics.checkNotNullParameter(url, "url");
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = this.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageRequestBuilder.placeholderImageResId$default(biliImageLoader.with(context).url(url), R.drawable.ic_default_avatar, (ScaleType) null, 2, (Object) null).into(this.binding.collectionAllHeaderAvatar.getImageView());
        this.binding.collectionAllHeaderTitle.setText("全部收藏·" + total + "个");
    }
}