package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DownloadErrorType;
import video.biz.offline.list.logic.SupportedOptions_androidKt;
import video.biz.offline.list.logic.statemachine.DiagnosticState;
import video.biz.offline.list.logic.utils.OfflineLogicKt;

/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lvideo/biz/offline/list/logic/list/ResolveTipProvider;", "Lvideo/biz/offline/list/logic/list/IResolveProvider;", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)V", "getVideoEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "getDamagedTip", "state", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged;", "(Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncompleteTip", "reason", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResolveTipProvider implements IResolveProvider {
    public static final int $stable = OfflineVideoEntity.$stable;
    private final OfflineVideoEntity videoEntity;

    /* compiled from: OfflineResolveDataProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadErrorType.values().length];
            try {
                iArr[DownloadErrorType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DownloadErrorType.ADDRESS_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DownloadErrorType.PLAYVIEW_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DownloadErrorType.STORAGE_SPACE_FULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DownloadErrorType.NOT_VIP_DOWNLOAD_VIP_VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DownloadErrorType.TOO_LARGE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DownloadErrorType.NOT_WIFI.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[DownloadErrorType.NETWORK_DISCONNECT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[DownloadErrorType.LOGOUT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ResolveTipProvider(OfflineVideoEntity videoEntity) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        this.videoEntity = videoEntity;
    }

    public final OfflineVideoEntity getVideoEntity() {
        return this.videoEntity;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[ORIG_RETURN, RETURN] */
    @Override // video.biz.offline.list.logic.list.IResolveProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object title(Continuation<? super String> continuation) {
        ResolveTipProvider$title$1 resolveTipProvider$title$1;
        Object from;
        DiagnosticState state;
        if (continuation instanceof ResolveTipProvider$title$1) {
            resolveTipProvider$title$1 = (ResolveTipProvider$title$1) continuation;
            if ((resolveTipProvider$title$1.label & Integer.MIN_VALUE) != 0) {
                resolveTipProvider$title$1.label -= Integer.MIN_VALUE;
                Object $result = resolveTipProvider$title$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveTipProvider$title$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiagnosticState.Companion companion = DiagnosticState.Companion;
                        OfflineVideoEntity offlineVideoEntity = this.videoEntity;
                        resolveTipProvider$title$1.label = 1;
                        from = companion.from(offlineVideoEntity, resolveTipProvider$title$1);
                        if (from == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        from = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                state = (DiagnosticState) from;
                if (!(state instanceof DiagnosticState.Completed)) {
                    return "建议:";
                }
                return "原因及建议:";
            }
        }
        resolveTipProvider$title$1 = new ResolveTipProvider$title$1(this, continuation);
        Object $result2 = resolveTipProvider$title$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveTipProvider$title$1.label) {
        }
        state = (DiagnosticState) from;
        if (!(state instanceof DiagnosticState.Completed)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    @Override // video.biz.offline.list.logic.list.IResolveProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object content(Continuation<? super String> continuation) {
        ResolveTipProvider$content$1 resolveTipProvider$content$1;
        Object from;
        DiagnosticState state;
        if (continuation instanceof ResolveTipProvider$content$1) {
            resolveTipProvider$content$1 = (ResolveTipProvider$content$1) continuation;
            if ((resolveTipProvider$content$1.label & Integer.MIN_VALUE) != 0) {
                resolveTipProvider$content$1.label -= Integer.MIN_VALUE;
                Object $result = resolveTipProvider$content$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveTipProvider$content$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiagnosticState.Companion companion = DiagnosticState.Companion;
                        OfflineVideoEntity offlineVideoEntity = this.videoEntity;
                        resolveTipProvider$content$1.label = 1;
                        from = companion.from(offlineVideoEntity, resolveTipProvider$content$1);
                        if (from == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        from = $result;
                        break;
                    case 2:
                        DiagnosticState diagnosticState = (DiagnosticState) resolveTipProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                state = (DiagnosticState) from;
                if (!(state instanceof DiagnosticState.Completed)) {
                    return "若进入视频或番剧详情页无法播放，可能是因为网络原因，建议在离线页点击视频直接播放";
                }
                if (state instanceof DiagnosticState.Damaged) {
                    resolveTipProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                    resolveTipProvider$content$1.label = 2;
                    Object damagedTip = getDamagedTip((DiagnosticState.Damaged) state, resolveTipProvider$content$1);
                    if (damagedTip == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return damagedTip;
                } else if (state instanceof DiagnosticState.Incomplete) {
                    return getIncompleteTip(((DiagnosticState.Incomplete) state).getReason());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        resolveTipProvider$content$1 = new ResolveTipProvider$content$1(this, continuation);
        Object $result2 = resolveTipProvider$content$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveTipProvider$content$1.label) {
        }
        state = (DiagnosticState) from;
        if (!(state instanceof DiagnosticState.Completed)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getDamagedTip(DiagnosticState.Damaged state, Continuation<? super String> continuation) {
        DiagnosticState.Damaged.Reason reason = state.getReason();
        if (reason instanceof DiagnosticState.Damaged.Reason.WithUnretryableDownloadingError) {
            switch (WhenMappings.$EnumSwitchMapping$0[((DiagnosticState.Damaged.Reason.WithUnretryableDownloadingError) state.getReason()).getErrorType().ordinal()]) {
                case 1:
                    return "原因：未知网络错误\n建议：手动删除缓存任务后重新缓存稿件";
                case 2:
                case 3:
                    return "原因：相关网络资源解析失败\n建议：手动删除缓存任务后重新缓存稿件";
                case 4:
                    return "原因：设备存储空间剩余不足\n建议：清理设备存储空间，手动删除缓存任务后重新缓存稿件";
                case 5:
                    return "原因：您没有缓存该稿件的权限\n建议：尝试更换大会员账号或为该稿件充电的账号";
                case 6:
                    return "原因：缓存稿件过大\n建议：手动删除缓存任务后重新缓存清晰度更低的稿件";
                default:
                    return "原因：未知错误\n建议：删除缓存任务后重试";
            }
        } else if (reason instanceof DiagnosticState.Damaged.Reason.DownloadedButInvalid) {
            return OfflineLogicKt.getLocalResourceInvalidTip(state.getEntity(), continuation);
        } else {
            if (!(reason instanceof DiagnosticState.Damaged.Reason.DownloadingButInvalid)) {
                throw new NoWhenBranchMatchedException();
            }
            return OfflineLogicKt.getLocalResourceInvalidTip(state.getEntity(), continuation);
        }
    }

    private final String getIncompleteTip(DiagnosticState.Incomplete.Reason reason) {
        if (reason instanceof DiagnosticState.Incomplete.Reason.Paused) {
            return !SupportedOptions_androidKt.isNetworkConnect() ? "请先检查您的网络连接" : "尝试重试或继续缓存任务";
        } else if (!(reason instanceof DiagnosticState.Incomplete.Reason.WithRetryableError)) {
            throw new NoWhenBranchMatchedException();
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[((DiagnosticState.Incomplete.Reason.WithRetryableError) reason).getErrorType().ordinal()]) {
                case 7:
                    return "原因：Wifi 缓存任务中切换至非 Wifi 网络，任务中断\n建议：尝试连接Wifi或允许使用流量进行缓存后重试缓存任务";
                case 8:
                    return "原因：缓存任务中网络断开，任务中断\n建议：尝试连接Wifi或允许使用流量进行缓存后重试缓存任务";
                case 9:
                    return "原因：用户未登录导致缓存任务中断\n建议：尝试重新登录后重试缓存任务";
                default:
                    return "尝试重试或继续缓存任务";
            }
        }
    }
}