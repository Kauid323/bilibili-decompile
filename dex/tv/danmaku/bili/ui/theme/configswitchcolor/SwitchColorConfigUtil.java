package tv.danmaku.bili.ui.theme.configswitchcolor;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.theme.configswitchcolor.ConfigSwitchColor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SwitchColorConfigUtil.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/theme/configswitchcolor/SwitchColorConfigUtil;", "", "<init>", "()V", "resourceIdMap", "", "", "", "getColorIdByResName", "context", "Landroid/content/Context;", "colorResName", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "parseColorConfig", "Ltv/danmaku/bili/ui/theme/configswitchcolor/ConfigSwitchColor$ColorConfig;", "configJson", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SwitchColorConfigUtil {
    public static final SwitchColorConfigUtil INSTANCE = new SwitchColorConfigUtil();
    private static final Map<String, Integer> resourceIdMap = new LinkedHashMap();

    private SwitchColorConfigUtil() {
    }

    public final Integer getColorIdByResName(Context context, String colorResName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorResName, "colorResName");
        Integer cache = resourceIdMap.get(colorResName);
        if (cache == null) {
            int id = context.getResources().getIdentifier(colorResName, "color", context.getPackageName());
            if (id == 0) {
                return null;
            }
            resourceIdMap.put(colorResName, Integer.valueOf(id));
            return Integer.valueOf(id);
        }
        return cache;
    }

    public final ConfigSwitchColor.ColorConfig parseColorConfig(Context context, String configJson) {
        Integer colorDstIntValue;
        Integer colorIntValue;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(configJson, "configJson");
        SparseArray colorIdMap = new SparseArray();
        SparseArray sparseArray = null;
        try {
            JSONObject jsonObject = JSONObject.parseObject(configJson);
            Iterable jSONArray = jsonObject.getJSONArray("color_id_list");
            if (jSONArray != null) {
                Iterable $this$forEach$iv = jSONArray;
                for (Object element$iv : $this$forEach$iv) {
                    JSONObject jSONObject = element$iv instanceof JSONObject ? (JSONObject) element$iv : null;
                    if (jSONObject != null) {
                        JSONObject colorObject = jSONObject;
                        Iterable keySet = colorObject.keySet();
                        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
                        Iterable<String> $this$forEach$iv2 = keySet;
                        for (String colorName : $this$forEach$iv2) {
                            SwitchColorConfigUtil switchColorConfigUtil = INSTANCE;
                            Intrinsics.checkNotNull(colorName);
                            Integer colorId = switchColorConfigUtil.getColorIdByResName(context2, colorName);
                            JSONObject colorObject2 = colorObject;
                            Object obj = colorObject2.get(colorName);
                            colorObject = colorObject2;
                            String colorValueString = obj instanceof String ? (String) obj : null;
                            if (colorId != null && colorValueString != null) {
                                try {
                                    Integer colorIntValue2 = Integer.valueOf(Color.parseColor(colorValueString));
                                    colorIntValue = colorIntValue2;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    colorIntValue = null;
                                }
                                if (colorIntValue != null) {
                                    colorIdMap.put(colorId.intValue(), colorIntValue);
                                }
                            }
                            context2 = context;
                        }
                    }
                    context2 = context;
                }
            }
            Iterable jSONArray2 = jsonObject.getJSONArray("color_list");
            if (jSONArray2 != null) {
                Iterable iterable = jSONArray2;
                sparseArray = new SparseArray();
                Iterable $this$forEach$iv3 = iterable;
                for (Object element$iv2 : $this$forEach$iv3) {
                    JSONObject jSONObject2 = element$iv2 instanceof JSONObject ? (JSONObject) element$iv2 : null;
                    if (jSONObject2 != null) {
                        JSONObject colorObject3 = jSONObject2;
                        Iterable keySet2 = colorObject3.keySet();
                        Intrinsics.checkNotNullExpressionValue(keySet2, "<get-keys>(...)");
                        Iterable<String> $this$forEach$iv4 = keySet2;
                        for (String colorResString : $this$forEach$iv4) {
                            Iterable iterable2 = iterable;
                            Object obj2 = colorObject3.get(colorResString);
                            String colorDstString = obj2 instanceof String ? (String) obj2 : null;
                            if (colorDstString != null) {
                                Integer colorResIntValue = null;
                                try {
                                    colorResIntValue = Integer.valueOf(Color.parseColor(colorResString));
                                    Integer colorDstIntValue2 = Integer.valueOf(Color.parseColor(colorDstString));
                                    colorDstIntValue = colorDstIntValue2;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    colorDstIntValue = null;
                                }
                                if (colorResIntValue != null && colorDstIntValue != null) {
                                    colorIdMap.put(colorResIntValue.intValue(), colorDstIntValue);
                                }
                            }
                            iterable = iterable2;
                        }
                    }
                    iterable = iterable;
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return new ConfigSwitchColor.ColorConfig(colorIdMap, sparseArray);
    }
}