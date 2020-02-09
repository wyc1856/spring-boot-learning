package club.wyc1856.dependency.ioc.lookup.domain;

import club.wyc1856.dependency.ioc.annotation.Supper;

/**
 * @author wyc1856
 * @date 2020/1/9
 **/
@Supper
public class SupperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SupperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
