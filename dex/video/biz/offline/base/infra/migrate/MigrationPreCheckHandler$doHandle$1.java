package video.biz.offline.base.infra.migrate;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MigrationPreCheckHandler.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.migrate.MigrationPreCheckHandler", f = "MigrationPreCheckHandler.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {DynModuleType.module_topic_brief_VALUE, 44, 54}, m = "doHandle", n = {"chain", "context", "db", "videoDao", "chain", "context", "db", "videoDao", "dbVideoRecords", "chain", "context", "db", "videoDao", "dbVideoRecords"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class MigrationPreCheckHandler$doHandle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MigrationPreCheckHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationPreCheckHandler$doHandle$1(MigrationPreCheckHandler migrationPreCheckHandler, Continuation<? super MigrationPreCheckHandler$doHandle$1> continuation) {
        super(continuation);
        this.this$0 = migrationPreCheckHandler;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doHandle(null, (Continuation) this);
    }
}