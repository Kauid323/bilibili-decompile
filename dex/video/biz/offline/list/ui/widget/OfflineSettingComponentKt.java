package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.RadioButtonColors;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.graphics.Color;
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
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.common.trio.switch.SimpleSwitchColors;
import kntr.common.trio.switch.SimpleSwitchKt;
import kntr.common.trio.switch.SimpleSwitchSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.base.model.model.StorageType;
import video.biz.offline.list.logic.SupportedOptions_androidKt;
import video.biz.offline.list.logic.model.OfflineSettingOperation;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageState;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore;

/* compiled from: OfflineSettingComponent.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001a3\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001a+\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0001¢\u0006\u0002\u0010\u0017\u001a;\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u00020\f*\u00020\u0015H\u0003¢\u0006\u0002\u0010 \u001a\u0011\u0010!\u001a\u00020\f*\u00020\u0015H\u0003¢\u0006\u0002\u0010 ¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"mapToSettingComponent", "", "Lvideo/biz/offline/list/logic/model/OfflineSettingOperation;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "state", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Ready;", "store", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageStore;", "(Lvideo/biz/offline/list/logic/model/OfflineSettingOperation;Lkotlinx/coroutines/CoroutineScope;Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Ready;Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageStore;Landroidx/compose/runtime/Composer;I)V", "SettingSwitchItem", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "subtitle", "checked", "", "onToggleSwitch", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StorageInfoItem", "storageItem", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "onClick", "(Lvideo/biz/offline/base/model/model/StorageInfoModel;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SettingClickItem", "modifier", "Landroidx/compose/ui/Modifier;", "dividerColor", "Landroidx/compose/ui/graphics/Color;", "SettingClickItem-xqIIw2o", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;II)V", "storageTypeDesc", "(Lvideo/biz/offline/base/model/model/StorageInfoModel;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "StorageContent", "ui_debug", "hideStorageSwitch", "hideStorageTest"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSettingComponentKt {

    /* compiled from: OfflineSettingComponent.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OfflineSettingOperation.values().length];
            try {
                iArr[OfflineSettingOperation.STORAGE_SELECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineSettingOperation.AUTO_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfflineSettingOperation.OFFLINE_DIAGNOSIS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[OfflineSettingOperation.STORAGE_TEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[StorageType.values().length];
            try {
                iArr2[StorageType.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[StorageType.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingClickItem_xqIIw2o$lambda$2(String str, Function0 function0, Modifier modifier, Color color, int i, int i2, Composer composer, int i3) {
        m2958SettingClickItemxqIIw2o(str, function0, modifier, color, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingSwitchItem$lambda$1(String str, String str2, boolean z, Function0 function0, int i, Composer composer, int i2) {
        SettingSwitchItem(str, str2, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StorageInfoItem$lambda$1(StorageInfoModel storageInfoModel, boolean z, Function0 function0, int i, Composer composer, int i2) {
        StorageInfoItem(storageInfoModel, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToSettingComponent$lambda$9(OfflineSettingOperation offlineSettingOperation, CoroutineScope coroutineScope, OfflineSettingsPageState.Ready ready, OfflineSettingsPageStore offlineSettingsPageStore, int i, Composer composer, int i2) {
        mapToSettingComponent(offlineSettingOperation, coroutineScope, ready, offlineSettingsPageStore, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void mapToSettingComponent(final OfflineSettingOperation $this$mapToSettingComponent, final CoroutineScope scope, final OfflineSettingsPageState.Ready state, final OfflineSettingsPageStore store, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$mapToSettingComponent, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(store, "store");
        Composer $composer2 = $composer.startRestartGroup(1152173618);
        ComposerKt.sourceInformation($composer2, "C(mapToSettingComponent)N(scope,state,store):OfflineSettingComponent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$mapToSettingComponent.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(scope) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer2.changed(state) : $composer2.changedInstance(state) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= ($changed & 4096) == 0 ? $composer2.changed(store) : $composer2.changedInstance(store) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1152173618, $dirty2, -1, "video.biz.offline.list.ui.widget.mapToSettingComponent (OfflineSettingComponent.kt:51)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[$this$mapToSettingComponent.ordinal()]) {
                case 1:
                    $composer2.startReplaceGroup(-974105596);
                    ComposerKt.sourceInformation($composer2, "53@2531L69,58@2667L259,58@2633L293");
                    ComposerKt.sourceInformationMarkerStart($composer2, -862707177, "CC(remember):OfflineSettingComponent.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(SupportedOptions_androidKt.hideExternalSdcard()), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    MutableState hideStorageSwitch$delegate = (MutableState) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Boolean valueOf = Boolean.valueOf(mapToSettingComponent$lambda$1(hideStorageSwitch$delegate));
                    ComposerKt.sourceInformationMarkerStart($composer2, -862702635, "CC(remember):OfflineSettingComponent.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & 7168) == 2048 || (($dirty2 & 4096) != 0 && $composer2.changedInstance(store));
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = (Function2) new OfflineSettingComponentKt$mapToSettingComponent$1$1(store, hideStorageSwitch$delegate, null);
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer2, 0);
                    if (!mapToSettingComponent$lambda$1(hideStorageSwitch$delegate)) {
                        $composer2.startReplaceGroup(-973662110);
                        ComposerKt.sourceInformation($composer2, "69@2985L1035,69@2974L1046");
                        ComposerKt.sourceInformationMarkerStart($composer2, -862691683, "CC(remember):OfflineSettingComponent.kt#9igjgp");
                        boolean invalid$iv2 = (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(state))) | $composer2.changedInstance(scope) | (($dirty2 & 7168) == 2048 || (($dirty2 & 4096) != 0 && $composer2.changedInstance(store)));
                        Object it$iv3 = $composer2.rememberedValue();
                        if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                            Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    Unit mapToSettingComponent$lambda$3$0;
                                    mapToSettingComponent$lambda$3$0 = OfflineSettingComponentKt.mapToSettingComponent$lambda$3$0(OfflineSettingsPageState.Ready.this, scope, store, (LazyListScope) obj);
                                    return mapToSettingComponent$lambda$3$0;
                                }
                            };
                            $composer2.updateRememberedValue(value$iv3);
                            it$iv3 = value$iv3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        LazyDslKt.LazyColumn((Modifier) null, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv3, $composer2, 0, 511);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-972625842);
                        ComposerKt.sourceInformation($composer2, "94@4050L42");
                        SpacerKt.Spacer(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), $composer2, 6);
                        $composer2.endReplaceGroup();
                    }
                    $composer2.endReplaceGroup();
                    break;
                case 2:
                    $composer2.startReplaceGroup(-972494340);
                    ComposerKt.sourceInformation($composer2, "103@4455L144,99@4165L434,108@4608L41");
                    String string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2250(PlayerbaseresRes.INSTANCE.getString()));
                    String string2 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2174(PlayerbaseresRes.INSTANCE.getString()));
                    boolean isAutoResumption = state.isAutoResumption();
                    ComposerKt.sourceInformationMarkerStart($composer2, -862645534, "CC(remember):OfflineSettingComponent.kt#9igjgp");
                    boolean invalid$iv3 = $composer2.changedInstance(scope) | (($dirty2 & 7168) == 2048 || (($dirty2 & 4096) != 0 && $composer2.changedInstance(store)));
                    Object it$iv4 = $composer2.rememberedValue();
                    if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                Unit mapToSettingComponent$lambda$4$0;
                                mapToSettingComponent$lambda$4$0 = OfflineSettingComponentKt.mapToSettingComponent$lambda$4$0(scope, store);
                                return mapToSettingComponent$lambda$4$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    SettingSwitchItem(string, string2, isAutoResumption, (Function0) it$iv4, $composer2, 0);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(15)), $composer2, 6);
                    $composer2.endReplaceGroup();
                    break;
                case 3:
                    $composer2.startReplaceGroup(-971950445);
                    ComposerKt.sourceInformation($composer2, "112@4740L6,115@4912L154,113@4766L347");
                    long divider = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_light-0d7_KjU();
                    String string3 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2177(PlayerbaseresRes.INSTANCE.getString()));
                    ComposerKt.sourceInformationMarkerStart($composer2, -862630900, "CC(remember):OfflineSettingComponent.kt#9igjgp");
                    boolean invalid$iv4 = $composer2.changedInstance(scope) | (($dirty2 & 7168) == 2048 || (($dirty2 & 4096) != 0 && $composer2.changedInstance(store)));
                    Object it$iv5 = $composer2.rememberedValue();
                    if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit mapToSettingComponent$lambda$5$0;
                                mapToSettingComponent$lambda$5$0 = OfflineSettingComponentKt.mapToSettingComponent$lambda$5$0(scope, store);
                                return mapToSettingComponent$lambda$5$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    m2958SettingClickItemxqIIw2o(string3, (Function0) it$iv5, null, Color.box-impl(divider), $composer2, 0, 4);
                    $composer2.endReplaceGroup();
                    break;
                case 4:
                    $composer2.startReplaceGroup(-971491707);
                    ComposerKt.sourceInformation($composer2, "125@5198L69");
                    ComposerKt.sourceInformationMarkerStart($composer2, -862621833, "CC(remember):OfflineSettingComponent.kt#9igjgp");
                    Object it$iv6 = $composer2.rememberedValue();
                    if (it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(SupportedOptions_androidKt.hideExternalSdcard()), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    }
                    MutableState hideStorageTest$delegate = (MutableState) it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (!mapToSettingComponent$lambda$7(hideStorageTest$delegate)) {
                        $composer2.startReplaceGroup(-971363646);
                        ComposerKt.sourceInformation($composer2, "132@5467L173,130@5313L342");
                        String string4 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2236(PlayerbaseresRes.INSTANCE.getString()));
                        ComposerKt.sourceInformationMarkerStart($composer2, -862613121, "CC(remember):OfflineSettingComponent.kt#9igjgp");
                        boolean invalid$iv5 = $composer2.changedInstance(scope) | (($dirty2 & 7168) == 2048 || (($dirty2 & 4096) != 0 && $composer2.changedInstance(store)));
                        Object it$iv7 = $composer2.rememberedValue();
                        if (invalid$iv5 || it$iv7 == Composer.Companion.getEmpty()) {
                            Object value$iv7 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda7
                                public final Object invoke() {
                                    Unit mapToSettingComponent$lambda$8$0;
                                    mapToSettingComponent$lambda$8$0 = OfflineSettingComponentKt.mapToSettingComponent$lambda$8$0(scope, store);
                                    return mapToSettingComponent$lambda$8$0;
                                }
                            };
                            $composer2.updateRememberedValue(value$iv7);
                            it$iv7 = value$iv7;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        m2958SettingClickItemxqIIw2o(string4, (Function0) it$iv7, null, null, $composer2, 0, 12);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-971005627);
                        $composer2.endReplaceGroup();
                    }
                    $composer2.endReplaceGroup();
                    break;
                default:
                    $composer2.startReplaceGroup(-862707032);
                    $composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit mapToSettingComponent$lambda$9;
                    mapToSettingComponent$lambda$9 = OfflineSettingComponentKt.mapToSettingComponent$lambda$9(OfflineSettingOperation.this, scope, state, store, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return mapToSettingComponent$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mapToSettingComponent$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToSettingComponent$lambda$3$0(final OfflineSettingsPageState.Ready $state, final CoroutineScope $scope, final OfflineSettingsPageStore $store, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List storageInfos = $state.getStorageInfoList();
        if (storageInfos.size() > 1) {
            LazyListScope.-CC.items$default($this$LazyColumn, storageInfos.size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(139902718, true, new Function4() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit mapToSettingComponent$lambda$3$0$0;
                    mapToSettingComponent$lambda$3$0$0 = OfflineSettingComponentKt.mapToSettingComponent$lambda$3$0$0(storageInfos, $state, $scope, $store, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return mapToSettingComponent$lambda$3$0$0;
                }
            }), 6, (Object) null);
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$OfflineSettingComponentKt.INSTANCE.getLambda$902260533$ui_debug(), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToSettingComponent$lambda$3$0$0(final List $storageInfos, OfflineSettingsPageState.Ready $state, final CoroutineScope $scope, final OfflineSettingsPageStore $store, LazyItemScope $this$items, final int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)77@3403L421,74@3193L658:OfflineSettingComponent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        if (!$composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(139902718, $dirty, -1, "video.biz.offline.list.ui.widget.mapToSettingComponent.<anonymous>.<anonymous>.<anonymous> (OfflineSettingComponent.kt:74)");
            }
            StorageInfoModel storageInfoModel = (StorageInfoModel) $storageInfos.get(index);
            boolean z = ((StorageInfoModel) $storageInfos.get(index)).getStorageType() == $state.getStorageType();
            ComposerKt.sourceInformationMarkerStart($composer, 1302534083, "CC(remember):OfflineSettingComponent.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($store) | $composer.changedInstance($storageInfos) | (($dirty & 112) == 32);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit mapToSettingComponent$lambda$3$0$0$0$0;
                        mapToSettingComponent$lambda$3$0$0$0$0 = OfflineSettingComponentKt.mapToSettingComponent$lambda$3$0$0$0$0($scope, $store, $storageInfos, index);
                        return mapToSettingComponent$lambda$3$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StorageInfoItem(storageInfoModel, z, (Function0) it$iv, $composer, StorageInfoModel.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToSettingComponent$lambda$3$0$0$0$0(CoroutineScope $scope, OfflineSettingsPageStore $store, List $storageInfos, int $index) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineSettingComponentKt$mapToSettingComponent$2$1$1$1$1$1($store, $storageInfos, $index, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToSettingComponent$lambda$4$0(CoroutineScope $scope, OfflineSettingsPageStore $store) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineSettingComponentKt$mapToSettingComponent$3$1$1($store, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToSettingComponent$lambda$5$0(CoroutineScope $scope, OfflineSettingsPageStore $store) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineSettingComponentKt$mapToSettingComponent$4$1$1($store, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final boolean mapToSettingComponent$lambda$7(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mapToSettingComponent$lambda$8$0(CoroutineScope $scope, OfflineSettingsPageStore $store) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineSettingComponentKt$mapToSettingComponent$5$1$1($store, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final void SettingSwitchItem(final String title, final String subtitle, final boolean checked, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(1332262632);
        ComposerKt.sourceInformation($composer2, "C(SettingSwitchItem)N(title,subtitle,checked,onToggleSwitch)154@5962L6,151@5879L920:OfflineSettingComponent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(subtitle) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(checked) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1332262632, $dirty2, -1, "video.biz.offline.list.ui.widget.SettingSwitchItem (OfflineSettingComponent.kt:150)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(15), Dp.constructor-impl(10));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$SettingSwitchItem_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 97857964, "C158@6110L481,176@6762L20,173@6600L193:OfflineSettingComponent.kt#uys4uf");
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$SettingSwitchItem_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1099039455, "C161@6233L9,162@6282L6,159@6163L175,165@6351L40,168@6477L9,169@6526L6,166@6404L177:OfflineSettingComponent.kt#uys4uf");
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, $dirty2 & 14, 24576, 114682);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), $composer2, 6);
            TextKt.Text-Nvy7gAk(subtitle, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, ($dirty2 >> 3) & 14, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SimpleSwitchSize simpleSwitchSize = new SimpleSwitchSize(Dp.constructor-impl(24), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(48), Dp.constructor-impl(30), 2, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1520843744, "CC(remember):OfflineSettingComponent.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit SettingSwitchItem$lambda$0$1$0;
                        SettingSwitchItem$lambda$0$1$0 = OfflineSettingComponentKt.SettingSwitchItem$lambda$0$1$0(function0, ((Boolean) obj).booleanValue());
                        return SettingSwitchItem$lambda$0$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SimpleSwitchKt.SimpleSwitch(checked, (Function1) it$iv, (Modifier) null, false, simpleSwitchSize, (SimpleSwitchColors) null, $composer2, (($dirty2 >> 6) & 14) | (SimpleSwitchSize.$stable << 12), 44);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingSwitchItem$lambda$1;
                    SettingSwitchItem$lambda$1 = OfflineSettingComponentKt.SettingSwitchItem$lambda$1(title, subtitle, checked, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingSwitchItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingSwitchItem$lambda$0$1$0(Function0 $onToggleSwitch, boolean it) {
        $onToggleSwitch.invoke();
        return Unit.INSTANCE;
    }

    public static final void StorageInfoItem(final StorageInfoModel storageItem, final boolean checked, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(storageItem, "storageItem");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(441978165);
        ComposerKt.sourceInformation($composer2, "C(StorageInfoItem)N(storageItem,checked,onClick)190@7018L6,187@6935L836:OfflineSettingComponent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(storageItem) : $composer2.changedInstance(storageItem) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(checked) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(441978165, $dirty2, -1, "video.biz.offline.list.ui.widget.StorageInfoItem (OfflineSettingComponent.kt:186)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(15), Dp.constructor-impl(10));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$StorageInfoItem_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -192371365, "C194@7166L493,209@7668L38,210@7715L50:OfflineSettingComponent.kt#uys4uf");
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 779615162, "C196@7228L17,197@7281L9,198@7330L6,195@7187L199,201@7399L40,203@7493L16,204@7545L9,205@7594L6,202@7452L197:OfflineSettingComponent.kt#uys4uf");
            TextKt.Text-Nvy7gAk(storageTypeDesc(storageItem, $composer2, StorageInfoModel.$stable | ($dirty2 & 14)), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 24576, 114682);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), $composer2, 6);
            TextKt.Text-Nvy7gAk(StorageContent(storageItem, $composer2, StorageInfoModel.$stable | ($dirty2 & 14)), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 0, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$StorageInfoItem_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
            RadioButtonKt.RadioButton(checked, function0, (Modifier) null, false, (RadioButtonColors) null, (MutableInteractionSource) null, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112), 60);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit StorageInfoItem$lambda$1;
                    StorageInfoItem$lambda$1 = OfflineSettingComponentKt.StorageInfoItem$lambda$1(StorageInfoModel.this, checked, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return StorageInfoItem$lambda$1;
                }
            });
        }
    }

    /* renamed from: SettingClickItem-xqIIw2o  reason: not valid java name */
    public static final void m2958SettingClickItemxqIIw2o(final String title, final Function0<Unit> function0, Modifier modifier, Color dividerColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Color color;
        Composer $composer2;
        Modifier modifier3;
        Color dividerColor2;
        Modifier modifier4;
        Color dividerColor3;
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-733653983);
        ComposerKt.sourceInformation($composer3, "C(SettingClickItem)N(title,onClick,modifier,dividerColor:c#ui.graphics.Color)225@8053L6,227@8158L267,221@7938L1046:OfflineSettingComponent.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            color = dividerColor;
        } else if (($changed & 3072) == 0) {
            color = dividerColor;
            $dirty |= $composer3.changed(color) ? 2048 : 1024;
        } else {
            color = dividerColor;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                dividerColor3 = color;
            } else {
                dividerColor3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-733653983, $dirty2, -1, "video.biz.offline.list.ui.widget.SettingClickItem (OfflineSettingComponent.kt:220)");
            }
            final Color dividerColor4 = dividerColor3;
            Modifier modifier5 = modifier4;
            Modifier modifier6 = ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null);
            boolean z = dividerColor4 != null;
            ComposerKt.sourceInformationMarkerStart($composer3, -666829268, "CC(remember):OfflineSettingComponent.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Modifier SettingClickItem_xqIIw2o$lambda$0$0;
                        SettingClickItem_xqIIw2o$lambda$0$0 = OfflineSettingComponentKt.SettingClickItem_xqIIw2o$lambda$0$0(dividerColor4, (Modifier) obj);
                        return SettingClickItem_xqIIw2o$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(OfflineComposeExtKt.ifMatch(modifier6, z, (Function1) it$iv), Dp.constructor-impl(15), Dp.constructor-impl(10)).then(modifier5);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1122217745, "C242@8697L9,243@8742L6,240@8635L129,246@8814L28,247@8873L6,245@8773L205:OfflineSettingComponent.kt#uys4uf");
            $composer2 = $composer3;
            dividerColor2 = dividerColor4;
            modifier3 = modifier5;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, $dirty2 & 14, 0, 131066);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa4-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
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
            modifier3 = modifier2;
            dividerColor2 = color;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Color color2 = dividerColor2;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineSettingComponentKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingClickItem_xqIIw2o$lambda$2;
                    SettingClickItem_xqIIw2o$lambda$2 = OfflineSettingComponentKt.SettingClickItem_xqIIw2o$lambda$2(title, function0, modifier7, color2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingClickItem_xqIIw2o$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier SettingClickItem_xqIIw2o$lambda$0$0(Color $dividerColor, Modifier it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ($dividerColor != null) {
            return BottomDividerKt.m2901drawBottomDividermxwnekA$default(it, false, $dividerColor.unbox-impl(), 1, null);
        }
        return it;
    }

    private static final String storageTypeDesc(StorageInfoModel $this$storageTypeDesc, Composer $composer, int $changed) {
        String string;
        ComposerKt.sourceInformationMarkerStart($composer, 823377672, "C(storageTypeDesc):OfflineSettingComponent.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(823377672, $changed, -1, "video.biz.offline.list.ui.widget.storageTypeDesc (OfflineSettingComponent.kt:256)");
        }
        switch (WhenMappings.$EnumSwitchMapping$1[$this$storageTypeDesc.getStorageType().ordinal()]) {
            case 1:
                string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2251(PlayerbaseresRes.INSTANCE.getString()));
                break;
            case 2:
                string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2165(PlayerbaseresRes.INSTANCE.getString()));
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return string;
    }

    private static final String StorageContent(StorageInfoModel $this$StorageContent, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1122806832, "C(StorageContent):OfflineSettingComponent.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1122806832, $changed, -1, "video.biz.offline.list.ui.widget.StorageContent (OfflineSettingComponent.kt:267)");
        }
        String str = $this$StorageContent.getStoragePath() + " (" + $this$StorageContent.getAvailableSpaceDesc() + " / " + $this$StorageContent.getTotalSpaceDesc() + ")";
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return str;
    }
}