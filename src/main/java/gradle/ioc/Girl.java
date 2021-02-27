package gradle.ioc;

import org.springframework.stereotype.Component;

@Component
public class Girl implements IBuy {

    @Override
    public String buy() {
        System.out.println("女孩买了一件连衣裙");
        return "连衣裙";
    }
}
