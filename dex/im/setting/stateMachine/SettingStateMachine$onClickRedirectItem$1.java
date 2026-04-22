package im.setting.stateMachine;

import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import faceverify.q;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingStateMachine", f = "SettingStateMachine.kt", i = {0, 0, 0, 0}, l = {TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM}, m = "onClickRedirectItem", n = {"$this$onClickRedirectItem", AuthActivity.ACTION_KEY, "item", q.KEY_RES_9_CONTENT}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class SettingStateMachine$onClickRedirectItem$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingStateMachine$onClickRedirectItem$1(SettingStateMachine settingStateMachine, Continuation<? super SettingStateMachine$onClickRedirectItem$1> continuation) {
        super(continuation);
        this.this$0 = settingStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object onClickRedirectItem;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        onClickRedirectItem = this.this$0.onClickRedirectItem(null, null, (Continuation) this);
        return onClickRedirectItem;
    }
}