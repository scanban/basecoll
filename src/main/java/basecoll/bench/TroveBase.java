package basecoll.bench;

import basecoll.IntList;
import basecoll.LongHash;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TLongLongMap;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class TroveBase {

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

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public long measureLongHashMapJdkSearch() throws InterruptedException {
        return LongHash.jdkSearch();
    }

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

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public long measureLongHashMapTroveSearch() throws InterruptedException {
        return LongHash.troveSearch();
    }

    @GenerateMicroBenchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public long measureLongHashMapTroveTraverse() throws InterruptedException {
        return LongHash.troveEach();
    }
}
