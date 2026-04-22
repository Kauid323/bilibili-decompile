package video.biz.offline.base.infra.utils;

import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineScope.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\"!\u0010\u0000\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\b\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u0005\"\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"downloadScope", "Lkotlinx/coroutines/CoroutineScope;", "getDownloadScope$annotations", "()V", "getDownloadScope", "()Lkotlinx/coroutines/CoroutineScope;", "downloadScope$delegate", "Lkotlin/Lazy;", "storageScope", "getStorageScope$annotations", "getStorageScope", "storageScope$delegate", "storageDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getStorageDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "storageDispatcher$delegate", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineScopeKt {
    private static final Lazy downloadScope$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.OfflineScopeKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            CoroutineScope downloadScope_delegate$lambda$0;
            downloadScope_delegate$lambda$0 = OfflineScopeKt.downloadScope_delegate$lambda$0();
            return downloadScope_delegate$lambda$0;
        }
    });
    private static final Lazy storageScope$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.OfflineScopeKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            CoroutineScope storageScope_delegate$lambda$0;
            storageScope_delegate$lambda$0 = OfflineScopeKt.storageScope_delegate$lambda$0();
            return storageScope_delegate$lambda$0;
        }
    });
    private static final Lazy storageDispatcher$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.OfflineScopeKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            CoroutineDispatcher storageDispatcher_delegate$lambda$0;
            storageDispatcher_delegate$lambda$0 = OfflineScopeKt.storageDispatcher_delegate$lambda$0();
            return storageDispatcher_delegate$lambda$0;
        }
    });

    public static /* synthetic */ void getDownloadScope$annotations() {
    }

    public static /* synthetic */ void getStorageScope$annotations() {
    }

    public static final CoroutineScope getDownloadScope() {
        return (CoroutineScope) downloadScope$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope downloadScope_delegate$lambda$0() {
        return CoroutineScopeKt.CoroutineScope(CoroutineExJvmKt.getIoContext().limitedParallelism(Config.Companion.getDownloadScopeParallelismLimit()).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus((CoroutineExceptionHandler) new OfflineScopeKt$downloadScope_delegate$lambda$0$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
    }

    public static final CoroutineScope getStorageScope() {
        return (CoroutineScope) storageScope$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope storageScope_delegate$lambda$0() {
        return CoroutineScopeKt.CoroutineScope(getStorageDispatcher().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus((CoroutineExceptionHandler) new OfflineScopeKt$storageScope_delegate$lambda$0$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
    }

    public static final CoroutineDispatcher getStorageDispatcher() {
        return (CoroutineDispatcher) storageDispatcher$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineDispatcher storageDispatcher_delegate$lambda$0() {
        return CoroutineExJvmKt.getIoContext().limitedParallelism(Config.Companion.getStorageScopeParallelismLimit());
    }
}