package tv.danmaku.bili.ui.main2.basic.dialog.top;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.ViewKt;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageClickAnim;
import com.bilibili.playerbizcommon.utils.BezierInterpolator;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGARange;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: TopTabClickAnim.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabClickAnim;", "", "position", "", "clickAnim", "Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageClickAnim;", "<init>", "(ILcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageClickAnim;)V", "step2Anim", "Landroid/animation/ObjectAnimator;", "step3Anim", "svgaImageView", "Lcom/opensource/svgaplayer/SVGAImageView;", "mEnterDuration", "", "mExitDuration", "mTitleInterpolator", "Lcom/bilibili/playerbizcommon/utils/BezierInterpolator;", "mSvgaInterpolator", "playTabAnim", "", "tabView", "Landroid/view/ViewGroup;", "tabAnimStep1", "tabAnimStep2", "videoItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "tabAnimStep3", "clearTabAnim", "newTabView", "resetTitleAnim", "isAddedView", "", "view", "Landroid/view/View;", "IAnimatorListener", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopTabClickAnim {
    public static final int $stable = 8;
    private final SecondaryPageClickAnim clickAnim;
    private long mEnterDuration;
    private long mExitDuration;
    private final BezierInterpolator mSvgaInterpolator;
    private final BezierInterpolator mTitleInterpolator;
    private final int position;
    private ObjectAnimator step2Anim;
    private ObjectAnimator step3Anim;
    private SVGAImageView svgaImageView;

    public TopTabClickAnim(int position, SecondaryPageClickAnim clickAnim) {
        Intrinsics.checkNotNullParameter(clickAnim, "clickAnim");
        this.position = position;
        this.clickAnim = clickAnim;
        this.mEnterDuration = 500L;
        this.mExitDuration = 100L;
        this.mTitleInterpolator = new BezierInterpolator(0.7f, 0.0f, 1.0f, 1.0f);
        this.mSvgaInterpolator = new BezierInterpolator(0.0f, 0.0f, 0.3f, 1.0f);
    }

    public final void playTabAnim(ViewGroup tabView) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        Context context = tabView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SVGAParser sVGAParser = new SVGAParser(context);
        String url = new URL(this.clickAnim.getFile()).toString();
        Intrinsics.checkNotNullExpressionValue(url, "toString(...)");
        if (!sVGAParser.exists(url)) {
            TopTabClickAnimKt.preloadResource(tabView.getContext(), this.clickAnim);
        } else {
            tabAnimStep1(tabView);
        }
    }

    private final void tabAnimStep1(final ViewGroup tabView) {
        Context context = tabView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        new SVGAParser(context).parse(new URL(this.clickAnim.getFile()), new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim$tabAnimStep1$1
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                BLog.d("TopTapClickAnim", "anim step parse svga complete");
                TopTabClickAnim.this.tabAnimStep2(tabView, videoItem);
            }

            public void onError() {
                BLog.d("TopTapClickAnim", "anim step parse svga error");
            }

            public void onCacheExist() {
                BLog.d("TopTapClickAnim", "anim step parse svga cache exist");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tabAnimStep2(final ViewGroup tabView, final SVGAVideoEntity videoItem) {
        final Ref.BooleanRef hasCancel = new Ref.BooleanRef();
        ObjectAnimator $this$tabAnimStep2_u24lambda_u240 = ObjectAnimator.ofFloat(tabView, "rotationX", 0.0f, 90.0f);
        $this$tabAnimStep2_u24lambda_u240.setDuration(this.mEnterDuration);
        $this$tabAnimStep2_u24lambda_u240.setInterpolator((TimeInterpolator) this.mTitleInterpolator);
        this.step2Anim = $this$tabAnimStep2_u24lambda_u240;
        $this$tabAnimStep2_u24lambda_u240.addListener(new IAnimatorListener() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim$tabAnimStep2$1$1
            @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
            public /* synthetic */ void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
            }

            @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.d("TopTapClickAnim", "anim step rotation title start");
            }

            @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.d("TopTapClickAnim", "anim step rotation title end");
                if (!hasCancel.element) {
                    ViewGroup $this$forEach$iv = tabView;
                    int childCount = $this$forEach$iv.getChildCount();
                    for (int index$iv = 0; index$iv < childCount; index$iv++) {
                        View it = $this$forEach$iv.getChildAt(index$iv);
                        Intrinsics.checkNotNullExpressionValue(it, "getChildAt(...)");
                        it.setAlpha(0.0f);
                    }
                    this.tabAnimStep3(tabView, videoItem);
                }
            }

            @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                hasCancel.element = true;
                this.resetTitleAnim(tabView);
                BLog.d("TopTapClickAnim", "anim step rotation title cancel");
            }
        });
        $this$tabAnimStep2_u24lambda_u240.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tabAnimStep3(final ViewGroup tabView, SVGAVideoEntity videoItem) {
        Context context = tabView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SVGAImageView $this$tabAnimStep3_u24lambda_u240 = new SVGAImageView(context);
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) layoutParams).startToStart = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).topToTop = 0;
        ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = 0;
        $this$tabAnimStep3_u24lambda_u240.setLayoutParams(layoutParams);
        $this$tabAnimStep3_u24lambda_u240.setVideoItem(videoItem);
        $this$tabAnimStep3_u24lambda_u240.setLoops(1);
        $this$tabAnimStep3_u24lambda_u240.setClearsAfterStop(false);
        tabView.addView((View) $this$tabAnimStep3_u24lambda_u240, 0);
        SVGAImageView.startAnimation$default($this$tabAnimStep3_u24lambda_u240, new SVGARange(0, 1), false, 2, (Object) null);
        this.svgaImageView = $this$tabAnimStep3_u24lambda_u240;
        final Ref.BooleanRef hasCancel = new Ref.BooleanRef();
        ObjectAnimator $this$tabAnimStep3_u24lambda_u241 = ObjectAnimator.ofFloat(tabView, "rotationX", 90.0f, 0.0f);
        this.step3Anim = $this$tabAnimStep3_u24lambda_u241;
        $this$tabAnimStep3_u24lambda_u241.setDuration(this.mEnterDuration);
        $this$tabAnimStep3_u24lambda_u241.setInterpolator((TimeInterpolator) this.mSvgaInterpolator);
        $this$tabAnimStep3_u24lambda_u241.addListener(new IAnimatorListener() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim$tabAnimStep3$2$1
            @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
            public /* synthetic */ void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
            }

            @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.d("TopTapClickAnim", "anim step rotation svga start");
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
                r0 = r2.svgaImageView;
             */
            @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onAnimationEnd(Animator animation) {
                SVGAImageView sVGAImageView;
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.d("TopTapClickAnim", "anim step rotation svga end");
                if (hasCancel.element || sVGAImageView == null) {
                    return;
                }
                sVGAImageView.startAnimation();
            }

            @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.d("TopTapClickAnim", "anim step rotation svga cancel");
                hasCancel.element = true;
                this.resetTitleAnim(tabView);
            }
        });
        $this$tabAnimStep3_u24lambda_u241.start();
    }

    public final void clearTabAnim(ViewGroup newTabView) {
        boolean z;
        ViewGroup $this$forEach$iv;
        boolean z2;
        Intrinsics.checkNotNullParameter(newTabView, "newTabView");
        ObjectAnimator objectAnimator = this.step2Anim;
        boolean z3 = true;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            ObjectAnimator objectAnimator2 = this.step2Anim;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
                return;
            }
            return;
        }
        ObjectAnimator objectAnimator3 = this.step3Anim;
        if (objectAnimator3 != null && objectAnimator3.isStarted()) {
            ObjectAnimator objectAnimator4 = this.step3Anim;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
                return;
            }
            return;
        }
        SVGAImageView sVGAImageView = this.svgaImageView;
        if (sVGAImageView != null) {
            sVGAImageView.stopAnimation();
        }
        final View oldTabView = ViewKt.findFragment(newTabView).getTopTabs().getTabAt(this.position);
        if (oldTabView != null) {
            boolean z4 = false;
            if (!(oldTabView instanceof ViewGroup)) {
                return;
            }
            List animators = new ArrayList();
            ViewGroup $this$forEach$iv2 = (ViewGroup) oldTabView;
            boolean z5 = false;
            int index$iv = 0;
            int childCount = $this$forEach$iv2.getChildCount();
            while (index$iv < childCount) {
                View child = $this$forEach$iv2.getChildAt(index$iv);
                Intrinsics.checkNotNullExpressionValue(child, "getChildAt(...)");
                if (!(child.getVisibility() == 0 ? z3 : false)) {
                    z = z4;
                    $this$forEach$iv = $this$forEach$iv2;
                    z2 = z5;
                } else if (isAddedView(child)) {
                    ObjectAnimator $this$clearTabAnim_u24lambda_u240_u240_u240 = ObjectAnimator.ofFloat(child, "alpha", 1.0f, 0.0f);
                    z = z4;
                    $this$clearTabAnim_u24lambda_u240_u240_u240.setDuration(this.mExitDuration);
                    Intrinsics.checkNotNullExpressionValue($this$clearTabAnim_u24lambda_u240_u240_u240, "apply(...)");
                    animators.add($this$clearTabAnim_u24lambda_u240_u240_u240);
                    $this$forEach$iv = $this$forEach$iv2;
                    z2 = z5;
                } else {
                    z = z4;
                    child.setRotationX(0.0f);
                    ObjectAnimator $this$clearTabAnim_u24lambda_u240_u240_u241 = ObjectAnimator.ofFloat(child, "alpha", 0.0f, 1.0f);
                    $this$forEach$iv = $this$forEach$iv2;
                    z2 = z5;
                    $this$clearTabAnim_u24lambda_u240_u240_u241.setDuration(this.mExitDuration);
                    Intrinsics.checkNotNullExpressionValue($this$clearTabAnim_u24lambda_u240_u240_u241, "apply(...)");
                    animators.add($this$clearTabAnim_u24lambda_u240_u240_u241);
                }
                index$iv++;
                $this$forEach$iv2 = $this$forEach$iv;
                z5 = z2;
                z4 = z;
                z3 = true;
            }
            AnimatorSet $this$clearTabAnim_u24lambda_u240_u241 = new AnimatorSet();
            $this$clearTabAnim_u24lambda_u240_u241.playTogether(animators);
            $this$clearTabAnim_u24lambda_u240_u241.addListener(new IAnimatorListener() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim$clearTabAnim$1$2$1
                @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
                public /* synthetic */ void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animation");
                }

                @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
                public /* synthetic */ void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animation");
                }

                @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    BLog.d("TopTapClickAnim", "anim step reset start");
                }

                @Override // tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim.IAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    BLog.d("TopTapClickAnim", "anim step reset end");
                    TopTabClickAnim.this.resetTitleAnim((ViewGroup) oldTabView);
                }
            });
            $this$clearTabAnim_u24lambda_u240_u241.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetTitleAnim(ViewGroup tabView) {
        BLog.d("TopTapClickAnim", "anim step reset title");
        tabView.setRotationX(0.0f);
        List removeViews = new ArrayList();
        int childCount = tabView.getChildCount();
        for (int index$iv = 0; index$iv < childCount; index$iv++) {
            View it = tabView.getChildAt(index$iv);
            Intrinsics.checkNotNullExpressionValue(it, "getChildAt(...)");
            if (isAddedView(it)) {
                removeViews.add(it);
            } else {
                it.setAlpha(1.0f);
            }
        }
        List $this$forEach$iv = removeViews;
        for (Object element$iv : $this$forEach$iv) {
            tabView.removeView((View) element$iv);
        }
    }

    private final boolean isAddedView(View view) {
        return view instanceof SVGAImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TopTabClickAnim.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabClickAnim$IAnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IAnimatorListener extends Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        void onAnimationCancel(Animator animator);

        @Override // android.animation.Animator.AnimatorListener
        void onAnimationEnd(Animator animator);

        @Override // android.animation.Animator.AnimatorListener
        void onAnimationRepeat(Animator animator);

        @Override // android.animation.Animator.AnimatorListener
        void onAnimationStart(Animator animator);

        /* compiled from: TopTabClickAnim.kt */
        /* renamed from: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnim$IAnimatorListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public final /* synthetic */ class CC {
        }
    }
}