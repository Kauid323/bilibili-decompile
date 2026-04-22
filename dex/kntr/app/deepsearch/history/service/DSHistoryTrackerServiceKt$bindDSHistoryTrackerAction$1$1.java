package kntr.app.deepsearch.history.service;

import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DSHistoryTrackerService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", "<unused var>", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.history.service.DSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1", f = "DSHistoryTrackerService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1 extends SuspendLambda implements Function3<DSHistoryAction, DSHistoryData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1(Continuation<? super DSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(DSHistoryAction dSHistoryAction, DSHistoryData dSHistoryData, Continuation<? super Unit> continuation) {
        DSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1 dSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1 = new DSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1(continuation);
        dSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1.L$0 = dSHistoryAction;
        return dSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DSHistoryAction action = (DSHistoryAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action instanceof DSHistoryAction.HistoryTrackerAction.ItemClick) {
                    DSHistoryTrackerServiceKt.handleItemClick((DSHistoryAction.HistoryTrackerAction.ItemClick) action);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}