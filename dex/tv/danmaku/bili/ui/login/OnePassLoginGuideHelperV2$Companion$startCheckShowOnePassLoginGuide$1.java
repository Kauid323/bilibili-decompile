package tv.danmaku.bili.ui.login;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;

/* compiled from: OnePassLoginGuideHelperV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$1", f = "OnePassLoginGuideHelperV2.kt", i = {}, l = {751}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<Integer, Boolean> $callback;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ String $fromSpmid;
    final /* synthetic */ boolean $isStartUpFragment;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$1(Fragment fragment, String str, boolean z, FragmentActivity fragmentActivity, Function1<? super Integer, Boolean> function1, Continuation<? super OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$1> continuation) {
        super(2, continuation);
        this.$fragment = fragment;
        this.$fromSpmid = str;
        this.$isStartUpFragment = z;
        this.$activity = fragmentActivity;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$1(this.$fragment, this.$fromSpmid, this.$isStartUpFragment, this.$activity, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnePassLoginGuideHelperV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$1$1", f = "OnePassLoginGuideHelperV2.kt", i = {}, l = {752}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ Function1<Integer, Boolean> $callback;
        final /* synthetic */ String $fromSpmid;
        final /* synthetic */ boolean $isStartUpFragment;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, boolean z, FragmentActivity fragmentActivity, Function1<? super Integer, Boolean> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$fromSpmid = str;
            this.$isStartUpFragment = z;
            this.$activity = fragmentActivity;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$fromSpmid, this.$isStartUpFragment, this.$activity, this.$callback, continuation);
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
                    if (OnePassLoginGuideHelperV2.Companion.startCheckShowOnePassLoginGuide(this.$fromSpmid, this.$isStartUpFragment, this.$activity, this.$callback, (Continuation) this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LiveData viewLifecycleOwnerLiveData = this.$fragment.getViewLifecycleOwnerLiveData();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwnerLiveData, "getViewLifecycleOwnerLiveData(...)");
                this.label = 1;
                Object first = FlowKt.first(FlowKt.filterNotNull(FlowLiveDataConversions.asFlow(viewLifecycleOwnerLiveData)), (Continuation) this);
                if (first != coroutine_suspended) {
                    $result = first;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $result), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$fromSpmid, this.$isStartUpFragment, this.$activity, this.$callback, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}