package tv.danmaku.bili.report.pv.spm;

import tv.danmaku.bili.report.pv.spm.PageModResourceResolver;

public class PositionModel {
    private String mPattern;
    private String mSpmId;

    private PositionModel(String spmId, String pattern) {
        this.mSpmId = spmId;
        this.mPattern = pattern;
    }

    public String getSpmId() {
        return this.mSpmId;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public static PositionModel create(String spmId, String pattern) {
        return new PositionModel(spmId, pattern);
    }

    public static PositionModel createFromJson(PageModResourceResolver.ModelBean bean) {
        return new PositionModel(bean.mSpmId, bean.mPattern);
    }
}