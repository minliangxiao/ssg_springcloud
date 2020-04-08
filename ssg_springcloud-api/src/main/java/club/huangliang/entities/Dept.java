package club.huangliang.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Dept implements Serializable {
    private Long deptno;//主键
    private String dname;//部门名称
    private String db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被储存到不同数据库
}
