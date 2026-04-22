package kntr.app.game.steam;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Brush;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SteamGameDLCPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$1$1", f = "SteamGameDLCPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Brush> $currentBackgroundBrush$delegate;
    final /* synthetic */ Brush $dynamicBrush;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$1$1(Brush brush, MutableState<Brush> mutableState, Continuation<? super SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$1$1> continuation) {
        super(2, continuation);
        this.$dynamicBrush = brush;
        this.$currentBackgroundBrush$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$1$1(this.$dynamicBrush, this.$currentBackgroundBrush$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$currentBackgroundBrush$delegate.setValue(this.$dynamicBrush);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}