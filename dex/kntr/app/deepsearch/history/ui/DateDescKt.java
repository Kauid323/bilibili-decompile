package kntr.app.deepsearch.history.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kntr.app.deepsearch.base.model.DSTimeDescriptionType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;
import srcs.app.deepsearch.history.ui.generated.resources.Res;
import srcs.app.deepsearch.history.ui.generated.resources.String0_commonMainKt;

/* compiled from: DateDesc.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"desc", "Lorg/jetbrains/compose/resources/StringResource;", "Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "getDesc", "(Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;Landroidx/compose/runtime/Composer;I)Lorg/jetbrains/compose/resources/StringResource;", "history-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DateDescKt {

    /* compiled from: DateDesc.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DSTimeDescriptionType.values().length];
            try {
                iArr[DSTimeDescriptionType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DSTimeDescriptionType.Today.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DSTimeDescriptionType.Week.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DSTimeDescriptionType.Month.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DSTimeDescriptionType.Earlier.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final StringResource getDesc(DSTimeDescriptionType $this$desc, Composer $composer, int $changed) {
        StringResource stringResource;
        Intrinsics.checkNotNullParameter($this$desc, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -125659485, "C(<get-desc>):DateDesc.kt#a2kngy");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-125659485, $changed, -1, "kntr.app.deepsearch.history.ui.<get-desc> (DateDesc.kt:13)");
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$this$desc.ordinal()]) {
            case 1:
                stringResource = null;
                break;
            case 2:
                stringResource = String0_commonMainKt.getHistory_group_today(Res.string.INSTANCE);
                break;
            case 3:
                stringResource = String0_commonMainKt.getHistory_group_week(Res.string.INSTANCE);
                break;
            case 4:
                stringResource = String0_commonMainKt.getHistory_group_month(Res.string.INSTANCE);
                break;
            case 5:
                stringResource = String0_commonMainKt.getHistory_group_earlier(Res.string.INSTANCE);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stringResource;
    }
}