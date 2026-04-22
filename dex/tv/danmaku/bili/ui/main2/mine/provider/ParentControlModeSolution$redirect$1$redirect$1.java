package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.net.Uri;
import bili.resource.homepage.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.core.test.FdDebugActivity;
import tv.danmaku.bili.ui.IntentHelper;
import tv.danmaku.bili.ui.main2.api.AccountApiService;
import tv.danmaku.bili.ui.main2.api.TeenGuardData;

/* compiled from: ParentControlModeSolution.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.provider.ParentControlModeSolution$redirect$1$redirect$1", f = "ParentControlModeSolution.kt", i = {}, l = {BR.badgeUri}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ParentControlModeSolution$redirect$1$redirect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentControlModeSolution$redirect$1$redirect$1(Activity activity, Continuation<? super ParentControlModeSolution$redirect$1$redirect$1> continuation) {
        super(2, continuation);
        this.$context = activity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ParentControlModeSolution$redirect$1$redirect$1(this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BLog.i("ParentControlMode", "Start get redirect url of teen guard");
                    this.label = 1;
                    if (TimeoutKt.withTimeout((long) FdDebugActivity.UPDATE_DELAY_TIME, new AnonymousClass1(this.$context, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            BLog.w("ParentControlMode", "Get url of teen guard failed", e);
            ToastHelper.showToastShort(this.$context, R.string.homepage_global_string_21);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ParentControlModeSolution.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.provider.ParentControlModeSolution$redirect$1$redirect$1$1", f = "ParentControlModeSolution.kt", i = {}, l = {BR.badgeVisibility}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.main2.mine.provider.ParentControlModeSolution$redirect$1$redirect$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = activity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BiliCall<GeneralResponse<TeenGuardData>> teenGuardType = ((AccountApiService) ServiceGenerator.createService(AccountApiService.class)).getTeenGuardType();
                    Intrinsics.checkNotNullExpressionValue(teenGuardType, "getTeenGuardType(...)");
                    this.label = 1;
                    Object data = BiliCallExtKt.getData(teenGuardType, (Continuation) this);
                    if (data != coroutine_suspended) {
                        $result = data;
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
            TeenGuardData guardType = (TeenGuardData) $result;
            Intrinsics.checkNotNull(guardType);
            IntentHelper.intentTo(this.$context, Uri.parse(guardType.requireUrl()));
            Neurons.reportClick(false, "main.teenagerguard.teenager-guard.icon.click", MapsKt.mapOf(TuplesKt.to("relation_type", String.valueOf(guardType.getRelationType()))));
            return Unit.INSTANCE;
        }
    }
}