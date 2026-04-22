package kntr.app.tribee.steam.bottomsheet;

import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: TribeeSteamThreeDotBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$1$1$1$1$2$1$1", f = "TribeeSteamThreeDotBottomSheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$1$1$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageType;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$1$1$1$1$2$1$1(String str, Continuation<? super TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$1$1$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$pageType = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$1$1$1$1$2$1$1(this.$pageType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = this.$pageType;
                if (it != null) {
                    SteamTrackerKt.steamPageFloatExposure(it);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}