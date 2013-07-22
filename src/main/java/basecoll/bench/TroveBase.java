package basecoll.bench;

import basecoll.IntList;
import basecoll.LongHash;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TLongLongMap;
import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class TroveBase {

    @State(Scope.Benchmark)
    public static class LoopState {
        private long l = -1;

        long getCount() {
            if (++l >= LongHash.INSERT_COUNT) { l = 0; }
            return l;
        }
    }

/*
    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public List<Integer> measureIntListJdkInsert() throws InterruptedException {
        return IntList.jdkInsertTest();
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public TIntArrayList measureIntListTroveInsert() throws InterruptedException {
        return IntList.troveInsertTest();
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public int measureIntListJdkTraverse() throws InterruptedException {
        return IntList.jdkEach();
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public int measureIntListTroveTraverse() throws InterruptedException {
        return IntList.troveEach();
    }

// ---

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public Map<Long, Long> measureLongHashMapJdkInsert() throws InterruptedException {
        return LongHash.jdkInsertTest();
    }

*/
    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public long measureLongHashMapJdkSearch() throws InterruptedException {
        return LongHash.jdkSearch();
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public long measureLongHashMapJdkSearchN(LoopState state) throws InterruptedException {
        return LongHash.jdkSearchNoLoop(state.getCount());
    }

/*

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public long measureLongHashMapJdkTraverse() throws InterruptedException {
        return LongHash.jdkEach();
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public TLongLongMap measureLongHashMapTroveInsert() throws InterruptedException {
        return LongHash.troveInsertTest();
    }
*/

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public long measureLongHashMapTroveSearch() throws InterruptedException {
        return LongHash.troveSearch();
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public long measureLongHashMapTroveSearchN(LoopState state) throws InterruptedException {
        return LongHash.troveSearchNoLoop(state.getCount());
    }
/*

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public long measureLongHashMapTroveTraverse() throws InterruptedException {
        return LongHash.troveEach();
    }
*/
}
