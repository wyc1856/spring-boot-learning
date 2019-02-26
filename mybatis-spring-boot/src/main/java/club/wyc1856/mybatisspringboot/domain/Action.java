package club.wyc1856.mybatisspringboot.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wyc1856
 * @date 2019/2/17 17:02
 * @description 行动信息
 **/
@Data
public class Action {

    /**
     * 行动id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 起点
     */
    private String origin;
    /**
     * 终点
     */
    private String terminal;
    /**
     * 进度
     */
    private String state;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;
}
