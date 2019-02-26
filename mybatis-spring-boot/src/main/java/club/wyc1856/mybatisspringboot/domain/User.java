package club.wyc1856.mybatisspringboot.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wyc1856
 * @date 2019/2/17 16:56
 * @description 用户信息
 **/
@Data
public class User {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
