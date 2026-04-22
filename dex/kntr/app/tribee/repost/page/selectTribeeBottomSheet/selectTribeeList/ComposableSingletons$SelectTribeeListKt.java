package kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: SelectTribeeList.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$SelectTribeeListKt {
    public static final ComposableSingletons$SelectTribeeListKt INSTANCE = new ComposableSingletons$SelectTribeeListKt();

    /* renamed from: lambda$-1260419895  reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f20lambda$1260419895 = ComposableLambdaKt.composableLambdaInstance(-1260419895, false, new Function3() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.ComposableSingletons$SelectTribeeListKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1260419895$lambda$0;
            lambda__1260419895$lambda$0 = ComposableSingletons$SelectTribeeListKt.lambda__1260419895$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1260419895$lambda$0;
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$2092654514 = ComposableLambdaKt.composableLambdaInstance(2092654514, false, new Function3() { // from class: kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.ComposableSingletons$SelectTribeeListKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_2092654514$lambda$0;
            lambda_2092654514$lambda$0 = ComposableSingletons$SelectTribeeListKt.lambda_2092654514$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_2092654514$lambda$0;
        }
    });

    /* renamed from: getLambda$-1260419895$repost_debug  reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1021getLambda$1260419895$repost_debug() {
        return f20lambda$1260419895;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$2092654514$repost_debug() {
        return lambda$2092654514;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1260419895$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C115@4391L56,115@4365L83:SelectTribeeList.kt#mscztr");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1260419895, $changed, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.ComposableSingletons$SelectTribeeListKt.lambda$-1260419895.<anonymous> (SelectTribeeList.kt:115)");
            }
            SelectTribeeListKt.SelectTribeeListIndicator(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_28(TribeeRes.INSTANCE.getString()), $composer, 0), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2092654514$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C121@4601L56,121@4575L83:SelectTribeeList.kt#mscztr");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2092654514, $changed, -1, "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.ComposableSingletons$SelectTribeeListKt.lambda$2092654514.<anonymous> (SelectTribeeList.kt:121)");
            }
            SelectTribeeListKt.SelectTribeeListIndicator(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_49(TribeeRes.INSTANCE.getString()), $composer, 0), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}