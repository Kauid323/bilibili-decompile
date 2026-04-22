package kntr.app.digital.preview.card.video;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import com.bilibili.framework.simpleplayer.SimplePlayerView_androidKt;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.DigitalItemContainerKt;
import kntr.app.digital.preview.card.image.ImageModuleKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: VideoUIService.kt */
@BusinessScope
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/card/video/VideoUIService;", RoomRecommendViewModel.EMPTY_CURSOR, "videoPlayService", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "router", "Lkntr/base/router/Router;", "<init>", "(Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/base/router/Router;)V", "VideoCardContent", RoomRecommendViewModel.EMPTY_CURSOR, "cardBasic", "Lkntr/app/digital/preview/card/CardBasic;", "data", "Lkntr/app/digital/preview/card/video/VideoCard;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/digital/preview/card/CardBasic;Lkntr/app/digital/preview/card/video/VideoCard;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoUIService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final Router router;
    private final DigitalVideoPlayService videoPlayService;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoCardContent$lambda$1(VideoUIService videoUIService, CardBasic cardBasic, VideoCard videoCard, Modifier modifier, int i, int i2, Composer composer, int i3) {
        videoUIService.VideoCardContent(cardBasic, videoCard, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public VideoUIService(DigitalVideoPlayService videoPlayService, DigitalCardStateService cardStateService, Router router) {
        Intrinsics.checkNotNullParameter(videoPlayService, "videoPlayService");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(router, "router");
        this.videoPlayService = videoPlayService;
        this.cardStateService = cardStateService;
        this.router = router;
    }

    public final void VideoCardContent(final CardBasic cardBasic, final VideoCard data, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(cardBasic, "cardBasic");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer2 = $composer.startRestartGroup(-545671843);
        ComposerKt.sourceInformation($composer2, "C(VideoCardContent)N(cardBasic,data,modifier)40@1466L2501,35@1249L2718:VideoUIService.kt#9zxnub");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(cardBasic) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(data) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-545671843, $dirty2, -1, "kntr.app.digital.preview.card.video.VideoUIService.VideoCardContent (VideoUIService.kt:34)");
            }
            DigitalItemContainerKt.DigitalCardContainer(cardBasic.getFrameImg(), cardBasic.getLeftTopTagImg(), modifier4, cardBasic.getHasMask(), ComposableLambdaKt.rememberComposableLambda(-672954500, true, new Function3() { // from class: kntr.app.digital.preview.card.video.VideoUIService$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit VideoCardContent$lambda$0;
                    VideoCardContent$lambda$0 = VideoUIService.VideoCardContent$lambda$0(VideoUIService.this, cardBasic, data, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return VideoCardContent$lambda$0;
                }
            }, $composer2, 54), $composer2, ($dirty2 & 896) | 24576, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.card.video.VideoUIService$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoCardContent$lambda$1;
                    VideoCardContent$lambda$1 = VideoUIService.VideoCardContent$lambda$1(VideoUIService.this, cardBasic, data, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoCardContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0132, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0170, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit VideoCardContent$lambda$0(final VideoUIService this$0, CardBasic $cardBasic, final VideoCard $data, BoxScope $this$DigitalCardContainer, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$DigitalCardContainer, "$this$DigitalCardContainer");
        ComposerKt.sourceInformation($composer, "C46@1830L24,86@3790L163:VideoUIService.kt#9zxnub");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-672954500, $changed, -1, "kntr.app.digital.preview.card.video.VideoUIService.VideoCardContent.<anonymous> (VideoUIService.kt:41)");
            }
            int currentIndex = this$0.cardStateService.getIndex();
            boolean isCurrentCard = this$0.cardStateService.indexByCardId($cardBasic.getUniqueId()) == currentIndex;
            boolean videoViewVisible = this$0.videoPlayService.getVideoViewVisible();
            long currentProgress = this$0.videoPlayService.getCurrentProgress();
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope coroutineScope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (isCurrentCard) {
                $composer.startReplaceGroup(920308172);
                ComposerKt.sourceInformation($composer, "49@1913L211");
                SimplePlayerView_androidKt.SimplePlayerView-nJ1p8Q0(this$0.videoPlayService.getSimplePlayer(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, (ContentScale) null, 0L, true, $composer, 196656, 28);
                if ($data.getWithControl()) {
                    $composer.startReplaceGroup(920572850);
                    ComposerKt.sourceInformation($composer, "63@2689L489,73@3226L101,79@3507L199,56@2263L1470");
                    String caption = this$0.videoPlayService.getCurrentCaption();
                    long duration = $data.getDuration();
                    long trialDuration = $data.getTrialDuration();
                    boolean z = !this$0.videoPlayService.getSimplePlayer().getIntendToPlay();
                    boolean trial = $data.getTrial();
                    ComposerKt.sourceInformationMarkerStart($composer, 1830826821, "CC(remember):VideoUIService.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance(coroutineScope) | $composer.changedInstance(this$0);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function1() { // from class: kntr.app.digital.preview.card.video.VideoUIService$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit VideoCardContent$lambda$0$0$0;
                            VideoCardContent$lambda$0$0$0 = VideoUIService.VideoCardContent$lambda$0$0$0(coroutineScope, this$0, ((Long) obj).longValue());
                            return VideoCardContent$lambda$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    Function1 function1 = (Function1) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1830843617, "CC(remember):VideoUIService.kt#9igjgp");
                    boolean invalid$iv2 = $composer.changedInstance(this$0) | $composer.changedInstance($data);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv2 = new Function0() { // from class: kntr.app.digital.preview.card.video.VideoUIService$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit VideoCardContent$lambda$0$1$0;
                            VideoCardContent$lambda$0$1$0 = VideoUIService.VideoCardContent$lambda$0$1$0(VideoUIService.this, $data);
                            return VideoCardContent$lambda$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    Function0 function0 = (Function0) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1830852707, "CC(remember):VideoUIService.kt#9igjgp");
                    boolean invalid$iv3 = $composer.changedInstance(this$0);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: kntr.app.digital.preview.card.video.VideoUIService$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit VideoCardContent$lambda$0$2$0;
                                VideoCardContent$lambda$0$2$0 = VideoUIService.VideoCardContent$lambda$0$2$0(VideoUIService.this);
                                return VideoCardContent$lambda$0$2$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    DigitalVideoControlUIKt.DigitalVideoControlUI(duration, trialDuration, z, trial, caption, currentProgress, function1, function0, ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), $composer, 0, 0);
                } else {
                    $composer.startReplaceGroup(918372966);
                }
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(918372966);
            }
            $composer.endReplaceGroup();
            ImageModuleKt.ImageUI($data.getImage(), AlphaKt.alpha(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (isCurrentCard && videoViewVisible) ? 0.0f : 1.0f), null, $composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoCardContent$lambda$0$0$0(CoroutineScope $coroutineScope, VideoUIService this$0, long progress) {
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VideoUIService$VideoCardContent$1$1$1$1(this$0, progress, null), 3, (Object) null);
        this$0.videoPlayService.setIntendToPlay(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoCardContent$lambda$0$1$0(VideoUIService this$0, VideoCard $data) {
        this$0.router.launch(UrisKt.toUri($data.getTrialLink()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoCardContent$lambda$0$2$0(VideoUIService this$0) {
        this$0.videoPlayService.setIntendToPlay(!this$0.videoPlayService.getSimplePlayer().getIntendToPlay());
        return Unit.INSTANCE;
    }
}