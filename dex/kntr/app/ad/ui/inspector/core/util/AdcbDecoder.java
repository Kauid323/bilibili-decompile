package kntr.app.ad.ui.inspector.core.util;

import java.util.List;
import kntr.app.ad.ui.inspector.core.util.AdvInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: AdcbDecoder.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "decodeAdcb", "Lkntr/app/ad/ui/inspector/core/util/AdvInfo;", "adcb", RoomRecommendViewModel.EMPTY_CURSOR, "advInfoToJson", "advInfo", "processAdcb", "Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder$AdcbResult;", "AdcbResult", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdcbDecoder {
    public static final int $stable = 0;
    public static final AdcbDecoder INSTANCE = new AdcbDecoder();

    private AdcbDecoder() {
    }

    public final AdvInfo decodeAdcb(String adcb) {
        Intrinsics.checkNotNullParameter(adcb, "adcb");
        try {
            byte[] adcbBytes = Base64.decode$default(Base64.Default, adcb, 0, 0, 6, (Object) null);
            return (AdvInfo) ProtoBuf.Default.decodeFromByteArray(AdvInfo.Companion.serializer(), adcbBytes);
        } catch (Exception e) {
            return null;
        }
    }

    public final String advInfoToJson(AdvInfo advInfo) {
        Intrinsics.checkNotNullParameter(advInfo, "advInfo");
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv, "planId", Long.valueOf(advInfo.getPlanId()));
        JsonElementBuildersKt.put(builder$iv, "unitId", Long.valueOf(advInfo.getUnitId()));
        JsonElementBuildersKt.put(builder$iv, "creativeId", Long.valueOf(advInfo.getCreativeId()));
        JsonElementBuildersKt.put(builder$iv, "costPrice", Long.valueOf(advInfo.getCostPrice()));
        JsonElementBuildersKt.put(builder$iv, "userId", Long.valueOf(advInfo.getUserId()));
        String it = advInfo.getRequestId();
        if (it != null) {
            JsonElementBuildersKt.put(builder$iv, "requestId", it);
        }
        AdvInfo.AdType it2 = advInfo.getType();
        if (it2 != null) {
            JsonElementBuildersKt.put(builder$iv, "type", it2.name());
        }
        Long sourceId = advInfo.getSourceId();
        if (sourceId != null) {
            JsonElementBuildersKt.put(builder$iv, "sourceId", Long.valueOf(sourceId.longValue()));
        }
        Long requestTime = advInfo.getRequestTime();
        if (requestTime != null) {
            JsonElementBuildersKt.put(builder$iv, "requestTime", Long.valueOf(requestTime.longValue()));
        }
        String it3 = advInfo.getCity();
        if (it3 != null) {
            JsonElementBuildersKt.put(builder$iv, "city", it3);
        }
        String it4 = advInfo.getProvince();
        if (it4 != null) {
            JsonElementBuildersKt.put(builder$iv, "province", it4);
        }
        String it5 = advInfo.getCountry();
        if (it5 != null) {
            JsonElementBuildersKt.put(builder$iv, "country", it5);
        }
        Long age = advInfo.getAge();
        if (age != null) {
            JsonElementBuildersKt.put(builder$iv, "age", Long.valueOf(age.longValue()));
        }
        Long gender = advInfo.getGender();
        if (gender != null) {
            JsonElementBuildersKt.put(builder$iv, "gender", Long.valueOf(gender.longValue()));
        }
        Long category = advInfo.getCategory();
        if (category != null) {
            JsonElementBuildersKt.put(builder$iv, "category", Long.valueOf(category.longValue()));
        }
        Long orderId = advInfo.getOrderId();
        if (orderId != null) {
            JsonElementBuildersKt.put(builder$iv, "orderId", Long.valueOf(orderId.longValue()));
        }
        String it6 = advInfo.getBceIp();
        if (it6 != null) {
            JsonElementBuildersKt.put(builder$iv, "bceIp", it6);
        }
        String it7 = advInfo.getExpName();
        if (it7 != null) {
            JsonElementBuildersKt.put(builder$iv, "expName", it7);
        }
        Long bidPrice = advInfo.getBidPrice();
        if (bidPrice != null) {
            JsonElementBuildersKt.put(builder$iv, "bidPrice", Long.valueOf(bidPrice.longValue()));
        }
        Long ctr = advInfo.getCtr();
        if (ctr != null) {
            JsonElementBuildersKt.put(builder$iv, "ctr", Long.valueOf(ctr.longValue()));
        }
        String it8 = advInfo.getUrl();
        if (it8 != null) {
            JsonElementBuildersKt.put(builder$iv, "url", it8);
        }
        String it9 = advInfo.getCpcProcess();
        if (it9 != null) {
            JsonElementBuildersKt.put(builder$iv, "cpcProcess", it9);
        }
        String it10 = advInfo.getPolaroidName();
        if (it10 != null) {
            JsonElementBuildersKt.put(builder$iv, "polaroidName", it10);
        }
        String it11 = advInfo.getStragetyTags();
        if (it11 != null) {
            JsonElementBuildersKt.put(builder$iv, "stragetyTags", it11);
        }
        Long templateId = advInfo.getTemplateId();
        if (templateId != null) {
            JsonElementBuildersKt.put(builder$iv, "templateId", Long.valueOf(templateId.longValue()));
        }
        Long planDailyBudget = advInfo.getPlanDailyBudget();
        if (planDailyBudget != null) {
            JsonElementBuildersKt.put(builder$iv, "planDailyBudget", Long.valueOf(planDailyBudget.longValue()));
        }
        Long unitDailyBudget = advInfo.getUnitDailyBudget();
        if (unitDailyBudget != null) {
            JsonElementBuildersKt.put(builder$iv, "unitDailyBudget", Long.valueOf(unitDailyBudget.longValue()));
        }
        Long avId = advInfo.getAvId();
        if (avId != null) {
            JsonElementBuildersKt.put(builder$iv, "avId", Long.valueOf(avId.longValue()));
        }
        Long secondPrice = advInfo.getSecondPrice();
        if (secondPrice != null) {
            JsonElementBuildersKt.put(builder$iv, "secondPrice", Long.valueOf(secondPrice.longValue()));
        }
        Long promotionPurposeType = advInfo.getPromotionPurposeType();
        if (promotionPurposeType != null) {
            JsonElementBuildersKt.put(builder$iv, "promotionPurposeType", Long.valueOf(promotionPurposeType.longValue()));
        }
        Long upMid = advInfo.getUpMid();
        if (upMid != null) {
            JsonElementBuildersKt.put(builder$iv, "upMid", Long.valueOf(upMid.longValue()));
        }
        List materials = advInfo.getMaterialInfos();
        if (materials != null) {
            JsonElementBuildersKt.put(builder$iv, "materialInfosCount", Integer.valueOf(materials.size()));
        }
        JsonObject jsonObject = builder$iv.build();
        return jsonObject.toString();
    }

    public final AdcbResult processAdcb(String adcb) {
        Intrinsics.checkNotNullParameter(adcb, "adcb");
        AdvInfo advInfo = decodeAdcb(adcb);
        if (advInfo == null) {
            return new AdcbResult.Error("解析失败");
        }
        String json = advInfoToJson(advInfo);
        return new AdcbResult.Success(advInfo, json);
    }

    /* compiled from: AdcbDecoder.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder$AdcbResult;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Success", "Error", "Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder$AdcbResult$Error;", "Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder$AdcbResult$Success;", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class AdcbResult {
        public static final int $stable = 0;

        public /* synthetic */ AdcbResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private AdcbResult() {
        }

        /* compiled from: AdcbDecoder.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder$AdcbResult$Success;", "Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder$AdcbResult;", "advInfo", "Lkntr/app/ad/ui/inspector/core/util/AdvInfo;", "jsonString", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/ad/ui/inspector/core/util/AdvInfo;Ljava/lang/String;)V", "getAdvInfo", "()Lkntr/app/ad/ui/inspector/core/util/AdvInfo;", "getJsonString", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Success extends AdcbResult {
            public static final int $stable = 8;
            private final AdvInfo advInfo;
            private final String jsonString;

            public static /* synthetic */ Success copy$default(Success success, AdvInfo advInfo, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    advInfo = success.advInfo;
                }
                if ((i & 2) != 0) {
                    str = success.jsonString;
                }
                return success.copy(advInfo, str);
            }

            public final AdvInfo component1() {
                return this.advInfo;
            }

            public final String component2() {
                return this.jsonString;
            }

            public final Success copy(AdvInfo advInfo, String str) {
                Intrinsics.checkNotNullParameter(advInfo, "advInfo");
                Intrinsics.checkNotNullParameter(str, "jsonString");
                return new Success(advInfo, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Success) {
                    Success success = (Success) obj;
                    return Intrinsics.areEqual(this.advInfo, success.advInfo) && Intrinsics.areEqual(this.jsonString, success.jsonString);
                }
                return false;
            }

            public int hashCode() {
                return (this.advInfo.hashCode() * 31) + this.jsonString.hashCode();
            }

            public String toString() {
                AdvInfo advInfo = this.advInfo;
                return "Success(advInfo=" + advInfo + ", jsonString=" + this.jsonString + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(AdvInfo advInfo, String jsonString) {
                super(null);
                Intrinsics.checkNotNullParameter(advInfo, "advInfo");
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                this.advInfo = advInfo;
                this.jsonString = jsonString;
            }

            public final AdvInfo getAdvInfo() {
                return this.advInfo;
            }

            public final String getJsonString() {
                return this.jsonString;
            }
        }

        /* compiled from: AdcbDecoder.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder$AdcbResult$Error;", "Lkntr/app/ad/ui/inspector/core/util/AdcbDecoder$AdcbResult;", "message", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Error extends AdcbResult {
            public static final int $stable = 0;
            private final String message;

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.message;
                }
                return error.copy(str);
            }

            public final String component1() {
                return this.message;
            }

            public final Error copy(String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new Error(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.areEqual(this.message, ((Error) obj).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "Error(message=" + this.message + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String message) {
                super(null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }
}