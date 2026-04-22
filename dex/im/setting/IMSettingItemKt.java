package im.setting;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.im.v1.KSelectItem;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import com.bapis.bilibili.app.im.v1.KSettingSelect;
import com.bapis.bilibili.app.im.v1.KSettingSwitch;
import com.bapis.bilibili.app.im.v1.KSettingText;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.framework.exposure.core.collecter.ComposeExposureLayoutInfoCollectorKt;
import com.bilibili.framework.exposure.core.transformer.ExposureAreaVisibilityTransformerKt;
import com.bilibili.framework.exposure.core.transformer.ExposureVisibleDurationTransformerKt;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.setting.model.SettingGroup;
import im.setting.model.SettingGroupTitleEnum;
import im.setting.model.SettingItem;
import io.grpc.internal.GrpcUtil;
import io.ktor.client.utils.CIOKt;
import java.util.Iterator;
import kntr.common.trio.priority.ComposePriorityHorizonKt;
import kntr.common.trio.priority.PriorityHorizonPolicy;
import kntr.common.trio.priority.PriorityHorizontalScope;
import kntr.common.trio.switch.SimpleSwitchColors;
import kntr.common.trio.switch.SimpleSwitchKt;
import kntr.common.trio.switch.SimpleSwitchSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMSettingItem.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f\u001a7\u0010\r\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\u0015\u001a7\u0010\u0016\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001a\u001a/\u0010\u001b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001f2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010 \u001a\u0017\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010#H\u0003¢\u0006\u0002\u0010$\u001a3\u0010%\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020&2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020&H\u0001¢\u0006\u0002\u0010)\u001a3\u0010%\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020&H\u0001¢\u0006\u0004\b,\u0010-¨\u0006."}, d2 = {"imSettingGroup", "", "Landroidx/compose/foundation/lazy/LazyListScope;", "group", "Lim/setting/model/SettingGroup;", "eventHandler", "Lim/setting/IMSettingEventHandler;", "IMSettingItem", "item", "Lim/setting/model/SettingItem;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lim/setting/model/SettingItem;Lim/setting/IMSettingEventHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMSettingSwitchItem", "Lim/setting/model/SettingItem$Setting;", "setting", "Lcom/bapis/bilibili/app/im/v1/KSettingSwitch;", "isLoading", "", "onAction", "Lim/setting/IMSettingActionHandler;", "(Lim/setting/model/SettingItem$Setting;Lcom/bapis/bilibili/app/im/v1/KSettingSwitch;ZLim/setting/IMSettingActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMSettingSelectItem", "Lcom/bapis/bilibili/app/im/v1/KSettingSelect;", "(Lim/setting/model/SettingItem$Setting;Lcom/bapis/bilibili/app/im/v1/KSettingSelect;ZLim/setting/IMSettingActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SettingDivider", "(Landroidx/compose/runtime/Composer;I)V", "IMSettingRedirectItem", "Lcom/bapis/bilibili/app/im/v1/KSettingRedirect;", "(Lim/setting/model/SettingItem$Setting;Lcom/bapis/bilibili/app/im/v1/KSettingRedirect;Lim/setting/IMSettingActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMSettingTextItem", "Lcom/bapis/bilibili/app/im/v1/KSettingText;", "(Lcom/bapis/bilibili/app/im/v1/KSettingText;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMSettingGroupTitle", "title", "Lim/setting/model/SettingGroupTitleEnum;", "(Lim/setting/model/SettingGroupTitleEnum;Landroidx/compose/runtime/Composer;I)V", "IMSettingTitles", "", "isDisabled", "subTitle", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/Color;", "IMSettingTitles-sW7UJKQ", "(Ljava/lang/String;JLandroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSettingItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingGroupTitle$lambda$0(SettingGroupTitleEnum settingGroupTitleEnum, int i2, Composer composer, int i3) {
        IMSettingGroupTitle(settingGroupTitleEnum, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingItem$lambda$1(SettingItem settingItem, IMSettingEventHandler iMSettingEventHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMSettingItem(settingItem, iMSettingEventHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingItem$lambda$2(SettingItem settingItem, IMSettingEventHandler iMSettingEventHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMSettingItem(settingItem, iMSettingEventHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingRedirectItem$lambda$2(SettingItem.Setting setting, KSettingRedirect kSettingRedirect, IMSettingActionHandler iMSettingActionHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMSettingRedirectItem(setting, kSettingRedirect, iMSettingActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingSelectItem$lambda$1(SettingItem.Setting setting, KSettingSelect kSettingSelect, boolean z, IMSettingActionHandler iMSettingActionHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMSettingSelectItem(setting, kSettingSelect, z, iMSettingActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingSwitchItem$lambda$1(SettingItem.Setting setting, KSettingSwitch kSettingSwitch, boolean z, IMSettingActionHandler iMSettingActionHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMSettingSwitchItem(setting, kSettingSwitch, z, iMSettingActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingTextItem$lambda$0(KSettingText kSettingText, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMSettingTextItem(kSettingText, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingTitles$lambda$0(String str, Modifier modifier, boolean z, String str2, int i2, int i3, Composer composer, int i4) {
        IMSettingTitles(str, modifier, z, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingTitles_sW7UJKQ$lambda$1(String str, long j, Modifier modifier, String str2, int i2, int i3, Composer composer, int i4) {
        m3390IMSettingTitlessW7UJKQ(str, j, modifier, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingDivider$lambda$0(int i2, Composer composer, int i3) {
        SettingDivider(composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void imSettingGroup(LazyListScope $this$imSettingGroup, final SettingGroup group, final IMSettingEventHandler eventHandler) {
        Intrinsics.checkNotNullParameter($this$imSettingGroup, "<this>");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        LazyListScope.-CC.item$default($this$imSettingGroup, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1797892158, true, new Function3() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit imSettingGroup$lambda$0;
                imSettingGroup$lambda$0 = IMSettingItemKt.imSettingGroup$lambda$0(SettingGroup.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return imSettingGroup$lambda$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.items$default($this$imSettingGroup, group.getItems().size(), new Function1() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Object imSettingGroup$lambda$1;
                imSettingGroup$lambda$1 = IMSettingItemKt.imSettingGroup$lambda$1(SettingGroup.this, ((Integer) obj).intValue());
                return imSettingGroup$lambda$1;
            }
        }, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1841918777, true, new Function4() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda13
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit imSettingGroup$lambda$2;
                imSettingGroup$lambda$2 = IMSettingItemKt.imSettingGroup$lambda$2(SettingGroup.this, eventHandler, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return imSettingGroup$lambda$2;
            }
        }), 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit imSettingGroup$lambda$0(SettingGroup $group, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C47@2084L36:IMSettingItem.kt#w7mava");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1797892158, $changed, -1, "im.setting.imSettingGroup.<anonymous> (IMSettingItem.kt:47)");
            }
            IMSettingGroupTitle($group.getTitleEnum(), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object imSettingGroup$lambda$1(SettingGroup $group, int it) {
        return $group.getItems().get(it).getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit imSettingGroup$lambda$2(SettingGroup $group, IMSettingEventHandler $eventHandler, LazyItemScope $this$items, int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)53@2270L115:IMSettingItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        if (!$composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1841918777, $dirty, -1, "im.setting.imSettingGroup.<anonymous> (IMSettingItem.kt:50)");
            }
            if (index != 0) {
                $composer.startReplaceGroup(-100075949);
                ComposerKt.sourceInformation($composer, "51@2235L16");
                SettingDivider($composer, 0);
            } else {
                $composer.startReplaceGroup(-102281413);
            }
            $composer.endReplaceGroup();
            IMSettingItem($group.getItems().get(index), $eventHandler, Modifier.Companion, $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void IMSettingItem(final SettingItem item, final IMSettingEventHandler eventHandler, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Modifier modifier5;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer3 = $composer.startRestartGroup(436419242);
        ComposerKt.sourceInformation($composer3, "C(IMSettingItem)N(item,eventHandler,modifier)68@2571L335:IMSettingItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(eventHandler) ? 32 : 16;
        }
        int i3 = i2 & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(436419242, $dirty2, -1, "im.setting.IMSettingItem (IMSettingItem.kt:66)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1507898151, "CC(remember):IMSettingItem.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(modifier4, new ExposureEntry(new Function1() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        Flow IMSettingItem$lambda$0$0;
                        IMSettingItem$lambda$0$0 = IMSettingItemKt.IMSettingItem$lambda$0$0((Flow) obj);
                        return IMSettingItem$lambda$0$0;
                    }
                }, new Function0() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit IMSettingItem$lambda$0$1;
                        IMSettingItem$lambda$0$1 = IMSettingItemKt.IMSettingItem$lambda$0$1(IMSettingEventHandler.this, item);
                        return IMSettingItem$lambda$0$1;
                    }
                }));
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Modifier reportModifier = (Modifier) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (item instanceof SettingItem.Setting) {
                $composer3.startReplaceGroup(500210373);
                ComposerKt.sourceInformation($composer3, "");
                KSetting.KRedirect content = ((SettingItem.Setting) item).getSetting().getContent();
                if (content != null) {
                    if (content instanceof KSetting.KRedirect) {
                        $composer3.startReplaceGroup(-1507881058);
                        ComposerKt.sourceInformation($composer3, "82@3108L244");
                        modifier5 = modifier4;
                        $composer2 = $composer3;
                        IMSettingRedirectItem((SettingItem.Setting) item, content.getValue(), eventHandler.getActionHandler(), reportModifier, $composer3, $dirty2 & 14, 0);
                        $composer2.endReplaceGroup();
                    } else {
                        modifier5 = modifier4;
                        $composer2 = $composer3;
                        if (content instanceof KSetting.KSelect) {
                            $composer2.startReplaceGroup(-1507871248);
                            ComposerKt.sourceInformation($composer2, "90@3413L294");
                            IMSettingSelectItem((SettingItem.Setting) item, ((KSetting.KSelect) content).getValue(), ((SettingItem.Setting) item).isLoading(), eventHandler.getActionHandler(), reportModifier, $composer2, $dirty2 & 14, 0);
                            $composer2.endReplaceGroup();
                        } else if (content instanceof KSetting.KSwitch) {
                            $composer2.startReplaceGroup(-1507859888);
                            ComposerKt.sourceInformation($composer2, "99@3768L294");
                            IMSettingSwitchItem((SettingItem.Setting) item, ((KSetting.KSwitch) content).getValue(), ((SettingItem.Setting) item).isLoading(), eventHandler.getActionHandler(), reportModifier, $composer2, $dirty2 & 14, 0);
                            $composer2.endReplaceGroup();
                        } else if (!(content instanceof KSetting.KText)) {
                            $composer2.startReplaceGroup(-1507882644);
                            $composer2.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        } else {
                            $composer2.startReplaceGroup(-1507849457);
                            ComposerKt.sourceInformation($composer2, "107@4101L69");
                            IMSettingTextItem(((KSetting.KText) content).getValue(), reportModifier, $composer2, 0, 0);
                            $composer2.endReplaceGroup();
                        }
                    }
                    $composer2.endReplaceGroup();
                } else {
                    $composer3.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier6 = modifier4;
                        endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda9
                            public final Object invoke(Object obj, Object obj2) {
                                Unit IMSettingItem$lambda$1;
                                IMSettingItem$lambda$1 = IMSettingItemKt.IMSettingItem$lambda$1(SettingItem.this, eventHandler, modifier6, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return IMSettingItem$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
            } else {
                modifier5 = modifier4;
                $composer2 = $composer3;
                if (!(item instanceof SettingItem.UserInfo)) {
                    $composer2.startReplaceGroup(-1507886105);
                    $composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                $composer2.startReplaceGroup(-1507844819);
                ComposerKt.sourceInformation($composer2, "112@4243L163");
                IMSettingUserInfoItemKt.IMSettingUserInfoItem((SettingItem.UserInfo) item, eventHandler.getActionHandler(), reportModifier, $composer2, $dirty2 & 14, 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingItem$lambda$2;
                    IMSettingItem$lambda$2 = IMSettingItemKt.IMSettingItem$lambda$2(SettingItem.this, eventHandler, modifier7, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow IMSettingItem$lambda$0$0(Flow it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ExposureVisibleDurationTransformerKt.exposeImmediatelyWhenNoticeable(ExposureAreaVisibilityTransformerKt.noticeableWhenAreaPixelIsAtLeast(it, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingItem$lambda$0$1(IMSettingEventHandler $eventHandler, SettingItem $item) {
        $eventHandler.getActionHandler().invoke(new IMSettingItemExposureAction($item));
        return Unit.INSTANCE;
    }

    public static final void IMSettingSwitchItem(final SettingItem.Setting item, final KSettingSwitch setting, final boolean isLoading, final IMSettingActionHandler onAction, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer $composer2 = $composer.startRestartGroup(1695494566);
        ComposerKt.sourceInformation($composer2, "C(IMSettingSwitchItem)N(item,setting,isLoading,onAction,modifier)133@4803L6,136@4916L508,129@4668L756:IMSettingItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(setting) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(isLoading) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= ($changed & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) == 0 ? $composer2.changed(onAction) : $composer2.changedInstance(onAction) ? 2048 : 1024;
        }
        int i3 = i2 & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1695494566, $dirty2, -1, "im.setting.IMSettingSwitchItem (IMSettingItem.kt:128)");
            }
            ComposePriorityHorizonKt.PriorityHorizon(PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(16)), (PriorityHorizonPolicy) null, Alignment.Companion.getCenterVertically(), ComposableLambdaKt.rememberComposableLambda(-1818684293, true, new Function3() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMSettingSwitchItem$lambda$0;
                    IMSettingSwitchItem$lambda$0 = IMSettingItemKt.IMSettingSwitchItem$lambda$0(setting, item, isLoading, onAction, (PriorityHorizontalScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMSettingSwitchItem$lambda$0;
                }
            }, $composer2, 54), $composer2, 3456, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingSwitchItem$lambda$1;
                    IMSettingSwitchItem$lambda$1 = IMSettingItemKt.IMSettingSwitchItem$lambda$1(SettingItem.Setting.this, setting, isLoading, onAction, modifier4, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingSwitchItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingSwitchItem$lambda$0(KSettingSwitch $setting, final SettingItem.Setting $item, boolean $isLoading, final IMSettingActionHandler $onAction, PriorityHorizontalScope $this$PriorityHorizon, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$PriorityHorizon, "$this$PriorityHorizon");
        ComposerKt.sourceInformation($composer, "C137@4926L122,139@5058L54,146@5362L45,141@5122L296:IMSettingItem.kt#w7mava");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1818684293, $changed, -1, "im.setting.IMSettingSwitchItem.<anonymous> (IMSettingItem.kt:137)");
        }
        IMSettingTitles($setting.getTitle(), $this$PriorityHorizon.priority(Modifier.Companion, 1), $item.isDisabled(), $setting.getSubtitle(), $composer, 0, 0);
        SpacerKt.Spacer($this$PriorityHorizon.priority(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 0), $composer, 0);
        boolean switchOn = $setting.getSwitchOn();
        Modifier priority = $this$PriorityHorizon.priority(Modifier.Companion, 2);
        SimpleSwitchSize simpleSwitchSize = new SimpleSwitchSize(Dp.constructor-impl(24), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(48), Dp.constructor-impl(30), 2, (DefaultConstructorMarker) null);
        boolean z = !$isLoading;
        ComposerKt.sourceInformationMarkerStart($composer, 296098216, "CC(remember):IMSettingItem.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($onAction) | $composer.changed($item);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj) {
                    Unit IMSettingSwitchItem$lambda$0$0$0;
                    IMSettingSwitchItem$lambda$0$0$0 = IMSettingItemKt.IMSettingSwitchItem$lambda$0$0$0(IMSettingActionHandler.this, $item, ((Boolean) obj).booleanValue());
                    return IMSettingSwitchItem$lambda$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        SimpleSwitchKt.SimpleSwitch(switchOn, (Function1) it$iv, priority, z, simpleSwitchSize, (SimpleSwitchColors) null, $composer, SimpleSwitchSize.$stable << 12, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingSwitchItem$lambda$0$0$0(IMSettingActionHandler $onAction, SettingItem.Setting $item, boolean it) {
        $onAction.invoke(new IMSettingSwitchAction($item, it));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0152, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMSettingSelectItem(final SettingItem.Setting item, final KSettingSelect setting, final boolean isLoading, final IMSettingActionHandler onAction, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Iterable $this$forEachIndexed$iv;
        Function0 factory$iv$iv$iv;
        final SettingItem.Setting setting2 = item;
        boolean z = isLoading;
        Intrinsics.checkNotNullParameter(setting2, "item");
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-1627646810);
        ComposerKt.sourceInformation($composer2, "C(IMSettingSelectItem)N(item,setting,isLoading,onAction,modifier)*167@5894L6,168@5959L98,163@5755L840:IMSettingItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(setting2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(setting) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(z) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= ($changed & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) == 0 ? $composer2.changed(onAction) : $composer2.changedInstance(onAction) ? 2048 : 1024;
        }
        int i3 = i2 & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        int i4 = 0;
        int i5 = 1;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1627646810, $dirty2, -1, "im.setting.IMSettingSelectItem (IMSettingItem.kt:158)");
            }
            Iterable $this$forEachIndexed$iv2 = setting.getItem();
            boolean z2 = false;
            int index$iv = 0;
            Iterator it = $this$forEachIndexed$iv2.iterator();
            while (it.hasNext()) {
                Object item$iv = it.next();
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final KSelectItem it2 = (KSelectItem) item$iv;
                if (index$iv != 0) {
                    $composer2.startReplaceGroup(-987158559);
                    ComposerKt.sourceInformation($composer2, "161@5720L16");
                    SettingDivider($composer2, i4);
                } else {
                    $composer2.startReplaceGroup(-992821143);
                }
                $composer2.endReplaceGroup();
                Modifier modifier5 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier4, (float) CropImageView.DEFAULT_ASPECT_RATIO, i5, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                boolean z3 = !z;
                ComposerKt.sourceInformationMarkerStart($composer2, 1630732315, "CC(remember):IMSettingItem.kt#9igjgp");
                int i6 = ((($dirty2 & 7168) == 2048 || (($dirty2 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 && $composer2.changedInstance(onAction))) ? i5 : 0) | (($dirty2 & 14) == 4 ? 1 : 0) | ($composer2.changedInstance(it2) ? 1 : 0);
                Object it$iv = $composer2.rememberedValue();
                if (i6 == 0) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                } else {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                }
                Object value$iv = new Function0() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda18
                    public final Object invoke() {
                        Unit IMSettingSelectItem$lambda$0$0$0;
                        IMSettingSelectItem$lambda$0$0$0 = IMSettingItemKt.IMSettingSelectItem$lambda$0$0$0(IMSettingActionHandler.this, setting2, it2);
                        return IMSettingSelectItem$lambda$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv = PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier5, z3, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), Dp.constructor-impl(16));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                Modifier modifier6 = modifier4;
                boolean z4 = z2;
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Iterator it3 = it;
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
                int i7 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i8 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -948845121, "C174@6226L54:IMSettingItem.kt#w7mava");
                IMSettingTitles(it2.getText(), null, item.isDisabled(), null, $composer2, 0, 10);
                if (it2.getSelected()) {
                    $composer2.startReplaceGroup(-948746573);
                    ComposerKt.sourceInformation($composer2, "178@6378L18,179@6435L6,177@6329L242");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
                } else {
                    $composer2.startReplaceGroup(-955033435);
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                setting2 = item;
                z = isLoading;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                index$iv = index$iv2;
                modifier4 = modifier6;
                z2 = z4;
                it = it3;
                i4 = 0;
                i5 = 1;
            }
            modifier3 = modifier4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingSelectItem$lambda$1;
                    IMSettingSelectItem$lambda$1 = IMSettingItemKt.IMSettingSelectItem$lambda$1(SettingItem.Setting.this, setting, isLoading, onAction, modifier7, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingSelectItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingSelectItem$lambda$0$0$0(IMSettingActionHandler $onAction, SettingItem.Setting $item, KSelectItem $it) {
        $onAction.invoke(new IMSettingSelectAction($item, $it.getItemType()));
        return Unit.INSTANCE;
    }

    public static final void SettingDivider(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-84024652);
        ComposerKt.sourceInformation($composer2, "C(SettingDivider)191@6752L6,192@6791L6,190@6653L192:IMSettingItem.kt#w7mava");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-84024652, $changed, -1, "im.setting.SettingDivider (IMSettingItem.kt:189)");
            }
            DividerKt.HorizontalDivider-9IZ8Weo(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer2, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingDivider$lambda$0;
                    SettingDivider$lambda$0 = IMSettingItemKt.SettingDivider$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingDivider$lambda$0;
                }
            });
        }
    }

    public static final void IMSettingRedirectItem(final SettingItem.Setting item, final KSettingRedirect setting, final IMSettingActionHandler onAction, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-575518262);
        ComposerKt.sourceInformation($composer2, "C(IMSettingRedirectItem)N(item,setting,onAction,modifier)208@7175L6,209@7214L79,213@7378L955,204@7040L1293:IMSettingItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(setting) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer2.changed(onAction) : $composer2.changedInstance(onAction) ? 256 : 128;
        }
        int i3 = i2 & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-575518262, $dirty, -1, "im.setting.IMSettingRedirectItem (IMSettingItem.kt:203)");
            }
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier4, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 977742489, "CC(remember):IMSettingItem.kt#9igjgp");
            boolean invalid$iv = (($dirty & 896) == 256 || (($dirty & 512) != 0 && $composer2.changedInstance(onAction))) | (($dirty & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit IMSettingRedirectItem$lambda$0$0;
                        IMSettingRedirectItem$lambda$0$0 = IMSettingItemKt.IMSettingRedirectItem$lambda$0$0(IMSettingActionHandler.this, item);
                        return IMSettingRedirectItem$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposePriorityHorizonKt.PriorityHorizon(PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(16)), (PriorityHorizonPolicy) null, Alignment.Companion.getCenterVertically(), ComposableLambdaKt.rememberComposableLambda(450944799, true, new Function3() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMSettingRedirectItem$lambda$1;
                    IMSettingRedirectItem$lambda$1 = IMSettingItemKt.IMSettingRedirectItem$lambda$1(setting, item, (PriorityHorizontalScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMSettingRedirectItem$lambda$1;
                }
            }, $composer2, 54), $composer2, 3456, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingRedirectItem$lambda$2;
                    IMSettingRedirectItem$lambda$2 = IMSettingItemKt.IMSettingRedirectItem$lambda$2(SettingItem.Setting.this, setting, onAction, modifier6, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingRedirectItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingRedirectItem$lambda$0$0(IMSettingActionHandler $onAction, SettingItem.Setting $item) {
        $onAction.invoke(new IMSettingRedirectAction($item));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingRedirectItem$lambda$1(KSettingRedirect $setting, SettingItem.Setting $item, PriorityHorizontalScope $this$PriorityHorizon, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$PriorityHorizon, "$this$PriorityHorizon");
        ComposerKt.sourceInformation($composer, "C214@7388L122,216@7520L54,218@7584L743:IMSettingItem.kt#w7mava");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(450944799, $changed, -1, "im.setting.IMSettingRedirectItem.<anonymous> (IMSettingItem.kt:214)");
        }
        IMSettingTitles($setting.getTitle(), $this$PriorityHorizon.priority(Modifier.Companion, 1), $item.isDisabled(), $setting.getSubtitle(), $composer, 0, 0);
        SpacerKt.Spacer($this$PriorityHorizon.priority(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 0), $composer, 0);
        Modifier modifier$iv = $this$PriorityHorizon.priority(Modifier.Companion, 2);
        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
        ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
        int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
        int i2 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        int i3 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 369272116, "C233@8135L28,234@8198L6,232@8090L227:IMSettingItem.kt#w7mava");
        if (StringsKt.isBlank($setting.getSelectedSummary())) {
            $composer.startReplaceGroup(361554975);
        } else {
            $composer.startReplaceGroup(369321870);
            ComposerKt.sourceInformation($composer, "226@7917L6,227@7969L9,224@7821L241");
            TextKt.Text-Nvy7gAk($setting.getSelectedSummary(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(2), (float) CropImageView.DEFAULT_ASPECT_RATIO, 11, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 48, 0, 131064);
        }
        $composer.endReplaceGroup();
        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void IMSettingTextItem(final KSettingText setting, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(setting, "setting");
        Composer $composer3 = $composer.startRestartGroup(1600003626);
        ComposerKt.sourceInformation($composer3, "C(IMSettingTextItem)N(setting,modifier)249@8512L6,250@8552L9,247@8451L292:IMSettingItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(setting) ? 4 : 2;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i3 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1600003626, $dirty2, -1, "im.setting.IMSettingTextItem (IMSettingItem.kt:246)");
            }
            Modifier modifier4 = modifier3;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(setting.getText(), PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(12), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer2, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingTextItem$lambda$0;
                    IMSettingTextItem$lambda$0 = IMSettingItemKt.IMSettingTextItem$lambda$0(setting, modifier2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingTextItem$lambda$0;
                }
            });
        }
    }

    private static final void IMSettingGroupTitle(final SettingGroupTitleEnum title, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-169667172);
        ComposerKt.sourceInformation($composer3, "C(IMSettingGroupTitle)N(title):IMSettingItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title == null ? -1 : title.ordinal()) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-169667172, $dirty2, -1, "im.setting.IMSettingGroupTitle (IMSettingItem.kt:260)");
            }
            StringResource res = title != null ? UtilsKt.getStringResource(title) : null;
            if (res != null) {
                $composer3.startReplaceGroup(621919735);
                ComposerKt.sourceInformation($composer3, "264@8916L19,265@8967L6,266@9011L9,263@8891L335");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(res, $composer3, 0), PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(10), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(6), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 48, 0, 131064);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(622255341);
                ComposerKt.sourceInformation($composer2, "274@9248L41");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingGroupTitle$lambda$0;
                    IMSettingGroupTitle$lambda$0 = IMSettingItemKt.IMSettingGroupTitle$lambda$0(SettingGroupTitleEnum.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingGroupTitle$lambda$0;
                }
            });
        }
    }

    public static final void IMSettingTitles(final String title, Modifier modifier, boolean isDisabled, String subTitle, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        boolean z;
        String str;
        Modifier modifier3;
        boolean isDisabled2;
        String subTitle2;
        long j;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(-81629183);
        ComposerKt.sourceInformation($composer2, "C(IMSettingTitles)N(title,modifier,isDisabled,subTitle)285@9463L187:IMSettingItem.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            $dirty |= 384;
            z = isDisabled;
        } else if (($changed & 384) == 0) {
            z = isDisabled;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = isDisabled;
        }
        int i5 = i2 & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            str = subTitle;
        } else if (($changed & 3072) == 0) {
            str = subTitle;
            $dirty |= $composer2.changed(str) ? 2048 : 1024;
        } else {
            str = subTitle;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isDisabled2 = z;
            subTitle2 = str;
        } else {
            if (i3 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 == 0) {
                isDisabled2 = z;
            } else {
                isDisabled2 = false;
            }
            if (i5 == 0) {
                subTitle2 = str;
            } else {
                subTitle2 = "";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-81629183, $dirty2, -1, "im.setting.IMSettingTitles (IMSettingItem.kt:284)");
            }
            if (isDisabled2) {
                $composer2.startReplaceGroup(-1136226106);
                ComposerKt.sourceInformation($composer2, "287@9545L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(-1136225210);
                ComposerKt.sourceInformation($composer2, "287@9573L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            m3390IMSettingTitlessW7UJKQ(title, j, modifier3, subTitle2, $composer2, ($dirty2 & 14) | (($dirty2 << 3) & 896) | ($dirty2 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z2 = isDisabled2;
            final String str2 = subTitle2;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingTitles$lambda$0;
                    IMSettingTitles$lambda$0 = IMSettingItemKt.IMSettingTitles$lambda$0(title, modifier4, z2, str2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingTitles$lambda$0;
                }
            });
        }
    }

    /* renamed from: IMSettingTitles-sW7UJKQ  reason: not valid java name */
    public static final void m3390IMSettingTitlessW7UJKQ(final String title, final long j, Modifier modifier, String subTitle, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        String str;
        Composer $composer2;
        Modifier modifier3;
        String subTitle2;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        int $dirty;
        int i3;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-978816076);
        ComposerKt.sourceInformation($composer3, "C(IMSettingTitles)N(title,color:c#ui.graphics.Color,modifier,subTitle)300@9803L601:IMSettingItem.kt#w7mava");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(j) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i2 & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            str = subTitle;
        } else if (($changed & 3072) == 0) {
            str = subTitle;
            $dirty2 |= $composer3.changed(str) ? 2048 : 1024;
        } else {
            str = subTitle;
        }
        int $dirty3 = $dirty2;
        if (!$composer3.shouldExecute(($dirty3 & 1171) != 1170, $dirty3 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            subTitle2 = str;
        } else {
            if (i4 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i5 == 0) {
                subTitle2 = str;
            } else {
                subTitle2 = "";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-978816076, $dirty3, -1, "im.setting.IMSettingTitles (IMSettingItem.kt:299)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(modifier3, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(20), (float) CropImageView.DEFAULT_ASPECT_RATIO, 11, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            Composer $composer4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer4, 1198570774, "C:IMSettingItem.kt#w7mava");
            if (!StringsKt.isBlank(title)) {
                $composer4.startReplaceGroup(1198600471);
                ComposerKt.sourceInformation($composer4, "308@10074L9,305@9973L205");
                $composer$iv$iv = $composer3;
                $composer$iv2 = $composer3;
                $composer2 = $composer3;
                $composer$iv$iv$iv = $composer3;
                $dirty = $dirty3;
                $composer$iv = $composer3;
                TextKt.Text-Nvy7gAk(title, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getClip-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16(), $composer4, ($dirty3 & 14) | (($dirty3 << 3) & 896), 24960, 110586);
                $composer4.endReplaceGroup();
                $composer4 = $composer4;
                i3 = 1188699908;
            } else {
                $composer2 = $composer3;
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv2 = $composer3;
                $composer$iv$iv$iv = $composer3;
                $dirty = $dirty3;
                i3 = 1188699908;
                $composer4.startReplaceGroup(1188699908);
                $composer4.endReplaceGroup();
            }
            if (StringsKt.isBlank(subTitle2)) {
                $composer4.startReplaceGroup(i3);
            } else {
                $composer4.startReplaceGroup(1198849463);
                ComposerKt.sourceInformation($composer4, "317@10312L6,318@10360L9,315@10239L149");
                TextKt.Text-Nvy7gAk(subTitle2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), $composer4, ($dirty >> 9) & 14, 0, 131066);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final String str2 = subTitle2;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingItemKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingTitles_sW7UJKQ$lambda$1;
                    IMSettingTitles_sW7UJKQ$lambda$1 = IMSettingItemKt.IMSettingTitles_sW7UJKQ$lambda$1(title, j, modifier4, str2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingTitles_sW7UJKQ$lambda$1;
                }
            });
        }
    }
}