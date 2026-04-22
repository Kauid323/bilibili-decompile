package kntr.app.upper.entrance.bubble;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.bubble.service.TiredType;
import kntr.app.upper.entrance.utils.LogUtils;
import kntr.app.upper.entrance.utils.TrackUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UperCenterPlusBubbleManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.bubble.UperCenterPlusBubbleManager$bubbleInfo$1", f = "UperCenterPlusBubbleManager.kt", i = {}, l = {35, 41}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class UperCenterPlusBubbleManager$bubbleInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $abExtra;
    final /* synthetic */ Function1<UperCenterPlusBubbleInfo, Unit> $callBack;
    final /* synthetic */ String $mid;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UperCenterPlusBubbleManager$bubbleInfo$1(String str, String str2, Function1<? super UperCenterPlusBubbleInfo, Unit> function1, Continuation<? super UperCenterPlusBubbleManager$bubbleInfo$1> continuation) {
        super(2, continuation);
        this.$mid = str;
        this.$abExtra = str2;
        this.$callBack = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UperCenterPlusBubbleManager$bubbleInfo$1(this.$mid, this.$abExtra, this.$callBack, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object checkAb;
        UpperCenterPlusBubbleStrategy strategy;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                checkAb = UperCenterPlusBubbleManager.INSTANCE.checkAb(this.$mid, this.$abExtra, (Continuation) this);
                if (checkAb == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (!((Boolean) checkAb).booleanValue()) {
                    strategy = UperCenterPlusBubbleManager.INSTANCE.strategy();
                    if (strategy != null) {
                        this.label = 2;
                        if (strategy.bubbleInfo(this.$mid, this.$abExtra, this.$callBack, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                LogUtils.INSTANCE.i("UperCenterPlusBubble", "no requestBubble no ab");
                this.$callBack.invoke((Object) null);
                TrackUtils.INSTANCE.trackBubbleRequestInfo(TiredType.AB.getValue(), (r21 & 2) != 0 ? "" : null, (r21 & 4) != 0 ? "" : null, (r21 & 8) != 0 ? "" : null, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? "" : this.$mid, (r21 & 256) != 0 ? "" : null, (r21 & 512) == 0 ? null : "");
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                checkAb = $result;
                if (!((Boolean) checkAb).booleanValue()) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}