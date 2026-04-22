package kntr.app.ad.domain.track;

import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* compiled from: AdTrackSampler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\u001a\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\b\u001a\u00020\u00038@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005\"\u001b\u0010\u000b\u001a\u00020\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\r\u0010\u000e\"\u001b\u0010\u0010\u001a\u00020\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000e\"\u001b\u0010\u0013\u001a\u00020\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0019"}, d2 = {"TAG", RoomRecommendViewModel.EMPTY_CURSOR, "track_toggle", RoomRecommendViewModel.EMPTY_CURSOR, "getTrack_toggle", "()Z", "track_toggle$delegate", "Lkotlin/Lazy;", "param_with_large_param", "getParam_with_large_param", "param_with_large_param$delegate", "data_sampler", RoomRecommendViewModel.EMPTY_CURSOR, "getData_sampler", "()I", "data_sampler$delegate", "action_sampler", "getAction_sampler", "action_sampler$delegate", "report_sampler", "getReport_sampler", "report_sampler$delegate", "getAlarmSampler", "key", "default", "track_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdTrackSamplerKt {
    private static final String TAG = "AdTrackSampler";
    private static final Lazy track_toggle$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.track.AdTrackSamplerKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean track_toggle_delegate$lambda$0;
            track_toggle_delegate$lambda$0 = AdTrackSamplerKt.track_toggle_delegate$lambda$0();
            return Boolean.valueOf(track_toggle_delegate$lambda$0);
        }
    });
    private static final Lazy param_with_large_param$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.track.AdTrackSamplerKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean param_with_large_param_delegate$lambda$0;
            param_with_large_param_delegate$lambda$0 = AdTrackSamplerKt.param_with_large_param_delegate$lambda$0();
            return Boolean.valueOf(param_with_large_param_delegate$lambda$0);
        }
    });
    private static final Lazy data_sampler$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.track.AdTrackSamplerKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            int data_sampler_delegate$lambda$0;
            data_sampler_delegate$lambda$0 = AdTrackSamplerKt.data_sampler_delegate$lambda$0();
            return Integer.valueOf(data_sampler_delegate$lambda$0);
        }
    });
    private static final Lazy action_sampler$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.track.AdTrackSamplerKt$$ExternalSyntheticLambda3
        public final Object invoke() {
            int action_sampler_delegate$lambda$0;
            action_sampler_delegate$lambda$0 = AdTrackSamplerKt.action_sampler_delegate$lambda$0();
            return Integer.valueOf(action_sampler_delegate$lambda$0);
        }
    });
    private static final Lazy report_sampler$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.track.AdTrackSamplerKt$$ExternalSyntheticLambda4
        public final Object invoke() {
            int report_sampler_delegate$lambda$0;
            report_sampler_delegate$lambda$0 = AdTrackSamplerKt.report_sampler_delegate$lambda$0();
            return Integer.valueOf(report_sampler_delegate$lambda$0);
        }
    });

    public static final boolean getTrack_toggle() {
        return ((Boolean) track_toggle$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean track_toggle_delegate$lambda$0() {
        return IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "cm.ff.tt_track_enable", false, 2, (Object) null);
    }

    public static final boolean getParam_with_large_param() {
        return ((Boolean) param_with_large_param$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean param_with_large_param_delegate$lambda$0() {
        return IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "cm.ff.tt_track_param_with_large_param", false, 2, (Object) null);
    }

    public static final int getData_sampler() {
        return ((Number) data_sampler$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int data_sampler_delegate$lambda$0() {
        return getAlarmSampler("cm.config.tt_track_data_rate", 100);
    }

    public static final int getAction_sampler() {
        return ((Number) action_sampler$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int action_sampler_delegate$lambda$0() {
        return getAlarmSampler("cm.config.tt_track_action_rate", 100);
    }

    public static final int getReport_sampler() {
        return ((Number) report_sampler$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int report_sampler_delegate$lambda$0() {
        return getAlarmSampler("cm.config.tt_track_report_rate", 5);
    }

    private static final int getAlarmSampler(String key, int i) {
        String obj;
        Integer intOrNull;
        String config = KConfig.INSTANCE.config(key, String.valueOf(i));
        int intValue = (config == null || (obj = StringsKt.trim(config).toString()) == null || (intOrNull = StringsKt.toIntOrNull(obj)) == null) ? i : intOrNull.intValue();
        int it = intValue;
        Logger_androidKt.getAdLog().i(TAG, key + ", sampler: " + it);
        return intValue;
    }
}