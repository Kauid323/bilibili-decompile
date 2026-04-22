package im.session.service;

import com.bapis.bilibili.broadcast.message.im.KCommandMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: IMBroadcastManager.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¨\u0006\u0007"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "T", "Lcom/bapis/bilibili/broadcast/message/im/KCommandMsg$ICommand;", "it", "", "Lcom/bapis/bilibili/broadcast/message/im/KCommandMsg;", "im/base/IMBroadcastManager$ofCommandList$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.IMBroadcastManager$ofCommandList$1", f = "IMBroadcastManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionBroadcastService$updateQuickLinkCommands$$inlined$ofCommandList$1 extends SuspendLambda implements Function2<List<? extends KCommandMsg>, Continuation<? super Flow<? extends KCommandMsg.KUpdateQuickLinkCommand>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public IMSessionBroadcastService$updateQuickLinkCommands$$inlined$ofCommandList$1(Continuation continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionBroadcastService$updateQuickLinkCommands$$inlined$ofCommandList$1 = new IMSessionBroadcastService$updateQuickLinkCommands$$inlined$ofCommandList$1(continuation);
        iMSessionBroadcastService$updateQuickLinkCommands$$inlined$ofCommandList$1.L$0 = obj;
        return iMSessionBroadcastService$updateQuickLinkCommands$$inlined$ofCommandList$1;
    }

    public final Object invoke(List<KCommandMsg> list, Continuation<? super Flow<? extends KCommandMsg.KUpdateQuickLinkCommand>> continuation) {
        return create(list, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Iterable it = (List) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$mapNotNull$iv = it;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    KCommandMsg cmd = (KCommandMsg) element$iv$iv$iv;
                    KCommandMsg.ICommand command = cmd.getCommand();
                    if (!(command instanceof KCommandMsg.KUpdateQuickLinkCommand)) {
                        command = null;
                    }
                    KCommandMsg.ICommand iCommand = (KCommandMsg.KUpdateQuickLinkCommand) command;
                    if (iCommand != null) {
                        destination$iv$iv.add(iCommand);
                    }
                }
                return FlowKt.asFlow((List) destination$iv$iv);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}