package tv.danmaku.bili.push.innerpush.v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bilibili.module.main.innerpush.InnerPush;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;
import tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$innerShowTask$2$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.subText, BR.teenagers}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AppInnerPushManagerV2$innerShowTask$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ CancellableContinuation<Boolean> $continuation;
    final /* synthetic */ Ref.BooleanRef $hasResume;
    final /* synthetic */ InnerPush $pushItem;
    final /* synthetic */ String $pvId;
    int label;
    final /* synthetic */ AppInnerPushManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppInnerPushManagerV2$innerShowTask$2$1(InnerPush innerPush, AppInnerPushManagerV2 appInnerPushManagerV2, AppCompatActivity appCompatActivity, String str, CancellableContinuation<? super Boolean> cancellableContinuation, Ref.BooleanRef booleanRef, Continuation<? super AppInnerPushManagerV2$innerShowTask$2$1> continuation) {
        super(2, continuation);
        this.$pushItem = innerPush;
        this.this$0 = appInnerPushManagerV2;
        this.$activity = appCompatActivity;
        this.$pvId = str;
        this.$continuation = cancellableContinuation;
        this.$hasResume = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInnerPushManagerV2$innerShowTask$2$1(this.$pushItem, this.this$0, this.$activity, this.$pvId, this.$continuation, this.$hasResume, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        InnerPushViewShowTaskV2 showTask;
        Exception e;
        Function0 function0;
        InnerPushViewShowTaskV2 createShowTask;
        Object createFullCoverShowTask;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e2) {
            e = e2;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!InnerPushExtensionKt.isImageType(this.$pushItem)) {
                    AppInnerPushManagerV2 appInnerPushManagerV2 = this.this$0;
                    ArrayList arrayListOf = CollectionsKt.arrayListOf(new InnerPush[]{this.$pushItem});
                    String str = this.$pvId;
                    final Ref.BooleanRef booleanRef = this.$hasResume;
                    final CancellableContinuation<Boolean> cancellableContinuation = this.$continuation;
                    Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$innerShowTask$2$1$showTask$2
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke(((Number) p1).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int how) {
                            if (!booleanRef.element) {
                                booleanRef.element = true;
                                Result.Companion companion = Result.Companion;
                                cancellableContinuation.resumeWith(Result.constructor-impl(true));
                            }
                        }
                    };
                    function0 = this.this$0.onClickDefault;
                    createShowTask = appInnerPushManagerV2.createShowTask(arrayListOf, str, (r14 & 4) != 0 ? false : false, (r14 & 8) != 0 ? new Function0() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    } : null, (r14 & 16) != 0 ? new Function1() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit createShowTask$lambda$1;
                            createShowTask$lambda$1 = AppInnerPushManagerV2.createShowTask$lambda$1(((Integer) obj).intValue());
                            return createShowTask$lambda$1;
                        }
                    } : function1, function0);
                    $result2 = $result;
                    showTask = createShowTask;
                    if (showTask != null) {
                    }
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, activity state = " + this.$activity.getLifecycle().getCurrentState().name());
                    Result.Companion companion = Result.Companion;
                    this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                    return Unit.INSTANCE;
                }
                AppInnerPushManagerV2 appInnerPushManagerV22 = this.this$0;
                AppCompatActivity appCompatActivity = this.$activity;
                InnerPush innerPush = this.$pushItem;
                String str2 = this.$pvId;
                final Ref.BooleanRef booleanRef2 = this.$hasResume;
                final CancellableContinuation<Boolean> cancellableContinuation2 = this.$continuation;
                this.label = 1;
                createFullCoverShowTask = appInnerPushManagerV22.createFullCoverShowTask(appCompatActivity, innerPush, str2, new Function1<Integer, Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$innerShowTask$2$1$showTask$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke(((Number) p1).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int how) {
                        if (!booleanRef2.element) {
                            booleanRef2.element = true;
                            Result.Companion companion2 = Result.Companion;
                            cancellableContinuation2.resumeWith(Result.constructor-impl(true));
                        }
                    }
                }, (Continuation) this);
                if (createFullCoverShowTask == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = createFullCoverShowTask;
                try {
                    showTask = (InnerPushViewShowTaskV2) $result;
                } catch (Exception e3) {
                    Object obj = $result2;
                    e = e3;
                    $result = obj;
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, create full cover task failed, error = " + e.getMessage());
                    $result2 = $result;
                    showTask = null;
                    if (showTask != null) {
                    }
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, activity state = " + this.$activity.getLifecycle().getCurrentState().name());
                    Result.Companion companion2 = Result.Companion;
                    this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                    return Unit.INSTANCE;
                }
                if (showTask != null || this.$activity.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) {
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, activity state = " + this.$activity.getLifecycle().getCurrentState().name());
                    Result.Companion companion22 = Result.Companion;
                    this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                    return Unit.INSTANCE;
                }
                this.this$0.currentShowingTask = showTask;
                BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, before show");
                try {
                    this.label = 2;
                } catch (Exception e4) {
                    e = e4;
                    Exception exception = e;
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, show exception, error = " + exception.getMessage());
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, after show");
                    return Unit.INSTANCE;
                }
                if (showTask.show(this.$activity, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, after show");
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                showTask = (InnerPushViewShowTaskV2) $result;
                if (showTask != null) {
                }
                BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, activity state = " + this.$activity.getLifecycle().getCurrentState().name());
                Result.Companion companion222 = Result.Companion;
                this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                return Unit.INSTANCE;
            case 2:
                try {
                    ResultKt.throwOnFailure($result);
                } catch (Exception e5) {
                    e = e5;
                    Exception exception2 = e;
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, show exception, error = " + exception2.getMessage());
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, after show");
                    return Unit.INSTANCE;
                }
                BLog.i("[InnerPush]AppInnerPushManagerV2", "tryShowInnerPush, after show");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}