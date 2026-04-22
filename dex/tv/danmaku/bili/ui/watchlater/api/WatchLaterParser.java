package tv.danmaku.bili.ui.watchlater.api;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.converter.IParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterResponse;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterParser.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/api/WatchLaterParser;", "Lcom/bilibili/okretro/converter/IParser;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterResponse;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "convert", "value", "Lokhttp3/ResponseBody;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterParser implements IParser<GeneralResponse<WatchLaterResponse>> {
    public static final WatchLaterParser INSTANCE = new WatchLaterParser();
    private static final Gson gson = new Gson();
    public static final int $stable = 8;

    private WatchLaterParser() {
    }

    public final Gson getGson() {
        return gson;
    }

    /* renamed from: convert */
    public GeneralResponse<WatchLaterResponse> m1771convert(ResponseBody value) {
        Intrinsics.checkNotNullParameter(value, "value");
        GeneralResponse response = new GeneralResponse();
        JsonObject jsonObject = (JsonObject) gson.fromJson(value.string(), JsonObject.class);
        response.code = jsonObject.get("code").getAsInt();
        response.message = jsonObject.get("message").getAsString();
        response.ttl = jsonObject.get("ttl").getAsInt();
        response.data = gson.fromJson(jsonObject.get("data"), WatchLaterResponse.class);
        return response;
    }
}