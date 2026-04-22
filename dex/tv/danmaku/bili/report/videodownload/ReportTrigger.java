package tv.danmaku.bili.report.videodownload;

public class ReportTrigger {
    static int[] sSectionRecords = new int[Section.getSectionTypeSize()];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void recordSectionType(int sectionType) {
        int[] iArr = sSectionRecords;
        iArr[sectionType] = iArr[sectionType] + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSatisfyTriggerCount(int sectionType) {
        int count = sSectionRecords[sectionType];
        return count == 1 || count % Section.getSectionTriggerCount(sectionType) == 0;
    }
}