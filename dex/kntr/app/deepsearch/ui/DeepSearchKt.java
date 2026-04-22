package kntr.app.deepsearch.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
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
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.deepsearch.DeepSearchViewModel;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentList;
import kntr.app.deepsearch.base.model.biz.DeepSearchCopyModel;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchToast;
import kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopContent;
import kntr.app.deepsearch.base.model.biz.RequestState;
import kntr.app.deepsearch.base.model.biz.TextConfigModel;
import kntr.app.deepsearch.base.model.input.InputState;
import kntr.app.deepsearch.base.model.input.SenderStatus;
import kntr.app.deepsearch.di.DeepSearchComponent;
import kntr.app.deepsearch.di.DeepSearchEntryPoint;
import kntr.app.deepsearch.stub.PageStub_androidKt;
import kntr.app.deepsearch.ui.ae.BackgroundKt;
import kntr.app.deepsearch.ui.ae.KeepBottomEffectKt;
import kntr.app.deepsearch.ui.input.AIHintKt;
import kntr.app.deepsearch.ui.input.GoToEndKt;
import kntr.app.deepsearch.ui.input.ImeVisibleKt;
import kntr.app.deepsearch.ui.input.InputKt;
import kntr.app.deepsearch.ui.list.ContentListKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.compose.list.LoadMoreListStateKt;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.deepsearch.compose.generated.resources.Res;
import srcs.app.deepsearch.compose.generated.resources.String0_commonMainKt;

