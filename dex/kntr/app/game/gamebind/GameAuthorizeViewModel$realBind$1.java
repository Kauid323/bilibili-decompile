package kntr.app.game.gamebind;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameAuthorizeViewModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.GameAuthorizeViewModel", f = "GameAuthorizeViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {398, 399}, m = "realBind", n = {"url", "$this$postFormUrlEncode$iv", "url$iv", "params$iv", "$this$post$iv$iv", "url$iv$iv", "$this$post$iv$iv$iv", "$this$post$iv$iv$iv$iv", "builder$iv$iv$iv$iv", "$this$request$iv$iv$iv$iv$iv", "$i$f$postFormUrlEncode", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request", "url", "httpResponse", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class GameAuthorizeViewModel$realBind$1 extends ContinuationImpl {
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
    final /* synthetic */ GameAuthorizeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameAuthorizeViewModel$realBind$1(GameAuthorizeViewModel gameAuthorizeViewModel, Continuation<? super GameAuthorizeViewModel$realBind$1> continuation) {
        super(continuation);
        this.this$0 = gameAuthorizeViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object realBind;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        realBind = this.this$0.realBind((Continuation) this);
        return realBind;
    }
}