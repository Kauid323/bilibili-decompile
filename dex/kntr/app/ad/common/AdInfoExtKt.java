package kntr.app.ad.common;

import com.bapis.bilibili.ad.v1.KAdContentExtraDto;
import com.bapis.bilibili.ad.v1.KAdDto;
import com.bapis.bilibili.ad.v1.KSourceContentDto;
import com.bapis.bilibili.app.card.v1.KAdInfo;
import com.google.protobuf.KInt32Value;
import java.util.Map;
import kntr.app.ad.common.model.AdInfo;
import kntr.app.ad.common.model.AdInfoExtra;
import kntr.app.ad.common.model.AdSourceContent;
import kntr.app.ad.common.model.AdSourceContentKt;
import kntr.app.ad.common.protocol.IAdInfo;
import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: AdInfoExt.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0007\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0006H\u0007\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"asAdInfo", "Lkntr/app/ad/common/protocol/IAdInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "isSourceContentFormat", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/card/v1/KAdInfo;", "Lcom/bapis/bilibili/ad/v1/KSourceContentDto;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/json/JsonObject;", "dto_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdInfoExtKt {
    public static /* synthetic */ IAdInfo asAdInfo$default(byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return asAdInfo(bArr, z);
    }

    public static final IAdInfo asAdInfo(byte[] $this$asAdInfo, boolean isSourceContentFormat) {
        IAdInfo asAdInfo;
        Intrinsics.checkNotNullParameter($this$asAdInfo, "<this>");
        byte[] bArr = !($this$asAdInfo.length == 0) ? $this$asAdInfo : null;
        if (bArr != null) {
            byte[] byteArray = bArr;
            if (isSourceContentFormat) {
                BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
                $this$decodeFromByteArray$iv.getSerializersModule();
                asAdInfo = asAdInfo((KSourceContentDto) $this$decodeFromByteArray$iv.decodeFromByteArray(KSourceContentDto.Companion.serializer(), byteArray));
            } else {
                BinaryFormat $this$decodeFromByteArray$iv2 = ProtoBuf.Default;
                $this$decodeFromByteArray$iv2.getSerializersModule();
                asAdInfo = asAdInfo((KAdInfo) $this$decodeFromByteArray$iv2.decodeFromByteArray(KAdInfo.Companion.serializer(), byteArray));
            }
            return asAdInfo;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final IAdInfo asAdInfo(KAdInfo $this$asAdInfo) {
        long j2;
        AdInfoExtra adInfoExtra;
        Object obj;
        Intrinsics.checkNotNullParameter($this$asAdInfo, "<this>");
        String requestId = $this$asAdInfo.getRequestId();
        long source = $this$asAdInfo.getSource();
        long resource = $this$asAdInfo.getResource();
        boolean isAdLoc = $this$asAdInfo.isAdLoc();
        String clientIp = $this$asAdInfo.getClientIp();
        long cardIndex = $this$asAdInfo.getCardIndex();
        long index = $this$asAdInfo.getIndex();
        long creativeId = $this$asAdInfo.getCreativeId();
        long creativeType = $this$asAdInfo.getCreativeType();
        String adCb = $this$asAdInfo.getAdCb();
        boolean isAd = $this$asAdInfo.isAd();
        int cmMark = (int) $this$asAdInfo.getCmMark();
        byte[] it = $this$asAdInfo.getExtra();
        if ((!(it.length == 0) ? it : null) != null) {
            try {
                Result.Companion companion = Result.Companion;
                Json this_$iv = JsonExtKt.getAdJson();
                String string$iv = StringsKt.decodeToString($this$asAdInfo.getExtra());
                this_$iv.getSerializersModule();
                j2 = creativeType;
                try {
                    obj = Result.constructor-impl((AdInfoExtra) this_$iv.decodeFromString(AdInfoExtra.Companion.serializer(), string$iv));
                } catch (Throwable th) {
                    th = th;
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    adInfoExtra = (AdInfoExtra) (!Result.isFailure-impl(obj) ? null : obj);
                    return new AdInfo(isAdLoc, source, resource, requestId, -1L, clientIp, index, cardIndex, 0L, isAd, creativeId, j2, 0, String.valueOf($this$asAdInfo.getCardType()), adCb, cmMark, adInfoExtra, 0L, (int) $this$asAdInfo.getNatureAd(), 135424, null);
                }
            } catch (Throwable th2) {
                th = th2;
                j2 = creativeType;
            }
            adInfoExtra = (AdInfoExtra) (!Result.isFailure-impl(obj) ? null : obj);
        } else {
            j2 = creativeType;
            adInfoExtra = null;
        }
        return new AdInfo(isAdLoc, source, resource, requestId, -1L, clientIp, index, cardIndex, 0L, isAd, creativeId, j2, 0, String.valueOf($this$asAdInfo.getCardType()), adCb, cmMark, adInfoExtra, 0L, (int) $this$asAdInfo.getNatureAd(), 135424, null);
    }

    public static final IAdInfo asAdInfo(KSourceContentDto $this$asAdInfo) {
        KInt32Value serverType;
        KInt32Value cardIndex;
        long j2;
        AdSourceContent.AdContent adContent;
        Intrinsics.checkNotNullParameter($this$asAdInfo, "<this>");
        String requestId = $this$asAdInfo.getRequestId();
        long sourceId = $this$asAdInfo.getSourceId();
        long resourceId = $this$asAdInfo.getResourceId();
        boolean isAdLoc = $this$asAdInfo.isAdLoc();
        long value = $this$asAdInfo.getServerType() != null ? serverType.getValue() : -1L;
        String clientIp = $this$asAdInfo.getClientIp();
        long value2 = $this$asAdInfo.getCardIndex() != null ? cardIndex.getValue() : -1L;
        long index = $this$asAdInfo.getIndex();
        KAdDto it = $this$asAdInfo.getAdContent();
        if (it != null) {
            long creativeId = it.getCreativeId();
            j2 = index;
            long creativeType = it.getCreativeType();
            String adCb = it.getAdCb();
            boolean isAd = it.isAd();
            int cmMark = it.getCmMark();
            KAdContentExtraDto extra = it.getExtra();
            adContent = new AdSourceContent.AdContent(creativeId, creativeType, adCb, isAd, cmMark, extra != null ? AdMossExtKt.transform(extra) : null);
        } else {
            j2 = index;
            adContent = null;
        }
        return AdSourceContentKt.asAdInfo(new AdSourceContent(requestId, sourceId, resourceId, isAdLoc, value, clientIp, value2, j2, adContent));
    }

    public static /* synthetic */ IAdInfo asAdInfo$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return asAdInfo(str, z);
    }

    public static final IAdInfo asAdInfo(String $this$asAdInfo, boolean isSourceContentFormat) {
        Object obj;
        AdInfo adInfo;
        Intrinsics.checkNotNullParameter($this$asAdInfo, "<this>");
        String string = $this$asAdInfo.length() > 0 ? $this$asAdInfo : null;
        if (string != null) {
            try {
                Result.Companion companion = Result.Companion;
                if (isSourceContentFormat) {
                    adInfo = AdSourceContentKt.asAdInfo((AdSourceContent) JsonExtKt.getAdJson().decodeFromString(SourceContentParser.INSTANCE, string));
                } else {
                    adInfo = (AdInfo) JsonExtKt.getAdJson().decodeFromString(AdInfoParser.INSTANCE, string);
                }
                obj = Result.constructor-impl(adInfo);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            r0 = (AdInfo) (Result.isFailure-impl(obj) ? null : obj);
        }
        return (IAdInfo) r0;
    }

    public static /* synthetic */ IAdInfo asAdInfo$default(JsonObject jsonObject, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return asAdInfo(jsonObject, z);
    }

    public static final IAdInfo asAdInfo(JsonObject $this$asAdInfo, boolean isSourceContentFormat) {
        Object obj;
        AdInfo adInfo;
        Intrinsics.checkNotNullParameter($this$asAdInfo, "<this>");
        JsonElement jsonElement = !((Map) $this$asAdInfo).isEmpty() ? $this$asAdInfo : null;
        if (jsonElement != null) {
            try {
                Result.Companion companion = Result.Companion;
                if (isSourceContentFormat) {
                    adInfo = AdSourceContentKt.asAdInfo((AdSourceContent) JsonExtKt.getAdJson().decodeFromJsonElement(SourceContentParser.INSTANCE, jsonElement));
                } else {
                    adInfo = (AdInfo) JsonExtKt.getAdJson().decodeFromJsonElement(AdInfoParser.INSTANCE, jsonElement);
                }
                obj = Result.constructor-impl(adInfo);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            r0 = (AdInfo) (Result.isFailure-impl(obj) ? null : obj);
        }
        return (IAdInfo) r0;
    }
}