package kntr.common.bilitheme.compose.bottomsheet;

import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComposeBottomsheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$BottomSheetContainer$1$1", f = "ComposeBottomsheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ComposeBottomsheetKt$BottomSheetContainer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onExpand;
    final /* synthetic */ SheetState $sheetState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeBottomsheetKt$BottomSheetContainer$1$1(SheetState sheetState, Function0<Unit> function0, Continuation<? super ComposeBottomsheetKt$BottomSheetContainer$1$1> continuation) {
        super(2, continuation);
        this.$sheetState = sheetState;
        this.$onExpand = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposeBottomsheetKt$BottomSheetContainer$1$1(this.$sheetState, this.$onExpand, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function0<Unit> function0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$sheetState.getCurrentValue() == SheetValue.Expanded && (function0 = this.$onExpand) != null) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}