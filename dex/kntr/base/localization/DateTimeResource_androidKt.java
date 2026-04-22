package kntr.base.localization;

import bili.resource.localization.LocalizationRes;
import bili.resource.localization.Plurals0_commonMainKt;
import bili.resource.localization.String0_commonMainKt;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.util.Arrays;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.PluralStringResource;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: DateTimeResource.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"dateTimeResource", "Lkntr/base/localization/IDateTimeResource;", "getDateTimeResource", "()Lkntr/base/localization/IDateTimeResource;", "getStringResource", "Lorg/jetbrains/compose/resources/StringResource;", "Lkntr/base/localization/DateTimeStringID;", "getPluralStringResource", "Lorg/jetbrains/compose/resources/PluralStringResource;", "Lkntr/base/localization/DateTimePluralID;", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DateTimeResource_androidKt {
    private static final IDateTimeResource dateTimeResource = new IDateTimeResource() { // from class: kntr.base.localization.DateTimeResource_androidKt$dateTimeResource$1
        @Override // kntr.base.localization.IDateTimeResource
        public String getString(DateTimeStringID id) {
            StringResource stringResource;
            Intrinsics.checkNotNullParameter(id, "id");
            LocalizationRes localizationRes = LocalizationRes.INSTANCE;
            stringResource = DateTimeResource_androidKt.getStringResource(id);
            return localizationRes.getString(stringResource);
        }

        @Override // kntr.base.localization.IDateTimeResource
        public String getString(DateTimeStringID id, Object... args) {
            StringResource stringResource;
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(args, "args");
            LocalizationRes localizationRes = LocalizationRes.INSTANCE;
            stringResource = DateTimeResource_androidKt.getStringResource(id);
            return localizationRes.getString(stringResource, Arrays.copyOf(args, args.length));
        }

        @Override // kntr.base.localization.IDateTimeResource
        public String getPluralString(DateTimePluralID id, int quantity, Object... args) {
            PluralStringResource pluralStringResource;
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(args, "args");
            LocalizationRes localizationRes = LocalizationRes.INSTANCE;
            pluralStringResource = DateTimeResource_androidKt.getPluralStringResource(id);
            return localizationRes.getPluralString(pluralStringResource, quantity, Arrays.copyOf(args, args.length));
        }
    };

    /* compiled from: DateTimeResource.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DateTimeStringID.values().length];
            try {
                iArr[DateTimeStringID.JustNow.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DateTimeStringID.Yesterday.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DateTimeStringID.Today.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DateTimeStringID.Tomorrow.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DateTimeStringID.YearMonthDay.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DateTimeStringID.MonthDay.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DateTimeStringID.HourMinute.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[DateTimeStringID.MonthDayTime.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[DateTimeStringID.YearMonthDayTime.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[DateTimeStringID.Monday.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[DateTimeStringID.Tuesday.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[DateTimeStringID.Wednesday.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[DateTimeStringID.Thursday.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[DateTimeStringID.Friday.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[DateTimeStringID.Saturday.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[DateTimeStringID.Sunday.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DateTimePluralID.values().length];
            try {
                iArr2[DateTimePluralID.MinutesAgo.ordinal()] = 1;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr2[DateTimePluralID.HoursAgo.ordinal()] = 2;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr2[DateTimePluralID.DaysAgo.ordinal()] = 3;
            } catch (NoSuchFieldError e19) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final IDateTimeResource getDateTimeResource() {
        return dateTimeResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource getStringResource(DateTimeStringID $this$getStringResource) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$getStringResource.ordinal()]) {
            case 1:
                return String0_commonMainKt.getLocalization_global_string_9(LocalizationRes.INSTANCE.getString());
            case 2:
                return String0_commonMainKt.getLocalization_global_string_18(LocalizationRes.INSTANCE.getString());
            case 3:
                return String0_commonMainKt.getLocalization_global_string_7(LocalizationRes.INSTANCE.getString());
            case 4:
                return String0_commonMainKt.getLocalization_global_string_5(LocalizationRes.INSTANCE.getString());
            case 5:
                return String0_commonMainKt.getLocalization_global_string_2(LocalizationRes.INSTANCE.getString());
            case 6:
                return String0_commonMainKt.getLocalization_global_string_3(LocalizationRes.INSTANCE.getString());
            case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                return String0_commonMainKt.getLocalization_global_string_4(LocalizationRes.INSTANCE.getString());
            case 8:
                return String0_commonMainKt.getLocalization_global_string_16(LocalizationRes.INSTANCE.getString());
            case ConstantsKt.SPACER_9 /* 9 */:
                return String0_commonMainKt.getLocalization_global_string_19(LocalizationRes.INSTANCE.getString());
            case 10:
                return String0_commonMainKt.getLocalization_global_string_14(LocalizationRes.INSTANCE.getString());
            case MediaAttrUtils.TYPE_MENU /* 11 */:
                return String0_commonMainKt.getLocalization_global_string_10(LocalizationRes.INSTANCE.getString());
            case 12:
                return String0_commonMainKt.getLocalization_global_string_17(LocalizationRes.INSTANCE.getString());
            case 13:
                return String0_commonMainKt.getLocalization_global_string_15(LocalizationRes.INSTANCE.getString());
            case ConstantsKt.SPACER_14 /* 14 */:
                return String0_commonMainKt.getLocalization_global_string_1(LocalizationRes.INSTANCE.getString());
            case 15:
                return String0_commonMainKt.getLocalization_global_string_8(LocalizationRes.INSTANCE.getString());
            case 16:
                return String0_commonMainKt.getLocalization_global_string_12(LocalizationRes.INSTANCE.getString());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PluralStringResource getPluralStringResource(DateTimePluralID $this$getPluralStringResource) {
        switch (WhenMappings.$EnumSwitchMapping$1[$this$getPluralStringResource.ordinal()]) {
            case 1:
                return Plurals0_commonMainKt.getLocalization_global_string_20(LocalizationRes.INSTANCE.getPlurals());
            case 2:
                return Plurals0_commonMainKt.getLocalization_global_string_13(LocalizationRes.INSTANCE.getPlurals());
            case 3:
                return Plurals0_commonMainKt.getLocalization_global_string_11(LocalizationRes.INSTANCE.getPlurals());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}