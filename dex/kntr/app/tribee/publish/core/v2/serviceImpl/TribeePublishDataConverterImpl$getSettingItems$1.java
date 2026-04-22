package kntr.app.tribee.publish.core.v2.serviceImpl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishDataConverterImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.serviceImpl.TribeePublishDataConverterImpl", f = "TribeePublishDataConverterImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {105, 109}, m = "getSettingItems", n = {"permission", "attachments", "map", "$this$forEach$iv", "element$iv", "item", "$i$f$forEach", "$i$a$-forEach-TribeePublishDataConverterImpl$getSettingItems$2", "$i$a$-ifBlank-TribeePublishDataConverterImpl$getSettingItems$2$value$1", "permission", "attachments", "map", "$this$forEach$iv", "element$iv", "item", "$i$f$forEach", "$i$a$-forEach-TribeePublishDataConverterImpl$getSettingItems$2", "$i$a$-ifBlank-TribeePublishDataConverterImpl$getSettingItems$2$value$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
public final class TribeePublishDataConverterImpl$getSettingItems$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
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
    final /* synthetic */ TribeePublishDataConverterImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishDataConverterImpl$getSettingItems$1(TribeePublishDataConverterImpl tribeePublishDataConverterImpl, Continuation<? super TribeePublishDataConverterImpl$getSettingItems$1> continuation) {
        super(continuation);
        this.this$0 = tribeePublishDataConverterImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSettingItems(null, null, (Continuation) this);
    }
}