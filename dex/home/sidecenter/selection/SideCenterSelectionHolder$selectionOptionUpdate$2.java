package home.sidecenter.selection;

import com.bapis.bilibili.app.home.v1.KHomeMoss;
import com.bapis.bilibili.app.home.v1.KMineSelectionOptionUpdateReq;
import home.sidecenter.recent.RecentIconItem;
import home.sidecenter.selection.ISideCenterSelectionAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SideCenterSelectionHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.selection.SideCenterSelectionHolder$selectionOptionUpdate$2", f = "SideCenterSelectionHolder.kt", i = {0, 0, 1, 1, 2, 2}, l = {179, 180, 183}, m = "invokeSuspend", n = {"$this$SideCenterSelectionActionResult", "itemIds", "$this$SideCenterSelectionActionResult", "itemIds", "$this$SideCenterSelectionActionResult", "e"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class SideCenterSelectionHolder$selectionOptionUpdate$2 extends SuspendLambda implements Function2<FlowCollector<? super ISideCenterSelectionAction>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SideCenterSelectionHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideCenterSelectionHolder$selectionOptionUpdate$2(SideCenterSelectionHolder sideCenterSelectionHolder, Continuation<? super SideCenterSelectionHolder$selectionOptionUpdate$2> continuation) {
        super(2, continuation);
        this.this$0 = sideCenterSelectionHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sideCenterSelectionHolder$selectionOptionUpdate$2 = new SideCenterSelectionHolder$selectionOptionUpdate$2(this.this$0, continuation);
        sideCenterSelectionHolder$selectionOptionUpdate$2.L$0 = obj;
        return sideCenterSelectionHolder$selectionOptionUpdate$2;
    }

    public final Object invoke(FlowCollector<? super ISideCenterSelectionAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00f3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        SideCenterSelectionState currentState;
        List itemIds;
        FlowCollector $this$SideCenterSelectionActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e2) {
            KLog_androidKt.getKLog().e("SideCenterSelectionHolder", "Failed update setting selection page data");
            this.L$0 = SpillingKt.nullOutSpilledVariable($this$SideCenterSelectionActionResult);
            this.L$1 = SpillingKt.nullOutSpilledVariable(e2);
            this.label = 3;
            if ($this$SideCenterSelectionActionResult.emit(new ISideCenterSelectionAction.UpdateSelectedItemFailed(e2), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("SideCenterSelectionHolder", "Start update setting selection page data");
                currentState = this.this$0.getCurrentState();
                Iterable $this$filter$iv = currentState.getSelected();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    RecentIconItem it = (RecentIconItem) element$iv$iv;
                    if (!it.getFixed()) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    RecentIconItem it2 = (RecentIconItem) element$iv$iv$iv;
                    Long longOrNull = StringsKt.toLongOrNull(it2.getId());
                    if (longOrNull != null) {
                        destination$iv$iv2.add(longOrNull);
                    }
                }
                itemIds = (List) destination$iv$iv2;
                this.L$0 = $this$SideCenterSelectionActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(itemIds);
                this.label = 1;
                if (new KHomeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).mineSelectionOptionUpdate(new KMineSelectionOptionUpdateReq(itemIds), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.L$0 = $this$SideCenterSelectionActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(itemIds);
                this.label = 2;
                if ($this$SideCenterSelectionActionResult.emit(new ISideCenterSelectionAction.UpdateSelectedItemSuccess("保存成功"), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                itemIds = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$SideCenterSelectionActionResult;
                this.L$1 = SpillingKt.nullOutSpilledVariable(itemIds);
                this.label = 2;
                if ($this$SideCenterSelectionActionResult.emit(new ISideCenterSelectionAction.UpdateSelectedItemSuccess("保存成功"), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                List list = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 3:
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}