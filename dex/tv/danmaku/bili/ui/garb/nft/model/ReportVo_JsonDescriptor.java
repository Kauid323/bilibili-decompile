package tv.danmaku.bili.ui.garb.nft.model;

import com.bilibili.bson.common.PojoClassDescriptor;
import com.bilibili.bson.common.PojoPropertyDescriptor;
import tv.danmaku.bili.ui.garb.nft.model.ReportVo;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

public final class ReportVo_JsonDescriptor extends PojoClassDescriptor {
    private static final PojoPropertyDescriptor[] properties = createProperties();

    public ReportVo_JsonDescriptor() {
        super(ReportVo.class, properties);
    }

    private static PojoPropertyDescriptor[] createProperties() {
        return new PojoPropertyDescriptor[]{new PojoPropertyDescriptor(ReportEvent.EVENT_TYPE_SHOW, (String[]) null, ReportVo.Content.class, (Class) null, 5), new PojoPropertyDescriptor("click", (String[]) null, ReportVo.Content.class, (Class) null, 5)};
    }

    public Object constructWith(Object[] objArr) {
        return new ReportVo((ReportVo.Content) objArr[0], (ReportVo.Content) objArr[1]);
    }

    public Object get(Object obj, int i) {
        ReportVo reportVo = (ReportVo) obj;
        switch (i) {
            case 0:
                return reportVo.getShow();
            case 1:
                return reportVo.getClick();
            default:
                return null;
        }
    }
}