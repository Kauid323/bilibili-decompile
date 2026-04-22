package tv.danmaku.bili.ui.answer;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleDestroyedException;
import androidx.lifecycle.WithLifecycleStateKt;
import bili.resource.share.R;
import com.bilibili.app.comm.list.widget.dialog.LoadingDialog;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.call.BiliCall;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.answer.AnswerServiceImp;
import tv.danmaku.bili.ui.answer.api.AnswerGuideData;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnswerServiceImp.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.answer.AnswerServiceImp$showLoading$1", f = "AnswerServiceImp.kt", i = {0}, l = {BR.bottomDisplay3}, m = "invokeSuspend", n = {"loading"}, s = {"L$0"}, v = 1)
public final class AnswerServiceImp$showLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BiliCall<GeneralResponse<AnswerGuideData>> $call;
    final /* synthetic */ AnswerServiceImp.AnswerDataCallback $callback;
    final /* synthetic */ FragmentActivity $fragmentActivity;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnswerServiceImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnswerServiceImp$showLoading$1(FragmentActivity fragmentActivity, AnswerServiceImp answerServiceImp, BiliCall<GeneralResponse<AnswerGuideData>> biliCall, AnswerServiceImp.AnswerDataCallback answerDataCallback, Continuation<? super AnswerServiceImp$showLoading$1> continuation) {
        super(2, continuation);
        this.$fragmentActivity = fragmentActivity;
        this.this$0 = answerServiceImp;
        this.$call = biliCall;
        this.$callback = answerDataCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> answerServiceImp$showLoading$1 = new AnswerServiceImp$showLoading$1(this.$fragmentActivity, this.this$0, this.$call, this.$callback, continuation);
        answerServiceImp$showLoading$1.L$0 = obj;
        return answerServiceImp$showLoading$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083 A[Catch: all -> 0x00b1, Exception -> 0x00b5, CancellationException -> 0x00b9, TryCatch #7 {CancellationException -> 0x00b9, Exception -> 0x00b5, all -> 0x00b1, blocks: (B:20:0x007f, B:22:0x0083, B:23:0x0089), top: B:54:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089 A[Catch: all -> 0x00b1, Exception -> 0x00b5, CancellationException -> 0x00b9, TRY_LEAVE, TryCatch #7 {CancellationException -> 0x00b9, Exception -> 0x00b5, all -> 0x00b1, blocks: (B:20:0x007f, B:22:0x0083, B:23:0x0089), top: B:54:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010d  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String str;
        LoadingDialog loading;
        LoadingDialog loading2;
        String str2;
        Object response;
        Object $result2;
        String str3;
        String str4;
        GeneralResponse result;
        String str5;
        String str6;
        LoadingDialog loading3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                    LoadingDialog.Companion companion = LoadingDialog.Companion;
                    String string = this.$fragmentActivity.getString(R.string.share_global_string_2);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    loading = companion.create(string, true, true);
                    try {
                        BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(loading, $this$launch, null), 3, (Object) null);
                        loading.showNow(this.$fragmentActivity.getSupportFragmentManager(), "LoadingDialog");
                        str2 = this.this$0.TAG;
                        BLog.d(str2, "show loading dialog and request ANSWER api.");
                        this.L$0 = loading;
                        this.label = 1;
                        response = BiliCallExtKt.getResponse(this.$call, (Continuation) this);
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        loading2 = loading;
                        str3 = this.this$0.TAG;
                        BLog.d(str3, "request ANSWER api occur error : " + e + FileUtils.HIDDEN_PREFIX);
                        this.$callback.onError(e);
                        if (loading2.isAdded()) {
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        e = th;
                        loading3 = loading;
                        if (loading3.isAdded()) {
                        }
                        throw e;
                    }
                    if (response == loading3) {
                        return loading3;
                    }
                    $result2 = $result;
                    $result = response;
                    try {
                        result = (GeneralResponse) $result;
                        if (result != null) {
                            this.$callback.onError(null);
                        } else {
                            str5 = this.this$0.TAG;
                            BLog.d(str5, "show answer dialog.");
                            this.$callback.onDataSuccess((AnswerGuideData) result.data);
                        }
                        if (loading.isAdded()) {
                            str6 = this.this$0.TAG;
                            BLog.d(str6, "dismiss loading dialog.");
                            loading.dismissAllowingStateLoss();
                        }
                    } catch (CancellationException e3) {
                        throw e3;
                    } catch (Exception e4) {
                        e = e4;
                        $result = $result2;
                        loading2 = loading;
                        str3 = this.this$0.TAG;
                        BLog.d(str3, "request ANSWER api occur error : " + e + FileUtils.HIDDEN_PREFIX);
                        this.$callback.onError(e);
                        if (loading2.isAdded()) {
                            str4 = this.this$0.TAG;
                            BLog.d(str4, "dismiss loading dialog.");
                            loading2.dismissAllowingStateLoss();
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        e = th2;
                        loading3 = loading;
                        if (loading3.isAdded()) {
                            str = this.this$0.TAG;
                            BLog.d(str, "dismiss loading dialog.");
                            loading3.dismissAllowingStateLoss();
                        }
                        throw e;
                    }
                    return Unit.INSTANCE;
                case 1:
                    loading2 = (LoadingDialog) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        loading = loading2;
                        $result2 = $result;
                        result = (GeneralResponse) $result;
                        if (result != null) {
                        }
                        if (loading.isAdded()) {
                        }
                    } catch (CancellationException e5) {
                        throw e5;
                    } catch (Exception e6) {
                        e = e6;
                        str3 = this.this$0.TAG;
                        BLog.d(str3, "request ANSWER api occur error : " + e + FileUtils.HIDDEN_PREFIX);
                        this.$callback.onError(e);
                        if (loading2.isAdded()) {
                        }
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th3) {
            e = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnswerServiceImp.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.answer.AnswerServiceImp$showLoading$1$1", f = "AnswerServiceImp.kt", i = {}, l = {BR.loadingViewVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.answer.AnswerServiceImp$showLoading$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ LoadingDialog $loading;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LoadingDialog loadingDialog, CoroutineScope coroutineScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$loading = loadingDialog;
            this.$$this$launch = coroutineScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$loading, this.$$this$launch, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Lifecycle $this$withStateAtLeastUnchecked$iv$iv = this.$loading.getLifecycle();
                    Intrinsics.checkNotNullExpressionValue($this$withStateAtLeastUnchecked$iv$iv, "<get-lifecycle>(...)");
                    final LoadingDialog loadingDialog = this.$loading;
                    final CoroutineScope coroutineScope = this.$$this$launch;
                    Enum r5 = Lifecycle.State.STARTED;
                    CoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
                    boolean dispatchNeeded$iv$iv = immediate.isDispatchNeeded(getContext());
                    if (!dispatchNeeded$iv$iv) {
                        if ($this$withStateAtLeastUnchecked$iv$iv.getCurrentState() == Lifecycle.State.DESTROYED) {
                            throw new LifecycleDestroyedException();
                        }
                        if ($this$withStateAtLeastUnchecked$iv$iv.getCurrentState().compareTo(r5) >= 0) {
                            Dialog dialog = loadingDialog.getDialog();
                            if (dialog != null) {
                                dialog.setOnDismissListener(new AnswerServiceImp$showLoading$1$1$1$1(coroutineScope));
                            }
                            Unit unit = Unit.INSTANCE;
                            break;
                        }
                    }
                    boolean dispatchNeeded$iv$iv2 = dispatchNeeded$iv$iv;
                    this.label = 1;
                    if (WithLifecycleStateKt.suspendWithStateAtLeastUnchecked($this$withStateAtLeastUnchecked$iv$iv, r5, dispatchNeeded$iv$iv2, immediate, new Function0<Unit>() { // from class: tv.danmaku.bili.ui.answer.AnswerServiceImp$showLoading$1$1$invokeSuspend$$inlined$withStarted$1
                        public final Unit invoke() {
                            Dialog dialog2 = loadingDialog.getDialog();
                            if (dialog2 != null) {
                                dialog2.setOnDismissListener(new AnswerServiceImp$showLoading$1$1$1$1(coroutineScope));
                            }
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = false;
                    break;
                case 1:
                    z = false;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}