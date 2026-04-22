package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IDateTimeResource.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u0001H&¢\u0006\u0002\u0010\bJ1\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u0001H&¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/base/localization/IDateTimeResource;", "", "getString", "", "id", "Lkntr/base/localization/DateTimeStringID;", "args", "", "(Lkntr/base/localization/DateTimeStringID;[Ljava/lang/Object;)Ljava/lang/String;", "getPluralString", "Lkntr/base/localization/DateTimePluralID;", "quantity", "", "(Lkntr/base/localization/DateTimePluralID;I[Ljava/lang/Object;)Ljava/lang/String;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDateTimeResource {
    String getPluralString(DateTimePluralID dateTimePluralID, int i, Object... objArr);

    String getString(DateTimeStringID dateTimeStringID);

    String getString(DateTimeStringID dateTimeStringID, Object... objArr);
}