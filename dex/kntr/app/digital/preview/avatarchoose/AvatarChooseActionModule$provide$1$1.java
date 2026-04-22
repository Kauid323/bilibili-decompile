package kntr.app.digital.preview.avatarchoose;

import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.avatarchoose.ChooseAvatar;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.digital.preview.loading.DigitalLoadingService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AvatarChooseActionModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.avatarchoose.AvatarChooseActionModule$provide$1$1", f = "AvatarChooseActionModule.kt", i = {0}, l = {36}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
final class AvatarChooseActionModule$provide$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DismissRequest $dismissRequest;
    final /* synthetic */ KomponentScope<Unit> $komponentScope;
    final /* synthetic */ DigitalLoadingService $loadingService;
    final /* synthetic */ Action<AvatarChooseAction> $this_ActionModule;
    final /* synthetic */ Toaster $toaster;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarChooseActionModule$provide$1$1(KomponentScope<? super Unit> komponentScope, Action<AvatarChooseAction> action, DigitalLoadingService digitalLoadingService, Toaster toaster, DismissRequest dismissRequest, Continuation<? super AvatarChooseActionModule$provide$1$1> continuation) {
        super(2, continuation);
        this.$komponentScope = komponentScope;
        this.$this_ActionModule = action;
        this.$loadingService = digitalLoadingService;
        this.$toaster = toaster;
        this.$dismissRequest = dismissRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> avatarChooseActionModule$provide$1$1 = new AvatarChooseActionModule$provide$1$1(this.$komponentScope, this.$this_ActionModule, this.$loadingService, this.$toaster, this.$dismissRequest, continuation);
        avatarChooseActionModule$provide$1$1.L$0 = obj;
        return avatarChooseActionModule$provide$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<ChooseAvatar.State> invoke = AvatarChooser_androidKt.getChooseAvatar().invoke(this.$komponentScope, this.$this_ActionModule.getData().getShowDigital(), this.$this_ActionModule.getData().getDigitalText());
                final DigitalLoadingService digitalLoadingService = this.$loadingService;
                final Toaster toaster = this.$toaster;
                final DismissRequest dismissRequest = this.$dismissRequest;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                this.label = 1;
                if (invoke.collect(new FlowCollector() { // from class: kntr.app.digital.preview.avatarchoose.AvatarChooseActionModule$provide$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((ChooseAvatar.State) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(ChooseAvatar.State it, Continuation<? super Unit> continuation) {
                        if (Intrinsics.areEqual(it, ChooseAvatar.State.Uploading.INSTANCE)) {
                            BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new C00011(digitalLoadingService, null), 3, (Object) null);
                        } else if (it instanceof ChooseAvatar.State.Failed) {
                            digitalLoadingService.setLoadingDialogMessage(null);
                            String errorStr = ((ChooseAvatar.State.Failed) it).getMsg();
                            String str = errorStr;
                            if (str == null || str.length() == 0) {
                                errorStr = "修改失败";
                                if (((ChooseAvatar.State.Failed) it).getErrorCode() == -653) {
                                    errorStr = "未接收到头像或头像过大(超过2M)";
                                } else if (((ChooseAvatar.State.Failed) it).getErrorCode() == 10000) {
                                    errorStr = "由于系统升级，暂时无法修改部分账号资料";
                                }
                            }
                            Toaster.-CC.showToast$default(toaster, errorStr, (ToastDuration) null, 2, (Object) null);
                        } else if (!Intrinsics.areEqual(it, ChooseAvatar.State.Success.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            dismissRequest.invoke();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: AvatarChooseActionModule.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "kntr.app.digital.preview.avatarchoose.AvatarChooseActionModule$provide$1$1$1$1", f = "AvatarChooseActionModule.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    /* renamed from: kntr.app.digital.preview.avatarchoose.AvatarChooseActionModule$provide$1$1$1$1  reason: invalid class name and collision with other inner class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class C00011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ DigitalLoadingService $loadingService;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00011(DigitalLoadingService digitalLoadingService, Continuation<? super C00011> continuation) {
                            super(2, continuation);
                            this.$loadingService = digitalLoadingService;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00011(this.$loadingService, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$loadingService.keepShowing("正在提交...", (Continuation) this) == coroutine_suspended) {
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
                }, (Continuation) this) == coroutine_suspended) {
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