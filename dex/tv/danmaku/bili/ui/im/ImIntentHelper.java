package tv.danmaku.bili.ui.im;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.router.Router;

public class ImIntentHelper {
    public static final String ARGS_CONVERSATION_TYPE = "conversation_type";
    public static final String ARGS_RECIVEID = "reciveid";
    public static final String ARGS_USER_ID = "user_id";
    public static final String ROUTE_URI_CONVERSATION = "activity://im/conversation/";
    public static final String ROUTE_URI_ENDAN = "activity://im/up_group/";
    public static final String ROUTE_URI_MY_GROUP = "activity://im/my_group/";

    public static void redirectAfterShare(Context context, Bundle shareResult) {
        if (shareResult == null) {
            return;
        }
        int where = shareResult.getInt("share_to_where", 0);
        long id = shareResult.getLong("share_to_id", 0L);
        if (where == 0) {
            toMyGroup(context);
        } else if (where == 1) {
            toConversation(context, 1, id);
        } else if (where == 2) {
            toConversation(context, 2, id);
        }
    }

    public static void toConversation(Context context, int conversationType, long receiveId) {
        Router.global().with(context).with(ARGS_CONVERSATION_TYPE, String.valueOf(conversationType)).with(ARGS_RECIVEID, String.valueOf(receiveId)).open(ROUTE_URI_CONVERSATION);
    }

    public static void toMyGroup(Context context) {
        Router.global().with(context).open(ROUTE_URI_MY_GROUP);
    }
}