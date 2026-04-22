package im.setting;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.im.v1.KAssistantId;
import com.bapis.bilibili.app.im.v1.KAssistantType;
import com.bapis.bilibili.app.im.v1.KPrivateId;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.brouter.uri.Uri;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.base.AlignmentKt;
import im.base.ContentStatus;
import im.base.EmptyContent;
import im.base.ErrorContent;
import im.base.IMStatusKt;
import im.base.IMTopBarKt;
import im.base.IdleContent;
import im.base.LoadingContent;
import im.setting.di.ChatSettingComponent;
import im.setting.di.IMSettingComponent;
import im.setting.di.SettingEntryPoint;
import im.setting.model.SettingGroup;
import im.setting.model.SettingPageType;
import im.setting.service.SettingReportService;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.list.DefaultListModifierKt;
import kntr.common.trio.systemui.ScrollToTopKt;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IMSettingPage.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\n\u001a+\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0014\u001a3\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0019\u001a\u001a\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0086B¢\u0006\u0002\u0010\u001d¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"PersonalChatSettingPage", "", "uid", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AssistantChatSettingPage", "assistantType", "assistId", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMSettingPage", "page", UtilsKt.DATA_KEY, "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "SettingPage", "settingViewModel", "Lim/setting/SettingViewModel;", "reportService", "Lim/setting/service/SettingReportService;", "(Lim/setting/SettingViewModel;Lim/setting/service/SettingReportService;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Lim/setting/IMSettingState;", "onAction", "Lkotlin/Function1;", "Lim/setting/IMSettingAction;", "(Lim/setting/IMSettingState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "invoke", "Lim/setting/IMSettingRouteHandler;", "url", "(Lim/setting/IMSettingRouteHandler;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug", "pageState"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSettingPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssistantChatSettingPage$lambda$3(String str, String str2, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        AssistantChatSettingPage(str, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSettingPage$lambda$3(String str, Modifier modifier, String str2, int i2, int i3, Composer composer, int i4) {
        IMSettingPage(str, modifier, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonalChatSettingPage$lambda$3(String str, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        PersonalChatSettingPage(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingPage$lambda$11(IMSettingState iMSettingState, Function1 function1, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        SettingPage(iMSettingState, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingPage$lambda$6(SettingViewModel settingViewModel, SettingReportService settingReportService, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        SettingPage(settingViewModel, settingReportService, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void PersonalChatSettingPage(final String uid, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Composer $composer2 = $composer.startRestartGroup(984066474);
        ComposerKt.sourceInformation($composer2, "C(PersonalChatSettingPage)N(uid,modifier)63@2569L24,65@2622L271,71@2914L45,72@2984L49,73@3038L93:IMSettingPage.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(uid) ? 4 : 2;
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
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            modifier3 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(984066474, $dirty2, -1, "im.setting.PersonalChatSettingPage (IMSettingPage.kt:62)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 795081593, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                ChatSettingComponent.Builder chatSettingComponentFactory = ((SettingEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(SettingEntryPoint.class))).getChatSettingComponentFactory();
                Long longOrNull = StringsKt.toLongOrNull(uid);
                Object value$iv = chatSettingComponentFactory.build(scope, new KSessionId(new KSessionId.KPrivateId(new KPrivateId(longOrNull != null ? longOrNull.longValue() : 0L))));
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ChatSettingComponent component = (ChatSettingComponent) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 795090711, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(component);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = component.viewModel();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            SettingViewModel viewModel = (SettingViewModel) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 795092955, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(component);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = component.reportService();
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            SettingReportService reportService = (SettingReportService) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SettingPage(viewModel, reportService, modifier3, $composer2, SettingViewModel.$stable | (($dirty2 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit PersonalChatSettingPage$lambda$3;
                    PersonalChatSettingPage$lambda$3 = IMSettingPageKt.PersonalChatSettingPage$lambda$3(uid, modifier3, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return PersonalChatSettingPage$lambda$3;
                }
            });
        }
    }

    public static final void AssistantChatSettingPage(final String assistantType, final String assistId, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(assistantType, "assistantType");
        Intrinsics.checkNotNullParameter(assistId, "assistId");
        Composer $composer2 = $composer.startRestartGroup(-230206161);
        ComposerKt.sourceInformation($composer2, "C(AssistantChatSettingPage)N(assistantType,assistId,modifier)84@3413L24,86@3466L623,102@4110L45,103@4180L49,104@4234L93:IMSettingPage.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(assistantType) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(assistId) ? 32 : 16;
        }
        int i3 = i2 & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-230206161, $dirty, -1, "im.setting.AssistantChatSettingPage (IMSettingPage.kt:83)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 2110185278, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv = (($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | (($dirty & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                ChatSettingComponent.Builder chatSettingComponentFactory = ((SettingEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(SettingEntryPoint.class))).getChatSettingComponentFactory();
                KAssistantType.Companion companion = KAssistantType.Companion;
                Integer intOrNull = StringsKt.toIntOrNull(assistantType);
                KAssistantType fromValue = companion.fromValue(intOrNull != null ? intOrNull.intValue() : 0);
                Long longOrNull = StringsKt.toLongOrNull(assistId);
                Object value$iv = chatSettingComponentFactory.build(scope, new KSessionId(new KSessionId.KAssistantId(new KAssistantId(longOrNull != null ? longOrNull.longValue() : 0L, fromValue))));
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ChatSettingComponent component = (ChatSettingComponent) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 2110205308, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(component);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = component.viewModel();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            SettingViewModel viewModel = (SettingViewModel) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 2110207552, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changed(component);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = component.reportService();
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            SettingReportService reportService = (SettingReportService) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SettingPage(viewModel, reportService, modifier4, $composer2, SettingViewModel.$stable | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AssistantChatSettingPage$lambda$3;
                    AssistantChatSettingPage$lambda$3 = IMSettingPageKt.AssistantChatSettingPage$lambda$3(assistantType, assistId, modifier5, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return AssistantChatSettingPage$lambda$3;
                }
            });
        }
    }

    public static final void IMSettingPage(final String page, Modifier modifier, String data, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        String str;
        Modifier modifier3;
        String data2;
        Intrinsics.checkNotNullParameter(page, "page");
        Composer $composer2 = $composer.startRestartGroup(-300162963);
        ComposerKt.sourceInformation($composer2, "C(IMSettingPage)N(page,modifier,data)115@4556L24,117@4609L213,123@4843L45,124@4913L49,125@4967L93:IMSettingPage.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(page) ? 4 : 2;
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
            str = data;
        } else if (($changed & 384) == 0) {
            str = data;
            $dirty |= $composer2.changed(str) ? 256 : 128;
        } else {
            str = data;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            String data3 = i4 != 0 ? null : str;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-300162963, $dirty2, -1, "im.setting.IMSettingPage (IMSettingPage.kt:114)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -693792926, "CC(remember):IMSettingPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((SettingEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(SettingEntryPoint.class))).getIMSettingComponentFactory().build(scope, UtilsKt.settingInitialParam(page, data3));
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            IMSettingComponent component = (IMSettingComponent) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -693785606, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(component);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = component.viewModel();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            SettingViewModel viewModel = (SettingViewModel) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -693783362, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(component);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = component.reportService();
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            SettingReportService reportService = (SettingReportService) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SettingPage(viewModel, reportService, modifier4, $composer2, SettingViewModel.$stable | (($dirty2 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            data2 = data3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            data2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str2 = data2;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSettingPage$lambda$3;
                    IMSettingPage$lambda$3 = IMSettingPageKt.IMSettingPage$lambda$3(page, modifier5, str2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSettingPage$lambda$3;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SettingPage(final SettingViewModel settingViewModel, final SettingReportService reportService, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        final Modifier modifier4;
        Intrinsics.checkNotNullParameter(settingViewModel, "settingViewModel");
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Composer $composer2 = $composer.startRestartGroup(-296499400);
        ComposerKt.sourceInformation($composer2, "C(SettingPage)N(settingViewModel,reportService,modifier)134@5266L16,135@5303L46,137@5418L233,137@5393L258,147@5707L59,151@5801L7,153@5835L175,153@5814L196,162@6043L7,164@6077L104,164@6056L125,170@6197L152,170@6187L162:IMSettingPage.kt#w7mava");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(settingViewModel) : $composer2.changedInstance(settingViewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(reportService) ? 32 : 16;
        }
        int i3 = i2 & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-296499400, $dirty2, -1, "im.setting.SettingPage (IMSettingPage.kt:133)");
            }
            final State pageState$delegate = SnapshotStateKt.collectAsState(settingViewModel.getState(), (CoroutineContext) null, $composer2, 0, 1);
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("im.im-setting.0.0.pv", $composer2, 6);
            SettingPageType pageType = SettingPage$lambda$0(pageState$delegate).getData().getType();
            ComposerKt.sourceInformationMarkerStart($composer2, -1468070975, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | $composer2.changedInstance(pageType) | $composer2.changedInstance(pvTrigger);
            IMSettingPageKt$SettingPage$1$1 value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new IMSettingPageKt$SettingPage$1$1(pageType, pvTrigger, reportService, null);
                $composer2.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(pageType, (Function2) value$iv, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1468061901, "CC(remember):IMSettingPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = (KFunction) new IMSettingPageKt$SettingPage$onAction$1$1(settingViewModel);
                $composer2.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Function1 onAction = (KFunction) it$iv;
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Router routeState = (Router) consume;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1468057689, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer2.changedInstance(settingViewModel))) | $composer2.changedInstance(routeState);
            IMSettingPageKt$SettingPage$2$1 value$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new IMSettingPageKt$SettingPage$2$1(settingViewModel, routeState, null);
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv3, $composer2, 6);
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Toaster toaster = (Toaster) consume2;
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1468050016, "CC(remember):IMSettingPage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(toaster) | (($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer2.changedInstance(settingViewModel)));
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv3) {
                $dirty = $dirty2;
            } else {
                $dirty = $dirty2;
                if (it$iv2 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(unit2, (Function2) it$iv2, $composer2, 6);
                    BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(352576128, true, new Function2() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SettingPage$lambda$5;
                            SettingPage$lambda$5 = IMSettingPageKt.SettingPage$lambda$5(onAction, modifier4, pageState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                            return SettingPage$lambda$5;
                        }
                    }, $composer2, 54), $composer2, 384, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
            }
            Object value$iv4 = (Function2) new IMSettingPageKt$SettingPage$3$1(settingViewModel, toaster, null);
            $composer2.updateRememberedValue(value$iv4);
            it$iv2 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv2, $composer2, 6);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(352576128, true, new Function2() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingPage$lambda$5;
                    SettingPage$lambda$5 = IMSettingPageKt.SettingPage$lambda$5(onAction, modifier4, pageState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingPage$lambda$5;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingPage$lambda$6;
                    SettingPage$lambda$6 = IMSettingPageKt.SettingPage$lambda$6(SettingViewModel.this, reportService, modifier5, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingPage$lambda$6;
                }
            });
        }
    }

    private static final IMSettingState SettingPage$lambda$0(State<IMSettingState> state) {
        Object thisObj$iv = state.getValue();
        return (IMSettingState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingPage$lambda$5(Function1 $onAction, Modifier $modifier, State $pageState$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C171@6224L28,172@6272L20,173@6301L42:IMSettingPage.kt#w7mava");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(352576128, $changed, -1, "im.setting.SettingPage.<anonymous> (IMSettingPage.kt:171)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            SettingPage(SettingPage$lambda$0($pageState$delegate), $onAction, $modifier, $composer, IMSettingState.$stable | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0409, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SettingPage(final IMSettingState page, final Function1<? super IMSettingAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        IMSettingPageState pageState;
        Function0 factory$iv$iv$iv3;
        Composer $composer3;
        final IMSettingPageState pageState2;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer4 = $composer.startRestartGroup(-1474912223);
        ComposerKt.sourceInformation($composer4, "C(SettingPage)N(page,onAction,modifier)183@6531L7,185@6567L74,189@6647L2353:IMSettingPage.kt#w7mava");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer4.changed(page) : $composer4.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i2 & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (!$composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1474912223, $dirty2, -1, "im.setting.SettingPage (IMSettingPage.kt:182)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Router routerState = (Router) consume;
            ComposerKt.sourceInformationMarkerStart($composer4, -51432373, "CC(remember):IMSettingPage.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new IMSettingPageState(routerState, new IMSettingPageKt$sam$im_setting_IMSettingActionHandler$0(function1));
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final IMSettingPageState pageState3 = (IMSettingPageState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = SizeKt.fillMaxSize$default(modifier4, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 930187233, "C194@6788L58,194@6743L104,202@6995L6,198@6857L2137:IMSettingPage.kt#w7mava");
            IMTopBarKt.m3090IMTopBarnWoaYo(ComposableLambdaKt.rememberComposableLambda(253353542, true, new Function2() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingPage$lambda$8$0;
                    SettingPage$lambda$8$0 = IMSettingPageKt.SettingPage$lambda$8$0(IMSettingState.this, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingPage$lambda$8$0;
                }
            }, $composer4, 54), null, 0L, 0L, false, false, null, null, null, $composer4, 24582, 494);
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 883695846, "C:IMSettingPage.kt#w7mava");
            if (page.getContentStatus() instanceof IdleContent) {
                $composer4.startReplaceGroup(883708772);
                ComposerKt.sourceInformation($composer4, "205@7101L23,211@7353L6,212@7394L24,213@7448L39,218@7697L12,220@7815L17,225@8023L155,206@7141L1037");
                ScrollableState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer4, 0, 3);
                Modifier defaultVerticalScrollableEffects = DefaultListModifierKt.defaultVerticalScrollableEffects(ScrollToTopKt.preferScrollToTop(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null), rememberLazyListState, (Flow) null, $composer4, 0, 2), rememberLazyListState, $composer4, 0);
                PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(0), Dp.constructor-impl(0), Dp.constructor-impl(0), WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer4, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer4, 0).calculateBottomPadding-D9Ej5fM());
                ComposerKt.sourceInformationMarkerStart($composer4, -525653096, "CC(remember):IMSettingPage.kt#9igjgp");
                boolean invalid$iv = ($dirty2 & 14) == 4 || (($dirty2 & 8) != 0 && $composer4.changedInstance(page));
                Object it$iv2 = $composer4.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function1() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit SettingPage$lambda$8$1$0$0;
                        SettingPage$lambda$8$1$0$0 = IMSettingPageKt.SettingPage$lambda$8$1$0$0(IMSettingState.this, pageState3, (LazyListScope) obj);
                        return SettingPage$lambda$8$1$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LazyDslKt.LazyColumn(defaultVerticalScrollableEffects, rememberLazyListState, paddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer4, 0, (int) TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_FAILED);
                $composer4.endReplaceGroup();
                $dirty = $dirty2;
                pageState = pageState3;
                $composer3 = $composer4;
            } else {
                $composer4.startReplaceGroup(884816371);
                ComposerKt.sourceInformation($composer4, "231@8232L27,232@8276L694");
                Alignment alignment = AlignmentKt.m3060rememberIMStatusAlignmentkHDZbjc(CropImageView.DEFAULT_ASPECT_RATIO, $composer4, 0, 1);
                Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
                int $changed$iv$iv3 = (6 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                pageState = pageState3;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                $composer3 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i9 = ((6 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 757403214, "C:IMSettingPage.kt#w7mava");
                ContentStatus contentStatus = page.getContentStatus();
                if (!(contentStatus instanceof IdleContent)) {
                    if (Intrinsics.areEqual(contentStatus, LoadingContent.INSTANCE)) {
                        $composer4.startReplaceGroup(757503064);
                        ComposerKt.sourceInformation($composer4, "239@8571L11");
                        IMStatusKt.IMLoading(null, $composer4, 0, 1);
                        $composer4.endReplaceGroup();
                        $dirty = $dirty2;
                    } else if (Intrinsics.areEqual(contentStatus, EmptyContent.INSTANCE)) {
                        $composer4.startReplaceGroup(757611130);
                        ComposerKt.sourceInformation($composer4, "243@8680L9");
                        IMStatusKt.IMEmpty(null, null, $composer4, 0, 3);
                        $composer4.endReplaceGroup();
                        $dirty = $dirty2;
                    } else {
                        if (contentStatus instanceof ErrorContent) {
                            $composer4.startReplaceGroup(757723505);
                            ComposerKt.sourceInformation($composer4, "247@8810L93,247@8790L114");
                            ComposerKt.sourceInformationMarkerStart($composer4, -668292444, "CC(remember):IMSettingPage.kt#9igjgp");
                            boolean invalid$iv2 = ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
                            $dirty = $dirty2;
                            Object value$iv3 = $composer4.rememberedValue();
                            if (!invalid$iv2 && value$iv3 != Composer.Companion.getEmpty()) {
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                IMStatusKt.IMError(null, false, value$iv3, $composer4, 0, 3);
                                $composer4.endReplaceGroup();
                            }
                            value$iv3 = new Function0() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda4
                                public final Object invoke() {
                                    Unit SettingPage$lambda$8$1$1$0$0;
                                    SettingPage$lambda$8$1$1$0$0 = IMSettingPageKt.SettingPage$lambda$8$1$1$0$0(function1);
                                    return SettingPage$lambda$8$1$1$0$0;
                                }
                            };
                            $composer4.updateRememberedValue(value$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            IMStatusKt.IMError(null, false, value$iv3, $composer4, 0, 3);
                            $composer4.endReplaceGroup();
                        } else {
                            $composer4.startReplaceGroup(-668304299);
                            $composer4.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                } else {
                    $composer4.startReplaceGroup(757456409);
                    $composer4.endReplaceGroup();
                    $dirty = $dirty2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final IMSettingDialog dialog = page.getDialog();
            if (dialog != null) {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1591928552);
                ComposerKt.sourceInformation($composer2, "262@9186L61,263@9273L62,259@9065L281");
                String title = dialog.getTitle();
                String subtitle = dialog.getSubtitle();
                ComposerKt.sourceInformationMarkerStart($composer2, -51348578, "CC(remember):IMSettingPage.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changedInstance(dialog);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    pageState2 = pageState;
                    Object value$iv4 = new Function0() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit SettingPage$lambda$9$0;
                            SettingPage$lambda$9$0 = IMSettingPageKt.SettingPage$lambda$9$0(IMSettingPageState.this, dialog);
                            return SettingPage$lambda$9$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv3 = value$iv4;
                } else {
                    pageState2 = pageState;
                }
                Function0 function0 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -51345793, "CC(remember):IMSettingPage.kt#9igjgp");
                boolean invalid$iv4 = $composer2.changedInstance(dialog);
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit SettingPage$lambda$10$0;
                            SettingPage$lambda$10$0 = IMSettingPageKt.SettingPage$lambda$10$0(IMSettingPageState.this, dialog);
                            return SettingPage$lambda$10$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv4 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                IMSettingConfirmDialogKt.IMSettingConfirmDialog(title, subtitle, function0, (Function0) it$iv4, $composer2, 0);
            } else {
                pageState2 = pageState;
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1600921311);
            }
            $composer2.endReplaceGroup();
            IMSettingWindowSelect bottomSheetWindow = page.getWindowSelect();
            if (bottomSheetWindow != null) {
                $composer2.startReplaceGroup(-1591556366);
                ComposerKt.sourceInformation($composer2, "269@9445L127");
                IMSelectBottomSheetKt.IMSelectBottomSheet(bottomSheetWindow.getItem(), pageState2.getEventHandler(), $composer2, 48);
            } else {
                $composer2.startReplaceGroup(-1600921311);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSettingPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingPage$lambda$11;
                    SettingPage$lambda$11 = IMSettingPageKt.SettingPage$lambda$11(IMSettingState.this, function1, modifier5, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingPage$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingPage$lambda$8$0(IMSettingState $page, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C195@6802L34:IMSettingPage.kt#w7mava");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(253353542, $changed, -1, "im.setting.SettingPage.<anonymous>.<anonymous> (IMSettingPage.kt:195)");
            }
            IMTopBarKt.TextTitle($page.getData().getTitle(), null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingPage$lambda$8$1$0$0(IMSettingState $page, IMSettingPageState $pageState, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        Iterable $this$forEach$iv = $page.getData().getGroups();
        for (Object element$iv : $this$forEach$iv) {
            SettingGroup it = (SettingGroup) element$iv;
            IMSettingItemKt.imSettingGroup($this$LazyColumn, it, $pageState.getEventHandler());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingPage$lambda$8$1$1$0$0(Function1 $onAction) {
        $onAction.invoke(IMSettingLoadAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingPage$lambda$9$0(IMSettingPageState $pageState, IMSettingDialog $dialog) {
        $pageState.getEventHandler().getActionHandler().invoke($dialog.getCancelAction());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingPage$lambda$10$0(IMSettingPageState $pageState, IMSettingDialog $dialog) {
        $pageState.getEventHandler().getActionHandler().invoke($dialog.getConfirmAction());
        return Unit.INSTANCE;
    }

    public static final Object invoke(IMSettingRouteHandler $this$invoke, String url, Continuation<? super Unit> continuation) {
        Object invoke = $this$invoke.invoke(Uri.Companion.parse(url), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}