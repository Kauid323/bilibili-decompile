package tv.danmaku.bili.ui.main2.mine.topleft;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.AccountMineData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopLeft.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/main2/mine/topleft/TopLeftData;", "mine", "Ltv/danmaku/bili/ui/main2/mine/AccountMineData;", "teen", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.topleft.TopLeftKt$setTopLeft$2", f = "TopLeft.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TopLeftKt$setTopLeft$2 extends SuspendLambda implements Function3<AccountMineData, Boolean, Continuation<? super TopLeftData>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TopLeftKt$setTopLeft$2(Continuation<? super TopLeftKt$setTopLeft$2> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((AccountMineData) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
    }

    public final Object invoke(AccountMineData accountMineData, boolean z, Continuation<? super TopLeftData> continuation) {
        TopLeftKt$setTopLeft$2 topLeftKt$setTopLeft$2 = new TopLeftKt$setTopLeft$2(continuation);
        topLeftKt$setTopLeft$2.L$0 = accountMineData;
        topLeftKt$setTopLeft$2.Z$0 = z;
        return topLeftKt$setTopLeft$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AccountMine.Answer answer;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                AccountMineData mine = (AccountMineData) this.L$0;
                boolean teen = this.Z$0;
                boolean z = teen && mine.getShowTeenagersAgeSetting();
                AccountMine accountMine = mine.getAccountMine();
                return new TopLeftData(z, (accountMine == null || (answer = accountMine.answer) == null) ? null : answer.activityAnswer, mine.getGarbEnum());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}