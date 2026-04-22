package srcs.base.localization.preview.generated.resources;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.LanguageQualifier;
import org.jetbrains.compose.resources.Qualifier;
import org.jetbrains.compose.resources.RegionQualifier;
import org.jetbrains.compose.resources.ResourceItem;
import org.jetbrains.compose.resources.StringResource;
import srcs.base.localization.preview.generated.resources.Res;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\b\u0010\b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004¨\u0006\u000f"}, d2 = {"datetime_format_column", "Lorg/jetbrains/compose/resources/StringResource;", "Lsrcs/base/localization/preview/generated/resources/Res$string;", "getDatetime_format_column", "(Lsrcs/base/localization/preview/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;", "init_datetime_format_column", "info_column", "getInfo_column", "init_info_column", "number_format_column", "getNumber_format_column", "init_number_format_column", ReportUtilKt.POS_TITLE, "getTitle", "init_title", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = BR.badgeVisibility)
public final class String0_commonMainKt {
    public static final StringResource getDatetime_format_column(Res.string $this$datetime_format_column) {
        Intrinsics.checkNotNullParameter($this$datetime_format_column, "<this>");
        return CommonMainString0.INSTANCE.getDatetime_format_column();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_datetime_format_column() {
        return new StringResource("string:datetime_format_column", "datetime_format_column", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.base.localization.preview.generated.resources/values/strings.commonMain.cvr", 10L, 50L)));
    }

    public static final StringResource getInfo_column(Res.string $this$info_column) {
        Intrinsics.checkNotNullParameter($this$info_column, "<this>");
        return CommonMainString0.INSTANCE.getInfo_column();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_info_column() {
        return new StringResource("string:info_column", "info_column", SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/srcs.base.localization.preview.generated.resources/values-en/strings.commonMain.cvr", 10L, 27L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/srcs.base.localization.preview.generated.resources/values-zh-rHK/strings.commonMain.cvr", 10L, 27L), new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.base.localization.preview.generated.resources/values/strings.commonMain.cvr", 61L, 27L)}));
    }

    public static final StringResource getNumber_format_column(Res.string $this$number_format_column) {
        Intrinsics.checkNotNullParameter($this$number_format_column, "<this>");
        return CommonMainString0.INSTANCE.getNumber_format_column();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_number_format_column() {
        return new StringResource("string:number_format_column", "number_format_column", SetsKt.setOf(new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.base.localization.preview.generated.resources/values/strings.commonMain.cvr", 89L, 48L)));
    }

    public static final StringResource getTitle(Res.string $this$title) {
        Intrinsics.checkNotNullParameter($this$title, "<this>");
        return CommonMainString0.INSTANCE.getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource init_title() {
        return new StringResource("string:title", ReportUtilKt.POS_TITLE, SetsKt.setOf(new ResourceItem[]{new ResourceItem(SetsKt.setOf(new LanguageQualifier("en")), "composeResources/srcs.base.localization.preview.generated.resources/values-en/strings.commonMain.cvr", 38L, 41L), new ResourceItem(SetsKt.setOf(new Qualifier[]{new LanguageQualifier("zh"), new RegionQualifier("HK")}), "composeResources/srcs.base.localization.preview.generated.resources/values-zh-rHK/strings.commonMain.cvr", 38L, 33L), new ResourceItem(SetsKt.emptySet(), "composeResources/srcs.base.localization.preview.generated.resources/values/strings.commonMain.cvr", 138L, 33L)}));
    }
}