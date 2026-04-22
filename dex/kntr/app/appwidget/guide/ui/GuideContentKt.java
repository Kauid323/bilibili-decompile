package kntr.app.appwidget.guide.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.appwidget.guide.generated.resources.Drawable0_commonMainKt;
import srcs.app.appwidget.guide.generated.resources.Res;

/* compiled from: GuideContent.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"GuideContent", RoomRecommendViewModel.EMPTY_CURSOR, "guideData", "Lkntr/app/appwidget/guide/ui/PopupData;", "windowWidth", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/appwidget/guide/ui/PopupData;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "Avatar", "imageUrl", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Avatars", "firstAvatar", "secondAvatar", "forceDark", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "guide_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GuideContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Avatar$lambda$2(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Avatar(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Avatars$lambda$2(String str, String str2, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Avatars(str, str2, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideContent$lambda$1(PopupData popupData, Integer num, int i, int i2, Composer composer, int i3) {
        GuideContent(popupData, num, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void GuideContent(final PopupData guideData, final Integer windowWidth, Composer $composer, final int $changed, final int i) {
        ThemeStrategy themeStrategy;
        Intrinsics.checkNotNullParameter(guideData, "guideData");
        Composer $composer2 = $composer.startRestartGroup(263588014);
        ComposerKt.sourceInformation($composer2, "C(GuideContent)N(guideData,windowWidth)64@2496L4868,57@2301L5063:GuideContent.kt#88uxtj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(guideData) : $composer2.changedInstance(guideData) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(windowWidth) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                windowWidth = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(263588014, $dirty2, -1, "kntr.app.appwidget.guide.ui.GuideContent (GuideContent.kt:56)");
            }
            if (guideData.getForceDark()) {
                themeStrategy = ThemeStrategy.ForceDay;
            } else {
                themeStrategy = ThemeStrategy.FollowApp;
            }
            BiliThemeKt.BiliTheme(themeStrategy, false, ComposableLambdaKt.rememberComposableLambda(760591350, true, new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit GuideContent$lambda$0;
                    GuideContent$lambda$0 = GuideContentKt.GuideContent$lambda$0(windowWidth, guideData, (Composer) obj, ((Integer) obj2).intValue());
                    return GuideContent$lambda$0;
                }
            }, $composer2, 54), $composer2, 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit GuideContent$lambda$1;
                    GuideContent$lambda$1 = GuideContentKt.GuideContent$lambda$1(PopupData.this, windowWidth, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GuideContent$lambda$1;
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -123
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit GuideContent$lambda$0(java.lang.Integer r133, kntr.app.appwidget.guide.ui.PopupData r134, androidx.compose.runtime.Composer r135, int r136) {
        /*
            Method dump skipped, instructions count: 2982
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.appwidget.guide.ui.GuideContentKt.GuideContent$lambda$0(java.lang.Integer, kntr.app.appwidget.guide.ui.PopupData, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideContent$lambda$0$3$0$1$0(PopupData $guideData) {
        $guideData.performAction();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideContent$lambda$0$3$1$0$0(PopupData $guideData) {
        $guideData.dismiss(false);
        return Unit.INSTANCE;
    }

    private static final void Avatar(final String imageUrl, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        final Modifier modifier3;
        Composer $composer3 = $composer.startRestartGroup(705929283);
        ComposerKt.sourceInformation($composer3, "C(Avatar)N(imageUrl,modifier)178@7507L385,197@8076L17,193@7898L202:GuideContent.kt#88uxtj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(imageUrl) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(705929283, $dirty2, -1, "kntr.app.appwidget.guide.ui.Avatar (GuideContent.kt:177)");
            }
            final Function2 placeHolder = ComposableLambdaKt.rememberComposableLambda(636841672, true, new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit Avatar$lambda$0;
                    Avatar$lambda$0 = GuideContentKt.Avatar$lambda$0(modifier3, (Composer) obj, ((Integer) obj2).intValue());
                    return Avatar$lambda$0;
                }
            }, $composer3, 54);
            Modifier modifier4 = modifier3;
            $composer2 = $composer3;
            BiliImageKt.BiliImage(new ImageRequest(imageUrl).build(), ClipKt.clip(SizeKt.size-3ABfNKs(modifier3, Dp.constructor-impl(40)), RoundedCornerShapeKt.getCircleShape()), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, placeHolder, ComposableLambdaKt.rememberComposableLambda(896689076, true, new Function4() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit Avatar$lambda$1;
                    Avatar$lambda$1 = GuideContentKt.Avatar$lambda$1(placeHolder, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return Avatar$lambda$1;
                }
            }, $composer3, 54), $composer3, 113246208, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit Avatar$lambda$2;
                    Avatar$lambda$2 = GuideContentKt.Avatar$lambda$2(imageUrl, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Avatar$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Avatar$lambda$0(Modifier $modifier, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C184@7692L6,179@7517L369:GuideContent.kt#88uxtj");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(636841672, $changed, -1, "kntr.app.appwidget.guide.ui.Avatar.<anonymous> (GuideContent.kt:179)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs($modifier, Dp.constructor-impl(40)), RoundedCornerShapeKt.getCircleShape()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 802813177, "C187@7773L47,186@7740L136:GuideContent.kt#88uxtj");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_default_avatar(Res.drawable.INSTANCE), $composer, 0), RoomRecommendViewModel.EMPTY_CURSOR, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, 124);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final Unit Avatar$lambda$1(Function2 $placeHolder, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)197@8078L13:GuideContent.kt#88uxtj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(896689076, $changed, -1, "kntr.app.appwidget.guide.ui.Avatar.<anonymous> (GuideContent.kt:197)");
        }
        $placeHolder.invoke($composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x028e, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Avatars(final String firstAvatar, final String secondAvatar, final boolean forceDark, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        final Modifier modifier4;
        final long borderColor;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(1412353257);
        ComposerKt.sourceInformation($composer3, "C(Avatars)N(firstAvatar,secondAvatar,forceDark,modifier)208@8297L385,225@8779L1376:GuideContent.kt#88uxtj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(firstAvatar) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(secondAvatar) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(forceDark) ? 256 : 128;
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
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412353257, $dirty2, -1, "kntr.app.appwidget.guide.ui.Avatars (GuideContent.kt:207)");
            }
            final Function2 placeHolder = ComposableLambdaKt.rememberComposableLambda(116715886, true, new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit Avatars$lambda$0;
                    Avatars$lambda$0 = GuideContentKt.Avatars$lambda$0(modifier4, (Composer) obj, ((Integer) obj2).intValue());
                    return Avatars$lambda$0;
                }
            }, $composer3, 54);
            if (forceDark) {
                $composer3.startReplaceGroup(61834092);
                ComposerKt.sourceInformation($composer3, "223@8731L6");
                borderColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa9-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(61834930);
                ComposerKt.sourceInformation($composer3, "223@8757L6");
                borderColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv = SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(70), Dp.constructor-impl(40));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((6 >> 6) & 112) | 6;
            BoxScope $this$Avatars_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 102557326, "C238@9176L17,239@9225L17,231@8915L338,247@9431L361,243@9291L858:GuideContent.kt#88uxtj");
            BiliImageKt.BiliImage(new ImageRequest(secondAvatar).build(), ClipKt.clip($this$Avatars_u24lambda_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), Alignment.Companion.getCenterEnd()), RoundedCornerShapeKt.getCircleShape()), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.rememberComposableLambda(-257732770, true, new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit Avatars$lambda$1$0;
                    Avatars$lambda$1$0 = GuideContentKt.Avatars$lambda$1$0(placeHolder, (Composer) obj, ((Integer) obj2).intValue());
                    return Avatars$lambda$1$0;
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(367981524, true, new Function4() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit Avatars$lambda$1$1;
                    Avatars$lambda$1$1 = GuideContentKt.Avatars$lambda$1$1(placeHolder, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return Avatars$lambda$1$1;
                }
            }, $composer3, 54), $composer3, 113246208, 124);
            Modifier align = $this$Avatars_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer3, 280418604, "CC(remember):GuideContent.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(borderColor);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = new Function1() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit Avatars$lambda$1$2$0;
                    Avatars$lambda$1$2$0 = GuideContentKt.Avatars$lambda$1$2$0(borderColor, (ContentDrawScope) obj);
                    return Avatars$lambda$1$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = DrawModifierKt.drawWithContent(align, (Function1) value$iv);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -177409917, "C263@10054L17,264@10107L17,257@9818L321:GuideContent.kt#88uxtj");
            BiliImageKt.BiliImage(new ImageRequest(firstAvatar).build(), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), RoundedCornerShapeKt.getCircleShape()), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.rememberComposableLambda(-1968185286, true, new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Avatars$lambda$1$3$0;
                    Avatars$lambda$1$3$0 = GuideContentKt.Avatars$lambda$1$3$0(placeHolder, (Composer) obj, ((Integer) obj2).intValue());
                    return Avatars$lambda$1$3$0;
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(-1953880528, true, new Function4() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit Avatars$lambda$1$3$1;
                    Avatars$lambda$1$3$1 = GuideContentKt.Avatars$lambda$1$3$1(placeHolder, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return Avatars$lambda$1$3$1;
                }
            }, $composer3, 54), $composer3, 113246208, 124);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit Avatars$lambda$2;
                    Avatars$lambda$2 = GuideContentKt.Avatars$lambda$2(firstAvatar, secondAvatar, forceDark, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Avatars$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Avatars$lambda$0(Modifier $modifier, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C214@8482L6,209@8307L369:GuideContent.kt#88uxtj");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(116715886, $changed, -1, "kntr.app.appwidget.guide.ui.Avatars.<anonymous> (GuideContent.kt:209)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs($modifier, Dp.constructor-impl(40)), RoundedCornerShapeKt.getCircleShape()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1984570221, "C217@8563L47,216@8530L136:GuideContent.kt#88uxtj");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_default_avatar(Res.drawable.INSTANCE), $composer, 0), RoomRecommendViewModel.EMPTY_CURSOR, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, 124);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final Unit Avatars$lambda$1$0(Function2 $placeHolder, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C238@9178L13:GuideContent.kt#88uxtj");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-257732770, $changed, -1, "kntr.app.appwidget.guide.ui.Avatars.<anonymous>.<anonymous> (GuideContent.kt:238)");
            }
            $placeHolder.invoke($composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Avatars$lambda$1$1(Function2 $placeHolder, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)239@9227L13:GuideContent.kt#88uxtj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(367981524, $changed, -1, "kntr.app.appwidget.guide.ui.Avatars.<anonymous>.<anonymous> (GuideContent.kt:239)");
        }
        $placeHolder.invoke($composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Avatars$lambda$1$2$0(long $borderColor, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        float f = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(20));
        float x$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(20));
        float y$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(20));
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        DrawScope.-CC.drawCircle-VaOC9Bg$default((DrawScope) $this$drawWithContent, $borderColor, f, Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)), 0.0f, new Stroke($this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(2)), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 104, (Object) null);
        $this$drawWithContent.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Avatars$lambda$1$3$0(Function2 $placeHolder, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C263@10056L13:GuideContent.kt#88uxtj");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968185286, $changed, -1, "kntr.app.appwidget.guide.ui.Avatars.<anonymous>.<anonymous>.<anonymous> (GuideContent.kt:263)");
            }
            $placeHolder.invoke($composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Avatars$lambda$1$3$1(Function2 $placeHolder, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)264@10109L13:GuideContent.kt#88uxtj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1953880528, $changed, -1, "kntr.app.appwidget.guide.ui.Avatars.<anonymous>.<anonymous>.<anonymous> (GuideContent.kt:264)");
        }
        $placeHolder.invoke($composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}