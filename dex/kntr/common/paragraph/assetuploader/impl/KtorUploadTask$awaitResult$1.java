package kntr.common.paragraph.assetuploader.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MossAssetUploaderImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.assetuploader.impl.KtorUploadTask", f = "MossAssetUploaderImpl.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {154, 287, 288}, m = "awaitResult-IoAF18A", n = {"$this$awaitResult_IoAF18A_u24lambda_u240", "$i$a$-runCatching-KtorUploadTask$awaitResult$2", "$this$awaitResult_IoAF18A_u24lambda_u240", "contentReader", "$this$submitFormWithBinaryData$iv", "url$iv", "formData$iv", "$completion$iv", "$this$submitFormWithBinaryData$iv$iv", "$this$request$iv$iv$iv", "$this$request$iv$iv$iv$iv", "builder$iv$iv$iv$iv", "$i$a$-runCatching-KtorUploadTask$awaitResult$2", "$i$f$submitFormWithBinaryData", "$i$f$submitFormWithBinaryData", "$i$f$request", "$i$f$request", "$this$awaitResult_IoAF18A_u24lambda_u240", "contentReader", "$this$body$iv", "$completion$iv", "result", "$i$a$-runCatching-KtorUploadTask$awaitResult$2", "$i$f$body"}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
public final class KtorUploadTask$awaitResult$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    Object L$0;
    Object L$1;
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
    final /* synthetic */ KtorUploadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtorUploadTask$awaitResult$1(KtorUploadTask ktorUploadTask, Continuation<? super KtorUploadTask$awaitResult$1> continuation) {
        super(continuation);
        this.this$0 = ktorUploadTask;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo2150awaitResultIoAF18A = this.this$0.mo2150awaitResultIoAF18A((Continuation) this);
        return mo2150awaitResultIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo2150awaitResultIoAF18A : Result.m2635boximpl(mo2150awaitResultIoAF18A);
    }
}