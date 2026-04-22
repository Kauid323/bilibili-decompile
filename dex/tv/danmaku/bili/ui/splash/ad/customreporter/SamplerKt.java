package tv.danmaku.bili.ui.splash.ad.customreporter;

import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.splash.BuildConfig;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Sampler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0010\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0006\"\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\u000e\"'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0018\u001a\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u001b\u0010\u001b\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\u000e\"'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b0\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\u0013¨\u0006\u001f"}, d2 = {"", "eventType", "", "getEventSampler", "(Ljava/lang/String;)Z", "isCanaryVersionCode", "()Z", "defaultSampler$delegate", "Lkotlin/Lazy;", "getDefaultSampler", "defaultSampler", "", "defaultSamplerValue$delegate", "getDefaultSamplerValue", "()I", "defaultSamplerValue", "j$/util/concurrent/ConcurrentHashMap", "mSamplerCache$delegate", "getMSamplerCache", "()Lj$/util/concurrent/ConcurrentHashMap;", "mSamplerCache", "mSamplerSalt$delegate", "getMSamplerSalt", "()Ljava/lang/String;", "mSamplerSalt", "mRandomValue$delegate", "getMRandomValue", "mRandomValue", "mConfigSamplerMap$delegate", "getMConfigSamplerMap", "mConfigSamplerMap", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SamplerKt {
    private static final Lazy defaultSampler$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.customreporter.SamplerKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean defaultSampler_delegate$lambda$0;
            defaultSampler_delegate$lambda$0 = SamplerKt.defaultSampler_delegate$lambda$0();
            return Boolean.valueOf(defaultSampler_delegate$lambda$0);
        }
    });
    private static final Lazy defaultSamplerValue$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.customreporter.SamplerKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            int defaultSamplerValue_delegate$lambda$0;
            defaultSamplerValue_delegate$lambda$0 = SamplerKt.defaultSamplerValue_delegate$lambda$0();
            return Integer.valueOf(defaultSamplerValue_delegate$lambda$0);
        }
    });
    private static final Lazy mSamplerCache$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.customreporter.SamplerKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            ConcurrentHashMap mSamplerCache_delegate$lambda$0;
            mSamplerCache_delegate$lambda$0 = SamplerKt.mSamplerCache_delegate$lambda$0();
            return mSamplerCache_delegate$lambda$0;
        }
    });
    private static final Lazy mSamplerSalt$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.customreporter.SamplerKt$$ExternalSyntheticLambda3
        public final Object invoke() {
            String mSamplerSalt_delegate$lambda$0;
            mSamplerSalt_delegate$lambda$0 = SamplerKt.mSamplerSalt_delegate$lambda$0();
            return mSamplerSalt_delegate$lambda$0;
        }
    });
    private static final Lazy mRandomValue$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.customreporter.SamplerKt$$ExternalSyntheticLambda4
        public final Object invoke() {
            int mRandomValue_delegate$lambda$0;
            mRandomValue_delegate$lambda$0 = SamplerKt.mRandomValue_delegate$lambda$0();
            return Integer.valueOf(mRandomValue_delegate$lambda$0);
        }
    });
    private static final Lazy mConfigSamplerMap$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.customreporter.SamplerKt$$ExternalSyntheticLambda5
        public final Object invoke() {
            ConcurrentHashMap mConfigSamplerMap_delegate$lambda$0;
            mConfigSamplerMap_delegate$lambda$0 = SamplerKt.mConfigSamplerMap_delegate$lambda$0();
            return mConfigSamplerMap_delegate$lambda$0;
        }
    });

    private static final boolean getDefaultSampler() {
        return ((Boolean) defaultSampler$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean defaultSampler_delegate$lambda$0() {
        return BuildConfig.DEBUG || getMRandomValue() < getDefaultSamplerValue();
    }

    private static final int getDefaultSamplerValue() {
        return ((Number) defaultSamplerValue$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int defaultSamplerValue_delegate$lambda$0() {
        Integer intOrNull;
        String str = (String) ConfigManager.Companion.config().get("splash.custom_reporter_default_sampler", ConstsKt.ARG_STATE_DIALOG_SHOW);
        if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
            return 10;
        }
        return intOrNull.intValue();
    }

    private static final ConcurrentHashMap<String, Boolean> getMSamplerCache() {
        return (ConcurrentHashMap) mSamplerCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap mSamplerCache_delegate$lambda$0() {
        return new ConcurrentHashMap();
    }

    private static final String getMSamplerSalt() {
        return (String) mSamplerSalt$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mSamplerSalt_delegate$lambda$0() {
        String str = (String) ConfigManager.Companion.config().get("splash.custom_reporter_sampler_salt", ConstsKt.ARG_STATE_DIALOG_SHOW);
        return str == null ? "splash_sampler_salt" : str;
    }

    private static final int getMRandomValue() {
        return ((Number) mRandomValue$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int mRandomValue_delegate$lambda$0() {
        int hashCode = (BuvidHelper.getBuvid().hashCode() ^ getMSamplerSalt().hashCode()) % 100;
        return Math.abs(hashCode + ((((hashCode ^ 100) & ((-hashCode) | hashCode)) >> 31) & 100));
    }

    private static final ConcurrentHashMap<String, Integer> getMConfigSamplerMap() {
        return (ConcurrentHashMap) mConfigSamplerMap$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap mConfigSamplerMap_delegate$lambda$0() {
        String str = (String) ConfigManager.Companion.config().get("splash.custom_reporter_event_sampler", "");
        String config = str != null ? str : "";
        try {
            Iterable $this$associate$iv = StringsKt.split$default(config, new String[]{","}, false, 0, 6, (Object) null);
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associate$iv) {
                String it = (String) element$iv$iv;
                List map = StringsKt.split$default(it, new String[]{":"}, false, 0, 6, (Object) null);
                Pair pair = TuplesKt.to(map.get(0), Integer.valueOf(Integer.parseInt((String) map.get(1))));
                destination$iv$iv.put(pair.getFirst(), pair.getSecond());
            }
            return new ConcurrentHashMap(destination$iv$iv);
        } catch (Throwable th) {
            return new ConcurrentHashMap();
        }
    }

    public static final boolean getEventSampler(String eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        try {
            if (isCanaryVersionCode()) {
                return true;
            }
            if (getMSamplerCache().containsKey(eventType)) {
                Boolean bool = (Boolean) getMSamplerCache().get(eventType);
                return bool != null ? bool.booleanValue() : getDefaultSampler();
            } else if (!getMConfigSamplerMap().containsKey(eventType)) {
                return getDefaultSampler();
            } else {
                Integer num = (Integer) getMConfigSamplerMap().get(eventType);
                int value = num != null ? num.intValue() : getDefaultSamplerValue();
                boolean sampler = getMRandomValue() < value;
                getMSamplerCache().put(eventType, Boolean.valueOf(sampler));
                return sampler || BuildConfig.DEBUG;
            }
        } catch (Throwable th) {
            return getDefaultSampler();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025 A[Catch: Exception -> 0x0047, TRY_LEAVE, TryCatch #0 {Exception -> 0x0047, blocks: (B:3:0x0002, B:5:0x0018, B:12:0x0025), top: B:16:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean isCanaryVersionCode() {
        boolean z;
        try {
            String canaryVersionCodes = (String) ConfigManager.Companion.config().get("splash.canary_version_code", "");
            String str = canaryVersionCodes;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
                if (!z) {
                    return false;
                }
                return StringsKt.split$default(canaryVersionCodes, new String[]{","}, false, 0, 6, (Object) null).contains(String.valueOf(FoundationAlias.getFapps().getVersionCode()));
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            return false;
        }
    }
}