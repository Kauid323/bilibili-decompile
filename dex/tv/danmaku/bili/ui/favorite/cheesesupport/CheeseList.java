package tv.danmaku.bili.ui.favorite.cheesesupport;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheetKt;

public class CheeseList {
    @JSONField(name = CommonMenuBottomSheetKt.KEY_ITEMS)
    public List<CheeseItem> items;
    @JSONField(name = LoginReporterV2.PAGE_FROM_KEY)
    public CheesePageInfo page;
}