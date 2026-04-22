package tv.danmaku.biliplayerimpl.toast.left.viewholder;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.lib.image2.view.BiliImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerimpl.R;
import tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter;
import tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder;
import tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ActionMessageWithAnimationVH.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010(\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0019H\u0016J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020!H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/viewholder/ActionMessageWithAnimationVH;", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastViewHolder;", "Ltv/danmaku/biliplayerimpl/toast/left/IChangeAnimatorImpl;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mFrontImageView", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mTitleTv", "Landroid/widget/TextView;", "mActionTv", "mFinalActionTv", "mFinalBg", "", "mFinalBgColorInt", "Ljava/lang/Integer;", "mFinalActionTextColor", "mFinalActionTextColorInt", "mFinalBgGradientColors", "", "mIsAnimStart", "", "isCollapse", "valueAnimator", "Landroid/animation/ValueAnimator;", "getValueAnimator", "()Landroid/animation/ValueAnimator;", "duration", "", "getDuration", "()J", "onViewRecycled", "", "bindPlayerToast", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "adapter", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter;", "bindWithNoAnimation", "bindWithAnimation", "onAnimationUpdate", "animation", "onAnimationStart", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "setFinalState", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ActionMessageWithAnimationVH extends AbsToastViewHolder implements IChangeAnimatorImpl {
    public static final Companion Companion = new Companion(null);
    public static final int INVALID_COLOR_INT = Integer.MAX_VALUE;
    private boolean isCollapse;
    private final TextView mActionTv;
    private int mFinalActionTextColor;
    private Integer mFinalActionTextColorInt;
    private final TextView mFinalActionTv;
    private int mFinalBg;
    private Integer mFinalBgColorInt;
    private int[] mFinalBgGradientColors;
    private final BiliImageView mFrontImageView;
    private boolean mIsAnimStart;
    private final TextView mTitleTv;

    public /* synthetic */ ActionMessageWithAnimationVH(View view2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2);
    }

    private ActionMessageWithAnimationVH(View itemView) {
        super(itemView);
        BiliImageView findViewById = itemView.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mFrontImageView = findViewById;
        View findViewById2 = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mTitleTv = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.action);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mActionTv = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.yellow);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mFinalActionTv = (TextView) findViewById4;
        this.mFinalActionTextColor = 17170443;
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl
    public ValueAnimator getValueAnimator() {
        int measureText;
        TextPaint paint = this.mFinalActionTv.getPaint();
        if (paint == null) {
            measureText = (int) DpUtils.dp2px(BiliContext.application(), 110.0f);
        } else {
            measureText = ((int) paint.measureText(this.mFinalActionTv.getText().toString())) + ((int) DpUtils.dp2px(BiliContext.application(), 32.0f));
        }
        int end = measureText;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.itemView.getWidth(), end);
        Intrinsics.checkNotNullExpressionValue(ofInt, "ofInt(...)");
        return ofInt;
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl
    public long getDuration() {
        return 300L;
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder
    public void onViewRecycled() {
        super.onViewRecycled();
        this.itemView.animate().cancel();
        this.itemView.setOnClickListener(null);
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastViewHolder
    public void bindPlayerToast(final PlayerToast toast, AbsToastListAdapter adapter) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        boolean z = true;
        boolean isAnim = toast.getExtraBooleanValue(PlayerToastConfig.EXTRA_ACTION_NEED_ANIM, true);
        if (isAnim) {
            bindWithAnimation(toast, adapter);
        } else {
            bindWithNoAnimation(toast, adapter);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActionMessageWithAnimationVH.bindPlayerToast$lambda$0(PlayerToast.this, this, view2);
            }
        });
        ViewGroup.LayoutParams params = this.itemView.getLayoutParams();
        params.width = -2;
        this.itemView.setLayoutParams(params);
        View toastView = toast.getToastView();
        if (toastView == null || toastView.getVisibility() != 8) {
            z = false;
        }
        if (z) {
            this.itemView.setVisibility(8);
        } else {
            this.itemView.setVisibility(0);
        }
        toast.setToastView(this.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindPlayerToast$lambda$0(PlayerToast $toast, ActionMessageWithAnimationVH this$0, View v) {
        PlayerToast.MessageClickListener listener = $toast.getClickListener();
        if (listener != null) {
            listener.onActionWithCollapse(PlayerToast.MessageClickListener.Companion.getCLICK_ID1(), this$0.isCollapse);
        }
    }

    private final void bindWithNoAnimation(PlayerToast toast, AbsToastListAdapter adapter) {
        this.mFrontImageView.setVisibility(8);
        this.mTitleTv.setVisibility(8);
        this.mActionTv.setVisibility(8);
        boolean z = false;
        this.mFinalActionTv.setVisibility(0);
        String finalActionText = toast.getExtraString(PlayerToastConfig.EXTRA_FINAL_ACTION_TEXT);
        int toastFinalBgResId = toast.getExtraIntValue(PlayerToastConfig.EXTRA_BG_FINAL_DRAWABLE_RES_ID);
        if (toastFinalBgResId > 0) {
            this.mFinalBg = toastFinalBgResId;
        }
        this.mFinalBgColorInt = Integer.valueOf(toast.getExtraIntValue(PlayerToastConfig.EXTRA_BG_FINAL_COLOR_INT, INVALID_COLOR_INT));
        this.mFinalBgGradientColors = toast.getExtraIntArray(PlayerToastConfig.EXTRA_BG_FINAL_GRADIENT_COLOR_ARRAY);
        int finalActionTextColorResId = toast.getExtraIntValue(PlayerToastConfig.EXTRA_FINAL_ACTION_TEXT_COLOR_RES_ID);
        if (finalActionTextColorResId > 0) {
            this.mFinalActionTextColor = finalActionTextColorResId;
        }
        this.mFinalActionTextColorInt = Integer.valueOf(toast.getExtraIntValue(PlayerToastConfig.EXTRA_FINAL_ACTION_TEXT_COLOR_INT, INVALID_COLOR_INT));
        int actionTextColorResId = toast.getExtraIntValue(PlayerToastConfig.EXTRA_ACTION_TEXT_COLOR_RES_ID);
        if (actionTextColorResId > 0) {
            this.mFinalActionTv.setTextColor(this.itemView.getResources().getColor(actionTextColorResId));
        } else {
            Integer valueOf = Integer.valueOf(toast.getExtraIntValue(PlayerToastConfig.EXTRA_ACTION_TEXT_COLOR_INT, INVALID_COLOR_INT));
            int it = valueOf.intValue();
            if (!(it != Integer.MAX_VALUE)) {
                valueOf = null;
            }
            if (valueOf != null) {
                int colorInt = valueOf.intValue();
                this.mFinalActionTv.setTextColor(colorInt);
            }
        }
        TextView textView = this.mFinalActionTv;
        String str = finalActionText;
        if (str == null || StringsKt.isBlank(str)) {
            z = true;
        }
        textView.setText(z ? PlayerToastConfig.getActionText(toast) : finalActionText);
        setFinalState();
    }

    private final void bindWithAnimation(PlayerToast toast, AbsToastListAdapter adapter) {
        Drawable drawable;
        this.itemView.animate().cancel();
        if (toast.getQueueType() != 49) {
            this.isCollapse = false;
        }
        if (this.isCollapse) {
            this.mFinalActionTv.setText(PlayerToastConfig.getActionText(toast));
            return;
        }
        int frontDrawableId = toast.getExtraIntValue(PlayerToastConfig.EXTRA_FRONT_DRAWABLE_RES_ID);
        if (frontDrawableId <= 0) {
            this.mFrontImageView.setVisibility(8);
            String url = toast.getExtraString(PlayerToastConfig.EXTRA_FRONT_DRAWABLE_URL);
            String str = url;
            if (!(str == null || str.length() == 0)) {
                BiliImageLoader.INSTANCE.acquire(this.mFrontImageView).with(this.mFrontImageView).asDrawable().url(url).submit().subscribe(new ImageDataSubscriber<DrawableHolder>() { // from class: tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH$bindWithAnimation$1
                    public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                        ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
                    }

                    public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
                        boolean z;
                        DrawableHolder drawableHolder;
                        Drawable it;
                        BiliImageView biliImageView;
                        BiliImageView biliImageView2;
                        z = ActionMessageWithAnimationVH.this.mIsAnimStart;
                        if (!z && imageDataSource != null && (drawableHolder = (DrawableHolder) imageDataSource.getResult()) != null && (it = drawableHolder.get()) != null) {
                            ActionMessageWithAnimationVH actionMessageWithAnimationVH = ActionMessageWithAnimationVH.this;
                            biliImageView = actionMessageWithAnimationVH.mFrontImageView;
                            biliImageView.getGenericProperties().setImage(it);
                            biliImageView2 = actionMessageWithAnimationVH.mFrontImageView;
                            biliImageView2.setVisibility(0);
                        }
                    }

                    public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
                    }

                    public void onCancellation(ImageDataSource<DrawableHolder> imageDataSource) {
                    }
                });
            }
        } else {
            this.mFrontImageView.setImageResource(frontDrawableId);
            this.mFrontImageView.setVisibility(0);
        }
        int toastFinalBgResId = toast.getExtraIntValue(PlayerToastConfig.EXTRA_BG_FINAL_DRAWABLE_RES_ID);
        if (toastFinalBgResId > 0) {
            this.mFinalBg = toastFinalBgResId;
        }
        this.mFinalBgColorInt = Integer.valueOf(toast.getExtraIntValue(PlayerToastConfig.EXTRA_BG_FINAL_COLOR_INT, INVALID_COLOR_INT));
        this.mFinalBgGradientColors = toast.getExtraIntArray(PlayerToastConfig.EXTRA_BG_FINAL_GRADIENT_COLOR_ARRAY);
        int finalActionTextColorResId = toast.getExtraIntValue(PlayerToastConfig.EXTRA_FINAL_ACTION_TEXT_COLOR_RES_ID);
        if (finalActionTextColorResId > 0) {
            this.mFinalActionTextColor = finalActionTextColorResId;
        }
        this.mFinalActionTextColorInt = Integer.valueOf(toast.getExtraIntValue(PlayerToastConfig.EXTRA_FINAL_ACTION_TEXT_COLOR_INT, INVALID_COLOR_INT));
        int actionTextColorResId = toast.getExtraIntValue(PlayerToastConfig.EXTRA_ACTION_TEXT_COLOR_RES_ID);
        if (actionTextColorResId > 0) {
            this.mActionTv.setTextColor(this.itemView.getResources().getColor(actionTextColorResId));
            this.mFinalActionTv.setTextColor(this.itemView.getResources().getColor(actionTextColorResId));
        } else {
            Integer valueOf = Integer.valueOf(toast.getExtraIntValue(PlayerToastConfig.EXTRA_ACTION_TEXT_COLOR_INT, INVALID_COLOR_INT));
            int it = valueOf.intValue();
            int it2 = it != Integer.MAX_VALUE ? 1 : 0;
            if (it2 == 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                int colorInt = valueOf.intValue();
                this.mActionTv.setTextColor(colorInt);
                this.mFinalActionTv.setTextColor(colorInt);
            }
        }
        String title = PlayerToastConfig.getTitle(toast);
        this.mTitleTv.setText(title);
        this.mTitleTv.setVisibility(0);
        String actionText = PlayerToastConfig.getActionText(toast);
        String finalActionText = toast.getExtraString(PlayerToastConfig.EXTRA_FINAL_ACTION_TEXT);
        this.mActionTv.setText(actionText);
        this.mActionTv.setVisibility(0);
        String str2 = finalActionText;
        this.mFinalActionTv.setText(str2 == null || StringsKt.isBlank(str2) ? actionText : finalActionText);
        this.mFinalActionTv.setVisibility(8);
        View view2 = this.itemView;
        Drawable $this$bindWithAnimation_u24lambda_u242 = ContextCompat.getDrawable(this.itemView.getContext(), tv.danmaku.biliplayer.baseres.R.drawable.shape_roundrect_player_black);
        if ($this$bindWithAnimation_u24lambda_u242 != null) {
            Integer valueOf2 = Integer.valueOf(toast.getExtraIntValue(PlayerToastConfig.EXTRA_BG_COLOR_INT, INVALID_COLOR_INT));
            int it3 = valueOf2.intValue();
            if (!(it3 != Integer.MAX_VALUE)) {
                valueOf2 = null;
            }
            if (valueOf2 != null) {
                int bgColorInt = valueOf2.intValue();
                Drawable mutate = $this$bindWithAnimation_u24lambda_u242.mutate();
                GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(bgColorInt);
                }
            }
            drawable = $this$bindWithAnimation_u24lambda_u242;
        } else {
            drawable = null;
        }
        view2.setBackground(drawable);
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl
    public void onAnimationUpdate(ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ViewGroup.LayoutParams params = this.itemView.getLayoutParams();
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        params.width = ((Integer) animatedValue).intValue();
        this.itemView.setLayoutParams(params);
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl
    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.mIsAnimStart = true;
        this.mFrontImageView.setVisibility(8);
        this.mTitleTv.setVisibility(8);
        this.mActionTv.setVisibility(8);
        this.mFinalActionTv.setVisibility(0);
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.IChangeAnimatorImpl
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.isCollapse = true;
        setFinalState();
    }

    private final void setFinalState() {
        View view2 = this.itemView;
        Drawable $this$setFinalState_u24lambda_u240 = ContextCompat.getDrawable(this.itemView.getContext(), this.mFinalBg > 0 ? this.mFinalBg : tv.danmaku.biliplayer.baseres.R.drawable.shape_roundrect_player_black);
        if ($this$setFinalState_u24lambda_u240 == null) {
            $this$setFinalState_u24lambda_u240 = null;
        } else if (this.mFinalBgGradientColors != null) {
            Drawable mutate = $this$setFinalState_u24lambda_u240.mutate();
            GradientDrawable $this$setFinalState_u24lambda_u240_u240 = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
            if ($this$setFinalState_u24lambda_u240_u240 != null) {
                $this$setFinalState_u24lambda_u240_u240.setColors(this.mFinalBgGradientColors);
                $this$setFinalState_u24lambda_u240_u240.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                $this$setFinalState_u24lambda_u240_u240.setGradientType(0);
            }
        } else {
            Integer num = this.mFinalBgColorInt;
            if (num != null) {
                int it = num.intValue();
                int it2 = it != Integer.MAX_VALUE ? 1 : 0;
                if (it2 == 0) {
                    num = null;
                }
                if (num != null) {
                    int finalBgColorInt = num.intValue();
                    Drawable mutate2 = $this$setFinalState_u24lambda_u240.mutate();
                    GradientDrawable gradientDrawable = mutate2 instanceof GradientDrawable ? (GradientDrawable) mutate2 : null;
                    if (gradientDrawable != null) {
                        gradientDrawable.setColor(finalBgColorInt);
                    }
                }
            }
        }
        view2.setBackground($this$setFinalState_u24lambda_u240);
        TextView textView = this.mFinalActionTv;
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        textView.setTextColor(application.getResources().getColor(this.mFinalActionTextColor));
        Integer num2 = this.mFinalActionTextColorInt;
        if (num2 != null) {
            int it3 = num2.intValue();
            Integer num3 = it3 != Integer.MAX_VALUE ? num2 : null;
            if (num3 != null) {
                int finalActionTextColorInt = num3.intValue();
                this.mFinalActionTv.setTextColor(finalActionTextColorInt);
            }
        }
    }

    /* compiled from: ActionMessageWithAnimationVH.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/viewholder/ActionMessageWithAnimationVH$Companion;", "", "<init>", "()V", "INVALID_COLOR_INT", "", "create", "Ltv/danmaku/biliplayerimpl/toast/left/viewholder/ActionMessageWithAnimationVH;", "parent", "Landroid/view/ViewGroup;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActionMessageWithAnimationVH create(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_player_toast_message_pay_movie, parent, false);
            Intrinsics.checkNotNull(view2);
            return new ActionMessageWithAnimationVH(view2, null);
        }
    }
}