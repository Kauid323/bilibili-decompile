package tv.danmaku.bili.push.innerpush.v2;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bilibili.module.main.innerpush.InnerPush;
import com.bilibili.module.main.innerpush.PushContext;
import com.bilibili.module.main.innerpush.ShowContent;
import com.bilibili.module.main.innerpush.Style;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;
import tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2;
import tv.danmaku.bili.push.innerpush.v2.InnerPushType;
import tv.danmaku.bili.ui.push.v2.manager.InnerPushViewShowTaskV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1", f = "AppInnerPushManagerV2.kt", i = {0, 1, 2, 3}, l = {BR.roomGuestMsgEnjoyChecked, BR.scoreVisible, BR.selectDataList, BR.showFollow}, m = "invokeSuspend", n = {"existTask", "bizMixShow", "task", "task"}, s = {"L$0", "I$0", "L$0", "L$0"}, v = 1)
public final class AppInnerPushManagerV2$bizShowTask$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ CancellableContinuation<Boolean> $continuation;
    final /* synthetic */ Ref.BooleanRef $hasResume;
    final /* synthetic */ List<InnerPush> $pushList;
    final /* synthetic */ String $pvId;
    final /* synthetic */ List<InnerPush> $reverseList;
    final /* synthetic */ AppInnerPushManagerV2.BizPushContent $rule;
    final /* synthetic */ InnerPushType.BizType $type;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ AppInnerPushManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppInnerPushManagerV2$bizShowTask$2$1(InnerPushType.BizType bizType, AppInnerPushManagerV2 appInnerPushManagerV2, CancellableContinuation<? super Boolean> cancellableContinuation, AppInnerPushManagerV2.BizPushContent bizPushContent, List<InnerPush> list, String str, AppCompatActivity appCompatActivity, List<InnerPush> list2, Ref.BooleanRef booleanRef, Continuation<? super AppInnerPushManagerV2$bizShowTask$2$1> continuation) {
        super(2, continuation);
        this.$type = bizType;
        this.this$0 = appInnerPushManagerV2;
        this.$continuation = cancellableContinuation;
        this.$rule = bizPushContent;
        this.$reverseList = list;
        this.$pvId = str;
        this.$activity = appCompatActivity;
        this.$pushList = list2;
        this.$hasResume = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInnerPushManagerV2$bizShowTask$2$1(this.$type, this.this$0, this.$continuation, this.$rule, this.$reverseList, this.$pvId, this.$activity, this.$pushList, this.$hasResume, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int i;
        InnerPushViewShowTaskV2 existTask;
        Object $result2;
        InnerPushViewShowTaskV2 existTask2;
        Map map;
        InnerPushViewShowTaskV2 task;
        Object containerView;
        final View rootView;
        Object $result3;
        InnerPushViewShowTaskV2 task2;
        Map map2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                i = 0;
                if (InnerPushLocalStorage.INSTANCE.isShowing(this.$type.getBizType())) {
                    existTask = this.this$0.currentShowingTask;
                    int bizType = existTask != null ? existTask.bizType() : 0;
                    if (existTask != null && Intrinsics.areEqual(String.valueOf(bizType), this.$type.getBizType())) {
                        final View rootView2 = existTask.getCurrentContainerView();
                        if (rootView2 == null) {
                            BLog.i("[InnerPush]AppInnerPushManagerV2", "bizShowTask, no valid root view");
                            Result.Companion companion = Result.Companion;
                            this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                            return Unit.INSTANCE;
                        }
                        final List<InnerPush> list = this.$reverseList;
                        final InnerPushType.BizType bizType2 = this.$type;
                        PushContext pushContext = new PushContext() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$pushContent$1
                            public List<InnerPush> getMsgList() {
                                return list;
                            }

                            public long getLastShowJobId() {
                                return InnerPushLocalStorage.INSTANCE.getBizInnerPushShowLastJob(bizType2.getBizType());
                            }

                            public Context getViewContext() {
                                Context context = rootView2.getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                                return context;
                            }

                            public void consume(String bizId, List<Long> list2) {
                                Intrinsics.checkNotNullParameter(bizId, "bizId");
                                Intrinsics.checkNotNullParameter(list2, "jobs");
                                AppInnerPushManagerV2.Companion.getInstance().consumeBizPush(bizType2.getBizType(), list2);
                            }
                        };
                        this.L$0 = existTask;
                        this.label = 1;
                        Object onReceive = this.$rule.getReceiver().onReceive(pushContext, (Continuation) this);
                        if (onReceive == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = onReceive;
                        existTask2 = existTask;
                        ShowContent showContent = (ShowContent) $result2;
                        map = this.this$0.bizClickMap;
                        map.put(this.$type.getBizType(), showContent.getOnClick());
                        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(showContent, existTask2, this.$activity, this.$continuation, null), 3, (Object) null);
                        return Unit.INSTANCE;
                    }
                    this.I$0 = 0;
                    this.label = 2;
                    if (DelayKt.delay(InnerPushExtensionKt.getDurationMs((InnerPush) CollectionsKt.first(this.$reverseList)), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                AppInnerPushManagerV2 appInnerPushManagerV2 = this.this$0;
                List<InnerPush> list2 = this.$reverseList;
                String str = this.$pvId;
                boolean z = i == 0;
                final InnerPushType.BizType bizType3 = this.$type;
                final List<InnerPush> list3 = this.$pushList;
                final AppInnerPushManagerV2 appInnerPushManagerV22 = this.this$0;
                final InnerPushType.BizType bizType4 = this.$type;
                final Ref.BooleanRef booleanRef = this.$hasResume;
                final CancellableContinuation<Boolean> cancellableContinuation = this.$continuation;
                final AppInnerPushManagerV2 appInnerPushManagerV23 = this.this$0;
                final InnerPushType.BizType bizType5 = this.$type;
                task = appInnerPushManagerV2.createShowTask(list2, str, z, new Function0<Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$task$1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1259invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m1259invoke() {
                        BLog.i("[InnerPush]AppInnerPushManagerV2", "bizShowTask, onShow");
                        InnerPushLocalStorage.INSTANCE.setBizInnerPushShowLastJob(InnerPushType.BizType.this.getBizType(), ((InnerPush) CollectionsKt.last(list3)).getJob());
                    }
                }, new Function1<Integer, Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$task$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke(((Number) p1).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int how) {
                        Map map3;
                        map3 = AppInnerPushManagerV2.this.bizClickMap;
                        map3.remove(bizType4.getBizType());
                        if (!booleanRef.element) {
                            booleanRef.element = true;
                            BLog.i("[InnerPush]AppInnerPushManagerV2", "bizShowTask, onDismiss");
                            Result.Companion companion2 = Result.Companion;
                            cancellableContinuation.resumeWith(Result.constructor-impl(true));
                        }
                    }
                }, new Function0<Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$task$3
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1260invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m1260invoke() {
                        Map map3;
                        map3 = AppInnerPushManagerV2.this.bizClickMap;
                        Function0 function0 = (Function0) map3.get(bizType5.getBizType());
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }
                });
                this.this$0.currentShowingTask = task;
                this.L$0 = task;
                this.label = 3;
                containerView = task.getContainerView(this.$activity, (Continuation) this);
                if (containerView == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rootView = (View) containerView;
                if (rootView == null) {
                    BLog.i("[InnerPush]AppInnerPushManagerV2", "bizShowTask, no valid root view");
                    Result.Companion companion2 = Result.Companion;
                    this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                    return Unit.INSTANCE;
                }
                final List<InnerPush> list4 = this.$reverseList;
                final InnerPushType.BizType bizType6 = this.$type;
                PushContext pushContext2 = new PushContext() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$pushContent$2
                    public List<InnerPush> getMsgList() {
                        return list4;
                    }

                    public long getLastShowJobId() {
                        return InnerPushLocalStorage.INSTANCE.getBizInnerPushShowLastJob(bizType6.getBizType());
                    }

                    public Context getViewContext() {
                        Context context = rootView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        return context;
                    }

                    public void consume(String bizId, List<Long> list5) {
                        Intrinsics.checkNotNullParameter(bizId, "bizId");
                        Intrinsics.checkNotNullParameter(list5, "jobs");
                        AppInnerPushManagerV2.Companion.getInstance().consumeBizPush(bizType6.getBizType(), list5);
                    }
                };
                this.L$0 = task;
                this.label = 4;
                Object onReceive2 = this.$rule.getReceiver().onReceive(pushContext2, (Continuation) this);
                if (onReceive2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result3 = onReceive2;
                task2 = task;
                ShowContent showContent2 = (ShowContent) $result3;
                map2 = this.this$0.bizClickMap;
                map2.put(this.$type.getBizType(), showContent2.getOnClick());
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(showContent2, task2, this.$activity, this.$continuation, this.this$0, this.$pvId, this.$reverseList, null), 3, (Object) null);
                return Unit.INSTANCE;
            case 1:
                $result2 = $result;
                ResultKt.throwOnFailure($result2);
                existTask2 = (InnerPushViewShowTaskV2) this.L$0;
                ShowContent showContent3 = (ShowContent) $result2;
                map = this.this$0.bizClickMap;
                map.put(this.$type.getBizType(), showContent3.getOnClick());
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(showContent3, existTask2, this.$activity, this.$continuation, null), 3, (Object) null);
                return Unit.INSTANCE;
            case 2:
                i = this.I$0;
                ResultKt.throwOnFailure($result);
                AppInnerPushManagerV2 appInnerPushManagerV24 = this.this$0;
                List<InnerPush> list22 = this.$reverseList;
                String str2 = this.$pvId;
                if (i == 0) {
                }
                final InnerPushType.BizType bizType32 = this.$type;
                final List<InnerPush> list32 = this.$pushList;
                final AppInnerPushManagerV2 appInnerPushManagerV222 = this.this$0;
                final InnerPushType.BizType bizType42 = this.$type;
                final Ref.BooleanRef booleanRef2 = this.$hasResume;
                final CancellableContinuation<? super Boolean> cancellableContinuation2 = this.$continuation;
                final AppInnerPushManagerV2 appInnerPushManagerV232 = this.this$0;
                final InnerPushType.BizType bizType52 = this.$type;
                task = appInnerPushManagerV24.createShowTask(list22, str2, z, new Function0<Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$task$1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1259invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m1259invoke() {
                        BLog.i("[InnerPush]AppInnerPushManagerV2", "bizShowTask, onShow");
                        InnerPushLocalStorage.INSTANCE.setBizInnerPushShowLastJob(InnerPushType.BizType.this.getBizType(), ((InnerPush) CollectionsKt.last(list32)).getJob());
                    }
                }, new Function1<Integer, Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$task$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke(((Number) p1).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int how) {
                        Map map3;
                        map3 = AppInnerPushManagerV2.this.bizClickMap;
                        map3.remove(bizType42.getBizType());
                        if (!booleanRef2.element) {
                            booleanRef2.element = true;
                            BLog.i("[InnerPush]AppInnerPushManagerV2", "bizShowTask, onDismiss");
                            Result.Companion companion22 = Result.Companion;
                            cancellableContinuation2.resumeWith(Result.constructor-impl(true));
                        }
                    }
                }, new Function0<Unit>() { // from class: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$task$3
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1260invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m1260invoke() {
                        Map map3;
                        map3 = AppInnerPushManagerV2.this.bizClickMap;
                        Function0 function0 = (Function0) map3.get(bizType52.getBizType());
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }
                });
                this.this$0.currentShowingTask = task;
                this.L$0 = task;
                this.label = 3;
                containerView = task.getContainerView(this.$activity, (Continuation) this);
                if (containerView == coroutine_suspended) {
                }
                rootView = (View) containerView;
                if (rootView == null) {
                }
                break;
            case 3:
                task = (InnerPushViewShowTaskV2) this.L$0;
                ResultKt.throwOnFailure($result);
                containerView = $result;
                rootView = (View) containerView;
                if (rootView == null) {
                }
                break;
            case 4:
                $result3 = $result;
                ResultKt.throwOnFailure($result3);
                task2 = (InnerPushViewShowTaskV2) this.L$0;
                ShowContent showContent22 = (ShowContent) $result3;
                map2 = this.this$0.bizClickMap;
                map2.put(this.$type.getBizType(), showContent22.getOnClick());
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(showContent22, task2, this.$activity, this.$continuation, this.this$0, this.$pvId, this.$reverseList, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppInnerPushManagerV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.rootViewHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatActivity $activity;
        final /* synthetic */ CancellableContinuation<Boolean> $continuation;
        final /* synthetic */ InnerPushViewShowTaskV2 $existTask;
        final /* synthetic */ ShowContent $showContent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ShowContent showContent, InnerPushViewShowTaskV2 innerPushViewShowTaskV2, AppCompatActivity appCompatActivity, CancellableContinuation<? super Boolean> cancellableContinuation, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$showContent = showContent;
            this.$existTask = innerPushViewShowTaskV2;
            this.$activity = appCompatActivity;
            this.$continuation = cancellableContinuation;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$showContent, this.$existTask, this.$activity, this.$continuation, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$showContent.getView() != null) {
                        this.label = 1;
                        if (this.$existTask.replaceBizView(this.$activity, this.$showContent.getView(), this.$showContent.getReportExtra(), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Result.Companion companion = Result.Companion;
                        this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
                        break;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    Result.Companion companion2 = Result.Companion;
                    this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppInnerPushManagerV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$2", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.showMore, BR.showShortUpInfo}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$bizShowTask$2$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatActivity $activity;
        final /* synthetic */ CancellableContinuation<Boolean> $continuation;
        final /* synthetic */ String $pvId;
        final /* synthetic */ List<InnerPush> $reverseList;
        final /* synthetic */ ShowContent $showContent;
        final /* synthetic */ InnerPushViewShowTaskV2 $task;
        int label;
        final /* synthetic */ AppInnerPushManagerV2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(ShowContent showContent, InnerPushViewShowTaskV2 innerPushViewShowTaskV2, AppCompatActivity appCompatActivity, CancellableContinuation<? super Boolean> cancellableContinuation, AppInnerPushManagerV2 appInnerPushManagerV2, String str, List<InnerPush> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$showContent = showContent;
            this.$task = innerPushViewShowTaskV2;
            this.$activity = appCompatActivity;
            this.$continuation = cancellableContinuation;
            this.this$0 = appInnerPushManagerV2;
            this.$pvId = str;
            this.$reverseList = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$showContent, this.$task, this.$activity, this.$continuation, this.this$0, this.$pvId, this.$reverseList, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Object showViewDefault;
            Object $result2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$showContent.getView() != null) {
                        InnerPushViewShowTaskV2 innerPushViewShowTaskV2 = this.$task;
                        AppCompatActivity appCompatActivity = this.$activity;
                        View view = this.$showContent.getView();
                        Intrinsics.checkNotNull(view);
                        this.label = 1;
                        if (innerPushViewShowTaskV2.showBizView(appCompatActivity, view, this.$showContent.getReportExtra(), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (!Intrinsics.areEqual(this.$showContent.getStyle(), Style.Custom.INSTANCE)) {
                        this.label = 2;
                        showViewDefault = this.this$0.showViewDefault(this.$activity, this.$pvId, this.$showContent.getStyle(), this.$reverseList, (Continuation) this);
                        if (showViewDefault == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result = showViewDefault;
                        boolean result = ((Boolean) $result).booleanValue();
                        Continuation continuation = this.$continuation;
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(result)));
                        Unit unit = Unit.INSTANCE;
                        break;
                    } else {
                        Result.Companion companion2 = Result.Companion;
                        this.$continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                        return Unit.INSTANCE;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    $result2 = $result;
                    boolean result2 = ((Boolean) $result).booleanValue();
                    Continuation continuation2 = this.$continuation;
                    Result.Companion companion3 = Result.Companion;
                    continuation2.resumeWith(Result.constructor-impl(Boxing.boxBoolean(result2)));
                    Unit unit2 = Unit.INSTANCE;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}