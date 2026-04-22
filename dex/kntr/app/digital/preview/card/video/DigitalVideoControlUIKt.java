package kntr.app.digital.preview.card.video;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
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
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: DigitalVideoControlUI.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0013\u001a\u0017\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"DigitalVideoControlUI", RoomRecommendViewModel.EMPTY_CURSOR, "duration", RoomRecommendViewModel.EMPTY_CURSOR, "trialDuration", "pause", RoomRecommendViewModel.EMPTY_CURSOR, "isTrial", "caption", RoomRecommendViewModel.EMPTY_CURSOR, "currentProgress", "onValueChange", "Lkotlin/Function1;", "onTrialBtnClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(JJZZLjava/lang/String;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CaptionsUI", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TrialNotice", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DigitalVideoControlUIKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptionsUI$lambda$2(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CaptionsUI(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DigitalVideoControlUI$lambda$1(long j2, long j3, boolean z, boolean z2, String str, long j4, Function1 function1, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DigitalVideoControlUI(j2, j3, z, z2, str, j4, function1, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrialNotice$lambda$1(Modifier modifier, int i, int i2, Composer composer, int i3) {
        TrialNotice(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DigitalVideoControlUI(final long duration, final long trialDuration, final boolean pause, final boolean isTrial, final String caption, final long currentProgress, final Function1<? super Long, Unit> function1, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv2;
        CompositionLocalMap localMap$iv$iv;
        Modifier materialized$iv$iv;
        int i2;
        Composer $composer3;
        int $dirty;
        int i3;
        Object obj;
        float f;
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Intrinsics.checkNotNullParameter(function0, "onTrialBtnClick");
        Composer $composer4 = $composer.startRestartGroup(1925548472);
        ComposerKt.sourceInformation($composer4, "C(DigitalVideoControlUI)N(duration,trialDuration,pause,isTrial,caption,currentProgress,onValueChange,onTrialBtnClick,modifier)49@1984L1995:DigitalVideoControlUI.kt#9zxnub");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(duration) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(trialDuration) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(pause) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changed(isTrial) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changed(caption) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer4.changed(currentProgress) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function0) ? 8388608 : 4194304;
        }
        int i4 = i & 256;
        if (i4 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer4.changed(modifier) ? 67108864 : 33554432;
        }
        if ($composer4.shouldExecute(($dirty2 & 38347923) != 38347922, $dirty2 & 1)) {
            modifier2 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1925548472, $dirty2, -1, "kntr.app.digital.preview.card.video.DigitalVideoControlUI (DigitalVideoControlUI.kt:48)");
            }
            int $changed$iv = ($dirty2 >> 24) & 14;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            int $dirty3 = $dirty2;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$DigitalVideoControlUI_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 940715154, "C62@2364L528,77@2901L1072:DigitalVideoControlUI.kt#9zxnub");
            if (pause) {
                $composer4.startReplaceGroup(940675566);
                ComposerKt.sourceInformation($composer4, "54@2092L52,53@2059L286");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_digital_video_pause(Res.drawable.INSTANCE), $composer4, 0), (String) null, $this$DigitalVideoControlUI_u24lambda_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(56)), Alignment.Companion.getCenter()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer4, Painter.$stable | 48, 120);
            } else {
                $composer4.startReplaceGroup(938636324);
            }
            $composer4.endReplaceGroup();
            SpacerKt.Spacer($this$DigitalVideoControlUI_u24lambda_u240.align(BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(120)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), Alignment.Companion.getBottomCenter()), $composer4, 0);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default($this$DigitalVideoControlUI_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(10), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 334203962, "C100@3711L252:DigitalVideoControlUI.kt#9zxnub");
            if (isTrial) {
                $composer4.startReplaceGroup(334197916);
                ComposerKt.sourceInformation($composer4, "84@3109L242");
                $dirty = $dirty3;
                materialized$iv$iv = materialized$iv$iv3;
                $composer3 = $composer4;
                $composer$iv = $composer4;
                $composer$iv$iv = $composer4;
                $composer$iv2 = $composer4;
                localMap$iv$iv = localMap$iv$iv3;
                i2 = 1;
                TrialNotice(ClickableKt.clickable-oSLSa3U$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(16), Dp.constructor-impl(24), 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), $composer3, 0, 0);
                $composer3.endReplaceGroup();
                i3 = 331122158;
            } else {
                $composer$iv = $composer4;
                $composer$iv$iv = $composer4;
                $composer$iv2 = $composer4;
                localMap$iv$iv = localMap$iv$iv3;
                materialized$iv$iv = materialized$iv$iv3;
                i2 = 1;
                $composer3 = $composer4;
                $dirty = $dirty3;
                i3 = 331122158;
                $composer3.startReplaceGroup(331122158);
                $composer3.endReplaceGroup();
            }
            String str = caption;
            if (((str == null || StringsKt.isBlank(str)) ? i2 : 0) == 0) {
                $composer3.startReplaceGroup(334512876);
                ComposerKt.sourceInformation($composer3, "92@3426L258");
                obj = null;
                f = 0.0f;
                CaptionsUI(caption, SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(16), Dp.constructor-impl(24), 2, (Object) null), 0.0f, i2, (Object) null), $composer3, (($dirty >> 12) & 14) | 48, 0);
            } else {
                obj = null;
                f = 0.0f;
                $composer3.startReplaceGroup(i3);
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer4;
            DigitalVideoSeekBarKt.DigitalVideoSeekBar(duration, trialDuration, currentProgress, function1, SizeKt.fillMaxWidth$default(Modifier.Companion, f, i2, obj), $composer3, ($dirty & 14) | 24576 | ($dirty & 112) | (($dirty >> 9) & 896) | (($dirty >> 9) & 7168), 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.DigitalVideoControlUIKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2, Object obj3) {
                    Unit DigitalVideoControlUI$lambda$1;
                    DigitalVideoControlUI$lambda$1 = DigitalVideoControlUIKt.DigitalVideoControlUI$lambda$1(duration, trialDuration, pause, isTrial, caption, currentProgress, function1, function0, modifier3, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return DigitalVideoControlUI$lambda$1;
                }
            });
        }
    }

    private static final void CaptionsUI(final String caption, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1055331966);
        ComposerKt.sourceInformation($composer2, "C(CaptionsUI)N(caption,modifier)120@4156L257,129@4458L229,118@4083L604:DigitalVideoControlUI.kt#9zxnub");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(caption) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1055331966, $dirty2, -1, "kntr.app.digital.preview.card.video.CaptionsUI (DigitalVideoControlUI.kt:117)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -561732317, "CC(remember):DigitalVideoControlUI.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.digital.preview.card.video.DigitalVideoControlUIKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        ContentTransform CaptionsUI$lambda$0$0;
                        CaptionsUI$lambda$0$0 = DigitalVideoControlUIKt.CaptionsUI$lambda$0$0((AnimatedContentTransitionScope) obj);
                        return CaptionsUI$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AnimatedContentKt.AnimatedContent(caption, (Modifier) null, (Function1) it$iv, (Alignment) null, "captionsAnimation", (Function1) null, ComposableLambdaKt.rememberComposableLambda(-1717181780, true, new Function4() { // from class: kntr.app.digital.preview.card.video.DigitalVideoControlUIKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit CaptionsUI$lambda$1;
                    CaptionsUI$lambda$1 = DigitalVideoControlUIKt.CaptionsUI$lambda$1(modifier3, (AnimatedContentScope) obj, (String) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return CaptionsUI$lambda$1;
                }
            }, $composer2, 54), $composer2, ($dirty2 & 14) | 1597824, 42);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.DigitalVideoControlUIKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit CaptionsUI$lambda$2;
                    CaptionsUI$lambda$2 = DigitalVideoControlUIKt.CaptionsUI$lambda$2(caption, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CaptionsUI$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform CaptionsUI$lambda$0$0(AnimatedContentTransitionScope $this$AnimatedContent) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        return $this$AnimatedContent.using(AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically$default((FiniteAnimationSpec) null, new Function1() { // from class: kntr.app.digital.preview.card.video.DigitalVideoControlUIKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                int CaptionsUI$lambda$0$0$0;
                CaptionsUI$lambda$0$0$0 = DigitalVideoControlUIKt.CaptionsUI$lambda$0$0$0(((Integer) obj).intValue());
                return Integer.valueOf(CaptionsUI$lambda$0$0$0);
            }
        }, 1, (Object) null).plus(EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null)), EnterExitTransitionKt.slideOutVertically$default((FiniteAnimationSpec) null, new Function1() { // from class: kntr.app.digital.preview.card.video.DigitalVideoControlUIKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                int CaptionsUI$lambda$0$0$1;
                CaptionsUI$lambda$0$0$1 = DigitalVideoControlUIKt.CaptionsUI$lambda$0$0$1(((Integer) obj).intValue());
                return Integer.valueOf(CaptionsUI$lambda$0$0$1);
            }
        }, 1, (Object) null).plus(EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null))), AnimatedContentKt.SizeTransform$default(false, (Function2) null, 2, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CaptionsUI$lambda$0$0$0(int height) {
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CaptionsUI$lambda$0$0$1(int height) {
        return -height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CaptionsUI$lambda$1(Modifier $modifier, AnimatedContentScope $this$AnimatedContent, String targetText, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        ComposerKt.sourceInformation($composer, "CN(targetText)133@4582L9,130@4482L199:DigitalVideoControlUI.kt#9zxnub");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1717181780, $changed, -1, "kntr.app.digital.preview.card.video.CaptionsUI.<anonymous> (DigitalVideoControlUI.kt:130)");
        }
        TextKt.Text-Nvy7gAk(targetText, $modifier, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, (($changed >> 3) & 14) | 384, 0, 130040);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void TrialNotice(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-814575748);
        ComposerKt.sourceInformation($composer2, "C(TrialNotice)N(modifier)142@4764L697:DigitalVideoControlUI.kt#9zxnub");
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
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-814575748, $dirty, -1, "kntr.app.digital.preview.card.video.TrialNotice (DigitalVideoControlUI.kt:141)");
            }
            Modifier modifier$iv = SizeKt.wrapContentSize$default(PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(modifier3, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(44))), Dp.constructor-impl(24), Dp.constructor-impl(5)), (Alignment) null, false, 3, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier4 = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -799179258, "C150@5142L9,150@5074L82,152@5193L55,151@5165L290:DigitalVideoControlUI.kt#9zxnub");
            TextKt.Text-Nvy7gAk("正在试听，获得后可听完整版", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 390, 0, 131066);
            IconKt.Icon-ww6aTOc(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getDigital_trial_right_arrow(Res.drawable.INSTANCE), $composer2, 0), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(12)), Color.Companion.getWhite-0d7_KjU(), $composer2, Painter.$stable | 3504, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.DigitalVideoControlUIKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TrialNotice$lambda$1;
                    TrialNotice$lambda$1 = DigitalVideoControlUIKt.TrialNotice$lambda$1(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TrialNotice$lambda$1;
                }
            });
        }
    }
}