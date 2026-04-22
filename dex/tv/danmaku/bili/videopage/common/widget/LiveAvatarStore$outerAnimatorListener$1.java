package tv.danmaku.bili.videopage.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bilibili.lib.coroutineextension.CoroutineExtensionKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveAvatarStore.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/bili/videopage/common/widget/LiveAvatarStore$outerAnimatorListener$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LiveAvatarStore$outerAnimatorListener$1 extends AnimatorListenerAdapter {
    final /* synthetic */ LiveAvatarStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveAvatarStore$outerAnimatorListener$1(LiveAvatarStore $receiver) {
        this.this$0 = $receiver;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Job job;
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.resetInner();
        this.this$0.resetOuter();
        job = this.this$0.mWaitJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LiveAvatarStore liveAvatarStore = this.this$0;
        long delayWait = this.this$0.getConfig().getDelayWait();
        final LiveAvatarStore liveAvatarStore2 = this.this$0;
        liveAvatarStore.mWaitJob = CoroutineExtensionKt.setTimeOut$default((CoroutineDispatcher) null, delayWait, new Function0() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$outerAnimatorListener$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onAnimationEnd$lambda$0;
                onAnimationEnd$lambda$0 = LiveAvatarStore$outerAnimatorListener$1.onAnimationEnd$lambda$0(LiveAvatarStore.this);
                return onAnimationEnd$lambda$0;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAnimationEnd$lambda$0(LiveAvatarStore this$0) {
        this$0.replay();
        return Unit.INSTANCE;
    }
}