package video.biz.offline.list.logic.utils;

import com.bapis.bilibili.app.viewunite.v1.KCachePlayAv;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.AvAuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineAuthApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lvideo/biz/offline/list/logic/model/AvAuthResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.OfflineAuthApiKt$avAuthWithLimit$2$1$1", f = "OfflineAuthApi.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineAuthApiKt$avAuthWithLimit$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AvAuthResult>>, Object> {
    final /* synthetic */ List<KCachePlayAv> $cachePlayAvs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineAuthApiKt$avAuthWithLimit$2$1$1(List<KCachePlayAv> list, Continuation<? super OfflineAuthApiKt$avAuthWithLimit$2$1$1> continuation) {
        super(2, continuation);
        this.$cachePlayAvs = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineAuthApiKt$avAuthWithLimit$2$1$1(this.$cachePlayAvs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<AvAuthResult>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object tryAddAvAuthResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                tryAddAvAuthResult = OfflineAuthApiKt.tryAddAvAuthResult(this.$cachePlayAvs, (Continuation) this);
                if (tryAddAvAuthResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return tryAddAvAuthResult;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}