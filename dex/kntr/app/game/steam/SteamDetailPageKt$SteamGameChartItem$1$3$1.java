package kntr.app.game.steam;

import androidx.compose.runtime.MutableState;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SteamDetailPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.SteamDetailPageKt$SteamGameChartItem$1$3$1", f = "SteamDetailPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SteamDetailPageKt$SteamGameChartItem$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $priceExposed$delegate;
    final /* synthetic */ MutableState<Boolean> $showPrice$delegate;
    final /* synthetic */ MutableState<Boolean> $timeExposed$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamDetailPageKt$SteamGameChartItem$1$3$1(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super SteamDetailPageKt$SteamGameChartItem$1$3$1> continuation) {
        super(2, continuation);
        this.$showPrice$delegate = mutableState;
        this.$priceExposed$delegate = mutableState2;
        this.$timeExposed$delegate = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SteamDetailPageKt$SteamGameChartItem$1$3$1(this.$showPrice$delegate, this.$priceExposed$delegate, this.$timeExposed$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean SteamGameChartItem$lambda$4;
        boolean SteamGameChartItem$lambda$42;
        boolean SteamGameChartItem$lambda$7$6;
        boolean SteamGameChartItem$lambda$7$3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SteamGameChartItem$lambda$4 = SteamDetailPageKt.SteamGameChartItem$lambda$4(this.$showPrice$delegate);
                if (SteamGameChartItem$lambda$4) {
                    SteamGameChartItem$lambda$7$3 = SteamDetailPageKt.SteamGameChartItem$lambda$7$3(this.$priceExposed$delegate);
                    if (!SteamGameChartItem$lambda$7$3) {
                        SteamDetailPageKt.SteamGameChartItem$lambda$7$4(this.$priceExposed$delegate, true);
                        ReportKt.reportExposure("game-ball.steam-game-list.steam-game-list.histogram.show", MapsKt.mapOf(TuplesKt.to("type", AdSearchSubCardType.CARD_TYPE_2)));
                        return Unit.INSTANCE;
                    }
                }
                SteamGameChartItem$lambda$42 = SteamDetailPageKt.SteamGameChartItem$lambda$4(this.$showPrice$delegate);
                if (!SteamGameChartItem$lambda$42) {
                    SteamGameChartItem$lambda$7$6 = SteamDetailPageKt.SteamGameChartItem$lambda$7$6(this.$timeExposed$delegate);
                    if (!SteamGameChartItem$lambda$7$6) {
                        SteamDetailPageKt.SteamGameChartItem$lambda$7$7(this.$timeExposed$delegate, true);
                        ReportKt.reportExposure("game-ball.steam-game-list.steam-game-list.histogram.show", MapsKt.mapOf(TuplesKt.to("type", "1")));
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}