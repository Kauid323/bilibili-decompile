package kntr.app.game.steam;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SteamDetailVM.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.SteamDetailVM", f = "SteamDetailVM.kt", i = {}, l = {140}, m = "refreshInfo", n = {}, s = {}, v = 1)
public final class SteamDetailVM$refreshInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SteamDetailVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SteamDetailVM$refreshInfo$1(SteamDetailVM steamDetailVM, Continuation<? super SteamDetailVM$refreshInfo$1> continuation) {
        super(continuation);
        this.this$0 = steamDetailVM;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshInfo((Continuation) this);
    }
}