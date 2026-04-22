package kntr.base.dd.impl.internal.decide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.UtilsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.Utils$Companion$decodeFromString$json$1;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: DDBucket.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DDBucket;", "", "logic", "", "salt", "low", "", "high", "count", "pName", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "getPName", "()Ljava/lang/String;", "decide", "", "pValue", "hash", "string", "mod", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDBucket {
    private final int count;
    private final int high;
    private final String logic;
    private final int low;
    private final String pName;
    private final String salt;
    public static final Companion Companion = new Companion(null);
    private static final List<String> ALLOW_LOGIC = CollectionsKt.listOf(new String[]{"u", "um", "dm"});

    public DDBucket(String logic, String salt, int low, int high, int count, String pName) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        Intrinsics.checkNotNullParameter(salt, "salt");
        Intrinsics.checkNotNullParameter(pName, "pName");
        this.logic = logic;
        this.salt = salt;
        this.low = low;
        this.high = high;
        this.count = count;
        this.pName = pName;
    }

    public final String getPName() {
        return this.pName;
    }

    /* compiled from: DDBucket.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DDBucket$Companion;", "", "<init>", "()V", "ALLOW_LOGIC", "", "", "decodeFromString", "Lkntr/base/dd/impl/internal/decide/DDBucket;", "string", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DDBucket decodeFromString(String string) {
            Object obj;
            String salt;
            Integer intOrNull;
            Iterable split$default;
            Utils.Companion companion = Utils.Companion;
            if (string == null) {
                obj = null;
            } else {
                try {
                    Json json$iv = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                    json$iv.getSerializersModule();
                    obj = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE)), string);
                } catch (Exception e$iv) {
                    DDConst dDConst = DDConst.INSTANCE;
                    String message = e$iv.getMessage();
                    if (message == null) {
                        message = "undefined";
                    }
                    DDConst.logE$default(dDConst, "decodeFromString error ," + message, null, 2, null);
                    obj = null;
                }
            }
            Map map = (Map) obj;
            if (map == null || (salt = (String) map.get("s")) == null) {
                return null;
            }
            String str = (String) map.get("bc");
            if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                int it = intOrNull.intValue();
                int it2 = it > 0 ? 1 : 0;
                if (it2 == 0) {
                    intOrNull = null;
                }
                if (intOrNull != null) {
                    int bucketCount = intOrNull.intValue();
                    String logic = (String) map.get("l");
                    if (logic != null) {
                        if (!DDBucket.ALLOW_LOGIC.contains(logic)) {
                            logic = null;
                        }
                        if (logic == null) {
                            return null;
                        }
                        String pName = Intrinsics.areEqual(logic, "dm") ? "buvid" : "mid";
                        String str2 = (String) map.get("b");
                        if (str2 != null && (split$default = StringsKt.split$default(str2, new String[]{"~"}, false, 0, 6, (Object) null)) != null) {
                            Iterable $this$map$iv = split$default;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                String it3 = (String) item$iv$iv;
                                destination$iv$iv.add(StringsKt.toIntOrNull(it3));
                            }
                            List it4 = (List) destination$iv$iv;
                            List it5 = it4.size() == 2 ? 1 : null;
                            if (it5 == null) {
                                it4 = null;
                            }
                            if (it4 != null) {
                                List bArray = it4;
                                Integer num = (Integer) bArray.get(0);
                                if (num != null) {
                                    int bucketLow = num.intValue();
                                    Integer num2 = (Integer) bArray.get(1);
                                    if (num2 != null) {
                                        int bucketHigh = num2.intValue();
                                        return new DDBucket(logic, salt, bucketLow, bucketHigh, bucketCount, pName);
                                    }
                                    return null;
                                }
                                return null;
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public final boolean decide(String pValue) {
        int hashCode;
        Intrinsics.checkNotNullParameter(pValue, "pValue");
        if (this.low < 0 || this.high < 0 || this.high < this.low) {
            return false;
        }
        if (StringsKt.isBlank(pValue) || Intrinsics.areEqual(pValue, "0")) {
            return Intrinsics.areEqual(this.logic, "dm") && (this.high - this.low) + 1 >= this.count;
        } else if ((this.high - this.low) + 1 >= this.count) {
            return true;
        } else {
            if (Intrinsics.areEqual(this.logic, "u")) {
                Long longOrNull = StringsKt.toLongOrNull(pValue);
                hashCode = (int) ((longOrNull != null ? longOrNull.longValue() : Long.MAX_VALUE) % this.count);
            } else {
                hashCode = hash(pValue + this.salt, this.count);
            }
            return hashCode <= this.high && this.low <= hashCode;
        }
    }

    private final int hash(String string, int mod) {
        String upperCase = UtilsKt.md5String(string).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        int hashCode = upperCase.hashCode() % mod;
        return hashCode < 0 ? hashCode + mod : hashCode;
    }
}