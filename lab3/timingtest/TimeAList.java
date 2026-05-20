package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
            // 1. 初始化三个 AList 用于存储最终表格的数据列
            AList<Integer> Ns = new AList<>();
            AList<Double> times = new AList<>();
            AList<Integer> opCounts = new AList<>();

            // 2. 定义我们需要测试的数据规模 N (控制变量)
            int[] testSizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};

            // 3. 对每一个数据规模 N 进行独立的系统性测试
            for (int N : testSizes) {
                Ns.addLast(N);
                opCounts.addLast(N); // 对于构造 AList 的测试，操作次数就是调用 addLast 的次数 N

                // 核心原则：每次测试必须使用一个全新且干净的 AList，排除上一次实验的内存干扰
                AList<Integer> testList = new AList<>();

                // 开始计时：只包裹核心运算部分
                Stopwatch sw = new Stopwatch();

                for (int i = 0; i < N; i += 1) {
                    testList.addLast(1); // 插入什么数字不重要，重要的是执行这个动作
                }

                // 结束计时并记录
                double timeInSeconds = sw.elapsedTime();
                times.addLast(timeInSeconds);
            }

            // 4. 打印最终结果
            printTimingTable(Ns, times, opCounts);
        }

}
