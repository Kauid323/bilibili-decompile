package tv.danmaku.bili.ui.main2;

import com.bilibili.app.comm.list.common.api.IDefaultKeywordResult;

public interface INavigationBarWatcher {
    void updateSearchText(IDefaultKeywordResult iDefaultKeywordResult);

    void updateZeroCardDefaultWord(IDefaultKeywordResult iDefaultKeywordResult);
}