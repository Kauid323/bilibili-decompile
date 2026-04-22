package im.direct.notification.interactive;

import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: INStateHolder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.direct.notification.interactive.INStateHolder", f = "INStateHolder.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14}, l = {149, 154, 168, 184, 200, TbsListener.ErrorCode.COPY_EXCEPTION, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 252, 263, 265, 269, 272, 281, TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, 333}, m = "dispatchAction", n = {"currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "newList", "$i$a$-fold-INStateHolder$dispatchAction$4", "isSelected", "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY, "currentState", AuthActivity.ACTION_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "Z$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class INStateHolder$dispatchAction$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ INStateHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public INStateHolder$dispatchAction$1(INStateHolder iNStateHolder, Continuation<? super INStateHolder$dispatchAction$1> continuation) {
        super(continuation);
        this.this$0 = iNStateHolder;
    }

    public final Object invokeSuspend(Object obj) {
        Object dispatchAction;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        dispatchAction = this.this$0.dispatchAction(null, null, (Continuation) this);
        return dispatchAction;
    }
}