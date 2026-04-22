package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.ResourceValidateCode;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DownloadErrorType;
import video.biz.offline.list.logic.SupportedOptions_androidKt;
import video.biz.offline.list.logic.statemachine.DiagnosticState;

/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lvideo/biz/offline/list/logic/list/ResolveResultProvider;", "Lvideo/biz/offline/list/logic/list/IResolveProvider;", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)V", "getVideoEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "getDamagedResult", "reason", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Damaged$Reason;", "getIncompleteResult", "Lvideo/biz/offline/list/logic/statemachine/DiagnosticState$Incomplete$Reason;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResolveResultProvider implements IResolveProvider {
    public static final int $stable = OfflineVideoEntity.$stable;
    private final OfflineVideoEntity videoEntity;

    /* compiled from: OfflineResolveDataProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
                iArr[DownloadErrorType.STORAGE_SPACE_FULL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DownloadErrorType.NOT_VIP_DOWNLOAD_VIP_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DownloadErrorType.TOO_LARGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DownloadErrorType.PLAYVIEW_ERROR.ordinal()] = 6;
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
            int[] iArr2 = new int[ResourceValidateCode.values().length];
            try {
                iArr2[ResourceValidateCode.ERROR_STORAGE_DIR_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_INVALID_ENTRY.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_ENTRY_NO_TYPE_TAG.ordinal()] = 3;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_MEDIA_DIR_NOT_FOUND.ordinal()] = 4;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_INVALID_INDEX.ordinal()] = 5;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr2[ResourceValidateCode.ERROR_DASH_NOT_FOUND.ordinal()] = 6;
            } catch (NoSuchFieldError e15) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public ResolveResultProvider(OfflineVideoEntity videoEntity) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        this.videoEntity = videoEntity;
    }

    public final OfflineVideoEntity getVideoEntity() {
        return this.videoEntity;
    }

    @Override // video.biz.offline.list.logic.list.IResolveProvider
    public Object title(Continuation<? super String> continuation) {
        return "诊断结果:";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    @Override // video.biz.offline.list.logic.list.IResolveProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object content(Continuation<? super String> continuation) {
        ResolveResultProvider$content$1 resolveResultProvider$content$1;
        Object from;
        DiagnosticState state;
        if (continuation instanceof ResolveResultProvider$content$1) {
            resolveResultProvider$content$1 = (ResolveResultProvider$content$1) continuation;
            if ((resolveResultProvider$content$1.label & Integer.MIN_VALUE) != 0) {
                resolveResultProvider$content$1.label -= Integer.MIN_VALUE;
                Object $result = resolveResultProvider$content$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveResultProvider$content$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiagnosticState.Companion companion = DiagnosticState.Companion;
                        OfflineVideoEntity offlineVideoEntity = this.videoEntity;
                        resolveResultProvider$content$1.label = 1;
                        from = companion.from(offlineVideoEntity, resolveResultProvider$content$1);
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
                if (state instanceof DiagnosticState.Completed) {
                    if (state instanceof DiagnosticState.Damaged) {
                        return getDamagedResult(((DiagnosticState.Damaged) state).getReason());
                    }
                    if (state instanceof DiagnosticState.Incomplete) {
                        return getIncompleteResult(((DiagnosticState.Incomplete) state).getReason());
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "离线缓存解析成功";
            }
        }
        resolveResultProvider$content$1 = new ResolveResultProvider$content$1(this, continuation);
        Object $result2 = resolveResultProvider$content$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveResultProvider$content$1.label) {
        }
        state = (DiagnosticState) from;
        if (state instanceof DiagnosticState.Completed) {
        }
    }

    private final String getDamagedResult(DiagnosticState.Damaged.Reason reason) {
        if (reason instanceof DiagnosticState.Damaged.Reason.WithUnretryableDownloadingError) {
            switch (WhenMappings.$EnumSwitchMapping$0[((DiagnosticState.Damaged.Reason.WithUnretryableDownloadingError) reason).getErrorType().ordinal()]) {
                case 1:
                    return "未知错误";
                case 2:
                case 6:
                default:
                    return "解析失败";
                case 3:
                    return "存储空间不足";
                case 4:
                    return "权限等原因无法缓存该视频";
                case 5:
                    return "超出单次缓存上限";
            }
        } else if (reason instanceof DiagnosticState.Damaged.Reason.DownloadedButInvalid) {
            switch (WhenMappings.$EnumSwitchMapping$1[((DiagnosticState.Damaged.Reason.DownloadedButInvalid) reason).getCode().ordinal()]) {
                case 1:
                default:
                    return "解析失败";
                case 2:
                    return "离线缓存目录内有文件缺失";
                case 3:
                    return "离线缓存清晰度解析失败";
                case 4:
                    return "离线缓存文件目录查找失败";
                case 5:
                    return "离线缓存视频信息不完整";
                case 6:
                    return "视频文件缺失，无法播放视频";
            }
        } else if (!(reason instanceof DiagnosticState.Damaged.Reason.DownloadingButInvalid)) {
            throw new NoWhenBranchMatchedException();
        } else {
            switch (WhenMappings.$EnumSwitchMapping$1[((DiagnosticState.Damaged.Reason.DownloadingButInvalid) reason).getCode().ordinal()]) {
                case 1:
                default:
                    return "解析失败";
                case 2:
                    return "离线缓存目录内有文件缺失";
                case 3:
                    return "离线缓存清晰度解析失败";
                case 4:
                    return "离线缓存文件目录查找失败";
                case 5:
                    return "离线缓存视频信息不完整";
            }
        }
    }

    private final String getIncompleteResult(DiagnosticState.Incomplete.Reason reason) {
        if (reason instanceof DiagnosticState.Incomplete.Reason.Paused) {
            return !SupportedOptions_androidKt.isNetworkConnect() ? "网络未连接" : "缓存未完成";
        } else if (!(reason instanceof DiagnosticState.Incomplete.Reason.WithRetryableError)) {
            throw new NoWhenBranchMatchedException();
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[((DiagnosticState.Incomplete.Reason.WithRetryableError) reason).getErrorType().ordinal()]) {
                case 7:
                    return "切换至非Wifi网络";
                case 8:
                    return "网络断开";
                case 9:
                    return "用户未登录";
                default:
                    return "缓存未完成";
            }
        }
    }
}