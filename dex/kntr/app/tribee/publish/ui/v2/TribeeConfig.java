package kntr.app.tribee.publish.ui.v2;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TribeeConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\u00020\u00058FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkntr/app/tribee/publish/ui/v2/TribeeConfig;", "", "<init>", "()V", "usePublishV2", "", "getUsePublishV2$annotations", "getUsePublishV2", "()Z", "usePublishV2$delegate", "Lkotlin/Lazy;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeConfig {
    public static final TribeeConfig INSTANCE = new TribeeConfig();
    private static final Lazy usePublishV2$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeeConfig$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean usePublishV2_delegate$lambda$0;
            usePublishV2_delegate$lambda$0 = TribeeConfig.usePublishV2_delegate$lambda$0();
            return Boolean.valueOf(usePublishV2_delegate$lambda$0);
        }
    });
    public static final int $stable = 8;

    public static /* synthetic */ void getUsePublishV2$annotations() {
    }

    private TribeeConfig() {
    }

    public final boolean getUsePublishV2() {
        return ((Boolean) usePublishV2$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean usePublishV2_delegate$lambda$0() {
        return KConfig.INSTANCE.ff("tribee.use_publish_v2", true);
    }
}