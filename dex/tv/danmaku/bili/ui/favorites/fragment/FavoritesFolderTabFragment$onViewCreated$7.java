package tv.danmaku.bili.ui.favorites.fragment;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageEvent;
import tv.danmaku.bili.ui.favorites.state.FolderAction;
import tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel;

/* compiled from: FavoritesFolderTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$7", f = "FavoritesFolderTabFragment.kt", i = {}, l = {BR.hasPinMsg}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesFolderTabFragment$onViewCreated$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesFolderTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesFolderTabFragment$onViewCreated$7(FavoritesFolderTabFragment favoritesFolderTabFragment, Continuation<? super FavoritesFolderTabFragment$onViewCreated$7> continuation) {
        super(2, continuation);
        this.this$0 = favoritesFolderTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesFolderTabFragment$onViewCreated$7(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesFolderTabFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$7$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FavoritesFolderTabFragment this$0;

        AnonymousClass1(FavoritesFolderTabFragment favoritesFolderTabFragment) {
            this.this$0 = favoritesFolderTabFragment;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((FavoritesPageEvent) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(FavoritesPageEvent favoritesPageEvent, Continuation<? super Unit> continuation) {
            FavoritesFolderTabFragment$onViewCreated$7$1$emit$1 favoritesFolderTabFragment$onViewCreated$7$1$emit$1;
            FolderListViewModel viewModel;
            AnonymousClass1 anonymousClass1;
            FolderListViewModel viewModel2;
            if (continuation instanceof FavoritesFolderTabFragment$onViewCreated$7$1$emit$1) {
                favoritesFolderTabFragment$onViewCreated$7$1$emit$1 = (FavoritesFolderTabFragment$onViewCreated$7$1$emit$1) continuation;
                if ((favoritesFolderTabFragment$onViewCreated$7$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    favoritesFolderTabFragment$onViewCreated$7$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = favoritesFolderTabFragment$onViewCreated$7$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (favoritesFolderTabFragment$onViewCreated$7$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (Intrinsics.areEqual(favoritesPageEvent, FavoritesPageEvent.ForceRefresh.INSTANCE)) {
                                favoritesFolderTabFragment$onViewCreated$7$1$emit$1.label = 1;
                                if (DelayKt.delay(500L, favoritesFolderTabFragment$onViewCreated$7$1$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                anonymousClass1 = this;
                                viewModel2 = anonymousClass1.this$0.getViewModel();
                                viewModel2.sendAction(new FolderAction.Load(true));
                                break;
                            } else if (favoritesPageEvent instanceof FavoritesPageEvent.SwitchLayoutType) {
                                viewModel = this.this$0.getViewModel();
                                viewModel.sendAction(FolderAction.SwitchLayoutType.INSTANCE);
                                break;
                            }
                            break;
                        case 1:
                            anonymousClass1 = this;
                            ResultKt.throwOnFailure($result);
                            viewModel2 = anonymousClass1.this$0.getViewModel();
                            viewModel2.sendAction(new FolderAction.Load(true));
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            favoritesFolderTabFragment$onViewCreated$7$1$emit$1 = new FavoritesFolderTabFragment$onViewCreated$7$1$emit$1(this, continuation);
            Object $result2 = favoritesFolderTabFragment$onViewCreated$7$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (favoritesFolderTabFragment$onViewCreated$7$1$emit$1.label) {
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
                if (this.this$0.getActivityVM().getUiEventFlow().collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
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