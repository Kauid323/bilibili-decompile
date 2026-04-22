package kntr.common.photonic.aphro.ui;

import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt$MediaSelectBottomSheet$5$1", f = "MediaSelectBottomSheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MediaSelectBottomSheetKt$MediaSelectBottomSheet$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<Boolean, Unit>> $dismissEffect;
    final /* synthetic */ AphroState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSelectBottomSheetKt$MediaSelectBottomSheet$5$1(AphroState aphroState, State<? extends Function1<? super Boolean, Unit>> state, Continuation<? super MediaSelectBottomSheetKt$MediaSelectBottomSheet$5$1> continuation) {
        super(2, continuation);
        this.$state = aphroState;
        this.$dismissEffect = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaSelectBottomSheetKt$MediaSelectBottomSheet$5$1(this.$state, this.$dismissEffect, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (((AphroState.AphroContent) this.$state).getConfirmed()) {
                    ((Function1) this.$dismissEffect.getValue()).invoke(Boxing.boxBoolean(true));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}