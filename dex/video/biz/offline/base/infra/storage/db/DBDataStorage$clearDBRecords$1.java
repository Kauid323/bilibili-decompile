package video.biz.offline.base.infra.storage.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DBDataStorage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.db.DBDataStorage", f = "DBDataStorage.kt", i = {0, 0, 0, 0, 0, 0}, l = {139}, m = "clearDBRecords$infra_debug", n = {"this_$iv", "logTag$iv", "$this$safeCallUnit_u24lambda_u240$iv", "$i$f$safeCallUnit", "$i$a$-runCatching-DBDataStorage$safeCallUnit$1$iv", "$i$a$-safeCallUnit-DBDataStorage$clearDBRecords$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 1)
public final class DBDataStorage$clearDBRecords$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DBDataStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBDataStorage$clearDBRecords$1(DBDataStorage dBDataStorage, Continuation<? super DBDataStorage$clearDBRecords$1> continuation) {
        super(continuation);
        this.this$0 = dBDataStorage;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearDBRecords$infra_debug((Continuation) this);
    }
}