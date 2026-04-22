package kntr.common.bilitheme.compose.bottomsheet;

import androidx.compose.material3.SheetState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: ComposeBottomsheet.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"kntr/common/bilitheme/compose/bottomsheet/ComposeBottomsheetKt$rememberBottomSheetScope$1$1", "Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;", "dismiss", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-bottomsheet_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposeBottomsheetKt$rememberBottomSheetScope$1$1 implements BottomSheetScope {
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ SheetState $sheetState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposeBottomsheetKt$rememberBottomSheetScope$1$1(SheetState $sheetState, Function0<Unit> function0) {
        this.$sheetState = $sheetState;
        this.$onDismiss = function0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    @Override // kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object dismiss(Continuation<? super Unit> continuation) {
        ComposeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1 composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1;
        if (continuation instanceof ComposeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1) {
            composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1 = (ComposeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1) continuation;
            if ((composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1.label & Integer.MIN_VALUE) != 0) {
                composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1.label -= Integer.MIN_VALUE;
                Object $result = composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        SheetState sheetState = this.$sheetState;
                        composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1.label = 1;
                        if (sheetState.hide(composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.$onDismiss.invoke();
                return Unit.INSTANCE;
            }
        }
        composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1 = new ComposeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1(this, continuation);
        Object $result2 = composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (composeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1.label) {
        }
        this.$onDismiss.invoke();
        return Unit.INSTANCE;
    }
}