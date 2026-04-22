package tv.danmaku.bili.ui.favorites.adapter.holder;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.common.utils.CommonExtensionKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.bilibili.lib.theme.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesInvalidVideoBinding;
import tv.danmaku.bili.ui.favorites.adapter.FavCardClickListener;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.model.Upper;
import tv.danmaku.bili.widget.VectorTextView;

/* compiled from: FavoritesInvalidVideoHolder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/holder/FavoritesInvalidVideoHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "binding", "Ltv/danmaku/bili/databinding/BiliAppItemFavoritesInvalidVideoBinding;", "cardClickListener", "Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppItemFavoritesInvalidVideoBinding;Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppItemFavoritesInvalidVideoBinding;", "bind", "", "payloads", "", "", "resizeCover", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesInvalidVideoHolder extends BaseFavoritesHolder<FavoritesMediasItem> {
    public static final int $stable = 8;
    private final BiliAppItemFavoritesInvalidVideoBinding binding;
    private final FavCardClickListener cardClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FavoritesInvalidVideoHolder(BiliAppItemFavoritesInvalidVideoBinding binding, FavCardClickListener cardClickListener) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(cardClickListener, "cardClickListener");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
        this.cardClickListener = cardClickListener;
    }

    public final BiliAppItemFavoritesInvalidVideoBinding getBinding() {
        return this.binding;
    }

    protected void bind() {
        BiliAppItemFavoritesInvalidVideoBinding $this$bind_u24lambda_u240 = this.binding;
        resizeCover();
        BiliImageView biliImageView = $this$bind_u24lambda_u240.cover;
        Intrinsics.checkNotNullExpressionValue(biliImageView, ReportUtilKt.POS_COVER);
        ImageExtentionKt.displayImage$default(biliImageView, ((FavoritesMediasItem) getData()).getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
        if (((FavoritesMediasItem) getData()).getEnableDrag()) {
            $this$bind_u24lambda_u240.getRoot().setBackgroundColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.Bg1));
            ListExtentionsKt.visible($this$bind_u24lambda_u240.line);
            ListExtentionsKt.gone($this$bind_u24lambda_u240.more);
            ListExtentionsKt.gone($this$bind_u24lambda_u240.clearInvalid);
            View view = $this$bind_u24lambda_u240.title;
            Intrinsics.checkNotNullExpressionValue(view, ReportUtilKt.POS_TITLE);
            CommonExtensionKt.setMarginRight(view, ListExtentionsKt.toPx(8));
            View view2 = $this$bind_u24lambda_u240.upName;
            Intrinsics.checkNotNullExpressionValue(view2, "upName");
            CommonExtensionKt.setMarginRight(view2, ListExtentionsKt.toPx(8));
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone($this$bind_u24lambda_u240.getRoot());
            constraintSet.connect($this$bind_u24lambda_u240.upName.getId(), 7, $this$bind_u24lambda_u240.icMove.getId(), 6);
            constraintSet.applyTo($this$bind_u24lambda_u240.getRoot());
            ListExtentionsKt.visible($this$bind_u24lambda_u240.icMove);
            $this$bind_u24lambda_u240.icMove.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean bind$lambda$0$0;
                    bind$lambda$0$0 = FavoritesInvalidVideoHolder.bind$lambda$0$0(FavoritesInvalidVideoHolder.this, view3, motionEvent);
                    return bind$lambda$0$0;
                }
            });
        } else {
            ListExtentionsKt.gone($this$bind_u24lambda_u240.icMove);
        }
        $this$bind_u24lambda_u240.checkBox.setVisibility(ListExtentionsKt.toVisibility(((FavoritesMediasItem) getData()).isCheckMode()));
        $this$bind_u24lambda_u240.checkBox.setChecked(((FavoritesMediasItem) getData()).isChecked());
        ListExtentionsKt.setText($this$bind_u24lambda_u240.title, ((FavoritesMediasItem) getData()).getTitle());
        TextView textView = $this$bind_u24lambda_u240.upName;
        Upper upper = ((FavoritesMediasItem) getData()).getUpper();
        ListExtentionsKt.setText(textView, upper != null ? upper.getName() : null);
        VectorTextView vectorTextView = $this$bind_u24lambda_u240.upName;
        Intrinsics.checkNotNullExpressionValue(vectorTextView, "upName");
        ListExtentionsKt.setIcon$default(vectorTextView, 25, R.color.Text4, 0.0f, 0.0f, 24, (Object) null);
        ListExtentionsKt.setText($this$bind_u24lambda_u240.invalidTag, this.itemView.getContext().getString(bili.resource.favorites.R.string.favorites_global_string_114));
        View view3 = $this$bind_u24lambda_u240.more;
        Intrinsics.checkNotNullExpressionValue(view3, "more");
        ListExtentionsKt.addTouchDelegate(view3, ListExtentionsKt.toPx(5));
        View view4 = $this$bind_u24lambda_u240.cover;
        Intrinsics.checkNotNullExpressionValue(view4, ReportUtilKt.POS_COVER);
        View $this$updateLayoutParams$iv = view4;
        ViewGroup.LayoutParams layoutParams = $this$updateLayoutParams$iv.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.LayoutParams params$iv = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.MarginLayoutParams $this$bind_u24lambda_u240_u241 = (ViewGroup.MarginLayoutParams) params$iv;
        $this$bind_u24lambda_u240_u241.setMarginStart(((FavoritesMediasItem) getData()).isCheckMode() ? ListExtentionsKt.toPx(30) : 0);
        $this$updateLayoutParams$iv.setLayoutParams(params$iv);
        $this$bind_u24lambda_u240.more.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                FavoritesInvalidVideoHolder.bind$lambda$0$2(FavoritesInvalidVideoHolder.this, view5);
            }
        });
        $this$bind_u24lambda_u240.clearInvalid.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                FavoritesInvalidVideoHolder.bind$lambda$0$3(FavoritesInvalidVideoHolder.this, view5);
            }
        });
        ListExtentionsKt.setOnClickDebounce($this$bind_u24lambda_u240.getRoot(), ((FavoritesMediasItem) getData()).isCheckMode() ? 0L : 500L, new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                FavoritesInvalidVideoHolder.bind$lambda$0$4(FavoritesInvalidVideoHolder.this, view5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$0(FavoritesInvalidVideoHolder this$0, View v, MotionEvent event) {
        if (event.getAction() == 0) {
            if (!((FavoritesMediasItem) this$0.getData()).getCanDrag()) {
                ToastHelper.showToastShort(v.getContext(), v.getContext().getString(bili.resource.favorites.R.string.favorites_global_string_78));
            } else {
                FavCardClickListener favCardClickListener = this$0.cardClickListener;
                if (favCardClickListener != null) {
                    favCardClickListener.startDrag((RecyclerView.ViewHolder) this$0);
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$2(FavoritesInvalidVideoHolder this$0, View it) {
        this$0.cardClickListener.onItemClick((FavoritesMediasItem) this$0.getData(), this$0.getAbsoluteAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$3(FavoritesInvalidVideoHolder this$0, View it) {
        this$0.cardClickListener.onClearInvalidItem((FavoritesMediasItem) this$0.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$4(FavoritesInvalidVideoHolder this$0, View it) {
        if (((FavoritesMediasItem) this$0.getData()).isCheckMode()) {
            this$0.cardClickListener.onCheckClick(this$0.getBindingAdapterPosition());
        } else {
            this$0.cardClickListener.onItemClick((FavoritesMediasItem) this$0.getData(), this$0.getAbsoluteAdapterPosition());
        }
    }

    protected void bind(List<Object> list) {
        Intrinsics.checkNotNullParameter(list, "payloads");
        final BiliAppItemFavoritesInvalidVideoBinding $this$bind_u24lambda_u241 = this.binding;
        if (list.contains(5)) {
            bind();
        }
        if (list.contains(3)) {
            $this$bind_u24lambda_u241.checkBox.setChecked(true);
        }
        if (list.contains(4)) {
            $this$bind_u24lambda_u241.checkBox.setChecked(false);
        }
        if (list.contains(1)) {
            ValueAnimator $this$bind_u24lambda_u241_u240 = ValueAnimator.ofInt(0, ListExtentionsKt.toPx(30));
            $this$bind_u24lambda_u241_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FavoritesInvalidVideoHolder.bind$lambda$1$0$0(BiliAppItemFavoritesInvalidVideoBinding.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNull($this$bind_u24lambda_u241_u240);
            ValueAnimator $this$doOnStart$iv = $this$bind_u24lambda_u241_u240;
            Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$bind$lambda$1$0$$inlined$doOnStart$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ListExtentionsKt.visible(BiliAppItemFavoritesInvalidVideoBinding.this.checkBox);
                    ListExtentionsKt.gone(BiliAppItemFavoritesInvalidVideoBinding.this.clearInvalid);
                }
            };
            $this$doOnStart$iv.addListener(animatorListener);
            $this$bind_u24lambda_u241_u240.addListener(animatorListener);
            $this$bind_u24lambda_u241_u240.setDuration(200L);
            $this$bind_u24lambda_u241_u240.start();
        }
        if (list.contains(2)) {
            ValueAnimator $this$bind_u24lambda_u241_u241 = ValueAnimator.ofInt(ListExtentionsKt.toPx(30), 0);
            $this$bind_u24lambda_u241_u241.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FavoritesInvalidVideoHolder.bind$lambda$1$1$0(BiliAppItemFavoritesInvalidVideoBinding.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNull($this$bind_u24lambda_u241_u241);
            ValueAnimator $this$doOnStart$iv2 = $this$bind_u24lambda_u241_u241;
            Animator.AnimatorListener animatorListener2 = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$bind$lambda$1$1$$inlined$doOnStart$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ListExtentionsKt.gone(BiliAppItemFavoritesInvalidVideoBinding.this.checkBox);
                    BiliAppItemFavoritesInvalidVideoBinding.this.checkBox.setChecked(false);
                    ListExtentionsKt.visible(BiliAppItemFavoritesInvalidVideoBinding.this.clearInvalid);
                }
            };
            $this$doOnStart$iv2.addListener(animatorListener2);
            $this$bind_u24lambda_u241_u241.addListener(animatorListener2);
            $this$bind_u24lambda_u241_u241.setDuration(200L);
            $this$bind_u24lambda_u241_u241.start();
        }
        ListExtentionsKt.setOnClickDebounce($this$bind_u24lambda_u241.getRoot(), ((FavoritesMediasItem) getData()).isCheckMode() ? 0L : 500L, new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FavoritesInvalidVideoHolder.bind$lambda$1$2(FavoritesInvalidVideoHolder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$0$0(BiliAppItemFavoritesInvalidVideoBinding $this_run, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        if (num != null) {
            int margin = num.intValue();
            View view = $this_run.cover;
            Intrinsics.checkNotNullExpressionValue(view, ReportUtilKt.POS_COVER);
            View $this$updateLayoutParams$iv = view;
            ViewGroup.LayoutParams layoutParams = $this$updateLayoutParams$iv.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.LayoutParams params$iv = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams $this$bind_u24lambda_u241_u240_u240_u240_u240 = (ViewGroup.MarginLayoutParams) params$iv;
            $this$bind_u24lambda_u241_u240_u240_u240_u240.setMarginStart(margin);
            $this$updateLayoutParams$iv.setLayoutParams(params$iv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$1$0(BiliAppItemFavoritesInvalidVideoBinding $this_run, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        if (num != null) {
            int margin = num.intValue();
            View view = $this_run.cover;
            Intrinsics.checkNotNullExpressionValue(view, ReportUtilKt.POS_COVER);
            View $this$updateLayoutParams$iv = view;
            ViewGroup.LayoutParams layoutParams = $this$updateLayoutParams$iv.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.LayoutParams params$iv = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams $this$bind_u24lambda_u241_u241_u240_u240_u240 = (ViewGroup.MarginLayoutParams) params$iv;
            $this$bind_u24lambda_u241_u241_u240_u240_u240.setMarginStart(margin);
            $this$updateLayoutParams$iv.setLayoutParams(params$iv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$2(FavoritesInvalidVideoHolder this$0, View it) {
        if (((FavoritesMediasItem) this$0.getData()).isCheckMode()) {
            this$0.cardClickListener.onCheckClick(this$0.getBindingAdapterPosition());
        } else {
            this$0.cardClickListener.onItemClick((FavoritesMediasItem) this$0.getData(), this$0.getAbsoluteAdapterPosition());
        }
    }

    private final void resizeCover() {
        View view = this.binding.cover;
        Intrinsics.checkNotNullExpressionValue(view, ReportUtilKt.POS_COVER);
        View $this$updateLayoutParams$iv = view;
        ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
        if (params$iv$iv != null) {
            if (((FavoritesMediasItem) getData()).getOtype() != 2) {
                if (((FavoritesMediasItem) getData()).getOtype() == 12) {
                    params$iv$iv.height = this.itemView.getResources().getDimensionPixelSize(tv.danmaku.bili.R.dimen.fav_audio_card_cover_size);
                    params$iv$iv.width = this.itemView.getResources().getDimensionPixelSize(tv.danmaku.bili.R.dimen.fav_audio_card_cover_size);
                }
            } else {
                params$iv$iv.height = this.itemView.getResources().getDimensionPixelSize(tv.danmaku.bili.R.dimen.fav_video_card_cover_height);
                params$iv$iv.width = this.itemView.getResources().getDimensionPixelSize(tv.danmaku.bili.R.dimen.fav_video_card_cover_width);
            }
            $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}