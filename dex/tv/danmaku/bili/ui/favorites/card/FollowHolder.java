package tv.danmaku.bili.ui.favorites.card;

import android.view.View;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.bilibili.playset.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesFollowBinding;
import tv.danmaku.bili.ui.favorites.adapter.FollowCardClickListener;
import tv.danmaku.bili.ui.favorites.model.FollowItem;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt;

/* compiled from: FollowHolder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/card/FollowHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FollowItem;", "binding", "Ltv/danmaku/bili/databinding/BiliAppItemFavoritesFollowBinding;", "clickListener", "Ltv/danmaku/bili/ui/favorites/adapter/FollowCardClickListener;", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppItemFavoritesFollowBinding;Ltv/danmaku/bili/ui/favorites/adapter/FollowCardClickListener;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppItemFavoritesFollowBinding;", "TAG", "", "getTAG", "()Ljava/lang/String;", "bind", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FollowHolder extends BaseFavoritesHolder<FollowItem> {
    public static final int $stable = 8;
    private final String TAG;
    private final BiliAppItemFavoritesFollowBinding binding;
    private final FollowCardClickListener clickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FollowHolder(BiliAppItemFavoritesFollowBinding binding, FollowCardClickListener clickListener) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
        this.clickListener = clickListener;
        this.TAG = "FollowHolder";
    }

    public final BiliAppItemFavoritesFollowBinding getBinding() {
        return this.binding;
    }

    public final String getTAG() {
        return this.TAG;
    }

    protected void bind() {
        final BiliAppItemFavoritesFollowBinding $this$bind_u24lambda_u240 = this.binding;
        BiliImageView biliImageView = $this$bind_u24lambda_u240.cover;
        Intrinsics.checkNotNullExpressionValue(biliImageView, ReportUtilKt.POS_COVER);
        ImageExtentionKt.displayImage$default(biliImageView, ((FollowItem) getData()).getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
        ListExtentionsKt.setText($this$bind_u24lambda_u240.title, ((FollowItem) getData()).getTitle());
        ListExtentionsKt.setText($this$bind_u24lambda_u240.coverTag, ((FollowItem) getData()).getTagName());
        $this$bind_u24lambda_u240.coverShadow.setVisibility(ListExtentionsKt.toVisibility(((FollowItem) getData()).getLastView()));
        ListExtentionsKt.setText($this$bind_u24lambda_u240.bottomText1, ((FollowItem) getData()).getProgressDesc());
        ListExtentionsKt.setText($this$bind_u24lambda_u240.bottomText2, ((FollowItem) getData()).getHistoryDesc());
        $this$bind_u24lambda_u240.tagNew.setVisibility(ListExtentionsKt.toVisibility(((FollowItem) getData()).getRedDot()));
        switch (((FollowItem) getData()).getTagType()) {
            case 1:
                $this$bind_u24lambda_u240.coverTag.setBackgroundResource(R.drawable.shape_rect_pink_corner_2);
                break;
            case 2:
                $this$bind_u24lambda_u240.coverTag.setBackgroundResource(tv.danmaku.bili.R.drawable.shape_rect_gray_corner_2);
                break;
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.card.FollowHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FollowHolder.bind$lambda$0$0(FollowHolder.this, $this$bind_u24lambda_u240, view);
            }
        });
        View view = $this$bind_u24lambda_u240.more;
        Intrinsics.checkNotNullExpressionValue(view, "more");
        ListExtentionsKt.addTouchDelegate(view, ListExtentionsKt.toPx(10));
        $this$bind_u24lambda_u240.more.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.card.FollowHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FollowHolder.bind$lambda$0$1(FollowHolder.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0(FollowHolder this$0, BiliAppItemFavoritesFollowBinding $this_apply, View it) {
        int position = this$0.getBindingAdapterPosition();
        if (position != -1) {
            WatchLaterRouterKt.routerTo$default(((FollowItem) this$0.getData()).getJumpLink(), $this_apply.getRoot().getContext(), (Map) null, 4, (Object) null);
            this$0.clickListener.onItemClick((FollowItem) this$0.getData(), position);
            return;
        }
        BLog.i(this$0.TAG, "position is " + position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$1(FollowHolder this$0, View it) {
        int position = this$0.getBindingAdapterPosition();
        if (position != -1) {
            this$0.clickListener.onThreePointClick(this$0.getBindingAdapterPosition());
        } else {
            BLog.i(this$0.TAG, "more click item has been removed");
        }
    }
}