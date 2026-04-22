package home.sidecenter.recent;

import com.tencent.tauth.AuthActivity;
import host.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecentPageStateHolder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.recent.RecentPageStateHolder", f = "RecentPageStateHolder.kt", i = {0}, l = {R.styleable.CameraView_cameraVideoSizeMinWidth}, m = "handleAction", n = {AuthActivity.ACTION_KEY}, s = {"L$0"}, v = 1)
public final class RecentPageStateHolder$handleAction$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecentPageStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentPageStateHolder$handleAction$1(RecentPageStateHolder recentPageStateHolder, Continuation<? super RecentPageStateHolder$handleAction$1> continuation) {
        super(continuation);
        this.this$0 = recentPageStateHolder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleAction(null, (Continuation) this);
    }
}