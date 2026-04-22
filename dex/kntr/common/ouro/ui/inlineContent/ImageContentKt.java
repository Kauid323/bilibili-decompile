package kntr.common.ouro.ui.inlineContent;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.ouro.core.model.node.renderable.OuroDivider;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageContent.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a?\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a#\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\u0018\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"RemoteImageContent", "", "node", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage;", "(Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage;Landroidx/compose/runtime/Composer;I)V", "Divider", "Lkntr/common/ouro/core/model/node/renderable/OuroDivider;", "(Lkntr/common/ouro/core/model/node/renderable/OuroDivider;Landroidx/compose/runtime/Composer;I)V", "UploadProgress", "progress", "", "modifier", "Landroidx/compose/ui/Modifier;", "strokeWidth", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "progressColor", "UploadProgress-jA1GFJw", "(FLandroidx/compose/ui/Modifier;FJJLandroidx/compose/runtime/Composer;II)V", "UploadFail", "throwable", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/Throwable;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "animatedProgress"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Divider$lambda$0(OuroDivider ouroDivider, int i, Composer composer, int i2) {
        Divider(ouroDivider, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RemoteImageContent$lambda$1(OuroRemoteImage ouroRemoteImage, int i, Composer composer, int i2) {
        RemoteImageContent(ouroRemoteImage, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadFail$lambda$1(Modifier modifier, Throwable th, int i, int i2, Composer composer, int i3) {
        UploadFail(modifier, th, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadProgress_jA1GFJw$lambda$2(float f, Modifier modifier, float f2, long j, long j2, int i, int i2, Composer composer, int i3) {
        m2083UploadProgressjA1GFJw(f, modifier, f2, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void RemoteImageContent(final OuroRemoteImage node, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(node, "node");
        Composer $composer2 = $composer.startRestartGroup(-1409104549);
        ComposerKt.sourceInformation($composer2, "C(RemoteImageContent)N(node)42@1857L617:ImageContent.kt#ldidgb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(node) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1409104549, $dirty2, -1, "kntr.common.ouro.ui.inlineContent.RemoteImageContent (ImageContent.kt:41)");
            }
            String $this$asRequest$iv = node.getLightImageURL();
            ImageRequest $this$RemoteImageContent_u24lambda_u240 = new ImageRequest($this$asRequest$iv);
            $this$RemoteImageContent_u24lambda_u240.contentScale(ContentScale.Companion.getCrop());
            BiliImageKt.BiliImage($this$RemoteImageContent_u24lambda_u240.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), "", null, null, null, null, ComposableSingletons$ImageContentKt.INSTANCE.getLambda$449999126$ui_debug(), ComposableSingletons$ImageContentKt.INSTANCE.getLambda$1821109900$ui_debug(), $composer2, 113246640, BackoffConfigKt.MAX_DELAY_SECONDS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.inlineContent.ImageContentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RemoteImageContent$lambda$1;
                    RemoteImageContent$lambda$1 = ImageContentKt.RemoteImageContent$lambda$1(OuroRemoteImage.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return RemoteImageContent$lambda$1;
                }
            });
        }
    }

    public static final void Divider(final OuroDivider node, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(node, "node");
        Composer $composer2 = $composer.startRestartGroup(406539576);
        ComposerKt.sourceInformation($composer2, "C(Divider)N(node)105@3873L6,105@3814L78:ImageContent.kt#ldidgb");
        if (!$composer2.shouldExecute(($changed & 1) != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(406539576, $changed, -1, "kntr.common.ouro.ui.inlineContent.Divider (ImageContent.kt:104)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_light-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.inlineContent.ImageContentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Divider$lambda$0;
                    Divider$lambda$0 = ImageContentKt.Divider$lambda$0(OuroDivider.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Divider$lambda$0;
                }
            });
        }
    }

    /* renamed from: UploadProgress-jA1GFJw  reason: not valid java name */
    public static final void m2083UploadProgressjA1GFJw(final float progress, Modifier modifier, float strokeWidth, long j, long j2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        long j3;
        long j4;
        Modifier modifier3;
        float strokeWidth2;
        long j5;
        Composer $composer2 = $composer.startRestartGroup(-1010588752);
        ComposerKt.sourceInformation($composer2, "C(UploadProgress)N(progress,modifier,strokeWidth,backgroundColor:c#ui.graphics.Color,progressColor:c#ui.graphics.Color)117@4181L111,122@4326L959,122@4298L987:ImageContent.kt#ldidgb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            f = strokeWidth;
        } else if (($changed & 384) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = strokeWidth;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(j) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            j3 = j2;
        } else if (($changed & 24576) == 0) {
            j3 = j2;
            $dirty |= $composer2.changed(j3) ? 16384 : 8192;
        } else {
            j3 = j2;
        }
        if ($composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                strokeWidth2 = f;
            } else {
                strokeWidth2 = 4.0f;
            }
            if (i4 == 0) {
                j4 = j;
            } else {
                j4 = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            if (i5 != 0) {
                j3 = Color.Companion.getWhite-0d7_KjU();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1010588752, $dirty, -1, "kntr.common.ouro.ui.inlineContent.UploadProgress (ImageContent.kt:115)");
            }
            int $dirty2 = $dirty;
            final State animatedProgress$delegate = AnimateAsStateKt.animateFloatAsState(progress, AnimationSpecKt.tween$default(500, 0, (Easing) null, 6, (Object) null), 0.0f, (String) null, (Function1) null, $composer2, ($dirty & 14) | 48, 28);
            ComposerKt.sourceInformationMarkerStart($composer2, -513167441, "CC(remember):ImageContent.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 896) == 256) | (($dirty2 & 7168) == 2048) | $composer2.changed(animatedProgress$delegate) | ((57344 & $dirty2) == 16384);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                final long j6 = j4;
                final float f2 = strokeWidth2;
                final long j7 = j3;
                Object value$iv = new Function1() { // from class: kntr.common.ouro.ui.inlineContent.ImageContentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit UploadProgress_jA1GFJw$lambda$1$0;
                        UploadProgress_jA1GFJw$lambda$1$0 = ImageContentKt.UploadProgress_jA1GFJw$lambda$1$0(j6, f2, j7, animatedProgress$delegate, (DrawScope) obj);
                        return UploadProgress_jA1GFJw$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier3, (Function1) it$iv, $composer2, ($dirty2 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j5 = j3;
        } else {
            $composer2.skipToGroupEnd();
            j4 = j;
            modifier3 = modifier2;
            strokeWidth2 = f;
            j5 = j3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final float f3 = strokeWidth2;
            final long j8 = j4;
            final long j9 = j5;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.inlineContent.ImageContentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit UploadProgress_jA1GFJw$lambda$2;
                    UploadProgress_jA1GFJw$lambda$2 = ImageContentKt.UploadProgress_jA1GFJw$lambda$2(progress, modifier4, f3, j8, j9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UploadProgress_jA1GFJw$lambda$2;
                }
            });
        }
    }

    private static final float UploadProgress_jA1GFJw$lambda$0(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadProgress_jA1GFJw$lambda$1$0(long j, float $strokeWidth, long j2, State $animatedProgress$delegate, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float f = 2;
        float radius = Size.getMinDimension-impl($this$Canvas.getSize-NH-jbRc()) / f;
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        float x$iv = Float.intBitsToFloat(bits$iv$iv$iv) / f;
        int bits$iv$iv$iv2 = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2) / f;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long center = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, j, radius, center, 0.0f, new Stroke($strokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 104, (Object) null);
        if (UploadProgress_jA1GFJw$lambda$0($animatedProgress$delegate) > 0.0f) {
            float UploadProgress_jA1GFJw$lambda$0 = UploadProgress_jA1GFJw$lambda$0($animatedProgress$delegate) * 360.0f;
            int bits$iv$iv$iv3 = (int) (center >> 32);
            float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv3) - radius;
            int bits$iv$iv$iv4 = (int) (center & 4294967295L);
            float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv4) - radius;
            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            long j3 = Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
            float width$iv = radius * f;
            float height$iv = f * radius;
            long v1$iv$iv3 = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv3 = Float.floatToRawIntBits(height$iv);
            DrawScope.-CC.drawArc-yD3GUKo$default($this$Canvas, j2, -90.0f, UploadProgress_jA1GFJw$lambda$0, false, j3, Size.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L)), 0.0f, new Stroke($strokeWidth, 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 832, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void UploadFail(Modifier modifier, Throwable throwable, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final Throwable throwable2;
        Modifier modifier3;
        Throwable throwable3;
        Function0 factory$iv$iv$iv;
        Throwable throwable4;
        boolean z;
        Composer $composer2 = $composer.startRestartGroup(36728613);
        ComposerKt.sourceInformation($composer2, "C(UploadFail)N(modifier,throwable)162@5403L978:ImageContent.kt#ldidgb");
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            throwable2 = throwable;
        } else if (($changed & 48) == 0) {
            throwable2 = throwable;
            $dirty |= $composer2.changedInstance(throwable2) ? 32 : 16;
        } else {
            throwable2 = throwable;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                throwable3 = throwable2;
            } else {
                throwable3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(36728613, $dirty, -1, "kntr.common.ouro.ui.inlineContent.UploadFail (ImageContent.kt:161)");
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(4), Alignment.Companion.getCenterVertically());
            int $changed$iv = ($dirty & 14) | 432;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier3;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1923845714, "C172@5722L21,175@5862L6,171@5681L204,180@5992L9,181@6037L6,177@5894L166:ImageContent.kt#ldidgb");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_replay_line_500($composer2, 6), "图片上传失败", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
            TextKt.Text-Nvy7gAk("图片上传失败", Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, 54, 0, 131064);
            String message = throwable3 != null ? throwable3.getMessage() : null;
            if (throwable3 != null) {
                if (message != null) {
                    if (message.length() > 0) {
                        z = true;
                        if (z) {
                            $composer2.startReplaceGroup(1924324942);
                            ComposerKt.sourceInformation($composer2, "188@6289L9,189@6338L6,185@6180L185");
                            throwable4 = throwable3;
                            TextKt.Text-Nvy7gAk(message, Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, 48, 0, 131064);
                            $composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier$iv$iv;
                            throwable2 = throwable4;
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
            throwable4 = throwable3;
            $composer2.startReplaceGroup(1918187655);
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier$iv$iv;
            throwable2 = throwable4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.inlineContent.ImageContentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit UploadFail$lambda$1;
                    UploadFail$lambda$1 = ImageContentKt.UploadFail$lambda$1(modifier2, throwable2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UploadFail$lambda$1;
                }
            });
        }
    }
}