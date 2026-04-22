package tv.danmaku.bili.splash.ad.services;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.converter.IParser;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashShowResponse;

/* compiled from: SplashGsonParser.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/splash/ad/services/SplashShowGsonParser;", "Lcom/bilibili/okretro/converter/IParser;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/splash/ad/model/SplashShowResponse;", "<init>", "()V", "convert", "value", "Lokhttp3/ResponseBody;", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashShowGsonParser implements IParser<GeneralResponse<SplashShowResponse>> {
    public static final int $stable = 0;

    /* JADX WARN: Type inference failed for: r2v0, types: [tv.danmaku.bili.splash.ad.services.SplashShowGsonParser$convert$response$1] */
    /* renamed from: convert */
    public GeneralResponse<SplashShowResponse> m1451convert(ResponseBody value) {
        Intrinsics.checkNotNullParameter(value, "value");
        GeneralResponse response = (GeneralResponse) SplashGsonParserKt.getGson().fromJson(value.charStream(), new TypeToken<GeneralResponse<SplashShowResponse>>() { // from class: tv.danmaku.bili.splash.ad.services.SplashShowGsonParser$convert$response$1
        }.getType());
        Intrinsics.checkNotNull(response);
        return response;
    }
}