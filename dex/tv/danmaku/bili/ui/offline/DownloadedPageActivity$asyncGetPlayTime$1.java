package tv.danmaku.bili.ui.offline;

import com.bilibili.offline.OfflineInfo;
import java.util.Collection;
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
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadedPageActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.DownloadedPageActivity$asyncGetPlayTime$1", f = "DownloadedPageActivity.kt", i = {}, l = {167, 169}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DownloadedPageActivity$asyncGetPlayTime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OfflineInfo> $infoList;
    int label;
    final /* synthetic */ DownloadedPageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadedPageActivity$asyncGetPlayTime$1(DownloadedPageActivity downloadedPageActivity, List<OfflineInfo> list, Continuation<? super DownloadedPageActivity$asyncGetPlayTime$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadedPageActivity;
        this.$infoList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadedPageActivity$asyncGetPlayTime$1(this.this$0, this.$infoList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        DownloadedPageAdapter downloadedPageAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(500L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$infoList, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                downloadedPageAdapter = this.this$0.mAdapter;
                if (downloadedPageAdapter != null) {
                    downloadedPageAdapter.notifyDataSetChanged();
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$infoList, null), (Continuation) this) == coroutine_suspended) {
                }
                downloadedPageAdapter = this.this$0.mAdapter;
                if (downloadedPageAdapter != null) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                downloadedPageAdapter = this.this$0.mAdapter;
                if (downloadedPageAdapter != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedPageActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.offline.DownloadedPageActivity$asyncGetPlayTime$1$1", f = "DownloadedPageActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.offline.DownloadedPageActivity$asyncGetPlayTime$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<OfflineInfo> $infoList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<OfflineInfo> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$infoList = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$infoList, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Collection $this$toTypedArray$iv = this.$infoList;
                    Object[] $this$forEach$iv = $this$toTypedArray$iv.toArray(new OfflineInfo[0]);
                    for (Object element$iv : $this$forEach$iv) {
                        OfflineInfo info = (OfflineInfo) element$iv;
                        info.playedTime = OfflineUtil.getPlayedTimeV2(info.typeInfo);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}