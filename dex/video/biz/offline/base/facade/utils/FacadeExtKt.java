package video.biz.offline.base.facade.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.account.model.UserInfo;
import kntr.base.account.model.Vip;
import kntr.base.reachability.KReachabilityKt;
import kntr.base.reachability.NetWorkState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;
import video.base.log.LogKt;
import video.biz.offline.base.facade.IOfflineFacade;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.infra.download.PauseType;
import video.biz.offline.base.infra.storage.diskfile.DiskFileImpl_androidKt;
import video.biz.offline.base.infra.storage.diskfile.FileType;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.model.ResolveParam;

/* compiled from: FacadeExt.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0001H\u0087@¢\u0006\u0002\u0010\u0004\u001a<\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0000¨\u0006\u000b"}, d2 = {"updateStoragePath", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "autoResumeOrPause", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDownloadAndUpdateItems", "Lkotlin/Pair;", "", "params", "Lvideo/biz/offline/base/model/model/ResolveParam;", "completes", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FacadeExtKt {

    /* compiled from: FacadeExt.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetWorkState.values().length];
            try {
                iArr[NetWorkState.NotReachable.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NetWorkState.ViaWiFi.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void updateStoragePath(OfflineVideoEntity $this$updateStoragePath) {
        Intrinsics.checkNotNullParameter($this$updateStoragePath, "<this>");
        $this$updateStoragePath.setStoragePath(DiskFileImpl_androidKt.filePath($this$updateStoragePath, FileType.RootDir.INSTANCE));
        IVBLog vBLog = LogKt.getVBLog();
        String key = $this$updateStoragePath.getKey();
        vBLog.info(key + " set storagePath: " + $this$updateStoragePath.getStoragePath());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object autoResumeOrPause(Continuation<? super Unit> continuation) {
        FacadeExtKt$autoResumeOrPause$1 facadeExtKt$autoResumeOrPause$1;
        AccountState.Logged state;
        UserInfo userInfo;
        Vip vip;
        NetWorkState netWorkState;
        if (continuation instanceof FacadeExtKt$autoResumeOrPause$1) {
            facadeExtKt$autoResumeOrPause$1 = (FacadeExtKt$autoResumeOrPause$1) continuation;
            if ((facadeExtKt$autoResumeOrPause$1.label & Integer.MIN_VALUE) != 0) {
                facadeExtKt$autoResumeOrPause$1.label -= Integer.MIN_VALUE;
                Object $result = facadeExtKt$autoResumeOrPause$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (facadeExtKt$autoResumeOrPause$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        state = (AccountState) KAccountStoreKt.getAccountHolder().getState().getValue();
                        if (state instanceof AccountState.Idle) {
                            LogKt.getVBLog().info("OfflineFacade account state is idle, pause all and set max concurrent 1");
                            IOfflineFacade offlineFacadeImpl = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            PauseType pauseType = PauseType.PAUSE_LOGOUT;
                            facadeExtKt$autoResumeOrPause$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            facadeExtKt$autoResumeOrPause$1.label = 1;
                            if (offlineFacadeImpl.pauseAll(pauseType, facadeExtKt$autoResumeOrPause$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            IOfflineFacade offlineFacadeImpl2 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            facadeExtKt$autoResumeOrPause$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            facadeExtKt$autoResumeOrPause$1.label = 2;
                            return offlineFacadeImpl2.setMaxConcurrent(1, facadeExtKt$autoResumeOrPause$1) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        AccountState.Logged logged = state instanceof AccountState.Logged ? state : null;
                        boolean z = false;
                        if (logged != null && (userInfo = logged.getUserInfo()) != null && (vip = userInfo.getVip()) != null && vip.getStatus() == 1) {
                            z = true;
                        }
                        if (!z) {
                            LogKt.getVBLog().info("OfflineFacade account not vip, set max concurrent 1");
                            IOfflineFacade offlineFacadeImpl3 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                            facadeExtKt$autoResumeOrPause$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            facadeExtKt$autoResumeOrPause$1.label = 3;
                            if (offlineFacadeImpl3.setMaxConcurrent(1, facadeExtKt$autoResumeOrPause$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        netWorkState = KReachabilityKt.getKReachability().getCurrentState();
                        LogKt.getVBLog().info("Network state: " + netWorkState + ", autoResumption: " + Config.Companion.getAutoResumption());
                        switch (WhenMappings.$EnumSwitchMapping$0[netWorkState.ordinal()]) {
                            case 1:
                                IOfflineFacade offlineFacadeImpl4 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                PauseType pauseType2 = PauseType.PAUSE_NETWORK_ERROR;
                                facadeExtKt$autoResumeOrPause$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                                facadeExtKt$autoResumeOrPause$1.L$1 = SpillingKt.nullOutSpilledVariable(netWorkState);
                                facadeExtKt$autoResumeOrPause$1.label = 4;
                                if (offlineFacadeImpl4.pauseAll(pauseType2, facadeExtKt$autoResumeOrPause$1) != coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            case 2:
                                if (!Config.Companion.getAutoResumption()) {
                                    IOfflineFacade offlineFacadeImpl5 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                    PauseType pauseType3 = PauseType.PAUSE_TAP_ALL;
                                    facadeExtKt$autoResumeOrPause$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                                    facadeExtKt$autoResumeOrPause$1.L$1 = SpillingKt.nullOutSpilledVariable(netWorkState);
                                    facadeExtKt$autoResumeOrPause$1.label = 6;
                                    if (offlineFacadeImpl5.pauseAll(pauseType3, facadeExtKt$autoResumeOrPause$1) != coroutine_suspended) {
                                        LogKt.getVBLog().info("OfflineFacade autoResumption is false");
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    IOfflineFacade offlineFacadeImpl6 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                    facadeExtKt$autoResumeOrPause$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                                    facadeExtKt$autoResumeOrPause$1.L$1 = SpillingKt.nullOutSpilledVariable(netWorkState);
                                    facadeExtKt$autoResumeOrPause$1.label = 5;
                                    if (offlineFacadeImpl6.startAll(facadeExtKt$autoResumeOrPause$1) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                }
                            default:
                                IOfflineFacade offlineFacadeImpl7 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                                PauseType pauseType4 = PauseType.PAUSE_NOT_WIFI;
                                facadeExtKt$autoResumeOrPause$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                                facadeExtKt$autoResumeOrPause$1.L$1 = SpillingKt.nullOutSpilledVariable(netWorkState);
                                facadeExtKt$autoResumeOrPause$1.label = 7;
                                if (offlineFacadeImpl7.pauseAll(pauseType4, facadeExtKt$autoResumeOrPause$1) != coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        state = (AccountState) facadeExtKt$autoResumeOrPause$1.L$0;
                        ResultKt.throwOnFailure($result);
                        IOfflineFacade offlineFacadeImpl22 = OfflineFacadeImpl_androidKt.getOfflineFacadeImpl();
                        facadeExtKt$autoResumeOrPause$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                        facadeExtKt$autoResumeOrPause$1.label = 2;
                        if (offlineFacadeImpl22.setMaxConcurrent(1, facadeExtKt$autoResumeOrPause$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        AccountState accountState = (AccountState) facadeExtKt$autoResumeOrPause$1.L$0;
                        ResultKt.throwOnFailure($result);
                    case 3:
                        state = (AccountState) facadeExtKt$autoResumeOrPause$1.L$0;
                        ResultKt.throwOnFailure($result);
                        netWorkState = KReachabilityKt.getKReachability().getCurrentState();
                        LogKt.getVBLog().info("Network state: " + netWorkState + ", autoResumption: " + Config.Companion.getAutoResumption());
                        switch (WhenMappings.$EnumSwitchMapping$0[netWorkState.ordinal()]) {
                        }
                        return Unit.INSTANCE;
                    case 4:
                    case 5:
                    case 7:
                        NetWorkState netWorkState2 = (NetWorkState) facadeExtKt$autoResumeOrPause$1.L$1;
                        AccountState accountState2 = (AccountState) facadeExtKt$autoResumeOrPause$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 6:
                        NetWorkState netWorkState3 = (NetWorkState) facadeExtKt$autoResumeOrPause$1.L$1;
                        AccountState accountState3 = (AccountState) facadeExtKt$autoResumeOrPause$1.L$0;
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("OfflineFacade autoResumption is false");
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        facadeExtKt$autoResumeOrPause$1 = new FacadeExtKt$autoResumeOrPause$1(continuation);
        Object $result2 = facadeExtKt$autoResumeOrPause$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (facadeExtKt$autoResumeOrPause$1.label) {
        }
    }

    public static final Pair<List<OfflineVideoEntity>, List<OfflineVideoEntity>> resolveDownloadAndUpdateItems(List<ResolveParam> list, List<OfflineVideoEntity> list2) {
        Intrinsics.checkNotNullParameter(list, "params");
        Intrinsics.checkNotNullParameter(list2, "completes");
        List<OfflineVideoEntity> $this$associateBy$iv = list2;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
            destination$iv$iv.put(it.getKey(), element$iv$iv);
        }
        List needDownloads = new ArrayList();
        List needUpdateItems = new ArrayList();
        List<ResolveParam> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            ResolveParam param = (ResolveParam) element$iv;
            OfflineVideoEntity video2 = param.resolveVideoEntity();
            OfflineVideoEntity existingComplete = (OfflineVideoEntity) destination$iv$iv.get(video2.getKey());
            if (existingComplete != null) {
                if (existingComplete.getGroupId() != video2.getGroupId()) {
                    existingComplete.setGroupId(video2.getGroupId());
                    existingComplete.setGroupTitle(video2.getGroupTitle());
                    needUpdateItems.add(existingComplete);
                }
            } else {
                updateStoragePath(video2);
                needDownloads.add(video2);
            }
        }
        return TuplesKt.to(needDownloads, needUpdateItems);
    }
}