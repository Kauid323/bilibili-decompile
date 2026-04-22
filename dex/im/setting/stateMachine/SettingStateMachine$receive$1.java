package im.setting.stateMachine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingStateMachine", f = "SettingStateMachine.kt", i = {0, 0, 0, 0}, l = {275}, m = "receive", n = {"$this$receive", "result", "it", "$i$a$-fold-SettingStateMachine$receive$3"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class SettingStateMachine$receive$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingStateMachine$receive$1(SettingStateMachine settingStateMachine, Continuation<? super SettingStateMachine$receive$1> continuation) {
        super(continuation);
        this.this$0 = settingStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object receive;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        receive = this.this$0.receive(null, null, (Continuation) this);
        return receive;
    }
}