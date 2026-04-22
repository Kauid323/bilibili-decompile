package tv.danmaku.bili.moss.test.cases.unary.rest;

import com.bapis.bilibili.api.probe.v1.Category;
import com.bapis.bilibili.api.probe.v1.DynamicMessageUpdate;
import com.bapis.bilibili.api.probe.v1.Embedded;
import com.bapis.bilibili.api.probe.v1.ErrorMessage;
import com.bapis.bilibili.api.probe.v1.SimpleMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: ModelMocks.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"buildTestSimpleMessage", "Lcom/bapis/bilibili/api/probe/v1/SimpleMessage;", "buildErrorMessage", "Lcom/bapis/bilibili/api/probe/v1/ErrorMessage;", "buildDynamicMessageUpdate", "Lcom/bapis/bilibili/api/probe/v1/DynamicMessageUpdate;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ModelMocksKt {
    public static final SimpleMessage buildTestSimpleMessage() {
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();
        builder.setId(100);
        builder.setNum(1000L);
        builder.setLang("zh");
        builder.setCate(Category.CATEGORY_ONE);
        Embedded.Builder eb = Embedded.newBuilder();
        eb.setBoolVal(true);
        eb.setInt32Val(1111);
        eb.addRepeatedStringVal("aaa");
        eb.addRepeatedStringVal("bbb");
        eb.putMapStringVal("key", "value");
        ErrorMessage.Builder errorBuilder = ErrorMessage.newBuilder();
        errorBuilder.setCode(10000L);
        eb.putMapErrorVal("key", errorBuilder.build());
        builder.setEmbedded(eb.build());
        SimpleMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public static final ErrorMessage buildErrorMessage() {
        ErrorMessage.Builder builder = ErrorMessage.newBuilder();
        builder.setCode(2233L);
        builder.setReason("2233reason");
        builder.setMessage("2233message");
        ErrorMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public static final DynamicMessageUpdate buildDynamicMessageUpdate() {
        DynamicMessageUpdate.Builder builder = DynamicMessageUpdate.newBuilder();
        builder.setBody(buildTestSimpleMessage());
        DynamicMessageUpdate build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}