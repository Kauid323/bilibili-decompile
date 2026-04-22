package tv.danmaku.bili.ui.topic;

import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.converter.IParser;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import okhttp3.ResponseBody;
import tv.danmaku.bili.ui.topic.api.BiliTopic;
import tv.danmaku.bili.ui.topic.api.BiliTopicList;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: TopicRepository.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÁ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/topic/TopicParser;", "Lcom/bilibili/okretro/converter/IParser;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/topic/api/BiliTopicList;", "<init>", "()V", "convert", "value", "Lokhttp3/ResponseBody;", "parseData", "json", "", "topic_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TopicParser implements IParser<GeneralResponse<BiliTopicList>> {
    public static final TopicParser INSTANCE = new TopicParser();

    private TopicParser() {
    }

    /* renamed from: convert */
    public GeneralResponse<BiliTopicList> m1704convert(ResponseBody value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        String string = value.string();
        Intrinsics.checkNotNullExpressionValue(string, "string(...)");
        BiliTopicList result = parseData(string);
        GeneralResponse $this$convert_u24lambda_u240 = new GeneralResponse();
        $this$convert_u24lambda_u240.code = result.code;
        $this$convert_u24lambda_u240.message = "";
        $this$convert_u24lambda_u240.data = result;
        return $this$convert_u24lambda_u240;
    }

    private final BiliTopicList parseData(String json) {
        ListIterator $this$parseData_u24lambda_u240;
        BiliTopicList result = (BiliTopicList) Json.Default.decodeFromString(BiliTopicList.Companion.serializer(), json);
        List<BiliTopic> list = result.topics;
        if (list != null && ($this$parseData_u24lambda_u240 = list.listIterator()) != null) {
            while ($this$parseData_u24lambda_u240.hasNext()) {
                BiliTopic next = $this$parseData_u24lambda_u240.next();
                String cover = next.component1();
                String link = next.component2();
                String str = link;
                boolean z = false;
                if (!(str == null || str.length() == 0)) {
                    String str2 = cover;
                    if (str2 == null || str2.length() == 0) {
                        z = true;
                    }
                    if (z) {
                    }
                }
                $this$parseData_u24lambda_u240.remove();
            }
        }
        return result;
    }
}