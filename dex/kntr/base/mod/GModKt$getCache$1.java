package kntr.base.mod;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GMod.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/base/mod/ModBundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.GModKt$getCache$1", f = "GMod.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class GModKt$getCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ModBundle>, Object> {
    final /* synthetic */ String $mod;
    final /* synthetic */ String $pool;
    final /* synthetic */ GMod $this_getCache;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GModKt$getCache$1(GMod gMod, String str, String str2, Continuation<? super GModKt$getCache$1> continuation) {
        super(2, continuation);
        this.$this_getCache = gMod;
        this.$pool = str;
        this.$mod = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GModKt$getCache$1(this.$this_getCache, this.$pool, this.$mod, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ModBundle> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object obj = this.$this_getCache.get(this.$pool, this.$mod, ModRequirementPolicy.None, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}