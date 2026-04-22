package tv.danmaku.bili.ui.favorites.viewmodel;

import com.bilibili.playset.playlist.entity.SortRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesEditListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1", f = "FavoritesEditListViewModel.kt", i = {}, l = {BR.eventHandle, BR.follow, BR.followClickable, BR.followIconDrawable, BR.followText, BR.gifThumbHeight, BR.guest, BR.guideBarPaddingBottom}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FavoritesEditListViewModel$onAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FavoritesAction $action;
    int label;
    final /* synthetic */ FavoritesEditListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesEditListViewModel$onAction$1(FavoritesAction favoritesAction, FavoritesEditListViewModel favoritesEditListViewModel, Continuation<? super FavoritesEditListViewModel$onAction$1> continuation) {
        super(2, continuation);
        this.$action = favoritesAction;
        this.this$0 = favoritesEditListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesEditListViewModel$onAction$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object favorites;
        long j;
        Iterable iterable;
        SortRecord it;
        List list;
        Object sortMedias;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FavoritesAction favoritesAction = this.$action;
                if (!Intrinsics.areEqual(favoritesAction, FavoritesAction.StartBatchManage.INSTANCE) && !Intrinsics.areEqual(favoritesAction, FavoritesAction.DirectlyBatchManage.INSTANCE)) {
                    if (Intrinsics.areEqual(favoritesAction, FavoritesAction.QuitBatchManage.INSTANCE)) {
                        this.this$0.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                FavTabState invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$1((FavTabState) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                        break;
                    } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.CheckAll.INSTANCE)) {
                        FavoritesEditListViewModel favoritesEditListViewModel = this.this$0;
                        final FavoritesEditListViewModel favoritesEditListViewModel2 = this.this$0;
                        favoritesEditListViewModel.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                FavTabState invokeSuspend$lambda$2;
                                invokeSuspend$lambda$2 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$2(FavoritesEditListViewModel.this, (FavTabState) obj);
                                return invokeSuspend$lambda$2;
                            }
                        });
                        break;
                    } else if (favoritesAction instanceof FavoritesAction.CheckItem) {
                        FavoritesEditListViewModel favoritesEditListViewModel3 = this.this$0;
                        final FavoritesEditListViewModel favoritesEditListViewModel4 = this.this$0;
                        final FavoritesAction favoritesAction2 = this.$action;
                        favoritesEditListViewModel3.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj) {
                                FavTabState invokeSuspend$lambda$3;
                                invokeSuspend$lambda$3 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$3(FavoritesEditListViewModel.this, favoritesAction2, (FavTabState) obj);
                                return invokeSuspend$lambda$3;
                            }
                        });
                        break;
                    } else if (!(favoritesAction instanceof FavoritesAction.ClickItem)) {
                        boolean z = true;
                        if (favoritesAction instanceof FavoritesAction.DeleteItem) {
                            FavoritesEditListViewModel favoritesEditListViewModel5 = this.this$0;
                            long oid = ((FavoritesAction.DeleteItem) this.$action).getItem().getOid();
                            int otype = ((FavoritesAction.DeleteItem) this.$action).getItem().getOtype();
                            this.label = 1;
                            if (BaseFavoritesViewModel.deleteItems$default(favoritesEditListViewModel5, oid + ":" + otype, null, (Continuation) this, 2, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            FavoritesEditListViewModel favoritesEditListViewModel6 = this.this$0;
                            final FavoritesEditListViewModel favoritesEditListViewModel7 = this.this$0;
                            final FavoritesAction favoritesAction3 = this.$action;
                            favoritesEditListViewModel6.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    FavTabState invokeSuspend$lambda$4;
                                    invokeSuspend$lambda$4 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$4(FavoritesEditListViewModel.this, favoritesAction3, (FavTabState) obj);
                                    return invokeSuspend$lambda$4;
                                }
                            });
                            break;
                        } else if (favoritesAction instanceof FavoritesAction.SortedUpdate) {
                            FavoritesEditListViewModel favoritesEditListViewModel8 = this.this$0;
                            final FavoritesAction favoritesAction4 = this.$action;
                            favoritesEditListViewModel8.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj) {
                                    FavTabState invokeSuspend$lambda$5;
                                    invokeSuspend$lambda$5 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$5(FavoritesAction.this, (FavTabState) obj);
                                    return invokeSuspend$lambda$5;
                                }
                            });
                            break;
                        } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.ClickDelete.INSTANCE)) {
                            this.label = 2;
                            if (this.this$0.sendEffect(FavoritesEvent.ShowDeleteDialog.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.CopyTo.INSTANCE)) {
                            this.label = 3;
                            if (this.this$0.sendEffect(FavoritesEvent.CopyTo.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.MoveTo.INSTANCE)) {
                            this.label = 4;
                            if (this.this$0.sendEffect(FavoritesEvent.MoveTo.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.SortItems.INSTANCE)) {
                            iterable = this.this$0.mSortOps;
                            Iterable $this$any$iv = iterable;
                            if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                                z = false;
                            } else {
                                Iterator it2 = $this$any$iv.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        Object element$iv = it2.next();
                                        SortRecord it3 = (SortRecord) element$iv;
                                        if (it3.isInvalid()) {
                                            it = null;
                                            continue;
                                        } else {
                                            it = 1;
                                            continue;
                                        }
                                        if (it != null) {
                                        }
                                    } else {
                                        z = false;
                                    }
                                }
                            }
                            if (z) {
                                FavoritesEditListViewModel favoritesEditListViewModel9 = this.this$0;
                                list = this.this$0.mSortOps;
                                this.label = 5;
                                sortMedias = favoritesEditListViewModel9.sortMedias(CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj) {
                                        CharSequence invokeSuspend$lambda$7;
                                        invokeSuspend$lambda$7 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$7((SortRecord) obj);
                                        return invokeSuspend$lambda$7;
                                    }
                                }, 30, (Object) null), (Continuation) this);
                                if (sortMedias == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.DeleteChecked.INSTANCE)) {
                            Iterable $this$filterTo$iv$iv = this.this$0.getSortedList();
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                                FavoritesMediasItem it4 = (FavoritesMediasItem) element$iv$iv;
                                if (it4.isChecked()) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            String resources = CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj) {
                                    CharSequence invokeSuspend$lambda$9;
                                    invokeSuspend$lambda$9 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$9((FavoritesMediasItem) obj);
                                    return invokeSuspend$lambda$9;
                                }
                            }, 30, (Object) null);
                            FavoritesEditListViewModel favoritesEditListViewModel10 = this.this$0;
                            final FavoritesEditListViewModel favoritesEditListViewModel11 = this.this$0;
                            favoritesEditListViewModel10.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj) {
                                    FavTabState invokeSuspend$lambda$10;
                                    invokeSuspend$lambda$10 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$10(FavoritesEditListViewModel.this, (FavTabState) obj);
                                    return invokeSuspend$lambda$10;
                                }
                            });
                            FavoritesEditListViewModel favoritesEditListViewModel12 = this.this$0;
                            j = this.this$0.playlistId;
                            this.label = 6;
                            if (favoritesEditListViewModel12.deleteItems(resources, Boxing.boxLong(j), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (favoritesAction instanceof FavoritesAction.Load) {
                            this.label = 7;
                            if (FavoritesEditListViewModel.getFavorites$default(this.this$0, ((FavoritesAction.Load) this.$action).getFirstLoad(), false, (Continuation) this, 2, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.Refresh.INSTANCE)) {
                            this.label = 8;
                            favorites = this.this$0.getFavorites(false, true, (Continuation) this);
                            if (favorites == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.CancelAllChecked.INSTANCE)) {
                            FavoritesEditListViewModel favoritesEditListViewModel13 = this.this$0;
                            final FavoritesEditListViewModel favoritesEditListViewModel14 = this.this$0;
                            favoritesEditListViewModel13.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj) {
                                    FavTabState invokeSuspend$lambda$11;
                                    invokeSuspend$lambda$11 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$11(FavoritesEditListViewModel.this, (FavTabState) obj);
                                    return invokeSuspend$lambda$11;
                                }
                            });
                            break;
                        } else {
                            BLog.e(FavoritesEditListViewModel.TAG, "action:" + this.$action + " not handled");
                            break;
                        }
                    }
                } else {
                    this.this$0.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$0((FavTabState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                FavoritesEditListViewModel favoritesEditListViewModel62 = this.this$0;
                final FavoritesEditListViewModel favoritesEditListViewModel72 = this.this$0;
                final FavoritesAction favoritesAction32 = this.$action;
                favoritesEditListViewModel62.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel$onAction$1$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        FavTabState invokeSuspend$lambda$4;
                        invokeSuspend$lambda$4 = FavoritesEditListViewModel$onAction$1.invokeSuspend$lambda$4(FavoritesEditListViewModel.this, favoritesAction32, (FavTabState) obj);
                        return invokeSuspend$lambda$4;
                    }
                });
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                break;
            case 4:
                ResultKt.throwOnFailure($result);
                break;
            case 5:
                ResultKt.throwOnFailure($result);
                break;
            case 6:
                ResultKt.throwOnFailure($result);
                break;
            case 7:
                ResultKt.throwOnFailure($result);
                break;
            case 8:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$0(FavTabState $this$updateState) {
        FavTabState copy;
        FavoritesMediasItem copy2;
        Iterable $this$map$iv = $this$updateState.getItemList();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            FavoritesMediasItem it = (FavoritesMediasItem) item$iv$iv;
            copy2 = it.copy((r45 & 1) != 0 ? it.cntInfo : null, (r45 & 2) != 0 ? it.cover : null, (r45 & 4) != 0 ? it.favTime : 0, (r45 & 8) != 0 ? it.oid : 0L, (r45 & 16) != 0 ? it.intro : null, (r45 & 32) != 0 ? it.link : null, (r45 & 64) != 0 ? it.ogv : null, (r45 & BR.cover) != 0 ? it.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? it.page : 0, (r45 & BR.roleType) != 0 ? it.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? it.playbackDesc : null, (r45 & 2048) != 0 ? it.title : null, (r45 & 4096) != 0 ? it.otype : 0, (r45 & 8192) != 0 ? it.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? it.leftText : null, (r45 & 32768) != 0 ? it.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? it.rightText : null, (r45 & 131072) != 0 ? it.rightIconType : 0, (r45 & 262144) != 0 ? it.userState : 0, (r45 & 524288) != 0 ? it.isCheckMode : true, (r45 & 1048576) != 0 ? it.isChecked : false, (r45 & 2097152) != 0 ? it.cardType : 0, (r45 & 4194304) != 0 ? it.enableDrag : false, (r45 & 8388608) != 0 ? it.canDrag : false, (r45 & 16777216) != 0 ? it.isInvalid : false, (r45 & 33554432) != 0 ? it.translateInfo : null);
            destination$iv$iv.add(copy2);
        }
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : (List) destination$iv$iv, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : true, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$1(FavTabState $this$updateState) {
        FavTabState copy;
        FavoritesMediasItem copy2;
        Iterable $this$map$iv = $this$updateState.getItemList();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            FavoritesMediasItem it = (FavoritesMediasItem) item$iv$iv;
            copy2 = it.copy((r45 & 1) != 0 ? it.cntInfo : null, (r45 & 2) != 0 ? it.cover : null, (r45 & 4) != 0 ? it.favTime : 0, (r45 & 8) != 0 ? it.oid : 0L, (r45 & 16) != 0 ? it.intro : null, (r45 & 32) != 0 ? it.link : null, (r45 & 64) != 0 ? it.ogv : null, (r45 & BR.cover) != 0 ? it.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? it.page : 0, (r45 & BR.roleType) != 0 ? it.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? it.playbackDesc : null, (r45 & 2048) != 0 ? it.title : null, (r45 & 4096) != 0 ? it.otype : 0, (r45 & 8192) != 0 ? it.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? it.leftText : null, (r45 & 32768) != 0 ? it.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? it.rightText : null, (r45 & 131072) != 0 ? it.rightIconType : 0, (r45 & 262144) != 0 ? it.userState : 0, (r45 & 524288) != 0 ? it.isCheckMode : false, (r45 & 1048576) != 0 ? it.isChecked : false, (r45 & 2097152) != 0 ? it.cardType : 0, (r45 & 4194304) != 0 ? it.enableDrag : false, (r45 & 8388608) != 0 ? it.canDrag : false, (r45 & 16777216) != 0 ? it.isInvalid : false, (r45 & 33554432) != 0 ? it.translateInfo : null);
            destination$iv$iv.add(copy2);
        }
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : (List) destination$iv$iv, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$2(FavoritesEditListViewModel this$0, FavTabState $this$updateState) {
        Iterable $this$all$iv;
        FavTabState copy;
        FavoritesMediasItem copy2;
        Iterable $this$all$iv2 = this$0.getSortedList();
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator<T> it = $this$all$iv2.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    FavoritesMediasItem it2 = (FavoritesMediasItem) element$iv;
                    if (!it2.isChecked()) {
                        $this$all$iv = null;
                        break;
                    }
                } else {
                    $this$all$iv = 1;
                    break;
                }
            }
        } else {
            $this$all$iv = 1;
        }
        Iterable $this$map$iv = this$0.getSortedList();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            FavoritesMediasItem it3 = (FavoritesMediasItem) item$iv$iv;
            copy2 = it3.copy((r45 & 1) != 0 ? it3.cntInfo : null, (r45 & 2) != 0 ? it3.cover : null, (r45 & 4) != 0 ? it3.favTime : 0, (r45 & 8) != 0 ? it3.oid : 0L, (r45 & 16) != 0 ? it3.intro : null, (r45 & 32) != 0 ? it3.link : null, (r45 & 64) != 0 ? it3.ogv : null, (r45 & BR.cover) != 0 ? it3.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? it3.page : 0, (r45 & BR.roleType) != 0 ? it3.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? it3.playbackDesc : null, (r45 & 2048) != 0 ? it3.title : null, (r45 & 4096) != 0 ? it3.otype : 0, (r45 & 8192) != 0 ? it3.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? it3.leftText : null, (r45 & 32768) != 0 ? it3.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? it3.rightText : null, (r45 & 131072) != 0 ? it3.rightIconType : 0, (r45 & 262144) != 0 ? it3.userState : 0, (r45 & 524288) != 0 ? it3.isCheckMode : false, (r45 & 1048576) != 0 ? it3.isChecked : $this$all$iv == null, (r45 & 2097152) != 0 ? it3.cardType : 0, (r45 & 4194304) != 0 ? it3.enableDrag : false, (r45 & 8388608) != 0 ? it3.canDrag : false, (r45 & 16777216) != 0 ? it3.isInvalid : false, (r45 & 33554432) != 0 ? it3.translateInfo : null);
            destination$iv$iv.add(copy2);
        }
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : (List) destination$iv$iv, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$3(FavoritesEditListViewModel this$0, FavoritesAction $action, FavTabState $this$updateState) {
        FavTabState copy;
        FavoritesMediasItem copy2;
        List $this$invokeSuspend_u24lambda_u243_u240 = this$0.getSortedList();
        int size = this$0.getSortedList().size();
        int pos = ((FavoritesAction.CheckItem) $action).getPos();
        boolean z = false;
        if (pos >= 0 && pos < size) {
            z = true;
        }
        if (z) {
            FavoritesMediasItem oldItem = $this$invokeSuspend_u24lambda_u243_u240.get(((FavoritesAction.CheckItem) $action).getPos());
            int pos2 = ((FavoritesAction.CheckItem) $action).getPos();
            copy2 = oldItem.copy((r45 & 1) != 0 ? oldItem.cntInfo : null, (r45 & 2) != 0 ? oldItem.cover : null, (r45 & 4) != 0 ? oldItem.favTime : 0, (r45 & 8) != 0 ? oldItem.oid : 0L, (r45 & 16) != 0 ? oldItem.intro : null, (r45 & 32) != 0 ? oldItem.link : null, (r45 & 64) != 0 ? oldItem.ogv : null, (r45 & BR.cover) != 0 ? oldItem.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? oldItem.page : 0, (r45 & BR.roleType) != 0 ? oldItem.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? oldItem.playbackDesc : null, (r45 & 2048) != 0 ? oldItem.title : null, (r45 & 4096) != 0 ? oldItem.otype : 0, (r45 & 8192) != 0 ? oldItem.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? oldItem.leftText : null, (r45 & 32768) != 0 ? oldItem.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? oldItem.rightText : null, (r45 & 131072) != 0 ? oldItem.rightIconType : 0, (r45 & 262144) != 0 ? oldItem.userState : 0, (r45 & 524288) != 0 ? oldItem.isCheckMode : false, (r45 & 1048576) != 0 ? oldItem.isChecked : !oldItem.isChecked(), (r45 & 2097152) != 0 ? oldItem.cardType : 0, (r45 & 4194304) != 0 ? oldItem.enableDrag : false, (r45 & 8388608) != 0 ? oldItem.canDrag : false, (r45 & 16777216) != 0 ? oldItem.isInvalid : false, (r45 & 33554432) != 0 ? oldItem.translateInfo : null);
            $this$invokeSuspend_u24lambda_u243_u240.set(pos2, copy2);
        }
        Unit unit = Unit.INSTANCE;
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : $this$invokeSuspend_u24lambda_u243_u240, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$4(FavoritesEditListViewModel this$0, FavoritesAction $action, FavTabState $this$updateState) {
        FavTabState copy;
        List newList = this$0.getSortedList();
        newList.remove(((FavoritesAction.DeleteItem) $action).getItem());
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : newList.isEmpty() ? FavPageState.Empty.INSTANCE : $this$updateState.getPageState(), (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : newList, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$5(FavoritesAction $action, FavTabState $this$updateState) {
        FavTabState copy;
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : ((FavoritesAction.SortedUpdate) $action).getList(), (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeSuspend$lambda$7(SortRecord it) {
        return it.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeSuspend$lambda$9(FavoritesMediasItem it) {
        long oid = it.getOid();
        return oid + ":" + it.getOtype();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$10(FavoritesEditListViewModel this$0, FavTabState $this$updateState) {
        FavTabState copy;
        Iterable $this$filter$iv = this$0.getSortedList();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            FavoritesMediasItem it = (FavoritesMediasItem) element$iv$iv;
            if (!it.isChecked()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List newList = (List) destination$iv$iv;
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : newList.isEmpty() ? FavPageState.Empty.INSTANCE : $this$updateState.getPageState(), (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : newList, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$11(FavoritesEditListViewModel this$0, FavTabState $this$updateState) {
        FavTabState copy;
        FavoritesMediasItem copy2;
        Iterable $this$map$iv = this$0.getSortedList();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            FavoritesMediasItem it = (FavoritesMediasItem) item$iv$iv;
            copy2 = it.copy((r45 & 1) != 0 ? it.cntInfo : null, (r45 & 2) != 0 ? it.cover : null, (r45 & 4) != 0 ? it.favTime : 0, (r45 & 8) != 0 ? it.oid : 0L, (r45 & 16) != 0 ? it.intro : null, (r45 & 32) != 0 ? it.link : null, (r45 & 64) != 0 ? it.ogv : null, (r45 & BR.cover) != 0 ? it.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? it.page : 0, (r45 & BR.roleType) != 0 ? it.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? it.playbackDesc : null, (r45 & 2048) != 0 ? it.title : null, (r45 & 4096) != 0 ? it.otype : 0, (r45 & 8192) != 0 ? it.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? it.leftText : null, (r45 & 32768) != 0 ? it.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? it.rightText : null, (r45 & 131072) != 0 ? it.rightIconType : 0, (r45 & 262144) != 0 ? it.userState : 0, (r45 & 524288) != 0 ? it.isCheckMode : true, (r45 & 1048576) != 0 ? it.isChecked : false, (r45 & 2097152) != 0 ? it.cardType : 0, (r45 & 4194304) != 0 ? it.enableDrag : false, (r45 & 8388608) != 0 ? it.canDrag : false, (r45 & 16777216) != 0 ? it.isInvalid : false, (r45 & 33554432) != 0 ? it.translateInfo : null);
            destination$iv$iv.add(copy2);
        }
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : (List) destination$iv$iv, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : true, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }
}