package kntr.common.ouro.common.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LinkParseServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.service.LinkParseServiceImpl", f = "LinkParseServiceImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {29}, m = "parse-gIAlu-s", n = {"urlList", "uniqueUrls", "allResults", "$this$forEach$iv", "element$iv", "batch", "req", "$completion$iv", "$i$f$forEach", "$i$a$-forEach-LinkParseServiceImpl$parse$2", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-LinkParseServiceImpl$parse$2$result$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3"}, v = 1)
public final class LinkParseServiceImpl$parse$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LinkParseServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkParseServiceImpl$parse$1(LinkParseServiceImpl linkParseServiceImpl, Continuation<? super LinkParseServiceImpl$parse$1> continuation) {
        super(continuation);
        this.this$0 = linkParseServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1885parsegIAlus = this.this$0.mo1885parsegIAlus(null, (Continuation) this);
        return mo1885parsegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1885parsegIAlus : Result.m2635boximpl(mo1885parsegIAlus);
    }
}