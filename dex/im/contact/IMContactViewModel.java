package im.contact;

import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import im.contact.di.IMContactCoroutineScope;
import im.contact.di.IMContactScope;
import im.contact.model.IMContactAction;
import im.contact.model.IMContactClickedHolder;
import im.contact.model.IMContactPageData;
import javax.inject.Inject;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: IMContactViewModel.kt */
@IMContactScope
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u00020\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lim/contact/IMContactViewModel;", "", "stateMachine", "Lim/contact/IMContactPageStateMachine;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lim/contact/IMContactPageStateMachine;Lkotlinx/coroutines/CoroutineScope;)V", "getScope$annotations", "()V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "dataFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lim/contact/model/IMContactPageData;", "getDataFlow$annotations", "getDataFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "clickedContact", "Lkotlinx/coroutines/flow/Flow;", "Lim/contact/model/IMContactClickedHolder;", "getClickedContact$annotations", "getClickedContact", "()Lkotlinx/coroutines/flow/Flow;", "dispatchAction", "", AuthActivity.ACTION_KEY, "Lim/contact/model/IMContactAction;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactViewModel {
    private final Flow<IMContactClickedHolder> clickedContact;
    private final StateFlow<IMContactPageData> dataFlow;
    private final CoroutineScope scope;
    private final IMContactPageStateMachine stateMachine;

    public static /* synthetic */ void getClickedContact$annotations() {
    }

    public static /* synthetic */ void getDataFlow$annotations() {
    }

    public static /* synthetic */ void getScope$annotations() {
    }

    @Inject
    public IMContactViewModel(IMContactPageStateMachine stateMachine, @IMContactCoroutineScope CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.stateMachine = stateMachine;
        this.scope = scope;
        this.dataFlow = FlowKt.stateIn(this.stateMachine.getState(), this.scope, SharingStarted.Companion.getLazily(), IMContactPageData.Companion.getDEFAULT());
        final Flow $this$map$iv = this.dataFlow;
        this.clickedContact = FlowKt.shareIn$default(FlowKt.distinctUntilChanged(new Flow<IMContactClickedHolder>() { // from class: im.contact.IMContactViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.contact.IMContactViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.contact.IMContactViewModel$special$$inlined$map$1$2", f = "IMContactViewModel.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: im.contact.IMContactViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    IMContactPageData it = (IMContactPageData) value;
                                    IMContactClickedHolder clickedContact = it.getClickedContact();
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(clickedContact, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i2 = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), this.scope, SharingStarted.Companion.getLazily(), 0, 4, (Object) null);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final StateFlow<IMContactPageData> getDataFlow() {
        return this.dataFlow;
    }

    public final Flow<IMContactClickedHolder> getClickedContact() {
        return this.clickedContact;
    }

    public final void dispatchAction(IMContactAction action) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        KLog_androidKt.getKLog().i(UtilsKt.TAG("VM"), "Action " + action);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new IMContactViewModel$dispatchAction$1(this, action, null), 3, (Object) null);
    }
}