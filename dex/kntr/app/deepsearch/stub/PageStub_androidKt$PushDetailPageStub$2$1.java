package kntr.app.deepsearch.stub;

import android.app.Activity;
import java.lang.ref.WeakReference;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageStub.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stub.PageStub_androidKt$PushDetailPageStub$2$1", f = "PageStub.android.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageStub_androidKt$PushDetailPageStub$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $current;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageStub_androidKt$PushDetailPageStub$2$1(Activity activity, String str, Continuation<? super PageStub_androidKt$PushDetailPageStub$2$1> continuation) {
        super(2, continuation);
        this.$current = activity;
        this.$sessionId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageStub_androidKt$PushDetailPageStub$2$1(this.$current, this.$sessionId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageStub.android.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/deepsearch/stub/PageStub;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.deepsearch.stub.PageStub_androidKt$PushDetailPageStub$2$1$1", f = "PageStub.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.deepsearch.stub.PageStub_androidKt$PushDetailPageStub$2$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PageStub, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Activity $current;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$current = activity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$current, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(PageStub pageStub, Continuation<? super Boolean> continuation) {
            return create(pageStub, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            WeakReference<Activity> activityRef;
            PageStub it = (PageStub) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    return Boxing.boxBoolean(Intrinsics.areEqual((it == null || (activityRef = it.getActivityRef()) == null) ? null : activityRef.get(), this.$current));
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Flow flow;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        PageStub it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                flow = PageStub_androidKt.detailPageStub;
                this.label = 1;
                if (FlowKt.firstOrNull(flow, new AnonymousClass1(this.$current, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        $this$update$iv = PageStub_androidKt.detailPageStub;
        String str = this.$sessionId;
        do {
            prevValue$iv = $this$update$iv.getValue();
            it = (PageStub) prevValue$iv;
        } while (!$this$update$iv.compareAndSet(prevValue$iv, it != null ? PageStub.copy$default(it, null, str, 1, null) : null));
        return Unit.INSTANCE;
    }
}