package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MigrationTimeoutHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.migrate.MigrationTimeoutHandler$doHandle$result$1", f = "MigrationTimeoutHandler.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MigrationTimeoutHandler$doHandle$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MigrationResult>, Object> {
    final /* synthetic */ MigrationChain $chain;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationTimeoutHandler$doHandle$result$1(MigrationChain migrationChain, Continuation<? super MigrationTimeoutHandler$doHandle$result$1> continuation) {
        super(2, continuation);
        this.$chain = migrationChain;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MigrationTimeoutHandler$doHandle$result$1(this.$chain, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MigrationResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object proceed = this.$chain.proceed((Continuation) this);
                if (proceed == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return proceed;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}