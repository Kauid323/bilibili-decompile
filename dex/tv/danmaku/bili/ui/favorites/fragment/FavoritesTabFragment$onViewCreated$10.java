package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import bili.resource.favorites.R;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import java.util.Map;
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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$10;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageAction;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt;

/* compiled from: FavoritesTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$10", f = "FavoritesTabFragment.kt", i = {}, l = {BR.leftBadgeVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesTabFragment$onViewCreated$10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesTabFragment$onViewCreated$10(FavoritesTabFragment favoritesTabFragment, Continuation<? super FavoritesTabFragment$onViewCreated$10> continuation) {
        super(2, continuation);
        this.this$0 = favoritesTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesTabFragment$onViewCreated$10(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesTabFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$10$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FavoritesTabFragment this$0;

        AnonymousClass1(FavoritesTabFragment favoritesTabFragment) {
            this.this$0 = favoritesTabFragment;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((FavoritesEvent) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
            if (r9 == r2) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00fd, code lost:
            if (r9 == r2) goto L29;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x010d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(FavoritesEvent it, Continuation<? super Unit> continuation) {
            FavoritesTabFragment$onViewCreated$10$1$emit$1 favoritesTabFragment$onViewCreated$10$1$emit$1;
            AnonymousClass1 anonymousClass1;
            boolean z;
            Object showBiliCommonDialog;
            Object showBiliCommonDialog2;
            boolean confirm;
            boolean confirm2;
            if (continuation instanceof FavoritesTabFragment$onViewCreated$10$1$emit$1) {
                favoritesTabFragment$onViewCreated$10$1$emit$1 = (FavoritesTabFragment$onViewCreated$10$1$emit$1) continuation;
                if ((favoritesTabFragment$onViewCreated$10$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    favoritesTabFragment$onViewCreated$10$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = favoritesTabFragment$onViewCreated$10$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (favoritesTabFragment$onViewCreated$10$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            z = false;
                            if (Intrinsics.areEqual(it, FavoritesEvent.ShowDeleteDialog.INSTANCE)) {
                                Context context = anonymousClass1.this$0.getContext();
                                if (context != null) {
                                    FavoritesTabFragment favoritesTabFragment = anonymousClass1.this$0;
                                    int i = R.string.favorites_global_string_169;
                                    int i2 = bili.resource.common.R.string.common_global_string_113;
                                    favoritesTabFragment$onViewCreated$10$1$emit$1.label = 1;
                                    showBiliCommonDialog2 = favoritesTabFragment.showBiliCommonDialog(context, i, i2, favoritesTabFragment$onViewCreated$10$1$emit$1);
                                    break;
                                }
                                confirm = z;
                                if (confirm) {
                                    anonymousClass1.this$0.getViewModel().sendAction(FavoritesAction.DeleteChecked.INSTANCE);
                                    anonymousClass1.this$0.getActivityVM().sendAction(FavoritesPageAction.QuitBatchManage.INSTANCE);
                                    break;
                                }
                            } else if (Intrinsics.areEqual(it, FavoritesEvent.CopyTo.INSTANCE)) {
                                anonymousClass1.this$0.showFavDialog(it);
                                break;
                            } else if (Intrinsics.areEqual(it, FavoritesEvent.MoveTo.INSTANCE)) {
                                anonymousClass1.this$0.showFavDialog(it);
                                break;
                            } else if (it instanceof FavoritesEvent.ShowDeletedToast) {
                                PromoToast.showMidToast(anonymousClass1.this$0.getActivity(), ((FavoritesEvent.ShowDeletedToast) it).getSuccess() ? "删除成功" : "删除失败");
                                break;
                            } else if (it instanceof FavoritesEvent.ClearInvalidVideoResult) {
                                if (((FavoritesEvent.ClearInvalidVideoResult) it).getSuccess()) {
                                    PromoToast.showMidToast(anonymousClass1.this$0.getActivity(), R.string.favorites_global_string_181);
                                    break;
                                }
                            } else if (it instanceof FavoritesEvent.ShowClearAllInvalidVideoDialog) {
                                Context context2 = anonymousClass1.this$0.getContext();
                                if (context2 != null) {
                                    FavoritesTabFragment favoritesTabFragment2 = anonymousClass1.this$0;
                                    int i3 = R.string.favorites_global_string_188;
                                    int i4 = bili.resource.common.R.string.common_global_string_365;
                                    favoritesTabFragment$onViewCreated$10$1$emit$1.label = 2;
                                    showBiliCommonDialog = favoritesTabFragment2.showBiliCommonDialog(context2, i3, i4, favoritesTabFragment$onViewCreated$10$1$emit$1);
                                    break;
                                }
                                confirm2 = z;
                                if (confirm2) {
                                    anonymousClass1.this$0.cleanInvalid();
                                    break;
                                }
                            } else if (it instanceof FavoritesEvent.ScrollToTop) {
                                TintConstraintLayout root = anonymousClass1.this$0.getBinding().getRoot();
                                final FavoritesTabFragment favoritesTabFragment3 = anonymousClass1.this$0;
                                Boxing.boxBoolean(root.post(new Runnable() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$10$1$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        FavoritesTabFragment$onViewCreated$10.AnonymousClass1.emit$lambda$0(FavoritesTabFragment.this);
                                    }
                                }));
                                break;
                            } else if (it instanceof FavoritesEvent.ShowInvalidCardDialog) {
                                anonymousClass1.this$0.showInvalidCardDialog(((FavoritesEvent.ShowInvalidCardDialog) it).getItem());
                                break;
                            } else if (it instanceof FavoritesEvent.RouteTo) {
                                WatchLaterRouterKt.routerTo$default(((FavoritesEvent.RouteTo) it).getLink(), anonymousClass1.this$0.getContext(), (Map) null, 4, (Object) null);
                                break;
                            } else if (it instanceof FavoritesEvent.NotifySwitchTranslate) {
                                anonymousClass1.this$0.getAdapter().notifyItemChanged(((FavoritesEvent.NotifySwitchTranslate) it).getPosition(), "PAYLOADS_UPDATE_TRANSLATE");
                                break;
                            }
                            return coroutine_suspended;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            showBiliCommonDialog2 = $result;
                            z = ((Boolean) showBiliCommonDialog2).booleanValue();
                            confirm = z;
                            if (confirm) {
                            }
                            break;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            showBiliCommonDialog = $result;
                            z = ((Boolean) showBiliCommonDialog).booleanValue();
                            confirm2 = z;
                            if (confirm2) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            favoritesTabFragment$onViewCreated$10$1$emit$1 = new FavoritesTabFragment$onViewCreated$10$1$emit$1(this, continuation);
            Object $result2 = favoritesTabFragment$onViewCreated$10$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (favoritesTabFragment$onViewCreated$10$1$emit$1.label) {
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$0(FavoritesTabFragment this$0) {
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