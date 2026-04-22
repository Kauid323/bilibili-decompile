package kntr.app.digital.preview.card;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Dp;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;
import javax.inject.Qualifier;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.card.image.ImageCard;
import kntr.app.digital.preview.card.image.ImageModuleKt;
import kntr.app.digital.preview.card.video.VideoCard;
import kntr.app.digital.preview.card.video.VideoUIService;
import kntr.app.digital.preview.card.web.WebCard;
import kntr.app.digital.preview.card.web.WebCardUIService;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalCardListUIService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\u000fB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardListUIService;", RoomRecommendViewModel.EMPTY_CURSOR, "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "videoPlayService", "Lkntr/app/digital/preview/card/video/VideoUIService;", "webCardUIService", "Lkntr/app/digital/preview/card/web/WebCardUIService;", "<init>", "(Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/app/digital/preview/card/video/VideoUIService;Lkntr/app/digital/preview/card/web/WebCardUIService;)V", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InitialPage", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalCardListUIService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final VideoUIService videoPlayService;
    private final WebCardUIService webCardUIService;

    /* compiled from: DigitalCardListUIService.kt */
    @Qualifier
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkntr/app/digital/preview/card/DigitalCardListUIService$InitialPage;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public @interface InitialPage {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(DigitalCardListUIService digitalCardListUIService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        digitalCardListUIService.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public DigitalCardListUIService(DigitalCardStateService cardStateService, VideoUIService videoPlayService, WebCardUIService webCardUIService) {
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(videoPlayService, "videoPlayService");
        Intrinsics.checkNotNullParameter(webCardUIService, "webCardUIService");
        this.cardStateService = cardStateService;
        this.videoPlayService = videoPlayService;
        this.webCardUIService = webCardUIService;
    }

    public final void Content(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-899889698);
        ComposerKt.sourceInformation($composer3, "C(Content)N(modifier)44@1698L2149,40@1526L2321:DigitalCardListUIService.kt#v85lra");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-899889698, $dirty2, -1, "kntr.app.digital.preview.card.DigitalCardListUIService.Content (DigitalCardListUIService.kt:36)");
            }
            this.cardStateService.getCardItems();
            final PagerState pagerState = this.cardStateService.getPagerState();
            $composer2 = $composer3;
            PagerKt.HorizontalPager--8jOkeI(pagerState, modifier3, PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(58), 0.0f, 2, (Object) null), (PageSize) null, 0, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(292372511, true, new Function4() { // from class: kntr.app.digital.preview.card.DigitalCardListUIService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit Content$lambda$0;
                    Content$lambda$0 = DigitalCardListUIService.Content$lambda$0(DigitalCardListUIService.this, pagerState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return Content$lambda$0;
                }
            }, $composer3, 54), $composer2, (($dirty2 << 3) & 112) | 384, 24576, 16376);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.DigitalCardListUIService$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = DigitalCardListUIService.Content$lambda$1(DigitalCardListUIService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(DigitalCardListUIService this$0, PagerState $pagerState, PagerScope $this$HorizontalPager, int index, Composer $composer, int $changed) {
        float scale;
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(index):DigitalCardListUIService.kt#v85lra");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(292372511, $changed, -1, "kntr.app.digital.preview.card.DigitalCardListUIService.Content.<anonymous> (DigitalCardListUIService.kt:45)");
        }
        CardItem cardItem = this$0.cardStateService.getCardItems().get(index);
        boolean isCurrentPage = $pagerState.getCurrentPage() == index;
        if (isCurrentPage) {
            float f = 1;
            scale = f - ((f - 0.85f) * Math.abs($pagerState.getCurrentPageOffsetFraction()));
        } else {
            scale = ((1 - 0.85f) * Math.abs($pagerState.getCurrentPageOffsetFraction())) + 0.85f;
        }
        Modifier m = ScaleKt.scale(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(ZIndexModifierKt.zIndex(Modifier.Companion, this$0.cardStateService.isWebCard(index) ? 1.0f : 0.0f), 0.0f, 1, (Object) null), 0.6666667f, false, 2, (Object) null), scale);
        final Object data = cardItem.getData();
        if (data instanceof ImageCard) {
            $composer.startReplaceGroup(-122957613);
            ComposerKt.sourceInformation($composer, "76@3221L211,71@2936L496");
            DigitalItemContainerKt.DigitalCardContainer(cardItem.getBasic().getFrameImg(), cardItem.getBasic().getLeftTopTagImg(), m, cardItem.getBasic().getHasMask(), ComposableLambdaKt.rememberComposableLambda(-548194344, true, new Function3() { // from class: kntr.app.digital.preview.card.DigitalCardListUIService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Content$lambda$0$0;
                    Content$lambda$0$0 = DigitalCardListUIService.Content$lambda$0$0(data, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Content$lambda$0$0;
                }
            }, $composer, 54), $composer, 24576, 0);
            $composer.endReplaceGroup();
        } else if (data instanceof VideoCard) {
            $composer.startReplaceGroup(-122418151);
            ComposerKt.sourceInformation($composer, "85@3535L41");
            this$0.videoPlayService.VideoCardContent(cardItem.getBasic(), (VideoCard) data, m, $composer, 0, 0);
            $composer.endReplaceGroup();
        } else if (data instanceof WebCard) {
            $composer.startReplaceGroup(-122277566);
            ComposerKt.sourceInformation($composer, "89@3677L32");
            this$0.webCardUIService.Content(cardItem.getBasic(), (WebCard) data, m, $composer, 0, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-122152915);
            ComposerKt.sourceInformation($composer, "93@3787L6");
            BoxKt.Box(m, $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$0(Object $data, BoxScope $this$DigitalCardContainer, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$DigitalCardContainer, "$this$DigitalCardContainer");
        ComposerKt.sourceInformation($composer, "C77@3251L155:DigitalCardListUIService.kt#v85lra");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-548194344, $changed, -1, "kntr.app.digital.preview.card.DigitalCardListUIService.Content.<anonymous>.<anonymous> (DigitalCardListUIService.kt:77)");
            }
            ImageModuleKt.ImageUI(((ImageCard) $data).getImage(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}