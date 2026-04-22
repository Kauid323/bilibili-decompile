package tv.danmaku.bili.router;

import android.content.Context;
import com.bilibili.lib.router.Router;

public class ChannelRoutes {
    public static final String CHANNEL_DETAIL = "bilibili://tag/:tagId/";
    public static final String CHANNEL_ID = "tagId";
    public static final String CHANNEL_NAME = "name";
    public static final String EXTRA_ATTEN_STATUS = "EXTRA_ATTEN_STATUS";
    public static final String FROM_SPMID = "from_spmid";

    public static void goToChannelDetail(Context context, long channelId, String channelName) {
        goToChannelDetail(context, channelId, channelName, null);
    }

    public static void goToChannelDetail(Context context, long channelId, String channelName, String spmidFrom) {
        Router.global().with(context).with(CHANNEL_ID, String.valueOf(channelId)).with(CHANNEL_NAME, channelName).with("from_spmid", spmidFrom).open("bilibili://tag/:tagId/");
    }
}