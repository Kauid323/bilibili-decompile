package tv.danmaku.bili.ui.favorites.adapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesArticleBinding;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.CntInfo;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.model.Upper;
import tv.danmaku.bili.widget.VectorTextView;

/* compiled from: FavoritesListAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0014\u0010\r\u001a\u00020\f*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavoritesArticleHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "binding", "Ltv/danmaku/bili/databinding/BiliAppItemFavoritesArticleBinding;", "cardClickListener", "Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppItemFavoritesArticleBinding;Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppItemFavoritesArticleBinding;", "bind", "", "reConstraintBottom", "hasCover", "", "payloads", "", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesArticleHolder extends BaseFavoritesHolder<FavoritesMediasItem> {
    public static final int $stable = 8;
    private final BiliAppItemFavoritesArticleBinding binding;
    private final FavCardClickListener cardClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FavoritesArticleHolder(BiliAppItemFavoritesArticleBinding binding, FavCardClickListener cardClickListener) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(cardClickListener, "cardClickListener");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
        this.cardClickListener = cardClickListener;
    }

    public final BiliAppItemFavoritesArticleBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0081, code lost:
        if (androidx.core.view.OneShotPreDrawListener.add(r1.title, new tv.danmaku.bili.ui.favorites.adapter.FavoritesArticleHolder$$ExternalSyntheticLambda0(r1)) == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void bind() {
        String it;
        final BiliAppItemFavoritesArticleBinding $this$bind_u24lambda_u240 = this.binding;
        String cover = ((FavoritesMediasItem) getData()).getCover();
        boolean hasCover = !(cover == null || StringsKt.isBlank(cover));
        reConstraintBottom($this$bind_u24lambda_u240, hasCover);
        $this$bind_u24lambda_u240.cover.setVisibility(ListExtentionsKt.toVisibility(hasCover));
        if (hasCover) {
            BiliImageView biliImageView = $this$bind_u24lambda_u240.cover;
            Intrinsics.checkNotNullExpressionValue(biliImageView, ReportUtilKt.POS_COVER);
            ImageExtentionKt.displayImage$default(biliImageView, ((FavoritesMediasItem) getData()).getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
        }
        String title = ((FavoritesMediasItem) getData()).getTitle();
        if (title != null && (it = ListExtentionsKt.takeIfNotBlank(title)) != null) {
            $this$bind_u24lambda_u240.title.setText(it);
            ListExtentionsKt.visible($this$bind_u24lambda_u240.title);
        }
        ListExtentionsKt.gone($this$bind_u24lambda_u240.title);
        $this$bind_u24lambda_u240.subtitle.setMaxLines(3);
        Unit unit = Unit.INSTANCE;
        ListExtentionsKt.setText($this$bind_u24lambda_u240.subtitle, ((FavoritesMediasItem) getData()).getIntro());
        VectorTextView vectorTextView = $this$bind_u24lambda_u240.leftText;
        Intrinsics.checkNotNullExpressionValue(vectorTextView, "leftText");
        Upper upper = ((FavoritesMediasItem) getData()).getUpper();
        ListExtentionsKt.setTextWithIcon$default(vectorTextView, upper != null ? upper.getName() : null, 25, 0, 0.0f, 0.0f, 56, (Object) null);
        VectorTextView vectorTextView2 = $this$bind_u24lambda_u240.rightText;
        Intrinsics.checkNotNullExpressionValue(vectorTextView2, "rightText");
        CntInfo cntInfo = ((FavoritesMediasItem) getData()).getCntInfo();
        ListExtentionsKt.setTextWithIcon$default(vectorTextView2, cntInfo != null ? String.valueOf(cntInfo.getThumbNum()) : null, 20, 0, 0.0f, 0.0f, 56, (Object) null);
        View view = $this$bind_u24lambda_u240.more;
        Intrinsics.checkNotNullExpressionValue(view, "more");
        ListExtentionsKt.addTouchDelegate(view, ListExtentionsKt.toPx(5));
        View view2 = $this$bind_u24lambda_u240.guideline;
        Intrinsics.checkNotNullExpressionValue(view2, "guideline");
        View $this$updateLayoutParams$iv = view2;
        ConstraintLayout.LayoutParams layoutParams = $this$updateLayoutParams$iv.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ViewGroup.LayoutParams) layoutParams;
        ConstraintLayout.LayoutParams $this$bind_u24lambda_u240_u242 = layoutParams2;
        $this$bind_u24lambda_u240_u242.guideBegin = ((FavoritesMediasItem) getData()).isCheckMode() ? ListExtentionsKt.toPx(30) : 0;
        $this$updateLayoutParams$iv.setLayoutParams(layoutParams2);
        $this$bind_u24lambda_u240.checkBox.setChecked(((FavoritesMediasItem) getData()).isChecked());
        $this$bind_u24lambda_u240.checkBox.setVisibility(ListExtentionsKt.toVisibility(((FavoritesMediasItem) getData()).isCheckMode()));
        $this$bind_u24lambda_u240.getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesArticleHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                FavoritesArticleHolder.bind$lambda$0$3(FavoritesArticleHolder.this, view3);
            }
        });
        $this$bind_u24lambda_u240.more.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesArticleHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                FavoritesArticleHolder.bind$lambda$0$4(FavoritesArticleHolder.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0$0(BiliAppItemFavoritesArticleBinding $this_run) {
        $this_run.subtitle.setMaxLines(3 - $this_run.title.getLineCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$3(FavoritesArticleHolder this$0, View it) {
        if (((FavoritesMediasItem) this$0.getData()).isCheckMode()) {
            this$0.cardClickListener.onCheckClick(this$0.getBindingAdapterPosition());
        } else {
            this$0.cardClickListener.onItemClick((FavoritesMediasItem) this$0.getData(), this$0.getAbsoluteAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$4(FavoritesArticleHolder this$0, View it) {
        this$0.cardClickListener.onMoreClick((FavoritesMediasItem) this$0.getData());
    }

    private final void reConstraintBottom(BiliAppItemFavoritesArticleBinding $this$reConstraintBottom, boolean hasCover) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone($this$reConstraintBottom.getRoot());
        if (!hasCover) {
            constraintSet.clear($this$reConstraintBottom.bottomDesc.getId(), 3);
            constraintSet.connect($this$reConstraintBottom.bottomDesc.getId(), 3, $this$reConstraintBottom.subtitle.getId(), 4, ListExtentionsKt.toPx(8));
        } else {
            constraintSet.clear($this$reConstraintBottom.bottomDesc.getId(), 3);
        }
        constraintSet.applyTo($this$reConstraintBottom.getRoot());
    }

    protected void bind(List<Object> list) {
        Intrinsics.checkNotNullParameter(list, "payloads");
        final BiliAppItemFavoritesArticleBinding $this$bind_u24lambda_u241 = this.binding;
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
            $this$bind_u24lambda_u241_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesArticleHolder$$ExternalSyntheticLambda3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FavoritesArticleHolder.bind$lambda$1$0$0(BiliAppItemFavoritesArticleBinding.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNull($this$bind_u24lambda_u241_u240);
            ValueAnimator $this$doOnStart$iv = $this$bind_u24lambda_u241_u240;
            Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesArticleHolder$bind$lambda$1$0$$inlined$doOnStart$1
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
                    ListExtentionsKt.visible(BiliAppItemFavoritesArticleBinding.this.checkBox);
                }
            };
            $this$doOnStart$iv.addListener(animatorListener);
            $this$bind_u24lambda_u241_u240.addListener(animatorListener);
            $this$bind_u24lambda_u241_u240.setDuration(200L);
            $this$bind_u24lambda_u241_u240.start();
            ListExtentionsKt.visible($this$bind_u24lambda_u241.checkBox);
        }
        if (list.contains(2)) {
            ValueAnimator $this$bind_u24lambda_u241_u241 = ValueAnimator.ofInt(ListExtentionsKt.toPx(30), 0);
            $this$bind_u24lambda_u241_u241.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesArticleHolder$$ExternalSyntheticLambda4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FavoritesArticleHolder.bind$lambda$1$1$0(BiliAppItemFavoritesArticleBinding.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNull($this$bind_u24lambda_u241_u241);
            ValueAnimator $this$doOnEnd$iv = $this$bind_u24lambda_u241_u241;
            Animator.AnimatorListener animatorListener2 = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesArticleHolder$bind$lambda$1$1$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ListExtentionsKt.gone(BiliAppItemFavoritesArticleBinding.this.checkBox);
                    BiliAppItemFavoritesArticleBinding.this.checkBox.setChecked(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            };
            $this$doOnEnd$iv.addListener(animatorListener2);
            $this$bind_u24lambda_u241_u241.addListener(animatorListener2);
            $this$bind_u24lambda_u241_u241.setDuration(200L);
            $this$bind_u24lambda_u241_u241.start();
            ListExtentionsKt.gone($this$bind_u24lambda_u241.checkBox);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$0$0(BiliAppItemFavoritesArticleBinding $this_run, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        if (num != null) {
            int marginStart = num.intValue();
            View view = $this_run.guideline;
            Intrinsics.checkNotNullExpressionValue(view, "guideline");
            View $this$updateLayoutParams$iv = view;
            ConstraintLayout.LayoutParams layoutParams = $this$updateLayoutParams$iv.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ViewGroup.LayoutParams) layoutParams;
            ConstraintLayout.LayoutParams $this$bind_u24lambda_u241_u240_u240_u240_u240 = layoutParams2;
            $this$bind_u24lambda_u241_u240_u240_u240_u240.guideBegin = marginStart;
            $this$updateLayoutParams$iv.setLayoutParams(layoutParams2);
        }
        $this_run.subtitle.setMaxLines(3 - $this_run.title.getLineCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$1$0(BiliAppItemFavoritesArticleBinding $this_run, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        if (num != null) {
            int marginStart = num.intValue();
            View view = $this_run.guideline;
            Intrinsics.checkNotNullExpressionValue(view, "guideline");
            View $this$updateLayoutParams$iv = view;
            ConstraintLayout.LayoutParams layoutParams = $this$updateLayoutParams$iv.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ViewGroup.LayoutParams) layoutParams;
            ConstraintLayout.LayoutParams $this$bind_u24lambda_u241_u241_u240_u240_u240 = layoutParams2;
            $this$bind_u24lambda_u241_u241_u240_u240_u240.guideBegin = marginStart;
            $this$updateLayoutParams$iv.setLayoutParams(layoutParams2);
        }
        $this_run.subtitle.setMaxLines(3 - $this_run.title.getLineCount());
    }
}