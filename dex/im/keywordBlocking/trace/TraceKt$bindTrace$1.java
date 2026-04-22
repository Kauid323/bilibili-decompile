package im.keywordBlocking.trace;

import com.tencent.tauth.AuthActivity;
import im.keywordBlocking.KBAction;
import im.keywordBlocking.KBActionAddConfirm;
import im.keywordBlocking.KBActionAddItem;
import im.keywordBlocking.KBActionClickItem;
import im.keywordBlocking.KBActionDeleteAlertShow;
import im.keywordBlocking.KBActionDeleteCancel;
import im.keywordBlocking.KBActionDeleteConfirm;
import im.keywordBlocking.KBActionDeleteItem;
import im.keywordBlocking.KBActionDropListShow;
import im.keywordBlocking.KBActionInputBoxShow;
import im.keywordBlocking.KBPageData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Trace.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", AuthActivity.ACTION_KEY, "Lim/keywordBlocking/KBAction;", "stateSnapshot", "Lim/keywordBlocking/KBPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.trace.TraceKt$bindTrace$1", f = "Trace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TraceKt$bindTrace$1 extends SuspendLambda implements Function3<KBAction, KBPageData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TraceKt$bindTrace$1(Continuation<? super TraceKt$bindTrace$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(KBAction kBAction, KBPageData kBPageData, Continuation<? super Unit> continuation) {
        TraceKt$bindTrace$1 traceKt$bindTrace$1 = new TraceKt$bindTrace$1(continuation);
        traceKt$bindTrace$1.L$0 = kBAction;
        return traceKt$bindTrace$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KBAction action = (KBAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action instanceof KBActionAddItem) {
                    TraceKt.handleAddClick();
                } else if (action instanceof KBActionInputBoxShow) {
                    TraceKt.handleInputBoxShow();
                } else if (action instanceof KBActionAddConfirm) {
                    TraceKt.handleInputBoxConfirmClick();
                } else if (action instanceof KBActionClickItem) {
                    TraceKt.handleListItemClick();
                } else if (action instanceof KBActionDropListShow) {
                    TraceKt.handleDropListShow();
                } else if (action instanceof KBActionDeleteItem) {
                    TraceKt.handleDropListClick();
                } else if (action instanceof KBActionDeleteAlertShow) {
                    TraceKt.handleDeleteAlertShow();
                } else if (action instanceof KBActionDeleteCancel) {
                    TraceKt.handleDeleteAlertClick("cancel");
                } else if (action instanceof KBActionDeleteConfirm) {
                    TraceKt.handleDeleteAlertClick("delete");
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}