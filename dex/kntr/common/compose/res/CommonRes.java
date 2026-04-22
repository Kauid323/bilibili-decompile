package kntr.common.compose.res;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import srcs.common.compose.res.generated.resources.Res;

/* compiled from: CommonRes.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/common/compose/res/CommonRes;", "", "<init>", "()V", "drawable", "Lsrcs/common/compose/res/generated/resources/Res$drawable;", "getDrawable", "()Lsrcs/common/compose/res/generated/resources/Res$drawable;", "string", "Lsrcs/common/compose/res/generated/resources/Res$string;", "getString", "()Lsrcs/common/compose/res/generated/resources/Res$string;", "compose-res_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommonRes {
    public static final int $stable = 0;
    public static final CommonRes INSTANCE = new CommonRes();
    private static final Res.drawable drawable = Res.drawable.INSTANCE;
    private static final Res.string string = Res.string.INSTANCE;

    private CommonRes() {
    }

    public final Res.drawable getDrawable() {
        return drawable;
    }

    public final Res.string getString() {
        return string;
    }
}