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
import video.biz.offline.list.logic.OfflineResolveResult_androidKt;
import video.biz.offline.list.logic.statemachine.DiagnosticState;

/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/list/ResolveTreeProvider;", "Lvideo/biz/offline/list/logic/list/IResolveProvider;", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)V", "getVideoEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResolveTreeProvider implements IResolveProvider {
    public static final int $stable = OfflineVideoEntity.$stable;
    private final OfflineVideoEntity videoEntity;

    public ResolveTreeProvider(OfflineVideoEntity videoEntity) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        this.videoEntity = videoEntity;
    }

    public final OfflineVideoEntity getVideoEntity() {
        return this.videoEntity;
    }

    @Override // video.biz.offline.list.logic.list.IResolveProvider
    public Object title(Continuation<? super String> continuation) {
        return "文件结构:";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    @Override // video.biz.offline.list.logic.list.IResolveProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object content(Continuation<? super String> continuation) {
        ResolveTreeProvider$content$1 resolveTreeProvider$content$1;
        Object from;
        DiagnosticState state;
        Object resolveErrorCode;
        DiagnosticState state2;
        Object resolveErrorCode2;
        DiagnosticState state3;
        if (continuation instanceof ResolveTreeProvider$content$1) {
            resolveTreeProvider$content$1 = (ResolveTreeProvider$content$1) continuation;
            if ((resolveTreeProvider$content$1.label & Integer.MIN_VALUE) != 0) {
                resolveTreeProvider$content$1.label -= Integer.MIN_VALUE;
                Object $result = resolveTreeProvider$content$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveTreeProvider$content$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiagnosticState.Companion companion = DiagnosticState.Companion;
                        OfflineVideoEntity offlineVideoEntity = this.videoEntity;
                        resolveTreeProvider$content$1.label = 1;
                        from = companion.from(offlineVideoEntity, resolveTreeProvider$content$1);
                        if (from == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        state = (DiagnosticState) from;
                        if (state instanceof DiagnosticState.Damaged) {
                            if (state instanceof DiagnosticState.Incomplete) {
                                OfflineVideoEntity entity = ((DiagnosticState.Incomplete) state).getEntity();
                                resolveTreeProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                                resolveTreeProvider$content$1.label = 4;
                                Object fileTree = OfflineResolveResult_androidKt.fileTree(entity, resolveTreeProvider$content$1);
                                return fileTree == coroutine_suspended ? coroutine_suspended : fileTree;
                            } else if (state instanceof DiagnosticState.Completed) {
                                OfflineVideoEntity entity2 = ((DiagnosticState.Completed) state).getEntity();
                                resolveTreeProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                                resolveTreeProvider$content$1.label = 5;
                                Object fileTree2 = OfflineResolveResult_androidKt.fileTree(entity2, resolveTreeProvider$content$1);
                                return fileTree2 == coroutine_suspended ? coroutine_suspended : fileTree2;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        DiagnosticState.Damaged.Reason reason = ((DiagnosticState.Damaged) state).getReason();
                        if (reason instanceof DiagnosticState.Damaged.Reason.DownloadedButInvalid) {
                            OfflineVideoEntity entity3 = ((DiagnosticState.Damaged) state).getEntity();
                            resolveTreeProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            resolveTreeProvider$content$1.label = 2;
                            resolveErrorCode2 = OfflineResolveResult_androidKt.resolveErrorCode(entity3, resolveTreeProvider$content$1);
                            if (resolveErrorCode2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            state3 = state;
                            return "code: " + resolveErrorCode2;
                        } else if (!(reason instanceof DiagnosticState.Damaged.Reason.DownloadingButInvalid)) {
                            if (reason instanceof DiagnosticState.Damaged.Reason.WithUnretryableDownloadingError) {
                                return "code: " + ((DiagnosticState.Damaged.Reason.WithUnretryableDownloadingError) ((DiagnosticState.Damaged) state).getReason()).getErrorType().getCode();
                            }
                            throw new NoWhenBranchMatchedException();
                        } else {
                            OfflineVideoEntity entity4 = ((DiagnosticState.Damaged) state).getEntity();
                            resolveTreeProvider$content$1.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            resolveTreeProvider$content$1.label = 3;
                            resolveErrorCode = OfflineResolveResult_androidKt.resolveErrorCode(entity4, resolveTreeProvider$content$1);
                            if (resolveErrorCode == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            state2 = state;
                            return "code: " + resolveErrorCode;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        from = $result;
                        state = (DiagnosticState) from;
                        if (state instanceof DiagnosticState.Damaged) {
                        }
                        break;
                    case 2:
                        state3 = (DiagnosticState) resolveTreeProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        resolveErrorCode2 = $result;
                        return "code: " + resolveErrorCode2;
                    case 3:
                        state2 = (DiagnosticState) resolveTreeProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        resolveErrorCode = $result;
                        return "code: " + resolveErrorCode;
                    case 4:
                        DiagnosticState diagnosticState = (DiagnosticState) resolveTreeProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 5:
                        DiagnosticState diagnosticState2 = (DiagnosticState) resolveTreeProvider$content$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        resolveTreeProvider$content$1 = new ResolveTreeProvider$content$1(this, continuation);
        Object $result2 = resolveTreeProvider$content$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveTreeProvider$content$1.label) {
        }
    }
}