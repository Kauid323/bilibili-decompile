package tv.danmaku.bili.ui.favorites.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesFolderItemBinding;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: FolderListAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00070\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0019\u001a\u00020\u0007H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FolderItemHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "binding", "Ltv/danmaku/bili/databinding/BiliAppItemFavoritesFolderItemBinding;", "onLongClick", "Lkotlin/Function0;", "", "onFolderItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "item", "isDefaultFolderItem", "", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppItemFavoritesFolderItemBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "holderWidth", "", "getHolderWidth", "()I", "holderWidth$delegate", "Lkotlin/Lazy;", "coverWidth", "coverHeight", "bind", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FolderItemHolder extends BaseFavoritesHolder<FavoritesMediasItem> {
    public static final int $stable = 8;
    private final BiliAppItemFavoritesFolderItemBinding binding;
    private final int coverHeight;
    private final int coverWidth;
    private final Lazy holderWidth$delegate;
    private final boolean isDefaultFolderItem;
    private final Function1<FavoritesMediasItem, Unit> onFolderItemClick;
    private final Function0<Unit> onLongClick;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FolderItemHolder(BiliAppItemFavoritesFolderItemBinding binding, Function0<Unit> function0, Function1<? super FavoritesMediasItem, Unit> function1, boolean isDefaultFolderItem) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onLongClick");
        Intrinsics.checkNotNullParameter(function1, "onFolderItemClick");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
        this.onLongClick = function0;
        this.onFolderItemClick = function1;
        this.isDefaultFolderItem = isDefaultFolderItem;
        this.holderWidth$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderItemHolder$$ExternalSyntheticLambda2
            public final Object invoke() {
                int holderWidth_delegate$lambda$0;
                holderWidth_delegate$lambda$0 = FolderItemHolder.holderWidth_delegate$lambda$0(FolderItemHolder.this);
                return Integer.valueOf(holderWidth_delegate$lambda$0);
            }
        });
        this.coverWidth = getHolderWidth() - (ListExtentionsKt.toPx(2) * 2);
        this.coverHeight = (this.coverWidth * 9) / 16;
    }

    public /* synthetic */ FolderItemHolder(BiliAppItemFavoritesFolderItemBinding biliAppItemFavoritesFolderItemBinding, Function0 function0, Function1 function1, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(biliAppItemFavoritesFolderItemBinding, function0, function1, (i & 8) != 0 ? false : z);
    }

    private final int getHolderWidth() {
        return ((Number) this.holderWidth$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int holderWidth_delegate$lambda$0(FolderItemHolder this$0) {
        return (ScreenUtil.getScreenWidth(this$0.itemView.getContext()) - ListExtentionsKt.toPx(44)) / 3;
    }

    protected void bind() {
        BiliAppItemFavoritesFolderItemBinding $this$bind_u24lambda_u240 = this.binding;
        View view = $this$bind_u24lambda_u240.container;
        Intrinsics.checkNotNullExpressionValue(view, "container");
        View $this$updateLayoutParams$iv = view;
        ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
        if (params$iv$iv == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        params$iv$iv.width = getHolderWidth();
        $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
        View $this$updateLayoutParams$iv2 = $this$bind_u24lambda_u240.cover;
        Intrinsics.checkNotNullExpressionValue($this$updateLayoutParams$iv2, ReportUtilKt.POS_COVER);
        View $this$updateLayoutParams$iv3 = $this$updateLayoutParams$iv2;
        ViewGroup.LayoutParams params$iv$iv2 = $this$updateLayoutParams$iv3.getLayoutParams();
        if (params$iv$iv2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        params$iv$iv2.width = this.coverWidth;
        params$iv$iv2.height = this.coverHeight;
        $this$updateLayoutParams$iv3.setLayoutParams(params$iv$iv2);
        View $this$updateLayoutParams$iv4 = $this$bind_u24lambda_u240.cover11;
        Intrinsics.checkNotNullExpressionValue($this$updateLayoutParams$iv4, "cover11");
        View $this$updateLayoutParams$iv5 = $this$updateLayoutParams$iv4;
        ViewGroup.LayoutParams $this$bind_u24lambda_u240_u242 = $this$updateLayoutParams$iv5.getLayoutParams();
        if ($this$bind_u24lambda_u240_u242 != null) {
            $this$bind_u24lambda_u240_u242.width = this.coverHeight;
            $this$bind_u24lambda_u240_u242.height = this.coverHeight;
            $this$updateLayoutParams$iv5.setLayoutParams($this$bind_u24lambda_u240_u242);
            if (((FavoritesMediasItem) getData()).isAudioCard()) {
                ListExtentionsKt.visible($this$bind_u24lambda_u240.cover11);
                BiliImageView biliImageView = $this$bind_u24lambda_u240.cover11;
                Intrinsics.checkNotNullExpressionValue(biliImageView, "cover11");
                ImageExtentionKt.displayImage$default(biliImageView, ((FavoritesMediasItem) getData()).getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
                BiliImageView biliImageView2 = $this$bind_u24lambda_u240.cover;
                Intrinsics.checkNotNullExpressionValue(biliImageView2, ReportUtilKt.POS_COVER);
                ImageExtentionKt.displayImage$default(biliImageView2, (String) null, (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
            } else {
                BiliImageView biliImageView3 = $this$bind_u24lambda_u240.cover;
                Intrinsics.checkNotNullExpressionValue(biliImageView3, ReportUtilKt.POS_COVER);
                ImageExtentionKt.displayImage$default(biliImageView3, ((FavoritesMediasItem) getData()).getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
                ListExtentionsKt.gone($this$bind_u24lambda_u240.cover11);
            }
            $this$bind_u24lambda_u240.title.setText(((FavoritesMediasItem) getData()).getDisplayTitle());
            View view2 = $this$bind_u24lambda_u240.title;
            Intrinsics.checkNotNullExpressionValue(view2, ReportUtilKt.POS_TITLE);
            View $this$isVisible$iv = view2;
            String displayTitle = ((FavoritesMediasItem) getData()).getDisplayTitle();
            boolean value$iv = !(displayTitle == null || displayTitle.length() == 0);
            $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
            $this$bind_u24lambda_u240.container.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderItemHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    FolderItemHolder.bind$lambda$0$3(FolderItemHolder.this, view3);
                }
            });
            if (!this.isDefaultFolderItem) {
                $this$bind_u24lambda_u240.container.setOnLongClickListener(new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderItemHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view3) {
                        boolean bind$lambda$0$4;
                        bind$lambda$0$4 = FolderItemHolder.bind$lambda$0$4(FolderItemHolder.this, view3);
                        return bind$lambda$0$4;
                    }
                });
                return;
            } else {
                $this$bind_u24lambda_u240.container.setOnLongClickListener((View.OnLongClickListener) null);
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$3(FolderItemHolder this$0, View it) {
        this$0.onFolderItemClick.invoke(this$0.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$4(FolderItemHolder this$0, View it) {
        this$0.onLongClick.invoke();
        return true;
    }
}