package gradle.ioc;

import org.springframework.stereotype.Component;

@Component
public class Boy implements IBuy {
    @Override
    public String buy() {
        System.out.println("男孩买了一把游戏机");
        return "游戏机";
    }
}
