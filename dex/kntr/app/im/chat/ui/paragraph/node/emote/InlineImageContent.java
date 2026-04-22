package kntr.app.im.chat.ui.paragraph.node.emote;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.SupportImageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImEmoteNodeBuilder.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\f\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lkntr/app/im/chat/ui/paragraph/node/emote/InlineImageContent;", RoomRecommendViewModel.EMPTY_CURSOR, "img", RoomRecommendViewModel.EMPTY_CURSOR, "animated", RoomRecommendViewModel.EMPTY_CURSOR, "size", "Landroidx/compose/ui/unit/DpSize;", "density", "Landroidx/compose/ui/unit/Density;", "tint", "Landroidx/compose/ui/graphics/Color;", "failedColor", "hasRadius", "align", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "<init>", "(Ljava/lang/String;ZJLandroidx/compose/ui/unit/Density;JJZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getImg", "()Ljava/lang/String;", "getAnimated", "()Z", "getSize-MYxV2XQ", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTint-0d7_KjU", "getFailedColor-0d7_KjU", "getHasRadius", "getAlign-J6kI3mc", "()I", "I", "inlineContent", "Landroidx/compose/foundation/text/InlineTextContent;", "getInlineContent", "()Landroidx/compose/foundation/text/InlineTextContent;", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InlineImageContent {
    public static final int $stable = 0;
    private final int align;
    private final boolean animated;
    private final Density density;
    private final long failedColor;
    private final boolean hasRadius;
    private final String img;
    private final InlineTextContent inlineContent;
    private final long size;
    private final long tint;

    public /* synthetic */ InlineImageContent(String str, boolean z, long j2, Density density, long j3, long j4, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, j2, density, j3, j4, z2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(InlineImageContent inlineImageContent, Modifier modifier, int i, int i2, Composer composer, int i3) {
        inlineImageContent.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private InlineImageContent(String img, boolean animated, long size, Density density, long tint, long failedColor, boolean hasRadius, int align) {
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(density, "density");
        this.img = img;
        this.animated = animated;
        this.size = size;
        this.density = density;
        this.tint = tint;
        this.failedColor = failedColor;
        this.hasRadius = hasRadius;
        this.align = align;
        Density $this$inlineContent_u24lambda_u240 = this.density;
        long j2 = $this$inlineContent_u24lambda_u240.toSp-0xMU5do(DpSize.getWidth-D9Ej5fM(this.size));
        Density $this$inlineContent_u24lambda_u2402 = this.density;
        this.inlineContent = new InlineTextContent(new Placeholder(j2, $this$inlineContent_u24lambda_u2402.toSp-0xMU5do(DpSize.getHeight-D9Ej5fM(this.size)), this.align, (DefaultConstructorMarker) null), ComposableLambdaKt.composableLambdaInstance(1172732410, true, new Function3() { // from class: kntr.app.im.chat.ui.paragraph.node.emote.InlineImageContent$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit inlineContent$lambda$2;
                inlineContent$lambda$2 = InlineImageContent.inlineContent$lambda$2(InlineImageContent.this, (String) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return inlineContent$lambda$2;
            }
        }));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ InlineImageContent(String str, boolean z, long j2, Density density, long j3, long j4, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, j2, density, j3, j4, r12, r13, null);
        boolean z3;
        int i3;
        if ((i2 & 64) == 0) {
            z3 = z2;
        } else {
            z3 = false;
        }
        if ((i2 & 128) == 0) {
            i3 = i;
        } else {
            i3 = PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc();
        }
    }

    public final String getImg() {
        return this.img;
    }

    public final boolean getAnimated() {
        return this.animated;
    }

    /* renamed from: getSize-MYxV2XQ  reason: not valid java name */
    public final long m1891getSizeMYxV2XQ() {
        return this.size;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* renamed from: getTint-0d7_KjU  reason: not valid java name */
    public final long m1892getTint0d7_KjU() {
        return this.tint;
    }

    /* renamed from: getFailedColor-0d7_KjU  reason: not valid java name */
    public final long m1890getFailedColor0d7_KjU() {
        return this.failedColor;
    }

    public final boolean getHasRadius() {
        return this.hasRadius;
    }

    /* renamed from: getAlign-J6kI3mc  reason: not valid java name */
    public final int m1889getAlignJ6kI3mc() {
        return this.align;
    }

    public final InlineTextContent getInlineContent() {
        return this.inlineContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inlineContent$lambda$2(InlineImageContent this$0, String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)155@6566L28:ImEmoteNodeBuilder.kt#njg0lc");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1172732410, $changed, -1, "kntr.app.im.chat.ui.paragraph.node.emote.InlineImageContent.inlineContent.<anonymous> (ImEmoteNodeBuilder.kt:155)");
            }
            this$0.Content(SizeKt.size-6HolHcs(Modifier.Companion, this$0.size), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public final void Content(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier finalModifier;
        Composer $composer3 = $composer.startRestartGroup(-1310025054);
        ComposerKt.sourceInformation($composer3, "C(Content)N(modifier)175@7159L215,166@6839L546:ImEmoteNodeBuilder.kt#njg0lc");
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
            $dirty |= $composer3.changed(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1310025054, $dirty2, -1, "kntr.app.im.chat.ui.paragraph.node.emote.InlineImageContent.Content (ImEmoteNodeBuilder.kt:159)");
            }
            if (this.hasRadius) {
                finalModifier = ClipKt.clip(modifier3, RoundedCornerShapeKt.getCircleShape());
            } else {
                finalModifier = modifier3;
            }
            String $this$asRequest$iv = this.img;
            ImageRequest $this$Content_u24lambda_u240 = new ImageRequest($this$asRequest$iv);
            $this$Content_u24lambda_u240.autoPlay(true);
            $this$Content_u24lambda_u240.requestFormat(SupportImageType.WEBP);
            if (this.tint != 16) {
                $this$Content_u24lambda_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, this.tint, 0, 2, (Object) null));
            }
            Modifier modifier4 = modifier3;
            $composer2 = $composer3;
            BiliImageKt.BiliImage($this$Content_u24lambda_u240.build(), finalModifier, (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1131658925, true, new Function4() { // from class: kntr.app.im.chat.ui.paragraph.node.emote.InlineImageContent$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = InlineImageContent.Content$lambda$1(InlineImageContent.this, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return Content$lambda$1;
                }
            }, $composer3, 54), $composer3, 100663296, 252);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.paragraph.node.emote.InlineImageContent$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$2;
                    Content$lambda$2 = InlineImageContent.Content$lambda$2(InlineImageContent.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(InlineImageContent this$0, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)176@7177L183:ImEmoteNodeBuilder.kt#njg0lc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1131658925, $changed, -1, "kntr.app.im.chat.ui.paragraph.node.emote.InlineImageContent.Content.<anonymous> (ImEmoteNodeBuilder.kt:176)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), this$0.failedColor, (Shape) null, 2, (Object) null), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}