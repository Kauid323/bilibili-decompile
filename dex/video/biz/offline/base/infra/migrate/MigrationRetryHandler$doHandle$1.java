package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MigrationRetryHandler.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.migrate.MigrationRetryHandler", f = "MigrationRetryHandler.kt", i = {0, 0, 0}, l = {19}, m = "doHandle", n = {"chain", "currentAttempt", "maxAttempts"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class MigrationRetryHandler$doHandle$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MigrationRetryHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationRetryHandler$doHandle$1(MigrationRetryHandler migrationRetryHandler, Continuation<? super MigrationRetryHandler$doHandle$1> continuation) {
        super(continuation);
        this.this$0 = migrationRetryHandler;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doHandle(null, (Continuation) this);
    }
}