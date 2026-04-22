package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealMigrationChain.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.migrate.RealMigrationChain", f = "RealMigrationChain.kt", i = {0}, l = {15}, m = "proceed", n = {"next"}, s = {"L$0"}, v = 1)
public final class RealMigrationChain$proceed$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealMigrationChain this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealMigrationChain$proceed$1(RealMigrationChain realMigrationChain, Continuation<? super RealMigrationChain$proceed$1> continuation) {
        super(continuation);
        this.this$0 = realMigrationChain;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.proceed((Continuation) this);
    }
}