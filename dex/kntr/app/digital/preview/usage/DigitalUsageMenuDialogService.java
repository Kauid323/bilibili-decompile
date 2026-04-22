package kntr.app.digital.preview.usage;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ktor.KApiResponse;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.preview.ActivityId;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.DialogScope;
import kntr.app.digital.preview.DialogService;
import kntr.app.digital.preview.action.HandleAction;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.usage.Badge;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalUsageMenuDialogService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B9\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J)\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0003¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService;", RoomRecommendViewModel.EMPTY_CURSOR, "handleAction", "Ldagger/Lazy;", "Lkntr/app/digital/preview/action/HandleAction;", "usage", "Lkntr/app/digital/preview/usage/Usage;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "activityId", RoomRecommendViewModel.EMPTY_CURSOR, "dialogService", "Lkntr/app/digital/preview/DialogService;", "<init>", "(Ldagger/Lazy;Lkntr/app/digital/preview/usage/Usage;Lkntr/app/digital/preview/card/DigitalCardStateService;ILkntr/app/digital/preview/DialogService;)V", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UsingMenuDialog", "usingMenus", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/usage/UsingMenu;", "onDismissRequest", "Lkotlin/Function0;", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalUsageMenuDialogService {
    public static final int $stable = 8;
    private final int activityId;
    private final DigitalCardStateService cardStateService;
    private final DialogService dialogService;
    private final Lazy<HandleAction> handleAction;
    private final Usage usage;

    /* compiled from: DigitalUsageMenuDialogService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Badge.Type.values().length];
            try {
                iArr[Badge.Type.Text.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Badge.Type.Image.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UsingMenuDialog$lambda$1(DigitalUsageMenuDialogService digitalUsageMenuDialogService, List list, Function0 function0, int i, Composer composer, int i2) {
        digitalUsageMenuDialogService.UsingMenuDialog(list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Inject
    public DigitalUsageMenuDialogService(Lazy<HandleAction> lazy, Usage usage, DigitalCardStateService cardStateService, @ActivityId int activityId, DialogService dialogService) {
        Intrinsics.checkNotNullParameter(lazy, "handleAction");
        Intrinsics.checkNotNullParameter(usage, "usage");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(dialogService, "dialogService");
        this.handleAction = lazy;
        this.usage = usage;
        this.cardStateService = cardStateService;
        this.activityId = activityId;
        this.dialogService = dialogService;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object usage(Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2;
        Object invoke;
        CardBasic.CardIdInfo cardIdInfo;
        boolean z;
        if (continuation instanceof DigitalUsageMenuDialogService$usage$1) {
            DigitalUsageMenuDialogService$usage$1 digitalUsageMenuDialogService$usage$1 = (DigitalUsageMenuDialogService$usage$1) continuation;
            if ((digitalUsageMenuDialogService$usage$1.label & Integer.MIN_VALUE) != 0) {
                digitalUsageMenuDialogService$usage$1.label -= Integer.MIN_VALUE;
                continuation2 = digitalUsageMenuDialogService$usage$1;
                Object $result = continuation2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (continuation2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CardBasic.CardIdInfo cardIdInfo2 = this.cardStateService.getCurrentCardItem().getBasic().getCardIdInfo();
                        Usage usage = this.usage;
                        int i = this.activityId;
                        long cardId = cardIdInfo2.getCardId();
                        long cardTypeId = cardIdInfo2.getCardTypeId();
                        continuation2.L$0 = SpillingKt.nullOutSpilledVariable(cardIdInfo2);
                        continuation2.label = 1;
                        invoke = usage.invoke(i, cardId, cardTypeId, continuation2);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cardIdInfo = cardIdInfo2;
                        KApiResponse.BusinessFailure businessFailure = (KApiResponse) invoke;
                        z = businessFailure instanceof KApiResponse.BusinessFailure;
                        String str = RoomRecommendViewModel.EMPTY_CURSOR;
                        if (!z) {
                            Exception it = new IllegalStateException("code:" + businessFailure.getCode() + ",message:" + businessFailure.getMessage());
                            ILogger kLog = KLog_androidKt.getKLog();
                            String message = it.getMessage();
                            if (message != null) {
                                str = message;
                            }
                            kLog.e("DigitalUsageMenuDialogService", str);
                        } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                            Exception it2 = ((KApiResponse.ServiceUnavailable) businessFailure).getException();
                            ILogger kLog2 = KLog_androidKt.getKLog();
                            String message2 = it2.getMessage();
                            if (message2 != null) {
                                str = message2;
                            }
                            kLog2.e("DigitalUsageMenuDialogService", str);
                        } else if (!(businessFailure instanceof KApiResponse.Success)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            UsageMenu result = (UsageMenu) ((KApiResponse.Success) businessFailure).getData();
                            Iterable $this$map$iv = result.getList();
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                UsageMenuItem it3 = (UsageMenuItem) item$iv$iv;
                                destination$iv$iv.add(UsingMenuKt.toUsingMenu(it3));
                            }
                            final List usingMenus = (List) destination$iv$iv;
                            continuation2.L$0 = SpillingKt.nullOutSpilledVariable(cardIdInfo);
                            continuation2.L$1 = SpillingKt.nullOutSpilledVariable(businessFailure);
                            continuation2.L$2 = SpillingKt.nullOutSpilledVariable(result);
                            continuation2.L$3 = SpillingKt.nullOutSpilledVariable(usingMenus);
                            continuation2.I$0 = 0;
                            continuation2.I$1 = 0;
                            continuation2.label = 2;
                            if (this.dialogService.keepDialogShowing((Function3) ComposableLambdaKt.composableLambdaInstance(-1016049631, true, new Function3() { // from class: kntr.app.digital.preview.usage.DigitalUsageMenuDialogService$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    Unit usage$lambda$0$1;
                                    usage$lambda$0$1 = DigitalUsageMenuDialogService.usage$lambda$0$1(DigitalUsageMenuDialogService.this, usingMenus, (DialogScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    return usage$lambda$0$1;
                                }
                            }), continuation2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        cardIdInfo = (CardBasic.CardIdInfo) continuation2.L$0;
                        invoke = $result;
                        KApiResponse.BusinessFailure businessFailure2 = (KApiResponse) invoke;
                        z = businessFailure2 instanceof KApiResponse.BusinessFailure;
                        String str2 = RoomRecommendViewModel.EMPTY_CURSOR;
                        if (!z) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        int i2 = continuation2.I$1;
                        int i3 = continuation2.I$0;
                        List list = (List) continuation2.L$3;
                        UsageMenu usageMenu = (UsageMenu) continuation2.L$2;
                        KApiResponse kApiResponse = (KApiResponse) continuation2.L$1;
                        CardBasic.CardIdInfo cardIdInfo3 = (CardBasic.CardIdInfo) continuation2.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        continuation2 = new DigitalUsageMenuDialogService$usage$1(this, continuation);
        Object $result2 = continuation2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (continuation2.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit usage$lambda$0$1(DigitalUsageMenuDialogService this$0, List $usingMenus, DialogScope $this$keepDialogShowing, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$keepDialogShowing, "$this$keepDialogShowing");
        ComposerKt.sourceInformation($composer, "C59@2370L128:DigitalUsageMenuDialogService.kt#q4jl6d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed($this$keepDialogShowing) : $composer.changedInstance($this$keepDialogShowing) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1016049631, $dirty, -1, "kntr.app.digital.preview.usage.DigitalUsageMenuDialogService.usage.<anonymous>.<anonymous> (DigitalUsageMenuDialogService.kt:59)");
            }
            this$0.UsingMenuDialog($usingMenus, $this$keepDialogShowing.getOnDismissRequest(), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final void UsingMenuDialog(final List<UsingMenu> list, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-53548586);
        ComposerKt.sourceInformation($composer3, "C(UsingMenuDialog)N(usingMenus,onDismissRequest)82@3129L4325,77@2879L4575:DigitalUsageMenuDialogService.kt#q4jl6d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(this) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-53548586, $dirty2, -1, "kntr.app.digital.preview.usage.DigitalUsageMenuDialogService.UsingMenuDialog (DigitalUsageMenuDialogService.kt:76)");
            }
            $composer2 = $composer3;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(function0, (Modifier) null, (SheetState) null, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null), ColorKt.Color(4279900698L), 0L, 0.0f, 0L, (Function2) null, (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-1901839176, true, new Function3() { // from class: kntr.app.digital.preview.usage.DigitalUsageMenuDialogService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit UsingMenuDialog$lambda$0;
                    UsingMenuDialog$lambda$0 = DigitalUsageMenuDialogService.UsingMenuDialog$lambda$0(list, function0, this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return UsingMenuDialog$lambda$0;
                }
            }, $composer3, 54), $composer2, (($dirty2 >> 3) & 14) | 1572864, 3078, 7070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.usage.DigitalUsageMenuDialogService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit UsingMenuDialog$lambda$1;
                    UsingMenuDialog$lambda$1 = DigitalUsageMenuDialogService.UsingMenuDialog$lambda$1(DigitalUsageMenuDialogService.this, list, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return UsingMenuDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x01c7, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit UsingMenuDialog$lambda$0(List $usingMenus, Function0 $onDismissRequest, DigitalUsageMenuDialogService this$0, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        long j2;
        final Function0 function0 = $onDismissRequest;
        final DigitalUsageMenuDialogService digitalUsageMenuDialogService = this$0;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C83@3147L4293:DigitalUsageMenuDialogService.kt#q4jl6d");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1901839176, $changed, -1, "kntr.app.digital.preview.usage.DigitalUsageMenuDialogService.UsingMenuDialog.<anonymous> (DigitalUsageMenuDialogService.kt:83)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv = $composer;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -382244225, "C152@6665L265,161@7036L9,159@6951L471:DigitalUsageMenuDialogService.kt#q4jl6d");
            $composer$iv.startReplaceGroup(-1120709554);
            ComposerKt.sourceInformation($composer$iv, "*95@3683L170,89@3371L2898");
            List $this$forEachIndexed$iv = $usingMenus;
            boolean z = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                final UsingMenu menu = (UsingMenu) item$iv;
                int index = index$iv;
                boolean z2 = z;
                Modifier materialized$iv$iv2 = materialized$iv$iv;
                Composer $composer$iv2 = $composer$iv;
                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(14), 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv, 666996124, "CC(remember):DigitalUsageMenuDialogService.kt#9igjgp");
                boolean invalid$iv = $composer$iv.changedInstance(digitalUsageMenuDialogService) | $composer$iv.changedInstance(menu) | $composer$iv.changed(function0);
                Object it$iv = $composer$iv.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.digital.preview.usage.DigitalUsageMenuDialogService$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit UsingMenuDialog$lambda$0$0$0$0$0;
                        UsingMenuDialog$lambda$0$0$0$0$0 = DigitalUsageMenuDialogService.UsingMenuDialog$lambda$0$0$0$0$0(DigitalUsageMenuDialogService.this, menu, function0);
                        return UsingMenuDialog$lambda$0$0$0$0$0;
                    }
                };
                $composer$iv.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str);
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                String str3 = str;
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str2);
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv.useNode();
                }
                String str4 = str2;
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i4 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1102567493, "C103@4094L9,101@3987L253:DigitalUsageMenuDialogService.kt#q4jl6d");
                TextKt.Text-Nvy7gAk(menu.getTitle(), (Modifier) null, ColorKt.Color(menu.getAvailable() ? 4294967295L : 4284573293L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT15(), $composer$iv, 0, 0, 131066);
                Badge badge = menu.getBadge();
                if (badge != null) {
                    $composer$iv.startReplaceGroup(1102937508);
                    ComposerKt.sourceInformation($composer$iv, RoomRecommendViewModel.EMPTY_CURSOR);
                    switch (WhenMappings.$EnumSwitchMapping$0[badge.getType().ordinal()]) {
                        case 1:
                            $composer$iv.startReplaceGroup(1103033515);
                            ComposerKt.sourceInformation($composer$iv, "112@4622L9,110@4490L1193");
                            String value = badge.getValue();
                            TextStyle t10 = BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT10();
                            if (menu.getAvailable()) {
                                j2 = Color.Companion.getWhite-0d7_KjU();
                            } else {
                                j2 = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            }
                            TextKt.Text-Nvy7gAk(value, PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorKt.Color(4294928025L), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(5), Dp.constructor-impl(1)), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t10, $composer$iv, 0, 0, 131064);
                            $composer$iv.endReplaceGroup();
                            Unit unit = Unit.INSTANCE;
                            break;
                        case 2:
                            $composer$iv.startReplaceGroup(1104287620);
                            ComposerKt.sourceInformation($composer$iv, "132@5821L320");
                            BiliImageKt.BiliImage(new ImageRequest(badge.getValue()).build(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer$iv, 48, 508);
                            $composer$iv.endReplaceGroup();
                            Unit unit2 = Unit.INSTANCE;
                            break;
                        default:
                            $composer$iv.startReplaceGroup(866862622);
                            $composer$iv.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                    }
                } else {
                    $composer$iv.startReplaceGroup(1098541460);
                }
                $composer$iv.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (index < CollectionsKt.getLastIndex($usingMenus)) {
                    $composer$iv.startReplaceGroup(-795328020);
                    ComposerKt.sourceInformation($composer$iv, "144@6359L236");
                    DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(0.5f), ColorKt.Color(436207615), $composer$iv, 438, 0);
                } else {
                    $composer$iv.startReplaceGroup(-801616432);
                }
                $composer$iv.endReplaceGroup();
                function0 = $onDismissRequest;
                digitalUsageMenuDialogService = this$0;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z = z2;
                materialized$iv$iv = materialized$iv$iv2;
                $composer$iv = $composer$iv2;
                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                str = str3;
                str2 = str4;
            }
            $composer$iv.endReplaceGroup();
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(8)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer$iv, 6);
            TextKt.Text-Nvy7gAk("取消", ClickableKt.clickable-oSLSa3U$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(17), 1, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, $onDismissRequest, 15, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT16(), $composer$iv, 390, 0, 130040);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UsingMenuDialog$lambda$0$0$0$0$0(DigitalUsageMenuDialogService this$0, UsingMenu $menu, Function0 $onDismissRequest) {
        ((HandleAction) this$0.handleAction.get()).invoke($menu.getAction());
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }
}