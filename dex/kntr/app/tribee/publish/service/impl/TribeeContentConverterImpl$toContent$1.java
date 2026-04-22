package kntr.app.tribee.publish.service.impl;

import com.bapis.bilibili.dynamic.common.KParagraph;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeContentConverterImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.service.impl.TribeeContentConverterImpl", f = "TribeeContentConverterImpl.kt", i = {0, 0, 0, 0}, l = {155}, m = "toContent", n = {"$this$toContent", "pic", "pureIdentifier", "isOrigin"}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 1)
public final class TribeeContentConverterImpl$toContent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeeContentConverterImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeContentConverterImpl$toContent$1(TribeeContentConverterImpl tribeeContentConverterImpl, Continuation<? super TribeeContentConverterImpl$toContent$1> continuation) {
        super(continuation);
        this.this$0 = tribeeContentConverterImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object content;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        content = this.this$0.toContent((KParagraph) null, (Continuation) this);
        return content;
    }
}