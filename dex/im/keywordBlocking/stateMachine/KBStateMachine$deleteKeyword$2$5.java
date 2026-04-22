package im.keywordBlocking.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.keywordBlocking.KBPageData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class KBStateMachine$deleteKeyword$2$5 extends FunctionReferenceImpl implements Function2<State<KBPageData>, KBDeleteItemStatus, ChangedState<? extends KBPageData>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KBStateMachine$deleteKeyword$2$5(Object obj) {
        super(2, obj, KBStateMachine.class, "deleteItemStateMapper", "deleteItemStateMapper(Lcom/freeletics/flowredux/dsl/State;Lim/keywordBlocking/stateMachine/KBDeleteItemStatus;)Lcom/freeletics/flowredux/dsl/ChangedState;", 0);
    }

    public final ChangedState<KBPageData> invoke(State<KBPageData> state, KBDeleteItemStatus p1) {
        ChangedState<KBPageData> deleteItemStateMapper;
        Intrinsics.checkNotNullParameter(state, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        deleteItemStateMapper = ((KBStateMachine) this.receiver).deleteItemStateMapper(state, p1);
        return deleteItemStateMapper;
    }
}