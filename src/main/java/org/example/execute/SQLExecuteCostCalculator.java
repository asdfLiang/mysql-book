package org.example.execute;

import java.math.BigDecimal;

/** SQL成本成本计算 */
public class SQLExecuteCostCalculator {

    /** 查询一页数据的io成本 */
    private static final BigDecimal IO_ONE_PAGE_COST = new BigDecimal("0.1");

    /** io成本微调参数 */
    private static final BigDecimal IO_COST_ADJUST = new BigDecimal("1.1");

    /** 查询一条记录的CPU成本 */
    private static final BigDecimal CPU_ACCESS_ONE_RECORD_COST = new BigDecimal("0.2");

    /** cpu成本微调参数 */
    private static final BigDecimal CPU_COST_ADJUST = new BigDecimal("1.0");

    /**
     * 查询成本计算
     *
     * @param clusterIndexPages 聚簇索引占用页数
     * @param tableRecordCount 标记记录数
     * @return 查询成本
     */
    public static BigDecimal selectCost(Integer clusterIndexPages, Integer tableRecordCount) {
        return ioCost(clusterIndexPages).add(cpuCost(tableRecordCount));
    }

    /**
     * IO成本计算
     *
     * @param clusterIndexPages 聚簇索引页数
     * @return io成本
     */
    public static BigDecimal ioCost(Integer clusterIndexPages) {
        return new BigDecimal(clusterIndexPages)
                .multiply(IO_ONE_PAGE_COST)
                .multiply(IO_COST_ADJUST);
    }

    /**
     * CPU成本计算
     *
     * @param tableRecordCount 统计表记录数
     * @return cpu成本
     */
    public static BigDecimal cpuCost(Integer tableRecordCount) {
        return new BigDecimal(tableRecordCount)
                .multiply(CPU_ACCESS_ONE_RECORD_COST)
                .multiply(CPU_COST_ADJUST);
    }
}
