package kntr.app.game.base.ui.page;

import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Incorrect field signature: TVM; */
/* compiled from: LoadComposable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.page.LoadComposableKt$LoadComposable$3$1", f = "LoadComposable.kt", i = {}, l = {79, 86}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoadComposableKt$LoadComposable$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $lazyLoad;
    final /* synthetic */ LifecycleOwner $lifecycle;
    final /* synthetic */ State<PageState> $pageState$delegate;
    final /* synthetic */ BaseViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (ZLandroidx/lifecycle/LifecycleOwner;TVM;Landroidx/compose/runtime/State<+Lkntr/app/game/base/viewmodel/PageState;>;Lkotlin/coroutines/Continuation<-Lkntr/app/game/base/ui/page/LoadComposableKt$LoadComposable$3$1;>;)V */
    public LoadComposableKt$LoadComposable$3$1(boolean z, LifecycleOwner lifecycleOwner, BaseViewModel baseViewModel, State state, Continuation continuation) {
        super(2, continuation);
        this.$lazyLoad = z;
        this.$lifecycle = lifecycleOwner;
        this.$viewModel = baseViewModel;
        this.$pageState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadComposableKt$LoadComposable$3$1(this.$lazyLoad, this.$lifecycle, this.$viewModel, this.$pageState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$lazyLoad) {
                    this.label = 1;
                    if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$lifecycle, Lifecycle.State.RESUMED, new AnonymousClass1(this.$viewModel, this.$pageState$delegate, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 2;
                    if (this.$viewModel.dispatch((PageEvent) PageEvent.Start.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Incorrect field signature: TVM; */
    /* compiled from: LoadComposable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.game.base.ui.page.LoadComposableKt$LoadComposable$3$1$1", f = "LoadComposable.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.game.base.ui.page.LoadComposableKt$LoadComposable$3$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<PageState> $pageState$delegate;
        final /* synthetic */ BaseViewModel $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (TVM;Landroidx/compose/runtime/State<+Lkntr/app/game/base/viewmodel/PageState;>;Lkotlin/coroutines/Continuation<-Lkntr/app/game/base/ui/page/LoadComposableKt$LoadComposable$3$1$1;>;)V */
        AnonymousClass1(BaseViewModel baseViewModel, State state, Continuation continuation) {
            super(2, continuation);
            this.$viewModel = baseViewModel;
            this.$pageState$delegate = state;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$viewModel, this.$pageState$delegate, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            PageState LoadComposable$lambda$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    KLog_androidKt.getKLog().d("LoadComposable", "lifecycle: resumed");
                    LoadComposable$lambda$1 = LoadComposableKt.LoadComposable$lambda$1(this.$pageState$delegate);
                    if (Intrinsics.areEqual(LoadComposable$lambda$1, PageState.Initialize.INSTANCE)) {
                        this.label = 1;
                        if (this.$viewModel.dispatch((PageEvent) PageEvent.Start.INSTANCE, (Continuation) this) == coroutine_suspended) {
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
    }
}