package tv.danmaku.bili.ui.favorites.api;

import com.bilibili.lib.gson.GsonUtils;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.converter.IParser;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.model.FollowResponse;

/* compiled from: FavoritesParser.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/favorites/api/FavoritesFollowParser;", "Lcom/bilibili/okretro/converter/IParser;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/favorites/model/FollowResponse;", "<init>", "()V", "convert", "value", "Lokhttp3/ResponseBody;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesFollowParser implements IParser<GeneralResponse<FollowResponse>> {
    public static final int $stable = 0;

    /* renamed from: convert */
    public GeneralResponse<FollowResponse> m1613convert(ResponseBody value) {
        Intrinsics.checkNotNullParameter(value, "value");
        GeneralResponse $this$convert_u24lambda_u240 = new GeneralResponse();
        JsonObject jsonObject = (JsonObject) GsonUtils.parse(value.string(), JsonObject.class);
        $this$convert_u24lambda_u240.data = GsonUtils.parse(jsonObject.get("data").toString(), FollowResponse.class);
        return $this$convert_u24lambda_u240;
    }
}