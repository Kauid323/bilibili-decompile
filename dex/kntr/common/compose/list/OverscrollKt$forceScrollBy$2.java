package kntr.common.compose.list;

import androidx.compose.foundation.gestures.ScrollScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: Overscroll.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.OverscrollKt$forceScrollBy$2", f = "Overscroll.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OverscrollKt$forceScrollBy$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.FloatRef $consumed;
    final /* synthetic */ float $offset;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverscrollKt$forceScrollBy$2(Ref.FloatRef floatRef, float f, Continuation<? super OverscrollKt$forceScrollBy$2> continuation) {
        super(2, continuation);
        this.$consumed = floatRef;
        this.$offset = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> overscrollKt$forceScrollBy$2 = new OverscrollKt$forceScrollBy$2(this.$consumed, this.$offset, continuation);
        overscrollKt$forceScrollBy$2.L$0 = obj;
        return overscrollKt$forceScrollBy$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return create(scrollScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ScrollScope $this$scroll = (ScrollScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$consumed.element = $this$scroll.scrollBy(this.$offset);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}