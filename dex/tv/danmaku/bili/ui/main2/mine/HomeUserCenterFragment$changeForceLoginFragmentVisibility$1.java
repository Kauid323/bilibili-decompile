package tv.danmaku.bili.ui.main2.mine;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.bilibili.ogv.infra.coroutine.FlowsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.ILoginDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$changeForceLoginFragmentVisibility$1", f = "HomeUserCenterFragment.kt", i = {}, l = {BR.rightBottomTextColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeUserCenterFragment$changeForceLoginFragmentVisibility$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromPageSelected;
    final /* synthetic */ boolean $isLogin;
    int label;
    final /* synthetic */ HomeUserCenterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterFragment$changeForceLoginFragmentVisibility$1(HomeUserCenterFragment homeUserCenterFragment, boolean z, boolean z2, Continuation<? super HomeUserCenterFragment$changeForceLoginFragmentVisibility$1> continuation) {
        super(2, continuation);
        this.this$0 = homeUserCenterFragment;
        this.$isLogin = z;
        this.$fromPageSelected = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeUserCenterFragment$changeForceLoginFragmentVisibility$1(this.this$0, this.$isLogin, this.$fromPageSelected, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeUserCenterFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$changeForceLoginFragmentVisibility$1$1", f = "HomeUserCenterFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$changeForceLoginFragmentVisibility$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $fromPageSelected;
        final /* synthetic */ boolean $isLogin;
        int label;
        final /* synthetic */ HomeUserCenterFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, HomeUserCenterFragment homeUserCenterFragment, boolean z2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isLogin = z;
            this.this$0 = homeUserCenterFragment;
            this.$fromPageSelected = z2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isLogin, this.this$0, this.$fromPageSelected, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
            r0 = r2.this$0.mNavigationLoginDispatcher;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean checkRestrictMode;
            ILoginDispatcher iLoginDispatcher;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    if (this.$isLogin) {
                        this.this$0.dismissForceLoginFragment();
                    } else {
                        checkRestrictMode = this.this$0.checkRestrictMode(false);
                        if (!checkRestrictMode) {
                            this.this$0.showForceLoginFragment(this.$fromPageSelected);
                        } else if (this.$fromPageSelected && iLoginDispatcher != null) {
                            iLoginDispatcher.quickLogin();
                        }
                    }
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
                LiveData viewLifecycleOwnerLiveData = this.this$0.getViewLifecycleOwnerLiveData();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwnerLiveData, "getViewLifecycleOwnerLiveData(...)");
                this.label = 1;
                Object firstNotNull = FlowsKt.firstNotNull(FlowLiveDataConversions.asFlow(viewLifecycleOwnerLiveData), (Continuation) this);
                if (firstNotNull != coroutine_suspended) {
                    $result = firstNotNull;
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $result), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$isLogin, this.this$0, this.$fromPageSelected, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}