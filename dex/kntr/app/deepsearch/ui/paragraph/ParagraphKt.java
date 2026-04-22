package kntr.app.deepsearch.ui.paragraph;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KClickBubble;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.ParagraphStateKt;
import com.bilibili.common.paragraph.action.ParagraphStateBuilderScope;
import com.bilibili.common.paragraph.builder.ParagraphBuilderKt;
import com.bilibili.common.paragraph.builder.ParagraphBuilderProvider;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.constant.SortedListDrawParams;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListener;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListenerKt;
import com.bilibili.common.paragraph.impl.text.TextParagraphBuilderScope;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.IBiliColors;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.ui.bubbles.BubbleKt;
import kntr.app.deepsearch.ui.colors.DayNightColor;
import kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphComponent;
import kntr.app.deepsearch.ui.paragraph.constants.ParagraphTextDrawParams;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Paragraph.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001aa\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\f\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u008a\u008e\u0002²\u0006\f\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u008a\u008e\u0002"}, d2 = {"Paragraph", RoomRecommendViewModel.EMPTY_CURSOR, "paragraphList", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "embed", RoomRecommendViewModel.EMPTY_CURSOR, "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "routeUriHandler", "Landroidx/compose/ui/platform/UriHandler;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/platform/UriHandler;", "compose_debug", "showBubble", "miniWindowMode", "offset", "Landroidx/compose/ui/geometry/Offset;", "clickBubble", "Lcom/bapis/bilibili/app/dynamic/v2/KClickBubble;", "charRect", "Landroidx/compose/ui/geometry/Rect;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ParagraphKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Paragraph$lambda$18(List list, Modifier modifier, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, String str, boolean z, Function1 function1, int i, int i2, Composer composer, int i3) {
        Paragraph(list, modifier, vertical, horizontal, str, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void Paragraph(final List<KModuleParagraph> list, Modifier modifier, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, String queryId, boolean embed, final Function1<? super DeepSearchAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Arrangement.Vertical vertical;
        Alignment.Horizontal horizontal;
        String str;
        boolean z;
        Modifier modifier3;
        Arrangement.Vertical verticalArrangement2;
        Alignment.Horizontal horizontalAlignment2;
        boolean embed2;
        String queryId2;
        Object paragraphTextDrawParams;
        int $dirty;
        Intrinsics.checkNotNullParameter(list, "paragraphList");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Composer $composer2 = $composer.startRestartGroup(-1188069603);
        ComposerKt.sourceInformation($composer2, "C(Paragraph)N(paragraphList,modifier,verticalArrangement,horizontalAlignment,queryId,embed,dispatcher)52@2386L34,53@2447L34,54@2500L40,55@2564L48,56@2633L40,58@2745L13,58@2707L536,71@3273L7,73@3319L9,74@3369L6,85@3744L7,86@3806L7,92@4113L1181,79@3450L1855,120@5370L17,122@5438L1706,119@5311L1833:Paragraph.kt#a32fmc");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            vertical = verticalArrangement;
        } else if (($changed & 384) == 0) {
            vertical = verticalArrangement;
            $dirty2 |= $composer2.changed(vertical) ? 256 : 128;
        } else {
            vertical = verticalArrangement;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            horizontal = horizontalAlignment;
        } else if (($changed & 3072) == 0) {
            horizontal = horizontalAlignment;
            $dirty2 |= $composer2.changed(horizontal) ? 2048 : 1024;
        } else {
            horizontal = horizontalAlignment;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            str = queryId;
        } else if (($changed & 24576) == 0) {
            str = queryId;
            $dirty2 |= $composer2.changed(str) ? 16384 : 8192;
        } else {
            str = queryId;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
            z = embed;
        } else if (($changed & 196608) == 0) {
            z = embed;
            $dirty2 |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = embed;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        if ($composer2.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                verticalArrangement2 = vertical;
            } else {
                verticalArrangement2 = Arrangement.INSTANCE.getTop();
            }
            if (i4 == 0) {
                horizontalAlignment2 = horizontal;
            } else {
                horizontalAlignment2 = Alignment.Companion.getStart();
            }
            if (i5 == 0) {
                queryId2 = str;
            } else {
                queryId2 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (i6 == 0) {
                embed2 = z;
            } else {
                embed2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1188069603, $dirty2, -1, "kntr.app.deepsearch.ui.paragraph.Paragraph (Paragraph.kt:51)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 726423391, "CC(remember):Paragraph.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState showBubble$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 726425343, "CC(remember):Paragraph.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState miniWindowMode$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 726427045, "CC(remember):Paragraph.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState offset$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 726429101, "CC(remember):Paragraph.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState clickBubble$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 726431301, "CC(remember):Paragraph.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final MutableState charRect$delegate = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean Paragraph$lambda$1 = Paragraph$lambda$1(showBubble$delegate);
            Enum dayNightTheme = BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, 726434165, "CC(remember):Paragraph.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(Paragraph$lambda$1) | ((458752 & $dirty2) == 131072) | $composer2.changed(dayNightTheme.ordinal());
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv || it$iv6 == Composer.Companion.getEmpty()) {
                if (embed2) {
                    paragraphTextDrawParams = new ParagraphTextDrawParams(7, TextOverflow.box-impl(TextOverflow.Companion.getEllipsis-gIe3tQ8()), Paragraph$lambda$1(showBubble$delegate) ? new DayNightColor(new Function1<IBiliColors, Color>() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$Paragraph$textDrawParams$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            return Color.box-impl(m771invokevNxB06k((IBiliColors) p1));
                        }

                        /* renamed from: invoke-vNxB06k  reason: not valid java name */
                        public final long m771invokevNxB06k(IBiliColors $this$DayNightColor) {
                            Intrinsics.checkNotNullParameter($this$DayNightColor, "$this$DayNightColor");
                            return $this$DayNightColor.getPi5-0d7_KjU();
                        }
                    }) : new DayNightColor(new Function1<IBiliColors, Color>() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$Paragraph$textDrawParams$1$2
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            return Color.box-impl(m772invokevNxB06k((IBiliColors) p1));
                        }

                        /* renamed from: invoke-vNxB06k  reason: not valid java name */
                        public final long m772invokevNxB06k(IBiliColors $this$DayNightColor) {
                            Intrinsics.checkNotNullParameter($this$DayNightColor, "$this$DayNightColor");
                            return $this$DayNightColor.getGa4-0d7_KjU();
                        }
                    }), null);
                } else {
                    paragraphTextDrawParams = new ParagraphTextDrawParams(null, null, Paragraph$lambda$1(showBubble$delegate) ? new DayNightColor(new Function1<IBiliColors, Color>() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$Paragraph$textDrawParams$1$3
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            return Color.box-impl(m773invokevNxB06k((IBiliColors) p1));
                        }

                        /* renamed from: invoke-vNxB06k  reason: not valid java name */
                        public final long m773invokevNxB06k(IBiliColors $this$DayNightColor) {
                            Intrinsics.checkNotNullParameter($this$DayNightColor, "$this$DayNightColor");
                            return $this$DayNightColor.getPi5-0d7_KjU();
                        }
                    }) : new DayNightColor(new Function1<IBiliColors, Color>() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$Paragraph$textDrawParams$1$4
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            return Color.box-impl(m774invokevNxB06k((IBiliColors) p1));
                        }

                        /* renamed from: invoke-vNxB06k  reason: not valid java name */
                        public final long m774invokevNxB06k(IBiliColors $this$DayNightColor) {
                            Intrinsics.checkNotNullParameter($this$DayNightColor, "$this$DayNightColor");
                            return $this$DayNightColor.getGa4-0d7_KjU();
                        }
                    }), 3, null);
                }
                Object value$iv6 = paragraphTextDrawParams;
                $composer2.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            ParagraphTextDrawParams paragraphTextDrawParams2 = (ParagraphTextDrawParams) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(28), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646142, (Object) null);
            Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
            DeepSearchParagraphComponent.Builder deepSearchParagraphComponentFactory = ((DeepSearchParagraphEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(DeepSearchParagraphEntryPoint.class))).getDeepSearchParagraphComponentFactory();
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            DeepSearchParagraphComponent.Builder bindDensity = deepSearchParagraphComponentFactory.bindDensity((Density) consume2);
            CompositionLocal this_$iv3 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            DeepSearchParagraphComponent.Builder bindParagraphTextDrawParams = bindDensity.bindDayNight((ThemeDayNight) consume3).bindSortedListDrawParams(new SortedListDrawParams(0.0f, 0.0f, 0.0f, 0.0f, 0L, 31, (DefaultConstructorMarker) null)).bindParagraphTextDrawParams(null);
            ParagraphBuilderProvider deepSearchParagraphBuilderProvider = bindParagraphTextDrawParams.bindDefaultTextStyle(bindParagraphTextDrawParams).build().deepSearchParagraphBuilderProvider();
            ComposerKt.sourceInformationMarkerStart($composer2, 726479802, "CC(remember):Paragraph.kt#9igjgp");
            boolean invalid$iv2 = ((3670016 & $dirty2) == 1048576) | ((57344 & $dirty2) == 16384) | $composer2.changedInstance(router);
            Object value$iv7 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv7 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                final String str2 = queryId2;
                value$iv7 = new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit Paragraph$lambda$16$0;
                        Paragraph$lambda$16$0 = ParagraphKt.Paragraph$lambda$16$0(function1, str2, router, charRect$delegate, showBubble$delegate, clickBubble$delegate, (ParagraphStateBuilderScope) obj);
                        return Paragraph$lambda$16$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
            } else {
                $dirty = $dirty2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ParagraphState state = ParagraphStateKt.rememberParagraphState(list, (TextStyle) null, deepSearchParagraphBuilderProvider, (Function1) value$iv7, $composer2, $dirty & 14, 2);
            ProvidedValue[] providedValueArr = {CompositionLocalsKt.getLocalUriHandler().provides(routeUriHandler($composer2, 0)), TextKt.getLocalTextStyle().provides(providedValueArr)};
            final Modifier modifier4 = modifier3;
            final Arrangement.Vertical vertical2 = verticalArrangement2;
            final Alignment.Horizontal horizontal2 = horizontalAlignment2;
            final String str3 = queryId2;
            CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(-1797647779, true, new Function2() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Paragraph$lambda$17;
                    Paragraph$lambda$17 = ParagraphKt.Paragraph$lambda$17(modifier4, vertical2, horizontal2, offset$delegate, miniWindowMode$delegate, state, function1, str3, showBubble$delegate, charRect$delegate, clickBubble$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return Paragraph$lambda$17;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            verticalArrangement2 = vertical;
            horizontalAlignment2 = horizontal;
            embed2 = z;
            queryId2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Arrangement.Vertical vertical3 = verticalArrangement2;
            final Alignment.Horizontal horizontal3 = horizontalAlignment2;
            final String str4 = queryId2;
            final boolean z2 = embed2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Paragraph$lambda$18;
                    Paragraph$lambda$18 = ParagraphKt.Paragraph$lambda$18(list, modifier5, vertical3, horizontal3, str4, z2, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Paragraph$lambda$18;
                }
            });
        }
    }

    private static final boolean Paragraph$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void Paragraph$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean Paragraph$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void Paragraph$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final long Paragraph$lambda$7(MutableState<Offset> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Offset) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void Paragraph$lambda$8(MutableState<Offset> mutableState, long j2) {
        Object value$iv = Offset.box-impl(j2);
        mutableState.setValue(value$iv);
    }

    private static final KClickBubble Paragraph$lambda$10(MutableState<KClickBubble> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (KClickBubble) $this$getValue$iv.getValue();
    }

    private static final Rect Paragraph$lambda$13(MutableState<Rect> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Rect) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Paragraph$lambda$16$0(final Function1 $dispatcher, final String $queryId, final Router $router, final MutableState $charRect$delegate, final MutableState $showBubble$delegate, final MutableState $clickBubble$delegate, ParagraphStateBuilderScope $this$rememberParagraphState) {
        Intrinsics.checkNotNullParameter($this$rememberParagraphState, "$this$rememberParagraphState");
        TextNodeClickListenerKt.registerTextParagraphClickListener($this$rememberParagraphState, new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit Paragraph$lambda$16$0$0;
                Paragraph$lambda$16$0$0 = ParagraphKt.Paragraph$lambda$16$0$0($dispatcher, $queryId, $router, $charRect$delegate, $showBubble$delegate, $clickBubble$delegate, (TextParagraphBuilderScope) obj);
                return Paragraph$lambda$16$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Paragraph$lambda$16$0$0(final Function1 $dispatcher, final String $queryId, final Router $router, final MutableState $charRect$delegate, final MutableState $showBubble$delegate, final MutableState $clickBubble$delegate, TextParagraphBuilderScope $this$registerTextParagraphClickListener) {
        Intrinsics.checkNotNullParameter($this$registerTextParagraphClickListener, "$this$registerTextParagraphClickListener");
        $this$registerTextParagraphClickListener.registerNode(Reflection.getOrCreateKotlinClass(KTextNode.KLink.class), new TextNodeClickListener() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$$ExternalSyntheticLambda0
            public final boolean invoke(KTextNode.IText iText, TextNodeClickInfo textNodeClickInfo) {
                boolean Paragraph$lambda$16$0$0$0;
                Paragraph$lambda$16$0$0$0 = ParagraphKt.Paragraph$lambda$16$0$0$0($dispatcher, $queryId, $router, $charRect$delegate, $showBubble$delegate, $clickBubble$delegate, (KTextNode.KLink) iText, textNodeClickInfo);
                return Paragraph$lambda$16$0$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Paragraph$lambda$16$0$0$0(Function1 $dispatcher, String $queryId, Router $router, MutableState $charRect$delegate, MutableState $showBubble$delegate, MutableState $clickBubble$delegate, KTextNode.KLink kLink, TextNodeClickInfo info) {
        Intrinsics.checkNotNullParameter(kLink, "<unused var>");
        Intrinsics.checkNotNullParameter(info, "info");
        KClickBubble bubble = info.getNode().getValue().getLinkClickBubble();
        if (bubble != null) {
            int textIndex = info.getTextLayoutResult().getOffsetForPosition-k-4lQ0M(info.getClickAt-F1C5BW0());
            $charRect$delegate.setValue(info.getTextLayoutResult().getBoundingBox(textIndex));
            Paragraph$lambda$2($showBubble$delegate, true);
            $clickBubble$delegate.setValue(bubble);
        } else {
            $dispatcher.invoke(new DeepSearchAction.TrackerAction.LinkNodeClick(info.getNode().getValue(), $queryId));
            $router.launch(UrisKt.toUri(info.getNode().getValue().getLink()));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit Paragraph$lambda$17(Modifier $modifier, Arrangement.Vertical $verticalArrangement, Alignment.Horizontal $horizontalAlignment, final MutableState $offset$delegate, final MutableState $miniWindowMode$delegate, ParagraphState $state, final Function1 $dispatcher, final String $queryId, final MutableState $showBubble$delegate, MutableState $charRect$delegate, final MutableState $clickBubble$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C125@5525L391,123@5448L1690:Paragraph.kt#a32fmc");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1797647779, $changed, -1, "kntr.app.deepsearch.ui.paragraph.Paragraph.<anonymous> (Paragraph.kt:123)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -962659452, "CC(remember):Paragraph.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit Paragraph$lambda$17$0$0;
                        Paragraph$lambda$17$0$0 = ParagraphKt.Paragraph$lambda$17$0$0($offset$delegate, $miniWindowMode$delegate, (LayoutCoordinates) obj);
                        return Paragraph$lambda$17$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned($modifier, (Function1) it$iv);
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy($verticalArrangement, $horizontalAlignment, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1911380104, "C142@6215L7,146@6368L22,150@6525L588,143@6235L893:Paragraph.kt#a32fmc");
            $composer.startReplaceGroup(477298933);
            ComposerKt.sourceInformation($composer, "*139@6128L19,139@6100L63");
            List $this$fastForEach$iv = $state.getContents();
            int $i$f$fastForEach = $this$fastForEach$iv.size();
            int index$iv = 0;
            while (index$iv < $i$f$fastForEach) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                List $this$fastForEach$iv2 = $this$fastForEach$iv;
                ParagraphContent it = (ParagraphContent) item$iv;
                it.Content(SizeKt.fillMaxWidth$default(ParagraphBuilderKt.padding(Modifier.Companion, it.getSpacing(), $composer, 6), 0.0f, 1, (Object) null), $composer, 0);
                index$iv++;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                $i$f$fastForEach = $i$f$fastForEach;
                z2 = z2;
                z = z;
                measurePolicy$iv$iv = measurePolicy$iv$iv;
            }
            $composer.endReplaceGroup();
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final Router route = (Router) consume;
            boolean Paragraph$lambda$4 = Paragraph$lambda$4($miniWindowMode$delegate);
            boolean Paragraph$lambda$1 = Paragraph$lambda$1($showBubble$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 477308477, "CC(remember):Paragraph.kt#9igjgp");
            Object value$iv2 = $composer.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit Paragraph$lambda$17$1$1$0;
                        Paragraph$lambda$17$1$1$0 = ParagraphKt.Paragraph$lambda$17$1$1$0($showBubble$delegate);
                        return Paragraph$lambda$17$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            }
            Function0 function0 = (Function0) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Rect Paragraph$lambda$13 = Paragraph$lambda$13($charRect$delegate);
            long Paragraph$lambda$7 = Paragraph$lambda$7($offset$delegate);
            KClickBubble Paragraph$lambda$10 = Paragraph$lambda$10($clickBubble$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 477314067, "CC(remember):Paragraph.kt#9igjgp");
            boolean invalid$iv = $composer.changed($dispatcher) | $composer.changed($queryId) | $composer.changedInstance(route);
            Object it$iv2 = $composer.rememberedValue();
            if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                BubbleKt.m703DSBubblePopuptZEomGk(Paragraph$lambda$4, Paragraph$lambda$1, function0, Paragraph$lambda$13, Paragraph$lambda$7, Paragraph$lambda$10, (Function0) it$iv2, $composer, 384);
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
            Object value$iv3 = new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit Paragraph$lambda$17$1$2$0;
                    Paragraph$lambda$17$1$2$0 = ParagraphKt.Paragraph$lambda$17$1$2$0(route, $clickBubble$delegate, $dispatcher, $queryId, $showBubble$delegate);
                    return Paragraph$lambda$17$1$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv2 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            BubbleKt.m703DSBubblePopuptZEomGk(Paragraph$lambda$4, Paragraph$lambda$1, function0, Paragraph$lambda$13, Paragraph$lambda$7, Paragraph$lambda$10, (Function0) it$iv2, $composer, 384);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Paragraph$lambda$17$0$0(MutableState $offset$delegate, MutableState $miniWindowMode$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        long screenOffset = it.localToScreen-MK-Hz9U(Offset.Companion.getZero-F1C5BW0());
        Paragraph$lambda$8($offset$delegate, it.localToWindow-MK-Hz9U(Offset.Companion.getZero-F1C5BW0()));
        int bits$iv$iv$iv = (int) (screenOffset & 4294967295L);
        float intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv);
        int bits$iv$iv$iv2 = (int) (4294967295L & Paragraph$lambda$7($offset$delegate));
        if (!(intBitsToFloat == Float.intBitsToFloat(bits$iv$iv$iv2))) {
            Paragraph$lambda$5($miniWindowMode$delegate, true);
        } else {
            Paragraph$lambda$8($offset$delegate, screenOffset);
            Paragraph$lambda$5($miniWindowMode$delegate, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Paragraph$lambda$17$1$1$0(MutableState $showBubble$delegate) {
        Paragraph$lambda$2($showBubble$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Paragraph$lambda$17$1$2$0(Router $route, MutableState $clickBubble$delegate, Function1 $dispatcher, String $queryId, MutableState $showBubble$delegate) {
        KClickBubble it = Paragraph$lambda$10($clickBubble$delegate);
        if (it != null) {
            $dispatcher.invoke(new DeepSearchAction.TrackerAction.BubbleClick(it.getBubbleType(), it.getBizId(), $queryId));
        }
        Paragraph$lambda$2($showBubble$delegate, false);
        KClickBubble Paragraph$lambda$10 = Paragraph$lambda$10($clickBubble$delegate);
        String url = Paragraph$lambda$10 != null ? Paragraph$lambda$10.getUrl() : null;
        if (url == null) {
            url = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $route.launch(UrisKt.toUri(url));
        return Unit.INSTANCE;
    }

    public static final UriHandler routeUriHandler(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1394043945, "C(routeUriHandler)173@7224L7,174@7243L160:Paragraph.kt#a32fmc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1394043945, $changed, -1, "kntr.app.deepsearch.ui.paragraph.routeUriHandler (Paragraph.kt:172)");
        }
        CompositionLocal this_$iv = RouterKt.getLocalRouter();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Router route = (Router) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 353568023, "CC(remember):Paragraph.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new UriHandler() { // from class: kntr.app.deepsearch.ui.paragraph.ParagraphKt$routeUriHandler$1$1
                public void openUri(String uri) {
                    Intrinsics.checkNotNullParameter(uri, "uri");
                    route.launch(UrisKt.toUri(uri));
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ParagraphKt$routeUriHandler$1$1 paragraphKt$routeUriHandler$1$1 = (ParagraphKt$routeUriHandler$1$1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return paragraphKt$routeUriHandler$1$1;
    }
}