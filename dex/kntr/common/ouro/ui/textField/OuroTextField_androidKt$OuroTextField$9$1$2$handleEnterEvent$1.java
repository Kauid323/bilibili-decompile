package kntr.common.ouro.ui.textField;

import androidx.compose.runtime.State;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.action.OuroInsertAction;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OuroTextField.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/common/ouro/core/OuroState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.textField.OuroTextField_androidKt$OuroTextField$9$1$2$handleEnterEvent$1", f = "OuroTextField.android.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OuroTextField_androidKt$OuroTextField$9$1$2$handleEnterEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OuroState>, Object> {
    final /* synthetic */ State<OuroState> $ouroState$delegate;
    final /* synthetic */ OuroStore $store;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroTextField_androidKt$OuroTextField$9$1$2$handleEnterEvent$1(OuroStore ouroStore, State<OuroState> state, Continuation<? super OuroTextField_androidKt$OuroTextField$9$1$2$handleEnterEvent$1> continuation) {
        super(2, continuation);
        this.$store = ouroStore;
        this.$ouroState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OuroTextField_androidKt$OuroTextField$9$1$2$handleEnterEvent$1(this.$store, this.$ouroState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OuroState> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OuroState this_$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OuroStore ouroStore = this.$store;
                this_$iv = OuroTextField_androidKt.OuroTextField$lambda$0(this.$ouroState$delegate);
                KClass key$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
                OuroPluginState ouroPluginState = this_$iv.getPluginStates().get(key$iv);
                if (!(ouroPluginState instanceof OuroTextStyleState)) {
                    ouroPluginState = null;
                }
                OuroTextStyleState ouroTextStyleState = (OuroTextStyleState) ouroPluginState;
                if (ouroTextStyleState != null) {
                    this.label = 1;
                    Object dispatchAndWait = ouroStore.dispatchAndWait(new OuroInsertAction("\n", null, null, ouroTextStyleState.getInsertTextStyle().getMarks(), null, true, null, 86, null), (Continuation) this);
                    if (dispatchAndWait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return dispatchAndWait;
                }
                throw new NoSuchElementException("No plugin state for " + key$iv);
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}