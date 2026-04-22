package tv.danmaku.bili.ui.favorites.adapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.bilibili.magicasakura.widgets.TintProgressBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesVideoBinding;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.model.Ogv;
import tv.danmaku.bili.ui.favorites.model.Upper;
import tv.danmaku.bili.widget.VectorTextView;

/* compiled from: FavoritesListAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavoritesVideoHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "binding", "Ltv/danmaku/bili/databinding/BiliAppItemFavoritesVideoBinding;", "cardClickListener", "Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppItemFavoritesVideoBinding;Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppItemFavoritesVideoBinding;", "bind", "", "setTitle", "resizeCover", "payloads", "", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesVideoHolder extends BaseFavoritesHolder<FavoritesMediasItem> {
    public static final int $stable = 8;
    private final BiliAppItemFavoritesVideoBinding binding;
    private final FavCardClickListener cardClickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FavoritesVideoHolder(BiliAppItemFavoritesVideoBinding binding, FavCardClickListener cardClickListener) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(cardClickListener, "cardClickListener");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
        this.cardClickListener = cardClickListener;
    }

    public final BiliAppItemFavoritesVideoBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x01ce, code lost:
        if (com.bilibili.app.comm.list.widget.utils.ListExtentionsKt.gone(r1.upName) == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0250, code lost:
        if (androidx.core.view.OneShotPreDrawListener.add(r1.title, new tv.danmaku.bili.ui.favorites.adapter.FavoritesVideoHolder$$ExternalSyntheticLambda1(r1)) == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void bind() {
        String it;
        String it2;
        final BiliAppItemFavoritesVideoBinding $this$bind_u24lambda_u240 = this.binding;
        resizeCover();
        BiliImageView biliImageView = $this$bind_u24lambda_u240.cover;
        Intrinsics.checkNotNullExpressionValue(biliImageView, ReportUtilKt.POS_COVER);
        ImageExtentionKt.displayImage$default(biliImageView, ((FavoritesMediasItem) getData()).getCover(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
        if (((FavoritesMediasItem) getData()).getEnableDrag()) {
            $this$bind_u24lambda_u240.getRoot().setBackgroundColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.Bg1));
            ListExtentionsKt.visible($this$bind_u24lambda_u240.line);
            ListExtentionsKt.gone($this$bind_u24lambda_u240.more);
            View view = $this$bind_u24lambda_u240.title;
            Intrinsics.checkNotNullExpressionValue(view, ReportUtilKt.POS_TITLE);
            CommonExtensionKt.setMarginRight(view, ListExtentionsKt.toPx(8));
            View view2 = $this$bind_u24lambda_u240.upName;
            Intrinsics.checkNotNullExpressionValue(view2, "upName");
            CommonExtensionKt.setMarginRight(view2, ListExtentionsKt.toPx(8));
            View view3 = $this$bind_u24lambda_u240.bottomDesc;
            Intrinsics.checkNotNullExpressionValue(view3, "bottomDesc");
            CommonExtensionKt.setMarginRight(view3, ListExtentionsKt.toPx(8));
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone($this$bind_u24lambda_u240.getRoot());
            constraintSet.connect($this$bind_u24lambda_u240.bottomDesc.getId(), 7, $this$bind_u24lambda_u240.icMove.getId(), 6);
            constraintSet.applyTo($this$bind_u24lambda_u240.getRoot());
            ListExtentionsKt.visible($this$bind_u24lambda_u240.icMove);
            $this$bind_u24lambda_u240.icMove.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesVideoHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view4, MotionEvent motionEvent) {
                    boolean bind$lambda$0$0;
                    bind$lambda$0$0 = FavoritesVideoHolder.bind$lambda$0$0(FavoritesVideoHolder.this, view4, motionEvent);
                    return bind$lambda$0$0;
                }
            });
        } else {
            ListExtentionsKt.gone($this$bind_u24lambda_u240.icMove);
        }
        $this$bind_u24lambda_u240.audioIcon.setVisibility(ListExtentionsKt.toVisibility(((FavoritesMediasItem) getData()).isAudioCard()));
        $this$bind_u24lambda_u240.checkBox.setVisibility(ListExtentionsKt.toVisibility(((FavoritesMediasItem) getData()).isCheckMode()));
        $this$bind_u24lambda_u240.checkBox.setChecked(((FavoritesMediasItem) getData()).isChecked());
        setTitle();
        VectorTextView vectorTextView = $this$bind_u24lambda_u240.leftText;
        Intrinsics.checkNotNullExpressionValue(vectorTextView, "leftText");
        ListExtentionsKt.setTextWithIcon$default(vectorTextView, ((FavoritesMediasItem) getData()).getLeftText(), ((FavoritesMediasItem) getData()).getLeftIconType(), 0, 0.0f, 0.0f, 56, (Object) null);
        VectorTextView vectorTextView2 = $this$bind_u24lambda_u240.rightText;
        Intrinsics.checkNotNullExpressionValue(vectorTextView2, "rightText");
        ListExtentionsKt.setTextWithIcon$default(vectorTextView2, ((FavoritesMediasItem) getData()).getRightText(), ((FavoritesMediasItem) getData()).getRightIconType(), 0, 0.0f, 0.0f, 56, (Object) null);
        ListExtentionsKt.setText($this$bind_u24lambda_u240.videoTime, ((FavoritesMediasItem) getData()).getPlaybackDesc());
        if (((FavoritesMediasItem) getData()).getOtype() == 12) {
            ListExtentionsKt.gone($this$bind_u24lambda_u240.subtitle);
        } else {
            ListExtentionsKt.visible($this$bind_u24lambda_u240.subtitle);
        }
        Ogv ogv = ((FavoritesMediasItem) getData()).getOgv();
        if (ogv != null && (it2 = ogv.getTypeName()) != null) {
            ListExtentionsKt.setText($this$bind_u24lambda_u240.coverTag, it2);
            ListExtentionsKt.setText($this$bind_u24lambda_u240.subtitle, ((FavoritesMediasItem) getData()).getIntro());
        }
        ListExtentionsKt.gone($this$bind_u24lambda_u240.coverTag);
        ListExtentionsKt.gone($this$bind_u24lambda_u240.subtitle);
        VectorTextView vectorTextView3 = $this$bind_u24lambda_u240.upName;
        Intrinsics.checkNotNullExpressionValue(vectorTextView3, "upName");
        Upper upper = ((FavoritesMediasItem) getData()).getUpper();
        ListExtentionsKt.setTextWithIcon$default(vectorTextView3, upper != null ? upper.getName() : null, 25, 0, 0.0f, 0.0f, 56, (Object) null);
        Unit unit = Unit.INSTANCE;
        View view4 = $this$bind_u24lambda_u240.subtitle;
        Intrinsics.checkNotNullExpressionValue(view4, "subtitle");
        View $this$isVisible$iv = view4;
        boolean z = true;
        View $this$isVisible$iv2 = $this$isVisible$iv.getVisibility() == 0 ? 1 : null;
        if ($this$isVisible$iv2 != null) {
            String title = ((FavoritesMediasItem) getData()).getTitle();
            if (title != null && (it = ListExtentionsKt.takeIfNotBlank(title)) != null) {
                $this$bind_u24lambda_u240.title.setText(it);
                ListExtentionsKt.visible($this$bind_u24lambda_u240.title);
            }
            ListExtentionsKt.gone($this$bind_u24lambda_u240.title);
            $this$bind_u24lambda_u240.subtitle.setMaxLines(3);
            Unit unit2 = Unit.INSTANCE;
        }
        TintProgressBar tintProgressBar = $this$bind_u24lambda_u240.progress;
        int playbackPosition = ((FavoritesMediasItem) getData()).getPlaybackPosition();
        if (1 > playbackPosition || playbackPosition >= 101) {
            z = false;
        }
        tintProgressBar.setVisibility(ListExtentionsKt.toVisibility(z));
        $this$bind_u24lambda_u240.progress.setProgress(((FavoritesMediasItem) getData()).getPlaybackPosition());
        View view5 = $this$bind_u24lambda_u240.more;
        Intrinsics.checkNotNullExpressionValue(view5, "more");
        ListExtentionsKt.addTouchDelegate(view5, ListExtentionsKt.toPx(5));
        View view6 = $this$bind_u24lambda_u240.cover;
        Intrinsics.checkNotNullExpressionValue(view6, ReportUtilKt.POS_COVER);
        View $this$updateLayoutParams$iv = view6;
        ViewGroup.LayoutParams layoutParams = $this$updateLayoutParams$iv.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.LayoutParams params$iv = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.MarginLayoutParams $this$bind_u24lambda_u240_u245 = (ViewGroup.MarginLayoutParams) params$iv;
        $this$bind_u24lambda_u240_u245.setMarginStart(((FavoritesMediasItem) getData()).isCheckMode() ? ListExtentionsKt.toPx(30) : 0);
        $this$updateLayoutParams$iv.setLayoutParams(params$iv);
        $this$bind_u24lambda_u240.getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesVideoHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view7) {
                FavoritesVideoHolder.bind$lambda$0$6(FavoritesVideoHolder.this, view7);
            }
        });
        $this$bind_u24lambda_u240.more.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesVideoHolder$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view7) {
                FavoritesVideoHolder.bind$lambda$0$7(FavoritesVideoHolder.this, view7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$0(FavoritesVideoHolder this$0, View v, MotionEvent event) {
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
    public static final void bind$lambda$0$3$0(BiliAppItemFavoritesVideoBinding $this_run) {
        $this_run.subtitle.setMaxLines(3 - $this_run.title.getLineCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$6(FavoritesVideoHolder this$0, View it) {
        if (((FavoritesMediasItem) this$0.getData()).isCheckMode()) {
            this$0.cardClickListener.onCheckClick(this$0.getBindingAdapterPosition());
        } else {
            this$0.cardClickListener.onItemClick((FavoritesMediasItem) this$0.getData(), this$0.getAbsoluteAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$7(FavoritesVideoHolder this$0, View it) {
        this$0.cardClickListener.onMoreClick((FavoritesMediasItem) this$0.getData());
    }

    private final void setTitle() {
        ListExtentionsKt.setText(this.binding.title, ((FavoritesMediasItem) getData()).getDisplayTitle());
    }

    private final void resizeCover() {
        View view = this.binding.cover;
        Intrinsics.checkNotNullExpressionValue(view, ReportUtilKt.POS_COVER);
        View $this$updateLayoutParams$iv = view;
        ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
        if (params$iv$iv != null) {
            if (((FavoritesMediasItem) getData()).getOtype() == 2) {
                params$iv$iv.height = this.itemView.getResources().getDimensionPixelSize(tv.danmaku.bili.R.dimen.fav_video_card_cover_height);
                params$iv$iv.width = this.itemView.getResources().getDimensionPixelSize(tv.danmaku.bili.R.dimen.fav_video_card_cover_width);
            } else if (((FavoritesMediasItem) getData()).getOtype() == 12) {
                params$iv$iv.height = this.itemView.getResources().getDimensionPixelSize(tv.danmaku.bili.R.dimen.fav_audio_card_cover_size);
                params$iv$iv.width = this.itemView.getResources().getDimensionPixelSize(tv.danmaku.bili.R.dimen.fav_audio_card_cover_size);
            }
            $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    protected void bind(List<Object> list) {
        Intrinsics.checkNotNullParameter(list, "payloads");
        final BiliAppItemFavoritesVideoBinding $this$bind_u24lambda_u241 = this.binding;
        if (list.contains("PAYLOADS_UPDATE_TRANSLATE")) {
            setTitle();
        }
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
            $this$bind_u24lambda_u241_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesVideoHolder$$ExternalSyntheticLambda4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FavoritesVideoHolder.bind$lambda$1$0$0(BiliAppItemFavoritesVideoBinding.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNull($this$bind_u24lambda_u241_u240);
            ValueAnimator $this$doOnStart$iv = $this$bind_u24lambda_u241_u240;
            Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesVideoHolder$bind$lambda$1$0$$inlined$doOnStart$1
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
                    ListExtentionsKt.visible(BiliAppItemFavoritesVideoBinding.this.checkBox);
                }
            };
            $this$doOnStart$iv.addListener(animatorListener);
            $this$bind_u24lambda_u241_u240.addListener(animatorListener);
            $this$bind_u24lambda_u241_u240.setDuration(200L);
            $this$bind_u24lambda_u241_u240.start();
        }
        if (list.contains(2)) {
            ValueAnimator $this$bind_u24lambda_u241_u241 = ValueAnimator.ofInt(ListExtentionsKt.toPx(30), 0);
            $this$bind_u24lambda_u241_u241.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesVideoHolder$$ExternalSyntheticLambda5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FavoritesVideoHolder.bind$lambda$1$1$0(BiliAppItemFavoritesVideoBinding.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNull($this$bind_u24lambda_u241_u241);
            ValueAnimator $this$doOnStart$iv2 = $this$bind_u24lambda_u241_u241;
            Animator.AnimatorListener animatorListener2 = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesVideoHolder$bind$lambda$1$1$$inlined$doOnStart$1
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
                    ListExtentionsKt.gone(BiliAppItemFavoritesVideoBinding.this.checkBox);
                    BiliAppItemFavoritesVideoBinding.this.checkBox.setChecked(false);
                }
            };
            $this$doOnStart$iv2.addListener(animatorListener2);
            $this$bind_u24lambda_u241_u241.addListener(animatorListener2);
            $this$bind_u24lambda_u241_u241.setDuration(200L);
            $this$bind_u24lambda_u241_u241.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1$0$0(BiliAppItemFavoritesVideoBinding $this_run, ValueAnimator it) {
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
    public static final void bind$lambda$1$1$0(BiliAppItemFavoritesVideoBinding $this_run, ValueAnimator it) {
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
}