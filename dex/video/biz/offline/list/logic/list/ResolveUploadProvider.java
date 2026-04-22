package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.statemachine.DiagnosticState;

/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/list/ResolveUploadProvider;", "Lvideo/biz/offline/list/logic/list/IResolveProvider;", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)V", "getVideoEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResolveUploadProvider implements IResolveProvider {
    public static final int $stable = OfflineVideoEntity.$stable;
    private final OfflineVideoEntity videoEntity;

    public ResolveUploadProvider(OfflineVideoEntity videoEntity) {
        Intrinsics.checkNotNullParameter(videoEntity, "videoEntity");
        this.videoEntity = videoEntity;
    }

    public final OfflineVideoEntity getVideoEntity() {
        return this.videoEntity;
    }

    @Override // video.biz.offline.list.logic.list.IResolveProvider
    public Object title(Continuation<? super String> continuation) {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d A[RETURN] */
    @Override // video.biz.offline.list.logic.list.IResolveProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object content(Continuation<? super String> continuation) {
        ResolveUploadProvider$content$1 resolveUploadProvider$content$1;
        Object from;
        DiagnosticState state;
        if (continuation instanceof ResolveUploadProvider$content$1) {
            resolveUploadProvider$content$1 = (ResolveUploadProvider$content$1) continuation;
            if ((resolveUploadProvider$content$1.label & Integer.MIN_VALUE) != 0) {
                resolveUploadProvider$content$1.label -= Integer.MIN_VALUE;
                Object $result = resolveUploadProvider$content$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (resolveUploadProvider$content$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DiagnosticState.Companion companion = DiagnosticState.Companion;
                        OfflineVideoEntity offlineVideoEntity = this.videoEntity;
                        resolveUploadProvider$content$1.label = 1;
                        from = companion.from(offlineVideoEntity, resolveUploadProvider$content$1);
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
                    return "";
                }
                return "上报诊断结果";
            }
        }
        resolveUploadProvider$content$1 = new ResolveUploadProvider$content$1(this, continuation);
        Object $result2 = resolveUploadProvider$content$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (resolveUploadProvider$content$1.label) {
        }
        state = (DiagnosticState) from;
        if (!(state instanceof DiagnosticState.Completed)) {
        }
    }
}