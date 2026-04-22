package kntr.common.bilitheme.compose.bottomsheet;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComposeBottomsheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$rememberBottomSheetScope$1$1", f = "ComposeBottomsheet.kt", i = {}, l = {143}, m = "dismiss", n = {}, s = {}, v = 1)
public final class ComposeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ComposeBottomsheetKt$rememberBottomSheetScope$1$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1(ComposeBottomsheetKt$rememberBottomSheetScope$1$1 composeBottomsheetKt$rememberBottomSheetScope$1$1, Continuation<? super ComposeBottomsheetKt$rememberBottomSheetScope$1$1$dismiss$1> continuation) {
        super(continuation);
        this.this$0 = composeBottomsheetKt$rememberBottomSheetScope$1$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.dismiss((Continuation) this);
    }
}