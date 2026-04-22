package kntr.common.behavior.prediction.impl;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2 = {"Lkntr/common/behavior/prediction/impl/DateUtilsModel;", "", "time", "", "<init>", "(J)V", "getTime", "()J", "date", "Lkotlinx/datetime/LocalDateTime;", "getDate", "()Lkotlinx/datetime/LocalDateTime;", "date$delegate", "Lkotlin/Lazy;", "holidayType", "", "getHolidayType", "()I", "holidayType$delegate", "vacationType", "getVacationType", "vacationType$delegate", "hourType", "getHourType", "hourType$delegate", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DateUtilsModel {
    private final Lazy date$delegate;
    private final Lazy holidayType$delegate;
    private final Lazy hourType$delegate;
    private final long time;
    private final Lazy vacationType$delegate;

    public DateUtilsModel() {
        this(0L, 1, null);
    }

    public DateUtilsModel(long time) {
        this.time = time;
        this.date$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.behavior.prediction.impl.DateUtilsModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                LocalDateTime date_delegate$lambda$0;
                date_delegate$lambda$0 = DateUtilsModel.date_delegate$lambda$0(DateUtilsModel.this);
                return date_delegate$lambda$0;
            }
        });
        this.holidayType$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.behavior.prediction.impl.DateUtilsModel$$ExternalSyntheticLambda1
            public final Object invoke() {
                int holidayType_delegate$lambda$0;
                holidayType_delegate$lambda$0 = DateUtilsModel.holidayType_delegate$lambda$0(DateUtilsModel.this);
                return Integer.valueOf(holidayType_delegate$lambda$0);
            }
        });
        this.vacationType$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.behavior.prediction.impl.DateUtilsModel$$ExternalSyntheticLambda2
            public final Object invoke() {
                int vacationType_delegate$lambda$0;
                vacationType_delegate$lambda$0 = DateUtilsModel.vacationType_delegate$lambda$0(DateUtilsModel.this);
                return Integer.valueOf(vacationType_delegate$lambda$0);
            }
        });
        this.hourType$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.behavior.prediction.impl.DateUtilsModel$$ExternalSyntheticLambda3
            public final Object invoke() {
                int hourType_delegate$lambda$0;
                hourType_delegate$lambda$0 = DateUtilsModel.hourType_delegate$lambda$0(DateUtilsModel.this);
                return Integer.valueOf(hourType_delegate$lambda$0);
            }
        });
    }

    public /* synthetic */ DateUtilsModel(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UtilsKt.currentTimestamp() : j);
    }

    public final long getTime() {
        return this.time;
    }

    private final LocalDateTime getDate() {
        return (LocalDateTime) this.date$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalDateTime date_delegate$lambda$0(DateUtilsModel this$0) {
        return TimeZoneKt.toLocalDateTime(Instant.Companion.fromEpochMilliseconds(this$0.time), TimeZone.Companion.of("Asia/Shanghai"));
    }

    public final int getHolidayType() {
        return ((Number) this.holidayType$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int holidayType_delegate$lambda$0(DateUtilsModel this$0) {
        switch (DayOfWeekKt.getIsoDayNumber(this$0.getDate().getDayOfWeek())) {
            case 6:
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                return 1;
            default:
                return 0;
        }
    }

    public final int getVacationType() {
        return ((Number) this.vacationType$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int vacationType_delegate$lambda$0(DateUtilsModel this$0) {
        switch (this$0.getDate().getMonthNumber()) {
            case 2:
                return 2;
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
            case 8:
                return 1;
            default:
                return 3;
        }
    }

    public final int getHourType() {
        return ((Number) this.hourType$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int hourType_delegate$lambda$0(DateUtilsModel this$0) {
        int hour = this$0.getDate().getHour();
        boolean z = false;
        if (5 <= hour && hour < 11) {
            return 2;
        }
        if (11 <= hour && hour < 13) {
            return 3;
        }
        if (13 <= hour && hour < 18) {
            return 4;
        }
        if (18 <= hour && hour < 22) {
            z = true;
        }
        return z ? 5 : 1;
    }
}