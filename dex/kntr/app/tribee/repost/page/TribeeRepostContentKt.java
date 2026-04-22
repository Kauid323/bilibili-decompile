package kntr.app.tribee.repost.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KOptionItem;
import com.bapis.bilibili.app.dynamic.v2.KOptionItemType;
import com.bapis.bilibili.app.dynamic.v2.KRepostOpus2TribeeOptionsResp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.tribee.repost.state.TribeeRepostState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.screen.adjust.KScreenAdjustUtilsKt;
import kntr.common.trio.p000switch.SimpleSwitchColors;
import kntr.common.trio.p000switch.SimpleSwitchKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeRepostContent.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\u001a\u008b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0007¢\u0006\u0002\u0010\u0014\u001aW\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0003¢\u0006\u0004\b\u001f\u0010 \u001a;\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0017H\u0003¢\u0006\u0002\u0010%\u001a\u0099\u0001\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00112\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00102\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00192\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00192\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0004\b/\u00100\u001aC\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00172\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u00104\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0004\b5\u00106\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u00067"}, d2 = {"convertedBizType", "Lkntr/app/tribee/repost/page/KOptionItemBizType;", "Lcom/bapis/bilibili/app/dynamic/v2/KOptionItem;", "getConvertedBizType", "(Lcom/bapis/bilibili/app/dynamic/v2/KOptionItem;)Lkntr/app/tribee/repost/page/KOptionItemBizType;", "TribeeRepostContent", "", "state", "Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;", "modifier", "Landroidx/compose/ui/Modifier;", "onClickSelectTribee", "Lkotlin/Function0;", "onClickIntro", "onClickEdit", "onRepostToFollowingChange", "Lkotlin/Function1;", "", "onRepostWithSourceChange", "onClickRepost", "(Lkntr/app/tribee/repost/state/TribeeRepostState$TribeeRepostContentState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SelectSettingItem", "title", "", "entryLeftIcon", "Landroidx/compose/ui/graphics/painter/Painter;", "entryLeftText", "entryRightText", "height", "Landroidx/compose/ui/unit/Dp;", "onClickedEntry", "SelectSettingItem-WH-ejsw", "(Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Ljava/lang/String;FLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SelectSettingItemEntryIconLeftArea", "icon", "leftText", "rightText", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "SwitchSettingItem", "checked", "onCheckedChange", "titleIcon", "onClickTitleIcon", "subtitle", "subtitleEntryText", "subtitleEntryIcon", "onClickSubtitleEntry", "SwitchSettingItem-yKJFJhA", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function0;FLandroidx/compose/runtime/Composer;III)V", "RepostButton", "text", "onClick", "enabled", "RepostButton-FJfuzF0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZFLandroidx/compose/runtime/Composer;II)V", "repost_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeRepostContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepostButton_FJfuzF0$lambda$1(String str, Function0 function0, Modifier modifier, boolean z, float f, int i, int i2, Composer composer, int i3) {
        m990RepostButtonFJfuzF0(str, function0, modifier, z, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectSettingItemEntryIconLeftArea$lambda$1(Modifier modifier, Painter painter, String str, String str2, int i, int i2, Composer composer, int i3) {
        SelectSettingItemEntryIconLeftArea(modifier, painter, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectSettingItem_WH_ejsw$lambda$3(String str, Painter painter, String str2, String str3, float f, Function0 function0, int i, int i2, Composer composer, int i3) {
        m991SelectSettingItemWHejsw(str, painter, str2, str3, f, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchSettingItem_yKJFJhA$lambda$3(boolean z, Function1 function1, Modifier modifier, String str, Painter painter, Function0 function0, String str2, String str3, Painter painter2, Function0 function02, float f, int i, int i2, int i3, Composer composer, int i4) {
        m992SwitchSettingItemyKJFJhA(z, function1, modifier, str, painter, function0, str2, str3, painter2, function02, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostContent$lambda$7(TribeeRepostState.TribeeRepostContentState tribeeRepostContentState, Modifier modifier, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function1 function12, Function0 function04, int i, int i2, Composer composer, int i3) {
        TribeeRepostContent(tribeeRepostContentState, modifier, function0, function02, function03, function1, function12, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final KOptionItemBizType getConvertedBizType(KOptionItem $this$convertedBizType) {
        Intrinsics.checkNotNullParameter($this$convertedBizType, "<this>");
        long bizType = $this$convertedBizType.getBizType();
        if (bizType == 1) {
            return KOptionItemBizType.SelectTribee;
        }
        if (bizType == 2) {
            return KOptionItemBizType.SwitchRepostToFollowing;
        }
        if (bizType == 3) {
            return KOptionItemBizType.SwitchRepostWithSource;
        }
        return KOptionItemBizType.Unknown;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostContent$lambda$3$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostContent$lambda$4$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r5v73 */
    /* JADX WARN: Type inference failed for: r8v44 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v50 */
    public static final void TribeeRepostContent(final TribeeRepostState.TribeeRepostContentState state, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super Boolean, Unit> function1, Function1<? super Boolean, Unit> function12, Function0<Unit> function04, Composer $composer, final int $changed, final int i) {
        Function0 onClickSelectTribee;
        Function0 onClickIntro;
        Function0 onClickEdit;
        int $dirty;
        Composer $composer$iv$iv$iv;
        Modifier modifier2;
        final Function1 onRepostToFollowingChange;
        final Function1 onRepostWithSourceChange;
        Function0 onClickRepost;
        Function0 onClickSelectTribee2;
        final Function0 onClickIntro2;
        final Function0 onClickEdit2;
        Function1 onRepostToFollowingChange2;
        Function1 onRepostWithSourceChange2;
        Function0 onClickRepost2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(1756659248);
        ComposerKt.sourceInformation($composer2, "C(TribeeRepostContent)N(state,modifier,onClickSelectTribee,onClickIntro,onClickEdit,onRepostToFollowingChange,onRepostWithSourceChange,onClickRepost)79@2987L2,80@3022L2,81@3056L2,82@3111L2,83@3165L2,84@3201L2,86@3213L6680:TribeeRepostContent.kt#qxdvwz");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            onClickSelectTribee = function0;
        } else if (($changed & 384) == 0) {
            onClickSelectTribee = function0;
            $dirty2 |= $composer2.changedInstance(onClickSelectTribee) ? 256 : 128;
        } else {
            onClickSelectTribee = function0;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            onClickIntro = function02;
        } else if (($changed & 3072) == 0) {
            onClickIntro = function02;
            $dirty2 |= $composer2.changedInstance(onClickIntro) ? 2048 : 1024;
        } else {
            onClickIntro = function02;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            onClickEdit = function03;
        } else if (($changed & 24576) == 0) {
            onClickEdit = function03;
            $dirty2 |= $composer2.changedInstance(onClickEdit) ? 16384 : 8192;
        } else {
            onClickEdit = function03;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(function12) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function04) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 227394898, "CC(remember):TribeeRepostContent.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onClickSelectTribee3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClickSelectTribee = onClickSelectTribee3;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 227396018, "CC(remember):TribeeRepostContent.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda13
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onClickIntro3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClickIntro = onClickIntro3;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 227397106, "CC(remember):TribeeRepostContent.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function0 onClickEdit3 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClickEdit = onClickEdit3;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 227398866, "CC(remember):TribeeRepostContent.kt#9igjgp");
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda15
                        public final Object invoke(Object obj) {
                            Unit TribeeRepostContent$lambda$3$0;
                            TribeeRepostContent$lambda$3$0 = TribeeRepostContentKt.TribeeRepostContent$lambda$3$0(((Boolean) obj).booleanValue());
                            return TribeeRepostContent$lambda$3$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                onRepostToFollowingChange2 = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onRepostToFollowingChange2 = function1;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 227400594, "CC(remember):TribeeRepostContent.kt#9igjgp");
                Object it$iv5 = $composer2.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj) {
                            Unit TribeeRepostContent$lambda$4$0;
                            TribeeRepostContent$lambda$4$0 = TribeeRepostContentKt.TribeeRepostContent$lambda$4$0(((Boolean) obj).booleanValue());
                            return TribeeRepostContent$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                onRepostWithSourceChange2 = it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onRepostWithSourceChange2 = function12;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 227401746, "CC(remember):TribeeRepostContent.kt#9igjgp");
                Object it$iv6 = $composer2.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda17
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                onClickRepost2 = it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onClickRepost2 = function04;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1756659248, $dirty2, -1, "kntr.app.tribee.repost.page.TribeeRepostContent (TribeeRepostContent.kt:85)");
            }
            Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null));
            modifier2 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            onClickRepost = onClickRepost2;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            onRepostWithSourceChange = onRepostWithSourceChange2;
            onRepostToFollowingChange = onRepostToFollowingChange2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i10 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeRepostContent_u24lambda_u246 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 557420272, "C91@3416L6,87@3286L946,126@4722L3891,121@4526L4087,205@8622L1265:TribeeRepostContent.kt#qxdvwz");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(37)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            onClickEdit2 = onClickEdit;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            onClickIntro2 = onClickIntro;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i12 = ((384 >> 6) & 112) | 6;
            RowScope $this$TribeeRepostContent_u24lambda_u246_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -987883012, "C95@3549L40,98@3690L30,99@3755L6,96@3602L229,102@3844L39,106@4014L6,103@3896L273,111@4182L40:TribeeRepostContent.kt#qxdvwz");
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer2, 6);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getWarning_report_circle_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer2, 6);
            TextKt.Text-Nvy7gAk(state.getData().getHeadTips(), RowScope.-CC.weight$default($this$TribeeRepostContent_u24lambda_u246_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24576, 24960, 241640);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Iterable $this$filter$iv = state.getData().getItems();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                KOptionItem item = (KOptionItem) element$iv$iv;
                KOptionItemType type = item.getType();
                if (type instanceof KOptionItemType.OPTION_ITEM_TYPE_SELECT ? true : type instanceof KOptionItemType.OPTION_ITEM_TYPE_SWITCH) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            final List filteredItems = (List) destination$iv$iv;
            Modifier modifier4 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(37), 0.0f, Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(20) + Dp.constructor-impl(44)) + Dp.constructor-impl(1)) + Dp.constructor-impl(33)) + Dp.constructor-impl(12)), 5, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 18024541, "CC(remember):TribeeRepostContent.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(filteredItems) | (($dirty2 & 896) == 256) | (($dirty2 & 14) == 4) | (($dirty2 & 7168) == 2048) | ((57344 & $dirty2) == 16384) | ((458752 & $dirty2) == 131072) | ((3670016 & $dirty2) == 1048576);
            Object it$iv7 = $composer2.rememberedValue();
            if (invalid$iv || it$iv7 == Composer.Companion.getEmpty()) {
                final Function0 function05 = onClickSelectTribee;
                Object value$iv7 = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj) {
                        Unit TribeeRepostContent$lambda$6$2$0;
                        TribeeRepostContent$lambda$6$2$0 = TribeeRepostContentKt.TribeeRepostContent$lambda$6$2$0(filteredItems, function05, state, onClickIntro2, onClickEdit2, onRepostToFollowingChange, onRepostWithSourceChange, (LazyListScope) obj);
                        return TribeeRepostContent$lambda$6$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier4, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv7, $composer2, 6, 510);
            Modifier modifier$iv3 = $this$TribeeRepostContent_u24lambda_u246.align(Modifier.Companion, Alignment.Companion.getBottomCenter());
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Function0 onClickSelectTribee4 = onClickSelectTribee;
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer2.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i13 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i14 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -406952249, "C209@8781L41,210@8835L312,219@9160L40,220@9213L610,237@9836L41:TribeeRepostContent.kt#qxdvwz");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer2, 6);
            m990RepostButtonFJfuzF0(state.getData().getConfirmText(), onClickRepost, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null), state.getEnableClickPageRepost(), Dp.constructor-impl(44), $composer2, (($dirty2 >> 18) & 112) | 24960, 0);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(1)), $composer2, 6);
            Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(33)), 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
            $dirty = $dirty2;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv4 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            $composer$iv$iv$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer2.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i15 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i16 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 498087208, "C231@9640L6,228@9510L299:TribeeRepostContent.kt#qxdvwz");
            TextKt.Text-Nvy7gAk(state.getData().getFootTips(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24576, 24960, 240618);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onClickSelectTribee2 = onClickSelectTribee4;
        } else {
            $dirty = $dirty2;
            $composer$iv$iv$iv = $composer2;
            $composer$iv$iv$iv.skipToGroupEnd();
            modifier2 = modifier;
            onRepostToFollowingChange = function1;
            onRepostWithSourceChange = function12;
            onClickRepost = function04;
            onClickSelectTribee2 = onClickSelectTribee;
            onClickIntro2 = onClickIntro;
            onClickEdit2 = onClickEdit;
        }
        ScopeUpdateScope endRestartGroup = $composer$iv$iv$iv.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final Function0 function06 = onClickSelectTribee2;
            final Function0 function07 = onClickIntro2;
            final Function0 function08 = onClickEdit2;
            final Function1 function13 = onRepostToFollowingChange;
            final Function1 function14 = onRepostWithSourceChange;
            final Function0 function09 = onClickRepost;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeRepostContent$lambda$7;
                    TribeeRepostContent$lambda$7 = TribeeRepostContentKt.TribeeRepostContent$lambda$7(TribeeRepostState.TribeeRepostContentState.this, modifier5, function06, function07, function08, function13, function14, function09, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeRepostContent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeRepostContent$lambda$6$2$0(final List $filteredItems, final Function0 $onClickSelectTribee, final TribeeRepostState.TribeeRepostContentState $state, final Function0 $onClickIntro, final Function0 $onClickEdit, final Function1 $onRepostToFollowingChange, final Function1 $onRepostWithSourceChange, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$TribeeRepostContent$lambda$6$2$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m995invoke((KOptionItem) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m995invoke(KOptionItem kOptionItem) {
                return null;
            }
        };
        $this$LazyColumn.items($filteredItems.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$TribeeRepostContent$lambda$6$2$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke($filteredItems.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$TribeeRepostContent$lambda$6$2$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Composer $composer2;
                Painter titleIcon;
                String subtitle;
                String subtitleEntryText;
                Painter subtitleEntryIcon;
                boolean checked;
                Function1 onCheckedChange;
                String subtitleEntryText2;
                String second;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int i = $dirty & 14;
                    KOptionItem item = (KOptionItem) $filteredItems.get(it);
                    $composer.startReplaceGroup(1984414493);
                    ComposerKt.sourceInformation($composer, "CN(item):TribeeRepostContent.kt#qxdvwz");
                    if (item.getType() instanceof KOptionItemType.OPTION_ITEM_TYPE_SELECT) {
                        $composer.startReplaceGroup(1984382438);
                        ComposerKt.sourceInformation($composer, "152@5932L303");
                        String title = item.getTitle();
                        Painter entryLeftIcon = null;
                        String entryLeftText = null;
                        String entryRightText = null;
                        Function0 onClickedEntry = $onClickSelectTribee;
                        if (TribeeRepostContentKt.getConvertedBizType(item) == KOptionItemBizType.SelectTribee) {
                            $composer.startReplaceGroup(1984711038);
                            ComposerKt.sourceInformation($composer, "137@5268L26");
                            entryLeftIcon = BiliIconfont.INSTANCE.getBrandtv_small_station_line($composer, 6);
                            String second2 = $state.getSelectedTribee().getSecond();
                            boolean z = second2 == null || second2.length() == 0;
                            String str = null;
                            if (z) {
                                KRepostOpus2TribeeOptionsResp.KRenderParams params = $state.getData().getParams();
                                second = params != null ? params.getDefaultTribeeName() : null;
                            } else {
                                second = $state.getSelectedTribee().getSecond();
                            }
                            entryLeftText = second;
                            Long first = $state.getSelectedPartition().getFirst();
                            if (first == null || first.longValue() != 0) {
                                str = $state.getSelectedPartition().getSecond();
                            }
                            entryRightText = str;
                        } else {
                            $composer.startReplaceGroup(1979550778);
                        }
                        $composer.endReplaceGroup();
                        TribeeRepostContentKt.m991SelectSettingItemWHejsw(title, entryLeftIcon, entryLeftText, entryRightText, 0.0f, onClickedEntry, $composer, Painter.$stable << 3, 16);
                        $composer.endReplaceGroup();
                        $composer2 = $composer;
                    } else {
                        if (item.getType() instanceof KOptionItemType.OPTION_ITEM_TYPE_SWITCH) {
                            $composer2 = $composer;
                            $composer2.startReplaceGroup(1985873290);
                            ComposerKt.sourceInformation($composer2, "166@6664L2,191@8042L529");
                            String title2 = item.getTitle();
                            String subtitle2 = null;
                            String subtitleEntryText3 = null;
                            Painter subtitleEntryIcon2 = null;
                            ComposerKt.sourceInformationMarkerStart($composer2, -628666902, "CC(remember):TribeeRepostContent.kt#9igjgp");
                            Object it$iv = $composer2.rememberedValue();
                            if (it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv = (Function1) new Function1<Boolean, Unit>() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$TribeeRepostContent$7$2$1$1$onCheckedChange$1$1
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        invoke(((Boolean) p1).booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean it2) {
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            }
                            Function1 onCheckedChange2 = (Function1) it$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            Function0 onClickTitleIcon = $onClickIntro;
                            Function0 onClickSubtitleEntry = $onClickEdit;
                            if (TribeeRepostContentKt.getConvertedBizType(item) == KOptionItemBizType.SwitchRepostToFollowing) {
                                $composer2.startReplaceGroup(1986399980);
                                ComposerKt.sourceInformation($composer2, "172@6962L29");
                                Painter titleIcon2 = BiliIconfont.INSTANCE.getQuestion_help_circle_line_500($composer2, 6);
                                if ($state.getEnableRepostToFollowing()) {
                                    $composer2.startReplaceGroup(1986563381);
                                    ComposerKt.sourceInformation($composer2, "180@7493L28");
                                    if ($state.getRepostMainText().length() == 0) {
                                        $composer2.startReplaceGroup(1986667386);
                                        ComposerKt.sourceInformation($composer2, "176@7207L56");
                                        subtitleEntryText2 = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_57(TribeeRes.INSTANCE.getString()), $composer2, 0);
                                        $composer2.endReplaceGroup();
                                    } else {
                                        $composer2.startReplaceGroup(1986800314);
                                        ComposerKt.sourceInformation($composer2, "178@7341L56");
                                        subtitleEntryText2 = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_58(TribeeRes.INSTANCE.getString()), $composer2, 0);
                                        $composer2.endReplaceGroup();
                                    }
                                    Painter subtitleEntryIcon3 = BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer2, 6);
                                    subtitle2 = item.getSubTitle();
                                    $composer2.endReplaceGroup();
                                    subtitleEntryText3 = subtitleEntryText2;
                                    subtitleEntryIcon2 = subtitleEntryIcon3;
                                } else {
                                    $composer2.startReplaceGroup(1979550778);
                                    $composer2.endReplaceGroup();
                                }
                                boolean checked2 = $state.getEnableRepostToFollowing();
                                onCheckedChange = $onRepostToFollowingChange;
                                $composer2.endReplaceGroup();
                                titleIcon = titleIcon2;
                                subtitle = subtitle2;
                                subtitleEntryText = subtitleEntryText3;
                                subtitleEntryIcon = subtitleEntryIcon2;
                                checked = checked2;
                            } else if (TribeeRepostContentKt.getConvertedBizType(item) != KOptionItemBizType.SwitchRepostWithSource) {
                                $composer2.startReplaceGroup(1979550778);
                                $composer2.endReplaceGroup();
                                titleIcon = null;
                                subtitle = null;
                                subtitleEntryText = null;
                                subtitleEntryIcon = null;
                                checked = false;
                                onCheckedChange = onCheckedChange2;
                            } else {
                                $composer2.startReplaceGroup(1987326942);
                                $composer2.endReplaceGroup();
                                boolean checked3 = $state.getEnableRepostWithSource();
                                onCheckedChange = $onRepostWithSourceChange;
                                titleIcon = null;
                                subtitle = null;
                                subtitleEntryText = null;
                                subtitleEntryIcon = null;
                                checked = checked3;
                            }
                            TribeeRepostContentKt.m992SwitchSettingItemyKJFJhA(checked, onCheckedChange, null, title2, titleIcon, onClickTitleIcon, subtitle, subtitleEntryText, subtitleEntryIcon, onClickSubtitleEntry, 0.0f, $composer2, (Painter.$stable << 12) | (Painter.$stable << 24), 0, 1028);
                        } else {
                            $composer2 = $composer;
                            $composer2.startReplaceGroup(1979550778);
                        }
                        $composer2.endReplaceGroup();
                    }
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* renamed from: SelectSettingItem-WH-ejsw  reason: not valid java name */
    public static final void m991SelectSettingItemWHejsw(String title, Painter entryLeftIcon, String entryLeftText, String entryRightText, float f, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        String entryLeftText2;
        String entryRightText2;
        float f2;
        final Function0 onClickedEntry;
        int $dirty;
        Composer $composer2;
        String title2;
        Painter entryLeftIcon2;
        String entryRightText3;
        Function0 onClickedEntry2;
        String entryRightText4;
        String title3;
        Painter entryLeftIcon3;
        Function0 factory$iv$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(1972269743);
        ComposerKt.sourceInformation($composer3, "C(SelectSettingItem)N(title,entryLeftIcon,entryLeftText,entryRightText,height:c#ui.unit.Dp,onClickedEntry)249@10128L2,252@10186L20,251@10140L2415:TribeeRepostContent.kt#qxdvwz");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(title) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= ($changed & 64) == 0 ? $composer3.changed(entryLeftIcon) : $composer3.changedInstance(entryLeftIcon) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            entryLeftText2 = entryLeftText;
        } else if (($changed & 384) == 0) {
            entryLeftText2 = entryLeftText;
            $dirty2 |= $composer3.changed(entryLeftText2) ? 256 : 128;
        } else {
            entryLeftText2 = entryLeftText;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            entryRightText2 = entryRightText;
        } else if (($changed & 3072) == 0) {
            entryRightText2 = entryRightText;
            $dirty2 |= $composer3.changed(entryRightText2) ? 2048 : 1024;
        } else {
            entryRightText2 = entryRightText;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            f2 = f;
        } else if (($changed & 24576) == 0) {
            f2 = f;
            $dirty2 |= $composer3.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
            onClickedEntry = function0;
        } else if (($changed & 196608) == 0) {
            onClickedEntry = function0;
            $dirty2 |= $composer3.changedInstance(onClickedEntry) ? 131072 : 65536;
        } else {
            onClickedEntry = function0;
        }
        if (!$composer3.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            title2 = title;
            entryLeftIcon2 = entryLeftIcon;
            entryRightText3 = entryRightText2;
            onClickedEntry2 = onClickedEntry;
            entryRightText4 = entryLeftText2;
        } else {
            if (i2 != 0) {
                title3 = "";
            } else {
                title3 = title;
            }
            if (i3 == 0) {
                entryLeftIcon3 = entryLeftIcon;
            } else {
                entryLeftIcon3 = null;
            }
            if (i4 != 0) {
                entryLeftText2 = null;
            }
            if (i5 != 0) {
                entryRightText2 = null;
            }
            if (i6 != 0) {
                f2 = Dp.constructor-impl(44);
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1270652241, "CC(remember):TribeeRepostContent.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onClickedEntry3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onClickedEntry = onClickedEntry3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1972269743, $dirty2, -1, "kntr.app.tribee.repost.page.SelectSettingItem (TribeeRepostContent.kt:250)");
            }
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, 1270654115, "CC(remember):TribeeRepostContent.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty2) == 131072;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit SelectSettingItem_WH_ejsw$lambda$1$0;
                        SelectSettingItem_WH_ejsw$lambda$1$0 = TribeeRepostContentKt.SelectSettingItem_WH_ejsw$lambda$1$0(onClickedEntry);
                        return SelectSettingItem_WH_ejsw$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $dirty = $dirty2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            onClickedEntry2 = onClickedEntry;
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 720400693, "C256@10302L1995,254@10224L2073,312@12518L6,306@12307L242:TribeeRepostContent.kt#qxdvwz");
            final float f3 = f2;
            final String str = title3;
            final String str2 = entryLeftText2;
            final String str3 = entryRightText2;
            final Painter painter = entryLeftIcon3;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(323898211, true, new Function3() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SelectSettingItem_WH_ejsw$lambda$2$0;
                    SelectSettingItem_WH_ejsw$lambda$2$0 = TribeeRepostContentKt.SelectSettingItem_WH_ejsw$lambda$2$0(f3, str, str2, str3, painter, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SelectSettingItem_WH_ejsw$lambda$2$0;
                }
            }, $composer3, 54), $composer3, 3078, 6);
            String title4 = title3;
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            title2 = title4;
            entryLeftIcon2 = entryLeftIcon3;
            entryRightText3 = entryRightText2;
            entryRightText4 = entryLeftText2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str4 = title2;
            final Painter painter2 = entryLeftIcon2;
            final String str5 = entryRightText4;
            final String str6 = entryRightText3;
            final float f4 = f2;
            final Function0 function02 = onClickedEntry2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectSettingItem_WH_ejsw$lambda$3;
                    SelectSettingItem_WH_ejsw$lambda$3 = TribeeRepostContentKt.SelectSettingItem_WH_ejsw$lambda$3(str4, painter2, str5, str6, f4, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectSettingItem_WH_ejsw$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectSettingItem_WH_ejsw$lambda$1$0(Function0 $onClickedEntry) {
        $onClickedEntry.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0414  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SelectSettingItem_WH_ejsw$lambda$2$0(float f, String $title, String $entryLeftText, String $entryRightText, Painter $entryLeftIcon, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean z;
        boolean showEntryText;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C258@10394L1893:TribeeRepostContent.kt#qxdvwz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(323898211, $dirty, -1, "kntr.app.tribee.repost.page.SelectSettingItem.<anonymous>.<anonymous> (TribeeRepostContent.kt:257)");
            }
            float f2 = Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl($this$BoxWithConstraints.getMaxWidth-D9Ej5fM() - Dp.constructor-impl(12)) - Dp.constructor-impl(20)) - Dp.constructor-impl(16)) - Dp.constructor-impl(12)) / 2);
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), f);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -486742627, "C269@10814L6,266@10698L409,277@11124L1149:TribeeRepostContent.kt#qxdvwz");
            TextKt.Text-Nvy7gAk($title, PaddingKt.padding-qDBjuR0$default(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, f2, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer, 24576, 24960, 241640);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((438 >> 6) & 112) | 6;
            RowScope $this$SelectSettingItem_WH_ejsw_u24lambda_u242_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 878532333, "C296@12031L28,297@12102L6,294@11927L328:TribeeRepostContent.kt#qxdvwz");
            String str = $entryLeftText;
            if (str == null || str.length() == 0) {
                String str2 = $entryRightText;
                if (str2 == null || str2.length() == 0) {
                    z = false;
                    showEntryText = z;
                    if (showEntryText) {
                        $composer.startReplaceGroup(867169127);
                    } else {
                        $composer.startReplaceGroup(878689006);
                        ComposerKt.sourceInformation($composer, "287@11603L281");
                        SelectSettingItemEntryIconLeftArea(RowScope.-CC.weight$default($this$SelectSettingItem_WH_ejsw_u24lambda_u242_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $entryLeftIcon, $entryLeftText, $entryRightText, $composer, Painter.$stable << 3, 0);
                    }
                    $composer.endReplaceGroup();
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_800($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
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
            }
            z = true;
            showEntryText = z;
            if (showEntryText) {
            }
            $composer.endReplaceGroup();
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_800($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SelectSettingItemEntryIconLeftArea(Modifier modifier, Painter icon, String leftText, String rightText, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String leftText2;
        String rightText2;
        Painter icon2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        boolean showVerticalDivider;
        String str;
        boolean showVerticalDivider2;
        String leftText3;
        String str2;
        Painter icon3 = icon;
        Composer $composer2 = $composer.startRestartGroup(-1223054308);
        ComposerKt.sourceInformation($composer2, "C(SelectSettingItemEntryIconLeftArea)N(modifier,icon,leftText,rightText)324@12750L1709:TribeeRepostContent.kt#qxdvwz");
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
        } else if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(icon3) : $composer2.changedInstance(icon3) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            leftText2 = leftText;
        } else if (($changed & 384) == 0) {
            leftText2 = leftText;
            $dirty |= $composer2.changed(leftText2) ? 256 : 128;
        } else {
            leftText2 = leftText;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            rightText2 = rightText;
        } else if (($changed & 3072) == 0) {
            rightText2 = rightText;
            $dirty |= $composer2.changed(rightText2) ? 2048 : 1024;
        } else {
            rightText2 = rightText;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            icon2 = icon3;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                icon3 = null;
            }
            if (i4 != 0) {
                leftText2 = null;
            }
            if (i5 != 0) {
                rightText2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1223054308, $dirty2, -1, "kntr.app.tribee.repost.page.SelectSettingItemEntryIconLeftArea (TribeeRepostContent.kt:323)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = ($dirty2 & 14) | 432;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i7 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$SelectSettingItemEntryIconLeftArea_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1450090751, "C:TribeeRepostContent.kt#qxdvwz");
            String str3 = leftText2;
            if (!(str3 == null || str3.length() == 0)) {
                String str4 = rightText2;
                if (!(str4 == null || str4.length() == 0)) {
                    showVerticalDivider = true;
                    if (icon3 != null) {
                        $composer2.startReplaceGroup(1450147789);
                        $composer2.endReplaceGroup();
                        icon2 = icon3;
                    } else {
                        $composer2.startReplaceGroup(1450147790);
                        ComposerKt.sourceInformation($composer2, "*334@13141L6,331@13027L280");
                        icon2 = icon3;
                        IconKt.Icon-ww6aTOc(icon3, (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(2), 0.0f, 11, (Object) null), Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
                        $composer2.endReplaceGroup();
                    }
                    str = leftText2;
                    if (str != null || str.length() == 0) {
                        $composer2.startReplaceGroup(1450514985);
                        ComposerKt.sourceInformation($composer2, "345@13478L6,342@13371L321");
                        TextKt.Text-Nvy7gAk(leftText2, $this$SelectSettingItemEntryIconLeftArea_u24lambda_u240.weight(Modifier.Companion, 2.0f, false), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, (($dirty2 >> 6) & 14) | 24576, 24960, 241640);
                    } else {
                        $composer2.startReplaceGroup(1437240010);
                    }
                    $composer2.endReplaceGroup();
                    if (showVerticalDivider) {
                        showVerticalDivider2 = showVerticalDivider;
                        leftText3 = leftText2;
                        $composer2.startReplaceGroup(1437240010);
                    } else {
                        $composer2.startReplaceGroup(1450875918);
                        ComposerKt.sourceInformation($composer2, "359@13978L6,354@13750L260");
                        showVerticalDivider2 = showVerticalDivider;
                        leftText3 = leftText2;
                        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), 0.0f, 10, (Object) null), Dp.constructor-impl((float) 0.5d), Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_bold-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
                    }
                    $composer2.endReplaceGroup();
                    str2 = rightText2;
                    if (str2 != null || str2.length() == 0) {
                        $composer2.startReplaceGroup(1451214810);
                        ComposerKt.sourceInformation($composer2, "366@14183L6,363@14075L368");
                        TextKt.Text-Nvy7gAk(rightText2, $this$SelectSettingItemEntryIconLeftArea_u24lambda_u240.weight(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(50), 1, (Object) null), 1.0f, false), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, (($dirty2 >> 9) & 14) | 24576, 24960, 241640);
                    } else {
                        $composer2.startReplaceGroup(1437240010);
                    }
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
                    leftText2 = leftText3;
                }
            }
            showVerticalDivider = false;
            if (icon3 != null) {
            }
            str = leftText2;
            if (str != null || str.length() == 0) {
            }
            $composer2.endReplaceGroup();
            if (showVerticalDivider) {
            }
            $composer2.endReplaceGroup();
            str2 = rightText2;
            if (str2 != null || str2.length() == 0) {
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            leftText2 = leftText3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Painter painter = icon2;
            final String str5 = leftText2;
            final String str6 = rightText2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectSettingItemEntryIconLeftArea$lambda$1;
                    SelectSettingItemEntryIconLeftArea$lambda$1 = TribeeRepostContentKt.SelectSettingItemEntryIconLeftArea$lambda$1(modifier5, painter, str5, str6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectSettingItemEntryIconLeftArea$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0afe  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0b0a  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0b10  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0bd3  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0bdf  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0ded  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0e0c  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0e3a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* renamed from: SwitchSettingItem-yKJFJhA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m992SwitchSettingItemyKJFJhA(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, String title, Painter titleIcon, Function0<Unit> function0, String subtitle, String subtitleEntryText, Painter subtitleEntryIcon, Function0<Unit> function02, float f, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        Composer $composer2;
        Modifier modifier2;
        String title2;
        Painter titleIcon2;
        Function0 onClickTitleIcon;
        String subtitle2;
        String subtitleEntryText2;
        Painter subtitleEntryIcon2;
        Function0 onClickSubtitleEntry;
        float f2;
        ScopeUpdateScope endRestartGroup;
        Painter titleIcon3;
        String title3;
        Function0 onClickTitleIcon2;
        String subtitle3;
        String subtitleEntryText3;
        Painter subtitleEntryIcon3;
        Function0 onClickSubtitleEntry2;
        Painter subtitleEntryIcon4;
        float f3;
        int $dirty1;
        Function0 onClickSubtitleEntry3;
        String title4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        final Function0 onClickTitleIcon3;
        Composer $composer3;
        Function0 factory$iv$iv$iv5;
        final Function0 onClickSubtitleEntry4;
        Object value$iv;
        Function0 factory$iv$iv$iv6;
        int i3;
        Composer $composer4 = $composer.startRestartGroup(-1343849190);
        ComposerKt.sourceInformation($composer4, "C(SwitchSettingItem)N(checked,onCheckedChange,modifier,title,titleIcon,onClickTitleIcon,subtitle,subtitleEntryText,subtitleEntryIcon,onClickSubtitleEntry,height:c#ui.unit.Dp)393@14964L4310:TribeeRepostContent.kt#qxdvwz");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(checked) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(title) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= (32768 & $changed) == 0 ? $composer4.changed(titleIcon) : $composer4.changedInstance(titleIcon) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer4.changed(subtitle) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer4.changed(subtitleEntryText) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        int i10 = 100663296;
        if (i9 == 0) {
            if (($changed & 100663296) == 0) {
                i10 = ($changed & 134217728) == 0 ? $composer4.changed(subtitleEntryIcon) : $composer4.changedInstance(subtitleEntryIcon) ? 67108864 : 33554432;
            }
            i2 = i & 512;
            if (i2 == 0) {
                $dirty |= 805306368;
            } else if (($changed & 805306368) == 0) {
                $dirty |= $composer4.changedInstance(function02) ? 536870912 : 268435456;
            }
            if (($changed1 & 6) == 0) {
                if ((i & 1024) == 0 && $composer4.changed(f)) {
                    i3 = 4;
                    $dirty12 |= i3;
                }
                i3 = 2;
                $dirty12 |= i3;
            }
            if ($composer4.shouldExecute(($dirty & 306783251) == 306783250 || ($dirty12 & 3) != 2, $dirty & 1)) {
                $composer2 = $composer4;
                $composer2.skipToGroupEnd();
                modifier2 = modifier;
                title2 = title;
                titleIcon2 = titleIcon;
                onClickTitleIcon = function0;
                subtitle2 = subtitle;
                subtitleEntryText2 = subtitleEntryText;
                subtitleEntryIcon2 = subtitleEntryIcon;
                onClickSubtitleEntry = function02;
                f2 = f;
            } else {
                $composer4.startDefaults();
                ComposerKt.sourceInformation($composer4, "386@14735L2,390@14887L2");
                if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                    Modifier modifier3 = (i & 4) != 0 ? (Modifier) Modifier.Companion : modifier;
                    String title5 = i4 != 0 ? "" : title;
                    titleIcon3 = i5 != 0 ? null : titleIcon;
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart($composer4, 1346091260, "CC(remember):TribeeRepostContent.kt#9igjgp");
                        Object it$iv = $composer4.rememberedValue();
                        title3 = title5;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv2 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda6
                                public final Object invoke() {
                                    Unit unit;
                                    unit = Unit.INSTANCE;
                                    return unit;
                                }
                            };
                            modifier2 = modifier3;
                            $composer4.updateRememberedValue(value$iv2);
                            it$iv = value$iv2;
                        } else {
                            modifier2 = modifier3;
                        }
                        onClickTitleIcon2 = it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                    } else {
                        title3 = title5;
                        modifier2 = modifier3;
                        onClickTitleIcon2 = function0;
                    }
                    subtitle3 = i7 != 0 ? null : subtitle;
                    subtitleEntryText3 = i8 != 0 ? null : subtitleEntryText;
                    Painter subtitleEntryIcon5 = i9 != 0 ? null : subtitleEntryIcon;
                    if (i2 != 0) {
                        ComposerKt.sourceInformationMarkerStart($composer4, 1346096124, "CC(remember):TribeeRepostContent.kt#9igjgp");
                        subtitleEntryIcon3 = subtitleEntryIcon5;
                        Object it$iv2 = $composer4.rememberedValue();
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            Object value$iv3 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda8
                                public final Object invoke() {
                                    Unit unit;
                                    unit = Unit.INSTANCE;
                                    return unit;
                                }
                            };
                            $composer4.updateRememberedValue(value$iv3);
                            it$iv2 = value$iv3;
                        }
                        onClickSubtitleEntry2 = (Function0) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                    } else {
                        subtitleEntryIcon3 = subtitleEntryIcon5;
                        onClickSubtitleEntry2 = function02;
                    }
                    if ((i & 1024) != 0) {
                        String str = subtitle3;
                        f3 = str == null || str.length() == 0 ? Dp.constructor-impl(44) : Dp.constructor-impl(63);
                        $dirty1 = $dirty12 & (-15);
                        subtitleEntryIcon4 = subtitleEntryIcon3;
                        onClickSubtitleEntry3 = onClickSubtitleEntry2;
                        title4 = title3;
                    } else {
                        subtitleEntryIcon4 = subtitleEntryIcon3;
                        f3 = f;
                        $dirty1 = $dirty12;
                        onClickSubtitleEntry3 = onClickSubtitleEntry2;
                        title4 = title3;
                    }
                } else {
                    $composer4.skipToGroupEnd();
                    if ((i & 1024) != 0) {
                        $dirty12 &= -15;
                    }
                    modifier2 = modifier;
                    title4 = title;
                    titleIcon3 = titleIcon;
                    onClickTitleIcon2 = function0;
                    subtitle3 = subtitle;
                    subtitleEntryText3 = subtitleEntryText;
                    subtitleEntryIcon4 = subtitleEntryIcon;
                    f3 = f;
                    $dirty1 = $dirty12;
                    onClickSubtitleEntry3 = function02;
                }
                $composer4.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1343849190, $dirty, $dirty1, "kntr.app.tribee.repost.page.SwitchSettingItem (TribeeRepostContent.kt:392)");
                }
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                $composer2 = $composer4;
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                subtitleEntryIcon2 = subtitleEntryIcon4;
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                Function0 onClickSubtitleEntry5 = onClickSubtitleEntry3;
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                subtitleEntryText2 = subtitleEntryText3;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv7;
                    $composer4.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv7;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                subtitle2 = subtitle3;
                Function0 onClickTitleIcon4 = onClickTitleIcon2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i12 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -219724716, "C394@14981L4036,491@19237L6,485@19026L242:TribeeRepostContent.kt#qxdvwz");
                Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), f3);
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                f2 = f3;
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv2 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer4.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i13 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i14 = ((432 >> 6) & 112) | 6;
                RowScope $this$SwitchSettingItem_yKJFJhA_u24lambda_u242_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -2068913051, "C402@15253L3025,468@18291L39,477@18677L6,478@18753L6,479@18823L6,480@18900L6,469@18343L664:TribeeRepostContent.kt#qxdvwz");
                Modifier modifier$iv3 = RowScope.-CC.weight$default($this$SwitchSettingItem_yKJFJhA_u24lambda_u242_u240, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null);
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv9;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv9;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i15 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i16 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 1598760127, "C406@15422L992:TribeeRepostContent.kt#qxdvwz");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier$iv4 = Modifier.Companion;
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                int $changed$iv$iv$iv4 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, $changed$iv$iv$iv4);
                int $changed$iv$iv4 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv10;
                    $composer4.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv10;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i17 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i18 = ((384 >> 6) & 112) | 6;
                RowScope $this$SwitchSettingItem_yKJFJhA_u24lambda_u242_u240_u240_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, 1798565496, "C412@15663L6,409@15535L329:TribeeRepostContent.kt#qxdvwz");
                String str2 = title4;
                TextKt.Text-Nvy7gAk(str2, $this$SwitchSettingItem_yKJFJhA_u24lambda_u242_u240_u240_u240.weight(Modifier.Companion, 1.0f, false), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, (($dirty >> 9) & 14) | 24576, 24960, 241640);
                if (titleIcon3 == null) {
                    $composer4.startReplaceGroup(1798912415);
                    $composer4.endReplaceGroup();
                    title2 = title4;
                    titleIcon2 = titleIcon3;
                    onClickTitleIcon3 = onClickTitleIcon4;
                } else {
                    $composer4.startReplaceGroup(1798912416);
                    ComposerKt.sourceInformation($composer4, "*421@16084L6,426@16325L22,418@15934L440");
                    Painter icon = titleIcon3;
                    long j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU();
                    title2 = title4;
                    Modifier modifier4 = PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), Dp.constructor-impl(1));
                    ComposerKt.sourceInformationMarkerStart($composer4, 170412394, "CC(remember):TribeeRepostContent.kt#9igjgp");
                    boolean invalid$iv = (458752 & $dirty) == 131072;
                    Object it$iv3 = $composer4.rememberedValue();
                    if (!invalid$iv && it$iv3 != Composer.Companion.getEmpty()) {
                        titleIcon2 = titleIcon3;
                        onClickTitleIcon3 = onClickTitleIcon4;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        IconKt.Icon-ww6aTOc(icon, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), j, $composer4, Painter.$stable | 48, 0);
                        Unit unit = Unit.INSTANCE;
                        $composer4.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    titleIcon2 = titleIcon3;
                    onClickTitleIcon3 = onClickTitleIcon4;
                    Object value$iv4 = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit SwitchSettingItem_yKJFJhA$lambda$2$0$0$0$0$0$0;
                            SwitchSettingItem_yKJFJhA$lambda$2$0$0$0$0$0$0 = TribeeRepostContentKt.SwitchSettingItem_yKJFJhA$lambda$2$0$0$0$0$0$0(onClickTitleIcon3);
                            return SwitchSettingItem_yKJFJhA$lambda$2$0$0$0$0$0$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv3 = value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    IconKt.Icon-ww6aTOc(icon, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), j, $composer4, Painter.$stable | 48, 0);
                    Unit unit3 = Unit.INSTANCE;
                    $composer4.endReplaceGroup();
                    Unit unit22 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                String str3 = subtitle2;
                if (str3 == null || str3.length() == 0) {
                    onClickTitleIcon = onClickTitleIcon3;
                    onClickSubtitleEntry = onClickSubtitleEntry5;
                    $composer3 = $composer4;
                    $composer3.startReplaceGroup(1583372408);
                    $composer3.endReplaceGroup();
                } else {
                    $composer4.startReplaceGroup(1599759566);
                    ComposerKt.sourceInformation($composer4, "431@16484L1762");
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier modifier$iv5 = Modifier.Companion;
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv5 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    onClickTitleIcon = onClickTitleIcon3;
                    CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                    Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv5 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv11;
                        $composer4.createNode(factory$iv$iv$iv5);
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv11;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i19 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i20 = ((384 >> 6) & 112) | 6;
                    RowScope $this$SwitchSettingItem_yKJFJhA_u24lambda_u242_u240_u240_u241 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1279381685, "C437@16752L6,434@16609L360:TribeeRepostContent.kt#qxdvwz");
                    TextKt.Text-Nvy7gAk(subtitle2, $this$SwitchSettingItem_yKJFJhA_u24lambda_u242_u240_u240_u241.weight(Modifier.Companion, 1.0f, false), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, (($dirty >> 18) & 14) | 24576, 24960, 241640);
                    String str4 = subtitleEntryText2;
                    if (str4 == null || str4.length() == 0) {
                        onClickSubtitleEntry = onClickSubtitleEntry5;
                        $composer4.startReplaceGroup(-1295908871);
                    } else {
                        $composer4.startReplaceGroup(-1278973261);
                        ComposerKt.sourceInformation($composer4, "443@17064L39,446@17279L26,444@17132L1066");
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer4, 6);
                        Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                        Modifier modifier5 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1067128131, "CC(remember):TribeeRepostContent.kt#9igjgp");
                        boolean invalid$iv2 = (1879048192 & $dirty) == 536870912;
                        Object it$iv4 = $composer4.rememberedValue();
                        if (!invalid$iv2 && it$iv4 != Composer.Companion.getEmpty()) {
                            value$iv = it$iv4;
                            onClickSubtitleEntry4 = onClickSubtitleEntry5;
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            Modifier modifier$iv6 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv6 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
                            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                            onClickSubtitleEntry = onClickSubtitleEntry4;
                            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv6 = factory$iv$iv$iv12;
                                $composer4.useNode();
                            } else {
                                factory$iv$iv$iv6 = factory$iv$iv$iv12;
                                $composer4.createNode(factory$iv$iv$iv6);
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer4);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                            int i21 = ($changed$iv$iv$iv7 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i22 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -272198562, "C451@17547L6,448@17371L347:TribeeRepostContent.kt#qxdvwz");
                            TextKt.Text-Nvy7gAk(subtitleEntryText2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText_link-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, (($dirty >> 21) & 14) | 24576, 24960, 241642);
                            if (subtitleEntryIcon2 != null) {
                                $composer4.startReplaceGroup(-271815125);
                                $composer4.endReplaceGroup();
                            } else {
                                $composer4.startReplaceGroup(-271815124);
                                ComposerKt.sourceInformation($composer4, "*459@18006L6,456@17820L314");
                                IconKt.Icon-ww6aTOc(subtitleEntryIcon2, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText_link-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
                                Unit unit4 = Unit.INSTANCE;
                                $composer4.endReplaceGroup();
                                Unit unit5 = Unit.INSTANCE;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                        }
                        onClickSubtitleEntry4 = onClickSubtitleEntry5;
                        Object obj = new Function0() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                Unit SwitchSettingItem_yKJFJhA$lambda$2$0$0$1$0$0;
                                SwitchSettingItem_yKJFJhA$lambda$2$0$0$1$0$0 = TribeeRepostContentKt.SwitchSettingItem_yKJFJhA$lambda$2$0$0$1$0$0(onClickSubtitleEntry4);
                                return SwitchSettingItem_yKJFJhA$lambda$2$0$0$1$0$0;
                            }
                        };
                        $composer4.updateRememberedValue(obj);
                        value$iv = obj;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier$iv62 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv42 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv62 = RowKt.rowMeasurePolicy(horizontalArrangement$iv42, verticalAlignment$iv4, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv62 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv62 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv62 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv62 = ComposedModifierKt.materializeModifier($composer4, modifier$iv62);
                        Function0 factory$iv$iv$iv122 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv72 = (($changed$iv$iv62 << 6) & 896) | 6;
                        onClickSubtitleEntry = onClickSubtitleEntry4;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv62 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, measurePolicy$iv62, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, localMap$iv$iv62, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv62, Integer.valueOf(compositeKeyHash$iv$iv62), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv62, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, materialized$iv$iv62, ComposeUiNode.Companion.getSetModifier());
                        int i212 = ($changed$iv$iv$iv72 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope2 = RowScopeInstance.INSTANCE;
                        int i222 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -272198562, "C451@17547L6,448@17371L347:TribeeRepostContent.kt#qxdvwz");
                        TextKt.Text-Nvy7gAk(subtitleEntryText2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText_link-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, (($dirty >> 21) & 14) | 24576, 24960, 241642);
                        if (subtitleEntryIcon2 != null) {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endReplaceGroup();
                    $composer3 = $composer4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer4, 6);
                SimpleSwitchKt.SimpleSwitch(checked, function1, SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null), Dp.constructor-impl(32), Dp.constructor-impl(20)), false, null, new SimpleSwitchColors(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText4-0d7_KjU(), 0L, 0L, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_white-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_white-0d7_KjU(), 0L, 0L, null, null, 972, null), $composer4, ($dirty & 14) | 384 | ($dirty & 112) | (SimpleSwitchColors.$stable << 15), 24);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer4, 0);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier6 = modifier2;
                final String str5 = title2;
                final Painter painter = titleIcon2;
                final Function0 function03 = onClickTitleIcon;
                final String str6 = subtitle2;
                final String str7 = subtitleEntryText2;
                final Painter painter2 = subtitleEntryIcon2;
                final Function0 function04 = onClickSubtitleEntry;
                final float f4 = f2;
                endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit SwitchSettingItem_yKJFJhA$lambda$3;
                        SwitchSettingItem_yKJFJhA$lambda$3 = TribeeRepostContentKt.SwitchSettingItem_yKJFJhA$lambda$3(checked, function1, modifier6, str5, painter, function03, str6, str7, painter2, function04, f4, $changed, $changed1, i, (Composer) obj2, ((Integer) obj3).intValue());
                        return SwitchSettingItem_yKJFJhA$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        $dirty |= i10;
        i2 = i & 512;
        if (i2 == 0) {
        }
        if (($changed1 & 6) == 0) {
        }
        if ($composer4.shouldExecute(($dirty & 306783251) == 306783250 || ($dirty12 & 3) != 2, $dirty & 1)) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchSettingItem_yKJFJhA$lambda$2$0$0$0$0$0$0(Function0 $onClickTitleIcon) {
        $onClickTitleIcon.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchSettingItem_yKJFJhA$lambda$2$0$0$1$0$0(Function0 $onClickSubtitleEntry) {
        $onClickSubtitleEntry.invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: RepostButton-FJfuzF0  reason: not valid java name */
    private static final void m990RepostButtonFJfuzF0(final String text, final Function0<Unit> function0, Modifier modifier, boolean enabled, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        float f2;
        Modifier modifier3;
        float f3;
        boolean enabled2;
        Modifier modifier4;
        boolean enabled3;
        float f4;
        Composer $composer2 = $composer.startRestartGroup(-1534008535);
        ComposerKt.sourceInformation($composer2, "C(RepostButton)N(text,onClick,modifier,enabled,height:c#ui.unit.Dp)513@19723L6,514@19783L6,515@19853L6,516@19940L6,512@19666L306,519@20023L200,504@19455L768:TribeeRepostContent.kt#qxdvwz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            f2 = f;
        } else if (($changed & 24576) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
            enabled2 = z;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                enabled3 = z;
            } else {
                enabled3 = true;
            }
            if (i4 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(44);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1534008535, $dirty, -1, "kntr.app.tribee.repost.page.RepostButton (TribeeRepostContent.kt:503)");
            }
            Modifier modifier5 = modifier4;
            ButtonKt.Button(function0, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), f4), enabled3, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(22)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), $composer2, ButtonDefaults.$stable << 12, 0), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-685334215, true, new Function3() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RepostButton_FJfuzF0$lambda$0;
                    RepostButton_FJfuzF0$lambda$0 = TribeeRepostContentKt.RepostButton_FJfuzF0$lambda$0(text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RepostButton_FJfuzF0$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 805306368 | (($dirty >> 3) & 896), (int) KScreenAdjustUtilsKt.CONTAINER_FUNCTION_MAX_WIDTH);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            enabled2 = enabled3;
            f3 = f4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z2 = enabled2;
            final float f5 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.repost.page.TribeeRepostContentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepostButton_FJfuzF0$lambda$1;
                    RepostButton_FJfuzF0$lambda$1 = TribeeRepostContentKt.RepostButton_FJfuzF0$lambda$1(text, function0, modifier6, z2, f5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepostButton_FJfuzF0$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepostButton_FJfuzF0$lambda$0(String $text, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C520@20033L184:TribeeRepostContent.kt#qxdvwz");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-685334215, $changed, -1, "kntr.app.tribee.repost.page.RepostButton.<anonymous> (TribeeRepostContent.kt:520)");
            }
            TextKt.Text-Nvy7gAk($text, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getW400(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 24960, 241582);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}