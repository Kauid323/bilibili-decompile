package kntr.app.game.biz;

import kntr.app.game.report.ReportKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SteamPrivacyConfig.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.biz.SteamPrivacyConfigKt$SteamPrivacySection$1$1", f = "SteamPrivacyConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SteamPrivacyConfigKt$SteamPrivacySection$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPublic;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamPrivacyConfigKt$SteamPrivacySection$1$1(boolean z, Continuation<? super SteamPrivacyConfigKt$SteamPrivacySection$1$1> continuation) {
        super(2, continuation);
        this.$isPublic = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SteamPrivacyConfigKt$SteamPrivacySection$1$1(this.$isPublic, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.$isPublic) {
                    ReportKt.reportExposure("game-ball.steam-setting.steam-setting.set-public-button.show", MapsKt.mapOf(TuplesKt.to("button_name", "去公开")));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}