package basecoll;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.array.TIntArrayList;

import java.util.ArrayList;
import java.util.List;

public class IntList {
    public static final int INSERT_COUNT = 1_000_000;

    private static List<Integer> jdkList = new ArrayList<>();
    private static TIntArrayList troveList = new TIntArrayList();

    static {
        for(int i = 0; i < INSERT_COUNT; ++i) {
            jdkList.add(i);
            troveList.add(i);
        }
    }

    public static List<Integer> jdkInsertTest() {
        List<Integer> jList = new ArrayList<>();
        for(int i = 0; i < INSERT_COUNT; ++i) {
            jList.add(i);
        }
        return jList;
    }

    public static TIntArrayList troveInsertTest() {
        TIntArrayList tList = new TIntArrayList();
        for(int i = 0; i < INSERT_COUNT; ++i) {
            tList.add(i);
        }
        return tList;
    }

    public static int jdkEach() {
        int j = 0;
        for(int i: jdkList) { j += i; }
        return j;
    }

    public static int troveEach() {
        int j = 0;
        for(TIntIterator it = troveList.iterator(); it.hasNext();) {
            j += it.next();
        }
        return j;
    }
}
