package im.session;

import im.base.ContentStatus;
import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMQuickLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: IMSessionViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionViewModelImpl$state$3", f = "IMSessionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSessionViewModelImpl$state$3 extends SuspendLambda implements Function2<IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionViewModelImpl$state$3(Continuation<? super IMSessionViewModelImpl$state$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionViewModelImpl$state$3 = new IMSessionViewModelImpl$state$3(continuation);
        iMSessionViewModelImpl$state$3.L$0 = obj;
        return iMSessionViewModelImpl$state$3;
    }

    public final Object invoke(IMState iMState, Continuation<? super Unit> continuation) {
        return create(iMState, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMState it = (IMState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getVMLogTag(), "筛选器: " + it.getData().getFilters());
                IMLog.Companion companion = IMLog.Companion;
                String vMLogTag = LogTagKt.getVMLogTag();
                ContentStatus pageContentStatus = it.getPageContentStatus();
                companion.i(vMLogTag, "页面状态: " + pageContentStatus + " 列表状态: " + it.getPartialContentStatus() + " 列表尾部状态: " + it.getTailContentStatus());
                IMLog.Companion.i(LogTagKt.getVMLogTag(), "会话个数：" + it.getData().getSessions().size());
                IMLog.Companion companion2 = IMLog.Companion;
                String vMLogTag2 = LogTagKt.getVMLogTag();
                IMQuickLink quickLinks = it.getData().getQuickLinks();
                companion2.i(vMLogTag2, "金刚位强化提示气泡 " + (quickLinks != null ? quickLinks.getBubble() : null));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}