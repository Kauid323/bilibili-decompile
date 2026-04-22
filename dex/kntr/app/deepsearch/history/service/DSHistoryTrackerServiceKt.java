package kntr.app.deepsearch.history.service;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.deepsearch.base.model.history.DSHistoryAction;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DSHistoryTrackerService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"bindDSHistoryTrackerAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", "handleItemClick", "action", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$HistoryTrackerAction$ItemClick;", "history_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryTrackerServiceKt {
    public static final void bindDSHistoryTrackerAction(FlowReduxStoreBuilder<DSHistoryData, DSHistoryAction> flowReduxStoreBuilder) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Function1 block$iv = new Function1() { // from class: kntr.app.deepsearch.history.service.DSHistoryTrackerServiceKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit bindDSHistoryTrackerAction$lambda$0;
                bindDSHistoryTrackerAction$lambda$0 = DSHistoryTrackerServiceKt.bindDSHistoryTrackerAction$lambda$0((InStateBuilderBlock) obj);
                return bindDSHistoryTrackerAction$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(DSHistoryData.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindDSHistoryTrackerAction$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new DSHistoryTrackerServiceKt$bindDSHistoryTrackerAction$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(DSHistoryAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleItemClick(DSHistoryAction.HistoryTrackerAction.ItemClick action) {
        KNeuron.INSTANCE.reportClick(false, "im.ds-chat.history.record.click", MapsKt.mapOf(TuplesKt.to("record", action.getRecord())));
    }
}