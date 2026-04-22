package tv.danmaku.bili.ui.splash.utils;

import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: FastJsonUtil.kt */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00052#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u0000¢\u0006\u0002\u0010\f\u001a?\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u0000\u001a\u001e\u0010\u0011\u001a\u00020\u000b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0002\u001a&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\"\u000e\u0010\u001a\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"readObjectFromFileUseStream", "T", "filePath", "", "clazz", "Ljava/lang/Class;", "onError", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "errMsg", "", "(Ljava/lang/String;Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "saveObjectToFileUseStream", "data", "", "fullPathToSave", "writeKv", "Lcom/alibaba/fastjson/JSONWriter;", "key", "value", "parseObjectInfo", "", "Ltv/danmaku/bili/ui/splash/utils/ObjectInfo;", "serialize", "", "TAG", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FastJsonUtilKt {
    private static final String TAG = "[Splash]FastJsonUtil";

    public static /* synthetic */ Object readObjectFromFileUseStream$default(String str, Class cls, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: tv.danmaku.bili.ui.splash.utils.FastJsonUtilKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit readObjectFromFileUseStream$lambda$0;
                    readObjectFromFileUseStream$lambda$0 = FastJsonUtilKt.readObjectFromFileUseStream$lambda$0((String) obj2);
                    return readObjectFromFileUseStream$lambda$0;
                }
            };
        }
        return readObjectFromFileUseStream(str, cls, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readObjectFromFileUseStream$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> T readObjectFromFileUseStream(String filePath, Class<T> cls, Function1<? super String, Unit> function1) {
        Unit unit;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(function1, "onError");
        JSONReader jSONReader = null;
        Object data = null;
        Unit unit2 = null;
        try {
            JSONReader $this$readObjectFromFileUseStream_u24lambda_u241 = new JSONReader(new FileReader(filePath));
            jSONReader = $this$readObjectFromFileUseStream_u24lambda_u241;
            Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Any");
            data = newInstance;
            Map objectInfoMap = parseObjectInfo(data, false);
            $this$readObjectFromFileUseStream_u24lambda_u241.startObject();
            while ($this$readObjectFromFileUseStream_u24lambda_u241.hasNext()) {
                String key = $this$readObjectFromFileUseStream_u24lambda_u241.readString();
                ObjectInfo objectInfo = objectInfoMap.get(key);
                if (objectInfo == null) {
                    $this$readObjectFromFileUseStream_u24lambda_u241.readObject();
                } else if (objectInfo.isList()) {
                    $this$readObjectFromFileUseStream_u24lambda_u241.startArray();
                    List dataList = new ArrayList();
                    while ($this$readObjectFromFileUseStream_u24lambda_u241.hasNext()) {
                        Object readObject = $this$readObjectFromFileUseStream_u24lambda_u241.readObject(objectInfo.getTypeReference().getType());
                        Intrinsics.checkNotNullExpressionValue(readObject, "readObject(...)");
                        dataList.add(readObject);
                    }
                    objectInfo.getField().set(data, dataList);
                    $this$readObjectFromFileUseStream_u24lambda_u241.endArray();
                } else {
                    objectInfo.getField().set(data, $this$readObjectFromFileUseStream_u24lambda_u241.readObject(objectInfo.getTypeReference()));
                }
            }
            $this$readObjectFromFileUseStream_u24lambda_u241.endObject();
        } catch (Throwable err) {
            try {
                BLog.e(TAG, "readObjectFromFileUseStream, error = " + err.getMessage());
                String message = err.getMessage();
                if (message == null) {
                    message = "";
                }
                function1.invoke(message);
                try {
                    Result.Companion companion = Result.Companion;
                    JSONReader jSONReader2 = jSONReader;
                    if (jSONReader2 != null) {
                        jSONReader2.close();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    Result.constructor-impl(unit);
                } catch (Throwable th) {
                    th = th;
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                    if (data == null) {
                    }
                }
            } catch (Throwable th2) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    JSONReader jSONReader3 = jSONReader;
                    if (jSONReader3 != null) {
                        jSONReader3.close();
                        unit2 = Unit.INSTANCE;
                    }
                    Result.constructor-impl(unit2);
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th3));
                }
                throw th2;
            }
        }
        try {
            Result.Companion companion5 = Result.Companion;
            jSONReader.close();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th4) {
            th = th4;
            Result.Companion companion22 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            if (data == null) {
            }
        }
        if (data == null) {
            return null;
        }
        try {
            Result.Companion companion6 = Result.Companion;
            return cls.cast(data);
        } catch (Throwable th5) {
            Result.Companion companion7 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th5));
            return null;
        }
    }

    public static /* synthetic */ void saveObjectToFileUseStream$default(Object obj, String str, Function1 function1, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: tv.danmaku.bili.ui.splash.utils.FastJsonUtilKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj3) {
                    Unit saveObjectToFileUseStream$lambda$0;
                    saveObjectToFileUseStream$lambda$0 = FastJsonUtilKt.saveObjectToFileUseStream$lambda$0((String) obj3);
                    return saveObjectToFileUseStream$lambda$0;
                }
            };
        }
        saveObjectToFileUseStream(obj, str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit saveObjectToFileUseStream$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void saveObjectToFileUseStream(Object data, String fullPathToSave, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(fullPathToSave, "fullPathToSave");
        Intrinsics.checkNotNullParameter(function1, "onError");
        if (data == null) {
            return;
        }
        JSONWriter jSONWriter = null;
        try {
            JSONWriter $this$saveObjectToFileUseStream_u24lambda_u241 = new JSONWriter(new FileWriter(fullPathToSave));
            jSONWriter = $this$saveObjectToFileUseStream_u24lambda_u241;
            if (data instanceof List) {
                $this$saveObjectToFileUseStream_u24lambda_u241.startArray();
                Iterable<Object> $this$forEach$iv = (Iterable) data;
                for (Object element$iv : $this$forEach$iv) {
                    $this$saveObjectToFileUseStream_u24lambda_u241.writeObject(element$iv);
                }
                $this$saveObjectToFileUseStream_u24lambda_u241.endArray();
            } else {
                Map objectInfoMap = parseObjectInfo(data, true);
                $this$saveObjectToFileUseStream_u24lambda_u241.startObject();
                for (Map.Entry element$iv2 : objectInfoMap.entrySet()) {
                    String k = element$iv2.getKey();
                    ObjectInfo v = element$iv2.getValue();
                    writeKv($this$saveObjectToFileUseStream_u24lambda_u241, k, v.getValue());
                }
                $this$saveObjectToFileUseStream_u24lambda_u241.endObject();
            }
            $this$saveObjectToFileUseStream_u24lambda_u241.close();
            try {
                Result.Companion companion = Result.Companion;
                jSONWriter.close();
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                th = th;
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        } catch (Throwable err) {
            Unit unit = null;
            try {
                BLog.e(TAG, "saveObjectToFileUseStream, error = " + err.getMessage());
                String message = err.getMessage();
                if (message == null) {
                    message = IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
                }
                function1.invoke(message);
                try {
                    Result.Companion companion3 = Result.Companion;
                    JSONWriter jSONWriter2 = jSONWriter;
                    if (jSONWriter2 != null) {
                        jSONWriter2.close();
                        unit = Unit.INSTANCE;
                    }
                    Result.constructor-impl(unit);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion22 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            } catch (Throwable th3) {
                try {
                    Result.Companion companion4 = Result.Companion;
                    JSONWriter jSONWriter3 = jSONWriter;
                    if (jSONWriter3 != null) {
                        jSONWriter3.close();
                        unit = Unit.INSTANCE;
                    }
                    Result.constructor-impl(unit);
                } catch (Throwable th4) {
                    Result.Companion companion5 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th4));
                }
                throw th3;
            }
        }
    }

    private static final void writeKv(JSONWriter $this$writeKv, String key, Object value) {
        if (value == null) {
            return;
        }
        $this$writeKv.writeKey(key);
        if (value instanceof List) {
            $this$writeKv.startArray();
            Iterable $this$forEach$iv = (Iterable) value;
            for (Object element$iv : $this$forEach$iv) {
                $this$writeKv.writeObject(element$iv);
            }
            $this$writeKv.endArray();
            return;
        }
        $this$writeKv.writeObject(value);
    }

    private static final Map<String, ObjectInfo> parseObjectInfo(Object data, boolean serialize) {
        Object obj = data;
        if (obj == null) {
            return EnhancedUnmodifiabilityKt.unmodifiable(MapsKt.emptyMap());
        }
        Field[] fields = data.getClass().getDeclaredFields();
        Map kvs = new LinkedHashMap();
        Intrinsics.checkNotNull(fields);
        int length = fields.length;
        int i = 0;
        while (i < length) {
            final Field field = fields[i];
            field.setAccessible(true);
            JSONField jsonField = field.getAnnotation(JSONField.class);
            if (jsonField != null && ((!serialize || jsonField.serialize()) && (serialize || jsonField.deserialize()))) {
                final boolean isList = Intrinsics.areEqual(field.getType(), List.class);
                TypeReference<Object> typeReference = new TypeReference<Object>() { // from class: tv.danmaku.bili.ui.splash.utils.FastJsonUtilKt$parseObjectInfo$1$typeRef$1
                    public Type getType() {
                        if (!isList) {
                            Class<?> type = field.getType();
                            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                            return type;
                        }
                        Type genericType = field.getGenericType();
                        Intrinsics.checkNotNull(genericType, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                        Type type2 = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                        Intrinsics.checkNotNullExpressionValue(type2, "get(...)");
                        return type2;
                    }
                };
                String name = jsonField.name();
                Intrinsics.checkNotNull(field);
                kvs.put(name, new ObjectInfo(field, field.get(obj), typeReference, isList));
            }
            i++;
            obj = data;
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(kvs);
    }
}