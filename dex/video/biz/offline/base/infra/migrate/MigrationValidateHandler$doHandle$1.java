package video.biz.offline.base.infra.migrate;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MigrationValidateHandler.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.migrate.MigrationValidateHandler", f = "MigrationValidateHandler.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {22, DynModuleType.module_onetime_notice_VALUE, 47}, m = "doHandle", n = {"chain", "db", "videoDao", "cachedVideos", "chain", "db", "videoDao", "cachedVideos", "dbVideos", "result", "chain", "db", "videoDao", "cachedVideos", "dbVideos", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 1)
public final class MigrationValidateHandler$doHandle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MigrationValidateHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationValidateHandler$doHandle$1(MigrationValidateHandler migrationValidateHandler, Continuation<? super MigrationValidateHandler$doHandle$1> continuation) {
        super(continuation);
        this.this$0 = migrationValidateHandler;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doHandle(null, (Continuation) this);
    }
}