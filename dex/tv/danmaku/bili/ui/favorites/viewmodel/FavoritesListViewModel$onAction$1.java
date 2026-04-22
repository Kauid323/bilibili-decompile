package tv.danmaku.bili.ui.favorites.viewmodel;

import com.bilibili.playset.api.FavoritesTranslateKt;
import com.bilibili.playset.api.TranslatableData;
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
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavTabState;
import tv.danmaku.bili.ui.favorites.state.FavoritesAction;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1", f = "FavoritesListViewModel.kt", i = {8, 8, 9}, l = {BR.firstButtonVo, BR.follow, BR.followDesc, BR.followed, BR.foregroundViewVisible, BR.gifThumbWidth, BR.guideHint, BR.hallTitle, BR.hasBadge, BR.hasIncomingAnimation, BR.hasTitle, BR.headerSubtitle, BR.highPrivilegedUser, BR.imageTranslationY, 300, BR.indexTitle}, m = "invokeSuspend", n = {"item", FavoritesConstsKt.POS, "item"}, s = {"L$0", "I$0", "L$0"}, v = 1)
public final class FavoritesListViewModel$onAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FavoritesAction $action;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FavoritesListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesListViewModel$onAction$1(FavoritesAction favoritesAction, FavoritesListViewModel favoritesListViewModel, Continuation<? super FavoritesListViewModel$onAction$1> continuation) {
        super(2, continuation);
        this.$action = favoritesAction;
        this.this$0 = favoritesListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesListViewModel$onAction$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0318 A[Catch: Exception -> 0x0341, TryCatch #3 {Exception -> 0x0341, blocks: (B:119:0x0302, B:121:0x030f, B:125:0x0318, B:130:0x0339, B:131:0x0340), top: B:197:0x0302 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0339 A[Catch: Exception -> 0x0341, TryCatch #3 {Exception -> 0x0341, blocks: (B:119:0x0302, B:121:0x030f, B:125:0x0318, B:130:0x0339, B:131:0x0340), top: B:197:0x0302 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x023a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object favorites;
        Object $result3;
        Object $result4;
        Object $result5;
        Object $result6;
        Object $result7;
        Object $result8;
        int pos;
        TranslatableData item;
        TranslatableData translatableData;
        Object $result9;
        Object $result10;
        TranslatableData item2;
        Object $result11;
        Object $result12;
        Object $result13;
        Object clearInvalidItem$default;
        Object $result14;
        Object $result15;
        Object $result16;
        FavoritesListViewModel favoritesListViewModel;
        Object $result17;
        String translateTitle;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                FavoritesAction favoritesAction = this.$action;
                if (Intrinsics.areEqual(favoritesAction, FavoritesAction.StartBatchManage.INSTANCE)) {
                    this.this$0.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$0((FavTabState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.QuitBatchManage.INSTANCE)) {
                    this.this$0.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$1((FavTabState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.CheckAll.INSTANCE)) {
                    this.this$0.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$2((FavTabState) obj);
                            return invokeSuspend$lambda$2;
                        }
                    });
                } else if (favoritesAction instanceof FavoritesAction.CheckItem) {
                    FavoritesListViewModel favoritesListViewModel2 = this.this$0;
                    final FavoritesAction favoritesAction2 = this.$action;
                    favoritesListViewModel2.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$3;
                            invokeSuspend$lambda$3 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$3(FavoritesAction.this, (FavTabState) obj);
                            return invokeSuspend$lambda$3;
                        }
                    });
                } else if (favoritesAction instanceof FavoritesAction.ClickItem) {
                    if (((FavoritesAction.ClickItem) this.$action).getItem().getOtype() == 302 || ((FavoritesAction.ClickItem) this.$action).getItem().getOtype() == 12 || !((FavoritesAction.ClickItem) this.$action).getItem().isInvalid()) {
                        this.label = 1;
                        if (this.this$0.sendEffect(new FavoritesEvent.RouteTo(((FavoritesAction.ClickItem) this.$action).getItem().getLink()), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result15 = $result2;
                    } else {
                        this.label = 2;
                        if (this.this$0.sendEffect(new FavoritesEvent.ShowInvalidCardDialog(((FavoritesAction.ClickItem) this.$action).getItem()), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result16 = $result2;
                    }
                } else if (favoritesAction instanceof FavoritesAction.DeleteItem) {
                    FavoritesListViewModel favoritesListViewModel3 = this.this$0;
                    long oid = ((FavoritesAction.DeleteItem) this.$action).getItem().getOid();
                    int otype = ((FavoritesAction.DeleteItem) this.$action).getItem().getOtype();
                    this.label = 3;
                    if (BaseFavoritesViewModel.deleteItems$default(favoritesListViewModel3, oid + ":" + otype, null, (Continuation) this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result14 = $result2;
                    FavoritesListViewModel favoritesListViewModel4 = this.this$0;
                    final FavoritesAction favoritesAction3 = this.$action;
                    favoritesListViewModel4.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$4;
                            invokeSuspend$lambda$4 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$4(FavoritesAction.this, (FavTabState) obj);
                            return invokeSuspend$lambda$4;
                        }
                    });
                } else if (favoritesAction instanceof FavoritesAction.ClearInvalidVideo) {
                    FavoritesListViewModel favoritesListViewModel5 = this.this$0;
                    long oid2 = ((FavoritesAction.ClearInvalidVideo) this.$action).getItem().getOid();
                    int otype2 = ((FavoritesAction.ClearInvalidVideo) this.$action).getItem().getOtype();
                    this.label = 4;
                    clearInvalidItem$default = FavoritesListViewModel.clearInvalidItem$default(favoritesListViewModel5, oid2 + ":" + otype2, null, (Continuation) this, 2, null);
                    if (clearInvalidItem$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    boolean result = ((Boolean) clearInvalidItem$default).booleanValue();
                    FavoritesListViewModel favoritesListViewModel6 = this.this$0;
                    final FavoritesAction favoritesAction4 = this.$action;
                    favoritesListViewModel6.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$5;
                            invokeSuspend$lambda$5 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$5(FavoritesAction.this, (FavTabState) obj);
                            return invokeSuspend$lambda$5;
                        }
                    });
                    favoritesListViewModel = this.this$0;
                    r6 = result;
                    this.label = 5;
                    if (favoritesListViewModel.sendEffect(new FavoritesEvent.ClearInvalidVideoResult(r6), (Continuation) this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result17 = $result2;
                } else if (favoritesAction instanceof FavoritesAction.ClearAllInvalidVideo) {
                    this.label = 6;
                    if (this.this$0.sendEffect(new FavoritesEvent.ShowClearAllInvalidVideoDialog(((FavoritesAction.ClearAllInvalidVideo) this.$action).getItem()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result13 = $result2;
                } else if (favoritesAction instanceof FavoritesAction.SwitchTranslate) {
                    TranslatableData item3 = ((FavoritesAction.SwitchTranslate) this.$action).getItem();
                    pos = CollectionsKt.indexOf(((FavTabState) this.this$0.get_uiStateFlow().getValue()).getItemList(), item3);
                    if (FavoritesTranslateKt.isTranslated(item3)) {
                        item3.setTranslateStatus(1);
                        this.label = 7;
                        if (this.this$0.sendEffect(new FavoritesEvent.NotifySwitchTranslate(pos), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result12 = $result2;
                    } else if (item3.getTranslateStatus() == 1 && !FavoritesTranslateKt.isTranslating(item3)) {
                        String translateTitle2 = item3.getTranslateTitle();
                        if (translateTitle2 == null || translateTitle2.length() == 0) {
                            item3.setTranslateStatus(10);
                            try {
                                this.L$0 = item3;
                                this.L$1 = item3;
                                this.I$0 = pos;
                                this.label = 9;
                                Object translateArcTitle = FavoritesTranslateKt.translateArcTitle(item3, (Continuation) this);
                                if (translateArcTitle == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                translatableData = item3;
                                $result9 = $result2;
                                $result10 = translateArcTitle;
                                item2 = translatableData;
                                try {
                                    translatableData.setTranslateTitle((String) $result10);
                                    translateTitle = item2.getTranslateTitle();
                                    if (!((translateTitle != null || translateTitle.length() == 0) ? true : true)) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                    item2.setTranslateStatus(2);
                                    this.L$0 = item2;
                                    this.L$1 = null;
                                    this.label = 10;
                                    if (this.this$0.sendEffect(new FavoritesEvent.NotifySwitchTranslate(pos), (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    item = item2;
                                    BLog.e(FavoritesListViewModel.TAG, "translate error: " + e.getMessage());
                                    item.setTranslateStatus(1);
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                item = item3;
                                BLog.e(FavoritesListViewModel.TAG, "translate error: " + e.getMessage());
                                item.setTranslateStatus(1);
                                return Unit.INSTANCE;
                            }
                        } else {
                            item3.setTranslateStatus(2);
                            this.label = 8;
                            if (this.this$0.sendEffect(new FavoritesEvent.NotifySwitchTranslate(pos), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result11 = $result2;
                        }
                    }
                } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.ClickDelete.INSTANCE)) {
                    this.label = 11;
                    if (this.this$0.sendEffect(FavoritesEvent.ShowDeleteDialog.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result8 = $result2;
                } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.CopyTo.INSTANCE)) {
                    this.label = 12;
                    if (this.this$0.sendEffect(FavoritesEvent.CopyTo.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result7 = $result2;
                } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.MoveTo.INSTANCE)) {
                    this.label = 13;
                    if (this.this$0.sendEffect(FavoritesEvent.MoveTo.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result6 = $result2;
                } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.DeleteChecked.INSTANCE)) {
                    Iterable $this$filterTo$iv$iv = ((FavTabState) this.this$0.getUiStateFlow().getValue()).getItemList();
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filterTo$iv$iv) {
                        FavoritesMediasItem it = (FavoritesMediasItem) element$iv$iv;
                        if (it.isChecked()) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    String resources = CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            CharSequence invokeSuspend$lambda$7;
                            invokeSuspend$lambda$7 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$7((FavoritesMediasItem) obj);
                            return invokeSuspend$lambda$7;
                        }
                    }, 30, (Object) null);
                    this.this$0.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$8;
                            invokeSuspend$lambda$8 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$8((FavTabState) obj);
                            return invokeSuspend$lambda$8;
                        }
                    });
                    this.label = 14;
                    if (BaseFavoritesViewModel.deleteItems$default(this.this$0, resources, null, (Continuation) this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result5 = $result2;
                } else if (favoritesAction instanceof FavoritesAction.Load) {
                    this.label = 15;
                    if (FavoritesListViewModel.getFavorites$default(this.this$0, ((FavoritesAction.Load) this.$action).getFirstLoad(), false, (Continuation) this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result4 = $result2;
                } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.Refresh.INSTANCE)) {
                    this.label = 16;
                    favorites = this.this$0.getFavorites(false, true, (Continuation) this);
                    if (favorites == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result3 = $result2;
                } else if (Intrinsics.areEqual(favoritesAction, FavoritesAction.GotoEmpty.INSTANCE)) {
                    this.this$0.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            FavTabState invokeSuspend$lambda$9;
                            invokeSuspend$lambda$9 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$9((FavTabState) obj);
                            return invokeSuspend$lambda$9;
                        }
                    });
                } else {
                    BLog.e(FavoritesListViewModel.TAG, "action:" + this.$action + " not handled");
                }
                return Unit.INSTANCE;
            case 1:
                $result15 = $result;
                ResultKt.throwOnFailure($result15);
                return Unit.INSTANCE;
            case 2:
                $result16 = $result;
                ResultKt.throwOnFailure($result16);
                return Unit.INSTANCE;
            case 3:
                $result14 = $result;
                ResultKt.throwOnFailure($result14);
                FavoritesListViewModel favoritesListViewModel42 = this.this$0;
                final FavoritesAction favoritesAction32 = this.$action;
                favoritesListViewModel42.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        FavTabState invokeSuspend$lambda$4;
                        invokeSuspend$lambda$4 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$4(FavoritesAction.this, (FavTabState) obj);
                        return invokeSuspend$lambda$4;
                    }
                });
                return Unit.INSTANCE;
            case 4:
                $result2 = $result;
                ResultKt.throwOnFailure($result2);
                clearInvalidItem$default = $result2;
                boolean result2 = ((Boolean) clearInvalidItem$default).booleanValue();
                FavoritesListViewModel favoritesListViewModel62 = this.this$0;
                final FavoritesAction favoritesAction42 = this.$action;
                favoritesListViewModel62.updateState(new Function1() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.FavoritesListViewModel$onAction$1$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        FavTabState invokeSuspend$lambda$5;
                        invokeSuspend$lambda$5 = FavoritesListViewModel$onAction$1.invokeSuspend$lambda$5(FavoritesAction.this, (FavTabState) obj);
                        return invokeSuspend$lambda$5;
                    }
                });
                favoritesListViewModel = this.this$0;
                if (result2) {
                }
                this.label = 5;
                if (favoritesListViewModel.sendEffect(new FavoritesEvent.ClearInvalidVideoResult(r6), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 5:
                $result17 = $result;
                ResultKt.throwOnFailure($result17);
                return Unit.INSTANCE;
            case 6:
                $result13 = $result;
                ResultKt.throwOnFailure($result13);
                return Unit.INSTANCE;
            case 7:
                $result12 = $result;
                ResultKt.throwOnFailure($result12);
                return Unit.INSTANCE;
            case 8:
                $result11 = $result;
                ResultKt.throwOnFailure($result11);
                return Unit.INSTANCE;
            case 9:
                $result10 = $result;
                int pos2 = this.I$0;
                TranslatableData translatableData2 = (TranslatableData) this.L$1;
                item2 = (TranslatableData) this.L$0;
                try {
                    ResultKt.throwOnFailure($result10);
                    translatableData = translatableData2;
                    pos = pos2;
                    $result9 = $result10;
                    translatableData.setTranslateTitle((String) $result10);
                    translateTitle = item2.getTranslateTitle();
                    if (translateTitle != null) {
                        break;
                    }
                    if (!((translateTitle != null || translateTitle.length() == 0) ? true : true)) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    item = item2;
                    BLog.e(FavoritesListViewModel.TAG, "translate error: " + e.getMessage());
                    item.setTranslateStatus(1);
                    return Unit.INSTANCE;
                }
                break;
            case 10:
                item = (TranslatableData) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                } catch (Exception e4) {
                    e = e4;
                    BLog.e(FavoritesListViewModel.TAG, "translate error: " + e.getMessage());
                    item.setTranslateStatus(1);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 11:
                $result8 = $result;
                ResultKt.throwOnFailure($result8);
                return Unit.INSTANCE;
            case 12:
                $result7 = $result;
                ResultKt.throwOnFailure($result7);
                return Unit.INSTANCE;
            case 13:
                $result6 = $result;
                ResultKt.throwOnFailure($result6);
                return Unit.INSTANCE;
            case 14:
                $result5 = $result;
                ResultKt.throwOnFailure($result5);
                return Unit.INSTANCE;
            case 15:
                $result4 = $result;
                ResultKt.throwOnFailure($result4);
                return Unit.INSTANCE;
            case 16:
                $result3 = $result;
                ResultKt.throwOnFailure($result3);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
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
    public static final FavTabState invokeSuspend$lambda$2(FavTabState $this$updateState) {
        Iterable $this$all$iv;
        FavTabState copy;
        FavoritesMediasItem copy2;
        Iterable $this$all$iv2 = $this$updateState.getItemList();
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator it = $this$all$iv2.iterator();
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
        Iterable $this$map$iv = $this$updateState.getItemList();
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
    public static final FavTabState invokeSuspend$lambda$3(FavoritesAction $action, FavTabState $this$updateState) {
        FavoritesMediasItem copy;
        FavTabState copy2;
        List $this$invokeSuspend_u24lambda_u243_u240 = CollectionsKt.toMutableList($this$updateState.getItemList());
        FavoritesMediasItem oldItem = (FavoritesMediasItem) $this$invokeSuspend_u24lambda_u243_u240.get(((FavoritesAction.CheckItem) $action).getPos());
        int pos = ((FavoritesAction.CheckItem) $action).getPos();
        copy = oldItem.copy((r45 & 1) != 0 ? oldItem.cntInfo : null, (r45 & 2) != 0 ? oldItem.cover : null, (r45 & 4) != 0 ? oldItem.favTime : 0, (r45 & 8) != 0 ? oldItem.oid : 0L, (r45 & 16) != 0 ? oldItem.intro : null, (r45 & 32) != 0 ? oldItem.link : null, (r45 & 64) != 0 ? oldItem.ogv : null, (r45 & BR.cover) != 0 ? oldItem.ugc : null, (r45 & BR.hallEnterHotText) != 0 ? oldItem.page : 0, (r45 & BR.roleType) != 0 ? oldItem.playbackPosition : 0, (r45 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? oldItem.playbackDesc : null, (r45 & 2048) != 0 ? oldItem.title : null, (r45 & 4096) != 0 ? oldItem.otype : 0, (r45 & 8192) != 0 ? oldItem.upper : null, (r45 & RingBuffer.CONSUME_SIZE) != 0 ? oldItem.leftText : null, (r45 & 32768) != 0 ? oldItem.leftIconType : 0, (r45 & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? oldItem.rightText : null, (r45 & 131072) != 0 ? oldItem.rightIconType : 0, (r45 & 262144) != 0 ? oldItem.userState : 0, (r45 & 524288) != 0 ? oldItem.isCheckMode : false, (r45 & 1048576) != 0 ? oldItem.isChecked : !oldItem.isChecked(), (r45 & 2097152) != 0 ? oldItem.cardType : 0, (r45 & 4194304) != 0 ? oldItem.enableDrag : false, (r45 & 8388608) != 0 ? oldItem.canDrag : false, (r45 & 16777216) != 0 ? oldItem.isInvalid : false, (r45 & 33554432) != 0 ? oldItem.translateInfo : null);
        $this$invokeSuspend_u24lambda_u243_u240.set(pos, copy);
        Unit unit = Unit.INSTANCE;
        copy2 = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : null, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : $this$invokeSuspend_u24lambda_u243_u240, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$4(FavoritesAction $action, FavTabState $this$updateState) {
        FavTabState copy;
        List newList = CollectionsKt.toMutableList($this$updateState.getItemList());
        newList.remove(((FavoritesAction.DeleteItem) $action).getItem());
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : newList.isEmpty() ? FavPageState.Empty.INSTANCE : $this$updateState.getPageState(), (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : newList, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$5(FavoritesAction $action, FavTabState $this$updateState) {
        FavTabState copy;
        List newList = CollectionsKt.toMutableList($this$updateState.getItemList());
        newList.remove(((FavoritesAction.ClearInvalidVideo) $action).getItem());
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : newList.isEmpty() ? FavPageState.Empty.INSTANCE : $this$updateState.getPageState(), (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : newList, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence invokeSuspend$lambda$7(FavoritesMediasItem it) {
        long oid = it.getOid();
        return oid + ":" + it.getOtype();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FavTabState invokeSuspend$lambda$8(FavTabState $this$updateState) {
        FavTabState copy;
        Iterable $this$filter$iv = $this$updateState.getItemList();
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
    public static final FavTabState invokeSuspend$lambda$9(FavTabState $this$updateState) {
        FavTabState copy;
        copy = $this$updateState.copy((r18 & 1) != 0 ? $this$updateState.pageState : FavPageState.Empty.INSTANCE, (r18 & 2) != 0 ? $this$updateState.footerState : null, (r18 & 4) != 0 ? $this$updateState.itemList : null, (r18 & 8) != 0 ? $this$updateState.isRefreshing : false, (r18 & 16) != 0 ? $this$updateState.isCheckMode : false, (r18 & 32) != 0 ? $this$updateState.pageNum : 0, (r18 & 64) != 0 ? $this$updateState.hasMore : false, (r18 & BR.cover) != 0 ? $this$updateState.hasInvalid : false);
        return copy;
    }
}