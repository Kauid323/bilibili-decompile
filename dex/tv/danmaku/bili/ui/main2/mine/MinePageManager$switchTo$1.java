package tv.danmaku.bili.ui.main2.mine;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MinePageManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1", f = "MinePageManager.kt", i = {0, 1, 2}, l = {BR.buttonWidths, BR.changeEpBtnVisible, BR.chatPlayerInputHint}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0"}, v = 1)
public final class MinePageManager$switchTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMineMenuItemRedirection $redirection;
    final /* synthetic */ MinePage $targetPage;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MinePageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MinePageManager$switchTo$1(MinePageManager minePageManager, IMineMenuItemRedirection iMineMenuItemRedirection, MinePage minePage, Continuation<? super MinePageManager$switchTo$1> continuation) {
        super(2, continuation);
        this.this$0 = minePageManager;
        this.$redirection = iMineMenuItemRedirection;
        this.$targetPage = minePage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> minePageManager$switchTo$1 = new MinePageManager$switchTo$1(this.this$0, this.$redirection, this.$targetPage, continuation);
        minePageManager$switchTo$1.L$0 = obj;
        return minePageManager$switchTo$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$launch;
        Context context;
        Activity activity;
        FragmentActivity fragmentActivity;
        final String promptScene;
        Context context2;
        FragmentActivity fragmentActivity2;
        final Flow $this$filter$iv;
        FragmentActivity fragmentActivity3;
        final Flow $this$filter$iv2;
        CoroutineScope $this$launch2;
        Context context3;
        Activity activity2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$launch = (CoroutineScope) this.L$0;
                context = this.this$0.activity;
                if (BiliAccounts.get(context).isLogin() || !this.$redirection.isNeedLoginBeforeRedirect(this.$targetPage.mMenuItem)) {
                    IMineMenuItemRedirection iMineMenuItemRedirection = this.$redirection;
                    activity = this.this$0.activity;
                    iMineMenuItemRedirection.redirect(activity, this.$targetPage.mMenuItem);
                    return Unit.INSTANCE;
                }
                fragmentActivity = this.this$0.activity;
                final Flow $this$filter$iv3 = fragmentActivity.getLifecycle().getCurrentStateFlow();
                this.L$0 = $this$launch;
                this.label = 1;
                if (FlowKt.first(new Flow<Lifecycle.State>() { // from class: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$1

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                        @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$1$2", f = "MinePageManager.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                        /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
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
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            Lifecycle.State it = (Lifecycle.State) value;
                                            Lifecycle.State it2 = it == Lifecycle.State.RESUMED ? 1 : null;
                                            if (it2 != null) {
                                                $continuation.label = 1;
                                                if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
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
                            $continuation = new AnonymousClass1($completion);
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv3.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                MinePageManager minePageManager = this.this$0;
                String str = this.$targetPage.mUrl;
                Intrinsics.checkNotNullExpressionValue(str, "mUrl");
                promptScene = minePageManager.getPromptSceneFromUrl(str);
                RouteRequest build = new RouteRequest.Builder("bilibili://login").extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = MinePageManager$switchTo$1.invokeSuspend$lambda$1(promptScene, (MutableBundleLike) obj);
                        return invokeSuspend$lambda$1;
                    }
                }).build();
                context2 = this.this$0.activity;
                BLRouter.routeTo(build, context2);
                fragmentActivity2 = this.this$0.activity;
                $this$filter$iv = fragmentActivity2.getLifecycle().getCurrentStateFlow();
                this.L$0 = $this$launch;
                this.label = 2;
                if (FlowKt.first(new Flow<Lifecycle.State>() { // from class: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$2

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$2$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                        @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$2$2", f = "MinePageManager.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                        /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$2$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
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
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            Lifecycle.State it = (Lifecycle.State) value;
                                            Lifecycle.State it2 = it.compareTo(Lifecycle.State.RESUMED) < 0 ? 1 : null;
                                            if (it2 != null) {
                                                $continuation.label = 1;
                                                if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
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
                            $continuation = new AnonymousClass1($completion);
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fragmentActivity3 = this.this$0.activity;
                $this$filter$iv2 = fragmentActivity3.getLifecycle().getCurrentStateFlow();
                this.L$0 = $this$launch;
                this.label = 3;
                if (FlowKt.first(new Flow<Lifecycle.State>() { // from class: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                        @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2", f = "MinePageManager.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                        /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
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
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            Lifecycle.State it = (Lifecycle.State) value;
                                            Lifecycle.State it2 = it == Lifecycle.State.RESUMED ? 1 : null;
                                            if (it2 != null) {
                                                $continuation.label = 1;
                                                if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
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
                            $continuation = new AnonymousClass1($completion);
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv2.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$launch2 = $this$launch;
                CoroutineScopeKt.ensureActive($this$launch2);
                context3 = this.this$0.activity;
                if (BiliAccounts.get(context3).isLogin()) {
                    IMineMenuItemRedirection iMineMenuItemRedirection2 = this.$redirection;
                    activity2 = this.this$0.activity;
                    iMineMenuItemRedirection2.redirect(activity2, this.$targetPage.mMenuItem);
                }
                return Unit.INSTANCE;
            case 1:
                $this$launch = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                MinePageManager minePageManager2 = this.this$0;
                String str2 = this.$targetPage.mUrl;
                Intrinsics.checkNotNullExpressionValue(str2, "mUrl");
                promptScene = minePageManager2.getPromptSceneFromUrl(str2);
                RouteRequest build2 = new RouteRequest.Builder("bilibili://login").extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = MinePageManager$switchTo$1.invokeSuspend$lambda$1(promptScene, (MutableBundleLike) obj);
                        return invokeSuspend$lambda$1;
                    }
                }).build();
                context2 = this.this$0.activity;
                BLRouter.routeTo(build2, context2);
                fragmentActivity2 = this.this$0.activity;
                $this$filter$iv = fragmentActivity2.getLifecycle().getCurrentStateFlow();
                this.L$0 = $this$launch;
                this.label = 2;
                if (FlowKt.first(new Flow<Lifecycle.State>() { // from class: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$2

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$2$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                        @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$2$2", f = "MinePageManager.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                        /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$2$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            if ($completion instanceof AnonymousClass1) {
                                $continuation = (AnonymousClass1) $completion;
                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                    $continuation.label -= Integer.MIN_VALUE;
                                    Object $result2 = $continuation.result;
                                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result2);
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            Lifecycle.State it = (Lifecycle.State) value;
                                            Lifecycle.State it2 = it.compareTo(Lifecycle.State.RESUMED) < 0 ? 1 : null;
                                            if (it2 != null) {
                                                $continuation.label = 1;
                                                if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended2) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended2;
                                                }
                                            }
                                            break;
                                        case 1:
                                            ResultKt.throwOnFailure($result2);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            $continuation = new AnonymousClass1($completion);
                            Object $result22 = $continuation.result;
                            Object coroutine_suspended22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                }
                fragmentActivity3 = this.this$0.activity;
                $this$filter$iv2 = fragmentActivity3.getLifecycle().getCurrentStateFlow();
                this.L$0 = $this$launch;
                this.label = 3;
                if (FlowKt.first(new Flow<Lifecycle.State>() { // from class: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                        @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2", f = "MinePageManager.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                        /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            if ($completion instanceof AnonymousClass1) {
                                $continuation = (AnonymousClass1) $completion;
                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                    $continuation.label -= Integer.MIN_VALUE;
                                    Object $result2 = $continuation.result;
                                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result2);
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            Lifecycle.State it = (Lifecycle.State) value;
                                            Lifecycle.State it2 = it == Lifecycle.State.RESUMED ? 1 : null;
                                            if (it2 != null) {
                                                $continuation.label = 1;
                                                if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended2) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended2;
                                                }
                                            }
                                            break;
                                        case 1:
                                            ResultKt.throwOnFailure($result2);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            $continuation = new AnonymousClass1($completion);
                            Object $result22 = $continuation.result;
                            Object coroutine_suspended22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv2.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                }
                break;
            case 2:
                $this$launch = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                fragmentActivity3 = this.this$0.activity;
                $this$filter$iv2 = fragmentActivity3.getLifecycle().getCurrentStateFlow();
                this.L$0 = $this$launch;
                this.label = 3;
                if (FlowKt.first(new Flow<Lifecycle.State>() { // from class: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                    /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
                        @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2", f = "MinePageManager.kt", i = {}, l = {BR.followButtonConfig}, m = "emit", n = {}, s = {}, v = 1)
                        /* renamed from: tv.danmaku.bili.ui.main2.mine.MinePageManager$switchTo$1$invokeSuspend$$inlined$filter$3$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
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
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            if ($completion instanceof AnonymousClass1) {
                                $continuation = (AnonymousClass1) $completion;
                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                    $continuation.label -= Integer.MIN_VALUE;
                                    Object $result22 = $continuation.result;
                                    Object coroutine_suspended22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result22);
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            Lifecycle.State it = (Lifecycle.State) value;
                                            Lifecycle.State it2 = it == Lifecycle.State.RESUMED ? 1 : null;
                                            if (it2 != null) {
                                                $continuation.label = 1;
                                                if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended22) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended22;
                                                }
                                            }
                                            break;
                                        case 1:
                                            ResultKt.throwOnFailure($result22);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            $continuation = new AnonymousClass1($completion);
                            Object $result222 = $continuation.result;
                            Object coroutine_suspended222 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv2.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                }
                break;
            case 3:
                $this$launch2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                CoroutineScopeKt.ensureActive($this$launch2);
                context3 = this.this$0.activity;
                if (BiliAccounts.get(context3).isLogin()) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(String $promptScene, MutableBundleLike $this$extras) {
        boolean z = false;
        if ($promptScene != null && (!StringsKt.isBlank($promptScene))) {
            z = true;
        }
        if (z) {
            $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, $promptScene);
        }
        return Unit.INSTANCE;
    }
}