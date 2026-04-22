package kntr.app.ad.common.model;

import kntr.app.ad.common.model.AdSourceContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: AdSourceContent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"asAdInfo", "Lkntr/app/ad/common/model/AdInfo;", "Lkntr/app/ad/common/model/AdSourceContent;", "dto_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdSourceContentKt {
    public static final AdInfo asAdInfo(AdSourceContent $this$asAdInfo) {
        long j2;
        Number number;
        long j3;
        Number number2;
        Intrinsics.checkNotNullParameter($this$asAdInfo, "<this>");
        boolean isAdLoc = $this$asAdInfo.isAdLoc();
        long sourceId = $this$asAdInfo.getSourceId();
        long resourceId = $this$asAdInfo.getResourceId();
        String requestId = $this$asAdInfo.getRequestId();
        long serverType = $this$asAdInfo.getServerType();
        String ip = $this$asAdInfo.getIp();
        long cardIndex = $this$asAdInfo.getCardIndex();
        long index = $this$asAdInfo.getIndex();
        AdSourceContent.AdContent adContent = $this$asAdInfo.getAdContent();
        Boolean valueOf = adContent != null ? Boolean.valueOf(adContent.isAd()) : null;
        if (valueOf == null) {
            valueOf = false;
        }
        boolean booleanValue = valueOf.booleanValue();
        AdSourceContent.AdContent adContent2 = $this$asAdInfo.getAdContent();
        Number $this$orZero$iv = adContent2 != null ? Long.valueOf(adContent2.getCreativeId()) : null;
        if ($this$orZero$iv == null) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                $this$orZero$iv = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                $this$orZero$iv = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                $this$orZero$iv = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                $this$orZero$iv = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                $this$orZero$iv = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                $this$orZero$iv = (Long) (short) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                $this$orZero$iv = (Long) (byte) 0;
            } else {
                throw new RuntimeException("not primitive number type");
            }
        }
        long longValue = $this$orZero$iv.longValue();
        AdSourceContent.AdContent adContent3 = $this$asAdInfo.getAdContent();
        Number $this$orZero$iv2 = adContent3 != null ? Long.valueOf(adContent3.getCreativeType()) : null;
        if ($this$orZero$iv2 != null) {
            j2 = longValue;
            number = $this$orZero$iv2;
        } else {
            j2 = longValue;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                number = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                number = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                number = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                number = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                number = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                number = (Long) (short) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                number = (Long) (byte) 0;
            } else {
                throw new RuntimeException("not primitive number type");
            }
        }
        long longValue2 = number.longValue();
        AdSourceContent.AdContent adContent4 = $this$asAdInfo.getAdContent();
        String adCb = adContent4 != null ? adContent4.getAdCb() : null;
        AdSourceContent.AdContent adContent5 = $this$asAdInfo.getAdContent();
        Number $this$orZero$iv3 = adContent5 != null ? Integer.valueOf(adContent5.getCmMark()) : null;
        if ($this$orZero$iv3 != null) {
            j3 = longValue2;
            number2 = $this$orZero$iv3;
        } else {
            j3 = longValue2;
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                number2 = (Integer) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                number2 = (Integer) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                number2 = (Integer) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                number2 = (Number) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                number2 = (Integer) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                number2 = (Integer) (short) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                number2 = (Integer) (byte) 0;
            } else {
                throw new RuntimeException("not primitive number type");
            }
        }
        int $i$f$orZero = number2.intValue();
        AdSourceContent.AdContent adContent6 = $this$asAdInfo.getAdContent();
        return new AdInfo(isAdLoc, sourceId, resourceId, requestId, serverType, ip, index, cardIndex, 0L, booleanValue, j2, j3, 0, null, adCb, $i$f$orZero, adContent6 != null ? adContent6.getExtra() : null, 0L, 0, 405760, null);
    }
}