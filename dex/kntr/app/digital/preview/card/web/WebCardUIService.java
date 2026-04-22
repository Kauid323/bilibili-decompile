package kntr.app.digital.preview.card.web;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.DigitalItemContainerKt;
import kntr.app.digital.preview.card.image.ImageModuleKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebCardUIService.kt */
@BusinessScope
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/digital/preview/card/web/WebCardUIService;", RoomRecommendViewModel.EMPTY_CURSOR, "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "webCardService", "Lkntr/app/digital/preview/card/web/DigitalWebCardService;", "<init>", "(Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/app/digital/preview/card/web/DigitalWebCardService;)V", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "cardBasic", "Lkntr/app/digital/preview/card/CardBasic;", "data", "Lkntr/app/digital/preview/card/web/WebCard;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/digital/preview/card/CardBasic;Lkntr/app/digital/preview/card/web/WebCard;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebCardUIService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final DigitalWebCardService webCardService;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(WebCardUIService webCardUIService, CardBasic cardBasic, WebCard webCard, Modifier modifier, int i, int i2, Composer composer, int i3) {
        webCardUIService.Content(cardBasic, webCard, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public WebCardUIService(DigitalCardStateService cardStateService, DigitalWebCardService webCardService) {
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(webCardService, "webCardService");
        this.cardStateService = cardStateService;
        this.webCardService = webCardService;
    }

    public final void Content(final CardBasic cardBasic, final WebCard data, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(cardBasic, "cardBasic");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer2 = $composer.startRestartGroup(-943893154);
        ComposerKt.sourceInformation($composer2, "C(Content)N(cardBasic,data,modifier)35@1304L1536:WebCardUIService.kt#yfljjo");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(cardBasic) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(data) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-943893154, $dirty2, -1, "kntr.app.digital.preview.card.web.WebCardUIService.Content (WebCardUIService.kt:34)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$Content_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1982719496, "C40@1592L492,56@2321L505,52@2102L724:WebCardUIService.kt#yfljjo");
            int currentIndex = this.cardStateService.getIndex();
            boolean isSelected = this.cardStateService.indexByCardId(cardBasic.getUniqueId()) == currentIndex;
            boolean webViewVisible = this.webCardService.getWebViewVisible();
            SmeltCardContent_androidKt.getSmeltCardContent().invoke(this.webCardService.getSmeltState(), isSelected, AlphaKt.alpha(AspectRatioKt.aspectRatio$default(SizeKt.width-3ABfNKs(SizeKt.wrapContentSize$default($this$Content_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getCenter()), (Alignment) null, true, 1, (Object) null), this.cardStateService.m930getMaxWidthD9Ej5fM()), 0.80648065f, false, 2, (Object) null), webViewVisible ? 1.0f : 0.0f), $composer2, 0);
            AnimatedVisibilityKt.AnimatedVisibility((isSelected && webViewVisible) ? false : true, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(750, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1425391812, true, new Function3() { // from class: kntr.app.digital.preview.card.web.WebCardUIService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Content$lambda$0$0;
                    Content$lambda$0$0 = WebCardUIService.Content$lambda$0$0(CardBasic.this, data, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Content$lambda$0$0;
                }
            }, $composer2, 54), $composer2, 200064, 18);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.web.WebCardUIService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = WebCardUIService.Content$lambda$1(WebCardUIService.this, cardBasic, data, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$0(CardBasic $cardBasic, final WebCard $data, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C62@2614L194,57@2343L465:WebCardUIService.kt#yfljjo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1425391812, $changed, -1, "kntr.app.digital.preview.card.web.WebCardUIService.Content.<anonymous>.<anonymous> (WebCardUIService.kt:57)");
        }
        DigitalItemContainerKt.DigitalCardContainer($cardBasic.getFrameImg(), $cardBasic.getLeftTopTagImg(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $cardBasic.getHasMask(), ComposableLambdaKt.rememberComposableLambda(521356029, true, new Function3() { // from class: kntr.app.digital.preview.card.web.WebCardUIService$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit Content$lambda$0$0$0;
                Content$lambda$0$0$0 = WebCardUIService.Content$lambda$0$0$0(WebCard.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return Content$lambda$0$0$0;
            }
        }, $composer, 54), $composer, 24960, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$0$0(WebCard $data, BoxScope $this$DigitalCardContainer, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$DigitalCardContainer, "$this$DigitalCardContainer");
        ComposerKt.sourceInformation($composer, "C63@2640L146:WebCardUIService.kt#yfljjo");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(521356029, $changed, -1, "kntr.app.digital.preview.card.web.WebCardUIService.Content.<anonymous>.<anonymous>.<anonymous> (WebCardUIService.kt:63)");
            }
            ImageModuleKt.ImageUI($data.getImageUrl(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}