package kntr.app.digital.preview.button;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
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
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.action.HandleAction;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DigitalButtonsService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\fJK\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/button/DigitalButtonsService;", RoomRecommendViewModel.EMPTY_CURSOR, "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "handleAction", "Lkntr/app/digital/preview/action/HandleAction;", "<init>", "(Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/app/digital/preview/action/HandleAction;)V", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DigitalButtonUI", "text", RoomRecommendViewModel.EMPTY_CURSOR, "textColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "backgroundColor", RoomRecommendViewModel.EMPTY_CURSOR, "badgeImageUrl", "DigitalButtonUI-qi6gXK8", "(Ljava/lang/String;JJLjava/util/List;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalButtonsService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final HandleAction handleAction;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(DigitalButtonsService digitalButtonsService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        digitalButtonsService.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalButtonUI_qi6gXK8$lambda$1(DigitalButtonsService digitalButtonsService, String str, long j2, long j3, List list, Modifier modifier, String str2, int i, int i2, Composer composer, int i3) {
        digitalButtonsService.m923DigitalButtonUIqi6gXK8(str, j2, j3, list, modifier, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public DigitalButtonsService(DigitalCardStateService cardStateService, HandleAction handleAction) {
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(handleAction, "handleAction");
        this.cardStateService = cardStateService;
        this.handleAction = handleAction;
    }

    public final void Content(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier materialized$iv$iv;
        Modifier itemModifier;
        Composer $composer2 = $composer.startRestartGroup(746724326);
        ComposerKt.sourceInformation($composer2, "C(Content)N(modifier)40@1594L1237:DigitalButtonsService.kt#xi2lmw");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(746724326, $dirty2, -1, "kntr.app.digital.preview.button.DigitalButtonsService.Content (DigitalButtonsService.kt:37)");
            }
            CardBasic basic = this.cardStateService.getCurrentCardItem().getBasic();
            List buttons = basic.getButtons();
            int $changed$iv = ($dirty2 & 14) | 432;
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Composer $composer$iv = $composer2;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(16), Alignment.Companion.getCenterHorizontally());
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            Modifier modifier$iv$iv = modifier$iv;
            Composer $composer$iv$iv = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv.startReusableNode();
            if ($composer$iv$iv.getInserting()) {
                $composer$iv$iv.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv2 = $composer$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$Content_u24lambda_u240 = RowScopeInstance.INSTANCE;
            Composer $composer3 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1419976149, "C:DigitalButtonsService.kt#xi2lmw");
            if (buttons.size() != 1) {
                materialized$iv$iv = materialized$iv$iv2;
                itemModifier = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$Content_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(47));
            } else {
                materialized$iv$iv = materialized$iv$iv2;
                itemModifier = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(164)), Dp.constructor-impl(47));
            }
            $composer3.startReplaceGroup(-1846909406);
            ComposerKt.sourceInformation($composer3, "*64@2677L99,56@2257L542");
            List $this$forEach$iv = buttons;
            for (Object element$iv : $this$forEach$iv) {
                final DigitalButton button = (DigitalButton) element$iv;
                String text = button.getText();
                long m922getTextColor0d7_KjU = button.m922getTextColor0d7_KjU();
                long m921getBorderColor0d7_KjU = button.m921getBorderColor0d7_KjU();
                List<Color> backgroundColor = button.getBackgroundColor();
                String badgeImageUrl = button.getBadgeImageUrl();
                Composer $composer$iv$iv2 = $composer$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, -492413440, "CC(remember):DigitalButtonsService.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(this) | $composer2.changedInstance(button);
                Composer $this$cache$iv = $composer3;
                CompositionLocalMap localMap$iv$iv2 = localMap$iv$iv;
                Object it$iv = $this$cache$iv.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Composer $composer4 = $composer3;
                    m923DigitalButtonUIqi6gXK8(text, m922getTextColor0d7_KjU, m921getBorderColor0d7_KjU, backgroundColor, ClickableKt.clickable-oSLSa3U$default(itemModifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), badgeImageUrl, $composer4, ($dirty2 << 15) & 3670016, 0);
                    horizontalArrangement$iv = horizontalArrangement$iv;
                    $dirty2 = $dirty2;
                    $composer3 = $composer4;
                    $composer$iv$iv = $composer$iv$iv2;
                    localMap$iv$iv = localMap$iv$iv2;
                    $composer$iv2 = $composer$iv2;
                    modifier$iv$iv = modifier$iv$iv;
                    $composer$iv = $composer$iv;
                    verticalAlignment$iv = verticalAlignment$iv;
                }
                Object value$iv = new Function0() { // from class: kntr.app.digital.preview.button.DigitalButtonsService$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit Content$lambda$0$0$0$0;
                        Content$lambda$0$0$0$0 = DigitalButtonsService.Content$lambda$0$0$0$0(DigitalButtonsService.this, button);
                        return Content$lambda$0$0$0$0;
                    }
                };
                $this$cache$iv.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Composer $composer42 = $composer3;
                m923DigitalButtonUIqi6gXK8(text, m922getTextColor0d7_KjU, m921getBorderColor0d7_KjU, backgroundColor, ClickableKt.clickable-oSLSa3U$default(itemModifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), badgeImageUrl, $composer42, ($dirty2 << 15) & 3670016, 0);
                horizontalArrangement$iv = horizontalArrangement$iv;
                $dirty2 = $dirty2;
                $composer3 = $composer42;
                $composer$iv$iv = $composer$iv$iv2;
                localMap$iv$iv = localMap$iv$iv2;
                $composer$iv2 = $composer$iv2;
                modifier$iv$iv = modifier$iv$iv;
                $composer$iv = $composer$iv;
                verticalAlignment$iv = verticalAlignment$iv;
            }
            Composer $composer5 = $composer3;
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.button.DigitalButtonsService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = DigitalButtonsService.Content$lambda$1(DigitalButtonsService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$0$0$0(DigitalButtonsService this$0, DigitalButton $button) {
        this$0.handleAction.invoke($button.getAction());
        return Unit.INSTANCE;
    }

    /* renamed from: DigitalButtonUI-qi6gXK8  reason: not valid java name */
    public final void m923DigitalButtonUIqi6gXK8(final String text, final long j2, final long j3, final List<Color> list, Modifier modifier, String badgeImageUrl, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Composer $composer2;
        Modifier modifier3;
        String badgeImageUrl2;
        Composer $composer$iv$iv;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        int i3;
        Modifier modifier4;
        Modifier modifier5;
        Function0 factory$iv$iv$iv;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer4 = $composer.startRestartGroup(-778596275);
        ComposerKt.sourceInformation($composer4, "C(DigitalButtonUI)N(text,textColor:c#ui.graphics.Color,borderColor:c#ui.graphics.Color,backgroundColor,modifier,badgeImageUrl)81@3130L2061:DigitalButtonsService.kt#xi2lmw");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(j2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(j3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changedInstance(list) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            str = badgeImageUrl;
        } else if ((196608 & $changed) == 0) {
            str = badgeImageUrl;
            $dirty |= $composer4.changed(str) ? 131072 : 65536;
        } else {
            str = badgeImageUrl;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            if (i4 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i5 == 0) {
                badgeImageUrl2 = str;
            } else {
                badgeImageUrl2 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-778596275, $dirty2, -1, "kntr.app.digital.preview.button.DigitalButtonsService.DigitalButtonUI (DigitalButtonsService.kt:80)");
            }
            int $changed$iv = ($dirty2 >> 12) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$DigitalButtonUI_qi6gXK8_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1827435449, "C84@3204L1507:DigitalButtonsService.kt#xi2lmw");
            Modifier it = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(40));
            List<Color> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                $composer$iv$iv = $composer4;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str3 = "C72@3469L9:Box.kt#2w3rfo";
                str4 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                i2 = 1;
                i3 = 0;
                modifier4 = it;
            } else {
                $composer$iv$iv = $composer4;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str4 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                i2 = 1;
                i3 = 0;
                str3 = "C72@3469L9:Box.kt#2w3rfo";
                modifier4 = BackgroundKt.background$default(it, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, list, 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape(), 0.0f, 4, (Object) null);
            }
            Modifier it2 = modifier4;
            if ((j3 != 16 ? i2 : i3) != 0) {
                modifier5 = BorderKt.border-xT4_qwU(it2, Dp.constructor-impl((float) 0.5d), j3, RoundedCornerShapeKt.getCircleShape());
            } else {
                modifier5 = it2;
            }
            Modifier modifier$iv2 = $this$DigitalButtonUI_qi6gXK8_u24lambda_u240.align(modifier5, Alignment.Companion.getBottomCenter());
            int $changed$iv2 = i3;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, str4);
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = ($changed$iv2 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, str5);
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, i3));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, str2);
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, str3);
            int i9 = (($changed$iv2 >> 6) & 112) | 6;
            BoxScope $this$DigitalButtonUI_qi6gXK8_u24lambda_u240_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -421241604, "C112@4484L9,110@4399L294:DigitalButtonsService.kt#xi2lmw");
            $composer2 = $composer4;
            TextKt.Text-Nvy7gAk(text, $this$DigitalButtonUI_qi6gXK8_u24lambda_u240_u242.align(Modifier.Companion, Alignment.Companion.getCenter()), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16(), $composer4, ($dirty2 & 14) | (($dirty2 << 3) & 896), 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (!StringsKt.isBlank(badgeImageUrl2)) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-1825939173);
                ComposerKt.sourceInformation($composer3, "121@4783L376");
                String $this$asRequest_u24default$iv = badgeImageUrl2;
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), PaddingKt.padding-VpY3zN4$default($this$DigitalButtonUI_qi6gXK8_u24lambda_u240.align(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), Dp.constructor-impl(16)), Alignment.Companion.getTopEnd()), Dp.constructor-impl(5), 0.0f, 2, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 0, 508);
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-1830675973);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            badgeImageUrl2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final String str6 = badgeImageUrl2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.button.DigitalButtonsService$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DigitalButtonUI_qi6gXK8$lambda$1;
                    DigitalButtonUI_qi6gXK8$lambda$1 = DigitalButtonsService.DigitalButtonUI_qi6gXK8$lambda$1(DigitalButtonsService.this, text, j2, j3, list, modifier6, str6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DigitalButtonUI_qi6gXK8$lambda$1;
                }
            });
        }
    }
}