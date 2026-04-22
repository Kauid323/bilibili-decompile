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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameV2Event;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameViewModelV2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersonInfoModifyNameActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$handleViewModel$2", f = "PersonInfoModifyNameActivityV2.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PersonInfoModifyNameActivityV2$handleViewModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PersonInfoModifyNameActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoModifyNameActivityV2$handleViewModel$2(PersonInfoModifyNameActivityV2 personInfoModifyNameActivityV2, Continuation<? super PersonInfoModifyNameActivityV2$handleViewModel$2> continuation) {
        super(2, continuation);
        this.this$0 = personInfoModifyNameActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PersonInfoModifyNameActivityV2$handleViewModel$2(this.this$0, continuation);
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
    @DebugMetadata(c = "tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$handleViewModel$2$1", f = "PersonInfoModifyNameActivityV2.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2$handleViewModel$2$1  reason: invalid class name */
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
            SharedFlow<ModifyNameV2Event> pageEventFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    modifyNameViewModelV2 = this.this$0.viewModel;
                    if (modifyNameViewModelV2 == null || (pageEventFlow = modifyNameViewModelV2.getPageEventFlow()) == null) {
                        return Unit.INSTANCE;
                    }
                    final PersonInfoModifyNameActivityV2 personInfoModifyNameActivityV2 = this.this$0;
                    this.label = 1;
                    if (pageEventFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.personinfo.PersonInfoModifyNameActivityV2.handleViewModel.2.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((ModifyNameV2Event) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(ModifyNameV2Event it, Continuation<? super Unit> continuation) {
                            BLog.i("PersonInfoModifyNameActivityV2", "pageEvent: " + it);
                            if (it instanceof ModifyNameV2Event.ShowToast) {
                                PersonInfoModifyNameActivityV2.this.showToast(((ModifyNameV2Event.ShowToast) it).getInfo());
                            } else if (it instanceof ModifyNameV2Event.SubmitFailed) {
                                PersonInfoModifyNameActivityV2.this.onSubmitFailed(((ModifyNameV2Event.SubmitFailed) it).getException());
                            } else if (it instanceof ModifyNameV2Event.SubmitSuccess) {
                                PersonInfoModifyNameActivityV2.this.onSubmitSuccess(((ModifyNameV2Event.SubmitSuccess) it).getSuccessName());
                            } else if (it instanceof ModifyNameV2Event.ShowBindPhoneDialog) {
                                PersonInfoModifyNameActivityV2.this.showBindPhoneDialog(((ModifyNameV2Event.ShowBindPhoneDialog) it).getConditionMsg(), ((ModifyNameV2Event.ShowBindPhoneDialog) it).getTel());
                            } else if (it instanceof ModifyNameV2Event.ShowChangeConformDialog) {
                                PersonInfoModifyNameActivityV2.this.showModifyNameConformDialog(((ModifyNameV2Event.ShowChangeConformDialog) it).getConformMsg());
                            } else if (it instanceof ModifyNameV2Event.ShowNameRetryDialog) {
                                PersonInfoModifyNameActivityV2.this.showNickNameReTryDialog(((ModifyNameV2Event.ShowNameRetryDialog) it).getNames());
                            } else {
                                throw new NoWhenBranchMatchedException();
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