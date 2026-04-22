package kntr.app.deepsearch.ui.cards;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Author.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AuthorKt {
    public static final ComposableSingletons$AuthorKt INSTANCE = new ComposableSingletons$AuthorKt();

    /* renamed from: lambda$-513427775  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f15lambda$513427775 = ComposableLambdaKt.composableLambdaInstance(-513427775, false, new Function2() { // from class: kntr.app.deepsearch.ui.cards.ComposableSingletons$AuthorKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__513427775$lambda$0;
            lambda__513427775$lambda$0 = ComposableSingletons$AuthorKt.lambda__513427775$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__513427775$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$650950411 = ComposableLambdaKt.composableLambdaInstance(650950411, false, new Function4() { // from class: kntr.app.deepsearch.ui.cards.ComposableSingletons$AuthorKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_650950411$lambda$0;
            lambda_650950411$lambda$0 = ComposableSingletons$AuthorKt.lambda_650950411$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_650950411$lambda$0;
        }
    });

    /* renamed from: getLambda$-513427775$compose_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m711getLambda$513427775$compose_debug() {
        return f15lambda$513427775;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$650950411$compose_debug() {
        return lambda$650950411;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__513427775$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C52@1900L13:Author.kt#pp6rt");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-513427775, $changed, -1, "kntr.app.deepsearch.ui.cards.ComposableSingletons$AuthorKt.lambda$-513427775.<anonymous> (Author.kt:52)");
            }
            AuthorKt.Placeholder(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_650950411$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)55@1977L13:Author.kt#pp6rt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(650950411, $changed, -1, "kntr.app.deepsearch.ui.cards.ComposableSingletons$AuthorKt.lambda$650950411.<anonymous> (Author.kt:55)");
        }
        AuthorKt.Placeholder(null, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}