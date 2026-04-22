package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;

/* compiled from: CharacterData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/CharacterData;", "Lnl/adaptivity/xmlutil/dom2/Node;", "getData", "", "setData", "", "value", "substringData", "offset", "", "count", "appendData", "data", "insertData", "deleteData", "replaceData", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CharacterData extends Node {
    void appendData(String str);

    void deleteData(int i, int i2);

    String getData();

    void insertData(int i, String str);

    void replaceData(int i, int i2, String str);

    void setData(String str);

    String substringData(int i, int i2);
}