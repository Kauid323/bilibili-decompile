package tv.danmaku.bili.ui.garb;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.bilibili.bililive.uam.config.IUAMConfig;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.bililive.uam.view.UAMViewListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;

/* compiled from: NftCardInfoGroup.kt */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"tv/danmaku/bili/ui/garb/NftCardInfoGroup$registerAnimListener$2", "Lcom/bilibili/bililive/uam/view/UAMViewListener;", "onInnerSurfaceStatusChanged", "", "isAvailable", "", "onConfigParseFinish", "config", "Lcom/bilibili/bililive/uam/config/IUAMConfig;", "onVideoFormatReadFinish", "mime", "", "onPlayStart", "onPlayFinish", "onBeforeRenderFailed", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", "message", "onPlayFailed", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardInfoGroup$registerAnimListener$2 implements UAMViewListener {
    final /* synthetic */ NftCardInfoGroup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NftCardInfoGroup$registerAnimListener$2(NftCardInfoGroup $receiver) {
        this.this$0 = $receiver;
    }

    public void onInnerSurfaceStatusChanged(boolean isAvailable) {
        BLog.d("NftCardDialog", "play show anim onInnerSurfaceStatusChanged " + isAvailable);
    }

    public void onConfigParseFinish(IUAMConfig config) {
        BLog.d("NftCardDialog", "play show anim onConfigParseFinish");
    }

    public void onVideoFormatReadFinish(String mime) {
        BLog.d("NftCardDialog", "play show anim onVideoFormatReadFinish");
    }

    public void onPlayStart() {
        UAMView uAMView;
        BLog.d("NftCardDialog", "play show anim onPlayStart");
        uAMView = this.this$0.mCardMp4Player;
        uAMView.setVisibility(4);
    }

    public void onPlayFinish() {
        View view;
        boolean z;
        String str;
        boolean z2;
        BiliCardPlayerScene.CardPlayTask.Token token;
        boolean z3;
        BLog.i("NftCardDialog", "play show anim onPlayFinish");
        view = this.this$0.mCardMp4Mask2;
        view.setVisibility(8);
        ValueAnimator $this$onPlayFinish_u24lambda_u240 = ValueAnimator.ofFloat(0.8f, 0.0f);
        final NftCardInfoGroup nftCardInfoGroup = this.this$0;
        $this$onPlayFinish_u24lambda_u240.setDuration(800L);
        $this$onPlayFinish_u24lambda_u240.setInterpolator(new DecelerateInterpolator());
        $this$onPlayFinish_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$registerAnimListener$2$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NftCardInfoGroup$registerAnimListener$2.onPlayFinish$lambda$0$0(NftCardInfoGroup.this, valueAnimator);
            }
        });
        $this$onPlayFinish_u24lambda_u240.start();
        this.this$0.mIsPlayingShowAnim = false;
        z = this.this$0.mNeedResumeVideoAfterAnim;
        if (z) {
            str = this.this$0.mCurrentPlayVideoUrl;
            z2 = this.this$0.mVideoMuteState;
            BLog.d("NftCardDialog", "play video " + str + " after anim, isMute " + z2);
            this.this$0.commitVideoTask();
            token = this.this$0.mVideoToken;
            if (token != null) {
                z3 = this.this$0.mVideoMuteState;
                token.setMute(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPlayFinish$lambda$0$0(NftCardInfoGroup this$0, ValueAnimator it) {
        View view;
        Intrinsics.checkNotNullParameter(it, "it");
        view = this$0.mCardMp4Mask;
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    public void onBeforeRenderFailed(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.this$0.mIsPlayingShowAnim = false;
        BLog.w("NftCardDialog", "play show anim onBeforeRenderFailed " + code + ", msg: " + message);
        this.this$0.loadAnimFailed(false, true);
    }

    public void onPlayFailed(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.this$0.mIsPlayingShowAnim = false;
        BLog.w("NftCardDialog", "play show anim onPlayFailed " + code);
        this.this$0.loadAnimFailed(false, true);
    }
}