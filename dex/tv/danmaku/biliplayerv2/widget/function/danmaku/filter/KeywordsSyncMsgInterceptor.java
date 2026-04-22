package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.content.Context;
import bili.resource.playerbaseres.R;

public class KeywordsSyncMsgInterceptor {
    public static String onIntercept(Context context, int code, String msg) {
        switch (code) {
            case KeywordsBlockApiService.ERROR_CODE_NO_ENOUGH_SPACE /* 36003 */:
                return context.getString(R.string.playerbaseres_global_string_601);
            default:
                return msg;
        }
    }
}