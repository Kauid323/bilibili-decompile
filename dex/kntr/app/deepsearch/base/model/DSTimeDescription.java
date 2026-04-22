package kntr.app.deepsearch.base.model;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DSTimeDescription.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0005\u0015\u0016\u0017\u0018\u0019J\u0016\u0010\n\u001a\u00020\u0000*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u0011\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u0012\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\f\u0010\u0013\u001a\u00020\u0003*\u00020\u0014H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0005\u001a\u001b\u001c\u001d\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/DSTimeDescription;", RoomRecommendViewModel.EMPTY_CURSOR, "desc", RoomRecommendViewModel.EMPTY_CURSOR, "getDesc", "()Ljava/lang/String;", "type", "Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "getType", "()Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "timeDescription", "Lkotlinx/datetime/Instant;", ReportBuildInParam.TIME_ZONE, "Lkotlinx/datetime/TimeZone;", "isSameDay", RoomRecommendViewModel.EMPTY_CURSOR, "isSameWeek", "isSameMonth", "isSameYear", "padZero", RoomRecommendViewModel.EMPTY_CURSOR, "Null", "Today", "Week", "Month", "Earlier", "Lkntr/app/deepsearch/base/model/DSTimeDescription$Earlier;", "Lkntr/app/deepsearch/base/model/DSTimeDescription$Month;", "Lkntr/app/deepsearch/base/model/DSTimeDescription$Null;", "Lkntr/app/deepsearch/base/model/DSTimeDescription$Today;", "Lkntr/app/deepsearch/base/model/DSTimeDescription$Week;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DSTimeDescription {
    String getDesc();

    DSTimeDescriptionType getType();

    String padZero(int i);

    DSTimeDescription timeDescription(Instant instant, TimeZone timeZone);

    /* compiled from: DSTimeDescription.kt */
    /* renamed from: kntr.app.deepsearch.base.model.DSTimeDescription$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ DSTimeDescription timeDescription$default(DSTimeDescription dSTimeDescription, Instant instant, TimeZone timeZone, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    timeZone = TimeZone.Companion.currentSystemDefault();
                }
                return dSTimeDescription.timeDescription(instant, timeZone);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: timeDescription");
        }

        public static DSTimeDescription $default$timeDescription(DSTimeDescription _this, Instant $this$timeDescription, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter($this$timeDescription, "<this>");
            Intrinsics.checkNotNullParameter(timeZone, ReportBuildInParam.TIME_ZONE);
            LocalDateTime msgDateTime = TimeZoneKt.toLocalDateTime($this$timeDescription, timeZone);
            if ($private$isSameDay(_this, $this$timeDescription, timeZone)) {
                return new Today(_this.padZero(msgDateTime.getHour()) + ":" + _this.padZero(msgDateTime.getMinute()), null, 2, null);
            } else if ($private$isSameWeek(_this, $this$timeDescription, timeZone)) {
                return new Week(msgDateTime.getMonthNumber() + "月" + msgDateTime.getDayOfMonth() + "日 " + _this.padZero(msgDateTime.getHour()) + ":" + _this.padZero(msgDateTime.getMinute()), null, 2, null);
            } else if ($private$isSameMonth(_this, $this$timeDescription, timeZone)) {
                return new Month(msgDateTime.getMonthNumber() + "月" + msgDateTime.getDayOfMonth() + "日 " + _this.padZero(msgDateTime.getHour()) + ":" + _this.padZero(msgDateTime.getMinute()), null, 2, null);
            } else {
                String desc = msgDateTime.getYear() + "年" + msgDateTime.getMonthNumber() + "月" + msgDateTime.getDayOfMonth() + "日 " + _this.padZero(msgDateTime.getHour()) + ":" + _this.padZero(msgDateTime.getMinute());
                if ($private$isSameYear(_this, $this$timeDescription, timeZone)) {
                    desc = msgDateTime.getMonthNumber() + "月" + msgDateTime.getDayOfMonth() + "日 " + _this.padZero(msgDateTime.getHour()) + ":" + _this.padZero(msgDateTime.getMinute());
                }
                return new Earlier(desc, null, 2, null);
            }
        }

        public static boolean $private$isSameDay(DSTimeDescription _this, Instant $this$isSameDay, TimeZone timeZone) {
            LocalDateTime currentDateTime = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), timeZone);
            LocalDateTime thisDateTime = TimeZoneKt.toLocalDateTime($this$isSameDay, timeZone);
            return currentDateTime.getYear() == thisDateTime.getYear() && currentDateTime.getMonth() == thisDateTime.getMonth() && currentDateTime.getDayOfMonth() == thisDateTime.getDayOfMonth();
        }

        public static boolean $private$isSameWeek(DSTimeDescription _this, Instant $this$isSameWeek, TimeZone timeZone) {
            int currentDateDayOfWeek = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), timeZone).getDayOfWeek().ordinal();
            int thisDateDayOfWeek = TimeZoneKt.toLocalDateTime($this$isSameWeek, timeZone).getDayOfWeek().ordinal();
            LocalDateTime currentDateWeekFirstDay = TimeZoneKt.toLocalDateTime(Instant.Companion.fromEpochMilliseconds(Clock.System.INSTANCE.now().toEpochMilliseconds() - ((currentDateDayOfWeek * 86400) * 1000)), timeZone);
            LocalDateTime thisDateDayWeekFirstDay = TimeZoneKt.toLocalDateTime(Instant.Companion.fromEpochMilliseconds($this$isSameWeek.toEpochMilliseconds() - ((86400 * thisDateDayOfWeek) * 1000)), timeZone);
            return currentDateWeekFirstDay.getYear() == thisDateDayWeekFirstDay.getYear() && currentDateWeekFirstDay.getMonth() == thisDateDayWeekFirstDay.getMonth() && currentDateWeekFirstDay.getDayOfMonth() == thisDateDayWeekFirstDay.getDayOfMonth();
        }

        public static boolean $private$isSameMonth(DSTimeDescription _this, Instant $this$isSameMonth, TimeZone timeZone) {
            LocalDateTime currentDateTime = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), timeZone);
            LocalDateTime thisDateTime = TimeZoneKt.toLocalDateTime($this$isSameMonth, timeZone);
            return currentDateTime.getYear() == thisDateTime.getYear() && currentDateTime.getMonth() == thisDateTime.getMonth();
        }

        public static boolean $private$isSameYear(DSTimeDescription _this, Instant $this$isSameYear, TimeZone timeZone) {
            LocalDateTime currentDateTime = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), timeZone);
            LocalDateTime thisDateTime = TimeZoneKt.toLocalDateTime($this$isSameYear, timeZone);
            return currentDateTime.getYear() == thisDateTime.getYear();
        }

        public static String $default$padZero(DSTimeDescription _this, int $this$padZero) {
            return StringsKt.padStart(String.valueOf($this$padZero), 2, '0');
        }
    }

    /* compiled from: DSTimeDescription.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lkntr/app/deepsearch/base/model/DSTimeDescription$Null;", "Lkntr/app/deepsearch/base/model/DSTimeDescription;", "<init>", "()V", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "getDesc", "()Ljava/lang/String;", "type", "Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "getType", "()Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Null implements DSTimeDescription {
        public static final Null INSTANCE = new Null();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Null) {
                Null r1 = (Null) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1201552087;
        }

        public String toString() {
            return "Null";
        }

        private Null() {
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ String padZero(int $this$padZero) {
            return CC.$default$padZero(this, $this$padZero);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ DSTimeDescription timeDescription(Instant $this$timeDescription, TimeZone timeZone) {
            return CC.$default$timeDescription(this, $this$timeDescription, timeZone);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public String getDesc() {
            return "Null";
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public DSTimeDescriptionType getType() {
            return DSTimeDescriptionType.Null;
        }
    }

    /* compiled from: DSTimeDescription.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/DSTimeDescription$Today;", "Lkntr/app/deepsearch/base/model/DSTimeDescription;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "type", "Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;)V", "getDesc", "()Ljava/lang/String;", "getType", "()Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Today implements DSTimeDescription {
        private final String desc;
        private final DSTimeDescriptionType type;

        public static /* synthetic */ Today copy$default(Today today, String str, DSTimeDescriptionType dSTimeDescriptionType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = today.desc;
            }
            if ((i & 2) != 0) {
                dSTimeDescriptionType = today.type;
            }
            return today.copy(str, dSTimeDescriptionType);
        }

        public final String component1() {
            return this.desc;
        }

        public final DSTimeDescriptionType component2() {
            return this.type;
        }

        public final Today copy(String str, DSTimeDescriptionType dSTimeDescriptionType) {
            Intrinsics.checkNotNullParameter(str, "desc");
            Intrinsics.checkNotNullParameter(dSTimeDescriptionType, "type");
            return new Today(str, dSTimeDescriptionType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Today) {
                Today today = (Today) obj;
                return Intrinsics.areEqual(this.desc, today.desc) && this.type == today.type;
            }
            return false;
        }

        public int hashCode() {
            return (this.desc.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            String str = this.desc;
            return "Today(desc=" + str + ", type=" + this.type + ")";
        }

        public Today(String desc, DSTimeDescriptionType type) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(type, "type");
            this.desc = desc;
            this.type = type;
        }

        public /* synthetic */ Today(String str, DSTimeDescriptionType dSTimeDescriptionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? DSTimeDescriptionType.Today : dSTimeDescriptionType);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ String padZero(int $this$padZero) {
            return CC.$default$padZero(this, $this$padZero);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ DSTimeDescription timeDescription(Instant $this$timeDescription, TimeZone timeZone) {
            return CC.$default$timeDescription(this, $this$timeDescription, timeZone);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public String getDesc() {
            return this.desc;
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public DSTimeDescriptionType getType() {
            return this.type;
        }
    }

    /* compiled from: DSTimeDescription.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/DSTimeDescription$Week;", "Lkntr/app/deepsearch/base/model/DSTimeDescription;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "type", "Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;)V", "getDesc", "()Ljava/lang/String;", "getType", "()Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Week implements DSTimeDescription {
        private final String desc;
        private final DSTimeDescriptionType type;

        public static /* synthetic */ Week copy$default(Week week, String str, DSTimeDescriptionType dSTimeDescriptionType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = week.desc;
            }
            if ((i & 2) != 0) {
                dSTimeDescriptionType = week.type;
            }
            return week.copy(str, dSTimeDescriptionType);
        }

        public final String component1() {
            return this.desc;
        }

        public final DSTimeDescriptionType component2() {
            return this.type;
        }

        public final Week copy(String str, DSTimeDescriptionType dSTimeDescriptionType) {
            Intrinsics.checkNotNullParameter(str, "desc");
            Intrinsics.checkNotNullParameter(dSTimeDescriptionType, "type");
            return new Week(str, dSTimeDescriptionType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Week) {
                Week week = (Week) obj;
                return Intrinsics.areEqual(this.desc, week.desc) && this.type == week.type;
            }
            return false;
        }

        public int hashCode() {
            return (this.desc.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            String str = this.desc;
            return "Week(desc=" + str + ", type=" + this.type + ")";
        }

        public Week(String desc, DSTimeDescriptionType type) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(type, "type");
            this.desc = desc;
            this.type = type;
        }

        public /* synthetic */ Week(String str, DSTimeDescriptionType dSTimeDescriptionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? DSTimeDescriptionType.Week : dSTimeDescriptionType);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ String padZero(int $this$padZero) {
            return CC.$default$padZero(this, $this$padZero);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ DSTimeDescription timeDescription(Instant $this$timeDescription, TimeZone timeZone) {
            return CC.$default$timeDescription(this, $this$timeDescription, timeZone);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public String getDesc() {
            return this.desc;
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public DSTimeDescriptionType getType() {
            return this.type;
        }
    }

    /* compiled from: DSTimeDescription.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/DSTimeDescription$Month;", "Lkntr/app/deepsearch/base/model/DSTimeDescription;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "type", "Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;)V", "getDesc", "()Ljava/lang/String;", "getType", "()Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Month implements DSTimeDescription {
        private final String desc;
        private final DSTimeDescriptionType type;

        public static /* synthetic */ Month copy$default(Month month, String str, DSTimeDescriptionType dSTimeDescriptionType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = month.desc;
            }
            if ((i & 2) != 0) {
                dSTimeDescriptionType = month.type;
            }
            return month.copy(str, dSTimeDescriptionType);
        }

        public final String component1() {
            return this.desc;
        }

        public final DSTimeDescriptionType component2() {
            return this.type;
        }

        public final Month copy(String str, DSTimeDescriptionType dSTimeDescriptionType) {
            Intrinsics.checkNotNullParameter(str, "desc");
            Intrinsics.checkNotNullParameter(dSTimeDescriptionType, "type");
            return new Month(str, dSTimeDescriptionType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Month) {
                Month month = (Month) obj;
                return Intrinsics.areEqual(this.desc, month.desc) && this.type == month.type;
            }
            return false;
        }

        public int hashCode() {
            return (this.desc.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            String str = this.desc;
            return "Month(desc=" + str + ", type=" + this.type + ")";
        }

        public Month(String desc, DSTimeDescriptionType type) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(type, "type");
            this.desc = desc;
            this.type = type;
        }

        public /* synthetic */ Month(String str, DSTimeDescriptionType dSTimeDescriptionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? DSTimeDescriptionType.Month : dSTimeDescriptionType);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ String padZero(int $this$padZero) {
            return CC.$default$padZero(this, $this$padZero);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ DSTimeDescription timeDescription(Instant $this$timeDescription, TimeZone timeZone) {
            return CC.$default$timeDescription(this, $this$timeDescription, timeZone);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public String getDesc() {
            return this.desc;
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public DSTimeDescriptionType getType() {
            return this.type;
        }
    }

    /* compiled from: DSTimeDescription.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/DSTimeDescription$Earlier;", "Lkntr/app/deepsearch/base/model/DSTimeDescription;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "type", "Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;)V", "getDesc", "()Ljava/lang/String;", "getType", "()Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Earlier implements DSTimeDescription {
        private final String desc;
        private final DSTimeDescriptionType type;

        public static /* synthetic */ Earlier copy$default(Earlier earlier, String str, DSTimeDescriptionType dSTimeDescriptionType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = earlier.desc;
            }
            if ((i & 2) != 0) {
                dSTimeDescriptionType = earlier.type;
            }
            return earlier.copy(str, dSTimeDescriptionType);
        }

        public final String component1() {
            return this.desc;
        }

        public final DSTimeDescriptionType component2() {
            return this.type;
        }

        public final Earlier copy(String str, DSTimeDescriptionType dSTimeDescriptionType) {
            Intrinsics.checkNotNullParameter(str, "desc");
            Intrinsics.checkNotNullParameter(dSTimeDescriptionType, "type");
            return new Earlier(str, dSTimeDescriptionType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Earlier) {
                Earlier earlier = (Earlier) obj;
                return Intrinsics.areEqual(this.desc, earlier.desc) && this.type == earlier.type;
            }
            return false;
        }

        public int hashCode() {
            return (this.desc.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            String str = this.desc;
            return "Earlier(desc=" + str + ", type=" + this.type + ")";
        }

        public Earlier(String desc, DSTimeDescriptionType type) {
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(type, "type");
            this.desc = desc;
            this.type = type;
        }

        public /* synthetic */ Earlier(String str, DSTimeDescriptionType dSTimeDescriptionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? DSTimeDescriptionType.Earlier : dSTimeDescriptionType);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ String padZero(int $this$padZero) {
            return CC.$default$padZero(this, $this$padZero);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public /* bridge */ DSTimeDescription timeDescription(Instant $this$timeDescription, TimeZone timeZone) {
            return CC.$default$timeDescription(this, $this$timeDescription, timeZone);
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public String getDesc() {
            return this.desc;
        }

        @Override // kntr.app.deepsearch.base.model.DSTimeDescription
        public DSTimeDescriptionType getType() {
            return this.type;
        }
    }

    /* compiled from: DSTimeDescription.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static DSTimeDescription timeDescription(DSTimeDescription $this, Instant $receiver, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            Intrinsics.checkNotNullParameter(timeZone, ReportBuildInParam.TIME_ZONE);
            return CC.$default$timeDescription($this, $receiver, timeZone);
        }

        @Deprecated
        public static String padZero(DSTimeDescription $this, int $receiver) {
            return CC.$default$padZero($this, $receiver);
        }
    }
}