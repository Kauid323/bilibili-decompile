package kntr.app.game.steam;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.PvEventTriggerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SteamGameAchievementPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.SteamGameAchievementPageKt$SteamGameAchievementPageContent$2$1", f = "SteamGameAchievementPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SteamGameAchievementPageKt$SteamGameAchievementPageContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ PvEventTrigger $pvTrigger;
    final /* synthetic */ String $sourceFrom;
    final /* synthetic */ String $spmid;
    final /* synthetic */ String $spmidFrom;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamGameAchievementPageKt$SteamGameAchievementPageContent$2$1(PvEventTrigger pvEventTrigger, String str, String str2, String str3, String str4, Continuation<? super SteamGameAchievementPageKt$SteamGameAchievementPageContent$2$1> continuation) {
        super(2, continuation);
        this.$pvTrigger = pvEventTrigger;
        this.$spmid = str;
        this.$sourceFrom = str2;
        this.$spmidFrom = str3;
        this.$appId = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SteamGameAchievementPageKt$SteamGameAchievementPageContent$2$1(this.$pvTrigger, this.$spmid, this.$sourceFrom, this.$spmidFrom, this.$appId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PvEventTriggerKt.updateExtra(this.$pvTrigger, "spmid", this.$spmid);
                PvEventTriggerKt.updateExtra(this.$pvTrigger, "sourcefrom", this.$sourceFrom);
                PvEventTriggerKt.updateExtra(this.$pvTrigger, AdAlarmExtraKey.STATUS, "1");
                PvEventTriggerKt.updateExtra(this.$pvTrigger, "spmid_from", this.$spmidFrom);
                PvEventTriggerKt.updateExtra(this.$pvTrigger, "app_id", this.$appId);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}