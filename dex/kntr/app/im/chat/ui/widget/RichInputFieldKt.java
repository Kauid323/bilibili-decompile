package kntr.app.im.chat.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.ClipboardManager;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.im.chat.db.model.InlineContent;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.clipboard.ClipboardServiceKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.compose.resources.FontResources_androidKt;
import srcs.app.im.chat.ui.generated.resources.Font0_commonMainKt;
import srcs.app.im.chat.ui.generated.resources.Res;

/* compiled from: RichInputField.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\t\u001a\u00020\n*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u001a<\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002\u001ak\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010'\u001a-\u0010(\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0003¢\u0006\u0002\u0010,\u001a\u0017\u0010-\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010.\u001a\u001f\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0004\b3\u00104¨\u00065²\u0006\n\u0010)\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u00101\u001a\u000202X\u008a\u008e\u0002"}, d2 = {"rememberRichInputFieldState", "Lkntr/app/im/chat/ui/widget/RichInputFieldState;", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/im/chat/ui/widget/RichInputFieldState;", "safeSub", RoomRecommendViewModel.EMPTY_CURSOR, "range", "Landroidx/compose/ui/text/TextRange;", "safeSub-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;", "buildNewAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "text", "inlineContents", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/model/InlineContent;", "diffTextFieldValue", "Lkotlin/Pair;", "Landroidx/compose/ui/text/input/TextFieldValue;", "oldValue", "newValue", "RichInputField", RoomRecommendViewModel.EMPTY_CURSOR, "inputBoxContent", "Lkntr/app/im/chat/db/model/InputBoxContent;", "onValueChange", "Lkotlin/Function1;", "contentVersion", RoomRecommendViewModel.EMPTY_CURSOR, "cursorColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "hintTextColor", "hintText", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "state", "RichInputField-1esR5Hs", "(Lkntr/app/im/chat/db/model/InputBoxContent;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;JLandroidx/compose/ui/text/TextStyle;JLjava/lang/String;Landroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/widget/RichInputFieldState;Landroidx/compose/runtime/Composer;II)V", "TextScrollEffect", "decorBoxHeight", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Lkntr/app/im/chat/ui/widget/RichInputFieldState;Lkntr/app/im/chat/db/model/InputBoxContent;ILandroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;I)V", "EmotePlaceholder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TransparentTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "richInputFieldValue", "Lkntr/app/im/chat/ui/widget/RichInputFieldValue;", "TransparentTextSelectionColors-RPmYEkk", "(Lkntr/app/im/chat/ui/widget/RichInputFieldValue;JLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RichInputFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmotePlaceholder$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        EmotePlaceholder(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichInputField_1esR5Hs$lambda$10(InputBoxContent inputBoxContent, Function1 function1, Integer num, long j2, TextStyle textStyle, long j3, String str, Modifier modifier, RichInputFieldState richInputFieldState, int i, int i2, Composer composer, int i3) {
        m1986RichInputField1esR5Hs(inputBoxContent, function1, num, j2, textStyle, j3, str, modifier, richInputFieldState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextScrollEffect$lambda$2(RichInputFieldState richInputFieldState, InputBoxContent inputBoxContent, int i, ScrollState scrollState, int i2, Composer composer, int i3) {
        TextScrollEffect(richInputFieldState, inputBoxContent, i, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final RichInputFieldState rememberRichInputFieldState(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 326439771, "C(rememberRichInputFieldState)70@3073L57,74@3173L7,75@3192L111:RichInputField.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(326439771, $changed, -1, "kntr.app.im.chat.ui.widget.rememberRichInputFieldState (RichInputField.kt:67)");
        }
        FontFamily font = FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getPlaceholder(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer, 0, 14)});
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 176014570, "CC(remember):RichInputField.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new RichInputFieldState(font, density);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        RichInputFieldState richInputFieldState = (RichInputFieldState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return richInputFieldState;
    }

    /* renamed from: safeSub-FDrldGo  reason: not valid java name */
    private static final CharSequence m1988safeSubFDrldGo(CharSequence $this$safeSub_u2dFDrldGo, long j2) {
        int start = RangesKt.coerceIn(Math.min(TextRange.getStart-impl(j2), TextRange.getEnd-impl(j2)), 0, $this$safeSub_u2dFDrldGo.length());
        int end = RangesKt.coerceIn(Math.max(TextRange.getStart-impl(j2), TextRange.getEnd-impl(j2)), 0, $this$safeSub_u2dFDrldGo.length());
        return $this$safeSub_u2dFDrldGo.subSequence(start, end).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString buildNewAnnotatedString(RichInputFieldState $this$buildNewAnnotatedString, AnnotatedString text, List<InlineContent> list) {
        AnnotatedString.Builder $this$buildNewAnnotatedString_u24lambda_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        $this$buildNewAnnotatedString_u24lambda_u240.append(text);
        List<InlineContent> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            InlineContent ic = (InlineContent) element$iv;
            float fontSize = Math.max(ic.getSize().getHeight(), ic.getSize().getWidth());
            $this$buildNewAnnotatedString_u24lambda_u240.addStyle(new SpanStyle(0L, TextUnitKt.getSp(fontSize), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, $this$buildNewAnnotatedString.getFont(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65501, (DefaultConstructorMarker) null), ic.getOffset(), ic.getOffset() + 1);
        }
        return $this$buildNewAnnotatedString_u24lambda_u240.toAnnotatedString();
    }

    private static final Pair<TextFieldValue, List<InlineContent>> diffTextFieldValue(RichInputFieldState $this$diffTextFieldValue, TextFieldValue oldValue, List<InlineContent> $this$filterNot$iv, TextFieldValue newValue) {
        int insertStart;
        boolean isHasDelete;
        InlineContent inlineContent;
        boolean isHasDelete2;
        Iterable $this$filterNot$iv2;
        boolean z;
        boolean isHasDelete3;
        int deleteStart;
        int deleteEnd;
        InlineContent inlineContent2;
        CharSequence annotatedString = oldValue.getAnnotatedString();
        CharSequence annotatedString2 = newValue.getAnnotatedString();
        long oldSelection = oldValue.getSelection-d9O1mEE();
        long newSelection = newValue.getSelection-d9O1mEE();
        List newInlineContents = null;
        if (annotatedString.length() > annotatedString2.length()) {
            if (TextRange.getCollapsed-impl(oldSelection)) {
                deleteStart = TextRange.getStart-impl(newSelection);
                deleteEnd = TextRange.getStart-impl(oldSelection);
            } else {
                deleteStart = TextRange.getMin-impl(oldSelection);
                deleteEnd = TextRange.getMax-impl(oldSelection);
            }
            int deleteCount = deleteEnd - deleteStart;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterNot$iv) {
                int offset = ((InlineContent) element$iv$iv).getOffset();
                if (!(deleteStart <= offset && offset < deleteEnd)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                InlineContent it = (InlineContent) item$iv$iv;
                List newInlineContents2 = newInlineContents;
                if (it.getOffset() >= deleteEnd) {
                    inlineContent2 = InlineContent.copy$default(it, null, null, null, it.getOffset() - deleteCount, false, null, 55, null);
                } else {
                    inlineContent2 = it;
                }
                destination$iv$iv2.add(inlineContent2);
                newInlineContents = newInlineContents2;
            }
            List newInlineContents3 = (List) destination$iv$iv2;
            AnnotatedString newAnnotatedString = buildNewAnnotatedString($this$diffTextFieldValue, annotatedString2, newInlineContents3);
            return new Pair<>(TextFieldValue.copy-3r_uNRQ$default(newValue, newAnnotatedString, 0L, (TextRange) null, 6, (Object) null), newInlineContents3);
        } else if (annotatedString.length() < annotatedString2.length()) {
            if (TextRange.getCollapsed-impl(oldSelection)) {
                insertStart = TextRange.getStart-impl(oldSelection);
                isHasDelete = false;
            } else {
                insertStart = TextRange.getStart-impl(oldSelection);
                isHasDelete = true;
            }
            List<InlineContent> $this$filterNot$iv3 = $this$filterNot$iv;
            boolean z2 = false;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv2 : $this$filterNot$iv3) {
                InlineContent it2 = (InlineContent) element$iv$iv2;
                if (isHasDelete) {
                    isHasDelete2 = isHasDelete;
                    int i = TextRange.getMin-impl(oldSelection);
                    $this$filterNot$iv2 = $this$filterNot$iv3;
                    int i2 = TextRange.getMax-impl(oldSelection);
                    z = z2;
                    int $i$f$filterNot = it2.getOffset();
                    isHasDelete3 = i <= $i$f$filterNot && $i$f$filterNot < i2;
                } else {
                    isHasDelete2 = isHasDelete;
                    $this$filterNot$iv2 = $this$filterNot$iv3;
                    z = z2;
                    isHasDelete3 = false;
                }
                if (!isHasDelete3) {
                    destination$iv$iv3.add(element$iv$iv2);
                }
                isHasDelete = isHasDelete2;
                $this$filterNot$iv3 = $this$filterNot$iv2;
                z2 = z;
            }
            Iterable $this$map$iv2 = (List) destination$iv$iv3;
            Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                InlineContent it3 = (InlineContent) item$iv$iv2;
                Iterable $this$map$iv3 = $this$map$iv2;
                if (it3.getOffset() >= insertStart) {
                    inlineContent = InlineContent.copy$default(it3, null, null, null, it3.getOffset() + (annotatedString2.length() - annotatedString.length()), false, null, 55, null);
                } else {
                    inlineContent = it3;
                }
                destination$iv$iv4.add(inlineContent);
                $this$map$iv2 = $this$map$iv3;
            }
            List newInlineContents4 = (List) destination$iv$iv4;
            AnnotatedString newAnnotatedString2 = buildNewAnnotatedString($this$diffTextFieldValue, newValue.getAnnotatedString(), newInlineContents4);
            return new Pair<>(TextFieldValue.copy-3r_uNRQ$default(newValue, newAnnotatedString2, 0L, (TextRange) null, 6, (Object) null), newInlineContents4);
        } else if (TextRange.getCollapsed-impl(oldSelection)) {
            AnnotatedString newAnnotatedString3 = buildNewAnnotatedString($this$diffTextFieldValue, annotatedString2, $this$filterNot$iv);
            return new Pair<>(TextFieldValue.copy-3r_uNRQ$default(newValue, newAnnotatedString3, 0L, (TextRange) null, 6, (Object) null), $this$filterNot$iv);
        } else {
            CharSequence oldSelectedText = m1988safeSubFDrldGo(annotatedString, oldSelection);
            CharSequence newSelectedText = m1988safeSubFDrldGo(annotatedString2, newSelection);
            if (Intrinsics.areEqual(oldSelectedText, newSelectedText)) {
                AnnotatedString newAnnotatedString4 = buildNewAnnotatedString($this$diffTextFieldValue, annotatedString2, $this$filterNot$iv);
                return new Pair<>(TextFieldValue.copy-3r_uNRQ$default(newValue, newAnnotatedString4, 0L, (TextRange) null, 6, (Object) null), $this$filterNot$iv);
            }
            return new Pair<>(newValue, $this$filterNot$iv);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x043e, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L112;
     */
    /* renamed from: RichInputField-1esR5Hs  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1986RichInputField1esR5Hs(final InputBoxContent inputBoxContent, final Function1<? super InputBoxContent, Unit> function1, final Integer contentVersion, final long j2, final TextStyle textStyle, final long j3, final String hintText, Modifier modifier, RichInputFieldState state, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        Modifier modifier2;
        RichInputFieldState state2;
        Modifier modifier3;
        RichInputFieldState state3;
        Modifier modifier4;
        boolean z;
        float verticalPadding;
        int $dirty;
        final MutableIntState decorBoxHeight$delegate;
        Modifier modifier5;
        String str;
        Object value$iv;
        Function0 factory$iv$iv$iv;
        int i2;
        Intrinsics.checkNotNullParameter(inputBoxContent, "inputBoxContent");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Composer $composer3 = $composer.startRestartGroup(-2046929841);
        ComposerKt.sourceInformation($composer3, "C(RichInputField)N(inputBoxContent,onValueChange,contentVersion,cursorColor:c#ui.graphics.Color,textStyle,hintTextColor:c#ui.graphics.Color,hintText,modifier,state)336@10426L21,338@10510L7,340@10624L33,342@10690L762,363@11489L1053,363@11458L1084,392@12624L86,389@12548L9916:RichInputField.kt#92mklk");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(inputBoxContent) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(contentVersion) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(j2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(textStyle) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changed(j3) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer3.changed(hintText) ? 1048576 : 524288;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 256) == 0 && $composer3.changed(state)) {
                i2 = 67108864;
                $dirty2 |= i2;
            }
            i2 = 33554432;
            $dirty2 |= i2;
        }
        if ($composer3.shouldExecute(($dirty2 & 38347923) != 38347922, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "334@10369L29");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 256) != 0) {
                    $dirty2 &= -234881025;
                }
                modifier4 = modifier;
                state3 = state;
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i & 256) == 0) {
                    state3 = state;
                    modifier4 = modifier3;
                } else {
                    state3 = rememberRichInputFieldState($composer3, 0);
                    $dirty2 &= -234881025;
                    modifier4 = modifier3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2046929841, $dirty2, -1, "kntr.app.im.chat.ui.widget.RichInputField (RichInputField.kt:335)");
            }
            final ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
            float f = Dp.constructor-impl(8);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            final int verticalPaddingPx = density.roundToPx-0680j_4(Dp.constructor-impl(2 * f));
            ComposerKt.sourceInformationMarkerStart($composer3, -4537936, "CC(remember):RichInputField.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            Modifier modifier6 = modifier4;
            if (it$iv == Composer.Companion.getEmpty()) {
                z = false;
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            } else {
                z = false;
            }
            MutableIntState decorBoxHeight$delegate2 = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -4535095, "CC(remember):RichInputField.kt#9igjgp");
            Object value$iv3 = $composer3.rememberedValue();
            if (value$iv3 == Composer.Companion.getEmpty()) {
                verticalPadding = f;
                value$iv3 = SnapshotStateKt.mutableStateOf$default(new RichInputFieldValue(new TextFieldValue(buildNewAnnotatedString(state3, new AnnotatedString(inputBoxContent.getText(), (List) null, 2, (DefaultConstructorMarker) null), inputBoxContent.getInlineContents()), TextRangeKt.TextRange(inputBoxContent.getCursorStart(), inputBoxContent.getCursorEnd()), (TextRange) null, 4, (DefaultConstructorMarker) null), inputBoxContent.getInlineContents()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                verticalPadding = f;
            }
            final MutableState richInputFieldValue$delegate = (MutableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -4509236, "CC(remember):RichInputField.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 896) == 256 ? true : z) | (((((234881024 & $dirty2) ^ 100663296) <= 67108864 || !$composer3.changed(state3)) && ($dirty2 & 100663296) != 67108864) ? z : true) | (($dirty2 & 14) == 4 ? true : z);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                state2 = state3;
                decorBoxHeight$delegate = decorBoxHeight$delegate2;
                modifier5 = modifier6;
                str = "CC(remember):RichInputField.kt#9igjgp";
                value$iv = (Function2) new RichInputFieldKt$RichInputField$1$1(contentVersion, state3, inputBoxContent, richInputFieldValue$delegate, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                $dirty = $dirty2;
                state2 = state3;
                value$iv = it$iv2;
                modifier5 = modifier6;
                decorBoxHeight$delegate = decorBoxHeight$delegate2;
                str = "CC(remember):RichInputField.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(contentVersion, (Function2) value$iv, $composer3, ($dirty >> 6) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, -4473883, str);
            boolean invalid$iv2 = $composer3.changed(verticalPaddingPx);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit RichInputField_1esR5Hs$lambda$8$0;
                        RichInputField_1esR5Hs$lambda$8$0 = RichInputFieldKt.RichInputField_1esR5Hs$lambda$8$0(verticalPaddingPx, decorBoxHeight$delegate, (IntSize) obj);
                        return RichInputField_1esR5Hs$lambda$8$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ScrollKt.verticalScroll$default(OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv3), scrollState, false, (FlingBehavior) null, false, 14, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1508774837, "C397@12832L7,398@12863L37,400@12943L709,417@13803L123,421@13938L8520,414@13662L8796:RichInputField.kt#92mklk");
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalClipboard();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Clipboard clipBoard = (Clipboard) consume2;
            final State getInput = SnapshotStateKt.rememberUpdatedState(inputBoxContent, $composer3, $dirty & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, -2029544230, str);
            boolean invalid$iv3 = $composer3.changed(clipBoard);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv5 = new Clipboard(clipBoard, getInput, inputBoxContent) { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$RichInputField$3$mockedClipBoard$1$1
                private final /* synthetic */ Clipboard $$delegate_0;
                final /* synthetic */ Clipboard $clipBoard;
                final /* synthetic */ State<InputBoxContent> $getInput;
                final /* synthetic */ InputBoxContent $inputBoxContent;

                public Object getClipEntry(Continuation<? super ClipEntry> continuation) {
                    return this.$$delegate_0.getClipEntry(continuation);
                }

                public ClipboardManager getNativeClipboard() {
                    return this.$$delegate_0.getNativeClipboard();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$clipBoard = clipBoard;
                    this.$getInput = getInput;
                    this.$inputBoxContent = inputBoxContent;
                    this.$$delegate_0 = clipBoard;
                }

                public Object setClipEntry(ClipEntry clipEntry, Continuation<? super Unit> continuation) {
                    String copyContent = ((InputBoxContent) this.$getInput.getValue()).getSelectedSummaryString();
                    IMLog.Companion companion = IMLog.Companion;
                    String text = this.$inputBoxContent.getText();
                    companion.i("Clipboard", "fFull content " + text + ", start " + this.$inputBoxContent.getCursorStart() + ", end " + this.$inputBoxContent.getCursorEnd());
                    IMLog.Companion.i("Clipboard", "Copying, reset to " + copyContent);
                    Object clipEntry2 = this.$clipBoard.setClipEntry(ClipboardServiceKt.getClipboardService().generateClipboardEntry(copyContent), continuation);
                    return clipEntry2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clipEntry2 : Unit.INSTANCE;
                }
            };
            $composer3.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            RichInputFieldKt$RichInputField$3$mockedClipBoard$1$1 mockedClipBoard = (RichInputFieldKt$RichInputField$3$mockedClipBoard$1$1) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            final RichInputFieldState richInputFieldState = state2;
            modifier2 = modifier5;
            final MutableIntState mutableIntState = decorBoxHeight$delegate;
            final float verticalPadding2 = verticalPadding;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalClipboard().provides(mockedClipBoard), TextSelectionColorsKt.getLocalTextSelectionColors().provides(m1987TransparentTextSelectionColorsRPmYEkk(RichInputField_1esR5Hs$lambda$5(richInputFieldValue$delegate), j2, $composer3, ($dirty >> 6) & 112))}, ComposableLambdaKt.rememberComposableLambda(1332137237, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit RichInputField_1esR5Hs$lambda$9$1;
                    RichInputField_1esR5Hs$lambda$9$1 = RichInputFieldKt.RichInputField_1esR5Hs$lambda$9$1(textStyle, j2, richInputFieldState, function1, richInputFieldValue$delegate, verticalPadding2, hintText, j3, inputBoxContent, scrollState, mutableIntState, density, (Composer) obj, ((Integer) obj2).intValue());
                    return RichInputField_1esR5Hs$lambda$9$1;
                }
            }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            state2 = state;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            final RichInputFieldState richInputFieldState2 = state2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit RichInputField_1esR5Hs$lambda$10;
                    RichInputField_1esR5Hs$lambda$10 = RichInputFieldKt.RichInputField_1esR5Hs$lambda$10(InputBoxContent.this, function1, contentVersion, j2, textStyle, j3, hintText, modifier7, richInputFieldState2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RichInputField_1esR5Hs$lambda$10;
                }
            });
        }
    }

    private static final int RichInputField_1esR5Hs$lambda$2(MutableIntState $decorBoxHeight$delegate) {
        IntState $this$getValue$iv = (IntState) $decorBoxHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RichInputFieldValue RichInputField_1esR5Hs$lambda$5(MutableState<RichInputFieldValue> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (RichInputFieldValue) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichInputField_1esR5Hs$lambda$8$0(int $verticalPaddingPx, MutableIntState $decorBoxHeight$delegate, IntSize it) {
        $decorBoxHeight$delegate.setIntValue(((int) (4294967295L & it.unbox-impl())) - $verticalPaddingPx);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichInputField_1esR5Hs$lambda$9$1(final TextStyle $textStyle, long j2, final RichInputFieldState $state, final Function1 $onValueChange, final MutableState $richInputFieldValue$delegate, final float $verticalPadding, final String $hintText, final long j3, final InputBoxContent $inputBoxContent, final ScrollState $scrollState, final MutableIntState $decorBoxHeight$delegate, final Density $density, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C422@14003L109,422@13952L160,429@14322L1228,456@15583L134,465@15952L6481,426@14126L8322:RichInputField.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1332137237, $changed, -1, "kntr.app.im.chat.ui.widget.RichInputField.<anonymous>.<anonymous> (RichInputField.kt:422)");
            }
            TextFieldValue textFieldValue = RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getTextFieldValue();
            ComposerKt.sourceInformationMarkerStart($composer, 283632738, "CC(remember):RichInputField.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new RichInputFieldKt$RichInputField$3$1$1$1($richInputFieldValue$delegate, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(textFieldValue, (Function2) it$iv, $composer, 0);
            TextFieldValue textFieldValue2 = RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getTextFieldValue();
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, true, 1, (Object) null);
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default($textStyle, 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnit.Companion.getUnspecified-XSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646143, (Object) null);
            Brush solidColor = new SolidColor(j2, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer, 283644065, "CC(remember):RichInputField.kt#9igjgp");
            boolean invalid$iv = $composer.changed($state) | $composer.changed($onValueChange);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit RichInputField_1esR5Hs$lambda$9$1$1$0;
                        RichInputField_1esR5Hs$lambda$9$1$1$0 = RichInputFieldKt.RichInputField_1esR5Hs$lambda$9$1$1$0(RichInputFieldState.this, $onValueChange, $richInputFieldValue$delegate, (TextFieldValue) obj);
                        return RichInputField_1esR5Hs$lambda$9$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function1 function1 = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 283683323, "CC(remember):RichInputField.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($state);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit RichInputField_1esR5Hs$lambda$9$1$2$0;
                        RichInputField_1esR5Hs$lambda$9$1$2$0 = RichInputFieldKt.RichInputField_1esR5Hs$lambda$9$1$2$0(RichInputFieldState.this, (TextLayoutResult) obj);
                        return RichInputField_1esR5Hs$lambda$9$1$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BasicTextFieldKt.BasicTextField(textFieldValue2, function1, wrapContentHeight$default, false, false, textStyle, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (VisualTransformation) null, (Function1) it$iv3, (MutableInteractionSource) null, solidColor, ComposableLambdaKt.rememberComposableLambda(404724242, true, new Function3() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RichInputField_1esR5Hs$lambda$9$1$3;
                    RichInputField_1esR5Hs$lambda$9$1$3 = RichInputFieldKt.RichInputField_1esR5Hs$lambda$9$1$3($verticalPadding, $hintText, $textStyle, j3, $state, $inputBoxContent, $scrollState, $richInputFieldValue$delegate, $decorBoxHeight$delegate, $density, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RichInputField_1esR5Hs$lambda$9$1$3;
                }
            }, $composer, 54), $composer, 384, 196608, 12248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichInputField_1esR5Hs$lambda$9$1$1$0(RichInputFieldState $state, Function1 $onValueChange, MutableState $richInputFieldValue$delegate, TextFieldValue fieldValue) {
        Intrinsics.checkNotNullParameter(fieldValue, "fieldValue");
        Pair textResult = diffTextFieldValue($state, RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getTextFieldValue(), RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getInlineContents(), fieldValue);
        $richInputFieldValue$delegate.setValue(new RichInputFieldValue((TextFieldValue) textResult.getFirst(), (List) textResult.getSecond()));
        IMLog.Companion.i("Clipboard", "Selection changed to " + TextRange.toString-impl(RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getTextFieldValue().getSelection-d9O1mEE()));
        $onValueChange.invoke(new InputBoxContent(RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getTextFieldValue().getText(), TextRange.getStart-impl(RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getTextFieldValue().getSelection-d9O1mEE()), TextRange.getEnd-impl(RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getTextFieldValue().getSelection-d9O1mEE()), (List) textResult.getSecond()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichInputField_1esR5Hs$lambda$9$1$2$0(RichInputFieldState $state, TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        $state.setTextLayoutResult(textLayoutResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0291, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit RichInputField_1esR5Hs$lambda$9$1$3(float $verticalPadding, String $hintText, TextStyle $textStyle, long j2, RichInputFieldState $state, InputBoxContent $inputBoxContent, ScrollState $scrollState, MutableState $richInputFieldValue$delegate, MutableIntState $decorBoxHeight$delegate, Density $density, Function2 innerTextField, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation($composer, "CN(innerTextField)466@15992L6423:RichInputField.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changedInstance(innerTextField) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(404724242, $dirty2, -1, "kntr.app.im.chat.ui.widget.RichInputField.<anonymous>.<anonymous>.<anonymous> (RichInputField.kt:466)");
            }
            Modifier modifier$iv = SizeKt.wrapContentHeight$default(PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, $verticalPadding, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            int i2 = ((54 >> 6) & 112) | 6;
            BoxScope $this$RichInputField_1esR5Hs_u24lambda_u249_u241_u243_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 72303761, "C486@16918L265,581@22377L16:RichInputField.kt#92mklk");
            if (!(RichInputField_1esR5Hs$lambda$5($richInputFieldValue$delegate).getTextFieldValue().getText().length() == 0) || $hintText == null) {
                $composer$iv = $composer;
                factory$iv$iv$iv2 = factory$iv$iv$iv;
                $composer.startReplaceGroup(55833770);
            } else {
                $composer.startReplaceGroup(72205304);
                ComposerKt.sourceInformation($composer, "476@16520L346");
                $composer$iv = $composer;
                factory$iv$iv$iv2 = factory$iv$iv$iv;
                TextKt.Text-Nvy7gAk($hintText, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default($textStyle, j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer, 48, 0, 131068);
            }
            $composer.endReplaceGroup();
            String str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
            Composer $composer$iv2 = $composer$iv;
            String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            TextScrollEffect($state, $inputBoxContent, RichInputField_1esR5Hs$lambda$2($decorBoxHeight$delegate), $scrollState, $composer, 0);
            TextLayoutResult textLayoutResult = $state.getTextLayoutResult();
            if (textLayoutResult == null) {
                $composer.startReplaceGroup(73088586);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(73088587);
                ComposerKt.sourceInformation($composer, "*518@18904L3422,494@17287L5039");
                Modifier modifier$iv2 = $this$RichInputField_1esR5Hs_u24lambda_u249_u241_u243_u240.matchParentSize(Modifier.Companion);
                ComposerKt.sourceInformationMarkerStart($composer, -425232965, "CC(remember):RichInputField.kt#9igjgp");
                boolean invalid$iv = $composer.changed($inputBoxContent) | $composer.changed($density) | $composer.changedInstance(textLayoutResult);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = (MeasurePolicy) new RichInputFieldKt$RichInputField$3$1$4$1$1$1$1($inputBoxContent, $density, textLayoutResult);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                MeasurePolicy measurePolicy$iv2 = (MeasurePolicy) it$iv;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv = ((0 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str3);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv = factory$iv$iv2;
                    $composer.createNode(factory$iv$iv);
                } else {
                    factory$iv$iv = factory$iv$iv2;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv >> 6) & 14;
                boolean z = false;
                ComposerKt.sourceInformationMarkerStart($composer, 386021229, "C:RichInputField.kt#92mklk");
                $composer.startReplaceGroup(428095255);
                ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
                Iterable $this$forEach$iv = $inputBoxContent.getInlineContents();
                boolean z2 = false;
                for (Object element$iv : $this$forEach$iv) {
                    InlineContent inlineContent = (InlineContent) element$iv;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    boolean z3 = z2;
                    $composer.startMovableGroup(-1291952123, inlineContent.getId());
                    ComposerKt.sourceInformation($composer, "499@17612L1146");
                    int $changed$iv$iv2 = $changed$iv$iv;
                    Modifier materialized$iv2 = materialized$iv;
                    Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, str2);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = measurePolicy$iv2;
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, str);
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                    boolean z4 = z;
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                    Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 6) & 896) | 6;
                    String str4 = str2;
                    String str5 = str;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, str3);
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv5;
                        $composer.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv5;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i5 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1477326272, "C500@17701L1011:RichInputField.kt#92mklk");
                    String $this$asRequest$iv = inlineContent.getUrl();
                    ImageRequest $this$RichInputField_1esR5Hs_u24lambda_u249_u241_u243_u240_u240_u241_u240_u240_u240 = new ImageRequest($this$asRequest$iv);
                    $this$RichInputField_1esR5Hs_u24lambda_u249_u241_u243_u240_u240_u241_u240_u240_u240.contentScale(ContentScale.Companion.getCrop());
                    $this$RichInputField_1esR5Hs_u24lambda_u249_u241_u243_u240_u240_u241_u240_u240_u240.autoPlay(inlineContent.getAnimated());
                    BiliImageKt.BiliImage($this$RichInputField_1esR5Hs_u24lambda_u249_u241_u243_u240_u240_u241_u240_u240_u240.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), "emote image", (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$RichInputFieldKt.INSTANCE.getLambda$401147669$ui_debug(), ComposableSingletons$RichInputFieldKt.INSTANCE.getLambda$1064029791$ui_debug(), $composer, 113246640, 120);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endMovableGroup();
                    str = str5;
                    measurePolicy$iv2 = measurePolicy$iv3;
                    $this$forEach$iv = $this$forEach$iv2;
                    z2 = z3;
                    $changed$iv$iv = $changed$iv$iv2;
                    materialized$iv = materialized$iv2;
                    z = z4;
                    str2 = str4;
                    str3 = str3;
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Unit unit = Unit.INSTANCE;
                $composer.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            innerTextField.invoke($composer, Integer.valueOf($dirty2 & 14));
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void TextScrollEffect(final RichInputFieldState state, final InputBoxContent inputBoxContent, final int decorBoxHeight, final ScrollState scrollState, Composer $composer, final int $changed) {
        int $dirty;
        Object obj;
        Object obj2;
        Object obj3;
        Integer num;
        int i;
        Integer num2;
        Composer $composer2 = $composer.startRestartGroup(-753498575);
        ComposerKt.sourceInformation($composer2, "C(TextScrollEffect)N(state,inputBoxContent,decorBoxHeight,scrollState):RichInputField.kt#92mklk");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(inputBoxContent) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(decorBoxHeight) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(scrollState) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (!$composer2.shouldExecute(($dirty3 & 1171) != 1170, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-753498575, $dirty3, -1, "kntr.app.im.chat.ui.widget.TextScrollEffect (RichInputField.kt:595)");
            }
            try {
                Result.Companion companion = Result.Companion;
                TextLayoutResult textLayoutResult = state.getTextLayoutResult();
                if (textLayoutResult == null) {
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(textLayoutResult.getLineForOffset(inputBoxContent.getCursorStart()));
                }
                obj = Result.constructor-impl(num2);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Object cursorLineNumber = obj;
            Integer lineNumber = (Integer) (Result.isFailure-impl(cursorLineNumber) ? null : cursorLineNumber);
            if (lineNumber == null) {
                $composer2.startReplaceGroup(-1976544365);
                $composer2.endReplaceGroup();
                $dirty = $dirty3;
            } else {
                $composer2.startReplaceGroup(-1976544364);
                ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                int lineIndex = lineNumber.intValue();
                try {
                    Result.Companion companion3 = Result.Companion;
                    TextLayoutResult textLayoutResult2 = state.getTextLayoutResult();
                    obj2 = Result.constructor-impl(textLayoutResult2 != null ? Float.valueOf(textLayoutResult2.getLineBottom(lineIndex)) : null);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                Float lineBottom = (Float) obj2;
                try {
                    Result.Companion companion5 = Result.Companion;
                    TextLayoutResult textLayoutResult3 = state.getTextLayoutResult();
                    obj3 = Result.constructor-impl(textLayoutResult3 != null ? Float.valueOf(textLayoutResult3.getLineTop(lineIndex)) : null);
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
                }
                Float lineTop = Result.isFailure-impl(obj3) ? null : obj3;
                if (lineBottom == null || lineTop == null) {
                    $dirty = $dirty3;
                    $composer2.startReplaceGroup(681185543);
                } else {
                    $composer2.startReplaceGroup(704244397);
                    ComposerKt.sourceInformation($composer2, "620@23377L378,617@23292L463");
                    float lineHeight = lineBottom.floatValue() - lineTop.floatValue();
                    Integer valueOf = Integer.valueOf(lineIndex);
                    Float valueOf2 = Float.valueOf(lineHeight);
                    ComposerKt.sourceInformationMarkerStart($composer2, -115825131, "CC(remember):RichInputField.kt#9igjgp");
                    boolean invalid$iv = (($dirty3 & 896) == 256) | (($dirty3 & 7168) == 2048) | $composer2.changed(lineBottom) | $composer2.changed(lineTop);
                    Object value$iv = $composer2.rememberedValue();
                    if (!invalid$iv && value$iv != Composer.Companion.getEmpty()) {
                        $dirty = $dirty3;
                        num = valueOf;
                        i = 0;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(num, valueOf2, (Function2) value$iv, $composer2, i);
                    }
                    num = valueOf;
                    $dirty = $dirty3;
                    i = 0;
                    value$iv = new RichInputFieldKt$TextScrollEffect$1$1$1(decorBoxHeight, scrollState, lineBottom, lineTop, null);
                    $composer2.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(num, valueOf2, (Function2) value$iv, $composer2, i);
                }
                $composer2.endReplaceGroup();
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj4, Object obj5) {
                    Unit TextScrollEffect$lambda$2;
                    TextScrollEffect$lambda$2 = RichInputFieldKt.TextScrollEffect$lambda$2(RichInputFieldState.this, inputBoxContent, decorBoxHeight, scrollState, $changed, (Composer) obj4, ((Integer) obj5).intValue());
                    return TextScrollEffect$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmotePlaceholder(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-136765864);
        ComposerKt.sourceInformation($composer2, "C(EmotePlaceholder)N(modifier)636@23891L29,639@24061L6,635@23853L233:RichInputField.kt#92mklk");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-136765864, $dirty2, -1, "kntr.app.im.chat.ui.widget.EmotePlaceholder (RichInputField.kt:634)");
            }
            ImageKt.Image(BiliIconfont.INSTANCE.getBrandtv_defaultimage_fill_100($composer2, 6), "emoticon placeholder", modifier, (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_weak-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | 48 | (($dirty2 << 6) & 896), 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.RichInputFieldKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit EmotePlaceholder$lambda$0;
                    EmotePlaceholder$lambda$0 = RichInputFieldKt.EmotePlaceholder$lambda$0(modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return EmotePlaceholder$lambda$0;
                }
            });
        }
    }

    /* renamed from: TransparentTextSelectionColors-RPmYEkk  reason: not valid java name */
    public static final TextSelectionColors m1987TransparentTextSelectionColorsRPmYEkk(RichInputFieldValue richInputFieldValue, long j2, Composer $composer, int $changed) {
        long j3;
        Intrinsics.checkNotNullParameter(richInputFieldValue, "richInputFieldValue");
        ComposerKt.sourceInformationMarkerStart($composer, 2086271814, "C(TransparentTextSelectionColors)N(richInputFieldValue,cursorColor:c#ui.graphics.Color)657@24498L11:RichInputField.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2086271814, $changed, -1, "kntr.app.im.chat.ui.widget.TransparentTextSelectionColors (RichInputField.kt:647)");
        }
        long $this$TransparentTextSelectionColors_RPmYEkk_u24lambda_u240 = richInputFieldValue.getTextFieldValue().getSelection-d9O1mEE();
        if (TextRange.getStart-impl($this$TransparentTextSelectionColors_RPmYEkk_u24lambda_u240) == TextRange.getEnd-impl($this$TransparentTextSelectionColors_RPmYEkk_u24lambda_u240)) {
            j3 = Color.Companion.getTransparent-0d7_KjU();
        } else {
            j3 = j2;
        }
        TextSelectionColors textSelectionColors = new TextSelectionColors(j3, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return textSelectionColors;
    }
}