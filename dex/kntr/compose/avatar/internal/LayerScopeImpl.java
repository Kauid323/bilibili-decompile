package kntr.compose.avatar.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpRect;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.AvatarLayerScope;
import kntr.compose.avatar.internal.mask.CircleMaskPainter;
import kntr.compose.avatar.internal.mask.EmptyMaskPainter;
import kntr.compose.avatar.internal.mask.MaskPainter;
import kntr.compose.avatar.internal.mask.MaskPainterImpl;
import kntr.compose.avatar.internal.painters.EmptyPainter;
import kntr.compose.avatar.internal.painters.NativeDrawPainter;
import kntr.compose.avatar.internal.painters.NativeFillDrawPainter;
import kntr.compose.avatar.internal.painters.NativeStrokeDrawPainter;
import kntr.compose.avatar.model.LocalResourceKt;
import kntr.compose.avatar.model.common.DrawSource;
import kntr.compose.avatar.model.common.FillMode;
import kntr.compose.avatar.model.common.IResource;
import kntr.compose.avatar.model.common.InvalidResource;
import kntr.compose.avatar.model.common.LayerGeneralSpec;
import kntr.compose.avatar.model.common.LocalSource;
import kntr.compose.avatar.model.common.NativeDrawType;
import kntr.compose.avatar.model.common.PositionSpec;
import kntr.compose.avatar.model.common.SizeSpec;
import kntr.compose.avatar.model.common.UrlResource;
import kntr.compose.avatar.model.layers.AnimationResource;
import kntr.compose.avatar.model.layers.ImageResource;
import kntr.compose.avatar.model.layers.Layer;
import kntr.compose.avatar.model.layers.LayerResource;
import kntr.compose.avatar.model.layers.MaskProperty;
import kntr.compose.avatar.model.layers.NativeDrawResource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvatarScopeImpl.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0004H\u0017¢\u0006\u0002\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0017*\u00020\u0004H\u0017¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0014*\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u001eH\u0002J\u0014\u0010\u001f\u001a\u00020 *\u00020\u0006H\u0097\u0001¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u001f\u001a\u00020 *\u00020#H\u0097\u0001¢\u0006\u0004\b$\u0010%J\u0014\u0010&\u001a\u00020\u0006*\u00020 H\u0097\u0001¢\u0006\u0004\b'\u0010(J\u0014\u0010&\u001a\u00020\u0006*\u00020)H\u0097\u0001¢\u0006\u0004\b'\u0010*J\u0014\u0010&\u001a\u00020\u0006*\u00020#H\u0097\u0001¢\u0006\u0004\b+\u0010,J\u0014\u0010-\u001a\u00020.*\u00020\u0010H\u0097\u0001¢\u0006\u0004\b/\u00100J\u0014\u00101\u001a\u00020)*\u00020\u0006H\u0097\u0001¢\u0006\u0004\b2\u0010*J\u0014\u00101\u001a\u00020)*\u00020#H\u0097\u0001¢\u0006\u0004\b3\u0010,J\r\u00104\u001a\u000205*\u000206H\u0097\u0001J\u0014\u00107\u001a\u00020\u0010*\u00020.H\u0097\u0001¢\u0006\u0004\b8\u00100J\u0014\u00109\u001a\u00020#*\u00020 H\u0097\u0001¢\u0006\u0004\b:\u0010;J\u0014\u00109\u001a\u00020#*\u00020)H\u0097\u0001¢\u0006\u0004\b:\u0010<J\u0014\u00109\u001a\u00020#*\u00020\u0006H\u0097\u0001¢\u0006\u0004\b=\u0010<R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020)8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020)8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bA\u0010?¨\u0006B"}, d2 = {"Lkntr/compose/avatar/internal/LayerScopeImpl;", "Lkntr/compose/avatar/AvatarLayerScope;", "Landroidx/compose/ui/unit/Density;", "layer", "Lkntr/compose/avatar/model/layers/Layer;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "themeDayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "density", "<init>", "(Lkntr/compose/avatar/model/layers/Layer;FLcom/bilibili/compose/theme/ThemeDayNight;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "getThemeDayNight", "()Lcom/bilibili/compose/theme/ThemeDayNight;", "layerSize", "Landroidx/compose/ui/geometry/Size;", "getLayerSize-NH-jbRc", "()J", "contentPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lkntr/compose/avatar/model/layers/Layer;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "maskPainter", "Lkntr/compose/avatar/internal/mask/MaskPainter;", "(Lkntr/compose/avatar/model/layers/Layer;Landroidx/compose/runtime/Composer;I)Lkntr/compose/avatar/internal/mask/MaskPainter;", "rememberPainter", "Lkntr/compose/avatar/model/common/IResource;", "(Lkntr/compose/avatar/model/common/IResource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "getNativePainter", "Lkntr/compose/avatar/internal/painters/NativeDrawPainter;", "Lkntr/compose/avatar/model/common/DrawSource;", "roundToPx", "", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "getDensity", "()F", "fontScale", "getFontScale", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LayerScopeImpl implements AvatarLayerScope, Density {
    public static final int $stable = 0;
    private final /* synthetic */ Density $$delegate_0;
    private final Layer layer;
    private final float normalSize;
    private final ThemeDayNight themeDayNight;

    /* compiled from: AvatarScopeImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FillMode.values().length];
            try {
                iArr[FillMode.Fill.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FillMode.Edge.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FillMode.Invalid.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ LayerScopeImpl(Layer layer, float f, ThemeDayNight themeDayNight, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(layer, f, themeDayNight, density);
    }

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m2501roundToPxR2X_6o(long j) {
        return this.$$delegate_0.roundToPx--R2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m2502roundToPx0680j_4(float f) {
        return this.$$delegate_0.roundToPx-0680j_4(f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m2503toDpGaN1DYA(long j) {
        return this.$$delegate_0.toDp-GaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m2504toDpu2uoSUM(float f) {
        return this.$$delegate_0.toDp-u2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m2505toDpu2uoSUM(int i) {
        return this.$$delegate_0.toDp-u2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m2506toDpSizekrfVVM(long j) {
        return this.$$delegate_0.toDpSize-k-rfVVM(j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m2507toPxR2X_6o(long j) {
        return this.$$delegate_0.toPx--R2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m2508toPx0680j_4(float f) {
        return this.$$delegate_0.toPx-0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m2509toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.toSize-XkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m2510toSp0xMU5do(float f) {
        return this.$$delegate_0.toSp-0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m2511toSpkPz2Gy4(float f) {
        return this.$$delegate_0.toSp-kPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m2512toSpkPz2Gy4(int i) {
        return this.$$delegate_0.toSp-kPz2Gy4(i);
    }

    private LayerScopeImpl(Layer layer, float normalSize, ThemeDayNight themeDayNight, Density density) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        Intrinsics.checkNotNullParameter(density, "density");
        this.$$delegate_0 = density;
        this.layer = layer;
        this.normalSize = normalSize;
        this.themeDayNight = themeDayNight;
    }

    @Override // kntr.compose.avatar.AvatarLayerScope
    /* renamed from: normalized-AqgpIyE */
    public /* bridge */ long mo2457normalizedAqgpIyE(SizeSpec $this$normalized_u2dAqgpIyE, float f) {
        return AvatarLayerScope.CC.m2461$default$normalizedAqgpIyE(this, $this$normalized_u2dAqgpIyE, f);
    }

    @Override // kntr.compose.avatar.AvatarLayerScope
    /* renamed from: normalized-OJVLdM4 */
    public /* bridge */ long mo2458normalizedOJVLdM4(PositionSpec $this$normalized_u2dOJVLdM4, float f, SizeSpec size) {
        return AvatarLayerScope.CC.m2462$default$normalizedOJVLdM4(this, $this$normalized_u2dOJVLdM4, f, size);
    }

    @Override // kntr.compose.avatar.AvatarLayerScope
    /* renamed from: normalizedDp-ISypg3U */
    public /* bridge */ long mo2459normalizedDpISypg3U(SizeSpec $this$normalizedDp_u2dISypg3U, float f) {
        return AvatarLayerScope.CC.m2463$default$normalizedDpISypg3U(this, $this$normalizedDp_u2dISypg3U, f);
    }

    @Override // kntr.compose.avatar.AvatarLayerScope
    /* renamed from: normalizedRect-3ABfNKs */
    public /* bridge */ Rect mo2460normalizedRect3ABfNKs(LayerGeneralSpec $this$normalizedRect_u2d3ABfNKs, float f) {
        return AvatarLayerScope.CC.m2464$default$normalizedRect3ABfNKs(this, $this$normalizedRect_u2d3ABfNKs, f);
    }

    @Override // kntr.compose.avatar.AvatarLayerScope
    public ThemeDayNight getThemeDayNight() {
        return this.themeDayNight;
    }

    @Override // kntr.compose.avatar.AvatarLayerScope
    /* renamed from: getLayerSize-NH-jbRc */
    public long mo2456getLayerSizeNHjbRc() {
        return mo2457normalizedAqgpIyE(this.layer.getGeneralSpec().getSize(), this.normalSize);
    }

    @Override // kntr.compose.avatar.AvatarLayerScope
    public Painter contentPainter(Layer $this$contentPainter, Composer $composer, int $changed) {
        EmptyPainter emptyPainter;
        Intrinsics.checkNotNullParameter($this$contentPainter, "<this>");
        $composer.startReplaceGroup(-1790644387);
        ComposerKt.sourceInformation($composer, "C(contentPainter):AvatarScopeImpl.kt#cxtxmf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1790644387, $changed, -1, "kntr.compose.avatar.internal.LayerScopeImpl.contentPainter (AvatarScopeImpl.kt:58)");
        }
        LayerResource resource = $this$contentPainter.getResource();
        if (resource instanceof AnimationResource) {
            $composer.startReplaceGroup(1472635310);
            ComposerKt.sourceInformation($composer, "61@2464L17");
            emptyPainter = rememberPainter(((AnimationResource) resource).getSource(), $composer, $changed & 112);
            $composer.endReplaceGroup();
        } else if (resource instanceof ImageResource) {
            $composer.startReplaceGroup(1472637550);
            ComposerKt.sourceInformation($composer, "62@2534L17");
            emptyPainter = rememberPainter(((ImageResource) resource).getSource(), $composer, $changed & 112);
            $composer.endReplaceGroup();
        } else if (resource instanceof NativeDrawResource) {
            $composer.startReplaceGroup(1472639950);
            ComposerKt.sourceInformation($composer, "63@2609L17");
            emptyPainter = rememberPainter(((NativeDrawResource) resource).getSource(), $composer, $changed & 112);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-1592738626);
            ComposerKt.sourceInformation($composer, "65@2671L71");
            ComposerKt.sourceInformationMarkerStart($composer, 1472641988, "CC(remember):AvatarScopeImpl.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new EmptyPainter();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
            emptyPainter = (EmptyPainter) it$iv;
        }
        Painter contentState = emptyPainter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return contentState;
    }

    @Override // kntr.compose.avatar.AvatarLayerScope
    public MaskPainter maskPainter(Layer $this$maskPainter, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$maskPainter, "<this>");
        $composer.startReplaceGroup(-300913094);
        ComposerKt.sourceInformation($composer, "C(maskPainter)80@3258L17:AvatarScopeImpl.kt#cxtxmf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-300913094, $changed, -1, "kntr.compose.avatar.internal.LayerScopeImpl.maskPainter (AvatarScopeImpl.kt:73)");
        }
        MaskProperty mask = $this$maskPainter.getLayerConfig().getMask();
        if (mask == null) {
            EmptyMaskPainter emptyMaskPainter = EmptyMaskPainter.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return emptyMaskPainter;
        }
        IResource maskSource = mask.getMaskSource();
        if ((maskSource instanceof DrawSource) && ((DrawSource) maskSource).getDrawType() == NativeDrawType.Circle && ((DrawSource) maskSource).getFillMode() == FillMode.Fill) {
            long size = mo2459normalizedDpISypg3U(mask.getGeneralSpec().getSize(), this.normalSize);
            CircleMaskPainter circleMaskPainter = new CircleMaskPainter(size, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return circleMaskPainter;
        }
        Painter painter = rememberPainter(mask.getMaskSource(), $composer, $changed & 112);
        if (painter == null) {
            EmptyMaskPainter emptyMaskPainter2 = EmptyMaskPainter.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return emptyMaskPainter2;
        }
        MaskPainterImpl maskPainterImpl = new MaskPainterImpl(painter);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return maskPainterImpl;
    }

    private final Painter rememberPainter(IResource $this$rememberPainter, Composer $composer, int $changed) {
        NativeDrawPainter painter;
        ComposerKt.sourceInformationMarkerStart($composer, 669793697, "C(rememberPainter):AvatarScopeImpl.kt#cxtxmf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(669793697, $changed, -1, "kntr.compose.avatar.internal.LayerScopeImpl.rememberPainter (AvatarScopeImpl.kt:86)");
        }
        if (Intrinsics.areEqual($this$rememberPainter, InvalidResource.INSTANCE)) {
            $composer.startReplaceGroup(-593902477);
            ComposerKt.sourceInformation($composer, "88@3504L78");
            Enum themeDayNight = getThemeDayNight();
            ComposerKt.sourceInformationMarkerStart($composer, -573347473, "CC(remember):AvatarScopeImpl.kt#9igjgp");
            boolean invalid$iv = $composer.changed(themeDayNight.ordinal());
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new EmptyPainter();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
            painter = (EmptyPainter) it$iv;
        } else if ($this$rememberPainter instanceof DrawSource) {
            $composer.startReplaceGroup(-593779128);
            ComposerKt.sourceInformation($composer, "92@3628L89");
            Enum themeDayNight2 = getThemeDayNight();
            ComposerKt.sourceInformationMarkerStart($composer, -573343494, "CC(remember):AvatarScopeImpl.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(themeDayNight2.ordinal());
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = getNativePainter((DrawSource) $this$rememberPainter);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
            painter = (NativeDrawPainter) it$iv2;
        } else if ($this$rememberPainter instanceof LocalSource) {
            $composer.startReplaceGroup(-573339283);
            ComposerKt.sourceInformation($composer, "95@3762L12");
            painter = LocalResourceKt.getPainter(((LocalSource) $this$rememberPainter).getSource(), $composer, 0);
            $composer.endReplaceGroup();
        } else if (!($this$rememberPainter instanceof UrlResource)) {
            $composer.startReplaceGroup(-573349516);
            $composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            $composer.startReplaceGroup(-573337901);
            ComposerKt.sourceInformation($composer, "96@3805L18");
            painter = UtilsKt.getPainter(this, (UrlResource) $this$rememberPainter, $composer, (($changed >> 3) & 14) | (($changed << 3) & 112));
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return painter;
    }

    private final NativeDrawPainter getNativePainter(DrawSource $this$getNativePainter) {
        long color;
        color = AvatarScopeImplKt.getColor($this$getNativePainter.getColor(), getThemeDayNight());
        float f = this.normalSize;
        float other$iv = $this$getNativePainter.getEdgeWeight();
        float size = m2508toPx0680j_4(Dp.constructor-impl(f * other$iv));
        switch (WhenMappings.$EnumSwitchMapping$0[$this$getNativePainter.getFillMode().ordinal()]) {
            case 1:
                return new NativeFillDrawPainter($this$getNativePainter.getDrawType(), color, mo2456getLayerSizeNHjbRc(), null);
            case 2:
                return new NativeStrokeDrawPainter($this$getNativePainter.getDrawType(), color, size, mo2456getLayerSizeNHjbRc(), null);
            case 3:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}