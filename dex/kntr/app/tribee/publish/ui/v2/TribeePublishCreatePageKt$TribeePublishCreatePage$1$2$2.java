package kntr.app.tribee.publish.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.TribeePublishViewModel;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.tribee.publish.ui.v2.internal.DialogsKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TribeePublishCreatePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ TribeePublishViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2(TribeePublishViewModel tribeePublishViewModel, CoroutineScope coroutineScope) {
        this.$viewModel = tribeePublishViewModel;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x01a6, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01eb, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0226, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0262, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(Composer $composer, int $changed) {
        final MutableState showDraftDialog$delegate;
        ComposerKt.sourceInformation($composer, "C64@2793L7,65@2824L28,66@2887L13,67@2913L115,71@3065L62,74@3168L16,76@3236L240,95@3952L19,92@3831L92,86@3636L52,89@3718L67,83@3489L548:TribeePublishCreatePage.kt#oim1ra");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(965044327, $changed, -1, "kntr.app.tribee.publish.ui.v2.TribeePublishCreatePage.<anonymous>.<anonymous>.<anonymous> (TribeePublishCreatePage.kt:64)");
        }
        final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer, LocalOnBackPressedDispatcher.$stable);
        SystemUiController trio = SystemUI_androidKt.rememberSystemUiController($composer, 0);
        ThemeDayNight theme = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable);
        ComposerKt.sourceInformationMarkerStart($composer, -1903608649, "CC(TribeePublishConfigWindow)N(block)20@740L7:TribeePublishConfigWinidow.android.kt#oim1ra");
        CompositionLocal this_$iv$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Activity activity$iv = ContextUtilKt.findActivityOrNull((Context) consume);
        if (Build.VERSION.SDK_INT >= 30 || activity$iv == null) {
            $composer.startReplaceGroup(343461332);
            ComposerKt.sourceInformation($composer, "29@1206L7");
            boolean z = false & true;
            ComposerKt.sourceInformationMarkerStart($composer, 2125323330, "C:TribeePublishCreatePage.kt#oim1ra");
            trio.setStatusBar(theme == ThemeDayNight.Day);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(343108707);
            ComposerKt.sourceInformation($composer, "22@864L13,23@933L251,23@909L275");
            boolean isNight$iv = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight$iv);
            ComposerKt.sourceInformationMarkerStart($composer, 288165874, "CC(remember):TribeePublishConfigWinidow.android.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changedInstance(activity$iv) | $composer.changed(isNight$iv);
            TribeePublishConfigWinidow_androidKt$TribeePublishConfigWindow$1$1 value$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new TribeePublishConfigWinidow_androidKt$TribeePublishConfigWindow$1$1(activity$iv, isNight$iv, null);
                $composer.updateRememberedValue(value$iv$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) value$iv$iv, $composer, 0);
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -305326971, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableState showDraftDialog$delegate2 = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        final TribeePublishState state = (TribeePublishState) SnapshotStateKt.collectAsState(this.$viewModel.getState(), (CoroutineContext) null, $composer, 0, 1).getValue();
        ComposerKt.sourceInformationMarkerStart($composer, -305321321, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
        boolean invalid$iv = $composer.changed(state);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function0) new Function0<Unit>() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$checkDraft$1$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m948invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m948invoke() {
                    TribeePublishContent publishContent = TribeePublishState.this.getPublishContent();
                    boolean z2 = false;
                    if (publishContent != null && publishContent.getReadyForSaveDraft()) {
                        z2 = true;
                    }
                    if (z2) {
                        TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2.invoke$lambda$3(showDraftDialog$delegate2, true);
                    }
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        final Function0 checkDraft = (Function0) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        OuroStore ouroStore = this.$viewModel.getOuroStore();
        TribeePublishViewModel tribeePublishViewModel = this.$viewModel;
        ComposerKt.sourceInformationMarkerStart($composer, -305298630, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(tribeePublishViewModel);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv2) {
        }
        Object value$iv3 = (KFunction) new TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$2$1(tribeePublishViewModel);
        $composer.updateRememberedValue(value$iv3);
        it$iv3 = value$iv3;
        Function2 function2 = (KFunction) it$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -305302429, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
        boolean invalid$iv3 = $composer.changedInstance(state);
        Object it$iv4 = $composer.rememberedValue();
        if (invalid$iv3) {
        }
        Object value$iv4 = (Function0) new Function0<Boolean>() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$3$1
            /* renamed from: invoke */
            public final Boolean m943invoke() {
                TribeePublishContent publishContent = TribeePublishState.this.getPublishContent();
                boolean z2 = false;
                if (publishContent != null && publishContent.getReadyForSaveDraft()) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
        };
        $composer.updateRememberedValue(value$iv4);
        it$iv4 = value$iv4;
        Function0 function0 = (Function0) it$iv4;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -305308709, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
        boolean invalid$iv4 = $composer.changed(checkDraft);
        Object it$iv5 = $composer.rememberedValue();
        if (invalid$iv4) {
        }
        Object value$iv5 = (Function0) new Function0<Unit>() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$4$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m944invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m944invoke() {
                checkDraft.invoke();
            }
        };
        $composer.updateRememberedValue(value$iv5);
        it$iv5 = value$iv5;
        Function0 function02 = (Function0) it$iv5;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -305306070, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
        boolean invalid$iv5 = $composer.changedInstance(backHandler);
        Object it$iv6 = $composer.rememberedValue();
        if (invalid$iv5) {
        }
        Object value$iv6 = (Function0) new Function0<Unit>() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$5$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m945invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m945invoke() {
                backHandler.onBackPressed();
            }
        };
        $composer.updateRememberedValue(value$iv6);
        it$iv6 = value$iv6;
        ComposerKt.sourceInformationMarkerEnd($composer);
        TribeePublishBasePageKt.TribeePublishBasePage(ouroStore, state, function0, function02, (Function0) it$iv6, function2, fillMaxSize$default, $composer, 1572864, 0);
        if (invoke$lambda$2(showDraftDialog$delegate2)) {
            $composer.startReplaceGroup(-874182351);
            ComposerKt.sourceInformation($composer, "101@4135L292,108@4460L293,100@4090L682");
            ComposerKt.sourceInformationMarkerStart($composer, -305292501, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
            boolean invalid$iv6 = $composer.changedInstance(this.$scope) | $composer.changedInstance(this.$viewModel);
            final CoroutineScope coroutineScope = this.$scope;
            final TribeePublishViewModel tribeePublishViewModel2 = this.$viewModel;
            Object it$iv7 = $composer.rememberedValue();
            if (invalid$iv6 || it$iv7 == Composer.Companion.getEmpty()) {
                showDraftDialog$delegate = showDraftDialog$delegate2;
                Object value$iv7 = (Function0) new Function0<Unit>() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$6$1

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TribeePublishCreatePage.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$6$1$1", f = "TribeePublishCreatePage.kt", i = {}, l = {104, 105}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    /* renamed from: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$6$1$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Boolean> $showDraftDialog$delegate;
                        final /* synthetic */ TribeePublishViewModel $viewModel;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(TribeePublishViewModel tribeePublishViewModel, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$viewModel = tribeePublishViewModel;
                            this.$showDraftDialog$delegate = mutableState;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$viewModel, this.$showDraftDialog$delegate, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:13:0x0041 A[RETURN] */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$viewModel.dispatch(TribeePublishAction.SaveDraft.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    this.label = 2;
                                    if (this.$viewModel.dispatch(TribeePublishAction.Close.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2.invoke$lambda$3(this.$showDraftDialog$delegate, false);
                                    return Unit.INSTANCE;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 2;
                                    if (this.$viewModel.dispatch(TribeePublishAction.Close.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                    }
                                    TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2.invoke$lambda$3(this.$showDraftDialog$delegate, false);
                                    return Unit.INSTANCE;
                                case 2:
                                    ResultKt.throwOnFailure($result);
                                    TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2.invoke$lambda$3(this.$showDraftDialog$delegate, false);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m946invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m946invoke() {
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(tribeePublishViewModel2, showDraftDialog$delegate, null), 3, (Object) null);
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            } else {
                showDraftDialog$delegate = showDraftDialog$delegate2;
            }
            Function0 function03 = (Function0) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -305282100, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
            boolean invalid$iv7 = $composer.changedInstance(this.$scope) | $composer.changedInstance(this.$viewModel);
            final CoroutineScope coroutineScope2 = this.$scope;
            final TribeePublishViewModel tribeePublishViewModel3 = this.$viewModel;
            Object it$iv8 = $composer.rememberedValue();
            if (invalid$iv7 || it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv8 = (Function0) new Function0<Unit>() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$7$1

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TribeePublishCreatePage.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$7$1$1", f = "TribeePublishCreatePage.kt", i = {}, l = {111, 112}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    /* renamed from: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2$7$1$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Boolean> $showDraftDialog$delegate;
                        final /* synthetic */ TribeePublishViewModel $viewModel;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(TribeePublishViewModel tribeePublishViewModel, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$viewModel = tribeePublishViewModel;
                            this.$showDraftDialog$delegate = mutableState;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$viewModel, this.$showDraftDialog$delegate, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:13:0x0041 A[RETURN] */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$viewModel.dispatch(TribeePublishAction.ClearDraft.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    this.label = 2;
                                    if (this.$viewModel.dispatch(TribeePublishAction.Close.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2.invoke$lambda$3(this.$showDraftDialog$delegate, false);
                                    return Unit.INSTANCE;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 2;
                                    if (this.$viewModel.dispatch(TribeePublishAction.Close.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                    }
                                    TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2.invoke$lambda$3(this.$showDraftDialog$delegate, false);
                                    return Unit.INSTANCE;
                                case 2:
                                    ResultKt.throwOnFailure($result);
                                    TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2.invoke$lambda$3(this.$showDraftDialog$delegate, false);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m947invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m947invoke() {
                        BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(tribeePublishViewModel3, showDraftDialog$delegate, null), 3, (Object) null);
                    }
                };
                $composer.updateRememberedValue(value$iv8);
                it$iv8 = value$iv8;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            DialogsKt.DraftDialog(function03, (Function0) it$iv8, null, $composer, 0, 4);
        } else {
            $composer.startReplaceGroup(-878244901);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    private static final boolean invoke$lambda$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }
}