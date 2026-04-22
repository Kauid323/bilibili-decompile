package tv.danmaku.bili.ui.favorites.fragment;

import bili.resource.favorites.R;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$6;
import tv.danmaku.bili.ui.favorites.state.FolderEvent;
import tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel;

/* compiled from: FavoritesFolderTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$6", f = "FavoritesFolderTabFragment.kt", i = {}, l = {BR.gifThumbHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesFolderTabFragment$onViewCreated$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesFolderTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesFolderTabFragment$onViewCreated$6(FavoritesFolderTabFragment favoritesFolderTabFragment, Continuation<? super FavoritesFolderTabFragment$onViewCreated$6> continuation) {
        super(2, continuation);
        this.this$0 = favoritesFolderTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesFolderTabFragment$onViewCreated$6(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesFolderTabFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$6$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FavoritesFolderTabFragment this$0;

        AnonymousClass1(FavoritesFolderTabFragment favoritesFolderTabFragment) {
            this.this$0 = favoritesFolderTabFragment;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((FolderEvent) value, (Continuation<? super Unit>) $completion);
        }

        public final Object emit(FolderEvent it, Continuation<? super Unit> continuation) {
            int textRes;
            if (it instanceof FolderEvent.ShowAddTopToast) {
                if (((FolderEvent.ShowAddTopToast) it).getSuccess()) {
                    textRes = R.string.favorites_global_string_144;
                } else {
                    textRes = R.string.favorites_global_string_116;
                }
                PromoToast.showMidToast(this.this$0.getContext(), textRes);
            } else if (it instanceof FolderEvent.ScrollToTop) {
                TintConstraintLayout root = this.this$0.getBinding().getRoot();
                final FavoritesFolderTabFragment favoritesFolderTabFragment = this.this$0;
                Boxing.boxBoolean(root.post(new Runnable() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$6$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FavoritesFolderTabFragment$onViewCreated$6.AnonymousClass1.emit$lambda$0(FavoritesFolderTabFragment.this);
                    }
                }));
            } else if (!(it instanceof FolderEvent.UpdateLayoutType)) {
                throw new NoWhenBranchMatchedException();
            } else {
                this.this$0.getAdapter().setLayoutType(((FolderEvent.UpdateLayoutType) it).getCompact());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$0(FavoritesFolderTabFragment this$0) {
            this$0.getBinding().recyclerView.scrollToPosition(0);
        }
    }

    public final Object invokeSuspend(Object $result) {
        FolderListViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewModel = this.this$0.getViewModel();
                this.label = 1;
                if (viewModel.getUiEventFlow().collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
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