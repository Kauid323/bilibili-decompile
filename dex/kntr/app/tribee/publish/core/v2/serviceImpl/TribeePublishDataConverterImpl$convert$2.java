package kntr.app.tribee.publish.core.v2.serviceImpl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishDataConverterImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.serviceImpl.TribeePublishDataConverterImpl", f = "TribeePublishDataConverterImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {83}, m = "convert", n = {"opus", "tribeeInfo", "limitInfo", "categories", "selectedCategory", "settingItems", "it", "sendToFollowing", "fromDraft", "fromEdit", "$i$a$-let-TribeePublishDataConverterImpl$convert$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "Z$0", "Z$1", "Z$2", "I$0"}, v = 1)
public final class TribeePublishDataConverterImpl$convert$2 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeePublishDataConverterImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishDataConverterImpl$convert$2(TribeePublishDataConverterImpl tribeePublishDataConverterImpl, Continuation<? super TribeePublishDataConverterImpl$convert$2> continuation) {
        super(continuation);
        this.this$0 = tribeePublishDataConverterImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.convert(null, null, null, false, null, null, null, false, false, (Continuation) this);
    }
}