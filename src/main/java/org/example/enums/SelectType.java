package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SelectType {
    // 简单查询，不包含union或子查询的查询，连接查询也是
    SIMPLE,
    // 对于包含UNION、UNION ALL或子查询的大查询来说，最左边的小查询select type就是PRIMARY
    PRIMARY,
    // 对于包含UNION、UNION ALL的大查询来说，除了最左边的那个小查询来说，其余小查询的select type值就是UNION
    UNION,
    // MySQL选择使用临时表完成UNION查询的去重操作，针对临时表的查询的select type就是UNION_TYPE
    UNION_RESULT,
    //
    SUBQUERY,
    DEPENDENT_SUBQUERY,
    DEPENDENT_UNION,
    DERIVED,
    MATERIALIZED,
    UN_CACHEABLE_SUBQUERY,
    UN_CACHEABLE_UNION
}
