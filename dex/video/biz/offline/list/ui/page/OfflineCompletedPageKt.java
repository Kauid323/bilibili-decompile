package video.biz.offline.list.ui.page;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.bilibili.compose.common.swipe.SwipeActionKt;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import java.util.Set;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.OfflinePageStateKt;
import video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine;
import video.biz.offline.list.ui.widget.ContentWithCheckMarkKt;
import video.biz.offline.list.ui.widget.ContentWithStateKt;
import video.biz.offline.list.ui.widget.OfflineCompletedCardKt;
import video.biz.offline.list.ui.widget.OfflineEmptyPlaceholderKt;
import video.biz.offline.list.ui.widget.OfflineListItem_androidKt;
import video.biz.offline.list.ui.widget.OfflineOperationComponentKt;
import video.biz.offline.list.ui.widget.OfflinePageFooterKt;
import video.biz.offline.list.ui.widget.OfflinePageHeaderKt;
import video.biz.offline.list.ui.widget.OfflinePopupKt;
import video.biz.offline.list.ui.widget.OfflineSwipeActionExtKt;

/* compiled from: OfflineCompletedPage.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001a\u008d\u0001\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010j\u0004\u0018\u0001`\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a\u009d\u0001\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"2\u001c\b\u0002\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0001\u0018\u00010%H\u0007¢\u0006\u0002\u0010&¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"OfflineCompletedPage", "", "type", "", "id", ChronosDanmakuSender.KEY_MARK_DANMAKU, RankRouter.BundleKey.ACTION_PARAM_TITLE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "OfflineCompletedView", "modifier", "Landroidx/compose/ui/Modifier;", "fitsSystemBar", "", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "downloadedInterceptor", "Lkotlin/Function3;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDownloadedRouteInterceptor;", "backInterceptor", "Lkotlin/Function0;", "Lvideo/biz/offline/list/logic/statemachine/OfflineBackInterceptor;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OfflineCompletedList", "isEdit", "completed", "", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "supportOperations", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "selected", "", "onItemClick", "Lkotlin/Function1;", "onItemLongClick", "operationHandler", "Lkotlin/Function2;", "(ZLjava/util/List;Ljava/util/List;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "state", "Lvideo/biz/offline/list/logic/model/OfflinePageState;"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineCompletedPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$2(boolean z, List list, List list2, LazyListState lazyListState, Modifier modifier, Set set, Function1 function1, Function1 function12, Function2 function2, int i, int i2, Composer composer, int i3) {
        OfflineCompletedList(z, list, list2, lazyListState, modifier, set, function1, function12, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$4(boolean z, List list, List list2, LazyListState lazyListState, Modifier modifier, Set set, Function1 function1, Function1 function12, Function2 function2, int i, int i2, Composer composer, int i3) {
        OfflineCompletedList(z, list, list2, lazyListState, modifier, set, function1, function12, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedPage$lambda$0(String str, String str2, String str3, String str4, int i, Composer composer, int i2) {
        OfflineCompletedPage(str, str2, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$4(String str, String str2, String str3, String str4, Modifier modifier, boolean z, TextStyle textStyle, Function3 function3, Function0 function0, int i, int i2, Composer composer, int i3) {
        OfflineCompletedView(str, str2, str3, str4, modifier, z, textStyle, function3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void OfflineCompletedPage(final String type, final String id, final String keyword, final String title, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Composer $composer3 = $composer.startRestartGroup(-273013792);
        ComposerKt.sourceInformation($composer3, "C(OfflineCompletedPage)N(type,id,keyword,title)69@3360L115:OfflineCompletedPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(type) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(id) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(keyword) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(title) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273013792, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineCompletedPage (OfflineCompletedPage.kt:68)");
            }
            $composer2 = $composer3;
            OfflineCompletedView(type, id, keyword, title, null, false, null, null, null, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168), 496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedPage$lambda$0;
                    OfflineCompletedPage$lambda$0 = OfflineCompletedPageKt.OfflineCompletedPage$lambda$0(type, id, keyword, title, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedPage$lambda$0;
                }
            });
        }
    }

    public static final void OfflineCompletedView(final String type, final String id, final String keyword, final String title, Modifier modifier, boolean fitsSystemBar, TextStyle titleTextStyle, Function3<? super String, ? super String, ? super String, Boolean> function3, Function0<Boolean> function0, Composer $composer, final int $changed, final int i) {
        TextStyle textStyle;
        Function3 function32;
        Modifier modifier2;
        boolean fitsSystemBar2;
        Function0 backInterceptor;
        TextStyle titleTextStyle2;
        Function3 downloadedInterceptor;
        TextStyle titleTextStyle3;
        int $dirty;
        Modifier modifier3;
        String str;
        String str2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Composer $composer2 = $composer.startRestartGroup(1716529238);
        ComposerKt.sourceInformation($composer2, "C(OfflineCompletedView)N(type,id,keyword,title,modifier,fitsSystemBar,titleTextStyle,downloadedInterceptor,backInterceptor)89@3875L7,90@3914L7,91@3938L24,93@3989L358,104@4379L50,106@4471L7,107@4504L137,107@4483L158,114@4708L23,117@4769L35,118@4819L4906,118@4809L4916:OfflineCompletedPage.kt#rawcr6");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(type) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(id) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(keyword) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(title) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changed(fitsSystemBar) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                textStyle = titleTextStyle;
                if ($composer2.changed(textStyle)) {
                    i3 = 1048576;
                    $dirty2 |= i3;
                }
            } else {
                textStyle = titleTextStyle;
            }
            i3 = 524288;
            $dirty2 |= i3;
        } else {
            textStyle = titleTextStyle;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty2 |= 12582912;
            function32 = function3;
        } else if ((12582912 & $changed) == 0) {
            function32 = function3;
            $dirty2 |= $composer2.changedInstance(function32) ? 8388608 : 4194304;
        } else {
            function32 = function3;
        }
        int i7 = i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
        if (i7 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 67108864 : 33554432;
        }
        if ($composer2.shouldExecute(($dirty2 & 38347923) != 38347922, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "85@3703L9");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
                boolean fitsSystemBar3 = i5 != 0 ? true : fitsSystemBar;
                if ((i & 64) != 0) {
                    titleTextStyle3 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT17b();
                    $dirty2 &= -3670017;
                } else {
                    titleTextStyle3 = textStyle;
                }
                Function3 downloadedInterceptor2 = i6 != 0 ? null : function32;
                if (i7 != 0) {
                    backInterceptor = null;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    fitsSystemBar2 = fitsSystemBar3;
                    titleTextStyle2 = titleTextStyle3;
                    downloadedInterceptor = downloadedInterceptor2;
                } else {
                    backInterceptor = function0;
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    fitsSystemBar2 = fitsSystemBar3;
                    titleTextStyle2 = titleTextStyle3;
                    downloadedInterceptor = downloadedInterceptor2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                modifier3 = modifier;
                fitsSystemBar2 = fitsSystemBar;
                backInterceptor = function0;
                titleTextStyle2 = textStyle;
                downloadedInterceptor = function32;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1716529238, $dirty, -1, "video.biz.offline.list.ui.page.OfflineCompletedView (OfflineCompletedPage.kt:88)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Router router = (Router) consume;
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Toaster toaster = (Toaster) consume2;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 317172348, "CC(remember):OfflineCompletedPage.kt#9igjgp");
            Object value$iv = $composer2.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                str2 = "CC(remember):OfflineCompletedPage.kt#9igjgp";
                i2 = 2023513938;
                value$iv = new OfflineCompletedPageStateMachine(OfflinePageStateKt.offlineCompletedPageInitialState(), id, keyword, type, router, scope, downloadedInterceptor);
                $composer2.updateRememberedValue(value$iv);
            } else {
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                str2 = "CC(remember):OfflineCompletedPage.kt#9igjgp";
                i2 = 2023513938;
            }
            final OfflineCompletedPageStateMachine machine = (OfflineCompletedPageStateMachine) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State state$delegate = SnapshotStateKt.collectAsState(machine.getState(), OfflinePageStateKt.offlineCompletedPageInitialState(), (CoroutineContext) null, $composer2, OfflinePageState.$stable << 3, 2);
            CompositionLocal this_$iv3 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, i2, str);
            Object consume3 = $composer2.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycle = (LifecycleOwner) consume3;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 317188607, str2);
            boolean invalid$iv = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(machine);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new OfflineCompletedPageKt$OfflineCompletedView$1$1(lifecycle, machine, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
            final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
            final boolean isEdit = OfflineCompletedView$lambda$1(state$delegate).isEdit();
            OfflineHomePageKt.PrepareBackHandler(machine, isEdit, $composer2, OfflineCompletedPageStateMachine.$stable);
            final Modifier modifier5 = modifier3;
            final boolean z = fitsSystemBar2;
            final TextStyle textStyle2 = titleTextStyle2;
            final Function0 function02 = backInterceptor;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(478282654, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedView$lambda$3;
                    OfflineCompletedView$lambda$3 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3(modifier5, machine, title, isEdit, z, textStyle2, function02, scope, state$delegate, lazyListState, toaster, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedView$lambda$3;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            fitsSystemBar2 = fitsSystemBar;
            backInterceptor = function0;
            titleTextStyle2 = textStyle;
            downloadedInterceptor = function32;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final boolean z2 = fitsSystemBar2;
            final TextStyle textStyle3 = titleTextStyle2;
            final Function3 function33 = downloadedInterceptor;
            final Function0 function03 = backInterceptor;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedView$lambda$4;
                    OfflineCompletedView$lambda$4 = OfflineCompletedPageKt.OfflineCompletedView$lambda$4(type, id, keyword, title, modifier6, z2, textStyle3, function33, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedView$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState OfflineCompletedView$lambda$1(State<OfflinePageState> state) {
        Object thisObj$iv = state.getValue();
        return (OfflinePageState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3(Modifier $modifier, final OfflineCompletedPageStateMachine $machine, final String $title, final boolean $isEdit, final boolean $fitsSystemBar, final TextStyle $titleTextStyle, final Function0 $backInterceptor, final CoroutineScope $scope, final State $state$delegate, final LazyListState $lazyListState, final Toaster $toaster, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C119@4846L28,120@4894L20,124@4988L714,142@5728L1567,176@7307L2348,122@4924L4731,230@9680L39:OfflineCompletedPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(478282654, $changed, -1, "video.biz.offline.list.ui.page.OfflineCompletedView.<anonymous> (OfflineCompletedPage.kt:119)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            ScaffoldKt.Scaffold-TvnljyQ($modifier, ComposableLambdaKt.rememberComposableLambda(-210628766, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedView$lambda$3$0;
                    OfflineCompletedView$lambda$3$0 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$0($title, $isEdit, $fitsSystemBar, $titleTextStyle, $backInterceptor, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedView$lambda$3$0;
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(716125987, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedView$lambda$3$1;
                    OfflineCompletedView$lambda$3$1 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$1($isEdit, $scope, $machine, $state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedView$lambda$3$1;
                }
            }, $composer, 54), (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1886971539, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineCompletedView$lambda$3$2;
                    OfflineCompletedView$lambda$3$2 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$2($state$delegate, $isEdit, $lazyListState, $scope, $machine, $toaster, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineCompletedView$lambda$3$2;
                }
            }, $composer, 54), $composer, 805306800, 504);
            OfflinePopupKt.OfflinePopup(OfflineCompletedView$lambda$1($state$delegate).getDialogType(), $machine, $composer, OfflineCompletedPageStateMachine.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$0(String $title, final boolean $isEdit, boolean $fitsSystemBar, TextStyle $titleTextStyle, Function0 $backInterceptor, final CoroutineScope $scope, final OfflineCompletedPageStateMachine $machine, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C132@5337L351,125@5006L682:OfflineCompletedPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-210628766, $changed, -1, "video.biz.offline.list.ui.page.OfflineCompletedView.<anonymous>.<anonymous> (OfflineCompletedPage.kt:125)");
            }
            OfflinePageHeaderKt.m2949OfflinePageHeaderGmEhDVc($title, SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), !$isEdit, $fitsSystemBar, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $titleTextStyle, $backInterceptor, ComposableLambdaKt.rememberComposableLambda(-645432634, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineCompletedView$lambda$3$0$0;
                    OfflineCompletedView$lambda$3$0$0 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$0$0($isEdit, $scope, $machine, $state$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineCompletedView$lambda$3$0$0;
                }
            }, $composer, 54), $composer, 100663344, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$0$0(boolean $isEdit, CoroutineScope $scope, OfflineCompletedPageStateMachine $machine, State $state$delegate, RowScope $this$OfflinePageHeader, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageHeader, "$this$OfflinePageHeader");
        ComposerKt.sourceInformation($composer, "C:OfflineCompletedPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-645432634, $changed, -1, "video.biz.offline.list.ui.page.OfflineCompletedView.<anonymous>.<anonymous>.<anonymous> (OfflineCompletedPage.kt:133)");
            }
            if ($isEdit) {
                $composer.startReplaceGroup(485021280);
                ComposerKt.sourceInformation($composer, "134@5397L44");
                OfflinePageHeaderKt.OfflineHeaderCancelOperation($scope, $machine, $composer, OfflineCompletedPageStateMachine.$stable << 3);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(485121875);
                ComposerKt.sourceInformation($composer, "*137@5586L36");
                Iterable $this$forEach$iv = OfflineCompletedView$lambda$1($state$delegate).getConfig().getHeaderOperations();
                for (Object element$iv : $this$forEach$iv) {
                    OfflinePageOperation operation = (OfflinePageOperation) element$iv;
                    OfflineOperationComponentKt.mapToHeaderComponent(operation, $scope, $machine, $composer, OfflineCompletedPageStateMachine.$stable << 6);
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$1(boolean $isEdit, final CoroutineScope $scope, final OfflineCompletedPageStateMachine $machine, final State $state$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C165@6888L167,170@7075L206,161@6660L621:OfflineCompletedPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(716125987, $changed, -1, "video.biz.offline.list.ui.page.OfflineCompletedView.<anonymous>.<anonymous> (OfflineCompletedPage.kt:143)");
            }
            StorageInfoModel storageInfo = OfflineCompletedView$lambda$1($state$delegate).getStorageInfo();
            if ($isEdit) {
                $composer.startReplaceGroup(1001036319);
                $composer.endReplaceGroup();
                int size = OfflineCompletedView$lambda$1($state$delegate).selected().size();
                int size2 = OfflineCompletedView$lambda$1($state$delegate).getCompleted().size();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1002343434, "CC(remember):OfflineCompletedPage.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit OfflineCompletedView$lambda$3$1$0$0;
                            OfflineCompletedView$lambda$3$1$0$0 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$1$0$0($scope, $machine);
                            return OfflineCompletedView$lambda$3$1$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                OfflinePageFooterKt.OfflinePageFooter(size, size2, fillMaxWidth$default, (Function0) it$iv, ComposableLambdaKt.rememberComposableLambda(-1660504423, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit OfflineCompletedView$lambda$3$1$1;
                        OfflineCompletedView$lambda$3$1$1 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$1$1($state$delegate, $scope, $machine, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return OfflineCompletedView$lambda$3$1$1;
                    }
                }, $composer, 54), $composer, 24960, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.startReplaceGroup(1006827615);
                ComposerKt.sourceInformation($composer, "");
                if (!(storageInfo != null && storageInfo.getShowStorageUsage()) || OfflineCompletedView$lambda$1($state$delegate).getCompleted().isEmpty()) {
                    $composer.startReplaceGroup(1001036319);
                } else {
                    $composer.startReplaceGroup(1006919158);
                    ComposerKt.sourceInformation($composer, "152@6273L12,154@6407L17,146@5934L633");
                    OfflinePageFooterKt.OfflineStorageUsage(storageInfo.getUsedSpaceDesc(), storageInfo.getAvailableSpaceDesc(), SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(PaddingKt.padding(Modifier.Companion, WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer, 0)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(5), 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), $composer, 0, 0);
                }
                $composer.endReplaceGroup();
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$1$0$0(CoroutineScope $scope, OfflineCompletedPageStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineCompletedPageKt$OfflineCompletedView$2$2$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$1$1(State $state$delegate, CoroutineScope $scope, OfflineCompletedPageStateMachine $machine, RowScope $this$OfflinePageFooter, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$OfflinePageFooter, "$this$OfflinePageFooter");
        ComposerKt.sourceInformation($composer, "C*172@7184L57:OfflineCompletedPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1660504423, $changed, -1, "video.biz.offline.list.ui.page.OfflineCompletedView.<anonymous>.<anonymous>.<anonymous> (OfflineCompletedPage.kt:171)");
            }
            Iterable $this$forEach$iv = OfflineCompletedView$lambda$1($state$delegate).getConfig().getFooterOperations();
            for (Object element$iv : $this$forEach$iv) {
                OfflinePageOperation operation = (OfflinePageOperation) element$iv;
                OfflineOperationComponentKt.mapToFooterComponent(operation, $scope, $machine, OfflineCompletedView$lambda$1($state$delegate).getSelectedCount(), $composer, OfflineCompletedPageStateMachine.$stable << 6);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$2(final State $state$delegate, final boolean $isEdit, final LazyListState $lazyListState, final CoroutineScope $scope, final OfflineCompletedPageStateMachine $machine, final Toaster $toaster, PaddingValues innerPadding, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding)183@7596L6,184@7623L2022,177@7337L2308:OfflineCompletedPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1886971539, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineCompletedView.<anonymous>.<anonymous> (OfflineCompletedPage.kt:177)");
            }
            ContentWithStateKt.ContentWithState(OfflineCompletedView$lambda$1($state$delegate).getDataState(), BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, innerPadding), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(-2076681780, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedView$lambda$3$2$0;
                    OfflineCompletedView$lambda$3$2$0 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$2$0($isEdit, $lazyListState, $scope, $machine, $state$delegate, $toaster, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedView$lambda$3$2$0;
                }
            }, $composer, 54), $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007d, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b9, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ff, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineCompletedView$lambda$3$2$0(boolean $isEdit, LazyListState $lazyListState, final CoroutineScope $scope, final OfflineCompletedPageStateMachine $machine, final State $state$delegate, final Toaster $toaster, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C192@8005L166,197@8211L170,202@8422L1190,185@7641L1990:OfflineCompletedPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2076681780, $changed, -1, "video.biz.offline.list.ui.page.OfflineCompletedView.<anonymous>.<anonymous>.<anonymous> (OfflineCompletedPage.kt:185)");
            }
            List<OfflineCachedCardModel> completed = OfflineCompletedView$lambda$1($state$delegate).getCompleted();
            List<OfflinePageOperation> footerOperations = OfflineCompletedView$lambda$1($state$delegate).getConfig().getFooterOperations();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            Set<String> selected = OfflineCompletedView$lambda$1($state$delegate).selected();
            ComposerKt.sourceInformationMarkerStart($composer, 1468614450, "CC(remember):OfflineCompletedPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj) {
                    Unit OfflineCompletedView$lambda$3$2$0$0$0;
                    OfflineCompletedView$lambda$3$2$0$0$0 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$2$0$0$0($scope, $machine, (String) obj);
                    return OfflineCompletedView$lambda$3$2$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            Function1 function1 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1468621046, "CC(remember):OfflineCompletedPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj) {
                    Unit OfflineCompletedView$lambda$3$2$0$1$0;
                    OfflineCompletedView$lambda$3$2$0$1$0 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$2$0$1$0($scope, $machine, (String) obj);
                    return OfflineCompletedView$lambda$3$2$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            Function1 function12 = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1468628818, "CC(remember):OfflineCompletedPage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changed($state$delegate) | $composer.changedInstance($machine) | $composer.changedInstance($toaster);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedView$lambda$3$2$0$2$0;
                    OfflineCompletedView$lambda$3$2$0$2$0 = OfflineCompletedPageKt.OfflineCompletedView$lambda$3$2$0$2$0($scope, $machine, $state$delegate, $toaster, (String) obj, (OfflinePageOperation) obj2);
                    return OfflineCompletedView$lambda$3$2$0$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineCompletedList($isEdit, completed, footerOperations, $lazyListState, fillMaxSize$default, selected, function1, function12, (Function2) it$iv3, $composer, 24576, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$2$0$0$0(CoroutineScope $scope, OfflineCompletedPageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineCompletedPageKt$OfflineCompletedView$2$3$1$1$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$2$0$1$0(CoroutineScope $scope, OfflineCompletedPageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineCompletedPageKt$OfflineCompletedView$2$3$1$2$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedView$lambda$3$2$0$2$0(CoroutineScope $scope, OfflineCompletedPageStateMachine $machine, State $state$delegate, Toaster $toaster, String key, OfflinePageOperation operations) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(operations, "operations");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineCompletedPageKt$OfflineCompletedView$2$3$1$3$1$1(operations, key, $machine, $state$delegate, $toaster, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r8v12 */
    public static final void OfflineCompletedList(final boolean isEdit, final List<OfflineCachedCardModel> list, final List<? extends OfflinePageOperation> list2, final LazyListState listState, Modifier modifier, Set<String> set, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, Function2<? super String, ? super OfflinePageOperation, Unit> function2, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Set selected;
        Function1<? super String, Unit> function13;
        Function1<? super String, Unit> function14;
        Function2<? super String, ? super OfflinePageOperation, Unit> function22;
        Intrinsics.checkNotNullParameter(list, "completed");
        Intrinsics.checkNotNullParameter(list2, "supportOperations");
        Intrinsics.checkNotNullParameter(listState, "listState");
        Composer $composer3 = $composer.startRestartGroup(1032518447);
        ComposerKt.sourceInformation($composer3, "C(OfflineCompletedList)N(isEdit,completed,supportOperations,listState,modifier,selected,onItemClick,onItemLongClick,operationHandler)242@10025L2,243@10069L2,251@10267L30,252@10323L36,253@10385L25,254@10436L24,255@10516L1082,255@10465L1133:OfflineCompletedPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(isEdit) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(list2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(listState) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(modifier) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(set) ? 131072 : 65536;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        int i5 = i & 128;
        if (i5 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 8388608 : 4194304;
        }
        int i6 = i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
        if (i6 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 67108864 : 33554432;
        }
        if ($composer3.shouldExecute(($dirty & 38347923) != 38347922, $dirty & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            Set selected2 = i3 != 0 ? SetsKt.emptySet() : set;
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 112791281, "CC(remember):OfflineCompletedPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit OfflineCompletedList$lambda$0$0;
                            OfflineCompletedList$lambda$0$0 = OfflineCompletedPageKt.OfflineCompletedList$lambda$0$0((String) obj);
                            return OfflineCompletedList$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function13 = it$iv;
            } else {
                function13 = function1;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 112792689, "CC(remember):OfflineCompletedPage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit OfflineCompletedList$lambda$1$0;
                            OfflineCompletedList$lambda$1$0 = OfflineCompletedPageKt.OfflineCompletedList$lambda$1$0((String) obj);
                            return OfflineCompletedList$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function14 = it$iv2;
            } else {
                function14 = function12;
            }
            function22 = i6 != 0 ? null : function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1032518447, $dirty, -1, "video.biz.offline.list.ui.page.OfflineCompletedList (OfflineCompletedPage.kt:245)");
            }
            if (list.isEmpty()) {
                $composer3.startReplaceGroup(-798284133);
                ComposerKt.sourceInformation($composer3, "247@10188L25");
                OfflineEmptyPlaceholderKt.OfflineEmptyPlaceholder(null, $composer3, 0, 1);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Set selected3 = selected2;
                    final Modifier modifier3 = modifier2;
                    final Function1<? super String, Unit> function15 = function13;
                    final Function1<? super String, Unit> function16 = function14;
                    final Function2<? super String, ? super OfflinePageOperation, Unit> function23 = function22;
                    endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj, Object obj2) {
                            Unit OfflineCompletedList$lambda$2;
                            OfflineCompletedList$lambda$2 = OfflineCompletedPageKt.OfflineCompletedList$lambda$2(isEdit, list, list2, listState, modifier3, selected3, function15, function16, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return OfflineCompletedList$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty2 = $dirty;
            final Set selected4 = selected2;
            $composer3.startReplaceGroup(-808383437);
            $composer3.endReplaceGroup();
            final SwipeCancellingToken swipeCancellingToken = SwipeActionKt.rememberSwipeCancellingToken($composer3, 0);
            SwipeActionKt.cancelOnLazyListScrolling(swipeCancellingToken, listState, $composer3, ($dirty2 >> 6) & 112);
            SwipeActionKt.cancelOnLifecyclePaused(swipeCancellingToken, $composer3, 0);
            $composer2 = $composer3;
            OfflineSwipeActionExtKt.cancelOnEditMode(swipeCancellingToken, isEdit, $composer2, ($dirty2 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart($composer2, 112808073, "CC(remember):OfflineCompletedPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | $composer2.changedInstance(swipeCancellingToken) | $composer2.changedInstance(list2) | (($dirty2 & 14) == 4) | (($dirty2 & 3670016) == 1048576) | (($dirty2 & 29360128) == 8388608) | (($dirty2 & 234881024) == 67108864) | $composer2.changedInstance(selected4);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                final Function1<? super String, Unit> function17 = function13;
                final Function1<? super String, Unit> function18 = function14;
                final Function2<? super String, ? super OfflinePageOperation, Unit> function24 = function22;
                value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        Unit OfflineCompletedList$lambda$3$0;
                        OfflineCompletedList$lambda$3$0 = OfflineCompletedPageKt.OfflineCompletedList$lambda$3$0(list, swipeCancellingToken, list2, isEdit, function17, function18, function24, selected4, (LazyListScope) obj);
                        return OfflineCompletedList$lambda$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier2, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv3, $composer2, (($dirty2 >> 12) & 14) | (($dirty2 >> 6) & 112), 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            selected = selected4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            selected = set;
            function13 = function1;
            function14 = function12;
            function22 = function2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier4 = modifier2;
            final Set set2 = selected;
            final Function1<? super String, Unit> function19 = function13;
            final Function1<? super String, Unit> function110 = function14;
            final Function2<? super String, ? super OfflinePageOperation, Unit> function25 = function22;
            endRestartGroup2.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedList$lambda$4;
                    OfflineCompletedList$lambda$4 = OfflineCompletedPageKt.OfflineCompletedList$lambda$4(isEdit, list, list2, listState, modifier4, set2, function19, function110, function25, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedList$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$3$0(final List $completed, final SwipeCancellingToken $swipeCancellingToken, final List $supportOperations, final boolean $isEdit, final Function1 $onItemClick, final Function1 $onItemLongClick, final Function2 $operationHandler, final Set $selected, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.items$default($this$LazyColumn, $completed.size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1353164369, true, new Function4() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit OfflineCompletedList$lambda$3$0$0;
                OfflineCompletedList$lambda$3$0$0 = OfflineCompletedPageKt.OfflineCompletedList$lambda$3$0$0($completed, $swipeCancellingToken, $supportOperations, $isEdit, $onItemClick, $onItemLongClick, $operationHandler, $selected, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return OfflineCompletedList$lambda$3$0$0;
            }
        }), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$3$0$0(final List $completed, SwipeCancellingToken $swipeCancellingToken, List $supportOperations, final boolean $isEdit, final Function1 $onItemClick, final Function1 $onItemLongClick, final Function2 $operationHandler, final Set $selected, LazyItemScope $this$items, final int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)263@10834L60,266@10926L64,269@11027L77,272@11120L462,258@10611L971:OfflineCompletedPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1353164369, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineCompletedList.<anonymous>.<anonymous>.<anonymous> (OfflineCompletedPage.kt:257)");
            }
            final OfflineCachedCardModel item = (OfflineCachedCardModel) $completed.get(index);
            String id = item.getId();
            ComposerKt.sourceInformationMarkerStart($composer, -984122867, "CC(remember):OfflineCompletedPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onItemClick) | $composer.changedInstance(item);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda23
                    public final Object invoke() {
                        Unit OfflineCompletedList$lambda$3$0$0$0$0;
                        OfflineCompletedList$lambda$3$0$0$0$0 = OfflineCompletedPageKt.OfflineCompletedList$lambda$3$0$0$0$0($onItemClick, item);
                        return OfflineCompletedList$lambda$3$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -984119919, "CC(remember):OfflineCompletedPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onItemLongClick) | $composer.changedInstance(item);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit OfflineCompletedList$lambda$3$0$0$1$0;
                        OfflineCompletedList$lambda$3$0$0$1$0 = OfflineCompletedPageKt.OfflineCompletedList$lambda$3$0$0$1$0($onItemLongClick, item);
                        return OfflineCompletedList$lambda$3$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function0 function02 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -984116674, "CC(remember):OfflineCompletedPage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($operationHandler) | $composer.changedInstance(item);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit OfflineCompletedList$lambda$3$0$0$2$0;
                        OfflineCompletedList$lambda$3$0$0$2$0 = OfflineCompletedPageKt.OfflineCompletedList$lambda$3$0$0$2$0($operationHandler, item, (OfflinePageOperation) obj);
                        return OfflineCompletedList$lambda$3$0$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineListItem_androidKt.OfflineListItem(id, $swipeCancellingToken, $supportOperations, $isEdit, null, function0, function02, (Function1) it$iv3, ComposableLambdaKt.rememberComposableLambda(1509243920, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedList$lambda$3$0$0$3;
                    OfflineCompletedList$lambda$3$0$0$3 = OfflineCompletedPageKt.OfflineCompletedList$lambda$3$0$0$3(index, $completed, $isEdit, $selected, item, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedList$lambda$3$0$0$3;
                }
            }, $composer, 54), $composer, 100663296, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$3$0$0$0$0(Function1 $onItemClick, OfflineCachedCardModel $item) {
        $onItemClick.invoke($item.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$3$0$0$1$0(Function1 $onItemLongClick, OfflineCachedCardModel $item) {
        $onItemLongClick.invoke($item.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$3$0$0$2$0(Function2 $operationHandler, OfflineCachedCardModel $item, OfflinePageOperation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ($operationHandler != null) {
            $operationHandler.invoke($item.getId(), it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$3$0$0$3(int $index, List $completed, boolean $isEdit, Set $selected, final OfflineCachedCardModel $item, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C278@11392L176,274@11223L345:OfflineCompletedPage.kt#rawcr6");
        boolean z = false;
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1509243920, $changed, -1, "video.biz.offline.list.ui.page.OfflineCompletedList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfflineCompletedPage.kt:273)");
            }
            if ($index != CollectionsKt.getLastIndex($completed) && $completed.size() > 1) {
                z = true;
            }
            final boolean showDivider = z;
            ContentWithCheckMarkKt.m2913ContentWithCheckMarkGHTll3U($isEdit, $selected.contains($item.getId()), null, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, null, ComposableLambdaKt.rememberComposableLambda(-1542244934, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineCompletedPageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedList$lambda$3$0$0$3$0;
                    OfflineCompletedList$lambda$3$0$0$3$0 = OfflineCompletedPageKt.OfflineCompletedList$lambda$3$0$0$3$0(OfflineCachedCardModel.this, showDivider, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedList$lambda$3$0$0$3$0;
                }
            }, $composer, 54), $composer, 12585984, 116);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedList$lambda$3$0$0$3$0(OfflineCachedCardModel $item, boolean $showDivider, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C279@11414L136:OfflineCompletedPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1542244934, $changed, -1, "video.biz.offline.list.ui.page.OfflineCompletedList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfflineCompletedPage.kt:279)");
            }
            OfflineCompletedCardKt.OfflineCompletedCard($item, null, $showDivider, $composer, OfflineCachedCardModel.$stable, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}