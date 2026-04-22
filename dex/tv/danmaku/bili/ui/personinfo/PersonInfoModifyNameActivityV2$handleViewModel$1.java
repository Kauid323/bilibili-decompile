package tv.danmaku.bili.ui.personinfo;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameViewModelV2;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.PageState;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ViewState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersonInfoModifyNameActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$handleViewModel$1", f = "PersonInfoModifyNameActivityV2.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PersonInfoModifyNameActivityV2$handleViewModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PersonInfoModifyNameActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoModifyNameActivityV2$handleViewModel$1(PersonInfoModifyNameActivityV2 personInfoModifyNameActivityV2, Continuation<? super PersonInfoModifyNameActivityV2$handleViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = personInfoModifyNameActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PersonInfoModifyNameActivityV2$handleViewModel$1(this.this$0, continuation);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0.getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PersonInfoModifyNameActivityV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$handleViewModel$1$1", f = "PersonInfoModifyNameActivityV2.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$handleViewModel$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PersonInfoModifyNameActivityV2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PersonInfoModifyNameActivityV2 personInfoModifyNameActivityV2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = personInfoModifyNameActivityV2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ModifyNameViewModelV2 modifyNameViewModelV2;
            StateFlow<ViewState> pageStateFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    modifyNameViewModelV2 = this.this$0.viewModel;
                    if (modifyNameViewModelV2 == null || (pageStateFlow = modifyNameViewModelV2.getPageStateFlow()) == null) {
                        return Unit.INSTANCE;
                    }
                    final PersonInfoModifyNameActivityV2 personInfoModifyNameActivityV2 = this.this$0;
                    this.label = 1;
                    if (pageStateFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2.handleViewModel.1.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((ViewState) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(ViewState it, Continuation<? super Unit> continuation) {
                            BLog.i("PersonInfoModifyNameActivityV2", "pageState: " + it);
                            PageState pageState = it.getPageState();
                            if (!Intrinsics.areEqual(pageState, PageState.Initial.INSTANCE)) {
                                if (Intrinsics.areEqual(pageState, PageState.ShowLoading.INSTANCE)) {
                                    PersonInfoModifyNameActivityV2.this.showLoading();
                                } else if (Intrinsics.areEqual(pageState, PageState.ShowEditState.INSTANCE)) {
                                    PersonInfoModifyNameActivityV2.this.handledCanEditState(it.getEditState().getTips(), it.getEditState().getCanEdit());
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
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