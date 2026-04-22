package tv.danmaku.bili.fullscreen.exp;

import android.content.Context;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.base.util.ContextUtilKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;

/* compiled from: FullscreenLoginExp.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"launchLogin", "", "Landroid/content/Context;", "exp", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "(Landroid/content/Context;Ltv/danmaku/bili/fullscreen/exp/LoginExpType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginExpKt {
    public static final Object launchLogin(Context $this$launchLogin, LoginExpType exp, Continuation<? super Unit> continuation) {
        ActivityResultRegistry activityResultRegistry;
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Continuation it = safeContinuation;
        FragmentActivity act = ContextUtilKt.findFragmentActivityOrNull($this$launchLogin);
        ActivityResultLauncher launcher = (act == null || (activityResultRegistry = act.getActivityResultRegistry()) == null) ? null : activityResultRegistry.register(IFullscreenLoginPageKt.TAG_FULLSCREEN, new FullscreenLoginContract(), new ActivityResultCallback() { // from class: tv.danmaku.bili.fullscreen.exp.FullscreenLoginExpKt$launchLogin$2$launcher$1
            public final void onActivityResult(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "<unused var>");
                Continuation<Unit> continuation2 = it;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
        });
        if (launcher != null) {
            launcher.launch(exp);
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }
}