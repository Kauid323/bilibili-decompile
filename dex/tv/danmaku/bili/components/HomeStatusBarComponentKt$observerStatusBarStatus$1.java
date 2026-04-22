package tv.danmaku.bili.components;

import com.bilibili.lib.homepage.home.model.StatusBarEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeStatusBarComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.components.HomeStatusBarComponentKt$observerStatusBarStatus$1", f = "HomeStatusBarComponent.kt", i = {}, l = {BR.backgroundTitleText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeStatusBarComponentKt$observerStatusBarStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $pathLog;
    final /* synthetic */ MainActivityV2 $this_observerStatusBarStatus;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeStatusBarComponentKt$observerStatusBarStatus$1(MainActivityV2 mainActivityV2, Ref.ObjectRef<String> objectRef, Continuation<? super HomeStatusBarComponentKt$observerStatusBarStatus$1> continuation) {
        super(2, continuation);
        this.$this_observerStatusBarStatus = mainActivityV2;
        this.$pathLog = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeStatusBarComponentKt$observerStatusBarStatus$1(this.$this_observerStatusBarStatus, this.$pathLog, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeStatusBarComponent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bilibili/lib/homepage/home/model/StatusBarEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.components.HomeStatusBarComponentKt$observerStatusBarStatus$1$1", f = "HomeStatusBarComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.components.HomeStatusBarComponentKt$observerStatusBarStatus$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<StatusBarEvent, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $pathLog;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pathLog = objectRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$pathLog, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(StatusBarEvent statusBarEvent, Continuation<? super Unit> continuation) {
            return create(statusBarEvent, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    StatusBarEvent it = (StatusBarEvent) this.L$0;
                    BLog.i("[Home]HomeStatusBarComponent", "observerStatusBarStatus, event = " + it);
                    this.$pathLog.element = new StringBuilder().append(this.$pathLog.element).append(it).toString();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (FlowKt.collectLatest(FlowKt.filterNotNull(this.$this_observerStatusBarStatus.viewModel.getStatusBarEvent()), new AnonymousClass1(this.$pathLog, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}