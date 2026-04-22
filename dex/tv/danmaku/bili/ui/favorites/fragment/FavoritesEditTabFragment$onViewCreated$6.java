package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppFragmentFavoritesTabBinding;
import tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$6;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;

/* compiled from: FavoritesEditTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$6", f = "FavoritesEditTabFragment.kt", i = {}, l = {BR.isFullscreen}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesEditTabFragment$onViewCreated$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesEditTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesEditTabFragment$onViewCreated$6(FavoritesEditTabFragment favoritesEditTabFragment, Continuation<? super FavoritesEditTabFragment$onViewCreated$6> continuation) {
        super(2, continuation);
        this.this$0 = favoritesEditTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesEditTabFragment$onViewCreated$6(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesEditTabFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$6$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FavoritesEditTabFragment this$0;

        AnonymousClass1(FavoritesEditTabFragment favoritesEditTabFragment) {
            this.this$0 = favoritesEditTabFragment;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((FavoritesEvent) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(FavoritesEvent it, Continuation<? super Unit> continuation) {
            FavoritesEditTabFragment$onViewCreated$6$1$emit$1 favoritesEditTabFragment$onViewCreated$6$1$emit$1;
            AnonymousClass1 anonymousClass1;
            boolean z;
            Object showBiliCommonDialog;
            boolean confirm;
            if (continuation instanceof FavoritesEditTabFragment$onViewCreated$6$1$emit$1) {
                favoritesEditTabFragment$onViewCreated$6$1$emit$1 = (FavoritesEditTabFragment$onViewCreated$6$1$emit$1) continuation;
                if ((favoritesEditTabFragment$onViewCreated$6$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    favoritesEditTabFragment$onViewCreated$6$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = favoritesEditTabFragment$onViewCreated$6$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (favoritesEditTabFragment$onViewCreated$6$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            BLog.d("FavoritesEditTabFragment", "event:" + it);
                            z = false;
                            if (Intrinsics.areEqual(it, FavoritesEvent.ShowDeleteDialog.INSTANCE)) {
                                Context context = anonymousClass1.this$0.getContext();
                                if (context != null) {
                                    FavoritesEditTabFragment favoritesEditTabFragment = anonymousClass1.this$0;
                                    favoritesEditTabFragment$onViewCreated$6$1$emit$1.label = 1;
                                    showBiliCommonDialog = favoritesEditTabFragment.showBiliCommonDialog(context, favoritesEditTabFragment$onViewCreated$6$1$emit$1);
                                    if (showBiliCommonDialog == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    z = ((Boolean) showBiliCommonDialog).booleanValue();
                                }
                                confirm = z;
                                if (confirm) {
                                    anonymousClass1.this$0.getViewModel().sendAction(FavoritesAction.DeleteChecked.INSTANCE);
                                    break;
                                }
                            } else if (Intrinsics.areEqual(it, FavoritesEvent.CopyTo.INSTANCE)) {
                                FavoritesEditTabFragment.showFavDialog$default(anonymousClass1.this$0, it, false, 2, null);
                                break;
                            } else if (Intrinsics.areEqual(it, FavoritesEvent.MoveTo.INSTANCE)) {
                                anonymousClass1.this$0.showFavDialog(it, true);
                                break;
                            } else if (it instanceof FavoritesEvent.ShowDeletedToast) {
                                PromoToast.showMidToast(anonymousClass1.this$0.getActivity(), ((FavoritesEvent.ShowDeletedToast) it).getSuccess() ? "删除成功" : "删除失败");
                                break;
                            } else if (it instanceof FavoritesEvent.ScrollToTop) {
                                TintConstraintLayout root = anonymousClass1.this$0.getBinding().getRoot();
                                final FavoritesEditTabFragment favoritesEditTabFragment2 = anonymousClass1.this$0;
                                Boxing.boxBoolean(root.post(new Runnable() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesEditTabFragment$onViewCreated$6$1$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        FavoritesEditTabFragment$onViewCreated$6.AnonymousClass1.emit$lambda$0(FavoritesEditTabFragment.this);
                                    }
                                }));
                                break;
                            } else if (Intrinsics.areEqual(it, FavoritesEvent.DirectlyBatchManage.INSTANCE)) {
                                anonymousClass1.this$0.getViewModel().sendAction(FavoritesAction.DirectlyBatchManage.INSTANCE);
                                BiliAppFragmentFavoritesTabBinding $this$emit_u24lambda_u241 = anonymousClass1.this$0.getBinding();
                                $this$emit_u24lambda_u241.batchManageContainer.setAlpha(1.0f);
                                ListExtentionsKt.visible($this$emit_u24lambda_u241.batchManageContainer);
                                $this$emit_u24lambda_u241.shadow.setAlpha(0.1f);
                                ListExtentionsKt.visible($this$emit_u24lambda_u241.shadow);
                                break;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            showBiliCommonDialog = $result;
                            z = ((Boolean) showBiliCommonDialog).booleanValue();
                            confirm = z;
                            if (confirm) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            favoritesEditTabFragment$onViewCreated$6$1$emit$1 = new FavoritesEditTabFragment$onViewCreated$6$1$emit$1(this, continuation);
            Object $result2 = favoritesEditTabFragment$onViewCreated$6$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (favoritesEditTabFragment$onViewCreated$6$1$emit$1.label) {
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$0(FavoritesEditTabFragment this$0) {
            this$0.getBinding().recyclerView.scrollToPosition(0);
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.this$0.getViewModel().getUiEventFlow().collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
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