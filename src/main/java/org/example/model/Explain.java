package org.example.model;

import lombok.Data;
import org.example.enums.SelectType;


@Data
public class Explain {
    /** 在一个大的查询语句中，每个SELECT关键字对一个唯一id */
    private Integer id;

    /** {@link SelectType SELECT关键字对应的查询类型} */
    private String selectType;

    /** 表名 */
    private String table;

    /** 匹配的分区信息 */
    private String partitions;

    /** 针对单表的访问方法 */
    private String type;

    /** 可能用到的索引 */
    private String possibleKeys;

    /** 实际使用的索引 */
    private String key;

    /** 实际使用的索引长度 */
    private Integer keyLen;

    /** 当使用索引列等值查询时，与索引列进行等值匹配的对象信息 */
    private String ref;

    /** 预估的需要读取的记录条数 */
    private Integer rows;

    /** 针对预估的需要读取的记录，经过搜索条件过滤后剩余记录的百分比 */
    private Double filtered;

    /** 一些额外的信息 */
    private String extra;
}
