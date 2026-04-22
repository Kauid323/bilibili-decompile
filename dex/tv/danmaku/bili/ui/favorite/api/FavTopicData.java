package tv.danmaku.bili.ui.favorite.api;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import tv.danmaku.bili.router.ChannelRoutes;

public class FavTopicData {
    public long count;
    public List<FavTopic> items;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class FavTopic {
        @JSONField(name = "h5_cover")
        public String cover;
        @JSONField(name = "fav_at")
        public long fav_at;
        @JSONField(name = "h5_url")
        public String link;
        @JSONField(name = ChannelRoutes.CHANNEL_NAME)
        public String title;
        @JSONField(name = "id")
        public long topicId;
    }
}