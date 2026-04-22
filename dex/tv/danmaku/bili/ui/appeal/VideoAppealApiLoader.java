package tv.danmaku.bili.ui.appeal;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import java.util.List;
import retrofit2.Callback;

public class VideoAppealApiLoader {
    private VideoAppealApi mApi;
    private Context mContext;

    public VideoAppealApiLoader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public VideoAppealApi getApi() {
        if (this.mApi == null) {
            this.mApi = (VideoAppealApi) ServiceGenerator.createService(VideoAppealApi.class);
        }
        return this.mApi;
    }

    public void init(String vid, Callback<GeneralResponse<List<BiliVideoAppeal>>> callback) {
        getApi().init(BiliAccounts.get(this.mContext).mid(), getAccessKey(this.mContext), vid).enqueue(callback);
    }

    public void add(String aid, String type, String reason, String pics, Callback<GeneralResponse<Void>> callback) {
        getApi().add(BiliAccounts.get(this.mContext).mid(), getAccessKey(this.mContext), aid, type, reason, pics).enqueue(callback);
    }

    public static String getAccessKey(Context context) {
        return BiliAccounts.get(context).getAccessKey();
    }
}