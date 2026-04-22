package tv.danmaku.bili.ui.main2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.Lifecycle;
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
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2;
import tv.danmaku.bili.ui.main2.HomeLoginExpKt$checkShowOnePassLoginGuide$1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeLoginExp.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.HomeLoginExpKt$checkShowOnePassLoginGuide$1", f = "HomeLoginExp.kt", i = {}, l = {BR.buttonText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeLoginExpKt$checkShowOnePassLoginGuide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromStartUpFragment;
    final /* synthetic */ Fragment $this_checkShowOnePassLoginGuide;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLoginExpKt$checkShowOnePassLoginGuide$1(Fragment fragment, boolean z, Continuation<? super HomeLoginExpKt$checkShowOnePassLoginGuide$1> continuation) {
        super(2, continuation);
        this.$this_checkShowOnePassLoginGuide = fragment;
        this.$fromStartUpFragment = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeLoginExpKt$checkShowOnePassLoginGuide$1(this.$this_checkShowOnePassLoginGuide, this.$fromStartUpFragment, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeLoginExp.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.main2.HomeLoginExpKt$checkShowOnePassLoginGuide$1$1", f = "HomeLoginExp.kt", i = {}, l = {BR.buttonTextColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.main2.HomeLoginExpKt$checkShowOnePassLoginGuide$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $fromStartUpFragment;
        final /* synthetic */ Fragment $this_checkShowOnePassLoginGuide;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, Fragment fragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$fromStartUpFragment = z;
            this.$this_checkShowOnePassLoginGuide = fragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$fromStartUpFragment, this.$this_checkShowOnePassLoginGuide, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    OnePassLoginGuideHelperV2.Companion companion = OnePassLoginGuideHelperV2.Companion;
                    boolean z = this.$fromStartUpFragment;
                    FragmentActivity activity = this.$this_checkShowOnePassLoginGuide.getActivity();
                    final Fragment fragment = this.$this_checkShowOnePassLoginGuide;
                    this.label = 1;
                    if (companion.startCheckShowOnePassLoginGuide("enter_homepage", z, activity, new Function1() { // from class: tv.danmaku.bili.ui.main2.HomeLoginExpKt$checkShowOnePassLoginGuide$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            boolean invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = HomeLoginExpKt$checkShowOnePassLoginGuide$1.AnonymousClass1.invokeSuspend$lambda$0(fragment, ((Integer) obj).intValue());
                            return Boolean.valueOf(invokeSuspend$lambda$0);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(Fragment $this_checkShowOnePassLoginGuide, int i) {
            Lifecycle lifecycle;
            Lifecycle.State currentState;
            FragmentActivity activity = $this_checkShowOnePassLoginGuide.getActivity();
            if ((activity == null || (lifecycle = activity.getLifecycle()) == null || (currentState = lifecycle.getCurrentState()) == null || !currentState.isAtLeast(Lifecycle.State.CREATED)) ? false : true) {
                HomeLoginExpKt.hasOneLoginShown = true;
                return true;
            }
            BLog.e("[Home]HomeLoginExp", "start endShowOnePassLoginGuide activity die");
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason("enter_homepage", OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
            return false;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LiveData viewLifecycleOwnerLiveData = this.$this_checkShowOnePassLoginGuide.getViewLifecycleOwnerLiveData();
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $result), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$fromStartUpFragment, this.$this_checkShowOnePassLoginGuide, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}