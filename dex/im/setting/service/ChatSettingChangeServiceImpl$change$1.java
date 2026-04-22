package im.setting.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingChangeService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.service.ChatSettingChangeServiceImpl", f = "SettingChangeService.kt", i = {0, 0, 0}, l = {TraceLevel.ABOVE_DEBUG}, m = "change-gIAlu-s", n = {"item", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-ChatSettingChangeServiceImpl$change$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class ChatSettingChangeServiceImpl$change$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatSettingChangeServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSettingChangeServiceImpl$change$1(ChatSettingChangeServiceImpl chatSettingChangeServiceImpl, Continuation<? super ChatSettingChangeServiceImpl$change$1> continuation) {
        super(continuation);
        this.this$0 = chatSettingChangeServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo3403changegIAlus = this.this$0.mo3403changegIAlus(null, (Continuation) this);
        return mo3403changegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo3403changegIAlus : Result.box-impl(mo3403changegIAlus);
    }
}