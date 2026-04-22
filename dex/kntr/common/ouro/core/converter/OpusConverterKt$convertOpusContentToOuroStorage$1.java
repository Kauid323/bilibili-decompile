package kntr.common.ouro.core.converter;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OpusConverter.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.converter.OpusConverterKt", f = "OpusConverter.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {752}, m = "convertOpusContentToOuroStorage", n = {"opusContent", "linkParseService", "document", "builder", "$this$convertOpusContentToOuroStorage_u24lambda_u240", "listParagraphs", "quoteParagraphs", "shouldCommitParagraphs", "prevCombineHash", "prevParagraphType", "nodes", "emotes", "emoteRawTexts", "$i$a$-with-OpusConverterKt$convertOpusContentToOuroStorage$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0"}, v = 1)
public final class OpusConverterKt$convertOpusContentToOuroStorage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpusConverterKt$convertOpusContentToOuroStorage$1(Continuation<? super OpusConverterKt$convertOpusContentToOuroStorage$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OpusConverterKt.convertOpusContentToOuroStorage(null, null, (Continuation) this);
    }
}