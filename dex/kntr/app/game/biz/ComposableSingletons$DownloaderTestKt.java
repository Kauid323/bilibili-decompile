package kntr.app.game.biz;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.util.KBiligameExtKt;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.widget.gameaction.DefaultActionListener;
import kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionState;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloaderTest.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DownloaderTestKt {
    public static final ComposableSingletons$DownloaderTestKt INSTANCE = new ComposableSingletons$DownloaderTestKt();
    private static Function6<LazyItemScope, KBiligame, GameListViewModel, Integer, Composer, Integer, Unit> lambda$265797693 = ComposableLambdaKt.composableLambdaInstance(265797693, false, new Function6() { // from class: kntr.app.game.biz.ComposableSingletons$DownloaderTestKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda_265797693$lambda$0;
            lambda_265797693$lambda$0 = ComposableSingletons$DownloaderTestKt.lambda_265797693$lambda$0((LazyItemScope) obj, (KBiligame) obj2, (GameListViewModel) obj3, ((Integer) obj4).intValue(), (Composer) obj5, ((Integer) obj6).intValue());
            return lambda_265797693$lambda$0;
        }
    });

    public final Function6<LazyItemScope, KBiligame, GameListViewModel, Integer, Composer, Integer, Unit> getLambda$265797693$gamebiz_debug() {
        return lambda$265797693;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_265797693$lambda$0(LazyItemScope $this$ListComposable, final KBiligame item, GameListViewModel viewModel, int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$ListComposable, "$this$ListComposable");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        ComposerKt.sourceInformation($composer, "CN(item,viewModel,index)92@3582L46,92@3521L107:DownloaderTest.kt#351edr");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(265797693, $changed, -1, "kntr.app.game.biz.ComposableSingletons$DownloaderTestKt.lambda$265797693.<anonymous> (DownloaderTest.kt:82)");
        }
        DefaultActionListener defaultActionListener = new DefaultActionListener() { // from class: kntr.app.game.biz.ComposableSingletons$DownloaderTestKt$lambda$265797693$1$onActionListener$1
            @Override // kntr.app.game.base.ui.widget.gameaction.DefaultActionListener
            public void onButtonClick(KBiligame game, GameActionState state, String sourceFrom) {
                Intrinsics.checkNotNullParameter(game, "game");
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
                KLog_androidKt.getKLog().d("DownloaderTestComposable", "game = " + KBiligameExtKt.formatGameName(game) + ", sourceFrom = " + sourceFrom);
            }
        };
        GameActionButtonStyle pink = GameActionButtonStyle.Companion.getPink();
        ComposerKt.sourceInformationMarkerStart($composer, 2028528811, "CC(remember):DownloaderTest.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(item);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.game.biz.ComposableSingletons$DownloaderTestKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit lambda_265797693$lambda$0$0$0;
                    lambda_265797693$lambda$0$0$0 = ComposableSingletons$DownloaderTestKt.lambda_265797693$lambda$0$0$0(item);
                    return lambda_265797693$lambda$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        DownloaderTestKt.GameItem(item, defaultActionListener, pink, (Function0) it$iv, $composer, (($changed >> 3) & 14) | (DefaultActionListener.$stable << 3));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_265797693$lambda$0$0$0(KBiligame $item) {
        RouterHelperKt.handleGameDetail$default($item, 0, false, 0, false, null, null, 126, null);
        return Unit.INSTANCE;
    }
}