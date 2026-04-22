package video.biz.offline.base.infra.storage.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DBDataStorage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.db.DBDataStorage", f = "DBDataStorage.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {50}, m = "getVideosByGroupId", n = {ChronosDanmakuSender.KEY_MARK_DANMAKU, "this_$iv", "logTag$iv", "$this$safeCall_u24lambda_u240$iv", "groupId", "$i$f$safeCall", "$i$a$-runCatching-DBDataStorage$safeCall$1$iv", "$i$a$-safeCall-DBDataStorage$getVideosByGroupId$2"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "I$1", "I$2"}, v = 1)
public final class DBDataStorage$getVideosByGroupId$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DBDataStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBDataStorage$getVideosByGroupId$1(DBDataStorage dBDataStorage, Continuation<? super DBDataStorage$getVideosByGroupId$1> continuation) {
        super(continuation);
        this.this$0 = dBDataStorage;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getVideosByGroupId(0L, null, (Continuation) this);
    }
}