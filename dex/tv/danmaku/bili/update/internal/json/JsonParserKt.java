package tv.danmaku.bili.update.internal.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: JsonParser.kt */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0000\u001a/\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0000¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"parseObject", "T", "text", "", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJSONString", "object", "", "getObject", "Lorg/json/JSONObject;", "s", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class JsonParserKt {
    public static final <T> T parseObject(String text, Class<T> cls) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return (T) RuntimeHelper.INSTANCE.parseObject(text, cls);
    }

    public static final String toJSONString(Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        return RuntimeHelper.INSTANCE.toJSONString(object);
    }

    public static final <T> T getObject(JSONObject $this$getObject, String s, Class<T> cls) {
        Intrinsics.checkNotNullParameter($this$getObject, "<this>");
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        JSONObject obj = $this$getObject.optJSONObject(s);
        if (obj == null) {
            return null;
        }
        try {
            String jSONObject = obj.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            return (T) parseObject(jSONObject, cls);
        } catch (Exception e) {
            throw new JSONException(e.getMessage());
        }
    }
}