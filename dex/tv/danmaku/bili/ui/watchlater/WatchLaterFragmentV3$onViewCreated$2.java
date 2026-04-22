package tv.danmaku.bili.ui.watchlater;

import android.content.Context;
import bili.resource.common.R;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.ui.watchlater.data.DialogType;
import tv.danmaku.bili.ui.watchlater.data.ToastType;
import tv.danmaku.bili.ui.watchlater.data.WLEvent;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterFragmentV3.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$onViewCreated$2", f = "WatchLaterFragmentV3.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class WatchLaterFragmentV3$onViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WatchLaterFragmentV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterFragmentV3$onViewCreated$2(WatchLaterFragmentV3 watchLaterFragmentV3, Continuation<? super WatchLaterFragmentV3$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = watchLaterFragmentV3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterFragmentV3$onViewCreated$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WatchLaterFragmentV3.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* renamed from: tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$onViewCreated$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ WatchLaterFragmentV3 this$0;

        AnonymousClass1(WatchLaterFragmentV3 watchLaterFragmentV3) {
            this.this$0 = watchLaterFragmentV3;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((WLEvent) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(WLEvent event, Continuation<? super Unit> continuation) {
            WatchLaterFragmentV3$onViewCreated$2$1$emit$1 watchLaterFragmentV3$onViewCreated$2$1$emit$1;
            AnonymousClass1 anonymousClass1;
            Boolean bool;
            Object showBiliCommonDialog;
            WLEvent event2;
            AnonymousClass1 anonymousClass12;
            Boolean result;
            if (continuation instanceof WatchLaterFragmentV3$onViewCreated$2$1$emit$1) {
                watchLaterFragmentV3$onViewCreated$2$1$emit$1 = (WatchLaterFragmentV3$onViewCreated$2$1$emit$1) continuation;
                if ((watchLaterFragmentV3$onViewCreated$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    watchLaterFragmentV3$onViewCreated$2$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = watchLaterFragmentV3$onViewCreated$2$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (watchLaterFragmentV3$onViewCreated$2$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            if (Intrinsics.areEqual(event, WLEvent.ShowBottomSheet.INSTANCE)) {
                                anonymousClass1.this$0.showBottomSheet();
                                break;
                            } else if (event instanceof WLEvent.ShowDeleteDialog) {
                                Context context = anonymousClass1.this$0.getContext();
                                if (context != null) {
                                    WatchLaterFragmentV3 watchLaterFragmentV3 = anonymousClass1.this$0;
                                    DialogType type = ((WLEvent.ShowDeleteDialog) event).getType();
                                    watchLaterFragmentV3$onViewCreated$2$1$emit$1.L$0 = event;
                                    watchLaterFragmentV3$onViewCreated$2$1$emit$1.label = 1;
                                    showBiliCommonDialog = watchLaterFragmentV3.showBiliCommonDialog(context, type, watchLaterFragmentV3$onViewCreated$2$1$emit$1);
                                    if (showBiliCommonDialog == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    event2 = event;
                                    anonymousClass12 = anonymousClass1;
                                    bool = (Boolean) showBiliCommonDialog;
                                    anonymousClass1 = anonymousClass12;
                                    event = event2;
                                    result = bool;
                                    if (Intrinsics.areEqual(result, Boxing.boxBoolean(true))) {
                                        anonymousClass1.this$0.getViewModel().onDialogConfirm(((WLEvent.ShowDeleteDialog) event).getType());
                                        break;
                                    }
                                } else {
                                    bool = null;
                                    result = bool;
                                    if (Intrinsics.areEqual(result, Boxing.boxBoolean(true))) {
                                    }
                                }
                            } else if (event instanceof WLEvent.ShowToast) {
                                ToastType type2 = ((WLEvent.ShowToast) event).getType();
                                if (Intrinsics.areEqual(type2, ToastType.NetworkError.INSTANCE)) {
                                    PromoToast.showMidToast(anonymousClass1.this$0.getContext(), R.string.common_global_string_16);
                                    break;
                                } else if (Intrinsics.areEqual(type2, ToastType.OperateSuccess.INSTANCE)) {
                                    PromoToast.showMidToast(anonymousClass1.this$0.getContext(), R.string.common_global_string_106);
                                    break;
                                } else if (!Intrinsics.areEqual(type2, ToastType.OperateFailed.INSTANCE)) {
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    PromoToast.showMidToast(anonymousClass1.this$0.getContext(), R.string.common_global_string_90);
                                    break;
                                }
                            } else if (event instanceof WLEvent.ShowDeleteBottomSheet) {
                                anonymousClass1.this$0.showBottomDeleteSheet(((WLEvent.ShowDeleteBottomSheet) event).getAid());
                                break;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            break;
                        case 1:
                            anonymousClass12 = this;
                            event2 = (WLEvent) watchLaterFragmentV3$onViewCreated$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            showBiliCommonDialog = $result;
                            bool = (Boolean) showBiliCommonDialog;
                            anonymousClass1 = anonymousClass12;
                            event = event2;
                            result = bool;
                            if (Intrinsics.areEqual(result, Boxing.boxBoolean(true))) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            watchLaterFragmentV3$onViewCreated$2$1$emit$1 = new WatchLaterFragmentV3$onViewCreated$2$1$emit$1(this, continuation);
            Object $result2 = watchLaterFragmentV3$onViewCreated$2$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (watchLaterFragmentV3$onViewCreated$2$1$emit$1.label) {
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.this$0.getViewModel().getEvent().collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
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
}