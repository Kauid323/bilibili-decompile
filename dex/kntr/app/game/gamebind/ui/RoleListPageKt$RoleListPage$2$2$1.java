package kntr.app.game.gamebind.ui;

import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.game.gamebind.GameBindEvent;
import kntr.app.game.gamebind.GameBindEventStore;
import kntr.app.game.gamebind.RolesListViewModel;
import kntr.app.game.gamebind.ui.report.ReporterKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoleListPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.ui.RoleListPageKt$RoleListPage$2$2$1", f = "RoleListPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RoleListPageKt$RoleListPage$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isMineTab;
    final /* synthetic */ boolean $isMyself;
    final /* synthetic */ Toaster $toaster;
    final /* synthetic */ RolesListViewModel $viewModel;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleListPageKt$RoleListPage$2$2$1(boolean z, boolean z2, RolesListViewModel rolesListViewModel, Toaster toaster, Continuation<? super RoleListPageKt$RoleListPage$2$2$1> continuation) {
        super(2, continuation);
        this.$isMineTab = z;
        this.$isMyself = z2;
        this.$viewModel = rolesListViewModel;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> roleListPageKt$RoleListPage$2$2$1 = new RoleListPageKt$RoleListPage$2$2$1(this.$isMineTab, this.$isMyself, this.$viewModel, this.$toaster, continuation);
        roleListPageKt$RoleListPage$2$2$1.L$0 = obj;
        return roleListPageKt$RoleListPage$2$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.$isMineTab) {
                    ReporterKt.reportManagementPageShow(this.$isMyself);
                }
                BuildersKt.launch$default($this$LaunchedEffect, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$viewModel, null), 3, (Object) null);
                BuildersKt.launch$default($this$LaunchedEffect, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$viewModel, this.$toaster, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoleListPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.game.gamebind.ui.RoleListPageKt$RoleListPage$2$2$1$1", f = "RoleListPage.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.game.gamebind.ui.RoleListPageKt$RoleListPage$2$2$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RolesListViewModel $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RolesListViewModel rolesListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$viewModel = rolesListViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$viewModel, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SharedFlow<GameBindEvent> bindEvent = GameBindEventStore.INSTANCE.getBindEvent();
                    final RolesListViewModel rolesListViewModel = this.$viewModel;
                    this.label = 1;
                    if (bindEvent.collect(new FlowCollector() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt.RoleListPage.2.2.1.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((GameBindEvent) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(GameBindEvent gameBindEvent, Continuation<? super Unit> continuation) {
                            Object dispatch = RolesListViewModel.this.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, continuation);
                            return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
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
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoleListPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.game.gamebind.ui.RoleListPageKt$RoleListPage$2$2$1$2", f = "RoleListPage.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.game.gamebind.ui.RoleListPageKt$RoleListPage$2$2$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Toaster $toaster;
        final /* synthetic */ RolesListViewModel $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RolesListViewModel rolesListViewModel, Toaster toaster, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$viewModel = rolesListViewModel;
            this.$toaster = toaster;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$viewModel, this.$toaster, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SharedFlow<String> toastEvent = this.$viewModel.getToastEvent();
                    final Toaster toaster = this.$toaster;
                    this.label = 1;
                    if (toastEvent.collect(new FlowCollector() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt.RoleListPage.2.2.1.2.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((String) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(String toast, Continuation<? super Unit> continuation) {
                            if (toast.length() > 0) {
                                Toaster.-CC.showToast$default(toaster, toast, (ToastDuration) null, 2, (Object) null);
                            }
                            return Unit.INSTANCE;
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
            throw new KotlinNothingValueException();
        }
    }
}