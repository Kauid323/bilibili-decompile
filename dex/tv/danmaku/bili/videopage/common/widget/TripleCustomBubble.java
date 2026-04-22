package tv.danmaku.bili.videopage.common.widget;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.playerbizcommon.utils.BezierInterpolator;
import com.opensource.svgaplayer.SVGAImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.videopage.common.R;
import tv.danmaku.bili.videopage.common.helper.DisplayUtils;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TripleCustomBubble.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fJ\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u0006\u0010\u0018\u001a\u00020\u0011J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u001e\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/TripleCustomBubble;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPreView", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mSucView", "mMsgView", "Landroid/widget/TextView;", "mSucImg", "", "mPreImg", "mFireWorks", "Lcom/opensource/svgaplayer/SVGAImageView;", "show", "", "anchor", "Landroid/view/View;", "preImg", "sucImg", "msg", "showPreStage", "showSuccess", "doSuccessMsgAnim", "view", "showSuccessStage", "doPreGifAnim", "doSucGifAnim", "doPreNormalAnim", "doSuccessNormalAnim", "getInterpolator", "Lcom/bilibili/playerbizcommon/utils/BezierInterpolator;", "showLocation", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TripleCustomBubble extends PopupWindow {
    public static final Companion Companion = new Companion(null);
    private static final int PIC_SIZE = DisplayUtils.dp2Px(96);
    public static final long PRE_ANIM_TIME = 1500;
    public static final long SUC_ANIM_TIME = 2500;
    private final Context context;
    private SVGAImageView mFireWorks;
    private TextView mMsgView;
    private String mPreImg;
    private BiliImageView mPreView;
    private String mSucImg;
    private BiliImageView mSucView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TripleCustomBubble(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        View rootLayout = LayoutInflater.from(this.context).inflate(R.layout.bili_app_tiple_custom_bubble_layout, (ViewGroup) null, false);
        this.mPreView = rootLayout.findViewById(R.id.pre_icon);
        this.mSucView = rootLayout.findViewById(R.id.suc_icon);
        this.mMsgView = (TextView) rootLayout.findViewById(R.id.content_msg);
        this.mFireWorks = rootLayout.findViewById(R.id.fireworks_icon);
        setContentView(rootLayout);
        setWidth(-2);
        setHeight(-2);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setClippingEnabled(false);
        setFocusable(false);
    }

    public final void show(View anchor, String preImg, String sucImg, String msg) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(preImg, "preImg");
        Intrinsics.checkNotNullParameter(sucImg, "sucImg");
        Intrinsics.checkNotNullParameter(msg, "msg");
        TextView textView = this.mMsgView;
        if (textView != null) {
            textView.setVisibility(4);
        }
        TextView textView2 = this.mMsgView;
        if (textView2 != null) {
            textView2.setText(msg);
        }
        this.mSucImg = sucImg;
        this.mPreImg = preImg;
        showLocation(anchor);
        showPreStage();
    }

    private final void showPreStage() {
        BiliImageView it = this.mPreView;
        if (it != null) {
            ImageRequestBuilder url = BiliImageLoader.INSTANCE.with(this.context).url(this.mPreImg);
            ScaleType scaleType = ScaleType.CENTER;
            Intrinsics.checkNotNullExpressionValue(scaleType, "CENTER");
            ImageRequestBuilder actualImageScaleType = url.actualImageScaleType(scaleType);
            boolean z = true;
            ImageRequestBuilder.enableAutoPlayAnimation$default(actualImageScaleType.enableAnimate(true, true).animationPlayEndlessLoop(true), true, false, 2, (Object) null).into(it);
            String str = this.mPreImg;
            if (str == null || !StringsKt.endsWith$default(str, ".gif", false, 2, (Object) null)) {
                z = false;
            }
            if (z) {
                doPreGifAnim((View) it);
            } else {
                doPreNormalAnim((View) it);
            }
        }
    }

    public final void showSuccess() {
        BiliImageView biliImageView = this.mPreView;
        if (biliImageView != null) {
            biliImageView.setVisibility(8);
        }
        showSuccessStage();
    }

    private final void doSuccessMsgAnim(View view2) {
        if (view2 == null) {
            return;
        }
        view2.setAlpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        view2.setVisibility(0);
        Keyframe frameAlpha1 = Keyframe.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        Keyframe frameAlpha2 = Keyframe.ofFloat(0.15f, 1.0f);
        frameAlpha2.setInterpolator((TimeInterpolator) getInterpolator());
        Keyframe frameAlpha3 = Keyframe.ofFloat(0.95f, 1.0f);
        Keyframe frameAlpha4 = Keyframe.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        PropertyValuesHolder scaleAlphaHolder = PropertyValuesHolder.ofKeyframe(View.ALPHA, frameAlpha1, frameAlpha2, frameAlpha3, frameAlpha4);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view2, scaleAlphaHolder);
        Intrinsics.checkNotNullExpressionValue(objectAnimator, "ofPropertyValuesHolder(...)");
        objectAnimator.setDuration(PlayerToastConfig.DURATION_2);
        objectAnimator.start();
    }

    private final void showSuccessStage() {
        BiliImageView it = this.mSucView;
        if (it != null) {
            ImageRequestBuilder url = BiliImageLoader.INSTANCE.with(this.context).url(this.mSucImg);
            ScaleType scaleType = ScaleType.FIT_CENTER;
            Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
            ImageRequestBuilder actualImageScaleType = url.actualImageScaleType(scaleType);
            boolean z = true;
            ImageRequestBuilder.enableAutoPlayAnimation$default(actualImageScaleType.enableAnimate(true, true).animationPlayEndlessLoop(true), true, false, 2, (Object) null).into(it);
            String str = this.mSucImg;
            if (str == null || !StringsKt.endsWith$default(str, ".gif", false, 2, (Object) null)) {
                z = false;
            }
            if (z) {
                doSucGifAnim((View) it);
            } else {
                doSuccessNormalAnim((View) it);
                it.postDelayed(new Runnable() { // from class: tv.danmaku.bili.videopage.common.widget.TripleCustomBubble$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TripleCustomBubble.showSuccessStage$lambda$0$0(TripleCustomBubble.this);
                    }
                }, 10L);
            }
            it.postDelayed(new Runnable() { // from class: tv.danmaku.bili.videopage.common.widget.TripleCustomBubble$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    TripleCustomBubble.showSuccessStage$lambda$0$1(TripleCustomBubble.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSuccessStage$lambda$0$0(TripleCustomBubble this$0) {
        SVGAImageView svga = this$0.mFireWorks;
        if (svga != null) {
            svga.setVisibility(0);
            svga.stepToFrame(0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSuccessStage$lambda$0$1(TripleCustomBubble this$0) {
        this$0.doSuccessMsgAnim(this$0.mMsgView);
    }

    private final void doPreGifAnim(View view2) {
        if (view2 == null) {
            return;
        }
        view2.setPivotX(PIC_SIZE / 2.0f);
        view2.setPivotY(PIC_SIZE);
        Keyframe frameScale1 = Keyframe.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        Keyframe frameScale2 = Keyframe.ofFloat(0.2f, 1.0f);
        frameScale2.setInterpolator((TimeInterpolator) getInterpolator());
        Keyframe frameScale3 = Keyframe.ofFloat(1.0f, 1.0f);
        PropertyValuesHolder scaleXValuesHolder = PropertyValuesHolder.ofKeyframe(View.SCALE_X, frameScale1, frameScale2, frameScale3);
        PropertyValuesHolder scaleYValuesHolder = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, frameScale1, frameScale2, frameScale3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view2, scaleXValuesHolder, scaleYValuesHolder);
        Intrinsics.checkNotNullExpressionValue(objectAnimator, "ofPropertyValuesHolder(...)");
        objectAnimator.setDuration(PRE_ANIM_TIME);
        objectAnimator.start();
    }

    private final void doSucGifAnim(View view2) {
        if (view2 == null) {
            return;
        }
        Keyframe frameAlpha1 = Keyframe.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        Keyframe frameAlpha2 = Keyframe.ofFloat(0.96f, 1.0f);
        Keyframe frameAlpha3 = Keyframe.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        frameAlpha3.setInterpolator((TimeInterpolator) getInterpolator());
        PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofKeyframe(View.ALPHA, frameAlpha1, frameAlpha2, frameAlpha3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view2, alphaHolder);
        Intrinsics.checkNotNullExpressionValue(objectAnimator, "ofPropertyValuesHolder(...)");
        objectAnimator.setDuration(SUC_ANIM_TIME);
        objectAnimator.start();
    }

    private final void doPreNormalAnim(View view2) {
        if (view2 == null) {
            return;
        }
        view2.setPivotX(PIC_SIZE / 2.0f);
        view2.setPivotY(PIC_SIZE);
        Keyframe frame1 = Keyframe.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        Keyframe frame2 = Keyframe.ofFloat(0.1f, 1.0f);
        Keyframe frame3 = Keyframe.ofFloat(0.94f, 1.0f);
        Keyframe frame4 = Keyframe.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        frame2.setInterpolator((TimeInterpolator) getInterpolator());
        frame4.setInterpolator((TimeInterpolator) getInterpolator());
        PropertyValuesHolder scaleXValuesHolder = PropertyValuesHolder.ofKeyframe(View.SCALE_X, frame1, frame2, frame3, frame4);
        PropertyValuesHolder scaleYValuesHolder = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, frame1, frame2, frame3, frame4);
        PropertyValuesHolder transXValuesHolder = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, -4.0f, 4.0f, -4.0f, 4.0f, 4.0f, -4.0f, 4.0f, -4.0f, 4.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        PropertyValuesHolder transYValuesHolder = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 4.0f, -4.0f, 4.0f, -4.0f, 4.0f, -4.0f, 4.0f, -4.0f, 4.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view2, scaleXValuesHolder, scaleYValuesHolder, transXValuesHolder, transYValuesHolder);
        Intrinsics.checkNotNullExpressionValue(objectAnimator, "ofPropertyValuesHolder(...)");
        objectAnimator.setDuration(PRE_ANIM_TIME);
        objectAnimator.start();
    }

    private final void doSuccessNormalAnim(View view2) {
        if (view2 == null) {
            return;
        }
        view2.setPivotX(PIC_SIZE / 2.0f);
        view2.setPivotY(PIC_SIZE);
        Keyframe frameScale1 = Keyframe.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        Keyframe frameScale2 = Keyframe.ofFloat(0.06f, 1.0f);
        Keyframe frameScale3 = Keyframe.ofFloat(1.0f, 1.0f);
        frameScale2.setInterpolator((TimeInterpolator) getInterpolator());
        PropertyValuesHolder scaleXValuesHolder = PropertyValuesHolder.ofKeyframe(View.SCALE_X, frameScale1, frameScale2, frameScale3);
        PropertyValuesHolder scaleYValuesHolder = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, frameScale1, frameScale2, frameScale3);
        Keyframe frameAlpha1 = Keyframe.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        Keyframe frameAlpha2 = Keyframe.ofFloat(0.96f, 1.0f);
        Keyframe frameAlpha3 = Keyframe.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        frameAlpha3.setInterpolator((TimeInterpolator) getInterpolator());
        PropertyValuesHolder scaleAlphaHolder = PropertyValuesHolder.ofKeyframe(View.ALPHA, frameAlpha1, frameAlpha2, frameAlpha3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view2, scaleXValuesHolder, scaleYValuesHolder, scaleAlphaHolder);
        Intrinsics.checkNotNullExpressionValue(objectAnimator, "ofPropertyValuesHolder(...)");
        objectAnimator.setDuration(SUC_ANIM_TIME);
        objectAnimator.start();
    }

    private final BezierInterpolator getInterpolator() {
        return new BezierInterpolator(0.33f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
    }

    private final void showLocation(View anchor) {
        int sizeW = DisplayUtils.dp2Px(100);
        int sizeH = DisplayUtils.dp2Px(105);
        int tranX = (anchor.getWidth() - sizeW) / 2;
        int tranY = anchor.getHeight() + sizeH;
        showAsDropDown(anchor, tranX, -tranY);
    }

    /* compiled from: TripleCustomBubble.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/TripleCustomBubble$Companion;", "", "<init>", "()V", "PIC_SIZE", "", "getPIC_SIZE", "()I", "PRE_ANIM_TIME", "", "SUC_ANIM_TIME", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getPIC_SIZE() {
            return TripleCustomBubble.PIC_SIZE;
        }
    }
}