package club.wyc1856.autoconfigurer.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author wyc1856
 * @date 2021/2/20
 **/
@ConfigurationProperties(prefix = "wyc.hello")
public class WycConfigProperties {


    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
