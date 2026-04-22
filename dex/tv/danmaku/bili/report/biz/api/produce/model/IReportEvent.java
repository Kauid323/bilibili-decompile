package tv.danmaku.bili.report.biz.api.produce.model;

public interface IReportEvent {
    Object get(String str);

    int getSource();

    void put(String str, Object obj);
}