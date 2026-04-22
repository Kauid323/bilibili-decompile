package kntr.app.upper.entrance.bubble;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UperCenterPlusBubbleManager.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.bubble.UperCenterPlusBubbleManager", f = "UperCenterPlusBubbleManager.kt", i = {0, 0}, l = {57}, m = "checkAb", n = {"mid", "abExtra"}, s = {"L$0", "L$1"}, v = 1)
public final class UperCenterPlusBubbleManager$checkAb$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UperCenterPlusBubbleManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UperCenterPlusBubbleManager$checkAb$1(UperCenterPlusBubbleManager uperCenterPlusBubbleManager, Continuation<? super UperCenterPlusBubbleManager$checkAb$1> continuation) {
        super(continuation);
        this.this$0 = uperCenterPlusBubbleManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object checkAb;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkAb = this.this$0.checkAb(null, null, (Continuation) this);
        return checkAb;
    }
}