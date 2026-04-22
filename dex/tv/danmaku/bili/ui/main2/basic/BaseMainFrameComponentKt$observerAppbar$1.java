package tv.danmaku.bili.ui.main2.basic;

import com.bilibili.lib.homepage.home.model.ToolbarEvent;
import com.bilibili.lib.homepage.splash.BaseMainViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMainFrameComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.basic.BaseMainFrameComponentKt$observerAppbar$1", f = "BaseMainFrameComponent.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BaseMainFrameComponentKt$observerAppbar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseMainFrameFragment $this_observerAppbar;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMainFrameComponentKt$observerAppbar$1(BaseMainFrameFragment baseMainFrameFragment, Continuation<? super BaseMainFrameComponentKt$observerAppbar$1> continuation) {
        super(2, continuation);
        this.$this_observerAppbar = baseMainFrameFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseMainFrameComponentKt$observerAppbar$1(this.$this_observerAppbar, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BaseMainViewModel viewModel = this.$this_observerAppbar.mBaseMainViewModel;
                if (viewModel == null) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (viewModel.getToolbarEvent().collect(new AnonymousClass1(this.$this_observerAppbar), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseMainFrameComponent.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.main2.basic.BaseMainFrameComponentKt$observerAppbar$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ BaseMainFrameFragment $this_observerAppbar;

        AnonymousClass1(BaseMainFrameFragment baseMainFrameFragment) {
            this.$this_observerAppbar = baseMainFrameFragment;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(ToolbarEvent event, Continuation<? super Unit> continuation) {
            BaseMainFrameComponentKt$observerAppbar$1$1$emit$1 baseMainFrameComponentKt$observerAppbar$1$1$emit$1;
            AnonymousClass1 anonymousClass1;
            boolean isToolbarVisible;
            boolean isToolbarVisible2;
            AnonymousClass1 anonymousClass12;
            if (continuation instanceof BaseMainFrameComponentKt$observerAppbar$1$1$emit$1) {
                baseMainFrameComponentKt$observerAppbar$1$1$emit$1 = (BaseMainFrameComponentKt$observerAppbar$1$1$emit$1) continuation;
                if ((baseMainFrameComponentKt$observerAppbar$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    baseMainFrameComponentKt$observerAppbar$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = baseMainFrameComponentKt$observerAppbar$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (baseMainFrameComponentKt$observerAppbar$1$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            BLog.i("[HomeFrame]BaseMainFrameComponent", "observerAppbar, event = " + event);
                            if (event instanceof ToolbarEvent.ExpandToolbar) {
                                BaseMainFrameComponentKt.enableScroll$default(anonymousClass1.$this_observerAppbar, false, 1, null);
                                BaseMainFrameComponentKt.expandToolBar(anonymousClass1.$this_observerAppbar, ((ToolbarEvent.ExpandToolbar) event).getExpand(), ((ToolbarEvent.ExpandToolbar) event).getAnimate());
                                break;
                            } else if (event instanceof ToolbarEvent.EnableScroll) {
                                BaseMainFrameComponentKt.enableScroll(anonymousClass1.$this_observerAppbar, ((ToolbarEvent.EnableScroll) event).getEnable());
                                break;
                            } else if (event instanceof ToolbarEvent.CollapseAndDisableScroll) {
                                isToolbarVisible2 = BaseMainFrameComponentKt.isToolbarVisible(anonymousClass1.$this_observerAppbar);
                                if (isToolbarVisible2 && ((ToolbarEvent.CollapseAndDisableScroll) event).getAnimate()) {
                                    BaseMainFrameComponentKt.enableScroll$default(anonymousClass1.$this_observerAppbar, false, 1, null);
                                    BaseMainFrameComponentKt.expandToolBar(anonymousClass1.$this_observerAppbar, false, true);
                                    baseMainFrameComponentKt$observerAppbar$1$1$emit$1.label = 1;
                                    if (DelayKt.delay(400L, baseMainFrameComponentKt$observerAppbar$1$1$emit$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    anonymousClass12 = anonymousClass1;
                                    anonymousClass1 = anonymousClass12;
                                }
                                BaseMainFrameComponentKt.showToolbar(anonymousClass1.$this_observerAppbar, false);
                                break;
                            } else if (event instanceof ToolbarEvent.ExpandAndEnableScroll) {
                                BaseMainFrameComponentKt.enableScroll$default(anonymousClass1.$this_observerAppbar, false, 1, null);
                                BaseMainFrameComponentKt.expandToolBar(anonymousClass1.$this_observerAppbar, false, false);
                                BaseMainFrameComponentKt.showToolbar(anonymousClass1.$this_observerAppbar, true);
                                BaseMainFrameComponentKt.expandToolBar(anonymousClass1.$this_observerAppbar, true, true);
                                break;
                            } else if (event instanceof ToolbarEvent.CollapseAndEnableScroll) {
                                BaseMainFrameComponentKt.enableScroll$default(anonymousClass1.$this_observerAppbar, false, 1, null);
                                BaseMainFrameComponentKt.expandToolBar(anonymousClass1.$this_observerAppbar, false, ((ToolbarEvent.CollapseAndEnableScroll) event).getAnimate());
                                BaseMainFrameComponentKt.showToolbar(anonymousClass1.$this_observerAppbar, true);
                                break;
                            } else if (!(event instanceof ToolbarEvent.KeepCollapseStateAndResetToScrollable)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                BaseMainFrameComponentKt.enableScroll$default(anonymousClass1.$this_observerAppbar, false, 1, null);
                                isToolbarVisible = BaseMainFrameComponentKt.isToolbarVisible(anonymousClass1.$this_observerAppbar);
                                if (!isToolbarVisible) {
                                    BaseMainFrameComponentKt.expandToolBar(anonymousClass1.$this_observerAppbar, false, false);
                                    BaseMainFrameComponentKt.showToolbar(anonymousClass1.$this_observerAppbar, true);
                                    break;
                                }
                            }
                            break;
                        case 1:
                            anonymousClass12 = this;
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = anonymousClass12;
                            BaseMainFrameComponentKt.showToolbar(anonymousClass1.$this_observerAppbar, false);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            baseMainFrameComponentKt$observerAppbar$1$1$emit$1 = new BaseMainFrameComponentKt$observerAppbar$1$1$emit$1(this, continuation);
            Object $result2 = baseMainFrameComponentKt$observerAppbar$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (baseMainFrameComponentKt$observerAppbar$1$1$emit$1.label) {
            }
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((ToolbarEvent) value, (Continuation<? super Unit>) $completion);
        }
    }
}