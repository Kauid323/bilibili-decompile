package tv.danmaku.bili.ui.main2.basic.story;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: HomeStoryEntranceAnimation.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/story/AnimationRunnable;", "Ljava/lang/Runnable;", "<init>", "()V", "run", "", "runAnim", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class AnimationRunnable implements Runnable {
    public static final int $stable = 0;

    public abstract void runAnim();

    public AnimationRunnable() {
        CopyOnWriteArrayList pendingExecuteAnimations;
        pendingExecuteAnimations = HomeStoryEntranceAnimationKt.getPendingExecuteAnimations();
        pendingExecuteAnimations.add(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArrayList pendingExecuteAnimations;
        BLog.i("[TopLeft]HomeStoryEntrance", "AnimationRunnable run");
        pendingExecuteAnimations = HomeStoryEntranceAnimationKt.getPendingExecuteAnimations();
        pendingExecuteAnimations.remove(this);
        runAnim();
    }
}