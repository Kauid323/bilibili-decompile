package im.setting.stateMachine;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingItemChangeStateMachine", f = "SettingItemChangeStateMachine.kt", i = {0, 0, 1, 1, 1, 1}, l = {144, 156}, m = SocialConstants.TYPE_REQUEST, n = {"$this$request", "changedItem", "$this$request", "changedItem", "it", "$i$a$-fold-SettingItemChangeStateMachine$request$3"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class SettingItemChangeStateMachine$request$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingItemChangeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingItemChangeStateMachine$request$1(SettingItemChangeStateMachine settingItemChangeStateMachine, Continuation<? super SettingItemChangeStateMachine$request$1> continuation) {
        super(continuation);
        this.this$0 = settingItemChangeStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object request;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        request = this.this$0.request(null, (Continuation) this);
        return request;
    }
}