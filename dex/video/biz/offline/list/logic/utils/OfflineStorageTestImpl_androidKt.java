package video.biz.offline.list.logic.utils;

import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineStorageTestImpl.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"testWriteExternalSD", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testReadExternalSD", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineStorageTestImpl_androidKt {
    public static final Object testWriteExternalSD(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new OfflineStorageTestImpl_androidKt$testWriteExternalSD$2(null), continuation);
    }

    public static final Object testReadExternalSD(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new OfflineStorageTestImpl_androidKt$testReadExternalSD$2(null), continuation);
    }
}