/* compiled from: DeepSearch.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u001a1\u0010\u0000\u001a\u00020\u00012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"DeepSearch", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQuery", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "sessionTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "DeepSearchPage", "backFromLogin", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "WindowConfig", "isNight", "(ZLandroidx/compose/runtime/Composer;I)V", "compose_debug", "loginRequired", "everLogin", "isShowingDialog"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearch$lambda$13(String str, String str2, String str3, int i, int i2, Composer composer, int i3) {
        DeepSearch(str, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchPage$lambda$8(String str, String str2, String str3, boolean z, int i, int i2, Composer composer, int i3) {
        DeepSearchPage(str, str2, str3, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WindowConfig$lambda$1(boolean z, int i, Composer composer, int i2) {
        WindowConfig(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DeepSearch(String sessionQuery, String sessionId, String sessionTitle, Composer $composer, final int $changed, final int i) {
        String str;
        String sessionId2;
        String sessionTitle2;
        String sessionQuery2;
        String sessionQuery3;
        String sessionId3;
        String sessionTitle3;
        Composer $composer2 = $composer.startRestartGroup(-957541165);
        ComposerKt.sourceInformation($composer2, "C(DeepSearch)N(sessionQuery,sessionId,sessionTitle)95@4341L16,96@4383L46,100@4452L46,104@4534L98,104@4504L128,110@4674L7:DeepSearch.kt#7uvpm4");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = sessionQuery;
        } else if (($changed & 6) == 0) {
            str = sessionQuery;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = sessionQuery;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            sessionId2 = sessionId;
        } else if (($changed & 48) == 0) {
            sessionId2 = sessionId;
            $dirty |= $composer2.changed(sessionId2) ? 32 : 16;
        } else {
            sessionId2 = sessionId;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            sessionTitle2 = sessionTitle;
        } else if (($changed & 384) == 0) {
            sessionTitle2 = sessionTitle;
            $dirty |= $composer2.changed(sessionTitle2) ? 256 : 128;
        } else {
            sessionTitle2 = sessionTitle;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            sessionQuery2 = str;
        } else {
            if (i2 != 0) {
                sessionQuery3 = null;
            } else {
                sessionQuery3 = str;
            }
            if (i3 == 0) {
                sessionId3 = sessionId2;
            } else {
                sessionId3 = null;
            }
            if (i4 == 0) {
                sessionTitle3 = sessionTitle2;
            } else {
                sessionTitle3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-957541165, $dirty2, -1, "kntr.app.deepsearch.ui.DeepSearch (DeepSearch.kt:94)");
            }
            State account = SnapshotStateKt.collectAsState(KAccountStoreKt.getAccountHolder().getState(), (CoroutineContext) null, $composer2, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer2, -1074048639, "CC(remember):DeepSearch.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState loginRequired$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1074046431, "CC(remember):DeepSearch.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState everLogin$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Object value = account.getValue();
            ComposerKt.sourceInformationMarkerStart($composer2, -1074043755, "CC(remember):DeepSearch.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(account);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new DeepSearchKt$DeepSearch$1$1(account, everLogin$delegate, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(value, (Function2) it$iv3, $composer2, 0);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Lifecycle lifecycle = ((LifecycleOwner) consume).getLifecycle();
            AccountState accountState = (AccountState) account.getValue();
            if (Intrinsics.areEqual(accountState, AccountState.Idle.INSTANCE)) {
                $composer2.startReplaceGroup(1064621440);
                ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                if (!DeepSearch$lambda$1(loginRequired$delegate)) {
                    $composer2.startReplaceGroup(1064644039);
                    ComposerKt.sourceInformation($composer2, "115@4831L7,116@4885L313,116@4855L343");
                    CompositionLocal this_$iv2 = RouterKt.getLocalRouter();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(this_$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Router router = (Router) consume2;
                    Object value2 = account.getValue();
                    ComposerKt.sourceInformationMarkerStart($composer2, -1074032308, "CC(remember):DeepSearch.kt#9igjgp");
                    boolean invalid$iv2 = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(router);
                    Object it$iv4 = $composer2.rememberedValue();
                    if (!invalid$iv2 && it$iv4 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(value2, (Function2) it$iv4, $composer2, 0);
                        $composer2.endReplaceGroup();
                    }
                    Object value$iv4 = (Function2) new DeepSearchKt$DeepSearch$2$1(lifecycle, router, loginRequired$delegate, null);
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(value2, (Function2) it$iv4, $composer2, 0);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(1065071839);
                    ComposerKt.sourceInformation($composer2, "123@5295L7,124@5349L319,124@5319L349");
                    OnBackPressedDispatcher onBackPressedDispatcher = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
                    Object value3 = account.getValue();
                    ComposerKt.sourceInformationMarkerStart($composer2, -1074017454, "CC(remember):DeepSearch.kt#9igjgp");
                    boolean invalid$iv3 = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(onBackPressedDispatcher);
                    Object it$iv5 = $composer2.rememberedValue();
                    if (!invalid$iv3 && it$iv5 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(value3, (Function2) it$iv5, $composer2, 0);
                        $composer2.endReplaceGroup();
                    }
                    Object value$iv5 = (Function2) new DeepSearchKt$DeepSearch$3$1(lifecycle, onBackPressedDispatcher, everLogin$delegate, null);
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(value3, (Function2) it$iv5, $composer2, 0);
                    $composer2.endReplaceGroup();
                }
                $composer2.endReplaceGroup();
            } else if (!(accountState instanceof AccountState.Logged)) {
                $composer2.startReplaceGroup(-1074037055);
                $composer2.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer2.startReplaceGroup(1065580270);
                ComposerKt.sourceInformation($composer2, "136@5763L62,140@5869L175,140@5839L205,146@6058L205");
                ComposerKt.sourceInformationMarkerStart($composer2, -1074004463, "CC(remember):DeepSearch.kt#9igjgp");
                Object it$iv6 = $composer2.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                MutableState backFromLogin$delegate = (MutableState) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Object value4 = account.getValue();
                ComposerKt.sourceInformationMarkerStart($composer2, -1074000958, "CC(remember):DeepSearch.kt#9igjgp");
                boolean invalid$iv4 = $composer2.changedInstance(lifecycle);
                Object it$iv7 = $composer2.rememberedValue();
                if (invalid$iv4 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = (Function2) new DeepSearchKt$DeepSearch$4$1(lifecycle, backFromLogin$delegate, null);
                    $composer2.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(value4, (Function2) it$iv7, $composer2, 0);
                DeepSearchPage(sessionQuery3, sessionId3, sessionTitle3, DeepSearch$lambda$10(backFromLogin$delegate), $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896), 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sessionQuery2 = sessionQuery3;
            sessionId2 = sessionId3;
            sessionTitle2 = sessionTitle3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str2 = sessionQuery2;
            final String str3 = sessionId2;
            final String str4 = sessionTitle2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeepSearch$lambda$13;
                    DeepSearch$lambda$13 = DeepSearchKt.DeepSearch$lambda$13(str2, str3, str4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DeepSearch$lambda$13;
                }
            });
        }
    }

    private static final boolean DeepSearch$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DeepSearch$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DeepSearch$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DeepSearch$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean DeepSearch$lambda$10(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DeepSearch$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x02a7, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0247, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x024b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DeepSearchPage(String sessionQuery, String sessionId, String sessionTitle, boolean backFromLogin, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        String sessionTitle2;
        boolean backFromLogin2;
        String sessionQuery2;
        String sessionId2;
        Object value$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        ClipboardManager clipboardManager;
        Object it$iv;
        boolean invalid$iv3;
        boolean invalid$iv4;
        Object it$iv2;
        Composer $composer2 = $composer.startRestartGroup(-106194010);
        ComposerKt.sourceInformation($composer2, "C(DeepSearchPage)N(sessionQuery,sessionId,sessionTitle,backFromLogin)164@6509L43,166@6570L24,168@6644L282,176@6958L16,179@7054L7,180@7093L7,181@7123L35,182@7185L42,184@7276L134,184@7233L177,190@7453L298,190@7416L335,201@7810L441,201@7757L494,213@8312L111,219@8429L52,221@8523L7,223@8557L240,223@8536L261,233@8813L7164,233@8803L7174,415@16005L25,416@16073L257,416@16035L295:DeepSearch.kt#7uvpm4");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = sessionQuery;
        } else if (($changed & 6) == 0) {
            str = sessionQuery;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = sessionQuery;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str2 = sessionId;
        } else if (($changed & 48) == 0) {
            str2 = sessionId;
            $dirty |= $composer2.changed(str2) ? 32 : 16;
        } else {
            str2 = sessionId;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            sessionTitle2 = sessionTitle;
        } else if (($changed & 384) == 0) {
            sessionTitle2 = sessionTitle;
            $dirty |= $composer2.changed(sessionTitle2) ? 256 : 128;
        } else {
            sessionTitle2 = sessionTitle;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            backFromLogin2 = backFromLogin;
        } else if (($changed & 3072) == 0) {
            backFromLogin2 = backFromLogin;
            $dirty |= $composer2.changed(backFromLogin2) ? 2048 : 1024;
        } else {
            backFromLogin2 = backFromLogin;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            sessionQuery2 = i2 != 0 ? null : str;
            sessionId2 = i3 != 0 ? null : str2;
            if (i4 != 0) {
                sessionTitle2 = null;
            }
            if (i5 != 0) {
                backFromLogin2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-106194010, $dirty2, -1, "kntr.app.deepsearch.ui.DeepSearchPage (DeepSearch.kt:163)");
            }
            PvTriggerEntranceKt.rememberPvEventTrigger("im.ds-chat.0.0.pv", $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1026781312, "CC(remember):DeepSearch.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                DeepSearchComponent.Builder deepSearchComponentFactory = ((DeepSearchEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(DeepSearchEntryPoint.class))).getDeepSearchComponentFactory();
                String str3 = RoomRecommendViewModel.EMPTY_CURSOR;
                String str4 = sessionId2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : sessionId2;
                String str5 = sessionQuery2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : sessionQuery2;
                if (sessionTitle2 != null) {
                    str3 = sessionTitle2;
                }
                Object value$iv2 = deepSearchComponentFactory.build(scope, str4, str5, str3).viewModel();
                $composer2.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            final DeepSearchViewModel viewModel = (DeepSearchViewModel) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State data = SnapshotStateKt.collectAsState(viewModel.getData(), (CoroutineContext) null, $composer2, 0, 1);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ClipboardManager clipboardManager2 = (ClipboardManager) consume;
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Toaster toaster = (Toaster) consume2;
            String successCopy = StringResourcesKt.stringResource(String0_commonMainKt.getHas_copy(Res.string.INSTANCE), $composer2, 0);
            final String successFeedBack = StringResourcesKt.stringResource(String0_commonMainKt.getFeedback_thanks(Res.string.INSTANCE), $composer2, 0);
            DeepSearchToast deepSearchToast = ((DeepSearchPageData) data.getValue()).getDeepSearchToast();
            ComposerKt.sourceInformationMarkerStart($composer2, 1026801388, "CC(remember):DeepSearch.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changed(data) | $composer2.changedInstance(toaster);
            String sessionTitle3 = sessionTitle2;
            Object it$iv4 = $composer2.rememberedValue();
            if (!invalid$iv5 && it$iv4 != Composer.Companion.getEmpty()) {
                value$iv = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(deepSearchToast, (Function2) value$iv, $composer2, 0);
                DeepSearchCopyModel copyModel = ((DeepSearchPageData) data.getValue()).getCopyModel();
                ComposerKt.sourceInformationMarkerStart($composer2, 1026807216, "CC(remember):DeepSearch.kt#9igjgp");
                invalid$iv = $composer2.changed(data) | $composer2.changedInstance(clipboardManager2) | $composer2.changedInstance(toaster) | $composer2.changed(successCopy);
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = (Function2) new DeepSearchKt$DeepSearchPage$2$1(data, clipboardManager2, toaster, successCopy, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv5 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(copyModel, (Function2) it$iv5, $composer2, 0);
                RequestState likeReqState = ((DeepSearchPageData) data.getValue()).getRequestModel().getLikeReqState();
                ComposerKt.sourceInformationMarkerStart($composer2, 1026818783, "CC(remember):DeepSearch.kt#9igjgp");
                invalid$iv2 = $composer2.changed(data) | $composer2.changedInstance(toaster) | $composer2.changed(successFeedBack);
                DeepSearchKt$DeepSearchPage$3$1 value$iv4 = $composer2.rememberedValue();
                if (invalid$iv2) {
                    clipboardManager = clipboardManager2;
                } else {
                    clipboardManager = clipboardManager2;
                }
                value$iv4 = new DeepSearchKt$DeepSearchPage$3$1(data, toaster, successFeedBack, null);
                $composer2.updateRememberedValue(value$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(likeReqState, (Function2) value$iv4, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, 1026834517, "CC(remember):DeepSearch.kt#9igjgp");
                it$iv = $composer2.rememberedValue();
                if (it$iv != Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit DeepSearchPage$lambda$4$0;
                            DeepSearchPage$lambda$4$0 = DeepSearchKt.DeepSearchPage$lambda$4$0(DeepSearchViewModel.this, (DeepSearchAction) obj);
                            return DeepSearchPage$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv = value$iv5;
                }
                final Function1 dispatcher = (Function1) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                PageStub_androidKt.PushDetailPageStub(((DeepSearchPageData) data.getValue()).getSessionId(), $composer2, 0);
                CompositionLocal this_$iv3 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume3 = $composer2.consume(this_$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LifecycleOwner lifecycle = (LifecycleOwner) consume3;
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1026842486, "CC(remember):DeepSearch.kt#9igjgp");
                invalid$iv3 = $composer2.changedInstance(lifecycle);
                Object it$iv6 = $composer2.rememberedValue();
                if (!invalid$iv3 && it$iv6 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(unit, (Function2) it$iv6, $composer2, 6);
                    final boolean z = backFromLogin2;
                    BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-2143040274, true, new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DeepSearchPage$lambda$6;
                            DeepSearchPage$lambda$6 = DeepSearchKt.DeepSearchPage$lambda$6(data, dispatcher, toaster, successFeedBack, scope, z, (Composer) obj, ((Integer) obj2).intValue());
                            return DeepSearchPage$lambda$6;
                        }
                    }, $composer2, 54), $composer2, 384, 3);
                    State appVisibleState = DeepSearchPreview_androidKt.rememberAppVisibleState($composer2, 0);
                    Object value = appVisibleState.getValue();
                    ComposerKt.sourceInformationMarkerStart($composer2, 1027083015, "CC(remember):DeepSearch.kt#9igjgp");
                    invalid$iv4 = $composer2.changed(appVisibleState);
                    it$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv4 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = (Function2) new DeepSearchKt$DeepSearchPage$6$1(appVisibleState, dispatcher, null);
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv2 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(value, (Function2) it$iv2, $composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sessionTitle2 = sessionTitle3;
                }
                Object value$iv7 = (Function2) new DeepSearchKt$DeepSearchPage$4$1(lifecycle, dispatcher, null);
                $composer2.updateRememberedValue(value$iv7);
                it$iv6 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit, (Function2) it$iv6, $composer2, 6);
                final boolean z2 = backFromLogin2;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-2143040274, true, new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DeepSearchPage$lambda$6;
                        DeepSearchPage$lambda$6 = DeepSearchKt.DeepSearchPage$lambda$6(data, dispatcher, toaster, successFeedBack, scope, z2, (Composer) obj, ((Integer) obj2).intValue());
                        return DeepSearchPage$lambda$6;
                    }
                }, $composer2, 54), $composer2, 384, 3);
                State appVisibleState2 = DeepSearchPreview_androidKt.rememberAppVisibleState($composer2, 0);
                Object value2 = appVisibleState2.getValue();
                ComposerKt.sourceInformationMarkerStart($composer2, 1027083015, "CC(remember):DeepSearch.kt#9igjgp");
                invalid$iv4 = $composer2.changed(appVisibleState2);
                it$iv2 = $composer2.rememberedValue();
                if (!invalid$iv4) {
                }
                Object value$iv62 = (Function2) new DeepSearchKt$DeepSearchPage$6$1(appVisibleState2, dispatcher, null);
                $composer2.updateRememberedValue(value$iv62);
                it$iv2 = value$iv62;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(value2, (Function2) it$iv2, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                sessionTitle2 = sessionTitle3;
            }
            value$iv = (Function2) new DeepSearchKt$DeepSearchPage$1$1(data, toaster, null);
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(deepSearchToast, (Function2) value$iv, $composer2, 0);
            DeepSearchCopyModel copyModel2 = ((DeepSearchPageData) data.getValue()).getCopyModel();
            ComposerKt.sourceInformationMarkerStart($composer2, 1026807216, "CC(remember):DeepSearch.kt#9igjgp");
            invalid$iv = $composer2.changed(data) | $composer2.changedInstance(clipboardManager2) | $composer2.changedInstance(toaster) | $composer2.changed(successCopy);
            Object it$iv52 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv32 = (Function2) new DeepSearchKt$DeepSearchPage$2$1(data, clipboardManager2, toaster, successCopy, null);
            $composer2.updateRememberedValue(value$iv32);
            it$iv52 = value$iv32;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(copyModel2, (Function2) it$iv52, $composer2, 0);
            RequestState likeReqState2 = ((DeepSearchPageData) data.getValue()).getRequestModel().getLikeReqState();
            ComposerKt.sourceInformationMarkerStart($composer2, 1026818783, "CC(remember):DeepSearch.kt#9igjgp");
            invalid$iv2 = $composer2.changed(data) | $composer2.changedInstance(toaster) | $composer2.changed(successFeedBack);
            DeepSearchKt$DeepSearchPage$3$1 value$iv42 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv42 = new DeepSearchKt$DeepSearchPage$3$1(data, toaster, successFeedBack, null);
            $composer2.updateRememberedValue(value$iv42);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(likeReqState2, (Function2) value$iv42, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1026834517, "CC(remember):DeepSearch.kt#9igjgp");
            it$iv = $composer2.rememberedValue();
            if (it$iv != Composer.Companion.getEmpty()) {
            }
            final Function1 dispatcher2 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PageStub_androidKt.PushDetailPageStub(((DeepSearchPageData) data.getValue()).getSessionId(), $composer2, 0);
            CompositionLocal this_$iv32 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume32 = $composer2.consume(this_$iv32);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycle2 = (LifecycleOwner) consume32;
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1026842486, "CC(remember):DeepSearch.kt#9igjgp");
            invalid$iv3 = $composer2.changedInstance(lifecycle2);
            Object it$iv62 = $composer2.rememberedValue();
            if (!invalid$iv3) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit2, (Function2) it$iv62, $composer2, 6);
                final boolean z22 = backFromLogin2;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-2143040274, true, new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DeepSearchPage$lambda$6;
                        DeepSearchPage$lambda$6 = DeepSearchKt.DeepSearchPage$lambda$6(data, dispatcher2, toaster, successFeedBack, scope, z22, (Composer) obj, ((Integer) obj2).intValue());
                        return DeepSearchPage$lambda$6;
                    }
                }, $composer2, 54), $composer2, 384, 3);
                State appVisibleState22 = DeepSearchPreview_androidKt.rememberAppVisibleState($composer2, 0);
                Object value22 = appVisibleState22.getValue();
                ComposerKt.sourceInformationMarkerStart($composer2, 1027083015, "CC(remember):DeepSearch.kt#9igjgp");
                invalid$iv4 = $composer2.changed(appVisibleState22);
                it$iv2 = $composer2.rememberedValue();
                if (!invalid$iv4) {
                }
                Object value$iv622 = (Function2) new DeepSearchKt$DeepSearchPage$6$1(appVisibleState22, dispatcher2, null);
                $composer2.updateRememberedValue(value$iv622);
                it$iv2 = value$iv622;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(value22, (Function2) it$iv2, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                sessionTitle2 = sessionTitle3;
            }
            Object value$iv72 = (Function2) new DeepSearchKt$DeepSearchPage$4$1(lifecycle2, dispatcher2, null);
            $composer2.updateRememberedValue(value$iv72);
            it$iv62 = value$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv62, $composer2, 6);
            final boolean z222 = backFromLogin2;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-2143040274, true, new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeepSearchPage$lambda$6;
                    DeepSearchPage$lambda$6 = DeepSearchKt.DeepSearchPage$lambda$6(data, dispatcher2, toaster, successFeedBack, scope, z222, (Composer) obj, ((Integer) obj2).intValue());
                    return DeepSearchPage$lambda$6;
                }
            }, $composer2, 54), $composer2, 384, 3);
            State appVisibleState222 = DeepSearchPreview_androidKt.rememberAppVisibleState($composer2, 0);
            Object value222 = appVisibleState222.getValue();
            ComposerKt.sourceInformationMarkerStart($composer2, 1027083015, "CC(remember):DeepSearch.kt#9igjgp");
            invalid$iv4 = $composer2.changed(appVisibleState222);
            it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv4) {
            }
            Object value$iv6222 = (Function2) new DeepSearchKt$DeepSearchPage$6$1(appVisibleState222, dispatcher2, null);
            $composer2.updateRememberedValue(value$iv6222);
            it$iv2 = value$iv6222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(value222, (Function2) it$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            sessionTitle2 = sessionTitle3;
        } else {
            $composer2.skipToGroupEnd();
            sessionQuery2 = str;
            sessionId2 = str2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str6 = sessionQuery2;
            final String str7 = sessionId2;
            final String str8 = sessionTitle2;
            final boolean z3 = backFromLogin2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeepSearchPage$lambda$8;
                    DeepSearchPage$lambda$8 = DeepSearchKt.DeepSearchPage$lambda$8(str6, str7, str8, z3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DeepSearchPage$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchPage$lambda$4$0(DeepSearchViewModel $viewModel, DeepSearchAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.dispatch(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0944  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0737  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x089b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x089d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x08c3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x08dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit DeepSearchPage$lambda$6(final State $data, final Function1 $dispatcher, final Toaster $toaster, final String $successFeedBack, final CoroutineScope $scope, boolean $backFromLogin, Composer $composer, int $changed) {
        String str;
        Modifier $this$DeepSearchPage_u24lambda_u246_u245_u241;
        Modifier modifier;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        final LazyListState state;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        Object it$iv$iv;
        Object it$iv;
        boolean invalid$iv;
        Object it$iv2;
        ComposerKt.sourceInformation($composer, "C234@8847L13,235@8892L21,236@8945L34,237@9000L23,238@9049L12,239@9113L501,239@9070L544,256@9693L110,254@9629L174,262@9840L7,264@9857L5302,390@15168L198,406@15751L209,397@15391L580:DeepSearch.kt#7uvpm4");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2143040274, $changed, -1, "kntr.app.deepsearch.ui.DeepSearchPage.<anonymous> (DeepSearch.kt:234)");
            }
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            WindowConfig(isNight, $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, 2122603024, "CC(remember):DeepSearch.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv3 = value$iv;
            }
            MutableState isShowingDialog$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyListState state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
            boolean imeVisible = ImeVisibleKt.imeVisible($composer, 0);
            DeepSearchTreadPopContent treadPopContent = ((DeepSearchPageData) $data.getValue()).getTreadPopContent();
            ComposerKt.sourceInformationMarkerStart($composer, 2122608867, "CC(remember):DeepSearch.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($data) | $composer.changed(imeVisible);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new DeepSearchKt$DeepSearchPage$5$1$1($data, imeVisible, isShowingDialog$delegate, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv4 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(treadPopContent, (Function2) it$iv4, $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, 2122627036, "CC(remember):DeepSearch.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function1) new DeepSearchKt$DeepSearchPage$5$2$1($dispatcher, null);
                $composer.updateRememberedValue(value$iv3);
                it$iv5 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LoadMoreListStateKt.applyLoadMoreBackwardEffects(state2, 5, (Function1) null, (Function1) it$iv5, $composer, 48, 2);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density = (Density) consume;
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
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
                $composer.createNode(factory$iv$iv$iv3);
            } else {
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
            int i2 = ((6 >> 6) & 112) | 6;
            BoxScope $this$DeepSearchPage_u24lambda_u246_u245 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1000761656, "C265@9910L102,285@10753L10,269@10026L5123:DeepSearch.kt#7uvpm4");
            BackgroundKt.Background($this$DeepSearchPage_u24lambda_u246_u245.align(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getTopStart()), $composer, 0, 0);
            $composer.startReplaceGroup(1140671671);
            ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
            $composer.startReplaceGroup(1140662885);
            ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
            Modifier modifier2 = Modifier.Companion;
            if (imeVisible) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
                $composer.startReplaceGroup(-1840128246);
                $composer.endReplaceGroup();
                $this$DeepSearchPage_u24lambda_u246_u245_u241 = modifier2;
            } else {
                $composer.startReplaceGroup(-1840248743);
                ComposerKt.sourceInformation($composer, "274@10243L14");
                str = RoomRecommendViewModel.EMPTY_CURSOR;
                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(modifier2, WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer, 6));
                $composer.endReplaceGroup();
                $this$DeepSearchPage_u24lambda_u246_u245_u241 = windowInsetsPadding;
            }
            $composer.endReplaceGroup();
            if (DeepSearchPage$lambda$6$1(isShowingDialog$delegate)) {
                $composer.startReplaceGroup(-26798961);
                $composer.endReplaceGroup();
                modifier = $this$DeepSearchPage_u24lambda_u246_u245_u241;
            } else {
                $composer.startReplaceGroup(-26936756);
                ComposerKt.sourceInformation($composer, "*280@10517L14");
                modifier = PaddingKt.padding-qDBjuR0$default($this$DeepSearchPage_u24lambda_u246_u245_u241, 0.0f, 0.0f, 0.0f, density.toDp-u2uoSUM(DeepSearchPreview_androidKt.getImeHeight($composer, 0).getIntValue()), 7, (Object) null);
                $composer.endReplaceGroup();
            }
            $composer.endReplaceGroup();
            Modifier modifier$iv2 = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, (Object) null), WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer, 6));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$DeepSearchPage_u24lambda_u246_u245_u242 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1507263432, "C287@10798L192,294@11053L790,313@11912L1649,359@13797L113,354@13579L754,371@14379L7,372@14454L14,374@14609L7,376@14654L481:DeepSearch.kt#7uvpm4");
            String str2 = str;
            DeepSearchTopBarKt.DeepSearchTopBar(((DeepSearchPageData) $data.getValue()).getSessionId(), ((DeepSearchPageData) $data.getValue()).getPageChatState(), null, $dispatcher, $composer, 3072, 4);
            ComposerKt.sourceInformationMarkerStart($composer, -2029583968, "CC(remember):DeepSearch.kt#9igjgp");
            Object it$iv6 = $composer.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                $composer$iv$iv$iv = $composer;
                state = state2;
                Object value$iv4 = new Function1() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit DeepSearchPage$lambda$6$5$2$0$0;
                        DeepSearchPage$lambda$6$5$2$0$0 = DeepSearchKt.DeepSearchPage$lambda$6$5$2$0$0($data, state, $scope, $dispatcher, (DeepSearchAction.InputAction) obj);
                        return DeepSearchPage$lambda$6$5$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv6 = value$iv4;
            } else {
                $composer$iv$iv$iv = $composer;
                state = state2;
            }
            final Function1 inputActionHandler = (Function1) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            boolean showAiHint = !imeVisible;
            Modifier modifier$iv3 = ColumnScope.-CC.weight$default($this$DeepSearchPage_u24lambda_u246_u245_u242, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$DeepSearchPage_u24lambda_u246_u245_u242_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1739573123, "C314@12028L7,316@12109L125,330@12664L436,321@12256L1036,345@13332L24,347@13378L165:DeepSearch.kt#7uvpm4");
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SoftwareKeyboardController soft = (SoftwareKeyboardController) consume2;
            DeepSearchContentList list = ((DeepSearchPageData) $data.getValue()).getList();
            KeepBottomEffectKt.keepBottom(state, list, $backFromLogin, $composer, 0);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Boolean valueOf = Boolean.valueOf(((DeepSearchPageData) $data.getValue()).getInputState().getInput().length() > 0);
            ComposerKt.sourceInformationMarkerStart($composer, 82452676, "CC(remember):DeepSearch.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed(soft);
            Object it$iv7 = $composer.rememberedValue();
            if (invalid$iv3) {
                $composer$iv = $composer;
            } else {
                $composer$iv = $composer;
                if (it$iv7 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ContentListKt.ContentList(list, state, $dispatcher, ((DeepSearchPageData) $data.getValue()).getSessionId(), ((DeepSearchPageData) $data.getValue()).getPageChatState(), SuspendingPointerInputFilterKt.pointerInput(fillMaxSize$default, valueOf, (PointerInputEventHandler) it$iv7), $composer, 384, 0);
                    ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
                    it$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                        $composer.updateRememberedValue(value$iv$iv);
                        it$iv$iv = value$iv$iv;
                    }
                    CoroutineScope scrollScope = (CoroutineScope) it$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    GoToEndKt.GoToEnd($this$DeepSearchPage_u24lambda_u246_u245_u242_u241, state, scrollScope, Modifier.Companion, $composer, ($changed2 & 14) | 3072, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    boolean DeepSearchPage$lambda$6$1 = DeepSearchPage$lambda$6$1(isShowingDialog$delegate);
                    InputState inputState = ((DeepSearchPageData) $data.getValue()).getInputState();
                    Modifier modifier3 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer, -2029496837, "CC(remember):DeepSearch.kt#9igjgp");
                    it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit DeepSearchPage$lambda$6$5$2$2$0;
                                DeepSearchPage$lambda$6$5$2$2$0 = DeepSearchKt.DeepSearchPage$lambda$6$5$2$2$0(inputActionHandler);
                                return DeepSearchPage$lambda$6$5$2$2$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv5);
                        it$iv = value$iv5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    InputKt.Input(DeepSearchPage$lambda$6$1, inputState, ((DeepSearchPageData) $data.getValue()).getPageStyle(), PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), !showAiHint ? Dp.constructor-impl(8) : Dp.constructor-impl(12)), inputActionHandler, $composer, 24576, 0);
                    CompositionLocal this_$iv3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer.consume(this_$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density $this$DeepSearchPage_u24lambda_u246_u245_u242_u243 = (Density) consume3;
                    float most = RangesKt.coerceAtLeast($this$DeepSearchPage_u24lambda_u246_u245_u242_u243.toPx-0680j_4(Dp.constructor-impl(14)), 1.0f);
                    float covered = RangesKt.coerceIn(DeepSearchPreview_androidKt.getImeHeight($composer, 0).getIntValue(), 0.0f, most);
                    float progress = 1.0f - (covered / most);
                    CompositionLocal this_$iv4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer.consume(this_$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Density $this$DeepSearchPage_u24lambda_u246_u245_u242_u244 = (Density) consume4;
                    float coveredDp = $this$DeepSearchPage_u24lambda_u246_u245_u242_u244.toDp-u2uoSUM(covered);
                    AIHintKt.AIHint(progress, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(0), Dp.constructor-impl(12), Dp.constructor-impl(5)), 0.0f, 1, (Object) null), RangesKt.coerceAtLeast(Dp.box-impl(Dp.constructor-impl(Dp.constructor-impl(14) - coveredDp)), Dp.box-impl(Dp.constructor-impl(0))).unbox-impl()), $composer, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ThinkingDialogKt.ThinkingDialog(((DeepSearchPageData) $data.getValue()).getThinkPopContent() == null, $dispatcher, (DeepSearchPageData) $data.getValue(), Modifier.Companion, $composer, 3120, 0);
                    boolean z = ((DeepSearchPageData) $data.getValue()).getTreadPopContent() == null;
                    Modifier modifier4 = Modifier.Companion;
                    DeepSearchTreadPopContent treadPopContent2 = ((DeepSearchPageData) $data.getValue()).getTreadPopContent();
                    String queryId = treadPopContent2 != null ? treadPopContent2.getQueryId() : null;
                    String str3 = queryId != null ? str2 : queryId;
                    TextConfigModel textConfigModel = ((DeepSearchPageData) $data.getValue()).getTextConfigModel();
                    ComposerKt.sourceInformationMarkerStart($composer, 2122820991, "CC(remember):DeepSearch.kt#9igjgp");
                    invalid$iv = $composer.changedInstance($toaster) | $composer.changed($successFeedBack);
                    it$iv2 = $composer.rememberedValue();
                    if (!invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit DeepSearchPage$lambda$6$6$0;
                                DeepSearchPage$lambda$6$6$0 = DeepSearchKt.DeepSearchPage$lambda$6$6$0($dispatcher, $toaster, $successFeedBack);
                                return DeepSearchPage$lambda$6$6$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv6);
                        it$iv2 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    FeedBackDialogKt.FeedBackDialog(z, $dispatcher, (Function0) it$iv2, str3, textConfigModel, modifier4, $composer, 196656, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            Object value$iv7 = (PointerInputEventHandler) new DeepSearchKt$DeepSearchPage$5$3$3$1$1$1(soft);
            $composer.updateRememberedValue(value$iv7);
            it$iv7 = value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ContentListKt.ContentList(list, state, $dispatcher, ((DeepSearchPageData) $data.getValue()).getSessionId(), ((DeepSearchPageData) $data.getValue()).getPageChatState(), SuspendingPointerInputFilterKt.pointerInput(fillMaxSize$default, valueOf, (PointerInputEventHandler) it$iv7), $composer, 384, 0);
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
            }
            CoroutineScope scrollScope2 = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            GoToEndKt.GoToEnd($this$DeepSearchPage_u24lambda_u246_u245_u242_u241, state, scrollScope2, Modifier.Companion, $composer, ($changed2 & 14) | 3072, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            boolean DeepSearchPage$lambda$6$12 = DeepSearchPage$lambda$6$1(isShowingDialog$delegate);
            InputState inputState2 = ((DeepSearchPageData) $data.getValue()).getInputState();
            Modifier modifier32 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -2029496837, "CC(remember):DeepSearch.kt#9igjgp");
            it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            InputKt.Input(DeepSearchPage$lambda$6$12, inputState2, ((DeepSearchPageData) $data.getValue()).getPageStyle(), PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(modifier32, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), !showAiHint ? Dp.constructor-impl(8) : Dp.constructor-impl(12)), inputActionHandler, $composer, 24576, 0);
            CompositionLocal this_$iv32 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume32 = $composer.consume(this_$iv32);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$DeepSearchPage_u24lambda_u246_u245_u242_u2432 = (Density) consume32;
            float most2 = RangesKt.coerceAtLeast($this$DeepSearchPage_u24lambda_u246_u245_u242_u2432.toPx-0680j_4(Dp.constructor-impl(14)), 1.0f);
            float covered2 = RangesKt.coerceIn(DeepSearchPreview_androidKt.getImeHeight($composer, 0).getIntValue(), 0.0f, most2);
            float progress2 = 1.0f - (covered2 / most2);
            CompositionLocal this_$iv42 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume42 = $composer.consume(this_$iv42);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$DeepSearchPage_u24lambda_u246_u245_u242_u2442 = (Density) consume42;
            float coveredDp2 = $this$DeepSearchPage_u24lambda_u246_u245_u242_u2442.toDp-u2uoSUM(covered2);
            AIHintKt.AIHint(progress2, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(0), Dp.constructor-impl(12), Dp.constructor-impl(5)), 0.0f, 1, (Object) null), RangesKt.coerceAtLeast(Dp.box-impl(Dp.constructor-impl(Dp.constructor-impl(14) - coveredDp2)), Dp.box-impl(Dp.constructor-impl(0))).unbox-impl()), $composer, 0, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ThinkingDialogKt.ThinkingDialog(((DeepSearchPageData) $data.getValue()).getThinkPopContent() == null, $dispatcher, (DeepSearchPageData) $data.getValue(), Modifier.Companion, $composer, 3120, 0);
            if (((DeepSearchPageData) $data.getValue()).getTreadPopContent() == null) {
            }
            Modifier modifier42 = Modifier.Companion;
            DeepSearchTreadPopContent treadPopContent22 = ((DeepSearchPageData) $data.getValue()).getTreadPopContent();
            if (treadPopContent22 != null) {
            }
            if (queryId != null) {
            }
            TextConfigModel textConfigModel2 = ((DeepSearchPageData) $data.getValue()).getTextConfigModel();
            ComposerKt.sourceInformationMarkerStart($composer, 2122820991, "CC(remember):DeepSearch.kt#9igjgp");
            invalid$iv = $composer.changedInstance($toaster) | $composer.changed($successFeedBack);
            it$iv2 = $composer.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv62 = new Function0() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit DeepSearchPage$lambda$6$6$0;
                    DeepSearchPage$lambda$6$6$0 = DeepSearchKt.DeepSearchPage$lambda$6$6$0($dispatcher, $toaster, $successFeedBack);
                    return DeepSearchPage$lambda$6$6$0;
                }
            };
            $composer.updateRememberedValue(value$iv62);
            it$iv2 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer);
            FeedBackDialogKt.FeedBackDialog(z, $dispatcher, (Function0) it$iv2, str3, textConfigModel2, modifier42, $composer, 196656, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DeepSearchPage$lambda$6$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DeepSearchPage$lambda$6$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchPage$lambda$6$5$2$0$0(State $data, LazyListState $state, CoroutineScope $scope, Function1 $dispatcher, DeepSearchAction.InputAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof DeepSearchAction.InputAction.SenderClick) {
            InputState inputState = ((DeepSearchPageData) $data.getValue()).getInputState();
            if (inputState.getSenderStatus() == SenderStatus.SEND_ALLOW && $state.getCanScrollForward()) {
                BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new DeepSearchKt$DeepSearchPage$5$3$3$inputActionHandler$1$1$1($state, null), 3, (Object) null);
            }
        }
        $dispatcher.invoke(action);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchPage$lambda$6$5$2$2$0(Function1 $inputActionHandler) {
        $inputActionHandler.invoke(DeepSearchAction.InputAction.InputClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeepSearchPage$lambda$6$6$0(Function1 $dispatcher, Toaster $toaster, String $successFeedBack) {
        $dispatcher.invoke(DeepSearchAction.TreadPopViewAction.TreadPopViewHidden.INSTANCE);
        $toaster.showToast($successFeedBack, ToastDuration.Short);
        return Unit.INSTANCE;
    }

    private static final void WindowConfig(final boolean isNight, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1440924502);
        ComposerKt.sourceInformation($composer2, "C(WindowConfig)N(isNight)428@16395L169:DeepSearch.kt#7uvpm4");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isNight) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1440924502, $dirty, -1, "kntr.app.deepsearch.ui.WindowConfig (DeepSearch.kt:427)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1441700542, "CC(ConfigWindow)N(block)31@1201L7:DeepSearchPreview.android.kt#7uvpm4");
            CompositionLocal this_$iv$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Activity activity$iv = ContextUtilKt.findActivityOrNull((Context) consume);
            if (Build.VERSION.SDK_INT >= 30 || activity$iv == null) {
                $composer2.startReplaceGroup(28421133);
                ComposerKt.sourceInformation($composer2, "40@1667L7");
                boolean z = false & true;
                ComposerKt.sourceInformationMarkerStart($composer2, -1617915506, "C429@16435L28,430@16496L62,430@16472L86:DeepSearch.kt#7uvpm4");
                SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer2, 0);
                Boolean valueOf = Boolean.valueOf(isNight);
                ComposerKt.sourceInformationMarkerStart($composer2, -190735737, "CC(remember):DeepSearch.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(controller) | (($dirty & 14) == 4);
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer2, $dirty & 14);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                }
                Object value$iv = (Function2) new DeepSearchKt$WindowConfig$1$1$1(controller, isNight, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer2, $dirty & 14);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(28068508);
                ComposerKt.sourceInformation($composer2, "33@1325L13,34@1394L251,34@1370L275");
                boolean isNight$iv = BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable) == ThemeDayNight.Night;
                Boolean valueOf2 = Boolean.valueOf(isNight$iv);
                ComposerKt.sourceInformationMarkerStart($composer2, -1800206695, "CC(remember):DeepSearchPreview.android.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changedInstance(activity$iv) | $composer2.changed(isNight$iv);
                Object it$iv$iv = $composer2.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                    Object value$iv$iv = (Function2) new DeepSearchPreview_androidKt$ConfigWindow$1$1(activity$iv, isNight$iv, null);
                    $composer2.updateRememberedValue(value$iv$iv);
                    it$iv$iv = value$iv$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv$iv, $composer2, 0);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.DeepSearchKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit WindowConfig$lambda$1;
                    WindowConfig$lambda$1 = DeepSearchKt.WindowConfig$lambda$1(isNight, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return WindowConfig$lambda$1;
                }
            });
        }
    }
}