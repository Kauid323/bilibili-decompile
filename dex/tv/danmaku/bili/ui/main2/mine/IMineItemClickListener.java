package tv.danmaku.bili.ui.main2.mine;

import com.bilibili.lib.homepage.mine.MenuGroup;

public interface IMineItemClickListener {
    void onMineItemClick(MenuGroup.Item item);

    void onNoticeItemClickClose();

    void onNoticeItemClickClose(int i, MenuGroup menuGroup, MenuGroup.Item item);

    void onSilenceItemClick();
}