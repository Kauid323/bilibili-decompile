package tv.danmaku.bili.splash.ad.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;

/* compiled from: SplashGsonParser.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashGsonParserKt {
    private static final Lazy gson$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.splash.ad.services.SplashGsonParserKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Gson gson_delegate$lambda$0;
            gson_delegate$lambda$0 = SplashGsonParserKt.gson_delegate$lambda$0();
            return gson_delegate$lambda$0;
        }
    });

    public static final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new GsonBuilder().create();
    }
}