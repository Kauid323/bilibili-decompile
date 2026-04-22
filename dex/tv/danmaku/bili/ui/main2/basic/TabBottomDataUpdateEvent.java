package tv.danmaku.bili.ui.main2.basic;

import com.bilibili.bus.IData;
import tv.danmaku.bili.ui.main2.resource.PrimaryPage;

public class TabBottomDataUpdateEvent implements IData {
    public PrimaryPage publishPage;

    public TabBottomDataUpdateEvent(PrimaryPage publishPage) {
        this.publishPage = publishPage;
    }
}