package tv.danmaku.bili.push.innerpush.v2;

import android.app.Activity;
import com.bilibili.module.main.innerpush.InnerPush;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.v2.InnerPushType;
import tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$2$1$1$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.pendentShowUrl, BR.playCountText, BR.playRecord}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AppInnerPushManagerV2$tryShowInnerPush$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ List<InnerPush> $list;
    final /* synthetic */ String $params;
    final /* synthetic */ String $pvId;
    final /* synthetic */ InnerPushType $type;
    int label;
    final /* synthetic */ AppInnerPushManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInnerPushManagerV2$tryShowInnerPush$2$1$1$1(InnerPushType innerPushType, AppInnerPushManagerV2 appInnerPushManagerV2, Activity activity, List<InnerPush> list, String str, String str2, Continuation<? super AppInnerPushManagerV2$tryShowInnerPush$2$1$1$1> continuation) {
        super(2, continuation);
        this.$type = innerPushType;
        this.this$0 = appInnerPushManagerV2;
        this.$activity = activity;
        this.$list = list;
        this.$pvId = str;
        this.$params = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInnerPushManagerV2$tryShowInnerPush$2$1$1$1(this.$type, this.this$0, this.$activity, this.$list, this.$pvId, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        InnerPushViewShowTaskV2 existTask;
        Object showTask;
        PushTaskQueueManager pushTaskQueueManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$type instanceof InnerPushType.Empty) {
                    return Unit.INSTANCE;
                }
                if ((this.$type instanceof InnerPushType.BizType) && InnerPushLocalStorage.INSTANCE.isShowing(((InnerPushType.BizType) this.$type).getBizType())) {
                    existTask = this.this$0.currentShowingTask;
                    int bizType = existTask != null ? existTask.bizType() : 0;
                    if (existTask != null && Intrinsics.areEqual(String.valueOf(bizType), ((InnerPushType.BizType) this.$type).getBizType())) {
                        this.label = 1;
                        showTask = this.this$0.showTask(this.$activity, this.$type, this.$list, this.$pvId, this.$params, (Continuation) this);
                        if (showTask == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                this.label = 2;
                if (DelayKt.delay(0L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pushTaskQueueManager = this.this$0.taskManager;
                this.label = 3;
                if (pushTaskQueueManager.addTask(this.$type, new AnonymousClass1(this.this$0, this.$activity, this.$type, this.$list, this.$pvId, this.$params, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                pushTaskQueueManager = this.this$0.taskManager;
                this.label = 3;
                if (pushTaskQueueManager.addTask(this.$type, new AnonymousClass1(this.this$0, this.$activity, this.$type, this.$list, this.$pvId, this.$params, null), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppInnerPushManagerV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$2$1$1$1$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.playStateIcon}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$tryShowInnerPush$2$1$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ List<InnerPush> $list;
        final /* synthetic */ String $params;
        final /* synthetic */ String $pvId;
        final /* synthetic */ InnerPushType $type;
        int label;
        final /* synthetic */ AppInnerPushManagerV2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AppInnerPushManagerV2 appInnerPushManagerV2, Activity activity, InnerPushType innerPushType, List<InnerPush> list, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = appInnerPushManagerV2;
            this.$activity = activity;
            this.$type = innerPushType;
            this.$list = list;
            this.$pvId = str;
            this.$params = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$activity, this.$type, this.$list, this.$pvId, this.$params, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object showTask;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    showTask = this.this$0.showTask(this.$activity, this.$type, this.$list, this.$pvId, this.$params, (Continuation) this);
                    if (showTask != coroutine_suspended) {
                        $result = showTask;
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
            boolean result = ((Boolean) $result).booleanValue();
            return Boxing.boxBoolean(result);
        }
    }
}