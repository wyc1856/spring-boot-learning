package club.wyc1856.dependency.ioc.domain;

import java.io.Serializable;

/**
 * @author wyc1856
 * @date 2020/1/9
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 3192454566270880605L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
