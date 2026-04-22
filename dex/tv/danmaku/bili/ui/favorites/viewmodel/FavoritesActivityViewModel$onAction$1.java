package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesActivityViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1", f = "FavoritesActivityViewModel.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FavoritesActivityViewModel$onAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FavoritesPageAction $action;
    int label;
    final /* synthetic */ FavoritesActivityViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesActivityViewModel$onAction$1(FavoritesPageAction favoritesPageAction, FavoritesActivityViewModel favoritesActivityViewModel, Continuation<? super FavoritesActivityViewModel$onAction$1> continuation) {
        super(2, continuation);
        this.$action = favoritesPageAction;
        this.this$0 = favoritesActivityViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesActivityViewModel$onAction$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object requestCollectionTabs;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FavoritesPageAction favoritesPageAction = this.$action;
                if (Intrinsics.areEqual(favoritesPageAction, FavoritesPageAction.StartBatchManage.INSTANCE)) {
                    this.this$0.sendEffect(new AnonymousClass1(null));
                    break;
                } else if (Intrinsics.areEqual(favoritesPageAction, FavoritesPageAction.QuitBatchManage.INSTANCE)) {
                    this.this$0.sendEffect(new AnonymousClass2(null));
                    break;
                } else if (favoritesPageAction instanceof FavoritesPageAction.ShowFavTab) {
                    switch (((FavoritesPageAction.ShowFavTab) this.$action).getType()) {
                        case 103:
                            this.this$0.sendEffect(new AnonymousClass6(null));
                            this.this$0.sendEffect(new AnonymousClass7(null));
                            this.this$0.sendEffect(new AnonymousClass8(null));
                            break;
                        case 120:
                            this.this$0.sendEffect(new AnonymousClass3(null));
                            this.this$0.sendEffect(new AnonymousClass4(null));
                            this.this$0.sendEffect(new AnonymousClass5(null));
                            break;
                        default:
                            this.this$0.sendEffect(new AnonymousClass9(null));
                            this.this$0.sendEffect(new AnonymousClass10(null));
                            this.this$0.sendEffect(new AnonymousClass11(null));
                            break;
                    }
                } else if (Intrinsics.areEqual(favoritesPageAction, FavoritesPageAction.ShowFolderTab.INSTANCE)) {
                    this.this$0.sendEffect(new AnonymousClass12(null));
                    this.this$0.sendEffect(new AnonymousClass13(null));
                    this.this$0.sendEffect(new AnonymousClass14(null));
                    break;
                } else if (favoritesPageAction instanceof FavoritesPageAction.GetTabData) {
                    this.label = 1;
                    requestCollectionTabs = this.this$0.requestCollectionTabs(((FavoritesPageAction.GetTabData) this.$action).getDefaultTabId(), (Continuation) this);
                    if (requestCollectionTabs == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Unit unit = Unit.INSTANCE;
                    break;
                } else if (Intrinsics.areEqual(favoritesPageAction, FavoritesPageAction.ForceRefresh.INSTANCE)) {
                    this.this$0.sendEffect(new AnonymousClass15(null));
                    break;
                } else if (!Intrinsics.areEqual(favoritesPageAction, FavoritesPageAction.SwitchLayoutType.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    this.this$0.sendEffect(new AnonymousClass16(null));
                    break;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                Unit unit2 = Unit.INSTANCE;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$1", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return FavoritesPageEvent.StartBatchManage.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$2", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return FavoritesPageEvent.QuitBatchManage.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$3", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return FavoritesPageEvent.HideRightIcon.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$4", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$4  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass4(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FavoritesPageEvent.SetSearchIcon(false);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$5", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$5  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass5(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FavoritesPageEvent.ShowCompactIcon(false);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$6", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$6  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass6(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return FavoritesPageEvent.ShowBatchManageIcon.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$7", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$7  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass7 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass7(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FavoritesPageEvent.SetSearchIcon(false);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$8", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$8  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass8 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass8(Continuation<? super AnonymousClass8> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass8(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FavoritesPageEvent.ShowCompactIcon(false);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$9", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$9  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass9 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass9(Continuation<? super AnonymousClass9> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass9(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return FavoritesPageEvent.ShowBatchManageIcon.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$10", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$10  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass10 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass10(Continuation<? super AnonymousClass10> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass10(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FavoritesPageEvent.SetSearchIcon(true);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$11", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$11  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass11 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass11(Continuation<? super AnonymousClass11> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass11(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FavoritesPageEvent.ShowCompactIcon(false);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$12", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$12  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass12 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass12(Continuation<? super AnonymousClass12> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass12(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return FavoritesPageEvent.ShowAddFolderIcon.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$13", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$13  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass13 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass13(Continuation<? super AnonymousClass13> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass13(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FavoritesPageEvent.SetSearchIcon(true);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$14", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$14  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass14 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass14(Continuation<? super AnonymousClass14> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass14(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FavoritesPageEvent.ShowCompactIcon(true);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$15", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$15  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass15 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass15(Continuation<? super AnonymousClass15> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass15(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return FavoritesPageEvent.ForceRefresh.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$16", f = "FavoritesActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$onAction$1$16  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass16 extends SuspendLambda implements Function1<Continuation<? super FavoritesPageEvent>, Object> {
        int label;

        AnonymousClass16(Continuation<? super AnonymousClass16> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass16(continuation);
        }

        public final Object invoke(Continuation<? super FavoritesPageEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return FavoritesPageEvent.SwitchLayoutType.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}