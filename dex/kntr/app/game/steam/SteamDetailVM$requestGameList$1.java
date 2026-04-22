package kntr.app.game.steam;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SteamDetailVM.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.SteamDetailVM", f = "SteamDetailVM.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {326, 327}, m = "requestGameList", n = {"url", "$this$postFormUrlEncode$iv", "url$iv", "params$iv", "$this$post$iv$iv", "url$iv$iv", "$this$post$iv$iv$iv", "$this$post$iv$iv$iv$iv", "builder$iv$iv$iv$iv", "$this$request$iv$iv$iv$iv$iv", "page", "$i$f$postFormUrlEncode", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request", "url", "httpResponse", "$this$body$iv", "page", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
public final class SteamDetailVM$requestGameList$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
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
    final /* synthetic */ SteamDetailVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamDetailVM$requestGameList$1(SteamDetailVM steamDetailVM, Continuation<? super SteamDetailVM$requestGameList$1> continuation) {
        super(continuation);
        this.this$0 = steamDetailVM;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestGameList(0, (Continuation) this);
    }
}