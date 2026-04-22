package kntr.app.upper.entrance.bubble2;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UperCenterPlusBubbleConcreteB.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.bubble2.UperCenterPlusBubbleConcreteB", f = "UperCenterPlusBubbleConcreteB.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {244, 245}, m = "selectBubbleByTired", n = {"mid", "bubbleBean", "resourceList", "selectedText", "resource", "bubble", "textList", "mid", "bubbleBean", "resourceList", "selectedText", "resource", "bubble", "textList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7"}, v = 1)
public final class UperCenterPlusBubbleConcreteB$selectBubbleByTired$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UperCenterPlusBubbleConcreteB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UperCenterPlusBubbleConcreteB$selectBubbleByTired$1(UperCenterPlusBubbleConcreteB uperCenterPlusBubbleConcreteB, Continuation<? super UperCenterPlusBubbleConcreteB$selectBubbleByTired$1> continuation) {
        super(continuation);
        this.this$0 = uperCenterPlusBubbleConcreteB;
    }

    public final Object invokeSuspend(Object obj) {
        Object selectBubbleByTired;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        selectBubbleByTired = this.this$0.selectBubbleByTired(null, null, (Continuation) this);
        return selectBubbleByTired;
    }
}