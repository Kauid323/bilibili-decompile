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
public final /* synthetic */ class KBStateMachine$addKeyword$4$2 extends FunctionReferenceImpl implements Function2<State<KBPageData>, KBAddItemStatus, ChangedState<? extends KBPageData>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KBStateMachine$addKeyword$4$2(Object obj) {
        super(2, obj, KBStateMachine.class, "addItemStateMapper", "addItemStateMapper(Lcom/freeletics/flowredux/dsl/State;Lim/keywordBlocking/stateMachine/KBAddItemStatus;)Lcom/freeletics/flowredux/dsl/ChangedState;", 0);
    }

    public final ChangedState<KBPageData> invoke(State<KBPageData> state, KBAddItemStatus p1) {
        ChangedState<KBPageData> addItemStateMapper;
        Intrinsics.checkNotNullParameter(state, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        addItemStateMapper = ((KBStateMachine) this.receiver).addItemStateMapper(state, p1);
        return addItemStateMapper;
    }
}