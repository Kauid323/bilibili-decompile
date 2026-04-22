package srcs.base.localization.preview.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0013"}, d2 = {"Lsrcs/base/localization/preview/generated/resources/CommonMainString0;", "", "<init>", "()V", "datetime_format_column", "Lorg/jetbrains/compose/resources/StringResource;", "getDatetime_format_column", "()Lorg/jetbrains/compose/resources/StringResource;", "datetime_format_column$delegate", "Lkotlin/Lazy;", "info_column", "getInfo_column", "info_column$delegate", "number_format_column", "getNumber_format_column", "number_format_column$delegate", ReportUtilKt.POS_TITLE, "getTitle", "title$delegate", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy datetime_format_column$delegate = LazyKt.lazy(new Function0() { // from class: srcs.base.localization.preview.generated.resources.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource datetime_format_column_delegate$lambda$0;
            datetime_format_column_delegate$lambda$0 = CommonMainString0.datetime_format_column_delegate$lambda$0();
            return datetime_format_column_delegate$lambda$0;
        }
    });
    private static final Lazy info_column$delegate = LazyKt.lazy(new Function0() { // from class: srcs.base.localization.preview.generated.resources.CommonMainString0$$ExternalSyntheticLambda1
        public final Object invoke() {
            StringResource info_column_delegate$lambda$0;
            info_column_delegate$lambda$0 = CommonMainString0.info_column_delegate$lambda$0();
            return info_column_delegate$lambda$0;
        }
    });
    private static final Lazy number_format_column$delegate = LazyKt.lazy(new Function0() { // from class: srcs.base.localization.preview.generated.resources.CommonMainString0$$ExternalSyntheticLambda2
        public final Object invoke() {
            StringResource number_format_column_delegate$lambda$0;
            number_format_column_delegate$lambda$0 = CommonMainString0.number_format_column_delegate$lambda$0();
            return number_format_column_delegate$lambda$0;
        }
    });
    private static final Lazy title$delegate = LazyKt.lazy(new Function0() { // from class: srcs.base.localization.preview.generated.resources.CommonMainString0$$ExternalSyntheticLambda3
        public final Object invoke() {
            StringResource title_delegate$lambda$0;
            title_delegate$lambda$0 = CommonMainString0.title_delegate$lambda$0();
            return title_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource datetime_format_column_delegate$lambda$0() {
        StringResource init_datetime_format_column;
        init_datetime_format_column = String0_commonMainKt.init_datetime_format_column();
        return init_datetime_format_column;
    }

    public final StringResource getDatetime_format_column() {
        return (StringResource) datetime_format_column$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource info_column_delegate$lambda$0() {
        StringResource init_info_column;
        init_info_column = String0_commonMainKt.init_info_column();
        return init_info_column;
    }

    public final StringResource getInfo_column() {
        return (StringResource) info_column$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource number_format_column_delegate$lambda$0() {
        StringResource init_number_format_column;
        init_number_format_column = String0_commonMainKt.init_number_format_column();
        return init_number_format_column;
    }

    public final StringResource getNumber_format_column() {
        return (StringResource) number_format_column$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource title_delegate$lambda$0() {
        StringResource init_title;
        init_title = String0_commonMainKt.init_title();
        return init_title;
    }

    public final StringResource getTitle() {
        return (StringResource) title$delegate.getValue();
    }
}