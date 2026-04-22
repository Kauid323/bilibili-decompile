package kntr.app.upper.entrance.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;

/* compiled from: FeatureConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/upper/entrance/utils/FeatureConfig;", "", "<init>", "()V", "transferFlag", "", "getTransferFlag", "()Z", "transferFlag$delegate", "Lkotlin/Lazy;", "enableAbNewCacheKey", "getEnableAbNewCacheKey", "enableAbNewCacheKey$delegate", "enableCoupon", "getEnableCoupon", "enableCoupon$delegate", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FeatureConfig {
    public static final FeatureConfig INSTANCE = new FeatureConfig();
    private static final Lazy transferFlag$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.utils.FeatureConfig$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean transferFlag_delegate$lambda$0;
            transferFlag_delegate$lambda$0 = FeatureConfig.transferFlag_delegate$lambda$0();
            return Boolean.valueOf(transferFlag_delegate$lambda$0);
        }
    });
    private static final Lazy enableAbNewCacheKey$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.utils.FeatureConfig$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean enableAbNewCacheKey_delegate$lambda$0;
            enableAbNewCacheKey_delegate$lambda$0 = FeatureConfig.enableAbNewCacheKey_delegate$lambda$0();
            return Boolean.valueOf(enableAbNewCacheKey_delegate$lambda$0);
        }
    });
    private static final Lazy enableCoupon$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.utils.FeatureConfig$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean enableCoupon_delegate$lambda$0;
            enableCoupon_delegate$lambda$0 = FeatureConfig.enableCoupon_delegate$lambda$0();
            return Boolean.valueOf(enableCoupon_delegate$lambda$0);
        }
    });

    private FeatureConfig() {
    }

    public final boolean getTransferFlag() {
        return ((Boolean) transferFlag$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean transferFlag_delegate$lambda$0() {
        boolean m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(Boolean.valueOf(IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "uper.center_plus_bubble_transfer_log_switch", false, 2, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
            m2636constructorimpl = false;
        }
        return ((Boolean) m2636constructorimpl).booleanValue();
    }

    public final boolean getEnableAbNewCacheKey() {
        return ((Boolean) enableAbNewCacheKey$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableAbNewCacheKey_delegate$lambda$0() {
        return IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "uper.enable_app_launch_ab_new_cache_key", false, 2, null);
    }

    public final boolean getEnableCoupon() {
        return ((Boolean) enableCoupon$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableCoupon_delegate$lambda$0() {
        boolean m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(Boolean.valueOf(IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "uper.enable_bubble_coupon", false, 2, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
            m2636constructorimpl = true;
        }
        return ((Boolean) m2636constructorimpl).booleanValue();
    }
}