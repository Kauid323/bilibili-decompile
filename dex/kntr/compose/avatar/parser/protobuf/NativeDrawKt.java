package kntr.compose.avatar.parser.protobuf;

import com.bapis.bilibili.dagw.component.avatar.common.KNativeDrawRes;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.FillMode;
import kntr.compose.avatar.model.common.NativeDrawType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeDraw.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u0006*\u00060\u0004j\u0002`\u0007*\n\u0010\u0003\"\u00020\u00042\u00020\u0004¨\u0006\b"}, d2 = {"toDrawType", "Lkntr/compose/avatar/model/common/NativeDrawType;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KNativeDrawRes$KNativeDraw;", "PBFillMode", "Lcom/bapis/bilibili/dagw/component/avatar/common/KNativeDrawRes$KFillMode;", "toFillMode", "Lkntr/compose/avatar/model/common/FillMode;", "Lkntr/compose/avatar/parser/protobuf/PBFillMode;", "parser_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NativeDrawKt {
    public static final NativeDrawType toDrawType(KNativeDrawRes.KNativeDraw $this$toDrawType) {
        Intrinsics.checkNotNullParameter($this$toDrawType, "<this>");
        return Intrinsics.areEqual($this$toDrawType, KNativeDrawRes.KNativeDraw.DRAW_CIRCLE.INSTANCE) ? NativeDrawType.Circle : Intrinsics.areEqual($this$toDrawType, KNativeDrawRes.KNativeDraw.DRAW_RECTANGLE.INSTANCE) ? NativeDrawType.Rect : Intrinsics.areEqual($this$toDrawType, KNativeDrawRes.KNativeDraw.DRAW_INVALID.INSTANCE) ? NativeDrawType.Invalid : NativeDrawType.Invalid;
    }

    public static final FillMode toFillMode(KNativeDrawRes.KFillMode $this$toFillMode) {
        Intrinsics.checkNotNullParameter($this$toFillMode, "<this>");
        return Intrinsics.areEqual($this$toFillMode, KNativeDrawRes.KFillMode.FILL_MODE_INTERNAL.INSTANCE) ? FillMode.Fill : Intrinsics.areEqual($this$toFillMode, KNativeDrawRes.KFillMode.FILL_MODE_EDGE.INSTANCE) ? FillMode.Edge : FillMode.Fill;
    }
}