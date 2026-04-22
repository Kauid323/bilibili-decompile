package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.format.TimeFieldContainer;
import kotlinx.datetime.internal.DecimalFraction;

/* compiled from: LocalDateTimeFormat.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/DateTimeFieldContainer;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/format/TimeFieldContainer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface DateTimeFieldContainer extends DateFieldContainer, TimeFieldContainer {

    /* compiled from: LocalDateTimeFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static DecimalFraction getFractionOfSecond(DateTimeFieldContainer $this) {
            return TimeFieldContainer.DefaultImpls.getFractionOfSecond($this);
        }

        public static void setFractionOfSecond(DateTimeFieldContainer $this, DecimalFraction value) {
            TimeFieldContainer.DefaultImpls.setFractionOfSecond($this, value);
        }
    }
}