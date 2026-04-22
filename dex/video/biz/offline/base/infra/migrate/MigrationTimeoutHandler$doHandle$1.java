package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MigrationTimeoutHandler.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.migrate.MigrationTimeoutHandler", f = "MigrationTimeoutHandler.kt", i = {0, 0, 0}, l = {24}, m = "doHandle", n = {"chain", "cachedVideos", "timeout"}, s = {"L$0", "L$1", "J$0"}, v = 1)
public final class MigrationTimeoutHandler$doHandle$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MigrationTimeoutHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationTimeoutHandler$doHandle$1(MigrationTimeoutHandler migrationTimeoutHandler, Continuation<? super MigrationTimeoutHandler$doHandle$1> continuation) {
        super(continuation);
        this.this$0 = migrationTimeoutHandler;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doHandle(null, (Continuation) this);
    }
}