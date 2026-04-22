package video.biz.offline.base.infra.download.tasks;

import com.bapis.bilibili.community.service.dm.v1.KDMMoss;
import com.bapis.bilibili.community.service.dm.v1.KDmSegCacheReq;
import com.bapis.bilibili.community.service.dm.v1.KDmSegMobileReply;
import java.util.Map;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DownloadLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PBDanmakuTask.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.download.tasks.PBDanmakuTask$downloadDanmaku$1", f = "PBDanmakuTask.kt", i = {0, 0, 0, 0}, l = {56}, m = "invokeSuspend", n = {"parent", "req", "oid", "pid"}, s = {"L$0", "L$1", "J$0", "J$1"}, v = 1)
public final class PBDanmakuTask$downloadDanmaku$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PBDanmakuTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PBDanmakuTask$downloadDanmaku$1(PBDanmakuTask pBDanmakuTask, Continuation<? super PBDanmakuTask$downloadDanmaku$1> continuation) {
        super(2, continuation);
        this.this$0 = pBDanmakuTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PBDanmakuTask$downloadDanmaku$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Map map;
        Map map2;
        Object dmSegCache;
        String str;
        Long longOrNull;
        String str2;
        Long longOrNull2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Path parent = PathsJvmKt.Path(this.this$0.getFullPath()).getParent();
                    if (parent != null && !FileSystemJvmKt.SystemFileSystem.exists(parent)) {
                        FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, parent, false, 2, (Object) null);
                    }
                    map = this.this$0.extended;
                    long oid = (map == null || (str2 = (String) map.get("oid")) == null || (longOrNull2 = StringsKt.toLongOrNull(str2)) == null) ? 0L : longOrNull2.longValue();
                    map2 = this.this$0.extended;
                    long pid = (map2 == null || (str = (String) map2.get("pid")) == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
                    if (oid != 0 && pid != 0) {
                        KDmSegCacheReq req = new KDmSegCacheReq(1, oid, pid);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(parent);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                        this.J$0 = oid;
                        this.J$1 = pid;
                        this.label = 1;
                        dmSegCache = new KDMMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).dmSegCache(req, (Continuation) this);
                        if (dmSegCache != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    }
                    new DownloadLog(this.this$0.getKey()).error("oid or pid is null");
                    return Unit.INSTANCE;
                case 1:
                    long j = this.J$1;
                    long j2 = this.J$0;
                    KDmSegCacheReq kDmSegCacheReq = (KDmSegCacheReq) this.L$1;
                    Path path = (Path) this.L$0;
                    ResultKt.throwOnFailure($result);
                    dmSegCache = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            KDmSegMobileReply res = (KDmSegMobileReply) dmSegCache;
            this.this$0.updateDanmakuCount(res.getElems().size());
            this.this$0.save2File(res);
            this.this$0.setComplete(true);
            ITaskStateChange delegate = this.this$0.getDelegate();
            if (delegate != null) {
                delegate.onFinish(this.this$0);
            }
        } catch (Exception e) {
            new DownloadLog(this.this$0.getKey()).fail(String.valueOf(this.this$0), e);
            this.this$0.setComplete(true);
            ITaskStateChange delegate2 = this.this$0.getDelegate();
            if (delegate2 != null) {
                delegate2.onFinish(this.this$0);
            }
        }
        return Unit.INSTANCE;
    }
}