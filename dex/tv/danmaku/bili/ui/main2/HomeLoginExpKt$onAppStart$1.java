package tv.danmaku.bili.ui.main2;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.moduleservice.main.InterestDialogService;
import com.bilibili.moduleservice.main.InterestDialogState;
import com.bilibili.moduleservice.main.MainCommonService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.distributable.DistributableLoginKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeLoginExp.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.HomeLoginExpKt$onAppStart$1", f = "HomeLoginExp.kt", i = {}, l = {BR.backgroundTitleTextColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeLoginExpKt$onAppStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $this_onAppStart;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLoginExpKt$onAppStart$1(FragmentActivity fragmentActivity, Continuation<? super HomeLoginExpKt$onAppStart$1> continuation) {
        super(2, continuation);
        this.$this_onAppStart = fragmentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeLoginExpKt$onAppStart$1(this.$this_onAppStart, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (EnvironmentManager.getInstance().isFirstStart()) {
                    this.label = 1;
                    if (DistributableLoginKt.tryDistributableStartupLogin(this.$this_onAppStart, new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeLoginExp.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.main2.HomeLoginExpKt$onAppStart$1$1", f = "HomeLoginExp.kt", i = {}, l = {BR.backgroundTranslucentEnable, BR.banner}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.main2.HomeLoginExpKt$onAppStart$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Flow state;
            Object $result2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BLog.i("[Home]HomeLoginExp", "wait system push dialog");
                    MainCommonService mainCommonService = (MainCommonService) BLRouter.get$default(BLRouter.INSTANCE, MainCommonService.class, (String) null, 2, (Object) null);
                    if (mainCommonService != null) {
                        this.label = 1;
                        if (mainCommonService.awaitSystemPushDialogResult((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    $result2 = $result;
                    InterestDialogState interestDialogState = (InterestDialogState) $result;
                    BLog.i("[Home]HomeLoginExp", "wait finish");
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), InterestDialogService.class, (String) null, 2, (Object) null);
            InterestDialogService interestService = suspendProducer != null ? (InterestDialogService) suspendProducer.get() : null;
            BLog.i("[Home]HomeLoginExp", "wait interest dialog if need, interestService , serviceHashCode = " + (interestService != null ? Boxing.boxInt(interestService.hashCode()) : null));
            if (interestService != null && (state = interestService.getState()) != null) {
                this.label = 2;
                Object first = FlowKt.first(state, new C00201(null), (Continuation) this);
                if (first == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = first;
                InterestDialogState interestDialogState2 = (InterestDialogState) $result;
            }
            BLog.i("[Home]HomeLoginExp", "wait finish");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HomeLoginExp.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bilibili/moduleservice/main/InterestDialogState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        @DebugMetadata(c = "tv.danmaku.bili.ui.main2.HomeLoginExpKt$onAppStart$1$1$1", f = "HomeLoginExp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: tv.danmaku.bili.ui.main2.HomeLoginExpKt$onAppStart$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class C00201 extends SuspendLambda implements Function2<InterestDialogState, Continuation<? super Boolean>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C00201(Continuation<? super C00201> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00201 = new C00201(continuation);
                c00201.L$0 = obj;
                return c00201;
            }

            public final Object invoke(InterestDialogState interestDialogState, Continuation<? super Boolean> continuation) {
                return create(interestDialogState, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        InterestDialogState it = (InterestDialogState) this.L$0;
                        return Boxing.boxBoolean(!it.getForbidOverlay());
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}