package tv.danmaku.bili.ui.offline;

import com.bilibili.offline.OfflineInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineHomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.OfflineHomeFragment$asyncGetPlayTime$1", f = "OfflineHomeFragment.kt", i = {1}, l = {615, 619}, m = "invokeSuspend", n = {"start$iv"}, s = {"J$0"}, v = 1)
public final class OfflineHomeFragment$asyncGetPlayTime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OfflineInfo> $infoList;
    long J$0;
    int label;
    final /* synthetic */ OfflineHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomeFragment$asyncGetPlayTime$1(OfflineHomeFragment offlineHomeFragment, List<OfflineInfo> list, Continuation<? super OfflineHomeFragment$asyncGetPlayTime$1> continuation) {
        super(2, continuation);
        this.this$0 = offlineHomeFragment;
        this.$infoList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineHomeFragment$asyncGetPlayTime$1(this.this$0, this.$infoList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        List<OfflineInfo> list;
        long start$iv;
        OfflineHomeAdapter mAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(500L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = this.$infoList;
                long start$iv2 = System.currentTimeMillis();
                BLog.i("offline-home", "loadData - loading");
                this.J$0 = start$iv2;
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getIO(), new OfflineHomeFragment$asyncGetPlayTime$1$1$1(list, null), this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                start$iv = start$iv2;
                BLog.i("offline-home", "loadData - loaded");
                long it = System.currentTimeMillis() - start$iv;
                BLog.i("offline-home", "loadData - time consume " + it + " ms");
                mAdapter = this.this$0.getMAdapter();
                mAdapter.notifyDataSetChanged();
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                list = this.$infoList;
                long start$iv22 = System.currentTimeMillis();
                BLog.i("offline-home", "loadData - loading");
                this.J$0 = start$iv22;
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getIO(), new OfflineHomeFragment$asyncGetPlayTime$1$1$1(list, null), this) != coroutine_suspended) {
                }
                break;
            case 2:
                start$iv = this.J$0;
                ResultKt.throwOnFailure($result);
                BLog.i("offline-home", "loadData - loaded");
                long it2 = System.currentTimeMillis() - start$iv;
                BLog.i("offline-home", "loadData - time consume " + it2 + " ms");
                mAdapter = this.this$0.getMAdapter();
                mAdapter.notifyDataSetChanged();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}