package kntr.app.digital.backpack.aggregate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackpackPageComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.backpack.aggregate.BackpackPageComponent$Impl$provideGetBackpackAssetBag$1", f = "BackpackPageComponent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {134, 135}, m = "invoke", n = {"$this$get$iv", "urlString$iv", "$completion$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "lotteryId", "$i$f$handleApiException", "$i$a$-handleApiException-BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$1", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "$this$body$iv", "$completion$iv", "lotteryId", "$i$f$handleApiException", "$i$a$-handleApiException-BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$1", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "J$0", "I$0", "I$1", "I$2"}, v = 1)
public final class BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackpackPageComponent$Impl$provideGetBackpackAssetBag$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1(BackpackPageComponent$Impl$provideGetBackpackAssetBag$1 backpackPageComponent$Impl$provideGetBackpackAssetBag$1, Continuation<? super BackpackPageComponent$Impl$provideGetBackpackAssetBag$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = backpackPageComponent$Impl$provideGetBackpackAssetBag$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(0L, (Continuation) this);
    }
}