package basecoll;

import gnu.trove.map.TLongLongMap;
import gnu.trove.map.hash.TLongLongHashMap;
import gnu.trove.procedure.TLongProcedure;

import java.util.HashMap;
import java.util.Map;

public class LongHash {
    public static final int INSERT_COUNT = 1_000_000;

    private static Map<Long, Long> jdkMap = new HashMap<>();
    private static TLongLongMap troveMap = new TLongLongHashMap();

    static {
        for(long l = 0; l < INSERT_COUNT; ++l) {
            jdkMap.put(l, l);
            troveMap.put(l, l);
        }

    }

    public static Map<Long, Long> jdkInsertTest() {
        Map<Long, Long> jmap = new HashMap<>();

        for(long l = 0; l < INSERT_COUNT; ++l) {
            jmap.put(l, l);
        }
        return jmap;
    }

    public static TLongLongMap troveInsertTest() {
        TLongLongMap tmap = new TLongLongHashMap();

        for(long l = 0; l < INSERT_COUNT; ++l) {
            tmap.put(l, l);
        }
        return tmap;
    }

    public static long jdkSearch() {
        long rvalue = 0;
        for(long l = 0; l < INSERT_COUNT; ++l) {
            rvalue += jdkMap.get(l);
        }
        return rvalue;
    }

    public static long jdkSearchNoLoop(long l) {
        return jdkMap.get(l);
    }


    public static long troveSearch() {
        long rvalue = 0;
        for(long l = 0; l < INSERT_COUNT; ++l) {
            rvalue += troveMap.get(l);
        }
        return rvalue;
    }

    public static long troveSearchNoLoop(long l) {
        return troveMap.get(l);
    }

    public static long jdkEach() {
        long rvalue = 0;
        for(long l: jdkMap.values()) {
            rvalue += l;
        }
        return rvalue;
    }

    public static long troveEach() {
        final long [] rvalue = {0};
        troveMap.forEachValue(new TLongProcedure() {
            @Override
            public boolean execute(long value) {
                rvalue[0] += value;
                return true;
            }
        });
        return rvalue[0];
    }
}

