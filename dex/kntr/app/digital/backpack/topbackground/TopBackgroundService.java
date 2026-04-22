package kntr.app.digital.backpack.topbackground;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.bpf.neuron.NeuronReportKt;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.digital.backpack.ReportParams;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.router.Router;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;

/* compiled from: TopBackgroundService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0017\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011J/\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"Lkntr/app/digital/backpack/topbackground/TopBackgroundService;", RoomRecommendViewModel.EMPTY_CURSOR, "topBackgroundModel", "Lkntr/app/digital/backpack/topbackground/TopBackgroundModel;", "router", "Lkntr/base/router/Router;", "reportParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/digital/backpack/topbackground/TopBackgroundModel;Lkntr/base/router/Router;Ljava/util/Map;)V", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "TopBackground", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OperationButton", "icon", "Lorg/jetbrains/compose/resources/DrawableResource;", "text", "hasRedPoint", RoomRecommendViewModel.EMPTY_CURSOR, "(Lorg/jetbrains/compose/resources/DrawableResource;Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "backpack_debug", "hasDot"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TopBackgroundService {
    public static final int $stable = 8;
    private final Map<String, String> reportParams;
    private final Router router;
    private final TopBackgroundModel topBackgroundModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OperationButton$lambda$1(TopBackgroundService topBackgroundService, DrawableResource drawableResource, String str, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        topBackgroundService.OperationButton(drawableResource, str, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBackground$lambda$1(TopBackgroundService topBackgroundService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        topBackgroundService.TopBackground(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public TopBackgroundService(TopBackgroundModel topBackgroundModel, Router router, @ReportParams Map<String, String> map) {
        Intrinsics.checkNotNullParameter(topBackgroundModel, "topBackgroundModel");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(map, "reportParams");
        this.topBackgroundModel = topBackgroundModel;
        this.router = router;
        this.reportParams = map;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.topbackground.TopBackgroundService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = TopBackgroundService.komponent$lambda$0(TopBackgroundService.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final TopBackgroundService this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, this$0) { // from class: kntr.app.digital.backpack.topbackground.TopBackgroundService$komponent$lambda$0$$inlined$setContent$1
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;
            final /* synthetic */ TopBackgroundService this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.this$0 = this$0;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                $composer.startReplaceGroup(-381388249);
                ComposerKt.sourceInformation($composer, "CN(it)*51@2048L17:TopBackgroundService.kt#koemkb");
                this.this$0.TopBackground(modifier, $composer, $changed & 14 & 14, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x025a, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void TopBackground(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        BoxScope $this$TopBackground_u24lambda_u240;
        String str;
        Composer $composer$iv2;
        int $changed$iv$iv$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(118361499);
        ComposerKt.sourceInformation($composer3, "C(TopBackground)N(modifier)57@2190L3095:TopBackgroundService.kt#koemkb");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer3.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(118361499, $dirty2, -1, "kntr.app.digital.backpack.topbackground.TopBackgroundService.TopBackground (TopBackgroundService.kt:56)");
            }
            int $changed$iv = $dirty2 & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$TopBackground_u24lambda_u2402 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 599323364, "C58@2233L258:TopBackgroundService.kt#koemkb");
            String $this$asRequest_u24default$iv = this.topBackgroundModel.getBackgroundImage();
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.875f, false, 2, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 48, 508);
            if (this.topBackgroundModel.getDecomposedButton() != null) {
                $composer3.startReplaceGroup(599592009);
                ComposerKt.sourceInformation($composer3, "82@3491L361,66@2579L1296");
                DrawableResource icon = this.topBackgroundModel.getDecomposedButton().getIcon();
                String title = this.topBackgroundModel.getDecomposedButton().getTitle();
                boolean hasDot = this.topBackgroundModel.getDecomposedButton().getHasDot();
                Modifier modifier5 = Modifier.Companion;
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopEnd();
                Modifier modifier6 = BackgroundKt.background-bw27NRU(SizeKt.wrapContentSize$default(PaddingKt.padding-qDBjuR0$default($this$TopBackground_u24lambda_u2402.align(modifier5, contentAlignment$iv2), 0.0f, Dp.constructor-impl(100), 0.0f, 0.0f, 13, (Object) null), (Alignment) null, false, 3, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(14), 0.0f, 0.0f, Dp.constructor-impl(14), 6, (Object) null));
                ComposerKt.sourceInformationMarkerStart($composer3, -673366070, "CC(remember):TopBackgroundService.kt#9igjgp");
                boolean invalid$iv = $composer3.changedInstance(this);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.digital.backpack.topbackground.TopBackgroundService$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TopBackground$lambda$0$0$0;
                        TopBackground$lambda$0$0$0 = TopBackgroundService.TopBackground$lambda$0$0$0(TopBackgroundService.this);
                        return TopBackground$lambda$0$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $this$TopBackground_u24lambda_u240 = $this$TopBackground_u24lambda_u2402;
                $composer$iv2 = $composer3;
                str = "CC(remember):TopBackgroundService.kt#9igjgp";
                $changed$iv$iv$iv = 597013057;
                $composer$iv = $composer3;
                OperationButton(icon, title, hasDot, ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer3, ($dirty2 << 9) & 57344, 0);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer$iv = $composer3;
                $this$TopBackground_u24lambda_u240 = $this$TopBackground_u24lambda_u2402;
                str = "CC(remember):TopBackgroundService.kt#9igjgp";
                $composer$iv2 = $composer3;
                $changed$iv$iv$iv = 597013057;
                $composer2 = $composer3;
                $composer2.startReplaceGroup(597013057);
                $composer2.endReplaceGroup();
            }
            if (this.topBackgroundModel.getGiftButton() != null) {
                $composer2.startReplaceGroup(600977244);
                ComposerKt.sourceInformation($composer2, "93@3999L65,110@4949L281,94@4085L1168");
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart($composer2, -673350110, str2);
                Composer $this$cache$iv = $composer2;
                Object it$iv2 = $this$cache$iv.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(this.topBackgroundModel.getGiftButton().getHasDot()), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $this$cache$iv.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                final MutableState hasDot$delegate = (MutableState) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                DrawableResource icon2 = this.topBackgroundModel.getGiftButton().getIcon();
                String title2 = this.topBackgroundModel.getGiftButton().getTitle();
                boolean TopBackground$lambda$0$2 = TopBackground$lambda$0$2(hasDot$delegate);
                Modifier modifier7 = BackgroundKt.background-bw27NRU(SizeKt.wrapContentSize$default(PaddingKt.padding-qDBjuR0$default($this$TopBackground_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd()), 0.0f, Dp.constructor-impl(148), 0.0f, 0.0f, 13, (Object) null), (Alignment) null, false, 3, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(14), 0.0f, 0.0f, Dp.constructor-impl(14), 6, (Object) null));
                ComposerKt.sourceInformationMarkerStart($composer2, -673319494, str2);
                boolean invalid$iv2 = $composer3.changedInstance(this);
                Composer $this$cache$iv2 = $composer2;
                Object it$iv3 = $this$cache$iv2.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.digital.backpack.topbackground.TopBackgroundService$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit TopBackground$lambda$0$4$0;
                            TopBackground$lambda$0$4$0 = TopBackgroundService.TopBackground$lambda$0$4$0(TopBackgroundService.this, hasDot$delegate);
                            return TopBackground$lambda$0$4$0;
                        }
                    };
                    $this$cache$iv2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                OperationButton(icon2, title2, TopBackground$lambda$0$2, ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), $composer2, ($dirty2 << 9) & 57344, 0);
            } else {
                $composer2.startReplaceGroup($changed$iv$iv$iv);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.topbackground.TopBackgroundService$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopBackground$lambda$1;
                    TopBackground$lambda$1 = TopBackgroundService.TopBackground$lambda$1(TopBackgroundService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TopBackground$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBackground$lambda$0$0$0(TopBackgroundService this$0) {
        NeuronReportKt.getNeuronReport().invoke(this$0.topBackgroundModel.getDecomposedButton().getEventId(), this$0.reportParams);
        this$0.router.launch(UrisKt.toUri(this$0.topBackgroundModel.getDecomposedButton().getUrl()));
        return Unit.INSTANCE;
    }

    private static final boolean TopBackground$lambda$0$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TopBackground$lambda$0$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBackground$lambda$0$4$0(TopBackgroundService this$0, MutableState $hasDot$delegate) {
        TopBackground$lambda$0$3($hasDot$delegate, false);
        NeuronReportKt.getNeuronReport().invoke(this$0.topBackgroundModel.getGiftButton().getEventId(), this$0.reportParams);
        this$0.router.launch(UrisKt.toUri(this$0.topBackgroundModel.getGiftButton().getUrl()));
        return Unit.INSTANCE;
    }

    public final void OperationButton(final DrawableResource icon, final String text, final boolean hasRedPoint, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(969741074);
        ComposerKt.sourceInformation($composer3, "C(OperationButton)N(icon,text,hasRedPoint,modifier)127@5509L1402:TopBackgroundService.kt#koemkb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(icon) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(text) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(hasRedPoint) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(969741074, $dirty, -1, "kntr.app.digital.backpack.topbackground.TopBackgroundService.OperationButton (TopBackgroundService.kt:126)");
            }
            int $changed$iv = ($dirty >> 9) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            modifier3 = modifier4;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$OperationButton_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1038915895, "C130@5583L833:TopBackgroundService.kt#koemkb");
            Modifier modifier$iv2 = $this$OperationButton_u24lambda_u240.align(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(4)), Alignment.Companion.getCenter());
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1077593865, "C138@5929L21,137@5888L305,148@6300L9,149@6358L6,146@6215L183:TopBackgroundService.kt#koemkb");
            ImageKt.Image(ImageResourcesKt.painterResource(icon, $composer3, $dirty & 14), RoomRecommendViewModel.EMPTY_CURSOR, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(2), 0.0f, 11, (Object) null), Dp.constructor-impl(20)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 432, 120);
            TextKt.Text-Nvy7gAk(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), $composer3, ($dirty >> 3) & 14, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (hasRedPoint) {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1038082709);
                ComposerKt.sourceInformation($composer2, "157@6685L6,153@6472L407");
                SpacerKt.Spacer(SizeKt.size-3ABfNKs(BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default($this$OperationButton_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd()), 0.0f, Dp.constructor-impl(3), Dp.constructor-impl(5), 0.0f, 9, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getStress_red-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(1), Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(6)), $composer2, 0);
            } else {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1044495958);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.backpack.topbackground.TopBackgroundService$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit OperationButton$lambda$1;
                    OperationButton$lambda$1 = TopBackgroundService.OperationButton$lambda$1(TopBackgroundService.this, icon, text, hasRedPoint, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OperationButton$lambda$1;
                }
            });
        }
    }
}