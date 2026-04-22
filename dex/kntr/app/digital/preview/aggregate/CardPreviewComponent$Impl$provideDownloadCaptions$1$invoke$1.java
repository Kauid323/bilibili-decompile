package kntr.app.digital.preview.aggregate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CardPreviewComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.aggregate.CardPreviewComponent$Impl$provideDownloadCaptions$1", f = "CardPreviewComponent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {216, 217}, m = "invoke", n = {"url", "$this$get_u24default$iv", "urlString$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "url", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "I$0"}, v = 1)
public final class CardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1 extends ContinuationImpl {
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
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardPreviewComponent$Impl$provideDownloadCaptions$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1(CardPreviewComponent$Impl$provideDownloadCaptions$1 cardPreviewComponent$Impl$provideDownloadCaptions$1, Continuation<? super CardPreviewComponent$Impl$provideDownloadCaptions$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = cardPreviewComponent$Impl$provideDownloadCaptions$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, (Continuation) this);
    }
}