package kntr.base.dd.impl.internal.debugger;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.Utils$Companion$decodeFromString$json$1;
import kntr.base.dd.impl.internal.data.CoreDataType;
import kntr.base.dd.impl.internal.data.ICoreData;
import kntr.base.dd.impl.internal.data.IDataCenter;
import kntr.base.dd.impl.internal.decide.DecisionMaker;
import kntr.base.dd.impl.internal.model.DDModel;
import kntr.base.dd.impl.internal.model.DDNode;
import kntr.base.dd.impl.internal.property.IPropertyCenter;
import kntr.base.dd.internal.IDeviceDecisionDebugger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: DDDebugger.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J \u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkntr/base/dd/impl/internal/debugger/DDDebugger;", "Lkntr/base/dd/internal/IDeviceDecisionDebugger;", "dataCenter", "Lkntr/base/dd/impl/internal/data/IDataCenter;", "properties", "Lkntr/base/dd/impl/internal/property/IPropertyCenter;", "<init>", "(Lkntr/base/dd/impl/internal/data/IDataCenter;Lkntr/base/dd/impl/internal/property/IPropertyCenter;)V", "getDecideDetailString", "", "key", "mockDDValue", "", "value", "mockDDValues", "json", "mockDDProp", "mockDDProps", "clearAllMock", "mockData", "Lkntr/base/dd/impl/internal/data/ICoreData;", "getMockData", "()Lkntr/base/dd/impl/internal/data/ICoreData;", "transMockJsonListToMap", "", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDDebugger implements IDeviceDecisionDebugger {
    private final IDataCenter dataCenter;
    private final IPropertyCenter properties;

    public DDDebugger(IDataCenter dataCenter, IPropertyCenter properties) {
        Intrinsics.checkNotNullParameter(dataCenter, "dataCenter");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.dataCenter = dataCenter;
        this.properties = properties;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x021b  */
    @Override // kntr.base.dd.internal.IDeviceDecisionDebugger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDecideDetailString(String key) {
        Object obj;
        Throwable error;
        StringBuilder append;
        Intrinsics.checkNotNullParameter(key, "key");
        StringBuilder $this$getDecideDetailString_u24lambda_u240 = new StringBuilder();
        boolean z = false;
        $this$getDecideDetailString_u24lambda_u240.append("版本信息: <" + this.dataCenter.getEnv() + "> " + this.dataCenter.currentData().getVersion() + "\n").append('\n');
        DDNode mockNode = this.dataCenter.dataWithType(CoreDataType.MOCK).node(key);
        if (mockNode != null) {
            String value = mockNode.getValue();
            if (value == null) {
                value = "null";
            }
            $this$getDecideDetailString_u24lambda_u240.append("当前key [" + key + "] 已被MOCK，具体值为 " + value).append('\n');
        } else {
            DDNode node = this.dataCenter.currentData().node(key);
            if (node == null) {
                $this$getDecideDetailString_u24lambda_u240.append("当前key [" + key + "] 未在Fawkes平台进行配置").append('\n');
                $this$getDecideDetailString_u24lambda_u240.append("用API取值时，将使用传入的默认值").append('\n');
            } else {
                try {
                    Result.Companion companion = Result.Companion;
                    DecisionMaker maker = new DecisionMaker(this.properties, true);
                    DecisionMaker.Result result = maker.decide(node);
                    if (!maker.getProcess().isEmpty()) {
                        $this$getDecideDetailString_u24lambda_u240.append("当前key [" + key + "] 决策的关键路径信息：").append('\n');
                        Iterable $this$forEach$iv = maker.getProcess();
                        for (Object element$iv : $this$forEach$iv) {
                            DecisionMaker.ProcessData it = (DecisionMaker.ProcessData) element$iv;
                            boolean z2 = z;
                            try {
                                $this$getDecideDetailString_u24lambda_u240.append("\t" + DDDebuggerKt.access$debugString(it)).append('\n');
                                z = z2;
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                error = Result.m2639exceptionOrNullimpl(obj);
                                if (error != null) {
                                }
                                return $this$getDecideDetailString_u24lambda_u240.toString();
                            }
                        }
                        $this$getDecideDetailString_u24lambda_u240.append('\n');
                    }
                    if (result.getHit()) {
                        String value2 = result.getValue();
                        if (value2 == null) {
                            value2 = "<null>";
                        }
                        $this$getDecideDetailString_u24lambda_u240.append("已命中决策树的分支, 其对应的返回值：" + value2).append('\n');
                        String value3 = result.getValue();
                        if (value3 == null) {
                            $this$getDecideDetailString_u24lambda_u240.append("注：此时的返回值为nil，绝大部分情况是为了兼容之前的FF配置导致的（由于一些历史设计问题）").append('\n');
                            $this$getDecideDetailString_u24lambda_u240.append("getBool 返回的是 true").append('\n');
                            append = $this$getDecideDetailString_u24lambda_u240.append("getString 将返回传入的默认值").append('\n');
                        } else {
                            Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(value3);
                            boolean boolValue = booleanStrictOrNull != null ? booleanStrictOrNull.booleanValue() : false;
                            $this$getDecideDetailString_u24lambda_u240.append("getBool 返回的是 " + boolValue).append('\n');
                            append = $this$getDecideDetailString_u24lambda_u240.append("getString 将返回 " + value3).append('\n');
                        }
                    } else {
                        $this$getDecideDetailString_u24lambda_u240.append("未任何命中决策树的分支").append('\n');
                        $this$getDecideDetailString_u24lambda_u240.append("getBool 返回的是 false").append('\n');
                        append = $this$getDecideDetailString_u24lambda_u240.append("getString 将返回传入的默认值").append('\n');
                    }
                    obj = Result.m2636constructorimpl(append);
                } catch (Throwable th2) {
                    th = th2;
                }
                error = Result.m2639exceptionOrNullimpl(obj);
                if (error != null) {
                    $this$getDecideDetailString_u24lambda_u240.append("当前key [" + key + "] 是异常配置，请将异常信息反馈给@Fawkes小姐姐").append('\n');
                    $this$getDecideDetailString_u24lambda_u240.append("具体的异常信息: " + error.getMessage()).append('\n');
                    $this$getDecideDetailString_u24lambda_u240.append("注：此时用API取值时，将使用传入的默认值").append('\n');
                }
            }
        }
        return $this$getDecideDetailString_u24lambda_u240.toString();
    }

    @Override // kntr.base.dd.internal.IDeviceDecisionDebugger
    public void mockDDValue(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(key)) {
            return;
        }
        ICoreData mockData = getMockData();
        String str = value;
        if (str.length() == 0) {
            str = null;
        }
        mockData.updateNodeValues(MapsKt.mapOf(TuplesKt.to(key, str)));
    }

    @Override // kntr.base.dd.internal.IDeviceDecisionDebugger
    public String mockDDValues(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Map it = transMockJsonListToMap(json);
        if (it != null) {
            getMockData().updateNodeValues(it);
            return "success";
        }
        return "input error";
    }

    @Override // kntr.base.dd.internal.IDeviceDecisionDebugger
    public void mockDDProp(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(key)) {
            return;
        }
        ICoreData mockData = getMockData();
        String str = value;
        if (str.length() == 0) {
            str = null;
        }
        mockData.updatePropValues(MapsKt.mapOf(TuplesKt.to(key, str)));
    }

    @Override // kntr.base.dd.internal.IDeviceDecisionDebugger
    public String mockDDProps(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Map it = transMockJsonListToMap(json);
        if (it != null) {
            getMockData().updatePropValues(it);
            return "success";
        }
        return "input error";
    }

    @Override // kntr.base.dd.internal.IDeviceDecisionDebugger
    public void clearAllMock() {
        getMockData().fallbackWithModel(new DDModel((String) null, 0L, (List) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null));
    }

    private final ICoreData getMockData() {
        return this.dataCenter.dataWithType(CoreDataType.MOCK);
    }

    private final Map<String, String> transMockJsonListToMap(String json) {
        Object obj;
        String str;
        Utils.Companion companion = Utils.Companion;
        if (json == null) {
            obj = null;
        } else {
            try {
                Json json$iv = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                json$iv.getSerializersModule();
                obj = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(new ArrayListSerializer(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE))), json);
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
        Iterable iterable = (List) obj;
        if (iterable != null) {
            Iterable $this$associateBy$iv = iterable;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associateBy$iv) {
                Map it = (Map) element$iv$iv;
                String str2 = (String) it.get("n");
                if (str2 == null) {
                    str2 = "";
                }
                destination$iv$iv.put(str2, element$iv$iv);
            }
            Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity(destination$iv$iv.size()));
            Iterable $this$associateByTo$iv$iv$iv = destination$iv$iv.entrySet();
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                Object key = it$iv$iv.getKey();
                Map.Entry it2 = (Map.Entry) element$iv$iv$iv;
                String str3 = (String) ((Map) it2.getValue()).get("v");
                if (str3 != null) {
                    String str4 = str3;
                    if (str4.length() == 0) {
                        str4 = null;
                    }
                    str = str4;
                } else {
                    str = null;
                }
                destination$iv$iv2.put(key, str);
            }
            return destination$iv$iv2;
        }
        return null;
    }
}