package tv.danmaku.bili.ui.answer;

import android.content.Context;
import com.bilibili.base.BiliGlobalPreferenceHelper;

public class AnswerHelper {
    private static final String ANSWER_KEY_COUNT = "answer_count";
    private static final String ANSWER_KEY_VERSION = "answer_version";
    private static final int MAX_ANSWER_ENTRY_SHOW = 3;
    private BiliGlobalPreferenceHelper preferencesHelper;

    public AnswerHelper(Context context) {
        this.preferencesHelper = BiliGlobalPreferenceHelper.getInstance(context);
        int version = this.preferencesHelper.optInteger(ANSWER_KEY_VERSION, 0);
        if (version != 1) {
            this.preferencesHelper.setInteger(ANSWER_KEY_VERSION, 1);
            clear();
        }
    }

    public void clear() {
        this.preferencesHelper.setInteger(ANSWER_KEY_COUNT, 0);
    }

    public int getShownCount() {
        return this.preferencesHelper.optInteger(ANSWER_KEY_COUNT, 0);
    }

    public boolean shouldShowEntry() {
        return getShownCount() < 3;
    }

    public void showEntry() {
        int count = getShownCount();
        if (count > 3) {
            return;
        }
        this.preferencesHelper.setInteger(ANSWER_KEY_COUNT, count + 1);
    }
}