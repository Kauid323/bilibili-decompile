package kntr.app.tribee.search;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.tribee.search.base.TribeeSearchPageStatusKt;
import kntr.app.tribee.search.base.TribeeSearchTopBarKt;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.page.TribeeSearchEmptyPageContentKt;
import kntr.app.tribee.search.page.TribeeSearchFindPageContentKt;
import kntr.app.tribee.search.page.TribeeSearchResultPageContentKt;
import kntr.app.tribee.search.state.SearchBarState;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.tribee.search.track.SearchTrackerKt;
import kntr.app.tribee.search.viewModels.TribeeSearchViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TribeeSearchPage.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001aS\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2 = {"TribeeSearchPage", "", "tribeeId", "", "keyword", "hint", "globalSearchUri", "enableHistory", "from", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "search_debug", "state", "Lkntr/app/tribee/search/state/TribeeSearchState;", "needFocus", "", "isFromFindPage"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchPageKt {

    /* compiled from: TribeeSearchPage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchPage$lambda$15(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, Composer composer, int i3) {
        TribeeSearchPage(str, str2, str3, str4, str5, str6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x02de, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0332, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x037b, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03e2, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x044f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSearchPage(final String tribeeId, String keyword, String hint, String globalSearchUri, String enableHistory, String from, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        String enableHistory2;
        String from2;
        String globalSearchUri2;
        String keyword2;
        String hint2;
        boolean invalid$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        boolean invalid$iv4;
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Composer $composer2 = $composer.startRestartGroup(-3438625);
        ComposerKt.sourceInformation($composer2, "C(TribeeSearchPage)N(tribeeId,keyword,hint,globalSearchUri,enableHistory,from)74@3071L268,83@3387L86,86@3501L16,87@3547L7,88@3596L7,89@3638L29,90@3689L34,91@3750L35,92@3831L7,93@3865L76,96@3993L7,99@4060L241,99@4029L272,109@4365L645,109@4332L678,131@5061L280,131@5035L306,143@5418L376,143@5361L433,157@5810L3175,157@5800L3185:TribeeSearchPage.kt#yi4umz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(tribeeId) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            str = keyword;
        } else if (($changed & 48) == 0) {
            str = keyword;
            $dirty |= $composer2.changed(str) ? 32 : 16;
        } else {
            str = keyword;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            str2 = hint;
        } else if (($changed & 384) == 0) {
            str2 = hint;
            $dirty |= $composer2.changed(str2) ? 256 : 128;
        } else {
            str2 = hint;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(globalSearchUri) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            enableHistory2 = enableHistory;
        } else if (($changed & 24576) == 0) {
            enableHistory2 = enableHistory;
            $dirty |= $composer2.changed(enableHistory2) ? 16384 : 8192;
        } else {
            enableHistory2 = enableHistory;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            from2 = from;
        } else if (($changed & 196608) == 0) {
            from2 = from;
            $dirty |= $composer2.changed(from2) ? 131072 : 65536;
        } else {
            from2 = from;
        }
        if ($composer2.shouldExecute(($dirty & 74899) != 74898, $dirty & 1)) {
            if (i2 != 0) {
                keyword2 = null;
            } else {
                keyword2 = str;
            }
            if (i3 == 0) {
                hint2 = str2;
            } else {
                hint2 = null;
            }
            if (i4 == 0) {
                globalSearchUri2 = globalSearchUri;
            } else {
                globalSearchUri2 = null;
            }
            if (i5 != 0) {
                enableHistory2 = null;
            }
            if (i6 != 0) {
                from2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-3438625, $dirty, -1, "kntr.app.tribee.search.TribeeSearchPage (TribeeSearchPage.kt:72)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 990467371, "CC(remember):TribeeSearchPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new TribeeSearchViewModel(keyword2, tribeeId, hint2, globalSearchUri2, enableHistory2);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final TribeeSearchViewModel viewModel = (TribeeSearchViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 990477301, "CC(remember):TribeeSearchPage.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changedInstance(viewModel);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit TribeeSearchPage$lambda$1$0;
                        TribeeSearchPage$lambda$1$0 = TribeeSearchPageKt.TribeeSearchPage$lambda$1$0(TribeeSearchViewModel.this, (TribeeSearchEvent) obj);
                        return TribeeSearchPage$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final Function1 onEvent = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State state$delegate = viewModel.collectAsState($composer2, 0);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FocusManager focusManager = (FocusManager) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 990485276, "CC(remember):TribeeSearchPage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new FocusRequester();
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final FocusRequester searchBarFocusRequester = (FocusRequester) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 990486913, "CC(remember):TribeeSearchPage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState needFocus$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 990488866, "CC(remember):TribeeSearchPage.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = (Set) new LinkedHashSet();
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final Set exposedKeywords = (Set) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv3 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume3;
            ComposerKt.sourceInformationMarkerStart($composer2, 990492587, "CC(remember):TribeeSearchPage.kt#9igjgp");
            boolean invalid$iv6 = (458752 & $dirty) == 131072;
            Object it$iv6 = $composer2.rememberedValue();
            if (!invalid$iv6 && it$iv6 != Composer.Companion.getEmpty()) {
                MutableState isFromFindPage$delegate = (MutableState) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
                ComposerKt.sourceInformationMarkerStart($composer2, 990498992, "CC(remember):TribeeSearchPage.kt#9igjgp");
                invalid$iv = $composer2.changedInstance(lifecycleOwner) | $composer2.changed(state$delegate) | $composer2.changed(onEvent);
                Object it$iv7 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv6 = (Function2) new TribeeSearchPageKt$TribeeSearchPage$1$1(lifecycleOwner, onEvent, state$delegate, needFocus$delegate, null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv7 = value$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(lifecycleOwner, (Function2) it$iv7, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, 990509156, "CC(remember):TribeeSearchPage.kt#9igjgp");
                invalid$iv2 = $composer2.changed(state$delegate) | $composer2.changedInstance(exposedKeywords) | $composer2.changedInstance(lifecycleOwner);
                Object it$iv8 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv7 = new Function1() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        DisposableEffectResult TribeeSearchPage$lambda$11$0;
                        TribeeSearchPage$lambda$11$0 = TribeeSearchPageKt.TribeeSearchPage$lambda$11$0(lifecycleOwner, exposedKeywords, state$delegate, needFocus$delegate, (DisposableEffectScope) obj);
                        return TribeeSearchPage$lambda$11$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
                it$iv8 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.DisposableEffect(lifecycleOwner, (Function1) it$iv8, $composer2, 0);
                Boolean valueOf = Boolean.valueOf(TribeeSearchPage$lambda$5(needFocus$delegate));
                ComposerKt.sourceInformationMarkerStart($composer2, 990531063, "CC(remember):TribeeSearchPage.kt#9igjgp");
                invalid$iv3 = $composer2.changed(state$delegate) | $composer2.changedInstance(focusManager);
                Object it$iv9 = $composer2.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv8 = (Function2) new TribeeSearchPageKt$TribeeSearchPage$3$1(searchBarFocusRequester, focusManager, state$delegate, needFocus$delegate, null);
                $composer2.updateRememberedValue(value$iv8);
                it$iv9 = value$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv9, $composer2, 0);
                CharSequence text = TribeeSearchPage$lambda$2(state$delegate).getSearchBarState().getTextFieldState().getText();
                ComposerKt.sourceInformationMarkerStart($composer2, 990542583, "CC(remember):TribeeSearchPage.kt#9igjgp");
                invalid$iv4 = $composer2.changed(state$delegate) | $composer2.changed(isFromFindPage$delegate) | $composer2.changedInstance(backHandler) | $composer2.changedInstance(viewModel);
                Object it$iv10 = $composer2.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv9 = (Function2) new TribeeSearchPageKt$TribeeSearchPage$4$1(backHandler, viewModel, state$delegate, isFromFindPage$delegate, null);
                $composer2.updateRememberedValue(value$iv9);
                it$iv10 = value$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(text, (Function2) it$iv10, $composer2, 0);
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1988653975, true, new Function2() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TribeeSearchPage$lambda$14;
                        TribeeSearchPage$lambda$14 = TribeeSearchPageKt.TribeeSearchPage$lambda$14(TribeeSearchViewModel.this, router, state$delegate, onEvent, searchBarFocusRequester, exposedKeywords, tribeeId, (Composer) obj, ((Integer) obj2).intValue());
                        return TribeeSearchPage$lambda$14;
                    }
                }, $composer2, 54), $composer2, 384, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv10 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(Intrinsics.areEqual(from2, SearchTrackerKt.SEARCH_DISCOVER_SPMID)), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer2.updateRememberedValue(value$iv10);
            it$iv6 = value$iv10;
            MutableState isFromFindPage$delegate2 = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            OnBackPressedDispatcher backHandler2 = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, 990498992, "CC(remember):TribeeSearchPage.kt#9igjgp");
            invalid$iv = $composer2.changedInstance(lifecycleOwner) | $composer2.changed(state$delegate) | $composer2.changed(onEvent);
            Object it$iv72 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv62 = (Function2) new TribeeSearchPageKt$TribeeSearchPage$1$1(lifecycleOwner, onEvent, state$delegate, needFocus$delegate, null);
            $composer2.updateRememberedValue(value$iv62);
            it$iv72 = value$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(lifecycleOwner, (Function2) it$iv72, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 990509156, "CC(remember):TribeeSearchPage.kt#9igjgp");
            invalid$iv2 = $composer2.changed(state$delegate) | $composer2.changedInstance(exposedKeywords) | $composer2.changedInstance(lifecycleOwner);
            Object it$iv82 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv72 = new Function1() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    DisposableEffectResult TribeeSearchPage$lambda$11$0;
                    TribeeSearchPage$lambda$11$0 = TribeeSearchPageKt.TribeeSearchPage$lambda$11$0(lifecycleOwner, exposedKeywords, state$delegate, needFocus$delegate, (DisposableEffectScope) obj);
                    return TribeeSearchPage$lambda$11$0;
                }
            };
            $composer2.updateRememberedValue(value$iv72);
            it$iv82 = value$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) it$iv82, $composer2, 0);
            Boolean valueOf2 = Boolean.valueOf(TribeeSearchPage$lambda$5(needFocus$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, 990531063, "CC(remember):TribeeSearchPage.kt#9igjgp");
            invalid$iv3 = $composer2.changed(state$delegate) | $composer2.changedInstance(focusManager);
            Object it$iv92 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv82 = (Function2) new TribeeSearchPageKt$TribeeSearchPage$3$1(searchBarFocusRequester, focusManager, state$delegate, needFocus$delegate, null);
            $composer2.updateRememberedValue(value$iv82);
            it$iv92 = value$iv82;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv92, $composer2, 0);
            CharSequence text2 = TribeeSearchPage$lambda$2(state$delegate).getSearchBarState().getTextFieldState().getText();
            ComposerKt.sourceInformationMarkerStart($composer2, 990542583, "CC(remember):TribeeSearchPage.kt#9igjgp");
            invalid$iv4 = $composer2.changed(state$delegate) | $composer2.changed(isFromFindPage$delegate2) | $composer2.changedInstance(backHandler2) | $composer2.changedInstance(viewModel);
            Object it$iv102 = $composer2.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv92 = (Function2) new TribeeSearchPageKt$TribeeSearchPage$4$1(backHandler2, viewModel, state$delegate, isFromFindPage$delegate2, null);
            $composer2.updateRememberedValue(value$iv92);
            it$iv102 = value$iv92;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(text2, (Function2) it$iv102, $composer2, 0);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1988653975, true, new Function2() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchPage$lambda$14;
                    TribeeSearchPage$lambda$14 = TribeeSearchPageKt.TribeeSearchPage$lambda$14(TribeeSearchViewModel.this, router, state$delegate, onEvent, searchBarFocusRequester, exposedKeywords, tribeeId, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchPage$lambda$14;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
            globalSearchUri2 = globalSearchUri;
            keyword2 = str;
            hint2 = str2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str3 = keyword2;
            final String str4 = hint2;
            final String str5 = globalSearchUri2;
            final String str6 = enableHistory2;
            final String str7 = from2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchPage$lambda$15;
                    TribeeSearchPage$lambda$15 = TribeeSearchPageKt.TribeeSearchPage$lambda$15(tribeeId, str3, str4, str5, str6, str7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchPage$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchPage$lambda$1$0(TribeeSearchViewModel $viewModel, TribeeSearchEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope($viewModel), (CoroutineContext) null, (CoroutineStart) null, new TribeeSearchPageKt$TribeeSearchPage$onEvent$1$1$1($viewModel, event, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSearchState TribeeSearchPage$lambda$2(State<? extends TribeeSearchState> state) {
        Object thisObj$iv = state.getValue();
        return (TribeeSearchState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeSearchPage$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeeSearchPage$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeSearchPage$lambda$9(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult TribeeSearchPage$lambda$11$0(final LifecycleOwner $lifecycleOwner, final Set $exposedKeywords, final State $state$delegate, final MutableState $needFocus$delegate, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda4
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                TribeeSearchPageKt.TribeeSearchPage$lambda$11$0$0($exposedKeywords, $state$delegate, $needFocus$delegate, lifecycleOwner, event);
            }
        };
        $lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
        return new DisposableEffectResult() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$lambda$11$0$$inlined$onDispose$1
            public void dispose() {
                $lifecycleOwner.getLifecycle().removeObserver(lifecycleObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeeSearchPage$lambda$11$0$0(Set $exposedKeywords, State $state$delegate, MutableState $needFocus$delegate, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
            case 2:
                if (TribeeSearchPage$lambda$2($state$delegate) instanceof TribeeSearchState.Find) {
                    TribeeSearchPage$lambda$6($needFocus$delegate, false);
                    $exposedKeywords.clear();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchPage$lambda$14(TribeeSearchViewModel $viewModel, Router $router, final State $state$delegate, final Function1 $onEvent, final FocusRequester $searchBarFocusRequester, final Set $exposedKeywords, final String $tribeeId, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C158@5839L28,159@5900L13,162@6021L64,162@5997L88,166@6116L254,166@6095L275,178@6458L536,192@7035L6,193@7057L1922,176@6380L2599:TribeeSearchPage.kt#yi4umz");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1988653975, $changed, -1, "kntr.app.tribee.search.TribeeSearchPage.<anonymous> (TribeeSearchPage.kt:158)");
            }
            SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            final Ref.ObjectRef pvEventTrigger = new Ref.ObjectRef();
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, -163969929, "CC(remember):TribeeSearchPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(uiController) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeeSearchPageKt$TribeeSearchPage$5$1$1(uiController, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -163966699, "CC(remember):TribeeSearchPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($viewModel) | $composer.changedInstance($router);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new TribeeSearchPageKt$TribeeSearchPage$5$2$1($viewModel, $router, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
            ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ComposableLambdaKt.rememberComposableLambda(-1119172781, true, new Function2() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchPage$lambda$14$2;
                    TribeeSearchPage$lambda$14$2 = TribeeSearchPageKt.TribeeSearchPage$lambda$14$2($state$delegate, $onEvent, $searchBarFocusRequester, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchPage$lambda$14$2;
                }
            }, $composer, 54), (Function2) null, (Function2) null, (Function2) null, 0, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-163303960, true, new Function3() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeSearchPage$lambda$14$3;
                    TribeeSearchPage$lambda$14$3 = TribeeSearchPageKt.TribeeSearchPage$lambda$14$3($onEvent, $exposedKeywords, pvEventTrigger, $state$delegate, $tribeeId, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeSearchPage$lambda$14$3;
                }
            }, $composer, 54), $composer, 805306422, 444);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchPage$lambda$14$2(final State $state$delegate, final Function1 $onEvent, FocusRequester $searchBarFocusRequester, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C182@6621L157,186@6810L89,179@6476L504:TribeeSearchPage.kt#yi4umz");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119172781, $changed, -1, "kntr.app.tribee.search.TribeeSearchPage.<anonymous>.<anonymous> (TribeeSearchPage.kt:179)");
            }
            TribeeSearchState TribeeSearchPage$lambda$2 = TribeeSearchPage$lambda$2($state$delegate);
            SearchBarState searchBarState = TribeeSearchPage$lambda$2($state$delegate).getSearchBarState();
            ComposerKt.sourceInformationMarkerStart($composer, -1783213168, "CC(remember):TribeeSearchPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($state$delegate) | $composer.changed($onEvent);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit TribeeSearchPage$lambda$14$2$0$0;
                        TribeeSearchPage$lambda$14$2$0$0 = TribeeSearchPageKt.TribeeSearchPage$lambda$14$2$0$0($onEvent, $state$delegate);
                        return TribeeSearchPage$lambda$14$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1783207188, "CC(remember):TribeeSearchPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onEvent);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TribeeSearchPage$lambda$14$2$1$0;
                        TribeeSearchPage$lambda$14$2$1$0 = TribeeSearchPageKt.TribeeSearchPage$lambda$14$2$1$0($onEvent);
                        return TribeeSearchPage$lambda$14$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeeSearchTopBarKt.TribeeSearchTopBar(TribeeSearchPage$lambda$2, searchBarState, function0, null, null, (Function0) it$iv2, $searchBarFocusRequester, $composer, 1572864, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchPage$lambda$14$2$0$0(Function1 $onEvent, State $state$delegate) {
        String keyword = TribeeSearchPage$lambda$2($state$delegate).getSearchBarState().getQuery();
        $onEvent.invoke(new TribeeSearchEvent.DoSearch(keyword));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchPage$lambda$14$2$1$0(Function1 $onEvent) {
        $onEvent.invoke(TribeeSearchEvent.ClearQueryText.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchPage$lambda$14$3(Function1 $onEvent, final Set $exposedKeywords, Ref.ObjectRef $pvEventTrigger, State $state$delegate, String $tribeeId, PaddingValues paddingValues, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation($composer, "CN(paddingValues)226@8523L446:TribeeSearchPage.kt#yi4umz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(paddingValues) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-163303960, $dirty2, -1, "kntr.app.tribee.search.TribeeSearchPage.<anonymous>.<anonymous> (TribeeSearchPage.kt:194)");
            }
            TribeeSearchState tmp = TribeeSearchPage$lambda$2($state$delegate);
            if (tmp instanceof TribeeSearchState.Find) {
                $composer.startReplaceGroup(1978688579);
                ComposerKt.sourceInformation($composer, "200@7391L79,196@7178L315");
                TribeeSearchState.Find find = (TribeeSearchState.Find) tmp;
                Modifier padding = PaddingKt.padding(Modifier.Companion, paddingValues);
                ComposerKt.sourceInformationMarkerStart($composer, 1978695159, "CC(remember):TribeeSearchPage.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($exposedKeywords);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            boolean TribeeSearchPage$lambda$14$3$0$0;
                            TribeeSearchPage$lambda$14$3$0$0 = TribeeSearchPageKt.TribeeSearchPage$lambda$14$3$0$0($exposedKeywords, (String) obj);
                            return Boolean.valueOf(TribeeSearchPage$lambda$14$3$0$0);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeSearchFindPageContentKt.TribeeSearchFindPageContent(find, $onEvent, padding, (Function1) it$iv, $composer, 0, 0);
                $composer.endReplaceGroup();
            } else if (tmp instanceof TribeeSearchState.Result.Loading) {
                $composer.startReplaceGroup(1978700839);
                ComposerKt.sourceInformation($composer, "205@7569L63");
                TribeeSearchPageStatusKt.TribeeSearchLoading(PaddingKt.padding(Modifier.Companion, paddingValues), $composer, 0, 0);
                $composer.endReplaceGroup();
            } else if (tmp instanceof TribeeSearchState.Result.Success) {
                $composer.startReplaceGroup(1978705424);
                ComposerKt.sourceInformation($composer, "207@7708L200");
                TribeeSearchResultPageContentKt.TribeeSearchResultPageContent((TribeeSearchState.Result.Success) tmp, $onEvent, PaddingKt.padding(Modifier.Companion, paddingValues), $composer, 0, 0);
                $composer.endReplaceGroup();
            } else if (!(tmp instanceof TribeeSearchState.Result.Empty)) {
                $composer.startReplaceGroup(1978686491);
                $composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer.startReplaceGroup(1978714191);
                ComposerKt.sourceInformation($composer, "213@7982L199");
                TribeeSearchEmptyPageContentKt.TribeeSearchEmptyPageContent((TribeeSearchState.Result.Empty) tmp, $onEvent, PaddingKt.padding(Modifier.Companion, paddingValues), $composer, 0, 0);
                $composer.endReplaceGroup();
            }
            if (TribeeSearchPage$lambda$2($state$delegate) instanceof TribeeSearchState.Result) {
                $composer.startReplaceGroup(1210857869);
                ComposerKt.sourceInformation($composer, "221@8302L40");
                $pvEventTrigger.element = PvTriggerEntranceKt.rememberPvEventTrigger(SearchTrackerKt.SEARCH_RESULT_PV, $composer, 6);
                $composer.endReplaceGroup();
            } else {
                if (TribeeSearchPage$lambda$2($state$delegate) instanceof TribeeSearchState.Find) {
                    $composer.startReplaceGroup(1211008715);
                    ComposerKt.sourceInformation($composer, "224@8454L42");
                    $pvEventTrigger.element = PvTriggerEntranceKt.rememberPvEventTrigger(SearchTrackerKt.SEARCH_DISCOVER_PV, $composer, 6);
                } else {
                    $composer.startReplaceGroup(1202672474);
                }
                $composer.endReplaceGroup();
            }
            EffectsKt.LaunchedEffect(TribeeSearchPage$lambda$2($state$delegate), new TribeeSearchPageKt$TribeeSearchPage$5$4$2($pvEventTrigger, $tribeeId, $state$delegate, null), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeeSearchPage$lambda$14$3$0$0(Set $exposedKeywords, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $exposedKeywords.add(it);
    }
}