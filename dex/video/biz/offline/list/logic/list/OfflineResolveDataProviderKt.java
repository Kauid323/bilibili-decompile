package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"isNotInDB", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineResolveDataProviderKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object isNotInDB(OfflineVideoEntity $this$isNotInDB, Continuation<? super Boolean> continuation) {
        OfflineResolveDataProviderKt$isNotInDB$1 offlineResolveDataProviderKt$isNotInDB$1;
        Object checkIfNotInDB;
        if (continuation instanceof OfflineResolveDataProviderKt$isNotInDB$1) {
            offlineResolveDataProviderKt$isNotInDB$1 = (OfflineResolveDataProviderKt$isNotInDB$1) continuation;
            if ((offlineResolveDataProviderKt$isNotInDB$1.label & Integer.MIN_VALUE) != 0) {
                offlineResolveDataProviderKt$isNotInDB$1.label -= Integer.MIN_VALUE;
                Object $result = offlineResolveDataProviderKt$isNotInDB$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineResolveDataProviderKt$isNotInDB$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                        offlineResolveDataProviderKt$isNotInDB$1.L$0 = $this$isNotInDB;
                        offlineResolveDataProviderKt$isNotInDB$1.label = 1;
                        checkIfNotInDB = offlineFacadeImpl.checkIfNotInDB($this$isNotInDB, offlineResolveDataProviderKt$isNotInDB$1);
                        if (checkIfNotInDB == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        $this$isNotInDB = (OfflineVideoEntity) offlineResolveDataProviderKt$isNotInDB$1.L$0;
                        ResultKt.throwOnFailure($result);
                        checkIfNotInDB = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean notInDB = ((Boolean) checkIfNotInDB).booleanValue();
                LogKt.getVBLog().debug("Video entity " + $this$isNotInDB.getVideoId() + " is not in DB: " + notInDB);
                return Boxing.boxBoolean(notInDB);
            }
        }
        offlineResolveDataProviderKt$isNotInDB$1 = new OfflineResolveDataProviderKt$isNotInDB$1(continuation);
        Object $result2 = offlineResolveDataProviderKt$isNotInDB$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineResolveDataProviderKt$isNotInDB$1.label) {
        }
        boolean notInDB2 = ((Boolean) checkIfNotInDB).booleanValue();
        LogKt.getVBLog().debug("Video entity " + $this$isNotInDB.getVideoId() + " is not in DB: " + notInDB2);
        return Boxing.boxBoolean(notInDB2);
    }
}