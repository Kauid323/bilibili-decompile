package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpandablePanel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$preUpPostDownNestedScrollConnection$1", f = "ExpandablePanel.kt", i = {0, 0}, l = {179}, m = "onPostFling-RZ2iAVY", n = {"$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0"}, s = {"J$0", "J$1"}, v = 1)
public final class ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExpandablePanelKt$preUpPostDownNestedScrollConnection$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1(ExpandablePanelKt$preUpPostDownNestedScrollConnection$1 expandablePanelKt$preUpPostDownNestedScrollConnection$1, Continuation<? super ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = expandablePanelKt$preUpPostDownNestedScrollConnection$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1910onPostFlingRZ2iAVY(0L, 0L, (Continuation) this);
    }
}