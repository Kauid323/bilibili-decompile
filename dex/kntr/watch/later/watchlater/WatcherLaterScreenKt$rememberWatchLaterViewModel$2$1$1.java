package kntr.watch.later.watchlater;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.painter.Painter;
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.trio.toast.Toaster;
import kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1;
import kntr.watch.later.watchlater.api.TranslateInfo;
import kntr.watch.later.watchlater.data.DialogType;
import kntr.watch.later.watchlater.data.ToastType;
import kntr.watch.later.watchlater.data.WLEvent;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatcherLaterScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1", f = "WatcherLaterScreen.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Toaster $toaster;
    final /* synthetic */ WatchLaterViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1(WatchLaterViewModel watchLaterViewModel, Toaster toaster, Continuation<? super WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = watchLaterViewModel;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1(this.$viewModel, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WatcherLaterScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* renamed from: kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ Toaster $toaster;
        final /* synthetic */ WatchLaterViewModel $viewModel;

        AnonymousClass1(WatchLaterViewModel watchLaterViewModel, Toaster toaster) {
            this.$viewModel = watchLaterViewModel;
            this.$toaster = toaster;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((WLEvent) value, (Continuation<? super Unit>) $completion);
        }

        public final Object emit(final WLEvent event, Continuation<? super Unit> continuation) {
            DialogInfo dialogInfo;
            if (event instanceof WLEvent.ShowDeleteDialog) {
                MutableStateFlow<DialogInfo> dialogInfo2 = this.$viewModel.getDialogInfo();
                DialogType type = ((WLEvent.ShowDeleteDialog) event).getType();
                final WatchLaterViewModel watchLaterViewModel = this.$viewModel;
                Function0 function0 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit emit$lambda$0;
                        emit$lambda$0 = WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1.AnonymousClass1.emit$lambda$0(WatchLaterViewModel.this);
                        return emit$lambda$0;
                    }
                };
                final WatchLaterViewModel watchLaterViewModel2 = this.$viewModel;
                dialogInfo = WatcherLaterScreenKt.getDialogInfo(type, function0, new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1$1$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit emit$lambda$1;
                        emit$lambda$1 = WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1.AnonymousClass1.emit$lambda$1(WatchLaterViewModel.this, event);
                        return emit$lambda$1;
                    }
                });
                dialogInfo2.setValue(dialogInfo);
            } else if (event instanceof WLEvent.ShowToast) {
                ToastType type2 = ((WLEvent.ShowToast) event).getType();
                if (Intrinsics.areEqual(type2, ToastType.NetworkError.INSTANCE)) {
                    Toaster.CC.showToast$default(this.$toaster, CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_16(CommonRes.INSTANCE.getString())), null, 2, null);
                } else if (Intrinsics.areEqual(type2, ToastType.OperateSuccess.INSTANCE)) {
                    Toaster.CC.showToast$default(this.$toaster, CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_106(CommonRes.INSTANCE.getString())), null, 2, null);
                } else if (!Intrinsics.areEqual(type2, ToastType.OperateFailed.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    Toaster.CC.showToast$default(this.$toaster, CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_90(CommonRes.INSTANCE.getString())), null, 2, null);
                }
            } else if (event instanceof WLEvent.ShowDeleteBottomSheet) {
                final WatchLaterItem item = ((WLEvent.ShowDeleteBottomSheet) event).getItem();
                boolean z = true;
                String string = CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_113(CommonRes.INSTANCE.getString()));
                Function2 function2 = new Function2() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        Painter emit$lambda$2;
                        emit$lambda$2 = WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1.AnonymousClass1.emit$lambda$2((Composer) obj, ((Integer) obj2).intValue());
                        return emit$lambda$2;
                    }
                };
                final WatchLaterViewModel watchLaterViewModel3 = this.$viewModel;
                List bottomSheetList = CollectionsKt.mutableListOf(new BottomSheetItemData[]{new BottomSheetItemData(string, (String) null, function2, 0L, 0L, false, 0, false, new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1$1$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit emit$lambda$3;
                        emit$lambda$3 = WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1.AnonymousClass1.emit$lambda$3(WatchLaterViewModel.this, item, ((Integer) obj).intValue());
                        return emit$lambda$3;
                    }
                }, 250, (DefaultConstructorMarker) null)});
                TranslateInfo it = item.getTranslateInfo();
                if (it != null) {
                    final WatchLaterViewModel watchLaterViewModel4 = this.$viewModel;
                    String title = null;
                    Function2 iconProvider = null;
                    if (item.getTranslateStatus() != 2) {
                        if (item.getTranslateStatus() == 1 || item.getTranslateStatus() == 10) {
                            title = it.getTranslateText();
                            iconProvider = new Function2() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1$1$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj, Object obj2) {
                                    Painter emit$lambda$4$1;
                                    emit$lambda$4$1 = WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1.AnonymousClass1.emit$lambda$4$1((Composer) obj, ((Integer) obj2).intValue());
                                    return emit$lambda$4$1;
                                }
                            };
                        }
                    } else {
                        title = it.getOriginText();
                        iconProvider = new Function2() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1$1$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj, Object obj2) {
                                Painter emit$lambda$4$0;
                                emit$lambda$4$0 = WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1.AnonymousClass1.emit$lambda$4$0((Composer) obj, ((Integer) obj2).intValue());
                                return emit$lambda$4$0;
                            }
                        };
                    }
                    String str = title;
                    if (str != null && !StringsKt.isBlank(str)) {
                        z = false;
                    }
                    if (!z && iconProvider != null) {
                        bottomSheetList.add(new BottomSheetItemData(title, (String) null, iconProvider, 0L, 0L, false, 0, false, new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1$1$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                Unit emit$lambda$4$2;
                                emit$lambda$4$2 = WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1.AnonymousClass1.emit$lambda$4$2(WatchLaterViewModel.this, item, ((Integer) obj).intValue());
                                return emit$lambda$4$2;
                            }
                        }, 250, (DefaultConstructorMarker) null));
                    }
                }
                this.$viewModel.getBottomSheetItems$watch_later_debug().setValue(bottomSheetList);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit emit$lambda$0(WatchLaterViewModel $viewModel) {
            $viewModel.getDialogInfo().setValue((Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit emit$lambda$1(WatchLaterViewModel $viewModel, WLEvent $event) {
            $viewModel.getDialogInfo().setValue((Object) null);
            $viewModel.onDialogConfirm(((WLEvent.ShowDeleteDialog) $event).getType());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Painter emit$lambda$2(Composer $composer, int $changed) {
            $composer.startReplaceGroup(591890895);
            ComposerKt.sourceInformation($composer, "C222@9228L21:WatcherLaterScreen.kt#buddnv");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(591890895, $changed, -1, "kntr.watch.later.watchlater.rememberWatchLaterViewModel.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WatcherLaterScreen.kt:222)");
            }
            Painter trash_delete_line_500 = BiliIconfont.INSTANCE.getTrash_delete_line_500($composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return trash_delete_line_500;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit emit$lambda$3(WatchLaterViewModel $viewModel, WatchLaterItem $item, int it) {
            WatcherLaterScreenKt.dismissBottomSheet($viewModel);
            $viewModel.deleteItem($item.getAid());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Painter emit$lambda$4$0(Composer $composer, int $changed) {
            $composer.startReplaceGroup(-1930008924);
            ComposerKt.sourceInformation($composer, "C234@9935L22:WatcherLaterScreen.kt#buddnv");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1930008924, $changed, -1, "kntr.watch.later.watchlater.rememberWatchLaterViewModel.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WatcherLaterScreen.kt:234)");
            }
            Painter original_text_line_500 = BiliIconfont.INSTANCE.getOriginal_text_line_500($composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return original_text_line_500;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Painter emit$lambda$4$1(Composer $composer, int $changed) {
            $composer.startReplaceGroup(1111648333);
            ComposerKt.sourceInformation($composer, "C239@10284L23:WatcherLaterScreen.kt#buddnv");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1111648333, $changed, -1, "kntr.watch.later.watchlater.rememberWatchLaterViewModel.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WatcherLaterScreen.kt:239)");
            }
            Painter caption_change_line_500 = BiliIconfont.INSTANCE.getCaption_change_line_500($composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return caption_change_line_500;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit emit$lambda$4$2(WatchLaterViewModel $viewModel, WatchLaterItem $item, int it) {
            $viewModel.switchTranslate($item);
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$viewModel.getEvent().collect(new AnonymousClass1(this.$viewModel, this.$toaster), (Continuation) this) == coroutine_suspended) {
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