package kntr.app.ad.domain.alarm;

import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* compiled from: AdAlarmSampler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\b\u001a\u00020\t8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b\"\u001b\u0010\r\u001a\u00020\t8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000b\"\u001b\u0010\u0010\u001a\u00020\t8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000b\"\u001b\u0010\u0013\u001a\u00020\t8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0019"}, d2 = {"TAG", RoomRecommendViewModel.EMPTY_CURSOR, "alarm_toggle", RoomRecommendViewModel.EMPTY_CURSOR, "getAlarm_toggle", "()Z", "alarm_toggle$delegate", "Lkotlin/Lazy;", "data_sampler", RoomRecommendViewModel.EMPTY_CURSOR, "getData_sampler", "()I", "data_sampler$delegate", "click_sampler", "getClick_sampler", "click_sampler$delegate", "status_sampler", "getStatus_sampler", "status_sampler$delegate", "report_sampler", "getReport_sampler", "report_sampler$delegate", "getAlarmSampler", "key", "default", "alarm_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdAlarmSamplerKt {
    private static final String TAG = "AdAlarmSampler";
    private static final Lazy alarm_toggle$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.alarm.AdAlarmSamplerKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean alarm_toggle_delegate$lambda$0;
            alarm_toggle_delegate$lambda$0 = AdAlarmSamplerKt.alarm_toggle_delegate$lambda$0();
            return Boolean.valueOf(alarm_toggle_delegate$lambda$0);
        }
    });
    private static final Lazy data_sampler$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.alarm.AdAlarmSamplerKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            int data_sampler_delegate$lambda$0;
            data_sampler_delegate$lambda$0 = AdAlarmSamplerKt.data_sampler_delegate$lambda$0();
            return Integer.valueOf(data_sampler_delegate$lambda$0);
        }
    });
    private static final Lazy click_sampler$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.alarm.AdAlarmSamplerKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            int click_sampler_delegate$lambda$0;
            click_sampler_delegate$lambda$0 = AdAlarmSamplerKt.click_sampler_delegate$lambda$0();
            return Integer.valueOf(click_sampler_delegate$lambda$0);
        }
    });
    private static final Lazy status_sampler$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.alarm.AdAlarmSamplerKt$$ExternalSyntheticLambda3
        public final Object invoke() {
            int status_sampler_delegate$lambda$0;
            status_sampler_delegate$lambda$0 = AdAlarmSamplerKt.status_sampler_delegate$lambda$0();
            return Integer.valueOf(status_sampler_delegate$lambda$0);
        }
    });
    private static final Lazy report_sampler$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.alarm.AdAlarmSamplerKt$$ExternalSyntheticLambda4
        public final Object invoke() {
            int report_sampler_delegate$lambda$0;
            report_sampler_delegate$lambda$0 = AdAlarmSamplerKt.report_sampler_delegate$lambda$0();
            return Integer.valueOf(report_sampler_delegate$lambda$0);
        }
    });

    public static final boolean getAlarm_toggle() {
        return ((Boolean) alarm_toggle$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean alarm_toggle_delegate$lambda$0() {
        return IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "cm.ff.tt_alarm_enable", false, 2, (Object) null);
    }

    public static final int getData_sampler() {
        return ((Number) data_sampler$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int data_sampler_delegate$lambda$0() {
        return getAlarmSampler("cm.config.tt_data_rate", 5);
    }

    public static final int getClick_sampler() {
        return ((Number) click_sampler$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int click_sampler_delegate$lambda$0() {
        return getAlarmSampler("cm.config.tt_click_rate", 100);
    }

    public static final int getStatus_sampler() {
        return ((Number) status_sampler$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int status_sampler_delegate$lambda$0() {
        return getAlarmSampler("cm.config.tt_status_rate", 80);
    }

    public static final int getReport_sampler() {
        return ((Number) report_sampler$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int report_sampler_delegate$lambda$0() {
        return getAlarmSampler("cm.config.tt_report_rate", 5);
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