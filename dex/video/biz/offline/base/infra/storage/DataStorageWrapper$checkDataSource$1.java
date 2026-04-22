package video.biz.offline.base.infra.storage;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStorageWrapper.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.DataStorageWrapper", f = "DataStorageWrapper.kt", i = {}, l = {148}, m = "checkDataSource", n = {}, s = {}, v = 1)
public final class DataStorageWrapper$checkDataSource$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStorageWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStorageWrapper$checkDataSource$1(DataStorageWrapper dataStorageWrapper, Continuation<? super DataStorageWrapper$checkDataSource$1> continuation) {
        super(continuation);
        this.this$0 = dataStorageWrapper;
    }

    public final Object invokeSuspend(Object obj) {
        Object checkDataSource;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        checkDataSource = this.this$0.checkDataSource((Continuation) this);
        return checkDataSource;
    }
}