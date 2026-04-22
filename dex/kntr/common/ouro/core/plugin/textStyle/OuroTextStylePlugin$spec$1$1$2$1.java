package kntr.common.ouro.core.plugin.textStyle;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.OuroPoint;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState;
import kntr.common.ouro.core.utils.MarkConflictResolverKt;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroTextStylePlugin.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$spec$1$1$2$1", f = "OuroTextStylePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroTextStylePlugin$spec$1$1$2$1 extends SuspendLambda implements Function2<State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroTextStylePlugin$spec$1$1$2$1(Continuation<? super OuroTextStylePlugin$spec$1$1$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ouroTextStylePlugin$spec$1$1$2$1 = new OuroTextStylePlugin$spec$1$1$2$1(continuation);
        ouroTextStylePlugin$spec$1$1$2$1.L$0 = obj;
        return ouroTextStylePlugin$spec$1$1$2$1;
    }

    public final Object invoke(State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin$spec$1$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OuroState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OuroTextStylePlugin$spec$1$1$2$1.invokeSuspend$lambda$0((OuroState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$0(OuroState $this$mutate) {
        OuroTextStyleState newState;
        OuroTextElement ouroTextElement;
        OuroTextElement ouroTextElement2;
        OuroMarks panelMarks = OuroNodeStorageUtilsKt.getResolvedTextMarks($this$mutate.getStorage(), $this$mutate.getSelection(), true);
        if (panelMarks == null) {
            OuroNodeStorage $this$getPreviousSelectableOrNull$iv = $this$mutate.getStorage();
            OuroPoint point$iv = $this$mutate.getSelection().getStart();
            int prevIndex$iv = point$iv.getIndex() - 1;
            if (prevIndex$iv >= 0) {
                Object orNull = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
                if (!(orNull instanceof OuroTextElement)) {
                    orNull = null;
                }
                ouroTextElement2 = (OuroTextElement) orNull;
            } else {
                ouroTextElement2 = null;
            }
            OuroTextElement ouroTextElement3 = (OuroTextElement) ouroTextElement2;
            panelMarks = ouroTextElement3 != null ? ouroTextElement3.getMarks() : null;
            if (panelMarks == null) {
                panelMarks = $this$mutate.getStorage().getRoot().getTextMarks();
            }
        }
        OuroMarks resolvedTextMarks = OuroNodeStorageUtilsKt.getResolvedTextMarks($this$mutate.getStorage(), $this$mutate.getSelection(), false);
        if (resolvedTextMarks == null) {
            OuroNodeStorage $this$getPreviousSelectableOrNull$iv2 = $this$mutate.getStorage();
            OuroPoint point$iv2 = $this$mutate.getSelection().getStart();
            int prevIndex$iv2 = point$iv2.getIndex() - 1;
            if (prevIndex$iv2 >= 0) {
                Object orNull2 = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv2.getAllSelectables(), prevIndex$iv2);
                if (!(orNull2 instanceof OuroTextElement)) {
                    orNull2 = null;
                }
                ouroTextElement = (OuroTextElement) orNull2;
            } else {
                ouroTextElement = null;
            }
            OuroTextElement ouroTextElement4 = (OuroTextElement) ouroTextElement;
            OuroMarks marks = ouroTextElement4 != null ? ouroTextElement4.getMarks() : null;
            resolvedTextMarks = marks == null ? $this$mutate.getStorage().getRoot().getTextMarks() : marks;
        }
        OuroMarks insertMarks = resolvedTextMarks;
        if (!insertMarks.contains(OuroForegroundColorMark.Key.INSTANCE)) {
            insertMarks = insertMarks.plus((OuroMarks) new OuroForegroundColorMark(MarkConflictResolverKt.getDefaultForegroundColor()));
        }
        if ($this$mutate.getSelection().isCollapsed()) {
            newState = new OuroTextStyleState.Preview(new OuroTextStyle(panelMarks), new OuroTextStyle(insertMarks));
        } else {
            newState = new OuroTextStyleState.Active(new OuroTextStyle(panelMarks), new OuroTextStyle(insertMarks));
        }
        OuroTextStyleState pluginState$iv = newState;
        KClass forKey$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
        Map newPluginStates$iv = MapsKt.toMutableMap($this$mutate.getPluginStates());
        newPluginStates$iv.put(forKey$iv, pluginState$iv);
        return OuroState.copy$default($this$mutate, null, null, null, null, MapsKt.toMap(newPluginStates$iv), 15, null);
    }
}